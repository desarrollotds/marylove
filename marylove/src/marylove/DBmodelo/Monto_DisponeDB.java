package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Monto_Dispone;

/**
 *
 * @author USUARIO
 */
public class Monto_DisponeDB extends Monto_Dispone {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar;// = new ConexionHi();

    public Monto_DisponeDB() {
    }

    public Monto_DisponeDB(int monto_dispone_codigo, int plan_recursos_int, String vivienda_monto, String alimentacion_monto, String educacion_monto, String transporte_monto) {
        super(monto_dispone_codigo, plan_recursos_int, vivienda_monto, alimentacion_monto, educacion_monto, transporte_monto);
    }

    public boolean Ingresar_MontoDispone() {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.monto_dispone"
                    + "(planrecursos_codigo, vivienda, alimentcion, educacion, transporte)";
            sql += "VALUES ";
            sql += "(" + getPlan_recursos_int() + ",'" + getVivienda_monto()
                    + "','" + getAlimentacion_monto() + "','" + getEducacion_monto() + "','" + getTransporte_monto() + "')";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("Error al ingresar MontoDispone del plan recursos: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }

    
    public boolean actualizarMontoDisponible() {
        String sql = "UPDATE monto_dispone SET ";
        sql += "vivienda='" + getVivienda_monto()+ "', ";
        System.out.println("objet: " + getVivienda_monto());
        sql += "alimentcion='" + getAlimentacion_monto()+ "', ";
        sql += "educacion='" + getEducacion_monto()+ "',";
        sql += "transporte='" + getTransporte_monto()+ "'";
        sql += " WHERE montodis_codigo='" + getMonto_dispone_codigo()+ "';";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public Monto_Dispone montoDispone(int cod){
        String sql = "select * from monto_dispone md "
                + "join plan_recursos plr "
                + "on md.planrecursos_codigo = plr.planrecursos_codigo "
                + "where plr.victima_codigo = '" + cod + "';";
//        sql += "order by 1";
        ResultSet rs = conectar.query(sql);
        Monto_Dispone mtd = new Monto_Dispone();
        try {
            while (re.next()) {
                mtd.setMonto_dispone_codigo(rs.getInt("montodis_codigo"));
                //planrecursos_codigo
                mtd.setVivienda_monto(rs.getString("vivienda"));
                mtd.setAlimentacion_monto(rs.getString("alimentcion"));
                mtd.setEducacion_monto(rs.getString("educacion"));
                mtd.setTransporte_monto(rs.getString("transporte"));
            } 
            rs.close();
            return mtd;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    // lista del monto disponible
//    public List<Monto_Dispone> listaMontoDispone(int cod) throws SQLException {
//        List<Monto_Dispone> listaMontoDispone = new ArrayList<Monto_Dispone>();
//        String sql = "select * from monto_dispone md\n"
//                + "join plan_recursos plr\n"
//                + "on md.planrecursos_codigo = plr.planrecursos_codigo\n"
//                + "where plr.victima_codigo = '" + cod + "';";
////        sql += "order by 1";
//        ResultSet rs = conectar.query(sql);
//        try {
//            while (rs.next()) {
//                Monto_Dispone mtd = new Monto_Dispone();
//                mtd.setMonto_dispone_codigo(rs.getInt("montodis_codigo"));
//                //planrecursos_codigo
//                mtd.setVivienda_monto(rs.getString("vivienda"));
//                mtd.setAlimentacion_monto(rs.getString("alimentcion"));
//                mtd.setEducacion_monto(rs.getString("educacion"));
//                mtd.setTransporte_monto(rs.getString("transporte"));
//                listaMontoDispone.add(mtd);
//            }
//            rs.close();
//            return listaMontoDispone;
//        } catch (SQLException ex) {
//            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
}
