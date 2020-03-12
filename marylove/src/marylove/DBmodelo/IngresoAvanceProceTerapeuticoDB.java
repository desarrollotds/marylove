package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.ArticulosEntregadosPersonal;
import marylove.models.IngresoAvanceProceTeraputico;

/**
 *
 * @author LENOVO
 */
public class IngresoAvanceProceTerapeuticoDB extends IngresoAvanceProceTeraputico{
    PreparedStatement ps;
    ResultSet re = null;
    Conexion conectar = new Conexion();

    public IngresoAvanceProceTerapeuticoDB() {
    }

    public IngresoAvanceProceTerapeuticoDB(int avances_codigo, int plan_at_codigo, String avancesFecha, String avances_situacion, String avances_intervencion) {
        super(avances_codigo, plan_at_codigo, avancesFecha, avances_situacion, avances_intervencion);
    }

     public boolean insetarAvance(){
         boolean ingreso=true;
         try {
             String sql="INSERT INTO avances_terapeuticos (avances_fecha, avances_situacion, avances_intervencion)"
                     + "VALUES"
                     + "('"+getAvancesFecha()+"','"+getAvances_situacion()+"','"+getAvances_intervencion()+"')";
             ps=conectar.conectarBD().prepareStatement(sql);
             ps.execute();
         } catch (SQLException ex) {
             System.out.println("Error: "+ex.getMessage());
             ingreso=false;
         }
         conectar.cerrarConexion();
         return ingreso;
     }
     
//      public List<IngresoAvanceProceTeraputico> obtenerRegisAct(int c_vic) {
//        List<IngresoAvanceProceTeraputico> listRA = new ArrayList();
//        try {
//            String sql = "select at.avances_codigo, " 
//                    + "at.plan_at_codigo, "
//                    + "at.avances_fecha, "
//                    + "at.avances_situacion, "
//                    + "at.avances_intervencion "
//                    + "from avances_terapeuticos at join ficha_plan_atencion_terapeuta ft "
//                    + "on at.plan_at_codigo = ft.plan_at_codigo "
//                    + "join historial_clinico hc "
//                    + "on hc.hist_id = ft.plan_at_codigo "
//                    + "where hc.victima_codigo =  " +c_vic+ ";";
//            ps = conectar.conectarBD().prepareStatement(sql);
//            re = ps.executeQuery();
//            while (re.next()) {
//                IngresoAvanceProceTeraputico it = new IngresoAvanceProceTeraputico();
//                it.setPlan_at_codigo(re.getInt("at.plan_at_codigo"));
//                it.setAvances_situacion(re.getString("at.avances_situacion"));
//               it.setAvances_intervencion(re.getString("at.avances_intervencion"));
//               it.setAvancesFecha("at.avances_fecha");
//                listRA.add(it);
//            }
//            re = ps.executeQuery();
//        } catch (SQLException ex) {
//            System.out.println("Error " + ex.getMessage());
//        }
//        conectar.cerrarConexion();
//        return listRA;
//    }
      
       public List<IngresoAvanceProceTeraputico> listar() throws SQLException {
        List<IngresoAvanceProceTeraputico> listar = new ArrayList<IngresoAvanceProceTeraputico>();
        String sql = "select * from avances_terapeuticos";
//        sql += "order by 1";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                IngresoAvanceProceTeraputico p = new IngresoAvanceProceTeraputico();
                p.setAvances_codigo(rs.getInt("avances_codigo"));
                p.setAvancesFecha(rs.getString("avances_fecha"));
                p.setAvances_situacion(rs.getString("avances_situacion"));
                p.setAvances_intervencion(rs.getString("avances_intervencion"));
                listar.add(p);
            }
            rs.close();
            return listar;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql = "select max (plan_at_codigo) from ficha_plan_atencion_terapeuta;";
            ps = conectar.conectarBD().prepareStatement(sql);
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
       
      
}
