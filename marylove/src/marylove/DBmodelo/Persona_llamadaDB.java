/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Persona;
import marylove.models.Persona_llamada;
import marylove.models.Resultado;

/**
 *
 * @author Alumno
 */
public class Persona_llamadaDB {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    private ArrayList<Resultado> resulatdos;//lista de resultados
    

    public ArrayList listaResultados() {//metodo para obtener la lista de los resultados de la llamada
        resulatdos = new ArrayList<>();
        conn = new ConexionHi();
        try {
           String sql = "select * from resultado;";
         ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conn.CerrarConexion();
            while (re.next()) {
                Resultado r=new Resultado();
                r.setResultado_id(re.getInt(1));
                r.setResultado_nombre(re.getString(2));
               resulatdos.add(r);
                

            } 
        } catch (Exception e) {
        }
        
        return resulatdos;
    }
    

    public void ingresarPersona_llamada(Persona_llamada pl) {// metodo para insertar a una nueva persona
        conn = new ConexionHi();
        try {

            String sql = "INSERT INTO public.persona_llamada( per_nombre, "
                    + "per_apellido, per_rango_edad, per_direccion ,per_nacionalidad ,"
                    + " per_estado_civil, per_numerohijos, "
                    + "comosupollamada, per_trabaja) VALUES ('" + pl.getPer_nombre() + "','" + pl.getPer_apellido()
                    + "','" + pl.getPer_rango_edad() + "','" + pl.getPer_direccion() + "','"
                    + pl.getPer_nacionalidad() + "','" + pl.getPer_estado_civil()
                    + "'," + pl.getPer_numerohijos() + ",'" + pl.getComosupollamada() + "'," + pl.isPer_trabaja() + ");";
//            ps = conn.getConection().prepareStatement(sql);
            ps = conn.getConnection().prepareStatement(sql);
            ps.execute();
            conn.CerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona_llamada.class.getName()).log(Level.SEVERE, null, ex);
        }

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
