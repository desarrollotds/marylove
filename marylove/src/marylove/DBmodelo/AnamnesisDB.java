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
    Conexion con;
    ConexionHi conn;
    PreparedStatement ps;
    ResultSet rs = null;
    private Conexion conecta = new Conexion();

    //variables locales
     
    public AnamnesisDB() {
    }

    public AnamnesisDB(int anamnesis_id, int hijo_codigo, int embarazo_id, int nacimiento_codigo, int post_parto_id, int desarrollo_id, int escoralidad_id, int salud_nna_id, int relación_familiar_nna_id, int sucoes_id, String observaciones_generales, int personal_codigo) {
        super(anamnesis_id, hijo_codigo, embarazo_id, nacimiento_codigo, post_parto_id, desarrollo_id, escoralidad_id, salud_nna_id, relación_familiar_nna_id, sucoes_id, observaciones_generales, personal_codigo);
    }

    public boolean ingresarFicha() {

        return true;
    }


    

  

    

    public boolean llenarDetalleNacimiento() {
        String sql = "INSERT INTO detalle_nacimiento(complicaciones_parto, peso, talla, lloro_nac, necesito_oxigeno, \"síntomas_after_part\", nacimiento_codigo)\n"
                + "	VALUES (?, ?, ?, ?, ?, ?, ?);";

        if (conecta.noQuery(sql) == null) {
            System.out.println("SE INSERTO CORRECTAMENTE");
            return true;
        } else {
            System.out.println("PROBLEMA AL INSERTAR");
            return false;
        }
    }

    public boolean llenarSueñoControlEsfinter() {
        String sql = "INSERT INTO \"sueño_control_esfin\"(duerme_toda_noche, miedo_dormir_solo, despertar_descripcion, pesadillas, \"acompañamiento_dormir\", edad_control_esfinter, \"ayuda_baño\", moja_cama, periodo_ecopresis_descrip) "
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        if (conecta.noQuery(sql) == null) {
            System.out.println("SE INSERTO CORRECTAMENTE");
            return true;
        } else {
            System.out.println("PROBLEMA AL INSERTAR");
            return false;
        }
    }

    public boolean llenarSaludNNA() {
        String sql = "INSERT INTO salud_nna(problem_familiar, problem_familiar_descrip, problem_respiratorio, problem_resp_descrip, problem_alergias, problem_aler_descrip, problem_neurologico, problem_neuro_descrip, problem_nerviosos, problem_nervi_descrip)\n"
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        if (conecta.noQuery(sql) == null) {
            System.out.println("SE INSERTO CORRECTAMENTE");
            return true;
        } else {
            System.out.println("PROBLEMA AL INSERTAR");
            return false;
        }
    }

    public boolean llenarRelacionFamiliarNNA() {
        String sql = "INSERT INTO relacion_familiar_nna(clima_familiar, \"relación_padre\", \"relación_madre\", \"relación_hermanos\", trabajo, trabajo_decrip, \"agresión_agresor\", \"agresión_frecuencia\", objeto_utilizado, \"obligación_familiar\", \"proyección_madre\", necesidad_inmediata) "
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        if (conecta.noQuery(sql) == null) {
            System.out.println("SE INSERTO CORRECTAMENTE");
            return true;
        } else {
            System.out.println("PROBLEMA AL INSERTAR");
            return false;
        }
    }

    public boolean llenarPostParto() {
        String sql = "INSERT INTO post_parto(\"sensación_post_parto\", sexo_esperado, \"reacción_padre\", \"reacción_madre\", alim_leche_master, alim_leche_master_descrip, alim_leche_master_edad_ini, alim_leche_master_fin, problemas_succion, destete_descripcion, edad_sentar, edad_caminar, edad_primeras_palabras, edad_aliment_solido, dificultades_alimentacion, veces_como_diario, actitud_madre_no_come, \"comer_solo_acompañado\") "
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        if (conecta.noQuery(sql) == null) {
            System.out.println("SE INSERTO CORRECTAMENTE");
            return true;
        } else {
            System.out.println("PROBLEMA AL INSERTAR");
            return false;
        }
    }

}
