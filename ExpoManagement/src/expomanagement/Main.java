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

import Registration.ChosenBooth;
import booth.Addbooths;
import booth.Editbooths;
import booth.OperationBooths;
import boothType.AddboothType;
import boothType.EditboothType;
import boothType.OperationBoothType;
import contact.OperationContact;
import exhibitor.AddExhibitor;
import exhibitor.EditExhibitor;
import exhibitor.OperationExhibitor;
import expo.AddExpo;
import expo.EditExpo;
import expo.OperationExpo;
import java.awt.Choice;
import java.awt.Frame;
import javax.swing.JOptionPane;
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
    ChosenBooth cb = new ChosenBooth();
    OperationExpo oe = new OperationExpo();
    OperationExhibitor oex = new OperationExhibitor();
    OperationProduct op = new OperationProduct();
    OperationBoothType obt = new OperationBoothType();
    OperationSponsor os = new OperationSponsor();
    OperationBooths ob = new OperationBooths();
    OperationStaff ost = new OperationStaff();
    OperationUser ou = new OperationUser();
    OperationContact oc = new OperationContact();
    String UserName ="";
    int TypeUser,EID;
    int flag =0;
    public Main() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        this.dispose();
        new Login(this,true).setVisible(true);
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
        tblContact.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                int slcRow = tblContact.getSelectedRow();
                if(slcRow >= 0){

                    JOptionPane.showMessageDialog(null, "row: "+slcRow+" value: " +tblContact.getValueAt(slcRow,0).toString().trim(),"Delete Product",JOptionPane.INFORMATION_MESSAGE);
                   
                    oc.DetailOfContact(tblContact.getValueAt(slcRow,0).toString().trim(),txtregDate, txtuserCre, rbnPaid, rbnUnPaid, txtBooths, txtsentDate, txtreturnDate, txtlastChange);
                    btnDelContact.setEnabled(true);
                    btnSaveContact.setEnabled(true);
                }
                else{
                    txtuserCre.setText("");
                    txtregDate.setText("");
                    txtBooths.setText("");
                    txtsentDate.setText("");
                    txtreturnDate.setText("");
                    txtlastChange.setText("");
                    cbExpo.setSelectedIndex(0);
                    rbnPaid.setSelected(false);
                    rbnUnPaid.setSelected(false);
                    btnDelContact.setEnabled(false);
                    btnSaveContact.setEnabled(false);
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
        buttonGroup1 = new javax.swing.ButtonGroup();
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
        TabChosenBooth = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbWhereBooths = new javax.swing.JComboBox();
        txtFindStaff1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbChoseExpo = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        tblBooths = new javax.swing.JScrollPane();
        tblChoseBooths = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();
        txtNumBooth = new javax.swing.JTextField();
        NumBooth_lb = new javax.swing.JLabel();
        Prio_lb = new javax.swing.JLabel();
        cbPriority = new javax.swing.JComboBox();
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
        jPanel22 = new javax.swing.JPanel();
        JStblContact = new javax.swing.JScrollPane();
        tblContact = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtregDate = new javax.swing.JTextField();
        txtuserCre = new javax.swing.JTextField();
        cbExpo = new javax.swing.JComboBox();
        txtBooths = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtsentDate = new javax.swing.JTextField();
        txtreturnDate = new javax.swing.JTextField();
        txtlastChange = new javax.swing.JTextField();
        tbnChosebooth = new javax.swing.JButton();
        btnSaveContact = new javax.swing.JButton();
        btnDelContact = new javax.swing.JButton();
        rbnPaid = new javax.swing.JRadioButton();
        rbnUnPaid = new javax.swing.JRadioButton();
        lbTypeUser = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mnUA = new javax.swing.JMenuItem();
        mnLogOut = new javax.swing.JMenuItem();
        mnExit = new javax.swing.JMenuItem();
        mnAdmin = new javax.swing.JMenu();
        mnManager = new javax.swing.JMenuItem();
        mnExhibitor = new javax.swing.JMenuItem();
        Contact = new javax.swing.JMenuItem();
        MnHelp = new javax.swing.JMenu();
        mnAbout = new javax.swing.JMenuItem();

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        mainTab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTextArea1.setRows(5);
        jTextArea1.setText("\n Welcome !\n You are using software of Team 1 - GC0501 - FPT GreenWich.\n Hope you work efficiently.\n Thank you for using our software.");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout TabHomeLayout = new org.jdesktop.layout.GroupLayout(TabHome);
        TabHome.setLayout(TabHomeLayout);
        TabHomeLayout.setHorizontalGroup(
            TabHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabHomeLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                .addContainerGap())
        );
        TabHomeLayout.setVerticalGroup(
            TabHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabHomeLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTab.addTab("Home", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/home.png")), TabHome); // NOI18N

        SubTabManager.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        SubTabManager.setFont(new java.awt.Font("Tahoma", 0, 12));

        TabExpo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabExpo.setFont(new java.awt.Font("Tahoma", 0, 12));

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
        btnEdit.setEnabled(false);
        btnEdit.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
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
                .add(txtFindExpo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
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
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
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

        btnEditBT.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEditBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/69.png"))); // NOI18N
        btnEditBT.setText("Edit");
        btnEditBT.setEnabled(false);
        btnEditBT.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBTActionPerformed(evt);
            }
        });

        btnDeleteBT.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteBT.setText("Delete");
        btnDeleteBT.setEnabled(false);
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
                .add(txtFindBT, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
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
            .add(jScrollPane8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
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
        btnEditB.setEnabled(false);
        btnEditB.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBActionPerformed(evt);
            }
        });

        btnDeleteB.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteB.setText("Delete");
        btnDeleteB.setEnabled(false);
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
                .add(txtFindBooth, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
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
            .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
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
        btnEditS.setEnabled(false);
        btnEditS.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSActionPerformed(evt);
            }
        });

        btnDeleteS.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteS.setText("Delete");
        btnDeleteS.setEnabled(false);
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
                .add(txtSponsor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .add(jScrollPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabSponsorLayout = new org.jdesktop.layout.GroupLayout(TabSponsor);
        TabSponsor.setLayout(TabSponsorLayout);
        TabSponsorLayout.setHorizontalGroup(
            TabSponsorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TabSponsorLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabSponsorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        SubTabManager.addTab(" Sponsor      ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/sponsor.png")), TabSponsor); // NOI18N

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
        btnEditAcc.setEnabled(false);
        btnEditAcc.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAccActionPerformed(evt);
            }
        });

        btnDeleteAcc.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteAcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteAcc.setText("Delete");
        btnDeleteAcc.setEnabled(false);
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
                .add(txtFindUser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
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
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabAccountLayout = new org.jdesktop.layout.GroupLayout(TabAccount);
        TabAccount.setLayout(TabAccountLayout);
        TabAccountLayout.setHorizontalGroup(
            TabAccountLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabAccountLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabAccountLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabAccountLayout.setVerticalGroup(
            TabAccountLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabAccountLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        SubTabManager.addTab(" Account     ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/users.png")), TabAccount); // NOI18N

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
        btnEditEx.setEnabled(false);
        btnEditEx.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditExActionPerformed(evt);
            }
        });

        btnDeleteEx.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteEx.setText("Delete");
        btnDeleteEx.setEnabled(false);
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
                .add(txtFindEhi, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
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
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout STabExhibitorLayout = new org.jdesktop.layout.GroupLayout(STabExhibitor);
        STabExhibitor.setLayout(STabExhibitorLayout);
        STabExhibitorLayout.setHorizontalGroup(
            STabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, STabExhibitorLayout.createSequentialGroup()
                .addContainerGap()
                .add(STabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        STabExhibitorLayout.setVerticalGroup(
            STabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(STabExhibitorLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SubTabManager.addTab(" Exhibitor    ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/exhibitor_man.png")), STabExhibitor); // NOI18N

        org.jdesktop.layout.GroupLayout TabManagerLayout = new org.jdesktop.layout.GroupLayout(TabManager);
        TabManager.setLayout(TabManagerLayout);
        TabManagerLayout.setHorizontalGroup(
            TabManagerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabManagerLayout.createSequentialGroup()
                .add(SubTabManager, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                .addContainerGap())
        );
        TabManagerLayout.setVerticalGroup(
            TabManagerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabManagerLayout.createSequentialGroup()
                .add(SubTabManager, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 476, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainTab.addTab("Manager", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/administrator.png")), TabManager); // NOI18N

        SubTabExhibitor.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        SubTabExhibitor.setFont(new java.awt.Font("Tahoma", 0, 12));

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel17.setText("Filter");

        cbWhereBooths.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtFindStaff1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFindStaff1CaretUpdate(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/65.png"))); // NOI18N

        cbChoseExpo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbChoseExpo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbChoseExpoItemStateChanged(evt);
            }
        });

        jLabel21.setText("Expo:");

        org.jdesktop.layout.GroupLayout jPanel17Layout = new org.jdesktop.layout.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel21)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbChoseExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 164, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 138, Short.MAX_VALUE)
                .add(jLabel17)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbWhereBooths, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(txtFindStaff1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 259, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel18)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel17Layout.createSequentialGroup()
                .add(jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtFindStaff1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel18)
                    .add(jLabel21)
                    .add(cbChoseExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbWhereBooths, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel17))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Booths of Expo"));

        tblBooths.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tblChoseBooths.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BoothID", "BoothName", "BoothType's Name", "Booth's Length", "Booth's Remain", "Booth's Price", "Date Create", "Order"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBooths.setViewportView(tblChoseBooths);
        tblChoseBooths.getColumnModel().getColumn(0).setMinWidth(50);
        tblChoseBooths.getColumnModel().getColumn(0).setMaxWidth(100);
        tblChoseBooths.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblChoseBooths.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblChoseBooths.getColumnModel().getColumn(5).setMinWidth(80);
        tblChoseBooths.getColumnModel().getColumn(6).setPreferredWidth(100);
        tblChoseBooths.getColumnModel().getColumn(7).setResizable(false);
        tblChoseBooths.getColumnModel().getColumn(7).setPreferredWidth(30);

        org.jdesktop.layout.GroupLayout jPanel20Layout = new org.jdesktop.layout.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tblBooths, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tblBooths, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Booth's Choice"));

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        NumBooth_lb.setText("Number of Booth");

        Prio_lb.setText("Priority Point");

        cbPriority.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C", "B", "A" }));

        org.jdesktop.layout.GroupLayout jPanel21Layout = new org.jdesktop.layout.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(Prio_lb, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .add(NumBooth_lb))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(cbPriority, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtNumBooth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnOk)
                .add(664, 664, 664))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel21Layout.createSequentialGroup()
                .add(jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Prio_lb)
                    .add(cbPriority, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtNumBooth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(NumBooth_lb)
                    .add(btnOk))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout TabChosenBoothLayout = new org.jdesktop.layout.GroupLayout(TabChosenBooth);
        TabChosenBooth.setLayout(TabChosenBoothLayout);
        TabChosenBoothLayout.setHorizontalGroup(
            TabChosenBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabChosenBoothLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabChosenBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel20, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel21, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel17, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabChosenBoothLayout.setVerticalGroup(
            TabChosenBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabChosenBoothLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel20, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        SubTabExhibitor.addTab("  Choose Booth", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/booth.png")), TabChosenBooth); // NOI18N

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
        btnEditStaff.setEnabled(false);
        btnEditStaff.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnEditStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditStaffActionPerformed(evt);
            }
        });

        btnDeleteStaff.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnDeleteStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/del.png"))); // NOI18N
        btnDeleteStaff.setText("Delete");
        btnDeleteStaff.setEnabled(false);
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
                .add(txtFindStaff, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
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
            .add(jScrollPane12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabStaffLayout = new org.jdesktop.layout.GroupLayout(TabStaff);
        TabStaff.setLayout(TabStaffLayout);
        TabStaffLayout.setHorizontalGroup(
            TabStaffLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabStaffLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabStaffLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel19, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel16, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabStaffLayout.setVerticalGroup(
            TabStaffLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabStaffLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel19, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        SubTabExhibitor.addTab(" Staff           ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/staff.png")), TabStaff); // NOI18N

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
                .add(txtPKeyword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
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
            .add(jScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout TabProductLayout = new org.jdesktop.layout.GroupLayout(TabProduct);
        TabProduct.setLayout(TabProductLayout);
        TabProductLayout.setHorizontalGroup(
            TabProductLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TabProductLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabProductLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabProductLayout.setVerticalGroup(
            TabProductLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabProductLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        SubTabExhibitor.addTab(" Product       ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/product.png")), TabProduct); // NOI18N

        org.jdesktop.layout.GroupLayout TabExhibitorLayout = new org.jdesktop.layout.GroupLayout(TabExhibitor);
        TabExhibitor.setLayout(TabExhibitorLayout);
        TabExhibitorLayout.setHorizontalGroup(
            TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 906, Short.MAX_VALUE)
            .add(TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(TabExhibitorLayout.createSequentialGroup()
                    .add(SubTabExhibitor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        TabExhibitorLayout.setVerticalGroup(
            TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 486, Short.MAX_VALUE)
            .add(TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, SubTabExhibitor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
        );

        mainTab.addTab("Exhibitor", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/exhibitor.png")), TabExhibitor); // NOI18N

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Contact List"));

        tblContact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ContractID", "User creadential", "Number Booth", "PriorityPoint"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JStblContact.setViewportView(tblContact);

        org.jdesktop.layout.GroupLayout jPanel22Layout = new org.jdesktop.layout.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(JStblContact, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(JStblContact, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Contract Detail"));

        jLabel33.setText("Register date");

        jLabel35.setText("User Credential");

        jLabel36.setText("Expo");

        jLabel37.setText("Status");

        jLabel38.setText("Number of booths");

        cbExpo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel39.setText("Contract sent date");

        jLabel40.setText("Contract return date");

        jLabel41.setText("Last change");

        tbnChosebooth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        tbnChosebooth.setText("Choose Booth");
        tbnChosebooth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnChoseboothActionPerformed(evt);
            }
        });

        btnSaveContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/22.png"))); // NOI18N
        btnSaveContact.setText("Update");
        btnSaveContact.setEnabled(false);
        btnSaveContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveContactActionPerformed(evt);
            }
        });

        btnDelContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/14.png"))); // NOI18N
        btnDelContact.setText("Delete contract");
        btnDelContact.setEnabled(false);
        btnDelContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelContactActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbnPaid);
        rbnPaid.setText("Paid");

        buttonGroup1.add(rbnUnPaid);
        rbnUnPaid.setText("UnPaid");

        org.jdesktop.layout.GroupLayout jPanel24Layout = new org.jdesktop.layout.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel24Layout.createSequentialGroup()
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel35)
                            .add(jLabel37)
                            .add(jLabel36)
                            .add(jLabel33)
                            .add(jLabel38))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel24Layout.createSequentialGroup()
                                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(txtuserCre)
                                    .add(txtregDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .add(txtBooths)
                                    .add(cbExpo, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .add(56, 56, 56)
                                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel39)
                                    .add(jLabel40)
                                    .add(jLabel41))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtlastChange, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtreturnDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtsentDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                                .add(257, 257, 257))
                            .add(jPanel24Layout.createSequentialGroup()
                                .add(rbnPaid)
                                .add(18, 18, 18)
                                .add(rbnUnPaid)
                                .add(816, 816, 816))))
                    .add(jPanel24Layout.createSequentialGroup()
                        .add(tbnChosebooth, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnSaveContact, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnDelContact)
                        .add(680, 680, 680))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel24Layout.createSequentialGroup()
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel33)
                    .add(txtregDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel39)
                    .add(txtsentDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel24Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel40)
                            .add(txtreturnDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel41)
                            .add(txtlastChange, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel24Layout.createSequentialGroup()
                        .add(25, 25, 25)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtuserCre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel35))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel36)
                    .add(cbExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel37)
                    .add(rbnPaid)
                    .add(rbnUnPaid))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel38)
                    .add(txtBooths, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tbnChosebooth)
                    .add(btnSaveContact)
                    .add(btnDelContact))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rbnUnPaid.setSelected(true);

        org.jdesktop.layout.GroupLayout TabContactLayout = new org.jdesktop.layout.GroupLayout(TabContact);
        TabContact.setLayout(TabContactLayout);
        TabContactLayout.setHorizontalGroup(
            TabContactLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TabContactLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabContactLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel22, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel24, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabContactLayout.setVerticalGroup(
            TabContactLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TabContactLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel22, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainTab.addTab("Contact", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/contact.png")), TabContact); // NOI18N

        lbTypeUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/user.png"))); // NOI18N

        lbUser.setFont(new java.awt.Font("Tahoma", 1, 11));
        lbUser.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/28.png"))); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        jPanel18.setBackground(new java.awt.Color(77, 155, 201));
        jPanel18.setAlignmentX(0.0F);
        jPanel18.setAlignmentY(0.0F);

        txtTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        txtTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/banner.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel18Layout = new org.jdesktop.layout.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel18Layout.createSequentialGroup()
                .add(txtTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        mnFile.setText("File");

        mnUA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, java.awt.event.InputEvent.ALT_MASK));
        mnUA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/user_edit.png"))); // NOI18N
        mnUA.setText("User Account");
        mnFile.add(mnUA);

        mnLogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.ALT_MASK));
        mnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/28.png"))); // NOI18N
        mnLogOut.setText("Log Out");
        mnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLogOutActionPerformed(evt);
            }
        });
        mnFile.add(mnLogOut);

        mnExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/33.png"))); // NOI18N
        mnExit.setText("Exit");
        mnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnExitActionPerformed(evt);
            }
        });
        mnFile.add(mnExit);

        MenuBar.add(mnFile);

        mnAdmin.setText("Administration");

        mnManager.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        mnManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/kgpg.png"))); // NOI18N
        mnManager.setText("Manager");
        mnManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnManagerActionPerformed(evt);
            }
        });
        mnAdmin.add(mnManager);

        mnExhibitor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        mnExhibitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/personal.png"))); // NOI18N
        mnExhibitor.setText("Exhibitor");
        mnExhibitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnExhibitorActionPerformed(evt);
            }
        });
        mnAdmin.add(mnExhibitor);

        Contact.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        Contact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/contact.png"))); // NOI18N
        Contact.setText("Contact");
        Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactActionPerformed(evt);
            }
        });
        mnAdmin.add(Contact);

        MenuBar.add(mnAdmin);

        MnHelp.setText("Help");

        mnAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        mnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/17.png"))); // NOI18N
        mnAbout.setText("About");
        mnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAboutActionPerformed(evt);
            }
        });
        MnHelp.add(mnAbout);

        MenuBar.add(MnHelp);

        setJMenuBar(MenuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel18, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(678, Short.MAX_VALUE)
                .add(lbTypeUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lbUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnLogOut)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainTab, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel18, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnLogOut)
                    .add(lbTypeUser))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mainTab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 548, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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

    private void btnEditPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPActionPerformed
        // TODO add your handling code here:
        new EditProduct(this,true).setVisible(true);
    }//GEN-LAST:event_btnEditPActionPerformed

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
        op.doSearch(this,op.returnSearch(cbWhereP),keyword,tblProducts);
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
        ost.doSearch(this,ost.returnSearch(cbWhereStaff),keyword,tblStaff);
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

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        logOut();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        lbUser.setText(UserName);
        if(TypeUser==1){
            lbTypeUser.setText("Manager: ");
            mainTab.setEnabledAt(1, true);mnManager.setEnabled(true);
            mainTab.setEnabledAt(2, false);mnExhibitor.setEnabled(false);
            LoadContact("null");obt.buildCbExpo(cbExpo);
            LoadExpo();oe.buildCbWhereEx(cbWhereExpo);
            LoadBoothType();obt.buildCbWhereP(cbWhereBT);
            LoadBooth();ob.buildCbWhereB(cbWhereBooth);
            LoadSponsor();os.buildCbWhereSp(cbWhereSp);
            LoadAccount();ou.buildCbUs(cbWhereUser);
            LoadExhibitor();oex.buildCbEx(cbEx);
            if(flag==0){
                mainTab.setSelectedIndex(0);
                flag=1;
            }           
        }
        else if(TypeUser==2)
        {   
            lbTypeUser.setText("Exhibitor: ");
            mainTab.setEnabledAt(1, false);mnManager.setEnabled(false);
            mainTab.setEnabledAt(2, true);mnExhibitor.setEnabled(true);
            LoadContact(EID+"");obt.buildCbExpo(cbExpo);
            obt.buildCbExpo(cbChoseExpo);
            LoadStaff();ost.buildCbStaff(cbWhereStaff);
            LoadProduct();op.buildCbWhereP(cbWhereP); 
            }
            if(flag==1){
                mainTab.setSelectedIndex(0); 
                flag=0; 
        }
    }//GEN-LAST:event_formWindowActivated

    private void mnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLogOutActionPerformed
        // TODO add your handling code here:
        logOut();
    }//GEN-LAST:event_mnLogOutActionPerformed

    private void mnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnExitActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "Do you want to exit application ?",
                "Exit Application",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_mnExitActionPerformed

    private void mnManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnManagerActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(1);
    }//GEN-LAST:event_mnManagerActionPerformed

    private void mnExhibitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnExhibitorActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(2);
    }//GEN-LAST:event_mnExhibitorActionPerformed

    private void ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactActionPerformed
        // TODO add your handling code here:
        mainTab.setSelectedIndex(3);
    }//GEN-LAST:event_ContactActionPerformed

    private void mnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAboutActionPerformed
        // TODO add your handling code here:
        new aboutSoftware().setVisible(true);
    }//GEN-LAST:event_mnAboutActionPerformed

    private void txtFindStaff1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindStaff1CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindStaff1CaretUpdate

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

}//GEN-LAST:event_btnOkActionPerformed

    private void tbnChoseboothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnChoseboothActionPerformed

}//GEN-LAST:event_tbnChoseboothActionPerformed

    private void btnSaveContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveContactActionPerformed

}//GEN-LAST:event_btnSaveContactActionPerformed

    private void btnDelContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelContactActionPerformed
        // TODO add your handling code here:
        int row = tblChoseBooths.getSelectedRow();
        String id = tblChoseBooths.getValueAt(row, 0).toString();
        oc.delContact(id);
    }//GEN-LAST:event_btnDelContactActionPerformed

    private void cbChoseExpoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbChoseExpoItemStateChanged
        // TODO add your handling code here:
        if(evt.getItem().toString().trim().equalsIgnoreCase("-- Choose Expo --")){
            cb.showInfomation(null, tblChoseBooths);
        }
        else{
            if(cbChoseExpo.getSelectedIndex()==0)
                cb.showInfomation(null, tblChoseBooths);
            else
                cb.showInfomation(obt.returnIdExpo(cbChoseExpo)+"", tblChoseBooths);
        }

    }//GEN-LAST:event_cbChoseExpoItemStateChanged
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
        ost.loadAllStaff(this,tblStaff);
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
        op.loadAllProduct(this,tblProducts);
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
    public void LoadContact(String EID)
    {
        oc.loadAllContact(this,EID, tblContact);
    }
    public JTable getSponsorTable(){
        return tblSponsor;
    }
    public void setCbExpo(String v){
        cbExpo.setSelectedItem(v);
    }
    public void setUser(String User){
        UserName = User;
    }
    public void setTypeUser(int TUser){
        TypeUser = TUser;
    }
    public void setEID(int eID){
        EID = eID;
    }
    public String getEID(){
        return EID+"";
    }
    public void logOut(){
        if(JOptionPane.showConfirmDialog(null, "Do you want to Log Out now ?",
                "Log Out System",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        this.dispose();
        new Login(this,true).setVisible(true);
        }
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
    private javax.swing.JMenuItem Contact;
    private javax.swing.JScrollPane JStblContact;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MnHelp;
    private javax.swing.JLabel NumBooth_lb;
    private javax.swing.JLabel Prio_lb;
    private javax.swing.JPanel STabExhibitor;
    private javax.swing.JTabbedPane SubTabExhibitor;
    private javax.swing.JTabbedPane SubTabManager;
    private javax.swing.JPanel TabAccount;
    private javax.swing.JPanel TabBooth;
    private javax.swing.JPanel TabBoothType;
    private javax.swing.JPanel TabChosenBooth;
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
    private javax.swing.JButton btnDelContact;
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
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSaveContact;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbChoseExpo;
    private javax.swing.JComboBox cbEx;
    private javax.swing.JComboBox cbExpo;
    private javax.swing.JComboBox cbPriority;
    private javax.swing.JComboBox cbWhereBT;
    private javax.swing.JComboBox cbWhereBooth;
    private javax.swing.JComboBox cbWhereBooths;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
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
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
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
    private javax.swing.JLabel lbTypeUser;
    private javax.swing.JLabel lbUser;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JMenuItem mnAbout;
    private javax.swing.JMenu mnAdmin;
    private javax.swing.JMenuItem mnExhibitor;
    private javax.swing.JMenuItem mnExit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenuItem mnLogOut;
    private javax.swing.JMenuItem mnManager;
    private javax.swing.JMenuItem mnUA;
    private javax.swing.JRadioButton rbnPaid;
    private javax.swing.JRadioButton rbnUnPaid;
    private javax.swing.JTable tblAccount;
    private javax.swing.JTable tblBooth;
    private javax.swing.JTable tblBoothType;
    private javax.swing.JScrollPane tblBooths;
    private javax.swing.JTable tblChoseBooths;
    private javax.swing.JTable tblContact;
    private javax.swing.JTable tblExhibitor;
    private javax.swing.JTable tblExpo;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTable tblSponsor;
    private javax.swing.JTable tblStaff;
    private javax.swing.JButton tbnChosebooth;
    private javax.swing.JTextField txtBooths;
    private javax.swing.JTextField txtFindBT;
    private javax.swing.JTextField txtFindBooth;
    private javax.swing.JTextField txtFindEhi;
    private javax.swing.JTextField txtFindExpo;
    private javax.swing.JTextField txtFindStaff;
    private javax.swing.JTextField txtFindStaff1;
    private javax.swing.JTextField txtFindUser;
    private javax.swing.JTextField txtNumBooth;
    private javax.swing.JTextField txtPKeyword;
    private javax.swing.JTextField txtSponsor;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JTextField txtlastChange;
    private javax.swing.JTextField txtregDate;
    private javax.swing.JTextField txtreturnDate;
    private javax.swing.JTextField txtsentDate;
    private javax.swing.JTextField txtuserCre;
    // End of variables declaration//GEN-END:variables

}
