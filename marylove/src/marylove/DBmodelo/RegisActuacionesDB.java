package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import marylove.conexion.ConexionHi;
import marylove.models.Register_Actuaciones;

/**
 *
 * @author vasquez
 */
public class RegisActuacionesDB extends Register_Actuaciones {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar ; //= new ConexionHi();
    String sql="";
    public RegisActuacionesDB() {
    }

    public boolean ingreRegis_Actu(Register_Actuaciones ra) {
       
        boolean ingre = true;
        try {
            sql = "INSERT INTO public.register_actuaciones (legal_id, "
                    + "notificaciones_diligencias, observaciones, fecha_limite)"
                    + " VALUES (?,?,?,'" + ra.getFecha_limite() + "');";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.setInt(1, ra.getLegal_id());
            ps.setString(2, ra.getNotf_dilig());
            ps.setString(3, ra.getObserv());
            ps.execute();
            ingre = true;

        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar ficha registro de actuaciones: " + ex.getMessage());
            ingre = false;
        }
        conectar.cerrarConexion();
        return ingre;
    }

    public List<Register_Actuaciones> obtenerRegisAct(int c_vic) {
        List<Register_Actuaciones> listRA = new ArrayList();

        //select * from register_actuaciones as ra join ficha_legal as fl
        //on ra.legal_id = fl.legal_id
        //where fl.victima_codigo = 2;
        try {
             sql = "select * from register_actuaciones ra join ficha_legal  fl"
                    + " on ra.legal_id = fl.legal_id "
                    + " where fl.victima_codigo = " + c_vic + ";";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                Register_Actuaciones ra = new Register_Actuaciones();
                ra.setReg_id(re.getInt(1));
                ra.setLegal_id(re.getInt(2));
                ra.setNotf_dilig(re.getString(3));
                ra.setFecha_limite(obtenerFecha(re.getDate(4)));
                ra.setObserv(re.getString(5));
                listRA.add(ra);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id de ficha legal " + ex.getMessage());
        }
        conectar.cerrarConexion();
        return listRA;
    }

    public boolean actualizar(Register_Actuaciones ra) {
        try {
             sql = "UPDATE register_actuaciones SET ";
            sql += "notificaciones_diligencias ='" + ra.getNotf_dilig() + "', ";
            sql += "fecha_limite ='" + ra.getFecha_limite() + "', ";
            sql += "observaciones ='" + ra.getObserv() + "'";
            sql += "WHERE reg_id = " + ra.getReg_id() + "";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            conectar.cerrarConexion();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al editar Registro Actuaciones "+ex.getMessage());
            conectar.cerrarConexion();
            return false;
        }
    }

    public int maxID() {
        int id = 0;
        try {
             sql = "select max(reg_id) from register_actuaciones ;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                id = (re.getInt(1) + 1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
        conectar.cerrarConexion();
        return id;
    }

    public String obtenerFecha(Date fech) {
        String fecha2 = "";
        SimpleDateFormat NFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha2 = NFormat.format(fech);
        return fecha2;
    }
    
    public boolean elimnarRA(int id){
        try {
            String sql = "Delete from register_actuaciones ";
            sql += "WHERE reg_id = " + id ;
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            conectar.cerrarConexion();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Registro Actuaciones "+ex.getMessage());
            conectar.cerrarConexion();
            return false;
        }
    }
}
