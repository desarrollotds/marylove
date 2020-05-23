package marylove;

import java.sql.SQLException;
import marylove.DBmodelo.Cuentas_DiariasDB;
import marylove.DBmodelo.HistorialClinicoDB;
import marylove.DBmodelo.Monto_DisponeDB;
import marylove.DBmodelo.Monto_NecesitaDB;
import marylove.DBmodelo.PlanAutonomiaDB;
import marylove.DBmodelo.Plan_deRecursosDB;
import marylove.DBmodelo.PvObjetivosEspecDB;
import marylove.DBmodelo.PvObjetivosGeneDB;
import marylove.DBmodelo.primer_EncuentroDB;
import marylove.controlador.ControlHistorialClinico;
import marylove.controlador.ControladorPlandeRecursos;
import marylove.controlador.ControladorPlandeVida;
import marylove.controlador.ControladorPrimerEncuentro;
import marylove.controlador.controlPlanAutonomia;
import marylove.models.Cuentas_Diarias;
import marylove.models.HistorialClinico;
import marylove.models.Monto_Dispone;
import marylove.models.Monto_Necesita;
import marylove.models.Plan_Autonomia;
import marylove.models.Pv_objeticos_especificos;
import marylove.models.Pv_objetivos_gene;
import marylove.vista.FichaHistoriaClinica;
import marylove.vista.FichaPlandeVida;
import marylove.vista.FichaPrimerEncuentro;
import marylove.vista.VistaDefinicionObjetivosEspecifico;
import marylove.vista.VistaPlanAutonomía;
import marylove.vista.VistaPlanRecursos;
import marylove.vista.vistaAgregarObjetivoGenera;
import marylove.vista.vistaCuentasDiarias;
import marylove.vista.vistaGastosPrioritarios;

/**
 *
 * @author USUARIO
 */
public class testManuel {
    public static void main(String[] args) throws SQLException, Exception {
        
//     VistaPlanRecursos vpr = new VistaPlanRecursos();
//     Monto_DisponeDB montDispModlDB = new Monto_DisponeDB();
//     Monto_NecesitaDB montNecesModelDB = new Monto_NecesitaDB();
//     Cuentas_DiariasDB cuentDiariasModelDB = new Cuentas_DiariasDB();
//     Monto_Dispone montDMdel = new Monto_Dispone();
//     Monto_Necesita montNMdel = new Monto_Necesita();
//     Cuentas_Diarias cuentDMdel = new Cuentas_Diarias();
//     vistaCuentasDiarias vistCuentD = new vistaCuentasDiarias();
//     vistaGastosPrioritarios vistGastPrio = new vistaGastosPrioritarios();          
//    ControladorPlandeRecursos contR = new ControladorPlandeRecursos(vpr, montDispModlDB, montNecesModelDB, cuentDiariasModelDB, montDMdel, montNMdel, cuentDMdel, vistCuentD, vistGastPrio);
//    contR.iniciarControlRecursos();
//    vpr.setVisible(true);

    FichaPlandeVida vPVida = new FichaPlandeVida();
    PvObjetivosGeneDB objGenModlDB = new PvObjetivosGeneDB();
    PvObjetivosEspecDB objEspeModelDB = new PvObjetivosEspecDB();
    Pv_objeticos_especificos objEspeMdel = new Pv_objeticos_especificos();
    Pv_objetivos_gene objGeMOdel = new Pv_objetivos_gene();
    VistaDefinicionObjetivosEspecifico vistObjEsp = new VistaDefinicionObjetivosEspecifico();
    vistaAgregarObjetivoGenera vistObjGene = new vistaAgregarObjetivoGenera();
    ControladorPlandeVida contPVida = new ControladorPlandeVida(vPVida, objGenModlDB, objEspeModelDB, objGeMOdel, objEspeMdel, vistObjEsp, vistObjGene);
     contPVida.iniciarControl();
     vPVida.setVisible(true);
    
    
    
//    FichaPrimerEncuentro vFPE = new FichaPrimerEncuentro();
//    primer_EncuentroDB peDB = new primer_EncuentroDB();
//    ControladorPrimerEncuentro contPE = new ControladorPrimerEncuentro(vFPE, peDB);
//    contPE.iniciarControl();
//    vFPE.setVisible(true);

    
    }
    
}
