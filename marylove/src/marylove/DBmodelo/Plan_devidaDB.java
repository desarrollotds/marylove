package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Plan_de_Vida;

/**
 *
 * @author USUARIO
 */
public class Plan_devidaDB extends Plan_de_Vida {

    PreparedStatement ps;
    ResultSet rs = null;
    ConexionHi conectar = new ConexionHi();
    String sql;
    boolean ingreso = true;

    public Plan_devidaDB() {
    }

    public Plan_devidaDB(int plan_de_vida_codigo, int victima_codigo, String fecha_elaboracion, String fecha_prox_evaluacion, String comosesiente, String comoseve, String comolegustariasuvida, String vision_equipo_ufa) {
        super(plan_de_vida_codigo, victima_codigo, fecha_elaboracion, fecha_prox_evaluacion, comosesiente, comoseve, comolegustariasuvida, vision_equipo_ufa);
    }
    
    public boolean Ingresar_Plandevida() {
        try {
            sql = "INSERT INTO public.plan_vida"
                    + "(victima_codigo, fecha_elaboracion, fecha_evaluacion, comosesiente, comoseve, comolegustariasuvida, vision_equipo_ufa,planvida_estado)";
            sql += "VALUES ";
            sql += "(" + getVictima_codigo() + ",'" + getFecha_elaboracion()
                    + "','" + getFecha_prox_evaluacion() + "','" + getComosesiente() + "','" + getComoseve()
                    + "','" + getComolegustariasuvida() + "','" + getVision_equipo_ufa()+ "','a')";
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
            rs = conectar.query(sql);
            while (rs.next()) {
                user = rs.getInt(1);
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
            rs = conectar.query(sql);
            while (rs.next()) {
                id = (rs.getInt(1));
            }
            //re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
        conectar.cerrarConexion();
        return id;
    }

    public boolean actualizar() {
        sql = "UPDATE public.plan_vida SET ";
        sql += "comosesiente='" + getComosesiente() + "', ";
        sql += "comoseve='" + getComoseve() + "', ";
        sql += "comolegustariasuvida='" + getComolegustariasuvida() + "', ";
        sql += "vision_equipo_ufa='" + getVision_equipo_ufa()+ "' ";
        sql += " WHERE planvida_codigo='" + getPlan_de_vida_codigo() + "';";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }
    public List<Plan_de_Vida> listarPlanVid() throws SQLException {
        List<Plan_de_Vida> listarPlanVid = new ArrayList<>();
        sql = "select epv.planvida_codigo,per.persona_cedula,per.persona_nombre, per.persona_apellido, epv.comosesiente,epv.comoseve,epv.comolegustariasuvida,epv.vision_equipo_ufa, epv.fecha_elaboracion, epv.fecha_evaluacion \n"
                + "from plan_vida epv\n"
                + "join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona per\n"
                + "on vc.persona_codigo = per.persona_codigo\n"
                + "where planvida_estado = 'a';";
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Plan_de_Vida p = new Plan_de_Vida();
                p.setPlan_de_vida_codigo(rs.getInt("planvida_codigo"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setComosesiente(rs.getString("comosesiente"));
                p.setComoseve(rs.getString("comoseve"));
                p.setComolegustariasuvida(rs.getString("comolegustariasuvida"));
                p.setVision_equipo_ufa(rs.getString("vision_equipo_ufa"));
                p.setFecha_elaboracion(rs.getString("fecha_elaboracion"));
                p.setFecha_prox_evaluacion(rs.getString("fecha_evaluacion"));
                listarPlanVid.add(p);
            }
            rs.close();
            return listarPlanVid;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public List<Plan_de_Vida> buscarTextoPlanVid(String texto) throws SQLException {
        List<Plan_de_Vida> buscarTexto = new ArrayList();
        System.out.println("testoDB: " + texto);
        sql = "select epv.planvida_codigo,per.persona_cedula,per.persona_nombre, per.persona_apellido, epv.comosesiente,epv.comoseve,epv.comolegustariasuvida,epv.vision_equipo_ufa, epv.fecha_elaboracion, epv.fecha_evaluacion \n"
                + "from plan_vida epv\n"
                + "join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona per\n"
                + "on vc.persona_codigo = per.persona_codigo "
                + "where planvida_estado = 'a' and persona_cedula like '" + texto + "%'\n"
                + "OR persona_nombre LIKE '" + texto + "%'\n"
                + "OR persona_apellido like '" + texto + "%';";
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Plan_de_Vida p = new Plan_de_Vida();
                p.setPlan_de_vida_codigo(rs.getInt("planvida_codigo"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setComosesiente(rs.getString("comosesiente"));
                p.setComoseve(rs.getString("comoseve"));
                p.setComolegustariasuvida(rs.getString("comolegustariasuvida"));
                p.setVision_equipo_ufa(rs.getString("vision_equipo_ufa"));
                p.setFecha_elaboracion(rs.getString("fecha_elaboracion"));
                p.setFecha_prox_evaluacion(rs.getString("fecha_evaluacion"));
                buscarTexto.add(p);

            }
            rs.close();
            return buscarTexto;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean eliminarPlanVid() {
        sql = "UPDATE plan_vida SET planvida_estado = 'd' WHERE planvida_codigo='" + getPlan_de_vida_codigo()+ "'";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }
}
