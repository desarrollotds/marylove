package marylove;

import java.sql.SQLException;
import marylove.DBmodelo.ArticulosEntregadosDB;
import marylove.DBmodelo.ArticulosEntregadosPersonalDB;
import marylove.DBmodelo.DefinicionObjetivosEspecificosDB;
import marylove.DBmodelo.DefinicionObjetivosGeneralDB;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.EgresoDB;
import marylove.DBmodelo.IngresoDB;
import marylove.controlador.ControlEvaluacionPlanVida;
import marylove.controlador.ControladorFichaEgreso;
import marylove.controlador.ControladorFichaIngreso;
import marylove.models.ArticulosEntregados;
import marylove.models.ArticulosEntregadosPersonal;
import marylove.models.DefinicionObjetivosEspecifico;
import marylove.models.DefinicionObjetivosGeneral;
import marylove.models.Direccion;
import marylove.models.Egreso;
import marylove.vista.FichaEgreso;
import marylove.vista.FichaEvaluacionPlandeVida;
import marylove.vista.FichaIngreso;
import marylove.vista.FormaAgregarArticulosPersonal;
import marylove.vista.FormaAgregarArticulosVictima;
import marylove.vista.FormaAgregarHijos;
import marylove.vista.VistaDefinicionObjetivosEspecifico;
import marylove.vista.VistaFamiliares;
import marylove.vista.VistaFiltroVistaVictima;
import marylove.vista.vistaAgregarObjetivoGenera;

public class testw {

    

    public static void main(String[] args) throws SQLException, Exception {
        
    FichaEvaluacionPlandeVida f = new FichaEvaluacionPlandeVida();
    DefinicionObjetivosGeneralDB d = new DefinicionObjetivosGeneralDB();
    DefinicionObjetivosEspecificosDB dO = new DefinicionObjetivosEspecificosDB();
    DefinicionObjetivosGeneral dg = new DefinicionObjetivosGeneral();
    DefinicionObjetivosEspecifico de = new DefinicionObjetivosEspecifico();
    VistaDefinicionObjetivosEspecifico vi = new VistaDefinicionObjetivosEspecifico();
    vistaAgregarObjetivoGenera ve = new vistaAgregarObjetivoGenera();
        VistaFiltroVistaVictima vistanna = new VistaFiltroVistaVictima();

    ControlEvaluacionPlanVida ctrlEvaPla = new ControlEvaluacionPlanVida(f,d,dO,dg,de,vi,ve, vistanna);
    //ctrlEvaPla.iniciCtrlEvaluacionPlanVida();
    
    
    Direccion dir = new Direccion();
    Egreso egr = new Egreso();
    FichaEgreso fichEgre = new  FichaEgreso();
    EgresoDB egrDb = new EgresoDB();
    DireccionDB dirDB = new DireccionDB();
    
    ControladorFichaEgreso ctrlFichIngreso = new ControladorFichaEgreso(dir, egr, fichEgre, egrDb, dirDB);
    //ctrlFichIngreso.iniciCtrlEgreso();
    
    
    FormaAgregarArticulosVictima fa = new FormaAgregarArticulosVictima();
    ArticulosEntregados ae = new ArticulosEntregados();
    ArticulosEntregadosDB  aeD = new ArticulosEntregadosDB ();
    ArticulosEntregadosPersonal ap = new ArticulosEntregadosPersonal();
    ArticulosEntregadosPersonalDB atED= new ArticulosEntregadosPersonalDB();
    FichaIngreso fi = new FichaIngreso();
    FormaAgregarArticulosPersonal fap= new FormaAgregarArticulosPersonal();
    IngresoDB indb = new IngresoDB ();
    FormaAgregarHijos foah = new FormaAgregarHijos();
    VistaFamiliares vistFam = new VistaFamiliares();
    ControladorFichaIngreso CfiI = new ControladorFichaIngreso(fa, ae, aeD,ap, atED, fi, fap, indb,foah, vistFam);
    CfiI.inciarCtrlFichIngreso();
    }

}
