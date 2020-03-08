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
import marylove.models.PlanEmergente;

/**
 *
 * @author LENOVO
 */
public class PlanEmergente2DB extends PlanEmergente{
    Conexion conex = new Conexion();
  PreparedStatement ps;
    ResultSet re = null;

    public PlanEmergente2DB(int victima_codigo, String emergente_fecha, int personal_codigo) {
        super(victima_codigo, emergente_fecha, personal_codigo);
    }
    
    
   public boolean ingresarPlan2() {
             boolean ingre = true;  
       try {
        
              String sql = "INSERT INTO public.plan_emergente(emergente_fecha)";
              sql += "VALUES";
              sql += " ('"+getEmergente_fecha()+"')";
              ps = conex.conectarBD().prepareStatement(sql);
              ps.execute();
              ingre = true;
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
    
}//sdfsdfsdf
