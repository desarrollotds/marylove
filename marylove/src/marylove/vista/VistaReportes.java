/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author ubuntu
 */
public class VistaReportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    public VistaReportes() {
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
        jBn_Anual = new javax.swing.JButton();
        btn_General = new javax.swing.JButton();
        btnSocial = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlEspecificacion = new javax.swing.JPanel();
        jComboBoxAnios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButtReportAnio = new javax.swing.JButton();
        btnHijos = new javax.swing.JButton();
        btnCompaniera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBn_Anual.setText("Anual");

        btn_General.setText("General");

        btnSocial.setText("Trabajo Social");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jBn_Anual)
                .addGap(61, 61, 61)
                .addComponent(btn_General)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSocial)
                .addGap(30, 30, 30))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_General)
                    .addComponent(jBn_Anual)
                    .addComponent(btnSocial))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Reportes");

        jLabel2.setText("Seleccione el año: ");

        jButtReportAnio.setText("Generar");

        btnHijos.setText("Hijos");

        btnCompaniera.setText("Compañera");

        javax.swing.GroupLayout pnlEspecificacionLayout = new javax.swing.GroupLayout(pnlEspecificacion);
        pnlEspecificacion.setLayout(pnlEspecificacionLayout);
        pnlEspecificacionLayout.setHorizontalGroup(
            pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEspecificacionLayout.createSequentialGroup()
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAnios, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnCompaniera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHijos)))
                .addGap(108, 108, 108))
            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jButtReportAnio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEspecificacionLayout.setVerticalGroup(
            pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecificacionLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHijos)
                    .addComponent(btnCompaniera))
                .addGap(18, 18, 18)
                .addGroup(pnlEspecificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAnios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButtReportAnio)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlEspecificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlEspecificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(VistaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaReportes().setVisible(true);
            }
        });
    }

    public JButton getBtnCompaniera() {
        return btnCompaniera;
    }

    public void setBtnCompaniera(JButton btnCompaniera) {
        this.btnCompaniera = btnCompaniera;
    }

    public JButton getBtnHijos() {
        return btnHijos;
    }

    public void setBtnHijos(JButton btnHijos) {
        this.btnHijos = btnHijos;
    }

    public JButton getjBn_Anual() {
        return jBn_Anual;
    }

    public void setjBn_Anual(JButton jBn_Anual) {
        this.jBn_Anual = jBn_Anual;
    }

    public JButton getBtn_General() {
        return btn_General;
    }

    public void setBtn_General(JButton btn_General) {
        this.btn_General = btn_General;
    }
   

    public JPanel getPnlEspecificacion() {
        return pnlEspecificacion;
    }

    public void setPnlEspecificacion(JPanel pnlEspecificacion) {
        this.pnlEspecificacion = pnlEspecificacion;
    }

    public JPanel getPnlPrincipal() {
        return pnlPrincipal;
    }

    public void setPnlPrincipal(JPanel pnlPrincipal) {
        this.pnlPrincipal = pnlPrincipal;
    }

    public JButton getBtnSocial() {
        return btnSocial;
    }

    public void setBtnSocial(JButton btnSocial) {
        this.btnSocial = btnSocial;
    }


    public JComboBox<String> getjComboBoxAnios() {
        return jComboBoxAnios;
    }

    public void setjComboBoxAnios(JComboBox<String> jComboBoxAnios) {
        this.jComboBoxAnios = jComboBoxAnios;
    }

    public JButton getjButtReportAnio() {
        return jButtReportAnio;
    }

    public void setjButtReportAnio(JButton jButtReportAnio) {
        this.jButtReportAnio = jButtReportAnio;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompaniera;
    private javax.swing.JButton btnHijos;
    private javax.swing.JButton btnSocial;
    private javax.swing.JButton btn_General;
    private javax.swing.JButton jBn_Anual;
    private javax.swing.JButton jButtReportAnio;
    public javax.swing.JComboBox<String> jComboBoxAnios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlEspecificacion;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
