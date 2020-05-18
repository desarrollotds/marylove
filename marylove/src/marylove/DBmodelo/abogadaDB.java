
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Abogada;

/**
 *
 * @author vasquez
 */
public class abogadaDB extends Abogada{
    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi con = new ConexionHi();

    public abogadaDB() {
    }
    // metodo para guardar abogada
    
    public boolean ingreAbogada(Abogada ab) {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.abogada( personal_codigo)"
                    + "VALUES (" + ab.getPersonal_codigo()+");";
            ps = con.getConnection().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error al ingresar Abogada "+ex.getMessage());
            ingreso = false;
        }
       con.cerrarConexion();
        return ingreso;
    }
    
    public int verifiUserA(int c_per) { // verifica que perfil es el usuario
        boolean verif = true;
        int user = 0;
        try {
            String sql = "select abogada_id from abogada where personal_codigo = " + c_per + ";";
            ps = con.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
                verif = true;
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener Abogada "+ex.getMessage());
            verif = false;
        }
        con.cerrarConexion();
        return user;
    }
}
