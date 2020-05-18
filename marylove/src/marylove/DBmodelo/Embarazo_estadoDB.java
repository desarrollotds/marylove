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
import marylove.models.Embarazo_estado;

/**
 *
 * @author Asus
 */
public class Embarazo_estadoDB extends Embarazo_estado {
    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;
    private static int embarazo_id_static;

    public Embarazo_estadoDB(int embarazo_id, int victima_codigo, boolean embarazo_planificado, String embarazo_reaccion_padre, String embarazo_reaccion_madre) {
        super(embarazo_id, victima_codigo, embarazo_planificado, embarazo_reaccion_padre, embarazo_reaccion_madre);
    }

    public Embarazo_estadoDB(String donde_realizo_controles, String consumo_causas, String aborto_causas) {
        super(donde_realizo_controles, consumo_causas, aborto_causas);
    }

    public Embarazo_estadoDB() {
    }

    public Embarazo_estadoDB(int victima_codigo, boolean embarazo_planificado, String embarazo_reaccion_padre, String embarazo_reaccion_madre) {
        super(victima_codigo, embarazo_planificado, embarazo_reaccion_padre, embarazo_reaccion_madre);
    }
    public void update_campos(int id) throws SQLException{
        String sql = "UPDATE public.embarazo_estado" +
"	SET donde_realizo_controles=?, consumo_causas=?, aborto_causas=?\n" +
"	WHERE embarazo_id="+id+";";
        ps=conectar.getConnection().prepareStatement(sql);
        ps.execute();
        conectar.cerrarConexion();
    } 
    public boolean llenarEmbarazoEstado() throws SQLException {
        String sql = "INSERT INTO embarazo_estado (victima_codigo, "
                + "embarazo_planificado, embarazo_reaccion_padre, "
                + "embarazo_reaccion_madre) "
                + "VALUES ("+getVictima_codigo()+","
                + "'"+isEmbarazo_planificado()+"',"
                + "'"+getEmbarazo_reaccion_padre()+"',"
                + "'"+getEmbarazo_reaccion_madre()+"')"
                + " returning embarazo_id;";
        ps=conectar.getConnection().prepareStatement(sql);
        rs=ps.executeQuery();
        conectar.cerrarConexion();
        if(rs!=null){
         while(rs.next()){
        embarazo_id_static=rs.getInt(1);
        }
         return true;
        }else{
        return false;
        }
       
       
    }

    public static int getEmbarazo_id_static() {
        return embarazo_id_static;
    }

    public static void setEmbarazo_id_static(int embarazo_id_static) {
        Embarazo_estadoDB.embarazo_id_static = embarazo_id_static;
    }
    
    
    
}
