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
import marylove.controlador.FiltroHijosVictima;
import marylove.models.Embarazo_estado;

/**
 *
 * @author Asus
 */
public class Embarazo_estadoDB extends Embarazo_estado {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;
    private static int embarazo_id_static;

    public Embarazo_estadoDB(int victima_codigo, boolean embarazo_planificado, String embarazo_reaccion_padre, String embarazo_reaccion_madre) {
        super(victima_codigo, embarazo_planificado, embarazo_reaccion_padre, embarazo_reaccion_madre);
    }

    public Embarazo_estadoDB(String donde_realizo_controles, String consumo_causas, String aborto_causas) {
        super(donde_realizo_controles, consumo_causas, aborto_causas);
    }

    public Embarazo_estadoDB() {
    }

    public boolean update_campos_primer() throws SQLException {
        String sql = "select embarazo_estado_primer_updateA (" + AnamnesisDB.embarazo_id + ", "
                + FiltroHijosVictima.victima_codigo_static + ", '" + isEmbarazo_planificado() + "','"
                + getEmbarazo_reaccion_padre() + "', '" + getEmbarazo_reaccion_madre() + "')";
        System.out.println(sql);
        boolean result = false;
        rs = conectar.query(sql);
        while (rs.next()) {
            result = rs.getBoolean(1);
            System.out.println(result);
        }
        return result;
    }

    public boolean update_campos_segundo() throws SQLException {
        String sql = "select embarazo_estado_segundo_updateA (" + AnamnesisDB.embarazo_id + ",'"
                + getDonde_realizo_controles() + "','" + getConsumo_causas() + "',"
                + "'" + getAborto_causas() + "')";
        boolean result = false;
        rs = conectar.query(sql);
        while (rs.next()) {
            result = rs.getBoolean(1);
            System.out.println(result);
        }
        return result;
    }

    public boolean llenarEmbarazoEstado() throws SQLException {
        String sql = "INSERT INTO embarazo_estado (victima_codigo, "
                + "embarazo_planificado, embarazo_reaccion_padre, "
                + "embarazo_reaccion_madre) "
                + "VALUES (" + getVictima_codigo() + ","
                + "'" + isEmbarazo_planificado() + "',"
                + "'" + getEmbarazo_reaccion_padre() + "',"
                + "'" + getEmbarazo_reaccion_madre() + "')"
                + " returning embarazo_id;";
        rs = conectar.query(sql);
        if (rs != null) {
            while (rs.next()) {
                embarazo_id_static = rs.getInt(1);
            }
            return true;
        } else {
            return false;
        }

    }

    public static int getEmbarazo_id_static() {
        return embarazo_id_static;
    }

    public static void setEmbarazo_id_static(int embarazo_id_static) {
        Embarazo_estadoDB.embarazo_id_static = embarazo_id_static;
    }

    //METODOS DE LA FICHA ANAMNESIS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //1.4 PERIODO DE EMBARAZO
    public boolean actualizarPeriodoEmbarazo(int victima_codigo) {
        String sql = "UPDATE embarazo_estado SET"
                + " embarazo_planificado = '" + isEmbarazo_planificado() + "'"
                + ", embarazo_reaccion_padre = '" + getEmbarazo_reaccion_padre() + "'"
                + ", embarazo_reaccion_madre = " + getEmbarazo_reaccion_madre() + ""
                + "WHERE persona_codigo = " + victima_codigo;

        if (conectar.noQuery(sql) == true) {
            System.out.println("1.4 Se actualizaron los datos del periodo de embarazo (Ubicación de método: Embarazo_estadoDB)");
            return true;
        } else {
            System.out.println("Error 1.4 No se pudo actualizar los datos del periodo de embarazo (Ubicación del método: Embarazo_estadoDB)");
            return false;
        }
    }

    public void EmbarazoAnamnesis(Embarazo_estado EA) {
        String sql = "select embarazo_planificado, embarazo_reaccion_padre, embarazo_reaccion_madre, donde_realizo_controles, consumo_causas, aborto_causas from anamnesis a join embarazo_estado using(embarazo_id) where a.hijo_codigo=" + FiltroHijosVictima.getCodigo() + ";";
        System.out.println(sql);
        try {
            rs = conectar.query(sql);
            while (rs.next()) {

                EA.setEmbarazo_planificado(rs.getBoolean(1));
                EA.setEmbarazo_reaccion_padre(rs.getString(2));
                EA.setEmbarazo_reaccion_madre(rs.getString(3));
                EA.setDonde_realizo_controles(rs.getString(4));
                EA.setConsumo_causas(rs.getString(5));
                EA.setAborto_causas(rs.getString(6));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Embarazo_estadoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
