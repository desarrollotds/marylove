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
import marylove.models.Llamada;

/**
 *
 * @author Asus
 */
public class LlamadaDB {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";

    public int insertarLlmada(Llamada l) throws SQLException {
        int llamadacodigo = 0;
        conn = new ConexionHi();
        sql = " INSERT INTO public.llamada( per_codigo, llamada_numero,"
                + " llamada_fecha, llamada_hora, llamada_prioridad, personal_codigo, "
                + "notas_adicionales)VALUES (" + l.getPer_codigo() + " , '" + l.getLlamda_numero()
                + "', '" + l.getLlamada_fecha() + "', '" + l.getLlamada_hora() + "','" + l.isLlamada_prioridad()
                + "', " + l.getPersonal_codigo() + ", '" + l.getNotas_adicionales() + "')returning llamda_codigo;";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            llamadacodigo = re.getInt(1);
        }
        conn.CerrarConexion();

        return llamadacodigo;
    }

    public int obtenerIdllamada() throws SQLException {
        int id = 0;
        conn = new ConexionHi();
        sql="SELECT llamada_codigo FROM llamada ORDER BY llamada_codigo DESC LIMIT 1;";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            id = re.getInt(1);
        }
        conn.CerrarConexion();
        return id;
    }

}
