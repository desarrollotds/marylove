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
//nuevo modelo de historial clinico
public class HistorialClinico {
    private int hist_id;
    private int victima_codigo;
    private int psicologo_codigo;
    private String motivo_consulta;
    private String demanda;
    private String demanda_implicita;
    private String historial_violencia;
    private String biog_psico_perso;
    private byte[] genograma_famili;
    private int gfLong;
    private String prub_descripcion;
    private String apart_gene_conduct;
    private String conducta;
    private String func_cogni_sensorio;
    private String estado_consiencia;
    private String orientacion;
    private String memoria;
    private String atencion_concentracion;
    private String afectividad;
    private String funciones_ment_superior;
    private String diagnos_infor;
    private String diagnos_diferencial;
    private String personality_descrip;
    private String senala_tecnicas;
    private String recomendaciones;

    public HistorialClinico(int hist_id, int victima_codigo, int psicologo_codigo, String motivo_consulta, String demanda, String demanda_implicita, String historial_violencia, String biog_psico_perso, byte[] genograma_famili, int gfLong, String prub_descripcion, String apart_gene_conduct, String conducta, String func_cogni_sensorio, String estado_consiencia, String orientacion, String memoria, String atencion_concentracion, String afectividad, String funciones_ment_superior, String diagnos_infor, String diagnos_diferencial, String personality_descrip, String senala_tecnicas, String recomendaciones) {
        this.hist_id = hist_id;
        this.victima_codigo = victima_codigo;
        this.psicologo_codigo = psicologo_codigo;
        this.motivo_consulta = motivo_consulta;
        this.demanda = demanda;
        this.demanda_implicita = demanda_implicita;
        this.historial_violencia = historial_violencia;
        this.biog_psico_perso = biog_psico_perso;
        this.genograma_famili = genograma_famili;
        this.gfLong = gfLong;
        this.prub_descripcion = prub_descripcion;
        this.apart_gene_conduct = apart_gene_conduct;
        this.conducta = conducta;
        this.func_cogni_sensorio = func_cogni_sensorio;
        this.estado_consiencia = estado_consiencia;
        this.orientacion = orientacion;
        this.memoria = memoria;
        this.atencion_concentracion = atencion_concentracion;
        this.afectividad = afectividad;
        this.funciones_ment_superior = funciones_ment_superior;
        this.diagnos_infor = diagnos_infor;
        this.diagnos_diferencial = diagnos_diferencial;
        this.personality_descrip = personality_descrip;
        this.senala_tecnicas = senala_tecnicas;
        this.recomendaciones = recomendaciones;
    }


    public HistorialClinico() {
    }

    public int getHist_id() {
        return hist_id;
    }

    public void setHist_id(int hist_id) {
        this.hist_id = hist_id;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public String getDemanda() {
        return demanda;
    }

    public void setDemanda(String demanda) {
        this.demanda = demanda;
    }

    public String getDemanda_implicita() {
        return demanda_implicita;
    }

    public void setDemanda_implicita(String demanda_implicita) {
        this.demanda_implicita = demanda_implicita;
    }

    public String getHistorial_violencia() {
        return historial_violencia;
    }

    public void setHistorial_violencia(String historial_violencia) {
        this.historial_violencia = historial_violencia;
    }

    public String getBiog_psico_perso() {
        return biog_psico_perso;
    }

    public void setBiog_psico_perso(String biog_psico_perso) {
        this.biog_psico_perso = biog_psico_perso;
    }

    public byte[] getGenograma_famili() {
        return genograma_famili;
    }

    public void setGenograma_famili(byte[] genograma_famili) {
        this.genograma_famili = genograma_famili;
    }

    public int getGfLong() {
        return gfLong;
    }

    public void setGfLong(int gfLong) {
        this.gfLong = gfLong;
    }

    public String getPrub_descripcion() {
        return prub_descripcion;
    }

    public void setPrub_descripcion(String prub_descripcion) {
        this.prub_descripcion = prub_descripcion;
    }

    public String getApart_gene_conduct() {
        return apart_gene_conduct;
    }

    public void setApart_gene_conduct(String apart_gene_conduct) {
        this.apart_gene_conduct = apart_gene_conduct;
    }

    public String getConducta() {
        return conducta;
    }

    public void setConducta(String conducta) {
        this.conducta = conducta;
    }

    public String getFunc_cogni_sensorio() {
        return func_cogni_sensorio;
    }

    public void setFunc_cogni_sensorio(String func_cogni_sensorio) {
        this.func_cogni_sensorio = func_cogni_sensorio;
    }

    public String getEstado_consiencia() {
        return estado_consiencia;
    }

    public void setEstado_consiencia(String estado_consiencia) {
        this.estado_consiencia = estado_consiencia;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getAtencion_concentracion() {
        return atencion_concentracion;
    }

    public void setAtencion_concentracion(String atencion_concentracion) {
        this.atencion_concentracion = atencion_concentracion;
    }

    public String getAfectividad() {
        return afectividad;
    }

    public void setAfectividad(String afectividad) {
        this.afectividad = afectividad;
    }

    public String getFunciones_ment_superior() {
        return funciones_ment_superior;
    }

    public void setFunciones_ment_superior(String funciones_ment_superior) {
        this.funciones_ment_superior = funciones_ment_superior;
    }

    public String getDiagnos_infor() {
        return diagnos_infor;
    }

    public void setDiagnos_infor(String diagnos_infor) {
        this.diagnos_infor = diagnos_infor;
    }

    public String getDiagnos_diferencial() {
        return diagnos_diferencial;
    }

    public void setDiagnos_diferencial(String diagnos_diferencial) {
        this.diagnos_diferencial = diagnos_diferencial;
    }

    public String getPersonality_descrip() {
        return personality_descrip;
    }

    public void setPersonality_descrip(String personality_descrip) {
        this.personality_descrip = personality_descrip;
    }

    public String getSenala_tecnicas() {
        return senala_tecnicas;
    }

    public void setSenala_tecnicas(String senala_tecnicas) {
        this.senala_tecnicas = senala_tecnicas;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
    
        public int getPsicologo_codigo() {
        return psicologo_codigo;
    }

    public void setPsicologo_codigo(int psicologo_codigo) {
        this.psicologo_codigo = psicologo_codigo;
    }


}
