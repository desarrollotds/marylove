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
public class persona_llamadaDB extends Persona_llamada {

    ConexionHi conectar =new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    //variables globales
    int id = 0;
    //variables locales para el metodo listaResultados()
    ArrayList<Resultado> r;
    ArrayList<Persona_llamada> lista_persona_llamada=new ArrayList<>();
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

    public persona_llamadaDB(String per_nombre, String per_apellido, String per_direccion, String per_nacionalidad, String per_rango_edad, String per_estado_civil, int per_numerohijos, String comosupollamada, boolean per_trabaja, String per_cedu_cod) {
        super(per_nombre, per_apellido, per_direccion, per_nacionalidad, per_rango_edad, per_estado_civil, per_numerohijos, comosupollamada, per_trabaja, per_cedu_cod);
    }

    public persona_llamadaDB(String per_nombre, String per_apellido, String per_direccion, String per_nacionalidad, String per_rango_edad, String per_estado_civil, int per_numerohijos, String comosupollamada, boolean per_trabaja) {
        super(per_nombre, per_apellido, per_direccion, per_nacionalidad, per_rango_edad, per_estado_civil, per_numerohijos, comosupollamada, per_trabaja);
    }

    public void ingresarPersona_llamada(Persona_llamada pl) {
       
        try {

            sql = "INSERT INTO public.persona_llamada( per_nombre, "
                    + "per_apellido, per_rango_edad, per_direccion ,per_nacionalidad ,"
                    + " per_estado_civil, per_numerohijos, "
                    + "comosupollamada, per_trabaja,per_cedu_cod) VALUES ('" + pl.getPer_nombre() + "','" + pl.getPer_apellido()
                    + "','" + pl.getPer_rango_edad() + "','" + pl.getPer_direccion() + "','"
                    + pl.getPer_nacionalidad() + "','" + pl.getPer_estado_civil()
                    + "'," + pl.getPer_numerohijos() + ",'" + pl.getComosupollamada() + "'," + pl.isPer_trabaja() + ",'"
                    + pl.getPer_cedu_cod()+"')"
                    + "returning per_codigo;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                System.out.println("re.getInt(1)");
                
                persona_llamada_static = re.getInt(1);
            }
            conectar.cerrarConexion();
        } catch (Exception ex) {
            System.out.println("Error en el Ingreso de persona "+ex.getMessage());
        }
        
    }

    public int obtenerIdPersonaLlamada() {

        try {
            
            sql = "select per_codigo from persona_llamada order by per_codigo desc limit 1;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conectar.cerrarConexion();
//            PreparedStatement ps = conectar.getConection().prepareStatement(sql);

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
          
            sql = "select resultado_id,resultado_nombre from resultado;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                rer = new Resultado(re.getInt("resultado_id"), re.getString("resultado_nombre"));
                r.add(rer);
            }
            conectar.cerrarConexion();
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
        
        sql = "SELECT per_codigo, per_nombre, per_apellido, per_rango_edad, "
                + "per_estado_civil, per_numerohijos, comosupollamada, per_direccion,"
                + " per_nacionalidad,  FROM public.persona_llamada where per_codigo="+id+";";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            pl=new Persona_llamada(re.getInt("per_codigo"), re.getString("per_nombre"), re.getString("per_apellido"), re.getString("per_direccion"), re.getString("per_nacionalidad"), re.getString("per_rango_edad"), re.getString("per_estado_civil"), re.getInt("per_numerohijos"), re.getString("comosupollamada"), re.getBoolean("per_trabaja"));
        }
        conectar.cerrarConexion();
        return pl;
    }
    public ArrayList lista_personas() throws SQLException {
        lista_persona_llamada= new ArrayList<>();
        sql = "select * from persona_llamada;";
        re = conectar.query(sql);
        while (re.next()) {
            Persona_llamada p = new Persona_llamada(re.getInt("per_codigo"),re.getString("per_nombre"),re.getString("per_apellido"),
            re.getString("per_direccion"),re.getString("per_nacionalidad"),re.getString("per_rango_edad"),re.getString("per_estado_civil"),
            re.getInt("per_numerohijos"),re.getString("comosupollamada"),re.getBoolean("per_trabaja"),re.getString("per_cedu_cod"));
            lista_persona_llamada.add(p);
            
        
        }
        
        return lista_persona_llamada;
    }
    public boolean verificar_existenciacedula(String c){
        boolean f=true;
        for (Persona_llamada o:lista_persona_llamada) {
            if( c.equals(o.getPer_cedu_cod())){
                f= true;
            } else {
                f=false;
            }
            System.out.println("metodos prueba : : : :"+o.toString());
        }
        return f;
    }
}
