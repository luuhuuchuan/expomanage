/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

import dataLayer.DBHelper;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SiaroKool
 */
public class OperationUser {
    DBHelper db = null;

    DefaultTableModel UserModel = null;
    public void loadAllUser(JTable jTable1){
        jTable1.setModel(UserModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"User Name","User Pass","Type User","User Email"};
        for(String s : heading)
            v.add(s);
        UserModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getStore("getAllUser");
            while(rs.next()){
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                if (rs.getInt(3) == 1)
                    v.add("Manager");
                else
                    v.add("Exhibitor");
                v.add(rs.getString(4));
                UserModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
        public OperationUser(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getStore(String sName)throws SQLException{
        String storeName = "{call "+sName+" }";
        return db.getCallAble(storeName).executeQuery();
    }
    public boolean checkUser(JTextField txtName,JPasswordField txtPass,JTextField txtEmail){
        
        boolean status = false;
        try{
        String storeName = "checkUser('"+txtName.getText().trim()+"')";
        ResultSet rs = getStore(storeName);
        while(rs.next()){
            status = rs.getBoolean(1);
        }
        rs.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        if(status){
            JOptionPane.showMessageDialog(null, "User Name has been existed !","Check User",JOptionPane.WARNING_MESSAGE);
            txtName.requestFocus();
            return false;
        }
        if(txtName.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Name of User !","Check User",JOptionPane.WARNING_MESSAGE);
            txtName.requestFocus();
            return false;
        }
        if((new String(txtPass.getPassword())).equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please,Enter pass of User","Check User",JOptionPane.WARNING_MESSAGE);
            txtPass.requestFocus();
            return false;
        }
        if(txtEmail.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please,Enter Email of User","Check User",JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            return false;
        }
        return true;
    }

    public void doSearch(String Where, String Key, JTable tblUser){
        try
        {
        String storeName = "findUser('" + Where + "','" + Key + "')";
        tblUser.setModel(UserModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"User Name","User Pass","Type User","User Email"};
        for(String s : heading)
            v.add(s);
        UserModel.setColumnIdentifiers(v);
        ResultSet rs = getStore(storeName);
        while(rs.next()){
            v = new Vector();
            v.add(rs.getString(1));
            v.add(rs.getString(2));
            if (rs.getInt(3) == 1)
                    v.add("Manager");
                else
                    v.add("Exhibitor");
            v.add(rs.getString(4));
            UserModel.addRow(v);
        }
        rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

  
    DefaultComboBoxModel CbUsModel = null;
    HashMap hmp = new HashMap();
    public void buildCbUs(JComboBox cbUs)
    {
        cbUs.setModel(CbUsModel = new DefaultComboBoxModel());
        CbUsModel.addElement("User Name");
        hmp.put("User Name","UName");
        CbUsModel.addElement("User Email");
        hmp.put("User Email","UEmail");
    }
    public String returnSearch(JComboBox cbUs)
    {
        return hmp.get(cbUs.getSelectedItem().toString().trim()).toString();
    }
    public void delUser(String name){
        try{
        CallableStatement cs = db.getConnection().prepareCall("{call DeleteUser(?)}");
        //truyen tham so cho store
        cs.setString(1, name);
        cs.execute();
        JOptionPane.showMessageDialog(null, "One User has been deleted !","Delete User",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this User !","Delete User",JOptionPane.ERROR_MESSAGE);
        }
    }
}

