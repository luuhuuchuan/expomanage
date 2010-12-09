/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package booth;

import dataLayer.DBHelper;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author namh3o
 */
public class OperationBooths {

    DBHelper db = null;
    DefaultTableModel BoothsModel = null;
    DefaultComboBoxModel CbContactModel = null;
    DefaultComboBoxModel CbStaffModel = null;
    HashMap hm = new HashMap();
    DefaultComboBoxModel CbBoothTypeModel = null;
    HashMap hm2 = new HashMap();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    public boolean checkformBooth(JComboBox cbBoothType, JTextField txtBname, JTextField txtBmoney){
        if(cbBoothType.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Please,select BoothType","Check Information",JOptionPane.ERROR_MESSAGE);
            cbBoothType.requestFocus();
            return false;
        }
        if(txtBname.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Name of Booth","Check Information",JOptionPane.ERROR_MESSAGE);
            txtBname.requestFocus();
            return false;
        }
        if(txtBmoney.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Booth Money","Check Information",JOptionPane.ERROR_MESSAGE);
            txtBmoney.requestFocus();
            return false;
        }
        try {
            Float.parseFloat(txtBmoney.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Booth Money must Number","Check Information",JOptionPane.ERROR_MESSAGE);
            txtBmoney.requestFocus();
            return false;
        }

        return true;
    }
    public void loadAllBooths(JTable jTable1){
        jTable1.setModel(BoothsModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Booth ID","Booth Type","Booth Name","Date","Cost","Booker"};
        for(String s : heading)
            v.add(s);
        BoothsModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getStore("getAllBooths");
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2).trim());
                v.add(rs.getString(3).trim());
                v.add(formatter.format(rs.getDate(4)));
                v.add(rs.getFloat(5));
                if(rs.getBoolean(6))
                    v.add("Yes");
                else
                    v.add("No");
                BoothsModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            
        }
    }
    public OperationBooths(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getStore(String sName)throws SQLException{
        String storeName = "{call "+sName+" }";
        return db.getCallAble(storeName).executeQuery();
    }


    public void buildAllContactID(JComboBox cbContact)
    {
        cbContact.setModel(CbContactModel = new DefaultComboBoxModel());
        CbContactModel.addElement("-- Choose Contact --");
        try{
            ResultSet rs = getStore("get_CID");
            while(rs.next()){
                String Cid = rs.getString(1).trim();
                CbContactModel.addElement(Cid);
            }
            rs.close();
        }
        catch(Exception ex){
            
        }
    }
    public void buildAlBoothType(JComboBox cbBoothType)
    {
        cbBoothType.setModel(CbBoothTypeModel = new DefaultComboBoxModel());
        CbBoothTypeModel.addElement("-- Choose BoothType --");
        try{
            ResultSet rs = getStore("get_BoothType");
            while(rs.next()){
                String btname = rs.getString(1);
                String btid = String.valueOf(rs.getInt(2));
                hm2.put(btname,btid);
                CbBoothTypeModel.addElement(btname);
            }
            rs.close();
        }
        catch(Exception ex){
            
        }
    }
    public void delBooth(int id){
        try{
            CallableStatement cs = db.getConnection().prepareCall("{call deleteBooths(?)}");
            //truyen tham so cho store
            cs.setInt(1, id);
            if(JOptionPane.showConfirmDialog(null, "Do you want to delete the record(s)",
                "Update Dialog",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "One Booth has been deleted !","Delete Booth",JOptionPane.INFORMATION_MESSAGE);
                }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this Booth !","Delete deleteBooth",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void doSearch(String Where, String Key, JTable tblBooths){
        try
        {

            String storeName = "findBooths('" + Where + "','" + Key + "')";
            tblBooths.setModel(BoothsModel = new DefaultTableModel());
            Vector v = new Vector();
            String [] heading = {"Booth ID","Booth Type","Booth Name","Date","Cost","Booker"};
            for(String s : heading)
                v.add(s);
            BoothsModel.setColumnIdentifiers(v);
            ResultSet rs = getStore(storeName);
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2).trim());
                v.add(rs.getString(3).trim());
                v.add(formatter.format(rs.getDate(4)));
                v.add(rs.getFloat(5));
                if(rs.getBoolean(6))
                    v.add("Yes");
                else
                    v.add("No");
                BoothsModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            
        }
    }
    DefaultComboBoxModel CbWhereBModel = null;
    HashMap hmbt = new HashMap();
    public void buildCbWhereB(JComboBox cbWhereB)
    {
        cbWhereB.setModel(CbWhereBModel = new DefaultComboBoxModel());
        CbWhereBModel.addElement("Booth ID");
        hmbt.put("Booth ID","B.BID");
        CbWhereBModel.addElement("Booth Name");
        hmbt.put("Booth Name","B.BName");
        CbWhereBModel.addElement("Booth Type");
        hmbt.put("Booth Type","BT.BTName");
    }
    public String returnSearch(JComboBox cbWhereBT)
    {
        return hmbt.get(cbWhereBT.getSelectedItem().toString().trim()).toString();
    }
    public int returnBTID(JComboBox cbBoothType)
    {
        return Integer.parseInt(hm2.get(cbBoothType.getSelectedItem().toString().trim()).toString());
    }



}
