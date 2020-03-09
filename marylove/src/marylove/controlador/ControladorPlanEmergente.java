/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Alumno
 */
public class ControladorPlanEmergente extends Validaciones{
    
     private VistaPlanEmergente vista;
    
    private PlanEmergenteDB modeloDB;
    private PlanEmergente2DB modeloDB2;

    public ControladorPlanEmergente(VistaPlanEmergente vista, PlanEmergenteDB modeloDB, PlanEmergente2DB modeloDB2) {
        this.vista = vista;
        this.modeloDB = modeloDB;
        this.modeloDB2 = modeloDB2;
    }
    

   
public void vistaver(){
    vista.setVisible(true);
    vista.setLocationRelativeTo(null);
}
     public void iniciarControlador(){
      GuardarTxtArea();
        vista.getBntGuardarPlanEmergente().addActionListener(e -> datoso());
           vistaver();
           obtenerFechaSistema();

    }
     public void GuardarTxtArea(){
          String texto=vista.getTxtACCIPsicologia().getText();
    texto= texto.trim();
     String[]areglo=texto.split("\n");
    String texto1=vista.getTxtACCIInfantoJuvenil().getText();
    texto1= texto1.trim();
     String[]areglo1=texto1.split("\n");
    String texto2=vista.getTxtACCILegal().getText();
    texto= texto2.trim();
     String[]areglo2=texto2.split("\n");
    String texto3=vista.getTxtACCITrabajoSocial().getText();
    texto3= texto3.trim();
     String[]areglo3=texto3.split("\n");
    String texto4=vista.getTxtAIInfantoJuvenil().getText();
    texto4= texto4.trim();
     String[]areglo4=texto4.split("\n");
    String texto5=vista.getTxtAILegal().getText();
    texto5= texto5.trim();
     String[]areglo5=texto5.split("\n");
    String texto6=vista.getTxtAIPsicologia().getText();
    texto6= texto6.trim();
     String[]areglo6=texto6.split("\n");
    String texto7=vista.getTxtAITrabajoSocial().getText();
    texto7= texto7.trim();
     String[]areglo7=texto7.split("\n");
     }
    //sdfgsdfgdfgddfgdf
  public void datoso() {
 
          //  modeloDB.setModalidad_nombre(vista.getTxtModalidad().getText());
            
        //modelo.setVictima_codigo(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
        modeloDB.setApreciacioninicial(vista.getTxtAIPsicologia().getText());
//        modelo.setApreciacioninicial(vista.getTxtAITrabajoSocial().getText());
//         modelo.setApreciacioninicial(vista.getTxtAILegal().getText());
//         modelo.setApreciacioninicial(vista.getTxtAIInfantoJuvenil().getText());
          modeloDB.setAccionesinmediatas(vista.getTxtACCIPsicologia().getText());
          
//        modelo.setAccionesinmediatas(vista.getTxtAITrabajoSocial().getText());
//         modelo.setAccionesinmediatas(vista.getTxtAILegal().getText());
//         modelo.setAccionesinmediatas(vista.getTxtAIInfantoJuvenil().getText());
        // modelo.setModalidad_nombre(vista.getTxtModalidad().getText());
          
       modeloDB2.setEmergente_fecha(obtenerFecha(vista.getjDateFechaPlanEmergente()));
//         modelo.setItem_fecha(obtenerFecha(vista.getjDateTrabajoSocial()));
//          modelo.setItem_fecha(obtenerFecha(vista.getjDateInfantoJuvenil()));
//           modelo.setItem_fecha(obtenerFecha(vista.getjDateLegal()));
            modeloDB.setItem_fecha(obtenerFecha(vista.getjDatePsicologia()));
            if (modeloDB.ingresarPlan()&& modeloDB2.ingresarPlan2()) {
                JOptionPane.showMessageDialog(null, "datosguardados");
        
            }else{
                JOptionPane.showMessageDialog(null, "error");
            }
            
        
       
    }
  
    public void obtenerFechaSistema(){
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
    

