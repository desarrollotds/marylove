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
public class Escala_prevencion_riesgo {

    private int epr_codigo;
    private int victima_codigo;
    private int psicologo_codigo;

    public Escala_prevencion_riesgo() {
    }

    public Escala_prevencion_riesgo(int victima_codigo, int psicologo_codigo) {
        this.victima_codigo = victima_codigo;
        this.psicologo_codigo = psicologo_codigo;
    }

    public Escala_prevencion_riesgo(int epr_codigo, int victima_codigo, int psicologo_codigo) {
        this.epr_codigo = epr_codigo;
        this.victima_codigo = victima_codigo;
        this.psicologo_codigo = psicologo_codigo;
    }

    public int getEpr_codigo() {
        return epr_codigo;
    }

    public void setEpr_codigo(int epr_codigo) {
        this.epr_codigo = epr_codigo;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public int getPsicologo_codigo() {
        return psicologo_codigo;
    }

    public void setPsicologo_codigo(int psicologo_codigo) {
        this.psicologo_codigo = psicologo_codigo;
    }

}

