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
           public void insertaDatos()  {
        
       // modelo_1encuentro.setPrimer_codigo(4);
      //  perso.setVictima_codigo(Integer.parseInt(VistaPlanEmergente.getTxtCodigoPersonal().getText()));
//        modelo_1encuentro.setPstIntCrisis_fecha(obtenerFecha(vista_1encuentro.getDatFechaPrimerEncuentro()));
//        modelo_1encuentro.setPstIntCrisis_estado_emocional(vista_1encuentro.getTxaEstadoEmocional().getText());
//        modelo_1encuentro.setPstIntCrisis_nivel_riesgo(vista_1encuentro.getTxaNivelRiesgo().getText());
//        modelo_1encuentro.setPstIntCrisis_valoracionpreliminar(vista_1encuentro.getTxaValoracionDaño().getText());
//       
//    delo_1encuentro.setPsicologo_codigo(4);
//        modelo_1encuentro.Ingresar_PrimerEncuentro();
//        
  
    }
    
    
}
