package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.Monto_Necesita;

/**
 *
 * @author USUARIO
 */
public class Monto_NecesitaDB extends Monto_Necesita{
    PreparedStatement ps;
    ResultSet re = null;
    Conexion conectar = new Conexion();

    public Monto_NecesitaDB() {
    }

    public Monto_NecesitaDB(int monto_nesecita_codigo, int plan_recursos_int, String vivienda_monto, String alimentacion_monto, String educacion_monto, String transporte_monto) {
        super(monto_nesecita_codigo, plan_recursos_int, vivienda_monto, alimentacion_monto, educacion_monto, transporte_monto);
    }
    
    public boolean Ingresar_MontoNecesita() {
        boolean ingreso = true;
        try {
            String sql = "INSERT INTO public.monto_necesita"
                    + "(planrecursos_codigo, vivienda, alimentcion, educacion, transporte)";
            sql += "VALUES ";
            sql += "("+ getPlan_recursos_int()+ ",'" + getVivienda_monto()
                    + "','" + getAlimentacion_monto()+ "','" + getEducacion_monto()+ "','" + getTransporte_monto()+ "')";
            ps = conectar.conectarBD().prepareStatement(sql);
            ps.execute();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("Error al ingresar Monto que Necesita del plan recursos: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }
    
}
