/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Addbooths.java
 *
 * Created on Nov 12, 2010, 5:16:02 PM
 */

package booth;

import dataLayer.DBHelper;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author namh3o
 */
public class Addbooths extends javax.swing.JFrame {

    OperationBooths ob  = new OperationBooths();
    DefaultComboBoxModel CbContactModel = null;
    HashMap hm = new HashMap();
    DefaultComboBoxModel CbStaffModel = null;
    HashMap hm1 = new HashMap();
    DefaultComboBoxModel CbBoothTypeModel = null;
    HashMap hm2 = new HashMap();
    /** Creates new form Addbooths */
    public Addbooths() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        //-----------------------
        cbStaff.setModel(CbStaffModel = new DefaultComboBoxModel());
        CbStaffModel.addElement("-- Choose Staff --");
        try{
            ResultSet rs = ob.getAllStaff();
            while(rs.next()){
                String name = rs.getString(1);
                String id = String.valueOf(rs.getInt(2));
                hm.put(name,id);
                CbStaffModel.addElement(name);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        //-----------------------
        /*
        cbContact.setModel(CbContactModel = new DefaultComboBoxModel());
        CbContactModel.addElement("-- Choose Contact --");
        try{
            ResultSet rs = ob.getAllCID();
            while(rs.next()){
                String name = rs.getString(1);
                String id = String.valueOf(rs.getInt(2));
                hm1.put(name,id);
                CbContactModel.addElement(id);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
         * */
        //-----------------------
        cbBoothType.setModel(CbBoothTypeModel = new DefaultComboBoxModel());
        CbBoothTypeModel.addElement("-- Choose BoothType --");
        try{
            ResultSet rs = ob.getAllBoothType();
            while(rs.next()){
                String name = rs.getString(1);
                String id = String.valueOf(rs.getInt(2));
                hm2.put(name,id);
                CbBoothTypeModel.addElement(name);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
    public void Reset(){
        cbContact.setSelectedItem("-- Choose Contact --");
        cbBoothType.setSelectedItem("-- Choose BoothType --");
        cbStaff.setSelectedItem("-- Choose Staff --");
        txtBname.setText("");
        txtBdate.setText("");
        txtBmoney.setText("");
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnAdd = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbStaff = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbContact = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbBoothType = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtBname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBdate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtBmoney = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnYes = new javax.swing.JRadioButton();
        btnNo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/76.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/33.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Booths"));

        jLabel2.setText("Staff  :");

        cbStaff.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Contact :");

        cbContact.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("BoothType :");

        cbBoothType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Booth Name :");

        jLabel7.setText("Booth Date :");

        jLabel1.setText("Booth Money :");

        jLabel11.setText("Booth Booker :");

        buttonGroup1.add(btnYes);
        btnYes.setSelected(true);
        btnYes.setText("Yes");

        buttonGroup1.add(btnNo);
        btnNo.setText("No");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel11)
                        .add(18, 18, 18)
                        .add(btnYes)
                        .add(18, 18, 18)
                        .add(btnNo)
                        .addContainerGap(130, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel7)
                                    .add(jLabel1))
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(18, 18, 18)
                                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(txtBname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(txtBdate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(18, 18, 18)
                                        .add(txtBmoney, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel6)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                                    .add(jLabel2)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(cbStaff, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(jPanel1Layout.createSequentialGroup()
                                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel3)
                                        .add(jLabel5))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 28, Short.MAX_VALUE)
                                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(cbBoothType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(cbContact, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                        .add(45, 45, 45))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(cbStaff, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(cbContact, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(19, 19, 19)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(cbBoothType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(23, 23, 23)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(txtBname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(txtBdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(23, 23, 23)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtBmoney, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnYes)
                    .add(btnNo)
                    .add(jLabel11))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(36, 36, 36)
                .add(btnAdd)
                .add(38, 38, 38)
                .add(btnReset)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 35, Short.MAX_VALUE)
                .add(btnClose)
                .add(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAdd)
                    .add(btnReset)
                    .add(btnClose))
                .add(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
        DBHelper db = null;
        db = new DBHelper();
        db.openConnection();
        int BTID = Integer.parseInt(hm.get(cbBoothType.getSelectedItem().toString().trim()).toString());
        int SID = Integer.parseInt(hm.get(cbStaff.getSelectedItem().toString().trim()).toString());
        int CID = Integer.parseInt(hm.get(cbContact.getSelectedItem().toString().trim()).toString());
        String name = txtBname.getText().trim();
        String bdate = txtBdate.getText().trim();
        float money = Float.parseFloat(txtBmoney.getText().trim());


        //tao giao dien de thuc thi store
        CallableStatement cs = db.getConnection().prepareCall("{call AddBoothType(?,?,?,?,?,?,?)}");
        //truyen tham so cho store
        cs.setInt(1, BTID);
        cs.setInt(2, SID);
        cs.setInt(3, CID);
        cs.setString(4, name);
        cs.setString(5, bdate);
        cs.setFloat(6, money);

        //thuc thi store
        cs.execute();
        JOptionPane.showMessageDialog(null, "One new Expo has been added","Add new Expo",JOptionPane.INFORMATION_MESSAGE);
        //lay gia tri tham so ra
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error occurred during execution","Add new Expo",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addbooths().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JRadioButton btnNo;
    private javax.swing.JButton btnReset;
    private javax.swing.JRadioButton btnYes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbBoothType;
    private javax.swing.JComboBox cbContact;
    private javax.swing.JComboBox cbStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBdate;
    private javax.swing.JTextField txtBmoney;
    private javax.swing.JTextField txtBname;
    // End of variables declaration//GEN-END:variables

}
