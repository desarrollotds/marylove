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
import marylove.models.Persona_llamada;

/**
 *
 * @author Asus
 */
public class Persona_llamadaDB {
    ConexionHi conn;
    PreparedStatement ps=null;
    ResultSet re=null;
    String sql="";
    public void ingresarPersona_llamada(Persona_llamada p) throws SQLException {
        conn=new ConexionHi();
        sql="INSERT INTO public.persona_llamada(per_nombre, per_apellido,"
        + " per_rango_edad, per_estado_civil, per_numerohijos, comosupollamada,"
        + " per_direccion, per_nacionalidad, per_trabaja)VALUES "
        + "('"+p.getPer_nombre().toUpperCase()+"','"+p.getPer_apellido().toUpperCase()
        + "', '"+p.getPer_rango_edad()+"', '"+p.getPer_estado_civil().toUpperCase()
        + "', "+p.getPer_numerohijos()+", '"+p.getComosupollamada()
        + "', '"+p.getPer_direccion()+"', '"+p.getPer_nacionalidad()
        + "', '"+p.isPer_trabaja()+"');";
        ps=conn.getConnection().prepareStatement(sql);
        ps.execute();
        conn.CerrarConexion();
    }
}
