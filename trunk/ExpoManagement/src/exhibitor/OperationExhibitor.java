/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exhibitor;

import dataLayer.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cuongnvgc00064
 */
public class OperationExhibitor {
    DBHelper db = null;

    DefaultTableModel ExhibitorModel = null;
    public void loadAllExhibitor(JTable jTable1){
        jTable1.setModel(ExhibitorModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Exhibitor Code","Exhibitor Name","Exhibitor Fax","Exhibitor Phone","Website"};
        for(String s : heading)
            v.add(s);
        ExhibitorModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getAllExhibitor();
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(6));
                ExhibitorModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public OperationExhibitor(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getAllExhibitor()throws SQLException{
        String storeName = "{call getAllExhibitor }";
        return db.getCallAble(storeName).executeQuery();
    }
//    public ResultSet doSearch(String str)throws SQLException{
//        //mo ket noi
//        //tao van tin
//    }
//    public void delExhibitor(int id)throws SQLException{
//        String storeName = "{call delExhibitor }";
//        db.getCallAble(storeName).executeQuery();
//    }
}
