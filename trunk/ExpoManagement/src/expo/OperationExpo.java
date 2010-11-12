/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expo;

import dataLayer.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
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
        String [] heading = {"Expo Code","Expo Name","Number Booth","Cost","Date Start","Date End"};
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
    public ResultSet getAllExpo()throws SQLException{
        String storeName = "{call getAllExpo }";
        return db.getCallAble(storeName).executeQuery();
    }
//    public ResultSet doSearch(String str)throws SQLException{
//        //mo ket noi
//        //tao van tin
//    }
//    public void delExpo(int id)throws SQLException{
//        String storeName = "{call delExpo }";
//        db.getCallAble(storeName).executeQuery();
//    }
}
