/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Login.java
 *
 * Created on 30-11-2010, 02:17:17
 */

package expomanagement;

import dataLayer.DBHelper;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hse7en
 */
public class Login extends javax.swing.JDialog {
    Main m = null;
    /** Creates new form Login */
    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(w/3, h/3);
        txtUserName.requestFocus();
        m = (Main) parent;

        this.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        lbTitle1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EXPO MANAGEMENT SYSTEM");

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/28.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/76.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/33.png"))); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        lbTitle1.setFont(new java.awt.Font("Tahoma", 1, 14));
        lbTitle1.setText("LOGIN WITH YOUR ACCOUNT");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                        .add(65, 65, 65)
                        .add(btnLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(btnReset)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 31, Short.MAX_VALUE)
                        .add(btnQuit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel1))
                        .add(35, 35, 35)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtPass, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .add(txtUserName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))))
                .add(37, 37, 37))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .add(lbTitle1)
                .add(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(lbTitle1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(26, 26, 26)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtPass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnQuit)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(btnLogin)
                        .add(btnReset)))
                .add(23, 23, 23))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 417, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 217, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equalsIgnoreCase("enter"))
            doLogin();
    }//GEN-LAST:event_txtUserNameKeyPressed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        doLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtPass.setText("");
        txtUserName.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnQuitActionPerformed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equalsIgnoreCase("enter"))
            doLogin();
    }//GEN-LAST:event_txtPassKeyPressed
public void doLogin(){
        try {
            DBHelper db = null;
            db = new DBHelper();
            db.openConnection();
            String DBUser = "";
            String DBPass = "";
            int TypeUser = 0,EID = 0;
            String userName = txtUserName.getText().trim();
            String pass = new String(txtPass.getPassword()).trim();
            String storeName = "{call doLogin('" + userName + "')}";
            ResultSet rs = db.getCallAble(storeName).executeQuery();
            while (rs.next()) {
                DBUser = rs.getString(1).trim();
                DBPass = rs.getString(2).trim();
                TypeUser = rs.getInt(3);
                EID = rs.getInt(4);
            }
            rs.close();
            if (userName.equalsIgnoreCase(DBUser.trim()) && pass.equalsIgnoreCase(DBPass.trim())) {
                m.setUser(DBUser);
                m.setTypeUser(TypeUser);
                m.setEID(EID);
                m.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "The username or password you entered is incorrect!", "Login Application", JOptionPane.ERROR_MESSAGE);
            }
        }
        /**
         * @param args the command line arguments
         */
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTitle1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

}
