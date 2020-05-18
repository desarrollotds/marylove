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
import marylove.models.x_llamada_estado_psico;

/**
 *
 * @author AlexanderGuzman
 */
public class x_llamad_estad_psicoDB extends x_llamada_estado_psico {

    ConexionHi conectar= new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    //variables globales
    int par_id = 0;

    public x_llamad_estad_psicoDB(int llamada_codigo, int estado_id) {
        super(llamada_codigo, estado_id);
    }

    public x_llamad_estad_psicoDB() {
    }

    public void insertar() throws SQLException {

        sql = "INSERT INTO public.x_llamada_estado_psico(llamada_codigo, "
                + "estado_id, llamadaestado_descrip)VALUES ( " + getLlamada_codigo() + ",'"
                + getEstado_id() + "'," + getLlamadaestado_descrip() + " );";
        ps = conectar.getConnection().prepareStatement(sql);
        ps.execute();
        conectar.cerrarConexion();

    }
}
