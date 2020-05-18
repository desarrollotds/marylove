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
import marylove.conexion.ConexionHi;
import marylove.models.Nacimiento;

/**
 *
 * @author Asus
 */
public class NacimientoDB extends Nacimiento{
    
    ConexionHi conectar;
    PreparedStatement ps;
    ResultSet rs = null;
    String sql="";
    private static int nacimiento_id_static;

    public NacimientoDB() {
    }

    public NacimientoDB(int mes_alumbramiento, String lugar_nacimiento, String parto_tipo, String observaciozes_parto, boolean anestesia) {
        super(mes_alumbramiento, lugar_nacimiento, parto_tipo, observaciozes_parto, anestesia);
    }

    public NacimientoDB(int nacimiento_codigo, int mes_alumbramiento, String lugar_nacimiento, String parto_tipo, String observaciozes_parto, boolean anestesia) {
        super(nacimiento_codigo, mes_alumbramiento, lugar_nacimiento, parto_tipo, observaciozes_parto, anestesia);
    }
    public boolean llenarNacimiento() throws SQLException {
         sql = "INSERT INTO public.nacimiento(mes_alumbramiento, lugar_nacimiento,"
                + " parto_tipo, observaciones_parto, anestesia)"
                + " VALUES ("+getMes_alumbramiento()+", '"+getLugar_nacimiento()+"',"
                + " '"+getParto_tipo()+"', '"+getParto_tipo()+"', '"+isAnestesia()+"');";
        ps=conectar.getConnection().prepareStatement(sql);
        rs=ps.executeQuery();
        conectar.cerrarConexion();
        if(rs!=null){
         while(rs.next()){
        nacimiento_id_static=rs.getInt(1);
        }
         return true;
        }else{
        return false;
        }
        
    }

    public static int getNacimiento_id_static() {
        return nacimiento_id_static;
    }

    public static void setNacimiento_id_static(int nacimiento_id_static) {
        NacimientoDB.nacimiento_id_static = nacimiento_id_static;
    }
    
}
