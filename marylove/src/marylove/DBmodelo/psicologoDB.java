package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Abogada;
import marylove.models.Psicologo;

/**
 *
 * @author Alumno
 */
public class psicologoDB extends Psicologo {

    PreparedStatement ps;
    ResultSet re = null;

    public psicologoDB() {
    }

    public boolean ingrePsicologo(Conexion con, Psicologo psc) {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.psicologo( personal_codigo)"
                    + "VALUES (" + psc.getCodigo_psic() + ");";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Abogada.class.getName()).log(Level.SEVERE, null, ex);
            ingreso = false;
        }
        con.cerrarConexion();
        return ingreso;
    }

    public boolean verifiUser(Conexion con, int c_per) { // verifica que perfil es el usuario
        boolean verif = true;
        int user = 0;
        try {
            String sql = "select * from psicologo where personal_codigo = " + c_per + ";";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
                verif = true;
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            verif = false;
        }
        con.cerrarConexion();
        return verif;
    }
}
