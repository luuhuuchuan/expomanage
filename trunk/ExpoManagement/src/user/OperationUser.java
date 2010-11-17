/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

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
public class OperationUser {
    DBHelper db = null;

    DefaultTableModel UserModel = null;
    public void loadAllUser(JTable jTable1){
        jTable1.setModel(UserModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"User Name","User Pass","Type User","User Email"};
        for(String s : heading)
            v.add(s);
        UserModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getAllUser();
            while(rs.next()){
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                if (rs.getInt(3) == 1)
                    v.add("Manager");
                else if(rs.getInt(3) == 2)
                    v.add("User");
                v.add(rs.getString(4));
                UserModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
        public OperationUser(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getAllUser()throws SQLException{
        String storeName = "{call getAllUser }";
        return db.getCallAble(storeName).executeQuery();
    }
}

