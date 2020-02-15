
package marylove.models;

public class RegistroReferenciaDb extends Persona{

    public RegistroReferenciaDb() {
    }

    public RegistroReferenciaDb(int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, boolean persona_estado_actual) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_estadocivil, persona_nacionalidad, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estado_actual);
    }

    public RegistroReferenciaDb(String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_estadocivil, persona_nacionalidad, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular);
    }

    public RegistroReferenciaDb(String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, boolean persona_estado_actual) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_estadocivil, persona_nacionalidad, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estado_actual);
    } 
}
