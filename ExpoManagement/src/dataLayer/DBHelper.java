/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dataLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Cuongnvgc00064
 */
public class DBHelper {
    private Connection conn = null;
    public Connection getConnection(){
        return conn;
    }
    //open the connection
    public boolean openConnection(){
        try{
            //load the driver (type 1)
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //load the driver (type 4)
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error when resgistering a bridge","Load the driver",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try{
            //open the connection (type 1)
            conn = DriverManager.getConnection("jdbc:odbc:Expo");
            //(type 4)
            //conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=123456;database=Expo");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Can not open the connection"+ex,"Open the connection",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    //close the connection
    @Override
    public void finalize()throws Throwable{
        if(conn != null){
            conn.setAutoCommit(true);
            conn.close();            
            conn = null;
        }
    }
    //create an interface to send and receive data
    public Statement getStatement()throws SQLException{
        return conn.createStatement();
    }
     //create an interface to send and receive data
    public CallableStatement getCallAble(String  storeName)throws SQLException{
        return conn.prepareCall(storeName);
    }
    
}
