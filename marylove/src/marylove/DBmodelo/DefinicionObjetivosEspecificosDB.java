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

    ConexionHi conectar;// = new ConexionHi();

    public DefinicionObjetivosEspecificosDB() {
    }

    public List<DefinicionObjetivosEspecifico> listartObjetiv() throws SQLException {
        List<DefinicionObjetivosEspecifico> listartObjetiv = new ArrayList<DefinicionObjetivosEspecifico>();
        String sql = "select definicion_id, objetivosespecificos,actividad,tiempo,apoyode,supuestosamenazas,responsable"
                + " from definicion_objetivos_especifico ";
//                + "doe\n"
//                + "join evaluacion_plan_vida epv\n"
//                + "on doe.evaluacion_id = epv.evaluacion_id\n"
//                + "where epv.victima_codigo = '" + cod + "';";
//        sql += "order by 1";
        try {
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
                Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } catch (Exception e) {
            System.out.println("ERROR RESULTSET LISTAR OBJETIVOS: " + e);
            return null;
        }

    }

    public boolean insertarObjectivEspecif() {
        String sql = "INSERT INTO definicion_objetivos_especifico(evaluacion_id,responsable,objetivosespecificos, actividad,tiempo,apoyode,supuestosamenazas)";
        sql += "VALUES";
        sql += " (" + getEvaluacion_id() + " ," + getResponsoble() + " ,' " + getObjetivosEspecificos() + " ',' " + getActividad() + " ',' " + getTiempo() + " ',' " + getApoyode() + " ',' " + getSupuestosAmenazas() + "')";
        PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
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

        if (conectar.noQuery(sql) == null) {
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
                + "where persona_cedula like '" + texto + "%'\n"
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
}
