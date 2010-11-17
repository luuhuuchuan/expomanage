/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package staff;

import dataLayer.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
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
        String [] heading = {"Staff Name","Staff Email","Staff Phone","Staff Address"};
        for(String s : heading)
            v.add(s);
        StaffModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getAllStaff();
            while(rs.next()){
                v = new Vector();
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getInt(5));
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
}
