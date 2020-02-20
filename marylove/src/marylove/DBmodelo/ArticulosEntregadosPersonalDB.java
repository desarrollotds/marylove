/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.ArticulosEntregadosPersonal;

/**
 *
 * @author usuario
 */
public class ArticulosEntregadosPersonalDB extends ArticulosEntregadosPersonal {

    Conexion conectar = new Conexion();

    public ArticulosEntregadosPersonalDB(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad) {
        super(artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad);
    }

    public ArticulosEntregadosPersonalDB() {
    }

    public boolean IngresarIngreso() {
        String sql = "INSERT INTO public.articulo_entre_personal"
                + "(ingreso_id, artentper_nombre, artentper_observaciones,articulo_cantidad)"
                + "VALUES (" + getIngreso_id() + "'," + getArtentper_nombre() + "'," + getArtentper_observaciones() + "'," + getArticulo_cantidad() + ")";
        //PreparedStatement ps= conectar.noQuery(sql);
        conectar.query(sql);
        return true;
    }

}
