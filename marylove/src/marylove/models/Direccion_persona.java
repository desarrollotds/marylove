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
    private int dir_codigo;


    public Direccion_persona() {
    }

    public Direccion_persona(int persona_codigo, int dir_codigo) {
        this.persona_codigo = persona_codigo;
        this.dir_codigo = dir_codigo;
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

    public int getDir_codigo() {
        return dir_codigo;
    }

    public void setDir_codigo(int dir_codigo) {
        this.dir_codigo = dir_codigo;
    }

    
    
    
    
}


