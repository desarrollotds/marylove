
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.DefinicionObjetivosEspecifico;

public class DefinicionObjetivosEspecificosDB extends DefinicionObjetivosEspecifico{
    
    Conexion conectar = new Conexion();
    public DefinicionObjetivosEspecificosDB() {
    }
    
    public List<DefinicionObjetivosEspecifico> listartObjetiv() throws SQLException {
        List<DefinicionObjetivosEspecifico> listartObjetiv = new ArrayList<DefinicionObjetivosEspecifico>();
        String sql = "select* from definicion_objetivos_especifico";
//        sql += "order by 1";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                DefinicionObjetivosEspecifico p = new DefinicionObjetivosEspecifico();
//                p.setArticulo_descripcion(rs.getInt("ruc"));
                p.setDefinicion_id(rs.getInt("definicion_id"));
                //evaluacion_id
                p.setObjetivosEspecificos(rs.getString("objetivosespecificos"));
                p.setActividad(rs.getString("actividad"));
                p.setTiempo(rs.getString("tiempo"));
                p.setApoyode(rs.getString("apoyode"));
                p.setSupuestosAmenazas(rs.getString("supuestosamenazas"));
                listartObjetiv.add(p);
            }
            rs.close();
            return listartObjetiv;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
     public boolean insertarObjectivEspecif() {
        String sql = "INSERT INTO definicion_objetivos_especifico(objetivosespecificos, actividad,tiempo,apoyode,supuestosamenazas)";
        sql += "VALUES";
        sql += " ('" + getObjetivosEspecificos()+ " ',' " + getActividad()+ " ',' " + getTiempo()+ " ',' " +getApoyode()+ " ',' " +getSupuestosAmenazas()+"')";
        PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
}
