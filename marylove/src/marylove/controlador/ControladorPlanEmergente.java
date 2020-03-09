
package marylove.controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import marylove.DBmodelo.HistorialClinicoDB;
import marylove.DBmodelo.PlanEmergente2DB;
import marylove.DBmodelo.PlanEmergenteDB;
import marylove.conexion.Conexion;
import marylove.models.HistorialClinico;
import marylove.models.Persona;
import marylove.models.PlanEmergente;
import marylove.models.PlanEmergenteItem;
import marylove.vista.FichaHistoriaClinica;
import marylove.vista.VistaPlanEmergente;

/**
 *SELECT a.item_id, a.emergente_id, a.apreciacioninicial, a.accionesinmediatas, a.item_fecha, a.modalidad_nombre,p.emergente_fecha
	FROM plan_emerg_item as a
	JOIN plan_emergente as p
	on p.emergente_id =a.emergente_id
	where a.item_id = 5saaad
 * @author Alumno
 */
public class ControladorPlanEmergente extends Validaciones {

    private VistaPlanEmergente vista;

    private PlanEmergenteDB modeloDB;
    private PlanEmergente2DB modeloDB2;
    private Conexion conex;

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
        vistaver();
        obtenerFechaSistema();
       // vista.getTxtNombrePlanEmergente().addKeyListener(validarCedula(vista.getTxtNombrePlanEmergente()));
        //  vista.getTxtNombrePlanEmergente().addKeyListener(enter1(vista.getTxtNombrePlanEmergente()));
       // vista.getTxtCodigoPlanEmergente().addKeyListener(validarNumeros(vista.getTxtCodigoPlanEmergente()));

       //vista.getTxtCedula().addKeyListener(enter1(conex, vista.getTxtCedula(), vista.getTxtNombrePlanEmergente(), vista.getTxtCodigoPlanEmergente()));

       
        vista.getBntGuardarPlanEmergente().addActionListener(e -> datoso());
        

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
  public void datoso() {
 
          //  modeloDB.setModalidad_nombre(vista.getTxtModalidad().getText());
            
        //modelo.setVictima_codigo(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));

    public void GuardarTxtArea() {
        controlArea(vista.getTxtAIPsicologia());
        controlArea(vista.getTxtACCIInfantoJuvenil());
        controlArea(vista.getTxtACCILegal());
        controlArea(vista.getTxtACCITrabajoSocial());
        controlArea(vista.getTxtAIInfantoJuvenil());
        controlArea(vista.getTxtAILegal());
        controlArea(vista.getTxtAIPsicologia());
        controlArea(vista.getTxtAITrabajoSocial());

    }

    public void datoso() {

    
        //modeloDB2.setVictima_codigo(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
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
        if (modeloDB.ingresarPSI() && modeloDB.ingresarTRA() &&modeloDB.ingresarLEG()&& modeloDB.ingresarINFA() &&  modeloDB2.ingresarPlan2()) {
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");

        } else {
            JOptionPane.showMessageDialog(null, "ERROR.........");
        }

    }

    public void obtenerFechaSistema() {
        Calendar c2 = new GregorianCalendar();
        vista.getjDatePsicologia().setCalendar(c2);
        Calendar c3 = new GregorianCalendar();
        vista.getjDateFechaPlanEmergente().setCalendar(c3);
        Calendar c1 = new GregorianCalendar();
        vista.getjDateInfantoJuvenil().setCalendar(c1);
        Calendar c4 = new GregorianCalendar();
        vista.getjDateTrabajoSocial().setCalendar(c4);
        Calendar c5 = new GregorianCalendar();
        vista.getjDateLegal().setCalendar(c5);

    }
}
