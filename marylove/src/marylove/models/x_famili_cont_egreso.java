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
public class x_famili_cont_egreso {
    private int famili_cont_egreso_id ;
    private int egreso_codigo ;
    private int familiares_id ;
    private int telefono;

    public x_famili_cont_egreso() {
    }

    public x_famili_cont_egreso(int famili_cont_egreso_id, int egreso_codigo, int familiares_id, int telefono) {
        this.famili_cont_egreso_id = famili_cont_egreso_id;
        this.egreso_codigo = egreso_codigo;
        this.familiares_id = familiares_id;
        this.telefono = telefono;
    }

    public x_famili_cont_egreso(int egreso_codigo, int familiares_id, int telefono) {
        this.egreso_codigo = egreso_codigo;
        this.familiares_id = familiares_id;
        this.telefono = telefono;
    }

    public int getFamili_cont_egreso_id() {
        return famili_cont_egreso_id;
    }

    public void setFamili_cont_egreso_id(int famili_cont_egreso_id) {
        this.famili_cont_egreso_id = famili_cont_egreso_id;
    }

    public int getEgreso_codigo() {
        return egreso_codigo;
    }

    public void setEgreso_codigo(int egreso_codigo) {
        this.egreso_codigo = egreso_codigo;
    }

    public int getFamiliares_id() {
        return familiares_id;
    }

    public void setFamiliares_id(int familiares_id) {
        this.familiares_id = familiares_id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
}
