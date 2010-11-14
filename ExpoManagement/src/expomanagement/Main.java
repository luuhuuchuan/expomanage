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

import exhibitor.AddExhibitor;
import exhibitor.EditExhibitor;
import exhibitor.OperationExhibitor;
import expo.AddExpo;
import expo.OperationExpo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import product.AddProduct;
import product.OperationProduct;

/**
 *
 * @author Hse7en
 */
public class Main extends javax.swing.JFrame {

    /** Creates new form Main */
    OperationExpo oe = new OperationExpo();
    OperationExhibitor oex = new OperationExhibitor();
    OperationProduct op = new OperationProduct();
    public Main() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        oe.loadAllExpo(tblExpo);
        oex.loadAllExhibitor(tblExhibitor);
        op.loadAllProduct(tblProducts);
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
        cbWhere = new javax.swing.JComboBox();
        txtKeyword = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpo = new javax.swing.JTable();
        TabBoothType = new javax.swing.JPanel();
        TabBooth = new javax.swing.JPanel();
        TabAccount = new javax.swing.JPanel();
        STabExhibitor = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnAddEx = new javax.swing.JButton();
        btnEditEx = new javax.swing.JButton();
        btnDeleteEx = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbWhereEx = new javax.swing.JComboBox();
        txtFind = new javax.swing.JTextField();
        btnFindEx = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblExhibitor = new javax.swing.JTable();
        TabExhibitor = new javax.swing.JPanel();
        SubTabExhibitor = new javax.swing.JTabbedPane();
        TabSponsor = new javax.swing.JPanel();
        TabStaff = new javax.swing.JPanel();
        TabProduct = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnAddP = new javax.swing.JButton();
        btnEditP = new javax.swing.JButton();
        btnDeleteP = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbWhereP = new javax.swing.JComboBox();
        txtPKeyword = new javax.swing.JTextField();
        btnFindP = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
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

        txtTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        txtTitle.setText("Expo Managenment System");

