/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boothType;


import dataLayer.DBHelper;
import java.sql.CallableStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.SQLException;
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
public class OperationBoothType {

    DBHelper db = null;
    DefaultTableModel BoothTypeModel = null;
    public boolean checkformBoothType(JComboBox cbExpo,JTextField txtBTName, JTextField txtBTHeight, JTextField txtBTWidth, JTextField txtBlength){
        if(cbExpo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Please,select Expo","Check Information",JOptionPane.ERROR_MESSAGE);
            cbExpo.requestFocus();
            return false;
        }
        if(txtBTName.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Name of BoothType","Check Information",JOptionPane.ERROR_MESSAGE);
            txtBTName.requestFocus();
            return false;
        }
        if(txtBTHeight.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter BoothType Height","Check Information",JOptionPane.ERROR_MESSAGE);
            txtBTHeight.requestFocus();
            return false;
        }
        try {
            Float.parseFloat(txtBTHeight.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BoothType Height must Number","Check Information",JOptionPane.ERROR_MESSAGE);
            txtBTHeight.requestFocus();
            return false;
        }
        if(txtBTWidth.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter BoothType Width","Check Information",JOptionPane.ERROR_MESSAGE);
            txtBTWidth.requestFocus();
            return false;
        }
        try {
            Float.parseFloat(txtBTWidth.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BoothType Width must Number","Check Information",JOptionPane.ERROR_MESSAGE);
            txtBTWidth.requestFocus();
            return false;
        }
        if(txtBlength.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Booth Length","Check Information",JOptionPane.ERROR_MESSAGE);
            txtBlength.requestFocus();
            return false;
        }
        try {
            Float.parseFloat(txtBlength.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Booth Length must Number","Check Information",JOptionPane.ERROR_MESSAGE);
            txtBlength.requestFocus();
            return false;
        }
        return true;
    }
    public void loadAllBoothType(JTable jTable1){
        jTable1.setModel(BoothTypeModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"BTID","BoothType Name","Expo Name" ,"Booth Height","Booth Width","Booth Remain","Booth Length"};
        for(String s : heading)
            v.add(s);
        BoothTypeModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getStore("getAllBoothType");
            while(rs.next()){
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getFloat(4));
                v.add(rs.getFloat(5));
                v.add(rs.getInt(6));
                v.add(rs.getInt(7));
                
                BoothTypeModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public OperationBoothType(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getStore(String sName)throws SQLException{
        String storeName = "{call "+sName+" }";
        return db.getCallAble(storeName).executeQuery();
    }

    DefaultComboBoxModel CbExpoModel = null;
    HashMap hm = new HashMap();
    private DefaultTableModel model = null;
    public void findBoothByName(String pattern,JComboBox boxBT, JTable tblBoothType){
        try{
            //tao van tin sql
            loadAllBoothType(tblBoothType);
            if(boxBT.getSelectedItem() == "BoothType Name"){
                String sqlCmd = "Select * from BoothType where BTName like '%"+pattern+"%'";
                ResultSet rs = getStore(sqlCmd);
                loadAllBoothType(tblBoothType);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
    public void buildCbExpo(JComboBox cbExpo)
    {
        cbExpo.setModel(CbExpoModel = new DefaultComboBoxModel());
        CbExpoModel.addElement("-- Choose Expo --");
        try{
            ResultSet rs = getStore("getID_Name_Of_Expo");
            while(rs.next()){
                String name = rs.getString(1);
                String id = String.valueOf(rs.getInt(2));
                hm.put(name,id);
                CbExpoModel.addElement(name);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public int returnIdExpo(JComboBox cbExpo)
    {
        return Integer.parseInt(hm.get(cbExpo.getSelectedItem().toString().trim()).toString());
    }
    public void delBoothType(int id){
        try{
            CallableStatement cs = db.getConnection().prepareCall("{call deleteBoothType(?)}");
            //truyen tham so cho store
            cs.setInt(1, id);
            if(JOptionPane.showConfirmDialog(null, "Do you want to delete the record(s)",
                "Update Dialog",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "One BoothType has been deleted !","Delete BoothType",JOptionPane.INFORMATION_MESSAGE);
                }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this BoothType !","Delete deleteBoothType",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void doSearch(String Where, String Key, JTable tblBoothType){
        try
        {
            String storeName = "findBoothType('" + Where + "','" + Key + "')";
            tblBoothType.setModel(BoothTypeModel = new DefaultTableModel());
            Vector v = new Vector();
            String [] heading = {"BTID","BoothType Name","Expo Name" ,"Booth Height","Booth Width","Booth Remain","Booth Length"};
            for(String s : heading)
                v.add(s);
            BoothTypeModel.setColumnIdentifiers(v);
            ResultSet rs = getStore(storeName);
           while(rs.next()){
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getFloat(4));
                v.add(rs.getFloat(5));
                v.add(rs.getInt(6));
                v.add(rs.getInt(7));
                BoothTypeModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    DefaultComboBoxModel CbWhereBTModel = null;
    HashMap hmbt = new HashMap();
    public void buildCbWhereP(JComboBox cbWhereBT)
    {
        cbWhereBT.setModel(CbWhereBTModel = new DefaultComboBoxModel());
        CbWhereBTModel.addElement("BoothType ID");
        hmbt.put("BoothType ID","BT.BTID");
        CbWhereBTModel.addElement("BoothType Name");
        hmbt.put("BoothType Name","BT.BTName");
        CbWhereBTModel.addElement("Expo Name");
        hmbt.put("Expo Name","E.ExName");
        CbWhereBTModel.addElement("Booth Height");
        hmbt.put("Booth Height","BT.BTHeight");
        CbWhereBTModel.addElement("Booth Width");
        hmbt.put("Booth Width","BT.BTWidth");
    }
    public String returnSearch(JComboBox cbWhereBT)
    {
        return hmbt.get(cbWhereBT.getSelectedItem().toString().trim()).toString();
    }
}
