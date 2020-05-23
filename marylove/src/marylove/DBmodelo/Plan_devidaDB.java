package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.conexion.ConexionHi;
import marylove.models.Plan_de_Vida;

/**
 *
 * @author USUARIO
 */
public class Plan_devidaDB extends Plan_de_Vida {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar = new ConexionHi();
    String sql;
    boolean ingreso = true;

    public Plan_devidaDB() {
    }

    public Plan_devidaDB(int plan_de_vida_codigo, int victima_codigo, String fecha_elaboracion, String fecha_prox_evaluacion, String comosesiente, String comoseve, String comolegustariasuvida) {
        super(plan_de_vida_codigo, victima_codigo, fecha_elaboracion, fecha_prox_evaluacion, comosesiente, comoseve, comolegustariasuvida);
    }

    public boolean Ingresar_Plandevida() {
        try {
            sql = "INSERT INTO public.plan_vida"
                    + "(victima_codigo, fecha_elaboracion, fecha_evaluacion, comosesiente, comoseve, comolegustariasuvida)";
            sql += "VALUES ";
            sql += "(" + getVictima_codigo() + ",'" + getFecha_elaboracion()
                    + "','" + getFecha_prox_evaluacion() + "','" + getComosesiente() + "','" + getComoseve()
                    + "','" + getComolegustariasuvida() + "')";
//            ps = conectar.getConnection().prepareStatement(sql);
//            ps.execute();
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar Plan de Vida: " + ex.getMessage());
            ingreso = false;
        }

        conectar.cerrarConexion();
        return ingreso;
    }

    public int verifiUserP(int c_per) { // verifica que perfil es el usuario
        int user = 0;
        try {
            sql = "select * from personal where personal_codigo = " + c_per + ";";
//            ps = conectar.getConnection().prepareStatement(sql);
//            re = ps.executeQuery();
            re = conectar.query(sql);
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error personal " + ex.getMessage());
            user = 0;
        }
        conectar.cerrarConexion();
        return user;
    }

    public int maxId() {
        int id = 0;
        try {
            sql = "select max(planvida_codigo) from plan_vida;";
//            ps = conectar.getConnection().prepareStatement(sql);
//            re = ps.executeQuery();
            re = conectar.query(sql);
            while (re.next()) {
                id = (re.getInt(1));
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
        conectar.cerrarConexion();
        return id;
    }

    public boolean actualizar() {
        sql = "UPDATE public.plan_vida SET ";
        sql += "comoseseinte='" + getComosesiente() + "', ";
        sql += "comoseve='" + getComoseve() + "', ";
        sql += "comolegustariasuvida='" + getComolegustariasuvida() + "', ";
        sql += " WHERE planvida_codigo='" + getPlan_de_vida_codigo() + "'";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }
}
