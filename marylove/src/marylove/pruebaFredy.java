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
        V_Login lg = new V_Login();
        V_Menu vP = new V_Menu();
        Personal pl = new Personal();
        Persona pr = new Persona();
        personaDB pDB = new personaDB();
        personalDB plDB = new personalDB();
        C_Menu menu = new C_Menu(vP);
        C_Login cl = new C_Login(lg,vP, pl, pr, pDB, plDB, menu);
        cl.iniciaControl();
    }
    
    
//        String urlDatabase = "jdbc:postgresql://localhost:5432/marylove";
//    private static final String pgUsuario = "postgres";
//    private static final String pgPass = "151155";
}
