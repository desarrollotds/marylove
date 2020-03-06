
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.Direccion_persona;

public class DireccionPersonaDB extends Direccion_persona{
    PreparedStatement ps;
    ResultSet re = null;
    
    public boolean insertaDireccionD(Conexion con, Direccion_persona dirp){
        boolean ing= true;
        
        try {
            String sql = "INSERT INTO public.direccion_persona(persona_codigo,dir_domicilio)"
                    + " VALUES(?,?);";
            ps = con.conectarBD().prepareStatement(sql);
            ps.setInt(1, dirp.getPersona_codigo());
            ps.setInt(2, dirp.getDir_domicilio());
            ps.execute();
            ing = true;
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar ficha Dirección: "+ex.getMessage());
            ing = false;
        }
        con.cerrarConexion();
         return ing;
    
    }
    
    public boolean insertaDireccionT(Conexion con, Direccion_persona dirp){
        boolean ing= true;
        
        try {
            String sql = "INSERT INTO public.direccion_persona(persona_codigo,dir_trabajo)"
                    + " VALUES(?,?);";
            ps = con.conectarBD().prepareStatement(sql);
            ps.setInt(1, dirp.getPersona_codigo());
            ps.setInt(2, dirp.getDir_trabajo());
            ps.execute();
            ing = true;
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar ficha Dirección: "+ex.getMessage());
            ing = false;
        }
        con.cerrarConexion();
         return ing;
    
    }
    
    public int verifiUser(Conexion con, int cod_per) { // verifica que perfil es el usuario
        int dirCod = 0;
        try {
            String sql = "select dirp_id from direccion_persona where persona_codigo = '" + cod_per + "';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                dirCod = re.getInt(1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            dirCod = 0;
            System.out.println("erorr al obtener direccion persona"+ex.getMessage());
        }
        con.cerrarConexion();
        return dirCod;
    }
}
