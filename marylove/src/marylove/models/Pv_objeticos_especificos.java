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
public class Pv_objeticos_especificos extends Persona {
    private int obj_espe_codigo;
    private int plan_de_vida;
    private String obejtivosEspecificos;
    private int personal_codigo;
    private String actividad;
    private String tiempo;
    private String apoyode;
    private String supu_amenazas;
    private String pv_estado;
    
    public Pv_objeticos_especificos() {
    }

    public Pv_objeticos_especificos(int plan_de_vida, String obejtivosEspecificos, int personal_codigo, String actividad, String tiempo, String apoyode, String supu_amenazas) {
        this.plan_de_vida = plan_de_vida;
        this.obejtivosEspecificos = obejtivosEspecificos;
        this.personal_codigo = personal_codigo;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supu_amenazas = supu_amenazas;
    }

    public Pv_objeticos_especificos(int obj_espe_codigo, int plan_de_vida, String obejtivosEspecificos, int personal_codigo, String actividad, String tiempo, String apoyode, String supu_amenazas) {
        this.obj_espe_codigo = obj_espe_codigo;
        this.plan_de_vida = plan_de_vida;
        this.obejtivosEspecificos = obejtivosEspecificos;
        this.personal_codigo = personal_codigo;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supu_amenazas = supu_amenazas;
    }

    public Pv_objeticos_especificos(int obj_espe_codigo, int plan_de_vida, String obejtivosEspecificos, int personal_codigo, String actividad, String tiempo, String apoyode, String supu_amenazas, String pv_estado) {
        this.obj_espe_codigo = obj_espe_codigo;
        this.plan_de_vida = plan_de_vida;
        this.obejtivosEspecificos = obejtivosEspecificos;
        this.personal_codigo = personal_codigo;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supu_amenazas = supu_amenazas;
        this.pv_estado = pv_estado;
    }

    public String getPv_estado() {
        return pv_estado;
    }

    public void setPv_estado(String pv_estado) {
        this.pv_estado = pv_estado;
    }

    

    public int getObj_espe_codigo() {
        return obj_espe_codigo;
    }

    public void setObj_espe_codigo(int obj_espe_codigo) {
        this.obj_espe_codigo = obj_espe_codigo;
    }

    public int getPlan_de_vida() {
        return plan_de_vida;
    }

    public void setPlan_de_vida(int plan_de_vida) {
        this.plan_de_vida = plan_de_vida;
    }

    public String getObejtivosEspecificos() {
        return obejtivosEspecificos;
    }

    public void setObejtivosEspecificos(String obejtivosEspecificos) {
        this.obejtivosEspecificos = obejtivosEspecificos;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getApoyode() {
        return apoyode;
    }

    public void setApoyode(String apoyode) {
        this.apoyode = apoyode;
    }

    public String getSupu_amenazas() {
        return supu_amenazas;
    }

    public void setSupu_amenazas(String supu_amenazas) {
        this.supu_amenazas = supu_amenazas;
    }
    
}
