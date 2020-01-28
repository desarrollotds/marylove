/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author Usuario
 */
public class Ingreso extends Personal{
    private int ingreso_id;
    private int victima_codigo;
    private int personal_codigo;

    public Ingreso() {
    }

    public Ingreso(int ingreso_id, int victima_codigo, int personal_codigo) {
        this.ingreso_id = ingreso_id;
        this.victima_codigo = victima_codigo;
        this.personal_codigo = personal_codigo;
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
    
}
