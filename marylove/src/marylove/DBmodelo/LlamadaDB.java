/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    String sql="";
    public void insertarLlmada(Llamada llamada){
    conn = new ConexionHi();
    sql=" INSERT INTO public.llamada( per_codigo, llamada_numero,"
    + " llamada_fecha, llamada_hora, llamada_prioridad, personal_codigo, "
    + "notas_adicionales)VALUES ( , ?, ?, ?, ?, ?, ?);";
    }
    
}
