
package marylove.models;

import java.util.Date;

public class DefinicionObjetivosEspecifico extends Persona {
    private int definicion_id;
    private int evaluacion_id;
    private String objetivosEspecificos;
    private String actividad;
    private String tiempo;
    private String apoyode;
    private String supuestosAmenazas;
    private int responsoble;
    private String objetivosEstado;

    public DefinicionObjetivosEspecifico(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado) {
        this.definicion_id = definicion_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivosEspecificos = objetivosEspecificos;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supuestosAmenazas = supuestosAmenazas;
        this.responsoble = responsoble;
        this.objetivosEstado = objetivosEstado;
    }

    public DefinicionObjetivosEspecifico(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_estadocivil, char persona_sexo) {
        super(persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_sexo);
        this.definicion_id = definicion_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivosEspecificos = objetivosEspecificos;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supuestosAmenazas = supuestosAmenazas;
        this.responsoble = responsoble;
        this.objetivosEstado = objetivosEstado;
    }

    public DefinicionObjetivosEspecifico(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
        this.definicion_id = definicion_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivosEspecificos = objetivosEspecificos;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supuestosAmenazas = supuestosAmenazas;
        this.responsoble = responsoble;
        this.objetivosEstado = objetivosEstado;
    }

    public DefinicionObjetivosEspecifico(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
        this.definicion_id = definicion_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivosEspecificos = objetivosEspecificos;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supuestosAmenazas = supuestosAmenazas;
        this.responsoble = responsoble;
        this.objetivosEstado = objetivosEstado;
    }

    public DefinicionObjetivosEspecifico(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
        this.definicion_id = definicion_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivosEspecificos = objetivosEspecificos;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supuestosAmenazas = supuestosAmenazas;
        this.responsoble = responsoble;
        this.objetivosEstado = objetivosEstado;
    }

    public DefinicionObjetivosEspecifico(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
        this.definicion_id = definicion_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivosEspecificos = objetivosEspecificos;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supuestosAmenazas = supuestosAmenazas;
        this.responsoble = responsoble;
        this.objetivosEstado = objetivosEstado;
    }

    public DefinicionObjetivosEspecifico(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.definicion_id = definicion_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivosEspecificos = objetivosEspecificos;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supuestosAmenazas = supuestosAmenazas;
        this.responsoble = responsoble;
        this.objetivosEstado = objetivosEstado;
    }

    public DefinicionObjetivosEspecifico(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble, String objetivosEstado, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.definicion_id = definicion_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivosEspecificos = objetivosEspecificos;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supuestosAmenazas = supuestosAmenazas;
        this.responsoble = responsoble;
        this.objetivosEstado = objetivosEstado;
    }

    public DefinicionObjetivosEspecifico() {
    }

    public String getObjetivosEstado() {
        return objetivosEstado;
    }

    public void setObjetivosEstado(String objetivosEstado) {
        this.objetivosEstado = objetivosEstado;
    }
    

    public int getResponsoble() {
        return responsoble;
    }

    public void setResponsoble(int responsoble) {
        this.responsoble = responsoble;
    }

    public int getDefinicion_id() {
        return definicion_id;
    }

    public void setDefinicion_id(int definicion_id) {
        this.definicion_id = definicion_id;
    }

    public int getEvaluacion_id() {
        return evaluacion_id;
    }

    public void setEvaluacion_id(int evaluacion_id) {
        this.evaluacion_id = evaluacion_id;
    }

    public String getObjetivosEspecificos() {
        return objetivosEspecificos;
    }

    public void setObjetivosEspecificos(String objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getApoyode() {
        return apoyode;
    }

    public void setApoyode(String apoyode) {
        this.apoyode = apoyode;
    }

    public String getSupuestosAmenazas() {
        return supuestosAmenazas;
    }

    public void setSupuestosAmenazas(String supuestosAmenazas) {
        this.supuestosAmenazas = supuestosAmenazas;
    }
    
    
}
