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

    ConexionHi conn = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    boolean ingreso = true;
    
    public personaDB() {
    }

    public personaDB(PreparedStatement ps) {
        this.ps = ps;
    }

    public personaDB(int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, boolean persona_estado_actual, char persona_sexo) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_estadocivil, persona_nacionalidad, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estado_actual, persona_sexo);
    }

    public boolean ingrePersona() {
       
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
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                re.getInt(1);
            }
            ingreso = true;

        } catch (SQLException ex) {
            Logger.getLogger(personaDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn.CerrarConexion();
                
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

    
      public boolean eliminarPersona() {
        try {
            String sql = "UPDATE public.persona\n"
                    + "	SET  persona_estado_actual=false\n"
                    + "	WHERE persona_codigo=" + getPersona_cedula();
            ps = conn.getConnection().prepareStatement(sql);
            ps.execute();
            conn.CerrarConexion();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(personaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean modificarPersona() {
        try {
            String sql = "UPDATE public.persona\n"
                    + "	SET persona_cedula="+"'"+getPersona_cedula()+"'"
                    + ", persona_nombre="+"'"+getPersona_nombre()+"'"
                    + ", persona_apellido="+"'"+getPersona_apellido()+"'"
                    + ", persona_fecha_nac="+"'"+getPersona_fecha_nac()+"'"
                    + ", persona_ocupacion="+getPersona_ocupacion()
                    + ", persona_nivel_acad="+getPersona_nivel_acad()
                    + ", persona_est_migr="+getPersona_est_migr()
                    + ", persona_telefono="+"'"+getPersona_telefono()+"'"
                    + ", persona_celular="+"'"+getPersona_celular()+"'"
                    + ", persona_estadocivil="+getPersona_estadocivil()
                    + ", persona_nacionalidad="+getPersona_cedula()
                    + ", persona_sexo="+"'"+getPersona_sexo()+"'"
                    //editar y guardar lugar de trabajo
                //    + ", persona_nivel_acad_otros="+"'"+getPersona_+"'" falta ingresar variable.
                    + "WHERE persona_codigo=" + getPersona_cedula();
            ps = conn.getConnection().prepareStatement(sql);
            ps.execute();
            conn.CerrarConexion();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(personaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
