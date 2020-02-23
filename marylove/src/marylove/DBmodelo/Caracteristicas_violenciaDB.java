/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Alumno
 */
public class Caracteristicas_violenciaDB {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    String sql="";
    ArrayList<Json_object_consulta> jocarray;
    Json_object_consulta joc;
    

    public ArrayList<Json_object_consulta> obtenerTitulos() throws ParseException {//obtener los titulos de cada seccion 
        int par_id = 0;
        jocarray = new ArrayList<>();
        conn = new ConexionHi();
        try {
            String par_valores = "";
            Object o;
            sql = "select par_valores from parametros where par_nombre='características_de_violencia_titulos';";
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conn.CerrarConexion();
            while (re.next()) {
                par_valores = re.getString(1);
            }
            o = new JSONParser().parse(par_valores);
            JSONArray caracteristicas = (JSONArray) o;
            for (int i = 0; i < caracteristicas.size(); i++) {
                JSONObject etc = (JSONObject) caracteristicas.get(i);
                int id = (int) etc.get("id");
                String valor = (String) etc.get("valor");
                joc = new Json_object_consulta(id, valor);
                jocarray.add(joc);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Caracteristicas_violenciaDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jocarray;
    }
    
    public int obtenerCaracteristicaId(String nombre) throws SQLException{
          int par_id = 0;
        conn = new ConexionHi();
        sql="select caracteristica_id from caracteristicas_violencia where caracteristicas_nombre='"+nombre+"';";
        ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conn.CerrarConexion();
            while (re.next()) {
                par_id = re.getInt(1);
            }
    return par_id;
    }
}
