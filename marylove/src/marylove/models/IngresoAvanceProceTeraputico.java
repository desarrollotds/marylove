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
public class IngresoAvanceProceTeraputico {
    private int avances_codigo;
    private int plan_at_codigo;
    private String avancesFecha;
    private String avances_situacion;
    private String avances_intervencion;

    public IngresoAvanceProceTeraputico() {
    }

    public IngresoAvanceProceTeraputico(int avances_codigo, int plan_at_codigo, String avancesFecha, String avances_situacion, String avances_intervencion) {
        this.avances_codigo = avances_codigo;
        this.plan_at_codigo = plan_at_codigo;
        this.avancesFecha = avancesFecha;
        this.avances_situacion = avances_situacion;
        this.avances_intervencion = avances_intervencion;
    }

    public int getAvances_codigo() {
        return avances_codigo;
    }

    public void setAvances_codigo(int avances_codigo) {
        this.avances_codigo = avances_codigo;
    }

    public int getPlan_at_codigo() {
        return plan_at_codigo;
    }

    public void setPlan_at_codigo(int plan_at_codigo) {
        this.plan_at_codigo = plan_at_codigo;
    }

    public String getAvancesFecha() {
        return avancesFecha;
    }

    public void setAvancesFecha(String avancesFecha) {
        this.avancesFecha = avancesFecha;
    }

    public String getAvances_situacion() {
        return avances_situacion;
    }

    public void setAvances_situacion(String avances_situacion) {
        this.avances_situacion = avances_situacion;
    }

    public String getAvances_intervencion() {
        return avances_intervencion;
    }

    public void setAvances_intervencion(String avances_intervencion) {
        this.avances_intervencion = avances_intervencion;
    }
    
    
}
