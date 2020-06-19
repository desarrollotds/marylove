package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Cuentas_Diarias;

/**
 *
 * @author USUARIO
 */
public class Cuentas_DiariasDB extends Cuentas_Diarias {

    PreparedStatement ps;
    ResultSet rs = null;
    ConexionHi conectar = new ConexionHi();
    String sql;
    boolean ingreso = true;

    public Cuentas_DiariasDB() {
    }

    public Cuentas_DiariasDB(int cuentas_diarias_codigo, int plan_recusos_codigo, String fecha_cuenta, String gasto, String descripcion, String saldo) {
        super(cuentas_diarias_codigo, plan_recusos_codigo, fecha_cuenta, gasto, descripcion, saldo);
    }

    public boolean Ingresar_CuentasDiarias() {
        try {
            sql = "INSERT INTO public.cuentas_diarias"
                    + "( planrecursos_codigo, fecha_cuenta, gasto, descripcion_gasto, saldo,cuentas_estado)";
            sql += "VALUES ";
            sql += "(" + getPlan_recusos_codigo() + ",'" + getFecha_cuenta()
                    + "','" + getGasto() + "','" + getDescripcion() + "','" + getSaldo() + "','a')";
//            ps = conectar.getConnection().prepareStatement(sql);
//            ps.execute();
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar Cuentas Diarias del plan recursos: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }

    /// lista cuentas diarias para cargar en la tabla
    public List<Cuentas_Diarias> listacuentasDiarias(int cod) throws SQLException {
        List<Cuentas_Diarias> listacuentasDiarias = new ArrayList<Cuentas_Diarias>();
        sql = "select * from cuentas_diarias cutd\n"
                + "join plan_recursos plr\n"
                + "on cutd.planrecursos_codigo = plr.planrecursos_codigo\n"
                + "where plr.victima_codigo = '" + cod + "' AND cutd.cuentas_estado = 'a';";
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Cuentas_Diarias cutd = new Cuentas_Diarias();
                cutd.setCuentas_diarias_codigo(rs.getInt("cuentas_codigo"));
                //planrecursos_codigo
                cutd.setFecha_cuenta(rs.getString("fecha_cuenta"));
                cutd.setGasto(rs.getString("gasto"));
                cutd.setDescripcion(rs.getString("descripcion_gasto"));
                cutd.setSaldo(rs.getString("saldo"));
                listacuentasDiarias.add(cutd);
            }
            rs.close();
            return listacuentasDiarias;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean actualizarCuentasDiarias() {
        sql = "UPDATE cuentas_diarias SET ";
        sql += "gasto='" + getGasto() + "', ";
        sql += "descripcion_gasto='" + getDescripcion() + "',";
        sql += "saldo='" + getSaldo() + "'";
        sql += " WHERE cuentas_codigo='" + getCuentas_diarias_codigo() + "';";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }

    public boolean eliminarCuentasDiarias() {
        sql = "UPDATE cuentas_diarias SET cuentas_estado = 'd' WHERE cuentas_codigo='" + getCuentas_diarias_codigo() + "'";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }

}
