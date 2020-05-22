/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.util.Date;


/**
 *
 * @author Alumno
 */
public class Ingreso extends Persona{

    private int ingreso_id;
    private int victima_codigo;
    private int personal_codigo;
    private String asignacion_dormitorio;
    private String Referidapor;
    private Date ingreso_fecha;

    public Ingreso(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha) {
        this.ingreso_id = ingreso_id;
        this.victima_codigo = victima_codigo;
        this.personal_codigo = personal_codigo;
        this.asignacion_dormitorio = asignacion_dormitorio;
        this.Referidapor = Referidapor;
        this.ingreso_fecha = ingreso_fecha;
    }

    public Ingreso(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
        this.ingreso_id = ingreso_id;
        this.victima_codigo = victima_codigo;
        this.personal_codigo = personal_codigo;
        this.asignacion_dormitorio = asignacion_dormitorio;
        this.Referidapor = Referidapor;
        this.ingreso_fecha = ingreso_fecha;
    }

    public Ingreso(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
        this.ingreso_id = ingreso_id;
        this.victima_codigo = victima_codigo;
        this.personal_codigo = personal_codigo;
        this.asignacion_dormitorio = asignacion_dormitorio;
        this.Referidapor = Referidapor;
        this.ingreso_fecha = ingreso_fecha;
    }

    public Ingreso(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
        this.ingreso_id = ingreso_id;
        this.victima_codigo = victima_codigo;
        this.personal_codigo = personal_codigo;
        this.asignacion_dormitorio = asignacion_dormitorio;
        this.Referidapor = Referidapor;
        this.ingreso_fecha = ingreso_fecha;
    }

    public Ingreso(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.ingreso_id = ingreso_id;
        this.victima_codigo = victima_codigo;
        this.personal_codigo = personal_codigo;
        this.asignacion_dormitorio = asignacion_dormitorio;
        this.Referidapor = Referidapor;
        this.ingreso_fecha = ingreso_fecha;
    }

    public Ingreso(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.ingreso_id = ingreso_id;
        this.victima_codigo = victima_codigo;
        this.personal_codigo = personal_codigo;
        this.asignacion_dormitorio = asignacion_dormitorio;
        this.Referidapor = Referidapor;
        this.ingreso_fecha = ingreso_fecha;
    }

    public Date getIngreso_fecha() {
        return ingreso_fecha;
    }

    public void setIngreso_fecha(Date ingreso_fecha) {
        this.ingreso_fecha = ingreso_fecha;
    }

   

    public Ingreso() {
    }
    

    public int getIngreso_id() {
        return ingreso_id;
    }

    public void setIngreso_id(int ingreso_id) {
        this.ingreso_id = ingreso_id;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }

    public String getAsignacion_dormitorio() {
        return asignacion_dormitorio;
    }

    public void setAsignacion_dormitorio(String asignacion_dormitorio) {
        this.asignacion_dormitorio = asignacion_dormitorio;
    }

    public String getReferidapor() {
        return Referidapor;
    }

    public void setReferidapor(String Referidapor) {
        this.Referidapor = Referidapor;
    }
}
