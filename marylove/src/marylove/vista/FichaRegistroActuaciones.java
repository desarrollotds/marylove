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
import javax.swing.JTextField;

/**
 *
 * @author dario
 */
public class FichaRegistroActuaciones extends javax.swing.JFrame {

    /**
     * Creates new form FichaRegistroActuaciones
     */
    public FichaRegistroActuaciones() {
        initComponents();
    }

    public JButton getBtnCCanc() {
        return btnCCanc;
    }

    public void setBtnCCanc(JButton btnCCanc) {
        this.btnCCanc = btnCCanc;
    }

    public JButton getBtnCGuar() {
        return btnCGuar;
    }

    public void setBtnCGuar(JButton btnCGuar) {
        this.btnCGuar = btnCGuar;
    }

    public JButton getBtnGuarRA() {
        return btnGuarRA;
    }

    public void setBtnGuarRA(JButton btnGuarRA) {
        this.btnGuarRA = btnGuarRA;
    }

    public JButton getBtnRACanc() {
        return btnRACanc;
    }

    public void setBtnRACanc(JButton btnRACanc) {
        this.btnRACanc = btnRACanc;
    }

    public JDateChooser getJdcCFechCier() {
        return jdcCFechCier;
    }

    public void setJdcCFechCier(JDateChooser jdcCFechCier) {
        this.jdcCFechCier = jdcCFechCier;
    }

    public JDateChooser getJdcCFechLimite() {
        return jdcCFechLimite;
    }

    public void setJdcCFechLimite(JDateChooser jdcCFechLimite) {
        this.jdcCFechLimite = jdcCFechLimite;
    }

    public JDateChooser getJdcRAFechLimite() {
        return jdcRAFechLimite;
    }

    public void setJdcRAFechLimite(JDateChooser jdcRAFechLimite) {
        this.jdcRAFechLimite = jdcRAFechLimite;
    }

    public JDialog getJdiCierre() {
        return jdiCierre;
    }

    public void setJdiCierre(JDialog jdiCierre) {
        this.jdiCierre = jdiCierre;
    }

    public JDialog getJdiRegActu() {
        return jdiRegActu;
    }

    public void setJdiRegActu(JDialog jdiRegActu) {
        this.jdiRegActu = jdiRegActu;
    }

    public JTextField getTxtCNotDil() {
        return txtCNotDil;
    }

    public void setTxtCNotDil(JTextField txtCNotDil) {
        this.txtCNotDil = txtCNotDil;
    }

    public JTextField getTxtCObs() {
        return txtCObs;
    }

    public void setTxtCObs(JTextField txtCObs) {
        this.txtCObs = txtCObs;
    }

    public JLabel getLabCId() {
        return labCId;
    }

    public void setLabCId(JLabel labCId) {
        this.labCId = labCId;
    }

    public JTextField getTxtRANotDil() {
        return txtRANotDil;
    }

    public void setTxtRANotDil(JTextField txtRANotDil) {
        this.txtRANotDil = txtRANotDil;
    }

    public JTextField getTxtRAObs() {
        return txtRAObs;
    }

    public void setTxtRAObs(JTextField txtRAObs) {
        this.txtRAObs = txtRAObs;
    }

    public JLabel getLabRAId() {
        return labRAId;
    }

    public void setLabRAId(JLabel labRAId) {
        this.labRAId = labRAId;
    }

    public JButton getBtnAñadirActuacion() {
        return btnAñadirActuacion;
    }

    public void setBtnAñadirActuacion(JButton btnAñadirActuacion) {
        this.btnAñadirActuacion = btnAñadirActuacion;
    }

    public JButton getBtnAñadirCierre() {
        return btnAñadirCierre;
    }

    public void setBtnAñadirCierre(JButton btnAñadirCierre) {
        this.btnAñadirCierre = btnAñadirCierre;
    }

    public JButton getBtnEditarActuacion() {
        return btnEditarActuacion;
    }

    public void setBtnEditarActuacion(JButton btnEditarActuacion) {
        this.btnEditarActuacion = btnEditarActuacion;
    }

    public JButton getBtnEditarCierre() {
        return btnEditarCierre;
    }

    public void setBtnEditarCierre(JButton btnEditarCierre) {
        this.btnEditarCierre = btnEditarCierre;
    }

    public JButton getBtnEliminarActuacion() {
        return btnEliminarActuacion;
    }

    public void setBtnEliminarActuacion(JButton btnEliminarActuacion) {
        this.btnEliminarActuacion = btnEliminarActuacion;
    }

    public JButton getBtnEliminarCierre() {
        return btnEliminarCierre;
    }

