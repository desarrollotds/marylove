package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Plan_Recursos;

/**
 *
 * @author USUARIO
 */
public class Plan_deRecursosDB extends Plan_Recursos {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar; // = new ConexionHi();
    String sql = "";

    public Plan_deRecursosDB() {
    }

    public Plan_deRecursosDB(int plan_recursos_codigo, int codigo_victima, String ficha_elaboracion, String alter_resol_nesi, String monto_actual, int personal_codigo) {
        super(plan_recursos_codigo, codigo_victima, ficha_elaboracion, alter_resol_nesi, monto_actual, personal_codigo);
    }

    public boolean Ingresar_PlanRecursos() {
        boolean ingreso = true;
        try {
            sql = "INSERT INTO public.plan_recursos"
                    + "( victima_codigo, fecha_elaboracion, alter_resol_nesi, montoactual,personal_codigo)";
            sql += "VALUES ";
            sql += "("+ getCodigo_victima() + ",'" + getFecha_elaboracion()
                    + "','" + getAlter_resol_nesi() + "'," + getMonto_actual() + "," + getPersonal_codigo() + " )";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("Error al ingresar PlanRecursos: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }
    public int verifiUserP(int c_per) { // verifica que perfil es el usuario
        int user = 0;
        try {
            sql = "select * from personal where personal_codigo = " + c_per + ";";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error personal " + ex.getMessage());
            user = 0;
        }
//        con.cerrarConexion();
        return user;
    }
    public int maxId() {
        int id = 0;
        try {
             sql = "select max(planrecursos_codigo) from plan_recursos;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                id = (re.getInt(1));
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
//        con.cerrarConexion();
        return id;
    }

}
