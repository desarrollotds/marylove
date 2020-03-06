
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.DefinicionObjetivosGeneral;

public class DefinicionObjetivosGeneralDB extends DefinicionObjetivosGeneral{
    Conexion conectar = new Conexion();
            
    public DefinicionObjetivosGeneralDB() {
    }

    public DefinicionObjetivosGeneralDB(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones) {
        super(definiciong_id, evaluacion_id, objetivo_general, responsable, tiempo, observaciones);
    }
    
    public List<DefinicionObjetivosGeneral> listartObjeGen() throws SQLException {
        List<DefinicionObjetivosGeneral> listartObjeGen = new ArrayList<DefinicionObjetivosGeneral>();
        String sql = "select* from definicion_objetivos_general";
//        sql += "order by 1";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                DefinicionObjetivosGeneral p = new DefinicionObjetivosGeneral();
                p.setDefiniciong_id(rs.getInt("definiciong_id"));
                p.setObjetivo_general(rs.getString("objetivo_general"));
                p.setTiempo(rs.getString("tiempo"));
                p.setObservaciones(rs.getString("observaciones"));
                listartObjeGen.add(p);
            }
            rs.close();
            return listartObjeGen;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public boolean insertarObjeGen() {
        String sql = "INSERT INTO definicion_objetivos_general(objetivo_general,tiempo, observaciones)";
        sql += "VALUES";
        sql += " ('" + getObjetivo_general()+ " ',' " + getTiempo()+ " ',' " +getObservaciones()+"')";
        PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
}
