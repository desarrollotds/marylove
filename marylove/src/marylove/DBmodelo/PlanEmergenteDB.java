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
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.PlanEmergenteItem;

/**
 *
 * @authorasxasxfghgSDFSDGs Alumno
 */

public class PlanEmergenteDB extends PlanEmergenteItem{
      ConexionHi conex = new ConexionHi();
  PreparedStatement ps;
    ResultSet re = null;

    public PlanEmergenteDB() {
    }

    public PlanEmergenteDB(long item_id, String apreciacioninicial, String accionesinmediatas, String item_fecha, String modalidad_nombre, int victima_codigo, String emergente_fecha, int personal_codigo) {
        super(item_id, apreciacioninicial, accionesinmediatas, item_fecha, modalidad_nombre, victima_codigo, emergente_fecha, personal_codigo);
    }
    

   public boolean ingresarPSI() {
             boolean ingre = true;  
       try {
        
              String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial()+"','"+getAccionesinmediatas()+"','"+getItem_fecha()+"','PSICOLOGIA')";
              ps = conex.getConnection().prepareStatement(sql);
              ps.execute();
         
              if (conex.noQuery(sql) == null) {
                  return true;
              } else {
                  return false;
              } } catch (SQLException ex) {
              System.out.println("error: " +ex);
          }
       conex.cerrarConexion();
       return ingre;
    }
    public boolean ingresarTRA() {
             boolean hola = true;  
       try {
        
              String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial()+"','"+getAccionesinmediatas()+"','"+getItem_fecha()+"','TRABAJO SOCIAL')";
              ps = conex.getConnection().prepareStatement(sql);
              ps.execute();
         
              if (conex.noQuery(sql) == null) {
                  return true;
              } else {
                  return false;
              } } catch (SQLException ex) {
              System.out.println("error: " +ex);
          }
       conex.cerrarConexion();
       return hola;
    }
    public boolean ingresarLEG() {
             boolean ingre1 = true;  
       try {
        
              String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial()+"','"+getAccionesinmediatas()+"','"+getItem_fecha()+"','LEGAL')";
              ps = conex.getConnection().prepareStatement(sql);
              ps.execute();
         
              if (conex.noQuery(sql) == null) {
                  return true;
              } else {
                  return false;
              } } catch (SQLException ex) {
              System.out.println("error: " +ex);
          }
       conex.cerrarConexion();
       return ingre1;
    }
    public boolean ingresarINFA() {
             boolean ingre2 = true;  
       try {
        
              String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial()+"','"+getAccionesinmediatas()+"','"+getItem_fecha()+"','INFANTO JUVENIL')";
              ps = conex.getConnection().prepareStatement(sql);
              ps.execute();
         
              if (conex.noQuery(sql) == null) {
                  return true;
              } else {
                  return false;
              } } catch (SQLException ex) {
              System.out.println("error: " +ex);
          }
       conex.cerrarConexion();
       return ingre2;
    }

//     public PlanEmergenteItem obtenetCV(Conexion con, String ced){
//        PlanEmergenteItem hisCli = new PlanEmergenteItem();
//        try {
//            String sql = "select * from plan_emerg_item as hc"
//                    +" join plan_emergente as vc on hc.emergente_id = vc.emergente_id"
//                    +" join personal as pe on vc.personal_codigo = pe.personal_codigo"
//                    +" where pe.persona_cedula = '"+ced+"';";
//            ps = con.conectarBD().prepareStatement(sql);
//            re = ps.executeQuery();
//            while (re.next()) {
//               
//                hisCli.setVictima_codigo(re.getInt(1));
//        
//            }
//        } catch (SQLException ex) {
//            System.out.println("error al obtener datos de victima "+ex.getMessage());
//        }
//        con.cerrarConexion();
//        return hisCli;
//    }
}
