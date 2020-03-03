package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.Trabajo_social;

/**
 *
 * @author vasquez
 */
public class Trabajo_SocialDB extends Trabajo_social {

    PreparedStatement ps;
    ResultSet re = null;

    public Trabajo_SocialDB() {
    }

    public boolean ingreTrabSocial(Conexion con, Trabajo_social ts) {
        boolean ingreso = true;
        String sql;
        try {
            sql = "INSERT INTO public.psicologo(personal_codigo)"
                    + "VALUES (" + ts.getPersonal_codigo() + ");";
            ps = con.conectarBD().prepareStatement(sql);
            ps.execute();

        } catch (SQLException ex) {
            System.out.println("Error al ingresar trabajo social " + ex.getMessage());
            ingreso = false;
        }
        con.cerrarConexion();
        return ingreso;
    }

    public int verifiUserT(Conexion con, int c_per) { // verifica que perfil es el usuario
        boolean verif = true;
        int user = 0;
        try {
            String sql = "select * from trabajo_social where personal_codigo = " + c_per + ";";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
                verif = true;
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener Trabajo Social " + ex.getMessage());
            verif = false;
        }
        con.cerrarConexion();
        return user;
    }
}
