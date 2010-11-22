/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditProduct.java
 *
 * Created on 14-11-2010, 06:56:01
 */

package product;

import booth.OperationBooths;
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
 * @author Cuongnvgc00064
 */
public class EditProduct extends javax.swing.JDialog {

    /** Creates new form EditProduct */
    Main m = null;
    Frame parentFrame = null;
    OperationProduct op = new OperationProduct();
    OperationBooths ob  = new OperationBooths();
    public EditProduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        op.buildCbExpo(cbExpo);
        op.buildCbContact(cbContact);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbContact = new javax.swing.JComboBox();
        cbExpo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Product");

        jLabel1.setText("Product Name");

        jLabel2.setText("Product Price");

        jLabel3.setText("Product Number");

        jLabel4.setText("Description");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/22.png"))); // NOI18N
        btnAdd.setText("Save");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/33.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/76.png"))); // NOI18N
        btnReset.setText("Cancel");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("Edit Product");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jLabel7.setText("Exhibitor ID");

        jLabel8.setText("Contact ID");

        cbContact.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbExpo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(46, 46, 46)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel4)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel1)
                            .add(jLabel2)
                            .add(jLabel8)
                            .add(jLabel7))
                        .add(3, 3, 3))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(btnAdd)
                        .add(jLabel3)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtPrice, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, cbContact, 0, 197, Short.MAX_VALUE)
                            .add(cbExpo, 0, 197, Short.MAX_VALUE))
                        .add(72, 72, 72))
                    .add(layout.createSequentialGroup()
                        .add(46, 46, 46)
                        .add(btnReset)
                        .add(43, 43, 43)
                        .add(btnClose)
                        .add(38, 38, 38))))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .add(jLabel6)
                .add(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel6)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(cbExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel8)
                            .add(cbContact, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1))
                        .add(18, 18, 18)
                        .add(txtPrice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jLabel2))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(33, 33, 33)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAdd)
                    .add(btnReset)
                    .add(btnClose))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
        DBHelper db = null;
        db = new DBHelper();
        db.openConnection();
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String DateP = sdf.format(today);
        
        String EID = cbContact.getSelectedItem().toString().trim();
        String CID = cbContact.getSelectedItem().toString().trim();
        String name = txtName.getText().trim();
        float price = Float.parseFloat(txtPrice.getText().trim());
        int number = Integer.parseInt(txtNumber.getText().trim());
        String description = txtDescription.getText();

        //tao giao dien de thuc thi store
        CallableStatement cs = db.getConnection().prepareCall("{call EditProduct(?,?,?,?,?,?,?)}");
        //truyen tham so cho store
        cs.setString(1, EID);
        cs.setString(2, CID);
        cs.setString(3, name);
        cs.setFloat(4, price);
        cs.setInt(5, number);
        cs.setString(6, description);
        cs.setString(7,DateP);
        //thuc thi store
        if(checkformProduct())
        {
        if(JOptionPane.showConfirmDialog(null, "Do you want to Save the Product(s)",
                "Save Product",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        cs.execute();
        ((Main)parentFrame).LoadProduct();
            JOptionPane.showMessageDialog(null, "The Product(s) has been Edit","Edit Product",JOptionPane.INFORMATION_MESSAGE);
         }
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error occurred during execution,Please check again !","Edit Product",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        cbExpo.setSelectedItem(0);
        cbContact.setSelectedItem(0);
        txtName.setText(null);
        txtPrice.setText(null);
        txtNumber.setText(null);
        txtDescription.setText(null);

        cbExpo.setEditable(true);
        txtName.setEditable(true);
        txtPrice.setEditable(true);
        txtNumber.setEditable(true);
        txtDescription.setEditable(true);
        txtName.requestFocus();
    }//GEN-LAST:event_btnResetActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddProduct dialog = new AddProduct(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox cbContact;
    private javax.swing.JComboBox cbExpo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    private boolean checkformProduct(){
        if(cbExpo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(this,"Please,Enter EID");
            cbExpo.requestFocus();
            return false;
        }
        if(txtName.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please,Enter Name of Product");
            txtName.requestFocus();
            return false;
        }
        if(txtPrice.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please,Enter Product Price");
            txtPrice.requestFocus();
            return false;
        }
        if(txtNumber.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please,Enter Product Number");
            txtNumber.requestFocus();
            return false;
        }
        try {
            Long.parseLong(txtNumber.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Product NumBer must Number");
            return false;
        }
        if(txtDescription.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please,Enter Description");
            txtDescription.requestFocus();
            return false;
        }
        return true;
    }
}