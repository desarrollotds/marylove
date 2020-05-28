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
import marylove.models.PercepcionFamiliar;

public class PercepcionFamiliarDB extends PercepcionFamiliar {

    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    ConexionHi conectar = new ConexionHi();

    public PercepcionFamiliarDB(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval) {
        super(percepcion_id, evaluacion_id, comoSeSiente, alcanzoObjetivosComo, dificultadesEncontradas, visionUnionFamiliar, peFamiliEstado, fecha, fechaEval);
    }

    public PercepcionFamiliarDB(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_estadocivil, char persona_sexo) {
        super(percepcion_id, evaluacion_id, comoSeSiente, alcanzoObjetivosComo, dificultadesEncontradas, visionUnionFamiliar, peFamiliEstado, fecha, fechaEval, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_sexo);
    }

    public PercepcionFamiliarDB(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(percepcion_id, evaluacion_id, comoSeSiente, alcanzoObjetivosComo, dificultadesEncontradas, visionUnionFamiliar, peFamiliEstado, fecha, fechaEval, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
    }

    public PercepcionFamiliarDB(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(percepcion_id, evaluacion_id, comoSeSiente, alcanzoObjetivosComo, dificultadesEncontradas, visionUnionFamiliar, peFamiliEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
    }

    public PercepcionFamiliarDB(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(percepcion_id, evaluacion_id, comoSeSiente, alcanzoObjetivosComo, dificultadesEncontradas, visionUnionFamiliar, peFamiliEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }

    public PercepcionFamiliarDB(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(percepcion_id, evaluacion_id, comoSeSiente, alcanzoObjetivosComo, dificultadesEncontradas, visionUnionFamiliar, peFamiliEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public PercepcionFamiliarDB(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(percepcion_id, evaluacion_id, comoSeSiente, alcanzoObjetivosComo, dificultadesEncontradas, visionUnionFamiliar, peFamiliEstado, fecha, fechaEval, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public PercepcionFamiliarDB(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(percepcion_id, evaluacion_id, comoSeSiente, alcanzoObjetivosComo, dificultadesEncontradas, visionUnionFamiliar, peFamiliEstado, fecha, fechaEval, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public PercepcionFamiliarDB() {
    }

    public boolean IngresarPercepcionFamil() throws SQLException {
        sql = "INSERT INTO percepcion_familiar"
                + "(evaluacion_id,comoseseinte,alcanzoonjetivos_como,dificultadesencontradas, vision_union_famili,per_famili_estado)"
                + "VALUES (" + getEvaluacion_id() + ",'" + getComoSeSiente() + "','" + getAlcanzoObjetivosComo() + "','" + getDificultadesEncontradas() + "','" + getVisionUnionFamiliar() + "','a')";
        ps = conectar.getConnection().prepareStatement(sql);
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public List<PercepcionFamiliar> listarPerFam() throws SQLException {
        List<PercepcionFamiliar> listarPerFam = new ArrayList<>();
        sql = "select pf.percepcion_id,per.persona_cedula,per.persona_nombre, per.persona_apellido, pf.comoseseinte,pf.alcanzoonjetivos_como,pf.dificultadesencontradas,pf.vision_union_famili, epv.evalucion_fecha, epv.evalucion_proxima \n"
                + "from percepcion_familiar pf join evaluacion_plan_vida epv\n"
                + "on epv.evaluacion_id = pf.evaluacion_id inner join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona per\n"
                + "on vc.persona_codigo = per.persona_codigo\n"
                + "where per_famili_estado = 'a';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                PercepcionFamiliar p = new PercepcionFamiliar();
                p.setPercepcion_id(rs.getInt("percepcion_id"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setComoSeSiente(rs.getString("comoseseinte"));
                p.setAlcanzoObjetivosComo(rs.getString("alcanzoonjetivos_como"));
                p.setDificultadesEncontradas(rs.getString("dificultadesencontradas"));
                p.setVisionUnionFamiliar(rs.getString("vision_union_famili"));
                p.setFecha(rs.getString("evalucion_fecha"));
                p.setFechaEval(rs.getString("evalucion_proxima"));
                listarPerFam.add(p);
            }
            rs.close();
            return listarPerFam;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean actualizarPerFam() {
        sql = "UPDATE percepcion_familiar SET ";
        sql += "comoseseinte='" + getComoSeSiente() + "', ";
        sql += "alcanzoonjetivos_como='" + getAlcanzoObjetivosComo() + "', ";
        sql += "dificultadesencontradas='" + getDificultadesEncontradas() + "',";
        sql += "vision_union_famili='" + getVisionUnionFamiliar() + "'";
        sql += " WHERE percepcion_id='" + getPercepcion_id() + "'";

        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public List<PercepcionFamiliar> buscarTextoPercepcionFam(String texto) throws SQLException {
        List<PercepcionFamiliar> buscarTexto = new ArrayList();
        System.out.println("testoDB: " + texto);
        sql = "select pf.percepcion_id,per.persona_cedula,per.persona_nombre, per.persona_apellido, pf.comoseseinte,pf.alcanzoonjetivos_como,pf.dificultadesencontradas,pf.vision_union_famili, epv.evalucion_fecha, epv.evalucion_proxima \n"
                + "from percepcion_familiar pf join evaluacion_plan_vida epv\n"
                + "on epv.evaluacion_id = pf.evaluacion_id inner join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona per\n"
                + "on vc.persona_codigo = per.persona_codigo "
                + "where per_famili_estado = 'a' and persona_cedula like '" + texto + "%'\n"
                + "OR persona_nombre LIKE '" + texto + "%'\n"
                + "OR persona_apellido like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                PercepcionFamiliar p = new PercepcionFamiliar();
                p.setPercepcion_id(rs.getInt("percepcion_id"));
                p.setPersona_cedula(rs.getString("persona_cedula"));
                p.setPersona_nombre(rs.getString("persona_nombre"));
                p.setPersona_apellido(rs.getString("persona_apellido"));
                p.setComoSeSiente(rs.getString("comoseseinte"));
                p.setAlcanzoObjetivosComo(rs.getString("alcanzoonjetivos_como"));
                p.setDificultadesEncontradas(rs.getString("dificultadesencontradas"));
                p.setAlcanzoObjetivosComo(rs.getString("vision_union_famili"));
                p.setFecha(rs.getString("evalucion_fecha"));
                p.setFechaEval(rs.getString("evalucion_proxima"));
                buscarTexto.add(p);

            }
            rs.close();
            return buscarTexto;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean eliminarPerFamily() {
        sql = "UPDATE percepcion_familiar SET per_famili_estado = 'd' WHERE percepcion_id='" + getPercepcion_id() + "'";
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }
}
