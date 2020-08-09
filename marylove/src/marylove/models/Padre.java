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
public class Padre extends Persona{
 private int padre_id;
 private int persona_codigo;
 private int edad;
    public Padre() {
    }

    public Padre(int padre_id, int persona_codigo) {
        this.padre_id = padre_id;
        this.persona_codigo = persona_codigo;
    }

    public Padre(int padre_id, int persona_codigo, int edad) {
        this.padre_id = padre_id;
        this.persona_codigo = persona_codigo;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPadre_id() {
        return padre_id;
    }

    public void setPadre_id(int padre_id) {
        this.padre_id = padre_id;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }
 
 
}

