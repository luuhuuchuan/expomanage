/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expo;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hse7en
 */
public class OperationExpo {
    DBHelper db = null;

    DefaultTableModel ExpoModel = null;
    public void loadAllExpo(JTable jTable1){
        jTable1.setModel(ExpoModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Expo Code","Expo Name","Number Booth","Cost","ExDescription","Date Start","Date End"};
        for(String s : heading)
            v.add(s);
        ExpoModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getAllExpo();
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getInt(3));
                //v.add(rs.getString(5));
                v.add(rs.getFloat(4));
                v.add(rs.getDate(6));
                v.add(rs.getDate(7));
                ExpoModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public OperationExpo(){
        db = new DBHelper();
        db.openConnection();
    }
        public boolean checkformExpo(JTextField txtName, JTextField txtNumBooth, JTextField txtCost, JTextField txtDateStart, JTextField txtDateEnd){
        if(txtName.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Name of Expo");
            txtName.requestFocus();
            return false;
        }
        if(txtNumBooth.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Number booth");
            txtNumBooth.requestFocus();
            return false;
        }
        try {
            Float.parseFloat(txtNumBooth.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Number Booth must Number");
            txtNumBooth.requestFocus();
            return false;
        }
        if(txtCost.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Cost ");
            txtCost.requestFocus();
            return false;
        }
        try {
            Float.parseFloat(txtCost.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cost must Number");
            txtCost.requestFocus();
            return false;
        }
         if(txtDateStart.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Date Start can't null");
            txtDateStart.requestFocus();
            return false;
         }
            if(txtDateEnd.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Date End  can't null");
            txtDateEnd.requestFocus();
            return false;
        }
        return true;
    }
    public ResultSet getAllExpo()throws SQLException{
        String storeName = "{call getAllExpo }";
        return db.getCallAble(storeName).executeQuery();
    }
    public void delExpo(int id){
        try{
        CallableStatement cs = db.getConnection().prepareCall("{call deleteExpo(?)}");
        //truyen tham so cho store
        cs.setInt(1, id);
        if(JOptionPane.showConfirmDialog(null, "Do you want to delete the record(s)",
                "Update Dialog",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "One Expo has been deleted !","Delete Expo",JOptionPane.INFORMATION_MESSAGE);
                }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this Expo !","Delete Expo",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void doSearch(String Where, String Key, JTable tblExpo){
        try
        {
            String storeName = "{call findExpo('" + Where + "','" + Key + "')}";
            tblExpo.setModel(ExpoModel = new DefaultTableModel());
            Vector v = new Vector();
            String [] heading = {"Expo Code","Expo Name","Number Booth","Cost","Date Start","Date End"};
            for(String s : heading)
                v.add(s);
            ExpoModel.setColumnIdentifiers(v);
            ResultSet rs = db.getCallAble(storeName).executeQuery();
                while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getInt(3));
                v.add(rs.getFloat(4));
                v.add(rs.getDate(6));
                v.add(rs.getDate(7));
                ExpoModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    DefaultComboBoxModel CbWhereExpoModel = null;
    HashMap hmbt = new HashMap();
    public void buildCbWhereEx(JComboBox cbWhereEx)
    {
        cbWhereEx.setModel(CbWhereExpoModel = new DefaultComboBoxModel());
        CbWhereExpoModel.addElement("Expo ID");
        hmbt.put("Expo ID","ExID");
        CbWhereExpoModel.addElement("Expo Name");
        hmbt.put("Expo Name","ExName");
    }
    public String returnSearch(JComboBox cbWhereEx)
    {
        return hmbt.get(cbWhereEx.getSelectedItem().toString().trim()).toString();
    }

}
