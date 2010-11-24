/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

import dataLayer.DBHelper;
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
 * @author Cuongnvgc00064
 */
public class OperationProduct {
    DBHelper db = null;

    DefaultTableModel ProductsModel = null;
    public void loadAllProduct(JTable jTable1){
        jTable1.setModel(ProductsModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Product Code","Product Name","Product Price","Product Number","Date"};
        for(String s : heading)
            v.add(s);
        ProductsModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getAllProducts();
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(4));
                v.add(rs.getFloat(5));
                v.add(rs.getInt(6));
                v.add(rs.getDate(8));
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
    public ResultSet getAllProducts()throws SQLException{
        String storeName = "{call getAllProducts }";
        return db.getCallAble(storeName).executeQuery();
    }
    public ResultSet doSearch()throws SQLException{
        String storeName = "{call findbyName }";
        return db.getCallAble(storeName).executeQuery();
    }
    public void delProducts(int id)throws SQLException{
        String storeName = "{call deleteProducts }";
        db.getCallAble(storeName).executeQuery();
    }

    public ResultSet getAllCID()throws SQLException{
        String storeName = "{call get_CID }";
        return db.getCallAble(storeName).executeQuery();
    }

    public ResultSet getAllExhibitor()throws SQLException{
        String storeName = "{call getAllExhibitor }";
        return db.getCallAble(storeName).executeQuery();
    }

    DefaultComboBoxModel CbExhibitorModel = null;
    HashMap hm = new HashMap();
    public void buildCbExhibitor(JComboBox cbExpo)
    {
        cbExpo.setModel(CbExhibitorModel = new DefaultComboBoxModel());
        CbExhibitorModel.addElement("-- Choose Exhibitor --");
        try{
            ResultSet rs = getAllExhibitor();
            while(rs.next()){
                String id = String.valueOf(rs.getInt(1));
                String name = rs.getString(2);
                hm.put(name,id);
                CbExhibitorModel.addElement(name);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public int returnIdExhibitor(JComboBox cbExhibitor)
    {
        return Integer.parseInt(hm.get(cbExhibitor.getSelectedItem().toString().trim()).toString());
    }
    DefaultComboBoxModel CbContactModel = null;
    public void buildCbContact(JComboBox cbContact)
    {
        cbContact.setModel(CbContactModel = new DefaultComboBoxModel());
        CbContactModel.addElement("-- Choose Contact ID--");
        try{
            ResultSet rs = getAllCID();
            while(rs.next()){
                String Cid = rs.getString(1);
                CbContactModel.addElement(Cid);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public boolean checkProducts(JComboBox cbExhibitor,JComboBox cbContact,JTextField txtName,JTextField txtPrice,JTextField txtNumber,JTextArea txtDescription){
        if(cbExhibitor.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Please, select Expo !","Check Product",JOptionPane.WARNING_MESSAGE);
            cbExhibitor.requestFocus();
            return false;
        }
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
            Long.parseLong(txtPrice.getText());
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
        if(txtDescription.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please, enter Description !","Check Product",JOptionPane.WARNING_MESSAGE);
            txtDescription.requestFocus();
            return false;
        }
        return true;
    }
}
