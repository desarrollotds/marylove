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
import marylove.models.DefinicionObjetivosEspecifico;

public class DefinicionObjetivosEspecificosDB extends DefinicionObjetivosEspecifico {

    ConexionHi conectar = new ConexionHi();

    public DefinicionObjetivosEspecificosDB(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String fecha, String fechaEval) {
        super(definicion_id, evaluacion_id, objetivosEspecificos, actividad, tiempo, apoyode, supuestosAmenazas, responsoble, objetivosEstado, fecha, fechaEval);
    }

    public DefinicionObjetivosEspecificosDB(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String fecha, String fechaEval, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_estadocivil, char persona_sexo) {
        super(definicion_id, evaluacion_id, objetivosEspecificos, actividad, tiempo, apoyode, supuestosAmenazas, responsoble, objetivosEstado, fecha, fechaEval, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_sexo);
    }

    public DefinicionObjetivosEspecificosDB(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String fecha, String fechaEval, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(definicion_id, evaluacion_id, objetivosEspecificos, actividad, tiempo, apoyode, supuestosAmenazas, responsoble, objetivosEstado, fecha, fechaEval, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
    }

    public DefinicionObjetivosEspecificosDB(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(definicion_id, evaluacion_id, objetivosEspecificos, actividad, tiempo, apoyode, supuestosAmenazas, responsoble, objetivosEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
    }

    public DefinicionObjetivosEspecificosDB(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(definicion_id, evaluacion_id, objetivosEspecificos, actividad, tiempo, apoyode, supuestosAmenazas, responsoble, objetivosEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }

    public DefinicionObjetivosEspecificosDB(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(definicion_id, evaluacion_id, objetivosEspecificos, actividad, tiempo, apoyode, supuestosAmenazas, responsoble, objetivosEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public DefinicionObjetivosEspecificosDB(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String fecha, String fechaEval, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(definicion_id, evaluacion_id, objetivosEspecificos, actividad, tiempo, apoyode, supuestosAmenazas, responsoble, objetivosEstado, fecha, fechaEval, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public DefinicionObjetivosEspecificosDB(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(definicion_id, evaluacion_id, objetivosEspecificos, actividad, tiempo, apoyode, supuestosAmenazas, responsoble, objetivosEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public DefinicionObjetivosEspecificosDB() {
    }

    public List<DefinicionObjetivosEspecifico> listartObjetiv() throws SQLException {
        List<DefinicionObjetivosEspecifico> listartObjetiv = new ArrayList<>();
        String sql = "select doe.definicion_id,pe.persona_cedula,pe.persona_nombre, pe.persona_apellido ,doe.objetivosespecificos, doe.actividad,doe.tiempo, doe.apoyode,doe.supuestosamenazas,doe.responsable, epv.evalucion_fecha, epv.evalucion_proxima\n"
                + "from definicion_objetivos_especifico doe join evaluacion_plan_vida epv \n"
                + "on doe.evaluacion_id=epv.evaluacion_id inner join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona pe\n"
                + "on pe.persona_codigo = vc.persona_codigo\n"
                + "where objetivos_estado = 'a'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                DefinicionObjetivosEspecifico p = new DefinicionObjetivosEspecifico();
                p.setDefinicion_id(rs.getInt("definicion_id"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setObjetivosEspecificos(rs.getString("objetivosespecificos"));
                p.setActividad(rs.getString("actividad"));
                p.setTiempo(rs.getString("tiempo"));
                p.setApoyode(rs.getString("apoyode"));
                p.setResponsoble(rs.getInt("responsable"));
                p.setSupuestosAmenazas(rs.getString("supuestosamenazas"));
                p.setFecha(rs.getString("evalucion_fecha"));
                p.setFechaEval(rs.getString("evalucion_proxima"));
                listartObjetiv.add(p);
            }
            rs.close();
            return listartObjetiv;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public List<DefinicionObjetivosEspecifico> listartObjetivEsp(String cod) throws SQLException {
        List<DefinicionObjetivosEspecifico> listartObjetivEsp = new ArrayList<>();
        String sql = "select doe.definicion_id,pe.persona_cedula,pe.persona_nombre, pe.persona_apellido ,doe.objetivosespecificos, doe.actividad,doe.tiempo, doe.apoyode,doe.supuestosamenazas,doe.responsable, epv.evalucion_fecha, epv.evalucion_proxima\n"
                + "from definicion_objetivos_especifico doe join evaluacion_plan_vida epv \n"
                + "on doe.evaluacion_id=epv.evaluacion_id inner join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona pe\n"
                + "on pe.persona_codigo = vc.persona_codigo\n"
                + "where objetivos_estado = 'a' and pe.persona_cedula = '"+cod+"';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                DefinicionObjetivosEspecifico p = new DefinicionObjetivosEspecifico();
                p.setDefinicion_id(rs.getInt("definicion_id"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setObjetivosEspecificos(rs.getString("objetivosespecificos"));
                p.setActividad(rs.getString("actividad"));
                p.setTiempo(rs.getString("tiempo"));
                p.setApoyode(rs.getString("apoyode"));
                p.setResponsoble(rs.getInt("responsable"));
                p.setSupuestosAmenazas(rs.getString("supuestosamenazas"));
                p.setFecha(rs.getString("evalucion_fecha"));
                p.setFechaEval(rs.getString("evalucion_proxima"));
                listartObjetivEsp.add(p);
            }
            rs.close();
            return listartObjetivEsp;
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
        String sql = "select doe.definicion_id,pe.persona_cedula,pe.persona_nombre, pe.persona_apellido ,doe.objetivosespecificos, doe.actividad,doe.tiempo, doe.apoyode,doe.supuestosamenazas,doe.responsable, epv.evalucion_fecha, epv.evalucion_proxima\n"
                + "from definicion_objetivos_especifico doe join evaluacion_plan_vida epv \n"
                + "on doe.evaluacion_id=epv.evaluacion_id inner join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona pe\n"
                + "on pe.persona_codigo = vc.persona_codigo "
                + "where objetivos_estado = 'a' and persona_cedula like '" + texto + "%'\n"
                + "OR persona_nombre LIKE '" + texto + "%'\n"
                + "OR persona_apellido like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                DefinicionObjetivosEspecifico p = new DefinicionObjetivosEspecifico();
                p.setDefinicion_id(rs.getInt("definicion_id"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setObjetivosEspecificos(rs.getString("objetivosespecificos"));
                p.setActividad(rs.getString("actividad"));
                p.setTiempo(rs.getString("tiempo"));
                p.setApoyode(rs.getString("apoyode"));
                p.setResponsoble(rs.getInt("responsable"));
                p.setSupuestosAmenazas(rs.getString("supuestosamenazas"));
                p.setFecha(rs.getString("evalucion_fecha"));
                p.setFechaEval(rs.getString("evalucion_proxima"));
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
        String sql = "UPDATE definicion_objetivos_especifico SET objetivos_estado = 'd' WHERE definicion_id='" + getDefinicion_id() + "'";
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }
}
