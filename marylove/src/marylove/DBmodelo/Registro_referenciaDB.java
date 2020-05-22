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
    Conexion conectar= new Conexion();;
    
    //variables globales
    int cod_re=0;
    
    public Registro_referenciaDB() {
    }

    public Registro_referenciaDB(int victima_codigo, String evidencias_agresion, int cita_id, int ayuda_codigo, boolean registra_agresioncontinua, boolean llamada_lineaapoyo, String frecuencia_agresion) {
        super(victima_codigo, evidencias_agresion, cita_id, ayuda_codigo, registra_agresioncontinua, llamada_lineaapoyo, frecuencia_agresion);
    }
    
    
    public int ingresarRegistroReferencia() throws SQLException{
        
        sql="INSERT INTO public.registro_referencia( "
                + "victima_codigo, evidencias_agresion, cita_id, ayuda_codigo,"
                + " registra_agresion_continua, llamada_lineaapoyo, "
                + "frecuencia_agresion)VALUES ("+getVictima_codigo()+",'"
                + getEvidencias_agresion()+"', "+getCita_id()+", "
                + getAyuda_codigo()+", '"+isRegistra_agresioncontinua()+"','"
                + isLlamada_lineaapoyo()+"','"+getFrecuencia_agresion()+"')returning registroreferencia_codigo;";
        ps=conectar.conectarBD().prepareStatement(sql);
        re=ps.executeQuery();
        conectar.cerrarConexion();
        while(re.next()){
        registro_referencia_static=re.getInt(1);
        cod_re=re.getInt(1);
        }
        return cod_re;
    }

    public static int getRegistro_referencia_static() {
        return registro_referencia_static;
    }

    public static void setRegistro_referencia_static(int registro_referencia_static) {
        Registro_referenciaDB.registro_referencia_static = registro_referencia_static;
    }
    
}
