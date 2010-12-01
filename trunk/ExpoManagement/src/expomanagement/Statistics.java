/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expomanagement;

import dataLayer.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Hse7en
 */
public class Statistics {
    DBHelper db = null;
    public Statistics(){
        db = new DBHelper();
        db.openConnection();
    }
    
    public void statisticsExhibitor(String EID,JLabel countS,JLabel countP,JLabel sumB,JLabel countC){
        try {
            ResultSet rs = db.getCallAble("{Call countExhibitor("+EID+")}").executeQuery();
            int S = 0;
            int P = 0;
            int B = 0;
            int C = 0;
            while (rs.next()) {
                S = rs.getInt(1);
                P = rs.getInt(2);
                B = rs.getInt(3);
                C = rs.getInt(4);
            }
            rs.close();
            countS.setText(Integer.toString(S));
            countP.setText(Integer.toString(P));
            sumB.setText(Integer.toString(B));
            countC.setText(Integer.toString(C));
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void statisticsSys(JLabel countExpo,JLabel countE,JLabel countBT,JLabel countB,JLabel countSp,JLabel countS,JLabel countP,JLabel countC) {
        try {
            ResultSet rs = db.getCallAble("CountExpo").executeQuery();
            int Ex = 0;
            int E = 0;
            int BT = 0;
            int B = 0;
            int Sp = 0;
            int S = 0;
            int P = 0;
            int C = 0;
            while (rs.next()) {
                Ex = rs.getInt(1);
                E = rs.getInt(2);
                BT = rs.getInt(3);
                B = rs.getInt(4);
                Sp = rs.getInt(5);
                S = rs.getInt(6);
                P = rs.getInt(7);
                C = rs.getInt(8);
            }
            rs.close();
            countExpo.setText(Integer.toString(Ex));
            countE.setText(Integer.toString(E));
            countBT.setText(Integer.toString(BT));
            countB.setText(Integer.toString(B));
            countSp.setText(Integer.toString(Sp));
            countS.setText(Integer.toString(S));
            countP.setText(Integer.toString(P));
            countC.setText(Integer.toString(C));
        } catch (Exception ex) {

        }
    }

}
