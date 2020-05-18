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
import marylove.models.Anamnesis;
import marylove.models.Desarrollo;
import marylove.models.Embarazo_estado;
import marylove.models.Escolaridad;

/**
 *
 * @author Usuario
 */
public class AnamnesisDB extends Anamnesis {

    //variables conexion
    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;

    //variables locales
    public AnamnesisDB() {
    }

    public AnamnesisDB(int hijo_codigo, int embarazo_id, int nacimiento_codigo, 
            int post_parto_id, int desarrollo_id, int escoralidad_id, int salud_nna_id, 
            int relación_familiar_nna_id, int sucoes_id, String observaciones_generales, 
            int personal_codigo) {
      
        super(hijo_codigo, embarazo_id, nacimiento_codigo, post_parto_id, desarrollo_id, escoralidad_id, salud_nna_id, relación_familiar_nna_id, sucoes_id, observaciones_generales, personal_codigo);
    }

    public boolean llenarAnamnesis() throws SQLException {
        String sql = "INSERT INTO public.anamnesis("
                + " hijo_codigo, embarazo_id, nacimiento_codigo,"
                + " post_parto_id, desarrollo_id, escolaridad_id, salud_nna_id, "
                + "rela_famili_nna_id, observaciones_generales, personal_codigo, sucoes_id)"
                + " VALUES ("+getHijo_codigo()+", "+getEmbarazo_id()+", "+getNacimiento_codigo()+", "
                + " "+getPost_parto_id()+", "+getDesarrollo_id()+", "+getEscoralidad_id()+","
                + " "+getSalud_nna_id()+", "+getRelación_familiar_nna_id()+","
                + " "+getSucoes_id()+", '"+getObservaciones_generales()+"',"+getPersonal_codigo()+");";
        ps = conectar.getConnection().prepareStatement(sql);
        if (ps.execute()) {
            conectar.cerrarConexion();
            return true;
        } else {
            conectar.cerrarConexion();
            return false;
        }

    }

}
