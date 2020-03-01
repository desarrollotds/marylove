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
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.x_resultado_llamada;

/**
 *
 * @author Asus
 */
public class x_resultado_llamadaDB {
    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    public void ingresarResultados(x_resultado_llamada xrl){
        try {
            conn=new ConexionHi();
           
            sql="INSERT INTO public.x_resultado_llamada(llamada_codigo, "
                    + "resultado_id, resultadollamada_descripcion)VALUES ("+xrl.getLlamada_codigo()
                    +", "+xrl.getResultado_id()+", '"+xrl.getResultadollamada_descripcion()+"');";

            ps = conn.getConnection().prepareStatement(sql);
            ps.execute();
            conn.CerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(x_resultado_llamada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
