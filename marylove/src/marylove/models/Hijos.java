package marylove.models;

import java.util.Date;

public class Hijos extends Persona {

    private int hijo_codigo;
    private int persona_codigo;
    private int victima_codigo;
    private String hijo_anioescolar;
    private String hijo_estado;
    private int padre_id;
    private boolean padre_agresor;
    private String hijo_estado_ingreso;
    private int institucion_codigo;
    private boolean hijos_estado;
    private boolean padreAgresor;

    public Hijos(int hijo_codigo, int victima_codigo, String hijo_anioescolar, String hijo_estado, int padre_id, boolean padre_agresor, String hijo_estado_ingreso, int institucion_codigo, boolean hijos_estado, boolean padreAgresor, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
        this.hijo_codigo = hijo_codigo;
       
        this.victima_codigo = victima_codigo;
        this.hijo_anioescolar = hijo_anioescolar;
        this.hijo_estado = hijo_estado;
        this.padre_id = padre_id;
        this.padre_agresor = padre_agresor;
        this.hijo_estado_ingreso = hijo_estado_ingreso;
        this.institucion_codigo = institucion_codigo;
        this.hijos_estado = hijos_estado;
        this.padreAgresor = padreAgresor;
    }

  
    

    public Hijos() {
    }

    public Hijos(int hijo_codigo, int persona_codigo, int victima_codigo, String hijo_anioescolar, String hijo_estado, int padre_id, boolean padre_agresor, String hijo_estado_ingreso, int institucion_codigo, boolean hijos_estado, boolean padreAgresor) {
        this.hijo_codigo = hijo_codigo;
        this.persona_codigo = persona_codigo;
        this.victima_codigo = victima_codigo;
        this.hijo_anioescolar = hijo_anioescolar;
        this.hijo_estado = hijo_estado;
        this.padre_id = padre_id;
        this.padre_agresor = padre_agresor;
        this.hijo_estado_ingreso = hijo_estado_ingreso;
        this.institucion_codigo = institucion_codigo;
        this.hijos_estado = hijos_estado;
        this.padreAgresor = padreAgresor;
    }

    public Hijos(int persona_codigo, int victima_codigo, String hijo_anioescolar, int institucion_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
        this.persona_codigo = persona_codigo;
        this.victima_codigo = victima_codigo;
        this.hijo_anioescolar = hijo_anioescolar;

        this.institucion_codigo = institucion_codigo;
    }

    public Hijos(String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public Hijos(int persona_codigo, int victima_codigo, String hijo_anioescolar, String hijo_estado, int padre_id, boolean padre_agresor, String hijo_estado_ingreso, int institucion_codigo, boolean hijos_estado) {
        this.persona_codigo = persona_codigo;
        this.victima_codigo = victima_codigo;
        this.hijo_anioescolar = hijo_anioescolar;
        this.hijo_estado = hijo_estado;
        this.padre_id = padre_id;
        this.padre_agresor = padre_agresor;
        this.hijo_estado_ingreso = hijo_estado_ingreso;
        this.institucion_codigo = institucion_codigo;
        this.hijos_estado = hijos_estado;
    }

    public Hijos(int persona_codigo, int victima_codigo, String hijo_anioescolar, String hijo_estado, int padre_id, boolean padre_agresor, String hijo_estado_ingreso, int institucion_codigo) {
        this.persona_codigo = persona_codigo;
        this.victima_codigo = victima_codigo;
        this.hijo_anioescolar = hijo_anioescolar;
        this.hijo_estado = hijo_estado;
        this.padre_id = padre_id;
        this.padre_agresor = padre_agresor;
        this.hijo_estado_ingreso = hijo_estado_ingreso;
        this.institucion_codigo = institucion_codigo;
    }

    public int getInstitucion_codigo() {
        return institucion_codigo;
    }
      public boolean isPadreAgresor() {
        return padreAgresor;
    }

    public void setPadreAgresor(boolean padreAgresor) {
        this.padreAgresor = padreAgresor;
    }

    public void setInstitucion(int institucion_codigo) {
        this.institucion_codigo = institucion_codigo;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }

    public int getHijo_codigo() {
        return hijo_codigo;
    }

    public void setHijo_codigo(int hijo_codigo) {
        this.hijo_codigo = hijo_codigo;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public String getHijo_anioescolar() {
        return hijo_anioescolar;
    }

    public void setHijo_anioescolar(String hijo_anioescolar) {
        this.hijo_anioescolar = hijo_anioescolar;
    }

    public String getHijo_estado() {
        return hijo_estado;
    }

    public void setHijo_estado(String hijo_estado) {
        this.hijo_estado = hijo_estado;
    }

    public int getPadre_id() {
        return padre_id;
    }

    public void setPadre_id(int padre_id) {
        this.padre_id = padre_id;
    }

    public boolean isPadre_agresor() {
        return padre_agresor;
    }

    public void setPadre_agresor(boolean padre_agresor) {
        this.padre_agresor = padre_agresor;
    }

    public String getHijo_estado_ingreso() {
        return hijo_estado_ingreso;
    }

    public void setHijo_estado_ingreso(String hijo_estado_ingreso) {
        this.hijo_estado_ingreso = hijo_estado_ingreso;
    }

    public boolean isHijos_estado() {
        return hijos_estado;
    }

    public void setHijos_estado(boolean hijos_estado) {
        this.hijos_estado = hijos_estado;
    }

}
