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
import marylove.models.x_motivo_llamada;

/**
 *
 * @author Asus
 */
public class x_motivo_llamadaDB {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
//variables globales pata el metodo insertar_x_motivo_llamada(x_motivo_llamada x)
    int ixml_id=0;
    public void insertar_x_motivo_llamada(x_motivo_llamada x) throws SQLException {
        
        conn = new ConexionHi();
        sql = "INSERT INTO public.x_motivo_llamada( "
                + "llamada_codigo, motivo_id, motivollamada_descripcion)VALUES "
                + "( " + x.getLlamada_codigo() + ", " + x.getMotivo_id() + ",'"
                + x.getMotivollamada_descripcion() + "');";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            ixml_id=re.getInt(1);
        }
        conn.CerrarConexion();
        
    }
}
