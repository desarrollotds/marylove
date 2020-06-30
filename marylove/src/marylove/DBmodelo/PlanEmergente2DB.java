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
import marylove.models.PlanEmergente;

/**
 *
 * @author LENqweqweqOVO
 */
 
public class PlanEmergente2DB extends PlanEmergente {
   private ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql="";
    public PlanEmergente2DB() {
        conectar = new ConexionHi();
    }

    public PlanEmergente2DB(int victima_codigo, String emergente_fecha, int personal_codigo) {
        super(victima_codigo, emergente_fecha, personal_codigo);
        conectar = new ConexionHi();
    }

    public boolean ingresarPlan2() {
        

            sql = "INSERT INTO public.plan_emergente(victima_codigo, emergente_fecha, personal_codigo)"
             +"VALUES"
             + " ('" + getVictima_codigo() + "','" + getEmergente_fecha() + "','" + getPersonal_codigo() + "')";
           boolean resultado = conectar.noQuery(sql);
       return resultado;
    }

    public void obtenetSelect(int ced) throws SQLException {
     ced =0;
        
             sql = "SELECT "
                    + "a.item_id,"
                    + "a.emergente_id,"
                    + "p.emergente_id, "
                    + "a.apreciacioninicial, "
                    + "a.accionesinmediatas, "
                    + "a.item_fecha, "
                    + "a.modalidad_nombre,"
                    + "p.emergente_fecha,"
                    + "p.victima_codigo,"
                     +"p.personal_codigo"
                    + " FROM plan_emerg_item a"
                    + " JOIN plan_emergente p on p.emergente_id =a.emergente_id"
                    + " JOIN victima v ON v.victima_codigo = p.victima_codigo"
                    + " JOIN persona per ON per.persona_codigo = v.persona_codigo"             
                    + " WHERE per.persona_cedula = '"+ced+"';";
             System.out.println("entrando");
            re = conectar.query(sql);
             
//ERFERFERFRE
      
       
       
    }
    public int obtenerCodigo() {
           int id = 0;
       try {
           sql = "select max(emergente_id) from plan_emerg_item ";
           re = conectar.query(sql);
           
           while (re.next()) {
               id = (re.getInt(1) + 1);
           }
       } catch (SQLException ex) {
           Logger.getLogger(PlanEmergente2DB.class.getName()).log(Level.SEVERE, null, ex);
       }
       return id;
    }

}