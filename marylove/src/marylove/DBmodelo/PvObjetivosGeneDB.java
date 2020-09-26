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
import marylove.models.Pv_objetivos_gene;

/**
 *
 * @author USUARIO
 */
public class PvObjetivosGeneDB extends Pv_objetivos_gene {

    PreparedStatement ps;
    ResultSet rs = null;
    ConexionHi conectar = new ConexionHi();
    String sql;
    boolean ingreso = true;

    public PvObjetivosGeneDB() {
    }

    public PvObjetivosGeneDB(int obj_codigo_gene, int planvida_codigo, String obejtivoGeneral, int personal_codigo, String tiempo, String observaciones) {
        super(obj_codigo_gene, planvida_codigo, obejtivoGeneral, personal_codigo, tiempo, observaciones);
    }

    public boolean insertarPvObjeGen() {
        try {
            sql = "INSERT INTO pv_objetivos_gene(planvida_codigo,personal_codigo,objetivo_general,tiempo, observaciones,objetivo_estado)";
            sql += "VALUES";
            sql += " (" + getPlanvida_codigo() + " ," + getPersonal_codigo() 
                    + " ,' " + getObejtivoGeneral() + " ',' " + getTiempo() 
                    + " ',' " + getObservaciones() + "','a')";
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar Plan de Vida ObjetivoGeneral: " + ex.getMessage());
            ingreso = false;
        }

        conectar.cerrarConexion();
        return ingreso;
    }

    public List<Pv_objetivos_gene> listarPvObjeGen(int cod) throws SQLException {
        List<Pv_objetivos_gene> listarPvObjeGen = new ArrayList<Pv_objetivos_gene>();
        sql = "select * from pv_objetivos_gene pvog\n"
                + "join plan_vida pv\n"
                + "on pvog.planvida_codigo = pv.planvida_codigo\n"
                + "where pv.victima_codigo = '" + cod + "'AND pvog.objetivo_estado = 'a';";
//        sql += "order by 1";
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Pv_objetivos_gene Pvog = new Pv_objetivos_gene();
                Pvog.setObj_codigo_gene(rs.getInt("obj_gene_codigo"));
                Pvog.setObejtivoGeneral(rs.getString("objetivo_general"));
                Pvog.setPersonal_codigo(rs.getInt("personal_codigo"));
                Pvog.setTiempo(rs.getString("tiempo"));
                Pvog.setObservaciones(rs.getString("observaciones"));
                listarPvObjeGen.add(Pvog);
            }
            rs.close();
            return listarPvObjeGen;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean actualizarPvObjGen() {
        sql = "UPDATE pv_objetivos_gene SET ";
        sql += "objetivo_general='" + getObejtivoGeneral() + "', ";
        sql += "tiempo='" + getTiempo() + "', ";
        sql += "observaciones='" + getObservaciones() + "'";
        sql += " WHERE obj_gene_codigo='" + getObj_codigo_gene() + "';";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }
    public List<Pv_objetivos_gene> buscarObjGen(String texto) throws SQLException {
        List<Pv_objetivos_gene> buscarObjGen = new ArrayList();
        System.out.println("testoDB: " + texto);
         sql = "select dog.obj_gene_codigo,pe.persona_cedula,pe.persona_nombre, pe.persona_apellido ,dog.objetivo_general, dog.responsable,dog.tiempo, dog.observaciones, pv.fecha_elaboracion, pv.fecha_evaluacion\n"
                + "from pv_objetivos_gene dog join plan_vida pv \n"
                + "on dog.planvida_codigo=pv.planvida_codigo inner join victima vc\n"
                + "on pv.victima_codigo = vc.victima_codigo inner join persona pe\n"
                + "on pe.persona_codigo = vc.persona_codigo "
                + "where objetivo_estado = 'a' and persona_cedula like '" + texto + "%'\n"
                + "OR persona_nombre LIKE '" + texto + "%'\n"
                + "OR persona_apellido like '" + texto + "%';";
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Pv_objetivos_gene p = new Pv_objetivos_gene();
                p.setObj_codigo_gene(rs.getInt("obj_gene_codigo"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setObejtivoGeneral(rs.getString("objetivo_general"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido("persona_apellido");
                p.setPersonal_codigo(rs.getInt("personal_codigo"));
                p.setTiempo(rs.getString("tiempo"));
                p.setObservaciones(rs.getString("observaciones"));
//                p.setFecha(rs.getString("evalucion_fecha"));
//                p.setFechaEval(rs.getString("evalucion_proxima"));
                buscarObjGen.add(p);

            }
            rs.close();
            return buscarObjGen;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean eliminarObjGen() {
        String sql = "UPDATE pv_objetivos_gene SET objetivo_estado = 'd' WHERE obj_gene_codigo='" + getObj_codigo_gene()+ "'";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }

}
