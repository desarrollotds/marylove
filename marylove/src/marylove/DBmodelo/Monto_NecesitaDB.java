package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Monto_Necesita;

/**
 *
 * @author USUARIO
 */
public class Monto_NecesitaDB extends Monto_Necesita {

    PreparedStatement ps;
    ResultSet rs = null;
    ConexionHi conectar = new ConexionHi();
    String sql;
    boolean ingreso = true;

    public Monto_NecesitaDB() {
    }

    public Monto_NecesitaDB(int monto_nesecita_codigo, int plan_recursos_int, String vivienda_monto, String alimentacion_monto, String educacion_monto, String transporte_monto) {
        super(monto_nesecita_codigo, plan_recursos_int, vivienda_monto, alimentacion_monto, educacion_monto, transporte_monto);
    }

    public boolean Ingresar_MontoNecesita() {
        try {
            sql = "INSERT INTO public.monto_necesita"
                    + "(planrecursos_codigo, vivienda, alimentcion, educacion, transporte,montoneces_estado)";
            sql += "VALUES ";
            sql += "(" + getPlan_recursos_int() + ",'" + getVivienda_monto()
                    + "','" + getAlimentacion_monto() + "','" + getEducacion_monto() + "','" 
                    + getTransporte_monto() + "','a')";
//            ps = conectar.getConnection().prepareStatement(sql);
//            ps.execute();
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar Monto que Necesita del plan recursos: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }
    public boolean actualizarMontoDisponible() {
        sql = "UPDATE monto_necesita SET ";
        sql += "vivienda='" + getVivienda_monto() + "', ";
        System.out.println("objet: " + getVivienda_monto());
        sql += "alimentcion='" + getAlimentacion_monto() + "', ";
        sql += "educacion='" + getEducacion_monto() + "',";
        sql += "transporte='" + getTransporte_monto() + "'";
        sql += " WHERE monto_codigo='" + getMonto_nesecita_codigo() + "';";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }
    
    public boolean eliminarMontNeces() {
        sql = "UPDATE monto_necesita SET montoneces_estado = 'd' WHERE monto_codigo='" + getMonto_nesecita_codigo()+ "'";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }

   public List<Monto_Necesita> listaMontoNecesita(int cod) throws SQLException {
        List<Monto_Necesita> listaMontoNecesita = new ArrayList<Monto_Necesita>();
        String sql = "select * from monto_necesita mn\n"
                + "join plan_recursos plr\n"
                + "on mn.planrecursos_codigo = plr.planrecursos_codigo\n"
                + "where plr.victima_codigo = '" + cod + "' AND montoneces_estado ='a';";
//        sql += "order by 1";
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Monto_Necesita mtn = new Monto_Necesita();
                mtn.setMonto_nesecita_codigo(rs.getInt("monto_codigo"));
                //planrecursos_codigo
                mtn.setVivienda_monto(rs.getString("vivienda"));
                mtn.setAlimentacion_monto(rs.getString("alimentcion"));
                mtn.setEducacion_monto(rs.getString("educacion"));
                mtn.setTransporte_monto(rs.getString("transporte"));
                listaMontoNecesita.add(mtn);
            }
            rs.close();
            return listaMontoNecesita;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
