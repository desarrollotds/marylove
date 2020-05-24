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

    ConexionHi conectar= new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    private static int llamada_static;
    //variables globales
    int llamadacodigo = 0;
    int id = 0;

    public static int getLlamada_static() {
        return llamada_static;
    }

    public static void setLlamada_static(int llamada_static) {
        LlamadaDB.llamada_static = llamada_static;
    }
    

    public int insertarLlmada(Llamada l) throws SQLException {

        sql = " INSERT INTO public.llamada( per_codigo, llamada_numero,"
                + " llamada_fecha, llamada_hora, llamada_prioridad, personal_codigo, "
                + "notas_adicionales)VALUES (" + l.getPer_codigo() + " , '" + l.getLlamda_numero()
                + "', '" + l.getLlamada_fecha() + "', '" + l.getLlamada_hora() + "','" + l.isLlamada_prioridad()
                + "', " + l.getPersonal_codigo() + ", '" + l.getNotas_adicionales() + "')returning llamada_codigo;";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            llamadacodigo = re.getInt(1);
            llamada_static=re.getInt(1);
        }
        conectar.cerrarConexion();

        return llamadacodigo;
    }

    public int obtenerIdllamada() throws SQLException {
        
        sql = "SELECT llamada_codigo FROM llamada ORDER BY llamada_codigo DESC LIMIT 1;";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            id = re.getInt(1);
        }
        conectar.cerrarConexion();
        return id;
    }

}
