package marylove.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    private String per_cedu_cod;
     
     
    public Persona_llamada() {
    }

    public Persona_llamada(int per_codigo, String per_nombre, String per_apellido, String per_direccion, String per_nacionalidad, String per_rango_edad, String per_estado_civil, int per_numerohijos, String comosupollamada, boolean per_trabaja, String per_cedu_cod) {
        this.per_codigo = per_codigo;
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_direccion = per_direccion;
        this.per_nacionalidad = per_nacionalidad;
        this.per_rango_edad = per_rango_edad;
        this.per_estado_civil = per_estado_civil;
        this.per_numerohijos = per_numerohijos;
        this.comosupollamada = comosupollamada;
        this.per_trabaja = per_trabaja;
        this.per_cedu_cod = per_cedu_cod;
    }

    public Persona_llamada(String per_nombre, String per_apellido, String per_direccion, String per_nacionalidad, String per_rango_edad, String per_estado_civil, int per_numerohijos, String comosupollamada, boolean per_trabaja, String per_cedu_cod) {
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_direccion = per_direccion;
        this.per_nacionalidad = per_nacionalidad;
        this.per_rango_edad = per_rango_edad;
        this.per_estado_civil = per_estado_civil;
        this.per_numerohijos = per_numerohijos;
        this.comosupollamada = comosupollamada;
        this.per_trabaja = per_trabaja;
        this.per_cedu_cod = per_cedu_cod;
    }

    public Persona_llamada(int per_codigo, String per_nombre, String per_apellido, String per_direccion, String per_nacionalidad, String per_rango_edad, String per_estado_civil, int per_numerohijos, String comosupollamada, boolean per_trabaja) {
        this.per_codigo = per_codigo;
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

    public String getPer_cedu_cod() {
        return per_cedu_cod;
    }

    public void setPer_cedu_cod(String per_cedu_cod) {
        this.per_cedu_cod = per_cedu_cod;
    }

   

}



