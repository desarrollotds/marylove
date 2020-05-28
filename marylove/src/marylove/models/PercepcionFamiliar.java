
package marylove.models;

import java.util.Date;

public class PercepcionFamiliar extends Persona{
    private int percepcion_id;
    private int evaluacion_id;
    private String comoSeSiente;
    private String alcanzoObjetivosComo;
    private String dificultadesEncontradas;
    private String visionUnionFamiliar;
    private String peFamiliEstado;
    private String fecha;
    private String fechaEval;

    public PercepcionFamiliar(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval) {
        this.percepcion_id = percepcion_id;
        this.evaluacion_id = evaluacion_id;
        this.comoSeSiente = comoSeSiente;
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
        this.dificultadesEncontradas = dificultadesEncontradas;
        this.visionUnionFamiliar = visionUnionFamiliar;
        this.peFamiliEstado = peFamiliEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public PercepcionFamiliar(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_estadocivil, char persona_sexo) {
        super(persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_sexo);
        this.percepcion_id = percepcion_id;
        this.evaluacion_id = evaluacion_id;
        this.comoSeSiente = comoSeSiente;
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
        this.dificultadesEncontradas = dificultadesEncontradas;
        this.visionUnionFamiliar = visionUnionFamiliar;
        this.peFamiliEstado = peFamiliEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public PercepcionFamiliar(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
        this.percepcion_id = percepcion_id;
        this.evaluacion_id = evaluacion_id;
        this.comoSeSiente = comoSeSiente;
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
        this.dificultadesEncontradas = dificultadesEncontradas;
        this.visionUnionFamiliar = visionUnionFamiliar;
        this.peFamiliEstado = peFamiliEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public PercepcionFamiliar(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
        this.percepcion_id = percepcion_id;
        this.evaluacion_id = evaluacion_id;
        this.comoSeSiente = comoSeSiente;
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
        this.dificultadesEncontradas = dificultadesEncontradas;
        this.visionUnionFamiliar = visionUnionFamiliar;
        this.peFamiliEstado = peFamiliEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public PercepcionFamiliar(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
        this.percepcion_id = percepcion_id;
        this.evaluacion_id = evaluacion_id;
        this.comoSeSiente = comoSeSiente;
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
        this.dificultadesEncontradas = dificultadesEncontradas;
        this.visionUnionFamiliar = visionUnionFamiliar;
        this.peFamiliEstado = peFamiliEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public PercepcionFamiliar(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
        this.percepcion_id = percepcion_id;
        this.evaluacion_id = evaluacion_id;
        this.comoSeSiente = comoSeSiente;
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
        this.dificultadesEncontradas = dificultadesEncontradas;
        this.visionUnionFamiliar = visionUnionFamiliar;
        this.peFamiliEstado = peFamiliEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public PercepcionFamiliar(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.percepcion_id = percepcion_id;
        this.evaluacion_id = evaluacion_id;
        this.comoSeSiente = comoSeSiente;
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
        this.dificultadesEncontradas = dificultadesEncontradas;
        this.visionUnionFamiliar = visionUnionFamiliar;
        this.peFamiliEstado = peFamiliEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public PercepcionFamiliar(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas, String visionUnionFamiliar, String peFamiliEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.percepcion_id = percepcion_id;
        this.evaluacion_id = evaluacion_id;
        this.comoSeSiente = comoSeSiente;
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
        this.dificultadesEncontradas = dificultadesEncontradas;
        this.visionUnionFamiliar = visionUnionFamiliar;
        this.peFamiliEstado = peFamiliEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public PercepcionFamiliar() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaEval() {
        return fechaEval;
    }

    public void setFechaEval(String fechaEval) {
        this.fechaEval = fechaEval;
    }

    public String getPeFamiliEstado() {
        return peFamiliEstado;
    }

    public void setPeFamiliEstado(String peFamiliEstado) {
        this.peFamiliEstado = peFamiliEstado;
    }

    public String getVisionUnionFamiliar() {
        return visionUnionFamiliar;
    }

    public void setVisionUnionFamiliar(String visionUnionFamiliar) {
        this.visionUnionFamiliar = visionUnionFamiliar;
    }

    public int getPercepcion_id() {
        return percepcion_id;
    }

    public void setPercepcion_id(int percepcion_id) {
        this.percepcion_id = percepcion_id;
    }

    public int getEvaluacion_id() {
        return evaluacion_id;
    }

    public void setEvaluacion_id(int evaluacion_id) {
        this.evaluacion_id = evaluacion_id;
    }

    public String getComoSeSiente() {
        return comoSeSiente;
    }

    public void setComoSeSiente(String comoSeSiente) {
        this.comoSeSiente = comoSeSiente;
    }

    public String getAlcanzoObjetivosComo() {
        return alcanzoObjetivosComo;
    }

    public void setAlcanzoObjetivosComo(String alcanzoObjetivosComo) {
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
    }

    public String getDificultadesEncontradas() {
        return dificultadesEncontradas;
    }

    public void setDificultadesEncontradas(String dificultadesEncontradas) {
        this.dificultadesEncontradas = dificultadesEncontradas;
    }

    
    
}
