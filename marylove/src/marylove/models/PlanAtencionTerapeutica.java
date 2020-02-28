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
public class PlanAtencionTerapeutica  {
    private String plan_at_codigo;
    private Date plan_at_fecha;
    private String plan_at_derechos_victima;
    private String plan_at_estrategias_rep;
    private String plan_at_compromisos_terep;

    public PlanAtencionTerapeutica() {
    }

    
    public PlanAtencionTerapeutica(String plan_at_codigo, Date plan_at_fecha, String plan_at_derechos_victima, String plan_at_estrategias_rep, String plan_at_compromisos_terep) {
        this.plan_at_codigo = plan_at_codigo;
        this.plan_at_fecha = plan_at_fecha;
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
    
    
    
    
    
}
