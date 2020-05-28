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
public class Salud_nna extends Relacion_familiar_nna{

    private int salud_nna_id;
    private String problem_familiare;
    private String problem_familiar_descrip;
    private boolean problem_respiratorio;
    private String problem_resp_descrip;
    private boolean problem_alergias;
    private String problem_aler_descrip;
    private boolean problem_neurologico;
    private String problem_neuro_descrip;
    private boolean problem_nerviosos;
    private String problem_nervi_descrip;
    private boolean salud_nna_estado;

     public Salud_nna(int salud_nna_id, String problem_familiare, String problem_familiar_descrip, boolean problem_respiratorio, String problem_resp_descrip, boolean problem_alergias, String problem_aler_descrip, boolean problem_neurologico, String problem_neuro_descrip, boolean problem_nerviosos, String problem_nervi_descrip, boolean salud_nna_estado, String clima_familiar, String relacion_padre, String relacion_madre, String relacion_hermanos, boolean trabajo, String trabajo_decrip, boolean agresion_agresor, String agresion_frecuencia, String objeto_utilizado, String obligacion_familiar, String proyeccion_madre, String necesidad_inmediata, boolean rela_famili_estado) {
        super(clima_familiar, relacion_padre, relacion_madre, relacion_hermanos, trabajo, trabajo_decrip, agresion_agresor, agresion_frecuencia, objeto_utilizado, obligacion_familiar, proyeccion_madre, necesidad_inmediata, rela_famili_estado);
        this.salud_nna_id = salud_nna_id;
        this.problem_familiare = problem_familiare;
        this.problem_familiar_descrip = problem_familiar_descrip;
        this.problem_respiratorio = problem_respiratorio;
        this.problem_resp_descrip = problem_resp_descrip;
        this.problem_alergias = problem_alergias;
        this.problem_aler_descrip = problem_aler_descrip;
        this.problem_neurologico = problem_neurologico;
        this.problem_neuro_descrip = problem_neuro_descrip;
        this.problem_nerviosos = problem_nerviosos;
        this.problem_nervi_descrip = problem_nervi_descrip;
        this.salud_nna_estado = salud_nna_estado;
    }
    public int getSalud_nna_id() {
        return salud_nna_id;
    }

    public void setSalud_nna_id(int salud_nna_id) {
        this.salud_nna_id = salud_nna_id;
    }

    public String getProblem_familiare() {
        return problem_familiare;
    }

    public void setProblem_familiare(String problem_familiare) {
        this.problem_familiare = problem_familiare;
    }

    public String getProblem_familiar_descrip() {
        return problem_familiar_descrip;
    }

    public void setProblem_familiar_descrip(String problem_familiar_descrip) {
        this.problem_familiar_descrip = problem_familiar_descrip;
    }

    public boolean isProblem_respiratorio() {
        return problem_respiratorio;
    }

    public void setProblem_respiratorio(boolean problem_respiratorio) {
        this.problem_respiratorio = problem_respiratorio;
    }

    public String getProblem_resp_descrip() {
        return problem_resp_descrip;
    }

    public void setProblem_resp_descrip(String problem_resp_descrip) {
        this.problem_resp_descrip = problem_resp_descrip;
    }

    public boolean isProblem_alergias() {
        return problem_alergias;
    }

    public void setProblem_alergias(boolean problem_alergias) {
        this.problem_alergias = problem_alergias;
    }

    public String getProblem_aler_descrip() {
        return problem_aler_descrip;
    }

    public void setProblem_aler_descrip(String problem_aler_descrip) {
        this.problem_aler_descrip = problem_aler_descrip;
    }

    public boolean isProblem_neurologico() {
        return problem_neurologico;
    }

    public void setProblem_neurologico(boolean problem_neurologico) {
        this.problem_neurologico = problem_neurologico;
    }

    public String getProblem_neuro_descrip() {
        return problem_neuro_descrip;
    }

    public void setProblem_neuro_descrip(String problem_neuro_descrip) {
        this.problem_neuro_descrip = problem_neuro_descrip;
    }

    public boolean isProblem_nerviosos() {
        return problem_nerviosos;
    }

    public void setProblem_nerviosos(boolean problem_nerviosos) {
        this.problem_nerviosos = problem_nerviosos;
    }

    public String getProblem_nervi_descrip() {
        return problem_nervi_descrip;
    }

    public void setProblem_nervi_descrip(String problem_nervi_descrip) {
        this.problem_nervi_descrip = problem_nervi_descrip;
    }

    public boolean isSalud_nna_estado() {
        return salud_nna_estado;
    }

    public void setSalud_nna_estado(boolean salud_nna_estado) {
        this.salud_nna_estado = salud_nna_estado;
    }

    public Salud_nna(String problem_familiare, String problem_familiar_descrip, boolean problem_respiratorio, String problem_resp_descrip, boolean problem_alergias, String problem_aler_descrip, boolean problem_neurologico, String problem_neuro_descrip, boolean problem_nerviosos, String problem_nervi_descrip) {
        this.problem_familiare = problem_familiare;
        this.problem_familiar_descrip = problem_familiar_descrip;
        this.problem_respiratorio = problem_respiratorio;
        this.problem_resp_descrip = problem_resp_descrip;
        this.problem_alergias = problem_alergias;
        this.problem_aler_descrip = problem_aler_descrip;
        this.problem_neurologico = problem_neurologico;
        this.problem_neuro_descrip = problem_neuro_descrip;
        this.problem_nerviosos = problem_nerviosos;
        this.problem_nervi_descrip = problem_nervi_descrip;
    }

    public Salud_nna(int salud_nna_id, String problem_familiare, String problem_familiar_descrip, boolean problem_respiratorio, String problem_resp_descrip, boolean problem_alergias, String problem_aler_descrip, boolean problem_neurologico, String problem_neuro_descrip, boolean problem_nerviosos, String problem_nervi_descrip) {
        this.salud_nna_id = salud_nna_id;
        this.problem_familiare = problem_familiare;
        this.problem_familiar_descrip = problem_familiar_descrip;
        this.problem_respiratorio = problem_respiratorio;
        this.problem_resp_descrip = problem_resp_descrip;
        this.problem_alergias = problem_alergias;
        this.problem_aler_descrip = problem_aler_descrip;
        this.problem_neurologico = problem_neurologico;
        this.problem_neuro_descrip = problem_neuro_descrip;
        this.problem_nerviosos = problem_nerviosos;
        this.problem_nervi_descrip = problem_nervi_descrip;
    }

    public Salud_nna(String problem_familiare, String problem_familiar_descrip, boolean problem_respiratorio, String problem_resp_descrip, boolean problem_alergias, String problem_aler_descrip, boolean problem_neurologico, String problem_neuro_descrip, boolean problem_nerviosos, String problem_nervi_descrip, boolean salud_nna_estado) {
        this.problem_familiare = problem_familiare;
        this.problem_familiar_descrip = problem_familiar_descrip;
        this.problem_respiratorio = problem_respiratorio;
        this.problem_resp_descrip = problem_resp_descrip;
        this.problem_alergias = problem_alergias;
        this.problem_aler_descrip = problem_aler_descrip;
        this.problem_neurologico = problem_neurologico;
        this.problem_neuro_descrip = problem_neuro_descrip;
        this.problem_nerviosos = problem_nerviosos;
        this.problem_nervi_descrip = problem_nervi_descrip;
        this.salud_nna_estado = salud_nna_estado;
    }

    public Salud_nna() {
    }

}
