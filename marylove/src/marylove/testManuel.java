package marylove;

import java.sql.SQLException;
import marylove.DBmodelo.Cuentas_DiariasDB;
import marylove.DBmodelo.Monto_DisponeDB;
import marylove.DBmodelo.Monto_NecesitaDB;
import marylove.DBmodelo.PlanAutonomiaDB;
import marylove.DBmodelo.Plan_deRecursosDB;
import marylove.DBmodelo.primer_EncuentroDB;
import marylove.controlador.ControladorPlandeRecursos;
import marylove.controlador.ControladorPrimerEncuentro;
import marylove.controlador.controlPlanAutonomia;
import marylove.models.Cuentas_Diarias;
import marylove.models.Monto_Dispone;
import marylove.models.Monto_Necesita;
import marylove.models.Plan_Autonomia;
import marylove.vista.FichaPrimerEncuentro;
import marylove.vista.VistaPlanAutonomía;
import marylove.vista.VistaPlanRecursos;
import marylove.vista.vistaCuentasDiarias;
import marylove.vista.vistaGastosPrioritarios;

/**
 *
 * @author USUARIO
 */
public class testManuel {
    public static void main(String[] args) throws SQLException, Exception {
        
     VistaPlanRecursos vpr = new VistaPlanRecursos();
     Monto_DisponeDB montDispModlDB = new Monto_DisponeDB();
     Monto_NecesitaDB montNecesModelDB = new Monto_NecesitaDB();
     Cuentas_DiariasDB cuentDiariasModelDB = new Cuentas_DiariasDB();
     Monto_Dispone montDMdel = new Monto_Dispone();
     Monto_Necesita montNMdel = new Monto_Necesita();
     Cuentas_Diarias cuentDMdel = new Cuentas_Diarias();
     vistaCuentasDiarias vistCuentD = new vistaCuentasDiarias();
     vistaGastosPrioritarios vistGastPrio = new vistaGastosPrioritarios();          
    ControladorPlandeRecursos contR = new ControladorPlandeRecursos(vpr, montDispModlDB, montNecesModelDB, cuentDiariasModelDB, montDMdel, montNMdel, cuentDMdel, vistCuentD, vistGastPrio);
    contR.iniciarControlRecursos();
    vpr.setVisible(true);
    
    
    
//    FichaPrimerEncuentro vFPE = new FichaPrimerEncuentro();
//    primer_EncuentroDB peDB = new primer_EncuentroDB();
//    ControladorPrimerEncuentro contPE = new ControladorPrimerEncuentro(vFPE, peDB);
//    contPE.iniciarControl();
//    vFPE.setVisible(true);

    
    }
    
}
