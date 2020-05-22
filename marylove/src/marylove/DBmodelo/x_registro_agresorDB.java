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
import marylove.models.x_registro_agresor;

/**
 *
 * @author Asus
 */
public class x_registro_agresorDB extends x_registro_agresor {
    //variables static
    private static int registro_agresor_static;
    
    //variables DB
    PreparedStatement ps;
    ResultSet re = null;
    boolean ingreso = true;
    boolean verif = true;
    String sql = "";
    Conexion conectar = new Conexion();
    
    //variables globales
    int cod_re=0;

    public x_registro_agresorDB() {
    }

    public x_registro_agresorDB(int agresor_codigo, int registroreferencia_codigo, int parentesco) {
        super(agresor_codigo, registroreferencia_codigo, parentesco);
    }
    
    
    public int ingresarX_registro_agresor() throws SQLException{
    cod_re=0;
    sql="INSERT INTO public.x_registro_agresor( agresor_codigo, "
            + "registroreferencia_codigo, parentesco)VALUES ( "
            + getAgresor_codigo()+", "+getRegistroreferencia_codigo()+", "
            + getParentesco()+")returning registroagresor_codigo;";
    ps=conectar.conectarBD().prepareStatement(sql);
    re=ps.executeQuery();
    conectar.cerrarConexion();
    while(re.next()){
    
       registro_agresor_static=re.getInt(1);
       cod_re=re.getInt(1);
        
    }
    
    return cod_re;
    }

    public static int getRegistro_agresor_static() {
        return registro_agresor_static;
    }

    public static void setRegistro_agresor_static(int registro_agresor_static) {
        x_registro_agresorDB.registro_agresor_static = registro_agresor_static;
    }

    
    
    
}
