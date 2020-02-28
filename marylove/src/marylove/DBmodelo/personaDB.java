package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Persona;
import marylove.models.Persona_llamada;

/**
 *
 * @author vasquez
 */
public class personaDB extends Persona {

    Conexion conectar = new Conexion();
    PreparedStatement ps;
    ResultSet re = null;

    public personaDB() {
    }

    public personaDB(PreparedStatement ps) {
        this.ps = ps;
    }

    public personaDB(int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, boolean persona_estado_actual, char persona_sexo) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_estadocivil, persona_nacionalidad, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estado_actual, persona_sexo);
    }

    public boolean ingrePersona() {
        boolean ingreso = true;
        try {

            String sql = "INSERT INTO public.persona( persona_cedula, "
                    + "persona_nombre,persona_apellido, persona_fecha_nac, persona_ocupacion ,persona_nivel_acad ,"
                    + " persona_est_migr, persona_telefono,persona_celular, "
                    + "persona_estadocivil, persona_nacionalidad,persona_sexo,persona_estado_actual) "
                    + "VALUES ('" + getPersona_cedula() + "','" + getPersona_nombre()
                    + "','" + getPersona_apellido() + "','" + getPersona_fecha_nac() + "',"
                    + getPersona_ocupacion() + "," + getPersona_nivel_acad()
                    + "," + getPersona_est_migr() + ",'" + getPersona_telefono() + "','"
                    + getPersona_celular() + "'," + getPersona_estadocivil() + ","
                    + getPersona_nacionalidad() + ",'" + getPersona_sexo() + "',true);";
            //            ps = conn.getConection().prepareStatement(sql);
            ps = conectar.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                re.getInt(1);
            }
            ingreso = true;

        } catch (SQLException ex) {
            Logger.getLogger(personaDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        conectar.cerrarConexion();
        return ingreso;
    }

    public int verifiCed(Conexion con, String ced) { // determinar si la cedula ingresada ya tiene datos 
        int cod_per= 0;
        try {
            String sql = "select persona_codigo from Persona where persona_cedula = '" + ced + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();

            while (re.next()) {
                cod_per = re.getInt(1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("No existe usuario");
            cod_per=0;
        }
        con.cerrarConexion();
        return cod_per;
    }

    public int obtenerCod(Conexion con, String ced) {
        int cod = 0;
        try {
            String sql = "select persona_codigo from Persona where persona_cedula = '" + ced + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();

            while (re.next()) {
                cod = re.getInt(1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("No existe usuario");
            cod = 0;
        }
        con.cerrarConexion();
        return cod;
    }

    public boolean ingrePersona2(Persona pe) {
        boolean ingreso = false;
        try {

            String sql = "INSERT INTO public.persona( persona_cedula, "
                    + "persona_nombre,persona_apellido, persona_fecha_nac, persona_ocupacion ,persona_nivel_acad ,"
                    + " persona_est_migr, persona_telefono,persona_celular, "
                    + "persona_estadocivil, persona_nacionalidad,persona_sexo,persona_estado_actual) "
                    + "VALUES ('" + pe.getPersona_cedula() + "','" + pe.getPersona_nombre()
                    + "','" + pe.getPersona_apellido() + "','" + pe.getPersona_fecha_nac() + "',"
                    + pe.getPersona_ocupacion() + "," + pe.getPersona_nivel_acad()
                    + "," + pe.getPersona_est_migr() + ",'" + pe.getPersona_telefono() + "','"
                    + pe.getPersona_celular() + "'," + pe.getPersona_estadocivil() + ","
                    + pe.getPersona_nacionalidad() + ",'" + pe.getPersona_sexo() + "',true);";
            //            ps = conn.getConection().prepareStatement(sql);
            ps = conectar.conectarBD().prepareStatement(sql);
            ps.execute();
            conectar.cerrarConexion();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar Persona "+ex.getMessage());
            ingreso = false;
        }
        return ingreso;
    }
}
