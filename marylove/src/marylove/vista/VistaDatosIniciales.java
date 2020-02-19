package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/** @author Angel Lucero */
public class VistaDatosIniciales extends javax.swing.JFrame {
    public VistaDatosIniciales() {
        initComponents();
        createButtonGroups();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void createButtonGroups(){
        ButtonGroup embarazada = new ButtonGroup();
        embarazada.add(radEmbarazadaVictimaSi);
        embarazada.add(radEmbarazadaVictimaNo);
        
        ButtonGroup discapacitada = new ButtonGroup();
        discapacitada.add(radDiscapacidadVictimaSi);
        discapacitada.add(radDiscapacidadVictimaNo);
        
        ButtonGroup movilidad = new ButtonGroup();
        movilidad.add(radSituacionMovilidadVictimaSi);
        movilidad.add(radSituacionMovilidadVictimaNo);
        
        ButtonGroup residencia = new ButtonGroup();
        residencia.add(radResidenciaVictimaUrbana);
        residencia.add(radResidenciaVictimaRural);
    }

    //Botón Guardar
    public JButton getBtnGuardar() {
        return btnGuardar;
    }
    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    //Datos Encabezado
    public JDateChooser getDatFechaEgreso() {
        return datFechaEgreso;
    }
    public void setDatFechaEgreso(JDateChooser datFechaEgreso) {
        this.datFechaEgreso = datFechaEgreso;
    }

    public JDateChooser getDatFechaIngreso() {
        return datFechaIngreso;
    }
    public void setDatFechaIngreso(JDateChooser datFechaIngreso) {
        this.datFechaIngreso = datFechaIngreso;
    }

    public JDateChooser getDatFechaNacimientoVictima() {
        return datFechaNacimientoVictima;
    }
    public void setDatFechaNacimientoVictima(JDateChooser datFechaNacimientoVictima) {
        this.datFechaNacimientoVictima = datFechaNacimientoVictima;
    }

    public JTextField getTxtApellidosVictima() {
        return txtApellidosVictima;
    }
    public void setTxtApellidosVictima(JTextField txtApellidosVictima) {
        this.txtApellidosVictima = txtApellidosVictima;
    }

    public JTextField getTxtCedulaVictima() {
        return txtCedulaVictima;
    }
    public void setTxtCedulaVictima(JTextField txtCedulaVictima) {
        this.txtCedulaVictima = txtCedulaVictima;
    }

    public JTextField getTxtNombresVictima() {
        return txtNombresVictima;
    }
    public void setTxtNombresVictima(JTextField txtNombresVictima) {
        this.txtNombresVictima = txtNombresVictima;
    }
    
    //Datos de identificacion

    public JComboBox<String> getCbxNacionalidadVictima() {
        return cbxNacionalidadVictima;
    }
    public void setCbxNacionalidadVictima(JComboBox<String> cbxNacionalidadVictima) {
        this.cbxNacionalidadVictima = cbxNacionalidadVictima;
    }

    public JComboBox<String> getCbxSituacionMovilidadVictima() {
        return cbxSituacionMovilidadVictima;
    }

    public void setCbxSituacionMovilidadVictima(JComboBox<String> cbxSituacionMovilidadVictima) {
        this.cbxSituacionMovilidadVictima = cbxSituacionMovilidadVictima;
    }

    public JRadioButton getRadSituacionMovilidadVictimaNo() {
        return radSituacionMovilidadVictimaNo;
    }
    public void setRadSituacionMovilidadVictimaNo(JRadioButton radSituacionMovilidadVictimaNo) {
        this.radSituacionMovilidadVictimaNo = radSituacionMovilidadVictimaNo;
    }

    public JRadioButton getRadSituacionMovilidadVictimaSi() {
        return radSituacionMovilidadVictimaSi;
    }
    public void setRadSituacionMovilidadVictimaSi(JRadioButton radSituacionMovilidadVictimaSi) {
        this.radSituacionMovilidadVictimaSi = radSituacionMovilidadVictimaSi;
    }

    public JTextField getTxtDomicilioVictima() {
        return txtDomicilioVictima;
    }
    public void setTxtDomicilioVictima(JTextField txtDomicilioVictima) {
        this.txtDomicilioVictima = txtDomicilioVictima;
    }

    public JComboBox<String> getCbxCantonVictima() {
        return cbxCantonVictima;
    }

    public void setCbxCantonVictima(JComboBox<String> cbxCantonVictima) {
        this.cbxCantonVictima = cbxCantonVictima;
    }

    public JComboBox<String> getCbxParroquiaVictima() {
        return cbxParroquiaVictima;
    }

    public void setCbxParroquiaVictima(JComboBox<String> cbxParroquiaVictima) {
        this.cbxParroquiaVictima = cbxParroquiaVictima;
    }

    public JComboBox<String> getCbxProvinciaVictima() {
        return cbxProvinciaVictima;
    }

    public void setCbxProvinciaVictima(JComboBox<String> cbxProvinciaVictima) {
        this.cbxProvinciaVictima = cbxProvinciaVictima;
    }

    public JRadioButton getRadResidenciaVictimaRural() {
        return radResidenciaVictimaRural;
    }
    public void setRadResidenciaVictimaRural(JRadioButton radResidenciaVictimaRural) {
        this.radResidenciaVictimaRural = radResidenciaVictimaRural;
    }

    public JRadioButton getRadResidenciaVictimaUrbana() {
        return radResidenciaVictimaUrbana;
    }
    public void setRadResidenciaVictimaUrbana(JRadioButton radResidenciaVictimaUrbana) {
        this.radResidenciaVictimaUrbana = radResidenciaVictimaUrbana;
    }

    public JComboBox<String> getCbxEtniaVictima() {
        return cbxEtniaVictima;
    }
    public void setCbxEtniaVictima(JComboBox<String> cbxEtniaVictima) {
        this.cbxEtniaVictima = cbxEtniaVictima;
    }

    public JSpinner getSpnNumeroHijosVictima() {
        return spnNumeroHijosVictima;
    }
    public void setSpnNumeroHijosVictima(JSpinner spnNumeroHijosVictima) {
        this.spnNumeroHijosVictima = spnNumeroHijosVictima;
    }

    public JRadioButton getRadEmbarazadaVictimaNo() {
        return radEmbarazadaVictimaNo;
    }

    public void setRadEmbarazadaVictimaNo(JRadioButton radEmbarazadaVictimaNo) {
        this.radEmbarazadaVictimaNo = radEmbarazadaVictimaNo;
    }

    public JRadioButton getRadEmbarazadaVictimaSi() {
        return radEmbarazadaVictimaSi;
    }

    public void setRadEmbarazadaVictimaSi(JRadioButton radEmbarazadaVictimaSi) {
        this.radEmbarazadaVictimaSi = radEmbarazadaVictimaSi;
    }

    public JSpinner getSpnMesesEmbarazoVictima() {
        return spnMesesEmbarazoVictima;
    }

    public void setSpnMesesEmbarazoVictima(JSpinner spnMesesEmbarazoVictima) {
        this.spnMesesEmbarazoVictima = spnMesesEmbarazoVictima;
    }

    public JRadioButton getRadDiscapacidadVictimaNo() {
        return radDiscapacidadVictimaNo;
    }

    public void setRadDiscapacidadVictimaNo(JRadioButton radDiscapacidadVictimaNo) {
        this.radDiscapacidadVictimaNo = radDiscapacidadVictimaNo;
    }

    public JRadioButton getRadDiscapacidadVictimaSi() {
        return radDiscapacidadVictimaSi;
    }

    public void setRadDiscapacidadVictimaSi(JRadioButton radDiscapacidadVictimaSi) {
        this.radDiscapacidadVictimaSi = radDiscapacidadVictimaSi;
    }

    public JSpinner getSpnPorcentajeDiscapacidadVictima() {
        return spnPorcentajeDiscapacidadVictima;
    }

    public void setSpnPorcentajeDiscapacidadVictima(JSpinner spnPorcentajeDiscapacidadVictima) {
        this.spnPorcentajeDiscapacidadVictima = spnPorcentajeDiscapacidadVictima;
    }

    public JComboBox<String> getCbxTipoDiscapacidadVictima() {
        return cbxTipoDiscapacidadVictima;
    }

    public void setCbxTipoDiscapacidadVictima(JComboBox<String> cbxTipoDiscapacidadVictima) {
        this.cbxTipoDiscapacidadVictima = cbxTipoDiscapacidadVictima;
    }

    public JTextField getTxtDescripcionDiscapacidadVictima() {
        return txtDescripcionDiscapacidadVictima;
    }

    public void setTxtDescripcionDiscapacidadVictima(JTextField txtDescripcionDiscapacidadVictima) {
        this.txtDescripcionDiscapacidadVictima = txtDescripcionDiscapacidadVictima;
    }

    public JComboBox<String> getCbxEstadoCivilVictima() {
        return cbxEstadoCivilVictima;
    }

    public void setCbxEstadoCivilVictima(JComboBox<String> cbxEstadoCivilVictima) {
        this.cbxEstadoCivilVictima = cbxEstadoCivilVictima;
    }

    public JComboBox<String> getCbxNivelEducacionVictima() {
        return cbxNivelEducacionVictima;
    }

    public void setCbxNivelEducacionVictima(JComboBox<String> cbxNivelEducacionVictima) {
        this.cbxNivelEducacionVictima = cbxNivelEducacionVictima;
    }
    
    //2. Datos de la violencia
    public JCheckBox getCheTipoViolenciaAbandono() {
        return cheTipoViolenciaAbandono;
    }
    public void setCheTipoViolenciaAbandono(JCheckBox cheTipoViolenciaAbandono) {
        this.cheTipoViolenciaAbandono = cheTipoViolenciaAbandono;
    }

    public JCheckBox getCheTipoViolenciaFemicidio() {
        return cheTipoViolenciaFemicidio;
    }
    public void setCheTipoViolenciaFemicidio(JCheckBox cheTipoViolenciaFemicidio) {
        this.cheTipoViolenciaFemicidio = cheTipoViolenciaFemicidio;
    }

    public JCheckBox getCheTipoViolenciaFisica() {
        return cheTipoViolenciaFisica;
    }
    public void setCheTipoViolenciaFisica(JCheckBox cheTipoViolenciaFisica) {
        this.cheTipoViolenciaFisica = cheTipoViolenciaFisica;
    }

    public JCheckBox getCheTipoViolenciaPatrimonial() {
        return cheTipoViolenciaPatrimonial;
    }
    public void setCheTipoViolenciaPatrimonial(JCheckBox cheTipoViolenciaPatrimonial) {
        this.cheTipoViolenciaPatrimonial = cheTipoViolenciaPatrimonial;
    }

    public JCheckBox getCheTipoViolenciaPsicologica() {
        return cheTipoViolenciaPsicologica;
    }
    public void setCheTipoViolenciaPsicologica(JCheckBox cheTipoViolenciaPsicologica) {
        this.cheTipoViolenciaPsicologica = cheTipoViolenciaPsicologica;
    }

    public JCheckBox getCheTipoViolenciaSexual() {
        return cheTipoViolenciaSexual;
    }
    public void setCheTipoViolenciaSexual(JCheckBox cheTipoViolenciaSexual) {
        this.cheTipoViolenciaSexual = cheTipoViolenciaSexual;
    }

    public JTextField getTxtNombresApellidosAgresor() {
        return txtNombresApellidosAgresor;
    }

    public void setTxtNombresApellidosAgresor(JTextField txtNombresApellidosAgresor) {
        this.txtNombresApellidosAgresor = txtNombresApellidosAgresor;
    }

    public JSpinner getSpnEdadAgresor() {
        return spnEdadAgresor;
    }

    public void setSpnEdadAgresor(JSpinner spnEdadAgresor) {
        this.spnEdadAgresor = spnEdadAgresor;
    }

    public JTextField getTxtParentescoAgresor() {
        return txtParentescoAgresor;
    }

    public void setTxtParentescoAgresor(JTextField txtParentescoAgresor) {
        this.txtParentescoAgresor = txtParentescoAgresor;
    }

    public JComboBox<String> getCbxNacionalidadAgresor() {
        return cbxNacionalidadAgresor;
    }

    public void setCbxNacionalidadAgresor(JComboBox<String> cbxNacionalidadAgresor) {
        this.cbxNacionalidadAgresor = cbxNacionalidadAgresor;
    }

    public JComboBox<String> getCbxSituacionMovilidadAgresor() {
        return cbxSituacionMovilidadAgresor;
    }

    public void setCbxSituacionMovilidadAgresor(JComboBox<String> cbxSituacionMovilidadAgresor) {
        this.cbxSituacionMovilidadAgresor = cbxSituacionMovilidadAgresor;
    }

    public JComboBox<String> getCbxNivelEducacionAgresor() {
        return cbxNivelEducacionAgresor;
    }

    public void setCbxNivelEducacionAgresor(JComboBox<String> cbxNivelEducacionAgresor) {
        this.cbxNivelEducacionAgresor = cbxNivelEducacionAgresor;
    }

    public JTextField getTxtDireccionDomicilioAgresor() {
        return txtDireccionDomicilioAgresor;
    }

    public void setTxtDireccionDomicilioAgresor(JTextField txtDireccionDomicilioAgresor) {
        this.txtDireccionDomicilioAgresor = txtDireccionDomicilioAgresor;
    }

    public JTextField getTxtDireccionTrabajoAgresor() {
        return txtDireccionTrabajoAgresor;
    }

    public void setTxtDireccionTrabajoAgresor(JTextField txtDireccionTrabajoAgresor) {
        this.txtDireccionTrabajoAgresor = txtDireccionTrabajoAgresor;
    }

    public JTextField getTxtTelefonoAgresor() {
        return txtTelefonoAgresor;
    }

    public void setTxtTelefonoAgresor(JTextField txtTelefonoAgresor) {
        this.txtTelefonoAgresor = txtTelefonoAgresor;
    }

    public JTextArea getTxtPeligrosidadAgresor() {
        return txtPeligrosidadAgresor;
    }

    public void setTxtPeligrosidadAgresor(JTextArea txtPeligrosidadAgresor) {
        this.txtPeligrosidadAgresor = txtPeligrosidadAgresor;
    }
    
    //3. Registro de femicidios/Tentativa de femicidios

    public JTextField getTxtCedulaVictima2() {
        return txtCedulaVictima2;
    }

    public void setTxtCedulaVictima2(JTextField txtCedulaVictima2) {
        this.txtCedulaVictima2 = txtCedulaVictima2;
    }

    public JTextField getTxtNombresApellidosVictima() {
        return txtNombresApellidosVictima;
    }

    public void setTxtNombresApellidosVictima(JTextField txtNombresApellidosVictima) {
        this.txtNombresApellidosVictima = txtNombresApellidosVictima;
    }

    public JDateChooser getDtaFechaNacimientoVictima() {
        return dtaFechaNacimientoVictima;
    }

    public void setDtaFechaNacimientoVictima(JDateChooser dtaFechaNacimientoVictima) {
        this.dtaFechaNacimientoVictima = dtaFechaNacimientoVictima;
    }

    public JSpinner getSpnEdadVictima() {
        return spnEdadVictima;
    }

    public void setSpnEdadVictima(JSpinner spnEdadVictima) {
        this.spnEdadVictima = spnEdadVictima;
    }

    public JDateChooser getDatFechaDelitoAVictima() {
        return datFechaDelitoAVictima;
    }

    public void setDatFechaDelitoAVictima(JDateChooser datFechaDelitoAVictima) {
        this.datFechaDelitoAVictima = datFechaDelitoAVictima;
    }

    public JDateChooser getDatFechaFallecimientoVictima() {
        return datFechaFallecimientoVictima;
    }

    public void setDatFechaFallecimientoVictima(JDateChooser datFechaFallecimientoVictima) {
        this.datFechaFallecimientoVictima = datFechaFallecimientoVictima;
    }

    public JTextArea getTxtDatosRelevantes() {
        return txtDatosRelevantes;
    }

    public void setTxtDatosRelevantes(JTextArea txtDatosRelevantes) {
        this.txtDatosRelevantes = txtDatosRelevantes;
    }

    public JTextField getTxtLugarHecho() {
        return txtLugarHecho;
    }

    public void setTxtLugarHecho(JTextField txtLugarHecho) {
        this.txtLugarHecho = txtLugarHecho;
    }

    public JTextField getTxtRelcionVictimaAgresor() {
        return txtRelcionVictimaAgresor;
    }

    public void setTxtRelcionVictimaAgresor(JTextField txtRelcionVictimaAgresor) {
        this.txtRelcionVictimaAgresor = txtRelcionVictimaAgresor;
    }

    public JTextField getTxtVulneravilidadVictima() {
        return txtVulneravilidadVictima;
    }

    public void setTxtVulneravilidadVictima(JTextField txtVulneravilidadVictima) {
        this.txtVulneravilidadVictima = txtVulneravilidadVictima;
    }
    
    //4. Ficha Socioeconomica

    public JButton getBtnAgregarFamiliar() {
        return btnAgregarFamiliar;
    }

    public void setBtnAgregarFamiliar(JButton btnAgregarFamiliar) {
        this.btnAgregarFamiliar = btnAgregarFamiliar;
    }

    public JTable getTabEstructuraFamiliar() {
        return tabEstructuraFamiliar;
    }

    public void setTabEstructuraFamiliar(JTable tabEstructuraFamiliar) {
        this.tabEstructuraFamiliar = tabEstructuraFamiliar;
    }

    public JTextArea getTxtHistoriaRelaciones() {
        return txtHistoriaRelaciones;
    }
    public void setTxtHistoriaRelaciones(JTextArea txtHistoriaRelaciones) {
        this.txtHistoriaRelaciones = txtHistoriaRelaciones;
    }

    //4.2
    public JTextArea getTxtEgresosVictima() {
        return txtEgresosVictima;
    }
    public void setTxtEgresosVictima(JTextArea txtEgresosVictima) {
        this.txtEgresosVictima = txtEgresosVictima;
    }

    public JTextArea getTxtIngresosVictima() {
        return txtIngresosVictima;
    }
    public void setTxtIngresosVictima(JTextArea txtIngresosVictima) {
        this.txtIngresosVictima = txtIngresosVictima;
    }

    public JTextArea getTxtServiciosBasicosVictima() {
        return txtServiciosBasicosVictima;
    }
    public void setTxtServiciosBasicosVictima(JTextArea txtServiciosBasicosVictima) {
        this.txtServiciosBasicosVictima = txtServiciosBasicosVictima;
    }

    public JTextArea getTxtSituacionLaboralVictima() {
        return txtSituacionLaboralVictima;
    }
    public void setTxtSituacionLaboralVictima(JTextArea txtSituacionLaboralVictima) {
        this.txtSituacionLaboralVictima = txtSituacionLaboralVictima;
    }

    public JTextArea getTxtViviendaVictima() {
        return txtViviendaVictima;
    }
    public void setTxtViviendaVictima(JTextArea txtViviendaVictima) {
        this.txtViviendaVictima = txtViviendaVictima;
    }

    //4.3.
    public JTextArea getTxtCapcidadesDestrezasVictima() {
        return txtCapcidadesDestrezasVictima;
    }

    public void setTxtCapcidadesDestrezasVictima(JTextArea txtCapcidadesDestrezasVictima) {
        this.txtCapcidadesDestrezasVictima = txtCapcidadesDestrezasVictima;
    }
    
    //4.4.

    public JTextArea getTxtAfeccionesFrecuentes() {
        return txtAfeccionesFrecuentes;
    }
    public void setTxtAfeccionesFrecuentes(JTextArea txtAfeccionesFrecuentes) {
        this.txtAfeccionesFrecuentes = txtAfeccionesFrecuentes;
    }

    public JTextArea getTxtSaludGrupofamiliarIngreso() {
        return txtSaludGrupofamiliarIngreso;
    }
    public void setTxtSaludGrupofamiliarIngreso(JTextArea txtSaludGrupofamiliarIngreso) {
        this.txtSaludGrupofamiliarIngreso = txtSaludGrupofamiliarIngreso;
    }

    public JTextArea getTxtAccesoServicioSalud() {
        return txtAccesoServicioSalud;
    }

    public void setTxtAccesoServicioSalud(JTextArea txtAccesoServicioSalud) {
        this.txtAccesoServicioSalud = txtAccesoServicioSalud;
    }

    public JTextArea getTxtSituacionesEspeciales() {
        return txtSituacionesEspeciales;
    }

    public void setTxtSituacionesEspeciales(JTextArea txtSituacionesEspeciales) {
        this.txtSituacionesEspeciales = txtSituacionesEspeciales;
    }
    
    //4.5.
    public JTextArea getTxtEducacionVictima() {
        return txtEducacionVictima;
    }

    public void setTxtEducacionVictima(JTextArea txtEducacionVictima) {
        this.txtEducacionVictima = txtEducacionVictima;
    }
    
    //4.6
    public JTextArea getTxtRiesgosVictima() {
        return txtRiesgosVictima;
    }
    public void setTxtRiesgosVictima(JTextArea txtRiesgosVictima) {
        this.txtRiesgosVictima = txtRiesgosVictima;
    }

    public JTextArea getTxtSituacionViolenciaVictima() {
        return txtSituacionViolenciaVictima;
    }
    public void setTxtSituacionViolenciaVictima(JTextArea txtSituacionViolenciaVictima) {
        this.txtSituacionViolenciaVictima = txtSituacionViolenciaVictima;
    }

    //4.7
    public JTextArea getTxtRecomendacionesVictima() {
        return txtRecomendacionesVictima;
    }
    public void setTxtRecomendacionesVictima(JTextArea txtRecomendacionesVictima) {
        this.txtRecomendacionesVictima = txtRecomendacionesVictima;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbxNacionalidadVictima = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        radSituacionMovilidadVictimaSi = new javax.swing.JRadioButton();
        radSituacionMovilidadVictimaNo = new javax.swing.JRadioButton();
        cbxSituacionMovilidadVictima = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbxProvinciaVictima = new javax.swing.JComboBox<>();
        cbxCantonVictima = new javax.swing.JComboBox<>();
        cbxParroquiaVictima = new javax.swing.JComboBox<>();
        txtDomicilioVictima = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        radResidenciaVictimaUrbana = new javax.swing.JRadioButton();
        radResidenciaVictimaRural = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        cbxEtniaVictima = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        spnNumeroHijosVictima = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        radEmbarazadaVictimaSi = new javax.swing.JRadioButton();
        radEmbarazadaVictimaNo = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        radDiscapacidadVictimaSi = new javax.swing.JRadioButton();
        radDiscapacidadVictimaNo = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        spnPorcentajeDiscapacidadVictima = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        cbxTipoDiscapacidadVictima = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtDescripcionDiscapacidadVictima = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cbxEstadoCivilVictima = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        cbxNivelEducacionVictima = new javax.swing.JComboBox<>();
        spnMesesEmbarazoVictima = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        cheTipoViolenciaPsicologica = new javax.swing.JCheckBox();
        cheTipoViolenciaSexual = new javax.swing.JCheckBox();
        cheTipoViolenciaFemicidio = new javax.swing.JCheckBox();
        cheTipoViolenciaAbandono = new javax.swing.JCheckBox();
        cheTipoViolenciaPatrimonial = new javax.swing.JCheckBox();
        cheTipoViolenciaFisica = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtNombresApellidosAgresor = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        spnEdadAgresor = new javax.swing.JSpinner();
        jLabel30 = new javax.swing.JLabel();
        txtParentescoAgresor = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        cbxNacionalidadAgresor = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        cbxNivelEducacionAgresor = new javax.swing.JComboBox<>();
        cbxSituacionMovilidadAgresor = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtDireccionDomicilioAgresor = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtDireccionTrabajoAgresor = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtTelefonoAgresor = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPeligrosidadAgresor = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtNombresApellidosVictima = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        spnEdadVictima = new javax.swing.JSpinner();
        jLabel40 = new javax.swing.JLabel();
        dtaFechaNacimientoVictima = new com.toedter.calendar.JDateChooser();
        txtCedulaVictima2 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        datFechaDelitoAVictima = new com.toedter.calendar.JDateChooser();
        jLabel42 = new javax.swing.JLabel();
        datFechaFallecimientoVictima = new com.toedter.calendar.JDateChooser();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDatosRelevantes = new javax.swing.JTextArea();
        jLabel45 = new javax.swing.JLabel();
        txtLugarHecho = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtVulneravilidadVictima = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtRelcionVictimaAgresor = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabEstructuraFamiliar = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtHistoriaRelaciones = new javax.swing.JTextArea();
        btnAgregarFamiliar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtViviendaVictima = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtServiciosBasicosVictima = new javax.swing.JTextArea();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtSituacionLaboralVictima = new javax.swing.JTextArea();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtIngresosVictima = new javax.swing.JTextArea();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtEgresosVictima = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtCapcidadesDestrezasVictima = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtSaludGrupofamiliarIngreso = new javax.swing.JTextArea();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtAfeccionesFrecuentes = new javax.swing.JTextArea();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtSituacionesEspeciales = new javax.swing.JTextArea();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtAccesoServicioSalud = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        txtEducacionVictima = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtSituacionViolenciaVictima = new javax.swing.JTextArea();
        jScrollPane17 = new javax.swing.JScrollPane();
        txtRiesgosVictima = new javax.swing.JTextArea();
        jLabel64 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        txtRecomendacionesVictima = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        datFechaIngreso = new com.toedter.calendar.JDateChooser();
        datFechaEgreso = new com.toedter.calendar.JDateChooser();
        txtNombresVictima = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtApellidosVictima = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCedulaVictima = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        datFechaNacimientoVictima = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FICHA DE DATOS INICIALES DE LA MUJER AACOGIDA");

        jLabel9.setText("Nacionalidad:");

        jLabel10.setText("Situación de movilidad humana:");

        radSituacionMovilidadVictimaSi.setText("Si");

        radSituacionMovilidadVictimaNo.setText("No");

        cbxSituacionMovilidadVictima.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Aplica", "Solicitante de refugio", "Refugiada", "Otra" }));

        jLabel11.setText("Direccion de domicilio:");

        jLabel12.setText("Provincia:");

        jLabel13.setText("Cantón:");

        jLabel14.setText("Parroquia:");

        jLabel15.setText("Área residencial:");

        radResidenciaVictimaUrbana.setText("Urbana");

        radResidenciaVictimaRural.setText("Rural");

        jLabel16.setText("Autoidentificación étnica cultural:");

        jLabel17.setText("Número de hij@s o familiares a cargo: ");

        spnNumeroHijosVictima.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel18.setText("¿Está embarazada?");

        radEmbarazadaVictimaSi.setText("Si");

        radEmbarazadaVictimaNo.setText("No");

        jLabel19.setText("meses");

        jLabel20.setText("¿Tiene discapacidad?");

        radDiscapacidadVictimaSi.setText("Si");

        radDiscapacidadVictimaNo.setText("No");

        jLabel21.setText("% de discapacidad");

        spnPorcentajeDiscapacidadVictima.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jLabel22.setText("Tipo de discapacidad:");

        jLabel23.setText("Descripción:");

        jLabel24.setText("Esatdo civil o tipo de ralación:");

        jLabel25.setText("Nivel de educación:");

        spnMesesEmbarazoVictima.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDomicilioVictima)
                        .addGap(159, 159, 159))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbxParroquiaVictima, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbxNacionalidadVictima, 0, 179, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbxProvinciaVictima, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxEtniaVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxEstadoCivilVictima, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxTipoDiscapacidadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radEmbarazadaVictimaSi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radEmbarazadaVictimaNo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(spnMesesEmbarazoVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCantonVictima, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(159, 159, 159))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radSituacionMovilidadVictimaNo)
                                    .addComponent(radSituacionMovilidadVictimaSi))
                                .addGap(18, 18, 18)
                                .addComponent(cbxSituacionMovilidadVictima, 0, 153, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radResidenciaVictimaUrbana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radResidenciaVictimaRural)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel20)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(radDiscapacidadVictimaSi)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(radDiscapacidadVictimaNo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(spnPorcentajeDiscapacidadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel21))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(spnNumeroHijosVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDescripcionDiscapacidadVictima)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxNivelEducacionVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radSituacionMovilidadVictimaSi)
                                .addComponent(cbxSituacionMovilidadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radSituacionMovilidadVictimaNo))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(cbxNacionalidadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDomicilioVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(cbxProvinciaVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCantonVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(cbxParroquiaVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radResidenciaVictimaUrbana)
                        .addComponent(radResidenciaVictimaRural)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbxEtniaVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(spnNumeroHijosVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(radEmbarazadaVictimaSi)
                    .addComponent(radEmbarazadaVictimaNo)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(radDiscapacidadVictimaSi)
                    .addComponent(radDiscapacidadVictimaNo)
                    .addComponent(jLabel21)
                    .addComponent(spnPorcentajeDiscapacidadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnMesesEmbarazoVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbxTipoDiscapacidadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtDescripcionDiscapacidadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(cbxNivelEducacionVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(cbxEstadoCivilVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );

        jTabbedPane1.addTab("1. Datos de identificación", jPanel2);

        cheTipoViolenciaPsicologica.setText("Psicológica");

        cheTipoViolenciaSexual.setText("Sexual (acoso, abuso, violación)");

        cheTipoViolenciaFemicidio.setText("Tentativa de femicidio");

        cheTipoViolenciaAbandono.setText("Abandono");

        cheTipoViolenciaPatrimonial.setText("Patrimonial o económica");

        cheTipoViolenciaFisica.setText("Física");

        jLabel26.setText("Tipo de violencia:");

        jLabel27.setText("Datos del agresor/a");

        jLabel28.setText("Nombres y apellidos:");

        jLabel29.setText("Edad:");

        spnEdadAgresor.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel30.setText("Parentesco:");

        jLabel31.setText("Nacionalidad:");

        jLabel32.setText("Situación de movilidad humana:");

        cbxSituacionMovilidadAgresor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solicitante de refugio", "Refugiada", "Otra" }));

        jLabel33.setText("Nivel de educación:");

        jLabel34.setText("Dirección de domicilio:");

        jLabel35.setText("Dirección de trabajo:");

        jLabel36.setText("Teléfono:");

        jLabel37.setText("Nivel de peligrosidad del agresor:");

        txtPeligrosidadAgresor.setColumns(20);
        txtPeligrosidadAgresor.setRows(5);
        jScrollPane1.setViewportView(txtPeligrosidadAgresor);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spnEdadAgresor))
                                    .addComponent(jLabel28))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtParentescoAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombresApellidosAgresor)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxNacionalidadAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cheTipoViolenciaFisica)
                                            .addComponent(cheTipoViolenciaPatrimonial))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cheTipoViolenciaAbandono)
                                            .addComponent(cheTipoViolenciaPsicologica))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cheTipoViolenciaFemicidio)
                                            .addComponent(cheTipoViolenciaSexual)))
                                    .addComponent(jLabel27))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSituacionMovilidadAgresor, 0, 147, Short.MAX_VALUE)
                        .addGap(452, 452, 452))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccionTrabajoAgresor))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxNivelEducacionAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccionDomicilioAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefonoAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cheTipoViolenciaFisica)
                    .addComponent(cheTipoViolenciaPsicologica)
                    .addComponent(cheTipoViolenciaSexual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cheTipoViolenciaAbandono)
                    .addComponent(cheTipoViolenciaFemicidio)
                    .addComponent(cheTipoViolenciaPatrimonial))
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtNombresApellidosAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(spnEdadAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtParentescoAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(cbxNacionalidadAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cbxSituacionMovilidadAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNivelEducacionAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(txtDireccionDomicilioAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtDireccionTrabajoAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(txtTelefonoAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("2. Datos de la violencia", jPanel3);

        jLabel38.setText("Nombres y apellidos de la víctima:");

        jLabel39.setText("Edad:");

        spnEdadVictima.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel40.setText("Fecha de nacimiento:");

        jLabel41.setText("Número de cédula:");

        jLabel42.setText("Fecha en la que cometió el delito:");

        jLabel43.setText("Fecha de fallecimiento (si aplica):");

        jLabel44.setText("Datos relevantes del hecho:");

        txtDatosRelevantes.setColumns(20);
        txtDatosRelevantes.setRows(5);
        jScrollPane2.setViewportView(txtDatosRelevantes);

        jLabel45.setText("¿Dónde ocurrió el hecho?");

        jLabel46.setText("Vulnerabiblidad de  la víctima antes y durante la agresción:");

        jLabel47.setText("Relación de la victima con el  agresor:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombresApellidosVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtaFechaNacimientoVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datFechaDelitoAVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnEdadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCedulaVictima2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datFechaFallecimientoVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVulneravilidadVictima))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLugarHecho))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel44)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRelcionVictimaAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtNombresApellidosVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(txtCedulaVictima2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39)
                        .addComponent(spnEdadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel40)
                    .addComponent(dtaFechaNacimientoVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(datFechaDelitoAVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(datFechaFallecimientoVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtLugarHecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtVulneravilidadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtRelcionVictimaAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("3. Registro de femicidios / Tentativa de femicidios", jPanel4);

        tabEstructuraFamiliar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres y apellidos", "Edad", "Relación", "Instrucción", "Escolaridad", "Ocupación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabEstructuraFamiliar.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabEstructuraFamiliar);
        if (tabEstructuraFamiliar.getColumnModel().getColumnCount() > 0) {
            tabEstructuraFamiliar.getColumnModel().getColumn(1).setResizable(false);
            tabEstructuraFamiliar.getColumnModel().getColumn(2).setResizable(false);
            tabEstructuraFamiliar.getColumnModel().getColumn(3).setResizable(false);
            tabEstructuraFamiliar.getColumnModel().getColumn(4).setResizable(false);
            tabEstructuraFamiliar.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel49.setText("Historia de vida y relaciones familiares:");

        txtHistoriaRelaciones.setColumns(20);
        txtHistoriaRelaciones.setRows(5);
        jScrollPane4.setViewportView(txtHistoriaRelaciones);

        btnAgregarFamiliar.setText("Agregar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarFamiliar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarFamiliar)
                .addGap(18, 18, 18)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("1. Estructura familiar", jPanel6);

        jLabel50.setText("Vivienda:");

        txtViviendaVictima.setColumns(20);
        txtViviendaVictima.setRows(5);
        jScrollPane5.setViewportView(txtViviendaVictima);

        txtServiciosBasicosVictima.setColumns(20);
        txtServiciosBasicosVictima.setRows(5);
        jScrollPane6.setViewportView(txtServiciosBasicosVictima);

        jLabel51.setText("Servicios básicos:");

        txtSituacionLaboralVictima.setColumns(20);
        txtSituacionLaboralVictima.setRows(5);
        jScrollPane7.setViewportView(txtSituacionLaboralVictima);

        jLabel56.setText("Situación laboral:");

        jLabel57.setText("Ingresos económicos:");

        txtIngresosVictima.setColumns(20);
        txtIngresosVictima.setRows(5);
        jScrollPane8.setViewportView(txtIngresosVictima);

        jLabel58.setText("Egresos:");

        txtEgresosVictima.setColumns(20);
        txtEgresosVictima.setRows(5);
        jScrollPane9.setViewportView(txtEgresosVictima);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane8)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("2. Situcación económica", jPanel7);

        txtCapcidadesDestrezasVictima.setColumns(20);
        txtCapcidadesDestrezasVictima.setRows(5);
        jScrollPane10.setViewportView(txtCapcidadesDestrezasVictima);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("3. Capacidades y destrezas", jPanel8);

        jLabel59.setText("Situación de salud del grupo familiar al momento del ingreso:");

        txtSaludGrupofamiliarIngreso.setColumns(20);
        txtSaludGrupofamiliarIngreso.setRows(5);
        jScrollPane11.setViewportView(txtSaludGrupofamiliarIngreso);

        jLabel60.setText("Afecciones frecuentes:");

        txtAfeccionesFrecuentes.setColumns(20);
        txtAfeccionesFrecuentes.setRows(5);
        jScrollPane12.setViewportView(txtAfeccionesFrecuentes);

        jLabel61.setText("Situcaciones especiales:");

        txtSituacionesEspeciales.setColumns(20);
        txtSituacionesEspeciales.setRows(5);
        jScrollPane13.setViewportView(txtSituacionesEspeciales);

        jLabel62.setText("Acceso a servicios de salud:");

        txtAccesoServicioSalud.setColumns(20);
        txtAccesoServicioSalud.setRows(5);
        jScrollPane14.setViewportView(txtAccesoServicioSalud);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11)
                    .addComponent(jScrollPane12)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("4. Salud del grupo familiar", jPanel9);

        txtEducacionVictima.setColumns(20);
        txtEducacionVictima.setRows(5);
        jScrollPane15.setViewportView(txtEducacionVictima);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("5. Educación", jPanel10);

        jLabel63.setText("Situaciones de violencia");

        txtSituacionViolenciaVictima.setColumns(20);
        txtSituacionViolenciaVictima.setRows(5);
        jScrollPane16.setViewportView(txtSituacionViolenciaVictima);

        txtRiesgosVictima.setColumns(20);
        txtRiesgosVictima.setRows(5);
        jScrollPane17.setViewportView(txtRiesgosVictima);

        jLabel64.setText("Riesgos:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addComponent(jLabel64))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane16))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("6. Situaciones de atención", jPanel11);

        txtRecomendacionesVictima.setColumns(20);
        txtRecomendacionesVictima.setRows(5);
        jScrollPane18.setViewportView(txtRecomendacionesVictima);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("7. Recomendaciones", jPanel12);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("4. Ficha socioeconómica", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setText("Fecha de ingreso:");

        jLabel3.setText("Fecha de egreso:");

        btnGuardar.setText("GUARDAR");

        jLabel4.setText("Nombres:");

        jLabel5.setText("Apellidos:");

        jLabel6.setText("Número de cédula:");

        jLabel7.setText("Fecha de nacimiento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombresVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidosVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datFechaNacimientoVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datFechaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCedulaVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(datFechaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCedulaVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(datFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtNombresVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtApellidosVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(datFechaNacimientoVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(VistaDatosIniciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaDatosIniciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaDatosIniciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaDatosIniciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaDatosIniciales().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFamiliar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxCantonVictima;
    private javax.swing.JComboBox<String> cbxEstadoCivilVictima;
    private javax.swing.JComboBox<String> cbxEtniaVictima;
    private javax.swing.JComboBox<String> cbxNacionalidadAgresor;
    private javax.swing.JComboBox<String> cbxNacionalidadVictima;
    private javax.swing.JComboBox<String> cbxNivelEducacionAgresor;
    private javax.swing.JComboBox<String> cbxNivelEducacionVictima;
    private javax.swing.JComboBox<String> cbxParroquiaVictima;
    private javax.swing.JComboBox<String> cbxProvinciaVictima;
    private javax.swing.JComboBox<String> cbxSituacionMovilidadAgresor;
    private javax.swing.JComboBox<String> cbxSituacionMovilidadVictima;
    private javax.swing.JComboBox<String> cbxTipoDiscapacidadVictima;
    private javax.swing.JCheckBox cheTipoViolenciaAbandono;
    private javax.swing.JCheckBox cheTipoViolenciaFemicidio;
    private javax.swing.JCheckBox cheTipoViolenciaFisica;
    private javax.swing.JCheckBox cheTipoViolenciaPatrimonial;
    private javax.swing.JCheckBox cheTipoViolenciaPsicologica;
    private javax.swing.JCheckBox cheTipoViolenciaSexual;
    private com.toedter.calendar.JDateChooser datFechaDelitoAVictima;
    private com.toedter.calendar.JDateChooser datFechaEgreso;
    private com.toedter.calendar.JDateChooser datFechaFallecimientoVictima;
    private com.toedter.calendar.JDateChooser datFechaIngreso;
    private com.toedter.calendar.JDateChooser datFechaNacimientoVictima;
    private com.toedter.calendar.JDateChooser dtaFechaNacimientoVictima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton radDiscapacidadVictimaNo;
    private javax.swing.JRadioButton radDiscapacidadVictimaSi;
    private javax.swing.JRadioButton radEmbarazadaVictimaNo;
    private javax.swing.JRadioButton radEmbarazadaVictimaSi;
    private javax.swing.JRadioButton radResidenciaVictimaRural;
    private javax.swing.JRadioButton radResidenciaVictimaUrbana;
    private javax.swing.JRadioButton radSituacionMovilidadVictimaNo;
    private javax.swing.JRadioButton radSituacionMovilidadVictimaSi;
    private javax.swing.JSpinner spnEdadAgresor;
    private javax.swing.JSpinner spnEdadVictima;
    private javax.swing.JSpinner spnMesesEmbarazoVictima;
    private javax.swing.JSpinner spnNumeroHijosVictima;
    private javax.swing.JSpinner spnPorcentajeDiscapacidadVictima;
    private javax.swing.JTable tabEstructuraFamiliar;
    private javax.swing.JTextArea txtAccesoServicioSalud;
    private javax.swing.JTextArea txtAfeccionesFrecuentes;
    private javax.swing.JTextField txtApellidosVictima;
    private javax.swing.JTextArea txtCapcidadesDestrezasVictima;
    private javax.swing.JTextField txtCedulaVictima;
    private javax.swing.JTextField txtCedulaVictima2;
    private javax.swing.JTextArea txtDatosRelevantes;
    private javax.swing.JTextField txtDescripcionDiscapacidadVictima;
    private javax.swing.JTextField txtDireccionDomicilioAgresor;
    private javax.swing.JTextField txtDireccionTrabajoAgresor;
    private javax.swing.JTextField txtDomicilioVictima;
    private javax.swing.JTextArea txtEducacionVictima;
    private javax.swing.JTextArea txtEgresosVictima;
    private javax.swing.JTextArea txtHistoriaRelaciones;
    private javax.swing.JTextArea txtIngresosVictima;
    private javax.swing.JTextField txtLugarHecho;
    private javax.swing.JTextField txtNombresApellidosAgresor;
    private javax.swing.JTextField txtNombresApellidosVictima;
    private javax.swing.JTextField txtNombresVictima;
    private javax.swing.JTextField txtParentescoAgresor;
    private javax.swing.JTextArea txtPeligrosidadAgresor;
    private javax.swing.JTextArea txtRecomendacionesVictima;
    private javax.swing.JTextField txtRelcionVictimaAgresor;
    private javax.swing.JTextArea txtRiesgosVictima;
    private javax.swing.JTextArea txtSaludGrupofamiliarIngreso;
    private javax.swing.JTextArea txtServiciosBasicosVictima;
    private javax.swing.JTextArea txtSituacionLaboralVictima;
    private javax.swing.JTextArea txtSituacionViolenciaVictima;
    private javax.swing.JTextArea txtSituacionesEspeciales;
    private javax.swing.JTextField txtTelefonoAgresor;
    private javax.swing.JTextArea txtViviendaVictima;
    private javax.swing.JTextField txtVulneravilidadVictima;
    // End of variables declaration//GEN-END:variables
}

