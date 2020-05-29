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
import marylove.models.Escala_prevencion_riesgo;

/**
 *
 * @author Asus
 */
public class Escala_prevencion_riesgoDB extends Escala_prevencion_riesgo {
    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    private static int esca_preve_ries_static;

    public Escala_prevencion_riesgoDB() {
    }

    public Escala_prevencion_riesgoDB(int victima_codigo, int psicologo_codigo) {
        super(victima_codigo, psicologo_codigo);
    }

    public Escala_prevencion_riesgoDB(int epr_codigo, int victima_codigo, int psicologo_codigo) {
        super(epr_codigo, victima_codigo, psicologo_codigo);
    }

    public static int getEsca_preve_ries_static() {
        return esca_preve_ries_static;
    }

    public static void setEsca_preve_ries_static(int esca_preve_ries_static) {
        Escala_prevencion_riesgoDB.esca_preve_ries_static = esca_preve_ries_static;
    }
    
    public boolean insertar_escala_prevencion_riesgo() throws SQLException{
    
        
        sql="INSERT INTO public.escala_prevencion_riesgos( victima_codigo, "
                + "psicologo_codigo) VALUES ("+getVictima_codigo()+", "
                + ""+getPsicologo_codigo()+")returning epr_codigo;";
        re=conectar.query(sql);
        if (re!=null) {
        while (re.next()) {
            esca_preve_ries_static=re.getInt(1);
        }
        return true;
        } else {
        return false;
        }
        
    }
    
}
