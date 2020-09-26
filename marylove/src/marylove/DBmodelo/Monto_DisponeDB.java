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
    ResultSet rs = null;
    ConexionHi conectar = new ConexionHi();
    String sql;
    boolean ingreso = true;

    public Monto_DisponeDB() {
    }

    public Monto_DisponeDB(int monto_dispone_codigo, int plan_recursos_int, String vivienda_monto, String alimentacion_monto, String educacion_monto, String transporte_monto) {
        super(monto_dispone_codigo, plan_recursos_int, vivienda_monto, alimentacion_monto, educacion_monto, transporte_monto);
    }

    public boolean Ingresar_MontoDispone() {
        try {
            sql = "INSERT INTO public.monto_dispone"
                    + "(planrecursos_codigo, vivienda, alimentcion, educacion, transporte, montodisp_estado)";
            sql += "VALUES ";
            sql += "(" + getPlan_recursos_int() + ",'" + getVivienda_monto()
                    + "','" + getAlimentacion_monto() + "','" + getEducacion_monto() + "','" 
                    + getTransporte_monto() + "','a')";
//            ps = conectar.getConnection().prepareStatement(sql);
//            ps.execute();
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar MontoDispone del plan recursos: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }

    public boolean actualizarMontoDisponible() {
        sql = "UPDATE monto_dispone SET ";
        sql += "vivienda='" + getVivienda_monto() + "', ";
        System.out.println("objet: " + getVivienda_monto());
        sql += "alimentcion='" + getAlimentacion_monto() + "', ";
        sql += "educacion='" + getEducacion_monto() + "',";
        sql += "transporte='" + getTransporte_monto() + "'";
        sql += " WHERE montodis_codigo='" + getMonto_dispone_codigo() + "';";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }
    
    public boolean eliminarMontDisp() {
        sql = "UPDATE monto_dispone SET montodisp_estado = 'd' WHERE montodis_codigo='" + getMonto_dispone_codigo()+ "'";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }

      //lista del monto disponible
    public List<Monto_Dispone> listaMontoDispone(int cod) throws SQLException {
        List<Monto_Dispone> listaMontoDispone = new ArrayList<Monto_Dispone>();
        sql = "select * from monto_dispone md\n"
                + "join plan_recursos plr\n"
                + "on md.planrecursos_codigo = plr.planrecursos_codigo\n"
                + "where plr.victima_codigo = '" + cod + "'AND montodisp_estado ='a';";
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Monto_Dispone mtd = new Monto_Dispone();
                mtd.setMonto_dispone_codigo(rs.getInt("montodis_codigo"));
                //planrecursos_codigo
                mtd.setVivienda_monto(rs.getString("vivienda"));
                mtd.setAlimentacion_monto(rs.getString("alimentcion"));
                mtd.setEducacion_monto(rs.getString("educacion"));
                mtd.setTransporte_monto(rs.getString("transporte"));
                listaMontoDispone.add(mtd);
            }
            rs.close();
            return listaMontoDispone;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
