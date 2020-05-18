package marylove.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Persona {

    
    private int persona_codigo;
    private String persona_cedula;
    private String persona_nombre;
    private String persona_apellido;
    private Date persona_fecha_nac;
    private int persona_ocupacion;
    private int persona_nivel_acad;
    private int persona_est_migr;
    private String persona_telefono; 
    private String persona_celular;
    private int persona_estadocivil;
    private int persona_nacionalidad;
    private boolean persona_estado_actual;
    private char persona_sexo;
    private String persona_nivel_acad_otros;
    private String persona_lugar_trabajo;
    private String persona_referencia;
    public Persona() {
    }

    public Persona(String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        this.persona_cedula = persona_cedula;
        this.persona_nombre = persona_nombre;
        this.persona_apellido = persona_apellido;
        this.persona_fecha_nac = persona_fecha_nac;
        this.persona_telefono = persona_telefono;
        this.persona_celular = persona_celular;
        this.persona_sexo = persona_sexo;
    }
    

    public Persona(String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        this.persona_cedula = persona_cedula;
        this.persona_nombre = persona_nombre;
        this.persona_apellido = persona_apellido;
        this.persona_telefono = persona_telefono;
        this.persona_celular = persona_celular;
    }
 
    public Persona(String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        this.persona_cedula = persona_cedula;
        this.persona_nombre = persona_nombre;
        this.persona_apellido = persona_apellido;
        this.persona_fecha_nac = persona_fecha_nac;
        this.persona_sexo = persona_sexo;
    }
    
    public Persona(int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        this.persona_codigo = persona_codigo;
        this.persona_cedula = persona_cedula;
        this.persona_nombre = persona_nombre;
        this.persona_apellido = persona_apellido;
        this.persona_fecha_nac = persona_fecha_nac;
        this.persona_ocupacion = persona_ocupacion;
        this.persona_nivel_acad = persona_nivel_acad;
        this.persona_est_migr = persona_est_migr;
        this.persona_telefono = persona_telefono;
        this.persona_celular = persona_celular;
        this.persona_estadocivil = persona_estadocivil;
        this.persona_nacionalidad = persona_nacionalidad;
        this.persona_estado_actual = persona_estado_actual;
        this.persona_sexo = persona_sexo;
        this.persona_nivel_acad_otros = persona_nivel_acad_otros;
        this.persona_lugar_trabajo = persona_lugar_trabajo;
        this.persona_referencia = persona_referencia;
    }

    public Persona(String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        this.persona_cedula = persona_cedula;
        this.persona_nombre = persona_nombre;
        this.persona_apellido = persona_apellido;
        this.persona_fecha_nac = persona_fecha_nac;
        this.persona_ocupacion = persona_ocupacion;
        this.persona_nivel_acad = persona_nivel_acad;
        this.persona_est_migr = persona_est_migr;
        this.persona_telefono = persona_telefono;
        this.persona_celular = persona_celular;
        this.persona_estadocivil = persona_estadocivil;
        this.persona_nacionalidad = persona_nacionalidad;
        this.persona_estado_actual = persona_estado_actual;
        this.persona_sexo = persona_sexo;
        this.persona_nivel_acad_otros = persona_nivel_acad_otros;
        this.persona_lugar_trabajo = persona_lugar_trabajo;
        this.persona_referencia = persona_referencia;
    }

   
    

    public String getPersona_referencia() {
        return persona_referencia;
    }

    public void setPersona_referencia(String persona_referencia) {
        this.persona_referencia = persona_referencia;
    }
    


    public String getPersona_nivel_acad_otros() {
        return persona_nivel_acad_otros;
    }

    public void setPersona_nivel_acad_otros(String persona_nivel_acad_otros) {
        this.persona_nivel_acad_otros = persona_nivel_acad_otros;
    }

    public String getPersona_lugar_trabajo() {
        return persona_lugar_trabajo;
    }

    public void setPersona_lugar_trabajo(String persona_lugar_trabajo) {
        this.persona_lugar_trabajo = persona_lugar_trabajo;
    }
   

    public char getPersona_sexo() {
        return persona_sexo;
    }

    public void setPersona_sexo(char persona_sexo) {
        this.persona_sexo = persona_sexo;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }

    public String getPersona_cedula() {
        return persona_cedula;
    }

    public void setPersona_cedula(String persona_cedula) {
        this.persona_cedula = persona_cedula;
    }

    public String getPersona_nombre() {
        return persona_nombre;
    }

    public void setPersona_nombre(String persona_nombre) {
        this.persona_nombre = persona_nombre;
    }

    public String getPersona_apellido() {
        return persona_apellido;
    }

    public void setPersona_apellido(String persona_apellido) {
        this.persona_apellido = persona_apellido;
    }

    public Date getPersona_fecha_nac() {
        return persona_fecha_nac;
    }

    public void setPersona_fecha_nac(Date persona_fecha_nac) {
        this.persona_fecha_nac = persona_fecha_nac;
    }

    


    public int getPersona_estadocivil() {
        return persona_estadocivil;
    }

    public void setPersona_estadocivil(int persona_estadocivil) {
        this.persona_estadocivil = persona_estadocivil;
    }

    public int getPersona_nacionalidad() {
        return persona_nacionalidad;
    }

    public void setPersona_nacionalidad(int persona_nacionalidad) {
        this.persona_nacionalidad = persona_nacionalidad;
    }

    public int getPersona_ocupacion() {
        return persona_ocupacion;
    }

    public void setPersona_ocupacion(int persona_ocupacion) {
        this.persona_ocupacion = persona_ocupacion;
    }

    public int getPersona_nivel_acad() {
        return persona_nivel_acad;
    }

    public void setPersona_nivel_acad(int persona_nivel_acad) {
        this.persona_nivel_acad = persona_nivel_acad;
    }

    public int getPersona_est_migr() {
        return persona_est_migr;
    }

    public void setPersona_est_migr(int persona_est_migr) {
        this.persona_est_migr = persona_est_migr;
    }

    public String getPersona_telefono() {
        return persona_telefono;
    }

    public void setPersona_telefono(String persona_telefono) {
        this.persona_telefono = persona_telefono;
    }

    public String getPersona_celular() {
        return persona_celular;
    }

    public void setPersona_celular(String persona_celular) {
        this.persona_celular = persona_celular;
    }

    public boolean isPersona_estado_actual() {
        return persona_estado_actual;
    }

    public void setPersona_estado_actual(boolean persona_estado_actual) {
        this.persona_estado_actual = persona_estado_actual;
    }


}
