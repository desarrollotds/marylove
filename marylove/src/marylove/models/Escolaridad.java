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
public class Escolaridad {
    
private int escolaridad_id;
private boolean esc_estudia;
private String esc_explicacion;
private String esc_repeticion_anio_causas;
private boolean esc_nna_problem_aprend;
private String esc_nna_observaciones;
private boolean esc_asis_prog_apoyo;
private String esc_asis_prog_apoyo_obser;
private boolean esc_estado;

    public Escolaridad() {
    }

    public Escolaridad(boolean esc_estudia, String esc_explicacion, String esc_repeticion_anio_causas, boolean esc_nna_problem_aprend, String esc_nna_observaciones, boolean esc_asis_prog_apoyo, String esc_asis_prog_apoyo_obser, boolean esc_estado) {
        this.esc_estudia = esc_estudia;
        this.esc_explicacion = esc_explicacion;
        this.esc_repeticion_anio_causas = esc_repeticion_anio_causas;
        this.esc_nna_problem_aprend = esc_nna_problem_aprend;
        this.esc_nna_observaciones = esc_nna_observaciones;
        this.esc_asis_prog_apoyo = esc_asis_prog_apoyo;
        this.esc_asis_prog_apoyo_obser = esc_asis_prog_apoyo_obser;
        this.esc_estado = esc_estado;
    }

    public Escolaridad(boolean esc_estudia, String esc_explicacion, String esc_repeticion_anio_causas, boolean esc_nna_problem_aprend, String esc_nna_observaciones, boolean esc_asis_prog_apoyo, String esc_asis_prog_apoyo_obser) {
        this.esc_estudia = esc_estudia;
        this.esc_explicacion = esc_explicacion;
        this.esc_repeticion_anio_causas = esc_repeticion_anio_causas;
        this.esc_nna_problem_aprend = esc_nna_problem_aprend;
        this.esc_nna_observaciones = esc_nna_observaciones;
        this.esc_asis_prog_apoyo = esc_asis_prog_apoyo;
        this.esc_asis_prog_apoyo_obser = esc_asis_prog_apoyo_obser;
    }

    public Escolaridad(int escolaridad_id, boolean esc_estudia, String esc_explicacion, String esc_repeticion_anio_causas, boolean esc_nna_problem_aprend, String esc_nna_observaciones, boolean esc_asis_prog_apoyo, String esc_asis_prog_apoyo_obser) {
        this.escolaridad_id = escolaridad_id;
        this.esc_estudia = esc_estudia;
        this.esc_explicacion = esc_explicacion;
        this.esc_repeticion_anio_causas = esc_repeticion_anio_causas;
        this.esc_nna_problem_aprend = esc_nna_problem_aprend;
        this.esc_nna_observaciones = esc_nna_observaciones;
        this.esc_asis_prog_apoyo = esc_asis_prog_apoyo;
        this.esc_asis_prog_apoyo_obser = esc_asis_prog_apoyo_obser;
    }

   

    public int getEscolaridad_id() {
        return escolaridad_id;
    }

    public void setEscolaridad_id(int escolaridad_id) {
        this.escolaridad_id = escolaridad_id;
    }

    public boolean isEsc_estudia() {
        return esc_estudia;
    }

    public void setEsc_estudia(boolean esc_estudia) {
        this.esc_estudia = esc_estudia;
    }

    

    public String getEsc_explicacion() {
        return esc_explicacion;
    }

    public void setEsc_explicacion(String esc_explicacion) {
        this.esc_explicacion = esc_explicacion;
    }

    public String getEsc_repeticion_anio_causas() {
        return esc_repeticion_anio_causas;
    }

    public void setEsc_repeticion_anio_causas(String esc_repeticion_anio_causas) {
        this.esc_repeticion_anio_causas = esc_repeticion_anio_causas;
    }

    public boolean isEsc_nna_problem_aprend() {
        return esc_nna_problem_aprend;
    }

    public void setEsc_nna_problem_aprend(boolean esc_nna_problem_aprend) {
        this.esc_nna_problem_aprend = esc_nna_problem_aprend;
    }

    public String getEsc_nna_observaciones() {
        return esc_nna_observaciones;
    }

    public void setEsc_nna_observaciones(String esc_nna_observaciones) {
        this.esc_nna_observaciones = esc_nna_observaciones;
    }

    public boolean isEsc_asis_prog_apoyo() {
        return esc_asis_prog_apoyo;
    }

    public void setEsc_asis_prog_apoyo(boolean esc_asis_prog_apoyo) {
        this.esc_asis_prog_apoyo = esc_asis_prog_apoyo;
    }

    public String getEsc_asis_prog_apoyo_obser() {
        return esc_asis_prog_apoyo_obser;
    }

    public void setEsc_asis_prog_apoyo_obser(String esc_asis_prog_apoyo_obser) {
        this.esc_asis_prog_apoyo_obser = esc_asis_prog_apoyo_obser;
    }

    public boolean isEsc_estado() {
        return esc_estado;
    }

    public void setEsc_estado(boolean esc_estado) {
        this.esc_estado = esc_estado;
    }

}

