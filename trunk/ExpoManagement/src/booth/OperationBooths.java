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
    public void loadAllBoothType(JTable jTable1){
        jTable1.setModel(BoothsModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"BTID","BT Name","Expo ID","BT Height","BT Width","BoothRemain","BoothLength"};
        for(String s : heading)
            v.add(s);
        BoothsModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getAllBooths();
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getInt(3));
                v.add(rs.getFloat(4));
                v.add(rs.getFloat(5));
                v.add(rs.getInt(6));
                v.add(rs.getInt(7));
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

}
