package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/** @author Angel Lucero */
public class VistaRegistroLlamadas extends javax.swing.JFrame {
    public VistaRegistroLlamadas() {
        initComponents();
        iniciarVentana();
    }
    
    public void iniciarVentana(){
        scrPrincipal.setSize(800, 600);
        //pnlPrincipal.setSize(800, 600);
        this.setSize(800, 600);
    }

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

    public JComboBox<String> getCbxEstadoCivilBeneficiaria() {
        return cbxEstadoCivilBeneficiaria;
    }

    public void setCbxEstadoCivilBeneficiaria(JComboBox<String> cbxEstadoCivilBeneficiaria) {
        this.cbxEstadoCivilBeneficiaria = cbxEstadoCivilBeneficiaria;
    }

    public JComboBox<String> getCbxHoraLlamada() {
        return cbxHoraLlamada;
    }

    public void setCbxHoraLlamada(JComboBox<String> cbxHoraLlamada) {
        this.cbxHoraLlamada = cbxHoraLlamada;
    }

    public JComboBox<String> getCbxPrioridad() {
        return cbxPrioridad;
    }

    public void setCbxPrioridad(JComboBox<String> cbxPrioridad) {
        this.cbxPrioridad = cbxPrioridad;
    }

    public JDateChooser getDatFechaLlamada() {
        return datFechaLlamada;
    }

    public void setDatFechaLlamada(JDateChooser datFechaLlamada) {
        this.datFechaLlamada = datFechaLlamada;
    }

    public JCheckBox getjCheckBox1() {
        return jCheckBox1;
    }

    public void setjCheckBox1(JCheckBox jCheckBox1) {
        this.jCheckBox1 = jCheckBox1;
    }

    public JCheckBox getjCheckBox10() {
        return jCheckBox10;
    }

    public void setjCheckBox10(JCheckBox jCheckBox10) {
        this.jCheckBox10 = jCheckBox10;
    }

    public JCheckBox getjCheckBox11() {
        return jCheckBox11;
    }

    public void setjCheckBox11(JCheckBox jCheckBox11) {
        this.jCheckBox11 = jCheckBox11;
    }

    public JCheckBox getjCheckBox12() {
        return jCheckBox12;
    }

    public void setjCheckBox12(JCheckBox jCheckBox12) {
        this.jCheckBox12 = jCheckBox12;
    }

    public JCheckBox getjCheckBox13() {
        return jCheckBox13;
    }

    public void setjCheckBox13(JCheckBox jCheckBox13) {
        this.jCheckBox13 = jCheckBox13;
    }

    public JCheckBox getjCheckBox14() {
        return jCheckBox14;
    }

    public void setjCheckBox14(JCheckBox jCheckBox14) {
        this.jCheckBox14 = jCheckBox14;
    }

    public JCheckBox getjCheckBox15() {
        return jCheckBox15;
    }

    public void setjCheckBox15(JCheckBox jCheckBox15) {
        this.jCheckBox15 = jCheckBox15;
    }

    public JCheckBox getjCheckBox16() {
        return jCheckBox16;
    }

    public void setjCheckBox16(JCheckBox jCheckBox16) {
        this.jCheckBox16 = jCheckBox16;
    }

    public JCheckBox getjCheckBox17() {
        return jCheckBox17;
    }

    public void setjCheckBox17(JCheckBox jCheckBox17) {
        this.jCheckBox17 = jCheckBox17;
    }

    public JCheckBox getjCheckBox18() {
        return jCheckBox18;
    }

    public void setjCheckBox18(JCheckBox jCheckBox18) {
        this.jCheckBox18 = jCheckBox18;
    }

    public JCheckBox getjCheckBox19() {
        return jCheckBox19;
    }

    public void setjCheckBox19(JCheckBox jCheckBox19) {
        this.jCheckBox19 = jCheckBox19;
    }

    public JCheckBox getjCheckBox2() {
        return jCheckBox2;
    }

    public void setjCheckBox2(JCheckBox jCheckBox2) {
        this.jCheckBox2 = jCheckBox2;
    }

    public JCheckBox getjCheckBox20() {
        return jCheckBox20;
    }

    public void setjCheckBox20(JCheckBox jCheckBox20) {
        this.jCheckBox20 = jCheckBox20;
    }

    public JCheckBox getjCheckBox21() {
        return jCheckBox21;
    }

    public void setjCheckBox21(JCheckBox jCheckBox21) {
        this.jCheckBox21 = jCheckBox21;
    }

    public JCheckBox getjCheckBox22() {
        return jCheckBox22;
    }

    public void setjCheckBox22(JCheckBox jCheckBox22) {
        this.jCheckBox22 = jCheckBox22;
    }

    public JCheckBox getjCheckBox23() {
        return jCheckBox23;
    }

    public void setjCheckBox23(JCheckBox jCheckBox23) {
        this.jCheckBox23 = jCheckBox23;
    }

    public JCheckBox getjCheckBox24() {
        return jCheckBox24;
    }

