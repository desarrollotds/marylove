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
public class Familiares extends Persona{

    private int familiares_id;
    private int persona_codigo;
    private int anamnesis_id;
    private String parentesco;
    private boolean estado;

    public Familiares() {
    }

    public Familiares(int persona_codigo, int anamnesis_id, String parentesco) {
        this.persona_codigo = persona_codigo;
        this.anamnesis_id = anamnesis_id;
        this.parentesco = parentesco;
    }
    

    public Familiares(int familiares_id, int persona_codigo, int anamnesis_id, String parentesco,boolean estado) {
        this.familiares_id = familiares_id;
        this.persona_codigo = persona_codigo;
        this.anamnesis_id = anamnesis_id;
        this.parentesco = parentesco;
        this.estado=estado;
    }

    public int getFamiliares_id() {
        return familiares_id;
    }

    public void setFamiliares_id(int familiares_id) {
        this.familiares_id = familiares_id;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }

    public int getAnamnesis_id() {
        return anamnesis_id;
    }

    public void setAnamnesis_id(int anamnesis_id) {
        this.anamnesis_id = anamnesis_id;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}

