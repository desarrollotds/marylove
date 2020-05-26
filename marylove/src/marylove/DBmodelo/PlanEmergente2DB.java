/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.PlanEmergente;

/**
 *
 * @author LENqweqweqOVO
 */
public class PlanEmergente2DB extends PlanEmergente {
ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql="";
    public PlanEmergente2DB() {
    }

    public PlanEmergente2DB(int victima_codigo, String emergente_fecha, int personal_codigo) {
        super(victima_codigo, emergente_fecha, personal_codigo);
    }

    public boolean ingresarPlan2() {
        

            sql = "INSERT INTO public.plan_emergente(victima_codigo, emergente_fecha, personal_codigo)";
            sql += "VALUES";
            sql += " ('" + getVictima_codigo() + "','" + getEmergente_fecha() + "','" + getPersonal_codigo() + "')";
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
    public int obtenerCodigo(int cod) throws SQLException {
        int id = 0;
     
             sql = "select plan_emergente from victima_codigo where =" + cod + ";";
            re = conectar.query(sql);
          
            while (re.next()) {
                id = (re.getInt(1) + 1);
            }
         
       
        return id;
    }

}//sdfsdfsdf
