/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Acer
 */
public class VistaPlanEmergente extends javax.swing.JFrame {

    /**
     * Creates new form VistaPlanEmergente
     */
    public VistaPlanEmergente() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombrePlanEmergente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoPlanEmergente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bntGuardarPlanEmergente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAIPsicologia = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtACCIPsicologia = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAITrabajoSocial = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtACCITrabajoSocial = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtACCIInfantoJuvenil = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtACCILegal = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtAILegal = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtAIInfantoJuvenil = new javax.swing.JTextArea();
        jDateFechaPlanEmergente = new com.toedter.calendar.JDateChooser();
        jDatePsicologia = new com.toedter.calendar.JDateChooser();
        jDateTrabajoSocial = new com.toedter.calendar.JDateChooser();
        jDateLegal = new com.toedter.calendar.JDateChooser();
        jDateInfantoJuvenil = new com.toedter.calendar.JDateChooser();
        bntCancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoPersonal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        bntLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("PLAN EMERGENTE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));
        getContentPane().add(txtNombrePlanEmergente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 100, -1));

        jLabel3.setText("Codigo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 84, -1, -1));

        txtCodigoPlanEmergente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPlanEmergenteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigoPlanEmergente, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 81, 100, -1));

        jLabel4.setText("Fecha de Elaboracion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("MODALIDAD");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel6.setText("APRECIACION INICIAL");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        jLabel7.setText("ACCIONES INMEDIATAS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 157, -1, -1));

        jLabel8.setText("FECHA");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 155, -1, -1));

        jLabel9.setText("PSICOLOGIA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel10.setText("TRABAJO SOCIAL");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jLabel11.setText("LEGAL");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        jLabel12.setText("INFANTO JUVENIL");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        bntGuardarPlanEmergente.setText("Guardar");
        getContentPane().add(bntGuardarPlanEmergente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 620, -1, -1));

        txtAIPsicologia.setColumns(20);
        txtAIPsicologia.setLineWrap(true);
        txtAIPsicologia.setRows(5);
        txtAIPsicologia.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAIPsicologia);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 230, -1));

        txtACCIPsicologia.setColumns(20);
        txtACCIPsicologia.setLineWrap(true);
        txtACCIPsicologia.setRows(5);
        txtACCIPsicologia.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtACCIPsicologia);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 189, 230, -1));

        txtAITrabajoSocial.setColumns(20);
        txtAITrabajoSocial.setLineWrap(true);
        txtAITrabajoSocial.setRows(5);
        txtAITrabajoSocial.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtAITrabajoSocial);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 295, 230, -1));

        txtACCITrabajoSocial.setColumns(20);
        txtACCITrabajoSocial.setLineWrap(true);
        txtACCITrabajoSocial.setRows(5);
        txtACCITrabajoSocial.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtACCITrabajoSocial);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 295, 230, -1));

        txtACCIInfantoJuvenil.setColumns(20);
        txtACCIInfantoJuvenil.setLineWrap(true);
        txtACCIInfantoJuvenil.setRows(5);
        txtACCIInfantoJuvenil.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txtACCIInfantoJuvenil);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 230, -1));

        txtACCILegal.setColumns(20);
        txtACCILegal.setLineWrap(true);
        txtACCILegal.setRows(5);
        txtACCILegal.setWrapStyleWord(true);
        jScrollPane6.setViewportView(txtACCILegal);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 397, 230, -1));

        txtAILegal.setColumns(20);
        txtAILegal.setLineWrap(true);
        txtAILegal.setRows(5);
        txtAILegal.setWrapStyleWord(true);
        jScrollPane7.setViewportView(txtAILegal);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 397, 230, -1));

        txtAIInfantoJuvenil.setColumns(20);
        txtAIInfantoJuvenil.setLineWrap(true);
        txtAIInfantoJuvenil.setRows(5);
        txtAIInfantoJuvenil.setWrapStyleWord(true);
        jScrollPane8.setViewportView(txtAIInfantoJuvenil);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 230, -1));
        getContentPane().add(jDateFechaPlanEmergente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 110, -1));
        getContentPane().add(jDatePsicologia, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 190, 110, -1));
        getContentPane().add(jDateTrabajoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 110, -1));
        getContentPane().add(jDateLegal, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 400, 110, -1));
        getContentPane().add(jDateInfantoJuvenil, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 500, 110, -1));

        bntCancelar.setText("Cancelar");
        getContentPane().add(bntCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, -1, -1));

        jLabel13.setText("Codigo Personal:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        txtCodigoPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPersonalActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 100, -1));

        jLabel14.setText("Cedula:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 100, -1));

        bntLimpiar.setText("Limpiar");
        getContentPane().add(bntLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 620, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoPlanEmergenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPlanEmergenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPlanEmergenteActionPerformed

    private void txtCodigoPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPersonalActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPlanEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPlanEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPlanEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPlanEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPlanEmergente().setVisible(true);
            }
        });
    }
