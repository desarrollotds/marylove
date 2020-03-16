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
import marylove.models.Agresor;

/**
 *
 * @author Unos conejos muy sospechosos
 */
public class AgresorDB extends Agresor {
    //Varibales static
    private static int agresor_codigo_static;
    
    //variablesDB
    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re;
    String sql = "";
    //variables globales
    int co_re=0;
    public AgresorDB() {
    }

    public AgresorDB(int persona_codigo) {
        super(persona_codigo);
    }

    public int insertarAgresor() throws SQLException {
        conn=new ConexionHi();
        co_re=0;
        sql = "INSERT INTO public.agresor( persona_codigo)VALUES "
                + "(" + getPersona_codigo() + ")returning agresor_codigo;";
        ps=conn.getConnection().prepareStatement(sql);
        re=ps.executeQuery();
        conn.CerrarConexion();
        while(re.next()){
            co_re=re.getInt(1);
            agresor_codigo_static=re.getInt(1);
        
        }
        return co_re;
    }

    public static int getAgresor_codigo_static() {
        return agresor_codigo_static;
    }

    public static void setAgresor_codigo_static(int agresor_codigo_static) {
        AgresorDB.agresor_codigo_static = agresor_codigo_static;
    }
    

}
