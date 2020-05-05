package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    + "(montodis_codigo, planrecursos_codigo, vivienda, alimentcion, educacion, transporte)";
            sql += "VALUES ";
            sql += "(" + getMonto_dispone_codigo()+ "," + getPlan_recursos_int()+ ",'" + getVivienda_monto()
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
}
