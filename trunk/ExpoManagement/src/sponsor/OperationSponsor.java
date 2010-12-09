/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sponsor;

import dataLayer.DBHelper;
import expomanagement.Application;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class OperationSponsor {
 DBHelper db = null;
 Application m = null;
    DefaultTableModel SponsorModel = null;
    public void loadAllSponsor(java.awt.Frame parent,JTable jTable1){
        m = (Application) parent;
        jTable1.setModel(SponsorModel = new DefaultTableModel());
        Vector v = new Vector();
        String [] heading = {"Sponsers ID","Name","Expo","Money","Description"};
        for(String s : heading)
            v.add(s);
        SponsorModel.setColumnIdentifiers(v);
        try{
            ResultSet rs = getStore("getAllSponsors("+m.getEID()+")");
            while(rs.next()){
                v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2).trim());
                v.add(rs.getString(3).trim());
                v.add(rs.getFloat(4));
                v.add(rs.getString(5).trim());
                SponsorModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public OperationSponsor(){
        db = new DBHelper();
        db.openConnection();
    }
     public boolean checkformSponsor( JComboBox cbExpo, JTextField txtSpName, JTextField txtSpMoney){
        if(cbExpo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Please,select  Expo");
            cbExpo.requestFocus();
            return false;
        }
        if(txtSpName.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Name of Sponsor");
            txtSpName.requestFocus();
            return false;
        }
        if(txtSpMoney.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please,Enter Money");
            txtSpMoney.requestFocus();
            return false;
        }
        try {
            Long.parseLong(txtSpMoney.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Money must Number");
            txtSpMoney.requestFocus();
            return false;
        }

        return true;
    }
    public ResultSet getStore(String sName)throws SQLException{
        String storeName = "{call "+sName+" }";
        return db.getCallAble(storeName).executeQuery();
    }
    DefaultComboBoxModel CbExpoModel = null;
    HashMap hm = new HashMap();

    public void buildCbExpo(JComboBox cbExpo)
    {
        cbExpo.setModel(CbExpoModel = new DefaultComboBoxModel());
        CbExpoModel.addElement("-- Choose Expo --");
        try{
            ResultSet rs = getStore("getID_Name_Of_Expo");
            while(rs.next()){
                String name = rs.getString(1);
                String id = String.valueOf(rs.getInt(2));
                hm.put(name,id);
                CbExpoModel.addElement(name);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void delSponsor(int id){
        try{
            CallableStatement cs = db.getConnection().prepareCall("{call deleteSponsor(?)}");
            //truyen tham so cho store
            cs.setInt(1, id);
            if(JOptionPane.showConfirmDialog(null, "Do you want to delete the record(s)",
                        "Update Dialog",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                cs.execute();
                JOptionPane.showMessageDialog(null, "One Sponsor has been deleted !","Delete Sponsor",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Can't delete this Sponsor !","Delete Sponsor",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void doSearch(String Where, String Key, JTable tblSponsor){
        try
        {
            String storeName = "findSponsor("+m.getEID()+",'" + Where + "','" + Key + "')";
            tblSponsor.setModel(SponsorModel = new DefaultTableModel());
            Vector v = new Vector();
            String [] heading = {"Sponsers ID","Name","Expo","Money","Description"};
            for(String s : heading)
                v.add(s);
            SponsorModel.setColumnIdentifiers(v);
            ResultSet rs = getStore(storeName);
                while(rs.next()){
                 v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2).trim());
                v.add(rs.getString(3).trim());
                v.add(rs.getFloat(4));
                v.add(rs.getString(5).trim());
                SponsorModel.addRow(v);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
 DefaultComboBoxModel CbWhereSponsorModel = null;
    HashMap hmbt = new HashMap();
    public void buildCbWhereSp(JComboBox cbWhereSp)
    {
        cbWhereSp.setModel(CbWhereSponsorModel = new DefaultComboBoxModel());
        CbWhereSponsorModel.addElement("Sponsor ID");
        hmbt.put("Sponsor ID","S.SpID");
        CbWhereSponsorModel.addElement("Sponsor Name");
        hmbt.put("Sponsor Name","S.SpName");
    }
    public String returnSearch(JComboBox cbWhereSp)
    {
        return hmbt.get(cbWhereSp.getSelectedItem().toString().trim()).toString();
    }

    public int returnIdExpo(JComboBox cbExpo)
    {
        return Integer.parseInt(hm.get(cbExpo.getSelectedItem().toString().trim()).toString());
    }

}