package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Angel Lucero
 */
public class VistaPlanRecursos extends javax.swing.JFrame {
   
    /**
     * Creates new form VistaPlanRecursos
     */
    public VistaPlanRecursos() {
        initComponents();
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnAgregarMonto() {
        return btnAgregarMonto;
    }

    public void setBtnAgregarMonto(JButton btnAgregarMonto) {
        this.btnAgregarMonto = btnAgregarMonto;
    }

    public JButton getBtnGuardarGastosyRecursos() {
        return btnGuardarGastosyRecursos;
    }

    public void setBtnGuardarGastosyRecursos(JButton btnGuardarGastosyRecursos) {
        this.btnGuardarGastosyRecursos = btnGuardarGastosyRecursos;
    }

    public JButton getBtnGuardarPlanRecursos() {
        return btnGuardarPlanRecursos;
    }

    public void setBtnGuardarPlanRecursos(JButton btnGuardarPlanRecursos) {
        this.btnGuardarPlanRecursos = btnGuardarPlanRecursos;
    }

    public JDateChooser getDatFechaPlanRecursos() {
        return datFechaPlanRecursos;
    }

    public void setDatFechaPlanRecursos(JDateChooser datFechaPlanRecursos) {
        this.datFechaPlanRecursos = datFechaPlanRecursos;
    }

    public JDialog getDlgPlanRecursoMontos() {
        return dlgPlanRecursoMontos;
    }

    public void setDlgPlanRecursoMontos(JDialog dlgPlanRecursoMontos) {
        this.dlgPlanRecursoMontos = dlgPlanRecursoMontos;
    }

    public JPanel getPlRecursos() {
        return plRecursos;
    }

    public void setPlRecursos(JPanel plRecursos) {
        this.plRecursos = plRecursos;
    }

    public JTable getTblCuentasDiarias() {
        return tblCuentasDiarias;
    }

    public void setTblCuentasDiarias(JTable tblCuentasDiarias) {
        this.tblCuentasDiarias = tblCuentasDiarias;
    }

    public JTable getTblGastosyRecursos() {
        return tblGastosyRecursos;
    }

    public void setTblGastosyRecursos(JTable tblGastosyRecursos) {
        this.tblGastosyRecursos = tblGastosyRecursos;
    }

    public JTextArea getTxaResolverNecesidades() {
        return txaResolverNecesidades;
    }

    public void setTxaResolverNecesidades(JTextArea txaResolverNecesidades) {
        this.txaResolverNecesidades = txaResolverNecesidades;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtCodigovictima() {
        return txtCodigovictima;
    }

    public void setTxtCodigovictima(JTextField txtCodigovictima) {
        this.txtCodigovictima = txtCodigovictima;
    }

    public JTextField getTxtMdAlimen() {
        return txtMdAlimen;
    }

    public void setTxtMdAlimen(JTextField txtMdAlimen) {
        this.txtMdAlimen = txtMdAlimen;
    }

    public JTextField getTxtMdEduc() {
        return txtMdEduc;
    }

    public void setTxtMdEduc(JTextField txtMdEduc) {
        this.txtMdEduc = txtMdEduc;
    }

    public JTextField getTxtMdTransp() {
        return txtMdTransp;
    }

    public void setTxtMdTransp(JTextField txtMdTransp) {
        this.txtMdTransp = txtMdTransp;
    }

    public JTextField getTxtMdVivienda() {
        return txtMdVivienda;
    }

    public void setTxtMdVivienda(JTextField txtMdVivienda) {
        this.txtMdVivienda = txtMdVivienda;
    }

    public JTextField getTxtMnAlimentacion() {
        return txtMnAlimentacion;
    }

    public void setTxtMnAlimentacion(JTextField txtMnAlimentacion) {
        this.txtMnAlimentacion = txtMnAlimentacion;
    }

    public JTextField getTxtMnEducacion() {
        return txtMnEducacion;
    }

    public void setTxtMnEducacion(JTextField txtMnEducacion) {
        this.txtMnEducacion = txtMnEducacion;
    }

    public JTextField getTxtMnTransporte() {
        return txtMnTransporte;
    }

    public void setTxtMnTransporte(JTextField txtMnTransporte) {
        this.txtMnTransporte = txtMnTransporte;
    }

    public JTextField getTxtMnVivienda() {
        return txtMnVivienda;
    }

    public void setTxtMnVivienda(JTextField txtMnVivienda) {
        this.txtMnVivienda = txtMnVivienda;
    }

    public JTextField getTxtMontoActual() {
        return txtMontoActual;
    }

    public void setTxtMontoActual(JTextField txtMontoActual) {
        this.txtMontoActual = txtMontoActual;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtmonto() {
        return txtmonto;
    }

    public void setTxtmonto(JTextField txtmonto) {
        this.txtmonto = txtmonto;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgPlanRecursoMontos = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMnVivienda = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMnAlimentacion = new javax.swing.JTextField();
        txtMnEducacion = new javax.swing.JTextField();
        txtMnTransporte = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMdVivienda = new javax.swing.JTextField();
        txtMdAlimen = new javax.swing.JTextField();
        txtMdEduc = new javax.swing.JTextField();
        txtMdTransp = new javax.swing.JTextField();
        btnGuardarGastosyRecursos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        plRecursos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGastosyRecursos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaResolverNecesidades = new javax.swing.JTextArea();
        btnAgregarMonto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCuentasDiarias = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        txtCodigovictima = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        datFechaPlanRecursos = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardarPlanRecursos = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtMontoActual = new javax.swing.JTextField();

        dlgPlanRecursoMontos.setMinimumSize(new java.awt.Dimension(540, 300));
        dlgPlanRecursoMontos.setSize(new java.awt.Dimension(0, 0));

        jLabel8.setText("Identificación de Gastos y Recursos");

        jLabel9.setText("Gastos Prioritarios:");

        txtMnVivienda.setToolTipText("No puede ser mayor al Monto Disponible");

        jLabel10.setText("Vivienda:");

        jLabel11.setText("Alimentación:");

        jLabel12.setText("Educación:");

        jLabel13.setText("Transporte:");

        txtMnAlimentacion.setToolTipText("No puede ser mayor al Monto Disponible");

        txtMnEducacion.setToolTipText("No puede ser mayor al Monto Disponible");

        txtMnTransporte.setToolTipText("No puede ser mayor al Monto Disponible");

        jLabel14.setText("Monto que Necesita:");

        jLabel15.setText("Monto Dispone:");

        btnGuardarGastosyRecursos.setText("Guardar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jLabel11))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(107, 107, 107)
                                .addComponent(jLabel15))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMnEducacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMnAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMnTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMnVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGuardarGastosyRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtMdVivienda)
                                    .addComponent(txtMdAlimen)
                                    .addComponent(txtMdEduc)
                                    .addComponent(txtMdTransp))))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMdVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMnVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMnAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMdAlimen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMnEducacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMdEduc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMnTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMdTransp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardarGastosyRecursos)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgPlanRecursoMontosLayout = new javax.swing.GroupLayout(dlgPlanRecursoMontos.getContentPane());
        dlgPlanRecursoMontos.getContentPane().setLayout(dlgPlanRecursoMontosLayout);
        dlgPlanRecursoMontosLayout.setHorizontalGroup(
            dlgPlanRecursoMontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgPlanRecursoMontosLayout.setVerticalGroup(
            dlgPlanRecursoMontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PLAN DE RECURSOS");

        tblGastosyRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Vivienda:", null, null},
                {"Alimentacion:", null, null},
                {"Educacion:", null, null},
                {"Transporte.", null, null},
                {"Total:", null, null}
            },
            new String [] {
                "Gastos prioritarios", "Monto que necesita", "Monto del que dispone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGastosyRecursos);

        jLabel5.setText("Alternativas para resolver necesidades principales:");

        txaResolverNecesidades.setColumns(20);
        txaResolverNecesidades.setLineWrap(true);
        txaResolverNecesidades.setRows(5);
        txaResolverNecesidades.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txaResolverNecesidades);

        btnAgregarMonto.setText("Agregar Monto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(435, 435, 435))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarMonto)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Identificación de gastos y recursos", jPanel1);

        jLabel6.setText("Montos del que dispongo:");

        tblCuentasDiarias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Gastos", "Descripción del gasto", "Saldo"
            }
        ));
        jScrollPane3.setViewportView(tblCuentasDiarias);

        btnActualizar.setText("Actualizar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmonto, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addGap(357, 357, 357)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cuentas diarias", jPanel2);

        jLabel3.setText("Código:");

        jLabel4.setText("Fecha:");

        jLabel2.setText("Cedula:");

        jLabel7.setText("Nombre:");

        btnGuardarPlanRecursos.setText("GUARDAR");

        jLabel16.setText("Monto Actual:");

        javax.swing.GroupLayout plRecursosLayout = new javax.swing.GroupLayout(plRecursos);
        plRecursos.setLayout(plRecursosLayout);
        plRecursosLayout.setHorizontalGroup(
            plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(plRecursosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plRecursosLayout.createSequentialGroup()
                        .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plRecursosLayout.createSequentialGroup()
                                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23))
                            .addGroup(plRecursosLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtCedula)
                            .addComponent(txtMontoActual))
                        .addGap(139, 139, 139)
                        .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCodigovictima)
                            .addComponent(datFechaPlanRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plRecursosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardarPlanRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        plRecursosLayout.setVerticalGroup(
            plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plRecursosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigovictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datFechaPlanRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel7)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plRecursosLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel16))
                    .addGroup(plRecursosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtMontoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarPlanRecursos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarMonto;
    private javax.swing.JButton btnGuardarGastosyRecursos;
    private javax.swing.JButton btnGuardarPlanRecursos;
    private com.toedter.calendar.JDateChooser datFechaPlanRecursos;
    private javax.swing.JDialog dlgPlanRecursoMontos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel plRecursos;
    private javax.swing.JTable tblCuentasDiarias;
    private javax.swing.JTable tblGastosyRecursos;
    private javax.swing.JTextArea txaResolverNecesidades;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigovictima;
    private javax.swing.JTextField txtMdAlimen;
    private javax.swing.JTextField txtMdEduc;
    private javax.swing.JTextField txtMdTransp;
    private javax.swing.JTextField txtMdVivienda;
    private javax.swing.JTextField txtMnAlimentacion;
    private javax.swing.JTextField txtMnEducacion;
    private javax.swing.JTextField txtMnTransporte;
    private javax.swing.JTextField txtMnVivienda;
    private javax.swing.JTextField txtMontoActual;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables
}
