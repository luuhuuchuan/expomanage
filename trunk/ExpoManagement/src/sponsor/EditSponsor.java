/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditSponsor.java
 *
 * Created on Nov 13, 2010, 11:17:02 AM
 */

package sponsor;

import dataLayer.DBHelper;
import expomanagement.Application;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */

public class EditSponsor extends javax.swing.JDialog {
    Application m = null;
    DBHelper db = null;
    OperationSponsor os  = new OperationSponsor();
    /** Creates new form EditSponsor */
    public EditSponsor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(w/3, h/3);
        os.buildCbExpo(cbExpo);
        m = (Application) parent;
        int row = m.getSponsorTable().getSelectedRow();
        txtSpID.setText(((Application) m).getSponsorTable().getValueAt(row, 0).toString().trim());
        txtSpName.setText(((Application) m).getSponsorTable().getValueAt(row, 1).toString().trim());
        cbExpo.setSelectedItem(((Application) m).getSponsorTable().getValueAt(row, 2));
        txtSpMoney.setText(((Application) m).getSponsorTable().getValueAt(row, 3).toString().trim());
        txtSpDes.setText(((Application) m).getSponsorTable().getValueAt(row, 4).toString().trim());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClose = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSpID = new javax.swing.JTextField();
        txtSpName = new javax.swing.JTextField();
        txtSpMoney = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSpDes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cbExpo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Sponsor");

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/33.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/22.png"))); // NOI18N
        btnEdit.setText("Save");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Sponsor"));

        jLabel5.setText("Sponsor Description:");

        txtSpID.setEditable(false);
        txtSpID.setEnabled(false);

        jLabel4.setText("Sponsor Money");

        jLabel3.setText("Sponsor Name:");

        jLabel2.setText("Sponsor ID:");

        txtSpDes.setColumns(20);
        txtSpDes.setRows(5);
        jScrollPane1.setViewportView(txtSpDes);

        jLabel1.setText("Expo:");

        cbExpo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2)
                            .add(jLabel3)
                            .add(jLabel4))
                        .add(29, 29, 29)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(txtSpMoney, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtSpName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, cbExpo, 0, 269, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtSpID, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
                .add(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtSpID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(cbExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtSpName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtSpMoney, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(63, 63, 63)
                        .add(btnEdit)
                        .add(126, 126, 126)
                        .add(btnClose)))
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
                    .add(btnClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_btnCloseActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(os.checkformSponsor( cbExpo, txtSpName, txtSpMoney)){
     try{
        db = new DBHelper();
        db.openConnection();
        int row = m.getSponsorTable().getSelectedRow();
        int id = Integer.parseInt(((Application)m).getSponsorTable().getValueAt(row, 0).toString());
        String name = txtSpName.getText().trim();
        int eid = os.returnIdExpo(cbExpo);
        Float money = Float.parseFloat(txtSpMoney.getText().trim());
        String description = txtSpDes.getText().trim();
        //tao giao dien de thuc thi store
        CallableStatement cs = db.getConnection().prepareCall("{call EditSponsor(?,?,?,?,?)}");
        //truyen tham so cho store
        cs.setInt(1, id);
        cs.setString(2, name);
        cs.setInt(3, eid);
        cs.setFloat(4, money);
        cs.setString(5, description);
        //thuc thi store
        cs.execute();
        //confirm update request from client
        if(JOptionPane.showConfirmDialog(null, "Do you want to update the record(s)",
                "Update Dialog",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            cs.execute();
            ((Application)m).LoadSponsor();
            dispose();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox cbExpo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtSpDes;
    private javax.swing.JTextField txtSpID;
    private javax.swing.JTextField txtSpMoney;
    private javax.swing.JTextField txtSpName;
    // End of variables declaration//GEN-END:variables

}
