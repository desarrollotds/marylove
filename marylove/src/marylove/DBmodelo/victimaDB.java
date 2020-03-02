
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
    int cod=0;
    public victimaDB() {
    }
    
    public Victima obtenetCV(Conexion con, String ced){
        Victima v = new Victima();
        try {
            String sql = "select vc.victima_codigo, pe.persona_nombre||' '||pe.persona_apellido from victima vc"
                    +" join persona as pe on vc.persona_codigo = pe.persona_codigo"
                    +" where pe.persona_cedula = '"+ced+"';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                v.setVictima_codigo(re.getInt(1));
                v.setPersona_nombre(re.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("error al obtener datos de victima "+ex.getMessage());
        }
        con.cerrarConexion();
        return v;
    }
}
