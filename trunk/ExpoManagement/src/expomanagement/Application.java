/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Application.java
 *
 * Created on 12-11-2010, 02:04:10
 */

package expomanagement;

import Registration.ChosenBooth;
import Registration.Registration;
import booth.Addbooths;
import booth.Editbooths;
import booth.OperationBooths;
import boothType.AddboothType;
import boothType.EditboothType;
import boothType.OperationBoothType;
import contract.OperationContract;
import exhibitor.AddExhibitor;
import exhibitor.EditExhibitor;
import exhibitor.OperationExhibitor;
import expo.AddExpo;
import expo.EditExpo;
import expo.OperationExpo;
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
public final class Application extends javax.swing.JFrame {

    /** Creates new form Application */
    ChosenBooth cb = new ChosenBooth();
    OperationExpo oe = new OperationExpo();
    OperationExhibitor oex = new OperationExhibitor();
    OperationProduct op = new OperationProduct();
    OperationBoothType obt = new OperationBoothType();
    OperationSponsor os = new OperationSponsor();
    OperationBooths ob = new OperationBooths();
    OperationStaff ost = new OperationStaff();
    OperationUser ou = new OperationUser();
    OperationContract oc = new OperationContract();
    String UserName ="";
    int TypeUser,EID;


    public Application(String UserName, final int TypeUser, final int EID) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {
        }
        initComponents();
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.UserName = UserName;
        this.EID = EID;
        this.TypeUser = TypeUser;
        new Statistics().statisticsSys(countExpo, countE, countBT, countB, countSp, countS, countP, countC);
        lbUser.setText(UserName);
        if(TypeUser==1){
            mainTab.setSelectedIndex(0);
            lbTypeUser.setText("Manager: ");
            mainTab.setEnabledAt(1, true);mnManager.setEnabled(true);
            mainTab.setEnabledAt(2, false);mnExhibitor.setEnabled(false);
            LoadContract("null");obt.buildCbExpo(cbExpoContract);
            LoadExpo();oe.buildCbWhereEx(cbWhereExpo);
            LoadBoothType();obt.buildCbWhereP(cbWhereBT);
            LoadBooth();ob.buildCbWhereB(cbWhereBooth);
            LoadAccount();ou.buildCbUs(cbWhereUser);
            LoadExhibitor();oex.buildCbEx(cbEx);
            }
        else if(TypeUser==2)
            {
                new Statistics().statisticsExhibitor(Integer.toString(EID),countS1, countP1, sumB, countC1);
                mainTab.setSelectedIndex(0);
                lbTypeUser.setText("Exhibitor: "); 
                mainTab.setEnabledAt(1, false);mnManager.setEnabled(false);
                mainTab.setEnabledAt(2, true);mnExhibitor.setEnabled(true);
                if(SubTabExhibitor.getSelectedIndex()==0)
                LoadContract(Integer.toString(EID));
                LoadSponsor();os.buildCbWhereSp(cbWhereSp);
                obt.buildCbExpo(cbChoseExpo);obt.buildCbExpo(cbExpoContract);
                cb.buildCbFindBooth(cbWhereBooths);
                LoadStaff();ost.buildCbStaff(cbWhereStaff);
                LoadProduct();op.buildCbWhereP(cbWhereP);
                btnActContact.setText("Send");
            }

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
                    oc.DetailOfContract(TypeUser,Integer.toString(EID),tblContact.getValueAt(slcRow,0).toString().trim(),txtregDate, txtuserCre, rbnPaid, rbnUnPaid, txtBooths, txtsentDate, txtreturnDate, txtlastChange, txtPaid, btnActContact, btnUpdateContract);
                    btnDelContact.setEnabled(true);
                }
                else{
                    txtuserCre.setText("");
                    txtregDate.setText("");
                    txtBooths.setText("");
                    txtsentDate.setText("");
                    txtreturnDate.setText("");
                    txtlastChange.setText("");
                    rbnPaid.setSelected(false);
                    rbnUnPaid.setSelected(false);
                    btnDelContact.setEnabled(false);
                    btnUpdateContract.setEnabled(false);
                    btnActContact.setEnabled(false);
                }
            }
        });
        tblChoseBooths.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                int slcRow = tblChoseBooths.getSelectedRow();
                if(slcRow >= 0){
                    cb.showInfoBT(tblChoseBooths.getValueAt(slcRow, 2).toString(), txtBoothType, txtLength, txtRemain);
                    if(tblChoseBooths.getValueAt(slcRow, 5).toString().trim().equals("Yes"))
                    {
                        btnBook.setEnabled(false);
                        btnUnBook.setEnabled(true);
                    }
                    else
                    {
                        btnBook.setEnabled(true);
                        btnUnBook.setEnabled(false);
                    }
                }
                else{
                    txtBoothType.setText("");
                    txtLength.setText("");
                    txtRemain.setText("");                 
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
        jPanel23 = new javax.swing.JPanel();
        countB = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        countExpo = new javax.swing.JLabel();
        countC = new javax.swing.JLabel();
        countP = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        countBT = new javax.swing.JLabel();
        countS = new javax.swing.JLabel();
        countSp = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        countE = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        countP1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        countC1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        countS1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        sumB = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
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
        btnBook = new javax.swing.JButton();
        btnUnBook = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtExDescription = new javax.swing.JTextArea();
        jPanel27 = new javax.swing.JPanel();
        txtLength = new javax.swing.JTextField();
        NumBooth_lb1 = new javax.swing.JLabel();
        txtRemain = new javax.swing.JTextField();
        NumBooth_lb2 = new javax.swing.JLabel();
        NumBooth_lb3 = new javax.swing.JLabel();
        txtBoothType = new javax.swing.JTextField();
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
        txtBooths = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtsentDate = new javax.swing.JTextField();
        txtreturnDate = new javax.swing.JTextField();
        txtlastChange = new javax.swing.JTextField();
        tbnChosebooth = new javax.swing.JButton();
        btnActContact = new javax.swing.JButton();
        btnDelContact = new javax.swing.JButton();
        rbnPaid = new javax.swing.JRadioButton();
        rbnUnPaid = new javax.swing.JRadioButton();
        txtPaid = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        btnUpdateContract = new javax.swing.JButton();
        cbExpoContract = new javax.swing.JComboBox();
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

        mainTab.setFont(new java.awt.Font("Tahoma", 0, 14));

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextArea1.setRows(5);
        jTextArea1.setText("\n Welcome !\n You are using software of Team 1 - GC0501 - FPT GreenWich.\n Hope you work efficiently.\n Thank you for using our software.");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("System's Statistics"));

        countB.setFont(new java.awt.Font("Tahoma", 1, 14));
        countB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countB.setText("0");
        countB.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel23.setText("Total Expo :");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel24.setText("Total Product :");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel25.setText("Total Sponsors :");

        countExpo.setFont(new java.awt.Font("Tahoma", 1, 14));
        countExpo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countExpo.setText("0");
        countExpo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        countExpo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        countExpo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        countC.setFont(new java.awt.Font("Tahoma", 1, 14));
        countC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countC.setText("0");
        countC.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        countP.setFont(new java.awt.Font("Tahoma", 1, 14));
        countP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countP.setText("0");
        countP.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel26.setText("Total Staff :");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel27.setText("Total Exhibitor :");

        countBT.setFont(new java.awt.Font("Tahoma", 1, 14));
        countBT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countBT.setText("0");
        countBT.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        countS.setFont(new java.awt.Font("Tahoma", 1, 14));
        countS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countS.setText("0");
        countS.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        countSp.setFont(new java.awt.Font("Tahoma", 1, 14));
        countSp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countSp.setText("0");
        countSp.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel28.setText("Total Booths :");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel29.setText("BoothType :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel30.setText("Total Contract :");

        countE.setFont(new java.awt.Font("Tahoma", 1, 14));
        countE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countE.setText("0");
        countE.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        org.jdesktop.layout.GroupLayout jPanel23Layout = new org.jdesktop.layout.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel23Layout.createSequentialGroup()
                .add(29, 29, 29)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel23)
                    .add(jLabel27)
                    .add(jLabel29)
                    .add(jLabel28)
                    .add(jLabel25)
                    .add(jLabel26)
                    .add(jLabel24)
                    .add(jLabel30))
                .add(36, 36, 36)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, countE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, countBT, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, countB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, countSp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, countS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, countP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, countC, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, countExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 204, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel23Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel23))
                .add(15, 15, 15)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel27))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countBT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel29))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel28))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countSp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel25))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel26))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel24))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countC, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel30))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("User's Statistics"));

        countP1.setFont(new java.awt.Font("Tahoma", 1, 14));
        countP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countP1.setText("0");
        countP1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel31.setText("Booths :");

        countC1.setFont(new java.awt.Font("Tahoma", 1, 14));
        countC1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countC1.setText("0");
        countC1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel32.setText("Contract :");

        countS1.setFont(new java.awt.Font("Tahoma", 1, 14));
        countS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countS1.setText("0");
        countS1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel34.setText("Staff :");

        sumB.setFont(new java.awt.Font("Tahoma", 1, 14));
        sumB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sumB.setText("0");
        sumB.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel43.setText("Product :");

        org.jdesktop.layout.GroupLayout jPanel26Layout = new org.jdesktop.layout.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel26Layout.createSequentialGroup()
                .add(54, 54, 54)
                .add(jPanel26Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel43)
                    .add(jLabel31)
                    .add(jLabel34)
                    .add(jLabel32))
                .add(18, 18, 18)
                .add(jPanel26Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(countS1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(countP1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(sumB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(countC1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel26Layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(jPanel26Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countS1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel34))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel26Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel43)
                    .add(countP1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel26Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(sumB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel31))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel26Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countC1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel32))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout TabHomeLayout = new org.jdesktop.layout.GroupLayout(TabHome);
        TabHome.setLayout(TabHomeLayout);
        TabHomeLayout.setHorizontalGroup(
            TabHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabHomeLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, TabHomeLayout.createSequentialGroup()
                        .add(jPanel23, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel26, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(60, 60, 60))
        );
        TabHomeLayout.setVerticalGroup(
            TabHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TabHomeLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(TabHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel23, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel26, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .add(txtFindExpo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
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
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
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
                .add(txtFindBT, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
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
            .add(jScrollPane8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
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
                .add(txtFindBooth, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
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
            .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
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

        SubTabManager.addTab("  Booth         ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/booth.png")), TabBooth); // NOI18N

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
                .add(txtFindUser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
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
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
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
                .add(txtFindEhi, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
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
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
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
                .add(SubTabManager, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
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
            .add(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel21)
                .add(18, 18, 18)
                .add(cbChoseExpo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(52, 52, 52)
                .add(jLabel17)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbWhereBooths, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFindStaff1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
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
                    .add(jLabel17)
                    .add(cbWhereBooths, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        org.jdesktop.layout.GroupLayout jPanel20Layout = new org.jdesktop.layout.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tblBooths, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tblBooths, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Booth's Choice"));

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        txtNumBooth.setEditable(false);
        txtNumBooth.setText("0");

        NumBooth_lb.setText("Number of Booth");

        Prio_lb.setText("Priority Point");

        cbPriority.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C", "B", "A" }));

        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnUnBook.setText("UnBook");
        btnUnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnBookActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel21Layout = new org.jdesktop.layout.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel21Layout.createSequentialGroup()
                        .add(NumBooth_lb)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtNumBooth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(Prio_lb, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cbPriority, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(33, 33, 33))
                    .add(jPanel21Layout.createSequentialGroup()
                        .add(btnBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnUnBook)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnOk)
                        .addContainerGap(213, Short.MAX_VALUE))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel21Layout.createSequentialGroup()
                .add(jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtNumBooth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(NumBooth_lb)
                    .add(cbPriority, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(Prio_lb))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnBook)
                    .add(btnUnBook)
                    .add(btnOk))
                .add(11, 11, 11))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Expo's Information"));

        jLabel22.setText("Description:");

        txtStartDate.setEditable(false);

        jLabel19.setText("Start Date:");

        jLabel20.setText("End Date:");

        txtEndDate.setEditable(false);

        txtExDescription.setColumns(20);
        txtExDescription.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtExDescription.setRows(5);
        jScrollPane5.setViewportView(txtExDescription);

        org.jdesktop.layout.GroupLayout jPanel25Layout = new org.jdesktop.layout.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel19)
                    .add(jLabel20))
                .add(28, 28, 28)
                .add(jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(txtEndDate)
                    .add(txtStartDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(jLabel22)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel25Layout.createSequentialGroup()
                        .add(jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel25Layout.createSequentialGroup()
                        .add(jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtStartDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel22)
                            .add(jLabel19))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtEndDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel20))
                        .add(12, 12, 12))))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("BoothType's Information"));

        txtLength.setEditable(false);

        NumBooth_lb1.setText("Booth Length");

        txtRemain.setEditable(false);

        NumBooth_lb2.setText("Booth Remain");

        NumBooth_lb3.setText("Booth Type");

        txtBoothType.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel27Layout = new org.jdesktop.layout.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel27Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel27Layout.createSequentialGroup()
                        .add(NumBooth_lb3)
                        .add(18, 18, 18)
                        .add(txtBoothType, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                    .add(jPanel27Layout.createSequentialGroup()
                        .add(NumBooth_lb1)
                        .add(10, 10, 10)
                        .add(txtLength, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .add(10, 10, 10)
                        .add(NumBooth_lb2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(txtRemain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(26, 26, 26))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel27Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(NumBooth_lb3)
                    .add(txtBoothType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel27Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(NumBooth_lb1)
                    .add(txtRemain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtLength, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(NumBooth_lb2))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout TabChosenBoothLayout = new org.jdesktop.layout.GroupLayout(TabChosenBooth);
        TabChosenBooth.setLayout(TabChosenBoothLayout);
        TabChosenBoothLayout.setHorizontalGroup(
            TabChosenBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TabChosenBoothLayout.createSequentialGroup()
                .addContainerGap()
                .add(TabChosenBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel20, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel17, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, TabChosenBoothLayout.createSequentialGroup()
                        .add(jPanel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel27, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel25, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabChosenBoothLayout.setVerticalGroup(
            TabChosenBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TabChosenBoothLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel20, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(TabChosenBoothLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jPanel27, 0, 92, Short.MAX_VALUE)
                    .add(jPanel21, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .add(txtFindStaff, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
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
            .add(jScrollPane12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
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
                .add(txtSponsor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
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
            .add(jScrollPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
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

        SubTabExhibitor.addTab(" Sponsor      ", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/sponsor.png")), TabSponsor); // NOI18N

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
                .add(txtPKeyword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
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
            .add(jScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
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
            .add(0, 938, Short.MAX_VALUE)
            .add(TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(TabExhibitorLayout.createSequentialGroup()
                    .add(SubTabExhibitor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        TabExhibitorLayout.setVerticalGroup(
            TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 460, Short.MAX_VALUE)
            .add(TabExhibitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, SubTabExhibitor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
        );

        mainTab.addTab("Exhibitor", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/exhibitor.png")), TabExhibitor); // NOI18N

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Contract List"));

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
            .add(JStblContact, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(JStblContact, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Contract Detail"));

        jLabel33.setText("Register date");

        jLabel35.setText("User Credential");

        jLabel36.setText("Expo");

        jLabel37.setText("Status");

        jLabel38.setText("Number of booths");

        txtregDate.setEditable(false);

        txtuserCre.setEditable(false);

        txtBooths.setEditable(false);

        jLabel39.setText("Contract sent date");

        jLabel40.setText("Contract return date");

        jLabel41.setText("Last change");

        txtsentDate.setEditable(false);

        txtreturnDate.setEditable(false);

        txtlastChange.setEditable(false);

        tbnChosebooth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/13.png"))); // NOI18N
        tbnChosebooth.setText("Choose Booth");
        tbnChosebooth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnChoseboothActionPerformed(evt);
            }
        });

        btnActContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/62.png"))); // NOI18N
        btnActContact.setText("Return");
        btnActContact.setEnabled(false);
        btnActContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActContactActionPerformed(evt);
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

        txtPaid.setEditable(false);

        jLabel42.setText("Paid");

        btnUpdateContract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/22.png"))); // NOI18N
        btnUpdateContract.setText("Update Contract");
        btnUpdateContract.setEnabled(false);
        btnUpdateContract.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnUpdateContract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateContractActionPerformed(evt);
            }
        });

        cbExpoContract.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.layout.GroupLayout jPanel24Layout = new org.jdesktop.layout.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel24Layout.createSequentialGroup()
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel24Layout.createSequentialGroup()
                        .add(47, 47, 47)
                        .add(jLabel37)
                        .add(118, 118, 118)
                        .add(rbnUnPaid))
                    .add(jPanel24Layout.createSequentialGroup()
                        .add(128, 128, 128)
                        .add(tbnChosebooth)
                        .add(10, 10, 10)
                        .add(btnDelContact)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnActContact, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(14, 14, 14)
                        .add(btnUpdateContract, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel24Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel36)
                            .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jPanel24Layout.createSequentialGroup()
                                    .add(19, 19, 19)
                                    .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(jLabel33)
                                        .add(jLabel42)))
                                .add(jLabel35)))
                        .add(29, 29, 29)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(txtPaid, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .add(txtregDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .add(rbnPaid)
                            .add(txtuserCre, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .add(cbExpoContract, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 233, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(58, 58, 58)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel39)
                            .add(jLabel40)
                            .add(jLabel41)
                            .add(jLabel38))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtBooths)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtsentDate)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtlastChange)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtreturnDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 209, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(121, 121, 121))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel24Layout.createSequentialGroup()
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel33)
                            .add(jPanel24Layout.createSequentialGroup()
                                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel24Layout.createSequentialGroup()
                                        .add(30, 30, 30)
                                        .add(jLabel35))
                                    .add(jPanel24Layout.createSequentialGroup()
                                        .add(txtregDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(txtuserCre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                            .add(jLabel36)
                                            .add(cbExpoContract, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(11, 11, 11)
                                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel42)
                                    .add(txtPaid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel24Layout.createSequentialGroup()
                                .add(7, 7, 7)
                                .add(jLabel37))
                            .add(jPanel24Layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(rbnPaid)
                                    .add(rbnUnPaid)))))
                    .add(jPanel24Layout.createSequentialGroup()
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel39)
                            .add(txtsentDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel40)
                            .add(txtreturnDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel41)
                            .add(txtlastChange, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtBooths, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel38))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 18, Short.MAX_VALUE)
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tbnChosebooth)
                    .add(btnDelContact)
                    .add(btnUpdateContract)
                    .add(btnActContact))
                .addContainerGap())
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
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel24, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE))
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

        mainTab.addTab("Contract", new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon/contact.png")), TabContact); // NOI18N

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
                .add(txtTitle)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel18Layout.createSequentialGroup()
                .add(txtTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnFile.setText("File");

        mnUA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, java.awt.event.InputEvent.ALT_MASK));
        mnUA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expomanagement/icon_func/user_edit.png"))); // NOI18N
        mnUA.setText("User Account");
        mnUA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUAActionPerformed(evt);
            }
        });
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
                .addContainerGap(710, Short.MAX_VALUE)
                .add(lbTypeUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lbUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnLogOut)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainTab)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnLogOut)
                    .add(lbTypeUser))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mainTab, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
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

    private void btnEditBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBTActionPerformed
        // TODO add your handling code here:
        new EditboothType(this, true).setVisible(true);
    }//GEN-LAST:event_btnEditBTActionPerformed

    private void btnEditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBActionPerformed
        // TODO add your handling code here:
        new Editbooths(this, true).setVisible(true);
    }//GEN-LAST:event_btnEditBActionPerformed

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

    private void txtFindUserCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindUserCaretUpdate
        // TODO add your handling code here:
        String keyword = txtFindUser.getText().trim();
        keyword.replace(" ", "%");
        ou.doSearch(ou.returnSearch(cbWhereUser),keyword,tblAccount);
    }//GEN-LAST:event_txtFindUserCaretUpdate

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

    private void tbnChoseboothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnChoseboothActionPerformed

}//GEN-LAST:event_tbnChoseboothActionPerformed

    private void btnActContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActContactActionPerformed
    int row = tblContact.getSelectedRow();
    String id = tblContact.getValueAt(row, 0).toString();
    if(TypeUser==1){
        oc.returnContract(id, Float.parseFloat(txtPaid.getText().trim()));
    }
    else if(TypeUser==2){
        oc.sendContract(id, Integer.toString(EID));
    }
    btnActContact.setEnabled(false);
}//GEN-LAST:event_btnActContactActionPerformed

    private void btnDelContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelContactActionPerformed
        // TODO add your handling code here:
        int row = tblContact.getSelectedRow();
        String id = tblContact.getValueAt(row, 0).toString();
        oc.delContract(id,Integer.toString(EID),TypeUser);
    }//GEN-LAST:event_btnDelContactActionPerformed

    private void txtPKeywordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPKeywordCaretUpdate
        // TODO add your handling code here:
        String keyword = txtPKeyword.getText().trim();
        keyword.replace(" ", "%");
        op.doSearch(this,op.returnSearch(cbWhereP),keyword,tblProducts);
}//GEN-LAST:event_txtPKeywordCaretUpdate

    private void btnDeletePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePActionPerformed
        // TODO add your handling code here:
        int row = tblProducts.getSelectedRow();
        int id = Integer.parseInt(tblProducts.getValueAt(row, 0).toString());
        op.delProducts(id);
        LoadProduct();
}//GEN-LAST:event_btnDeletePActionPerformed

    private void btnEditPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPActionPerformed
        // TODO add your handling code here:
        new EditProduct(this,true).setVisible(true);
}//GEN-LAST:event_btnEditPActionPerformed

    private void btnAddPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPActionPerformed
        // TODO add your handling code here:
        new AddProduct(this,true).setVisible(true);
}//GEN-LAST:event_btnAddPActionPerformed

    private void txtFindStaffCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindStaffCaretUpdate
        // TODO add your handling code here:
        String keyword = txtFindStaff.getText().trim();
        keyword.replace(" ", "%");
        ost.doSearch(this,ost.returnSearch(cbWhereStaff),keyword,tblStaff);
}//GEN-LAST:event_txtFindStaffCaretUpdate

    private void btnDeleteStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStaffActionPerformed
        // TODO add your handling code here:
        int row = tblStaff.getSelectedRow();
        int id = Integer.parseInt(tblStaff.getValueAt(row, 0).toString());
        ost.delStaff(id);
        LoadStaff();
}//GEN-LAST:event_btnDeleteStaffActionPerformed

    private void btnEditStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditStaffActionPerformed
        // TODO add your handling code here:
        new EditStaff(this, true).setVisible(true);
}//GEN-LAST:event_btnEditStaffActionPerformed

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
        // TODO add your handling code here:
        new AddStaff(this, true).setVisible(true);
}//GEN-LAST:event_btnAddStaffActionPerformed

    private void txtFindStaff1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindStaff1CaretUpdate
        // TODO add your handling code here:
}//GEN-LAST:event_txtFindStaff1CaretUpdate

    private void cbChoseExpoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbChoseExpoItemStateChanged
        // TODO add your handling code here:
        if(!evt.getItem().toString().trim().equalsIgnoreCase("-- Choose Expo --")){
            if(cbChoseExpo.getSelectedIndex()!=0)
            {
                cb.showInfoExpo(Integer.toString(obt.returnIdExpo(cbChoseExpo)), txtStartDate, txtEndDate, txtExDescription);
                cb.showInfomation(Integer.toString(obt.returnIdExpo(cbChoseExpo)), tblChoseBooths);
            }
        }
    }//GEN-LAST:event_cbChoseExpoItemStateChanged

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
    new Registration(this, true,txtNumBooth.getText().trim(), cbChoseExpo.getSelectedItem().toString().trim(), obt.returnIdExpo(cbChoseExpo)+"", cbPriority.getSelectedItem().toString().trim()).setVisible(true);
}//GEN-LAST:event_btnOkActionPerformed

    private void btnUpdateContractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateContractActionPerformed
        // TODO add your handling code here:
        int row = tblContact.getSelectedRow();
        String id = tblContact.getValueAt(row, 0).toString().trim();
        oc.updateContract(id, obt.returnIdExpo(cbExpoContract), txtuserCre.getText().trim(), Integer.parseInt(txtBooths.getText().trim()));
    }//GEN-LAST:event_btnUpdateContractActionPerformed

    private void mnUAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUAActionPerformed
        // TODO add your handling code here:
        new EditCurrentAccount(this, true, UserName).setVisible(true);
    }//GEN-LAST:event_mnUAActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
        int row = tblChoseBooths.getSelectedRow();
        String id = tblChoseBooths.getValueAt(row, 0).toString();
        cb.choiceBooth(id,true);
        tblChoseBooths.setValueAt("Yes", row, 5);
        btnBook.setEnabled(false);
        btnUnBook.setEnabled(true);
        int numBooth = Integer.parseInt(txtNumBooth.getText().trim());
        txtNumBooth.setText(Integer.toString(numBooth+1));
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnUnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnBookActionPerformed
        // TODO add your handling code here:
        int row = tblChoseBooths.getSelectedRow();
        String id = tblChoseBooths.getValueAt(row, 0).toString();
        cb.choiceBooth(id,false);
        tblChoseBooths.setValueAt("No", row, 5);
        btnBook.setEnabled(true);
        btnUnBook.setEnabled(false);
        int numBooth = Integer.parseInt(txtNumBooth.getText().trim());
        txtNumBooth.setText(Integer.toString(numBooth-1));
    }//GEN-LAST:event_btnUnBookActionPerformed
    public void setCbExpoContract(String v)
    {
        cbExpoContract.setSelectedItem(v);
    }
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
        os.loadAllSponsor(this,tblSponsor);
    }
    public void LoadContract(String EID)
    {
        oc.loadAllContract(this,EID, tblContact);
    }
    public JTable getSponsorTable(){
        return tblSponsor;
    }


    public String getEID(){
        return Integer.toString(EID).trim();
    }
    public void logOut(){
        if(JOptionPane.showConfirmDialog(null, "Do you want to Log Out now ?",
                "Log Out System",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        this.dispose();
        new Login().setVisible(true);
        }
    }

    /**
    * @param args the command line arguments
    */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Contact;
    private javax.swing.JScrollPane JStblContact;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MnHelp;
    private javax.swing.JLabel NumBooth_lb;
    private javax.swing.JLabel NumBooth_lb1;
    private javax.swing.JLabel NumBooth_lb2;
    private javax.swing.JLabel NumBooth_lb3;
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
    private javax.swing.JButton btnActContact;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddAcc;
    private javax.swing.JButton btnAddB;
    private javax.swing.JButton btnAddBT1;
    private javax.swing.JButton btnAddEx;
    private javax.swing.JButton btnAddP;
    private javax.swing.JButton btnAddS;
    private javax.swing.JButton btnAddStaff;
    private javax.swing.JButton btnBook;
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
    private javax.swing.JButton btnUnBook;
    private javax.swing.JButton btnUpdateContract;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbChoseExpo;
    private javax.swing.JComboBox cbEx;
    private javax.swing.JComboBox cbExpoContract;
    private javax.swing.JComboBox cbPriority;
    private javax.swing.JComboBox cbWhereBT;
    private javax.swing.JComboBox cbWhereBooth;
    private javax.swing.JComboBox cbWhereBooths;
    private javax.swing.JComboBox cbWhereExpo;
    private javax.swing.JComboBox cbWhereP;
    private javax.swing.JComboBox cbWhereSp;
    private javax.swing.JComboBox cbWhereStaff;
    private javax.swing.JComboBox cbWhereUser;
    private javax.swing.JLabel countB;
    private javax.swing.JLabel countBT;
    private javax.swing.JLabel countC;
    private javax.swing.JLabel countC1;
    private javax.swing.JLabel countE;
    private javax.swing.JLabel countExpo;
    private javax.swing.JLabel countP;
    private javax.swing.JLabel countP1;
    private javax.swing.JLabel countS;
    private javax.swing.JLabel countS1;
    private javax.swing.JLabel countSp;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
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
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
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
    private javax.swing.JScrollPane jScrollPane5;
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
    private javax.swing.JLabel sumB;
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
    private javax.swing.JTextField txtBoothType;
    private javax.swing.JTextField txtBooths;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextArea txtExDescription;
    private javax.swing.JTextField txtFindBT;
    private javax.swing.JTextField txtFindBooth;
    private javax.swing.JTextField txtFindEhi;
    private javax.swing.JTextField txtFindExpo;
    private javax.swing.JTextField txtFindStaff;
    private javax.swing.JTextField txtFindStaff1;
    private javax.swing.JTextField txtFindUser;
    private javax.swing.JTextField txtLength;
    private javax.swing.JTextField txtNumBooth;
    private javax.swing.JTextField txtPKeyword;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtRemain;
    private javax.swing.JTextField txtSponsor;
    private javax.swing.JTextField txtStartDate;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JTextField txtlastChange;
    private javax.swing.JTextField txtregDate;
    private javax.swing.JTextField txtreturnDate;
    private javax.swing.JTextField txtsentDate;
    private javax.swing.JTextField txtuserCre;
    // End of variables declaration//GEN-END:variables

}
