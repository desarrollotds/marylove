
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FichaIngreso extends javax.swing.JFrame {

    public FichaIngreso() {
        initComponents();
    }

    public JComboBox<String> getCbxParent() {
        return cbxParent;
    }

    public void setCbxParent(JComboBox<String> cbxParent) {
        this.cbxParent = cbxParent;
    }

    public JLabel getLblCodAcomp() {
        return lblCodAcomp;
    }

    public void setLblCodAcomp(JLabel lblCodAcomp) {
        this.lblCodAcomp = lblCodAcomp;
    }

    public JButton getBtnCancelar1() {
        return btnCancelar1;
    }

    public void setBtnCancelar1(JButton btnCancelar1) {
        this.btnCancelar1 = btnCancelar1;
    }

    public JButton getBtnGuardar1() {
        return btnGuardar1;
    }

    public void setBtnGuardar1(JButton btnGuardar1) {
        this.btnGuardar1 = btnGuardar1;
    }

    public JButton getBtnRefresHijos1() {
        return btnRefresHijos1;
    }

    public void setBtnRefresHijos1(JButton btnRefresHijos1) {
        this.btnRefresHijos1 = btnRefresHijos1;
    }

    public JDialog getDlgEditarAcomp() {
        return dlgEditarAcomp;
    }

    public void setDlgEditarAcomp(JDialog dlgEditarAcomp) {
        this.dlgEditarAcomp = dlgEditarAcomp;
    }

    public JDateChooser getDtcFechNac() {
        return dtcFechNac;
    }

    public void setDtcFechNac(JDateChooser dtcFechNac) {
        this.dtcFechNac = dtcFechNac;
    }

    public JTextField getTxCed() {
        return txCed;
    }

    public void setTxCed(JTextField txCed) {
        this.txCed = txCed;
    }

    public JTextField getTxtApell() {
        return txtApell;
    }

    public void setTxtApell(JTextField txtApell) {
        this.txtApell = txtApell;
    }

    public JTextField getTxtNom() {
        return txtNom;
    }

    public void setTxtNom(JTextField txtNom) {
        this.txtNom = txtNom;
    }

    public JTable getTblAcomp() {
        return tblAcomp;
    }

    public void setTblAcomp(JTable tblAcomp) {
        this.tblAcomp = tblAcomp;
    }

    public JButton getBtnActHijAco() {
        return btnActHijAco;
    }

    public void setBtnActHijAco(JButton btnActHijAco) {
        this.btnActHijAco = btnActHijAco;
    }

    public JButton getBtnAgregarIntiEdu() {
        return btnAgregarIntiEdu;
    }

    public void setBtnAgregarIntiEdu(JButton btnAgregarIntiEdu) {
        this.btnAgregarIntiEdu = btnAgregarIntiEdu;
    }

    public JButton getBtnCancEdit() {
        return btnCancEdit;
    }

    public void setBtnCancEdit(JButton btnCancEdit) {
        this.btnCancEdit = btnCancEdit;
    }

    public JButton getBtnGuardEdit() {
        return btnGuardEdit;
    }

    public void setBtnGuardEdit(JButton btnGuardEdit) {
        this.btnGuardEdit = btnGuardEdit;
    }

    public JComboBox<String> getCbxAnioEscEdit() {
        return cbxAnioEscEdit;
    }

    public void setCbxAnioEscEdit(JComboBox<String> cbxAnioEscEdit) {
        this.cbxAnioEscEdit = cbxAnioEscEdit;
    }

    public JComboBox<String> getCbxIntiEducEdit() {
        return cbxIntiEducEdit;
    }

    public void setCbxIntiEducEdit(JComboBox<String> cbxIntiEducEdit) {
        this.cbxIntiEducEdit = cbxIntiEducEdit;
    }

    public JComboBox<String> getCbxNivelAcadEdit() {
        return cbxNivelAcadEdit;
    }

    public void setCbxNivelAcadEdit(JComboBox<String> cbxNivelAcadEdit) {
        this.cbxNivelAcadEdit = cbxNivelAcadEdit;
    }

    public JComboBox<String> getCbxSexEdit() {
        return cbxSexEdit;
    }

    public void setCbxSexEdit(JComboBox<String> cbxSexEdit) {
        this.cbxSexEdit = cbxSexEdit;
    }

    public JDateChooser getDcFecNacEdit() {
        return dcFecNacEdit;
    }

    public void setDcFecNacEdit(JDateChooser dcFecNacEdit) {
        this.dcFecNacEdit = dcFecNacEdit;
    }

    public JDialog getDlgEditarHijosAcom() {
        return dlgEditarHijosAcom;
    }

    public void setDlgEditarHijosAcom(JDialog dlgEditarHijosAcom) {
        this.dlgEditarHijosAcom = dlgEditarHijosAcom;
    }

    public JLabel getLblCodEditHijoDlg() {
        return lblCodEditHijoDlg;
    }

    public void setLblCodEditHijoDlg(JLabel lblCodEditHijoDlg) {
        this.lblCodEditHijoDlg = lblCodEditHijoDlg;
    }

    public JPanel getPnlCabecera() {
        return pnlCabecera;
    }

    public void setPnlCabecera(JPanel pnlCabecera) {
        this.pnlCabecera = pnlCabecera;
    }

    public JTextField getTxtApellEdit() {
        return txtApellEdit;
    }

    public void setTxtApellEdit(JTextField txtApellEdit) {
        this.txtApellEdit = txtApellEdit;
    }

    public JTextField getTxtCedEdit() {
        return txtCedEdit;
    }

    public void setTxtCedEdit(JTextField txtCedEdit) {
        this.txtCedEdit = txtCedEdit;
    }

    public JTextField getTxtNomEdit() {
        return txtNomEdit;
    }

    public void setTxtNomEdit(JTextField txtNomEdit) {
        this.txtNomEdit = txtNomEdit;
    }

    public JButton getBtnAgreAcomp() {
        return btnAgreAcomp;
    }

    public void setBtnAgreAcomp(JButton btnAgreAcomp) {
        this.btnAgreAcomp = btnAgreAcomp;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JDialog getDlgEditar() {
        return DlgEditar;
    }

    public void setDlgEditar(JDialog DlgEditar) {
        this.DlgEditar = DlgEditar;
    }

    public JButton getBtnCancelarEdit() {
        return btnCancelarEdit;
    }

    public void setBtnCancelarEdit(JButton btnCancelarEdit) {
        this.btnCancelarEdit = btnCancelarEdit;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(JButton btnEdit) {
        this.btnEdit = btnEdit;
    }

    public JLabel getLblCodEdit() {
        return lblCodEdit;
    }

    public void setLblCodEdit(JLabel lblCodEdit) {
        this.lblCodEdit = lblCodEdit;
    }

    public JTextArea getTxaReferidaEdit() {
        return txaReferidaEdit;
    }

    public void setTxaReferidaEdit(JTextArea txaReferidaEdit) {
        this.txaReferidaEdit = txaReferidaEdit;
    }

    public JTextField getTxtDormiEdit() {
        return txtDormiEdit;
    }

    public void setTxtDormiEdit(JTextField txtDormiEdit) {
        this.txtDormiEdit = txtDormiEdit;
    }

    public JButton getBtnRefresHijos() {
        return btnRefresHijos;
    }

    public void setBtnRefresHijos(JButton btnRefresHijos) {
        this.btnRefresHijos = btnRefresHijos;
    }

    public JButton getBtnRefreshArtEntBenef() {
        return btnRefreshArtEntBenef;
    }

    public void setBtnRefreshArtEntBenef(JButton btnRefreshArtEntBenef) {
        this.btnRefreshArtEntBenef = btnRefreshArtEntBenef;
    }

    public JButton getBtnRefreshDorRef() {
        return btnRefreshDorRef;
    }

    public void setBtnRefreshDorRef(JButton btnRefreshDorRef) {
        this.btnRefreshDorRef = btnRefreshDorRef;
    }

    public JPanel getPnlArticulosBeneficiaria() {
        return pnlArticulosBeneficiaria;
    }

    public void setPnlArticulosBeneficiaria(JPanel pnlArticulosBeneficiaria) {
        this.pnlArticulosBeneficiaria = pnlArticulosBeneficiaria;
    }

    public JPanel getPnlArticulosBeneficiaria1() {
        return pnlArticulosBeneficiaria1;
    }

    public void setPnlArticulosBeneficiaria1(JPanel pnlArticulosBeneficiaria1) {
        this.pnlArticulosBeneficiaria1 = pnlArticulosBeneficiaria1;
    }

    public JPanel getPnlArticulosFundacion() {
        return pnlArticulosFundacion;
    }

    public void setPnlArticulosFundacion(JPanel pnlArticulosFundacion) {
        this.pnlArticulosFundacion = pnlArticulosFundacion;
    }

    public JPanel getPnlArticulosFundacion1() {
        return pnlArticulosFundacion1;
    }

    public void setPnlArticulosFundacion1(JPanel pnlArticulosFundacion1) {
        this.pnlArticulosFundacion1 = pnlArticulosFundacion1;
    }

    public JPanel getPnlDormitorio() {
        return pnlDormitorio;
    }

    public void setPnlDormitorio(JPanel pnlDormitorio) {
        this.pnlDormitorio = pnlDormitorio;
    }

    public JPanel getPnlDormitorio1() {
        return pnlDormitorio1;
    }

    public void setPnlDormitorio1(JPanel pnlDormitorio1) {
        this.pnlDormitorio1 = pnlDormitorio1;
    }

    public JPanel getPnlFichaIngre() {
        return pnlFichaIngre;
    }

    public void setPnlFichaIngre(JPanel pnlFichaIngre) {
        this.pnlFichaIngre = pnlFichaIngre;
    }

    public JPanel getPnlFichaIngre1() {
        return pnlFichaIngre1;
    }

    public void setPnlFichaIngre1(JPanel pnlFichaIngre1) {
        this.pnlFichaIngre1 = pnlFichaIngre1;
    }

    public JPanel getPnlHijos() {
        return pnlHijos;
    }

    public void setPnlHijos(JPanel pnlHijos) {
        this.pnlHijos = pnlHijos;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnAgregarArticulosFundacion() {
        return btnAgregarArticulosFundacion;
    }

    public void setBtnAgregarArticulosFundacion(JButton btnAgregarArticulosFundacion) {
        this.btnAgregarArticulosFundacion = btnAgregarArticulosFundacion;
    }

    public JButton getBtnAgregarArticulosVictima() {
        return btnAgregarArticulosVictima;
    }

    public void setBtnAgregarArticulosVictima(JButton btnAgregarArticulosVictima) {
        this.btnAgregarArticulosVictima = btnAgregarArticulosVictima;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnDlgActualizar() {
        return btnDlgActualizar;
    }

    public void setBtnDlgActualizar(JButton btnDlgActualizar) {
        this.btnDlgActualizar = btnDlgActualizar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnIngresarHij() {
        return btnIngresarHij;
    }

    public void setBtnIngresarHij(JButton btnIngresarHij) {
        this.btnIngresarHij = btnIngresarHij;
    }

    public JButton getBtnVerRegistros() {
        return btnVerRegistros;
    }

    public void setBtnVerRegistros(JButton btnVerRegistros) {
        this.btnVerRegistros = btnVerRegistros;
    }

    public JDialog getDlgRegistro() {
        return dlgRegistro;
    }

    public void setDlgRegistro(JDialog dlgRegistro) {
        this.dlgRegistro = dlgRegistro;
    }

    public JDateChooser getJdcFecha() {
        return jdcFecha;
    }

    public void setJdcFecha(JDateChooser jdcFecha) {
        this.jdcFecha = jdcFecha;
    }

    public JLabel getLblCant() {
        return lblCant;
    }

    public void setLblCant(JLabel lblCant) {
        this.lblCant = lblCant;
    }

    public JLabel getLblCant1() {
        return lblCant1;
    }

    public void setLblCant1(JLabel lblCant1) {
        this.lblCant1 = lblCant1;
    }

    public JLabel getLblCodHijoa() {
        return lblCodHijoa;
    }

    public void setLblCodHijoa(JLabel lblCodHijoa) {
        this.lblCodHijoa = lblCodHijoa;
    }

    public JLabel getLblCodigoArtEntFund() {
        return lblCodigoArtEntFund;
    }

    public void setLblCodigoArtEntFund(JLabel lblCodigoArtEntFund) {
        this.lblCodigoArtEntFund = lblCodigoArtEntFund;
    }

    public JLabel getLblCodigoEntBenef() {
        return lblCodigoEntBenef;
    }

    public void setLblCodigoEntBenef(JLabel lblCodigoEntBenef) {
        this.lblCodigoEntBenef = lblCodigoEntBenef;
    }

    public JLabel getLblCodigoIngreso() {
        return lblCodigoIngreso;
    }

    public void setLblCodigoIngreso(JLabel lblCodigoIngreso) {
        this.lblCodigoIngreso = lblCodigoIngreso;
    }

    public JPanel getPnlHijos1() {
        return pnlHijos1;
    }

    public void setPnlHijos1(JPanel pnlHijos1) {
        this.pnlHijos1 = pnlHijos1;
    }

    public JTable getTblArticulosBeneficiaria() {
        return tblArticulosBeneficiaria;
    }

    public void setTblArticulosBeneficiaria(JTable tblArticulosBeneficiaria) {
        this.tblArticulosBeneficiaria = tblArticulosBeneficiaria;
    }

    public JTable getTblArticulosBeneficiaria1() {
        return tblArticulosBeneficiaria1;
    }

    public void setTblArticulosBeneficiaria1(JTable tblArticulosBeneficiaria1) {
        this.tblArticulosBeneficiaria1 = tblArticulosBeneficiaria1;
    }

    public JTable getTblArticulosFundacion() {
        return tblArticulosFundacion;
    }

    public void setTblArticulosFundacion(JTable tblArticulosFundacion) {
        this.tblArticulosFundacion = tblArticulosFundacion;
    }

    public JTable getTblArticulosFundacion1() {
        return tblArticulosFundacion1;
    }

    public void setTblArticulosFundacion1(JTable tblArticulosFundacion1) {
        this.tblArticulosFundacion1 = tblArticulosFundacion1;
    }

    public JTable getTblDorRef() {
        return tblDorRef;
    }

    public void setTblDorRef(JTable tblDorRef) {
        this.tblDorRef = tblDorRef;
    }

    public JTable getTblHijos() {
        return tblHijos;
    }

    public void setTblHijos(JTable tblHijos) {
        this.tblHijos = tblHijos;
    }

    public JTable getTblHijos1() {
        return tblHijos1;
    }

    public void setTblHijos1(JTable tblHijos1) {
        this.tblHijos1 = tblHijos1;
    }

    public JTextArea getTxaReferida() {
        return txaReferida;
    }

    public void setTxaReferida(JTextArea txaReferida) {
        this.txaReferida = txaReferida;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JTextField getTxtDlgBusar() {
        return txtDlgBusar;
    }

    public void setTxtDlgBusar(JTextField txtDlgBusar) {
        this.txtDlgBusar = txtDlgBusar;
    }

    public JTextField getTxtDormitorio() {
        return txtDormitorio;
    }

    public void setTxtDormitorio(JTextField txtDormitorio) {
        this.txtDormitorio = txtDormitorio;
    }

    public JTextField getTxtNombresApellidos() {
        return txtNombresApellidos;
    }

    public void setTxtNombresApellidos(JTextField txtNombresApellidos) {
        this.txtNombresApellidos = txtNombresApellidos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgRegistro = new javax.swing.JDialog();
        pnlFichaIngre1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnlDormitorio1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDorRef = new javax.swing.JTable();
        btnRefreshDorRef = new javax.swing.JButton();
        pnlArticulosBeneficiaria1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblArticulosBeneficiaria1 = new javax.swing.JTable();
        btnRefreshArtEntBenef = new javax.swing.JButton();
        pnlArticulosFundacion1 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblArticulosFundacion1 = new javax.swing.JTable();
        btnDlgActualizar = new javax.swing.JButton();
        pnlHijos1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblHijos1 = new javax.swing.JTable();
        btnRefresHijos = new javax.swing.JButton();
        pnlHijos2 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblAcomp = new javax.swing.JTable();
        btnRefresHijos1 = new javax.swing.JButton();
        txtDlgBusar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        DlgEditar = new javax.swing.JDialog();
        pnlDormitorio2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtDormiEdit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaReferidaEdit = new javax.swing.JTextArea();
        btnEdit = new javax.swing.JButton();
        btnCancelarEdit = new javax.swing.JButton();
        lblCodEdit = new javax.swing.JLabel();
        dlgEditarHijosAcom = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        dcFecNacEdit = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        btnGuardEdit = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnCancEdit = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNomEdit = new javax.swing.JTextField();
        txtApellEdit = new javax.swing.JTextField();
        cbxAnioEscEdit = new javax.swing.JComboBox<>();
        cbxIntiEducEdit = new javax.swing.JComboBox<>();
        btnAgregarIntiEdu = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        cbxSexEdit = new javax.swing.JComboBox<>();
        cbxNivelAcadEdit = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtCedEdit = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        lblCodEditHijoDlg = new javax.swing.JLabel();
        dlgEditarAcomp = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txCed = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtApell = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        dtcFechNac = new com.toedter.calendar.JDateChooser();
        cbxParent = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        lblCodAcomp = new javax.swing.JLabel();
        pnlFichaIngre = new javax.swing.JPanel();
        pnlCabecera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombresApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        btnVerRegistros = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlDormitorio = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDormitorio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaReferida = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCodigoIngreso = new javax.swing.JLabel();
        pnlHijos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHijos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnIngresarHij = new javax.swing.JButton();
        lblCodHijoa = new javax.swing.JLabel();
        btnAgreAcomp = new javax.swing.JButton();
        btnActHijAco = new javax.swing.JButton();
        pnlArticulosBeneficiaria = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnAgregarArticulosVictima = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblArticulosBeneficiaria = new javax.swing.JTable();
        lblCant = new javax.swing.JLabel();
        lblCodigoEntBenef = new javax.swing.JLabel();
        pnlArticulosFundacion = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblArticulosFundacion = new javax.swing.JTable();
        btnAgregarArticulosFundacion = new javax.swing.JButton();
        lblCant1 = new javax.swing.JLabel();
        lblCodigoArtEntFund = new javax.swing.JLabel();

        tblDorRef.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cédula", "Nombre Apellido", "Dormitorio", "Referido por: ", "Fecha Ingreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblDorRef);

        btnRefreshDorRef.setText("Refrescar");

        javax.swing.GroupLayout pnlDormitorio1Layout = new javax.swing.GroupLayout(pnlDormitorio1);
        pnlDormitorio1.setLayout(pnlDormitorio1Layout);
        pnlDormitorio1Layout.setHorizontalGroup(
            pnlDormitorio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDormitorio1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefreshDorRef)
                .addContainerGap())
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
        );
        pnlDormitorio1Layout.setVerticalGroup(
            pnlDormitorio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDormitorio1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefreshDorRef)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab(" (1) Dormitorio /Referida", pnlDormitorio1);

        tblArticulosBeneficiaria1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Nombre Apellido", "Articulo", "Cantidad", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblArticulosBeneficiaria1);

        btnRefreshArtEntBenef.setText("Refrescar");

        javax.swing.GroupLayout pnlArticulosBeneficiaria1Layout = new javax.swing.GroupLayout(pnlArticulosBeneficiaria1);
        pnlArticulosBeneficiaria1.setLayout(pnlArticulosBeneficiaria1Layout);
        pnlArticulosBeneficiaria1Layout.setHorizontalGroup(
            pnlArticulosBeneficiaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlArticulosBeneficiaria1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefreshArtEntBenef)
                .addContainerGap())
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
        );
        pnlArticulosBeneficiaria1Layout.setVerticalGroup(
            pnlArticulosBeneficiaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosBeneficiaria1Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefreshArtEntBenef)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("(2) Artículos que entrega la beneficiaria ", pnlArticulosBeneficiaria1);

        tblArticulosFundacion1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Nombre Apellido", "Articulo", "Cantidad", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblArticulosFundacion1);

        btnDlgActualizar.setText("Refrescar");

        javax.swing.GroupLayout pnlArticulosFundacion1Layout = new javax.swing.GroupLayout(pnlArticulosFundacion1);
        pnlArticulosFundacion1.setLayout(pnlArticulosFundacion1Layout);
        pnlArticulosFundacion1Layout.setHorizontalGroup(
            pnlArticulosFundacion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlArticulosFundacion1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDlgActualizar)
                .addContainerGap())
        );
        pnlArticulosFundacion1Layout.setVerticalGroup(
            pnlArticulosFundacion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosFundacion1Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDlgActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("(3) Artículos que entrega la fundación ", pnlArticulosFundacion1);

        tblHijos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombres Apellidos Acojida", "Nombre Aepllido del acompañante", "Cédula", "Fecha nacimiento", "Edad", "Parentesco", "Sexo", "Nivel académico", "Año escolar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblHijos1);
        if (tblHijos1.getColumnModel().getColumnCount() > 0) {
            tblHijos1.getColumnModel().getColumn(1).setHeaderValue("Nombres Apellidos Acojida");
            tblHijos1.getColumnModel().getColumn(7).setHeaderValue("Sexo");
            tblHijos1.getColumnModel().getColumn(8).setHeaderValue("Nivel académico");
            tblHijos1.getColumnModel().getColumn(9).setHeaderValue("Año escolar");
        }

        btnRefresHijos.setText("Refrescar");

        javax.swing.GroupLayout pnlHijos1Layout = new javax.swing.GroupLayout(pnlHijos1);
        pnlHijos1.setLayout(pnlHijos1Layout);
        pnlHijos1Layout.setHorizontalGroup(
            pnlHijos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHijos1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresHijos)
                .addContainerGap())
        );
        pnlHijos1Layout.setVerticalGroup(
            pnlHijos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHijos1Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresHijos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab(" (4) Hijos /Hijas con los que Ingresa", pnlHijos1);

        tblAcomp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Nombre", "Apellido", "Fecha nacimiento", "Edad", "Parentesco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(tblAcomp);

        btnRefresHijos1.setText("Refrescar");

        javax.swing.GroupLayout pnlHijos2Layout = new javax.swing.GroupLayout(pnlHijos2);
        pnlHijos2.setLayout(pnlHijos2Layout);
        pnlHijos2Layout.setHorizontalGroup(
            pnlHijos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHijos2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresHijos1)
                .addContainerGap())
        );
        pnlHijos2Layout.setVerticalGroup(
            pnlHijos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHijos2Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresHijos1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab(" (5)Personas con las que Ingresa", pnlHijos2);

        jLabel11.setText("Buscar: ");

        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout pnlFichaIngre1Layout = new javax.swing.GroupLayout(pnlFichaIngre1);
        pnlFichaIngre1.setLayout(pnlFichaIngre1Layout);
        pnlFichaIngre1Layout.setHorizontalGroup(
            pnlFichaIngre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFichaIngre1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDlgBusar, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane2)
        );
        pnlFichaIngre1Layout.setVerticalGroup(
            pnlFichaIngre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaIngre1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFichaIngre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDlgBusar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgRegistroLayout = new javax.swing.GroupLayout(dlgRegistro.getContentPane());
        dlgRegistro.getContentPane().setLayout(dlgRegistroLayout);
        dlgRegistroLayout.setHorizontalGroup(
            dlgRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFichaIngre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgRegistroLayout.setVerticalGroup(
            dlgRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFichaIngre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel12.setText("Dormitorio:");

        jLabel13.setText("Referida por:(Institución, persona acompañante, contactos)");

        txaReferidaEdit.setColumns(20);
        txaReferidaEdit.setLineWrap(true);
        txaReferidaEdit.setRows(5);
        txaReferidaEdit.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txaReferidaEdit);

        btnEdit.setText("Editar");

        btnCancelarEdit.setText("Cancelar");

        lblCodEdit.setText("Codigo: ");

        javax.swing.GroupLayout pnlDormitorio2Layout = new javax.swing.GroupLayout(pnlDormitorio2);
        pnlDormitorio2.setLayout(pnlDormitorio2Layout);
        pnlDormitorio2Layout.setHorizontalGroup(
            pnlDormitorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDormitorio2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlDormitorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDormitorio2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDormitorio2Layout.createSequentialGroup()
                        .addGroup(pnlDormitorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDormitorio2Layout.createSequentialGroup()
                                .addGroup(pnlDormitorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDormitorio2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtDormiEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDormitorio2Layout.createSequentialGroup()
                                        .addComponent(btnCancelarEdit)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEdit)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                            .addGroup(pnlDormitorio2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblCodEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))))
        );
        pnlDormitorio2Layout.setVerticalGroup(
            pnlDormitorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDormitorio2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDormitorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDormiEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(pnlDormitorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnCancelarEdit))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout DlgEditarLayout = new javax.swing.GroupLayout(DlgEditar.getContentPane());
        DlgEditar.getContentPane().setLayout(DlgEditarLayout);
        DlgEditarLayout.setHorizontalGroup(
            DlgEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
            .addGroup(DlgEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DlgEditarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDormitorio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        DlgEditarLayout.setVerticalGroup(
            DlgEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(DlgEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DlgEditarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDormitorio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dcFecNacEdit.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 16)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("EDITAR HIJOS/AS - PERSONAS A CARGO");

        btnGuardEdit.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        btnGuardEdit.setText("Guardar");

        jLabel15.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        jLabel15.setText("Nombre: ");

        btnCancEdit.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        btnCancEdit.setText("Cancelar");

        jLabel16.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        jLabel16.setText("Apellido: ");

        jLabel17.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        jLabel17.setText("Fecha de Nacimiento: ");

        jLabel18.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        jLabel18.setText("Institución Educativa:");

        jLabel19.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        jLabel19.setText("Año Escolar: ");

        txtNomEdit.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        txtNomEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomEditActionPerformed(evt);
            }
        });

        txtApellEdit.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N

        cbxAnioEscEdit.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N

        cbxIntiEducEdit.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N

        btnAgregarIntiEdu.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        btnAgregarIntiEdu.setText("Agregar");

        jLabel20.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        jLabel20.setText("Sexo:");

        cbxSexEdit.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        cbxSexEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccione>", "F", "M", "?" }));

        cbxNivelAcadEdit.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        jLabel21.setText("Nivel Academico:");

        txtCedEdit.setEditable(false);
        txtCedEdit.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 13)); // NOI18N
        jLabel22.setText("Cedula:");

        lblCodEditHijoDlg.setText("?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator2)
                .addGap(54, 54, 54))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCodEditHijoDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel18)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbxIntiEducEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel20)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbxSexEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(dcFecNacEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel16)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtApellEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel15)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtNomEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel22)
                                                        .addGap(126, 126, 126)
                                                        .addComponent(txtCedEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAgregarIntiEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel21)
                                                    .addComponent(jLabel19))
                                                .addGap(71, 71, 71)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbxAnioEscEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbxNivelAcadEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jSeparator1))
                                .addGap(134, 134, 134))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardEdit)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblCodEditHijoDlg))
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel22)
                                                    .addComponent(txtCedEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(txtNomEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtApellEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(dcFecNacEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbxSexEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(btnAgregarIntiEdu))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbxIntiEducEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addGap(18, 18, 18)
                                .addComponent(cbxNivelAcadEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(cbxAnioEscEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancEdit)
                    .addComponent(btnGuardEdit))
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgEditarHijosAcomLayout = new javax.swing.GroupLayout(dlgEditarHijosAcom.getContentPane());
        dlgEditarHijosAcom.getContentPane().setLayout(dlgEditarHijosAcomLayout);
        dlgEditarHijosAcomLayout.setHorizontalGroup(
            dlgEditarHijosAcomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgEditarHijosAcomLayout.setVerticalGroup(
            dlgEditarHijosAcomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel23.setText("Cédula:");

        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        jLabel24.setText("Nombre:");

        jLabel25.setText("Apellido");

        jLabel26.setText("Fecha Nacimiento");

        jLabel27.setText("Parentesco:");

        cbxParent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setText(" Personas con las que ingresa");

        btnGuardar1.setText("editar");

        btnCancelar1.setText("Cancelar");

        lblCodAcomp.setText("?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnCancelar1)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27))
                                .addGap(189, 189, 189)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dtcFechNac, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                    .addComponent(txCed)
                                    .addComponent(txtNom)
                                    .addComponent(txtApell)
                                    .addComponent(cbxParent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCodAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lblCodAcomp))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addComponent(txtApell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtcFechNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar1)
                    .addComponent(btnCancelar1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgEditarAcompLayout = new javax.swing.GroupLayout(dlgEditarAcomp.getContentPane());
        dlgEditarAcomp.getContentPane().setLayout(dlgEditarAcompLayout);
        dlgEditarAcompLayout.setHorizontalGroup(
            dlgEditarAcompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgEditarAcompLayout.setVerticalGroup(
            dlgEditarAcompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ficha de Ingreso");

        jLabel2.setText("Nombres y Apellidos: ");

        jLabel3.setText("Fecha de Ingreso:");

        txtNombresApellidos.setEditable(false);

        jLabel4.setText("Código:");

        txtCodigo.setEditable(false);

        jLabel9.setText("Cedula: ");

        btnVerRegistros.setText("Ver Registros");

        btnActualizar.setText("Actulizar");

        btnNuevo.setText("Nuevo");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(txtNombresApellidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVerRegistros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo)))
                .addContainerGap())
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtNombresApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnVerRegistros)
                    .addComponent(btnNuevo)))
        );

        jLabel5.setText("Dormitorio:");

        jLabel6.setText("Referida por:(Institución, persona acompañante, contactos)");

        txaReferida.setColumns(20);
        txaReferida.setLineWrap(true);
        txaReferida.setRows(5);
        txaReferida.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txaReferida);

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        lblCodigoIngreso.setText("Codigo: ");

        javax.swing.GroupLayout pnlDormitorioLayout = new javax.swing.GroupLayout(pnlDormitorio);
        pnlDormitorio.setLayout(pnlDormitorioLayout);
        pnlDormitorioLayout.setHorizontalGroup(
            pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDormitorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDormitorioLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDormitorioLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(txtDormitorio, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(762, 762, 762))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDormitorioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblCodigoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDormitorioLayout.createSequentialGroup()
                        .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDormitorioLayout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar))
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlDormitorioLayout.setVerticalGroup(
            pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDormitorioLayout.createSequentialGroup()
                .addComponent(lblCodigoIngreso)
                .addGap(12, 12, 12)
                .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDormitorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab(" (1) Dormitorio /Referida", pnlDormitorio);

        tblHijos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre Apellido", "Fecha nacimiento", "Edad", "Parentesco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblHijos);

        jLabel7.setText("Hijos/ Hijas o Personas con las que ingresa");

        btnIngresarHij.setText("Agregar hijos");

        lblCodHijoa.setText("Codigo: ");

        btnAgreAcomp.setText("Agregar Acompañante");

        btnActHijAco.setText("Actulizar");

        javax.swing.GroupLayout pnlHijosLayout = new javax.swing.GroupLayout(pnlHijos);
        pnlHijos.setLayout(pnlHijosLayout);
        pnlHijosLayout.setHorizontalGroup(
            pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHijosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCodHijoa, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlHijosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                    .addGroup(pnlHijosLayout.createSequentialGroup()
                        .addGroup(pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(pnlHijosLayout.createSequentialGroup()
                                .addComponent(btnIngresarHij)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgreAcomp)
                                .addGap(18, 18, 18)
                                .addComponent(btnActHijAco)))
                        .addContainerGap(682, Short.MAX_VALUE))))
        );
        pnlHijosLayout.setVerticalGroup(
            pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHijosLayout.createSequentialGroup()
                .addComponent(lblCodHijoa)
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarHij)
                    .addComponent(btnAgreAcomp)
                    .addComponent(btnActHijAco))
                .addContainerGap())
        );

        jTabbedPane1.addTab(" Hijos /Hijas o personas con las que Ingresa", pnlHijos);

        jLabel8.setText("Artículos que entrega la beneficiaria");

        btnAgregarArticulosVictima.setText("Agregar Artículos");

        tblArticulosBeneficiaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Articulo", "Cantidad", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblArticulosBeneficiaria);

        lblCant.setText(" Cantidad");

        lblCodigoEntBenef.setText("Codigo: ");

        javax.swing.GroupLayout pnlArticulosBeneficiariaLayout = new javax.swing.GroupLayout(pnlArticulosBeneficiaria);
        pnlArticulosBeneficiaria.setLayout(pnlArticulosBeneficiariaLayout);
        pnlArticulosBeneficiariaLayout.setHorizontalGroup(
            pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosBeneficiariaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCant, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlArticulosBeneficiariaLayout.createSequentialGroup()
                .addGroup(pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlArticulosBeneficiariaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlArticulosBeneficiariaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarArticulosVictima)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlArticulosBeneficiariaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblCodigoEntBenef, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlArticulosBeneficiariaLayout.setVerticalGroup(
            pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosBeneficiariaLayout.createSequentialGroup()
                .addComponent(lblCodigoEntBenef)
                .addGap(1, 1, 1)
                .addGroup(pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnAgregarArticulosVictima))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCant)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Artículos que entrega la beneficiaria ", pnlArticulosBeneficiaria);

        jLabel10.setText("Artículos que entrega la beneficiaria");

        tblArticulosFundacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Articulo", "Cantidad", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblArticulosFundacion);

        btnAgregarArticulosFundacion.setText("Agregar Artículos");

        lblCant1.setText("Total: ");

        lblCodigoArtEntFund.setText("Codigo: ");

        javax.swing.GroupLayout pnlArticulosFundacionLayout = new javax.swing.GroupLayout(pnlArticulosFundacion);
        pnlArticulosFundacion.setLayout(pnlArticulosFundacionLayout);
        pnlArticulosFundacionLayout.setHorizontalGroup(
            pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCant1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlArticulosFundacionLayout.createSequentialGroup()
                .addGroup(pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE))
                    .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarArticulosFundacion)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlArticulosFundacionLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblCodigoArtEntFund, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlArticulosFundacionLayout.setVerticalGroup(
            pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                .addComponent(lblCodigoArtEntFund)
                .addGap(1, 1, 1)
                .addGroup(pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btnAgregarArticulosFundacion))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCant1)
                .addContainerGap())
        );

        jTabbedPane1.addTab(" Artículos que entrega la fundación ", pnlArticulosFundacion);

        javax.swing.GroupLayout pnlFichaIngreLayout = new javax.swing.GroupLayout(pnlFichaIngre);
        pnlFichaIngre.setLayout(pnlFichaIngreLayout);
        pnlFichaIngreLayout.setHorizontalGroup(
            pnlFichaIngreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaIngreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFichaIngreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFichaIngreLayout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addComponent(pnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlFichaIngreLayout.setVerticalGroup(
            pnlFichaIngreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaIngreLayout.createSequentialGroup()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFichaIngre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFichaIngre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEditActionPerformed

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaIngreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DlgEditar;
    private javax.swing.JButton btnActHijAco;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgreAcomp;
    private javax.swing.JButton btnAgregarArticulosFundacion;
    private javax.swing.JButton btnAgregarArticulosVictima;
    private javax.swing.JButton btnAgregarIntiEdu;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancEdit;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnCancelarEdit;
    private javax.swing.JButton btnDlgActualizar;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGuardEdit;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnIngresarHij;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRefresHijos;
    private javax.swing.JButton btnRefresHijos1;
    private javax.swing.JButton btnRefreshArtEntBenef;
    private javax.swing.JButton btnRefreshDorRef;
    private javax.swing.JButton btnVerRegistros;
    private javax.swing.JComboBox<String> cbxAnioEscEdit;
    private javax.swing.JComboBox<String> cbxIntiEducEdit;
    private javax.swing.JComboBox<String> cbxNivelAcadEdit;
    private javax.swing.JComboBox<String> cbxParent;
    private javax.swing.JComboBox<String> cbxSexEdit;
    private com.toedter.calendar.JDateChooser dcFecNacEdit;
    private javax.swing.JDialog dlgEditarAcomp;
    private javax.swing.JDialog dlgEditarHijosAcom;
    private javax.swing.JDialog dlgRegistro;
    private com.toedter.calendar.JDateChooser dtcFechNac;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel lblCant;
    private javax.swing.JLabel lblCant1;
    private javax.swing.JLabel lblCodAcomp;
    private javax.swing.JLabel lblCodEdit;
    private javax.swing.JLabel lblCodEditHijoDlg;
    private javax.swing.JLabel lblCodHijoa;
    private javax.swing.JLabel lblCodigoArtEntFund;
    private javax.swing.JLabel lblCodigoEntBenef;
    private javax.swing.JLabel lblCodigoIngreso;
    private javax.swing.JPanel pnlArticulosBeneficiaria;
    private javax.swing.JPanel pnlArticulosBeneficiaria1;
    private javax.swing.JPanel pnlArticulosFundacion;
    private javax.swing.JPanel pnlArticulosFundacion1;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlDormitorio;
    private javax.swing.JPanel pnlDormitorio1;
    private javax.swing.JPanel pnlDormitorio2;
    private javax.swing.JPanel pnlFichaIngre;
    private javax.swing.JPanel pnlFichaIngre1;
    private javax.swing.JPanel pnlHijos;
    private javax.swing.JPanel pnlHijos1;
    private javax.swing.JPanel pnlHijos2;
    private javax.swing.JTable tblAcomp;
    private javax.swing.JTable tblArticulosBeneficiaria;
    private javax.swing.JTable tblArticulosBeneficiaria1;
    private javax.swing.JTable tblArticulosFundacion;
    private javax.swing.JTable tblArticulosFundacion1;
    private javax.swing.JTable tblDorRef;
    private javax.swing.JTable tblHijos;
    private javax.swing.JTable tblHijos1;
    private javax.swing.JTextField txCed;
    private javax.swing.JTextArea txaReferida;
    private javax.swing.JTextArea txaReferidaEdit;
    private javax.swing.JTextField txtApell;
    private javax.swing.JTextField txtApellEdit;
    private javax.swing.JTextField txtCedEdit;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDlgBusar;
    private javax.swing.JTextField txtDormiEdit;
    private javax.swing.JTextField txtDormitorio;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNomEdit;
    private javax.swing.JTextField txtNombresApellidos;
    // End of variables declaration//GEN-END:variables
}
