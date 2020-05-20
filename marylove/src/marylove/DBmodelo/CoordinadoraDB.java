
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Coordinadora;
import marylove.models.Educadora;

/**
 *
 * @author vasquez
 */
public class CoordinadoraDB extends Coordinadora{
    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar;// = new ConexionHi();

    public CoordinadoraDB() {
    }
    
    public boolean ingreCoodinadora(Coordinadora co) {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.coordinadora( personal_codigo)"
                    + "VALUES (" + co.getPersonal_codigo()+");";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error al ingresar coordinadora "+ex.getMessage());
            ingreso = false;
        }
       conectar.cerrarConexion();
        return ingreso;
    }
    
    public int verifiUserC(int c_per) { // verifica que perfil es el usuario
        boolean verif = true;
        int user = 0;
        try {
            String sql = "select * from coordinadora where personal_codigo = " + c_per + ";";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
                verif = true;
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener coordinadora "+ex.getMessage());
            verif = false;
        }
        conectar.cerrarConexion();
        return user;
    }
}
