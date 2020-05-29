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
public class x_respuestasDB extends x_respuestas {

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

    public boolean insert_x_respuesta(int enc_id, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10,
            int p11, int p12, int p13, int p14, int p15, int p16, int p17, int p18, int p19, int p20,
            String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10,
            String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20) {
        sql="select insertar_fichaR1 ( "+enc_id+" ,"+p1+","+p2+","+p3+","+p4+","+p5+","+p6+","+p7+","+p8+","+p9+","+p10+","+p11+","+p12+","+p13+","
                + p14+","+p15+","+p16+","+p17+","+p18+","+p19+","+p20+",'"+r1+"','"+r2+"','"+r3+"','"+r4+"','"+r5+"','"+r6+"','"
                + r7+"','"+r8+"','"+r9+"','"+r10+"','"+r11+"','"+r12+"','"+r13+"','"+r14+"','"+r15+"','"+r16+"','"+r17+"','"+r18+"','"+r19+"','"+r20+"');";
        
        if (conectar.noQuery(sql)) {
        return true;
        } else {
        return false;
        }
    }

}
