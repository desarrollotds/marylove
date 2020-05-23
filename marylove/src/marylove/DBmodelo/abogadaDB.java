package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Abogada;

/**
 *
 * @author vasquez
 */
public class abogadaDB extends Abogada {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar = new ConexionHi();

    public abogadaDB() {
    }
    // metodo para guardar abogada

    public boolean ingreAbogada(Abogada ab) {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.abogada( personal_codigo)"
                    + "VALUES (" + ab.getPersonal_codigo() + ");";
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar Abogada " + ex.getMessage());
            ingreso = false;
        }
        return ingreso;
    }

    public int verifiUserA(int c_per) { // verifica que perfil es el usuario
        int user = 0;
        try {
            String sql = "select abogada_id from abogada where personal_codigo = " + c_per + ";";
            re = conectar.query(sql);
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Abogada " + ex.getMessage());
            conectar.cerrarConexion();
        }
        return user;
    }
}
