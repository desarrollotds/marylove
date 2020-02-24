package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Personal;

/**
 *
 * @author vasquez
 */
public class personalDB extends Personal {

    PreparedStatement ps;
    ResultSet re = null;

    public personalDB() {
    }
    
    

    public boolean ingrePersona(Conexion con, Personal pel) {
        boolean ingreso = true;
        try {

            String sql = "INSERT INTO public.personal( personal_usuario, "
                    + "personal_contra,persona_codigo"
                    + "VALUES ('" + pel.getPersonal_usuario() + "','" + pel.getPersonal_contra()
                    + "','" + pel.getPersona_codigo() + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            ingreso = false;
        }
        con.cerrarConexion();
        return ingreso;
    }

    public boolean verifiUser(Conexion con, String c_user) { // verifica si ya existe un usuario con el mismo nombre
        boolean verif = true;
        String user = "";
        try {
            String sql = "select * from Personal where personal_usuario = '" + c_user + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getString(2);
                System.out.println("Usuario ya existente");
                verif = true;
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Usuario");
            verif = false;
        }
        con.cerrarConexion();
        return verif;
    }
    
    // metodos para el ingreso de los usuarios
    

    public int verifContra(Conexion con, String user,String c_contra) { // verifica la contraseña y el ususario
        int contra = 0;
        try {
            String sql = "select personal_codigo from Personal where personal_usuario = '" + user + "' AND personal_contra = '" + c_contra + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                contra = re.getInt(1);
                System.out.println("Contraseña valida");
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Contraseña no valida");
            contra = 0;
        }
        con.cerrarConexion();
        return contra;
    }
}
