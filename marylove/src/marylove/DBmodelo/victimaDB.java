
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.Victima;

/**
 *
 * @author vasquez
 */
public class victimaDB extends Victima{
    PreparedStatement ps;
    ResultSet re = null;

    public victimaDB() {
    }
    
    public int obtenetCV(Conexion con, String ced){
        int cod=0;
        try {
            String sql = "select vc.victima_codigo from victima as vc"
                          +"join persona as pe on vc.persona_codigo = pe.persona_codigo" 
                          +"where pe.persona_cedula = '"+ced + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                cod = re.getInt(1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("error "+ex.getMessage());
            cod = 0;
        }
        con.cerrarConexion();
        return cod;
        
    }
}
