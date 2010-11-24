/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Editbooths.java
 *
 * Created on Nov 22, 2010, 11:27:18 PM
 */

package booth;

import dataLayer.DBHelper;
import expomanagement.Main;
import java.awt.Frame;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author namh3o
 */
public class Editbooths extends javax.swing.JDialog {

    /** Creates new form Editbooths */
    OperationBooths ob  = new OperationBooths();
    Main m = null;
    Frame parentFrame = null;
    public Editbooths(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        ob.buildAllStaff(cbStaff);
        ob.buildAllContactID(cbContact);
        ob.buildAlBoothType(cbBoothType);
        parentFrame = parent;
        m = (Main)parent;

        int row = m.getBoothTable().getSelectedRow();

        cbStaff.setSelectedItem(m.getBoothTable().getValueAt(row, 3).toString());
        cbContact.setSelectedItem(m.getBoothTable().getValueAt(row,0).toString());
        cbBoothType.setSelectedItem(m.getBoothTable().getValueAt(row, 2).toString());
        txtBname.setText(m.getBoothTable().getValueAt(row, 4).toString());
        txtBDate.setDate(null);
        txtBmoney.setText(m.getBoothTable().getValueAt(row, 6).toString());
        buttonGroup1.isSelected(null);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbStaff = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbContact = new javax.swing.JComboBox();
        cbBoothType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtBname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBmoney = new javax.swing.JTextField();
        btnYes = new javax.swing.JRadioButton();
        btnNo = new javax.swing.JRadioButton();
        txtBDate = new com.toedter.calendar.JDateChooser();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Booths");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Booths"));

        jLabel2.setText("Staff :");

        cbStaff.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Contact ID :");

        jLabel4.setText("Booth Type : ");

        cbContact.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbBoothType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Booth Name :");

        txtBname.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel5.setText("Booth Date :");

        jLabel6.setText("Booth Money :");

        jLabel7.setText("Booth Booker :");

        buttonGroup1.add(btnYes);
        btnYes.setSelected(true);
        btnYes.setText("Yes");

        buttonGroup1.add(btnNo);
        btnNo.setText("No");

        txtBDate.setDateFormatString("MM/dd/yyyy");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jLabel5)
                    .add(jLabel6)
                    .add(jLabel7)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jLabel4))
                .add(29, 29, 29)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtBDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .add(cbContact, 0, 173, Short.MAX_VALUE)
                    .add(cbStaff, 0, 173, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, cbBoothType, 0, 173, Short.MAX_VALUE)
                    .add(txtBname, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(btnYes)
                        .add(35, 35, 35)
                        .add(btnNo))
                    .add(txtBmoney, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .add(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(cbStaff, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(cbContact, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(cbBoothType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtBname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel5)
                    .add(txtBDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(txtBmoney, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(btnYes)
                    .add(btnNo))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/76.png"))); // NOI18N
        btnReset.setText("Reset");

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/33.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(btnEdit)
                        .add(38, 38, 38)
                        .add(btnReset)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 34, Short.MAX_VALUE)
                        .add(btnCancel)
                        .add(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnEdit)
                    .add(btnReset)
                    .add(btnCancel))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(ob.checkformBooth(cbStaff, cbContact, cbBoothType, txtBname, txtBmoney)){
            try {
                DBHelper db = null;
                db = new DBHelper();
                db.openConnection();
                int row = m.getBoothTable().getSelectedRow();
                int id = Integer.parseInt(((Main)m).getBoothTable().getValueAt(row, 1).toString());
                int BTID = ob.returnBTID(cbBoothType);
                int SID = ob.returnSID(cbStaff);
                String CID = cbContact.getSelectedItem().toString();
                String name = txtBname.getText().trim();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                Date dS = txtBDate.getDate();
                String bdate = sdf.format(dS);
                float money = Float.parseFloat(txtBmoney.getText().trim());

                //tao giao dien de thuc thi store
                CallableStatement cs = db.getConnection().prepareCall("{call EditBooths (?,?,?,?,?,?,?,?)}");
                //truyen tham so cho store
                cs.setInt(1, id);
                cs.setInt(2, BTID);
                cs.setInt(3, SID);
                cs.setString(4, CID);
                cs.setString(5, name);
                cs.setString(6, bdate);
                cs.setFloat(7, money);
                if(btnYes.isSelected())
                    cs.setInt(8, 1);
                else
                    cs.setInt(8, 0);
                //thuc thi store
                if(JOptionPane.showConfirmDialog(null, "Do you want to update the record(s)",
                "Update Dialog",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    cs.execute();
                    ((Main)m).LoadBooth();
                    JOptionPane.showMessageDialog(null, "The record(s) has been updated","Update Result",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                //lay gia tri tham so ra
            } catch (Exception ex) {
                //JOptionPane.showMessageDialog(null, "An error occurred during execution","Add new Booth",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Editbooths dialog = new Editbooths(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JRadioButton btnNo;
    private javax.swing.JButton btnReset;
    private javax.swing.JRadioButton btnYes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbBoothType;
    private javax.swing.JComboBox cbContact;
    private javax.swing.JComboBox cbStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser txtBDate;
    private javax.swing.JTextField txtBmoney;
    private javax.swing.JTextField txtBname;
    // End of variables declaration//GEN-END:variables

}
