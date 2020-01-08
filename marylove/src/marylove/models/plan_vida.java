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
public class plan_vida {
    private int plan_id ;
    private Date fecha_elaboracion ;
    private Date fecha_evaluacion ;
    private int victima_codigo ;
    private String como_siente ;
    private String como_ve ;
    private String como_gust_ver ;
    private String vision_equipo ;
    private String objetivo_general ;

    public plan_vida() {
    }

    public plan_vida(int plan_id, Date fecha_elaboracion, Date fecha_evaluacion, int victima_codigo, String como_siente, String como_ve, String como_gust_ver, String vision_equipo, String objetivo_general) {
        this.plan_id = plan_id;
        this.fecha_elaboracion = fecha_elaboracion;
        this.fecha_evaluacion = fecha_evaluacion;
        this.victima_codigo = victima_codigo;
        this.como_siente = como_siente;
        this.como_ve = como_ve;
        this.como_gust_ver = como_gust_ver;
        this.vision_equipo = vision_equipo;
        this.objetivo_general = objetivo_general;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public Date getFecha_elaboracion() {
        return fecha_elaboracion;
    }

    public void setFecha_elaboracion(Date fecha_elaboracion) {
        this.fecha_elaboracion = fecha_elaboracion;
    }

    public Date getFecha_evaluacion() {
        return fecha_evaluacion;
    }

    public void setFecha_evaluacion(Date fecha_evaluacion) {
        this.fecha_evaluacion = fecha_evaluacion;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public String getComo_siente() {
        return como_siente;
    }

    public void setComo_siente(String como_siente) {
        this.como_siente = como_siente;
    }

    public String getComo_ve() {
        return como_ve;
    }

    public void setComo_ve(String como_ve) {
        this.como_ve = como_ve;
    }

    public String getComo_gust_ver() {
        return como_gust_ver;
    }

    public void setComo_gust_ver(String como_gust_ver) {
        this.como_gust_ver = como_gust_ver;
    }

    public String getVision_equipo() {
        return vision_equipo;
    }

    public void setVision_equipo(String vision_equipo) {
        this.vision_equipo = vision_equipo;
    }

    public String getObjetivo_general() {
        return objetivo_general;
    }

    public void setObjetivo_general(String objetivo_general) {
        this.objetivo_general = objetivo_general;
    }
    
    
}
