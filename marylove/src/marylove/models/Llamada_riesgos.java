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
public class Llamada_riesgos {
    private int lama_id;
    private int llamada_codigo;
    private String frecuencia_agresion;
    private String nacionalidad_agresor;

    public Llamada_riesgos(int llamada_codigo, String frecuencia_agresion, String nacionalidad_agresor) {
        this.llamada_codigo = llamada_codigo;
        this.frecuencia_agresion = frecuencia_agresion;
        this.nacionalidad_agresor = nacionalidad_agresor;
    }
    
    public Llamada_riesgos() {
    }

    public int getLama_id() {
        return lama_id;
    }

    public void setLama_id(int lama_id) {
        this.lama_id = lama_id;
    }

    public int getLlamada_codigo() {
        return llamada_codigo;
    }

    public void setLlamada_codigo(int llamada_codigo) {
        this.llamada_codigo = llamada_codigo;
    }

    public String getFrecuencia_agresion() {
        return frecuencia_agresion;
    }

    public void setFrecuencia_agresion(String frecuencia_agresion) {
        this.frecuencia_agresion = frecuencia_agresion;
    }

    public String getNacionalidad_agresor() {
        return nacionalidad_agresor;
    }

    public void setNacionalidad_agresor(String nacionalidad_agresor) {
        this.nacionalidad_agresor = nacionalidad_agresor;
    }
    
}