    public void setjCheckBox24(JCheckBox jCheckBox24) {
        this.jCheckBox24 = jCheckBox24;
    }

    public JCheckBox getjCheckBox25() {
        return jCheckBox25;
    }

    public void setjCheckBox25(JCheckBox jCheckBox25) {
        this.jCheckBox25 = jCheckBox25;
    }

    public JCheckBox getjCheckBox26() {
        return jCheckBox26;
    }

    public void setjCheckBox26(JCheckBox jCheckBox26) {
        this.jCheckBox26 = jCheckBox26;
    }

    public JCheckBox getjCheckBox27() {
        return jCheckBox27;
    }

    public void setjCheckBox27(JCheckBox jCheckBox27) {
        this.jCheckBox27 = jCheckBox27;
    }

    public JCheckBox getjCheckBox28() {
        return jCheckBox28;
    }

    public void setjCheckBox28(JCheckBox jCheckBox28) {
        this.jCheckBox28 = jCheckBox28;
    }

    public JCheckBox getjCheckBox29() {
        return jCheckBox29;
    }

    public void setjCheckBox29(JCheckBox jCheckBox29) {
        this.jCheckBox29 = jCheckBox29;
    }

    public JCheckBox getjCheckBox3() {
        return jCheckBox3;
    }

    public void setjCheckBox3(JCheckBox jCheckBox3) {
        this.jCheckBox3 = jCheckBox3;
    }

    public JCheckBox getjCheckBox30() {
        return jCheckBox30;
    }

    public void setjCheckBox30(JCheckBox jCheckBox30) {
        this.jCheckBox30 = jCheckBox30;
    }

    public JCheckBox getjCheckBox31() {
        return jCheckBox31;
    }

    public void setjCheckBox31(JCheckBox jCheckBox31) {
        this.jCheckBox31 = jCheckBox31;
    }

    public JCheckBox getjCheckBox32() {
        return jCheckBox32;
    }

    public void setjCheckBox32(JCheckBox jCheckBox32) {
        this.jCheckBox32 = jCheckBox32;
    }

    public JCheckBox getjCheckBox33() {
        return jCheckBox33;
    }

    public void setjCheckBox33(JCheckBox jCheckBox33) {
        this.jCheckBox33 = jCheckBox33;
    }

    public JCheckBox getjCheckBox34() {
        return jCheckBox34;
    }

    public void setjCheckBox34(JCheckBox jCheckBox34) {
        this.jCheckBox34 = jCheckBox34;
    }

    public JCheckBox getjCheckBox35() {
        return jCheckBox35;
    }

    public void setjCheckBox35(JCheckBox jCheckBox35) {
        this.jCheckBox35 = jCheckBox35;
    }

    public JCheckBox getjCheckBox36() {
        return jCheckBox36;
    }

    public void setjCheckBox36(JCheckBox jCheckBox36) {
        this.jCheckBox36 = jCheckBox36;
    }

    public JCheckBox getjCheckBox37() {
        return jCheckBox37;
    }

    public void setjCheckBox37(JCheckBox jCheckBox37) {
        this.jCheckBox37 = jCheckBox37;
    }

    public JCheckBox getjCheckBox38() {
        return jCheckBox38;
    }

    public void setjCheckBox38(JCheckBox jCheckBox38) {
        this.jCheckBox38 = jCheckBox38;
    }

    public JCheckBox getjCheckBox39() {
        return jCheckBox39;
    }

    public void setjCheckBox39(JCheckBox jCheckBox39) {
        this.jCheckBox39 = jCheckBox39;
    }

    public JCheckBox getjCheckBox4() {
        return jCheckBox4;
    }

    public void setjCheckBox4(JCheckBox jCheckBox4) {
        this.jCheckBox4 = jCheckBox4;
    }

    public JCheckBox getjCheckBox40() {
        return jCheckBox40;
    }

    public void setjCheckBox40(JCheckBox jCheckBox40) {
        this.jCheckBox40 = jCheckBox40;
    }

    public JCheckBox getjCheckBox41() {
        return jCheckBox41;
    }

    public void setjCheckBox41(JCheckBox jCheckBox41) {
        this.jCheckBox41 = jCheckBox41;
    }

    public JCheckBox getjCheckBox42() {
        return jCheckBox42;
    }

    public void setjCheckBox42(JCheckBox jCheckBox42) {
        this.jCheckBox42 = jCheckBox42;
    }

    public JCheckBox getjCheckBox43() {
        return jCheckBox43;
    }

    public void setjCheckBox43(JCheckBox jCheckBox43) {
        this.jCheckBox43 = jCheckBox43;
    }

    public JCheckBox getjCheckBox44() {
        return jCheckBox44;
    }

    public void setjCheckBox44(JCheckBox jCheckBox44) {
        this.jCheckBox44 = jCheckBox44;
    }

    public JCheckBox getjCheckBox45() {
        return jCheckBox45;
    }

    public void setjCheckBox45(JCheckBox jCheckBox45) {
        this.jCheckBox45 = jCheckBox45;
    }

