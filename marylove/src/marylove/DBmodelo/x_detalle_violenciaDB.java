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
import marylove.models.x_detalle_violencia;

/**
 *
 * @author Asus
 */
public class x_detalle_violenciaDB extends x_detalle_violencia {
    //variables static

    private static int detalle_violencia_static;

    //variables DB
    PreparedStatement ps;
    ResultSet re = null;
    boolean ingreso = true;
    boolean verif = true;
    String sql = "";
    ConexionHi conn;

    //variables globales
    int cod_re = 0;

    public x_detalle_violenciaDB() {
    }

    public x_detalle_violenciaDB(int registroagresor_codigo, int caracteristica_id, String caracteristica_otra) {
        super(registroagresor_codigo, caracteristica_id, caracteristica_otra);
    }



    public void ingresar_detalle_violencia() throws SQLException {
        cod_re = 0;
        sql="INSERT INTO public.x_detalle_violencia( registroagresor_codigo, "
                + "caracteristica_id,caracteristica_otra )"
                + "VALUES ("+getRegistroagresor_codigo()+", "
                + getCaracteristica_id()+",'"+getCaracteristica_otra()+"');";
        ps=conn.getConnection().prepareStatement(sql);
        ps.execute();
        conn.cerrarConexion();

    }

    public static int getDetalle_violencia_static() {
        return detalle_violencia_static;
    }

    public static void setDetalle_violencia_static(int detalle_violencia_static) {
        x_detalle_violenciaDB.detalle_violencia_static = detalle_violencia_static;
    }

}
