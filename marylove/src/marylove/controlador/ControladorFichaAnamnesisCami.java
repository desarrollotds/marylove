/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import marylove.DBmodelo.Embarazo_estadoDB;
import marylove.DBmodelo.FamiliaresDB;
import marylove.DBmodelo.FichaAnamnesisBD;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.NacimientoDB;
import marylove.DBmodelo.PadreDB;
import marylove.models.Hijos;
import marylove.models.Padre;
import marylove.vista.FichaAnamnesis;

/**
 *
 * @author Usuario
 */
public class ControladorFichaAnamnesisCami extends Validaciones implements ActionListener {

    private FichaAnamnesis vistaAnamnesis;
    private FichaAnamnesisBD modeloAnamnesisBD;

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ControladorFichaAnamnesisCami() throws Exception {
    }

    public ControladorFichaAnamnesisCami(FichaAnamnesis vistaAnamnesis, FichaAnamnesisBD modeloAnamnesisBD) throws Exception {
        this.vistaAnamnesis = vistaAnamnesis;
        this.modeloAnamnesisBD = modeloAnamnesisBD;
    }

    public void iniciarControl() {
    }

    public void creacionObjetos() {

        //1.1 DATOS DE IDENTIFICACIÓN
        HijosDB modeloHijosDB = new HijosDB();
        modeloHijosDB.setPersona_fecha_nac(fechaBD(vistaAnamnesis.getJdcFechaNacimientoNNA().getDate().getTime()));
        modeloHijosDB.setPersona_nacionalidad(0);//INGRESAREMOS EL ID DE LA NACIONALIDAD QUE EXISTE EN EL JSON DE NACIONALIDADES

        NacimientoDB modeloNacimientoDB = new NacimientoDB();
        modeloNacimientoDB.setLugar_nacimiento(vistaAnamnesis.getTxtLugarNacNNA1().getText());

        //1.2 DATOS DE LA MADRE Y EL PADRE ---- 1.3 SITUACIÓN DE INGRESO NNA
        PadreDB modeloPadreDB = new PadreDB();
        modeloPadreDB.setPersona_apellido(vistaAnamnesis.getTxtNombrePadre().getText());
        modeloPadreDB.setPersona_nacionalidad(0);//INGRESO DESDE EL JSON
        //edad por verse

        if (vistaAnamnesis.getCbxPadreAgresor().getSelectedItem().toString() == "Si") {
            modeloHijosDB.setPadre_agresor(true);
        } else {
            modeloHijosDB.setPadre_agresor(false);
        }

        modeloHijosDB.setHijo_estado_ingreso(vistaAnamnesis.getTxaSituacionIngresaNNA().getText());

        //1.4 COMPOSICIÓN FAMILIAR DEL NNA
        FamiliaresDB modeloFamiliaresDB = new FamiliaresDB();
        modeloFamiliaresDB.setPersona_nombre(vistaAnamnesis.getTxtFamiliares_nombres().getText());
        modeloFamiliaresDB.setPersona_apellido(vistaAnamnesis.getTxtFamiliares_apellidos().getText());
        modeloFamiliaresDB.setPersona_ocupacion(0);//CONSULTA EL ID EN EL JSON
        modeloFamiliaresDB.setParentesco(vistaAnamnesis.getTxtFamiliares_parentesco().getText());

        if (null != vistaAnamnesis.getCbxFamiliares_sexo().getSelectedItem().toString()) {
            switch (vistaAnamnesis.getCbxFamiliares_sexo().getSelectedItem().toString()) {
                case "Masculino":
                    modeloFamiliaresDB.setPersona_sexo('M');
                    break;
                case "Femenino":
                    modeloFamiliaresDB.setPersona_sexo('F');
                    break;
                case "Sin especificar":
                    modeloFamiliaresDB.setPersona_sexo('S');
                    break;
                default:
                    break;
            }
        }

        modeloFamiliaresDB.setPersona_estadocivil(0);//CONSULTA EL ID EN EL JSON 
        modeloFamiliaresDB.setPersona_nivel_acad(0);//CONSULTA EL ID EN EL JSON

        //1.5 PERIODO DE EMBARAZO
        Embarazo_estadoDB modeloEmbarazo_estadoDB = new Embarazo_estadoDB();

        if (vistaAnamnesis.getCbxEmbarazoPlanificado().getSelectedItem().toString() == "Si") {
            modeloEmbarazo_estadoDB.setEmbarazo_planificado(true);
        } else {
            modeloEmbarazo_estadoDB.setEmbarazo_planificado(false);
        }

        modeloEmbarazo_estadoDB.setEmbarazo_reaccion_padre(vistaAnamnesis.getTxtReaccionPapa().toString());
        modeloEmbarazo_estadoDB.setEmbarazo_reaccion_madre(vistaAnamnesis.getTxtReaccionMama().toString());

        //1.6 NACIMIENTO
        modeloNacimientoDB.setMes_alumbramiento(0);//POR DEFINIR

    }

