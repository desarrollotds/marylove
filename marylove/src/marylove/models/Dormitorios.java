
package marylove.models;

import java.util.Date;
public class Dormitorios extends Ingreso{
    private int dormitorio_id;
    private int victima_codigoDormit;
    private String dormitorio_nombre;
    private Date dormitorio_ingreso;
    private Date dormitorio_salida;

    public Dormitorios(int dormitorio_id, int victima_codigoDormit, String dormitorio_nombre, Date dormitorio_ingreso, Date dormitorio_salida) {
        this.dormitorio_id = dormitorio_id;
        this.victima_codigoDormit = victima_codigoDormit;
        this.dormitorio_nombre = dormitorio_nombre;
        this.dormitorio_ingreso = dormitorio_ingreso;
        this.dormitorio_salida = dormitorio_salida;
    }

    public Dormitorios(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha);
    }

    public Dormitorios(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
    }

    public Dormitorios(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }

    public Dormitorios(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public Dormitorios(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public Dormitorios(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public Dormitorios() {
    }

    public int getDormitorio_id() {
        return dormitorio_id;
    }

    public void setDormitorio_id(int dormitorio_id) {
        this.dormitorio_id = dormitorio_id;
    }

    public int getVictima_codigoDormit() {
        return victima_codigoDormit;
    }

    public void setVictima_codigoDormit(int victima_codigoDormit) {
        this.victima_codigoDormit = victima_codigoDormit;
    }

    public String getDormitorio_nombre() {
        return dormitorio_nombre;
    }

    public void setDormitorio_nombre(String dormitorio_nombre) {
        this.dormitorio_nombre = dormitorio_nombre;
    }

    public Date getDormitorio_ingreso() {
        return dormitorio_ingreso;
    }

    public void setDormitorio_ingreso(Date dormitorio_ingreso) {
        this.dormitorio_ingreso = dormitorio_ingreso;
    }

    public Date getDormitorio_salida() {
        return dormitorio_salida;
    }

    public void setDormitorio_salida(Date dormitorio_salida) {
        this.dormitorio_salida = dormitorio_salida;
    }
    
    
}
