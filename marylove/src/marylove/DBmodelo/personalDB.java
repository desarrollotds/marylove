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
    boolean ingreso = true;
    
    boolean verif = true;
    
    public personalDB() {
    }
    
    

    public boolean ingrePersonal(Conexion con, Personal pel) {
        
        try {

            String sql = "INSERT INTO public.personal( personal_usuario, "
                    + "personal_contra, persona_codigo)"
                    + "VALUES ('" + pel.getPersonal_usuario() + "','" + pel.getPersonal_contra()
                    + "'," + pel.getPersona_codigo() + ");";
            ps = con.conectarBD().prepareStatement(sql);
            ps.execute();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar personal "+ex.getMessage());
            ingreso = false;
        }
        con.cerrarConexion();
        return ingreso;
    }

    public String verifiUser(Conexion con, String c_user) { // verifica si ya existe un usuario con el mismo nombre
        
        String user = "";
        try {
            String sql = "select * from Personal where personal_usuario = '" + c_user + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getString(2);
                System.out.println("Usuario ya existente");
                
            }
            verif = true;
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Usuario");
            verif = false;
        }
        con.cerrarConexion();
        return user;
    }
    
    // metodos para el ingreso de los usuarios
    

    public int verifContra(Conexion con, String user,String c_contra) { // verifica la contraseña y el ususario
        
        int contra = 0;
        try {
            String sql = "select * from Personal where personal_usuario = '" + user + "' AND personal_contra = '" + c_contra + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                contra = re.getInt(1);
                System.out.println("Contraseña valida");
            }
            verif=true;
        } catch (SQLException ex) {
            System.out.println("Contraseña no valida");
            verif=false;
        }
        con.cerrarConexion();
        return contra;
    }
    
    public int obtenerCod(Conexion con, String user,String c_contra){
        int codP=0;
        try {
            String sql = "select personal_codigo from Personal where personal_usuario = '" + user + "' AND personal_contra = '" + c_contra + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                codP = re.getInt(1);
            }
            con.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("error al obtener codigo: "+ex.getMessage());
            codP=0;
        }
        return codP;
    }
}
