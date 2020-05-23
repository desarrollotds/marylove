
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
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
    ConexionHi conectar = new ConexionHi();
     ArrayList<Json_object_consulta> jocarray;
    Json_object_consulta joc;
    
    public ArrayList obtenerEstadoCivil() throws ParseException{
    jocarray = new ArrayList<>();
    String sql;
        try {
            String par_valores = "";
            Object o;
            sql = "select par_valores from parametros where par_nombre='estado_civil'";
//            ps = conectar.conectarBD().prepareStatement(sql);
//            re = ps.executeQuery();
            re = conectar.query(sql);
            while (re.next()) {
                par_valores = re.getString(1);
            }
            //conectar.cerrarConexion();
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
            System.out.println("ERROR al cargar estado civil "+ex.getMessage());
        }

        return jocarray;
        
    }
    public ArrayList obtenerInstruccines() throws ParseException{
    jocarray = new ArrayList<>();
    String sql;
        try {
            String par_valores = "";
            Object o;

            sql = "select par_valores from parametros where par_nombre='instruccion/nivel_acad'";
            re = conectar.query(sql);
            while (re.next()) {
                par_valores = re.getString(1);
            }
           // conectar.cerrarConexion();
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
            System.out.println("ERROR al cargar nacionalidades "+ex.getMessage());
        }

        return jocarray;
    }
    
    public ArrayList obtenerNacionalidades() throws ParseException{
    jocarray = new ArrayList<>();
        try {
            String par_valores = "";
            Object o;
            String sql = "select par_valores from parametros where par_nombre='nacionalidades'";
            re = conectar.query(sql);

            while (re.next()) {
                par_valores = re.getString(1);
            }
            //conectar.cerrarConexion();
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
    public ArrayList obtenerTipo_Insti() throws ParseException{
    jocarray = new ArrayList<>();
        try {
            String par_valores = "";
            Object o;
            String sql = "select par_valores from parametros where par_nombre='tipo_institucion_educativa'";
            re = conectar.query(sql);

            while (re.next()) {
                par_valores = re.getString(1);
            }
            //conectar.cerrarConexion();
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
    public ArrayList obtenerOcupaciones() throws ParseException{
    jocarray = new ArrayList<>();
        try {
            String par_valores = "";
            Object o;
            String sql = "select par_valores from parametros where par_nombre='ocupaciones'";
            re = conectar.query(sql);


            while (re.next()) {
                par_valores = re.getString(1);
            }
            //conectar.cerrarConexion();
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
     public ArrayList obtenerParntesco() throws ParseException{
    jocarray = new ArrayList<>();
        try {
            String par_valores = "";
            Object o;
            String sql = "select par_valores from parametros where par_nombre='parentesco/relación'";
            re = conectar.query(sql);
            while (re.next()) {
                par_valores = re.getString(1);
            }
//            conectar.cerrarConexion();
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
     public ArrayList obtenerParntescoEspecifico() throws ParseException{
    jocarray = new ArrayList<>();
        try {
            String par_valores = "";
            Object o;
            String sql = "select par_valores from parametros where par_nombre='parentesco_especifico'";
            re = conectar.query(sql);
            while (re.next()) {
                par_valores = re.getString(1);
            }
//            conectar.cerrarConexion();
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
     public ArrayList obtenerAnioEscolar() throws ParseException{
    jocarray = new ArrayList<>();
        try {
            String par_valores = "";
            Object o;
            String sql = "select par_valores from parametros where par_nombre='anio_escolar'";
            re = conectar.query(sql);
            while (re.next()) {
                par_valores = re.getString(1);
            }
//            conectar.cerrarConexion();
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
    public ArrayList obtenerNivel_academico() throws ParseException{
    jocarray = new ArrayList<>();
        try {
            String par_valores = "";
            Object o;
            String sql = "select par_valores from parametros where par_nombre='nivel_academico'";
            re = conectar.query(sql);

            while (re.next()) {
                par_valores = re.getString(1);
            }
//            conectar.cerrarConexion();
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
    
    public ArrayList obtenerProvincia() throws ParseException{
    jocarray = new ArrayList<>();
        try {
            String par_valores = "";
            Object o;
            String sql = "select par_valores from parametros where par_nombre='nacionalidades'";
//            ps = conectar.conectarBD().prepareStatement(sql);
//            re = ps.executeQuery();
            re = conectar.query(sql);

            while (re.next()) {
                par_valores = re.getString(1);
            }
//            conectar.cerrarConexion();
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
    
    public ArrayList obtenerCanton() throws ParseException{
    jocarray = new ArrayList<>();
        try {
            String par_valores = "";
            Object o;
            String sql = "select par_valores from parametros where par_nombre='nacionalidades'";
//            ps = conectar.conectarBD().prepareStatement(sql);
//            re = ps.executeQuery();
            re = conectar.query(sql);


            while (re.next()) {
                par_valores = re.getString(1);
            }
//            conectar.cerrarConexion();
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

