    package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Ficha_Legal;
import marylove.models.Persona;

/**
 *
 * @author vasquez
 */
public class fichaLegalDB extends Ficha_Legal {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi con = new ConexionHi();
    boolean ingreso = true;

    public boolean ingreFLegal(Ficha_Legal fl) {

        try {

            String sql = "INSERT INTO public.ficha_legal( victima_codigo, "
                    + "abogada_id, motivo_consulta, relacion_hechos, aspectos_reelevantes,fecha_elaboracion)"
                    + "VALUES ('" + fl.getVictima_codigo() + "','" + fl.getAbogada_codigo()
                    + "','" + fl.getMotivo_consulta() + "','" + fl.getRelacion_hechos() + "','"
                    + fl.getAspectos_reelevantes() + "','" + fl.getFecha() + "');";
//            ps = conn.getConection().prepareStatement(sql);
            ps = con.getConnection().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar Ficha Legal "+ex.getMessage());
            ingreso = false;
        }
        con.cerrarConexion();
        return ingreso;
    }

    public int obtenerLegal_Id(int c_vic) {
        int id = 0;
        try {
            String sql = "select legal_id from ficha_legal where victima_codigo = " + c_vic + ";";
            ps = con.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                id = re.getInt(1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id de ficha legal " + ex.getMessage());
            id = 0;
        }
        con.cerrarConexion();
        return id;
    }
    
    public Ficha_Legal obtenerFichaLegal(int c_vic) {
        int id = 0;
        Ficha_Legal fl = new Ficha_Legal();
        try {
            String sql = "select * from ficha_legal where victima_codigo = " + c_vic + ";";
            ps = con.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                fl.setLegal_id(re.getInt(1));
                fl.setVictima_codigo(re.getInt(2));
                fl.setAbogada_codigo(re.getInt(3));
                fl.setMotivo_consulta(re.getString(4));
                fl.setRelacion_hechos(re.getString(5));
                fl.setAspectos_reelevantes(re.getString(6));
                fl.setFecha(obtenerFecha(re.getDate(7)));
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id de ficha legal " + ex.getMessage());
        }
        con.cerrarConexion();
        return fl;
    }
    
    public boolean editFLegal(Ficha_Legal flg) {
        try {
            String sql = "UPDATE ficha_legal SET ";
            sql += "abogada_id ='" + flg.getAbogada_codigo() + "', ";
            sql += "motivo_consulta ='" + flg.getMotivo_consulta() + "', ";
            sql += "relacion_hechos ='" + flg.getRelacion_hechos() + "',";
            sql += "aspectos_reelevantes = '" + flg.getAspectos_reelevantes() + "' ";
            sql += "WHERE cierre_id = " + flg.getVictima_codigo() + ";";
            ps = con.getConnection().prepareStatement(sql);
            ps.execute();
            con.cerrarConexion();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al editar ficha legal " + ex.getMessage());
            con.cerrarConexion();
            return false;
        }
    }
    
    public String obtenerFecha(Date fech) {
        String fecha2 = "";
        SimpleDateFormat NFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha2 = NFormat.format(fech);
        return fecha2;
    }
}