    public void setBtnEliminarCierre(JButton btnEliminarCierre) {
        this.btnEliminarCierre = btnEliminarCierre;
    }

    public JDateChooser getFechaRegistroActuaciones() {
        return fechaRegistroActuaciones;
    }

    public void setFechaRegistroActuaciones(JDateChooser fechaRegistroActuaciones) {
        this.fechaRegistroActuaciones = fechaRegistroActuaciones;
    }

    public JTable getJtTablaActuaciones() {
        return jtTablaActuaciones;
    }

    public void setJtTablaActuaciones(JTable jtTablaActuaciones) {
        this.jtTablaActuaciones = jtTablaActuaciones;
    }

    public JTable getJtTablaCierre() {
        return jtTablaCierre;
    }

    public void setJtTablaCierre(JTable jtTablaCierre) {
        this.jtTablaCierre = jtTablaCierre;
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

    public JPanel getJpFondo() {
        return jpFondo;
    }

    public void setJpFondo(JPanel jpFondo) {
        this.jpFondo = jpFondo;
    }

    public JButton getBtnLimp() {
        return btnLimp;
    }

    public void setBtnLimp(JButton btnLimp) {
        this.btnLimp = btnLimp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdiCierre = new javax.swing.JDialog();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCNotDil = new javax.swing.JTextField();
        jdcCFechLimite = new com.toedter.calendar.JDateChooser();
        txtCObs = new javax.swing.JTextField();
        btnCGuar = new javax.swing.JButton();
        btnCCanc = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jdcCFechCier = new com.toedter.calendar.JDateChooser();
        labCId = new javax.swing.JLabel();
        jdiRegActu = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtRANotDil = new javax.swing.JTextField();
        jdcRAFechLimite = new com.toedter.calendar.JDateChooser();
        txtRAObs = new javax.swing.JTextField();
        btnGuarRA = new javax.swing.JButton();
        btnRACanc = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        labRAId = new javax.swing.JLabel();
        jpFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaActuaciones = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAñadirActuacion = new javax.swing.JButton();
        btnEditarActuacion = new javax.swing.JButton();
        btnEliminarActuacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaCierre = new javax.swing.JTable();
        btnAñadirCierre = new javax.swing.JButton();
        btnEditarCierre = new javax.swing.JButton();
        btnEliminarCierre = new javax.swing.JButton();
        fechaRegistroActuaciones = new com.toedter.calendar.JDateChooser();
        btnLimp = new javax.swing.JButton();

        jLabel16.setText("codigo:  ");

        jLabel17.setText("Notoficación ");

        jLabel18.setText("Diligencias");

        jLabel19.setText("Fecha Limite");

        jLabel20.setText("Observaciones");

        btnCGuar.setText("Guardar");

        btnCCanc.setText("Cancelar");

        jLabel21.setText("LEG/ 2.2 DESCRIPCION DEL CIERRE DEL PROCESO");

        jLabel22.setText("Fecha de Cierre");

        labCId.setText("id");

        javax.swing.GroupLayout jdiCierreLayout = new javax.swing.GroupLayout(jdiCierre.getContentPane());
        jdiCierre.getContentPane().setLayout(jdiCierreLayout);
        jdiCierreLayout.setHorizontalGroup(
            jdiCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdiCierreLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnCGuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCCanc)
                .addGap(75, 75, 75))
            .addGroup(jdiCierreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdiCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdiCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCNotDil)
                    .addComponent(jdcCFechLimite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCObs)
                    .addComponent(jdcCFechCier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdiCierreLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labCId, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jdiCierreLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jdiCierreLayout.setVerticalGroup(
            jdiCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdiCierreLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addGroup(jdiCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labCId)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jdiCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jdiCierreLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addComponent(txtCNotDil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdiCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jdcCFechLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdiCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtCObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdiCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcCFechCier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jdiCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCGuar)
                    .addComponent(btnCCanc))
                .addContainerGap())
        );

        jLabel10.setText("codigo:  ");

        jLabel11.setText("Notoficación ");

        jLabel12.setText("Diligencias");

        jLabel13.setText("Fecha Limite");

        jLabel14.setText("Observaciones");

        btnGuarRA.setText("Guardar");

        btnRACanc.setText("Cancelar");

        jLabel15.setText("LEG/2.1 ACTUACIONES");

        labRAId.setText("id");

