package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Coordinadora;
import marylove.models.Directora;

/**
 *
 * @author vasquez
 */
public class DirectoraDB extends Directora {

    PreparedStatement ps;
    ResultSet re = null;
    Conexion conectar;
//    ConexionHi conectar;// = new ConexionHi();

    public DirectoraDB() {
    }

    public boolean ingreDirectora(Directora dr) {
        conectar = new Conexion();
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.directora( personal_codigo)"
                    + "VALUES (" + dr.getPersonal_codigo() + ");";
//            ps = conectar.getConnection().prepareStatement(sql);
//            ps.execute();
            if (conectar.noQuery(sql) == null) {
                ingreso = true;
            } else {
                ingreso = false;
            }
        } catch (Exception ex) {
            System.out.println("Error al ingresar Directora " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }

    public int verifiUserD(int c_per) { // verifica que perfil es el usuario
        conectar = new Conexion();
        boolean verif = true;
        int user = 0;
        try {
            String sql = "select * from directora where personal_codigo = " + c_per + ";";
//            ps = conectar.getConnection().prepareStatement(sql);
//            re = ps.executeQuery();
            re = conectar.query(sql);
            while (re.next()) {
                user = re.getInt(1);
                verif = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Directora " + ex.getMessage());
            verif = false;
        }
        conectar.cerrarConexion();
        return user;
    }
}
