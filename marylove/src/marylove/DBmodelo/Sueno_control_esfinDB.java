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
import marylove.models.Sueno_control_esfin;

/**
 *
 * @author Asus
 */
public class Sueno_control_esfinDB extends Sueno_control_esfin{
    Conexion con;
    ConexionHi conn;
    PreparedStatement ps;
    ResultSet rs = null;
    private static int sucoes_id_static;
    
    public Sueno_control_esfinDB(boolean duerme_toda_noche, boolean miedo_dormir_solo, String despertar_descripcion, boolean pesadillas, 
            int acompanamiento_dormir, int edad_control_esfinter, boolean ayuda_bano, boolean moja_cama, String periodo_ecopresis_descrip) {
        super(duerme_toda_noche, miedo_dormir_solo, despertar_descripcion, pesadillas, acompanamiento_dormir, edad_control_esfinter, ayuda_bano, 
                moja_cama, periodo_ecopresis_descrip);
    }

    public Sueno_control_esfinDB() {
    }
    
    public boolean llenarSuenoControlEsfinter() throws SQLException {
        String sql = "INSERT INTO sueno_control_esfin(duerme_toda_noche, "
                + "miedo_dormir_solo, despertar_descripcion, pesadillas, "
                + "acompanamiento_dormir, edad_control_esfinter, ayuda_bano, "
                + "moja_cama, periodo_ecopresis_descrip)  "
                + " VALUES ('"+isDuerme_toda_noche()+"',"
                + " '"+isMiedo_dormir_solo()+"', '"+getDespertar_descripcion()+"', "
                + " '"+isPesadillas()+"', "+getAcompanamiento_dormir()+", "
                + " "+getEdad_control_esfinter()+", '"+isAyuda_bano()+"', "
                + " '"+isMoja_cama()+"','"+getPeriodo_ecopresis_descrip()+"')returning sucoes_id;";
        ps=conn.getConnection().prepareStatement(sql);
        rs=ps.executeQuery();
        conn.CerrarConexion();
        if(rs!=null){
         while(rs.next()){
        sucoes_id_static=rs.getInt(1);
        }
         return true;
        }else{
        return false;
        }
        
    }

    public static int getSucoes_id_static() {
        return sucoes_id_static;
    }

    public static void setSucoes_id_static(int sucoes_id_static) {
        Sueno_control_esfinDB.sucoes_id_static = sucoes_id_static;
    }
    
}
