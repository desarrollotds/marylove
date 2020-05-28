package marylove.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @author ubuntu */
public class VistaReportes extends javax.swing.JFrame {
    public VistaReportes() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public JButton getBtnGenerar() {
        return btnGenerar;
    }
    public void setBtnGenerar(JButton btnGenerar) {
        this.btnGenerar = btnGenerar;
    }

    public JComboBox<String> getCbxTipoReporte() {
        return cbxTipoReporte;
    }
    public void setCbxTipoReporte(JComboBox<String> cbxTipoReporte) {
        this.cbxTipoReporte = cbxTipoReporte;
    }

    public JLabel getLblTipoReporte() {
        return lblTipoReporte;
    }
    public void setLblTipoReporte(JLabel lblTipoReporte) {
        this.lblTipoReporte = lblTipoReporte;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        cbxTipoReporte = new javax.swing.JComboBox<>();
        pnlEspecificacion = new javax.swing.JPanel();
        jComboBoxAnios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        lblTipoReporte = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        cbxTipoGeneral = new javax.swing.JComboBox<>();
        txtRuta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");
        setResizable(false);

        cbxTipoReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el reporte...", "Reporte Anual", "Reporte General", "Reporte de Trabajo Social" }));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxTipoReporte, 0, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Seleccione el año: ");

        btnBuscar.setText("Buscar");

        jLabel3.setText("Seleccione la ubicación para guardar reporte:");

        btnGenerar.setText("GENERAR");
        btnGenerar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 204, 51), null, null));

        lblTipoReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoReporte.setText(":v");

        lbtipo.setText("Seleccione el tipo de Reporte:");

        cbxTipoGeneral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "General", "Compañera", "NNA" }));

        txtRuta.setText("Ruta de almacenamiento");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout pnlEspecificacionLayout = new javax.swing.GroupLayout(pnlEspecificacion);
        pnlEspecificacion.setLayout(pnlEspecificacionLayout);
        pnlEspecificacionLayout.setHorizontalGroup(
            pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEspecificacionLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAnios, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbtipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlEspecificacionLayout.setVerticalGroup(
            pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTipoReporte)
                .addGap(18, 18, 18)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxAnios, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtipo)
                    .addComponent(cbxTipoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuta)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("?");
        jLabel1.setToolTipText("Ayuda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEspecificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEspecificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public JComboBox<String> getCbxTipoGeneral() {
        return cbxTipoGeneral;
    }

    public void setCbxTipoGeneral(JComboBox<String> cbxTipoGeneral) {
        this.cbxTipoGeneral = cbxTipoGeneral;
    }

    public JLabel getLbtipo() {
        return lbtipo;
    }

    public void setLbtipo(JLabel lbtipo) {
        this.lbtipo = lbtipo;
    }

   

    public JPanel getPnlEspecificacion() {
        return pnlEspecificacion;
    }
    public void setPnlEspecificacion(JPanel pnlEspecificacion) {
        this.pnlEspecificacion = pnlEspecificacion;
    }

    public JComboBox<String> getjComboBoxAnios() {
        return jComboBoxAnios;
    }
    public void setjComboBoxAnios(JComboBox<String> jComboBoxAnios) {
        this.jComboBoxAnios = jComboBoxAnios;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }
    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JLabel getTxtRuta() {
        return txtRuta;
    }

    public void setTxtRuta(JLabel txtRuta) {
        this.txtRuta = txtRuta;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> cbxTipoGeneral;
    private javax.swing.JComboBox<String> cbxTipoReporte;
    public javax.swing.JComboBox<String> jComboBoxAnios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblTipoReporte;
    private javax.swing.JLabel lbtipo;
    private javax.swing.JPanel pnlEspecificacion;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JLabel txtRuta;
    // End of variables declaration//GEN-END:variables
}
