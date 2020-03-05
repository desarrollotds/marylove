
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
public class CierreDB extends Cierre{
    PreparedStatement ps;
    ResultSet re = null;
    Conexion con = new Conexion();
    
    public boolean ingreCierre(Cierre ce) {
        boolean ingre = true;
        try {
            String sql = "INSERT INTO public.cierre (legal_id, "
                    + "notifi_dilig, observacion, fecha_limite,fecha_cierre)"
                    + " VALUES (?,?,?,'"+ce.getFecha_limite()+"','"+ce.getFecha_cierre()+"');";
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
    
    public List<Cierre> obtenerCierre(int c_vic){
        List<Cierre> listRA= new ArrayList();
        Cierre ce = new Cierre();
        try {
            String sql = "select * from cierre as cr join ficha_legal as fl"
                    +"on cr.legal_id = fl.legal_id "
                    +" where fl.victima_codigo = " + c_vic + ";";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                ce.setCierre_id(re.getInt(1));
                ce.setLegal_id(re.getInt(2));
                ce.setNotifi_dilig(re.getString(3));
                ce.setFecha_limite(obtenerFecha(re.getDate(4)));
                ce.setObservacion(re.getString(5));
                ce.setFecha_cierre(sql);
                listRA.add(ce);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id de ficha legal " + ex.getMessage());
        }
        return listRA;
    }
    public boolean actualizar(Cierre cr) {
        
        String sql = "UPDATE cierre SET ";
        sql += "notificaciones_diligencias ='" + cr.getNotifi_dilig()+ "', ";
        sql += "fecha_limite ='" + cr.getFecha_limite() + "', ";
        sql += "observaciones ='" + cr.getObservacion() + "'";
        sql += "observaciones ='" + cr.getFecha_cierre() + "',";
        sql += "WHERE cierre_id = " + cr.getCierre_id() + ";";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public String obtenerFecha(Date fech) {
        String fecha2 = "";
            SimpleDateFormat NFormat = new SimpleDateFormat("yyyy/MM/dd");
            fecha2 = NFormat.format(fech);
        System.out.println(fecha2);
        return fecha2;
    }
}
