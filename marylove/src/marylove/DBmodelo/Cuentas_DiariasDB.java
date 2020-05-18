package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Cuentas_Diarias;

/**
 *
 * @author USUARIO
 */
public class Cuentas_DiariasDB extends Cuentas_Diarias{
    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar = new ConexionHi();

    public Cuentas_DiariasDB() {
    }

    public Cuentas_DiariasDB(int cuentas_diarias_codigo, int plan_recusos_codigo, String fecha_cuenta, String gasto, String descripcion, String saldo) {
        super(cuentas_diarias_codigo, plan_recusos_codigo, fecha_cuenta, gasto, descripcion, saldo);
    }
    
    public boolean Ingresar_MontoNecesita() {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.cuentas_diarias"
                    + "(cuentas_codigo, planrecursos_codigo, fecha_cuenta, gasto, descripcion_gasto, saldo)";
            sql += "VALUES ";
            sql += "(" + getCuentas_diarias_codigo()+ "," + getPlan_recusos_codigo()+ ",'" + getFecha_cuenta()
                    + "','" + getGasto()+ "','" + getDescripcion()+ "','" + getSaldo()+ "')";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("Error al ingresar Cuentas Diarias del plan recursos: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }
    
}
