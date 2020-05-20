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
import marylove.models.x_caracteristicas_agresor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Asus
 */
public class x_caracteristicas_agresorDB extends x_caracteristicas_agresor {

    ConexionHi conectar ; //= new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    
    
    

    public x_caracteristicas_agresorDB(int llamada_codigo, String registro_observaciones, String caracteristica_descripcion, int caracteristica_id) {
        super(llamada_codigo, registro_observaciones, caracteristica_descripcion, caracteristica_id);
    }

    

    public int isertarRegistroCaracteristica() throws SQLException {
        sql = "INSERT INTO public.x_caracteristicas_agresor( llamada_codigo, "
                + "registro_observaciones, caracteristica_descripcion, caracteristica_id)"
                + "VALUES ( " + getLlamada_codigo() + ", '" + getRegistro_observaciones() + "'"
                + ",'" + getCaracteristica_descripcion() + "'," + getCaracteristica_id()  + ");";
        ps = conectar.getConnection().prepareStatement(sql);
        ps.execute();
        conectar.cerrarConexion();
        return 0;
    }
    
}
