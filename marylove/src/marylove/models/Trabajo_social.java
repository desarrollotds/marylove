/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author Unos conejos muy sospechosos
 */
public class Trabajo_social {
    private int trabsoc_codigo;
    private int personal_codigo;

    public Trabajo_social(int trabsoc_codigo, int personal_codigo) {
        this.trabsoc_codigo = trabsoc_codigo;
        this.personal_codigo = personal_codigo;
    }

    public Trabajo_social() {
    }

    public int getTrabsoc_codigo() {
        return trabsoc_codigo;
    }

    public void setTrabsoc_codigo(int trabsoc_codigo) {
        this.trabsoc_codigo = trabsoc_codigo;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }
    
    
}
