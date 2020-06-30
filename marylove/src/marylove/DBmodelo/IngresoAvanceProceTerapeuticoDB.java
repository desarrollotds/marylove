package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import marylove.conexion.ConexionHi;
import marylove.models.IngresoAvanceProceTeraputico;

/**
 *
 * @author LENOVO
 */
public class IngresoAvanceProceTerapeuticoDB extends IngresoAvanceProceTeraputico {

    PreparedStatement ps;
    ResultSet re;
    ConexionHi conectar = new ConexionHi();

    public IngresoAvanceProceTerapeuticoDB() {
    }

    public IngresoAvanceProceTerapeuticoDB(int avances_codigo, int plan_at_codigo, String avancesFecha, String avances_situacion, String avances_intervencion) {
        super(avances_codigo, plan_at_codigo, avancesFecha, avances_situacion, avances_intervencion);
    }

    public boolean insetarAvance()  {
        String sql = "INSERT INTO avances_terapeuticos (avances_fecha, avances_situacion, avances_intervencion, plan_at_codigo) "
                + "VALUES "
                + "('" + getAvancesFecha() + "','" + getAvances_situacion() + "','" + getAvances_intervencion() +"', " + getPlan_at_codigo() + ") ;";
        return conectar.noQuery(sql);
    }
    
    public List<IngresoAvanceProceTeraputico> listar(int cod) {
        List<IngresoAvanceProceTeraputico> listar = new ArrayList<IngresoAvanceProceTeraputico>();
//      SELECT avt.avances_codigo, avt.avances_fecha, avt.avances_intervencion, avt.avances_situacion from avances_terapeuticos avt INNER JOIN ficha_plan_atencion_terapeuta pat 
//      ON avt.plan_at_codigo = pat.plan_at_codigo INNER JOIN historial_clinico hc 
//      ON pat.hist_id = hc.hist_id WHERE hc.victima_codigo = 
        try {
            String sql = "SELECT avt.avances_codigo, avt.avances_fecha, avt.avances_intervencion, avt.avances_situacion "
                    + "from avances_terapeuticos avt INNER JOIN ficha_plan_atencion_terapeuta pat "
                    + "ON avt.plan_at_codigo = pat.plan_at_codigo INNER JOIN historial_clinico hc "
                    + "ON pat.hist_id = hc.hist_id WHERE hc.victima_codigo = " +cod
                    +" ORDER BY avances_codigo ";
            re = conectar.query(sql);
            while (re.next()) {
                IngresoAvanceProceTeraputico p = new IngresoAvanceProceTeraputico();
                p.setAvances_codigo(re.getInt("avances_codigo"));
                p.setAvancesFecha(obtenerFecha(re.getDate("avances_fecha")));
                p.setAvances_situacion(re.getString("avances_situacion"));
                p.setAvances_intervencion(re.getString("avances_intervencion"));
                listar.add(p);
            }
            re.close();
            return listar;
        } catch (Exception ex) {
            System.out.println("error; " + ex);
            return null;
        }

    }

    public String obtenerFecha(Date fech) {
        String fecha2 = "";
        SimpleDateFormat NFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha2 = NFormat.format(fech);
        return fecha2;
    }

    public int maxID() {
        int id = 0;
        try {
            String sql = "select max (avances_codigo) from avances_terapeuticos ;";
            re = conectar.query(sql);
            while (re.next()) {
                id = (re.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
        id = id + 1;
        return id;
    }
    
    public boolean editar(IngresoAvanceProceTeraputico eap){
        boolean ingre = false;
        try {
            String sql = "UPDATE avances_terapeuticos SET ";
            sql += "avances_fecha = '" + eap.getAvancesFecha() + "', ";
            sql += "avances_situacion = '" + eap.getAvances_situacion()+ "', ";
            sql += "avances_intervencion = '" + eap.getAvances_intervencion() + "' ";
            sql += "WHERE avances_codigo = " + eap.getAvances_codigo() + " ;";
            ingre = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al editar Avances terapeuticos " + ex.getMessage());
            ingre = false;
        }
        return  ingre;
    }
    
    public IngresoAvanceProceTeraputico obtenerDatos(int cod){
        IngresoAvanceProceTeraputico ap = new IngresoAvanceProceTeraputico();
        try {
            String sql = "SELECT avances_fecha, avances_intervencion, avances_situacion "
                    + "from avances_terapeuticos  WHERE avances_codigo = " +cod;
            re = conectar.query(sql);
            while (re.next()) {
                ap.setAvancesFecha(obtenerFecha(re.getDate("avances_fecha")));
                ap.setAvances_situacion(re.getString("avances_situacion"));
                ap.setAvances_intervencion(re.getString("avances_intervencion"));
            }
            re.close();
            return ap;
        } catch (Exception ex) {
            System.out.println("error; " + ex);
            return null;
        }
    }
    public boolean Elimnar(int cg){
        String sql = "Delete from avances_terapeuticos ";
        sql += "WHERE avances_codigo = " + cg;
        return conectar.noQuery(sql);
    }

}
