
package marylove.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
 
    Calendar cal = new GregorianCalendar();
    
    static int codigoPlan;

    public ControladorPlanEmergente(VistaPlanEmergente vista, PlanEmergenteDB modeloDB, PlanEmergente2DB modeloDB2)throws Exception {
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
        // vistaver();
        obtenerFechaSistema();
        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(),vista.getTxtNombrePlanEmergente(), vista.getTxtCodigoPlanEmergente()));
        // vista.getTxtCedula().addKeyListener(mostrarDatos1());
        vista.getBntGuardarPlanEmergente().addActionListener(e -> {
            try {
                datoso();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPlanEmergente.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vista.getBntLimpiar().addActionListener(e -> limpiarPlan());
        vista.getTxtCodigoPersonal().setText("" + personal_cod);
        //   vista.getTxtCodigoPlanEmergente(Integer.parseInt(codigoPlan));
      
      
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

public void datoso() throws SQLException {

     modeloDB2.obtenetSelect(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
        modeloDB2.setVictima_codigo(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
        modeloDB.setApreciacioninicial(vista.getTxtAIPsicologia().getText());
        modeloDB.setApreciacioninicial1(vista.getTxtAITrabajoSocial().getText());
        modeloDB.setApreciacioninicial2(vista.getTxtAILegal().getText());
        modeloDB.setApreciacioninicial3(vista.getTxtAIInfantoJuvenil().getText());
         
         //////////////////////////////////////////////////////////////////////////////
       modeloDB.setAccionesinmediatas(vista.getTxtACCIPsicologia().getText());
       modeloDB.setAccionesinmediatas1(vista.getTxtACCITrabajoSocial().getText());
        modeloDB.setAccionesinmediatas2(vista.getTxtACCILegal().getText());
        modeloDB.setAccionesinmediatas3(vista.getTxtACCIInfantoJuvenil().getText());
         /////////////////////////////////////////////////////////////////////////
       modeloDB2.setEmergente_fecha(obtenerFecha(vista.getjDateFechaPlanEmergente()));
        modeloDB.setItem_fecha1(obtenerFecha(vista.getjDateTrabajoSocial()));
        modeloDB.setItem_fecha3(obtenerFecha(vista.getjDateInfantoJuvenil()));
        modeloDB.setItem_fecha2(obtenerFecha(vista.getjDateLegal()));
       modeloDB.setItem_fecha(obtenerFecha(vista.getjDatePsicologia()));
        /////////////////////////////////////////////////////////////////////////
    
             if (modeloDB.ingresarPSI() && modeloDB.ingresarTRA() && modeloDB.ingresarLEG() && modeloDB.ingresarINFA()&& modeloDB2.ingresarPlan2()) {
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
           

        } else {
            JOptionPane.showMessageDialog(null, "ERROR.........");
        }
  
}

   
//    public void cargar(){
//        modeloDB2.obtenetSelect(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
//        vista.getTxtACCIPsicologia().setText(modeloDB.getAccionesinmediatas());
//        vista.getTxtACCITrabajoSocial().setText(modeloDB.getAccionesinmediatas1());
//        vista.getTxtACCILegal().setText(modeloDB.getAccionesinmediatas2());
//        vista.getTxtACCIInfantoJuvenil().setText(modeloDB.getAccionesinmediatas3());
//        vista.getTxtAIPsicologia().setText(modeloDB.getApreciacioninicial());
//        vista.getTxtAITrabajoSocial().setText(modeloDB.getApreciacioninicial1());
//        vista.getTxtAILegal().setText(modeloDB.getApreciacioninicial2());
//        vista.getTxtAIInfantoJuvenil().setText(modeloDB.getApreciacioninicial3());
//        vista.getjDatePsicologia().setDate(modeloDB.getItem_fecha());
//        vista.getjDateTrabajoSocial().setDate(modeloDB.getItem_fecha1());
//        vista.getjDateLegal().setDate(modeloDB.getItem_fecha2());
//        vista.getjDateInfantoJuvenil().setDate(modeloDB.getItem_fecha3());
//     
//         if (modeloDB.actualizar()) {
//                JOptionPane.showMessageDialog(null, "Datos Edistado");
//                limpiarPlan();
//            }else{
//                JOptionPane.showMessageDialog(null, "Datos no Editador");
//            }
//        

    
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
//    
 
 
    public KeyListener mostrarCodigo() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int id;
                    try {
                        id = modeloDB2.obtenerCodigo(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
                    
                    if (id != 0) {
                        codigoPlan=id;
                    }else{
                        JOptionPane.showMessageDialog(null, "Panel sin Datos");
                    }
                    } catch (SQLException ex) {
                        Logger.getLogger(ControladorPlanEmergente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

 
     
 
            }
        };
        return kn;
    }
   
}
