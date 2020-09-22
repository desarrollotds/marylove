/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class ViewReports extends javax.swing.JFrame {

    /**
     * Creates new form ViewReports
     */
    public ViewReports() {
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

        pnlPrincipal = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbxTipoReporte = new javax.swing.JComboBox<>();
        pnlEspecificacion = new javax.swing.JPanel();
        jComboBoxAnios = new javax.swing.JComboBox<>();
        lbanio = new javax.swing.JLabel();
        lblTipoReporte = new javax.swing.JLabel();
        btnReport = new javax.swing.JButton();
        lbcedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lbFecha = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        lbfechafinal = new javax.swing.JLabel();
        datefinal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Seleccione el reporte que desea realizar hoy.");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxTipoReporte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbanio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbanio.setText("Seleccione el año: ");

        lblTipoReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoReporte.setText(":v");

        btnReport.setText("Generar Reporte");

        lbcedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbcedula.setText("Ingrese la cedula de la compañera:");

        lbFecha.setText("Fecha Inicial:");

        lbfechafinal.setText("Fecha Final:");

        javax.swing.GroupLayout pnlEspecificacionLayout = new javax.swing.GroupLayout(pnlEspecificacion);
        pnlEspecificacion.setLayout(pnlEspecificacionLayout);
        pnlEspecificacionLayout.setHorizontalGroup(
            pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                                .addComponent(lbanio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTipoReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                                .addComponent(lbcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(lbfechafinal)
                        .addGap(24, 24, 24)))
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxAnios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(datefinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        pnlEspecificacionLayout.setVerticalGroup(
            pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxAnios, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbanio)))
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTipoReporte)))
                .addGap(18, 18, 18)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEspecificacionLayout.createSequentialGroup()
                        .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcedula)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbFecha)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(datefinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lbfechafinal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26)
                .addComponent(btnReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEspecificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEspecificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JDateChooser getDatefinal() {
        return datefinal;
    }

    public void setDatefinal(JDateChooser datefinal) {
        this.datefinal = datefinal;
    }

    public JLabel getLbfechafinal() {
        return lbfechafinal;
    }

    public void setLbfechafinal(JLabel lbfechafinal) {
        this.lbfechafinal = lbfechafinal;
    }

    
    public JPanel getPnlEspecificacion() {
        return pnlEspecificacion;
    }

    public void setPnlEspecificacion(JPanel pnlEspecificacion) {
        this.pnlEspecificacion = pnlEspecificacion;
    }

    public JButton getBtnReport() {
        return btnReport;
    }

    public void setBtnReport(JButton btnReport) {
        this.btnReport = btnReport;
    }

    public JComboBox<String> getCbxTipoReporte() {
        return cbxTipoReporte;
    }

    public void setCbxTipoReporte(JComboBox<String> cbxTipoReporte) {
        this.cbxTipoReporte = cbxTipoReporte;
    }

    public JDateChooser getDate() {
        return date;
    }

    public void setDate(JDateChooser date) {
        this.date = date;
    }

    public JComboBox<String> getjComboBoxAnios() {
        return jComboBoxAnios;
    }

    public void setjComboBoxAnios(JComboBox<String> jComboBoxAnios) {
        this.jComboBoxAnios = jComboBoxAnios;
    }

    public JLabel getLbFecha() {
        return lbFecha;
    }

    public void setLbFecha(JLabel lbFecha) {
        this.lbFecha = lbFecha;
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

    public JLabel getLblTipoReporte() {
        return lblTipoReporte;
    }

    public void setLblTipoReporte(JLabel lblTipoReporte) {
        this.lblTipoReporte = lblTipoReporte;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

  
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
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox<String> cbxTipoReporte;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser datefinal;
    public javax.swing.JComboBox<String> jComboBoxAnios;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbanio;
    private javax.swing.JLabel lbcedula;
    private javax.swing.JLabel lbfechafinal;
    private javax.swing.JLabel lblTipoReporte;
    private javax.swing.JPanel pnlEspecificacion;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
