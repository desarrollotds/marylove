
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class FichaPrimerEncuentro extends javax.swing.JFrame {

    /**
     * Creates new form FichaPrimerEncuentro
     */
    private JScrollPane scrollpane;

    public FichaPrimerEncuentro() {
        initComponents();
    }

    public JPanel getPanelInquietudes1() {
        return PanelInquietudes1;
    }

    public void setPanelInquietudes1(JPanel PanelInquietudes1) {
        this.PanelInquietudes1 = PanelInquietudes1;
    }

    public ButtonGroup getBtngp1EditProcesoyAcesoria() {
        return btngp1EditProcesoyAcesoria;
    }

    public void setBtngp1EditProcesoyAcesoria(ButtonGroup btngp1EditProcesoyAcesoria) {
        this.btngp1EditProcesoyAcesoria = btngp1EditProcesoyAcesoria;
    }

    public ButtonGroup getBtngp2EditAcogida() {
        return btngp2EditAcogida;
    }

    public void setBtngp2EditAcogida(ButtonGroup btngp2EditAcogida) {
        this.btngp2EditAcogida = btngp2EditAcogida;
    }
    

    public JButton getBtnActulizartbl() {
        return btnActulizartbl;
    }

    public void setBtnActulizartbl(JButton btnActulizartbl) {
        this.btnActulizartbl = btnActulizartbl;
    }

    public JButton getBtnBuscar1() {
        return btnBuscar1;
    }

    public void setBtnBuscar1(JButton btnBuscar1) {
        this.btnBuscar1 = btnBuscar1;
    }

    public JButton getBtnCancelarEdit() {
        return btnCancelarEdit;
    }

    public void setBtnCancelarEdit(JButton btnCancelarEdit) {
        this.btnCancelarEdit = btnCancelarEdit;
    }

    public JButton getBtnCanelarRegl() {
        return btnCanelarRegl;
    }

    public void setBtnCanelarRegl(JButton btnCanelarRegl) {
        this.btnCanelarRegl = btnCanelarRegl;
    }

    public JButton getBtnOk() {
        return btnOk;
    }

    public void setBtnOk(JButton btnOk) {
        this.btnOk = btnOk;
    }

    public JButton getBtnRegist1Encuent() {
        return btnRegist1Encuent;
    }

    public void setBtnRegist1Encuent(JButton btnRegist1Encuent) {
        this.btnRegist1Encuent = btnRegist1Encuent;
    }

    public JComboBox<String> getCmbRiesgoEdit() {
        return cmbRiesgoEdit;
    }

    public void setCmbRiesgoEdit(JComboBox<String> cmbRiesgoEdit) {
        this.cmbRiesgoEdit = cmbRiesgoEdit;
    }

    public JDialog getjDlgEdit() {
        return jDlgEdit;
    }

    public void setjDlgEdit(JDialog jDlgEdit) {
        this.jDlgEdit = jDlgEdit;
    }

    public JDialog getjDlgEditTbl() {
        return jDlgEditTbl;
    }

    public void setjDlgEditTbl(JDialog jDlgEditTbl) {
        this.jDlgEditTbl = jDlgEditTbl;
    }

    public JTabbedPane getjTabbedPane2() {
        return jTabbedPane2;
    }

    public void setjTabbedPane2(JTabbedPane jTabbedPane2) {
        this.jTabbedPane2 = jTabbedPane2;
    }

    public JRadioButton getJrbAsesoriaEdit() {
        return jrbAsesoriaEdit;
    }

    public void setJrbAsesoriaEdit(JRadioButton jrbAsesoriaEdit) {
        this.jrbAsesoriaEdit = jrbAsesoriaEdit;
    }

    public JRadioButton getJrbNoEdit() {
        return jrbNoEdit;
    }

    public void setJrbNoEdit(JRadioButton jrbNoEdit) {
        this.jrbNoEdit = jrbNoEdit;
    }

    public JRadioButton getJrbProcesoEdit() {
        return jrbProcesoEdit;
    }

    public void setJrbProcesoEdit(JRadioButton jrbProcesoEdit) {
        this.jrbProcesoEdit = jrbProcesoEdit;
    }

    public JRadioButton getJrbSiEdit() {
        return jrbSiEdit;
    }

    public void setJrbSiEdit(JRadioButton jrbSiEdit) {
        this.jrbSiEdit = jrbSiEdit;
    }

    public JLabel getLblCodEdit() {
        return lblCodEdit;
    }

    public void setLblCodEdit(JLabel lblCodEdit) {
        this.lblCodEdit = lblCodEdit;
    }

    public JTable getTblEditar() {
        return tblEditar;
    }

    public void setTblEditar(JTable tblEditar) {
        this.tblEditar = tblEditar;
    }

    public JTextArea getTxaEstadoEmocionalEdit() {
        return txaEstadoEmocionalEdit;
    }

    public void setTxaEstadoEmocionalEdit(JTextArea txaEstadoEmocionalEdit) {
        this.txaEstadoEmocionalEdit = txaEstadoEmocionalEdit;
    }

    public JTextArea getTxaInquietudesEdit() {
        return txaInquietudesEdit;
    }

    public void setTxaInquietudesEdit(JTextArea txaInquietudesEdit) {
        this.txaInquietudesEdit = txaInquietudesEdit;
    }

    public JTextArea getTxaNivelRiesgoEdit() {
        return txaNivelRiesgoEdit;
    }

    public void setTxaNivelRiesgoEdit(JTextArea txaNivelRiesgoEdit) {
        this.txaNivelRiesgoEdit = txaNivelRiesgoEdit;
    }

    public JTextArea getTxaValoracionDañoEdit() {
        return txaValoracionDañoEdit;
    }

    public void setTxaValoracionDañoEdit(JTextArea txaValoracionDañoEdit) {
        this.txaValoracionDañoEdit = txaValoracionDañoEdit;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JLabel getLbCodigo() {
        return lbCodigo;
    }

    public void setLbCodigo(JLabel lbCodigo) {
        this.lbCodigo = lbCodigo;
    }

    public JPanel getPanelCabecera() {
        return PanelCabecera;
    }

    public void setPanelCabecera(JPanel PanelCabecera) {
        this.PanelCabecera = PanelCabecera;
    }

    public JPanel getPanelInquietudes() {
        return PanelInquietudes;
    }

    public void setPanelInquietudes(JPanel PanelInquietudes) {
        this.PanelInquietudes = PanelInquietudes;
    }

    public JLabel getLbCedula() {
        return lbCedula;
    }

    public void setLbCedula(JLabel lbCedula) {
        this.lbCedula = lbCedula;
    }

    public JPanel getPnlBotones() {
        return pnlBotones;
    }

    public void setPnlBotones(JPanel pnlBotones) {
        this.pnlBotones = pnlBotones;
    }

    public JPanel getPnlEstado() {
        return pnlEstado;
    }

    public void setPnlEstado(JPanel pnlEstado) {
        this.pnlEstado = pnlEstado;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public ButtonGroup getBtngp1() {
        return btngp1EditProcesoyAcesoria;
    }

    public void setBtngp1(ButtonGroup btngp1) {
        this.btngp1EditProcesoyAcesoria = btngp1;
    }

    public ButtonGroup getBtngp2() {
        return btngp2EditAcogida;
    }

    public void setBtngp2(ButtonGroup btngp2) {
        this.btngp2EditAcogida = btngp2;
    }

    public JComboBox<String> getCmbRiesgo() {
        return cmbRiesgo;
    }

    public void setCmbRiesgo(JComboBox<String> cmbRiesgo) {
        this.cmbRiesgo = cmbRiesgo;
    }

    public JDateChooser getDatFechaPrimerEncuentro() {
        return datFechaPrimerEncuentro;
    }

    public void setDatFechaPrimerEncuentro(JDateChooser datFechaPrimerEncuentro) {
        this.datFechaPrimerEncuentro = datFechaPrimerEncuentro;
    }

    public JRadioButton getJrbAsesoria() {
        return jrbAsesoria;
    }

    public void setJrbAsesoria(JRadioButton jrbAsesoria) {
        this.jrbAsesoria = jrbAsesoria;
    }

    public JRadioButton getJrbNo() {
        return jrbNo;
    }

    public void setJrbNo(JRadioButton jrbNo) {
        this.jrbNo = jrbNo;
    }

    public JRadioButton getJrbProceso() {
        return jrbProceso;
    }

    public void setJrbProceso(JRadioButton jrbProceso) {
        this.jrbProceso = jrbProceso;
    }

    public JRadioButton getJrbSi() {
        return jrbSi;
    }

    public void setJrbSi(JRadioButton jrbSi) {
        this.jrbSi = jrbSi;
    }

    public JLabel getLblPsicologo() {
        return lblPsicologo;
    }

    public void setLblPsicologo(JLabel lblPsicologo) {
        this.lblPsicologo = lblPsicologo;
    }

    public JPanel getPnlPrimerEncuentro() {
        return pnlPrimerEncuentro;
    }

    public void setPnlPrimerEncuentro(JPanel pnlPrimerEncuentro) {
        this.pnlPrimerEncuentro = pnlPrimerEncuentro;
    }

    public JScrollPane getSpEstado() {
        return spEstado;
    }

    public void setSpEstado(JScrollPane spEstado) {
        this.spEstado = spEstado;
    }

    public JTextArea getTxaEstadoEmocional() {
        return txaEstadoEmocional;
    }

    public void setTxaEstadoEmocional(JTextArea txaEstadoEmocional) {
        this.txaEstadoEmocional = txaEstadoEmocional;
    }

    public JTextArea getTxaInquietudes() {
        return txaInquietudes;
    }

    public void setTxaInquietudes(JTextArea txaInquietudes) {
        this.txaInquietudes = txaInquietudes;
    }

    public JTextArea getTxaNivelRiesgo() {
        return txaNivelRiesgo;
    }

    public void setTxaNivelRiesgo(JTextArea txaNivelRiesgo) {
        this.txaNivelRiesgo = txaNivelRiesgo;
    }

    public JTextArea getTxaValoracionDaño() {
        return txaValoracionDaño;
    }

    public void setTxaValoracionDaño(JTextArea txaValoracionDaño) {
        this.txaValoracionDaño = txaValoracionDaño;
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

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngp1EditProcesoyAcesoria = new javax.swing.ButtonGroup();
        btngp2EditAcogida = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jDlgEdit = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        spEstado1 = new javax.swing.JScrollPane();
        pnlEstado1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaEstadoEmocionalEdit = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaNivelRiesgoEdit = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txaValoracionDañoEdit = new javax.swing.JTextArea();
        PanelInquietudes1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cmbRiesgoEdit = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txaInquietudesEdit = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jrbProcesoEdit = new javax.swing.JRadioButton();
        jrbAsesoriaEdit = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jrbSiEdit = new javax.swing.JRadioButton();
        jrbNoEdit = new javax.swing.JRadioButton();
        lblPsicologo1 = new javax.swing.JLabel();
        btnCancelarEdit = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        lblCodEdit = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jDlgEditTbl = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        btnCanelarRegl = new javax.swing.JButton();
        btnActulizartbl = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblEditar = new javax.swing.JTable();
        btnBuscar1 = new javax.swing.JButton();
        pnlPrimerEncuentro = new javax.swing.JPanel();
        PanelCabecera = new javax.swing.JPanel();
        lbCedula = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        datFechaPrimerEncuentro = new com.toedter.calendar.JDateChooser();
        lbNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        spEstado = new javax.swing.JScrollPane();
        pnlEstado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEstadoEmocional = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaNivelRiesgo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaValoracionDaño = new javax.swing.JTextArea();
        PanelInquietudes = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbRiesgo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaInquietudes = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jrbProceso = new javax.swing.JRadioButton();
        jrbAsesoria = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jrbSi = new javax.swing.JRadioButton();
        jrbNo = new javax.swing.JRadioButton();
        lblPsicologo = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnRegist1Encuent = new javax.swing.JButton();

        jLabel10.setText("1.1 Estado Emocional en el que llega la persona");

        txaEstadoEmocionalEdit.setColumns(20);
        txaEstadoEmocionalEdit.setLineWrap(true);
        txaEstadoEmocionalEdit.setRows(5);
        txaEstadoEmocionalEdit.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txaEstadoEmocionalEdit);

        jLabel11.setText("1.2 Nivel de riesgo o vulnerabilidad");

        txaNivelRiesgoEdit.setColumns(20);
        txaNivelRiesgoEdit.setLineWrap(true);
        txaNivelRiesgoEdit.setRows(5);
        txaNivelRiesgoEdit.setWrapStyleWord(true);
        jScrollPane6.setViewportView(txaNivelRiesgoEdit);

        jLabel12.setText("1.3 Valoración preliminar del daño psicológico");

        txaValoracionDañoEdit.setColumns(20);
        txaValoracionDañoEdit.setLineWrap(true);
        txaValoracionDañoEdit.setRows(5);
        txaValoracionDañoEdit.setWrapStyleWord(true);
        jScrollPane7.setViewportView(txaValoracionDañoEdit);

        javax.swing.GroupLayout pnlEstado1Layout = new javax.swing.GroupLayout(pnlEstado1);
        pnlEstado1.setLayout(pnlEstado1Layout);
        pnlEstado1Layout.setHorizontalGroup(
            pnlEstado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEstado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEstado1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlEstado1Layout.createSequentialGroup()
                        .addGroup(pnlEstado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
                            .addGroup(pnlEstado1Layout.createSequentialGroup()
                                .addGroup(pnlEstado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEstado1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel12))
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 182, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        pnlEstado1Layout.setVerticalGroup(
            pnlEstado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstado1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        spEstado1.setViewportView(pnlEstado1);

        jTabbedPane2.addTab("Estado de la Compañera", spEstado1);

        jLabel13.setText("1.4  Riesgo Suicida: ");

        cmbRiesgoEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));

        jLabel14.setText("1.5 Inquietudes y/o puntos relevantes sobre el caso que se deben considerar para elaborar el plan de atención.");

        txaInquietudesEdit.setColumns(20);
        txaInquietudesEdit.setLineWrap(true);
        txaInquietudesEdit.setRows(5);
        txaInquietudesEdit.setWrapStyleWord(true);
        jScrollPane9.setViewportView(txaInquietudesEdit);

        jLabel15.setText("1.6 La persona expresa intención de iniciar proceso psicoterapéutico o requiere solamente asesoría.");

        btngp1EditProcesoyAcesoria.add(jrbProcesoEdit);
        jrbProcesoEdit.setText("Apoyo terapeutico");
        jrbProcesoEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbProcesoEditActionPerformed(evt);
            }
        });

        btngp1EditProcesoyAcesoria.add(jrbAsesoriaEdit);
        jrbAsesoriaEdit.setText("Asesoría");

        jLabel16.setText("Psicologa: ");

        jLabel17.setText("¿La persona desea la acogida?");

        btngp2EditAcogida.add(jrbSiEdit);
        jrbSiEdit.setText("Si");

        btngp2EditAcogida.add(jrbNoEdit);
        jrbNoEdit.setText("No");

        javax.swing.GroupLayout PanelInquietudes1Layout = new javax.swing.GroupLayout(PanelInquietudes1);
        PanelInquietudes1.setLayout(PanelInquietudes1Layout);
        PanelInquietudes1Layout.setHorizontalGroup(
            PanelInquietudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                .addGroup(PanelInquietudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                        .addGroup(PanelInquietudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jrbProcesoEdit)
                                .addGap(73, 73, 73)
                                .addComponent(jrbAsesoriaEdit))
                            .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(PanelInquietudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblPsicologo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                                        .addComponent(jrbSiEdit)
                                        .addGap(92, 92, 92)
                                        .addComponent(jrbNoEdit))))
                            .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(cmbRiesgoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelInquietudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))))
                        .addGap(0, 258, Short.MAX_VALUE))
                    .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9)))
                .addContainerGap())
            .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelInquietudes1Layout.setVerticalGroup(
            PanelInquietudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInquietudes1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelInquietudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbRiesgoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(28, 28, 28)
                .addGroup(PanelInquietudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbProcesoEdit)
                    .addComponent(jrbAsesoriaEdit))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(PanelInquietudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbSiEdit)
                    .addComponent(jrbNoEdit))
                .addGap(18, 18, 18)
                .addGroup(PanelInquietudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPsicologo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Inquietudes", PanelInquietudes1);

        btnCancelarEdit.setText("Cancelar");

        btnOk.setText("Guardar");

        jLabel19.setText("Cod:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCodEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelarEdit)
                        .addGap(53, 53, 53)
                        .addComponent(btnOk)))
                .addGap(51, 51, 51))
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarEdit)
                    .addComponent(btnOk))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDlgEditLayout = new javax.swing.GroupLayout(jDlgEdit.getContentPane());
        jDlgEdit.getContentPane().setLayout(jDlgEditLayout);
        jDlgEditLayout.setHorizontalGroup(
            jDlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDlgEditLayout.setVerticalGroup(
            jDlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblNombre.setText("Buscar: ");

        btnCanelarRegl.setText("Cancelar");

        btnActulizartbl.setText("Actualizar");

        tblEditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Nombre y Apellido", "Crisis_estado_emocional", "Crisis_nivel_riesgo", "Crisis_valoracionpreliminar", "Crisis_riesgo_suicida", "Crisis_puntosreelevantes", "Crisis_proceso_psicoterapeutico", "Crisis_asesoria", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblEditar);

        btnBuscar1.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActulizartbl)
                .addGap(18, 18, 18)
                .addComponent(btnCanelarRegl)
                .addContainerGap())
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombre))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar1)
                        .addComponent(btnCanelarRegl)
                        .addComponent(btnActulizartbl)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDlgEditTblLayout = new javax.swing.GroupLayout(jDlgEditTbl.getContentPane());
        jDlgEditTbl.getContentPane().setLayout(jDlgEditTblLayout);
        jDlgEditTblLayout.setHorizontalGroup(
            jDlgEditTblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDlgEditTblLayout.setVerticalGroup(
            jDlgEditTblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbCedula.setText("Cedula:");

        lbFecha.setText("Fecha: ");

        lbCodigo.setText("Código");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Primer Encuentro");

        lbNombre.setText("Nombre:");

        javax.swing.GroupLayout PanelCabeceraLayout = new javax.swing.GroupLayout(PanelCabecera);
        PanelCabecera.setLayout(PanelCabeceraLayout);
        PanelCabeceraLayout.setHorizontalGroup(
            PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCabeceraLayout.createSequentialGroup()
                        .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtNombre))
                        .addGap(337, 337, 337)
                        .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCabeceraLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lbCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCabeceraLayout.createSequentialGroup()
                                .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datFechaPrimerEncuentro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PanelCabeceraLayout.setVerticalGroup(
            PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCedula)
                    .addComponent(lbCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datFechaPrimerEncuentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFecha)
                        .addComponent(lbNombre)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
        );

        jLabel1.setText("1.1 Estado Emocional en el que llega la persona");

        txaEstadoEmocional.setColumns(20);
        txaEstadoEmocional.setLineWrap(true);
        txaEstadoEmocional.setRows(5);
        txaEstadoEmocional.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txaEstadoEmocional);

        jLabel2.setText("1.2 Nivel de riesgo o vulnerabilidad");

        txaNivelRiesgo.setColumns(20);
        txaNivelRiesgo.setLineWrap(true);
        txaNivelRiesgo.setRows(5);
        txaNivelRiesgo.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txaNivelRiesgo);

        jLabel3.setText("1.3 Valoración preliminar del daño psicológico");

        txaValoracionDaño.setColumns(20);
        txaValoracionDaño.setLineWrap(true);
        txaValoracionDaño.setRows(5);
        txaValoracionDaño.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txaValoracionDaño);

        javax.swing.GroupLayout pnlEstadoLayout = new javax.swing.GroupLayout(pnlEstado);
        pnlEstado.setLayout(pnlEstadoLayout);
        pnlEstadoLayout.setHorizontalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEstadoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlEstadoLayout.createSequentialGroup()
                        .addGroup(pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
                            .addGroup(pnlEstadoLayout.createSequentialGroup()
                                .addGroup(pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEstadoLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        pnlEstadoLayout.setVerticalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        spEstado.setViewportView(pnlEstado);

        jTabbedPane1.addTab("Estado de la Compañera", spEstado);

        jLabel4.setText("1.4  Riesgo Suicida: ");

        cmbRiesgo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));

        jLabel5.setText("1.5 Inquietudes y/o puntos relevantes sobre el caso que se deben considerar para elaborar el plan de atención.");

        txaInquietudes.setColumns(20);
        txaInquietudes.setLineWrap(true);
        txaInquietudes.setRows(5);
        txaInquietudes.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txaInquietudes);

        jLabel6.setText("1.6 La persona expresa intención de iniciar proceso psicoterapéutico o requiere solamente asesoría.");

        btngp1EditProcesoyAcesoria.add(jrbProceso);
        jrbProceso.setText("Apoyo terapeutico");
        jrbProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbProcesoActionPerformed(evt);
            }
        });

        btngp1EditProcesoyAcesoria.add(jrbAsesoria);
        jrbAsesoria.setText("Asesoría");

        jLabel7.setText("Psicologa: ");

        jLabel9.setText("¿La persona desea la acogida?");

        btngp2EditAcogida.add(jrbSi);
        jrbSi.setText("Si");

        btngp2EditAcogida.add(jrbNo);
        jrbNo.setText("No");

        javax.swing.GroupLayout PanelInquietudesLayout = new javax.swing.GroupLayout(PanelInquietudes);
        PanelInquietudes.setLayout(PanelInquietudesLayout);
        PanelInquietudesLayout.setHorizontalGroup(
            PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInquietudesLayout.createSequentialGroup()
                        .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jrbProceso)
                                .addGap(73, 73, 73)
                                .addComponent(jrbAsesoria))
                            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblPsicologo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                        .addComponent(jrbSi)
                                        .addGap(92, 92, 92)
                                        .addComponent(jrbNo))))
                            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbRiesgo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))))
                        .addGap(0, 177, Short.MAX_VALUE))
                    .addGroup(PanelInquietudesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5)))
                .addContainerGap())
            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelInquietudesLayout.setVerticalGroup(
            PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbRiesgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbProceso)
                    .addComponent(jrbAsesoria))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbSi)
                    .addComponent(jrbNo))
                .addGap(18, 18, 18)
                .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPsicologo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inquietudes", PanelInquietudes);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");

        btnRegist1Encuent.setText("Registro");

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegist1Encuent, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnRegist1Encuent))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrimerEncuentroLayout = new javax.swing.GroupLayout(pnlPrimerEncuentro);
        pnlPrimerEncuentro.setLayout(pnlPrimerEncuentroLayout);
        pnlPrimerEncuentroLayout.setHorizontalGroup(
            pnlPrimerEncuentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrimerEncuentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrimerEncuentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addComponent(PanelCabecera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPrimerEncuentroLayout.setVerticalGroup(
            pnlPrimerEncuentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrimerEncuentroLayout.createSequentialGroup()
                .addComponent(PanelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrimerEncuentro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrimerEncuentro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbProcesoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jrbProcesoEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbProcesoEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbProcesoEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCabecera;
    private javax.swing.JPanel PanelInquietudes;
    private javax.swing.JPanel PanelInquietudes1;
    private javax.swing.JButton btnActulizartbl;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarEdit;
    private javax.swing.JButton btnCanelarRegl;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnRegist1Encuent;
    private javax.swing.ButtonGroup btngp1EditProcesoyAcesoria;
    private javax.swing.ButtonGroup btngp2EditAcogida;
    private javax.swing.JComboBox<String> cmbRiesgo;
    private javax.swing.JComboBox<String> cmbRiesgoEdit;
    private com.toedter.calendar.JDateChooser datFechaPrimerEncuentro;
    private javax.swing.JDialog jDlgEdit;
    private javax.swing.JDialog jDlgEditTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton jrbAsesoria;
    private javax.swing.JRadioButton jrbAsesoriaEdit;
    private javax.swing.JRadioButton jrbNo;
    private javax.swing.JRadioButton jrbNoEdit;
    private javax.swing.JRadioButton jrbProceso;
    private javax.swing.JRadioButton jrbProcesoEdit;
    private javax.swing.JRadioButton jrbSi;
    private javax.swing.JRadioButton jrbSiEdit;
    private javax.swing.JLabel lbCedula;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lblCodEdit;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPsicologo;
    private javax.swing.JLabel lblPsicologo1;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlEstado;
    private javax.swing.JPanel pnlEstado1;
    private javax.swing.JPanel pnlPrimerEncuentro;
    private javax.swing.JScrollPane spEstado;
    private javax.swing.JScrollPane spEstado1;
    private javax.swing.JTable tblEditar;
    private javax.swing.JTextArea txaEstadoEmocional;
    private javax.swing.JTextArea txaEstadoEmocionalEdit;
    private javax.swing.JTextArea txaInquietudes;
    private javax.swing.JTextArea txaInquietudesEdit;
    private javax.swing.JTextArea txaNivelRiesgo;
    private javax.swing.JTextArea txaNivelRiesgoEdit;
    private javax.swing.JTextArea txaValoracionDaño;
    private javax.swing.JTextArea txaValoracionDañoEdit;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
