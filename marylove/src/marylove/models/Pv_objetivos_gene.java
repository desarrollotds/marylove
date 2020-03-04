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
public class Pv_objetivos_gene {
    private int obj_codigo_gene;
    private String obejtivoGeneral;
    private int personal_codigo;
    private String tiempo;
    private String observaciones;

    public Pv_objetivos_gene(int obj_codigo_gene, String obejtivoGeneral, int personal_codigo, String tiempo, String observaciones) {
        this.obj_codigo_gene = obj_codigo_gene;
        this.obejtivoGeneral = obejtivoGeneral;
        this.personal_codigo = personal_codigo;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
    }

    public Pv_objetivos_gene() {
    }

    public int getObj_codigo_gene() {
        return obj_codigo_gene;
    }

    public void setObj_codigo_gene(int obj_codigo_gene) {
        this.obj_codigo_gene = obj_codigo_gene;
    }

    public String getObejtivoGeneral() {
        return obejtivoGeneral;
    }

    public void setObejtivoGeneral(String obejtivoGeneral) {
        this.obejtivoGeneral = obejtivoGeneral;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
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
