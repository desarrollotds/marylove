/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.x_caracteristicas_agresor;

/**
 *
 * @author Asus
 */
public class x_caracteristicas_agresorDB {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";

    public int isertarRegistroCaracteristica(x_caracteristicas_agresor a) throws SQLException {
        conn = new ConexionHi();
        sql = "INSERT INTO public.x_caracteristicas_agresor( llamada_codigo, "
                + "registro_observaciones, caracteristica_descripcion, caracteristica_id)"
                + "VALUES ( " + a.getLlamada_codigo() + ", '" + a.getRegistro_observaciones() + "'"
                + ",'" + a.getCaracteristica_descripcion() + "'," + a.getCaracteristica_id() + ");";
        ps = conn.getConnection().prepareStatement(sql);
        ps.execute();
        conn.CerrarConexion();
        return 0;
    }
    
}
