/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package booth;

import dataLayer.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author namh3o
 */
public class OperationBooths {

    DBHelper db = null;
    DefaultTableModel BoothsModel = null;
    public void loadAllBooths(JTable jTable1){
        jTable1.setModel(BoothsModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Contact ID","Book ID","BoothType Name","Staff Name","Booth Name","Booth Date","Booth Money","Booth Booker"};
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
                v.add(rs.getBoolean(8));
                BoothsModel.addRow(v);
            }
            rs.close();
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

}
