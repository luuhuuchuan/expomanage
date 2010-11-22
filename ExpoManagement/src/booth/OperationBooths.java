/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package booth;

import dataLayer.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author namh3o
 */
public class OperationBooths {

    DBHelper db = null;
    DefaultTableModel BoothsModel = null;
    DefaultComboBoxModel CbContactModel = null;
    DefaultComboBoxModel CbStaffModel = null;
    HashMap hm = new HashMap();
    DefaultComboBoxModel CbBoothTypeModel = null;
    HashMap hm2 = new HashMap();
    public void loadAllBooths(JTable jTable1){
        jTable1.setModel(BoothsModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Contact","Booth ID","Booth Type","Staff","Booth Name","Date","Cost","Booker"};
        for(String s : heading)
            v.add(s);
        BoothsModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getAllBooths();
            while(rs.next()){
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getInt(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getDate(6));
                v.add(rs.getFloat(7));
                if(rs.getBoolean(8))
                    v.add("Yes");
                else
                    v.add("No");
                BoothsModel.addRow(v);
            }
            rs.close();
            TableColumn column = null;
            for (int i = 0; i < 8; i++) {
                column = jTable1.getColumnModel().getColumn(i);
                if (i == 1) {
                    column.setPreferredWidth(30);
                }
                if (i == 2) {
                    column.setPreferredWidth(100);
                } 
                if (i == 4 || i ==5) {
                    column.setPreferredWidth(80);
                }
                else {
                    column.setPreferredWidth(50);
                }
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public OperationBooths(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getAllBooths()throws SQLException{
        String storeName = "{call getAllBooths }";
        return db.getCallAble(storeName).executeQuery();
    }
    public ResultSet getAllCID()throws SQLException{
        String storeName = "{call get_CID }";
        return db.getCallAble(storeName).executeQuery();
    }
    public ResultSet getAllStaff()throws SQLException{
        String storeName = "{call get_Sname }";
        return db.getCallAble(storeName).executeQuery();
    }
    public ResultSet getAllBoothType()throws SQLException{
        String storeName = "{call get_BoothType }";
        return db.getCallAble(storeName).executeQuery();
    }
    public void buildAllStaff(JComboBox cbStaff)
    {
        cbStaff.setModel(CbStaffModel = new DefaultComboBoxModel());
        CbStaffModel.addElement("-- Choose Staff --");
        try{
            ResultSet rs = getAllStaff();
            while(rs.next()){
                String sname = rs.getString(1);
                String sid = String.valueOf(rs.getInt(2));
                hm.put(sname,sid);
                CbStaffModel.addElement(sname);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
    public void buildAllContactID(JComboBox cbContact)
    {
        cbContact.setModel(CbContactModel = new DefaultComboBoxModel());
        CbContactModel.addElement("-- Choose Contact --");
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
    public void buildAlBoothType(JComboBox cbBoothType)
    {
        cbBoothType.setModel(CbBoothTypeModel = new DefaultComboBoxModel());
        CbBoothTypeModel.addElement("-- Choose BoothType --");
        try{
            ResultSet rs = getAllBoothType();
            while(rs.next()){
                String btname = rs.getString(1);
                String btid = String.valueOf(rs.getInt(2));
                hm2.put(btname,btid);
                CbBoothTypeModel.addElement(btname);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public int returnBTID(JComboBox cbBoothType)
    {
        return Integer.parseInt(hm2.get(cbBoothType.getSelectedItem().toString().trim()).toString());
    }
    public int returnSID(JComboBox cbStaff)
    {
        return Integer.parseInt(hm.get(cbStaff.getSelectedItem().toString().trim()).toString());
    }

}
