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
      ConexionHi conectar = new ConexionHi();
  PreparedStatement ps;
    ResultSet re = null;//gerwgrgjhudsgdg
    String sql="";
    public PlanEmergenteDB() {
    }
 public PlanEmergenteDB(long item_id, String apreciacioninicial, String apreciacioninicial1, String accionesinmediatas, String accionesinmediatas1, String item_fecha, String item_fecha1, String apreciacioninicial2, String apreciacioninicial3, String accionesinmediatas2, String accionesinmediatas3, String item_fecha2, String item_fecha3, String modalidad_nombre) {
        super(item_id, apreciacioninicial, apreciacioninicial1, accionesinmediatas, accionesinmediatas1, item_fecha, item_fecha1, apreciacioninicial2, apreciacioninicial3, accionesinmediatas2, accionesinmediatas3, item_fecha2, item_fecha3, modalidad_nombre);
    }

  

  

   public boolean ingresarPSI() {
            
        
              String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial()+"','"+getAccionesinmediatas()+"','"+getItem_fecha()+"','PSICOLOGIA')";
              boolean resultado = conectar.noQuery(sql);
       return resultado;
    }
    public boolean ingresarTRA() {
            
        String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial1()+"','"+getAccionesinmediatas1()+"','"+getItem_fecha1()+"','TRABAJO SOCIAL')";
              boolean resultado = conectar.noQuery(sql);
       return resultado;
    }
    public boolean ingresarLEG() {
          
     
        //uihiu
              String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial2()+"','"+getAccionesinmediatas2()+"','"+getItem_fecha2()+"','LEGAL')";
              boolean resultado = conectar.noQuery(sql);
       return resultado;
    }
    public boolean ingresarINFA() {
            
      
        
              String sql = "INSERT INTO public.plan_emerg_item(apreciacioninicial, accionesinmediatas,item_fecha,modalidad_nombre)";
              sql += "VALUES";
              sql += " ('"+getApreciacioninicial3()+"','"+getAccionesinmediatas3()+"','"+getItem_fecha3()+"','INFANTO JUVENIL')";
              boolean resultado = conectar.noQuery(sql);
       return resultado;
    }

 public int maxID1() throws SQLException {
        int id = 0;
       
             sql = "select max(emergente_id) from plan_emergente ;";
            re = conectar.query(sql);
            
            while (re.next()) {
                id = (re.getInt(1) + 1);
            }
            re = ps.executeQuery();
       
        return id;
    }
}
