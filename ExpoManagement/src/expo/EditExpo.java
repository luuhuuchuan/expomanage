/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditExpo.java
 *
 * Created on Nov 13, 2010, 8:32:01 AM
 */

package expo;

import dataLayer.DBHelper;
import expomanagement.Main;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public class EditExpo extends javax.swing.JDialog {
    Main m = null;
    DBHelper db = null;
    OperationExpo oe = new OperationExpo();
    /** Creates new form EditExpo */
    public EditExpo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(w/3, h/3);
        m = (Main)parent;
        int row = m.getExpoTable().getSelectedRow();
        txtName.setText(m.getExpoTable().getValueAt(row, 1).toString().trim());
        txtNumBooth.setText(m.getExpoTable().getValueAt(row, 2).toString().trim());
        txtCost.setText(m.getExpoTable().getValueAt(row, 3).toString().trim());
        txtDescription.setText(m.getExpoTable().getValueAt(row, 4).toString().trim());
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String StartDate = m.getExpoTable().getValueAt(row, 5).toString().trim();
        String EndDate = m.getExpoTable().getValueAt(row, 6).toString().trim();
        try {
            txtDateStart.setDate(formatter.parse(StartDate));
            txtDateEnd.setDate(formatter.parse(EndDate));
        } catch (ParseException ex) {
            Logger.getLogger(EditExpo.class.getName()).log(Level.SEVERE, null, ex);
        }  
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNumBooth = new javax.swing.JTextField();
        txtCost = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtDateStart = new com.toedter.calendar.JDateChooser();
        txtDateEnd = new com.toedter.calendar.JDateChooser();
        BtnClose = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Expo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Expo"));

        jLabel1.setText("Expo Name:");

        jLabel2.setText("Number Booth:");

        jLabel3.setText("Cost:");

        jLabel4.setText("Description:");

        jLabel5.setText("Date Start:");

        jLabel6.setText("Date End:");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        txtDateStart.setDateFormatString("MM/dd/yyyy");

        txtDateEnd.setDateFormatString("MM/dd/yyyy");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2))
                        .add(31, 31, 31)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtNumBooth, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .add(txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(77, 77, 77)
                        .add(txtCost, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel4)
                        .add(46, 46, 46)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel6)
                            .add(jLabel5))
                        .add(49, 49, 49)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(txtDateEnd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtDateStart, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtNumBooth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(txtCost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(jLabel5))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(txtDateStart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(23, 23, 23)
                        .add(jLabel6))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(txtDateEnd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addContainerGap())
        );

        BtnClose.setFont(new java.awt.Font("Tahoma", 0, 12));
        BtnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/33.png"))); // NOI18N
        BtnClose.setText("Close");
        BtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/22.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(74, 74, 74)
                .add(btnEdit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 106, Short.MAX_VALUE)
                .add(BtnClose)
                .add(96, 96, 96))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnEdit)
                    .add(BtnClose))
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Edit expo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(oe.checkformExpo(txtName, txtNumBooth, txtCost, txtDateStart, txtDateEnd)){
        try{
        db = new DBHelper();
        db.openConnection();
        int row = m.getExpoTable().getSelectedRow();
        int id = Integer.parseInt(((Main)m).getExpoTable().getValueAt(row, 0).toString());
        String name = txtName.getText().trim();
        int numBooth = Integer.parseInt(txtNumBooth.getText().trim());
        float cost = Float.parseFloat(txtCost.getText().trim());
        String description = txtDescription.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date dS = txtDateStart.getDate();
        Date dE = txtDateEnd.getDate();
        String dateStart = sdf.format(dS);
        String dateEnd = sdf.format(dE);
        CallableStatement cs = db.getConnection().prepareCall("{call EditExpo(?,?,?,?,?,?,?)}");
        //truyen tham so cho store
        cs.setInt(1, id);
        cs.setString(2, name);
        cs.setInt(3, numBooth);
        cs.setFloat(4, cost);
        cs.setString(5, description);
        cs.setString(6,dateStart);
        cs.setString(7,dateEnd);
        //thuc thi store
        cs.execute();
        //confirm update request from client
        if(JOptionPane.showConfirmDialog(null, "Do you want to update the record(s)",
                "Update Dialog",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            cs.execute();
            m.LoadExpo();
            dispose();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
      }
}//GEN-LAST:event_btnEditActionPerformed

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_BtnCloseActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnClose;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCost;
    private com.toedter.calendar.JDateChooser txtDateEnd;
    private com.toedter.calendar.JDateChooser txtDateStart;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumBooth;
    // End of variables declaration//GEN-END:variables

}
