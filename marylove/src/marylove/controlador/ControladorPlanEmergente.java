/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import marylove.DBmodelo.HistorialClinicoDB;
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
      SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyyy");
    Date fecha = new Date();
    Date date;
    String F;
    String f;
     private VistaPlanEmergente vista;
    private PlanEmergenteItem modelo;
    private PlanEmergenteDB modeloDB;
    private Conexion conex;

    public ControladorPlanEmergente(VistaPlanEmergente vista, PlanEmergenteItem modelo, PlanEmergenteDB modeloDB) {
        this.vista = vista;
        this.modelo = modelo;
        this.modeloDB = modeloDB;
    }

     public void iniciarControlador(){
        vista.getTxtNombrePlanEmergente().addKeyListener(enter2(conex,vista.getTxtNombrePlanEmergente(),vista.getTxtCodigoPlanEmergente()));
       
        //vista.getBtnGuardar().addActionListener(e->agregarFicha());
        
    }
  public PlanEmergenteItem datos() {
        
        modelo.setVictima_codigo(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
        modelo.setApreciacioninicial(vista.getTxtAIPsicologia().getText());
        modelo.setApreciacioninicial(vista.getTxtAITrabajoSocial().getText());
         modelo.setApreciacioninicial(vista.getTxtAILegal().getText());
         modelo.setApreciacioninicial(vista.getTxtAIInfantoJuvenil().getText());
          modelo.setAccionesinmediatas(vista.getTxtAIPsicologia().getText());
        modelo.setAccionesinmediatas(vista.getTxtAITrabajoSocial().getText());
         modelo.setAccionesinmediatas(vista.getTxtAILegal().getText());
         modelo.setAccionesinmediatas(vista.getTxtAIInfantoJuvenil().getText());
          try {
     //   modelo.setEmergente_fecha(obtenerFecha(vista.getjDateFechaPlanEmergente()));
        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER LA  FECHA " + e.getMessage());
        }
          
          return modelo;
       
    }
    
    
    
}
