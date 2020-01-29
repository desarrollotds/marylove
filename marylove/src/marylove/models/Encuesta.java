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
public class Encuesta {

    private int enc_codigo;
    private int epr_codigo;

    public Encuesta() {
    }

    public Encuesta(int enc_codigo, int epr_codigo) {
        this.enc_codigo = enc_codigo;
        this.epr_codigo = epr_codigo;
    }

    public int getEnc_codigo() {
        return enc_codigo;
    }

    public void setEnc_codigo(int enc_codigo) {
        this.enc_codigo = enc_codigo;
    }

    public int getEpr_codigo() {
        return epr_codigo;
    }

    public void setEpr_codigo(int epr_codigo) {
        this.epr_codigo = epr_codigo;
    }

}

