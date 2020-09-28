/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import marylove.conexion.ConexionHi;
import marylove.models.Encuesta;

/**
 *
 * @author Asus
 */
public class EncuestaDB extends Encuesta {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    private static int encuesta_codigo_static;

    public static int getEncuesta_codigo_static() {
        return encuesta_codigo_static;
    }

    public static void setEncuesta_codigo_static(int encuesta_codigo_static) {
        EncuestaDB.encuesta_codigo_static = encuesta_codigo_static;
    }

    public EncuestaDB() {
    }

    public EncuestaDB(int epr_codigo, int enc_tipo, Date enc_fecha) {
        super(epr_codigo, enc_tipo, enc_fecha);
    }

    public EncuestaDB(int enc_codigo, int epr_codigo, int enc_tipo) {
        super(enc_codigo, epr_codigo, enc_tipo);
    }

    public EncuestaDB(int epr_codigo, int enc_tipo) {
        super(epr_codigo, enc_tipo);
    }

    public EncuestaDB(int total) {
        super(total);
    }

    public boolean insertar_encuesta() throws SQLException {

        sql = "INSERT INTO public.encuesta(epr_codigo, enc_tipo, enc_fecha_elaboracion) "
                + "VALUES ( " + getEpr_codigo() + "," + getEnc_tipo() + "," + "'" + getEnc_fecha() + "')"
                + " returning enc_codigo;";
        re = conectar.query(sql);
        if (re != null) {
            while (re.next()) {
                encuesta_codigo_static = re.getInt(1);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean update_total_encuesta(int id) throws SQLException {
        sql = "UPDATE public.encuesta SET total= " + getTotal() + " "
                + "WHERE enc_codigo = " + id + ";";
        if (conectar.noQuery(sql)) {
            return true;
        }
        return false;
    }

    public boolean update_estado(boolean e, int id) {
        sql = "UPDATE public.encuesta SET ecn_estado='" + e + "' where enc_codigo = " + id + ";";
        if (conectar.noQuery(sql)) {
            return true;
        }
        return false;

    }
}
