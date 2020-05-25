package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.EvaluacionPlanVida;

public class EvaluacionPlanVidaDB extends EvaluacionPlanVida {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";

    public EvaluacionPlanVidaDB(int evaluacion_id, int victima_codigo, String evaluacion_fecha, String evaluacion_proxima, int personal_codigo, String evaluacion_estado) {
        super(evaluacion_id, victima_codigo, evaluacion_fecha, evaluacion_proxima, personal_codigo, evaluacion_estado);
    }

    public EvaluacionPlanVidaDB() {
    }

    public boolean IngresarEvaluacionPlaVida() throws SQLException {
        sql = "INSERT INTO evaluacion_plan_vida"
                + "(victima_codigo,personal_codigo,evalucion_fecha,evalucion_proxima,evaluacion_estado)"
            //    + "VALUES (" + getVictima_codigo() + "," + getPersonal_codigo() + ",'" + getEvaluacion_fecha() + "','" + getEvaluacion_proxima() + "','a')";
                + "VALUES (" + getVictima_codigo() + "," + 1 + ",'" + getEvaluacion_fecha() + "','" + getEvaluacion_proxima() + "','a')";

        ps = conectar.getConnection().prepareStatement(sql);
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public int verifiUserP(int c_per) { // verifica que perfil es el usuario
        int user = 0;
        try {
            sql = "select * from personal where personal_codigo = " + c_per + ";";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error personal " + ex.getMessage());
            user = 0;
        }
//        con.cerrarConexion();
        return user;
    }

    public int maxId() {
        int id = 0;
        try {
            sql = "select max(evaluacion_id) from evaluacion_plan_vida;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                id = (re.getInt(1));
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
//        con.cerrarConexion();
        return id;
    }
    
    
}
