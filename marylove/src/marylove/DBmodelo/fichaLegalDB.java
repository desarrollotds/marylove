
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Ficha_Legal;
import marylove.models.Persona;

/**
 *
 * @author vasquez
 */
public class fichaLegalDB extends Ficha_Legal{
    PreparedStatement ps;
    ResultSet re = null;
    boolean ingreso = true;
    public boolean ingreFLegal(Conexion con, Ficha_Legal fl) {
        
        try {

            String sql = "INSERT INTO public.ficha_legal( victima_codigo, "
                    + "psicologo_codigo, motivos_consulta, relacion_hechos, aspectos_reelevantes"
                    + "VALUES ('" + fl.getVictima_codigo() + "','" + fl.getAbogada_codigo()
                    + "','" + fl.getMotivo_consulta() + "','" + fl.getRelacion_hechos() + "','"
                    + fl.getAspectos_reelevantes() + "';";
//            ps = conn.getConection().prepareStatement(sql);
            ps = con.conectarBD().prepareStatement(sql);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Ficha_Legal.class.getName()).log(Level.SEVERE, null, ex);
            ingreso = false;
        }
        con.cerrarConexion();
        return ingreso;
    }
}
