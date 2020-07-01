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
import marylove.models.Salud_nna;
import marylove.vista.FichaAnamnesis;

/**
 *
 * @author Asus
 */
public class Salud_nnaDB extends Salud_nna {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;
    String sql = "";
    private static int salud_nna_id_static;

    public Salud_nnaDB(int salud_nna_id, String problem_familiare, String problem_familiar_descrip, boolean problem_respiratorio, String problem_resp_descrip, boolean problem_alergias, String problem_aler_descrip, boolean problem_neurologico, String problem_neuro_descrip, boolean problem_nerviosos, String problem_nervi_descrip) {
        super(salud_nna_id, problem_familiare, problem_familiar_descrip, problem_respiratorio, problem_resp_descrip, problem_alergias, problem_aler_descrip, problem_neurologico, problem_neuro_descrip, problem_nerviosos, problem_nervi_descrip);
    }

    public Salud_nnaDB(String problem_familiare,
            String problem_familiar_descrip,
            boolean problem_respiratorio,
            String problem_resp_descrip,
            boolean problem_alergias,
            String problem_aler_descrip,
            boolean problem_neurologico,
            String problem_neuro_descrip,
            boolean problem_nerviosos,
            String problem_nervi_descrip) {
        super(problem_familiare, problem_familiar_descrip, problem_respiratorio, problem_resp_descrip, problem_alergias, problem_aler_descrip, problem_neurologico, problem_neuro_descrip, problem_nerviosos, problem_nervi_descrip);
    }

    public Salud_nnaDB() {
    }

    public static int getSalud_nna_id_static() {
        return salud_nna_id_static;
    }

    public static void setSalud_nna_id_static(int salud_nna_id_static) {
        Salud_nnaDB.salud_nna_id_static = salud_nna_id_static;
    }
             

    public boolean update_salud_nna(String problem_respiratorio, String problem_alergias, String problem_neurologico, String problem_nerviosos ) throws SQLException {
        boolean res = false;
        sql = "select salud_nna_updateA (" + AnamnesisDB.salud_nna_id + ",'" + getProblem_familiare() + "',"
                + "'" + getProblem_familiar_descrip() + "', "+ problem_respiratorio + ", "
                + "'" + getProblem_resp_descrip() + "', " + problem_alergias + ", "
                + "'" + getProblem_aler_descrip() + "', " + problem_neurologico + ", "
                + "'" + getProblem_neuro_descrip() + "', " + problem_nerviosos + ", "
                + "'" + getProblem_nervi_descrip() + "')";
        boolean result = false;
        rs = conectar.query(sql);
            while (rs.next()) {
                result = rs.getBoolean(1);
                System.out.println(result);
            }
        return result;
    }

    public boolean llenarSaludNNA() throws SQLException {
        sql = "INSERT INTO salud_nna(problem_familiar, problem_familiar_descrip, "
                + "problem_respiratorio, problem_resp_descrip, problem_alergias, "
                + "problem_aler_descrip, problem_neurologico, problem_neuro_descrip, "
                + "problem_nerviosos, problem_nervi_descrip)"
                + " VALUES ('" + getProblem_familiare() + "', '" + getProblem_familiar_descrip() + "', "
                + " '" + isProblem_respiratorio() + "', '" + getProblem_resp_descrip() + "',"
                + " '" + isProblem_alergias() + "', '" + getProblem_aler_descrip() + "', "
                + " '" + isProblem_neurologico() + "', '" + getProblem_neuro_descrip() + "', "
                + " '" + isProblem_nerviosos() + "', '" + getProblem_neuro_descrip() + "')returning salud_nna_id;";

        ps = conectar.getConnection().prepareStatement(sql);
        rs = ps.executeQuery();
        conectar.cerrarConexion();
        if (rs != null) {
            while (rs.next()) {
                salud_nna_id_static = rs.getInt(1);
            }
            return true;
        } else {
            return false;
        }

    }

    public void rellenarCamposAnamnesis(Salud_nna s) {
        sql = "Select s.problem_familiar, s.problem_familiar_descrip, s.problem_respiratorio, s.problem_resp_descrip, s.problem_alergias, s.problem_aler_descrip, s.problem_neurologico, s.problem_neuro_descrip, s.problem_nerviosos, s.problem_nervi_descrip, rf.clima_familiar, rf.relacion_padre, rf.relacion_madre, rf.relacion_hermanos, rf.trabajo, rf.trabajo_decrip, rf.agresion_agresor, rf.objeto_utilizado, rf.obligacion_familiar, rf.proyeccion_madre, rf.necesidad_inmediata, \n"
                + "rf.agresion_frecuencia\n"
                + "from  anamnesis  an  join salud_nna s using(salud_nna_id) join relacion_familiar_nna rf using (rela_famili_nna_id) where an.hijo_codigo=" + FichaAnamnesis.txtCodigo.getText() + "; ";
        System.out.println(sql);

        try {
            rs = conectar.query(sql);
            while (rs.next()) {
                s.setProblem_familiare(rs.getString(1));
                s.setProblem_familiar_descrip(rs.getString(2));
                s.setProblem_respiratorio(rs.getBoolean(3));
                s.setProblem_resp_descrip(rs.getString(4));
                s.setProblem_alergias(rs.getBoolean(5));
                s.setProblem_aler_descrip(rs.getString(6));
                s.setProblem_neurologico(rs.getBoolean(7));
                s.setProblem_neuro_descrip(rs.getString(8));
                s.setProblem_nerviosos(rs.getBoolean(9));
                s.setProblem_nervi_descrip(rs.getString(10));
                s.setClima_familiar(rs.getString(11));
                s.setRelacion_padre(rs.getString(12));
                s.setRelacion_madre(rs.getString(13));
                s.setRelacion_hermanos(rs.getString(14));
                s.setTrabajo(rs.getBoolean(15));
                s.setTrabajo_decrip(rs.getString(16));
                s.setAgresion_agresor(rs.getBoolean(17));
                s.setObjeto_utilizado(rs.getString(18));
                s.setObligacion_familiar(rs.getString(19));
                s.setProyeccion_madre(rs.getString(20));
                s.setNecesidad_inmediata(rs.getString(21));
                s.setAgresion_frecuencia(rs.getString(22));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salud_nnaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
