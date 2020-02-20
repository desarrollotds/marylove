/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.vista.DBmodelo;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.ArticulosEntregados;

/**
 *
 * @author usuario
 */
public class ArticulosEntregadosDB extends ArticulosEntregados {

    Conexion conectar = new Conexion();

    public ArticulosEntregadosDB() {
    }

    public ArticulosEntregadosDB(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad) {
        super(articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones, articulo_cantidad);
    }

    public boolean IngresarIngreso() {
        String sql = "INSERT INTO public.articulo_entregados"
                + "(ingreso_id, articulo_descripcion, articulo_observaciones,articulo_cantidad)"
                + "    VALUES ("+getIngreso_id()+"',"+getArticulo_descripcion()+"',"+getArticulo_observaciones()+"',"+getArticulo_cantidad()+")";
        //PreparedStatement ps= conectar.noQuery(sql);
        try {
            conectar.query(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(IngresoDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
