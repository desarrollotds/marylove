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
public class ficha_legal {
    private int legal_id ;
    private int victima_codigo ;
    private int psicologo_codigo;
    private String motivo_consulta;
    private String relacion_hechos;
    private String aspectos_reelevantes;

    public ficha_legal() {
    }

    public ficha_legal(int legal_id, int victima_codigo, int psicologo_codigo, String motivo_consulta, String relacion_hechos, String aspectos_reelevantes) {
        this.legal_id = legal_id;
        this.victima_codigo = victima_codigo;
        this.psicologo_codigo = psicologo_codigo;
        this.motivo_consulta = motivo_consulta;
        this.relacion_hechos = relacion_hechos;
        this.aspectos_reelevantes = aspectos_reelevantes;
    }

    public int getLegal_id() {
        return legal_id;
    }

    public void setLegal_id(int legal_id) {
        this.legal_id = legal_id;
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

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public String getRelacion_hechos() {
        return relacion_hechos;
    }

    public void setRelacion_hechos(String relacion_hechos) {
        this.relacion_hechos = relacion_hechos;
    }

    public String getAspectos_reelevantes() {
        return aspectos_reelevantes;
    }

    public void setAspectos_reelevantes(String aspectos_reelevantes) {
        this.aspectos_reelevantes = aspectos_reelevantes;
    }
    
    
}
