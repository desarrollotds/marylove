
package marylove.models;

import java.util.Date;

public class DefinicionObjetivosGeneral extends Persona{
    private int definiciong_id;
    private int evaluacion_id;
    private String objetivo_general;
    private int responsable;
    private String tiempo;
    private String observaciones;
    private String objetivosEstado;
    private String fecha;
    private String fechaEval;

    public DefinicionObjetivosGeneral(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval) {
        this.definiciong_id = definiciong_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivo_general = objetivo_general;
        this.responsable = responsable;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
        this.objetivosEstado = objetivosEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public DefinicionObjetivosGeneral(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_estadocivil, char persona_sexo) {
        super(persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_sexo);
        this.definiciong_id = definiciong_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivo_general = objetivo_general;
        this.responsable = responsable;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
        this.objetivosEstado = objetivosEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public DefinicionObjetivosGeneral(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
        this.definiciong_id = definiciong_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivo_general = objetivo_general;
        this.responsable = responsable;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
        this.objetivosEstado = objetivosEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public DefinicionObjetivosGeneral(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
        this.definiciong_id = definiciong_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivo_general = objetivo_general;
        this.responsable = responsable;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
        this.objetivosEstado = objetivosEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public DefinicionObjetivosGeneral(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
        this.definiciong_id = definiciong_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivo_general = objetivo_general;
        this.responsable = responsable;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
        this.objetivosEstado = objetivosEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public DefinicionObjetivosGeneral(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
        this.definiciong_id = definiciong_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivo_general = objetivo_general;
        this.responsable = responsable;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
        this.objetivosEstado = objetivosEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public DefinicionObjetivosGeneral(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.definiciong_id = definiciong_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivo_general = objetivo_general;
        this.responsable = responsable;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
        this.objetivosEstado = objetivosEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public DefinicionObjetivosGeneral(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones, String objetivosEstado, String fecha, String fechaEval, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.definiciong_id = definiciong_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivo_general = objetivo_general;
        this.responsable = responsable;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
        this.objetivosEstado = objetivosEstado;
        this.fecha = fecha;
        this.fechaEval = fechaEval;
    }

    public DefinicionObjetivosGeneral() {
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

    public String getObjetivosEstado() {
        return objetivosEstado;
    }

    public void setObjetivosEstado(String objetivosEstado) {
        this.objetivosEstado = objetivosEstado;
    }

    public int getDefiniciong_id() {
        return definiciong_id;
    }

    public void setDefiniciong_id(int definiciong_id) {
        this.definiciong_id = definiciong_id;
    }

    public int getEvaluacion_id() {
        return evaluacion_id;
    }

    public void setEvaluacion_id(int evaluacion_id) {
        this.evaluacion_id = evaluacion_id;
    }

    public String getObjetivo_general() {
        return objetivo_general;
    }

    public void setObjetivo_general(String objetivo_general) {
        this.objetivo_general = objetivo_general;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
