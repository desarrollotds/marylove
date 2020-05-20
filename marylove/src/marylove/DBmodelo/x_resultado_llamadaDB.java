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
import marylove.models.x_resultado_llamada;

/**
 *
 * @author Asus
 */
public class x_resultado_llamadaDB {
    ConexionHi conectar; //=new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    public void ingresarResultados(x_resultado_llamada xrl){
        try {
        
            sql="INSERT INTO public.x_resultado_llamada(llamada_codigo, "
                    + "resultado_id, resultadollamada_descripcion)VALUES ("+xrl.getLlamada_codigo()
                    +", "+xrl.getResultado_id()+", '"+xrl.getResultadollamada_descripcion()+"');";

            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            conectar.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(x_resultado_llamada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
