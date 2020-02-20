
package marylove.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;

/**
 *
 * @author Dario Carrion d-_-b
 *///
public class FichaR1 {
    Conexion conn;
    public void guardarRespuestas(x_respuestas xr) throws ParseException, Exception {
        try {
            conn = new Conexion();

            PreparedStatement ps;
            String sql = "INSERT INTO public.x_respuestas( resp_id, enc_codigo,"
                    + " pregunta_codigo, resp_descripcion"
                    + ")VALUES ('" + xr.getResp_id() + "','"
                    + xr.getEnc_codigo() + "','" + xr.getPregunta_codigo() + "','" + xr.getResp_descripcion() + "');";
//            ps = conn.getConection().prepareStatement(sql);
            ps = (PreparedStatement) conn.query(sql);
            ps.execute();

            conn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
}
