package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.Plan_Recursos;

/**
 *
 * @author USUARIO
 */
public class Plan_deRecursosDB extends Plan_Recursos {

    PreparedStatement ps;
    ResultSet re = null;
    Conexion conectar = new Conexion();

    public Plan_deRecursosDB() {
    }

    public Plan_deRecursosDB(int plan_recursos_codigo, int codigo_victima, String ficha_elaboracion, String alter_resol_nesi, String monto_actual, int personal_codigo) {
        super(plan_recursos_codigo, codigo_victima, ficha_elaboracion, alter_resol_nesi, monto_actual, personal_codigo);
    }

    public boolean Ingresar_PrimerEncuentro() {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.plan_recursos"
                    + "(planrecursos_codigo, victima_codigo, fecha_elaboracion, alter_resol_nesi, montoactual, personal_codigo)";
            sql += "VALUES ";
            sql += "(" + getPlan_recursos_codigo() + "," + getCodigo_victima() + ",'" + getFecha_elaboracion()
                    + "','" + getAlter_resol_nesi() + "'," + getMonto_actual() + "," + getPersonal_codigo() + ")";
            ps = conectar.conectarBD().prepareStatement(sql);
            ps.execute();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("Error al ingresar Primer Encuentro: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }

}
