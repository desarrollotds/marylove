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
        btnCancelarEdit = new javax.swing.JButton();
        jDlgEditTbl = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        btnCanelarRegl = new javax.swing.JButton();
        btnActulizartbl = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblEditar = new javax.swing.JTable();
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
        jLabel1 = new javax.swing.JLabel();
        btnActDlg = new javax.swing.JButton();
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
        btnVerReg = new javax.swing.JButton();

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
                "Código", "Como se siente", "Objetivos planteados", "Dificultades encontradas", "vision con respecto a la familia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblEditar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnActulizartbl)
                .addGap(18, 18, 18)
                .addComponent(btnCanelarRegl)
                .addGap(21, 21, 21))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCanelarRegl)
                    .addComponent(btnActulizartbl))
                .addGap(4, 4, 4))
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
                "Código", "Objetivos Específicos", "Responsable", "Actividad", "Tiempo", "Con el apollo de", "Supuestos y Amenazas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(DlgtblObjEsp);
        if (DlgtblObjEsp.getColumnModel().getColumnCount() > 0) {
            DlgtblObjEsp.getColumnModel().getColumn(5).setResizable(false);
        }

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
                "Código", "Objetivo General", "Responsable", "Tiempo", "Observación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
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

        jLabel1.setText("Buscar");

        btnActDlg.setText("Actualizar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(txtBuscarOGenEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(btnActDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tbbDesarrollo1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarOGenEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnActDlg))
                .addContainerGap(528, Short.MAX_VALUE))
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

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Evaluacion Plan de Vida");

        jLabel64.setText("Nombre:");

        jLabel65.setText("NNA: ");

        jLabel66.setText("Fecha:");

        jLabel67.setText("Fecha de evaluación:");

        jLabel68.setText("Cedula");

        jLabel69.setText("Codigo: ");

        btnGuradar.setText("Guardar");

        javax.swing.GroupLayout pnlCabecera7Layout = new javax.swing.GroupLayout(pnlCabecera7);
        pnlCabecera7.setLayout(pnlCabecera7Layout);
        pnlCabecera7Layout.setHorizontalGroup(
            pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabecera7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addGap(32, 32, 32)
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(txtNNA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabecera7Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnGuradar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCabecera7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtcFechaEval, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtcFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabecera7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCabecera7Layout.setVerticalGroup(
            pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabecera7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCabecera7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabecera7Layout.createSequentialGroup()
                        .addComponent(dtcFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dtcFechaEval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuradar))
                    .addGroup(pnlCabecera7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
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
                            .addComponent(jLabel69))))
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
                    .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                        .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(484, 484, 484))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDesarrollo1Layout.createSequentialGroup()
                                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                                        .addComponent(BtnVerRegist)
                                        .addGap(89, 89, 89)
                                        .addComponent(btnGuradrarDesa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2))
                                .addGap(81, 81, 81)))
                        .addGap(32, 32, 32))
                    .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                        .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(44, 44, 44)
                        .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtObjPlaned, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtComSiente)
                            .addComponent(txtDificEncontrados, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(82, 82, 82))
                    .addGroup(pnlDesarrollo1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(53, 53, 53))))
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
                .addGroup(pnlDesarrollo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

        btnVerReg.setText("Ver registros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                        .addGap(81, 81, 81)
                        .addComponent(btnVerReg)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(38, 38, 38)
                                .addComponent(btnObjetivoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(29, 29, 29)
                                .addComponent(btnObjetivosEspecificos, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(lblCodigoObGen, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(lblCodigoObEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addComponent(jScrollPane4)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(btnActualizar)
                    .addComponent(btnVerReg))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(btnObjetivoGeneral)
                    .addComponent(lblCodigoObGen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
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
                .addComponent(tbbDesarrollo, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlCabecera7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlEvaluPVLayout.setVerticalGroup(
            pnlEvaluPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEvaluPVLayout.createSequentialGroup()
                .addComponent(pnlCabecera7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbbDesarrollo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEvaluPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEvaluPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtObjPlanedEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObjPlanedEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObjPlanedEditActionPerformed

    public JButton getBtnActDlg() {
        return btnActDlg;
    }

    public void setBtnActDlg(JButton btnActDlg) {
        this.btnActDlg = btnActDlg;
    }

    public JButton getBtnVerReg() {
        return btnVerReg;
    }

    public void setBtnVerReg(JButton btnVerReg) {
        this.btnVerReg = btnVerReg;
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

    public JDialog getDlgObjGenEsp() {
        return dlgObjGenEsp;
    }

    public void setDlgObjGenEsp(JDialog dlgObjGenEsp) {
        this.dlgObjGenEsp = dlgObjGenEsp;
    }

    public JTextField getTxtBuscarOGenEsp() {
        return txtBuscarOGenEsp;
    }

    public void setTxtBuscarOGenEsp(JTextField txtBuscarOGenEsp) {
        this.txtBuscarOGenEsp = txtBuscarOGenEsp;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JButton getBtnActulizartbl() {
        return btnActulizartbl;
    }

    public void setBtnActulizartbl(JButton btnActulizartbl) {
        this.btnActulizartbl = btnActulizartbl;
    }

    public JButton getBtnCanelarRegl() {
        return btnCanelarRegl;
    }

    public void setBtnCanelarRegl(JButton btnCanelarRegl) {
        this.btnCanelarRegl = btnCanelarRegl;
    }

    public JButton getBtnCancelarEdit() {
        return btnCancelarEdit;
    }

    public void setBtnCancelarEdit(JButton btnCancelarEdit) {
        this.btnCancelarEdit = btnCancelarEdit;
    }

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
        return btnCanelarRegl;
    }

    public void setBtnEditTbl(JButton btnEditTbl) {
        this.btnCanelarRegl = btnEditTbl;
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
    private javax.swing.JTable DlgTblObjGen;
    private javax.swing.JTable DlgtblObjEsp;
    private javax.swing.JButton btnActDlg;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActulizartbl;
    private javax.swing.JButton btnCancelarEdit;
    private javax.swing.JButton btnCanelarRegl;
    private javax.swing.JButton btnGuradar;
    private javax.swing.JButton btnGuradrarDesa;
    private javax.swing.JButton btnObjetivoGeneral;
    private javax.swing.JButton btnObjetivosEspecificos;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnVerReg;
    private javax.swing.JDialog dlgObjGenEsp;
    private com.toedter.calendar.JDateChooser dtcFecha1;
    private com.toedter.calendar.JDateChooser dtcFechaEval;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblCodEdit;
    private javax.swing.JLabel lblCodigoObEsp;
    private javax.swing.JLabel lblCodigoObGen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel pnlCabecera7;
    private javax.swing.JPanel pnlDesarrollo1;
    private javax.swing.JPanel pnlDesarrollo2;
    private javax.swing.JPanel pnlDesarrollo3;
    private javax.swing.JPanel pnlEvaluPV;
    private javax.swing.JTable tabObjetivoGeneral;
    private javax.swing.JTable tabObjetivosEspecificos;
    private javax.swing.JTabbedPane tbbDesarrollo;
    private javax.swing.JTabbedPane tbbDesarrollo1;
    private javax.swing.JTable tblEditar;
    private javax.swing.JTextArea txaVision1;
    private javax.swing.JTextArea txaVisionEdit;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarOGenEsp;
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
