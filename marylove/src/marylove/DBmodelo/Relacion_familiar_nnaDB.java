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
import marylove.conexion.ConexionHi;
import marylove.models.Relacion_familiar_nna;

/**
 *
 * @author Asus
 */
public class Relacion_familiar_nnaDB extends Relacion_familiar_nna {
    Conexion con;
    ConexionHi conn;
    PreparedStatement ps;
    ResultSet rs = null;
    private static int rela_famili_nna_id_static;

    public Relacion_familiar_nnaDB() {
    }

    public Relacion_familiar_nnaDB(String clima_familiar, String relacion_padre, String relacion_madre, String relacion_hermanos, boolean trabajo, String trabajo_decrip, boolean agresion_agresor, String agresion_frecuencia, String objeto_utilizado, String obligacion_familiar, String proyeccion_madre, String necesidad_inmediata) {
        super(clima_familiar, relacion_padre, relacion_madre, relacion_hermanos, trabajo, trabajo_decrip, agresion_agresor, agresion_frecuencia, objeto_utilizado, obligacion_familiar, proyeccion_madre, necesidad_inmediata);
    }

   
  

    public static int getRela_famili_nna_id_static() {
        return rela_famili_nna_id_static;
    }

    public static void setRela_famili_nna_id_static(int rela_famili_nna_id_static) {
        Relacion_familiar_nnaDB.rela_famili_nna_id_static = rela_famili_nna_id_static;
    }
    
    public boolean llenarRelacionFamiliarNNA() throws SQLException {
        String sql = "INSERT INTO relacion_familiar_nna(clima_familiar, relacion_padre,"
                + " relacion_madre, relacion_hermanos, trabajo, trabajo_decrip, "
                + " agresion_agresor, agresion_frecuencia, objeto_utilizado, "
                + " obligacion_familiar, proyeccion_madre, necesidad_inmediata) "
                + "	VALUES ('"+getClima_familiar()+"', '"+getRelacion_padre()+"',"
                + " '"+getRelacion_madre()+"', '"+getRelacion_hermanos()+"',"
                + " '"+isTrabajo()+"', '"+getTrabajo_decrip()+"', '"+isAgresion_agresor()+"',"
                + " '"+getAgresion_frecuencia()+"', '"+getObjeto_utilizado()+"',"
                + " '"+getObligacion_familiar()+"', '"+getProyeccion_madre()+"', "
                + "'"+getNecesidad_inmediata()+"')returning rela_famili_nna_id;";

        ps=conn.getConnection().prepareStatement(sql);
        rs=ps.executeQuery();
        conn.CerrarConexion();
        if(rs!=null){
         while(rs.next()){
        rela_famili_nna_id_static=rs.getInt(1);
        }
         return true;
        }else{
        return false;
        }
    }
}