        javax.swing.GroupLayout jdiRegActuLayout = new javax.swing.GroupLayout(jdiRegActu.getContentPane());
        jdiRegActu.getContentPane().setLayout(jdiRegActuLayout);
        jdiRegActuLayout.setHorizontalGroup(
            jdiRegActuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdiRegActuLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnGuarRA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(btnRACanc)
                .addGap(75, 75, 75))
            .addGroup(jdiRegActuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdiRegActuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdiRegActuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRANotDil)
                    .addComponent(jdcRAFechLimite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRAObs))
                .addContainerGap())
            .addGroup(jdiRegActuLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdiRegActuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labRAId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jdiRegActuLayout.setVerticalGroup(
            jdiRegActuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdiRegActuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdiRegActuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labRAId, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jdiRegActuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtRANotDil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdiRegActuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jdiRegActuLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addComponent(jdcRAFechLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdiRegActuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtRAObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jdiRegActuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuarRA)
                    .addComponent(btnRACanc))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INSTRUMENTOS TECNICOS - AREA LEGAL");

        jLabel2.setText("LEG/2 - FICHA REGISTRO DE ACTUACIONES");

        jLabel3.setText("Nombre");

        jLabel4.setText("Cedula");

        jLabel5.setText("Fecha");

        jLabel6.setText("Codigo");

        jtTablaActuaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Notificaciones/diligencias", "Fecha limite", "Observacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtTablaActuaciones);

        jLabel7.setText("LEG/2.1 ACTUACIONES");

        jLabel8.setText("LEG/ 2.2 DESCRIPCION DEL CIERRE DEL PROCESO");

        btnAñadirActuacion.setText("Añadir");

        btnEditarActuacion.setText("Editar");

        btnEliminarActuacion.setText("Eliminar");

        jtTablaCierre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Notificaciones/diligencias", "Fecha limite", "Observacion", "Fecha cierre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTablaCierre);

        btnAñadirCierre.setText("Añadir");

        btnEditarCierre.setText("Editar");

        btnEliminarCierre.setText("Eliminar");

        btnLimp.setText("Limpiar");

        javax.swing.GroupLayout jpFondoLayout = new javax.swing.GroupLayout(jpFondo);
        jpFondo.setLayout(jpFondoLayout);
        jpFondoLayout.setHorizontalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoLayout.createSequentialGroup()
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(jpFondoLayout.createSequentialGroup()
                                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(txtCedula))
                                .addGap(154, 154, 154)
                                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCodigo)
                                    .addComponent(fechaRegistroActuaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))))
                        .addGap(92, 92, 92))
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnAñadirActuacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditarActuacion)
                .addGap(156, 156, 156)
                .addComponent(btnEliminarActuacion)
                .addGap(178, 178, 178))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoLayout.createSequentialGroup()
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnAñadirCierre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarCierre)
                        .addGap(189, 189, 189)
                        .addComponent(btnEliminarCierre)
                        .addGap(78, 78, 78)))
                .addGap(92, 92, 92))
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimp)
                .addGap(100, 100, 100))
        );
        jpFondoLayout.setVerticalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpFondoLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel5))
                            .addGroup(jpFondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaRegistroActuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadirActuacion)
                    .addComponent(btnEditarActuacion)
                    .addComponent(btnEliminarActuacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoLayout.createSequentialGroup()
                        .addComponent(btnEliminarCierre)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimp)
                        .addGap(270, 270, 270))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoLayout.createSequentialGroup()
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAñadirCierre)
                            .addComponent(btnEditarCierre))
                        .addGap(323, 323, 323))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FichaRegistroActuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaRegistroActuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaRegistroActuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaRegistroActuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaRegistroActuaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirActuacion;
    private javax.swing.JButton btnAñadirCierre;
    private javax.swing.JButton btnCCanc;
    private javax.swing.JButton btnCGuar;
    private javax.swing.JButton btnEditarActuacion;
    private javax.swing.JButton btnEditarCierre;
    private javax.swing.JButton btnEliminarActuacion;
    private javax.swing.JButton btnEliminarCierre;
    private javax.swing.JButton btnGuarRA;
    private javax.swing.JButton btnLimp;
    private javax.swing.JButton btnRACanc;
    private com.toedter.calendar.JDateChooser fechaRegistroActuaciones;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcCFechCier;
    private com.toedter.calendar.JDateChooser jdcCFechLimite;
    private com.toedter.calendar.JDateChooser jdcRAFechLimite;
    private javax.swing.JDialog jdiCierre;
    private javax.swing.JDialog jdiRegActu;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JTable jtTablaActuaciones;
    private javax.swing.JTable jtTablaCierre;
    private javax.swing.JLabel labCId;
    private javax.swing.JLabel labRAId;
    private javax.swing.JTextField txtCNotDil;
    private javax.swing.JTextField txtCObs;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRANotDil;
    private javax.swing.JTextField txtRAObs;
    // End of variables declaration//GEN-END:variables
}
