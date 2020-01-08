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
public class abogada extends Personal{
    private int abogada_id;
    private int personal_codigo;

    public abogada() {
    }

    public abogada(int abogada_id, int personal_codigo) {
        this.abogada_id = abogada_id;
        this.personal_codigo = personal_codigo;
    }

    public int getAbogada_id() {
        return abogada_id;
    }

    public void setAbogada_id(int abogada_id) {
        this.abogada_id = abogada_id;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }
}
