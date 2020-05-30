
package marylove.models;

import java.util.Date;

public class Familiars extends Persona{
    private int familiares_id;
    private int persona_codigoFam;
    private int hijo_codigoFam;
    private String parentescoFam;
    private boolean estadoFam;
    private int edadFam;

    public Familiars(int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam) {
        this.familiares_id = familiares_id;
        this.persona_codigoFam = persona_codigoFam;
        this.hijo_codigoFam = hijo_codigoFam;
        this.parentescoFam = parentescoFam;
        this.estadoFam = estadoFam;
        this.edadFam = edadFam;
    }

    public Familiars(int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_estadocivil, char persona_sexo) {
        super(persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_sexo);
        this.familiares_id = familiares_id;
        this.persona_codigoFam = persona_codigoFam;
        this.hijo_codigoFam = hijo_codigoFam;
        this.parentescoFam = parentescoFam;
        this.estadoFam = estadoFam;
        this.edadFam = edadFam;
    }

    public Familiars(int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
        this.familiares_id = familiares_id;
        this.persona_codigoFam = persona_codigoFam;
        this.hijo_codigoFam = hijo_codigoFam;
        this.parentescoFam = parentescoFam;
        this.estadoFam = estadoFam;
        this.edadFam = edadFam;
    }

    public Familiars(int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
        this.familiares_id = familiares_id;
        this.persona_codigoFam = persona_codigoFam;
        this.hijo_codigoFam = hijo_codigoFam;
        this.parentescoFam = parentescoFam;
        this.estadoFam = estadoFam;
        this.edadFam = edadFam;
    }

    public Familiars(int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
        this.familiares_id = familiares_id;
        this.persona_codigoFam = persona_codigoFam;
        this.hijo_codigoFam = hijo_codigoFam;
        this.parentescoFam = parentescoFam;
        this.estadoFam = estadoFam;
        this.edadFam = edadFam;
    }

    public Familiars(int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
        this.familiares_id = familiares_id;
        this.persona_codigoFam = persona_codigoFam;
        this.hijo_codigoFam = hijo_codigoFam;
        this.parentescoFam = parentescoFam;
        this.estadoFam = estadoFam;
        this.edadFam = edadFam;
    }

    public Familiars(int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.familiares_id = familiares_id;
        this.persona_codigoFam = persona_codigoFam;
        this.hijo_codigoFam = hijo_codigoFam;
        this.parentescoFam = parentescoFam;
        this.estadoFam = estadoFam;
        this.edadFam = edadFam;
    }

    public Familiars(int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.familiares_id = familiares_id;
        this.persona_codigoFam = persona_codigoFam;
        this.hijo_codigoFam = hijo_codigoFam;
        this.parentescoFam = parentescoFam;
        this.estadoFam = estadoFam;
        this.edadFam = edadFam;
    }

    public Familiars() {
    }

    public int getFamiliares_id() {
        return familiares_id;
    }

    public void setFamiliares_id(int familiares_id) {
        this.familiares_id = familiares_id;
    }

    public int getPersona_codigoFam() {
        return persona_codigoFam;
    }

    public void setPersona_codigoFam(int persona_codigoFam) {
        this.persona_codigoFam = persona_codigoFam;
    }

    public int getHijo_codigoFam() {
        return hijo_codigoFam;
    }

    public void setHijo_codigoFam(int hijo_codigoFam) {
        this.hijo_codigoFam = hijo_codigoFam;
    }

    public String getParentescoFam() {
        return parentescoFam;
    }

    public void setParentescoFam(String parentescoFam) {
        this.parentescoFam = parentescoFam;
    }

    public boolean isEstadoFam() {
        return estadoFam;
    }

    public void setEstadoFam(boolean estadoFam) {
        this.estadoFam = estadoFam;
    }

    public int getEdadFam() {
        return edadFam;
    }

    public void setEdadFam(int edadFam) {
        this.edadFam = edadFam;
    }
    
    
}
