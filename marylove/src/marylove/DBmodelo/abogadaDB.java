
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Abogada;

/**
 *
 * @author vasquez
 */
public class abogadaDB extends Abogada{
    PreparedStatement ps;
    ResultSet re = null;

    public abogadaDB() {
    }
    
    public boolean ingrePersona(Conexion con, Abogada ab) {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.personal( personal_codigo"
                    + "VALUES ('" + ab.getPersonal_codigo()+"'";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(Abogada.class.getName()).log(Level.SEVERE, null, ex);
            ingreso = false;
        }
        con.cerrarConexion();
        return ingreso;
    }
    
    public boolean verifiUser(Conexion con, String c_per) { // verifica que perfil es el usuario
        boolean verif = true;
        int user = 0;
        try {
            String sql = "select * from abogada where personal_codigo = '" + c_per + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
                verif = true;
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            verif = false;
        }
        con.cerrarConexion();
        return verif;
    }
}
