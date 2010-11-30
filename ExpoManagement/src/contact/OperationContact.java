/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contact;

import dataLayer.DBHelper;
import expomanagement.Main;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cuongnvgc00064
 */
public class OperationContact {
    DBHelper db = null;
    DefaultTableModel ContactModel = null;
    Main m = null;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    public void loadAllContact(java.awt.Frame parent,String EID,JTable jTable1){
        m = (Main) parent;
        jTable1.setModel(ContactModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Contact ID","User Credential","Number Booth","Priority Point"};
        for(String s : heading)
            v.add(s);
        ContactModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getStore("getAllContact("+EID.trim()+")");
            while(rs.next()){
                v = new Vector();
                v.add(rs.getString(1).trim());
                v.add(rs.getString(4).trim());
                v.add(rs.getInt(5));
                v.add(rs.getString(12).trim());
                ContactModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public OperationContact(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getStore(String sName)throws SQLException{
        String storeName = "{call "+sName+" }";
        return db.getCallAble(storeName).executeQuery();
    }
    public void delContact(String id){
        try{
        CallableStatement cs = db.getConnection().prepareCall("{call DeleteContact(?)}");
        //truyen tham so cho store
        cs.setString(1, id);
        if(JOptionPane.showConfirmDialog(null, "Do you want to delete this Contact ?",
                "Delete Contact",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            cs.execute();
            JOptionPane.showMessageDialog(null, "One Contact has been deleted !","Delete Contact",JOptionPane.INFORMATION_MESSAGE);
        }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this Contact !","Delete Contact",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void DetailOfContact(String id){
        
    }
}
