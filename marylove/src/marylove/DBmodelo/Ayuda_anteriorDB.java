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
import marylove.models.Ayuda_anterior;

/**
 *
 * @author Asus
 */
public class Ayuda_anteriorDB extends Ayuda_anterior {
//variables static
    public static int ayuda_anterior_static;
    
    //variables DB
    PreparedStatement ps;
    ResultSet re = null;
    boolean ingreso = true;
    boolean verif = true;
    String sql = "";
    ConexionHi conn;
//variables globales
    int co_re;

    public Ayuda_anteriorDB() {
    }

    public Ayuda_anteriorDB(String ayuda_nombre, String ayuda_telefono, String ayuda_motivo, String ayuda_atencion, String ayuda_contactoReferencia) {
        super(ayuda_nombre, ayuda_telefono, ayuda_motivo, ayuda_atencion, ayuda_contactoReferencia);
    }


   
    public int insertarAyudaAnterior() throws SQLException{
    conn=new ConexionHi();
    co_re=0;
    sql="INSERT INTO public.ayuda_anterior( ayuda_nombre, ayuda_telefono, "
            + "ayuda_motivo, ayuda_atencion, "
            + "ayuda_contacto_referencia)VALUES ('"+getAyuda_nombre()+"','"
            + getAyuda_telefono()+"','"+getAyuda_motivo()+"','"+getAyuda_atencion()+"','"
            + getAyuda_contactoReferencia()+")returning ayuda_codigo;";
    ps=conn.getConnection().prepareStatement(sql);
    re=ps.executeQuery();
    conn.CerrarConexion();
    while(re.next()){
    
    
    }
          
    
    return co_re;
    }

}
