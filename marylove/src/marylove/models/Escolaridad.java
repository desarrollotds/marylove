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
public class Escolaridad extends Sueno_control_esfin {
    
private int escolaridad_id;
private boolean esc_estudia;
private String esc_explicacion;
private String esc_repeticion_anio_causas;
private boolean esc_nna_problem_aprend;
private String esc_nna_observaciones;
private boolean esc_asis_prog_apoyo;
private String esc_asis_prog_apoyo_obser;
private boolean esc_estado;
private String esc_ultimo_anio_cursado;

    public Escolaridad() {
    }
     public Escolaridad(int escolaridad_id, boolean esc_estudia, String esc_explicacion, String esc_repeticion_anio_causas, boolean esc_nna_problem_aprend, String esc_nna_observaciones, boolean esc_asis_prog_apoyo, String esc_asis_prog_apoyo_obser, boolean esc_estado, String esc_ultimo_anio_cursado, int sucoes_id, boolean duerme_toda_noche, boolean miedo_dormir_solo, String despertar_descripcion, boolean pesadillas, int edad_control_esfinter, boolean ayuda_bano, boolean moja_cama, String periodo_ecopresis_descrip, boolean periodo_ecopresis, String como_es_sueno, String acompanamiento_dormir, boolean sueno_cont_estado, String des_motor_grueso, String des_motor_fino, String movimientos, String des_psico_social, String des_cognitivo, String des_fisico, String caridad_lenguajes, String claridad_lenguajes_descrip, boolean desarrollo_estado) {
        super(sucoes_id, duerme_toda_noche, miedo_dormir_solo, despertar_descripcion, pesadillas, edad_control_esfinter, ayuda_bano, moja_cama, periodo_ecopresis_descrip, periodo_ecopresis, como_es_sueno, acompanamiento_dormir, sueno_cont_estado, des_motor_grueso, des_motor_fino, movimientos, des_psico_social, des_cognitivo, des_fisico, caridad_lenguajes, claridad_lenguajes_descrip, desarrollo_estado);
        this.escolaridad_id = escolaridad_id;
        this.esc_estudia = esc_estudia;
        this.esc_explicacion = esc_explicacion;
        this.esc_repeticion_anio_causas = esc_repeticion_anio_causas;
        this.esc_nna_problem_aprend = esc_nna_problem_aprend;
        this.esc_nna_observaciones = esc_nna_observaciones;
        this.esc_asis_prog_apoyo = esc_asis_prog_apoyo;
        this.esc_asis_prog_apoyo_obser = esc_asis_prog_apoyo_obser;
        this.esc_estado = esc_estado;
        this.esc_ultimo_anio_cursado = esc_ultimo_anio_cursado;
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

    public String getEsc_ultimo_anio_cursado() {
        return esc_ultimo_anio_cursado;
    }

    public void setEsc_ultimo_anio_cursado(String esc_ultimo_anio_cursado) {
        this.esc_ultimo_anio_cursado = esc_ultimo_anio_cursado;
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

