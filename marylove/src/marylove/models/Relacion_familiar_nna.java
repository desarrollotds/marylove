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
public class Relacion_familiar_nna {

    private int rela_famili_nna_id;
    private String clima_familiar;
    private String relación_padre;
    private String relación_madre;
    private String relación_hermanos;
    private boolean trabajo;
    private String trabajo_decrip;
    private boolean agresión_agresor;
    private int agresión_frecuencia;
    private String objeto_utilizado;
    private String obligación_familiar;
    private String proyección_madre;
    private String necesidad_inmediata;

    public Relacion_familiar_nna() {
    }

    public Relacion_familiar_nna(int rela_famili_nna_id, String clima_familiar, String relación_padre, String relación_madre, String relación_hermanos, boolean trabajo, String trabajo_decrip, boolean agresión_agresor, int agresión_frecuencia, String objeto_utilizado, String obligación_familiar, String proyección_madre, String necesidad_inmediata) {
        this.rela_famili_nna_id = rela_famili_nna_id;
        this.clima_familiar = clima_familiar;
        this.relación_padre = relación_padre;
        this.relación_madre = relación_madre;
        this.relación_hermanos = relación_hermanos;
        this.trabajo = trabajo;
        this.trabajo_decrip = trabajo_decrip;
        this.agresión_agresor = agresión_agresor;
        this.agresión_frecuencia = agresión_frecuencia;
        this.objeto_utilizado = objeto_utilizado;
        this.obligación_familiar = obligación_familiar;
        this.proyección_madre = proyección_madre;
        this.necesidad_inmediata = necesidad_inmediata;
    }

    public int getRela_famili_nna_id() {
        return rela_famili_nna_id;
    }

    public void setRela_famili_nna_id(int rela_famili_nna_id) {
        this.rela_famili_nna_id = rela_famili_nna_id;
    }

    public String getClima_familiar() {
        return clima_familiar;
    }

    public void setClima_familiar(String clima_familiar) {
        this.clima_familiar = clima_familiar;
    }

    public String getRelación_padre() {
        return relación_padre;
    }

    public void setRelación_padre(String relación_padre) {
        this.relación_padre = relación_padre;
    }

    public String getRelación_madre() {
        return relación_madre;
    }

    public void setRelación_madre(String relación_madre) {
        this.relación_madre = relación_madre;
    }

    public String getRelación_hermanos() {
        return relación_hermanos;
    }

    public void setRelación_hermanos(String relación_hermanos) {
        this.relación_hermanos = relación_hermanos;
    }

    public boolean isTrabajo() {
        return trabajo;
    }

    public void setTrabajo(boolean trabajo) {
        this.trabajo = trabajo;
    }

    public String getTrabajo_decrip() {
        return trabajo_decrip;
    }

    public void setTrabajo_decrip(String trabajo_decrip) {
        this.trabajo_decrip = trabajo_decrip;
    }

    public boolean isAgresión_agresor() {
        return agresión_agresor;
    }

    public void setAgresión_agresor(boolean agresión_agresor) {
        this.agresión_agresor = agresión_agresor;
    }

    public int getAgresión_frecuencia() {
        return agresión_frecuencia;
    }

    public void setAgresión_frecuencia(int agresión_frecuencia) {
        this.agresión_frecuencia = agresión_frecuencia;
    }

    public String getObjeto_utilizado() {
        return objeto_utilizado;
    }

    public void setObjeto_utilizado(String objeto_utilizado) {
        this.objeto_utilizado = objeto_utilizado;
    }

    public String getObligación_familiar() {
        return obligación_familiar;
    }

    public void setObligación_familiar(String obligación_familiar) {
        this.obligación_familiar = obligación_familiar;
    }

    public String getProyección_madre() {
        return proyección_madre;
    }

    public void setProyección_madre(String proyección_madre) {
        this.proyección_madre = proyección_madre;
    }

    public String getNecesidad_inmediata() {
        return necesidad_inmediata;
    }

    public void setNecesidad_inmediata(String necesidad_inmediata) {
        this.necesidad_inmediata = necesidad_inmediata;
    }

}

