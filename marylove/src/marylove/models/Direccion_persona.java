/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author icrv9
 */
public class Direccion_persona {
    
    private int dirper_id;
    private int persona_codigo;
    private int dir_domicilio;
    private int dir_trabajo;

    public Direccion_persona(int dirper_id, int persona_codigo, int dir_domicilio, int dir_trabajo) {
        this.dirper_id = dirper_id;
        this.persona_codigo = persona_codigo;
        this.dir_domicilio = dir_domicilio;
        this.dir_trabajo = dir_trabajo;
    }
    
    public Direccion_persona() {
    }

    public Direccion_persona(int persona_codigo, int dir_domicilio, int dir_trabajo) {
        this.persona_codigo = persona_codigo;
        this.dir_domicilio = dir_domicilio;
        this.dir_trabajo = dir_trabajo;
    }

    public int getDirper_id() {
        return dirper_id;
    }

    public void setDirper_id(int dirper_id) {
        this.dirper_id = dirper_id;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }

    public int getDir_domicilio() {
        return dir_domicilio;
    }

    public void setDir_domicilio(int dir_domicilio) {
        this.dir_domicilio = dir_domicilio;
    }

    public int getDir_trabajo() {
        return dir_trabajo;
    }

    public void setDir_trabajo(int dir_trabajo) {
        this.dir_trabajo = dir_trabajo;
    }
    
    
    
}


