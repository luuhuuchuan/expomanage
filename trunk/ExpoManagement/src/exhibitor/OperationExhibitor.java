/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exhibitor;

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
 * @author Cuongnvgc00064
 */
public class OperationExhibitor {
    
    DBHelper db = null;
    DefaultTableModel ExhibitorModel = null;
    public void loadAllExhibitor(JTable jTable1){
        jTable1.setModel(ExhibitorModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Exhibitor Code","Exhibitor Name","Exhibitor Fax","Phone Number","Address","Website"};
        for(String s : heading)
            v.add(s);
        ExhibitorModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getAllExhibitor();
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                ExhibitorModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public OperationExhibitor(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getAllExhibitor()throws SQLException{
        String storeName = "{call getAllExhibitor }";
        return db.getCallAble(storeName).executeQuery();
    }
    public boolean checkExhibitor(JTextField txtName,JTextField txtFax,JTextField txtPhone,JTextField txtAddress,JTextField txtWebsite){
        if(txtName.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Name of Exhibitor !","Check Exhibitor",JOptionPane.WARNING_MESSAGE);
            txtName.requestFocus();
            return false;
        }
        if(txtFax.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please,Enter Fax of Exhibitor","Check Exhibitor",JOptionPane.WARNING_MESSAGE);
            txtFax.requestFocus();
            return false;
        }
        try {
            Long.parseLong(txtFax.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fax must be number","Check Exhibitor",JOptionPane.WARNING_MESSAGE);
            txtFax.requestFocus();
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
            JOptionPane.showMessageDialog(null, "Phone must be number","Check Exhibitor",JOptionPane.WARNING_MESSAGE);
            txtPhone.requestFocus();
            return false;
        }
        if(txtAddress.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please,Enter Address of Exhibitor","Check Exhibitor",JOptionPane.WARNING_MESSAGE);
            txtAddress.requestFocus();
            return false;
        }
        if(txtWebsite.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please,Enter Website of Exhibitor","Check Exhibitor",JOptionPane.WARNING_MESSAGE);
            txtWebsite.requestFocus();
            return false;
        }
        return true;
    }

    public void doSearch(String Where, String Key, JTable tblProduct){
        try
        {
        String storeName = "{call findExhibitor('" + Where + "','" + Key + "')}";
        tblProduct.setModel(ExhibitorModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Exhibitor Code","Exhibitor Name","Exhibitor Fax","Phone Number","Address","Website"};
        for(String s : heading)
            v.add(s);
        ExhibitorModel.setColumnIdentifiers(v);
        ResultSet rs = db.getCallAble(storeName).executeQuery();
        while(rs.next()){
            v = new Vector();
            v.add(rs.getInt(1));
            v.add(rs.getString(2));
            v.add(rs.getString(3));
            v.add(rs.getString(4));
            v.add(rs.getString(5));
            v.add(rs.getString(6));
            ExhibitorModel.addRow(v);
        }
        rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    DefaultComboBoxModel CbExModel = null;
    HashMap hmp = new HashMap();
    public void buildCbEx(JComboBox cbEx)
    {
        cbEx.setModel(CbExModel = new DefaultComboBoxModel());
        CbExModel.addElement("Exhibitor ID");
        hmp.put("Exhibitor ID","EID");
        CbExModel.addElement("Exhibitor Name");
        hmp.put("Exhibitor Name","EName");
        CbExModel.addElement("Exhibitor Address");
        hmp.put("Exhibitor Address","EAddress");
        CbExModel.addElement("Fax");
        hmp.put("Fax","EFax");
    }
    public String returnSearch(JComboBox cbEx)
    {
        return hmp.get(cbEx.getSelectedItem().toString().trim()).toString();
    }
    public void delExhibitor(int id){
        try{
        CallableStatement cs = db.getConnection().prepareCall("{call DeleteExhibitor(?)}");
        //truyen tham so cho store
        cs.setInt(1, id);
        if(JOptionPane.showConfirmDialog(null, "Do you want to delete this Exhibitor ?",
                "Delete Exhibitor",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "One Exhibitor has been deleted !","Delete Exhibitor",JOptionPane.INFORMATION_MESSAGE);
                }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this Exhibitor !","Delete Exhibitor",JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet getIDExhibitor()throws SQLException{
        String storeName = "{call GetExhibitorID }";
        return db.getCallAble(storeName).executeQuery();
    }
}
