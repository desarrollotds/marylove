package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import marylove.conexion.Conexion;
import marylove.controlador.Validaciones;
import marylove.models.Register_Actuaciones;

/**
 *
 * @author vasquez
 */
public class RegisActuacionesDB extends Validaciones {

    PreparedStatement ps;
    ResultSet re = null;
    Conexion con = new Conexion();
    
    

    public RegisActuacionesDB() {
    }

    public boolean ingreRegis_Actu(Register_Actuaciones ra) {
        boolean ingre = true;
        try {
            String sql = "INSERT INTO public.register_actuaciones (legal_id, "
                    + "notificaciones_diligencias, fecha_limite, observaciones)"
                    + " VALUES (?,?,?,?);";
            ps = con.conectarBD().prepareStatement(sql);
            ps.setInt(1, ra.getLegal_id());
            ps.setString(2, ra.getNotf_dilig());
            ps.setString(3, ra.getFecha_limite());
            ps.setString(4, ra.getObserv());
            ps.execute();
            ingre = true;

        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar ficha registro de actuaciones: " + ex.getMessage());
            ingre = false;
        }
        con.cerrarConexion();
        return ingre;
    }
    
    public List<Register_Actuaciones> obtenerRegisAct(int c_vic){
        List<Register_Actuaciones> listRA= new ArrayList();
        Register_Actuaciones ra = new Register_Actuaciones();
        try {
            String sql = "select legal_id from register_actuaciones where victima_codigo = " + c_vic + ";";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                ra.setReg_id(re.getInt(1));
                ra.setLegal_id(re.getInt(2));
                ra.setNotf_dilig(re.getString(3));
                ra.setFecha_limite(obtenerFecha2(re.getDate(4)));
                ra.setObserv(re.getString(5));
                listRA.add(ra);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id de ficha legal " + ex.getMessage());
        }
        return listRA;
    }
    public boolean actualizar(Register_Actuaciones ra) {
        
        String sql = "UPDATE register_actuaciones SET ";
        sql += "notificaciones_diligencias ='" + ra.getNotf_dilig()+ "', ";
        sql += "fecha_limite ='" + ra.getFecha_limite() + "', ";
        sql += "observaciones ='" + ra.getObserv() + "'";
        sql += "WHERE idpersona = " + ra.getReg_id() + "";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
}
