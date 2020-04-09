package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            System.out.println("Error al ingresar Plan de Vida: " + ex.getMessage());
            ingreso = false;
        }
        
        conectar.cerrarConexion();
        return ingreso;
    }
//    public List<Plan_de_Vida> listar() throws SQLException {
//        List<Plan_de_Vida> listar = new ArrayList<Plan_de_Vida>();
//        String sql = "select planvida_codigo,comoseseinte,comoseve,comolegustariasuvida from percepcion_familiar pf\n" +
//                      "join evaluacion_plan_vida epv\n" +
//                      "on epv.evaluacion_id = pf.evaluacion_id\n" +
//                      "where epv.victima_codigo = '1';";
////        sql += "order by 1";
//        ResultSet rs = conectar.query(sql);
//        try {
//            while (rs.next()) {
//                Plan_de_Vida p = new Plan_de_Vida();
//                p.setPercepcion_id(rs.getInt("percepcion_id"));
//                p.setComoSeSiente(rs.getString("comoseseinte"));
//                p.setAlcanzoObjetivosComo(rs.getString("alcanzoonjetivos_como"));
//                p.setDificultadesEncontradas(rs.getString("dificultadesencontradas"));
//                listarPerFam.add(p);
//            }
//            rs.close();
//            return listarPerFam;
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }

//    }
    public boolean actualizar() {
        String sql = "UPDATE public.plan_vida SET ";
        sql += "comoseseinte='" + getComosesiente()+ "', ";
        sql += "comoseve='" + getComoseve()+ "', ";
        sql += "comolegustariasuvida='" + getComolegustariasuvida()+ "', ";
        sql += " WHERE planvida_codigo='" + getPlan_de_vida_codigo()+ "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
}
