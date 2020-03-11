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
import marylove.models.HistorialClinico;
import marylove.models.PlanEmergente;
import marylove.models.PlanEmergenteItem;

/**
 *
 * @author LENOVO
 */
public class PlanEmergente2DB extends PlanEmergente{
    Conexion conex = new Conexion();
  PreparedStatement ps;
    ResultSet re = null;

    public PlanEmergente2DB() {
    }

    public PlanEmergente2DB(int victima_codigo, String emergente_fecha, int personal_codigo) {
        super(victima_codigo, emergente_fecha, personal_codigo);
    }
    
    
   public boolean ingresarPlan2() {
             boolean ingre = true;  
       try {
        
              String sql = "INSERT INTO public.plan_emergente(victima_codigo, emergente_fecha, personal_codigo)";
              sql += "VALUES";
              sql += " ('"+getVictima_codigo()+"','"+getEmergente_fecha()+"','"+getPersonal_codigo()+"')";
              ps = conex.conectarBD().prepareStatement(sql);
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
    public PlanEmergente obtenetCV(int ced){
        PlanEmergente p = new PlanEmergente();
        PlanEmergenteItem pi = new PlanEmergenteItem();
//        "SELECT a.item_id, a.emergente_id, a.apreciacioninicial, a.accionesinmediatas, a.item_fecha, a.modalidad_nombre,p.emergente_fecha
//	FROM plan_emerg_item as a
//	JOIN plan_emergente as p
//	on p.emergente_id =a.emergente_id
//	where p.victima_codigo='"+ced+"';";
        try {
           // String sql = "select * from plan_emergente where victima_codigo='"+ced+"';";
            String sql = "SELECT ,p.emergente_fecha"
            +"FROM plan_emerg_item as a"
            +"JOIN plan_emergente as p"
            +"on p.emergente_id =a.emergente_id"
            +"where p.victima_codigo='"+ced+"';";
            ps = conex.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                p.setEmergente_fecha(re.getString(1));
                p.setVictima_codigo(re.getInt(2));
               // p.setPersonal_codigo(re.getInt(3));
//                pi.setAccionesinmediatas(re.getString(4));
//                pi.setApreciacioninicial(re.getString(5));
//                pi.setItem_fecha(re.getString(6));
                
            }
        } catch (SQLException ex) {
            System.out.println("error al obtener datos de victima "+ex.getMessage());
        }
        conex.cerrarConexion();
        return p;
    }
    
    
}//sdfsdfsdf
