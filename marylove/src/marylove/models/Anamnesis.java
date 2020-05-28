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
public class Anamnesis extends Escolaridad {

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
    private boolean anamnesis_estado;
    private String nombre_madre;
    private String apellido_madre;
    private int edad_madre;
    private int nacionalidad_madre;
    

    public Anamnesis() {
    }
  public Anamnesis(String observaciones_generales, int escolaridad_id, boolean esc_estudia, String esc_explicacion, String esc_repeticion_anio_causas, boolean esc_nna_problem_aprend, String esc_nna_observaciones, boolean esc_asis_prog_apoyo, String esc_asis_prog_apoyo_obser, boolean esc_estado, String esc_ultimo_anio_cursado, int sucoes_id, boolean duerme_toda_noche, boolean miedo_dormir_solo, String despertar_descripcion, boolean pesadillas, int edad_control_esfinter, boolean ayuda_bano, boolean moja_cama, String periodo_ecopresis_descrip, boolean periodo_ecopresis, String como_es_sueno, String acompanamiento_dormir, boolean sueno_cont_estado, String des_motor_grueso, String des_motor_fino, String movimientos, String des_psico_social, String des_cognitivo, String des_fisico, String caridad_lenguajes, String claridad_lenguajes_descrip, boolean desarrollo_estado) {
        super(escolaridad_id, esc_estudia, esc_explicacion, esc_repeticion_anio_causas, esc_nna_problem_aprend, esc_nna_observaciones, esc_asis_prog_apoyo, esc_asis_prog_apoyo_obser, esc_estado, esc_ultimo_anio_cursado, sucoes_id, duerme_toda_noche, miedo_dormir_solo, despertar_descripcion, pesadillas, edad_control_esfinter, ayuda_bano, moja_cama, periodo_ecopresis_descrip, periodo_ecopresis, como_es_sueno, acompanamiento_dormir, sueno_cont_estado, des_motor_grueso, des_motor_fino, movimientos, des_psico_social, des_cognitivo, des_fisico, caridad_lenguajes, claridad_lenguajes_descrip, desarrollo_estado);
        this.observaciones_generales = observaciones_generales;
    }
    public Anamnesis(int anamnesis_id, String observaciones_generales) {
        this.anamnesis_id = anamnesis_id;
        this.observaciones_generales = observaciones_generales;
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

    public Anamnesis(int hijo_codigo, int embarazo_id, int nacimiento_codigo, int post_parto_id, int desarrollo_id, int escoralidad_id, int salud_nna_id, int relación_familiar_nna_id, int sucoes_id, String observaciones_generales, int personal_codigo, boolean anamnesis_estado) {
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
        this.anamnesis_estado = anamnesis_estado;
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

    public boolean isAnamnesis_estado() {
        return anamnesis_estado;
    }

    public void setAnamnesis_estado(boolean anamnesis_estado) {
        this.anamnesis_estado = anamnesis_estado;
    }

    public String getNombre_madre() {
        return nombre_madre;
    }

    public void setNombre_madre(String nombre_madre) {
        this.nombre_madre = nombre_madre;
    }

    public String getApellido_madre() {
        return apellido_madre;
    }

    public void setApellido_madre(String apellido_madre) {
        this.apellido_madre = apellido_madre;
    }

    public int getEdad_madre() {
        return edad_madre;
    }

    public void setEdad_madre(int edad_madre) {
        this.edad_madre = edad_madre;
    }

    public int getNacionalidad_madre() {
        return nacionalidad_madre;
    }

    public void setNacionalidad_madre(int nacionalidad_madre) {
        this.nacionalidad_madre = nacionalidad_madre;
    }
}