    public JCheckBox getjCheckBox46() {
        return jCheckBox46;
    }

    public void setjCheckBox46(JCheckBox jCheckBox46) {
        this.jCheckBox46 = jCheckBox46;
    }

    public JCheckBox getjCheckBox47() {
        return jCheckBox47;
    }

    public void setjCheckBox47(JCheckBox jCheckBox47) {
        this.jCheckBox47 = jCheckBox47;
    }

    public JCheckBox getjCheckBox48() {
        return jCheckBox48;
    }

    public void setjCheckBox48(JCheckBox jCheckBox48) {
        this.jCheckBox48 = jCheckBox48;
    }

    public JCheckBox getjCheckBox5() {
        return jCheckBox5;
    }

    public void setjCheckBox5(JCheckBox jCheckBox5) {
        this.jCheckBox5 = jCheckBox5;
    }

    public JCheckBox getjCheckBox6() {
        return jCheckBox6;
    }

    public void setjCheckBox6(JCheckBox jCheckBox6) {
        this.jCheckBox6 = jCheckBox6;
    }

    public JCheckBox getjCheckBox7() {
        return jCheckBox7;
    }

    public void setjCheckBox7(JCheckBox jCheckBox7) {
        this.jCheckBox7 = jCheckBox7;
    }

    public JCheckBox getjCheckBox8() {
        return jCheckBox8;
    }

    public void setjCheckBox8(JCheckBox jCheckBox8) {
        this.jCheckBox8 = jCheckBox8;
    }

    public JCheckBox getjCheckBox9() {
        return jCheckBox9;
    }

    public void setjCheckBox9(JCheckBox jCheckBox9) {
        this.jCheckBox9 = jCheckBox9;
    }

    public JComboBox<String> getjComboBox4() {
        return jComboBox4;
    }

    public void setjComboBox4(JComboBox<String> jComboBox4) {
        this.jComboBox4 = jComboBox4;
    }

    public JComboBox<String> getjComboBox5() {
        return jComboBox5;
    }

    public void setjComboBox5(JComboBox<String> jComboBox5) {
        this.jComboBox5 = jComboBox5;
    }

    public JComboBox<String> getjComboBox6() {
        return jComboBox6;
    }

