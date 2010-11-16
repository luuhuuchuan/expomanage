/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boothType;


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
public class OperationBoothType {

    DBHelper db = null;
    DefaultTableModel BoothTypeModel = null;
    public void loadAllBoothType(JTable jTable1){
        jTable1.setModel(BoothTypeModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"BoothType Name","Expo Name" ,"Booth Height","Booth Width","Booth Remain","Booth Length"};
        for(String s : heading)
            v.add(s);
        BoothTypeModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getAllBoothType();
            while(rs.next()){
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getFloat(3));
                v.add(rs.getFloat(4));
                v.add(rs.getInt(5));
                v.add(rs.getInt(6));
                
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
        String storeName = "{call getID_Name_Of_Expo2 }";
        return db.getCallAble(storeName).executeQuery();
    }
}
