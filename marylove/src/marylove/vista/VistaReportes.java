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
        jLabel4 = new javax.swing.JLabel();
        pnlEspecificacion = new javax.swing.JPanel();
        jComboBoxAnios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTipoReporte = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        cbxTipoGeneral = new javax.swing.JComboBox<>();
        txtRuta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        cbxTipoReporte = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Seleccione el reporte que desea realizar hoy.");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Seleccione el año: ");

        btnBuscar.setText("Buscar");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Seleccione la carpeta donde desea guardar el reporte:");

        lblTipoReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoReporte.setText(":v");

        lbtipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbtipo.setText("Seleccione el tipo de Reporte:");

        cbxTipoGeneral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "General", "Compañera", "NNA" }));

        txtRuta.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txtRuta.setText("Ruta de almacenamiento");

        javax.swing.GroupLayout pnlEspecificacionLayout = new javax.swing.GroupLayout(pnlEspecificacion);
        pnlEspecificacion.setLayout(pnlEspecificacionLayout);
        pnlEspecificacionLayout.setHorizontalGroup(
            pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxAnios, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                                .addComponent(lbtipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxTipoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEspecificacionLayout.createSequentialGroup()
                                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlEspecificacionLayout.setVerticalGroup(
            pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTipoReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxAnios, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbtipo)
                    .addComponent(cbxTipoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(txtRuta)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("?");
        jLabel1.setToolTipText("Ayuda");

        btnGenerar.setText("Guardar Reporte.");
        btnGenerar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 204, 51), null, null));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        cbxTipoReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el reporte...", "Reporte Anual", "Reporte General", "Reporte de Trabajo Social" }));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxTipoReporte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(13, 13, 13)
                .addComponent(cbxTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEspecificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarActionPerformed

    
    
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
