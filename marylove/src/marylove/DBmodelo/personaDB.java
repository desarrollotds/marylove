
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class personaDB extends Persona{
    Conexion conectar = new Conexion();
    PreparedStatement ps;
    ResultSet re = null;
    
    public personaDB() {
    }
    
    public boolean ingrePersona(Conexion con,Persona per){
        boolean ingreso = true;
        try {

            String sql = "INSERT INTO public.persona( persona_cedula, "
                    + "persona_nombre,persona_apellido, persona_fecha_nac, persona_ocupacion ,persona_nivel_acad ,"
                    + " persona_est_migr, persona_teledono,persona_celular, "
                    + "persona_estadocivil, ppersona_nacionalidad,persona_sexo,persona_estado_actual) "
                    +"VALUES ('" + per.getPersona_cedula() + "','" + per.getPersona_nombre()
                    + "','" + per.getPersona_apellido() + "','" + per.getPersona_fecha_nac() + "','"
                    + per.getPersona_ocupacion() + "','" + per.getPersona_nivel_acad()
                    + "'," + per.getPersona_est_migr() + ",'" + per.getPersona_telefono() + "'," + per.getPersona_celular() + "'," +per.getPersona_estadocivil()
                    +per.getPersona_nacionalidad()+ ",'" +per.getPersona_sexo()+",true);";
//            ps = conn.getConection().prepareStatement(sql);
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona_llamada.class.getName()).log(Level.SEVERE, null, ex);
            ingreso = false;
        }
        
        return ingreso;
    }
    public boolean verifiCed(Conexion con, String ced){
        boolean existe = true;
        String cedula;
        try {
            String sql = "select persona_codigo from Persona where persona_codigo = '"+ced+"';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();

            while (re.next()) {
                cedula = re.getString(1);
                existe = true;
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("No existe usuario");
            existe = false;
        }
        
        return existe;
    }
}
