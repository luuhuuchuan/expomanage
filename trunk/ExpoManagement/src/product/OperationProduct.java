/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

import dataLayer.DBHelper;
import expomanagement.Main;
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
 * @author Cuongnvgc00064
 */
public class OperationProduct {
    DBHelper db = null;
    DefaultTableModel ProductsModel = null;
    Main m = null;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    public void loadAllProduct(java.awt.Frame parent,JTable jTable1){
        m = (Main) parent;
        jTable1.setModel(ProductsModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Product Code","Contact ID","Product Name","Product Price","Product Number","Description","Date"};
        for(String s : heading)
            v.add(s);
        ProductsModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getStore("getAllProducts("+m.getEID().trim()+")");
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(3).trim());
                v.add(rs.getString(4).trim());
                v.add(rs.getFloat(5));
                v.add(rs.getInt(6));
                v.add(rs.getString(7).trim());
                v.add(formatter.format(rs.getDate(8)));
                ProductsModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public OperationProduct(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getStore(String sName)throws SQLException{
        String storeName = "{call "+sName+" }";
        return db.getCallAble(storeName).executeQuery();
    }
    public void doSearch(java.awt.Frame parent,String Where, String Key, JTable tblProduct){
        m = (Main) parent;
        try
        {
        String storeName = "findProduct("+m.getEID().trim()+",'" + Where + "','" + Key + "')";
        tblProduct.setModel(ProductsModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Product Code","Contact ID","Product Name","Product Price","Product Number","Description","Date"};
        for(String s : heading)
            v.add(s);
        ProductsModel.setColumnIdentifiers(v);
        ResultSet rs = getStore(storeName);
        while(rs.next()){
            v = new Vector();
            v.add(rs.getInt(1));
            v.add(rs.getString(3).trim());
            v.add(rs.getString(4).trim());
            v.add(rs.getFloat(5));
            v.add(rs.getInt(6));
            v.add(rs.getString(7).trim());
            v.add(formatter.format(rs.getDate(8)));
            ProductsModel.addRow(v);
        }
        rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void delProducts(int id){
        try{
        CallableStatement cs = db.getConnection().prepareCall("{call DeleteProducts(?)}");
        //truyen tham so cho store
        cs.setInt(1, id);
        if(JOptionPane.showConfirmDialog(null, "Do you want to delete this Product ?",
                "Delete Product",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            cs.execute();
            JOptionPane.showMessageDialog(null, "One Product has been deleted !","Delete Product",JOptionPane.INFORMATION_MESSAGE);
        }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this Product !","Delete Product",JOptionPane.ERROR_MESSAGE);
        }
    }

    DefaultComboBoxModel CbContactModel = null;
    public boolean checkProducts(JComboBox cbContact,JTextField txtName,JTextField txtPrice,JTextField txtNumber){
        if(cbContact.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Please, select CID !","Check Product",JOptionPane.WARNING_MESSAGE);
            cbContact.requestFocus();
            return false;
        }
        if(txtName.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please, Enter Name of Product !","Check Product",JOptionPane.WARNING_MESSAGE);
            txtName.requestFocus();
            return false;
        }
        if(txtPrice.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please, Enter Price of Product !","Check Product",JOptionPane.WARNING_MESSAGE);
            txtPrice.requestFocus();
            return false;
        }
        try {
            Float.parseFloat(txtPrice.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Price of Product must Number !","Check Product",JOptionPane.WARNING_MESSAGE);
            txtPrice.requestFocus();
            return false;
        }
        if(txtNumber.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please, enter Number Product !","Check Product",JOptionPane.WARNING_MESSAGE);
            txtNumber.requestFocus();
            return false;
        }
        try {
            Long.parseLong(txtNumber.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Number Product must Number !","Check Product",JOptionPane.WARNING_MESSAGE);
            txtNumber.requestFocus();
            return false;
        }
        return true;
    }
    
    DefaultComboBoxModel CbWherePModel = null;
    HashMap hmp = new HashMap();
    public void buildCbWhereP(JComboBox cbWhereP)
    {
        cbWhereP.setModel(CbWherePModel = new DefaultComboBoxModel());
        CbWherePModel.addElement("Product ID");
        hmp.put("Product ID","PID");
        CbWherePModel.addElement("Product Name");
        hmp.put("Product Name","PName");
        CbWherePModel.addElement("Product Price");
        hmp.put("Product Price","PPrice");
    }
    public String returnSearch(JComboBox cbWhereP)
    {
        return hmp.get(cbWhereP.getSelectedItem().toString().trim()).toString();
    }
}
