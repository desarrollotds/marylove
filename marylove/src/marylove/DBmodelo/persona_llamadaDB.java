/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Persona;
import marylove.models.Persona_llamada;

/**
 *
 * @author Alumno
 */
public class persona_llamadaDB {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;

    public int ingresarPersona_llamada(Persona_llamada pl) {
        conn = new ConexionHi();
         int personallamadcodigo=0;
        try {

            String sql = "INSERT INTO public.persona_llamada( per_nombre, "
                    + "per_apellido, per_rango_edad, per_direccion ,per_nacionalidad ,"
                    + " per_estado_civil, per_numerohijos, "
                    + "comosupollamada, per_trabaja) VALUES ('" + pl.getPer_nombre() + "','" + pl.getPer_apellido()
                    + "','" + pl.getPer_rango_edad() + "','" + pl.getPer_direccion() + "','"
                    + pl.getPer_nacionalidad() + "','" + pl.getPer_estado_civil()
                    + "'," + pl.getPer_numerohijos() + ",'" + pl.getComosupollamada() + "'," + pl.isPer_trabaja() + ")"
                    + "returning per_codigo;";
//            ps = conn.getConection().prepareStatement(sql);
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while(re.next()){
            personallamadcodigo=re.getInt(1);
            }
            conn.CerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona_llamada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personallamadcodigo;
    }

    public int obtenerIdPersonaLlamada() {
        int id = 0;
        try {
            conn = new ConexionHi();
            String sql = "select per_codigo from persona_llamada order by per_codigo desc limit 1;";
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            
//            PreparedStatement ps = conn.getConection().prepareStatement(sql);

            while (re.next()) {
                id = re.getInt(1);
                System.out.println("id_persona_llamada=" + re.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

   
}
