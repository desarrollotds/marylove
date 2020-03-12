package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class IngresoAvancesProcesoTerapeutico extends javax.swing.JFrame {

    /**
     * Creates new form IngresoAvances
     */
    
    public IngresoAvancesProcesoTerapeutico() {
        initComponents();
    }

    public JPanel getPnlIngresoAvanceProceTera() {
        return pnlIngresoAvanceProceTera;
    }

    public void setPnlIngresoAvanceProceTera(JPanel pnlIngresoAvanceProceTera) {
        this.pnlIngresoAvanceProceTera = pnlIngresoAvanceProceTera;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIngresoAvanceProceTera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaSituacion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaIntervencion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCodigoAvance = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlIngresoAvanceProceTera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Fecha:");

        jLabel2.setText("Situación:");

        txaSituacion.setColumns(20);
        txaSituacion.setRows(5);
        jScrollPane1.setViewportView(txaSituacion);

        jLabel3.setText("Tipo de intervención:");

        txaIntervencion.setColumns(20);
        txaIntervencion.setRows(5);
        jScrollPane2.setViewportView(txaIntervencion);

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        txtCodigoAvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoAvanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlIngresoAvanceProceTeraLayout = new javax.swing.GroupLayout(pnlIngresoAvanceProceTera);
        pnlIngresoAvanceProceTera.setLayout(pnlIngresoAvanceProceTeraLayout);
        pnlIngresoAvanceProceTeraLayout.setHorizontalGroup(
            pnlIngresoAvanceProceTeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoAvanceProceTeraLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlIngresoAvanceProceTeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addGroup(pnlIngresoAvanceProceTeraLayout.createSequentialGroup()
                        .addGroup(pnlIngresoAvanceProceTeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIngresoAvanceProceTeraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(30, 30, 30)
                .addComponent(btnGuardar)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIngresoAvanceProceTeraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtCodigoAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlIngresoAvanceProceTeraLayout.setVerticalGroup(
            pnlIngresoAvanceProceTeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoAvanceProceTeraLayout.createSequentialGroup()
                .addComponent(txtCodigoAvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnlIngresoAvanceProceTeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(pnlIngresoAvanceProceTeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlIngresoAvanceProceTera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pnlIngresoAvanceProceTera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoAvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoAvanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoAvanceActionPerformed

    public JTextField getTxtCodigoAvance() {
        return txtCodigoAvance;
    }

    public void setTxtCodigoAvance(JTextField txtCodigoAvance) {
        this.txtCodigoAvance = txtCodigoAvance;
    }

   

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JDateChooser getDcFecha() {
        return dcFecha;
    }

    public void setDcFecha(JDateChooser dcFecha) {
        this.dcFecha = dcFecha;
    }

    public JTextArea getTxaIntervencion() {
        return txaIntervencion;
    }

    public void setTxaIntervencion(JTextArea txaIntervencion) {
        this.txaIntervencion = txaIntervencion;
    }

    public JTextArea getTxaSituacion() {
        return txaSituacion;
    }

    public void setTxaSituacion(JTextArea txaSituacion) {
        this.txaSituacion = txaSituacion;
    }

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlIngresoAvanceProceTera;
    private javax.swing.JTextArea txaIntervencion;
    private javax.swing.JTextArea txaSituacion;
    private javax.swing.JTextField txtCodigoAvance;
    // End of variables declaration//GEN-END:variables
}
