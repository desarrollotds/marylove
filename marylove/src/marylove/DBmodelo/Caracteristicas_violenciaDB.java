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
import marylove.models.Caracteristicas_violencia;

import marylove.models.Json_object_consulta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Alumno
 */
public class Caracteristicas_violenciaDB extends Caracteristicas_violencia {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    ArrayList<Json_object_consulta> jocarray;
    Json_object_consulta joc;
     //variables globales para el metodo obtenerCaracteristicaId()
     int par_id = 0;
     int final_id = 0;
    public Caracteristicas_violenciaDB() {
    }

    public Caracteristicas_violenciaDB(String caracteristicas_nombre, int carasteristicas_tipo) {
        super(caracteristicas_nombre, carasteristicas_tipo);
    }

    public Caracteristicas_violenciaDB(int carasteristica_id, String caracteristicas_nombre, int carasteristicas_tipo) {
        super(carasteristica_id, caracteristicas_nombre, carasteristicas_tipo);
    }
public ArrayList obtenerNacionalidades() throws ParseException{
    jocarray = new ArrayList<>();
        conn = new ConexionHi();
        try {
            String par_valores = "";
            Object o;
            sql = "select par_valores from parametros where par_nombre='nacionalidades';";
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();

            while (re.next()) {
                par_valores = re.getString(1);
            }
            conn.CerrarConexion();
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
    public ArrayList<Json_object_consulta> obtenerTitulos() throws ParseException {//obtener los titulos de cada seccion 
        
        jocarray = new ArrayList<>();
        conn = new ConexionHi();
        try {
            String par_valores = "";
            Object o;
            sql = "select par_valores from parametros where par_nombre='características_de_violencia_titulos';";
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();

            while (re.next()) {
                par_valores = re.getString(1);
            }
            conn.CerrarConexion();
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
   
    public int obtenerCaracteristicaId(String nombre) throws SQLException {
       
        conn = new ConexionHi();
        sql = "select caracteristica_id from caracteristicas_violencia where caracteristicas_nombre='" + nombre + "';";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            par_id = re.getInt(1);
        }
        conn.CerrarConexion();
        return par_id;
    }
    private int IdOtros=0;//variable global para el metodo de abajo
    public int obtenerCaracteristicaIdOtros(String titulo) throws ParseException, SQLException {
         
        conn = new ConexionHi();
        jocarray = obtenerTitulos();
        for (Json_object_consulta o : jocarray) {
            if (o.getValor().equals(titulo)) {
                IdOtros = o.getId();
                
             
            }
                
        }
        sql = "select caracteristica_id from caracteristicas_violencia where caracteristicas_nombre='Otra' and carasteristicas_tipo=" + IdOtros + ";";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            final_id = re.getInt(1);
            
            
        }
     
        conn.CerrarConexion();
        return final_id;
    }
    public int obtenerCaracteristicaIdNoreporta(String titulo) throws ParseException, SQLException {
         
        conn = new ConexionHi();
        jocarray = obtenerTitulos();
        for (Json_object_consulta o : jocarray) {
            if (o.getValor().equals(titulo)) {
                IdOtros = o.getId();
            }
        }
        sql = "select caracteristica_id from caracteristicas_violencia where caracteristicas_nombre='No reporta' and carasteristicas_tipo=" + IdOtros + ";";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            final_id = re.getInt(1);
        }
     
        conn.CerrarConexion();
        return final_id;
    }
}
