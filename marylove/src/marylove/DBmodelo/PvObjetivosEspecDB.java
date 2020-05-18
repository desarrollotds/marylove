/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Pv_objeticos_especificos;

/**
 *
 * @author USUARIO
 */
public class PvObjetivosEspecDB extends Pv_objeticos_especificos {

    ConexionHi conectar = new ConexionHi();
    String sql="";

    public PvObjetivosEspecDB() {
    }

    public PvObjetivosEspecDB(int obj_espe_codigo, int plan_de_vida, String obejtivosEspecificos, int personal_codigo, String actividad, String tiempo, String apoyode, String supu_amenazas) {
        super(obj_espe_codigo, plan_de_vida, obejtivosEspecificos, personal_codigo, actividad, tiempo, apoyode, supu_amenazas);
    }

    public boolean insertarPvObjectivEspecif() {
        boolean ingreso = true;
        try {
             sql = "INSERT INTO pv_objetivos_espe(planvida_codigo,personal_codigo,objetivoespecificos,actividad,tiempo,apoyode,supu_amenazas)";
            sql += "VALUES";
            sql += " (" + getPlan_de_vida() + " ," + getPersonal_codigo() + " ,' " + getObejtivosEspecificos() + " ',' " + getActividad() + " ',' " + getTiempo() + " ',' " + getApoyode() + " ',' " + getSupu_amenazas() + "')";
            PreparedStatement ps = conectar.getPs(sql);
            //ps = conectar.conectarBD().prepareStatement(sql);
            ps.execute();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("Error al ingresar Plan de Vida ObjetivoEspecifico: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;

    }

    public List<Pv_objeticos_especificos> listarPvObjetivEsp(int cod) throws SQLException {
        List<Pv_objeticos_especificos> listarPvObjetivEsp = new ArrayList<Pv_objeticos_especificos>();
         sql = "select * from pv_objetivos_espe pvoe\n"
                + "join plan_vida pv\n"
                + "on pvoe.planvida_codigo = pv.planvida_codigo\n"
                + "where pv.victima_codigo = '" + cod + "';";
//        sql += "order by 1";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Pv_objeticos_especificos Pvoe = new Pv_objeticos_especificos();
                Pvoe.setObj_espe_codigo(rs.getInt("obj_espe_codigo"));
                //planvida_codigo
                Pvoe.setObejtivosEspecificos(rs.getString("objetivoespecificos"));
                Pvoe.setActividad(rs.getString("actividad"));
                Pvoe.setTiempo(rs.getString("tiempo"));
                Pvoe.setApoyode(rs.getString("apoyode"));
                Pvoe.setSupu_amenazas(rs.getString("supu_amenazas"));
                listarPvObjetivEsp.add(Pvoe);
            }
            rs.close();
            return listarPvObjetivEsp;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean actualizarPvObjEsp() {
         sql = "UPDATE pv_objetivos_espe SET ";
        sql += "objetivoespecificos='" + getObejtivosEspecificos() + "', ";
        System.out.println("objet: " + getObejtivosEspecificos());
        sql += "actividad='" + getActividad() + "', ";
        sql += "tiempo='" + getTiempo() + "',";
        sql += "apoyode='" + getApoyode() + "',";
        sql += "supuestosamenazas='" + getSupu_amenazas() + "'";
        sql += " WHERE obj_espe_codigo='" + getObj_espe_codigo() + "';";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

}