        mainTab.setFont(new java.awt.Font("Tahoma", 0, 14));

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTextArea1.setRows(5);
        jTextArea1.setText("\n Welcome come !\n You using software of Team 1 - GC0501 - FPT GreenWich.\n Wish you to work efficiently.\n Thank you for using our software.");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout TabHomeLayout = new org.jdesktop.layout.GroupLayout(TabHome);
        TabHome.setLayout(TabHomeLayout);
        TabHomeLayout.setHorizontalGroup(
            TabHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabHomeLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
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
        SubTabManager.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/33.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Filter");

        cbWhere.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N
        btnFind.setText("Find");
        btnFind.setMargin(new java.awt.Insets(2, 4, 2, 4));

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
                .add(cbWhere, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtKeyword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnFind))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAdd)
                    .add(btnEdit)
                    .add(btnDelete)
                    .add(jLabel1)
                    .add(cbWhere, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnFind))
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
        jScrollPane1.setViewportView(tblExpo);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabExpoLayout = new org.jdesktop.layout.GroupLayout(TabExpo);
        TabExpo.setLayout(TabExpoLayout);
        TabExpoLayout.setHorizontalGroup(
            TabExpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabExpoLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabExpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabExpoLayout.setVerticalGroup(
            TabExpoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabExpoLayout.createSequentialGroup()
                .add(11, 11, 11)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(11, 11, 11))
        );

        SubTabManager.addTab("Expo", TabExpo);

        org.jdesktop.layout.GroupLayout TabBoothTypeLayout = new org.jdesktop.layout.GroupLayout(TabBoothType);
        TabBoothType.setLayout(TabBoothTypeLayout);
        TabBoothTypeLayout.setHorizontalGroup(
            TabBoothTypeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 523, Short.MAX_VALUE)
        );
        TabBoothTypeLayout.setVerticalGroup(
            TabBoothTypeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 364, Short.MAX_VALUE)
        );

        SubTabManager.addTab("Booth Type", TabBoothType);

        org.jdesktop.layout.GroupLayout TabBoothLayout = new org.jdesktop.layout.GroupLayout(TabBooth);
        TabBooth.setLayout(TabBoothLayout);
        TabBoothLayout.setHorizontalGroup(
            TabBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 523, Short.MAX_VALUE)
        );
        TabBoothLayout.setVerticalGroup(
            TabBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 364, Short.MAX_VALUE)
        );

        SubTabManager.addTab("Booth", TabBooth);

        org.jdesktop.layout.GroupLayout TabAccountLayout = new org.jdesktop.layout.GroupLayout(TabAccount);
        TabAccount.setLayout(TabAccountLayout);
        TabAccountLayout.setHorizontalGroup(
            TabAccountLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 523, Short.MAX_VALUE)
        );
        TabAccountLayout.setVerticalGroup(
            TabAccountLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 364, Short.MAX_VALUE)
        );

        SubTabManager.addTab("Account", TabAccount);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        btnAddEx.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAddEx.setText("Add");
        btnAddEx.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnAddEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExActionPerformed(evt);
            }
        });

        btnEditEx.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEditEx.setText("Edit");
        btnEditEx.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditExActionPerformed(evt);
            }
        });

        btnDeleteEx.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/33.png"))); // NOI18N
        btnDeleteEx.setText("Delete");
        btnDeleteEx.setMargin(new java.awt.Insets(2, 4, 2, 4));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setText("Filter");

        cbWhereEx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnFindEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N
        btnFindEx.setText("Find");
        btnFindEx.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnFindEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindExActionPerformed(evt);
            }
        });

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
                .add(cbWhereEx, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFind, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnFindEx))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAddEx)
                    .add(btnEditEx)
                    .add(btnDeleteEx)
                    .add(jLabel3)
                    .add(cbWhereEx, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtFind, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnFindEx))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Expo List"));

        tblExhibitor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Fax", "Phone", "Address", "Website"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblExhibitor);

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
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
                .add(16, 16, 16))
        );

        SubTabManager.addTab("Exhibitor", STabExhibitor);

        org.jdesktop.layout.GroupLayout TabManagerLayout = new org.jdesktop.layout.GroupLayout(TabManager);
        TabManager.setLayout(TabManagerLayout);
        TabManagerLayout.setHorizontalGroup(
            TabManagerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 626, Short.MAX_VALUE)
            .add(TabManagerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(TabManagerLayout.createSequentialGroup()
                    .add(SubTabManager, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        TabManagerLayout.setVerticalGroup(
            TabManagerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 380, Short.MAX_VALUE)
            .add(TabManagerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(TabManagerLayout.createSequentialGroup()
                    .add(SubTabManager, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        mainTab.addTab("Manager", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/administrator.png")), TabManager); // NOI18N

        SubTabExhibitor.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        SubTabExhibitor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        org.jdesktop.layout.GroupLayout TabSponsorLayout = new org.jdesktop.layout.GroupLayout(TabSponsor);
        TabSponsor.setLayout(TabSponsorLayout);
        TabSponsorLayout.setHorizontalGroup(
            TabSponsorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 611, Short.MAX_VALUE)
        );
        TabSponsorLayout.setVerticalGroup(
            TabSponsorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 375, Short.MAX_VALUE)
        );

        SubTabExhibitor.addTab("Sponsor", TabSponsor);

        org.jdesktop.layout.GroupLayout TabStaffLayout = new org.jdesktop.layout.GroupLayout(TabStaff);
        TabStaff.setLayout(TabStaffLayout);
        TabStaffLayout.setHorizontalGroup(
            TabStaffLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 611, Short.MAX_VALUE)
        );
        TabStaffLayout.setVerticalGroup(
            TabStaffLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 375, Short.MAX_VALUE)
        );

        SubTabExhibitor.addTab("Staff", TabStaff);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        btnAddP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        btnAddP.setText("Add");
        btnAddP.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnAddP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPActionPerformed(evt);
            }
        });

        btnEditP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEditP.setText("Edit");
        btnEditP.setMargin(new java.awt.Insets(2, 4, 2, 4));

        btnDeleteP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/33.png"))); // NOI18N
        btnDeleteP.setText("Delete");
        btnDeleteP.setMargin(new java.awt.Insets(2, 4, 2, 4));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Filter");

        cbWhereP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnFindP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N
        btnFindP.setText("Find");
        btnFindP.setMargin(new java.awt.Insets(2, 4, 2, 4));

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
                .add(txtPKeyword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnFindP))
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
                    .add(btnFindP))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jScrollPane3.setViewportView(tblProducts);

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 531, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabProductLayout = new org.jdesktop.layout.GroupLayout(TabProduct);
        TabProduct.setLayout(TabProductLayout);
        TabProductLayout.setHorizontalGroup(
            TabProductLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabProductLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabProductLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        TabProductLayout.setVerticalGroup(
            TabProductLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabProductLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        SubTabExhibitor.addTab("Product", TabProduct);

        org.jdesktop.layout.GroupLayout TabExhibitorLayout = new org.jdesktop.layout.GroupLayout(TabExhibitor);
        TabExhibitor.setLayout(TabExhibitorLayout);
        TabExhibitorLayout.setHorizontalGroup(
            TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 626, Short.MAX_VALUE)
            .add(TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(TabExhibitorLayout.createSequentialGroup()
                    .add(SubTabExhibitor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 683, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            .add(0, 626, Short.MAX_VALUE)
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
                    .add(mainTab, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(txtTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mainTab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 442, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddExpo ae = new AddExpo();
        ae.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPActionPerformed
        // TODO add your handling code here:
        new AddProduct(this, true).setVisible(true);
    }//GEN-LAST:event_btnAddPActionPerformed

    private void btnAddExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExActionPerformed
        // TODO add your handling code here:
        new AddExhibitor(this,true).setVisible(true);
    }//GEN-LAST:event_btnAddExActionPerformed

    private void btnEditExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditExActionPerformed
        // TODO add your handling code here:
        new EditExhibitor(this,true).setVisible(true);
    }//GEN-LAST:event_btnEditExActionPerformed

    private void btnFindExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindExActionPerformed
        try {
            // TODO add your handling code here:
            oex.getResult();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFindExActionPerformed

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
    private javax.swing.JButton btnAddEx;
    private javax.swing.JButton btnAddP;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteEx;
    private javax.swing.JButton btnDeleteP;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditEx;
    private javax.swing.JButton btnEditP;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFindEx;
    private javax.swing.JButton btnFindP;
    private javax.swing.JComboBox cbWhere;
    private javax.swing.JComboBox cbWhereEx;
    private javax.swing.JComboBox cbWhereP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JTable tblExhibitor;
    private javax.swing.JTable tblExpo;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtKeyword;
    private javax.swing.JTextField txtPKeyword;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables

}
