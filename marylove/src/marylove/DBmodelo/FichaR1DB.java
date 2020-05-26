
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Persona;
import marylove.models.x_respuestas;

/**
 *
 * @author Dario Carrion d-_-b
 */
public class FichaR1DB extends x_respuestas{ 
    ConexionHi conectar = new ConexionHi();;

    public FichaR1DB() {
    }

    public FichaR1DB(int resp_id, int enc_codigo, int pregunta_codigo, String resp_descripcion) {
        super(resp_id, enc_codigo, pregunta_codigo, resp_descripcion);
    }
    
    
    
     public void guardarRespuestas(x_respuestas xr) throws ParseException, Exception {
        try {
            
            PreparedStatement ps;
            String sql = "INSERT INTO public.x_respuestas( resp_id, enc_codigo,"
                    + " pregunta_codigo, resp_descripcion"
                    + ")VALUES ('" + xr.getResp_id() + "','"
                    + xr.getEnc_codigo() + "','" + xr.getPregunta_codigo() + "','" + xr.getResp_descripcion() + "');";
//            ps = conn.getConection().prepareStatement(sql);
            ps = (PreparedStatement) conectar.query(sql);
            ps.execute();
            
            conectar.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
