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

    PreparedStatement ps;
    ResultSet rs = null;
    ConexionHi conectar = new ConexionHi();
    String sql;
    boolean ingreso = true;

    public PvObjetivosEspecDB() {
    }

    public PvObjetivosEspecDB(int obj_espe_codigo, int plan_de_vida, String obejtivosEspecificos, int personal_codigo, String actividad, String tiempo, String apoyode, String supu_amenazas) {
        super(obj_espe_codigo, plan_de_vida, obejtivosEspecificos, personal_codigo, actividad, tiempo, apoyode, supu_amenazas);
    }
    

    public boolean insertarPvObjectivEspecif() {
        try {
            sql = "INSERT INTO pv_objetivos_espe(planvida_codigo,personal_codigo,objetivoespecificos,actividad,tiempo,apoyode,supu_amenazas,pv_estado)";
            sql += "VALUES";
            sql += " (" + getPlan_de_vida() + " ," + getPersonal_codigo() 
                    + " ,' " + getObejtivosEspecificos() + " ',' " + getActividad() 
                    + " ',' " + getTiempo() + " ',' " + getApoyode() + " ',' " 
                    + getSupu_amenazas() + "','a')";
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
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
                + "where pv.victima_codigo = '" + cod + "'AND pvoe.pv_estado = 'a';";
//        sql += "order by 1";
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Pv_objeticos_especificos Pvoe = new Pv_objeticos_especificos();
                Pvoe.setObj_espe_codigo(rs.getInt("obj_espe_codigo"));
                Pvoe.setObejtivosEspecificos(rs.getString("objetivoespecificos"));
                Pvoe.setPersonal_codigo(rs.getInt("personal_codigo"));
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
        sql += "supu_amenazas='" + getSupu_amenazas() + "'";
        sql += " WHERE obj_espe_codigo='" + getObj_espe_codigo() + "';";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }
     public List<Pv_objeticos_especificos> buscarObjEsp(String texto) throws SQLException {
        List<Pv_objeticos_especificos> buscarObjEsp = new ArrayList();
        System.out.println("testoDB: " + texto);
        sql = "select doe.obj_espe_codigo,pe.persona_cedula,pe.persona_nombre, pe.persona_apellido ,doe.objetivoespecificos, doe.actividad,doe.tiempo, doe.apoyode,doe.supu_amenazas,doe.responsable, pv.fecha_elaboracion, pv.fecha_evaluacion\n"
                + "from pv_objetivos_espe doe join plan_vida pv \n"
                + "on doe.planvida_codigo=pv.planvida_codigo inner join victima vc\n"
                + "on pv.victima_codigo = vc.victima_codigo inner join persona pe\n"
                + "on pe.persona_codigo = vc.persona_codigo "
                + "where pv_estado = 'a' and persona_cedula like '" + texto + "%'\n"
                + "OR persona_nombre LIKE '" + texto + "%'\n"
                + "OR persona_apellido like '" + texto + "%';";
         rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Pv_objeticos_especificos p = new Pv_objeticos_especificos();
                p.setObj_espe_codigo(rs.getInt("obj_espe_codigo"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setObejtivosEspecificos(rs.getString("objetivoespecificos"));
                p.setActividad(rs.getString("actividad"));
                p.setTiempo(rs.getString("tiempo"));
                p.setApoyode(rs.getString("apoyode"));
                p.setPersonal_codigo(rs.getInt("personal_codigo"));
                p.setSupu_amenazas(rs.getString("supu_amenazas"));
//                p.set(rs.getString("evalucion_fecha"));
//                p.setFechaEval(rs.getString("evalucion_proxima"));
                buscarObjEsp.add(p);

            }
            rs.close();
            return buscarObjEsp;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean eliminarObEsp(){ 
        sql = "UPDATE pv_objetivos_espe SET pv_estado = 'd' WHERE obj_espe_codigo='" + getObj_espe_codigo()+ "'";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }

}
