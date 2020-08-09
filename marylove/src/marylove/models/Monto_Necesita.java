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
public class Monto_Necesita {
    private int monto_nesecita_codigo;
    private int plan_recursos_int;
    private String vivienda_monto;
    private String alimentacion_monto;
    private String educacion_monto;
    private String transporte_monto;
    private String montoneces_estado;
    
    public Monto_Necesita(int monto_nesecita_codigo, int plan_recursos_int, String vivienda_monto, String alimentacion_monto, String educacion_monto, String transporte_monto) {
        this.monto_nesecita_codigo = monto_nesecita_codigo;
        this.plan_recursos_int = plan_recursos_int;
        this.vivienda_monto = vivienda_monto;
        this.alimentacion_monto = alimentacion_monto;
        this.educacion_monto = educacion_monto;
        this.transporte_monto = transporte_monto;
    }

    public Monto_Necesita(int monto_nesecita_codigo, int plan_recursos_int, String vivienda_monto, String alimentacion_monto, String educacion_monto, String transporte_monto, String montoneces_estado) {
        this.monto_nesecita_codigo = monto_nesecita_codigo;
        this.plan_recursos_int = plan_recursos_int;
        this.vivienda_monto = vivienda_monto;
        this.alimentacion_monto = alimentacion_monto;
        this.educacion_monto = educacion_monto;
        this.transporte_monto = transporte_monto;
        this.montoneces_estado = montoneces_estado;
    }

    public String getMontoneces_estado() {
        return montoneces_estado;
    }

    public void setMontoneces_estado(String montoneces_estado) {
        this.montoneces_estado = montoneces_estado;
    }

    public Monto_Necesita() {
    }

    public int getMonto_nesecita_codigo() {
        return monto_nesecita_codigo;
    }

    public void setMonto_nesecita_codigo(int monto_nesecita_codigo) {
        this.monto_nesecita_codigo = monto_nesecita_codigo;
    }

    public int getPlan_recursos_int() {
        return plan_recursos_int;
    }

    public void setPlan_recursos_int(int plan_recursos_int) {
        this.plan_recursos_int = plan_recursos_int;
    }

    public String getVivienda_monto() {
        return vivienda_monto;
    }

    public void setVivienda_monto(String vivienda_monto) {
        this.vivienda_monto = vivienda_monto;
    }

    public String getAlimentacion_monto() {
        return alimentacion_monto;
    }

    public void setAlimentacion_monto(String alimentacion_monto) {
        this.alimentacion_monto = alimentacion_monto;
    }

    public String getEducacion_monto() {
        return educacion_monto;
    }

    public void setEducacion_monto(String educacion_monto) {
        this.educacion_monto = educacion_monto;
    }

    public String getTransporte_monto() {
        return transporte_monto;
    }

    public void setTransporte_monto(String transporte_monto) {
        this.transporte_monto = transporte_monto;
    }
    
}