    public void validarCampos() {
        if (vistaAnamnesis.getTxtFamiliares_nombres().getText().equals("")
                || vistaAnamnesis.getTxtFamiliares_apellidos().getText().equals("")
                || vistaAnamnesis.getTxtFamiliares_edad().getText().equals("")
                || vistaAnamnesis.getTxtFamiliares_ocupacion().getText().equals("")
                || vistaAnamnesis.getTxtFamiliares_parentesco().getText().equals("")) {
            validarComboBoxSexo();
            validarEstadoCivil();
            validarIntitucionAcademica();
            JOptionPane.showMessageDialog(null, "LLene todos los campos.");
        } else {
            //codigo
        }
    }

    public void validarComboBoxSexo() {
        String seleccion = vistaAnamnesis.getCbxFamiliares_sexo().toString();
        if (seleccion.equals("Masculino") || seleccion.equals("Femenino") || seleccion.equals("Sin especificar")) {
            System.out.println("Selecciono un estado civil");
        } else {

            JOptionPane.showMessageDialog(null, "No ha seleccionado el sexo.");
        }

    }

    public void validarEstadoCivil() {
        String selec = vistaAnamnesis.getCbxFamiliares_estadoCivil().toString();
        if (selec.equals("Soltero") || selec.equals("Casado") || selec.equals("Viudo") || selec.equals("Divorciado") || selec.equals("Unión libre")) {
            System.out.println("Estado civil seleccionado");
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado un estado civil.");
        }
    }

    public void validarIntitucionAcademica() {
        String selec = vistaAnamnesis.getCbxFamiliares_estadoCivil().toString();
        if (selec.equals("No aplica") || selec.equals("Educación primaria") || selec.equals("Educación secundaria") || selec.equals("Educación de tercer nivel") || selec.equals("Educación de cuarto nivel")) {
            System.out.println("Estado intituto seleccionado");
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado una Institucion Academica.");
        }
    }

    //----------------------------------------Validaciones Nuevas
    //validaciones punto 1.5
    public boolean periodoEmbarazoValida() {
        if (null != vistaAnamnesis.getCbxEmbarazoPlanificado().getSelectedItem().toString()
                || vistaAnamnesis.getTxtReaccionPadre().getText().equals("")
                || vistaAnamnesis.getTxtReaccionMama().getText().equals("")
                || vistaAnamnesis.getTxtDondeRealizoControles().getText().equals("")
                || vistaAnamnesis.getTxtReaccionMama().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
            return false;
        } else {
            //---codigo
            return true;
        }

    }

