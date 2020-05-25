package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.DefinicionObjetivosEspecifico;

public class DefinicionObjetivosEspecificosDB extends DefinicionObjetivosEspecifico {

    ConexionHi conectar = new ConexionHi();

    public DefinicionObjetivosEspecificosDB(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado) {
        super(definicion_id, evaluacion_id, objetivosEspecificos, actividad, tiempo, apoyode, supuestosAmenazas, responsoble, objetivosEstado);
    }

    public DefinicionObjetivosEspecificosDB() {
    }

    public List<DefinicionObjetivosEspecifico> listartObjetiv() throws SQLException {
        List<DefinicionObjetivosEspecifico> listartObjetiv = new ArrayList<>();
        String sql = "select definicion_id, objetivosespecificos,actividad,tiempo,apoyode,supuestosamenazas,responsable\n"
                + "from definicion_objetivos_especifico"
                + " where objetivos_estado =  'a'; ";
//                + "doe\n"
//                + "join evaluacion_plan_vida epv\n"
//                + "on doe.evaluacion_id = epv.evaluacion_id\n"
//                + "where epv.victima_codigo = '" + cod + "';";
//        sql += "order by 1";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                DefinicionObjetivosEspecifico p = new DefinicionObjetivosEspecifico();
                p.setDefinicion_id(rs.getInt("definicion_id"));
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
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean insertarObjectivEspecif() throws SQLException {
        String sql = "INSERT INTO definicion_objetivos_especifico(evaluacion_id,responsable,objetivosespecificos, actividad,tiempo,apoyode,supuestosamenazas, objetivos_estado)";
        sql += "VALUES";
        sql += " (" + getEvaluacion_id() + " ," + getResponsoble() + " ,' " + getObjetivosEspecificos() + " ',' " + getActividad() + " ',' " + getTiempo() + " ',' " + getApoyode() + " ',' " + getSupuestosAmenazas() + "', 'a')";
        PreparedStatement ps = conectar.getConnection().prepareStatement(sql);
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarObjEsp() {
        String sql = "UPDATE definicion_objetivos_especifico SET ";
        sql += "objetivosespecificos='" + getObjetivosEspecificos() + "', ";
        System.out.println("objet: " + getObjetivosEspecificos());
        sql += "actividad='" + getActividad() + "', ";
        sql += "tiempo='" + getTiempo() + "',";
        sql += "apoyode='" + getApoyode() + "',";
        sql += "supuestosamenazas='" + getSupuestosAmenazas() + "'";
        sql += " WHERE definicion_id='" + getDefinicion_id() + "';";

        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public List<DefinicionObjetivosEspecifico> buscarObjEsp(String texto) throws SQLException {
        List<DefinicionObjetivosEspecifico> buscarObjEsp = new ArrayList();
        System.out.println("testoDB: " + texto);
        String sql = "select definicion_id, objetivosespecificos,actividad,tiempo,apoyode,supuestosamenazas,responsable"
                + " from definicion_objetivos_especifico pf\n"
                + "join evaluacion_plan_vida epv\n"
                + "on pf.evaluacion_id = epv.evaluacion_id join victima vic\n"
                + "on vic.victima_codigo= epv.victima_codigo join persona as pe\n"
                + "on vic.persona_codigo =  pe.persona_codigo\n"
                + "where objetivos_estado = 'a' and persona_cedula like '" + texto + "%'\n"
                + "OR persona_nombre LIKE '" + texto + "%'\n"
                + "OR persona_apellido like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                DefinicionObjetivosEspecifico p = new DefinicionObjetivosEspecifico();
                p.setDefinicion_id(rs.getInt("definicion_id"));
                //evaluacion_id
                p.setObjetivosEspecificos(rs.getString("objetivosespecificos"));
                p.setActividad(rs.getString("actividad"));
                p.setTiempo(rs.getString("tiempo"));
                p.setApoyode(rs.getString("apoyode"));
                p.setSupuestosAmenazas(rs.getString("supuestosamenazas"));

                buscarObjEsp.add(p);

            }
            rs.close();
            return buscarObjEsp;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean eliminarObEsp() {
        String sql = "UPDATE definicion_objetivos_especifico SET objetivos_estado = 'd' WHERE definicion_id='" + getDefinicion_id()+ "'";
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }
}
