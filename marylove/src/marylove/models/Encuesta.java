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
    private int enc_tipo;
    private int total;

    public Encuesta() {
    }

    public Encuesta(int total) {
        this.total = total;
    }
    
    public Encuesta(int enc_codigo, int epr_codigo, int enc_tipo) {
        this.enc_codigo = enc_codigo;
        this.epr_codigo = epr_codigo;
        this.enc_tipo = enc_tipo;
    }

    public Encuesta(int epr_codigo, int enc_tipo) {
        this.epr_codigo = epr_codigo;
        this.enc_tipo = enc_tipo;
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

    public int getEnc_tipo() {
        return enc_tipo;
    }

    public void setEnc_tipo(int enc_tipo) {
        this.enc_tipo = enc_tipo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}

