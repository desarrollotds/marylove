
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.Educadora;

/**
 *
 * @author vasquez
 */
public class EducadoraDB extends Educadora{
    PreparedStatement ps;
    ResultSet re = null;

    public EducadoraDB() {
    }
    
    public boolean ingreEducadora(Conexion con, Educadora ed) {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.educadora( personal_codigo)"
                    + "VALUES (" + ed.getPersonal_codigo()+");";
            ps = con.conectarBD().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error al ingresar Educadora "+ex.getMessage());
            ingreso = false;
        }
       con.cerrarConexion();
        return ingreso;
    }
    
    public int verifiUserE(Conexion con, int c_per) { // verifica que perfil es el usuario
        boolean verif = true;
        int user = 0;
        try {
            String sql = "select * from educadora where personal_codigo = " + c_per + ";";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
                verif = true;
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener Educadora "+ex.getMessage());
            verif = false;
        }
        con.cerrarConexion();
        return user;
    }
}
