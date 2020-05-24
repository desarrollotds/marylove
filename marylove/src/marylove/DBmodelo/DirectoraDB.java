package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Directora;

/**
 *
 * @author vasquez
 */
public class DirectoraDB extends Directora {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar = new ConexionHi();

    public DirectoraDB() {
    }

    public boolean ingreDirectora(Directora dr) {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.directora( personal_codigo)"
                    + "VALUES (" + dr.getPersonal_codigo() + ");";
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar Directora " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }

    public int verifiUserD(int c_per) { // verifica que perfil es el usuario
        int user = 0;
        try {
            String sql = "select * from directora where personal_codigo = " + c_per + ";";
            re = conectar.query(sql);
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Directora " + ex.getMessage());
            conectar.cerrarConexion();
        }
        return user;
    }
}
