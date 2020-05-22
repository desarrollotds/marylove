/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.x_motivo_llamada;

/**
 *
 * @author Asus
 */
public class x_motivo_llamadaDB extends x_motivo_llamada {

    Conexion conectar = new Conexion();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
//variables globales pata el metodo insertar_x_motivo_llamada(x_motivo_llamada x)
    int ixml_id=0;

    

    public x_motivo_llamadaDB(int llamada_codigo, int motivo_id, String motivollamada_descripcion) {
        super(llamada_codigo, motivo_id, motivollamada_descripcion);
    }

    public x_motivo_llamadaDB() {
    
    }
    
    public void insertar_x_motivo_llamada() throws SQLException {
        

        sql = "INSERT INTO public.x_motivo_llamada( "
                + "llamada_codigo, motivo_id, motivollamada_descripcion)VALUES "
                + "( " + getLlamada_codigo() + ", " + getMotivo_id() + ",'"
                + getMotivollamada_descripcion() + "');";
        ps = conectar.conectarBD().prepareStatement(sql);
        ps.execute();
        conectar.cerrarConexion();
        
    }
}
