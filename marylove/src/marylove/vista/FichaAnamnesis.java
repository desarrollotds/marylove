/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class FichaAnamnesis extends javax.swing.JFrame {

    /**
     * Creates new form FichaAnamnesis
     */
    public FichaAnamnesis() {
        initComponents();
    }

    public JButton getBtnAñadir() {
        return btnAñadir;
    }

    public void setBtnAñadir(JButton btnAñadir) {
        this.btnAñadir = btnAñadir;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JComboBox<String> getCbxEmbarazoPlanificado() {
        return cbxEmbarazoPlanificado;
    }

    public void setCbxEmbarazoPlanificado(JComboBox<String> cbxEmbarazoPlanificado) {
        this.cbxEmbarazoPlanificado = cbxEmbarazoPlanificado;
    }

    public JComboBox<String> getCbxPadreAgresor() {
        return cbxPadreAgresor;
    }

    public void setCbxPadreAgresor(JComboBox<String> cbxPadreAgresor) {
        this.cbxPadreAgresor = cbxPadreAgresor;
    }

    public JComboBox<String> getCbxPoseeCedula() {
        return cbxPoseeCedula;
    }

    public void setCbxPoseeCedula(JComboBox<String> cbxPoseeCedula) {
        this.cbxPoseeCedula = cbxPoseeCedula;
    }

    public JCheckBox getJcxAbusoSexual() {
        return jcxAbusoSexual;
    }

    public void setJcxAbusoSexual(JCheckBox jcxAbusoSexual) {
        this.jcxAbusoSexual = jcxAbusoSexual;
    }

    public JCheckBox getJcxAlcohol() {
        return jcxAlcohol;
    }

    public void setJcxAlcohol(JCheckBox jcxAlcohol) {
        this.jcxAlcohol = jcxAlcohol;
    }

    public JCheckBox getJcxAlcoholismo() {
        return jcxAlcoholismo;
    }

    public void setJcxAlcoholismo(JCheckBox jcxAlcoholismo) {
        this.jcxAlcoholismo = jcxAlcoholismo;
    }

    public JCheckBox getJcxAmbitoLaboral() {
        return jcxAmbitoLaboral;
    }

    public void setJcxAmbitoLaboral(JCheckBox jcxAmbitoLaboral) {
        this.jcxAmbitoLaboral = jcxAmbitoLaboral;
    }

    public JCheckBox getJcxAmbos() {
        return jcxAmbos;
    }

    public void setJcxAmbos(JCheckBox jcxAmbos) {
        this.jcxAmbos = jcxAmbos;
    }

    public JCheckBox getJcxBajoPeso() {
        return jcxBajoPeso;
    }

    public void setJcxBajoPeso(JCheckBox jcxBajoPeso) {
        this.jcxBajoPeso = jcxBajoPeso;
    }

    public JCheckBox getJcxCesarea() {
        return jcxCesarea;
    }

    public void setJcxCesarea(JCheckBox jcxCesarea) {
        this.jcxCesarea = jcxCesarea;
    }

    public JCheckBox getJcxClaro() {
        return jcxClaro;
    }

    public void setJcxClaro(JCheckBox jcxClaro) {
        this.jcxClaro = jcxClaro;
    }

    public JCheckBox getJcxDepresion() {
        return jcxDepresion;
    }

    public void setJcxDepresion(JCheckBox jcxDepresion) {
        this.jcxDepresion = jcxDepresion;
    }

    public JCheckBox getJcxDiscapacidadIntelectual() {
        return jcxDiscapacidadIntelectual;
    }

    public void setJcxDiscapacidadIntelectual(JCheckBox jcxDiscapacidadIntelectual) {
        this.jcxDiscapacidadIntelectual = jcxDiscapacidadIntelectual;
    }

    public JCheckBox getJcxDroga() {
        return jcxDroga;
    }

    public void setJcxDroga(JCheckBox jcxDroga) {
        this.jcxDroga = jcxDroga;
    }

    public JCheckBox getJcxEpilepsia() {
        return jcxEpilepsia;
    }

    public void setJcxEpilepsia(JCheckBox jcxEpilepsia) {
        this.jcxEpilepsia = jcxEpilepsia;
    }

    public JCheckBox getJcxGolpes() {
        return jcxGolpes;
    }

    public void setJcxGolpes(JCheckBox jcxGolpes) {
        this.jcxGolpes = jcxGolpes;
    }

    public JCheckBox getJcxHemorragias() {
        return jcxHemorragias;
    }

    public void setJcxHemorragias(JCheckBox jcxHemorragias) {
        this.jcxHemorragias = jcxHemorragias;
    }

    public JCheckBox getJcxHipersencibilidad() {
        return jcxHipersencibilidad;
    }

    public void setJcxHipersencibilidad(JCheckBox jcxHipersencibilidad) {
        this.jcxHipersencibilidad = jcxHipersencibilidad;
    }

    public JCheckBox getJcxInfecciones() {
        return jcxInfecciones;
    }

    public void setJcxInfecciones(JCheckBox jcxInfecciones) {
        this.jcxInfecciones = jcxInfecciones;
    }

    public JCheckBox getJcxInsultos() {
        return jcxInsultos;
    }

    public void setJcxInsultos(JCheckBox jcxInsultos) {
        this.jcxInsultos = jcxInsultos;
    }

    public JCheckBox getJcxIrregularMotorFino() {
        return jcxIrregularMotorFino;
    }

    public void setJcxIrregularMotorFino(JCheckBox jcxIrregularMotorFino) {
        this.jcxIrregularMotorFino = jcxIrregularMotorFino;
    }

    public JCheckBox getJcxIrregularMotorGrueso() {
        return jcxIrregularMotorGrueso;
    }

    public void setJcxIrregularMotorGrueso(JCheckBox jcxIrregularMotorGrueso) {
        this.jcxIrregularMotorGrueso = jcxIrregularMotorGrueso;
    }

    public JCheckBox getJcxMensual() {
        return jcxMensual;
    }

    public void setJcxMensual(JCheckBox jcxMensual) {
        this.jcxMensual = jcxMensual;
    }

    public JCheckBox getJcxNegligencia() {
        return jcxNegligencia;
    }

    public void setJcxNegligencia(JCheckBox jcxNegligencia) {
        this.jcxNegligencia = jcxNegligencia;
    }

    public JCheckBox getJcxNinguna() {
        return jcxNinguna;
    }

    public void setJcxNinguna(JCheckBox jcxNinguna) {
        this.jcxNinguna = jcxNinguna;
    }

    public JCheckBox getJcxNoAborto() {
        return jcxNoAborto;
    }

    public void setJcxNoAborto(JCheckBox jcxNoAborto) {
        this.jcxNoAborto = jcxNoAborto;
    }

    public JCheckBox getJcxNoAgrede() {
        return jcxNoAgrede;
    }

    public void setJcxNoAgrede(JCheckBox jcxNoAgrede) {
        this.jcxNoAgrede = jcxNoAgrede;
    }

    public JCheckBox getJcxNoAlergias() {
        return jcxNoAlergias;
    }

    public void setJcxNoAlergias(JCheckBox jcxNoAlergias) {
        this.jcxNoAlergias = jcxNoAlergias;
    }

    public JCheckBox getJcxNoAnestesia() {
        return jcxNoAnestesia;
    }

    public void setJcxNoAnestesia(JCheckBox jcxNoAnestesia) {
        this.jcxNoAnestesia = jcxNoAnestesia;
    }

    public JCheckBox getJcxNoAprendizaje() {
        return jcxNoAprendizaje;
    }

    public void setJcxNoAprendizaje(JCheckBox jcxNoAprendizaje) {
        this.jcxNoAprendizaje = jcxNoAprendizaje;
    }

    public JCheckBox getJcxNoAyudaBanho() {
        return jcxNoAyudaBanho;
    }

    public void setJcxNoAyudaBanho(JCheckBox jcxNoAyudaBanho) {
        this.jcxNoAyudaBanho = jcxNoAyudaBanho;
    }

    public JCheckBox getJcxNoBiberon() {
        return jcxNoBiberon;
    }

    public void setJcxNoBiberon(JCheckBox jcxNoBiberon) {
        this.jcxNoBiberon = jcxNoBiberon;
    }

    public JCheckBox getJcxNoComplicaciones() {
        return jcxNoComplicaciones;
    }

    public void setJcxNoComplicaciones(JCheckBox jcxNoComplicaciones) {
        this.jcxNoComplicaciones = jcxNoComplicaciones;
    }

    public JCheckBox getJcxNoConsume() {
        return jcxNoConsume;
    }

    public void setJcxNoConsume(JCheckBox jcxNoConsume) {
        this.jcxNoConsume = jcxNoConsume;
    }

    public JCheckBox getJcxNoControles() {
        return jcxNoControles;
    }

    public void setJcxNoControles(JCheckBox jcxNoControles) {
        this.jcxNoControles = jcxNoControles;
    }

    public JCheckBox getJcxNoDuerme() {
        return jcxNoDuerme;
    }

    public void setJcxNoDuerme(JCheckBox jcxNoDuerme) {
        this.jcxNoDuerme = jcxNoDuerme;
    }

    public JCheckBox getJcxNoEcopresis() {
        return jcxNoEcopresis;
    }

    public void setJcxNoEcopresis(JCheckBox jcxNoEcopresis) {
        this.jcxNoEcopresis = jcxNoEcopresis;
    }

    public JCheckBox getJcxNoEstudia() {
        return jcxNoEstudia;
    }

    public void setJcxNoEstudia(JCheckBox jcxNoEstudia) {
        this.jcxNoEstudia = jcxNoEstudia;
    }

    public JCheckBox getJcxNoLeche() {
        return jcxNoLeche;
    }

    public void setJcxNoLeche(JCheckBox jcxNoLeche) {
        this.jcxNoLeche = jcxNoLeche;
    }

    public JCheckBox getJcxNoLloro() {
        return jcxNoLloro;
    }

    public void setJcxNoLloro(JCheckBox jcxNoLloro) {
        this.jcxNoLloro = jcxNoLloro;
    }

    public JCheckBox getJcxNoMiedoDormir() {
        return jcxNoMiedoDormir;
    }

    public void setJcxNoMiedoDormir(JCheckBox jcxNoMiedoDormir) {
        this.jcxNoMiedoDormir = jcxNoMiedoDormir;
    }

    public JCheckBox getJcxNoMojaCama() {
        return jcxNoMojaCama;
    }

    public void setJcxNoMojaCama(JCheckBox jcxNoMojaCama) {
        this.jcxNoMojaCama = jcxNoMojaCama;
    }

    public JCheckBox getJcxNoMuyClaro() {
        return jcxNoMuyClaro;
    }

    public void setJcxNoMuyClaro(JCheckBox jcxNoMuyClaro) {
        this.jcxNoMuyClaro = jcxNoMuyClaro;
    }

    public JCheckBox getJcxNoNerviosos() {
        return jcxNoNerviosos;
    }

    public void setJcxNoNerviosos(JCheckBox jcxNoNerviosos) {
        this.jcxNoNerviosos = jcxNoNerviosos;
    }

    public JCheckBox getJcxNoNeurologicos() {
        return jcxNoNeurologicos;
    }

    public void setJcxNoNeurologicos(JCheckBox jcxNoNeurologicos) {
        this.jcxNoNeurologicos = jcxNoNeurologicos;
    }

    public JCheckBox getJcxNoNivelacion() {
        return jcxNoNivelacion;
    }

    public void setJcxNoNivelacion(JCheckBox jcxNoNivelacion) {
        this.jcxNoNivelacion = jcxNoNivelacion;
    }

    public JCheckBox getJcxNoOxigeno() {
        return jcxNoOxigeno;
    }

    public void setJcxNoOxigeno(JCheckBox jcxNoOxigeno) {
        this.jcxNoOxigeno = jcxNoOxigeno;
    }

    public JCheckBox getJcxNoPesadillas() {
        return jcxNoPesadillas;
    }

    public void setJcxNoPesadillas(JCheckBox jcxNoPesadillas) {
        this.jcxNoPesadillas = jcxNoPesadillas;
    }

    public JCheckBox getJcxNoProblemasRespiratorios() {
        return jcxNoProblemasRespiratorios;
    }

    public void setJcxNoProblemasRespiratorios(JCheckBox jcxNoProblemasRespiratorios) {
        this.jcxNoProblemasRespiratorios = jcxNoProblemasRespiratorios;
    }

    public JCheckBox getJcxNoSeEntiende() {
        return jcxNoSeEntiende;
    }

    public void setJcxNoSeEntiende(JCheckBox jcxNoSeEntiende) {
        this.jcxNoSeEntiende = jcxNoSeEntiende;
    }

    public JCheckBox getJcxNoSexo() {
        return jcxNoSexo;
    }

    public void setJcxNoSexo(JCheckBox jcxNoSexo) {
        this.jcxNoSexo = jcxNoSexo;
    }

    public JCheckBox getJcxNoSuccionar() {
        return jcxNoSuccionar;
    }

    public void setJcxNoSuccionar(JCheckBox jcxNoSuccionar) {
        this.jcxNoSuccionar = jcxNoSuccionar;
    }

    public JCheckBox getJcxNoTrabajo() {
        return jcxNoTrabajo;
    }

    public void setJcxNoTrabajo(JCheckBox jcxNoTrabajo) {
        this.jcxNoTrabajo = jcxNoTrabajo;
    }

    public JCheckBox getJcxNoViolencia() {
        return jcxNoViolencia;
    }

    public void setJcxNoViolencia(JCheckBox jcxNoViolencia) {
        this.jcxNoViolencia = jcxNoViolencia;
    }

    public JCheckBox getJcxNormal() {
        return jcxNormal;
    }

    public void setJcxNormal(JCheckBox jcxNormal) {
        this.jcxNormal = jcxNormal;
    }

    public JCheckBox getJcxNormalMotorFino() {
        return jcxNormalMotorFino;
    }

    public void setJcxNormalMotorFino(JCheckBox jcxNormalMotorFino) {
        this.jcxNormalMotorFino = jcxNormalMotorFino;
    }

    public JCheckBox getJcxNormalMotorGrueso() {
        return jcxNormalMotorGrueso;
    }

    public void setJcxNormalMotorGrueso(JCheckBox jcxNormalMotorGrueso) {
        this.jcxNormalMotorGrueso = jcxNormalMotorGrueso;
    }

    public JCheckBox getJcxPreclansia() {
        return jcxPreclansia;
    }

    public void setJcxPreclansia(JCheckBox jcxPreclansia) {
        this.jcxPreclansia = jcxPreclansia;
    }

    public JCheckBox getJcxSiAborto() {
        return jcxSiAborto;
    }

    public void setJcxSiAborto(JCheckBox jcxSiAborto) {
        this.jcxSiAborto = jcxSiAborto;
    }

    public JCheckBox getJcxSiAgrede() {
        return jcxSiAgrede;
    }

    public void setJcxSiAgrede(JCheckBox jcxSiAgrede) {
        this.jcxSiAgrede = jcxSiAgrede;
    }

    public JCheckBox getJcxSiAlergias() {
        return jcxSiAlergias;
    }

    public void setJcxSiAlergias(JCheckBox jcxSiAlergias) {
        this.jcxSiAlergias = jcxSiAlergias;
    }

    public JCheckBox getJcxSiAnestesia() {
        return jcxSiAnestesia;
    }

    public void setJcxSiAnestesia(JCheckBox jcxSiAnestesia) {
        this.jcxSiAnestesia = jcxSiAnestesia;
    }

    public JCheckBox getJcxSiAprendizaje() {
        return jcxSiAprendizaje;
    }

    public void setJcxSiAprendizaje(JCheckBox jcxSiAprendizaje) {
        this.jcxSiAprendizaje = jcxSiAprendizaje;
    }

    public JCheckBox getJcxSiAyudaBanho() {
        return jcxSiAyudaBanho;
    }

    public void setJcxSiAyudaBanho(JCheckBox jcxSiAyudaBanho) {
        this.jcxSiAyudaBanho = jcxSiAyudaBanho;
    }

    public JCheckBox getJcxSiBiberon() {
        return jcxSiBiberon;
    }

    public void setJcxSiBiberon(JCheckBox jcxSiBiberon) {
        this.jcxSiBiberon = jcxSiBiberon;
    }

    public JCheckBox getJcxSiComplicaciones() {
        return jcxSiComplicaciones;
    }

    public void setJcxSiComplicaciones(JCheckBox jcxSiComplicaciones) {
        this.jcxSiComplicaciones = jcxSiComplicaciones;
    }

    public JCheckBox getJcxSiConsume() {
        return jcxSiConsume;
    }

    public void setJcxSiConsume(JCheckBox jcxSiConsume) {
        this.jcxSiConsume = jcxSiConsume;
    }

    public JCheckBox getJcxSiControles() {
        return jcxSiControles;
    }

    public void setJcxSiControles(JCheckBox jcxSiControles) {
        this.jcxSiControles = jcxSiControles;
    }

    public JCheckBox getJcxSiDuerme() {
        return jcxSiDuerme;
    }

    public void setJcxSiDuerme(JCheckBox jcxSiDuerme) {
        this.jcxSiDuerme = jcxSiDuerme;
    }

    public JCheckBox getJcxSiEcopresis() {
        return jcxSiEcopresis;
    }

    public void setJcxSiEcopresis(JCheckBox jcxSiEcopresis) {
        this.jcxSiEcopresis = jcxSiEcopresis;
    }

    public JCheckBox getJcxSiEstudia() {
        return jcxSiEstudia;
    }

    public void setJcxSiEstudia(JCheckBox jcxSiEstudia) {
        this.jcxSiEstudia = jcxSiEstudia;
    }

    public JCheckBox getJcxSiLeche() {
        return jcxSiLeche;
    }

    public void setJcxSiLeche(JCheckBox jcxSiLeche) {
        this.jcxSiLeche = jcxSiLeche;
    }

    public JCheckBox getJcxSiLloro() {
        return jcxSiLloro;
    }

    public void setJcxSiLloro(JCheckBox jcxSiLloro) {
        this.jcxSiLloro = jcxSiLloro;
    }

    public JCheckBox getJcxSiMiedoDormir() {
        return jcxSiMiedoDormir;
    }

    public void setJcxSiMiedoDormir(JCheckBox jcxSiMiedoDormir) {
        this.jcxSiMiedoDormir = jcxSiMiedoDormir;
    }

    public JCheckBox getJcxSiMojaCama() {
        return jcxSiMojaCama;
    }

    public void setJcxSiMojaCama(JCheckBox jcxSiMojaCama) {
        this.jcxSiMojaCama = jcxSiMojaCama;
    }

    public JCheckBox getJcxSiNerviosos() {
        return jcxSiNerviosos;
    }

    public void setJcxSiNerviosos(JCheckBox jcxSiNerviosos) {
        this.jcxSiNerviosos = jcxSiNerviosos;
    }

    public JCheckBox getJcxSiNeurologicos() {
        return jcxSiNeurologicos;
    }

    public void setJcxSiNeurologicos(JCheckBox jcxSiNeurologicos) {
        this.jcxSiNeurologicos = jcxSiNeurologicos;
    }

    public JCheckBox getJcxSiNivelacion() {
        return jcxSiNivelacion;
    }

    public void setJcxSiNivelacion(JCheckBox jcxSiNivelacion) {
        this.jcxSiNivelacion = jcxSiNivelacion;
    }

    public JCheckBox getJcxSiOxigeno() {
        return jcxSiOxigeno;
    }

    public void setJcxSiOxigeno(JCheckBox jcxSiOxigeno) {
        this.jcxSiOxigeno = jcxSiOxigeno;
    }

    public JCheckBox getJcxSiPesadillas() {
        return jcxSiPesadillas;
    }

    public void setJcxSiPesadillas(JCheckBox jcxSiPesadillas) {
        this.jcxSiPesadillas = jcxSiPesadillas;
    }

    public JCheckBox getJcxSiProblemasRespiratorios() {
        return jcxSiProblemasRespiratorios;
    }

    public void setJcxSiProblemasRespiratorios(JCheckBox jcxSiProblemasRespiratorios) {
        this.jcxSiProblemasRespiratorios = jcxSiProblemasRespiratorios;
    }

    public JCheckBox getJcxSiSexo() {
        return jcxSiSexo;
    }

    public void setJcxSiSexo(JCheckBox jcxSiSexo) {
        this.jcxSiSexo = jcxSiSexo;
    }

    public JCheckBox getJcxSiSuccionar() {
        return jcxSiSuccionar;
    }

    public void setJcxSiSuccionar(JCheckBox jcxSiSuccionar) {
        this.jcxSiSuccionar = jcxSiSuccionar;
    }

    public JCheckBox getJcxSiTrabajo() {
        return jcxSiTrabajo;
    }

    public void setJcxSiTrabajo(JCheckBox jcxSiTrabajo) {
        this.jcxSiTrabajo = jcxSiTrabajo;
    }

    public JCheckBox getJcxSiViolencia() {
        return jcxSiViolencia;
    }

    public void setJcxSiViolencia(JCheckBox jcxSiViolencia) {
        this.jcxSiViolencia = jcxSiViolencia;
    }

    public JCheckBox getJcxSindromeDown() {
        return jcxSindromeDown;
    }

    public void setJcxSindromeDown(JCheckBox jcxSindromeDown) {
        this.jcxSindromeDown = jcxSindromeDown;
    }

    public JCheckBox getJcxTabaco() {
        return jcxTabaco;
    }

    public void setJcxTabaco(JCheckBox jcxTabaco) {
        this.jcxTabaco = jcxTabaco;
    }

    public JCheckBox getJcxTrimestral() {
        return jcxTrimestral;
    }

    public void setJcxTrimestral(JCheckBox jcxTrimestral) {
        this.jcxTrimestral = jcxTrimestral;
    }

    public JCheckBox getJcxUnaVez() {
        return jcxUnaVez;
    }

    public void setJcxUnaVez(JCheckBox jcxUnaVez) {
        this.jcxUnaVez = jcxUnaVez;
    }

    public JDateChooser getJdcFechaElaboracion() {
        return jdcFechaElaboracion;
    }

    public void setJdcFechaElaboracion(JDateChooser jdcFechaElaboracion) {
        this.jdcFechaElaboracion = jdcFechaElaboracion;
    }

    public JDateChooser getJdcFechaNacimientoNNA() {
        return jdcFechaNacimientoNNA;
    }

    public void setJdcFechaNacimientoNNA(JDateChooser jdcFechaNacimientoNNA) {
        this.jdcFechaNacimientoNNA = jdcFechaNacimientoNNA;
    }

    public JTabbedPane getJtpPrincipal() {
        return jtpPrincipal;
    }

    public void setJtpPrincipal(JTabbedPane jtpPrincipal) {
        this.jtpPrincipal = jtpPrincipal;
    }

    public JPanel getPanelAlimentacionActual() {
        return panelAlimentacionActual;
    }

    public void setPanelAlimentacionActual(JPanel panelAlimentacionActual) {
        this.panelAlimentacionActual = panelAlimentacionActual;
    }

    public JPanel getPanelComposicionFamiliar() {
        return panelComposicionFamiliar;
    }

    public void setPanelComposicionFamiliar(JPanel panelComposicionFamiliar) {
        this.panelComposicionFamiliar = panelComposicionFamiliar;
    }

    public JPanel getPanelCondicionesNacimiento() {
        return panelCondicionesNacimiento;
    }

    public void setPanelCondicionesNacimiento(JPanel panelCondicionesNacimiento) {
        this.panelCondicionesNacimiento = panelCondicionesNacimiento;
    }

    public JPanel getPanelDatosIdentificacion() {
        return panelDatosIdentificacion;
    }

    public void setPanelDatosIdentificacion(JPanel panelDatosIdentificacion) {
        this.panelDatosIdentificacion = panelDatosIdentificacion;
    }

    public JPanel getPanelDatosMadrePadre() {
        return panelDatosMadrePadre;
    }

    public void setPanelDatosMadrePadre(JPanel panelDatosMadrePadre) {
        this.panelDatosMadrePadre = panelDatosMadrePadre;
    }

    public JPanel getPanelDesarrolloMotorLenguaje() {
        return panelDesarrolloMotorLenguaje;
    }

    public void setPanelDesarrolloMotorLenguaje(JPanel panelDesarrolloMotorLenguaje) {
        this.panelDesarrolloMotorLenguaje = panelDesarrolloMotorLenguaje;
    }

    public JPanel getPanelEscolarizacionNNA() {
        return panelEscolarizacionNNA;
    }

    public void setPanelEscolarizacionNNA(JPanel panelEscolarizacionNNA) {
        this.panelEscolarizacionNNA = panelEscolarizacionNNA;
    }

    public JPanel getPanelFondo() {
        return panelFondo;
    }

    public void setPanelFondo(JPanel panelFondo) {
        this.panelFondo = panelFondo;
    }

    public JPanel getPanelObservacionesGenerales() {
        return panelObservacionesGenerales;
    }

    public void setPanelObservacionesGenerales(JPanel panelObservacionesGenerales) {
        this.panelObservacionesGenerales = panelObservacionesGenerales;
    }

    public JPanel getPanelPeriodoEmbarazo() {
        return panelPeriodoEmbarazo;
    }

    public void setPanelPeriodoEmbarazo(JPanel panelPeriodoEmbarazo) {
        this.panelPeriodoEmbarazo = panelPeriodoEmbarazo;
    }

    public JPanel getPanelPrimerosDiaVida() {
        return panelPrimerosDiaVida;
    }

    public void setPanelPrimerosDiaVida(JPanel panelPrimerosDiaVida) {
        this.panelPrimerosDiaVida = panelPrimerosDiaVida;
    }

    public JPanel getPanelRelacionFamiliar() {
        return panelRelacionFamiliar;
    }

    public void setPanelRelacionFamiliar(JPanel panelRelacionFamiliar) {
        this.panelRelacionFamiliar = panelRelacionFamiliar;
    }

    public JPanel getPanelSalud() {
        return panelSalud;
    }

    public void setPanelSalud(JPanel panelSalud) {
        this.panelSalud = panelSalud;
    }

    public JPanel getPanelSueñoEsfinteres() {
        return panelSueñoEsfinteres;
    }

    public void setPanelSueñoEsfinteres(JPanel panelSueñoEsfinteres) {
        this.panelSueñoEsfinteres = panelSueñoEsfinteres;
    }

    public JTable getTabComposicionFamiliarNNA() {
        return tabComposicionFamiliarNNA;
    }

    public void setTabComposicionFamiliarNNA(JTable tabComposicionFamiliarNNA) {
        this.tabComposicionFamiliarNNA = tabComposicionFamiliarNNA;
    }

    public JTextArea getTxAObservaciones() {
        return txAObservaciones;
    }

    public void setTxAObservaciones(JTextArea txAObservaciones) {
        this.txAObservaciones = txAObservaciones;
    }

    public JTextArea getTxaSituacionIngresaNNA() {
        return txaSituacionIngresaNNA;
    }

    public void setTxaSituacionIngresaNNA(JTextArea txaSituacionIngresaNNA) {
        this.txaSituacionIngresaNNA = txaSituacionIngresaNNA;
    }

    public JTextField getTxtActitudMadre() {
        return txtActitudMadre;
    }

    public void setTxtActitudMadre(JTextField txtActitudMadre) {
        this.txtActitudMadre = txtActitudMadre;
    }

    public JTextField getTxtAnhoCursa() {
        return txtAnhoCursa;
    }

    public void setTxtAnhoCursa(JTextField txtAnhoCursa) {
        this.txtAnhoCursa = txtAnhoCursa;
    }

    public JTextField getTxtAnhoRepite() {
        return txtAnhoRepite;
    }

    public void setTxtAnhoRepite(JTextField txtAnhoRepite) {
        this.txtAnhoRepite = txtAnhoRepite;
    }

    public JTextField getTxtCausaEcopresis() {
        return txtCausaEcopresis;
    }

    public void setTxtCausaEcopresis(JTextField txtCausaEcopresis) {
        this.txtCausaEcopresis = txtCausaEcopresis;
    }

    public JTextField getTxtCausasAborto() {
        return txtCausasAborto;
    }

    public void setTxtCausasAborto(JTextField txtCausasAborto) {
        this.txtCausasAborto = txtCausasAborto;
    }

    public JTextField getTxtCausasConsumo() {
        return txtCausasConsumo;
    }

    public void setTxtCausasConsumo(JTextField txtCausasConsumo) {
        this.txtCausasConsumo = txtCausasConsumo;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtClimaFamiliar() {
        return txtClimaFamiliar;
    }

    public void setTxtClimaFamiliar(JTextField txtClimaFamiliar) {
        this.txtClimaFamiliar = txtClimaFamiliar;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JTextField getTxtCognitivo() {
        return txtCognitivo;
    }

    public void setTxtCognitivo(JTextField txtCognitivo) {
        this.txtCognitivo = txtCognitivo;
    }

    public JTextField getTxtComeSolooAcompanhado() {
        return txtComeSolooAcompanhado;
    }

    public void setTxtComeSolooAcompanhado(JTextField txtComeSolooAcompanhado) {
        this.txtComeSolooAcompanhado = txtComeSolooAcompanhado;
    }

    public JTextField getTxtComoDespierta() {
        return txtComoDespierta;
    }

    public void setTxtComoDespierta(JTextField txtComoDespierta) {
        this.txtComoDespierta = txtComoDespierta;
    }

    public JTextField getTxtComoDuerme() {
        return txtComoDuerme;
    }

    public void setTxtComoDuerme(JTextField txtComoDuerme) {
        this.txtComoDuerme = txtComoDuerme;
    }

    public JTextField getTxtComoFueDestete() {
        return txtComoFueDestete;
    }

    public void setTxtComoFueDestete(JTextField txtComoFueDestete) {
        this.txtComoFueDestete = txtComoFueDestete;
    }

    public JTextField getTxtComoSonMovimientos() {
        return txtComoSonMovimientos;
    }

    public void setTxtComoSonMovimientos(JTextField txtComoSonMovimientos) {
        this.txtComoSonMovimientos = txtComoSonMovimientos;
    }

    public JTextField getTxtConQuienDuerme() {
        return txtConQuienDuerme;
    }

    public void setTxtConQuienDuerme(JTextField txtConQuienDuerme) {
        this.txtConQuienDuerme = txtConQuienDuerme;
    }

    public JTextField getTxtDesdeEdadBiberon() {
        return txtDesdeEdadBiberon;
    }

    public void setTxtDesdeEdadBiberon(JTextField txtDesdeEdadBiberon) {
        this.txtDesdeEdadBiberon = txtDesdeEdadBiberon;
    }

    public JTextField getTxtDificultadEspecifique() {
        return txtDificultadEspecifique;
    }

    public void setTxtDificultadEspecifique(JTextField txtDificultadEspecifique) {
        this.txtDificultadEspecifique = txtDificultadEspecifique;
    }

    public JTextField getTxtDondeRealizoControles() {
        return txtDondeRealizoControles;
    }

    public void setTxtDondeRealizoControles(JTextField txtDondeRealizoControles) {
        this.txtDondeRealizoControles = txtDondeRealizoControles;
    }

    public JTextField getTxtEdadCamino() {
        return txtEdadCamino;
    }

    public void setTxtEdadCamino(JTextField txtEdadCamino) {
        this.txtEdadCamino = txtEdadCamino;
    }

    public JTextField getTxtEdadDioLeche() {
        return txtEdadDioLeche;
    }

    public void setTxtEdadDioLeche(JTextField txtEdadDioLeche) {
        this.txtEdadDioLeche = txtEdadDioLeche;
    }

    public JTextField getTxtEdadEsfinteres() {
        return txtEdadEsfinteres;
    }

    public void setTxtEdadEsfinteres(JTextField txtEdadEsfinteres) {
        this.txtEdadEsfinteres = txtEdadEsfinteres;
    }

    public JTextField getTxtEdadMadre() {
        return txtEdadMadre;
    }

    public void setTxtEdadMadre(JTextField txtEdadMadre) {
        this.txtEdadMadre = txtEdadMadre;
    }

    public JTextField getTxtEdadNNA() {
        return txtEdadNNA;
    }

    public void setTxtEdadNNA(JTextField txtEdadNNA) {
        this.txtEdadNNA = txtEdadNNA;
    }

    public JTextField getTxtEdadPadre() {
        return txtEdadPadre;
    }

    public void setTxtEdadPadre(JTextField txtEdadPadre) {
        this.txtEdadPadre = txtEdadPadre;
    }

    public JTextField getTxtEdadPrimerasPalabras() {
        return txtEdadPrimerasPalabras;
    }

    public void setTxtEdadPrimerasPalabras(JTextField txtEdadPrimerasPalabras) {
        this.txtEdadPrimerasPalabras = txtEdadPrimerasPalabras;
    }

    public JTextField getTxtEdadSento() {
        return txtEdadSento;
    }

    public void setTxtEdadSento(JTextField txtEdadSento) {
        this.txtEdadSento = txtEdadSento;
    }

    public JTextField getTxtEnqueaTrabajo() {
        return txtEnqueaTrabajo;
    }

    public void setTxtEnqueaTrabajo(JTextField txtEnqueaTrabajo) {
        this.txtEnqueaTrabajo = txtEnqueaTrabajo;
    }

    public JTextField getTxtEspecifiqueAlergias() {
        return txtEspecifiqueAlergias;
    }

    public void setTxtEspecifiqueAlergias(JTextField txtEspecifiqueAlergias) {
        this.txtEspecifiqueAlergias = txtEspecifiqueAlergias;
    }

    public JTextField getTxtEspecifiqueAprendizaje() {
        return txtEspecifiqueAprendizaje;
    }

    public void setTxtEspecifiqueAprendizaje(JTextField txtEspecifiqueAprendizaje) {
        this.txtEspecifiqueAprendizaje = txtEspecifiqueAprendizaje;
    }

    public JTextField getTxtEspecifiqueNerviosos() {
        return txtEspecifiqueNerviosos;
    }

    public void setTxtEspecifiqueNerviosos(JTextField txtEspecifiqueNerviosos) {
        this.txtEspecifiqueNerviosos = txtEspecifiqueNerviosos;
    }

    public JTextField getTxtEspecifiqueNeurologicos() {
        return txtEspecifiqueNeurologicos;
    }

    public void setTxtEspecifiqueNeurologicos(JTextField txtEspecifiqueNeurologicos) {
        this.txtEspecifiqueNeurologicos = txtEspecifiqueNeurologicos;
    }

    public JTextField getTxtEspecifiqueNivelacion() {
        return txtEspecifiqueNivelacion;
    }

    public void setTxtEspecifiqueNivelacion(JTextField txtEspecifiqueNivelacion) {
        this.txtEspecifiqueNivelacion = txtEspecifiqueNivelacion;
    }

    public JTextField getTxtEspecifiqueProblemasRespiratorios() {
        return txtEspecifiqueProblemasRespiratorios;
    }

    public void setTxtEspecifiqueProblemasRespiratorios(JTextField txtEspecifiqueProblemasRespiratorios) {
        this.txtEspecifiqueProblemasRespiratorios = txtEspecifiqueProblemasRespiratorios;
    }

    public JTextField getTxtExpliqueEstudia() {
        return txtExpliqueEstudia;
    }

    public void setTxtExpliqueEstudia(JTextField txtExpliqueEstudia) {
        this.txtExpliqueEstudia = txtExpliqueEstudia;
    }

    public JTextField getTxtFrecuenciaAgresorAgrede() {
        return txtFrecuenciaAgresorAgrede;
    }

    public void setTxtFrecuenciaAgresorAgrede(JTextField txtFrecuenciaAgresorAgrede) {
        this.txtFrecuenciaAgresorAgrede = txtFrecuenciaAgresorAgrede;
    }

    public JTextField getTxtHastaEdadBiberon() {
        return txtHastaEdadBiberon;
    }

    public void setTxtHastaEdadBiberon(JTextField txtHastaEdadBiberon) {
        this.txtHastaEdadBiberon = txtHastaEdadBiberon;
    }

    public JTextField getTxtInicioSolidos() {
        return txtInicioSolidos;
    }

    public void setTxtInicioSolidos(JTextField txtInicioSolidos) {
        this.txtInicioSolidos = txtInicioSolidos;
    }

    public JTextField getTxtLugarParto() {
        return txtLugarParto;
    }

    public void setTxtLugarParto(JTextField txtLugarParto) {
        this.txtLugarParto = txtLugarParto;
    }

    public JTextField getTxtMesAlumbramiento() {
        return txtMesAlumbramiento;
    }

    public void setTxtMesAlumbramiento(JTextField txtMesAlumbramiento) {
        this.txtMesAlumbramiento = txtMesAlumbramiento;
    }

    public JTextField getTxtMotivoCesarea() {
        return txtMotivoCesarea;
    }

    public void setTxtMotivoCesarea(JTextField txtMotivoCesarea) {
        this.txtMotivoCesarea = txtMotivoCesarea;
    }

  



    public JTextField getTxtNacionalidadNNA() {
        return txtNacionalidadNNA;
    }

    public void setTxtNacionalidadNNA(JTextField txtNacionalidadNNA) {
        this.txtNacionalidadNNA = txtNacionalidadNNA;
    }

    
   

    public JTextField getTxtNecesidadGrupoFamiliar() {
        return txtNecesidadGrupoFamiliar;
    }

    public void setTxtNecesidadGrupoFamiliar(JTextField txtNecesidadGrupoFamiliar) {
        this.txtNecesidadGrupoFamiliar = txtNecesidadGrupoFamiliar;
    }

    public JTextField getTxtNombreApellido() {
        return txtNombre;
    }

    public void setTxtNombreApellido(JTextField txtNombreApellido) {
        this.txtNombre = txtNombreApellido;
    }

    public JTextField getTxtNombreInstitucion() {
        return txtNombreInstitucion;
    }

    public void setTxtNombreInstitucion(JTextField txtNombreInstitucion) {
        this.txtNombreInstitucion = txtNombreInstitucion;
    }

    public JTextField getTxtNombreMadre() {
        return txtNombreMadre;
    }

    public void setTxtNombreMadre(JTextField txtNombreMadre) {
        this.txtNombreMadre = txtNombreMadre;
    }

    public JTextField getTxtNombrePadre() {
        return txtNombrePadre;
    }

    public void setTxtNombrePadre(JTextField txtNombrePadre) {
        this.txtNombrePadre = txtNombrePadre;
    }

    public JTextField getTxtObligacionesenlaFamilia() {
        return txtObligacionesenlaFamilia;
    }

    public void setTxtObligacionesenlaFamilia(JTextField txtObligacionesenlaFamilia) {
        this.txtObligacionesenlaFamilia = txtObligacionesenlaFamilia;
    }

    public JTextField getTxtOtraComplicacionEmbarazo() {
        return txtOtraComplicacionEmbarazo;
    }

    public void setTxtOtraComplicacionEmbarazo(JTextField txtOtraComplicacionEmbarazo) {
        this.txtOtraComplicacionEmbarazo = txtOtraComplicacionEmbarazo;
    }

    public JTextField getTxtOtroEspecifique() {
        return txtOtroEspecifique;
    }

    public void setTxtOtroEspecifique(JTextField txtOtroEspecifique) {
        this.txtOtroEspecifique = txtOtroEspecifique;
    }

    public JTextField getTxtPeso() {
        return txtPeso;
    }

    public void setTxtPeso(JTextField txtPeso) {
        this.txtPeso = txtPeso;
    }

    public JTextField getTxtPorqueLeche() {
        return txtPorqueLeche;
    }

    public void setTxtPorqueLeche(JTextField txtPorqueLeche) {
        this.txtPorqueLeche = txtPorqueLeche;
    }

    public JTextField getTxtProyeciondelaMadre() {
        return txtProyeciondelaMadre;
    }

    public void setTxtProyeciondelaMadre(JTextField txtProyeciondelaMadre) {
        this.txtProyeciondelaMadre = txtProyeciondelaMadre;
    }

    public JTextField getTxtPsicoSocial() {
        return txtPsicoSocial;
    }

    public void setTxtPsicoSocial(JTextField txtPsicoSocial) {
        this.txtPsicoSocial = txtPsicoSocial;
    }

    public JTextField getTxtQueUtiliza() {
        return txtQueUtiliza;
    }

    public void setTxtQueUtiliza(JTextField txtQueUtiliza) {
        this.txtQueUtiliza = txtQueUtiliza;
    }

    public JTextField getTxtReaccionMadre() {
        return txtReaccionMadre;
    }

    public void setTxtReaccionMadre(JTextField txtReaccionMadre) {
        this.txtReaccionMadre = txtReaccionMadre;
    }

    public JTextField getTxtReaccionMama() {
        return txtReaccionMama;
    }

    public void setTxtReaccionMama(JTextField txtReaccionMama) {
        this.txtReaccionMama = txtReaccionMama;
    }

    public JTextField getTxtReaccionPadre() {
        return txtReaccionPadre;
    }

    public void setTxtReaccionPadre(JTextField txtReaccionPadre) {
        this.txtReaccionPadre = txtReaccionPadre;
    }

    public JTextField getTxtReaccionPapa() {
        return txtReaccionPapa;
    }

    public void setTxtReaccionPapa(JTextField txtReaccionPapa) {
        this.txtReaccionPapa = txtReaccionPapa;
    }

    public JTextField getTxtRelacionHermanos() {
        return txtRelacionHermanos;
    }

    public void setTxtRelacionHermanos(JTextField txtRelacionHermanos) {
        this.txtRelacionHermanos = txtRelacionHermanos;
    }

    public JTextField getTxtRelacionMadre() {
        return txtRelacionMadre;
    }

    public void setTxtRelacionMadre(JTextField txtRelacionMadre) {
        this.txtRelacionMadre = txtRelacionMadre;
    }

    public JTextField getTxtRelacionPadre() {
        return txtRelacionPadre;
    }

    public void setTxtRelacionPadre(JTextField txtRelacionPadre) {
        this.txtRelacionPadre = txtRelacionPadre;
    }

    public JTextField getTxtTalla() {
        return txtTalla;
    }

    public void setTxtTalla(JTextField txtTalla) {
        this.txtTalla = txtTalla;
    }

    public JTextField getTxtVecesComeDia() {
        return txtVecesComeDia;
    }

    public void setTxtVecesComeDia(JTextField txtVecesComeDia) {
        this.txtVecesComeDia = txtVecesComeDia;
    }

    public JTextField getTxtfisico() {
        return txtfisico;
    }

    public void setTxtfisico(JTextField txtfisico) {
        this.txtfisico = txtfisico;
    }

    public JTextField getTxtLugarNacNNA1() {
        return txtLugarNacNNA1;
    }

    public void setTxtLugarNacNNA1(JTextField txtLugarNacNNA1) {
        this.txtLugarNacNNA1 = txtLugarNacNNA1;
    }
    
    //VENTANA AÑADIR FAMILIARES GET Y SET

    public JFrame getFrmFamiliares() {
        return FrmFamiliares;
    }

    public void setFrmFamiliares(JFrame FrmFamiliares) {
        this.FrmFamiliares = FrmFamiliares;
    }

    public JButton getBtnFamiliares_anadirFamiliar() {
        return btnFamiliares_anadirFamiliar;
    }

    public void setBtnFamiliares_anadirFamiliar(JButton btnFamiliares_anadirFamiliar) {
        this.btnFamiliares_anadirFamiliar = btnFamiliares_anadirFamiliar;
    }

    public JButton getBtnFamiliares_cancelar() {
        return btnFamiliares_cancelar;
    }

    public void setBtnFamiliares_cancelar(JButton btnFamiliares_cancelar) {
        this.btnFamiliares_cancelar = btnFamiliares_cancelar;
    }

    public JComboBox<String> getCbxFamiliares_estadoCivil() {
        return cbxFamiliares_estadoCivil;
    }

    public void setCbxFamiliares_estadoCivil(JComboBox<String> cbxFamiliares_estadoCivil) {
        this.cbxFamiliares_estadoCivil = cbxFamiliares_estadoCivil;
    }

    public JComboBox<String> getCbxFamiliares_instruccionAcademica() {
        return cbxFamiliares_instruccionAcademica;
    }

    public void setCbxFamiliares_instruccionAcademica(JComboBox<String> cbxFamiliares_instruccionAcademica) {
        this.cbxFamiliares_instruccionAcademica = cbxFamiliares_instruccionAcademica;
    }

    public JComboBox<String> getCbxFamiliares_sexo() {
        return cbxFamiliares_sexo;
    }

    public void setCbxFamiliares_sexo(JComboBox<String> cbxFamiliares_sexo) {
        this.cbxFamiliares_sexo = cbxFamiliares_sexo;
    }

    public JTextField getTxtFamiliares_apellidos() {
        return txtFamiliares_apellidos;
    }

    public void setTxtFamiliares_apellidos(JTextField txtFamiliares_apellidos) {
        this.txtFamiliares_apellidos = txtFamiliares_apellidos;
    }

    public JTextField getTxtFamiliares_edad() {
        return txtFamiliares_edad;
    }

    public void setTxtFamiliares_edad(JTextField txtFamiliares_edad) {
        this.txtFamiliares_edad = txtFamiliares_edad;
    }

    public JTextField getTxtFamiliares_nombres() {
        return txtFamiliares_nombres;
    }

    public void setTxtFamiliares_nombres(JTextField txtFamiliares_nombres) {
        this.txtFamiliares_nombres = txtFamiliares_nombres;
    }

    public JTextField getTxtFamiliares_ocupacion() {
        return txtFamiliares_ocupacion;
    }

    public void setTxtFamiliares_ocupacion(JTextField txtFamiliares_ocupacion) {
        this.txtFamiliares_ocupacion = txtFamiliares_ocupacion;
    }

    public JTextField getTxtFamiliares_parentesco() {
        return txtFamiliares_parentesco;
    }

    public void setTxtFamiliares_parentesco(JTextField txtFamiliares_parentesco) {
        this.txtFamiliares_parentesco = txtFamiliares_parentesco;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtApellidoMadre() {
        return txtApellidoMadre;
    }

    public void setTxtApellidoMadre(JTextField txtApellidoMadre) {
        this.txtApellidoMadre = txtApellidoMadre;
    }

    public JTextField getTxtApellidoPadre() {
        return txtApellidoPadre;
    }

    public void setTxtApellidoPadre(JTextField txtApellidoPadre) {
        this.txtApellidoPadre = txtApellidoPadre;
    }

    public JTextField getTxtNacionalidadPadre() {
        return txtNacionalidadPadre;
    }

    public void setTxtNacionalidadPadre(JTextField txtNacionalidadPadre) {
        this.txtNacionalidadPadre = txtNacionalidadPadre;
    }

    public JTextField getTxtNaconalidadMadre() {
        return txtNaconalidadMadre;
    }

    public void setTxtNaconalidadMadre(JTextField txtNaconalidadMadre) {
        this.txtNaconalidadMadre = txtNaconalidadMadre;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrmFamiliares = new javax.swing.JFrame();
        pnlAgregarFamilar = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        txtFamiliares_nombres = new javax.swing.JTextField();
        txtFamiliares_apellidos = new javax.swing.JTextField();
        txtFamiliares_parentesco = new javax.swing.JTextField();
        cbxFamiliares_instruccionAcademica = new javax.swing.JComboBox<>();
        txtFamiliares_ocupacion = new javax.swing.JTextField();
        txtFamiliares_edad = new javax.swing.JTextField();
        btnFamiliares_anadirFamiliar = new javax.swing.JButton();
        btnFamiliares_cancelar = new javax.swing.JButton();
        cbxFamiliares_sexo = new javax.swing.JComboBox<>();
        cbxFamiliares_estadoCivil = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        panelFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdcFechaElaboracion = new com.toedter.calendar.JDateChooser();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtpPrincipal = new javax.swing.JTabbedPane();
        panelDatosIdentificacion = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNacionalidadNNA = new javax.swing.JTextField();
        jdcFechaNacimientoNNA = new com.toedter.calendar.JDateChooser();
        txtEdadNNA = new javax.swing.JTextField();
        cbxPoseeCedula = new javax.swing.JComboBox<>();
        jLabel114 = new javax.swing.JLabel();
        txtLugarNacNNA1 = new javax.swing.JTextField();
        panelDatosMadrePadre = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNombreMadre = new javax.swing.JTextField();
        txtNombrePadre = new javax.swing.JTextField();
        txtEdadMadre = new javax.swing.JTextField();
        txtEdadPadre = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbxPadreAgresor = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaSituacionIngresaNNA = new javax.swing.JTextArea();
        jLabel124 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel125 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel126 = new javax.swing.JLabel();
        txtApellidoMadre = new javax.swing.JTextField();
        txtNaconalidadMadre = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        txtNacionalidadPadre = new javax.swing.JTextField();
        txtApellidoPadre = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel128 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        panelComposicionFamiliar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabComposicionFamiliarNNA = new javax.swing.JTable();
        btnAñadir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        panelPeriodoEmbarazo = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        cbxEmbarazoPlanificado = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtReaccionPapa = new javax.swing.JTextField();
        txtReaccionMama = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jcxSiViolencia = new javax.swing.JCheckBox();
        jcxNoViolencia = new javax.swing.JCheckBox();
        jcxGolpes = new javax.swing.JCheckBox();
        jcxInsultos = new javax.swing.JCheckBox();
        jcxNegligencia = new javax.swing.JCheckBox();
        jcxAmbitoLaboral = new javax.swing.JCheckBox();
        jcxAbusoSexual = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jcxSiControles = new javax.swing.JCheckBox();
        jcxNoControles = new javax.swing.JCheckBox();
        jcxUnaVez = new javax.swing.JCheckBox();
        jcxMensual = new javax.swing.JCheckBox();
        jcxTrimestral = new javax.swing.JCheckBox();
        jcxNinguna = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        txtDondeRealizoControles = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jcxSiComplicaciones = new javax.swing.JCheckBox();
        jcxNoComplicaciones = new javax.swing.JCheckBox();
        jcxBajoPeso = new javax.swing.JCheckBox();
        jcxHemorragias = new javax.swing.JCheckBox();
        jcxInfecciones = new javax.swing.JCheckBox();
        jcxPreclansia = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        txtOtraComplicacionEmbarazo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jcxSiConsume = new javax.swing.JCheckBox();
        jcxNoConsume = new javax.swing.JCheckBox();
        jcxTabaco = new javax.swing.JCheckBox();
        jcxAlcohol = new javax.swing.JCheckBox();
        jcxDroga = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        txtCausasConsumo = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jcxSiAborto = new javax.swing.JCheckBox();
        jcxNoAborto = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        txtCausasAborto = new javax.swing.JTextField();
        panelCondicionesNacimiento = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtMesAlumbramiento = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtLugarParto = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jcxNormal = new javax.swing.JCheckBox();
        jcxCesarea = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        txtMotivoCesarea = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jcxSiAnestesia = new javax.swing.JCheckBox();
        jcxNoAnestesia = new javax.swing.JCheckBox();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jcxSiLloro = new javax.swing.JCheckBox();
        jcxNoLloro = new javax.swing.JCheckBox();
        jLabel39 = new javax.swing.JLabel();
        jcxSiOxigeno = new javax.swing.JCheckBox();
        jcxNoOxigeno = new javax.swing.JCheckBox();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtTalla = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jcxDepresion = new javax.swing.JCheckBox();
        jcxHipersencibilidad = new javax.swing.JCheckBox();
        jLabel44 = new javax.swing.JLabel();
        jcxSiSexo = new javax.swing.JCheckBox();
        jcxNoSexo = new javax.swing.JCheckBox();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtReaccionMadre = new javax.swing.JTextField();
        txtReaccionPadre = new javax.swing.JTextField();
        panelPrimerosDiaVida = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jcxSiLeche = new javax.swing.JCheckBox();
        jcxNoLeche = new javax.swing.JCheckBox();
        jLabel49 = new javax.swing.JLabel();
        txtPorqueLeche = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtEdadDioLeche = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jcxSiBiberon = new javax.swing.JCheckBox();
        jcxNoBiberon = new javax.swing.JCheckBox();
        jcxAmbos = new javax.swing.JCheckBox();
        jLabel52 = new javax.swing.JLabel();
        txtDesdeEdadBiberon = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtHastaEdadBiberon = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jcxSiSuccionar = new javax.swing.JCheckBox();
        jcxNoSuccionar = new javax.swing.JCheckBox();
        jLabel55 = new javax.swing.JLabel();
        txtComoFueDestete = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtEdadSento = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtEdadCamino = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtEdadPrimerasPalabras = new javax.swing.JTextField();
        panelAlimentacionActual = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        txtInicioSolidos = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txtVecesComeDia = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtComeSolooAcompanhado = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtActitudMadre = new javax.swing.JTextField();
        jtxtdificultadesAlimentacion = new javax.swing.JTextField();
        panelDesarrolloMotorLenguaje = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jcxNormalMotorGrueso = new javax.swing.JCheckBox();
        jcxIrregularMotorGrueso = new javax.swing.JCheckBox();
        jLabel65 = new javax.swing.JLabel();
        jcxNormalMotorFino = new javax.swing.JCheckBox();
        jcxIrregularMotorFino = new javax.swing.JCheckBox();
        jLabel66 = new javax.swing.JLabel();
        txtComoSonMovimientos = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtPsicoSocial = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtCognitivo = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtfisico = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jcxClaro = new javax.swing.JCheckBox();
        jcxNoMuyClaro = new javax.swing.JCheckBox();
        jcxNoSeEntiende = new javax.swing.JCheckBox();
        jLabel71 = new javax.swing.JLabel();
        txtDificultadEspecifique = new javax.swing.JTextField();
        panelSueñoEsfinteres = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jcxSiDuerme = new javax.swing.JCheckBox();
        jcxNoDuerme = new javax.swing.JCheckBox();
        jLabel73 = new javax.swing.JLabel();
        txtComoDuerme = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jcxSiMiedoDormir = new javax.swing.JCheckBox();
        jcxNoMiedoDormir = new javax.swing.JCheckBox();
        jLabel75 = new javax.swing.JLabel();
        txtComoDespierta = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jcxSiPesadillas = new javax.swing.JCheckBox();
        jcxNoPesadillas = new javax.swing.JCheckBox();
        jLabel77 = new javax.swing.JLabel();
        txtConQuienDuerme = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        txtEdadEsfinteres = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jcxSiAyudaBanho = new javax.swing.JCheckBox();
        jcxNoAyudaBanho = new javax.swing.JCheckBox();
        jLabel80 = new javax.swing.JLabel();
        jcxSiEcopresis = new javax.swing.JCheckBox();
        jcxNoEcopresis = new javax.swing.JCheckBox();
        jLabel81 = new javax.swing.JLabel();
        txtCausaEcopresis = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jcxSiMojaCama = new javax.swing.JCheckBox();
        jcxNoMojaCama = new javax.swing.JCheckBox();
        panelEscolarizacionNNA = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jcxSiEstudia = new javax.swing.JCheckBox();
        jcxNoEstudia = new javax.swing.JCheckBox();
        jLabel84 = new javax.swing.JLabel();
        txtExpliqueEstudia = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        txtNombreInstitucion = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        txtAnhoCursa = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        txtAnhoRepite = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jcxSiAprendizaje = new javax.swing.JCheckBox();
        jcxNoAprendizaje = new javax.swing.JCheckBox();
        jLabel89 = new javax.swing.JLabel();
        txtEspecifiqueAprendizaje = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jcxSiNivelacion = new javax.swing.JCheckBox();
        jcxNoNivelacion = new javax.swing.JCheckBox();
        jLabel91 = new javax.swing.JLabel();
        txtEspecifiqueNivelacion = new javax.swing.JTextField();
        panelSalud = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jcxSindromeDown = new javax.swing.JCheckBox();
        jcxEpilepsia = new javax.swing.JCheckBox();
        jcxAlcoholismo = new javax.swing.JCheckBox();
        jcxDiscapacidadIntelectual = new javax.swing.JCheckBox();
        jLabel93 = new javax.swing.JLabel();
        txtOtroEspecifique = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jcxSiProblemasRespiratorios = new javax.swing.JCheckBox();
        jcxNoProblemasRespiratorios = new javax.swing.JCheckBox();
        jLabel95 = new javax.swing.JLabel();
        txtEspecifiqueProblemasRespiratorios = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jcxSiAlergias = new javax.swing.JCheckBox();
        jcxNoAlergias = new javax.swing.JCheckBox();
        jLabel97 = new javax.swing.JLabel();
        txtEspecifiqueAlergias = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jcxSiNeurologicos = new javax.swing.JCheckBox();
        jcxNoNeurologicos = new javax.swing.JCheckBox();
        jLabel99 = new javax.swing.JLabel();
        txtEspecifiqueNeurologicos = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jcxSiNerviosos = new javax.swing.JCheckBox();
        jcxNoNerviosos = new javax.swing.JCheckBox();
        jLabel101 = new javax.swing.JLabel();
        txtEspecifiqueNerviosos = new javax.swing.JTextField();
        panelRelacionFamiliar = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        txtClimaFamiliar = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        txtRelacionPadre = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        txtRelacionMadre = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        txtRelacionHermanos = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jcxSiTrabajo = new javax.swing.JCheckBox();
        jcxNoTrabajo = new javax.swing.JCheckBox();
        jLabel107 = new javax.swing.JLabel();
        txtEnqueaTrabajo = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jcxSiAgrede = new javax.swing.JCheckBox();
        jcxNoAgrede = new javax.swing.JCheckBox();
        jLabel109 = new javax.swing.JLabel();
        txtFrecuenciaAgresorAgrede = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        txtQueUtiliza = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        txtObligacionesenlaFamilia = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        txtProyeciondelaMadre = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        txtNecesidadGrupoFamiliar = new javax.swing.JTextField();
        panelObservacionesGenerales = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txAObservaciones = new javax.swing.JTextArea();
        jLabel129 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        FrmFamiliares.setTitle("Añadiendo familiar");
        FrmFamiliares.setMinimumSize(new java.awt.Dimension(550, 442));
        FrmFamiliares.setResizable(false);

        pnlAgregarFamilar.setMinimumSize(new java.awt.Dimension(372, 400));

        jLabel115.setText("Añadir Familar");

        jLabel116.setText("Nombres:");

        jLabel117.setText("Apellidos:");

        jLabel118.setText("Sexo:");

        jLabel119.setText("Edad:");

        jLabel120.setText("Estado civil:");

        jLabel121.setText("Parentesco:");

        jLabel122.setText("Instrucción académica:");

        jLabel123.setText("Ocupación:");

        cbxFamiliares_instruccionAcademica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));

        btnFamiliares_anadirFamiliar.setText("Guardar");

        btnFamiliares_cancelar.setText("Cancelar");

        cbxFamiliares_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Masculino", "Femenino", "Sin especificar" }));

        cbxFamiliares_estadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));

        javax.swing.GroupLayout pnlAgregarFamilarLayout = new javax.swing.GroupLayout(pnlAgregarFamilar);
        pnlAgregarFamilar.setLayout(pnlAgregarFamilarLayout);
        pnlAgregarFamilarLayout.setHorizontalGroup(
            pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarFamilarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgregarFamilarLayout.createSequentialGroup()
                        .addComponent(btnFamiliares_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFamiliares_anadirFamiliar))
                    .addGroup(pnlAgregarFamilarLayout.createSequentialGroup()
                        .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel116)
                            .addComponent(jLabel117)
                            .addComponent(jLabel119)
                            .addComponent(jLabel120)
                            .addComponent(jLabel121)
                            .addComponent(jLabel122)
                            .addComponent(jLabel123)
                            .addComponent(jLabel118))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFamiliares_edad)
                            .addComponent(txtFamiliares_nombres)
                            .addComponent(txtFamiliares_apellidos)
                            .addComponent(txtFamiliares_parentesco)
                            .addComponent(cbxFamiliares_instruccionAcademica, 0, 194, Short.MAX_VALUE)
                            .addComponent(txtFamiliares_ocupacion)
                            .addComponent(cbxFamiliares_sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxFamiliares_estadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
            .addGroup(pnlAgregarFamilarLayout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(jLabel115)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        pnlAgregarFamilarLayout.setVerticalGroup(
            pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarFamilarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel115)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(txtFamiliares_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel117)
                    .addComponent(txtFamiliares_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAgregarFamilarLayout.createSequentialGroup()
                        .addComponent(jLabel118)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel119))
                    .addGroup(pnlAgregarFamilarLayout.createSequentialGroup()
                        .addComponent(cbxFamiliares_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFamiliares_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(cbxFamiliares_estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(txtFamiliares_parentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel122)
                    .addComponent(cbxFamiliares_instruccionAcademica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123)
                    .addComponent(txtFamiliares_ocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlAgregarFamilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFamiliares_anadirFamiliar)
                    .addComponent(btnFamiliares_cancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout FrmFamiliaresLayout = new javax.swing.GroupLayout(FrmFamiliares.getContentPane());
        FrmFamiliares.getContentPane().setLayout(FrmFamiliaresLayout);
        FrmFamiliaresLayout.setHorizontalGroup(
            FrmFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrmFamiliaresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAgregarFamilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FrmFamiliaresLayout.setVerticalGroup(
            FrmFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrmFamiliaresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAgregarFamilar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INSTRUMENTOS TECNICOS-AREA INFANTO JUVENIL");

        jLabel2.setText("INFJUV/1 ANAMNESIS");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Cedula de Identidad:");

        jLabel5.setText("Fecha de elaboracion:");

        jLabel6.setText("Codigo:");

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha de Nacimiento:");

        jLabel8.setText("Nacionalidad:");

        jLabel9.setText("Posee Cedula:");

        jLabel10.setText("Edad:");

        cbxPoseeCedula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));

        jLabel114.setText("Lugar de Nacimiento:");

        javax.swing.GroupLayout panelDatosIdentificacionLayout = new javax.swing.GroupLayout(panelDatosIdentificacion);
        panelDatosIdentificacion.setLayout(panelDatosIdentificacionLayout);
        panelDatosIdentificacionLayout.setHorizontalGroup(
            panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosIdentificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosIdentificacionLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDatosIdentificacionLayout.createSequentialGroup()
                        .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosIdentificacionLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdcFechaNacimientoNNA, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosIdentificacionLayout.createSequentialGroup()
                                .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel114)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLugarNacNNA1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNacionalidadNNA, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(28, 28, 28)
                        .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxPoseeCedula, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEdadNNA, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelDatosIdentificacionLayout.setVerticalGroup(
            panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosIdentificacionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosIdentificacionLayout.createSequentialGroup()
                        .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbxPoseeCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEdadNNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(jLabel114)))
                    .addGroup(panelDatosIdentificacionLayout.createSequentialGroup()
                        .addComponent(jdcFechaNacimientoNNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLugarNacNNA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelDatosIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNacionalidadNNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(528, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Datos de Identificacion", panelDatosIdentificacion);

        jLabel12.setText("Nombre de la Madre:");

        jLabel13.setText("Nacionalidad:");

        jLabel14.setText("Nombre del Padre:");

        jLabel15.setText("Nacionalidad:");

        jLabel16.setText("Edad de la Madre");

        jLabel17.setText("Edad del Padre");

        jLabel18.setText("El padre es el agresor:");

        cbxPadreAgresor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));

        jLabel19.setText("Situacion en la que ingresa el niño, niña o adolescente");

        txaSituacionIngresaNNA.setColumns(20);
        txaSituacionIngresaNNA.setRows(5);
        jScrollPane1.setViewportView(txaSituacionIngresaNNA);

        jLabel124.setText("Datos de la  madre.");

        jLabel125.setText("Datos del padre.");

        jLabel126.setText("Apellido de la Madre:");

        txtNaconalidadMadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNaconalidadMadreActionPerformed(evt);
            }
        });

        jLabel127.setText("Apellido del Padre");

        txtApellidoPadre.setText("jTextField1");

        jLabel128.setText("Observaciones.");

        javax.swing.GroupLayout panelDatosMadrePadreLayout = new javax.swing.GroupLayout(panelDatosMadrePadre);
        panelDatosMadrePadre.setLayout(panelDatosMadrePadreLayout);
        panelDatosMadrePadreLayout.setHorizontalGroup(
            panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelDatosMadrePadreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosMadrePadreLayout.createSequentialGroup()
                        .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosMadrePadreLayout.createSequentialGroup()
                                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxPadreAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelDatosMadrePadreLayout.createSequentialGroup()
                                        .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombrePadre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(txtApellidoPadre))
                                        .addGap(109, 109, 109)
                                        .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel128))))
                                .addGap(49, 49, 49))
                            .addComponent(jLabel19)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosMadrePadreLayout.createSequentialGroup()
                                .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 129, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel13))
                                .addGap(43, 43, 43)))
                        .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosMadrePadreLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtNaconalidadMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosMadrePadreLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNacionalidadPadre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEdadPadre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(174, 174, 174))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosMadrePadreLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosMadrePadreLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEdadMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosMadrePadreLayout.createSequentialGroup()
                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosMadrePadreLayout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(jLabel124))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosMadrePadreLayout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel125)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelDatosMadrePadreLayout.createSequentialGroup()
                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        panelDatosMadrePadreLayout.setVerticalGroup(
            panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosMadrePadreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel124)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtEdadMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtNombreMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 51, Short.MAX_VALUE)
                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel126)
                    .addComponent(txtApellidoMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNaconalidadMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel125)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNombrePadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtEdadPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel127)
                    .addComponent(txtNacionalidadPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbxPadreAgresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosMadrePadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jtpPrincipal.addTab("Datos de la Madre y Padre", panelDatosMadrePadre);

        tabComposicionFamiliarNNA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombres ", "Apellidos", "Sexo", "Edad", "Estado Civil", "Parentesco", "Instruccion", "Ocupacion"
            }
        ));
        jScrollPane2.setViewportView(tabComposicionFamiliarNNA);

        btnAñadir.setText("Añadir");

        btnEditar.setText("Editar");

        btnEliminar.setText("Eliminar");

        javax.swing.GroupLayout panelComposicionFamiliarLayout = new javax.swing.GroupLayout(panelComposicionFamiliar);
        panelComposicionFamiliar.setLayout(panelComposicionFamiliarLayout);
        panelComposicionFamiliarLayout.setHorizontalGroup(
            panelComposicionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComposicionFamiliarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelComposicionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelComposicionFamiliarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAñadir)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        panelComposicionFamiliarLayout.setVerticalGroup(
            panelComposicionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComposicionFamiliarLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelComposicionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadir)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(381, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Composicion Familiar del niño, niña o adolescente", panelComposicionFamiliar);

        jLabel20.setText("El embarazo fue planificado?");

        cbxEmbarazoPlanificado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));

        jLabel21.setText("Reacción de Papá:");

        jLabel22.setText("Reacción de Mamá:");

        jLabel23.setText("Sufrio episodios de violencia durante el embarazo?");

        jcxSiViolencia.setText("Si");

        jcxNoViolencia.setText("No");

        jcxGolpes.setText("Golpes");

        jcxInsultos.setText("Insultos");

        jcxNegligencia.setText("Negligencia");

        jcxAmbitoLaboral.setText("En el ámbito laboral");

        jcxAbusoSexual.setText("Abuso sexual");

        jLabel24.setText("Se Realizó controles médicos");

        jcxSiControles.setText("Si");

        jcxNoControles.setText("No");

        jcxUnaVez.setText("Una sola vez");

        jcxMensual.setText("Mensual");

        jcxTrimestral.setText("Trimestral");

        jcxNinguna.setText("Ninguna");

        jLabel25.setText("En dónde se realizó los controles");

        jLabel26.setText("Tuvo complicaciones durante el embarazo");

        jcxSiComplicaciones.setText("Si");

        jcxNoComplicaciones.setText("No");

        jcxBajoPeso.setText("Bajo peso");

        jcxHemorragias.setText("Hemorragias");

        jcxInfecciones.setText("infecciones");

        jcxPreclansia.setText("Preclamsia");

        jLabel27.setText("Otro");

        jLabel28.setText("Durante el embarazo hubo consumo");

        jcxSiConsume.setText("Si");

        jcxNoConsume.setText("No");

        jcxTabaco.setText("Tabaco");

        jcxAlcohol.setText("Alcohol");

        jcxDroga.setText("Droga");

        jLabel29.setText("¿Causas?");

        jLabel30.setText("Tentativas de aborto");

        jcxSiAborto.setText("Si");

        jcxNoAborto.setText("No");

        jLabel31.setText("¿Causas?");

        javax.swing.GroupLayout panelPeriodoEmbarazoLayout = new javax.swing.GroupLayout(panelPeriodoEmbarazo);
        panelPeriodoEmbarazo.setLayout(panelPeriodoEmbarazoLayout);
        panelPeriodoEmbarazoLayout.setHorizontalGroup(
            panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeriodoEmbarazoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPeriodoEmbarazoLayout.createSequentialGroup()
                        .addComponent(jcxSiControles)
                        .addGap(18, 18, 18)
                        .addComponent(jcxNoControles)
                        .addGap(18, 18, 18)
                        .addComponent(jcxUnaVez)
                        .addGap(18, 18, 18)
                        .addComponent(jcxMensual)
                        .addGap(18, 18, 18)
                        .addComponent(jcxTrimestral)
                        .addGap(18, 18, 18)
                        .addComponent(jcxNinguna))
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addGroup(panelPeriodoEmbarazoLayout.createSequentialGroup()
                        .addComponent(jcxSiConsume)
                        .addGap(18, 18, 18)
                        .addComponent(jcxNoConsume)
                        .addGap(18, 18, 18)
                        .addComponent(jcxTabaco)
                        .addGap(18, 18, 18)
                        .addComponent(jcxAlcohol)
                        .addGap(18, 18, 18)
                        .addComponent(jcxDroga))
                    .addComponent(jLabel23)
                    .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtReaccionPapa, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelPeriodoEmbarazoLayout.createSequentialGroup()
                            .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21)
                                .addComponent(jLabel22))
                            .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPeriodoEmbarazoLayout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(txtReaccionMama, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPeriodoEmbarazoLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxEmbarazoPlanificado, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelPeriodoEmbarazoLayout.createSequentialGroup()
                        .addComponent(jcxSiViolencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcxNoViolencia)
                        .addGap(18, 18, 18)
                        .addComponent(jcxGolpes)
                        .addGap(18, 18, 18)
                        .addComponent(jcxAbusoSexual)
                        .addGap(18, 18, 18)
                        .addComponent(jcxInsultos)
                        .addGap(18, 18, 18)
                        .addComponent(jcxNegligencia)
                        .addGap(18, 18, 18)
                        .addComponent(jcxAmbitoLaboral))
                    .addGroup(panelPeriodoEmbarazoLayout.createSequentialGroup()
                        .addComponent(jcxSiAborto)
                        .addGap(18, 18, 18)
                        .addComponent(jcxNoAborto))
                    .addComponent(jLabel30)
                    .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPeriodoEmbarazoLayout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCausasAborto))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPeriodoEmbarazoLayout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCausasConsumo))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPeriodoEmbarazoLayout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addGap(18, 18, 18)
                            .addComponent(txtDondeRealizoControles))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPeriodoEmbarazoLayout.createSequentialGroup()
                            .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcxSiComplicaciones)
                                .addComponent(jLabel27))
                            .addGap(18, 18, 18)
                            .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtOtraComplicacionEmbarazo, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelPeriodoEmbarazoLayout.createSequentialGroup()
                                    .addComponent(jcxNoComplicaciones)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcxBajoPeso)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcxHemorragias)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcxInfecciones)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcxPreclansia))))))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        panelPeriodoEmbarazoLayout.setVerticalGroup(
            panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeriodoEmbarazoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbxEmbarazoPlanificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtReaccionPapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtReaccionMama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcxSiViolencia)
                    .addComponent(jcxNoViolencia)
                    .addComponent(jcxGolpes)
                    .addComponent(jcxAbusoSexual)
                    .addComponent(jcxInsultos)
                    .addComponent(jcxNegligencia)
                    .addComponent(jcxAmbitoLaboral))
                .addGap(10, 10, 10)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcxSiControles)
                    .addComponent(jcxNoControles)
                    .addComponent(jcxUnaVez)
                    .addComponent(jcxMensual)
                    .addComponent(jcxTrimestral)
                    .addComponent(jcxNinguna))
                .addGap(18, 18, 18)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtDondeRealizoControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcxSiComplicaciones)
                    .addComponent(jcxNoComplicaciones)
                    .addComponent(jcxBajoPeso)
                    .addComponent(jcxHemorragias)
                    .addComponent(jcxInfecciones)
                    .addComponent(jcxPreclansia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtOtraComplicacionEmbarazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcxNoConsume)
                    .addComponent(jcxTabaco)
                    .addComponent(jcxAlcohol)
                    .addComponent(jcxDroga)
                    .addComponent(jcxSiConsume))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtCausasConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addGap(10, 10, 10)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcxSiAborto)
                    .addComponent(jcxNoAborto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPeriodoEmbarazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtCausasAborto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Periodo de Embarazo", panelPeriodoEmbarazo);

        jLabel32.setText("¿En qué mes de embarazo se produjo el alumbramiento?");

        jLabel33.setText("Lugar de atención del parto:");

        jLabel34.setText("¿Cómo transcurrió el parto?");

        jcxNormal.setText("Normal");

        jcxCesarea.setText("Cesárea");

        jLabel35.setText("Motivo de la Cesárea");

        jLabel36.setText("¿Utilizaron anestesia?");

        jcxSiAnestesia.setText("Si");

        jcxNoAnestesia.setText("No");

        jLabel37.setText("Complicaciones después del parto");

        jLabel38.setText("¿Lloro al nacer?");

        jcxSiLloro.setText("Si");

        jcxNoLloro.setText("No");

        jLabel39.setText("¿Necesito oxigeno?");

        jcxSiOxigeno.setText("Si");

        jcxNoOxigeno.setText("No");

        jLabel40.setText("Peso y talla al momento de nacer ");

        jLabel41.setText("Talla");

        jLabel42.setText("Peso");

        jLabel43.setText("¿Cómo se sintió después del parto?");

        jcxDepresion.setText("Depresión");

        jcxHipersencibilidad.setText("Hipersensibilidad");

        jLabel44.setText("¿Fue el niño o niña del sexo esperado?");

        jcxSiSexo.setText("Si");

        jcxNoSexo.setText("No");

        jLabel45.setText("Reacción frente a este hecho:");

        jLabel46.setText("Madre:");

        jLabel47.setText("Padre:");

        javax.swing.GroupLayout panelCondicionesNacimientoLayout = new javax.swing.GroupLayout(panelCondicionesNacimiento);
        panelCondicionesNacimiento.setLayout(panelCondicionesNacimientoLayout);
        panelCondicionesNacimientoLayout.setHorizontalGroup(
            panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCondicionesNacimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addGroup(panelCondicionesNacimientoLayout.createSequentialGroup()
                        .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel36)
                            .addComponent(jLabel40)
                            .addComponent(jLabel38)
                            .addGroup(panelCondicionesNacimientoLayout.createSequentialGroup()
                                .addComponent(jcxSiLloro)
                                .addGap(18, 18, 18)
                                .addComponent(jcxNoLloro))
                            .addComponent(jLabel41)
                            .addComponent(jLabel44)
                            .addComponent(jcxSiSexo)
                            .addComponent(jcxNoSexo))
                        .addGap(18, 18, 18)
                        .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLugarParto)
                            .addComponent(jLabel45)
                            .addGroup(panelCondicionesNacimientoLayout.createSequentialGroup()
                                .addComponent(jcxDepresion)
                                .addGap(18, 18, 18)
                                .addComponent(jcxHipersencibilidad))
                            .addGroup(panelCondicionesNacimientoLayout.createSequentialGroup()
                                .addComponent(jcxSiOxigeno)
                                .addGap(18, 18, 18)
                                .addComponent(jcxNoOxigeno))
                            .addComponent(jLabel39)
                            .addComponent(jLabel43)
                            .addComponent(txtMesAlumbramiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCondicionesNacimientoLayout.createSequentialGroup()
                                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcxNormal)
                                    .addComponent(jcxSiAnestesia))
                                .addGap(18, 18, 18)
                                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcxNoAnestesia)
                                    .addComponent(jcxCesarea)))
                            .addGroup(panelCondicionesNacimientoLayout.createSequentialGroup()
                                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel47))
                                .addGap(18, 18, 18)
                                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtReaccionMadre)
                                    .addComponent(txtReaccionPadre, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)))))
                    .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCondicionesNacimientoLayout.createSequentialGroup()
                            .addComponent(jLabel42)
                            .addGap(18, 18, 18)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel35)
                    .addComponent(txtMotivoCesarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        panelCondicionesNacimientoLayout.setVerticalGroup(
            panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCondicionesNacimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtMesAlumbramiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(txtLugarParto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcxNormal)
                        .addComponent(jcxCesarea)))
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtMotivoCesarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jcxSiAnestesia)
                    .addComponent(jcxNoAnestesia))
                .addGap(18, 18, 18)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcxSiLloro)
                    .addComponent(jcxNoLloro)
                    .addComponent(jcxSiOxigeno)
                    .addComponent(jcxNoOxigeno))
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel43))
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcxDepresion)
                    .addComponent(jcxHipersencibilidad))
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcxSiSexo)
                    .addComponent(jLabel46)
                    .addComponent(txtReaccionMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCondicionesNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcxNoSexo)
                    .addComponent(jLabel47)
                    .addComponent(txtReaccionPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jtpPrincipal.addTab("Condiciones del nacimiento", panelCondicionesNacimiento);

        jLabel48.setText("Alimentación con leche materna");

        jcxSiLeche.setText("Si");

        jcxNoLeche.setText("No");

        jLabel49.setText("¿Por qué?");

        jLabel50.setText("¿Hasta qué edad le dio leche materna?");

        jLabel51.setText("Usó biberón");

        jcxSiBiberon.setText("Si");

        jcxNoBiberon.setText("No");

        jcxAmbos.setText("Ambos");

        jLabel52.setText("¿Desde qué edad?");

        jLabel53.setText("¿Hasta qué edad?");

        jLabel54.setText("Dificultades para succionar");

        jcxSiSuccionar.setText("Si");

        jcxNoSuccionar.setText("No");

        jLabel55.setText("¿Cómo fue el destete?");

        jLabel56.setText("¿A qué edad se sentó?");

        jLabel57.setText("¿A qué edad caminó?");

        jLabel58.setText("¿A qué edad dijo sus primeras palabras?");

        javax.swing.GroupLayout panelPrimerosDiaVidaLayout = new javax.swing.GroupLayout(panelPrimerosDiaVida);
        panelPrimerosDiaVida.setLayout(panelPrimerosDiaVidaLayout);
        panelPrimerosDiaVidaLayout.setHorizontalGroup(
            panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrimerosDiaVidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrimerosDiaVidaLayout.createSequentialGroup()
                        .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrimerosDiaVidaLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDesdeEdadBiberon, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrimerosDiaVidaLayout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addGap(18, 18, 18)
                                .addComponent(jcxSiBiberon)
                                .addGap(18, 18, 18)
                                .addComponent(jcxNoBiberon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcxAmbos))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrimerosDiaVidaLayout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGap(18, 18, 18)
                                .addComponent(jcxSiLeche)
                                .addGap(18, 18, 18)
                                .addComponent(jcxNoLeche))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrimerosDiaVidaLayout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addGap(18, 18, 18)
                                .addComponent(txtEdadDioLeche)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel53)
                        .addGap(32, 32, 32)
                        .addComponent(txtHastaEdadBiberon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(panelPrimerosDiaVidaLayout.createSequentialGroup()
                        .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelPrimerosDiaVidaLayout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(145, 145, 145)
                                .addComponent(txtPorqueLeche))
                            .addGroup(panelPrimerosDiaVidaLayout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addGap(18, 18, 18)
                                .addComponent(jcxSiSuccionar)
                                .addGap(18, 18, 18)
                                .addComponent(jcxNoSuccionar))
                            .addGroup(panelPrimerosDiaVidaLayout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addGap(18, 18, 18)
                                .addComponent(txtEdadPrimerasPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPrimerosDiaVidaLayout.createSequentialGroup()
                                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel57))
                                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelPrimerosDiaVidaLayout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addComponent(txtComoFueDestete, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrimerosDiaVidaLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEdadSento, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEdadCamino, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(369, 369, 369)))))
                        .addGap(0, 163, Short.MAX_VALUE)))
                .addGap(37, 37, 37))
        );
        panelPrimerosDiaVidaLayout.setVerticalGroup(
            panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrimerosDiaVidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jcxSiLeche)
                    .addComponent(jcxNoLeche))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtPorqueLeche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtEdadDioLeche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jcxSiBiberon)
                    .addComponent(jcxNoBiberon)
                    .addComponent(jcxAmbos))
                .addGap(18, 18, 18)
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtDesdeEdadBiberon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(txtHastaEdadBiberon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jcxSiSuccionar)
                    .addComponent(jcxNoSuccionar))
                .addGap(18, 18, 18)
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtComoFueDestete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtEdadSento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtEdadCamino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrimerosDiaVidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txtEdadPrimerasPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(239, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Primeros dias de vida", panelPrimerosDiaVida);

        jLabel59.setText("¿A qué edad inicio su alimentación con sólidos?");

        jLabel60.setText("Dificultades en la alimentación");

        jLabel61.setText("¿Cuántas veces come al diá?");

        jLabel62.setText("¿Come solo o acompañado?");

        jLabel63.setText("Actitud de la madre cuando no come:");

        javax.swing.GroupLayout panelAlimentacionActualLayout = new javax.swing.GroupLayout(panelAlimentacionActual);
        panelAlimentacionActual.setLayout(panelAlimentacionActualLayout);
        panelAlimentacionActualLayout.setHorizontalGroup(
            panelAlimentacionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlimentacionActualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlimentacionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63)
                    .addComponent(jLabel60))
                .addGap(18, 18, 18)
                .addGroup(panelAlimentacionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInicioSolidos)
                    .addComponent(txtVecesComeDia)
                    .addComponent(txtComeSolooAcompanhado)
                    .addComponent(txtActitudMadre)
                    .addComponent(jtxtdificultadesAlimentacion, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                .addGap(79, 79, 79))
        );
        panelAlimentacionActualLayout.setVerticalGroup(
            panelAlimentacionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlimentacionActualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlimentacionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtInicioSolidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlimentacionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jtxtdificultadesAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlimentacionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(txtVecesComeDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlimentacionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(txtComeSolooAcompanhado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlimentacionActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(txtActitudMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(458, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Alimentacion actual", panelAlimentacionActual);

        jLabel64.setText("Desarrollo Motor Grueso");

        jcxNormalMotorGrueso.setText("Normal");

        jcxIrregularMotorGrueso.setText("Irregular");

        jLabel65.setText("Desarrollo Motor Fino");

        jcxNormalMotorFino.setText("Normal");

        jcxIrregularMotorFino.setText("Irregular");

        jLabel66.setText("¿Cómo son sus movimientos?");

        jLabel67.setText("Desarrollo Psico-social:");

        jLabel68.setText("Desarrollo Cognitivo:");

        jLabel69.setText("Desarrollo Físico:");

        jLabel70.setText("Su lenguaje actual es:");

        jcxClaro.setText("Claro");

        jcxNoMuyClaro.setText("No muy claro");

        jcxNoSeEntiende.setText("No se entiende");

        jLabel71.setText("Dificultad especifica(Explique)");

        javax.swing.GroupLayout panelDesarrolloMotorLenguajeLayout = new javax.swing.GroupLayout(panelDesarrolloMotorLenguaje);
        panelDesarrolloMotorLenguaje.setLayout(panelDesarrolloMotorLenguajeLayout);
        panelDesarrolloMotorLenguajeLayout.setHorizontalGroup(
            panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDesarrolloMotorLenguajeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDesarrolloMotorLenguajeLayout.createSequentialGroup()
                        .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69))
                        .addGap(18, 18, 18)
                        .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtComoSonMovimientos)
                            .addComponent(txtPsicoSocial)
                            .addComponent(txtCognitivo)
                            .addComponent(txtfisico)))
                    .addGroup(panelDesarrolloMotorLenguajeLayout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addGap(18, 18, 18)
                        .addComponent(txtDificultadEspecifique, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
                    .addGroup(panelDesarrolloMotorLenguajeLayout.createSequentialGroup()
                        .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65)
                            .addComponent(jLabel70))
                        .addGap(31, 31, 31)
                        .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDesarrolloMotorLenguajeLayout.createSequentialGroup()
                                .addComponent(jcxNormalMotorGrueso)
                                .addGap(18, 18, 18)
                                .addComponent(jcxIrregularMotorGrueso))
                            .addGroup(panelDesarrolloMotorLenguajeLayout.createSequentialGroup()
                                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcxNormalMotorFino)
                                    .addComponent(jcxClaro))
                                .addGap(18, 18, 18)
                                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDesarrolloMotorLenguajeLayout.createSequentialGroup()
                                        .addComponent(jcxNoMuyClaro)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcxNoSeEntiende))
                                    .addComponent(jcxIrregularMotorFino))))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        panelDesarrolloMotorLenguajeLayout.setVerticalGroup(
            panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDesarrolloMotorLenguajeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jcxNormalMotorGrueso)
                    .addComponent(jcxIrregularMotorGrueso))
                .addGap(18, 18, 18)
                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jcxNormalMotorFino)
                    .addComponent(jcxIrregularMotorFino))
                .addGap(18, 18, 18)
                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jcxClaro)
                    .addComponent(jcxNoMuyClaro)
                    .addComponent(jcxNoSeEntiende))
                .addGap(18, 18, 18)
                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(txtDificultadEspecifique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(txtComoSonMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(txtPsicoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(txtCognitivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDesarrolloMotorLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(txtfisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(333, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Desarrollo motor y del lenguaje actual", panelDesarrolloMotorLenguaje);

        jLabel72.setText("Duerme toda la noche");

        jcxSiDuerme.setText("Si");

        jcxNoDuerme.setText("No");

        jLabel73.setText("¿Cómo es el sueño?");

        jLabel74.setText("Tiene miedo de dormir solo");

        jcxSiMiedoDormir.setText("Si");

        jcxNoMiedoDormir.setText("No");

        jLabel75.setText("¿Cómo se despierta?");

        jLabel76.setText("Dice tener pesadillas");

        jcxSiPesadillas.setText("Si");

        jcxNoPesadillas.setText("No");

        jLabel77.setText("¿Con quién duerme?");

        jLabel78.setText("¿A qué edad controlo los esfínteres?");

        jLabel79.setText("Necesita ayuda para ir al baño");

        jcxSiAyudaBanho.setText("Si");

        jcxNoAyudaBanho.setText("No");

        jLabel80.setText("Presenta períodos de ecopresis");

        jcxSiEcopresis.setText("Si");

        jcxNoEcopresis.setText("No");

        jLabel81.setText("Alguna causa");

        jLabel82.setText("¿Moja la cama?");

        jcxSiMojaCama.setText("Si");

        jcxNoMojaCama.setText("No");

        javax.swing.GroupLayout panelSueñoEsfinteresLayout = new javax.swing.GroupLayout(panelSueñoEsfinteres);
        panelSueñoEsfinteres.setLayout(panelSueñoEsfinteresLayout);
        panelSueñoEsfinteresLayout.setHorizontalGroup(
            panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jcxSiEcopresis)
                                .addGap(18, 18, 18)
                                .addComponent(jcxNoEcopresis))
                            .addComponent(jLabel80))
                        .addGap(112, 112, 112)
                        .addComponent(jLabel81)
                        .addGap(128, 128, 128)
                        .addComponent(txtCausaEcopresis, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79)
                            .addComponent(jLabel72)
                            .addComponent(jLabel74)
                            .addComponent(jLabel76)
                            .addComponent(jLabel82))
                        .addGap(22, 22, 22)
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                                .addComponent(jcxSiMojaCama)
                                .addGap(18, 18, 18)
                                .addComponent(jcxNoMojaCama)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                                .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                                        .addComponent(jcxSiDuerme)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcxNoDuerme))
                                    .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                                        .addComponent(jcxSiMiedoDormir)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcxNoMiedoDormir))
                                    .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                                        .addComponent(jcxSiPesadillas)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcxNoPesadillas))
                                    .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                                        .addComponent(jcxSiAyudaBanho)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcxNoAyudaBanho)))
                                .addGap(112, 112, 112)
                                .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(jLabel75))
                                        .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel73))
                                    .addComponent(jLabel77))
                                .addGap(18, 18, 18)
                                .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtComoDuerme)
                                    .addComponent(txtComoDespierta)
                                    .addComponent(txtConQuienDuerme)
                                    .addComponent(txtEdadEsfinteres))
                                .addGap(23, 23, 23))))))
        );
        panelSueñoEsfinteresLayout.setVerticalGroup(
            panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(txtComoDuerme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(txtComoDespierta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77)
                            .addComponent(txtConQuienDuerme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel78)
                            .addComponent(txtEdadEsfinteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSueñoEsfinteresLayout.createSequentialGroup()
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(jcxSiDuerme)
                            .addComponent(jcxNoDuerme))
                        .addGap(18, 18, 18)
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(jcxSiMiedoDormir)
                            .addComponent(jcxNoMiedoDormir))
                        .addGap(18, 18, 18)
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(jcxSiPesadillas)
                            .addComponent(jcxNoPesadillas))
                        .addGap(47, 47, 47)
                        .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcxSiAyudaBanho)
                            .addComponent(jcxNoAyudaBanho)
                            .addComponent(jLabel79))))
                .addGap(18, 18, 18)
                .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jcxSiMojaCama)
                    .addComponent(jcxNoMojaCama))
                .addGap(18, 18, 18)
                .addGroup(panelSueñoEsfinteresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jcxSiEcopresis)
                    .addComponent(jcxNoEcopresis)
                    .addComponent(jLabel81)
                    .addComponent(txtCausaEcopresis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(371, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Sueño y control de esfínteres", panelSueñoEsfinteres);

        jLabel83.setText("El NNA estudia");

        jcxSiEstudia.setText("Si");

        jcxNoEstudia.setText("No");

        jLabel84.setText("Explique por qué");

        jLabel85.setText("Nombre de la institución a la que asisitía o asiste:");

        jLabel86.setText("Año de Básica que cursa o el último que estudio:");

        jLabel87.setText("Repetición de año de basica y causas:");

        jLabel88.setText("El NNA ha presentado problemas de aprendizaje");

        jcxSiAprendizaje.setText("Si");

        jcxNoAprendizaje.setText("No");

        jLabel89.setText("¿Cuáles?");

        jLabel90.setText("Asiste a programas de apoyo o nivelación escolar ");

        jcxSiNivelacion.setText("Si");

        jcxNoNivelacion.setText("No");

        jLabel91.setText("¿Cuáles?");

        javax.swing.GroupLayout panelEscolarizacionNNALayout = new javax.swing.GroupLayout(panelEscolarizacionNNA);
        panelEscolarizacionNNA.setLayout(panelEscolarizacionNNALayout);
        panelEscolarizacionNNALayout.setHorizontalGroup(
            panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEscolarizacionNNALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelEscolarizacionNNALayout.createSequentialGroup()
                        .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel88)
                            .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelEscolarizacionNNALayout.createSequentialGroup()
                                    .addComponent(jcxSiAprendizaje)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcxNoAprendizaje))
                                .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelEscolarizacionNNALayout.createSequentialGroup()
                                        .addComponent(jLabel83)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcxSiEstudia)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcxNoEstudia))
                                    .addGroup(panelEscolarizacionNNALayout.createSequentialGroup()
                                        .addComponent(jLabel90)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcxSiNivelacion)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcxNoNivelacion)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91)
                            .addComponent(jLabel89))
                        .addGap(63, 63, 63)
                        .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEspecifiqueAprendizaje)
                            .addComponent(txtEspecifiqueNivelacion, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(panelEscolarizacionNNALayout.createSequentialGroup()
                        .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel85)
                            .addComponent(jLabel87)
                            .addComponent(jLabel86))
                        .addGap(18, 18, 18)
                        .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelEscolarizacionNNALayout.createSequentialGroup()
                                    .addComponent(jLabel84)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtExpliqueEstudia, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                                .addComponent(txtNombreInstitucion)
                                .addComponent(txtAnhoCursa))
                            .addComponent(txtAnhoRepite))))
                .addGap(80, 80, 80))
        );
        panelEscolarizacionNNALayout.setVerticalGroup(
            panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEscolarizacionNNALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel84)
                        .addComponent(txtExpliqueEstudia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEscolarizacionNNALayout.createSequentialGroup()
                        .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombreInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEscolarizacionNNALayout.createSequentialGroup()
                                .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel83)
                                    .addComponent(jcxSiEstudia)
                                    .addComponent(jcxNoEstudia))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel85)))
                        .addGap(18, 18, 18)
                        .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel86)
                            .addComponent(txtAnhoCursa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(txtAnhoRepite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(jcxSiAprendizaje)
                            .addComponent(jcxNoAprendizaje)
                            .addComponent(jLabel89)
                            .addComponent(txtEspecifiqueAprendizaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEscolarizacionNNALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel90)
                            .addComponent(jcxSiNivelacion)
                            .addComponent(jcxNoNivelacion)
                            .addComponent(jLabel91)
                            .addComponent(txtEspecifiqueNivelacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(415, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Escolarizacion del niño, niña o adolescente", panelEscolarizacionNNA);

        jLabel92.setText("Familiares con problemas:");

        jcxSindromeDown.setText("Síndrome de down");

        jcxEpilepsia.setText("Epilepsia");

        jcxAlcoholismo.setText("Alcoholismo");

        jcxDiscapacidadIntelectual.setText("Discapacidad Intelectual");

        jLabel93.setText("Otro Especifique");

        jLabel94.setText("Problemas respiratorios del NNA");

        jcxSiProblemasRespiratorios.setText("Si");

        jcxNoProblemasRespiratorios.setText("No");

        jLabel95.setText("Especifique");

        jLabel96.setText("Problemas de alergias del NNA");

        jcxSiAlergias.setText("Si");

        jcxNoAlergias.setText("No");

        jLabel97.setText("Especifique");

        jLabel98.setText("Problemas Neurológicos en el NNA");

        jcxSiNeurologicos.setText("Si");

        jcxNoNeurologicos.setText("No");

        jLabel99.setText("Especifique");

        jLabel100.setText("Problemas nerviosos del NNA");

        jcxSiNerviosos.setText("Si");

        jcxNoNerviosos.setText("No");

        jLabel101.setText("Especifique");

        javax.swing.GroupLayout panelSaludLayout = new javax.swing.GroupLayout(panelSalud);
        panelSalud.setLayout(panelSaludLayout);
        panelSaludLayout.setHorizontalGroup(
            panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaludLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSaludLayout.createSequentialGroup()
                        .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSaludLayout.createSequentialGroup()
                                .addComponent(jLabel92)
                                .addGap(18, 18, 18)
                                .addComponent(jcxSindromeDown)
                                .addGap(18, 18, 18)
                                .addComponent(jcxEpilepsia))
                            .addGroup(panelSaludLayout.createSequentialGroup()
                                .addComponent(jLabel94)
                                .addGap(28, 28, 28)
                                .addComponent(jcxSiProblemasRespiratorios)
                                .addGap(18, 18, 18)
                                .addComponent(jcxNoProblemasRespiratorios)))
                        .addGap(18, 18, 18)
                        .addComponent(jcxAlcoholismo)
                        .addGap(18, 18, 18)
                        .addComponent(jcxDiscapacidadIntelectual))
                    .addGroup(panelSaludLayout.createSequentialGroup()
                        .addComponent(jLabel96)
                        .addGap(36, 36, 36)
                        .addComponent(jcxSiAlergias)
                        .addGap(18, 18, 18)
                        .addComponent(jcxNoAlergias))
                    .addGroup(panelSaludLayout.createSequentialGroup()
                        .addComponent(jLabel100)
                        .addGap(48, 48, 48)
                        .addComponent(jcxSiNerviosos)
                        .addGap(18, 18, 18)
                        .addComponent(jcxNoNerviosos))
                    .addGroup(panelSaludLayout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addGap(18, 18, 18)
                        .addComponent(jcxSiNeurologicos)
                        .addGap(18, 18, 18)
                        .addComponent(jcxNoNeurologicos))
                    .addGroup(panelSaludLayout.createSequentialGroup()
                        .addComponent(jLabel101)
                        .addGap(55, 55, 55)
                        .addComponent(txtEspecifiqueNerviosos))
                    .addGroup(panelSaludLayout.createSequentialGroup()
                        .addComponent(jLabel99)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEspecifiqueNeurologicos, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSaludLayout.createSequentialGroup()
                        .addComponent(jLabel97)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEspecifiqueAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSaludLayout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addGap(50, 50, 50)
                        .addComponent(txtEspecifiqueProblemasRespiratorios))
                    .addGroup(panelSaludLayout.createSequentialGroup()
                        .addComponent(jLabel93)
                        .addGap(18, 18, 18)
                        .addComponent(txtOtroEspecifique, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        panelSaludLayout.setVerticalGroup(
            panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaludLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(jcxSindromeDown)
                    .addComponent(jcxEpilepsia)
                    .addComponent(jcxAlcoholismo)
                    .addComponent(jcxDiscapacidadIntelectual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(txtOtroEspecifique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(jcxSiProblemasRespiratorios)
                    .addComponent(jcxNoProblemasRespiratorios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(txtEspecifiqueProblemasRespiratorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jcxSiAlergias)
                    .addComponent(jcxNoAlergias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(txtEspecifiqueAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(jcxSiNeurologicos)
                    .addComponent(jcxNoNeurologicos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(txtEspecifiqueNeurologicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(jcxSiNerviosos)
                    .addComponent(jcxNoNerviosos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(txtEspecifiqueNerviosos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(319, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Salud", panelSalud);

        jLabel102.setText("Clima Familiar");

        jLabel103.setText("Relación del NNA con el Padre");

        jLabel104.setText("Relación del NNA con la Madre");

        jLabel105.setText("Relación del NNA con los hermanos/as");

        jLabel106.setText("El NNA ha trabajado alguna vez");

        jcxSiTrabajo.setText("Si");

        jcxNoTrabajo.setText("No");

        jLabel107.setText("¿En qué?");

        jLabel108.setText("¿El agresor agrede también al NNA?");

        jcxSiAgrede.setText("Si");

        jcxNoAgrede.setText("No");

        jLabel109.setText("¿Con qué frecuencia?");

        jLabel110.setText("¿Qué utiliza?");

        jLabel111.setText("¿Qué obligaciones tiene el NNA en la familia?");

        jLabel112.setText("Proyección de la madre con el NNA");

        jLabel113.setText("¿Alguna necesidad inmediata del grupo familiar?");

        javax.swing.GroupLayout panelRelacionFamiliarLayout = new javax.swing.GroupLayout(panelRelacionFamiliar);
        panelRelacionFamiliar.setLayout(panelRelacionFamiliarLayout);
        panelRelacionFamiliarLayout.setHorizontalGroup(
            panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRelacionFamiliarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel108)
                    .addComponent(jLabel105)
                    .addComponent(jLabel106)
                    .addComponent(jLabel104)
                    .addComponent(jLabel103)
                    .addComponent(jLabel102)
                    .addGroup(panelRelacionFamiliarLayout.createSequentialGroup()
                        .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel113)
                            .addComponent(jLabel110)
                            .addComponent(jLabel111)
                            .addComponent(jLabel112))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtObligacionesenlaFamilia)
                            .addComponent(txtProyeciondelaMadre)
                            .addComponent(txtQueUtiliza)
                            .addComponent(txtNecesidadGrupoFamiliar)))
                    .addGroup(panelRelacionFamiliarLayout.createSequentialGroup()
                        .addComponent(jLabel107)
                        .addGap(237, 237, 237)
                        .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRelacionFamiliarLayout.createSequentialGroup()
                                .addComponent(jcxSiTrabajo)
                                .addGap(18, 18, 18)
                                .addComponent(jcxNoTrabajo))
                            .addComponent(txtClimaFamiliar, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                            .addComponent(txtRelacionPadre)
                            .addComponent(txtRelacionMadre)
                            .addComponent(txtRelacionHermanos)
                            .addComponent(txtEnqueaTrabajo)))
                    .addGroup(panelRelacionFamiliarLayout.createSequentialGroup()
                        .addComponent(jLabel109)
                        .addGap(166, 166, 166)
                        .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRelacionFamiliarLayout.createSequentialGroup()
                                .addComponent(jcxSiAgrede)
                                .addGap(18, 18, 18)
                                .addComponent(jcxNoAgrede))
                            .addComponent(txtFrecuenciaAgresorAgrede, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        panelRelacionFamiliarLayout.setVerticalGroup(
            panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRelacionFamiliarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(txtClimaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(txtRelacionPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(txtRelacionMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(txtRelacionHermanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(jcxSiTrabajo)
                    .addComponent(jcxNoTrabajo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(txtEnqueaTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108)
                    .addComponent(jcxSiAgrede)
                    .addComponent(jcxNoAgrede))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(txtFrecuenciaAgresorAgrede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(txtQueUtiliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(txtObligacionesenlaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(txtProyeciondelaMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRelacionFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(txtNecesidadGrupoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Relacion familiar", panelRelacionFamiliar);

        txAObservaciones.setColumns(20);
        txAObservaciones.setRows(5);
        jScrollPane3.setViewportView(txAObservaciones);

        javax.swing.GroupLayout panelObservacionesGeneralesLayout = new javax.swing.GroupLayout(panelObservacionesGenerales);
        panelObservacionesGenerales.setLayout(panelObservacionesGeneralesLayout);
        panelObservacionesGeneralesLayout.setHorizontalGroup(
            panelObservacionesGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObservacionesGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        panelObservacionesGeneralesLayout.setVerticalGroup(
            panelObservacionesGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObservacionesGeneralesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(468, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Observaciones generales", panelObservacionesGenerales);

        jScrollPane4.setViewportView(jtpPrincipal);

        jLabel129.setText("Apellido:");

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnGuardar.setText("Guardar");

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(357, 357, 357))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelFondoLayout.createSequentialGroup()
                                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelFondoLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panelFondoLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(82, 82, 82)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(137, 137, 137)
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(34, 34, 34)
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdcFechaElaboracion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addComponent(jSeparator7)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(273, 273, 273))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(25, 25, 25))))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFechaElaboracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel129))
                .addGap(21, 21, 21)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNaconalidadMadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNaconalidadMadreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNaconalidadMadreActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

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
            java.util.logging.Logger.getLogger(FichaAnamnesis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaAnamnesis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaAnamnesis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaAnamnesis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaAnamnesis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrmFamiliares;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFamiliares_anadirFamiliar;
    private javax.swing.JButton btnFamiliares_cancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxEmbarazoPlanificado;
    private javax.swing.JComboBox<String> cbxFamiliares_estadoCivil;
    private javax.swing.JComboBox<String> cbxFamiliares_instruccionAcademica;
    private javax.swing.JComboBox<String> cbxFamiliares_sexo;
    private javax.swing.JComboBox<String> cbxPadreAgresor;
    private javax.swing.JComboBox<String> cbxPoseeCedula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
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
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JCheckBox jcxAbusoSexual;
    private javax.swing.JCheckBox jcxAlcohol;
    private javax.swing.JCheckBox jcxAlcoholismo;
    private javax.swing.JCheckBox jcxAmbitoLaboral;
    private javax.swing.JCheckBox jcxAmbos;
    private javax.swing.JCheckBox jcxBajoPeso;
    private javax.swing.JCheckBox jcxCesarea;
    private javax.swing.JCheckBox jcxClaro;
    private javax.swing.JCheckBox jcxDepresion;
    private javax.swing.JCheckBox jcxDiscapacidadIntelectual;
    private javax.swing.JCheckBox jcxDroga;
    private javax.swing.JCheckBox jcxEpilepsia;
    private javax.swing.JCheckBox jcxGolpes;
    private javax.swing.JCheckBox jcxHemorragias;
    private javax.swing.JCheckBox jcxHipersencibilidad;
    private javax.swing.JCheckBox jcxInfecciones;
    private javax.swing.JCheckBox jcxInsultos;
    private javax.swing.JCheckBox jcxIrregularMotorFino;
    private javax.swing.JCheckBox jcxIrregularMotorGrueso;
    private javax.swing.JCheckBox jcxMensual;
    private javax.swing.JCheckBox jcxNegligencia;
    private javax.swing.JCheckBox jcxNinguna;
    private javax.swing.JCheckBox jcxNoAborto;
    private javax.swing.JCheckBox jcxNoAgrede;
    private javax.swing.JCheckBox jcxNoAlergias;
    private javax.swing.JCheckBox jcxNoAnestesia;
    private javax.swing.JCheckBox jcxNoAprendizaje;
    private javax.swing.JCheckBox jcxNoAyudaBanho;
    private javax.swing.JCheckBox jcxNoBiberon;
    private javax.swing.JCheckBox jcxNoComplicaciones;
    private javax.swing.JCheckBox jcxNoConsume;
    private javax.swing.JCheckBox jcxNoControles;
    private javax.swing.JCheckBox jcxNoDuerme;
    private javax.swing.JCheckBox jcxNoEcopresis;
    private javax.swing.JCheckBox jcxNoEstudia;
    private javax.swing.JCheckBox jcxNoLeche;
    private javax.swing.JCheckBox jcxNoLloro;
    private javax.swing.JCheckBox jcxNoMiedoDormir;
    private javax.swing.JCheckBox jcxNoMojaCama;
    private javax.swing.JCheckBox jcxNoMuyClaro;
    private javax.swing.JCheckBox jcxNoNerviosos;
    private javax.swing.JCheckBox jcxNoNeurologicos;
    private javax.swing.JCheckBox jcxNoNivelacion;
    private javax.swing.JCheckBox jcxNoOxigeno;
    private javax.swing.JCheckBox jcxNoPesadillas;
    private javax.swing.JCheckBox jcxNoProblemasRespiratorios;
    private javax.swing.JCheckBox jcxNoSeEntiende;
    private javax.swing.JCheckBox jcxNoSexo;
    private javax.swing.JCheckBox jcxNoSuccionar;
    private javax.swing.JCheckBox jcxNoTrabajo;
    private javax.swing.JCheckBox jcxNoViolencia;
    private javax.swing.JCheckBox jcxNormal;
    private javax.swing.JCheckBox jcxNormalMotorFino;
    private javax.swing.JCheckBox jcxNormalMotorGrueso;
    private javax.swing.JCheckBox jcxPreclansia;
    private javax.swing.JCheckBox jcxSiAborto;
    private javax.swing.JCheckBox jcxSiAgrede;
    private javax.swing.JCheckBox jcxSiAlergias;
    private javax.swing.JCheckBox jcxSiAnestesia;
    private javax.swing.JCheckBox jcxSiAprendizaje;
    private javax.swing.JCheckBox jcxSiAyudaBanho;
    private javax.swing.JCheckBox jcxSiBiberon;
    private javax.swing.JCheckBox jcxSiComplicaciones;
    private javax.swing.JCheckBox jcxSiConsume;
    private javax.swing.JCheckBox jcxSiControles;
    private javax.swing.JCheckBox jcxSiDuerme;
    private javax.swing.JCheckBox jcxSiEcopresis;
    private javax.swing.JCheckBox jcxSiEstudia;
    private javax.swing.JCheckBox jcxSiLeche;
    private javax.swing.JCheckBox jcxSiLloro;
    private javax.swing.JCheckBox jcxSiMiedoDormir;
    private javax.swing.JCheckBox jcxSiMojaCama;
    private javax.swing.JCheckBox jcxSiNerviosos;
    private javax.swing.JCheckBox jcxSiNeurologicos;
    private javax.swing.JCheckBox jcxSiNivelacion;
    private javax.swing.JCheckBox jcxSiOxigeno;
    private javax.swing.JCheckBox jcxSiPesadillas;
    private javax.swing.JCheckBox jcxSiProblemasRespiratorios;
    private javax.swing.JCheckBox jcxSiSexo;
    private javax.swing.JCheckBox jcxSiSuccionar;
    private javax.swing.JCheckBox jcxSiTrabajo;
    private javax.swing.JCheckBox jcxSiViolencia;
    private javax.swing.JCheckBox jcxSindromeDown;
    private javax.swing.JCheckBox jcxTabaco;
    private javax.swing.JCheckBox jcxTrimestral;
    private javax.swing.JCheckBox jcxUnaVez;
    private com.toedter.calendar.JDateChooser jdcFechaElaboracion;
    private com.toedter.calendar.JDateChooser jdcFechaNacimientoNNA;
    private javax.swing.JTabbedPane jtpPrincipal;
    private javax.swing.JTextField jtxtdificultadesAlimentacion;
    private javax.swing.JPanel panelAlimentacionActual;
    private javax.swing.JPanel panelComposicionFamiliar;
    private javax.swing.JPanel panelCondicionesNacimiento;
    private javax.swing.JPanel panelDatosIdentificacion;
    private javax.swing.JPanel panelDatosMadrePadre;
    private javax.swing.JPanel panelDesarrolloMotorLenguaje;
    private javax.swing.JPanel panelEscolarizacionNNA;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelObservacionesGenerales;
    private javax.swing.JPanel panelPeriodoEmbarazo;
    private javax.swing.JPanel panelPrimerosDiaVida;
    private javax.swing.JPanel panelRelacionFamiliar;
    private javax.swing.JPanel panelSalud;
    private javax.swing.JPanel panelSueñoEsfinteres;
    private javax.swing.JPanel pnlAgregarFamilar;
    private javax.swing.JTable tabComposicionFamiliarNNA;
    private javax.swing.JTextArea txAObservaciones;
    private javax.swing.JTextArea txaSituacionIngresaNNA;
    private javax.swing.JTextField txtActitudMadre;
    private javax.swing.JTextField txtAnhoCursa;
    private javax.swing.JTextField txtAnhoRepite;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoMadre;
    private javax.swing.JTextField txtApellidoPadre;
    private javax.swing.JTextField txtCausaEcopresis;
    private javax.swing.JTextField txtCausasAborto;
    private javax.swing.JTextField txtCausasConsumo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtClimaFamiliar;
    public static javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCognitivo;
    private javax.swing.JTextField txtComeSolooAcompanhado;
    private javax.swing.JTextField txtComoDespierta;
    private javax.swing.JTextField txtComoDuerme;
    private javax.swing.JTextField txtComoFueDestete;
    private javax.swing.JTextField txtComoSonMovimientos;
    private javax.swing.JTextField txtConQuienDuerme;
    private javax.swing.JTextField txtDesdeEdadBiberon;
    private javax.swing.JTextField txtDificultadEspecifique;
    private javax.swing.JTextField txtDondeRealizoControles;
    private javax.swing.JTextField txtEdadCamino;
    private javax.swing.JTextField txtEdadDioLeche;
    private javax.swing.JTextField txtEdadEsfinteres;
    private javax.swing.JTextField txtEdadMadre;
    private javax.swing.JTextField txtEdadNNA;
    private javax.swing.JTextField txtEdadPadre;
    private javax.swing.JTextField txtEdadPrimerasPalabras;
    private javax.swing.JTextField txtEdadSento;
    private javax.swing.JTextField txtEnqueaTrabajo;
    private javax.swing.JTextField txtEspecifiqueAlergias;
    private javax.swing.JTextField txtEspecifiqueAprendizaje;
    private javax.swing.JTextField txtEspecifiqueNerviosos;
    private javax.swing.JTextField txtEspecifiqueNeurologicos;
    private javax.swing.JTextField txtEspecifiqueNivelacion;
    private javax.swing.JTextField txtEspecifiqueProblemasRespiratorios;
    private javax.swing.JTextField txtExpliqueEstudia;
    private javax.swing.JTextField txtFamiliares_apellidos;
    private javax.swing.JTextField txtFamiliares_edad;
    private javax.swing.JTextField txtFamiliares_nombres;
    private javax.swing.JTextField txtFamiliares_ocupacion;
    private javax.swing.JTextField txtFamiliares_parentesco;
    private javax.swing.JTextField txtFrecuenciaAgresorAgrede;
    private javax.swing.JTextField txtHastaEdadBiberon;
    private javax.swing.JTextField txtInicioSolidos;
    private javax.swing.JTextField txtLugarNacNNA1;
    private javax.swing.JTextField txtLugarParto;
    private javax.swing.JTextField txtMesAlumbramiento;
    private javax.swing.JTextField txtMotivoCesarea;
    private javax.swing.JTextField txtNacionalidadNNA;
    private javax.swing.JTextField txtNacionalidadPadre;
    private javax.swing.JTextField txtNaconalidadMadre;
    private javax.swing.JTextField txtNecesidadGrupoFamiliar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreInstitucion;
    private javax.swing.JTextField txtNombreMadre;
    private javax.swing.JTextField txtNombrePadre;
    private javax.swing.JTextField txtObligacionesenlaFamilia;
    private javax.swing.JTextField txtOtraComplicacionEmbarazo;
    private javax.swing.JTextField txtOtroEspecifique;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPorqueLeche;
    private javax.swing.JTextField txtProyeciondelaMadre;
    private javax.swing.JTextField txtPsicoSocial;
    private javax.swing.JTextField txtQueUtiliza;
    private javax.swing.JTextField txtReaccionMadre;
    private javax.swing.JTextField txtReaccionMama;
    private javax.swing.JTextField txtReaccionPadre;
    private javax.swing.JTextField txtReaccionPapa;
    private javax.swing.JTextField txtRelacionHermanos;
    private javax.swing.JTextField txtRelacionMadre;
    private javax.swing.JTextField txtRelacionPadre;
    private javax.swing.JTextField txtTalla;
    private javax.swing.JTextField txtVecesComeDia;
    private javax.swing.JTextField txtfisico;
    // End of variables declaration//GEN-END:variables
}
