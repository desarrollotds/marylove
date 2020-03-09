package marylove;


import marylove.DBmodelo.*;
import marylove.conexion.Conexion;
import marylove.controlador.*;
import marylove.models.*;
import marylove.vista.*;

/**
 *
 * @author vasquez
 */
public class pruebaFredy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FichaRegistroActuaciones vFRA = new FichaRegistroActuaciones();
        Cierre mC = new Cierre();
        CierreDB cDB = new CierreDB();
        Register_Actuaciones mRA = new Register_Actuaciones();
        RegisActuacionesDB raDB = new RegisActuacionesDB();
        ControlFichaRegisActu cFRA = new ControlFichaRegisActu(vFRA, mC, cDB, mRA, raDB);
        FichaLegal vistaLegal = new FichaLegal();
        fichaLegalDB flDB = new fichaLegalDB();
        Ficha_Legal f_l = new Ficha_Legal();
        V_Login lg = new V_Login();
        V_Menu vP = new V_Menu();
        Personal pl = new Personal();
        Persona pr = new Persona();
        personaDB pDB = new personaDB();
        personalDB plDB = new personalDB();
        Conexion cx = new Conexion();
        controlFichaLegal cFL = new controlFichaLegal(vistaLegal, f_l, flDB,cx);
        C_Menu menu = new C_Menu(vP, cx, vistaLegal, vFRA, cFRA,cFL);
        C_Login cl = new C_Login(lg,vP, pl, pr, pDB, plDB,menu,cx);
        cl.iniciaControl();
    }
    
    
//        String urlDatabase = "jdbc:postgresql://localhost:5432/marylove";
//    private static final String pgUsuario = "postgres";
//    private static final String pgPass = "151155";
}
