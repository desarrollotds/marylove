package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Monto_Dispone;

/**
 *
 * @author USUARIO
 */
public class Monto_DisponeDB extends Monto_Dispone{
    PreparedStatement ps;
    ResultSet re = null;
    Conexion conectar = new Conexion();  

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
            sql += "(" + getPlan_recursos_int()+ ",'" + getVivienda_monto()
                    + "','" + getAlimentacion_monto()+ "','" + getEducacion_monto()+ "','" + getTransporte_monto()+ "')";
            ps = conectar.conectarBD().prepareStatement(sql);
            ps.execute();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("Error al ingresar MontoDispone del plan recursos: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }
    // lista pero me parece que esta mal hecha por eso no funciona
    public List<Monto_Dispone> listaMontoDispone(int cod) throws SQLException {
        
        List<Monto_Dispone> listaMontoDispone = new ArrayList<Monto_Dispone>();
        String sql = "select * from monto_dispone WHERE montodis_codigo = '"+ cod+"' ";
        System.out.println("entr1");
        ResultSet rs = conectar.query(sql);
        System.out.println("entr2");
        Monto_Dispone md = new Monto_Dispone();
        try {
            System.out.println("entr3");
            while (rs.next()) {
                
                md.setVivienda_monto(rs.getString("vivienda"));
                md.setAlimentacion_monto(rs.getString("alimentcion"));
                md.setEducacion_monto(rs.getString("educacion"));
                md.setTransporte_monto(rs.getString("transporte"));
                listaMontoDispone.add(md);

            }
            rs.close();
            return listaMontoDispone;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
