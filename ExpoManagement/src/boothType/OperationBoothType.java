/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boothType;


import dataLayer.DBHelper;
import expomanagement.Main;
import java.awt.Frame;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author namh3o
 */
public class OperationBoothType {

    DBHelper db = null;
    DefaultTableModel BoothTypeModel = null;
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
}