    public boolean checksValidacion() {
        // pregunta sufrio episodios de violencia
        if (vistaAnamnesis.getJcxSiViolencia().isSelected() == false
                && vistaAnamnesis.getJcxNoViolencia().isSelected() == false
                && vistaAnamnesis.getJcxGolpes().isSelected() == false
                && vistaAnamnesis.getJcxAbusoSexual().isSelected() == false
                && vistaAnamnesis.getJcxInsultos().isSelected() == false
                && vistaAnamnesis.getJcxNegligencia().isSelected() == false
                && vistaAnamnesis.getJcxAmbitoLaboral().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccine una opcion en sufrio episodios de violencia");
            return false;
            //pregunta realizo controles medicos
        } else if (vistaAnamnesis.getJcxSiControles().isSelected() == false
                && vistaAnamnesis.getJcxNoControles().isSelected() == false
                && vistaAnamnesis.getJcxMensual().isSelected() == false
                && vistaAnamnesis.getJcxUnaVez().isSelected() == false
                && vistaAnamnesis.getJcxTrimestral().isSelected() == false
                && vistaAnamnesis.getJcxNinguna().isSelected() == false) {

            JOptionPane.showMessageDialog(null, "Seleccine una opcion en realizo controles medicos");
            return false;
            // pregunta complicaciones en el embarazo
        } else if (vistaAnamnesis.getJcxSiComplicaciones().isSelected() == false
                && vistaAnamnesis.getJcxNoComplicaciones().isSelected() == false
                && vistaAnamnesis.getJcxBajoPeso().isSelected() == false
                && vistaAnamnesis.getJcxHemorragias().isSelected() == false
                && vistaAnamnesis.getJcxInfecciones().isSelected() == false
                && vistaAnamnesis.getJcxNoViolencia().isSelected() == false
                && vistaAnamnesis.getJcxPreclansia().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccine una opcion en complicaciones de el embarazo");
            return false;
            // pregunta hubo consumo en el embarazo
        } else if (vistaAnamnesis.getJcxSiConsume().isSelected() == false
                && vistaAnamnesis.getJcxNoConsume().isSelected() == false
                && vistaAnamnesis.getJcxTabaco().isSelected() == false
                && vistaAnamnesis.getJcxAlcohol().isSelected() == false
                && vistaAnamnesis.getJcxDroga().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccine una opcion si realizo algun tipo de consumo");
            return false;
            // pregunta tentativas de aborto
        } else if (vistaAnamnesis.getJcxNoViolencia().isSelected() == false
                && vistaAnamnesis.getJcxSiAborto().isSelected() == false
                && vistaAnamnesis.getJcxNoAborto().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccine una opcion en tentatica de aborto");
            return false;
        } else {
            return true;
        }

    }
//------------------ validaciones 1.6

    // validacion de la parte de los txt
    public boolean validaCondicionesNaci() {
        if (vistaAnamnesis.getTxtMesAlumbramiento().getText().equals("")
                || vistaAnamnesis.getTxtLugarParto().getText().equals("")
                || vistaAnamnesis.getTxtTalla().getText().equals("")
                || vistaAnamnesis.getTxtPeso().getText().equals("")
                || vistaAnamnesis.getTxtReaccionMadre().getText().equals("")
                || vistaAnamnesis.getTxtReaccionPadre().getText().equals("")) {
            return false;
        } else {
            return true;
        }

    }

// validacion de los checks
    public boolean validaChecksCondi() {
        //pregunta tipo de parto
        if (vistaAnamnesis.getJcxNormal().isSelected() == false
                && vistaAnamnesis.getJcxCesarea().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en tipo de parto");
            return false;
            // pregunta utilizaon anastesia
        } else if (vistaAnamnesis.getJcxSiAnestesia().isSelected() == false
                && vistaAnamnesis.getJcxNoAnestesia().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en utilizaron anestesia");
            return false;
            // pregunta lloro al nacer
        } else if (vistaAnamnesis.getJcxSiLloro().isSelected() == false
                && vistaAnamnesis.getJcxNoLloro().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en lloro al nacer");
            return false;
            //  pregunta necesito oxigeno
        } else if (vistaAnamnesis.getJcxSiOxigeno().isSelected() == false
                && vistaAnamnesis.getJcxNoOxigeno().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en necesito oxigeno");
            return false;
            // pregunta como se sintio despues del parto
        } else if (vistaAnamnesis.getJcxDepresion().isSelected() == false
                && vistaAnamnesis.getJcxHipersencibilidad().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en desoues del parto");
            return false;
            // pregunta fue del sexo esperado
        } else if (vistaAnamnesis.getJcxSiSexo().isSelected() == false
                && vistaAnamnesis.getJcxNoSexo().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en fue el sexo esperado");
            return false;
        } else {
            System.out.println("Validacion valida :v");
        }
        return true;
    }

