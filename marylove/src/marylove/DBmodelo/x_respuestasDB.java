/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import marylove.conexion.ConexionHi;
import marylove.models.x_respuestas;

/**
 *
 * @author Asus
 */
public class x_respuestasDB extends x_respuestas{
        
    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";

    public x_respuestasDB() {
    }

    public x_respuestasDB(int enc_codigo, int pregunta_codigo, String resp_descripcion) {
        super(enc_codigo, pregunta_codigo, resp_descripcion);
    }

    public x_respuestasDB(int resp_id, int enc_codigo, int pregunta_codigo, String resp_descripcion) {
        super(resp_id, enc_codigo, pregunta_codigo, resp_descripcion);
    }
    
    public boolean insertar_x_respuesta() {
    
        sql="INSERT INTO public.x_respuestas( enc_codigo, pregunta_codigo, "
                + "resp_descripcion) VALUES ("+getEnc_codigo()+", "
                + getPregunta_codigo()+", '"+getResp_descripcion()+"');";
        if (conectar.noQuery(sql)) {
            return true;
        } else {
            return false;
        }
    
    }
    
    
}
