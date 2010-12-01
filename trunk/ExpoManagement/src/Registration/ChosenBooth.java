/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Registration;

import boothType.OperationBoothType;
import dataLayer.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hse7en
 */
public class ChosenBooth {
    OperationBoothType obt = new OperationBoothType();
    DefaultTableModel BoothsModel = null;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public void showInfomation(String EID,JTable tbshowBooths)
    {
        tbshowBooths.setModel(BoothsModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"BID","B.BName","BT.BTName","BT.BoothLength","BT.BoothRemain","B.BDate","B.BMoney","B.BBooker"};
        for(String s : heading)
            v.add(s);
        BoothsModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getStore("showAllInformation("+EID+")");
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2).trim());
                v.add(rs.getString(3).trim());
                v.add(rs.getInt(4));
                v.add(rs.getInt(5));
                v.add(rs.getFloat(6));
                v.add(formatter.format(rs.getDate(7)));
                if(rs.getBoolean(8))
                    v.add(new JCheckBox());
                else
                    v.add(new JCheckBox());
                    //v.add(new Boolean(false));
                BoothsModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    DBHelper db = null;
    public ChosenBooth(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getStore(String sName)throws SQLException{
        String storeName = "{call "+sName+" }";
        return db.getCallAble(storeName).executeQuery();
    }
}
