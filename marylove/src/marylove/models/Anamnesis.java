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
public class Anamnesis {
private int anamnesis_id;
private int hijo_codigo;
private int embarazo_id;
private int nacimiento_codigo;
private int post_parto_id;
private int desarrollo_id;
private int escoralidad_id;
private int salud_nna_id;
private int relación_familiar_nna_id;
private int sucoes_id;
private String observaciones_generales;
private int personal_codigo;

    public Anamnesis() {
    }

    public Anamnesis(int hijo_codigo, int embarazo_id, int nacimiento_codigo, int post_parto_id, int desarrollo_id, int escoralidad_id, int salud_nna_id, int relación_familiar_nna_id, int sucoes_id, String observaciones_generales, int personal_codigo) {
        this.hijo_codigo = hijo_codigo;
        this.embarazo_id = embarazo_id;
        this.nacimiento_codigo = nacimiento_codigo;
        this.post_parto_id = post_parto_id;
        this.desarrollo_id = desarrollo_id;
        this.escoralidad_id = escoralidad_id;
        this.salud_nna_id = salud_nna_id;
        this.relación_familiar_nna_id = relación_familiar_nna_id;
        this.sucoes_id = sucoes_id;
        this.observaciones_generales = observaciones_generales;
        this.personal_codigo = personal_codigo;
    }

    public Anamnesis(int anamnesis_id, int hijo_codigo, int embarazo_id, int nacimiento_codigo, int post_parto_id, int desarrollo_id, int escoralidad_id, int salud_nna_id, int relación_familiar_nna_id, int sucoes_id, String observaciones_generales, int personal_codigo) {
        this.anamnesis_id = anamnesis_id;
        this.hijo_codigo = hijo_codigo;
        this.embarazo_id = embarazo_id;
        this.nacimiento_codigo = nacimiento_codigo;
        this.post_parto_id = post_parto_id;
        this.desarrollo_id = desarrollo_id;
        this.escoralidad_id = escoralidad_id;
        this.salud_nna_id = salud_nna_id;
        this.relación_familiar_nna_id = relación_familiar_nna_id;
        this.sucoes_id = sucoes_id;
        this.observaciones_generales = observaciones_generales;
        this.personal_codigo = personal_codigo;
    }

    public int getAnamnesis_id() {
        return anamnesis_id;
    }

    public void setAnamnesis_id(int anamnesis_id) {
        this.anamnesis_id = anamnesis_id;
    }

    public int getHijo_codigo() {
        return hijo_codigo;
    }

    public void setHijo_codigo(int hijo_codigo) {
        this.hijo_codigo = hijo_codigo;
    }

    public int getEmbarazo_id() {
        return embarazo_id;
    }

    public void setEmbarazo_id(int embarazo_id) {
        this.embarazo_id = embarazo_id;
    }

    public int getNacimiento_codigo() {
        return nacimiento_codigo;
    }

    public void setNacimiento_codigo(int nacimiento_codigo) {
        this.nacimiento_codigo = nacimiento_codigo;
    }

    public int getPost_parto_id() {
        return post_parto_id;
    }

    public void setPost_parto_id(int post_parto_id) {
        this.post_parto_id = post_parto_id;
    }

    public int getDesarrollo_id() {
        return desarrollo_id;
    }

    public void setDesarrollo_id(int desarrollo_id) {
        this.desarrollo_id = desarrollo_id;
    }

    public int getEscoralidad_id() {
        return escoralidad_id;
    }

    public void setEscoralidad_id(int escoralidad_id) {
        this.escoralidad_id = escoralidad_id;
    }

    public int getSalud_nna_id() {
        return salud_nna_id;
    }

    public void setSalud_nna_id(int salud_nna_id) {
        this.salud_nna_id = salud_nna_id;
    }

    public int getRelación_familiar_nna_id() {
        return relación_familiar_nna_id;
    }

    public void setRelación_familiar_nna_id(int relación_familiar_nna_id) {
        this.relación_familiar_nna_id = relación_familiar_nna_id;
    }

    public int getSucoes_id() {
        return sucoes_id;
    }

    public void setSucoes_id(int sucoes_id) {
        this.sucoes_id = sucoes_id;
    }

    public String getObservaciones_generales() {
        return observaciones_generales;
    }

    public void setObservaciones_generales(String observaciones_generales) {
        this.observaciones_generales = observaciones_generales;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }

}

