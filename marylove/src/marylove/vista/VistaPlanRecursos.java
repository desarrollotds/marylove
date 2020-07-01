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

    public JButton getBtnCancelarPlanRecursos() {
        return btnCancelarPlanRecursos;
    }

    public void setBtnCancelarPlanRecursos(JButton btnCancelarPlanRecursos) {
        this.btnCancelarPlanRecursos = btnCancelarPlanRecursos;
    }

    public JButton getBtnActualizar_Montos() {
        return btnActualizar_Montos;
    }

    public void setBtnActualizar_Montos(JButton btnActualizar_Montos) {
        this.btnActualizar_Montos = btnActualizar_Montos;
    }

    public JButton getBtnAgregarMontoNeces() {
        return btnAgregarMontoNeces;
    }

    public void setBtnAgregarMontoNeces(JButton btnAgregarMontoNeces) {
        this.btnAgregarMontoNeces = btnAgregarMontoNeces;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JTable getTblMontoDisponible() {
        return tblMontoDisponible;
    }

    public void setTblMontoDisponible(JTable tblMontoDisponible) {
        this.tblMontoDisponible = tblMontoDisponible;
    }

    public JTable getTblMontoNecesita() {
        return tblMontoNecesita;
    }

    public void setTblMontoNecesita(JTable tblMontoNecesita) {
        this.tblMontoNecesita = tblMontoNecesita;
    }

    
    public JButton getBtnNuevoCuentasDiarias() {
        return btnNuevoCuentasDiarias;
    }

    public void setBtnNuevoCuentasDiarias(JButton btnNuevoCuentasDiarias) {
        this.btnNuevoCuentasDiarias = btnNuevoCuentasDiarias;
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
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaResolverNecesidades = new javax.swing.JTextArea();
        btnAgregarMonto = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMontoDisponible = new javax.swing.JTable();
        btnAgregarMontoNeces = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMontoNecesita = new javax.swing.JTable();
        btnActualizar_Montos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCuentasDiarias = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnNuevoCuentasDiarias = new javax.swing.JButton();
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
        btnCancelarPlanRecursos = new javax.swing.JButton();

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

        jLabel5.setText("Alternativas para resolver necesidades principales:");

        txaResolverNecesidades.setColumns(20);
        txaResolverNecesidades.setLineWrap(true);
        txaResolverNecesidades.setRows(5);
        txaResolverNecesidades.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txaResolverNecesidades);

        btnAgregarMonto.setText("Agregar Monto Disponible");

        tblMontoDisponible.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Vivienda", "Alimentacion", "Educacion", "Transporte"
            }
        ));
        tblMontoDisponible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMontoDisponibleMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblMontoDisponible);

        btnAgregarMontoNeces.setText("Agregar Monto Necesita");

        tblMontoNecesita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Vivienda", "Alimentacion", "Educacion", "Transporte"
            }
        ));
        jScrollPane5.setViewportView(tblMontoNecesita);

        btnActualizar_Montos.setText("Actualizar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar_Montos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarMontoNeces, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMonto)
                    .addComponent(btnActualizar_Montos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarMontoNeces)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Identificación de gastos y recursos", jPanel1);

        jLabel6.setText("Montos del que dispongo:");

        tblCuentasDiarias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha", "Gastos", "Descripción del gasto", "Saldo"
            }
        ));
        jScrollPane3.setViewportView(tblCuentasDiarias);

        btnActualizar.setText("Actualizar");

        btnNuevoCuentasDiarias.setText("Nuevo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btnNuevoCuentasDiarias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addGap(609, 609, 609)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNuevoCuentasDiarias)
                        .addGap(11, 11, 11)
                        .addComponent(btnActualizar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cuentas diarias", jPanel2);

        jLabel3.setText("Código:");

        jLabel4.setText("Fecha:");

        jLabel2.setText("Cedula:");

        jLabel7.setText("Nombre:");

        btnGuardarPlanRecursos.setText("GUARDAR");

        jLabel16.setText("Monto Actual:");

        btnCancelarPlanRecursos.setText("CANCELAR");

        javax.swing.GroupLayout plRecursosLayout = new javax.swing.GroupLayout(plRecursos);
        plRecursos.setLayout(plRecursosLayout);
        plRecursosLayout.setHorizontalGroup(
            plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(plRecursosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plRecursosLayout.createSequentialGroup()
                        .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plRecursosLayout.createSequentialGroup()
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigovictima, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(plRecursosLayout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datFechaPlanRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(plRecursosLayout.createSequentialGroup()
                        .addComponent(txtMontoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plRecursosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarPlanRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardarPlanRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        plRecursosLayout.setVerticalGroup(
            plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plRecursosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plRecursosLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(plRecursosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigovictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(17, 17, 17)
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datFechaPlanRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(22, 22, 22)
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMontoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarPlanRecursos)
                    .addComponent(btnCancelarPlanRecursos))
                .addContainerGap(53, Short.MAX_VALUE))
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

    private void tblMontoDisponibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMontoDisponibleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMontoDisponibleMouseClicked

    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizar_Montos;
    private javax.swing.JButton btnAgregarMonto;
    private javax.swing.JButton btnAgregarMontoNeces;
    private javax.swing.JButton btnCancelarPlanRecursos;
    private javax.swing.JButton btnGuardarGastosyRecursos;
    private javax.swing.JButton btnGuardarPlanRecursos;
    private javax.swing.JButton btnNuevoCuentasDiarias;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel plRecursos;
    private javax.swing.JTable tblCuentasDiarias;
    private javax.swing.JTable tblMontoDisponible;
    private javax.swing.JTable tblMontoNecesita;
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
    // End of variables declaration//GEN-END:variables
}
