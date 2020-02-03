package marylove.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.conexion.Conexion;

public class Persona {

    private ArrayList<String> cedula;
    private int persona_codigo;
    private String persona_cedula;
    private String persona_nombre;
    private String persona_apellido;
    private String persona_fecha_nac;
    private int persona_estadocivil;
    private int persona_nacionalidad;
    private int persona_ocupacion;
    private int persona_nivel_acad;
    private int persona_est_migr;
    private String persona_telefono;
    private String persona_celular;
    private int dir_codigo;
    private boolean persona_estado_actual;

    Conexion conn;

    public Persona() {
    }

    public Persona(int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int dir_codigo, boolean persona_estado_actual) {
        this.persona_codigo = persona_codigo;
        this.persona_cedula = persona_cedula;
        this.persona_nombre = persona_nombre;
        this.persona_apellido = persona_apellido;
        this.persona_fecha_nac = persona_fecha_nac;
        this.persona_estadocivil = persona_estadocivil;
        this.persona_nacionalidad = persona_nacionalidad;
        this.persona_ocupacion = persona_ocupacion;
        this.persona_nivel_acad = persona_nivel_acad;
        this.persona_est_migr = persona_est_migr;
        this.persona_telefono = persona_telefono;
        this.persona_celular = persona_celular;
        this.dir_codigo = dir_codigo;
        this.persona_estado_actual = persona_estado_actual;
    }

    public Persona(String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int dir_codigo) {
        this.persona_cedula = persona_cedula;
        this.persona_nombre = persona_nombre;
        this.persona_apellido = persona_apellido;
        this.persona_fecha_nac = persona_fecha_nac;
        this.persona_estadocivil = persona_estadocivil;
        this.persona_nacionalidad = persona_nacionalidad;
        this.persona_ocupacion = persona_ocupacion;
        this.persona_nivel_acad = persona_nivel_acad;
        this.persona_est_migr = persona_est_migr;
        this.persona_telefono = persona_telefono;
        this.persona_celular = persona_celular;
        this.dir_codigo = dir_codigo;
    }

    public Persona(String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int dir_codigo, boolean persona_estado_actual) {

        this.persona_cedula = persona_cedula;
        this.persona_nombre = persona_nombre;
        this.persona_apellido = persona_apellido;
        this.persona_fecha_nac = persona_fecha_nac;
        this.persona_estadocivil = persona_estadocivil;
        this.persona_nacionalidad = persona_nacionalidad;
        this.persona_ocupacion = persona_ocupacion;
        this.persona_nivel_acad = persona_nivel_acad;
        this.persona_est_migr = persona_est_migr;
        this.persona_telefono = persona_telefono;
        this.persona_celular = persona_celular;
        this.dir_codigo = dir_codigo;
        this.persona_estado_actual = persona_estado_actual;
    }

    public void actualizarPersona(Persona p) {
        try {
            conn = new Conexion();
            PreparedStatement ps;
            String sql = "UPDATE public.persona	"
                    + "SET persona_nombre='" + p.persona_nombre + "', persona_apellido='"
                    + p.persona_apellido + "', persona_fecha_nac='" + p.persona_fecha_nac + "',"
                    + " persona_ocupacion=" + p.persona_ocupacion + ", persona_nivel_acad=" + p.persona_nivel_acad + ", "
                    + "persona_est_migr=" + p.persona_est_migr + ", persona_telefono='" + p.persona_telefono + "', "
                    + "persona_celular='" + p.persona_celular + "', dir_codigo=" + p.dir_codigo + ", "
                    + "persona_estadocivil=" + p.persona_estadocivil + ", persona_nacionalidad="
                    + p.persona_nacionalidad + "WHERE persona_cedula='" + p.persona_cedula + "';";
            ps = conn.getConection().prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Persona Actualizada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }

    }

    public void ingresarPersona(Persona p) throws ParseException, Exception {
        try {
            conn = new Conexion();

            PreparedStatement ps;
            String sql = "INSERT INTO public.persona( persona_cedula, persona_nombre,"
                    + " persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad,"
                    + " persona_est_migr, persona_telefono, persona_celular, dir_codigo, persona_estadocivil,"
                    + " persona_nacionalidad,persona_estado_actual)VALUES ('" + p.persona_cedula + "','"
                    + p.persona_nombre + "','" + p.persona_apellido + "','" + p.persona_fecha_nac + "',"
                    + p.persona_ocupacion + "," + p.persona_nivel_acad + "," + p.persona_est_migr + ","
                    + p.persona_telefono + ",'" + p.persona_celular + "'," + p.dir_codigo + ","
                    + p.persona_estadocivil + "," + p.persona_nacionalidad + ",true);";

            ps = conn.getConection().prepareStatement(sql);
            ps.execute();

            conn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList listaCedulas() {

        try {
            conn = new Conexion();
            cedula = new ArrayList<>();
            String sql = "select persona_cedula from persona where persona_estado_actual=false;";
            PreparedStatement ps = conn.getConection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                cedula.add(rs.getString(1));
                System.out.println(rs.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cedula;
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

    public String getPersona_fecha_nac() {
        return persona_fecha_nac;
    }

    public void setPersona_fecha_nac(String persona_fecha_nac) {
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

    public int getDir_codigo() {
        return dir_codigo;
    }

    public void setDir_codigo(int dir_codigo) {
        this.dir_codigo = dir_codigo;
    }

}
