/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.conexion.Conexion;
import marylove.models.Persona;
import marylove.conexion.ConexionHi;

/**
 *
 * @author Unos conejos muy sospechosos
 */
public class PersonaDB {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    private ArrayList<String> cedula;

    public void actualizarPersona(Persona p) {
        try {
            conn = new ConexionHi();
            PreparedStatement ps;
            String sql = "UPDATE public.persona	"
                    + "SET persona_nombre='" + p.getPersona_nombre() + "', persona_apellido='"
                    + p.getPersona_apellido() + "', persona_fecha_nac='" + p.getPersona_fecha_nac() + "',"
                    + " persona_ocupacion=" + p.getPersona_ocupacion() + ", persona_nivel_acad=" + p.getPersona_nivel_acad() + ", "
                    + "persona_est_migr=" + p.getPersona_est_migr() + ", persona_telefono='" + p.getPersona_telefono() + "', "
                    + "persona_celular='" + p.getPersona_celular() + "'," + "persona_estadocivil=" + p.getPersona_estadocivil()
                    + ", persona_nacionalidad=" + p.getPersona_nacionalidad() + "WHERE persona_cedula='" + p.getPersona_cedula() + "';";
//            ps = conn.getConection().prepareStatement(sql);
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conn.CerrarConexion();
            JOptionPane.showMessageDialog(null, "Persona Actualizada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }

    }
      public int obtenerIdPersona(){
    
            int id=0;
    try {
            conn = new ConexionHi();
           
            String sql = "select persona_codigo from persona order by persona_codigo desc limit 1;";
//            PreparedStatement ps = conn.getConection().prepareStatement(sql);
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conn.CerrarConexion();
            while (re.next()) {
                id=re.getInt(1);
                System.out.println("id_persona="+re.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }

    public void ingresarPersona(Persona p) throws ParseException, Exception {
        try {
            conn = new ConexionHi();

            
            String sql = "INSERT INTO public.persona( persona_cedula, persona_nombre,"
                    + " persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad,"
                    + " persona_est_migr, persona_telefono, persona_celular, persona_estadocivil,"
                    + " persona_nacionalidad,persona_estado_actual,persona_sexo)VALUES ('" + p.getPersona_cedula() + "','"
                    + p.getPersona_nombre().toUpperCase() + "','" + p.getPersona_apellido().toUpperCase() + "','" + p.getPersona_fecha_nac() + "',"
                    + p.getPersona_ocupacion() + "," + p.getPersona_nivel_acad() + "," + p.getPersona_est_migr() + ","
                    + p.getPersona_telefono() + ",'" + p.getPersona_celular() + "'," + p.getPersona_estadocivil() + "," 
                    + p.getPersona_nacionalidad() + ",true,'"+p.getPersona_sexo()+"'); ";

            ps = conn.getConnection().prepareStatement(sql);
            ps.execute();
            conn.CerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList listaCedulas() {

        try {
            conn = new ConexionHi();
            cedula = new ArrayList<>();
            String sql = "select persona_cedula from persona where persona_estado_actual=false;";
//            PreparedStatement ps = conn.getConection().prepareStatement(sql);
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conn.CerrarConexion();
            while (re.next()) {

                cedula.add(re.getString(1));
                System.out.println(re.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cedula;
    }
    public boolean verificarCedulas(String ced) {
         boolean personCedula = true;
        try {
            conn = new ConexionHi();
            String sql = "select * from persona where persona_cedula = '"+ced+"'";
//            PreparedStatement ps = conn.getConection().prepareStatement(sql);
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conn.CerrarConexion();
            while (re.next()) {
                System.out.println(re.getString(1));
                personCedula = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            personCedula = false;
        }
        return personCedula;
    }
}
