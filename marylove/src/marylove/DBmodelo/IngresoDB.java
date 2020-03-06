/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.util.Date;
import marylove.conexion.Conexion;
import marylove.models.Ingreso;

public class IngresoDB extends Ingreso {

    private Conexion conectar;

    public IngresoDB(int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha) {
        super(victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha);
    }

    public IngresoDB() {
    }

    public boolean IngresarDormitorioReferido() {
        conectar = new Conexion();
        String sql = "INSERT INTO ingreso"
                + "(asignacion_dormitorio, referidapor)"
                + "VALUES ('" + getAsignacion_dormitorio() + "','" + getReferidapor() + "')";
        PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizar() {
        conectar = new Conexion();
        String sql = "UPDATE public.ingreso SET "
                + "victima_codigo=" + getVictima_codigo() + ","
                + " personal_codigo=" + getPersonal_codigo() + ","
                + "asignacion_dormitorio='" + getAsignacion_dormitorio() + "',"
                + " Referidapor= '" + getReferidapor() + " "
                + " WHERE ingreso_id =" + getIngreso_id();

        if (conectar.noQuery(sql) == null) {
            conectar.cerrarConexion();
            return true;

        } else {
            conectar.cerrarConexion();
            return false;
        }
    }

}