    //------------------------ validaciones 1.7
    // validacion para campos txt
    public boolean validacionesPrimerosDias() {

        if (vistaAnamnesis.getTxtPorqueLeche().getText().equals("")
                || vistaAnamnesis.getTxtHastaEdadBiberon().getText().equals("")
                || vistaAnamnesis.getTxtEdadDioLeche().getText().equals("")
                || vistaAnamnesis.getTxtDesdeEdadBiberon().getText().equals("")
                || vistaAnamnesis.getTxtHastaEdadBiberon().getText().equals("")
                || vistaAnamnesis.getTxtComoFueDestete().getText().equals("")
                || vistaAnamnesis.getTxtEdadSento().getText().equals("")
                || vistaAnamnesis.getTxtEdadCamino().getText().equals("")
                || vistaAnamnesis.getTxtEdadPrimerasPalabras().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            return false;
        } else {//-------codigo

            return true;
        }

    }

    public boolean validaChekcPrimerosDias() {
        // pregunta alimentacion materna
        if (vistaAnamnesis.getJcxSiLeche().isSelected() == false
                && vistaAnamnesis.getJcxNoLeche().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en alimentacion materna");
            return false;
            // pregunta uso biberon
        } else if (vistaAnamnesis.getJcxSiBiberon().isSelected() == false
                && vistaAnamnesis.getJcxNoBiberon().isSelected() == false
                && vistaAnamnesis.getJcxAmbos().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en uso biberon");
            return false;
            // preguntas dificultades para succionar
        } else if (vistaAnamnesis.getJcxSiSuccionar().isSelected() == false
                && vistaAnamnesis.getJcxNoSuccionar().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en dificultades al succionar");
            return false;
        } else {
            System.out.println("Validacion correcta");
            return true;
        }

    }

    //------------------- validaciones 1.8
    // validaciones para campos txt (no tiene campos chek)
    public boolean validarAlimentaActual() {
        if (vistaAnamnesis.getTxtInicioSolidos().getText().equals("")
                || vistaAnamnesis.getTxtVecesComeDia().getText().equals("")
                || vistaAnamnesis.getTxtComeSolooAcompanhado().getText().equals("")
                || vistaAnamnesis.getTxtActitudMadre().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            return false;
        } else { // codigo

            return true;
        }
    }

    // ----------------- validaciones 1.9
    // campos txt
    public boolean valiDesarrolloMotor() {
        if (vistaAnamnesis.getTxtDificultadEspecifique().getText().equals("")
                || vistaAnamnesis.getTxtComoSonMovimientos().getText().equals("")
                || vistaAnamnesis.getTxtPsicoSocial().getText().equals("")
                || vistaAnamnesis.getTxtCognitivo().getText().equals("")
                || vistaAnamnesis.getTxtfisico().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            return false;
        } else {
            return true;
        }
    }
    // validacion componentes checks

    public boolean validaCheksDesarrolloMotor() {
        // pregunta motor grueso
        if (vistaAnamnesis.getJcxNormalMotorGrueso().isSelected() == false
                && vistaAnamnesis.getJcxIrregularMotorGrueso().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en desarrollo motor grueso.");
            return false;
            //pregunta motor fino 
        } else if (vistaAnamnesis.getJcxNormalMotorFino().isSelected() == false
                && vistaAnamnesis.getJcxIrregularMotorFino().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en desarrollo motor fino.");
            return false;
            // pregunta su lenguaje actual es 
        } else if (vistaAnamnesis.getJcxNormal().isSelected() == false
                && vistaAnamnesis.getJcxNoMuyClaro().isSelected() == false
                && vistaAnamnesis.getJcxNoSeEntiende().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en lenguaje actual.");
            return false;
        } else {
            return true;
        }
    }

