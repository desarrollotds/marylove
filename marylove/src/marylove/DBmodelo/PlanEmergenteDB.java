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
import marylove.conexion.Conexion;
import marylove.models.PlanEmergenteItem;

/**
 *
 * @author Alumno
 */
public class PlanEmergenteDB extends PlanEmergenteItem{
  PreparedStatement ps;
    ResultSet re = null;

    public PlanEmergenteDB() {
    }
    

    public PlanEmergenteDB(long item_id, int emergencia_id, String apreciacioninicial, Date item_feha, String modalidad_nombre, long emergente_id, int victima_codigo, Date emergente_fecha, int personal_codigo) {
        super(item_id, emergencia_id, apreciacioninicial, item_feha, modalidad_nombre, emergente_id, victima_codigo, emergente_fecha, personal_codigo);
    }
     public boolean ingresarHistClinico(Conexion con, PlanEmergenteItem pei){
        boolean ingre=true;
        try {
            String sql = "INSERT INTO public.historial_clinico (item_id"
                    + "emergente_fecha,emergente_id,victima_codigo,personal_codigo, apreciacioninicial, accionesinmediatas, item_fecha, modalidad_nombre"
                   
                  
                    + " VALUES (" + pei.getItem_id()+ "," + pei.getEmergente_fecha()+ ",'"+pei.getEmergencia_id()
                    + "','" + pei.getVictima_codigo()+ "','" + pei.getPersonal_codigo()+ "','"+pei.getApreciacioninicial()
                    + "','"+ pei.getAccionesinmediatas() +"','"+pei.getItem_feha()
                    +"','"+pei.getModalidad_nombre()+"');";
            ps = con.conectarBD().prepareStatement(sql);
            ps.execute();
            ingre = true;

        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar ficha PlanEMERGENTE: "+ex.getMessage());
            ingre = false;
        }
        con.cerrarConexion();
        return ingre; 
    }
    
}
