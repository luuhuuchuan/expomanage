/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package staff;

import dataLayer.DBHelper;
import expomanagement.Application;
import java.sql.CallableStatement;
import java.sql.ResultSet;
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
 * @author SiaroKool
 */
public class OperationStaff {

    DBHelper db = null;
    Application m = null;
    DefaultTableModel StaffModel = null;
    public void loadAllStaff(java.awt.Frame parent,JTable jTable1){
        m = (Application) parent;
        jTable1.setModel(StaffModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Staff ID","Contact ID","Staff Name","Staff Email","Staff Phone","Staff Address","Booth"};
        for(String s : heading)
            v.add(s);
        StaffModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getStore("getAllStaff("+m.getEID().trim()+")");
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2).trim());
                v.add(rs.getString(3).trim());
                v.add(rs.getString(4).trim());
                v.add(rs.getString(5).trim());
                v.add(rs.getString(6).trim());
                v.add(rs.getString(7).trim());
                StaffModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
        public OperationStaff(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getStore(String sName)throws SQLException{
        String storeName = "{call "+sName+" }";
        return db.getCallAble(storeName).executeQuery();
    }
    public boolean checkStaff(JTextField txtName,JTextField txtEmail,JTextField txtPhone){
        if(txtName.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Name of Staff !","Check Staff",JOptionPane.WARNING_MESSAGE);
            txtName.requestFocus();
            return false;
        }
        if(txtEmail.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please,Enter Email of Staff","Check Staff",JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            return false;
        }
        if(txtPhone.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please,Enter phone of Exhibitor","Check Exhibitor",JOptionPane.WARNING_MESSAGE);
            txtPhone.requestFocus();
            return false;
        }
        try {
            int age = Integer.parseInt(txtPhone.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Phone must be number","Check Staff",JOptionPane.WARNING_MESSAGE);
            txtPhone.requestFocus();
            return false;
        }
        return true;
    }

    public void doSearch(java.awt.Frame parent,String Where, String Key, JTable tblStaff){
        try
        {
        m = (Application) parent;
        String storeName = "findStaff("+m.getEID().trim()+",'" + Where + "','" + Key + "')";
        tblStaff.setModel(StaffModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Staff ID","Contact ID","Staff Name","Staff Email","Staff Phone","Staff Address","Booth"};
        for(String s : heading)
            v.add(s);
        StaffModel.setColumnIdentifiers(v);
        ResultSet rs = getStore(storeName);
        while(rs.next()){
            v = new Vector();
            v.add(rs.getInt(1));
            v.add(rs.getString(2).trim());
            v.add(rs.getString(3).trim());
            v.add(rs.getString(4).trim());
            v.add(rs.getString(5).trim());
            v.add(rs.getString(6).trim());
            v.add(rs.getString(7).trim());
            StaffModel.addRow(v);
        }
        rs.close();
        }
        catch(SQLException e)
        {
            
        }
    }

    DefaultComboBoxModel CbStaffModel = null;
    HashMap hmp = new HashMap();
    public void buildCbStaff(JComboBox cbStaff)
    {
        cbStaff.setModel(CbStaffModel = new DefaultComboBoxModel());
        CbStaffModel.addElement("Staff ID");
        hmp.put("Staff ID","SID");
        CbStaffModel.addElement("Staff Name");
        hmp.put("Staff Name","SName");
        CbStaffModel.addElement("Staff Email");
        hmp.put("Staff Email","SEmail");
        CbStaffModel.addElement("Staff Phone");
        hmp.put("Staff Phone","SPhone");
        CbStaffModel.addElement("Staff Address");
        hmp.put("Staff Address","SAddress");
        
    }
    public String returnSearch(JComboBox cbSt)
    {
        return hmp.get(cbSt.getSelectedItem().toString().trim()).toString();
    }
        DefaultComboBoxModel CbBoothModel = null;
        HashMap hm = new HashMap();
        private DefaultTableModel model = null;
        public void buildCbBooth(JComboBox cbBooth)
    {
        cbBooth.setModel(CbBoothModel = new DefaultComboBoxModel());
        CbBoothModel.addElement("-- Choose Booth --");
        try{
            ResultSet rs = getStore("get_Booth");
            while(rs.next()){
                String name = rs.getString(1);
                String id = String.valueOf(rs.getInt(2));
                hm.put(name,id);
                CbBoothModel.addElement(name);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public int returnIdBooth(JComboBox cbBooth)
    {
        return Integer.parseInt(hm.get(cbBooth.getSelectedItem().toString().trim()).toString());
    }
    public void delStaff(int id){
        try{
        CallableStatement cs = db.getConnection().prepareCall("{call DeleteStaff(?)}");
        //truyen tham so cho store
        cs.setInt(1, id);
        if(JOptionPane.showConfirmDialog(null, "Do you want to delete the record(s)",
                "Update Dialog",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            cs.execute();
            JOptionPane.showMessageDialog(null, "One Staff has been deleted !","Delete Staff",JOptionPane.INFORMATION_MESSAGE);
        }
        
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this Staff !","Delete Staff",JOptionPane.ERROR_MESSAGE);
        }
    }
}
