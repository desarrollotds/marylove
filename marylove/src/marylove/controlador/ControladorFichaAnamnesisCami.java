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
    
    public ControladorFichaAnamnesisCami() {
    }
    
    public ControladorFichaAnamnesisCami(FichaAnamnesis vistaAnamnesis, FichaAnamnesisBD modeloAnamnesisBD) {
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
        if (vistaAnamnesis.getJcxSiViolencia().isSelected()
                || vistaAnamnesis.getJcxNoViolencia().isSelected()
                || vistaAnamnesis.getJcxGolpes().isSelected()
                || vistaAnamnesis.getJcxAbusoSexual().isSelected()
                || vistaAnamnesis.getJcxInsultos().isSelected()
                || vistaAnamnesis.getJcxNegligencia().isSelected()
                || vistaAnamnesis.getJcxAmbitoLaboral().isSelected()
                || vistaAnamnesis.getJcxSiControles().isSelected()
                || vistaAnamnesis.getJcxNoControles().isSelected()
                || vistaAnamnesis.getJcxMensual().isSelected()
                || vistaAnamnesis.getJcxUnaVez().isSelected()
                || vistaAnamnesis.getJcxTrimestral().isSelected()
                || vistaAnamnesis.getJcxNinguna().isSelected()
                || vistaAnamnesis.getJcxSiComplicaciones().isSelected()
                || vistaAnamnesis.getJcxNoComplicaciones().isSelected()
                || vistaAnamnesis.getJcxBajoPeso().isSelected()
                || vistaAnamnesis.getJcxHemorragias().isSelected()
                || vistaAnamnesis.getJcxInfecciones().isSelected()
                || vistaAnamnesis.getJcxNoViolencia().isSelected()
                || vistaAnamnesis.getJcxPreclansia().isSelected()
                || vistaAnamnesis.getJcxSiConsume().isSelected()
                || vistaAnamnesis.getJcxNoConsume().isSelected()
                || vistaAnamnesis.getJcxTabaco().isSelected()
                || vistaAnamnesis.getJcxAlcohol().isSelected()
                || vistaAnamnesis.getJcxDroga().isSelected()
                || vistaAnamnesis.getJcxNoViolencia().isSelected()
                || vistaAnamnesis.getJcxSiAborto().isSelected()
                || vistaAnamnesis.getJcxNoAborto().isSelected()) {
            System.out.println("No a selecciona un check de el formulario");
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
    public void validaChecksCondi() {
        
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
        return true;
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
    
    public boolean validaCheksDesarrolloMotor(){
        if (true) {
            return false;
        }else{
            return true;
        }
    }
    
    
    //------------------------- validaciones 1.10
    
    // validar txt
    public boolean validacionesSuenio(){
        if (vistaAnamnesis.getTxtComoDuerme().getText().equals("")
                ||vistaAnamnesis.getTxtComoDespierta().getText().equals("")
                ||vistaAnamnesis.getTxtConQuienDuerme().getText().equals("")
                ||vistaAnamnesis.getTxtEdadEsfinteres().getText().equals("")
                ||vistaAnamnesis.getTxtEdadEsfinteres().getText().equals("")
                ) {
            
            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            return false;
        }else{
            return true;
        }
    }
    
    // validar checks
    
    public boolean validarCheksSuenio(){
        if (true) {
            return false;
        }else{
            return true;
        }
    }
    
    public boolean ejemploValidarChks(){
        
        //PERIODO DE EMBARAZO -SECCIÓN: "Se realizó controles médicos" 
       if(vistaAnamnesis.getJcxSiControles().isSelected()== false
               && vistaAnamnesis.getJcxSiControles().isSelected()== false
               && vistaAnamnesis.getJcxUnaVez().isSelected() == false
               && vistaAnamnesis.getJcxMensual().isSelected() == false
               && vistaAnamnesis.getJcxTrimestral().isSelected()==false
               && vistaAnamnesis.getJcxNinguna().isSelected()==false){
           JOptionPane.showMessageDialog(null, "La sección de controles medicos no esta completada");
           return false;
       }else{
           
           System.out.println("Validación correcta");
           return true;
       }
    }
    
    public void controlar(){
        if(ejemploValidarChks()==true){
            //llenarmodelos();
            //IngresarDB();
            
        }else{
            System.out.println("La ficha esta incompleta, no se pudo guardar");
        }
    }
}
