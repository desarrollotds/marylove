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
import marylove.models.Escolaridad;

/**
 *
 * @author Asus
 */
public class EscolaridadDB extends Escolaridad {

    Conexion conectar;// = new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;
    private static int escoralidad_id_static;

    public EscolaridadDB() {
    }

    public EscolaridadDB(int escolaridad_id, boolean esc_estudia, String esc_explicacion, String esc_repeticion_anio_causas, boolean esc_nna_problem_aprend, String esc_nna_observaciones, boolean esc_asis_prog_apoyo, String esc_asis_prog_apoyo_obser) {
        super(escolaridad_id, esc_estudia, esc_explicacion, esc_repeticion_anio_causas, esc_nna_problem_aprend, esc_nna_observaciones, esc_asis_prog_apoyo, esc_asis_prog_apoyo_obser);
    }

    public EscolaridadDB(boolean esc_estudia, String esc_explicacion, String esc_repeticion_anio_causas, boolean esc_nna_problem_aprend, String esc_nna_observaciones, boolean esc_asis_prog_apoyo, String esc_asis_prog_apoyo_obser) {
        super(esc_estudia, esc_explicacion, esc_repeticion_anio_causas, esc_nna_problem_aprend, esc_nna_observaciones, esc_asis_prog_apoyo, esc_asis_prog_apoyo_obser);
    }

    public boolean update_escolaridad(int escolaridad_id) throws SQLException {
        boolean res = false;
        String sql = "select escolaridad_updateA ("+escolaridad_id+",'"+isEsc_estudia()+"',"
                + "'"+getEsc_explicacion()+"','"+getEsc_repeticion_anio_causas()+"',"
                + "'"+isEsc_nna_problem_aprend()+"','"+getEsc_nna_observaciones()+"',"
                + "'"+isEsc_asis_prog_apoyo()+"','"+getEsc_asis_prog_apoyo_obser()+"')";
        ps=conectar.conectarBD().prepareStatement(sql);
        rs=ps.executeQuery();
        conectar.cerrarConexion();
        while (rs.next()) {
            res=rs.getBoolean(1);
        }
        return res;
    }

    public boolean llenarEscolaridad() throws SQLException {
        String sql = "INSERT INTO escolaridad(esc_estudia, esc_explicacion, "
                + "esc_repeticion_anio_causas, esc_nna_problem_aprend, "
                + "esc_nna_observaciones, esc_asis_prog_apoyo, "
                + "esc_asis_prog_apoyo_obser)"
                + " VALUES ('" + isEsc_estudia() + "', '" + getEsc_explicacion() + "',"
                + " '" + getEsc_repeticion_anio_causas() + "', '" + isEsc_nna_problem_aprend() + "',"
                + " '" + getEsc_nna_observaciones() + "', '" + isEsc_asis_prog_apoyo() + "', "
                + "'" + getEsc_asis_prog_apoyo_obser() + "')returning escoralidad_id;";
        ps = conectar.conectarBD().prepareStatement(sql);
        rs = ps.executeQuery();
        conectar.cerrarConexion();
        if (rs != null) {
            while (rs.next()) {
                escoralidad_id_static = rs.getInt(1);
            }
            return true;
        } else {
            return false;
        }
    }

    public static int getEscoralidad_id_static() {
        return escoralidad_id_static;
    }

    public static void setEscoralidad_id_static(int escoralidad_id_static) {
        EscolaridadDB.escoralidad_id_static = escoralidad_id_static;
    }

}
