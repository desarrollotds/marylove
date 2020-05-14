/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FichaPlandeVida extends javax.swing.JFrame {

    public FichaPlandeVida() {
        initComponents();
    }

    public JButton getBtnVerRegist() {
        return BtnVerRegist;
    }

    public void setBtnVerRegist(JButton BtnVerRegist) {
        this.BtnVerRegist = BtnVerRegist;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnGuradar() {
        return btnGuradar;
    }

    public void setBtnGuradar(JButton btnGuradar) {
        this.btnGuradar = btnGuradar;
    }

    public JButton getBtnGuradrarDesa() {
        return btnGuradrarDesa;
    }

    public void setBtnGuradrarDesa(JButton btnGuradrarDesa) {
        this.btnGuradrarDesa = btnGuradrarDesa;
    }

    public JButton getBtnObjetivoGeneral() {
        return btnObjetivoGeneral;
    }

    public void setBtnObjetivoGeneral(JButton btnObjetivoGeneral) {
        this.btnObjetivoGeneral = btnObjetivoGeneral;
    }

    public JButton getBtnObjetivosEspecificos() {
        return btnObjetivosEspecificos;
    }

    public void setBtnObjetivosEspecificos(JButton btnObjetivosEspecificos) {
        this.btnObjetivosEspecificos = btnObjetivosEspecificos;
    }

    public JDateChooser getDtcFecha() {
        return dtcFecha;
    }

    public void setDtcFecha(JDateChooser dtcFecha) {
        this.dtcFecha = dtcFecha;
    }

    public JDateChooser getDtcFechaProximaEvaluacion() {
        return dtcFechaProximaEvaluacion;
    }

    public void setDtcFechaProximaEvaluacion(JDateChooser dtcFechaProximaEvaluacion) {
        this.dtcFechaProximaEvaluacion = dtcFechaProximaEvaluacion;
    }

    public JLabel getLblCodigoObEsp() {
        return lblCodigoObEsp;
    }

    public void setLblCodigoObEsp(JLabel lblCodigoObEsp) {
        this.lblCodigoObEsp = lblCodigoObEsp;
    }

    public JLabel getLblCodigoObGen() {
        return lblCodigoObGen;
    }

    public void setLblCodigoObGen(JLabel lblCodigoObGen) {
        this.lblCodigoObGen = lblCodigoObGen;
    }

    public JPanel getPlPlandeVida() {
        return plPlandeVida;
    }

    public void setPlPlandeVida(JPanel plPlandeVida) {
        this.plPlandeVida = plPlandeVida;
    }

    public JPanel getPnlCabecera() {
        return pnlCabecera;
    }

    public void setPnlCabecera(JPanel pnlCabecera) {
        this.pnlCabecera = pnlCabecera;
    }

    public JPanel getPnlDesarrollo1() {
        return pnlDesarrollo1;
    }

    public void setPnlDesarrollo1(JPanel pnlDesarrollo1) {
        this.pnlDesarrollo1 = pnlDesarrollo1;
    }

    public JTable getTabObjetivoGeneral() {
        return tabObjetivoGeneral;
    }

    public void setTabObjetivoGeneral(JTable tabObjetivoGeneral) {
        this.tabObjetivoGeneral = tabObjetivoGeneral;
    }

    public JTable getTabObjetivosEspecificos() {
        return tabObjetivosEspecificos;
    }

    public void setTabObjetivosEspecificos(JTable tabObjetivosEspecificos) {
        this.tabObjetivosEspecificos = tabObjetivosEspecificos;
    }

    public JTextArea getTxaVisionUFA() {
        return txaVisionUFA;
    }

    public void setTxaVisionUFA(JTextArea txaVisionUFA) {
        this.txaVisionUFA = txaVisionUFA;
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

    public JTextField getTxtComSiente() {
        return txtComSiente;
    }

    public void setTxtComSiente(JTextField txtComSiente) {
        this.txtComSiente = txtComSiente;
    }

    public JTextField getTxtComoleGustariasuVida() {
        return txtComoleGustariasuVida;
    }

    public void setTxtComoleGustariasuVida(JTextField txtComoleGustariasuVida) {
        this.txtComoleGustariasuVida = txtComoleGustariasuVida;
    }

    public JTextField getTxtComoseVe() {
        return txtComoseVe;
    }

    public void setTxtComoseVe(JTextField txtComoseVe) {
        this.txtComoseVe = txtComoseVe;
    }

    public JTextField getTxtNNA() {
        return txtNNA;
    }

    public void setTxtNNA(JTextField txtNNA) {
        this.txtNNA = txtNNA;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plPlandeVida = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnlDesarrollo1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaVisionUFA = new javax.swing.JTextArea();
        txtComSiente = new javax.swing.JTextField();
        txtComoseVe = new javax.swing.JTextField();
        txtComoleGustariasuVida = new javax.swing.JTextField();
        btnGuradrarDesa = new javax.swing.JButton();
        BtnVerRegist = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabObjetivoGeneral = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnObjetivoGeneral = new javax.swing.JButton();
        btnObjetivosEspecificos = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabObjetivosEspecificos = new javax.swing.JTable();
        lblCodigoObGen = new javax.swing.JLabel();
        lblCodigoObEsp = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        pnlCabecera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNNA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtcFecha = new com.toedter.calendar.JDateChooser();
        dtcFechaProximaEvaluacion = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnGuradar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel11.setText("Precepcion del grupo familiar sobre su situación actual.");

        jLabel12.setText("¿Como se siente?");

        jLabel13.setText("Como se ve?");

        jLabel14.setText("Como le gustaria que sea su vida?");

        jLabel15.setText("Visión del equipo con respecto a la unidad familiar actual");

        txaVisionUFA.setColumns(20);
        txaVisionUFA.setLineWrap(true);
        txaVisionUFA.setRows(5);
        txaVisionUFA.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txaVisionUFA);

        btnGuradrarDesa.setText("Guardar");

        BtnVerRegist.setText("Ver Registro");

        javax.swing.GroupLayout pnlDesarrollo1Layout = new javax.swing.GroupLayout(pnlDesarrollo1);
        pnlDesarrollo1.setLayout(pnlDesarrollo1Layout);
        pnlDesarrollo1Layout.setHorizontalGroup(
            pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11)
                            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtComoleGustariasuVida, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(98, 98, 98)
                                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtComSiente, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                                    .addComponent(txtComoseVe)))))
                    .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnVerRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnGuradrarDesa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDesarrollo1Layout.setVerticalGroup(
            pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtComSiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtComoseVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtComoleGustariasuVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuradrarDesa)
                    .addComponent(BtnVerRegist))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Desarrollo", pnlDesarrollo1);

        tabObjetivoGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Objetivo General", "Responsable", "Tiempo", "Observacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabObjetivoGeneral);

        jLabel16.setText("Definición de los objetivos del proceso");

        jLabel17.setText("Objetivo Especifico");

        jLabel18.setText("Obetivo General");

        btnObjetivoGeneral.setText("Agregar Objetivo General");

        btnObjetivosEspecificos.setText("Agregar Objetivos Especificos");

        tabObjetivosEspecificos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Objetivos Especificos", "Responsable", "Actividad", "Tiempo", "Con el apoyo de", "Supuestos y Amenazas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabObjetivosEspecificos);
        if (tabObjetivosEspecificos.getColumnModel().getColumnCount() > 0) {
            tabObjetivosEspecificos.getColumnModel().getColumn(1).setResizable(false);
        }

        lblCodigoObGen.setText("Codigo: ");

        lblCodigoObEsp.setText("Codigo: ");

        btnActualizar.setText("Actualizar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                                .addGap(197, 197, 197)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(64, 64, 64)
                                .addComponent(btnObjetivoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCodigoObGen, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)
                        .addGap(51, 51, 51)
                        .addComponent(btnObjetivosEspecificos, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCodigoObEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(btnObjetivoGeneral)
                    .addComponent(lblCodigoObGen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObjetivosEspecificos)
                    .addComponent(jLabel17)
                    .addComponent(lblCodigoObEsp))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Objetivos", jPanel1);

        jLabel1.setText("       Plan de Vida");

        jLabel2.setText("Nombre:");

        jLabel3.setText("NNA: ");

        jLabel4.setText("Fecha Elaboración:");

        jLabel5.setText("Fecha de evaluación:");

        jLabel6.setText("Cedula");

        jLabel7.setText("Codigo: ");

        btnGuradar.setText("Guardar");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtCedula)
                            .addComponent(txtNNA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuradar, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dtcFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(dtcFechaProximaEvaluacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createSequentialGroup()
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dtcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtcFechaProximaEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuradar)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout plPlandeVidaLayout = new javax.swing.GroupLayout(plPlandeVida);
        plPlandeVida.setLayout(plPlandeVidaLayout);
        plPlandeVidaLayout.setHorizontalGroup(
            plPlandeVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plPlandeVidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        plPlandeVidaLayout.setVerticalGroup(
            plPlandeVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plPlandeVidaLayout.createSequentialGroup()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(plPlandeVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plPlandeVida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVerRegist;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuradar;
    private javax.swing.JButton btnGuradrarDesa;
    private javax.swing.JButton btnObjetivoGeneral;
    private javax.swing.JButton btnObjetivosEspecificos;
    private com.toedter.calendar.JDateChooser dtcFecha;
    private com.toedter.calendar.JDateChooser dtcFechaProximaEvaluacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblCodigoObEsp;
    private javax.swing.JLabel lblCodigoObGen;
    private javax.swing.JPanel plPlandeVida;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlDesarrollo1;
    private javax.swing.JTable tabObjetivoGeneral;
    private javax.swing.JTable tabObjetivosEspecificos;
    private javax.swing.JTextArea txaVisionUFA;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComSiente;
    private javax.swing.JTextField txtComoleGustariasuVida;
    private javax.swing.JTextField txtComoseVe;
    private javax.swing.JTextField txtNNA;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
