package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import marylove.conexion.Conexion;
import marylove.models.Cierre;
import marylove.models.Register_Actuaciones;

/**
 *
 * @author vasquez
 */
public class CierreDB extends Cierre {

    PreparedStatement ps;
    ResultSet re = null;
    Conexion con = new Conexion();

    public boolean ingreCierre(Cierre ce) {
        boolean ingre = true;
        try {
            String sql = "INSERT INTO public.cierre (legal_id, "
                    + "notifi_dilig, observacion, fecha_limite,fecha_cierre)"
                    + " VALUES (?,?,?,'" + ce.getFecha_limite() + "','" + ce.getFecha_cierre() + "');";
            ps = con.conectarBD().prepareStatement(sql);
            ps.setInt(1, ce.getLegal_id());
            ps.setString(2, ce.getNotifi_dilig());
            ps.setString(3, ce.getObservacion());
            ps.execute();
            ingre = true;

        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar cierre: " + ex.getMessage());
            ingre = false;
        }
        con.cerrarConexion();
        return ingre;
    }

    public List<Cierre> obtenerCierre(int c_vic) {
        List<Cierre> listRA = new ArrayList();

        try {
            String sql = "select * from cierre cr join ficha_legal fl"
                    + " on cr.legal_id = fl.legal_id "
                    + " where fl.victima_codigo = " + c_vic + ";";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                Cierre ce = new Cierre();
                ce.setCierre_id(re.getInt(1));
                ce.setLegal_id(re.getInt(2));
                ce.setNotifi_dilig(re.getString(3));
                ce.setFecha_limite(obtenerFecha(re.getDate(4)));
                ce.setObservacion(re.getString(5));
                ce.setFecha_cierre(obtenerFecha(re.getDate(6)));
                listRA.add(ce);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener datos de cierre " + ex.getMessage());
        }
        return listRA;
    }

    public boolean actualizar(Cierre cr) {
        try {
            String sql = "UPDATE cierre SET ";
            sql += "notifi_dilig ='" + cr.getNotifi_dilig() + "', ";
            sql += "fecha_limite ='" + cr.getFecha_limite() + "', ";
            sql += "observacion ='" + cr.getObservacion() + "',";
            sql += "fecha_cierre = '" + cr.getFecha_cierre() + "' ";
            sql += "WHERE cierre_id = " + cr.getCierre_id() + ";";
            ps = con.conectarBD().prepareStatement(sql);
            ps.execute();
            con.cerrarConexion();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al editar Cierre " + ex.getMessage());
            con.cerrarConexion();
            return false;
        }
    }

    public int maxID() {
        int id = 0;
        try {
            String sql = "select max(cierre_id) from cierre ;";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                id = (re.getInt(1) + 1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
        con.cerrarConexion();
        return id;
    }

    public String obtenerFecha(Date fech) {
        String fecha2 = "";
        SimpleDateFormat NFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha2 = NFormat.format(fech);
        return fecha2;
    }
}
