/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Registration;

import boothType.OperationBoothType;
import dataLayer.DBHelper;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hse7en
 */
public class ChosenBooth {
    DBHelper db = null;
    OperationBoothType obt = new OperationBoothType();
    DefaultTableModel BoothsModel = null;
    HashMap hm = new HashMap(); 
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    String BTName;
    int lengthBooth,remainBooth;
    public void showInfoExpo(String ExID,JTextField StartDate,JTextField EndDate,JTextArea Des)
    {
        try {
            ResultSet rs = getStore("showAllInfoExpo("+ExID+")");
                while(rs.next()){
                    StartDate.setText(formatter.format(rs.getDate(1)).trim());
                    EndDate.setText(formatter.format(rs.getDate(2)).trim());
                    Des.setText(rs.getString(3).trim());
                }
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChosenBooth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showInfomation(String EID,JTable tbshowBooths)
    {
        tbshowBooths.setModel(BoothsModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"BID","Name","BoothType","Date Create","Money","Booked"};
        for(String s : heading)
            v.add(s);
        BoothsModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getStore("showAllInformation("+EID+")");
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2).trim());
                BTName = rs.getString(3).trim();
                v.add(BTName);
                v.add(formatter.format(rs.getDate(4)));
                v.add(rs.getFloat(5));
                if(rs.getBoolean(6))
                    v.add("Yes");
                else
                    v.add("No");
                lengthBooth = rs.getInt(7);
                remainBooth = rs.getInt(8);
                BoothsModel.addRow(v);
                hm.put(BTName, new BoothType(BTName, lengthBooth, remainBooth));
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void choiceBooth(String ID,boolean book){
        try{
        CallableStatement cs = db.getConnection().prepareCall("{call choiceBooth(?,?)}");
        //truyen tham so cho store
        cs.setString(1, ID);
        cs.setBoolean(2, book);
        cs.execute();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void showInfoBT(String Name,JTextField BTName,JTextField BTLength,JTextField BTRemain){
        BoothType bt = new BoothType();
        bt = (BoothType) hm.get(Name);
        BTName.setText(Name);
        BTLength.setText(Integer.toString(bt.getBTLength()));
        BTRemain.setText(Integer.toString(bt.getBTRemain()));
    }
    DefaultComboBoxModel CbWhereChoseBooth = null;
    HashMap hmcb = new HashMap();
    public void buildCbFindBooth(JComboBox cbWhereBT)
    {
        cbWhereBT.setModel(CbWhereChoseBooth = new DefaultComboBoxModel());
        CbWhereChoseBooth.addElement("BoothType ID");
        hmcb.put("BoothID","B.BID");
        CbWhereChoseBooth.addElement("BoothType Name");
        hmcb.put("BoothType Name","BT.BTName");
        CbWhereChoseBooth.addElement("Booth Height");
        hmcb.put("Booth Height","BT.BTHeight");
        CbWhereChoseBooth.addElement("Booth Width");
        hmcb.put("Booth Width","BT.BTWidth");
    }
    
    public ChosenBooth(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getStore(String sName)throws SQLException{
        String storeName = "{call "+sName+" }";
        return db.getCallAble(storeName).executeQuery();
    }
}
