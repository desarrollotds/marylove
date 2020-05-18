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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FichaEvaluacionPlandeVida extends javax.swing.JFrame {

    public FichaEvaluacionPlandeVida() {
        initComponents();
        //prueba
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
        jDlgEditTbl = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEditar = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        btnEditTbl = new javax.swing.JButton();
        pnlEvaluPV = new javax.swing.JPanel();
        pnlCabecera7 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNNA = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        dtcFecha1 = new com.toedter.calendar.JDateChooser();
        dtcFechaEval = new com.toedter.calendar.JDateChooser();
        jLabel68 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        btnGuradar = new javax.swing.JButton();
        tbbDesarrollo = new javax.swing.JTabbedPane();
        pnlDesarrollo1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaVision1 = new javax.swing.JTextArea();
        txtComSiente = new javax.swing.JTextField();
        txtObjPlaned = new javax.swing.JTextField();
        txtDificEncontrados = new javax.swing.JTextField();
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

        javax.swing.GroupLayout pnlDesarrollo2Layout = new javax.swing.GroupLayout(pnlDesarrollo2);
        pnlDesarrollo2.setLayout(pnlDesarrollo2Layout);
        pnlDesarrollo2Layout.setHorizontalGroup(
            pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesarrollo2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlDesarrollo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOk)
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
                .addComponent(btnOk)
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

        tblEditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Como se siente?", "Alcanzo objetivos como", "Dificultades encontradas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEditar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblEditar);
        if (tblEditar.getColumnModel().getColumnCount() > 0) {
            tblEditar.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblEditar.getColumnModel().getColumn(1).setPreferredWidth(280);
            tblEditar.getColumnModel().getColumn(2).setPreferredWidth(280);
            tblEditar.getColumnModel().getColumn(3).setPreferredWidth(280);
        }

        lblNombre.setText("Nombre: ");

        btnEditTbl.setText("Editar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 245, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditTbl)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnEditTbl))
        );

        javax.swing.GroupLayout jDlgEditTblLayout = new javax.swing.GroupLayout(jDlgEditTbl.getContentPane());
        jDlgEditTbl.getContentPane().setLayout(jDlgEditTblLayout);
        jDlgEditTblLayout.setHorizontalGroup(
            jDlgEditTblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDlgEditTblLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDlgEditTblLayout.setVerticalGroup(
            jDlgEditTblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDlgEditTblLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel63.setText("Evaluacion Plan de Vida");

        jLabel64.setText("Nombre:");

        jLabel65.setText("NNA: ");

        jLabel66.setText("Fecha:");

        jLabel67.setText("Fecha de evaluación:");

        jLabel68.setText("Cedula");

        jLabel69.setText("Codigo: ");

        btnGuradar.setText("Guradar");

        javax.swing.GroupLayout pnlCabecera7Layout = new javax.swing.GroupLayout(pnlCabecera7);
        pnlCabecera7.setLayout(pnlCabecera7Layout);
        pnlCabecera7Layout.setHorizontalGroup(
            pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabecera7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlCabecera7Layout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(txtNNA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCabecera7Layout.createSequentialGroup()
                        .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtCedula))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtcFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnGuradar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigo)
                        .addComponent(dtcFechaEval, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(pnlCabecera7Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel63)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCabecera7Layout.setVerticalGroup(
            pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabecera7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dtcFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dtcFechaEval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuradar)
                .addContainerGap())
            .addGroup(pnlCabecera7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel68)
                    .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel66)))
                .addGap(18, 18, 18)
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel64)
                    .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel67)))
                .addGap(18, 18, 18)
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel65))
                    .addComponent(jLabel69))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("Precepcion del grupo familiar sobre su situación actual.");

        jLabel12.setText("¿Como se siente?");

        jLabel13.setText("¿Ha alcanzado los objetivos planteados?");

        jLabel14.setText("¿Cuales han sido las dificultades que ha encontrado?");

        jLabel15.setText("Visión del equipo con respecto a la unidad familiar actual");

        txaVision1.setColumns(20);
        txaVision1.setRows(5);
        jScrollPane2.setViewportView(txaVision1);

        btnGuradrarDesa.setText("Guardar");

        BtnVerRegist.setText("Ver Registro");

        javax.swing.GroupLayout pnlDesarrollo1Layout = new javax.swing.GroupLayout(pnlDesarrollo1);
        pnlDesarrollo1.setLayout(pnlDesarrollo1Layout);
        pnlDesarrollo1Layout.setHorizontalGroup(
            pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDesarrollo1Layout.createSequentialGroup()
                        .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(123, 123, 123)
                        .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDificEncontrados, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                            .addComponent(txtComSiente, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                            .addComponent(txtObjPlaned))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                        .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14))
                                .addGap(484, 484, 484))
                            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                                .addComponent(BtnVerRegist)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuradrarDesa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );
        pnlDesarrollo1Layout.setVerticalGroup(
            pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtComSiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtObjPlaned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDificEncontrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuradrarDesa)
                    .addComponent(BtnVerRegist))
                .addGap(24, 24, 24))
        );

        tbbDesarrollo.addTab("Desarrollo", pnlDesarrollo1);

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
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                        .addGap(138, 138, 138)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(38, 38, 38)
                                .addComponent(btnObjetivoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnObjetivosEspecificos, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(lblCodigoObGen, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(lblCodigoObEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addComponent(jScrollPane4)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(btnObjetivoGeneral)
                    .addComponent(lblCodigoObGen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(btnObjetivosEspecificos)
                    .addComponent(lblCodigoObEsp))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbbDesarrollo.addTab("Objetivos", jPanel1);

        javax.swing.GroupLayout pnlEvaluPVLayout = new javax.swing.GroupLayout(pnlEvaluPV);
        pnlEvaluPV.setLayout(pnlEvaluPVLayout);
        pnlEvaluPVLayout.setHorizontalGroup(
            pnlEvaluPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEvaluPVLayout.createSequentialGroup()
                .addGroup(pnlEvaluPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tbbDesarrollo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEvaluPVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlCabecera7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEvaluPVLayout.setVerticalGroup(
            pnlEvaluPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEvaluPVLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(pnlCabecera7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbbDesarrollo)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEvaluPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEvaluPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtObjPlanedEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObjPlanedEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObjPlanedEditActionPerformed

    public JDateChooser getDtcFechaEval() {
        return dtcFechaEval;
    }

    public void setDtcFechaEval(JDateChooser dtcFechaEval) {
        this.dtcFechaEval = dtcFechaEval;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
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

    public JButton getBtnEditTbl() {
        return btnEditTbl;
    }

    public void setBtnEditTbl(JButton btnEditTbl) {
        this.btnEditTbl = btnEditTbl;
    }

    public JDialog getjDlgEditTbl() {
        return jDlgEditTbl;
    }

    public void setjDlgEditTbl(JDialog jDlgEditTbl) {
        this.jDlgEditTbl = jDlgEditTbl;
    }

    public JTable getTblEditar() {
        return tblEditar;
    }

    public void setTblEditar(JTable tblEditar) {
        this.tblEditar = tblEditar;
    }

    public JButton getBtnVerRegist() {
        return BtnVerRegist;
    }

    public void setBtnVerRegist(JButton BtnVerRegist) {
        this.BtnVerRegist = BtnVerRegist;
    }

    public JButton getBtnOk() {
        return btnOk;
    }

    public void setBtnOk(JButton btnOk) {
        this.btnOk = btnOk;
    }

    public JDialog getjDlgEdit() {
        return jDlgEdit;
    }

    public void setjDlgEdit(JDialog jDlgEdit) {
        this.jDlgEdit = jDlgEdit;
    }

    public JTextArea getTxaVisionEdit() {
        return txaVisionEdit;
    }

    public void setTxaVisionEdit(JTextArea txaVisionEdit) {
        this.txaVisionEdit = txaVisionEdit;
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

    public JButton getBtnGuradrarDesa() {
        return btnGuradrarDesa;
    }

    public void setBtnGuradrarDesa(JButton btnGuradrarDesa) {
        this.btnGuradrarDesa = btnGuradrarDesa;
    }

    public JButton getBtnGuradar() {
        return btnGuradar;
    }

    public void setBtnGuradar(JButton btnGuradar) {
        this.btnGuradar = btnGuradar;
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

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
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
        return dtcFecha1;
    }

    public void setDtcFecha(JDateChooser dtcFecha) {
        this.dtcFecha1 = dtcFecha;
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

    public JTextArea getTxaVision1() {
        return txaVision1;
    }

    public void setTxaVision1(JTextArea txaVision1) {
        this.txaVision1 = txaVision1;
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

    public JTextField getTxtComSiente() {
        return txtComSiente;
    }

    public void setTxtComSiente(JTextField txtComSiente) {
        this.txtComSiente = txtComSiente;
    }

    public JTextField getTxtDificEncontrados() {
        return txtDificEncontrados;
    }

    public void setTxtDificEncontrados(JTextField txtDificEncontrados) {
        this.txtDificEncontrados = txtDificEncontrados;
    }

    public JTextField getTxtObjPlaned() {
        return txtObjPlaned;
    }

    public void setTxtObjPlaned(JTextField txtObjPlaned) {
        this.txtObjPlaned = txtObjPlaned;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JPanel getPnlEvaluPV() {
        return pnlEvaluPV;
    }

    public void setPnlEvaluPV(JPanel pnlEvaluPV) {
        this.pnlEvaluPV = pnlEvaluPV;
    }
    
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVerRegist;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditTbl;
    private javax.swing.JButton btnGuradar;
    private javax.swing.JButton btnGuradrarDesa;
    private javax.swing.JButton btnObjetivoGeneral;
    private javax.swing.JButton btnObjetivosEspecificos;
    private javax.swing.JButton btnOk;
    private com.toedter.calendar.JDateChooser dtcFecha1;
    private com.toedter.calendar.JDateChooser dtcFechaEval;
    private javax.swing.JDialog jDlgEdit;
    private javax.swing.JDialog jDlgEditTbl;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblCodEdit;
    private javax.swing.JLabel lblCodigoObEsp;
    private javax.swing.JLabel lblCodigoObGen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel pnlCabecera7;
    private javax.swing.JPanel pnlDesarrollo1;
    private javax.swing.JPanel pnlDesarrollo2;
    private javax.swing.JPanel pnlEvaluPV;
    private javax.swing.JTable tabObjetivoGeneral;
    private javax.swing.JTable tabObjetivosEspecificos;
    private javax.swing.JTabbedPane tbbDesarrollo;
    private javax.swing.JTable tblEditar;
    private javax.swing.JTextArea txaVision1;
    private javax.swing.JTextArea txaVisionEdit;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComSiente;
    private javax.swing.JTextField txtComSienteEdit;
    private javax.swing.JTextField txtDificEncontrados;
    private javax.swing.JTextField txtDificEncontradosEdit;
    private javax.swing.JTextField txtNNA;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtObjPlaned;
    private javax.swing.JTextField txtObjPlanedEdit;
    // End of variables declaration//GEN-END:variables
}
