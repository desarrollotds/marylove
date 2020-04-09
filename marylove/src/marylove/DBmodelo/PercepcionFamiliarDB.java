package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.PercepcionFamiliar;

public class PercepcionFamiliarDB extends PercepcionFamiliar {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conn;
    String sql = "";
    Conexion con = new Conexion();

    public PercepcionFamiliarDB(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas) {
        super(percepcion_id, evaluacion_id, comoSeSiente, alcanzoObjetivosComo, dificultadesEncontradas);
    }

    public PercepcionFamiliarDB() {
    }

    public boolean IngresarPercepcionFamil() {
        String sql = "INSERT INTO percepcion_familiar"
                + "(evaluacion_id,comoseseinte,alcanzoonjetivos_como,dificultadesencontradas)"
                + "VALUES (" + getEvaluacion_id() + ",'" + getComoSeSiente() + "','" + getAlcanzoObjetivosComo() + "','" + getDificultadesEncontradas() + "')";
        PreparedStatement ps = con.getPs(sql);
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public List<PercepcionFamiliar> listarPerFam() throws SQLException {
        List<PercepcionFamiliar> listarPerFam = new ArrayList<PercepcionFamiliar>();
        String sql = "select percepcion_id,comoseseinte,alcanzoonjetivos_como,dificultadesencontradas from percepcion_familiar pf\n" +
                      "join evaluacion_plan_vida epv\n" +
                      "on epv.evaluacion_id = pf.evaluacion_id\n" +
                      "where epv.victima_codigo = '1';";
//        sql += "order by 1";
        ResultSet rs = con.query(sql);
        try {
            while (rs.next()) {
                PercepcionFamiliar p = new PercepcionFamiliar();
                p.setPercepcion_id(rs.getInt("percepcion_id"));
                p.setComoSeSiente(rs.getString("comoseseinte"));
                p.setAlcanzoObjetivosComo(rs.getString("alcanzoonjetivos_como"));
                p.setDificultadesEncontradas(rs.getString("dificultadesencontradas"));
                listarPerFam.add(p);
            }
            rs.close();
            return listarPerFam;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public boolean actualizarPerFam() {
        String sql = "UPDATE percepcion_familiar SET ";
        sql += "comoseseinte='" + getComoSeSiente()+ "', ";
        sql += "alcanzoonjetivos_como='" + getAlcanzoObjetivosComo()+ "', ";
        sql += "dificultadesencontradas='" + getDificultadesEncontradas()+ "'";
        sql += " WHERE percepcion_id='" + getPercepcion_id()+ "'";

        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
}
