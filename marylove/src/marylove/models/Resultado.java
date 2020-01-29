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
public class Resultado {

    private int resultado_id;
    private String resultado_nombre;

    public Resultado() {
    }

    public Resultado(int resultado_id, String resultado_nombre) {
        this.resultado_id = resultado_id;
        this.resultado_nombre = resultado_nombre;
    }

    public int getResultado_id() {
        return resultado_id;
    }

    public void setResultado_id(int resultado_id) {
        this.resultado_id = resultado_id;
    }

    public String getResultado_nombre() {
        return resultado_nombre;
    }

    public void setResultado_nombre(String resultado_nombre) {
        this.resultado_nombre = resultado_nombre;
    }

}

