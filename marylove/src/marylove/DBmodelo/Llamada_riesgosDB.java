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
import marylove.models.Llamada_riesgos;

/**
 *
 * @author Unos conejos muy sospechosos
 */
public class Llamada_riesgosDB extends Llamada_riesgos {
    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";

    public Llamada_riesgosDB(int llamada_codigo, String frecuencia_agresion, String nacionalidad_agresor) {
        super(llamada_codigo, frecuencia_agresion, nacionalidad_agresor);
    }
    
    public void insertarLlamadaRiesgos() throws SQLException{
    conn= new ConexionHi();
    sql="INSERT INTO public.llamada_riesgos( llamada_codigo, "
    + "frecuencia_agresion, nacionalidad_agresor)VALUES ( "+getLlamada_codigo()
    + ", '"+getFrecuencia_agresion()+"', '"+getNacionalidad_agresor()+"');";
    ps=conn.getConnection().prepareStatement(sql);
    ps.execute();
    conn.CerrarConexion();
    
    }
    
}
