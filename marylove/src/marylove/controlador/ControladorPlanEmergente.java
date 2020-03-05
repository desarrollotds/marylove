/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
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
public void vistaver(){
    vista.setVisible(true);
    vista.setLocationRelativeTo(null);
}
     public void iniciarControlador(){
       // vista.getTxtNombrePlanEmergente().addKeyListener(enter2(conex,vista.getTxtNombrePlanEmergente(),vista.getTxtCodigoPlanEmergente()));
       vistaver();
        //vista.getBtnGuardar().addActionListener(e->agregarFicha());
          //validaciones
    
        //vista.getTxtCodigoPersonal()o().addKeyListener(validarNumeros(vistaHC.getTxtCodigo()));
        // eventos de botones
       
        vista.getBntGuardarPlanEmergente().addActionListener(e -> ingresarHC());
        
        // obtener el codigo
       // vistaHC.getTxtNombre().addKeyListener(enter2(conex, vistaHC.getTxtNombre(), vistaHC.getTxtCodigo()));
    }
      public void ingresarHC(){
        if (modeloDB.ingresarPlan(conex,datos()) ) {
            JOptionPane.showMessageDialog(null, "Datos ingresar Correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Datos no ingresar");
        }
    }
  public PlanEmergenteItem datos() {
        
        //modelo.setVictima_codigo(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
        modelo.setApreciacioninicial(vista.getTxtAIPsicologia().getText());
//        modelo.setApreciacioninicial(vista.getTxtAITrabajoSocial().getText());
//         modelo.setApreciacioninicial(vista.getTxtAILegal().getText());
//         modelo.setApreciacioninicial(vista.getTxtAIInfantoJuvenil().getText());
          modelo.setAccionesinmediatas(vista.getTxtAIPsicologia().getText());
//        modelo.setAccionesinmediatas(vista.getTxtAITrabajoSocial().getText());
//         modelo.setAccionesinmediatas(vista.getTxtAILegal().getText());
//         modelo.setAccionesinmediatas(vista.getTxtAIInfantoJuvenil().getText());
         modelo.setModalidad_nombre(vista.getTxtModalidad().getText());
          try {
       // modelo.setEmergente_fecha(obtenerFecha(vista.getjDateFechaPlanEmergente()));
//         modelo.setItem_fecha(obtenerFecha(vista.getjDateTrabajoSocial()));
//          modelo.setItem_fecha(obtenerFecha(vista.getjDateInfantoJuvenil()));
//           modelo.setItem_fecha(obtenerFecha(vista.getjDateLegal()));
            modelo.setItem_fecha(obtenerFecha(vista.getjDatePsicologia()));
        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER LA  FECHA " + e.getMessage());
        }
          
          return modelo;
       
    }
    
    
    
}
