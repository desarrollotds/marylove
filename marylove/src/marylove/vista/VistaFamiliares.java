
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VistaFamiliares extends javax.swing.JFrame {

    public VistaFamiliares() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txCed = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtApell = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtcFechNac = new com.toedter.calendar.JDateChooser();
        cbxParent = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cédula:");

        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido");

        jLabel4.setText("Fecha Nacimiento");

        jLabel5.setText("Parentesco:");

        cbxParent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Hijos/ Hijas o Personas con las que ingresa");

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dtcFechNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txCed)
                            .addComponent(txtNom)
                            .addComponent(txtApell)
                            .addComponent(cbxParent, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(42, 42, 42))
                                            .addComponent(jLabel2))
                                        .addGap(42, 42, 42))
                                    .addComponent(jLabel3))
                                .addGap(60, 60, 60))
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtApell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dtcFechNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)
                        .addComponent(cbxParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed


    public JButton getBtnCancelar() {
        return btnCancelar;
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

    public JComboBox<String> getCbxParent() {
        return cbxParent;
    }

    public void setCbxParent(JComboBox<String> cbxParent) {
        this.cbxParent = cbxParent;
    }

    public JDateChooser getDtcFechNac() {
        return dtcFechNac;
    }

    public void setDtcFechNac(JDateChooser dtcFechNac) {
        this.dtcFechNac = dtcFechNac;
    }

    public JTextField getTxCed() {
        return txCed;
    }

    public void setTxCed(JTextField txCed) {
        this.txCed = txCed;
    }

    public JTextField getTxtApell() {
        return txtApell;
    }

    public void setTxtApell(JTextField txtApell) {
        this.txtApell = txtApell;
    }

    public JTextField getTxtNom() {
        return txtNom;
    }

    public void setTxtNom(JTextField txtNom) {
        this.txtNom = txtNom;
    }

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
            java.util.logging.Logger.getLogger(VistaFamiliares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaFamiliares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaFamiliares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaFamiliares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaFamiliares().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFamiliares_anadirFamiliar;
    private javax.swing.JButton btnFamiliares_anadirFamiliar1;
    private javax.swing.JButton btnFamiliares_anadirFamiliar2;
    private javax.swing.JButton btnFamiliares_anadirFamiliar3;
    private javax.swing.JButton btnFamiliares_anadirFamiliar4;
    private javax.swing.JButton btnFamiliares_anadirFamiliar5;
    private javax.swing.JButton btnFamiliares_cancelar;
    private javax.swing.JButton btnFamiliares_cancelar1;
    private javax.swing.JButton btnFamiliares_cancelar2;
    private javax.swing.JButton btnFamiliares_cancelar3;
    private javax.swing.JButton btnFamiliares_cancelar4;
    private javax.swing.JButton btnFamiliares_cancelar5;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxFamiliares_estadoCivil;
    private javax.swing.JComboBox<String> cbxFamiliares_estadoCivil1;
    private javax.swing.JComboBox<String> cbxFamiliares_estadoCivil2;
    private javax.swing.JComboBox<String> cbxFamiliares_estadoCivil3;
    private javax.swing.JComboBox<String> cbxFamiliares_estadoCivil4;
    private javax.swing.JComboBox<String> cbxFamiliares_estadoCivil5;
    private javax.swing.JComboBox<String> cbxFamiliares_instruccionAcademica;
    private javax.swing.JComboBox<String> cbxFamiliares_instruccionAcademica1;
    private javax.swing.JComboBox<String> cbxFamiliares_instruccionAcademica2;
    private javax.swing.JComboBox<String> cbxFamiliares_instruccionAcademica3;
    private javax.swing.JComboBox<String> cbxFamiliares_instruccionAcademica4;
    private javax.swing.JComboBox<String> cbxFamiliares_instruccionAcademica5;
    private javax.swing.JComboBox<String> cbxFamiliares_sexo;
    private javax.swing.JComboBox<String> cbxFamiliares_sexo1;
    private javax.swing.JComboBox<String> cbxFamiliares_sexo2;
    private javax.swing.JComboBox<String> cbxFamiliares_sexo3;
    private javax.swing.JComboBox<String> cbxFamiliares_sexo4;
    private javax.swing.JComboBox<String> cbxFamiliares_sexo5;
    private javax.swing.JComboBox<String> cbxParent;
    private com.toedter.calendar.JDateChooser dtcFechNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlAgregarFamilar;
    private javax.swing.JPanel pnlAgregarFamilar1;
    private javax.swing.JPanel pnlAgregarFamilar2;
    private javax.swing.JPanel pnlAgregarFamilar3;
    private javax.swing.JPanel pnlAgregarFamilar4;
    private javax.swing.JPanel pnlAgregarFamilar5;
    private javax.swing.JTextField txCed;
    private javax.swing.JTextField txtApell;
    private javax.swing.JTextField txtFamiliares_apellidos;
    private javax.swing.JTextField txtFamiliares_apellidos1;
    private javax.swing.JTextField txtFamiliares_apellidos2;
    private javax.swing.JTextField txtFamiliares_apellidos3;
    private javax.swing.JTextField txtFamiliares_apellidos4;
    private javax.swing.JTextField txtFamiliares_apellidos5;
    private javax.swing.JTextField txtFamiliares_edad;
    private javax.swing.JTextField txtFamiliares_edad1;
    private javax.swing.JTextField txtFamiliares_edad2;
    private javax.swing.JTextField txtFamiliares_edad3;
    private javax.swing.JTextField txtFamiliares_edad4;
    private javax.swing.JTextField txtFamiliares_edad5;
    private javax.swing.JTextField txtFamiliares_nombres;
    private javax.swing.JTextField txtFamiliares_nombres1;
    private javax.swing.JTextField txtFamiliares_nombres2;
    private javax.swing.JTextField txtFamiliares_nombres3;
    private javax.swing.JTextField txtFamiliares_nombres4;
    private javax.swing.JTextField txtFamiliares_nombres5;
    private javax.swing.JTextField txtFamiliares_ocupacion;
    private javax.swing.JTextField txtFamiliares_ocupacion1;
    private javax.swing.JTextField txtFamiliares_ocupacion2;
    private javax.swing.JTextField txtFamiliares_ocupacion3;
    private javax.swing.JTextField txtFamiliares_ocupacion4;
    private javax.swing.JTextField txtFamiliares_ocupacion5;
    private javax.swing.JTextField txtFamiliares_parentesco;
    private javax.swing.JTextField txtFamiliares_parentesco1;
    private javax.swing.JTextField txtFamiliares_parentesco2;
    private javax.swing.JTextField txtFamiliares_parentesco3;
    private javax.swing.JTextField txtFamiliares_parentesco4;
    private javax.swing.JTextField txtFamiliares_parentesco5;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
