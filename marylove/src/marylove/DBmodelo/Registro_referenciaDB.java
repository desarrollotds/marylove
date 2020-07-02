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
import marylove.models.Registro_referencia;

/**
 *
 * @author Asus
 */
public class Registro_referenciaDB extends Registro_referencia {

    //variables static
    private static int registro_referencia_static;

    //variables DB
    PreparedStatement ps;
    ResultSet re = null;
    boolean ingreso = true;
    boolean verif = true;
    String sql = "";
    ConexionHi conectar = new ConexionHi();
    ;
    
    //variables globales
    int cod_re = 0;

    public Registro_referenciaDB() {
    }

    public Registro_referenciaDB(int victima_codigo, String evidencias_agresion, int ayuda_codigo, boolean registra_agresioncontinua, boolean llamada_lineaapoyo, String frecuencia_agresion) {
        super(victima_codigo, evidencias_agresion, ayuda_codigo, registra_agresioncontinua, llamada_lineaapoyo, frecuencia_agresion);
    }

    public int ingresar_registro_referencia() throws SQLException {

        sql = "INSERT INTO public.registro_referencia( estado)VALUES ('true')returning registroreferencia_codigo;";
        ps = conectar.getConnection().prepareStatement(sql);
        re = conectar.query(sql);
        while (re.next()) {
            registro_referencia_static = re.getInt(1);
            cod_re = re.getInt(1);
        }
        return cod_re;
    }
    public boolean ingresar_codigo_victima(int id) {
        sql= "UPDATE public.registro_referencia SET victima_codigo="+id+""
                + "where registroreferencia_codigo=" + registro_referencia_static + ";";
        return conectar.noQuery(sql);
    
    }
    public boolean registr_referencia_update(int id) {
        sql = "UPDATE public.registro_referencia "
                + " SET victima_codigo=" + getVictima_codigo() + ", "
                + " evidencias_agresion='" + getEvidencias_agresion() + "', "
                + " ayuda_codigo=" + getAyuda_codigo() + ", "
                + " registra_agresion_continua='" + isRegistra_agresioncontinua() + "', "
                + " llamada_lineaapoyo=" + isLlamada_lineaapoyo() + ", "
                + " frecuencia_agresion='" + getFrecuencia_agresion() + "', "
                + " estado='true' "
                + " WHERE registroreferencia_codigo=" + id + ";";
        return conectar.noQuery(sql);
    }

    public static int getRegistro_referencia_static() {
        return registro_referencia_static;
    }

    public static void setRegistro_referencia_static(int registro_referencia_static) {
        Registro_referenciaDB.registro_referencia_static = registro_referencia_static;
    }

}
