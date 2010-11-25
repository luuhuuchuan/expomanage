/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boothType;


import dataLayer.DBHelper;
import expomanagement.Main;
import java.awt.Frame;
import java.sql.CallableStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ComboBoxModel;
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
            JOptionPane.showMessageDialog(null,"Please,select Expo");
            cbExpo.requestFocus();
            return false;
        }
        if(txtBTName.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Name of BoothType");
            txtBTName.requestFocus();
            return false;
        }
        if(txtBTHeight.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter BoothType Height");
            txtBTHeight.requestFocus();
            return false;
        }
        try {
            Long.parseLong(txtBTHeight.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BoothType Height must Number");
            txtBTHeight.requestFocus();
            return false;
        }
        if(txtBTWidth.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter BoothType Width");
            txtBTWidth.requestFocus();
            return false;
        }
        try {
            Long.parseLong(txtBTWidth.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BoothType Width must Number");
            txtBTWidth.requestFocus();
            return false;
        }
//        if(txtBremain.getText().equals("")){
//            JOptionPane.showMessageDialog(null,"Please,Enter Booth Remain");
//            txtBremain.requestFocus();
//            return false;
//        }
//        try {
//            Long.parseLong(txtBremain.getText());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Booth Remain must Number");
//            txtBremain.requestFocus();
//            return false;
//        }
        if(txtBlength.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Booth Length");
            txtBlength.requestFocus();
            return false;
        }
        try {
            Long.parseLong(txtBlength.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Booth Length must Number");
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
            ResultSet rs = getAllBoothType();
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
    public ResultSet getAllBoothType()throws SQLException{
        String storeName = "{call getAllBoothType }";
        return db.getCallAble(storeName).executeQuery();
    }

    public ResultSet getAllExpo()throws SQLException{
        String storeName = "{call getID_Name_Of_Expo }";
        return db.getCallAble(storeName).executeQuery();
    }
    public ResultSet getDeleteBoothType()throws SQLException{
        String storeName = "{call deleteBoothType }";
        return db.getCallAble(storeName).executeQuery();
    }
    public ResultSet getBoothTypeID()throws SQLException{
        String storeName = "{call getBoothTypeByID }";
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
                ResultSet rs = db.getStatement().executeQuery(sqlCmd);
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
            ResultSet rs = getAllExpo();
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
        cs.execute();

        JOptionPane.showMessageDialog(null, "One BoothType has been deleted !","Delete BoothType",JOptionPane.INFORMATION_MESSAGE);

        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this BoothType !","Delete deleteBoothType",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void doSearch(String Where, String Key, JTable tblBoothType){
        try
        {
            String storeName = "{call findBoothType('" + Where + "','" + Key + "')}";
            tblBoothType.setModel(BoothTypeModel = new DefaultTableModel());
            Vector v = new Vector();
            String [] heading = {"BTID","BoothType Name","Expo Name" ,"Booth Height","Booth Width","Booth Remain","Booth Length"};
            for(String s : heading)
                v.add(s);
            BoothTypeModel.setColumnIdentifiers(v);
            ResultSet rs = db.getCallAble(storeName).executeQuery();
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
        hmbt.put("BoothType ID","BTID");
        CbWhereBTModel.addElement("BoothType Name");
        hmbt.put("BoothType Name","BTName");
    }
    public String returnSearch(JComboBox cbWhereBT)
    {
        return hmbt.get(cbWhereBT.getSelectedItem().toString().trim()).toString();
    }
}
