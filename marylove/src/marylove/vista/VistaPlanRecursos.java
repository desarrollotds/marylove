package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btnEditar = new javax.swing.JButton();
        btnEliminarMonto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCuentasDiarias = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        txtCodigovictima = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        datFechaPlanRecursos = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PLAN DE RECURSOS");

        tblGastosyRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Vivienda", null, null},
                {"Alimentación", null, null},
                {"Educación", null, null},
                {"Transporte", null, null},
                {"TOTAL", null, null}
            },
            new String [] {
                "Gastos prioritarios", "Monto que necesita", "Monto del que dispone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
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

        btnEditar.setText("Editar");

        btnEliminarMonto.setText("Eliminar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(435, 435, 435))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMonto)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminarMonto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
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

        btnNuevo.setText("Nuevo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmonto, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
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
                    .addComponent(btnNuevo)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cuentas diarias", jPanel2);

        jLabel3.setText("Código:");

        jLabel4.setText("Fecha:");

        jLabel2.setText("Cedula:");

        jLabel7.setText("Nombre:");

        btnGuardar.setText("GUARDAR");

        javax.swing.GroupLayout plRecursosLayout = new javax.swing.GroupLayout(plRecursos);
        plRecursos.setLayout(plRecursosLayout);
        plRecursosLayout.setHorizontalGroup(
            plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plRecursosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtCedula))
                .addGap(136, 136, 136)
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCodigovictima)
                    .addComponent(datFechaPlanRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addGap(85, 85, 85))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plRecursosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
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
            .addComponent(plRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JPanel getPlRecursos() {
        return plRecursos;
    }

    public void setPlRecursos(JPanel plRecursos) {
        this.plRecursos = plRecursos;
    }

    
    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JDateChooser getDatFechaPlanRecursos() {
        return datFechaPlanRecursos;
    }

    public void setDatFechaPlanRecursos(JDateChooser datFechaPlanRecursos) {
        this.datFechaPlanRecursos = datFechaPlanRecursos;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
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

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JButton getBtnAgregarMonto() {
        return btnAgregarMonto;
    }

    public void setBtnAgregarMonto(JButton btnAgregarMonto) {
        this.btnAgregarMonto = btnAgregarMonto;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnEliminarMonto() {
        return btnEliminarMonto;
    }

    public void setBtnEliminarMonto(JButton btnEliminarMonto) {
        this.btnEliminarMonto = btnEliminarMonto;
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMonto;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminarMonto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private com.toedter.calendar.JDateChooser datFechaPlanRecursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel plRecursos;
    private javax.swing.JTable tblCuentasDiarias;
    private javax.swing.JTable tblGastosyRecursos;
    private javax.swing.JTextArea txaResolverNecesidades;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigovictima;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables
}
