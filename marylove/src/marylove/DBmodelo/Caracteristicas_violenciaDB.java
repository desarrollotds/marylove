/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
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

    public void obtenerTitulos() throws ParseException {
        try {
            conn = new ConexionHi();
            String par_valores="";
            Object o;
            String sql = "select par_valores from parametros where par_nombre='características_de_violencia_titulos';";
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                par_valores=re.getString(1);
            }
            o= new JSONParser().parse(par_valores);
            JSONArray caracteristicas = (JSONArray) o;
            for (int i = 0; i < caracteristicas.size(); i++) {
                 JSONObject etc = (JSONObject) caracteristicas.get(i);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Caracteristicas_violenciaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.CerrarConexion();
    }
}
