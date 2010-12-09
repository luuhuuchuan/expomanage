/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contract;

import dataLayer.DBHelper;
import expomanagement.Application;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cuongnvgc00064
 */
public class OperationContract {
    DBHelper db = null;
    DefaultTableModel ContractModel = null;
    Application m = null;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    HashMap hm = new HashMap();
    public void loadAllContract(java.awt.Frame parent,String EID,JTable jTable1){
        m = (Application) parent;
        jTable1.setModel(ContractModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Contact ID","User Credential","Number Booth","Priority Point"};
        for(String s : heading)
            v.add(s);
        ContractModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getStore("getAllContract("+EID.trim()+")");
            while(rs.next()){
                v = new Vector();
                String CID = rs.getString(1).trim();
                String Expo = rs.getString(2).trim();
                String UserCre = rs.getString(3).trim();
                String numBooth = Integer.toString(rs.getInt(4));
                String Paid = Double.toString(rs.getDouble(5));
                String RDate = formatter.format(rs.getDate(6));
                String SDate = null,RtDate = null,LDate ="";
                try {
                    SDate = formatter.format(rs.getDate(7));
                    RtDate = formatter.format(rs.getDate(8));
                    LDate = formatter.format(rs.getDate(9));
                } catch (NullPointerException e) {

                }
                Boolean Status = rs.getBoolean(10);
                String ProPoint = rs.getString(11).trim();

                v.add(CID);
                v.add(UserCre);
                v.add(numBooth);
                v.add(ProPoint);
                ContractModel.addRow(v);

                hm.put(CID, new Contract(Expo,RDate, UserCre, Status, numBooth, SDate, RtDate, LDate, Paid));
            }
            rs.close();
        }
        catch(Exception ex){
        }
    }
    public OperationContract(){
        db = new DBHelper();
        db.openConnection();
    }
    public ResultSet getStore(String sName)throws SQLException{
        String storeName = "{call "+sName+" }";
        return db.getCallAble(storeName).executeQuery();
    }
    public void delContract(String id,String EID,int typeUser){
        try{
        CallableStatement cs = db.getConnection().prepareCall("{call DeleteContract(?)}");
        //truyen tham so cho store
        cs.setString(1, id);
        if(JOptionPane.showConfirmDialog(null, "Do you want to delete this Contact ?",
                "Delete Contact",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            cs.execute();
            if(typeUser==1)
                m.LoadContract("null");
            else if(typeUser==2)
                m.LoadContract(EID);
            JOptionPane.showMessageDialog(null, "One Contact has been deleted !","Delete Contact",JOptionPane.INFORMATION_MESSAGE);
        }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this Contact !","Delete Contact",JOptionPane.ERROR_MESSAGE);
        }
    }
        public void makeContract(String ID,String ExID,String EID,String PrID,String user,String num,String date ){
        try{
        CallableStatement cs = db.getConnection().prepareCall("{call makeContract(?,?,?,?,?,?,?)}");
        //truyen tham so cho store
        cs.setString(1, ID);
        cs.setInt(2, Integer.parseInt(ExID));
        cs.setInt(3, Integer.parseInt(EID));
        cs.setInt(4, Integer.parseInt(PrID));
        cs.setString(5, user);
        cs.setInt(6, Integer.parseInt(num));
        cs.setString(7, date);
        cs.execute();
        m.LoadContract(m.getEID());
        JOptionPane.showMessageDialog(null, "One Contact has been made !","Make Contact",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void sendContract(String id,String EID){
        try{
        Date today = new Date();
        String SendDate = formatter.format(today);
        CallableStatement cs = db.getConnection().prepareCall("{call SendContract(?,?)}");
        //truyen tham so cho store
        cs.setString(1, id);
        cs.setString(2, SendDate);
        if(JOptionPane.showConfirmDialog(null, "Do you want to send this Contact ?",
                "Send Contact",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            cs.execute();
            m.LoadContract(EID);
            JOptionPane.showMessageDialog(null, "One Contact has been sent !","Send Contact",JOptionPane.INFORMATION_MESSAGE);
        }
        }catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    public void returnContract(String id,Float Paid){
        try{
        Date today = new Date();
        String ReturnDate = formatter.format(today);
        CallableStatement cs = db.getConnection().prepareCall("{call ReturnContract(?,?,?)}");
        //truyen tham so cho store
        cs.setString(1, id);
        cs.setString(2, ReturnDate);
        cs.setFloat(3, Paid);
        if(JOptionPane.showConfirmDialog(null, "Do you want to return this Contact ?",
                "Return Contact",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            cs.execute();
            m.LoadContract("null");
            JOptionPane.showMessageDialog(null, "One Contact has been returned !","Return Contact",JOptionPane.INFORMATION_MESSAGE);
        }
        }catch(Exception e)
        {
           e.printStackTrace();
        }
    }
        public void updateContract(String id,int ExID,String User,int NumBooth){
        try{
        Date today = new Date();
        String ReDate = formatter.format(today);
        CallableStatement cs = db.getConnection().prepareCall("{call UpdateContract(?,?,?,?,?)}");
        //truyen tham so cho store
        cs.setString(1, id);
        cs.setInt(2, ExID);
        cs.setString(3, User);
        cs.setInt(4, NumBooth);
        cs.setString(5, ReDate);
        if(JOptionPane.showConfirmDialog(null, "Do you want to update this Contact ?",
                "Update Contact",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            cs.execute();
            m.LoadContract(m.getEID().trim());
            JOptionPane.showMessageDialog(null, "One Contact has been updated !","Update Contact",JOptionPane.INFORMATION_MESSAGE);
        }
        }catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    public void DetailOfContract(int typeUser,String EID,String CID,JTextField txtregDate,JTextField txtuserCre,JRadioButton rbnPaid,JRadioButton rbnUnPaid,JTextField txtBooths,JTextField txtsentDate,JTextField txtreturnDate,JTextField txtlastChange,JTextField txtPaid,JButton btnActContract,JButton btnUpdateContract)
    {
        
        Contract c = new Contract();
        c = (Contract) hm.get(CID.trim());
        m.setCbExpoContract(c.getExpo().trim());
        txtuserCre.setText(c.getName());
        txtBooths.setText(c.getNumBooths());
        txtPaid.setText(c.getPaid());
        txtregDate.setText(c.getRDate());
        txtsentDate.setText(c.getSentDate());
        txtreturnDate.setText(c.getReturnDate());
        txtlastChange.setText(c.getLastDate());
        if(typeUser==1)
        {
            if(c.getStatus()){
                rbnPaid.setSelected(true);
            }
            else{
                rbnUnPaid.setSelected(true);
            }
            if(c.getReturnDate()==null)
            {
                btnActContract.setEnabled(true);
                txtPaid.setEnabled(true);
                txtPaid.setEditable(true);
            }
            else
            {
                btnActContract.setEnabled(false);
                txtPaid.setEditable(false);
            }
        }
        else if(typeUser==2)
        {
            if(c.getStatus()){
                rbnPaid.setSelected(true);
                rbnPaid.setEnabled(true);
                rbnUnPaid.setEnabled(false);
            }
            else{
                rbnUnPaid.setEnabled(true);
                rbnUnPaid.setSelected(true);
                rbnPaid.setEnabled(false);
            }
            if(c.getSentDate()==null){
                btnActContract.setEnabled(true);
                btnUpdateContract.setEnabled(true);
                txtuserCre.setEditable(true);
            }
            else
            {
                btnActContract.setEnabled(false);
                btnUpdateContract.setEnabled(false);
            }                
        }
    }
}
