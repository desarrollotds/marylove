
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
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

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public ButtonGroup getBtngp2() {
        return btngp2;
    }

    public void setBtngp2(ButtonGroup btngp2) {
        this.btngp2 = btngp2;
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

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
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

    public JLabel getLbCedula() {
        return lbCedula;
    }

    public void setLbCedula(JLabel lbCedula) {
        this.lbCedula = lbCedula;
    }

    public JPanel getPnlEstado() {
        return pnlEstado;
    }

    public void setPnlEstado(JPanel pnlEstado) {
        this.pnlEstado = pnlEstado;
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

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public ButtonGroup getBtngp1() {
        return btngp1;
    }

    public void setBtngp1(ButtonGroup btngp1) {
        this.btngp1 = btngp1;
    }

    public JTextField getTxtPsicologa() {
        return txtPsicologa;
    }

    public void setTxtPsicologa(JTextField txtPsicologa) {
        this.txtPsicologa = txtPsicologa;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngp1 = new javax.swing.ButtonGroup();
        btngp2 = new javax.swing.ButtonGroup();
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
        txtPsicologa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jrbSi = new javax.swing.JRadioButton();
        jrbNo = new javax.swing.JRadioButton();
        pnlBotones = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbCedula.setText("Cedula:");

        lbFecha.setText("Fecha: ");

        lbCodigo.setText("Código");

        jLabel8.setText("Primer Encuentro");

        lbNombre.setText("Nombre:");

        javax.swing.GroupLayout PanelCabeceraLayout = new javax.swing.GroupLayout(PanelCabecera);
        PanelCabecera.setLayout(PanelCabeceraLayout);
        PanelCabeceraLayout.setHorizontalGroup(
            PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCabeceraLayout.createSequentialGroup()
                .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCabeceraLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCabeceraLayout.createSequentialGroup()
                                .addComponent(lbCedula)
                                .addGap(18, 18, 18))
                            .addGroup(PanelCabeceraLayout.createSequentialGroup()
                                .addComponent(lbNombre)
                                .addGap(14, 14, 14)))
                        .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addGap(104, 104, 104)
                        .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelCabeceraLayout.createSequentialGroup()
                                .addComponent(lbCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCabeceraLayout.createSequentialGroup()
                                .addComponent(lbFecha)
                                .addGap(18, 18, 18)
                                .addComponent(datFechaPrimerEncuentro, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelCabeceraLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel8)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        PanelCabeceraLayout.setVerticalGroup(
            PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(22, 22, 22))
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
                .addGap(26, 26, 26)
                .addGroup(pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        pnlEstadoLayout.setVerticalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        spEstado.setViewportView(pnlEstado);

        jTabbedPane1.addTab("Estado de la Compañera", spEstado);

        jLabel4.setText("1.4  Riesgo Suicida: ");

        cmbRiesgo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel5.setText("1.5 Inquietudes y/o puntos relevantes sobre el caso que se deben considerar para elaborar el plan de atención.");

        txaInquietudes.setColumns(20);
        txaInquietudes.setLineWrap(true);
        txaInquietudes.setRows(5);
        txaInquietudes.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txaInquietudes);

        jLabel6.setText("1.6 La persona expresa intención de iniciar proceso psicoterapéutico o requiere solamente asesoría.");

        btngp1.add(jrbProceso);
        jrbProceso.setText("Apoyo terapeutico");
        jrbProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbProcesoActionPerformed(evt);
            }
        });

        btngp1.add(jrbAsesoria);
        jrbAsesoria.setText("Asesoría");

        jLabel7.setText("Psicologa: ");

        jLabel9.setText("¿La persona desea la acogida?");

        btngp2.add(jrbSi);
        jrbSi.setText("Si");

        btngp2.add(jrbNo);
        jrbNo.setText("No");

        javax.swing.GroupLayout PanelInquietudesLayout = new javax.swing.GroupLayout(PanelInquietudes);
        PanelInquietudes.setLayout(PanelInquietudesLayout);
        PanelInquietudesLayout.setHorizontalGroup(
            PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInquietudesLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane5)
                                .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                            .addComponent(jrbProceso)
                                            .addGap(73, 73, 73)
                                            .addComponent(jrbAsesoria))
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbRiesgo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelInquietudesLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtPsicologa, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelInquietudesLayout.createSequentialGroup()
                                .addComponent(jrbSi)
                                .addGap(92, 92, 92)
                                .addComponent(jrbNo)))))
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
                .addGroup(PanelInquietudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPsicologa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inquietudes", PanelInquietudes);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap(489, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(31, 31, 31)
                .addComponent(btnGuardar)
                .addContainerGap())
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrimerEncuentroLayout = new javax.swing.GroupLayout(pnlPrimerEncuentro);
        pnlPrimerEncuentro.setLayout(pnlPrimerEncuentroLayout);
        pnlPrimerEncuentroLayout.setHorizontalGroup(
            pnlPrimerEncuentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrimerEncuentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrimerEncuentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrimerEncuentroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrimerEncuentroLayout.createSequentialGroup()
                        .addGroup(pnlPrimerEncuentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPrimerEncuentroLayout.setVerticalGroup(
            pnlPrimerEncuentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrimerEncuentroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlPrimerEncuentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlPrimerEncuentro, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbProcesoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCabecera;
    private javax.swing.JPanel PanelInquietudes;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup btngp1;
    private javax.swing.ButtonGroup btngp2;
    private javax.swing.JComboBox<String> cmbRiesgo;
    private com.toedter.calendar.JDateChooser datFechaPrimerEncuentro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton jrbAsesoria;
    private javax.swing.JRadioButton jrbNo;
    private javax.swing.JRadioButton jrbProceso;
    private javax.swing.JRadioButton jrbSi;
    private javax.swing.JLabel lbCedula;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlEstado;
    private javax.swing.JPanel pnlPrimerEncuentro;
    private javax.swing.JScrollPane spEstado;
    private javax.swing.JTextArea txaEstadoEmocional;
    private javax.swing.JTextArea txaInquietudes;
    private javax.swing.JTextArea txaNivelRiesgo;
    private javax.swing.JTextArea txaValoracionDaño;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPsicologa;
    // End of variables declaration//GEN-END:variables
}
