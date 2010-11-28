/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on 12-11-2010, 02:04:10
 */

package expomanagement;

import booth.Addbooths;
import booth.Editbooths;
import booth.OperationBooths;
import boothType.AddboothType;
import boothType.EditboothType;
import boothType.OperationBoothType;
import exhibitor.AddExhibitor;
import exhibitor.EditExhibitor;
import exhibitor.OperationExhibitor;
import expo.AddExpo;
import expo.EditExpo;
import expo.OperationExpo;
import java.awt.Frame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import product.AddProduct;
import product.EditProduct;
import product.OperationProduct;
import sponsor.AddSponsor;
import sponsor.EditSponsor;
import sponsor.OperationSponsor;
import staff.AddStaff;
import staff.EditStaff;
import staff.OperationStaff;
import user.AddUser;
import user.EditUser;
import user.OperationUser;

/**
 *
 * @author Hse7en
 */
public class Main extends javax.swing.JFrame {

    /** Creates new form Main */
    OperationExpo oe = new OperationExpo();
    OperationExhibitor oex = new OperationExhibitor();
    OperationProduct op = new OperationProduct();
    OperationBoothType obt = new OperationBoothType();
    OperationSponsor os = new OperationSponsor();
    OperationBooths ob = new OperationBooths();
    OperationStaff ost = new OperationStaff();
    OperationUser ou = new OperationUser();

    public Main() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        //this.dispose();
        //new Login(this,true).setVisible(true);
        initComponents();
        this.setExtendedState(Frame.MAXIMIZED_BOTH);


