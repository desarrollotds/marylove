package marylove.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;

/**
 *
 * @author icrv9
 */
public class Persona_llamada {

    private int per_codigo;
    private String per_nombre;
    private String per_apellido;
    private String per_direccion;
    private String per_nacionalidad;
    private String per_rango_edad;
    private String per_estado_civil;
    private int per_numerohijos;
    private String comosupollamada;
    private boolean per_trabaja;
    private Conexion conn;
     public void ingresarPersona_llamada(Persona_llamada pl){
    
        try {
            PreparedStatement ps;
            String sql ="INSERT INTO public.persona_llamada( per_nombre, "
                    + "per_apellido, per_rango_edad, per_direccion ,per_nacionalidad ,"
                    + " per_estado_civil, per_numerohijos, "
                    + "comosupollamada, per_trabaja) VALUES ('"+pl.getPer_nombre()+"','"+pl.getPer_apellido()
                    +"','"+pl.getPer_rango_edad()+"','"+pl.getPer_direccion()+"','"
                    +pl.getPer_nacionalidad()+"','"+pl.getPer_estado_civil()
                    +"',"+pl.getPer_numerohijos()+",'"+pl.getComosupollamada()+"',"+pl.isPer_trabaja()+");";
            ps = conn.getConection().prepareStatement(sql);
            ps.execute();
            conn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona_llamada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    }
     
    public Persona_llamada() {
    }
    public int obtenerIdPersonaLlamada(){
        int id=0;
    try {
            conn = new Conexion();
           
            String sql = "select per_codigo from persona_llamada order by per_codigo desc limit 1;";
            PreparedStatement ps = conn.getConection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id=rs.getInt(1);
                System.out.println("id_persona_llamada="+rs.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    return id;
    }

    public Persona_llamada(String per_nombre, String per_apellido, String per_direccion, String per_nacionalidad, String per_rango_edad, String per_estado_civil, int per_numerohijos, String comosupollamada, boolean per_trabaja) {
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_direccion = per_direccion;
        this.per_nacionalidad = per_nacionalidad;
        this.per_rango_edad = per_rango_edad;
        this.per_estado_civil = per_estado_civil;
        this.per_numerohijos = per_numerohijos;
        this.comosupollamada = comosupollamada;
        this.per_trabaja = per_trabaja;
    }

    public boolean isPer_trabaja() {
        return per_trabaja;
    }


    public void setPer_trabaja(boolean per_trabaja) {
        this.per_trabaja = per_trabaja;
    }



    

    public String getPer_nacionalidad() {
        return per_nacionalidad;
    }

    public void setPer_nacionalidad(String per_nacionalidad) {
        this.per_nacionalidad = per_nacionalidad;
    }
    
    
    public String getPer_direccion() {
        return per_direccion;
    }

    public void setPer_direccion(String per_direccion) {
        this.per_direccion = per_direccion;
    }

    public String getComosupollamada() {
        return comosupollamada;
    }

    public void setComosupollamada(String comosupollamada) {
        this.comosupollamada = comosupollamada;
    }
    public int getPer_codigo() {
        return per_codigo;
    }

    public void setPer_codigo(int per_codigo) {
        this.per_codigo = per_codigo;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_apellido() {
        return per_apellido;
    }

    public void setPer_apellido(String per_apellido) {
        this.per_apellido = per_apellido;
    }

    public String getPer_rango_edad() {
        return per_rango_edad;
    }

    public void setPer_rango_edad(String per_rango_edad) {
        this.per_rango_edad = per_rango_edad;
    }

    public String getPer_estado_civil() {
        return per_estado_civil;
    }

    public void setPer_estado_civil(String per_estado_civil) {
        this.per_estado_civil = per_estado_civil;
    }

    public int getPer_numerohijos() {
        return per_numerohijos;
    }

    public void setPer_numerohijos(int per_numerohijos) {
        this.per_numerohijos = per_numerohijos;
    }

   

}