    //------------------------- validaciones 1.10
    // validar txt
    public boolean validacionesSuenio() {
        if (vistaAnamnesis.getTxtComoDuerme().getText().equals("")
                || vistaAnamnesis.getTxtComoDespierta().getText().equals("")
                || vistaAnamnesis.getTxtConQuienDuerme().getText().equals("")
                || vistaAnamnesis.getTxtEdadEsfinteres().getText().equals("")
                || vistaAnamnesis.getTxtEdadEsfinteres().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            return false;
        } else {
            return true;
        }
    }

    // validar checks
    public boolean validarCheksSuenio() {
        // pregunta duerme toda la noche
        if (vistaAnamnesis.getJcxSiDuerme().isSelected() == false
                && vistaAnamnesis.getJcxNoDuerme().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en duerme toda la noche");
            return false;
            // tiene miedo de dormir
        } else if (vistaAnamnesis.getJcxSiMiedoDormir().isSelected() == false
                && vistaAnamnesis.getJcxNoMiedoDormir().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en tiene miedo al dormir");
            return false;
            // pregunta tiene pesadillas
        } else if (vistaAnamnesis.getJcxSiPesadillas().isSelected() == false
                && vistaAnamnesis.getJcxNoPesadillas().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en tiene pesadillas");
            return false;
            //pregunta necesita ayuda para ir al banio
        } else if (vistaAnamnesis.getJcxSiAyudaBanho().isSelected() == false
                && vistaAnamnesis.getJcxNoAyudaBanho().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en nesecita ayuda para ir al baño");
            return false;
            //pregunta moja la cama
        } else if (vistaAnamnesis.getJcxSiMojaCama().isSelected() == false
                && vistaAnamnesis.getJcxNoMojaCama().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en moja la cama");
            return false;
            // pregunta presenta periodos de ecopresis
        } else if (vistaAnamnesis.getJcxSiEcopresis().isSelected() == false
                && vistaAnamnesis.getJcxNoEcopresis().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en periodos de ecopresis");
            return false;
        } else {
            return true;
        }
    }

    //--------------------- validar 1.11
    // campos txt 
    public boolean valiEscolar() {
        if (vistaAnamnesis.getTxtNombreInstitucion().getText().equals("")
                || vistaAnamnesis.getTxtAnhoCursa().getText().equals("")
                || vistaAnamnesis.getTxtAnhoRepite().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LLene todos los campos");
            return false;
        } else {

            System.out.println("Validado");
            return true;
        }
    }
    // validacion campos cheks

    public boolean checksEscolar() {
        //pregunta el NNA estudia
        if (vistaAnamnesis.getJcxSiEstudia().isSelected() == false
                && vistaAnamnesis.getJcxNoEstudia().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en NNA estudia");
            return false;
        } else if (vistaAnamnesis.getJcxSiAprendizaje().isSelected() == false
                && vistaAnamnesis.getJcxNoAprendizaje().isSelected() == false) {
            // preguntas  problemas de aprendisaje
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en problemas de aprensisaje");
            return false;
        } else if (vistaAnamnesis.getJcxSiNivelacion().isSelected() == false
                && vistaAnamnesis.getJcxNoNivelacion().isSelected() == false) {
            // pregunta se apoyo o nivelacion escolar
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en apoyo o nivelacion escolar");
            return false;
        } else {

            return true;
        }
    }

    //------------------ Cami valida
    public boolean ejemploValidarChks() {

        //PERIODO DE EMBARAZO -SECCIÓN: "Se realizó controles médicos" 
        if (vistaAnamnesis.getJcxSiControles().isSelected() == false
                && vistaAnamnesis.getJcxSiControles().isSelected() == false
                && vistaAnamnesis.getJcxUnaVez().isSelected() == false
                && vistaAnamnesis.getJcxMensual().isSelected() == false
                && vistaAnamnesis.getJcxTrimestral().isSelected() == false
                && vistaAnamnesis.getJcxNinguna().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "La sección de controles medicos no esta completada");
            return false;
        } else {

            System.out.println("Validación correcta");
            return true;
        }
    }

    public void controlar() {
        if (ejemploValidarChks() == true) {
            //llenarmodelos();
            //IngresarDB();

        } else {
            System.out.println("La ficha esta incompleta, no se pudo guardar");
        }
    }
}
