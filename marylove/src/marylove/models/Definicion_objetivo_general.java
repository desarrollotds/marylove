/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author LENOVO
 */
public class Definicion_objetivo_general {
    private int definicon_id;
    private int evaluacion_id;
    private String objetivosGeneral;
    private int responsable;
    private String tiempo;
    private String observaciones;

    public Definicion_objetivo_general() {
    }

    public Definicion_objetivo_general(int definicon_id, int evaluacion_id, String objetivosGeneral, int responsable, String tiempo, String observaciones) {
        this.definicon_id = definicon_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivosGeneral = objetivosGeneral;
        this.responsable = responsable;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
    }

    public int getDefinicon_id() {
        return definicon_id;
    }

    public void setDefinicon_id(int definicon_id) {
        this.definicon_id = definicon_id;
    }

    public int getEvaluacion_id() {
        return evaluacion_id;
    }

    public void setEvaluacion_id(int evaluacion_id) {
        this.evaluacion_id = evaluacion_id;
    }

    public String getObjetivosGeneral() {
        return objetivosGeneral;
    }

    public void setObjetivosGeneral(String objetivosGeneral) {
        this.objetivosGeneral = objetivosGeneral;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
