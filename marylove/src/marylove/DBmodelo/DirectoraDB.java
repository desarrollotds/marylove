
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Coordinadora;
import marylove.models.Directora;

/**
 *
 * @author vasquez
 */
public class DirectoraDB extends Directora{
    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar;// = new ConexionHi();

    public DirectoraDB() {
    }
    
    public boolean ingreDirectora(Directora dr) {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.directora( personal_codigo)"
                    + "VALUES (" + dr.getPersonal_codigo()+");";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error al ingresar Directora "+ex.getMessage());
            ingreso = false;
        }
       conectar.cerrarConexion();
        return ingreso;
    }
    
    public int verifiUserD(int c_per) { // verifica que perfil es el usuario
        boolean verif = true;
        int user = 0;
        try {
            String sql = "select * from directora where personal_codigo = " + c_per + ";";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
                verif = true;
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener Directora "+ex.getMessage());
            verif = false;
        }
        conectar.cerrarConexion();
        return user;
    }
}
