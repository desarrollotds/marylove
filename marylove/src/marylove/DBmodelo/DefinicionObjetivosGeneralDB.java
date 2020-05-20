package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.DefinicionObjetivosGeneral;

public class DefinicionObjetivosGeneralDB extends DefinicionObjetivosGeneral {

    ConexionHi conectar; //= new ConexionHi();

    public DefinicionObjetivosGeneralDB() {
    }

    public DefinicionObjetivosGeneralDB(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones) {
        super(definiciong_id, evaluacion_id, objetivo_general, responsable, tiempo, observaciones);
    }

    public List<DefinicionObjetivosGeneral> listartObjeGen() throws SQLException {
        List<DefinicionObjetivosGeneral> listartObjeGen = new ArrayList<DefinicionObjetivosGeneral>();
        String sql = "select definiciong_id, objetivo_general, responsable,tiempo,observaciones from definicion_objetivos_general; ";
//                + "doj\n"
//                + "join evaluacion_plan_vida epv\n"
//                + "on doj.evaluacion_id = epv.evaluacion_id\n"
//                + "where epv.victima_codigo = '" + cod + "';";
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
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean insertarObjeGen() {
        String sql = "INSERT INTO definicion_objetivos_general(evaluacion_id,responsable,objetivo_general,tiempo, observaciones)";
        sql += "VALUES";
        sql += " (" + getEvaluacion_id() + " ," + getResponsable() + " ,' " + getObjetivo_general() + " ',' " + getTiempo() + " ',' " + getObservaciones() + "')";
        PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarObjGen() {
        String sql = "UPDATE definicion_objetivos_general SET ";
        sql += "objetivo_general='" + getObjetivo_general() + "', ";
        sql += "tiempo='" + getTiempo() + "', ";
        sql += "observaciones='" + getObservaciones() + "'";
        sql += " WHERE definiciong_id='" + getDefiniciong_id() + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<DefinicionObjetivosGeneral> buscarObjGen(String texto) throws SQLException {
        List<DefinicionObjetivosGeneral> buscarObjGen = new ArrayList();
        System.out.println("testoDB: " + texto);
        String sql = "select* from definicion_objetivos_general pf\n"
                + "join evaluacion_plan_vida epv\n"
                + "on pf.evaluacion_id = epv.evaluacion_id join victima vic\n"
                + "on vic.victima_codigo= epv.victima_codigo join persona as pe\n"
                + "on vic.persona_codigo =  pe.persona_codigo\n"
                + "where persona_cedula like '"+texto+"%'\n"
                + "OR persona_nombre LIKE '"+texto+"%'\n"
                + "OR persona_apellido like '"+texto+"%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                DefinicionObjetivosGeneral p = new DefinicionObjetivosGeneral();
                p.setDefiniciong_id(rs.getInt("definiciong_id"));
                p.setObjetivo_general(rs.getString("objetivo_general"));
                p.setTiempo(rs.getString("tiempo"));
                p.setObservaciones(rs.getString("observaciones"));
                buscarObjGen.add(p);

            }
            rs.close();
            return buscarObjGen;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
