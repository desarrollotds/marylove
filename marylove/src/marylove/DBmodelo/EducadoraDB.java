package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Educadora;

/**
 *
 * @author vasquez
 */
public class EducadoraDB extends Educadora {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar = new ConexionHi();

    public EducadoraDB() {
    }

    public boolean ingreEducadora(Educadora ed) {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.educadora( personal_codigo)"
                    + "VALUES (" + ed.getPersonal_codigo() + ");";
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar Educadora " + ex.getMessage());
            ingreso = false;
        }
        return ingreso;
    }

    public int verifiUserE(int c_per) { // verifica que perfil es el usuario
        int user = 0;
        try {
            String sql = "select educadora_codigo from educadora where personal_codigo = " + c_per + ";";
            re = conectar.query(sql);
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Educadora " + ex.getMessage());
            conectar.cerrarConexion();
        }
        return user;
    }
}