    public void setjComboBox6(JComboBox<String> jComboBox6) {
        this.jComboBox6 = jComboBox6;
    }

    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }

    public JLabel getjLabel24() {
        return jLabel24;
    }

    public void setjLabel24(JLabel jLabel24) {
        this.jLabel24 = jLabel24;
    }

    public JLabel getjLabel25() {
        return jLabel25;
    }

    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }

    public JLabel getjLabel28() {
        return jLabel28;
    }

    public void setjLabel28(JLabel jLabel28) {
        this.jLabel28 = jLabel28;
    }

    public JLabel getjLabel29() {
        return jLabel29;
    }

    public void setjLabel29(JLabel jLabel29) {
        this.jLabel29 = jLabel29;
    }

    public JLabel getjLabel30() {
        return jLabel30;
    }

    public void setjLabel30(JLabel jLabel30) {
        this.jLabel30 = jLabel30;
    }

    public JLabel getjLabel31() {
        return jLabel31;
    }

    public void setjLabel31(JLabel jLabel31) {
        this.jLabel31 = jLabel31;
    }

    public JLabel getjLabel32() {
        return jLabel32;
    }

    public void setjLabel32(JLabel jLabel32) {
        this.jLabel32 = jLabel32;
    }

    public JLabel getjLabel33() {
        return jLabel33;
    }

    public void setjLabel33(JLabel jLabel33) {
        this.jLabel33 = jLabel33;
    }

    public JLabel getjLabel34() {
        return jLabel34;
    }

    public void setjLabel34(JLabel jLabel34) {
        this.jLabel34 = jLabel34;
    }

    public JLabel getjLabel35() {
        return jLabel35;
    }

    public void setjLabel35(JLabel jLabel35) {
        this.jLabel35 = jLabel35;
    }

    public JLabel getjLabel36() {
        return jLabel36;
    }

    public void setjLabel36(JLabel jLabel36) {
        this.jLabel36 = jLabel36;
    }

    public JLabel getjLabel37() {
        return jLabel37;
    }

    public void setjLabel37(JLabel jLabel37) {
        this.jLabel37 = jLabel37;
    }

    public JLabel getjLabel38() {
        return jLabel38;
    }

    public void setjLabel38(JLabel jLabel38) {
        this.jLabel38 = jLabel38;
    }

    public JLabel getjLabel39() {
        return jLabel39;
    }

    public void setjLabel39(JLabel jLabel39) {
        this.jLabel39 = jLabel39;
    }

    public JLabel getjLabel40() {
        return jLabel40;
    }

    public void setjLabel40(JLabel jLabel40) {
        this.jLabel40 = jLabel40;
    }

    public JLabel getjLabel41() {
        return jLabel41;
    }

    public void setjLabel41(JLabel jLabel41) {
        this.jLabel41 = jLabel41;
    }

    public JLabel getjLabel42() {
        return jLabel42;
    }

    public void setjLabel42(JLabel jLabel42) {
        this.jLabel42 = jLabel42;
    }

    public JLabel getjLabel43() {
        return jLabel43;
    }

    public void setjLabel43(JLabel jLabel43) {
        this.jLabel43 = jLabel43;
    }

    public JLabel getjLabel44() {
        return jLabel44;
    }

    public void setjLabel44(JLabel jLabel44) {
        this.jLabel44 = jLabel44;
    }

    public JLabel getjLabel45() {
        return jLabel45;
    }

    public void setjLabel45(JLabel jLabel45) {
        this.jLabel45 = jLabel45;
    }

    public JLabel getjLabel46() {
        return jLabel46;
    }

    public void setjLabel46(JLabel jLabel46) {
        this.jLabel46 = jLabel46;
    }

    public JLabel getjLabel47() {
        return jLabel47;
    }

    public void setjLabel47(JLabel jLabel47) {
        this.jLabel47 = jLabel47;
    }

    public JLabel getjLabel48() {
        return jLabel48;
    }

    public void setjLabel48(JLabel jLabel48) {
        this.jLabel48 = jLabel48;
    }

    public JLabel getjLabel49() {
        return jLabel49;
    }

    public void setjLabel49(JLabel jLabel49) {
        this.jLabel49 = jLabel49;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel50() {
        return jLabel50;
    }

    public void setjLabel50(JLabel jLabel50) {
        this.jLabel50 = jLabel50;
    }

    public JPanel getjPanel14() {
        return jPanel14;
    }

    public void setjPanel14(JPanel jPanel14) {
        this.jPanel14 = jPanel14;
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public void setjPanel7(JPanel jPanel7) {
        this.jPanel7 = jPanel7;
    }

    public JRadioButton getjRadioButton10() {
        return jRadioButton10;
    }

    public void setjRadioButton10(JRadioButton jRadioButton10) {
        this.jRadioButton10 = jRadioButton10;
    }

    public JRadioButton getjRadioButton11() {
        return jRadioButton11;
    }

    public void setjRadioButton11(JRadioButton jRadioButton11) {
        this.jRadioButton11 = jRadioButton11;
    }

    public JRadioButton getjRadioButton12() {
        return jRadioButton12;
    }

    public void setjRadioButton12(JRadioButton jRadioButton12) {
        this.jRadioButton12 = jRadioButton12;
    }

    public JRadioButton getjRadioButton13() {
        return jRadioButton13;
    }

    public void setjRadioButton13(JRadioButton jRadioButton13) {
        this.jRadioButton13 = jRadioButton13;
    }

    public JRadioButton getjRadioButton14() {
        return jRadioButton14;
    }

    public void setjRadioButton14(JRadioButton jRadioButton14) {
        this.jRadioButton14 = jRadioButton14;
    }

    public JRadioButton getjRadioButton7() {
        return jRadioButton7;
    }

    public void setjRadioButton7(JRadioButton jRadioButton7) {
        this.jRadioButton7 = jRadioButton7;
    }

    public JRadioButton getjRadioButton8() {
        return jRadioButton8;
    }

    public void setjRadioButton8(JRadioButton jRadioButton8) {
        this.jRadioButton8 = jRadioButton8;
    }

    public JRadioButton getjRadioButton9() {
        return jRadioButton9;
    }

    public void setjRadioButton9(JRadioButton jRadioButton9) {
        this.jRadioButton9 = jRadioButton9;
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

    public JSpinner getjSpinner4() {
        return jSpinner4;
    }

    public void setjSpinner4(JSpinner jSpinner4) {
        this.jSpinner4 = jSpinner4;
    }

    public JTabbedPane getjTabbedPane2() {
        return jTabbedPane2;
    }

    public void setjTabbedPane2(JTabbedPane jTabbedPane2) {
        this.jTabbedPane2 = jTabbedPane2;
    }

    public JTextField getjTextField10() {
        return jTextField10;
    }

    public void setjTextField10(JTextField jTextField10) {
        this.jTextField10 = jTextField10;
    }

    public JTextField getjTextField11() {
        return jTextField11;
    }

    public void setjTextField11(JTextField jTextField11) {
        this.jTextField11 = jTextField11;
    }

    public JTextField getjTextField12() {
        return jTextField12;
    }

    public void setjTextField12(JTextField jTextField12) {
        this.jTextField12 = jTextField12;
    }

    public JTextField getjTextField13() {
        return jTextField13;
    }

    public void setjTextField13(JTextField jTextField13) {
        this.jTextField13 = jTextField13;
    }

    public JTextField getjTextField5() {
        return jTextField5;
    }

    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }

    public JTextField getjTextField6() {
        return jTextField6;
    }

    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

    public JTextField getjTextField7() {
        return jTextField7;
    }

    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }

    public JTextField getjTextField8() {
        return jTextField8;
    }

    public void setjTextField8(JTextField jTextField8) {
        this.jTextField8 = jTextField8;
    }

    public JTextField getjTextField9() {
        return jTextField9;
    }

    public void setjTextField9(JTextField jTextField9) {
        this.jTextField9 = jTextField9;
    }

    public JPanel getPnlCaracteristicas() {
        return pnlCaracteristicas;
    }

    public void setPnlCaracteristicas(JPanel pnlCaracteristicas) {
        this.pnlCaracteristicas = pnlCaracteristicas;
    }

    public JPanel getPnlDatos() {
        return pnlDatos;
    }

    public void setPnlDatos(JPanel pnlDatos) {
        this.pnlDatos = pnlDatos;
    }

    public JPanel getPnlEstado() {
        return pnlEstado;
    }

    public void setPnlEstado(JPanel pnlEstado) {
        this.pnlEstado = pnlEstado;
    }

    public JPanel getPnlMotivo() {
        return pnlMotivo;
    }

    public void setPnlMotivo(JPanel pnlMotivo) {
        this.pnlMotivo = pnlMotivo;
    }

    public JPanel getPnlNotas() {
        return pnlNotas;
    }

    public void setPnlNotas(JPanel pnlNotas) {
        this.pnlNotas = pnlNotas;
    }

    public JPanel getPnlReferencia() {
        return pnlReferencia;
    }

    public void setPnlReferencia(JPanel pnlReferencia) {
        this.pnlReferencia = pnlReferencia;
    }

    public JPanel getPnlResultados() {
        return pnlResultados;
    }

    public void setPnlResultados(JPanel pnlResultados) {
        this.pnlResultados = pnlResultados;
    }

    public JScrollPane getScrPrincipal() {
        return scrPrincipal;
    }

    public void setScrPrincipal(JScrollPane scrPrincipal) {
        this.scrPrincipal = scrPrincipal;
    }

    public JSpinner getSpnEdadBeneficiaria() {
        return spnEdadBeneficiaria;
    }

    public void setSpnEdadBeneficiaria(JSpinner spnEdadBeneficiaria) {
        this.spnEdadBeneficiaria = spnEdadBeneficiaria;
    }

    public JTextField getTxtDireccionBeneficiaria() {
        return txtDireccionBeneficiaria;
    }

    public void setTxtDireccionBeneficiaria(JTextField txtDireccionBeneficiaria) {
        this.txtDireccionBeneficiaria = txtDireccionBeneficiaria;
    }

    public JTextField getTxtNacionalidadBeneficiaria() {
        return txtNacionalidadBeneficiaria;
    }

    public void setTxtNacionalidadBeneficiaria(JTextField txtNacionalidadBeneficiaria) {
        this.txtNacionalidadBeneficiaria = txtNacionalidadBeneficiaria;
    }

    public JTextField getTxtNombreBeneficiaria() {
        return txtNombreBeneficiaria;
    }

    public void setTxtNombreBeneficiaria(JTextField txtNombreBeneficiaria) {
        this.txtNombreBeneficiaria = txtNombreBeneficiaria;
    }

    public JTextArea getTxtNotasAdicionalesBeneficiaria() {
        return txtNotasAdicionalesBeneficiaria;
    }

    public void setTxtNotasAdicionalesBeneficiaria(JTextArea txtNotasAdicionalesBeneficiaria) {
        this.txtNotasAdicionalesBeneficiaria = txtNotasAdicionalesBeneficiaria;
    }

    public JTextField getTxtOperador() {
        return txtOperador;
    }

    public void setTxtOperador(JTextField txtOperador) {
        this.txtOperador = txtOperador;
    }

    public JRootPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(JRootPane rootPane) {
        this.rootPane = rootPane;
    }

    public boolean isRootPaneCheckingEnabled() {
        return rootPaneCheckingEnabled;
    }

    public void setRootPaneCheckingEnabled(boolean rootPaneCheckingEnabled) {
        this.rootPaneCheckingEnabled = rootPaneCheckingEnabled;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrPrincipal = new javax.swing.JScrollPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnlDatos = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtNombreBeneficiaria = new javax.swing.JTextField();
        txtNacionalidadBeneficiaria = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        spnEdadBeneficiaria = new javax.swing.JSpinner();
        jLabel47 = new javax.swing.JLabel();
        cbxEstadoCivilBeneficiaria = new javax.swing.JComboBox<String>();
        jLabel48 = new javax.swing.JLabel();
        txtDireccionBeneficiaria = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jLabel50 = new javax.swing.JLabel();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jSpinner4 = new javax.swing.JSpinner();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        pnlMotivo = new javax.swing.JPanel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        pnlEstado = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<String>();
        jLabel20 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<String>();
        pnlNotas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotasAdicionalesBeneficiaria = new javax.swing.JTextArea();
        pnlCaracteristicas = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<String>();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox30 = new javax.swing.JCheckBox();
        jTextField7 = new javax.swing.JTextField();
        jCheckBox26 = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox31 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jCheckBox28 = new javax.swing.JCheckBox();
        jCheckBox29 = new javax.swing.JCheckBox();
        jTextField8 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox32 = new javax.swing.JCheckBox();
        jCheckBox37 = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        jCheckBox33 = new javax.swing.JCheckBox();
        jTextField9 = new javax.swing.JTextField();
        jCheckBox38 = new javax.swing.JCheckBox();
        jCheckBox34 = new javax.swing.JCheckBox();
        jCheckBox35 = new javax.swing.JCheckBox();
        jCheckBox36 = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jCheckBox39 = new javax.swing.JCheckBox();
        jCheckBox40 = new javax.swing.JCheckBox();
        jCheckBox41 = new javax.swing.JCheckBox();
        jCheckBox46 = new javax.swing.JCheckBox();
        jCheckBox45 = new javax.swing.JCheckBox();
        jCheckBox44 = new javax.swing.JCheckBox();
        jLabel33 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jCheckBox48 = new javax.swing.JCheckBox();
        jCheckBox42 = new javax.swing.JCheckBox();
        jCheckBox43 = new javax.swing.JCheckBox();
        jCheckBox47 = new javax.swing.JCheckBox();
        pnlResultados = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        pnlReferencia = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel42 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cbxPrioridad = new javax.swing.JComboBox<String>();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cbxHoraLlamada = new javax.swing.JComboBox<String>();
        txtOperador = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        datFechaLlamada = new com.toedter.calendar.JDateChooser();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de llamadas");
        setResizable(false);

        pnlDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        jLabel44.setText("Nombre:");

        jLabel45.setText("Nacionalidad:");

        jLabel46.setText("Edad:");

        spnEdadBeneficiaria.setModel(new javax.swing.SpinnerNumberModel(18, 0, 100, 1));

        jLabel47.setText("Estado civil:");

        cbxEstadoCivilBeneficiaria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltera", "Casada", "Divirciado", "Viuda", "Unión libre" }));

        jLabel48.setText("Dirección:");

        jLabel49.setText("¿Hijos?:");

        jRadioButton9.setText("Si");

        jRadioButton10.setText("No");

        jLabel50.setText("¿Trabaja?:");

        jRadioButton11.setText("Si");

        jRadioButton12.setText("No");

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jRadioButton13.setText("No reporta");

        jRadioButton14.setText("No reporta");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(24, 24, 24)
                                .addComponent(jRadioButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton10))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGap(12, 12, 12)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jRadioButton13)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtDireccionBeneficiaria)))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel46))
                                .addGap(21, 21, 21)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnEdadBeneficiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreBeneficiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel45))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxEstadoCivilBeneficiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNacionalidadBeneficiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(66, 66, 66))))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(txtNombreBeneficiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNacionalidadBeneficiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(spnEdadBeneficiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(cbxEstadoCivilBeneficiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtDireccionBeneficiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton13))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12)
                    .addComponent(jRadioButton14))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("DATOS DE INFORMACIÓN", pnlDatos);

        jCheckBox3.setText("Violación");

        jCheckBox4.setText("Accesoría legal");

        jCheckBox9.setText("Intento de sucidio");

        jCheckBox12.setText("No reporta");

        jCheckBox11.setText("Información sobre otras instituciones");

        jCheckBox7.setText("Atención psicológica");

        jCheckBox6.setText("Violencia socila");

        jCheckBox2.setText("Abuso sexual");

        jCheckBox1.setText("Violencia intrafamiliar");

        jCheckBox5.setText("Violencia institucional");

        jCheckBox8.setText("Alivio y apoyo");

        jCheckBox10.setText("Información sobre la casa de acogida");

        jLabel16.setText("Otros:");

        javax.swing.GroupLayout pnlMotivoLayout = new javax.swing.GroupLayout(pnlMotivo);
        pnlMotivo.setLayout(pnlMotivoLayout);
        pnlMotivoLayout.setHorizontalGroup(
            pnlMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMotivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMotivoLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5))
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(pnlMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox11))
                .addGap(34, 34, 34)
                .addGroup(pnlMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox12)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox9))
                .addContainerGap())
        );
        pnlMotivoLayout.setVerticalGroup(
            pnlMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMotivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox11)
                    .addComponent(jCheckBox12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(233, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("MOTIVO DE LA LLAMADA", pnlMotivo);

        jLabel18.setText("Emociones:");

        jCheckBox13.setText("Ansiosa");

        jCheckBox16.setText("Tranquila");

        jCheckBox17.setText("Llorosa");

        jCheckBox14.setText("Asustada");

        jCheckBox15.setText("Nerviosa");

        jCheckBox18.setText("Enojada");

        jLabel19.setText("Habla:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Mucho", "Poco", "Nada" }));

        jLabel20.setText("Voz:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Susurro", "Grita" }));

        javax.swing.GroupLayout pnlEstadoLayout = new javax.swing.GroupLayout(pnlEstado);
        pnlEstado.setLayout(pnlEstadoLayout);
        pnlEstadoLayout.setHorizontalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEstadoLayout.createSequentialGroup()
                        .addComponent(jCheckBox13)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox16)
                        .addGap(168, 168, 168)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEstadoLayout.createSequentialGroup()
                        .addComponent(jCheckBox15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox18))
                    .addGroup(pnlEstadoLayout.createSequentialGroup()
                        .addComponent(jCheckBox14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox17)))
                .addContainerGap())
        );
        pnlEstadoLayout.setVerticalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jCheckBox13)
                    .addComponent(jCheckBox16)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox14)
                    .addComponent(jCheckBox17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox15)
                    .addComponent(jCheckBox18))
                .addContainerGap(291, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ESTADO PSICO-EMOCIONAL EN EL TELÉFONO", pnlEstado);

        txtNotasAdicionalesBeneficiaria.setColumns(20);
        txtNotasAdicionalesBeneficiaria.setRows(5);
        jScrollPane2.setViewportView(txtNotasAdicionalesBeneficiaria);

        javax.swing.GroupLayout pnlNotasLayout = new javax.swing.GroupLayout(pnlNotas);
        pnlNotas.setLayout(pnlNotasLayout);
        pnlNotasLayout.setHorizontalGroup(
            pnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlNotasLayout.setVerticalGroup(
            pnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("NOTAS ADICIONALES", pnlNotas);

        jLabel35.setText("Donde:");

        jRadioButton8.setText("No");

        jRadioButton7.setText("Si");

        jLabel34.setText("¿Ha recibido atención anterior por la violencia?");

        jLabel23.setText("Tipo de violencia:");

        jCheckBox19.setText("Física");

        jCheckBox20.setText("Psicológica");

        jCheckBox21.setText("Laboral");

        jCheckBox22.setText("Econímica");

        jCheckBox23.setText("Negligencia");

        jCheckBox24.setText("No reporta");

        jLabel5.setText("Otra:");

        jLabel24.setText("Frecuencia de la agresión:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Primera vez", "Ocasionalmente", "Constantemente", "No reporta" }));

        jCheckBox25.setText("Esposo");

        jCheckBox30.setText("Jefe");

        jCheckBox26.setText("Padre/Madre");

        jLabel25.setText("¿Quién es el agresor?:");

        jCheckBox31.setText("No reporta");

        jCheckBox27.setText("Novio");

        jCheckBox28.setText("Ex pareja");

        jCheckBox29.setText("Hijo");

        jLabel29.setText("Nacionalidad del agresor:");

        jLabel28.setText("Otro:");

        jLabel30.setText("Factores de riesgo:");

        jCheckBox32.setText("Alcoholismo");

        jCheckBox37.setText("Machismo");

        jLabel31.setText("Otro:");

        jCheckBox33.setText("Migración");

        jCheckBox38.setText("No reporta");

        jCheckBox34.setText("Celos");

        jCheckBox35.setText("Desempleo");

        jCheckBox36.setText("Infidelidad");

        jLabel32.setText("Consecuencias físicas de la agresión:");

        jCheckBox39.setText("Fracturas");

        jCheckBox40.setText("Moretones");

        jCheckBox41.setText("Heridas");

        jCheckBox46.setText("Depresión");

        jCheckBox45.setText("Baja autoestima");

        jCheckBox44.setText("Alt. nerviosas");

        jLabel33.setText("Otro:");

        jCheckBox48.setText("No reporta");

        jCheckBox42.setText("Abortos");

        jCheckBox43.setText("Contagios ETS");

        jCheckBox47.setText("Embarazo no deseado");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jCheckBox19))
                                .addGap(41, 41, 41)
                                .addComponent(jCheckBox20)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox21)
                                    .addComponent(jCheckBox24))))
                        .addGap(89, 89, 89)
                        .addComponent(jCheckBox22)
                        .addGap(72, 72, 72)
                        .addComponent(jCheckBox23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8)
                        .addGap(179, 179, 179))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox25)
                                    .addComponent(jCheckBox30))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jCheckBox26)
                                        .addGap(242, 242, 242)
                                        .addComponent(jCheckBox28))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGap(127, 127, 127)
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jCheckBox27)
                                                    .addComponent(jCheckBox31)))
                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(69, 69, 69)
                                .addComponent(jCheckBox29))
                            .addComponent(jLabel25)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(487, 487, 487)
                                        .addComponent(jCheckBox35))
                                    .addComponent(jLabel30))
                                .addGap(17, 17, 17)
                                .addComponent(jCheckBox36))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox32)
                                    .addComponent(jCheckBox37))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox33)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox38)
                                    .addComponent(jCheckBox34)))
                            .addComponent(jLabel32))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jCheckBox39)
                                .addGap(65, 65, 65)
                                .addComponent(jCheckBox40)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox41)
                                    .addComponent(jCheckBox46)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jCheckBox44)
                                .addGap(42, 42, 42)
                                .addComponent(jCheckBox45)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox47))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(487, 487, 487)
                        .addComponent(jCheckBox42)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckBox43))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox48)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox19)
                    .addComponent(jCheckBox20)
                    .addComponent(jCheckBox21)
                    .addComponent(jCheckBox22)
                    .addComponent(jCheckBox23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox24))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox25)
                    .addComponent(jCheckBox26)
                    .addComponent(jCheckBox27)
                    .addComponent(jCheckBox28)
                    .addComponent(jCheckBox29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox30)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox31)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox32)
                    .addComponent(jCheckBox33)
                    .addComponent(jCheckBox34)
                    .addComponent(jCheckBox35)
                    .addComponent(jCheckBox36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox37)
                    .addComponent(jLabel31)
                    .addComponent(jCheckBox38)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox39)
                    .addComponent(jCheckBox40)
                    .addComponent(jCheckBox41)
                    .addComponent(jCheckBox42)
                    .addComponent(jCheckBox43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox44)
                    .addComponent(jCheckBox45)
                    .addComponent(jCheckBox46)
                    .addComponent(jCheckBox47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox48))
                .addContainerGap(285, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel14);

        javax.swing.GroupLayout pnlCaracteristicasLayout = new javax.swing.GroupLayout(pnlCaracteristicas);
        pnlCaracteristicas.setLayout(pnlCaracteristicasLayout);
        pnlCaracteristicasLayout.setHorizontalGroup(
            pnlCaracteristicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCaracteristicasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCaracteristicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addGroup(pnlCaracteristicasLayout.createSequentialGroup()
                        .addComponent(jRadioButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );
        pnlCaracteristicasLayout.setVerticalGroup(
            pnlCaracteristicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCaracteristicasLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(274, 274, 274)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCaracteristicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8)
                    .addComponent(jLabel35)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("CARACTERÍSTICAS DE LA VIOLENCIA", pnlCaracteristicas);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlResultadosLayout = new javax.swing.GroupLayout(pnlResultados);
        pnlResultados.setLayout(pnlResultadosLayout);
        pnlResultadosLayout.setHorizontalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadosLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlResultadosLayout.setVerticalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("RESULTADOS", pnlResultados);

        jLabel36.setText("Fecha:");

        jLabel38.setText("Responsable de la atención:");

        jLabel37.setText("Hora:");

        javax.swing.GroupLayout pnlReferenciaLayout = new javax.swing.GroupLayout(pnlReferencia);
        pnlReferencia.setLayout(pnlReferenciaLayout);
        pnlReferenciaLayout.setHorizontalGroup(
            pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReferenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField13)
                    .addGroup(pnlReferenciaLayout.createSequentialGroup()
                        .addGroup(pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlReferenciaLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlReferenciaLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(133, 133, 133)
                        .addComponent(jLabel37)
                        .addGap(0, 300, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlReferenciaLayout.setVerticalGroup(
            pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReferenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlReferenciaLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel37))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReferenciaLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel36)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReferenciaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(270, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("¿CÓMO SUPO DE LA LÍNEA TELAFÓNICA?", pnlReferencia);

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("FICHA DE REGISTRO DE LLAMADAS TELEFÓNICAS");

        jLabel40.setText("Fecha:");

        cbxPrioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Urgente", "Medio", "Normal" }));

        jLabel39.setText("Prioridad del caso:");

        jLabel41.setText("Hora de llamada:");

        cbxHoraLlamada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mañana", "Tarde", "Noche" }));

        jLabel43.setText("Operador:");

        btnCancelar.setText("Cancelar");

        btnGuardar.setText("GUARDAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datFechaLlamada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxHoraLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPrincipal)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(jLabel41)
                        .addComponent(jLabel43)
                        .addComponent(cbxHoraLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(datFechaLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(cbxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaRegistroLlamadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroLlamadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroLlamadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroLlamadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistroLlamadas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxEstadoCivilBeneficiaria;
    private javax.swing.JComboBox<String> cbxHoraLlamada;
    private javax.swing.JComboBox<String> cbxPrioridad;
    private com.toedter.calendar.JDateChooser datFechaLlamada;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox34;
    private javax.swing.JCheckBox jCheckBox35;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox41;
    private javax.swing.JCheckBox jCheckBox42;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox44;
    private javax.swing.JCheckBox jCheckBox45;
    private javax.swing.JCheckBox jCheckBox46;
    private javax.swing.JCheckBox jCheckBox47;
    private javax.swing.JCheckBox jCheckBox48;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel pnlCaracteristicas;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlEstado;
    private javax.swing.JPanel pnlMotivo;
    private javax.swing.JPanel pnlNotas;
    private javax.swing.JPanel pnlReferencia;
    private javax.swing.JPanel pnlResultados;
    private javax.swing.JScrollPane scrPrincipal;
    private javax.swing.JSpinner spnEdadBeneficiaria;
    private javax.swing.JTextField txtDireccionBeneficiaria;
    private javax.swing.JTextField txtNacionalidadBeneficiaria;
    private javax.swing.JTextField txtNombreBeneficiaria;
    private javax.swing.JTextArea txtNotasAdicionalesBeneficiaria;
    private javax.swing.JTextField txtOperador;
    // End of variables declaration//GEN-END:variables
}
