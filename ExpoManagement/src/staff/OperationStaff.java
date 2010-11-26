/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package staff;

import dataLayer.DBHelper;
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

    DefaultTableModel StaffModel = null;
    public void loadAllStaff(JTable jTable1){
        jTable1.setModel(StaffModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Staff ID","Contact ID","Staff Name","Staff Email","Staff Phone","Staff Address"};
        for(String s : heading)
            v.add(s);
        StaffModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getAllStaff();
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
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
    public ResultSet getAllStaff()throws SQLException{
        String storeName = "{call getAllStaff }";
        return db.getCallAble(storeName).executeQuery();
    }
    public boolean checkStaff(JTextField txtName,JTextField txtEmail,JTextField txtPhone,JTextField txtAddress){
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
        if(txtAddress.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please,Enter Address of Staff","Check Staff",JOptionPane.WARNING_MESSAGE);
            txtAddress.requestFocus();
            return false;
        }
        return true;
    }

    public void doSearch(String Where, String Key, JTable tblStaff){
        try
        {
        String storeName = "{call findStaff('" + Where + "','" + Key + "')}";
        tblStaff.setModel(StaffModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Staff ID","Contact ID","Staff Name","Staff Email","Staff Phone","Staff Address"};
        for(String s : heading)
            v.add(s);
        StaffModel.setColumnIdentifiers(v);
        ResultSet rs = db.getCallAble(storeName).executeQuery();
        while(rs.next()){
            v = new Vector();
            v.add(rs.getInt(1));
            v.add(rs.getString(2));
            v.add(rs.getString(3));
            v.add(rs.getString(4));
            v.add(rs.getString(5));
            v.add(rs.getString(6));
            StaffModel.addRow(v);
        }
        rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
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
