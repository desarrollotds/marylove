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
      ConexionHi conectar; // = new ConexionHi();
  PreparedStatement ps;
    ResultSet re = null;//gerwgrgjhudsgdg
    String sql="";
    public PlanEmergenteDB() {
    }
 public PlanEmergenteDB(long item_id, String apreciacioninicial, String apreciacioninicial1, String accionesinmediatas, String accionesinmediatas1, String item_fecha, String item_fecha1, String apreciacioninicial2, String apreciacioninicial3, String accionesinmediatas2, String accionesinmediatas3, String item_fecha2, String item_fecha3, String modalidad_nombre) {
        super(item_id, apreciacioninicial, apreciacioninicial1, accionesinmediatas, accionesinmediatas1, item_fecha, item_fecha1, apreciacioninicial2, apreciacioninicial3, accionesinmediatas2, accionesinmediatas3, item_fecha2, item_fecha3, modalidad_nombre);
    }

  

  

   public boolean ingresarPSI() {
               boolean ingre = true;  
       try {
        
              String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial()+"','"+getAccionesinmediatas()+"','"+getItem_fecha()+"','PSICOLOGIA')";
              ps = conectar.getConnection().prepareStatement(sql);
              ps.execute();
         
           } catch (SQLException ex) {
              System.out.println("error: " +ex);
          }
        conectar.cerrarConexion();
        
       return ingre;
    }
    public boolean ingresarTRA() {
             boolean hola = true;  
       try {
        String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial1()+"','"+getAccionesinmediatas1()+"','"+getItem_fecha1()+"','TRABAJO SOCIAL')";
              ps = conectar.getConnection().prepareStatement(sql);
              ps.execute();
             } catch (SQLException ex) {
              System.out.println("error: " +ex);
          }
       conectar.cerrarConexion();
       return hola;
    }
    public boolean ingresarLEG() {
             boolean ingre1 = true;  
       try {
        
              String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial2()+"','"+getAccionesinmediatas2()+"','"+getItem_fecha2()+"','LEGAL')";
              ps = conectar.getConnection().prepareStatement(sql);
              ps.execute();
         
             } catch (SQLException ex) {
              System.out.println("error: " +ex);
          }
       conectar.cerrarConexion();
       return ingre1;
    }
    public boolean ingresarINFA() {
             boolean ingre2 = true;  
       try {
        
              String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial3()+"','"+getAccionesinmediatas3()+"','"+getItem_fecha3()+"','INFANTO JUVENIL')";
              ps = conectar.getConnection().prepareStatement(sql);
              ps.execute();
         
              } catch (SQLException ex) {
              System.out.println("error: " +ex);
          }
       conectar.cerrarConexion();
       return ingre2;
    }

 public int maxID1() {
        int id = 0;
        try {
             sql = "select max(emergente_id) from plan_emergente ;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                id = (re.getInt(1) + 1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
        conectar.cerrarConexion();
        return id;
    }
}
