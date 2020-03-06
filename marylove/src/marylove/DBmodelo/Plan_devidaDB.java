package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.Plan_de_Vida;

/**
 *
 * @author USUARIO
 */
public class Plan_devidaDB extends Plan_de_Vida {

    PreparedStatement ps;
    ResultSet re = null;
    Conexion conectar = new Conexion();

    public Plan_devidaDB() {
    }

    public Plan_devidaDB(int plan_de_vida_codigo, int victima_codigo, String fecha_elaboracion, String fecha_prox_evaluacion, String comosesiente, String comoseve, String comolegustariasuvida) {
        super(plan_de_vida_codigo, victima_codigo, fecha_elaboracion, fecha_prox_evaluacion, comosesiente, comoseve, comolegustariasuvida);
    }

    public boolean Ingresar_Plandevida() {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.plan_vida"
                    + "(planvida_codigo, victima_codigo, fecha_elaboracion, fecha_evaluacion, comosesiente, comoseve, comolegustariasuvida)";
            sql += "VALUES ";
            sql += "(" + getPlan_de_vida_codigo() + "," + getVictima_codigo() + ",'" + getFecha_elaboracion()
                    + "','" + getFecha_prox_evaluacion() + "','" + getComosesiente() + "','" + getComoseve()
                    + "','" + getComolegustariasuvida() + "')";
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
