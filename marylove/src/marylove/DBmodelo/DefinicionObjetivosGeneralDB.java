package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.DefinicionObjetivosGeneral;

public class DefinicionObjetivosGeneralDB extends DefinicionObjetivosGeneral {

    ConexionHi conectar = new ConexionHi();

    public DefinicionObjetivosGeneralDB(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval) {
        super(definiciong_id, evaluacion_id, objetivo_general, responsable, tiempo, observaciones, objetivosEstado, fecha, fechaEval);
    }

    public DefinicionObjetivosGeneralDB(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_estadocivil, char persona_sexo) {
        super(definiciong_id, evaluacion_id, objetivo_general, responsable, tiempo, observaciones, objetivosEstado, fecha, fechaEval, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_sexo);
    }

    public DefinicionObjetivosGeneralDB(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(definiciong_id, evaluacion_id, objetivo_general, responsable, tiempo, observaciones, objetivosEstado, fecha, fechaEval, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
    }

    public DefinicionObjetivosGeneralDB(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(definiciong_id, evaluacion_id, objetivo_general, responsable, tiempo, observaciones, objetivosEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
    }

    public DefinicionObjetivosGeneralDB(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(definiciong_id, evaluacion_id, objetivo_general, responsable, tiempo, observaciones, objetivosEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }

    public DefinicionObjetivosGeneralDB(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(definiciong_id, evaluacion_id, objetivo_general, responsable, tiempo, observaciones, objetivosEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public DefinicionObjetivosGeneralDB(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(definiciong_id, evaluacion_id, objetivo_general, responsable, tiempo, observaciones, objetivosEstado, fecha, fechaEval, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public DefinicionObjetivosGeneralDB(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(definiciong_id, evaluacion_id, objetivo_general, responsable, tiempo, observaciones, objetivosEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public DefinicionObjetivosGeneralDB() {
    }


    public List<DefinicionObjetivosGeneral> listartObjeGen() throws SQLException {
        List<DefinicionObjetivosGeneral> listartObjeGen = new ArrayList<>();
        String sql = "select dog.definiciong_id,pe.persona_cedula,pe.persona_nombre, pe.persona_apellido ,dog.objetivo_general, dog.responsable,dog.tiempo, dog.observaciones, epv.evalucion_fecha, epv.evalucion_proxima\n"
                + "from definicion_objetivos_general dog join evaluacion_plan_vida epv \n"
                + "on dog.evaluacion_id=epv.evaluacion_id inner join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona pe\n"
                + "on pe.persona_codigo = vc.persona_codigo"
                + " where objetivos_estado = 'a';";

        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                DefinicionObjetivosGeneral p = new DefinicionObjetivosGeneral();
                p.setDefiniciong_id(rs.getInt("definiciong_id"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setObjetivo_general(rs.getString("objetivo_general"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido("persona_apellido");
                p.setResponsable(rs.getInt("responsable"));
                p.setTiempo(rs.getString("tiempo"));
                p.setObservaciones(rs.getString("observaciones"));
                p.setFecha(rs.getString("evalucion_fecha"));
                p.setFechaEval(rs.getString("evalucion_proxima"));
                listartObjeGen.add(p);
            }
            rs.close();
            return listartObjeGen;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean insertarObjeGen() throws SQLException {
        String sql = "INSERT INTO definicion_objetivos_general(evaluacion_id,responsable,objetivo_general,tiempo, observaciones, objetivos_estado)";
        sql += "VALUES";
        sql += " (" + getEvaluacion_id() + " ," + getResponsable() + " ,' " + getObjetivo_general() + " ',' " + getTiempo() + " ',' " + getObservaciones() + "','a')";
        PreparedStatement ps = conectar.getConnection().prepareStatement(sql);
        if (conectar.noQuery(sql) == true) {
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

        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public List<DefinicionObjetivosGeneral> buscarObjGen(String texto) throws SQLException {
        List<DefinicionObjetivosGeneral> buscarObjGen = new ArrayList();
        System.out.println("testoDB: " + texto);
        String sql = "select dog.definiciong_id,pe.persona_cedula,pe.persona_nombre, pe.persona_apellido ,dog.objetivo_general, dog.responsable,dog.tiempo, dog.observaciones, epv.evalucion_fecha, epv.evalucion_proxima\n"
                + "from definicion_objetivos_general dog join evaluacion_plan_vida epv \n"
                + "on dog.evaluacion_id=epv.evaluacion_id inner join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona pe\n"
                + "on pe.persona_codigo = vc.persona_codigo "
                + "where objetivos_estado = 'a' and persona_cedula like '" + texto + "%'\n"
                + "OR persona_nombre LIKE '" + texto + "%'\n"
                + "OR persona_apellido like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                DefinicionObjetivosGeneral p = new DefinicionObjetivosGeneral();
                p.setDefiniciong_id(rs.getInt("definiciong_id"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setObjetivo_general(rs.getString("objetivo_general"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido("persona_apellido");
                p.setResponsable(rs.getInt("responsable"));
                p.setTiempo(rs.getString("tiempo"));
                p.setObservaciones(rs.getString("observaciones"));
                p.setFecha(rs.getString("evalucion_fecha"));
                p.setFechaEval(rs.getString("evalucion_proxima"));
                buscarObjGen.add(p);

            }
            rs.close();
            return buscarObjGen;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean eliminarObjGen() {
        String sql = "UPDATE definicion_objetivos_general SET objetivos_estado = 'd' WHERE definiciong_id='" + getDefiniciong_id() + "'";
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }
}
