/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import marylove.conexion.Conexion;
import marylove.models.Anamnesis;

/**
 *
 * @author Usuario
 */
public class AnamnesisDB extends Anamnesis {

    Conexion con;
    PreparedStatement ps;
    ResultSet rs = null;

    public AnamnesisDB() {
    }

    public AnamnesisDB(int anamnesis_id, int hijo_codigo, int embarazo_id, int nacimiento_codigo, int post_parto_id, int desarrollo_id, int escoralidad_id, int salud_nna_id, int relación_familiar_nna_id, int sucoes_id, String observaciones_generales, int personal_codigo) {
        super(anamnesis_id, hijo_codigo, embarazo_id, nacimiento_codigo, post_parto_id, desarrollo_id, escoralidad_id, salud_nna_id, relación_familiar_nna_id, sucoes_id, observaciones_generales, personal_codigo);
    }

    public boolean ingresarFicha() {
        String sql = "INSERT INTO embarazo_estado (victima_codigo, embarazo_planificado, embarazo_reaccion_padre, embarazo_reaccion_madre) "
                + "VALUES ()";
        return true;
    }

}
