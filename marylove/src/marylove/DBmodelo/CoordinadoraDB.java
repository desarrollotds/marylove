package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Coordinadora;

/**
 *
 * @author vasquez
 */
public class CoordinadoraDB extends Coordinadora {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar = new ConexionHi();

    public CoordinadoraDB() {
    }

    public boolean ingreCoodinadora(Coordinadora co) {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.coordinadora( personal_codigo)"
                    + "VALUES (" + co.getPersonal_codigo() + ");";
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar coordinadora " + ex.getMessage());
            ingreso = false;
        }
        return ingreso;
    }

    public int verifiUserC(int c_per) { // verifica que perfil es el usuario
        int user = 0;
        try {
            String sql = "select * from coordinadora where personal_codigo = " + c_per + ";";
            re = conectar.query(sql);
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener coordinadora " + ex.getMessage());
            user = 0;
        }
        return user;
    }
}
