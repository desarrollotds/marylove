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
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Pv_objetivos_gene;

/**
 *
 * @author USUARIO
 */
public class PvObjetivosGeneDB extends Pv_objetivos_gene{
    
    //PreparedStatement ps;
    ResultSet re = null;
    Conexion conectar = new Conexion();
    ConexionHi conn;

    public PvObjetivosGeneDB() {
    }

    public PvObjetivosGeneDB(int obj_codigo_gene, int planvida_codigo, String obejtivoGeneral, int personal_codigo, String tiempo, String observaciones) {
        super(obj_codigo_gene, planvida_codigo, obejtivoGeneral, personal_codigo, tiempo, observaciones);
    }

    
    public boolean insertarPvObjeGen() {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO pv_objetivos_gene(planvida_codigo,personal_codigo,objetivogeneral,tiempo, observaciones)";
        sql += "VALUES";
        sql += " (" +getPlanvida_codigo()+ " ," +getPersonal_codigo()+ " ,' " +getObj_codigo_gene()+ " ',' " + getTiempo()+ " ',' " +getObservaciones()+"')";
        PreparedStatement ps = conectar.getPs(sql);
            //ps = conectar.conectarBD().prepareStatement(sql);
            ps.execute();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("Error al ingresar Plan de Vida ObjetivoGeneral: " + ex.getMessage());
            ingreso = false;
        }
        
        conectar.cerrarConexion();
        return ingreso;
    }
    
    public List<Pv_objetivos_gene> listarPvObjeGen(int cod) throws SQLException {
        List<Pv_objetivos_gene> listarPvObjeGen = new ArrayList<Pv_objetivos_gene>();
        String sql = "select * from pv_objetivos_gene pvog\n" +
                    "join plan_vida pv\n" +
                    "on pvog.planvida_codigo = pv.planvida_codigo\n" +
                    "where pv.victima_codigo = '"+ cod+"';";
//        sql += "order by 1";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Pv_objetivos_gene Pvog = new Pv_objetivos_gene();
                Pvog.setObj_codigo_gene(rs.getInt("obj_gene_codigo"));
                Pvog.setObejtivoGeneral(rs.getString("objetivogeneral"));
                Pvog.setTiempo(rs.getString("tiempo"));
                Pvog.setObservaciones(rs.getString("observaciones"));
                listarPvObjeGen.add(Pvog);
            }
            rs.close();
            return listarPvObjeGen;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public boolean actualizarPvObjGen() {
        String sql = "UPDATE pv_objetivos_gene SET ";
        sql += "objetivogeneral='" + getObejtivoGeneral()+ "', ";
        sql += "tiempo='" + getTiempo()+ "', ";
        sql += "observaciones='" + getObservaciones()+ "'";
        sql += " WHERE obj_gene_codigo='" + getObj_codigo_gene()+ "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