        //Event
        tblExpo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                int slcRow = tblExpo.getSelectedRow();
                if(slcRow >= 0){
                    btnDelete.setEnabled(true);
                    btnEdit.setEnabled(true);
                }
                else{
                    btnDelete.setEnabled(false);
                    btnEdit.setEnabled(false);
                }
            }
        });
        tblSponsor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                int slcRow = tblSponsor.getSelectedRow();
                if(slcRow >= 0){
                    btnDeleteS.setEnabled(true);
                    btnEditS.setEnabled(true);
                }
                else{
                    btnDeleteS.setEnabled(false);
                    btnEditS.setEnabled(false);
                }
            }
        });
        tblBoothType.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                int slcRow = tblBoothType.getSelectedRow();
                if(slcRow >= 0){
                    btnDeleteBT.setEnabled(true);
                    btnEditBT.setEnabled(true);
                }
                else{
                    btnDeleteBT.setEnabled(false);
                    btnEditBT.setEnabled(false);
                }
            }
        });
        tblBooth.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                int slcRow = tblBooth.getSelectedRow();
                if(slcRow >= 0){
                    btnDeleteB.setEnabled(true);
                    btnEditB.setEnabled(true);
                }
                else{
                    btnDeleteB.setEnabled(false);
                    btnEditB.setEnabled(false);
                }
            }
        });
        tblAccount.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                int slcRow = tblAccount.getSelectedRow();
                if(slcRow >= 0){
                    btnDeleteAcc.setEnabled(true);
                    btnEditAcc.setEnabled(true);
                }
                else{
                    btnDeleteAcc.setEnabled(false);
                    btnEditAcc.setEnabled(false);
                }
            }
        });
        tblStaff.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                int slcRow = tblStaff.getSelectedRow();
                if(slcRow >= 0){
                    btnDeleteStaff.setEnabled(true);
                    btnEditStaff.setEnabled(true);
                }
                else{
                    btnDeleteStaff.setEnabled(false);
                    btnEditStaff.setEnabled(false);
                }
            }
        });
        tblProducts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                int slcRow = tblProducts.getSelectedRow();
                if(slcRow >= 0){
                    btnDeleteP.setEnabled(true);
                    btnEditP.setEnabled(true);
                }
                else{
                    btnDeleteP.setEnabled(false);
                    btnEditP.setEnabled(false);
                }
            }
        });
        tblExhibitor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                int slcRow = tblExhibitor.getSelectedRow();
                if(slcRow >= 0){
                    btnEditEx.setEnabled(true);
                    btnDeleteEx.setEnabled(true);
                }
                else{
                    btnEditEx.setEnabled(false);
                    btnDeleteEx.setEnabled(false);
                }
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

        jPanel2 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        mainTab = new javax.swing.JTabbedPane();
        TabHome = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        TabManager = new javax.swing.JPanel();
        SubTabManager = new javax.swing.JTabbedPane();
        TabExpo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbWhereExpo = new javax.swing.JComboBox();
        txtFindExpo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpo = new javax.swing.JTable();
        TabBoothType = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnAddBT1 = new javax.swing.JButton();
        btnEditBT = new javax.swing.JButton();
        btnDeleteBT = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbWhereBT = new javax.swing.JComboBox();
        txtFindBT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblBoothType = new javax.swing.JTable();
        TabBooth = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnAddB = new javax.swing.JButton();
        btnEditB = new javax.swing.JButton();
        btnDeleteB = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbWhereBooth = new javax.swing.JComboBox();
        txtFindBooth = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblBooth = new javax.swing.JTable();
        TabAccount = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        btnAddAcc = new javax.swing.JButton();
        btnEditAcc = new javax.swing.JButton();
        btnDeleteAcc = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbWhereUser = new javax.swing.JComboBox();
        txtFindUser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();
        STabExhibitor = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnAddEx = new javax.swing.JButton();
        btnEditEx = new javax.swing.JButton();
        btnDeleteEx = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbEx = new javax.swing.JComboBox();
        txtFindEhi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblExhibitor = new javax.swing.JTable();
        TabExhibitor = new javax.swing.JPanel();
        SubTabExhibitor = new javax.swing.JTabbedPane();
        TabSponsor = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnAddS = new javax.swing.JButton();
        btnEditS = new javax.swing.JButton();
        btnDeleteS = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbWhereSp = new javax.swing.JComboBox();
        txtSponsor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSponsor = new javax.swing.JTable();
        TabStaff = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        btnAddStaff = new javax.swing.JButton();
        btnEditStaff = new javax.swing.JButton();
        btnDeleteStaff = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbWhereStaff = new javax.swing.JComboBox();
        txtFindStaff = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();
        TabProduct = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnAddP = new javax.swing.JButton();
        btnEditP = new javax.swing.JButton();
        btnDeleteP = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbWhereP = new javax.swing.JComboBox();
        txtPKeyword = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        TabContact = new javax.swing.JPanel();

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Expo Management System");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        txtTitle.setText("Expo Managenment System");

        mainTab.setFont(new java.awt.Font("Tahoma", 0, 14));

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTextArea1.setRows(5);
        jTextArea1.setText("\n Welcome !\n You using software of Team 1 - GC0501 - FPT GreenWich.\n Hope you work efficiently.\n Thank you for using our software.");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout TabHomeLayout = new org.jdesktop.layout.GroupLayout(TabHome);
        TabHome.setLayout(TabHomeLayout);
        TabHomeLayout.setHorizontalGroup(
            TabHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabHomeLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        TabHomeLayout.setVerticalGroup(
            TabHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabHomeLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTab.addTab("Home", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/home.png")), TabHome); // NOI18N

        SubTabManager.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        SubTabManager.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TabExpo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabExpo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TabExpo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabExpoPropertyChange(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Filter");

        cbWhereExpo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtFindExpo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFindExpoCaretUpdate(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(btnAdd)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEdit)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDelete)
                .add(18, 18, 18)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbWhereExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFindExpo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel16)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAdd)
                    .add(btnEdit)
                    .add(btnDelete)
                    .add(jLabel1)
                    .add(cbWhereExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtFindExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel16))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Expo List"));

        tblExpo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblExpo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblExpo);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabExpoLayout = new org.jdesktop.layout.GroupLayout(TabExpo);
        TabExpo.setLayout(TabExpoLayout);
        TabExpoLayout.setHorizontalGroup(
            TabExpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TabExpoLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabExpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabExpoLayout.setVerticalGroup(
            TabExpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabExpoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        SubTabManager.addTab(" Expo         ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/expo.png")), TabExpo); // NOI18N

        TabBoothType.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabBoothTypePropertyChange(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        btnAddBT1.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAddBT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAddBT1.setText("Add");
        btnAddBT1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnAddBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBT1ActionPerformed(evt);
            }
        });

        btnEditBT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEditBT.setText("Edit");
        btnEditBT.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBTActionPerformed(evt);
            }
        });

        btnDeleteBT.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteBT.setText("Delete");
        btnDeleteBT.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnDeleteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBTActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel4.setText("Filter");

        cbWhereBT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtFindBT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFindBTCaretUpdate(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(btnAddBT1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEditBT)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDeleteBT)
                .add(18, 18, 18)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbWhereBT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFindBT, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel12)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAddBT1)
                    .add(btnEditBT)
                    .add(btnDeleteBT)
                    .add(jLabel4)
                    .add(cbWhereBT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtFindBT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel12))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("BoothType List"));

        tblBoothType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBoothType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblBoothTypeFocusGained(evt);
            }
        });
        jScrollPane8.setViewportView(tblBoothType);

        org.jdesktop.layout.GroupLayout jPanel14Layout = new org.jdesktop.layout.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabBoothTypeLayout = new org.jdesktop.layout.GroupLayout(TabBoothType);
        TabBoothType.setLayout(TabBoothTypeLayout);
        TabBoothTypeLayout.setHorizontalGroup(
            TabBoothTypeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TabBoothTypeLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabBoothTypeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabBoothTypeLayout.setVerticalGroup(
            TabBoothTypeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabBoothTypeLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        SubTabManager.addTab(" Booth Type", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/organize.png")), TabBoothType); // NOI18N

        TabBooth.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabBooth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabBoothPropertyChange(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        btnAddB.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAddB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAddB.setText("Add");
        btnAddB.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnAddB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBActionPerformed(evt);
            }
        });

        btnEditB.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEditB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEditB.setText("Edit");
        btnEditB.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBActionPerformed(evt);
            }
        });

        btnDeleteB.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteB.setText("Delete");
        btnDeleteB.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnDeleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel5.setText("Filter");

        cbWhereBooth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtFindBooth.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFindBoothCaretUpdate(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel10Layout = new org.jdesktop.layout.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel10Layout.createSequentialGroup()
                .add(btnAddB)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEditB)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDeleteB)
                .add(18, 18, 18)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbWhereBooth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFindBooth, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel11)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel10Layout.createSequentialGroup()
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAddB)
                    .add(btnEditB)
                    .add(btnDeleteB)
                    .add(jLabel5)
                    .add(cbWhereBooth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtFindBooth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel11))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Booth List"));

        tblBooth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblBooth);

        org.jdesktop.layout.GroupLayout jPanel13Layout = new org.jdesktop.layout.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabBoothLayout = new org.jdesktop.layout.GroupLayout(TabBooth);
        TabBooth.setLayout(TabBoothLayout);
        TabBoothLayout.setHorizontalGroup(
            TabBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabBoothLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabBoothLayout.setVerticalGroup(
            TabBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabBoothLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        SubTabManager.addTab(" Booth         ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/booth.png")), TabBooth); // NOI18N

        TabAccount.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabAccountPropertyChange(evt);
            }
        });

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        btnAddAcc.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAddAcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAddAcc.setText("Add");
        btnAddAcc.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnAddAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAccActionPerformed(evt);
            }
        });

        btnEditAcc.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEditAcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEditAcc.setText("Edit");
        btnEditAcc.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAccActionPerformed(evt);
            }
        });

        btnDeleteAcc.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteAcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteAcc.setText("Delete");
        btnDeleteAcc.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnDeleteAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAccActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel7.setText("Filter");

        cbWhereUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtFindUser.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFindUserCaretUpdate(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel15Layout = new org.jdesktop.layout.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel15Layout.createSequentialGroup()
                .add(btnAddAcc)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEditAcc)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDeleteAcc)
                .add(18, 18, 18)
                .add(jLabel7)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbWhereUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFindUser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel9)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel15Layout.createSequentialGroup()
                .add(jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAddAcc)
                    .add(btnEditAcc)
                    .add(btnDeleteAcc)
                    .add(jLabel7)
                    .add(cbWhereUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtFindUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Account List"));

        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblAccount);

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabAccountLayout = new org.jdesktop.layout.GroupLayout(TabAccount);
        TabAccount.setLayout(TabAccountLayout);
        TabAccountLayout.setHorizontalGroup(
            TabAccountLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabAccountLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabAccountLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabAccountLayout.setVerticalGroup(
            TabAccountLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabAccountLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(17, 17, 17))
        );

        SubTabManager.addTab(" Account     ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/users.png")), TabAccount); // NOI18N

        STabExhibitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                STabExhibitorPropertyChange(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        btnAddEx.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAddEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAddEx.setText("Add");
        btnAddEx.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnAddEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExActionPerformed(evt);
            }
        });

        btnEditEx.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEditEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEditEx.setText("Edit");
        btnEditEx.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditExActionPerformed(evt);
            }
        });

        btnDeleteEx.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteEx.setText("Delete");
        btnDeleteEx.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnDeleteEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteExActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setText("Filter");

        cbEx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtFindEhi.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFindEhiCaretUpdate(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(btnAddEx)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEditEx)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDeleteEx)
                .add(18, 18, 18)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbEx, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFindEhi, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel10)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAddEx)
                    .add(btnEditEx)
                    .add(btnDeleteEx)
                    .add(jLabel3)
                    .add(cbEx, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtFindEhi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Exhibitor List"));

        tblExhibitor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblExhibitor);

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout STabExhibitorLayout = new org.jdesktop.layout.GroupLayout(STabExhibitor);
        STabExhibitor.setLayout(STabExhibitorLayout);
        STabExhibitorLayout.setHorizontalGroup(
            STabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(STabExhibitorLayout.createSequentialGroup()
                .addContainerGap()
                .add(STabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        STabExhibitorLayout.setVerticalGroup(
            STabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(STabExhibitorLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(39, 39, 39))
        );

        SubTabManager.addTab(" Exhibitor    ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/exhibitor_man.png")), STabExhibitor); // NOI18N

        org.jdesktop.layout.GroupLayout TabManagerLayout = new org.jdesktop.layout.GroupLayout(TabManager);
        TabManager.setLayout(TabManagerLayout);
        TabManagerLayout.setHorizontalGroup(
            TabManagerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabManagerLayout.createSequentialGroup()
                .add(SubTabManager, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
        );
        TabManagerLayout.setVerticalGroup(
            TabManagerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabManagerLayout.createSequentialGroup()
                .add(SubTabManager, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTab.addTab("Manager", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/administrator.png")), TabManager); // NOI18N

        SubTabExhibitor.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        SubTabExhibitor.setFont(new java.awt.Font("Tahoma", 0, 12));

        TabSponsor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabSponsorPropertyChange(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        btnAddS.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAddS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAddS.setText("Add");
        btnAddS.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnAddS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSActionPerformed(evt);
            }
        });

        btnEditS.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEditS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEditS.setText("Edit");
        btnEditS.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSActionPerformed(evt);
            }
        });

        btnDeleteS.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteS.setText("Delete");
        btnDeleteS.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnDeleteS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel6.setText("Filter");

        cbWhereSp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtSponsor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSponsorCaretUpdate(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .add(btnAddS)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEditS)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDeleteS)
                .add(18, 18, 18)
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbWhereSp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtSponsor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel15)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAddS)
                    .add(btnDeleteS)
                    .add(jLabel6)
                    .add(cbWhereSp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtSponsor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnEditS)
                    .add(jLabel15))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Sponsor List"));

        tblSponsor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblSponsor);

        org.jdesktop.layout.GroupLayout jPanel12Layout = new org.jdesktop.layout.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabSponsorLayout = new org.jdesktop.layout.GroupLayout(TabSponsor);
        TabSponsor.setLayout(TabSponsorLayout);
        TabSponsorLayout.setHorizontalGroup(
            TabSponsorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TabSponsorLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabSponsorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabSponsorLayout.setVerticalGroup(
            TabSponsorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabSponsorLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        SubTabExhibitor.addTab(" Sponsor      ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/sponsor.png")), TabSponsor); // NOI18N

        TabStaff.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabStaffPropertyChange(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        btnAddStaff.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAddStaff.setText("Add");
        btnAddStaff.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffActionPerformed(evt);
            }
        });

        btnEditStaff.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEditStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEditStaff.setText("Edit");
        btnEditStaff.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditStaffActionPerformed(evt);
            }
        });

        btnDeleteStaff.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteStaff.setText("Delete");
        btnDeleteStaff.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnDeleteStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStaffActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel8.setText("Filter");

        cbWhereStaff.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtFindStaff.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFindStaffCaretUpdate(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel16Layout = new org.jdesktop.layout.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel16Layout.createSequentialGroup()
                .add(btnAddStaff)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEditStaff)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDeleteStaff)
                .add(18, 18, 18)
                .add(jLabel8)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbWhereStaff, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFindStaff, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel13)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel16Layout.createSequentialGroup()
                .add(jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAddStaff)
                    .add(btnEditStaff)
                    .add(btnDeleteStaff)
                    .add(jLabel8)
                    .add(cbWhereStaff, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtFindStaff, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel13))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Staff List"));

        tblStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tblStaff);

        org.jdesktop.layout.GroupLayout jPanel19Layout = new org.jdesktop.layout.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabStaffLayout = new org.jdesktop.layout.GroupLayout(TabStaff);
        TabStaff.setLayout(TabStaffLayout);
        TabStaffLayout.setHorizontalGroup(
            TabStaffLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabStaffLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabStaffLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel19, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel16, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabStaffLayout.setVerticalGroup(
            TabStaffLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabStaffLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel19, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(24, 24, 24))
        );

        SubTabExhibitor.addTab(" Staff           ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/staff.png")), TabStaff); // NOI18N

        TabProduct.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabProductPropertyChange(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        btnAddP.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAddP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAddP.setText("Add");
        btnAddP.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnAddP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPActionPerformed(evt);
            }
        });

        btnEditP.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEditP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEditP.setText("Edit");
        btnEditP.setEnabled(false);
        btnEditP.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPActionPerformed(evt);
            }
        });

        btnDeleteP.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteP.setText("Delete");
        btnDeleteP.setEnabled(false);
        btnDeleteP.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnDeleteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Filter");

        cbWhereP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtPKeyword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPKeywordCaretUpdate(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(btnAddP)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEditP)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDeleteP)
                .add(18, 18, 18)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbWhereP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtPKeyword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel14)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAddP)
                    .add(btnEditP)
                    .add(btnDeleteP)
                    .add(jLabel2)
                    .add(cbWhereP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtPKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel14))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Product List"));

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Product Number", "Product Price", "Description", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane.setViewportView(tblProducts);

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabProductLayout = new org.jdesktop.layout.GroupLayout(TabProduct);
        TabProduct.setLayout(TabProductLayout);
        TabProductLayout.setHorizontalGroup(
            TabProductLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TabProductLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabProductLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabProductLayout.setVerticalGroup(
            TabProductLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabProductLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(24, 24, 24))
        );

        SubTabExhibitor.addTab(" Product       ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/product.png")), TabProduct); // NOI18N

        org.jdesktop.layout.GroupLayout TabExhibitorLayout = new org.jdesktop.layout.GroupLayout(TabExhibitor);
        TabExhibitor.setLayout(TabExhibitorLayout);
        TabExhibitorLayout.setHorizontalGroup(
            TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 750, Short.MAX_VALUE)
            .add(TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(TabExhibitorLayout.createSequentialGroup()
                    .add(SubTabExhibitor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        TabExhibitorLayout.setVerticalGroup(
            TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 380, Short.MAX_VALUE)
            .add(TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, SubTabExhibitor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        );

        mainTab.addTab("Exhibitor", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/exhibitor.png")), TabExhibitor); // NOI18N

        org.jdesktop.layout.GroupLayout TabContactLayout = new org.jdesktop.layout.GroupLayout(TabContact);
        TabContact.setLayout(TabContactLayout);
        TabContactLayout.setHorizontalGroup(
            TabContactLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 750, Short.MAX_VALUE)
        );
        TabContactLayout.setVerticalGroup(
            TabContactLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 380, Short.MAX_VALUE)
        );

        mainTab.addTab("Contact", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/contact.png")), TabContact); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtTitle)
                    .add(mainTab, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(txtTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mainTab, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tblExpo.getSelectedRow();
        int id = Integer.parseInt(tblExpo.getValueAt(row, 0).toString());
        oe.delExpo(id);
        LoadExpo();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        new AddExpo(this, true).setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPActionPerformed
        // TODO add your handling code here:
        new AddProduct(this,true).setVisible(true);
    }//GEN-LAST:event_btnAddPActionPerformed

    private void btnAddExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExActionPerformed
        // TODO add your handling code here:
        new AddExhibitor(this,true).setVisible(true);
    }//GEN-LAST:event_btnAddExActionPerformed

    private void btnEditExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditExActionPerformed
        // TODO add your handling code here:
        new EditExhibitor(this,true).setVisible(true);
    }//GEN-LAST:event_btnEditExActionPerformed


    private void btnAddBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBT1ActionPerformed
        // TODO add your handling code here:
        new AddboothType(this, true).setVisible(true);
    }//GEN-LAST:event_btnAddBT1ActionPerformed

    private void btnAddBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBActionPerformed
        // TODO add your handling code here:
        new Addbooths(this, true).setVisible(true);

    }//GEN-LAST:event_btnAddBActionPerformed

    private void btnAddSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSActionPerformed
        // TODO add your handling code here:
        new AddSponsor(this,true).setVisible(true);
    }//GEN-LAST:event_btnAddSActionPerformed

    private void btnEditSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSActionPerformed
        // TODO add your handling code here:
        new EditSponsor(this,true).setVisible(true);
    }//GEN-LAST:event_btnEditSActionPerformed

    private void STabExhibitorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_STabExhibitorPropertyChange
        // TODO add your handling code here:
        LoadExhibitor();
        oex.buildCbEx(cbEx);
    }//GEN-LAST:event_STabExhibitorPropertyChange

    private void TabSponsorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabSponsorPropertyChange
        // TODO add your handling code here:
        LoadSponsor();
        os.buildCbWhereSp(cbWhereSp);
    }//GEN-LAST:event_TabSponsorPropertyChange

    private void btnEditPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPActionPerformed
        // TODO add your handling code here:
        new EditProduct(this,true).setVisible(true);
    }//GEN-LAST:event_btnEditPActionPerformed

    private void TabBoothTypePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabBoothTypePropertyChange
        // TODO add your handling code here:
        LoadBoothType();
        obt.buildCbWhereP(cbWhereBT);
    }//GEN-LAST:event_TabBoothTypePropertyChange

    private void TabBoothPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabBoothPropertyChange
        // TODO add your handling code here:
        LoadBooth();
        ob.buildCbWhereB(cbWhereBooth);
    }//GEN-LAST:event_TabBoothPropertyChange

    private void TabAccountPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabAccountPropertyChange
        // TODO add your handling code here:
        LoadAccount();
        ou.buildCbUs(cbWhereUser);
    }//GEN-LAST:event_TabAccountPropertyChange

    private void TabStaffPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabStaffPropertyChange
        // TODO add your handling code here:
        LoadStaff();
        ost.buildCbStaff(cbWhereStaff);
    }//GEN-LAST:event_TabStaffPropertyChange

    private void TabProductPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabProductPropertyChange
        // TODO add your handling code here:
        LoadProduct();
        op.buildCbWhereP(cbWhereP);
    }//GEN-LAST:event_TabProductPropertyChange

    private void btnEditBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBTActionPerformed
        // TODO add your handling code here:
        new EditboothType(this, true).setVisible(true);
    }//GEN-LAST:event_btnEditBTActionPerformed

    private void btnEditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBActionPerformed
        // TODO add your handling code here:
        new Editbooths(this, true).setVisible(true);
    }//GEN-LAST:event_btnEditBActionPerformed

    private void btnDeletePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePActionPerformed
        // TODO add your handling code here:
        int row = tblProducts.getSelectedRow();
        int id = Integer.parseInt(tblProducts.getValueAt(row, 0).toString());
        op.delProducts(id);
        LoadProduct();
    }//GEN-LAST:event_btnDeletePActionPerformed

    private void txtPKeywordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPKeywordCaretUpdate
        // TODO add your handling code here:
        String keyword = txtPKeyword.getText().trim();
        keyword.replace(" ", "%");
        op.doSearch(op.returnSearch(cbWhereP),keyword,tblProducts);
    }//GEN-LAST:event_txtPKeywordCaretUpdate

    private void txtFindEhiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindEhiCaretUpdate
        // TODO add your handling code here:
        String keyword = txtFindEhi.getText().trim();
        keyword.replace(" ", "%");
        oex.doSearch(oex.returnSearch(cbEx),keyword,tblExhibitor);
    }//GEN-LAST:event_txtFindEhiCaretUpdate

    private void btnDeleteExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteExActionPerformed
        // TODO add your handling code here:
        int row = tblExhibitor.getSelectedRow();
        int id = Integer.parseInt(tblExhibitor.getValueAt(row, 0).toString());
        oex.delExhibitor(id);
        LoadExhibitor();
    }//GEN-LAST:event_btnDeleteExActionPerformed

    private void btnDeleteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBTActionPerformed
        // TODO add your handling code here:
        int row = tblBoothType.getSelectedRow();
        int id = Integer.parseInt(tblBoothType.getValueAt(row, 0).toString());
        obt.delBoothType(id);
        LoadBoothType();
    }//GEN-LAST:event_btnDeleteBTActionPerformed

    private void txtFindBTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindBTCaretUpdate
        // TODO add your handling code here:
        String keyword = txtFindBT.getText().trim();
        keyword.replace(" ", "%");
        obt.doSearch(obt.returnSearch(cbWhereBT),keyword,tblBoothType);

    }//GEN-LAST:event_txtFindBTCaretUpdate

    private void btnDeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBActionPerformed
        // TODO add your handling code here:
        int row = tblBooth.getSelectedRow();
        int id = Integer.parseInt(tblBooth.getValueAt(row, 1).toString());
        ob.delBooth(id);
        LoadBooth();

    }//GEN-LAST:event_btnDeleteBActionPerformed

    private void txtFindBoothCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindBoothCaretUpdate
        // TODO add your handling code here:
        String keyword = txtFindBooth.getText().trim();
        keyword.replace(" ", "%");
        ob.doSearch(ob.returnSearch(cbWhereBooth),keyword,tblBooth);
    }//GEN-LAST:event_txtFindBoothCaretUpdate

    private void tblBoothTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblBoothTypeFocusGained
        // TODO add your handling code here:
        btnDeleteBT.setEnabled(true);
        btnEditBT.setEnabled(true);
    }//GEN-LAST:event_tblBoothTypeFocusGained

    private void btnAddAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccActionPerformed
        // TODO add your handling code here:
        new AddUser(this, true).setVisible(true);
    }//GEN-LAST:event_btnAddAccActionPerformed

    private void btnEditAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAccActionPerformed
        // TODO add your handling code here:
        new EditUser(this, true).setVisible(true);
    }//GEN-LAST:event_btnEditAccActionPerformed

    private void btnDeleteAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccActionPerformed
        // TODO add your handling code here:
        int row = tblAccount.getSelectedRow();
        String Name = tblAccount.getValueAt(row, 0).toString();
        ou.delUser(Name);
        LoadAccount();
    }//GEN-LAST:event_btnDeleteAccActionPerformed

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
        // TODO add your handling code here:
        new AddStaff(this, true).setVisible(true);
    }//GEN-LAST:event_btnAddStaffActionPerformed

    private void btnEditStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditStaffActionPerformed
        // TODO add your handling code here:
        new EditStaff(this, true).setVisible(true);
    }//GEN-LAST:event_btnEditStaffActionPerformed

    private void btnDeleteStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStaffActionPerformed
        // TODO add your handling code here:
        int row = tblStaff.getSelectedRow();
        int id = Integer.parseInt(tblStaff.getValueAt(row, 0).toString());
        ost.delStaff(id);
        LoadStaff();
    }//GEN-LAST:event_btnDeleteStaffActionPerformed

    private void txtFindUserCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindUserCaretUpdate
        // TODO add your handling code here:
        String keyword = txtFindUser.getText().trim();
        keyword.replace(" ", "%");
        ou.doSearch(ou.returnSearch(cbWhereUser),keyword,tblAccount);
    }//GEN-LAST:event_txtFindUserCaretUpdate

    private void txtFindStaffCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindStaffCaretUpdate
        // TODO add your handling code here:
        String keyword = txtFindStaff.getText().trim();
        keyword.replace(" ", "%");
        ost.doSearch(ost.returnSearch(cbWhereStaff),keyword,tblStaff);
    }//GEN-LAST:event_txtFindStaffCaretUpdate

    private void txtFindExpoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindExpoCaretUpdate
        // TODO add your handling code here:
        String keyword = txtFindExpo.getText().trim();
        keyword.replace(" ", "%");
        oe.doSearch(oe.returnSearch(cbWhereExpo),keyword,tblExpo);
    }//GEN-LAST:event_txtFindExpoCaretUpdate

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        new EditExpo(this, true).setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSActionPerformed
        // TODO add your handling code here:
        int row = tblSponsor.getSelectedRow();
        int id = Integer.parseInt(tblSponsor.getValueAt(row, 0).toString());
        os.delSponsor(id);
        LoadSponsor();
    }//GEN-LAST:event_btnDeleteSActionPerformed

    private void txtSponsorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSponsorCaretUpdate
        // TODO add your handling code here:
        String keyword = txtSponsor.getText().trim();
        keyword.replace(" ", "%");
        os.doSearch(os.returnSearch(cbWhereSp),keyword,tblSponsor);
    }//GEN-LAST:event_txtSponsorCaretUpdate

    private void TabExpoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabExpoPropertyChange
        // TODO add your handling code here:
        LoadExpo();
        oe.buildCbWhereEx(cbWhereExpo);
}//GEN-LAST:event_TabExpoPropertyChange


    public void LoadExpo()
    {
        oe.loadAllExpo(tblExpo);
    }
    public JTable getExpoTable()
    {
        return tblExpo;
    }
    public void LoadBoothType()
    {
        obt.loadAllBoothType(tblBoothType);
    }
    public JTable getBoothTypeTable(){
        return tblBoothType;
    }
    public void LoadBooth()
    {
        ob.loadAllBooths(tblBooth);
    }
    public JTable getBoothTable(){
        return tblBooth;
    }
    public void LoadStaff()
    {
        ost.loadAllStaff(tblStaff);
    }
    public JTable getStaffTable(){
        return tblStaff;
    }
    public void LoadAccount()
    {
        ou.loadAllUser(tblAccount);
    }
    public JTable getAccountTable(){
        return tblAccount;
    }
    public void LoadProduct()
    {
        op.loadAllProduct(tblProducts);
    }
    public JTable getProductsTable(){
        return tblProducts;
    }
    public void LoadExhibitor()
    {
        oex.loadAllExhibitor(tblExhibitor);
    }
    public JTable getExhibitorTable(){
        return tblExhibitor;
    }
    public void LoadSponsor()
    {
        os.loadAllSponsor(tblSponsor);
    }
    public JTable getSponsorTable(){
        return tblSponsor;
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel STabExhibitor;
    private javax.swing.JTabbedPane SubTabExhibitor;
    private javax.swing.JTabbedPane SubTabManager;
    private javax.swing.JPanel TabAccount;
    private javax.swing.JPanel TabBooth;
    private javax.swing.JPanel TabBoothType;
    private javax.swing.JPanel TabContact;
    private javax.swing.JPanel TabExhibitor;
    private javax.swing.JPanel TabExpo;
    private javax.swing.JPanel TabHome;
    private javax.swing.JPanel TabManager;
    private javax.swing.JPanel TabProduct;
    private javax.swing.JPanel TabSponsor;
    private javax.swing.JPanel TabStaff;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddAcc;
    private javax.swing.JButton btnAddB;
    private javax.swing.JButton btnAddBT1;
    private javax.swing.JButton btnAddEx;
    private javax.swing.JButton btnAddP;
    private javax.swing.JButton btnAddS;
    private javax.swing.JButton btnAddStaff;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteAcc;
    private javax.swing.JButton btnDeleteB;
    private javax.swing.JButton btnDeleteBT;
    private javax.swing.JButton btnDeleteEx;
    private javax.swing.JButton btnDeleteP;
    private javax.swing.JButton btnDeleteS;
    private javax.swing.JButton btnDeleteStaff;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditAcc;
    private javax.swing.JButton btnEditB;
    private javax.swing.JButton btnEditBT;
    private javax.swing.JButton btnEditEx;
    private javax.swing.JButton btnEditP;
    private javax.swing.JButton btnEditS;
    private javax.swing.JButton btnEditStaff;
    private javax.swing.JComboBox cbEx;
    private javax.swing.JComboBox cbWhereBT;
    private javax.swing.JComboBox cbWhereBooth;
    private javax.swing.JComboBox cbWhereExpo;
    private javax.swing.JComboBox cbWhereP;
    private javax.swing.JComboBox cbWhereSp;
    private javax.swing.JComboBox cbWhereStaff;
    private javax.swing.JComboBox cbWhereUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JTable tblAccount;
    private javax.swing.JTable tblBooth;
    private javax.swing.JTable tblBoothType;
    private javax.swing.JTable tblExhibitor;
    private javax.swing.JTable tblExpo;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTable tblSponsor;
    private javax.swing.JTable tblStaff;
    private javax.swing.JTextField txtFindBT;
    private javax.swing.JTextField txtFindBooth;
    private javax.swing.JTextField txtFindEhi;
    private javax.swing.JTextField txtFindExpo;
    private javax.swing.JTextField txtFindStaff;
    private javax.swing.JTextField txtFindUser;
    private javax.swing.JTextField txtPKeyword;
    private javax.swing.JTextField txtSponsor;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables

}
