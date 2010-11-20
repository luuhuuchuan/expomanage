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
import javax.swing.JTable;
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

    public ResultSet getAllExpo()throws SQLException{
        String storeName = "{call get_EID }";
        return db.getCallAble(storeName).executeQuery();
    }

    DefaultComboBoxModel CbExpoModel = null;
    public void buildCbExpo(JComboBox cbExpo)
    {
        cbExpo.setModel(CbExpoModel = new DefaultComboBoxModel());
        CbExpoModel.addElement("-- Choose Expo ID --");
        try{
            ResultSet rs = getAllExpo();
            while(rs.next()){
                String Eid = rs.getString(1);
                CbExpoModel.addElement(Eid);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
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
}
