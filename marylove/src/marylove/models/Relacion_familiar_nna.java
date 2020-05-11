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
    private String relacion_padre;
    private String relacion_madre;
    private String relacion_hermanos;
    private boolean trabajo;
    private String trabajo_decrip;
    private boolean agresion_agresor;
    private String agresion_frecuencia;
    private String objeto_utilizado;
    private String obligacion_familiar;
    private String proyeccion_madre;
    private String necesidad_inmediata;

    public Relacion_familiar_nna() {
    }

    public Relacion_familiar_nna(String clima_familiar, String relacion_padre, String relacion_madre, String relacion_hermanos, boolean trabajo, String trabajo_decrip, boolean agresion_agresor, String agresion_frecuencia, String objeto_utilizado, String obligacion_familiar, String proyeccion_madre, String necesidad_inmediata) {
        this.clima_familiar = clima_familiar;
        this.relacion_padre = relacion_padre;
        this.relacion_madre = relacion_madre;
        this.relacion_hermanos = relacion_hermanos;
        this.trabajo = trabajo;
        this.trabajo_decrip = trabajo_decrip;
        this.agresion_agresor = agresion_agresor;
        this.agresion_frecuencia = agresion_frecuencia;
        this.objeto_utilizado = objeto_utilizado;
        this.obligacion_familiar = obligacion_familiar;
        this.proyeccion_madre = proyeccion_madre;
        this.necesidad_inmediata = necesidad_inmediata;
    }

    public Relacion_familiar_nna(int rela_famili_nna_id, String clima_familiar, String relacion_padre, String relacion_madre, String relacion_hermanos, boolean trabajo, String trabajo_decrip, boolean agresion_agresor, String agresion_frecuencia, String objeto_utilizado, String obligacion_familiar, String proyeccion_madre, String necesidad_inmediata) {
        this.rela_famili_nna_id = rela_famili_nna_id;
        this.clima_familiar = clima_familiar;
        this.relacion_padre = relacion_padre;
        this.relacion_madre = relacion_madre;
        this.relacion_hermanos = relacion_hermanos;
        this.trabajo = trabajo;
        this.trabajo_decrip = trabajo_decrip;
        this.agresion_agresor = agresion_agresor;
        this.agresion_frecuencia = agresion_frecuencia;
        this.objeto_utilizado = objeto_utilizado;
        this.obligacion_familiar = obligacion_familiar;
        this.proyeccion_madre = proyeccion_madre;
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

    public String getRelacion_padre() {
        return relacion_padre;
    }

    public void setRelacion_padre(String relacion_padre) {
        this.relacion_padre = relacion_padre;
    }

    public String getRelacion_madre() {
        return relacion_madre;
    }

    public void setRelacion_madre(String relacion_madre) {
        this.relacion_madre = relacion_madre;
    }

    public String getRelacion_hermanos() {
        return relacion_hermanos;
    }

    public void setRelacion_hermanos(String relacion_hermanos) {
        this.relacion_hermanos = relacion_hermanos;
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

    public boolean isAgresion_agresor() {
        return agresion_agresor;
    }

    public void setAgresion_agresor(boolean agresion_agresor) {
        this.agresion_agresor = agresion_agresor;
    }

    public String getAgresion_frecuencia() {
        return agresion_frecuencia;
    }

    public void setAgresion_frecuencia(String agresion_frecuencia) {
        this.agresion_frecuencia = agresion_frecuencia;
    }

 

    public String getObjeto_utilizado() {
        return objeto_utilizado;
    }

    public void setObjeto_utilizado(String objeto_utilizado) {
        this.objeto_utilizado = objeto_utilizado;
    }

    public String getObligacion_familiar() {
        return obligacion_familiar;
    }

    public void setObligacion_familiar(String obligacion_familiar) {
        this.obligacion_familiar = obligacion_familiar;
    }

    public String getProyeccion_madre() {
        return proyeccion_madre;
    }

    public void setProyeccion_madre(String proyeccion_madre) {
        this.proyeccion_madre = proyeccion_madre;
    }

    public String getNecesidad_inmediata() {
        return necesidad_inmediata;
    }

    public void setNecesidad_inmediata(String necesidad_inmediata) {
        this.necesidad_inmediata = necesidad_inmediata;
    }

   

}

