package models;

public class Persona {
private int persona_codigo;
private String cedula_persona,nombre_persona, fechaNac_persona,estadoCivil_persona,nacionalidad_persona,ocupacion_persona,nivelAcdm_persona,estadoMigr_persona,telefono_persona,celular_persona,dir_codigo;

    public Persona() {
    }

    public Persona(int persona_codigo, String cedula_persona, String nombre_persona, String fechaNac_persona, String estadoCivil_persona, String nacionalidad_persona, String ocupacion_persona, String nivelAcdm_persona, String estadoMigr_persona, String telefono_persona, String celular_persona, String dir_codigo) {
        this.persona_codigo = persona_codigo;
        this.cedula_persona = cedula_persona;
        this.nombre_persona = nombre_persona;
        this.fechaNac_persona = fechaNac_persona;
        this.estadoCivil_persona = estadoCivil_persona;
        this.nacionalidad_persona = nacionalidad_persona;
        this.ocupacion_persona = ocupacion_persona;
        this.nivelAcdm_persona = nivelAcdm_persona;
        this.estadoMigr_persona = estadoMigr_persona;
        this.telefono_persona = telefono_persona;
        this.celular_persona = celular_persona;
        this.dir_codigo = dir_codigo;
    }


    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }

    public String getCedula_persona() {
        return cedula_persona;
    }

    public void setCedula_persona(String cedula_persona) {
        this.cedula_persona = cedula_persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getFechaNac_persona() {
        return fechaNac_persona;
    }

    public void setFechaNac_persona(String fechaNac_persona) {
        this.fechaNac_persona = fechaNac_persona;
    }

    public String getEstadoCivil_persona() {
        return estadoCivil_persona;
    }

    public void setEstadoCivil_persona(String estadoCivil_persona) {
        this.estadoCivil_persona = estadoCivil_persona;
    }

    public String getNacionalidad_persona() {
        return nacionalidad_persona;
    }

    public void setNacionalidad_persona(String nacionalidad_persona) {
        this.nacionalidad_persona = nacionalidad_persona;
    }

    public String getOcupacion_persona() {
        return ocupacion_persona;
    }

    public void setOcupacion_persona(String ocupacion_persona) {
        this.ocupacion_persona = ocupacion_persona;
    }

    public String getNivelAcdm_persona() {
        return nivelAcdm_persona;
    }

    public void setNivelAcdm_persona(String nivelAcdm_persona) {
        this.nivelAcdm_persona = nivelAcdm_persona;
    }

    public String getEstadoMigr_persona() {
        return estadoMigr_persona;
    }

    public void setEstadoMigr_persona(String estadoMigr_persona) {
        this.estadoMigr_persona = estadoMigr_persona;
    }

    public String getTelefono_persona() {
        return telefono_persona;
    }

    public void setTelefono_persona(String telefono_persona) {
        this.telefono_persona = telefono_persona;
    }

    public String getCelular_persona() {
        return celular_persona;
    }

    public void setCelular_persona(String celular_persona) {
        this.celular_persona = celular_persona;
    }

    public String getDir_codigo() {
        return dir_codigo;
    }

    public void setDir_codigo(String dir_codigo) {
        this.dir_codigo = dir_codigo;
    }
    
}
