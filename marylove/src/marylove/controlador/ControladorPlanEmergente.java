
package marylove.controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import marylove.DBmodelo.CoordinadoraDB;
import marylove.DBmodelo.DirectoraDB;
import marylove.DBmodelo.EducadoraDB;
import marylove.DBmodelo.HistorialClinicoDB;
import marylove.DBmodelo.PlanEmergente2DB;
import marylove.DBmodelo.PlanEmergenteDB;
import marylove.DBmodelo.Trabajo_SocialDB;
import marylove.DBmodelo.abogadaDB;
import marylove.DBmodelo.psicologoDB;
import marylove.conexion.Conexion;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.HistorialClinico;
import marylove.models.Persona;
import marylove.models.PlanEmergente;
import marylove.models.PlanEmergenteItem;
import marylove.vista.FichaHistoriaClinica;
import static marylove.vista.Ficharegistroyreferencia.txtCedula;
import marylove.vista.VistaPlanEmergente;

/**
 *SELECT a.item_id, a.emergente_id, a.apreciacioninicial, a.accionesinmediatas, a.item_fecha, a.modalidad_nombre,p.emergente_fecha
	FROM plan_emerg_item as a
	JOIN plan_emergente as p
	on p.emergente_id =a.emergente_id
	where a.item_id = 5saaad
 * @author Alumqwewqnobhgyhghy
 */
public class ControladorPlanEmergente extends Validaciones {

    private VistaPlanEmergente vista;
    private PlanEmergenteDB modeloDB;
    private PlanEmergente2DB modeloDB2;
    
    Conexion conex = new Conexion();
    Calendar cal = new GregorianCalendar();

    public ControladorPlanEmergente(VistaPlanEmergente vista, PlanEmergenteDB modeloDB, PlanEmergente2DB modeloDB2) {
        this.vista = vista;
        this.modeloDB = modeloDB;
        this.modeloDB2 = modeloDB2;
    }

    public void vistaver() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    public void iniciarControlador() {
        GuardarTxtArea();
        limpiarPlan();
    vistaver();
    //cargardgfsdf();
        obtenerFechaSistema();
       // vista.getTxtNombrePlanEmergente().addKeyListener(validarCedula(vista.getTxtNombrePlanEmergente()));
        //  vista.getTxtNombrePlanEmergente().addKeyListener(enter1(vista.getTxtNombrePlanEmergente()));
       // vista.getTxtCodigoPlanEmergente().addKeyListener(validarNumeros(vista.getTxtCodigoPlanEmergente()));

       vista.getTxtCedula().addKeyListener(enter2(vista.getTxtCedula(), vista.getTxtCodigoPlanEmergente()));

       
        vista.getBntGuardarPlanEmergente().addActionListener(e -> datoso());
         vista.getBntLimpiar().addActionListener(e -> limpiarPlan());
        vista.getTxtCodigoPersonal().setText("" + personal_cod);
      
    }
    

     public void GuardarTxtArea(){
    controlArea(vista.getTxtAIPsicologia());
    controlArea(vista.getTxtACCIInfantoJuvenil());
    controlArea(vista.getTxtACCILegal());
    controlArea(vista.getTxtACCITrabajoSocial());
    controlArea(vista.getTxtAIInfantoJuvenil());
    controlArea(vista.getTxtAILegal());
    controlArea(vista.getTxtAIPsicologia());
    controlArea(vista.getTxtAITrabajoSocial());
 
     }
    //sdfgsdfgdfgddfgdf
//  public void datoso() {
 
          //  modeloDB.setModalidad_nombre(vista.getTxtModalidad().getText());
            
        //modelo.setVictima_codigo(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));


    public void datoso() {

    
        modeloDB2.setVictima_codigo(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
        modeloDB.setApreciacioninicial(vista.getTxtAIPsicologia().getText());
        modeloDB.setApreciacioninicial(vista.getTxtAITrabajoSocial().getText());
         modeloDB.setApreciacioninicial(vista.getTxtAILegal().getText());
         modeloDB.setApreciacioninicial(vista.getTxtAIInfantoJuvenil().getText());
         
         //////////////////////////////////////////////////////////////////////////////
        modeloDB.setAccionesinmediatas(vista.getTxtACCIPsicologia().getText());
        modeloDB.setAccionesinmediatas(vista.getTxtAITrabajoSocial().getText());
         modeloDB.setAccionesinmediatas(vista.getTxtAILegal().getText());
         modeloDB.setAccionesinmediatas(vista.getTxtAIInfantoJuvenil().getText());
   /////////////////////////////////////////////////////////////////////////
        modeloDB2.setEmergente_fecha(obtenerFecha(vista.getjDateFechaPlanEmergente()));
         modeloDB.setItem_fecha(obtenerFecha(vista.getjDateTrabajoSocial()));
          modeloDB.setItem_fecha(obtenerFecha(vista.getjDateInfantoJuvenil()));
           modeloDB.setItem_fecha(obtenerFecha(vista.getjDateLegal()));
        modeloDB.setItem_fecha(obtenerFecha(vista.getjDatePsicologia()));
        /////////////////////////////////////////////////////////////////////////
        if (modeloDB.ingresarPSI() && modeloDB.ingresarTRA() &&modeloDB.ingresarLEG()&& modeloDB.ingresarINFA() &&  modeloDB2.ingresarPlan2()&& cargar()) {
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");

        } else {
            JOptionPane.showMessageDialog(null, "ERROR.........");
        }

    }

    public boolean cargar() {
        boolean ing = true;
         modeloDB2.obtenetSelect(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
       // vistaHC.getTxaFormulacion().setText(modeloHC.getMotivo_consulta());
       return ing;
    }
    public void obtenerFechaSistema() {      
        vista.getjDatePsicologia().setCalendar(cal);     
        vista.getjDateFechaPlanEmergente().setCalendar(cal);
        vista.getjDateInfantoJuvenil().setCalendar(cal);
        vista.getjDateTrabajoSocial().setCalendar(cal);
        vista.getjDateLegal().setCalendar(cal);

    }
     public void limpiarPlan(){
         
        vista.getTxtACCIInfantoJuvenil().setText("");
        vista.getTxtACCILegal().setText("");
        vista.getTxtACCIPsicologia().setText("");
        vista.getTxtACCITrabajoSocial().setText("");
        vista.getTxtAIInfantoJuvenil().setText("");
        vista.getTxtAILegal().setText("");
        vista.getTxtAIPsicologia().setText("");
        vista.getTxtAITrabajoSocial().setText("");
        vista.getjDateFechaPlanEmergente().setCalendar(cal);
        vista.getjDateInfantoJuvenil().setCalendar(cal);
        vista.getjDateLegal().setCalendar(cal);
        vista.getjDatePsicologia().setCalendar(cal);
         vista.getjDateTrabajoSocial().setCalendar(cal);
  
    }
 
        
      
    
         
       
     
 
}
