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
import marylove.models.Sueno_control_esfin;

/**
 *
 * @author Asus
 */
public class Sueno_control_esfinDB extends Sueno_control_esfin {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;
    String sql = "";
    private static int sucoes_id_static;

    public Sueno_control_esfinDB(int sucoes_id, boolean duerme_toda_noche, boolean miedo_dormir_solo, String despertar_descripcion, boolean pesadillas, int edad_control_esfinter, boolean ayuda_bano, boolean moja_cama, String periodo_ecopresis_descrip, boolean periodo_ecopresis, String como_es_sueno, String acompanamiento_dormir) {
        super(sucoes_id, duerme_toda_noche, miedo_dormir_solo, despertar_descripcion, pesadillas, edad_control_esfinter, ayuda_bano, moja_cama, periodo_ecopresis_descrip, periodo_ecopresis, como_es_sueno, acompanamiento_dormir);
    }

    public Sueno_control_esfinDB(boolean duerme_toda_noche, boolean miedo_dormir_solo, String despertar_descripcion, boolean pesadillas, int edad_control_esfinter, boolean ayuda_bano, boolean moja_cama, String periodo_ecopresis_descrip, boolean periodo_ecopresis, String como_es_sueno, String acompanamiento_dormir) {
        super(duerme_toda_noche, miedo_dormir_solo, despertar_descripcion, pesadillas, edad_control_esfinter, ayuda_bano, moja_cama, periodo_ecopresis_descrip, periodo_ecopresis, como_es_sueno, acompanamiento_dormir);
    }

    public Sueno_control_esfinDB() {
    }

    public boolean update_sueno_control_esfin(String duermeTodaNoche, String miedoDormirSolo, String pesadillas, String ayudaBano, String mojaCama, String incontrol_esfin_anal ) throws SQLException {
        sql = "select sueno_control_esfin_updateA (" + AnamnesisDB.sucoes_id + "," +duermeTodaNoche+ ", "
                + miedoDormirSolo + ",'" + getDespertar_descripcion() + "', "
                + pesadillas + "," + getEdad_control_esfinter() + ","
                + ayudaBano+ "," + mojaCama + ",'" + getIncontrol_esfin_anal_descrip()+ "',"
                + incontrol_esfin_anal + ",'" + getComo_es_sueno() + "','" + getAcompanamiento_dormir() + "')";
        System.out.println(sql);
        boolean result = false;
        rs = conectar.query(sql);

        while (rs.next()) {

            result = rs.getBoolean(1);
            System.out.println(result);
        }
        return result;
    }

    public boolean llenarSuenoControlEsfinter() throws SQLException {
        sql = "INSERT INTO sueno_control_esfin(duerme_toda_noche, "
                + "miedo_dormir_solo, despertar_descripcion, pesadillas, "
                + "acompanamiento_dormir, edad_control_esfinter, ayuda_bano, "
                + "moja_cama, periodo_ecopresis_descrip)  "
                + " VALUES ('" + isDuerme_toda_noche() + "',"
                + " '" + isMiedo_dormir_solo() + "', '" + getDespertar_descripcion() + "', "
                + " '" + isPesadillas() + "', " + getAcompanamiento_dormir() + ", "
                + " " + getEdad_control_esfinter() + ", '" + isAyuda_bano() + "', "
                + " '" + isMoja_cama() + "','" + getIncontrol_esfin_anal_descrip()+ "')returning sucoes_id;";
        rs = conectar.query(sql);
        if (rs != null) {
            while (rs.next()) {
                sucoes_id_static = rs.getInt(1);
            }
            return true;
        } else {
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
