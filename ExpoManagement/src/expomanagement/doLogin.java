/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expomanagement;

import dataLayer.DBHelper;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Hse7en
 */
public class doLogin {
        HashMap hm = new HashMap();
    public boolean Login(JTextField txtUserName,JPasswordField txtPass) throws Exception{
        DBHelper db = null;
        db = new DBHelper();
        db.openConnection();

        String DBUser = "";
        String DBPass = "";
        String userName = txtUserName.getText().trim();
        String pass = new String(txtPass.getPassword()).trim();

        String storeName = "{call doLogin('" + userName + "')}";
        ResultSet rs = db.getCallAble(storeName).executeQuery();
        while(rs.next()){
            DBUser = rs.getString(1).trim();
            hm.put("User",DBUser);
            DBPass = rs.getString(2).trim();
            int TypeUser = rs.getInt(3);
            hm.put("TypeUser",TypeUser);
            int EID = rs.getInt(4);
            hm.put("EID",EID);
        }
        rs.close();
        if(userName.equalsIgnoreCase(DBUser.trim()) && pass.equalsIgnoreCase(DBPass.trim())){
            return true;
        } else{
            return false;
        }

    }
    public String ReturnLogin(String Obj){
        JOptionPane.showMessageDialog(null, "One:"+hm.get("User").toString(),"Delete Expo",JOptionPane.INFORMATION_MESSAGE);
        return hm.get(Obj).toString();
    }
 
}
