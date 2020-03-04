
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FormaAgregarHijos extends javax.swing.JFrame {

    public FormaAgregarHijos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtInstitucionEducativa = new javax.swing.JTextField();
        cbxAnioEscolar = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtParentesco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(dcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 121, 165, -1));

        jLabel1.setText("Agregar Hijos /Hijas / Personas a cargo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 13, -1, -1));

        btnGuardar.setText("GUARDAR");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 299, -1, -1));

        jLabel2.setText("Nombres: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 46, -1, -1));

        btnCancelar.setText("Cancelar");
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 299, -1, -1));

        jLabel3.setText("Apellidos: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 81, -1, -1));

        jLabel4.setText("Fecha de Nacimiento: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 114, -1, -1));

        jLabel5.setText("Institución Educativa:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 197, -1, -1));

        jLabel6.setText("Año Escolar: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 247, -1, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 44, 165, -1));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 84, 165, -1));
        jPanel1.add(txtInstitucionEducativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 195, 165, -1));

        cbxAnioEscolar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxAnioEscolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 242, 168, -1));

        jLabel7.setText("Parentesco: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 160, -1, -1));
        jPanel1.add(txtParentesco, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 158, 165, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    public JComboBox<String> getCbxAnioEscolar() {
        return cbxAnioEscolar;
    }

    public void setCbxAnioEscolar(JComboBox<String> cbxAnioEscolar) {
        this.cbxAnioEscolar = cbxAnioEscolar;
    }

    public JDateChooser getDcFechaNacimiento() {
        return dcFechaNacimiento;
    }

    public void setDcFechaNacimiento(JDateChooser dcFechaNacimiento) {
        this.dcFechaNacimiento = dcFechaNacimiento;
    }

    public JTextField getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(JTextField txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

 

    public JTextField getTxtInstitucionEducativa() {
        return txtInstitucionEducativa;
    }

    public void setTxtInstitucionEducativa(JTextField txtInstitucionEducativa) {
        this.txtInstitucionEducativa = txtInstitucionEducativa;
    }

    public JTextField getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(JTextField txtNombres) {
        this.txtNombres = txtNombres;
    }

    public JTextField getTxtParentesco() {
        return txtParentesco;
    }

    public void setTxtParentesco(JTextField txtParentesco) {
        this.txtParentesco = txtParentesco;
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
            java.util.logging.Logger.getLogger(FormaAgregarHijos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaAgregarHijos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaAgregarHijos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaAgregarHijos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormaAgregarHijos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxAnioEscolar;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtInstitucionEducativa;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtParentesco;
    // End of variables declaration//GEN-END:variables
}
