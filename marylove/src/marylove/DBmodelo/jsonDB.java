
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Json_object_consulta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author vasquez
 */
public class jsonDB {
    PreparedStatement ps;
    ResultSet re = null;
    
     ArrayList<Json_object_consulta> jocarray;
    Json_object_consulta joc;
    
    public ArrayList obtenerEstadoCivil(Conexion con) throws ParseException{
    jocarray = new ArrayList<>();
    String sql;
        try {
            String par_valores = "";
            Object o;
            sql = "select par_valores from parametros where par_nombre='estado_civil';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();

            while (re.next()) {
                par_valores = re.getString(1);
            }
            con.cerrarConexion();
            o = new JSONParser().parse(par_valores);
            JSONArray caracteristicas = (JSONArray) o;
            for (int i = 0; i < caracteristicas.size(); i++) {
                JSONObject etc = (JSONObject) caracteristicas.get(i);
                long id = (long) etc.get("id");
                int id_id=(int)id;
                String valor = (String) etc.get("valor");
                joc = new Json_object_consulta(id_id, valor);
                jocarray.add(joc);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Caracteristicas_violenciaDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jocarray;
        
    }
}

