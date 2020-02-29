package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexanderGuzman
 */
public class EstadoPsicoEmoDB {
    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    public int obtenerIdEstado(String nombre) throws SQLException{
        int par_id = 0;
        conn = new ConexionHi();
 
        sql= "select estado_id  from estado_psico_emocional where estado_nombre='" + nombre + "';";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            par_id = re.getInt(1);
        }
        conn.CerrarConexion();
        return par_id;
    }
}
