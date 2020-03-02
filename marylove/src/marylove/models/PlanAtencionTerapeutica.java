/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class PlanAtencionTerapeutica extends HistorialClinico {
    private String plan_at_codigo;
    private Date plan_at_fecha;
    private String plan_at_encuadre_terapeuta;
    private String plan_at_obj_atencion;
    private String plan_at_derechos_victima;
    private String plan_at_estrategias_rep;
    private String plan_at_compromisos_terep;

    public PlanAtencionTerapeutica() {
    }

    public PlanAtencionTerapeutica(String plan_at_codigo, Date plan_at_fecha, String plan_at_encuadre_terapeuta, String plan_at_obj_atencion, String plan_at_derechos_victima, String plan_at_estrategias_rep, String plan_at_compromisos_terep, int hist_id, int victima_codigo, int psicologo_codigo, String motivo_consulta, String demanda, String demanda_implicita, String historial_violencia, String biog_psico_perso, byte[] genograma_famili, int gfLong, String prub_descripcion, String apart_gene_conduct, String conducta, String func_cogni_sensorio, String estado_consiencia, String orientacion, String memoria, String atencion_concentracion, String afectividad, String funciones_ment_superior, String diagnos_infor, String diagnos_diferencial, String personality_descrip, String senala_tecnicas, String recomendaciones) {
        super(hist_id, victima_codigo, psicologo_codigo, motivo_consulta, demanda, demanda_implicita, historial_violencia, biog_psico_perso, genograma_famili, gfLong, prub_descripcion, apart_gene_conduct, conducta, func_cogni_sensorio, estado_consiencia, orientacion, memoria, atencion_concentracion, afectividad, funciones_ment_superior, diagnos_infor, diagnos_diferencial, personality_descrip, senala_tecnicas, recomendaciones);
        this.plan_at_codigo = plan_at_codigo;
        this.plan_at_fecha = plan_at_fecha;
        this.plan_at_encuadre_terapeuta = plan_at_encuadre_terapeuta;
        this.plan_at_obj_atencion = plan_at_obj_atencion;
        this.plan_at_derechos_victima = plan_at_derechos_victima;
        this.plan_at_estrategias_rep = plan_at_estrategias_rep;
        this.plan_at_compromisos_terep = plan_at_compromisos_terep;
    }

    public PlanAtencionTerapeutica(String plan_at_codigo, Date plan_at_fecha, String plan_at_encuadre_terapeuta, String plan_at_obj_atencion, String plan_at_derechos_victima, String plan_at_estrategias_rep, String plan_at_compromisos_terep) {
        this.plan_at_codigo = plan_at_codigo;
        this.plan_at_fecha = plan_at_fecha;
        this.plan_at_encuadre_terapeuta = plan_at_encuadre_terapeuta;
        this.plan_at_obj_atencion = plan_at_obj_atencion;
        this.plan_at_derechos_victima = plan_at_derechos_victima;
        this.plan_at_estrategias_rep = plan_at_estrategias_rep;
        this.plan_at_compromisos_terep = plan_at_compromisos_terep;
    }
    public PlanAtencionTerapeutica(String plan_at_codigo) {
        this.plan_at_codigo = plan_at_codigo;
    }
    

    public String getPlan_at_codigo() {
        return plan_at_codigo;
        
    }

    public void setPlan_at_codigo(String plan_at_codigo) {
        this.plan_at_codigo = plan_at_codigo;
    }

    public Date getPlan_at_fecha() {
        return plan_at_fecha;
    }

    public void setPlan_at_fecha(Date plan_at_fecha) {
        this.plan_at_fecha = plan_at_fecha;
    }

    public String getPlan_at_derechos_victima() {
        return plan_at_derechos_victima;
    }

    public void setPlan_at_derechos_victima(String plan_at_derechos_victima) {
        this.plan_at_derechos_victima = plan_at_derechos_victima;
    }

    public String getPlan_at_estrategias_rep() {
        return plan_at_estrategias_rep;
    }

    public void setPlan_at_estrategias_rep(String plan_at_estrategias_rep) {
        this.plan_at_estrategias_rep = plan_at_estrategias_rep;
    }

    public String getPlan_at_compromisos_terep() {
        return plan_at_compromisos_terep;
    }

    public void setPlan_at_compromisos_terep(String plan_at_compromisos_terep) {
        this.plan_at_compromisos_terep = plan_at_compromisos_terep;
    }

    public String getPlan_at_encuadre_terapeuta() {
        return plan_at_encuadre_terapeuta;
    }

    public void setPlan_at_encuadre_terapeuta(String plan_at_encuadre_terapeuta) {
        this.plan_at_encuadre_terapeuta = plan_at_encuadre_terapeuta;
    }

    public String getPlan_at_obj_atencion() {
        return plan_at_obj_atencion;
    }

    public void setPlan_at_obj_atencion(String plan_at_obj_atencion) {
        this.plan_at_obj_atencion = plan_at_obj_atencion;
    }
    
    
    
    
    
}
