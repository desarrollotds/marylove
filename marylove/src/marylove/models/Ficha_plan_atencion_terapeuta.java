/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Ficha_plan_atencion_terapeuta {
    private int plan_AT_codigo;
    private int hist_id ;
    private Date plan_AT_fecha ;
    private String plan_AT_encuadre_terapeuta;
    private String plan_AT_obj_atencion; 
    private String plan_AT_derechos_victima;
    private String plan_AT_estrategias_rep ;
    private String plan_AT_compromisos_terap ;

    public Ficha_plan_atencion_terapeuta() {
    }

    public Ficha_plan_atencion_terapeuta(int plan_AT_codigo, int hist_id, Date plan_AT_fecha, String plan_AT_encuadre_terapeuta, String plan_AT_obj_atencion, String plan_AT_derechos_victima, String plan_AT_estrategias_rep, String plan_AT_compromisos_terap) {
        this.plan_AT_codigo = plan_AT_codigo;
        this.hist_id = hist_id;
        this.plan_AT_fecha = plan_AT_fecha;
        this.plan_AT_encuadre_terapeuta = plan_AT_encuadre_terapeuta;
        this.plan_AT_obj_atencion = plan_AT_obj_atencion;
        this.plan_AT_derechos_victima = plan_AT_derechos_victima;
        this.plan_AT_estrategias_rep = plan_AT_estrategias_rep;
        this.plan_AT_compromisos_terap = plan_AT_compromisos_terap;
    }

    public int getPlan_AT_codigo() {
        return plan_AT_codigo;
    }

    public void setPlan_AT_codigo(int plan_AT_codigo) {
        this.plan_AT_codigo = plan_AT_codigo;
    }

    public int getHist_id() {
        return hist_id;
    }

    public void setHist_id(int hist_id) {
        this.hist_id = hist_id;
    }

    public Date getPlan_AT_fecha() {
        return plan_AT_fecha;
    }

    public void setPlan_AT_fecha(Date plan_AT_fecha) {
        this.plan_AT_fecha = plan_AT_fecha;
    }

    public String getPlan_AT_encuadre_terapeuta() {
        return plan_AT_encuadre_terapeuta;
    }

    public void setPlan_AT_encuadre_terapeuta(String plan_AT_encuadre_terapeuta) {
        this.plan_AT_encuadre_terapeuta = plan_AT_encuadre_terapeuta;
    }

    public String getPlan_AT_obj_atencion() {
        return plan_AT_obj_atencion;
    }

    public void setPlan_AT_obj_atencion(String plan_AT_obj_atencion) {
        this.plan_AT_obj_atencion = plan_AT_obj_atencion;
    }

    public String getPlan_AT_derechos_victima() {
        return plan_AT_derechos_victima;
    }

    public void setPlan_AT_derechos_victima(String plan_AT_derechos_victima) {
        this.plan_AT_derechos_victima = plan_AT_derechos_victima;
    }

    public String getPlan_AT_estrategias_rep() {
        return plan_AT_estrategias_rep;
    }

    public void setPlan_AT_estrategias_rep(String plan_AT_estrategias_rep) {
        this.plan_AT_estrategias_rep = plan_AT_estrategias_rep;
    }

    public String getPlan_AT_compromisos_terap() {
        return plan_AT_compromisos_terap;
    }

    public void setPlan_AT_compromisos_terap(String plan_AT_compromisos_terap) {
        this.plan_AT_compromisos_terap = plan_AT_compromisos_terap;
    }
    
    
}
