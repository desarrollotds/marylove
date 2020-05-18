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
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Persona;
import marylove.models.Persona_llamada;
import marylove.models.Resultado;

/**
 *
 * @author Alumno
 */
public class persona_llamadaDB extends Persona_llamada {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    //variables globales
    int id = 0;
    //variables locales para el metodo listaResultados()
    ArrayList<Resultado> r;
    Resultado rer;
    private static int persona_llamada_static;

    public static int getPersona_llamada_static() {
        return persona_llamada_static;
    }

    public static void setPersona_llamada_static(int persona_llamada_static) {
        persona_llamadaDB.persona_llamada_static = persona_llamada_static;
    }
    
    public persona_llamadaDB() {
    }

    public persona_llamadaDB(String per_nombre, String per_apellido, String per_direccion, String per_nacionalidad, String per_rango_edad, String per_estado_civil, int per_numerohijos, String comosupollamada, boolean per_trabaja) {
        super(per_nombre, per_apellido, per_direccion, per_nacionalidad, per_rango_edad, per_estado_civil, per_numerohijos, comosupollamada, per_trabaja);
    }

    public int ingresarPersona_llamada(Persona_llamada pl) {
        conn = new ConexionHi();
        System.out.println("------");
        int personallamadcodigo = 0;
        try {

            sql = "INSERT INTO public.persona_llamada( per_nombre, "
                    + "per_apellido, per_rango_edad, per_direccion ,per_nacionalidad ,"
                    + " per_estado_civil, per_numerohijos, "
                    + "comosupollamada, per_trabaja) VALUES ('" + pl.getPer_nombre() + "','" + pl.getPer_apellido()
                    + "','" + pl.getPer_rango_edad() + "','" + pl.getPer_direccion() + "','"
                    + pl.getPer_nacionalidad() + "','" + pl.getPer_estado_civil()
                    + "'," + pl.getPer_numerohijos() + ",'" + pl.getComosupollamada() + "'," + pl.isPer_trabaja() + ")"
                    + "returning per_codigo;";
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                System.out.println("re.getInt(1)");
                personallamadcodigo = re.getInt(1);
                persona_llamada_static = re.getInt(1);
            }
            conn.CerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona_llamada.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(personallamadcodigo);
        return personallamadcodigo;
    }

    public int obtenerIdPersonaLlamada() {

        try {
            conn = new ConexionHi();
            sql = "select per_codigo from persona_llamada order by per_codigo desc limit 1;";
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conn.CerrarConexion();
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

    public ArrayList listaResultados() {
        r = new ArrayList<>();
        try {
            conn = new ConexionHi();
            sql = "select resultado_id,resultado_nombre from resultado;";
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                rer = new Resultado(re.getInt("resultado_id"), re.getString("resultado_nombre"));
                r.add(rer);
            }
            conn.CerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    //metodos para la ficha de registro y refencia...
    Persona_llamada pl;
    public persona_llamadaDB(int per_codigo, String per_nombre, String per_apellido, String per_direccion, String per_nacionalidad, String per_rango_edad, String per_estado_civil, int per_numerohijos, String comosupollamada, boolean per_trabaja) {
        super(per_codigo, per_nombre, per_apellido, per_direccion, per_nacionalidad, per_rango_edad, per_estado_civil, per_numerohijos, comosupollamada, per_trabaja);

    }
    

    public Persona_llamada obtenerPersonaCodigo(int id) throws SQLException {
        conn = new ConexionHi();
        
        sql = "SELECT per_codigo, per_nombre, per_apellido, per_rango_edad, "
                + "per_estado_civil, per_numerohijos, comosupollamada, per_direccion,"
                + " per_nacionalidad,  FROM public.persona_llamada where per_codigo="+id+";";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            pl=new Persona_llamada(re.getInt("per_codigo"), re.getString("per_nombre"), re.getString("per_apellido"), re.getString("per_direccion"), re.getString("per_nacionalidad"), re.getString("per_rango_edad"), re.getString("per_estado_civil"), re.getInt("per_numerohijos"), re.getString("comosupollamada"), re.getBoolean("per_trabaja"));
        }
        conn.CerrarConexion();
        return pl;
    }

}
