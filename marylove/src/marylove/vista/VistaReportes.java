package marylove.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** @author ubuntu */
public class VistaReportes extends javax.swing.JFrame {
    public VistaReportes() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public JButton getBtnReport() {
        return btnReport;
    }

    public void setBtnReport(JButton btnReport) {
        this.btnReport = btnReport;
    }

    public JLabel getLbanio() {
        return lbanio;
    }

    public void setLbanio(JLabel lbanio) {
        this.lbanio = lbanio;
    }

    public JLabel getLbcedula() {
        return lbcedula;
    }

    public void setLbcedula(JLabel lbcedula) {
        this.lbcedula = lbcedula;
    }

    public JLabel getLbid() {
        return lbid;
    }

    public void setLbid(JLabel lbid) {
        this.lbid = lbid;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
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
        lbanio = new javax.swing.JLabel();
        lblTipoReporte = new javax.swing.JLabel();
        btnReport = new javax.swing.JButton();
        lbcedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lbid = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
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

        lbanio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbanio.setText("Seleccione el año: ");

        lblTipoReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoReporte.setText(":v");

        btnReport.setText("Generar Reporte");

        lbcedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbcedula.setText("Ingrese la cedula de la compañera:");

        lbid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbid.setText("Ingrese el ID de la ficha Anamnesis:");

        javax.swing.GroupLayout pnlEspecificacionLayout = new javax.swing.GroupLayout(pnlEspecificacion);
        pnlEspecificacion.setLayout(pnlEspecificacionLayout);
        pnlEspecificacionLayout.setHorizontalGroup(
            pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addComponent(lbanio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbid, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxAnios, 0, 125, Short.MAX_VALUE))
                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(txtID))
                .addGap(29, 29, 29))
        );
        pnlEspecificacionLayout.setVerticalGroup(
            pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblTipoReporte))
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxAnios, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbanio))))
                .addGap(18, 18, 18)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbid)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnReport)
                .addGap(22, 22, 22))
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
                .addComponent(pnlEspecificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox<String> cbxTipoReporte;
    public javax.swing.JComboBox<String> jComboBoxAnios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbanio;
    private javax.swing.JLabel lbcedula;
    private javax.swing.JLabel lbid;
    private javax.swing.JLabel lblTipoReporte;
    private javax.swing.JPanel pnlEspecificacion;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