//iojiji
//    public JButton getBntEditar() {
//        return bntEditar;
//    }
//
//    public void setBntEditar(JButton bntEditar) {
//        this.bntEditar = bntEditar;
//    }

    public JButton getBntLimpiar() {
        return bntLimpiar;
    }

    public void setBntLimpiar(JButton bntLimpiar) {
        this.bntLimpiar = bntLimpiar;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JTextField getTxtCodigoPersonal() {
        return txtCodigoPersonal;
    }

    public void setTxtCodigoPersonal(JTextField txtCodigoPersonal) {
        this.txtCodigoPersonal = txtCodigoPersonal;
    }

    public JButton getBntGuardarPlanEmergente() {
        return bntGuardarPlanEmergente;
    }

    public void setBntGuardarPlanEmergente(JButton bntGuardarPlanEmergente) {
        this.bntGuardarPlanEmergente = bntGuardarPlanEmergente;
    }

//    public JDateChooser getDatFechaPlanEmergente() {
//        return datFechaPlanEmergente;
//    }
//
//    public void setDatFechaPlanEmergente(JDateChooser datFechaPlanEmergente) {
//        this.datFechaPlanEmergente = datFechaPlanEmergente;
//    }

    public JButton getBntCancelar() {
        return bntCancelar;
    }

    public void setBntCancelar(JButton bntCancelar) {
        this.bntCancelar = bntCancelar;
    }

    public JDateChooser getjDateFechaPlanEmergente() {
        return jDateFechaPlanEmergente;
    }

    public void setjDateFechaPlanEmergente(JDateChooser jDateFechaPlanEmergente) {
        this.jDateFechaPlanEmergente = jDateFechaPlanEmergente;
    }

    public JDateChooser getjDateInfantoJuvenil() {
        return jDateInfantoJuvenil;
    }

    public void setjDateInfantoJuvenil(JDateChooser jDateInfantoJuvenil) {
        this.jDateInfantoJuvenil = jDateInfantoJuvenil;
    }

    public JDateChooser getjDateLegal() {
        return jDateLegal;
    }

    public void setjDateLegal(JDateChooser jDateLegal) {
        this.jDateLegal = jDateLegal;
    }

    public JDateChooser getjDatePsicologia() {
        return jDatePsicologia;
    }

    public void setjDatePsicologia(JDateChooser jDatePsicologia) {
        this.jDatePsicologia = jDatePsicologia;
    }

    public JDateChooser getjDateTrabajoSocial() {
        return jDateTrabajoSocial;
    }

    public void setjDateTrabajoSocial(JDateChooser jDateTrabajoSocial) {
        this.jDateTrabajoSocial = jDateTrabajoSocial;
    }

  

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public void setjScrollPane5(JScrollPane jScrollPane5) {
        this.jScrollPane5 = jScrollPane5;
    }

    public JScrollPane getjScrollPane6() {
        return jScrollPane6;
    }

    public void setjScrollPane6(JScrollPane jScrollPane6) {
        this.jScrollPane6 = jScrollPane6;
    }

    public JScrollPane getjScrollPane7() {
        return jScrollPane7;
    }

    public void setjScrollPane7(JScrollPane jScrollPane7) {
        this.jScrollPane7 = jScrollPane7;
    }

    public JScrollPane getjScrollPane8() {
        return jScrollPane8;
    }

    public void setjScrollPane8(JScrollPane jScrollPane8) {
        this.jScrollPane8 = jScrollPane8;
    }

    public JTextArea getTxtACCIInfantoJuvenil() {
        return txtACCIInfantoJuvenil;
    }

    public void setTxtACCIInfantoJuvenil(JTextArea txtACCIInfantoJuvenil) {
        this.txtACCIInfantoJuvenil = txtACCIInfantoJuvenil;
    }

    public JTextArea getTxtACCILegal() {
        return txtACCILegal;
    }

    public void setTxtACCILegal(JTextArea txtACCILegal) {
        this.txtACCILegal = txtACCILegal;
    }

    public JTextArea getTxtACCIPsicologia() {
        return txtACCIPsicologia;
    }

    public void setTxtACCIPsicologia(JTextArea txtACCIPsicologia) {
        this.txtACCIPsicologia = txtACCIPsicologia;
    }

    public JTextArea getTxtACCITrabajoSocial() {
        return txtACCITrabajoSocial;
    }

    public void setTxtACCITrabajoSocial(JTextArea txtACCITrabajoSocial) {
        this.txtACCITrabajoSocial = txtACCITrabajoSocial;
    }

    public JTextArea getTxtAIInfantoJuvenil() {
        return txtAIInfantoJuvenil;
    }

    public void setTxtAIInfantoJuvenil(JTextArea txtAIInfantoJuvenil) {
        this.txtAIInfantoJuvenil = txtAIInfantoJuvenil;
    }

    public JTextArea getTxtAILegal() {
        return txtAILegal;
    }

    public void setTxtAILegal(JTextArea txtAILegal) {
        this.txtAILegal = txtAILegal;
    }

    public JTextArea getTxtAIPsicologia() {
        return txtAIPsicologia;
    }

    public void setTxtAIPsicologia(JTextArea txtAIPsicologia) {
        this.txtAIPsicologia = txtAIPsicologia;
    }

    public JTextArea getTxtAITrabajoSocial() {
        return txtAITrabajoSocial;
    }

    public void setTxtAITrabajoSocial(JTextArea txtAITrabajoSocial) {
        this.txtAITrabajoSocial = txtAITrabajoSocial;
    }

    public JTextField getTxtCodigoPlanEmergente() {
        return txtCodigoPlanEmergente;
    }

    public void setTxtCodigoPlanEmergente(JTextField txtCodigoPlanEmergente) {
        this.txtCodigoPlanEmergente = txtCodigoPlanEmergente;
    }

    public JTextField getTxtNombrePlanEmergente() {
        return txtNombrePlanEmergente;
    } 

    public void setTxtNombrePlanEmergente(JTextField txtNombrePlanEmergente) {
        this.txtNombrePlanEmergente = txtNombrePlanEmergente;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntGuardarPlanEmergente;
    private javax.swing.JButton bntLimpiar;
    private com.toedter.calendar.JDateChooser jDateFechaPlanEmergente;
    private com.toedter.calendar.JDateChooser jDateInfantoJuvenil;
    private com.toedter.calendar.JDateChooser jDateLegal;
    private com.toedter.calendar.JDateChooser jDatePsicologia;
    private com.toedter.calendar.JDateChooser jDateTrabajoSocial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea txtACCIInfantoJuvenil;
    private javax.swing.JTextArea txtACCILegal;
    private javax.swing.JTextArea txtACCIPsicologia;
    private javax.swing.JTextArea txtACCITrabajoSocial;
    private javax.swing.JTextArea txtAIInfantoJuvenil;
    private javax.swing.JTextArea txtAILegal;
    private javax.swing.JTextArea txtAIPsicologia;
    private javax.swing.JTextArea txtAITrabajoSocial;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigoPersonal;
    private javax.swing.JTextField txtCodigoPlanEmergente;
    private javax.swing.JTextField txtNombrePlanEmergente;
    // End of variables declaration//GEN-END:variables
}
