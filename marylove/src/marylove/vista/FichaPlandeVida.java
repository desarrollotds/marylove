/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FichaPlandeVida extends javax.swing.JFrame {

    public FichaPlandeVida() {
        initComponents();
    }

    public JTable getDlgTblObjGen() {
        return DlgTblObjGen;
    }

    public void setDlgTblObjGen(JTable DlgTblObjGen) {
        this.DlgTblObjGen = DlgTblObjGen;
    }

    public JTable getDlgtblObjEsp() {
        return DlgtblObjEsp;
    }

    public void setDlgtblObjEsp(JTable DlgtblObjEsp) {
        this.DlgtblObjEsp = DlgtblObjEsp;
    }

    public JButton getBtnActDlg() {
        return btnActDlg;
    }

    public void setBtnActDlg(JButton btnActDlg) {
        this.btnActDlg = btnActDlg;
    }

    public JButton getBtnActulizartbl() {
        return btnActulizartbl;
    }

    public void setBtnActulizartbl(JButton btnActulizartbl) {
        this.btnActulizartbl = btnActulizartbl;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
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


    public JDialog getDlgObjGenEsp() {
        return dlgObjGenEsp;
    }

    public void setDlgObjGenEsp(JDialog dlgObjGenEsp) {
        this.dlgObjGenEsp = dlgObjGenEsp;
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

    public JLabel getLblCodEdit() {
        return lblCodEdit;
    }

    public void setLblCodEdit(JLabel lblCodEdit) {
        this.lblCodEdit = lblCodEdit;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JPanel getPnlDesarrollo2() {
        return pnlDesarrollo2;
    }

    public void setPnlDesarrollo2(JPanel pnlDesarrollo2) {
        this.pnlDesarrollo2 = pnlDesarrollo2;
    }

    public JPanel getPnlDesarrollo3() {
        return pnlDesarrollo3;
    }

    public void setPnlDesarrollo3(JPanel pnlDesarrollo3) {
        this.pnlDesarrollo3 = pnlDesarrollo3;
    }

    public JTabbedPane getTbbDesarrollo1() {
        return tbbDesarrollo1;
    }

    public void setTbbDesarrollo1(JTabbedPane tbbDesarrollo1) {
        this.tbbDesarrollo1 = tbbDesarrollo1;
    }

    public JTable getTblEditar() {
        return tblEditar;
    }

    public void setTblEditar(JTable tblEditar) {
        this.tblEditar = tblEditar;
    }

    public JTextArea getTxaVisionEdit() {
        return txaVisionEdit;
    }

    public void setTxaVisionEdit(JTextArea txaVisionEdit) {
        this.txaVisionEdit = txaVisionEdit;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTextField getTxtBuscarOGenEsp() {
        return txtBuscarOGenEsp;
    }

    public void setTxtBuscarOGenEsp(JTextField txtBuscarOGenEsp) {
        this.txtBuscarOGenEsp = txtBuscarOGenEsp;
    }

    public JTextField getTxtComSienteEdit() {
        return txtComSienteEdit;
    }

    public void setTxtComSienteEdit(JTextField txtComSienteEdit) {
        this.txtComSienteEdit = txtComSienteEdit;
    }

    public JTextField getTxtDificEncontradosEdit() {
        return txtDificEncontradosEdit;
    }

    public void setTxtDificEncontradosEdit(JTextField txtDificEncontradosEdit) {
        this.txtDificEncontradosEdit = txtDificEncontradosEdit;
    }

    public JTextField getTxtObjPlanedEdit() {
        return txtObjPlanedEdit;
    }

    public void setTxtObjPlanedEdit(JTextField txtObjPlanedEdit) {
        this.txtObjPlanedEdit = txtObjPlanedEdit;
    }

    

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnGuardarplanVida() {
        return btnGuardarplanVida;
    }

    public void setBtnGuardarplanVida(JButton btnGuardarplanVida) {
        this.btnGuardarplanVida = btnGuardarplanVida;
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

    public JButton getBtnNNA() {
        return btnNNA;
    }

    public void setBtnNNA(JButton btnNNA) {
        this.btnNNA = btnNNA;
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

        jDlgEdit = new javax.swing.JDialog();
        pnlDesarrollo2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaVisionEdit = new javax.swing.JTextArea();
        txtComSienteEdit = new javax.swing.JTextField();
        txtObjPlanedEdit = new javax.swing.JTextField();
        txtDificEncontradosEdit = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        lblCodEdit = new javax.swing.JLabel();
        btnCancelarEdit = new javax.swing.JButton();
        jDlgEditTbl = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        btnCanelarRegl = new javax.swing.JButton();
        btnActulizartbl = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblEditar = new javax.swing.JTable();
        btnBuscar1 = new javax.swing.JButton();
        dlgObjGenEsp = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        tbbDesarrollo1 = new javax.swing.JTabbedPane();
        pnlDesarrollo3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        DlgtblObjEsp = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        DlgTblObjGen = new javax.swing.JTable();
        txtBuscarOGenEsp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnActDlg = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
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
        btnGuardarplanVida = new javax.swing.JButton();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtcFecha = new com.toedter.calendar.JDateChooser();
        dtcFechaProximaEvaluacion = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnNNA = new javax.swing.JButton();

        jLabel19.setText("Precepcion del grupo familiar sobre su situación actual.");

        jLabel20.setText("¿Como se siente?");

        jLabel21.setText("¿Ha alcanzado los objetivos planteados?");

        jLabel22.setText("¿Cuales han sido las dificultades que ha encontrado?");

        jLabel23.setText("Visión del equipo con respecto a la unidad familiar actual");

        txaVisionEdit.setColumns(20);
        txaVisionEdit.setRows(5);
        jScrollPane5.setViewportView(txaVisionEdit);

        txtObjPlanedEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObjPlanedEditActionPerformed(evt);
            }
        });

        btnOk.setText("Ok");

        lblCodEdit.setText("Cod:");

        btnCancelarEdit.setText("Cancelar");

        javax.swing.GroupLayout pnlDesarrollo2Layout = new javax.swing.GroupLayout(pnlDesarrollo2);
        pnlDesarrollo2.setLayout(pnlDesarrollo2Layout);
        pnlDesarrollo2Layout.setHorizontalGroup(
            pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesarrollo2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDesarrollo2Layout.createSequentialGroup()
                        .addComponent(btnCancelarEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnOk))
                    .addGroup(pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane5)
                        .addComponent(jLabel23)
                        .addGroup(pnlDesarrollo2Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlDesarrollo2Layout.createSequentialGroup()
                            .addGroup(pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21))
                            .addGap(77, 77, 77)
                            .addGroup(pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtObjPlanedEdit)
                                .addComponent(txtComSienteEdit)))
                        .addGroup(pnlDesarrollo2Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDificEncontradosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        pnlDesarrollo2Layout.setVerticalGroup(
            pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesarrollo2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblCodEdit))
                .addGap(18, 18, 18)
                .addGroup(pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtComSienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtObjPlanedEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtDificEncontradosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelarEdit))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDlgEditLayout = new javax.swing.GroupLayout(jDlgEdit.getContentPane());
        jDlgEdit.getContentPane().setLayout(jDlgEditLayout);
        jDlgEditLayout.setHorizontalGroup(
            jDlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
            .addGroup(jDlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDlgEditLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDesarrollo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDlgEditLayout.setVerticalGroup(
            jDlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
            .addGroup(jDlgEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDlgEditLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDesarrollo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lblNombre.setText("Buscar: ");

        btnCanelarRegl.setText("Cancelar");

        btnActulizartbl.setText("Actulizar");

        tblEditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Nombre y Apellido", "Como se siente", "Objetivos planteados", "Dificultades encontradas", "Visiónn con respecto a la familia", "Fecha", "Fecha Evaluación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        dlgObjGenEsp.setSize(new java.awt.Dimension(900, 500));

        DlgtblObjEsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédua", "Nombre Apellido", "Objetivos Específicos", "Responsable", "Actividad", "Tiempo", "Con el apollo de", "Supuestos y Amenazas", "Fecha", "Fecha evaluación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(DlgtblObjEsp);

        javax.swing.GroupLayout pnlDesarrollo3Layout = new javax.swing.GroupLayout(pnlDesarrollo3);
        pnlDesarrollo3.setLayout(pnlDesarrollo3Layout);
        pnlDesarrollo3Layout.setHorizontalGroup(
            pnlDesarrollo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
        );
        pnlDesarrollo3Layout.setVerticalGroup(
            pnlDesarrollo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );

        tbbDesarrollo1.addTab("Objetivos Especificos", pnlDesarrollo3);

        DlgTblObjGen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Nombre Apellido", "Objetivo General", "Responsable", "Tiempo", "Observación", "Fecha", "Fecha evaluación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(DlgTblObjGen);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );

        tbbDesarrollo1.addTab("Objetivos Generales", jPanel4);

        jLabel8.setText("Buscar");

        btnActDlg.setText("Actualizar");

        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel8)
                .addGap(38, 38, 38)
                .addComponent(txtBuscarOGenEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnActDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tbbDesarrollo1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarOGenEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnActDlg)
                    .addComponent(btnBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(tbbDesarrollo1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout dlgObjGenEspLayout = new javax.swing.GroupLayout(dlgObjGenEsp.getContentPane());
        dlgObjGenEsp.getContentPane().setLayout(dlgObjGenEspLayout);
        dlgObjGenEspLayout.setHorizontalGroup(
            dlgObjGenEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgObjGenEspLayout.setVerticalGroup(
            dlgObjGenEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        btnGuardarplanVida.setText("Guardar");

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
                            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(118, 118, 118)
                                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtComoseVe)
                                    .addComponent(txtComSiente)))
                            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel11))
                                .addGap(0, 427, Short.MAX_VALUE))
                            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtComoleGustariasuVida))))
                    .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarplanVida, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(btnGuardarplanVida)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Desarrollo", pnlDesarrollo1);

        tabObjetivoGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Objetivo General", "Personal", "Tiempo", "Observacion"
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
                "Código", "Objetivos Especificos", "Personal", "Actividad", "Tiempo", "Con el apoyo de", "Supuestos y Amenazas"
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
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObjetivosEspecificos)
                    .addComponent(jLabel17)
                    .addComponent(lblCodigoObEsp))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Objetivos", jPanel1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("       Plan de Vida");

        jLabel2.setText("Nombre:");

        jLabel3.setText("NNA: ");

        jLabel4.setText("Fecha Elaboración:");

        jLabel5.setText("Fecha de evaluación:");

        jLabel6.setText("Cedula");

        jLabel7.setText("Codigo: ");

        btnNNA.setText("Registro NNA");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(btnNNA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtcFechaProximaEvaluacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtcFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createSequentialGroup()
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtcFechaProximaEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)
                        .addComponent(btnNNA)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout plPlandeVidaLayout = new javax.swing.GroupLayout(plPlandeVida);
        plPlandeVida.setLayout(plPlandeVidaLayout);
        plPlandeVidaLayout.setHorizontalGroup(
            plPlandeVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCabecera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        plPlandeVidaLayout.setVerticalGroup(
            plPlandeVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plPlandeVidaLayout.createSequentialGroup()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 117, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plPlandeVida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(plPlandeVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtObjPlanedEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObjPlanedEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObjPlanedEditActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DlgTblObjGen;
    private javax.swing.JTable DlgtblObjEsp;
    private javax.swing.JButton btnActDlg;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActulizartbl;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnCancelarEdit;
    private javax.swing.JButton btnCanelarRegl;
    private javax.swing.JButton btnGuardarplanVida;
    private javax.swing.JButton btnNNA;
    private javax.swing.JButton btnObjetivoGeneral;
    private javax.swing.JButton btnObjetivosEspecificos;
    private javax.swing.JButton btnOk;
    private javax.swing.JDialog dlgObjGenEsp;
    private com.toedter.calendar.JDateChooser dtcFecha;
    private com.toedter.calendar.JDateChooser dtcFechaProximaEvaluacion;
    private javax.swing.JDialog jDlgEdit;
    private javax.swing.JDialog jDlgEditTbl;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblCodEdit;
    private javax.swing.JLabel lblCodigoObEsp;
    private javax.swing.JLabel lblCodigoObGen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel plPlandeVida;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlDesarrollo1;
    private javax.swing.JPanel pnlDesarrollo2;
    private javax.swing.JPanel pnlDesarrollo3;
    private javax.swing.JTable tabObjetivoGeneral;
    private javax.swing.JTable tabObjetivosEspecificos;
    private javax.swing.JTabbedPane tbbDesarrollo1;
    private javax.swing.JTable tblEditar;
    private javax.swing.JTextArea txaVisionEdit;
    private javax.swing.JTextArea txaVisionUFA;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarOGenEsp;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComSiente;
    private javax.swing.JTextField txtComSienteEdit;
    private javax.swing.JTextField txtComoleGustariasuVida;
    private javax.swing.JTextField txtComoseVe;
    private javax.swing.JTextField txtDificEncontradosEdit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtObjPlanedEdit;
    // End of variables declaration//GEN-END:variables
}
