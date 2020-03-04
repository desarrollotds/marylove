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
public class Plan_Autonomia {
    private int autonomia_codigo;
    private int codigo_victima;
    private String fecha_elaboacion;
    private String proceso_evalua;
    private String autonomia_econo;
    private String estabilidad_salud;
    private String procesos_educativos;
    private String factor_riesgo;
    private String fecha_egreso;
    private int persona_codigo;

    public Plan_Autonomia() {
    }

    public Plan_Autonomia(int autonomia_codigo, int codigo_victima, String fecha_elaboacion, String proceso_evalua, String autonomia_econo, String estabilidad_salud, String procesos_educativos, String factor_riesgo, String fecha_egreso, int persona_codigo) {
        this.autonomia_codigo = autonomia_codigo;
        this.codigo_victima = codigo_victima;
        this.fecha_elaboacion = fecha_elaboacion;
        this.proceso_evalua = proceso_evalua;
        this.autonomia_econo = autonomia_econo;
        this.estabilidad_salud = estabilidad_salud;
        this.procesos_educativos = procesos_educativos;
        this.factor_riesgo = factor_riesgo;
        this.fecha_egreso = fecha_egreso;
        this.persona_codigo = persona_codigo;
    }

    public int getAutonomia_codigo() {
        return autonomia_codigo;
    }

    public void setAutonomia_codigo(int autonomia_codigo) {
        this.autonomia_codigo = autonomia_codigo;
    }

    public int getCodigo_victima() {
        return codigo_victima;
    }

    public void setCodigo_victima(int codigo_victima) {
        this.codigo_victima = codigo_victima;
    }

    public String getFecha_elaboacion() {
        return fecha_elaboacion;
    }

    public void setFecha_elaboacion(String fecha_elaboacion) {
        this.fecha_elaboacion = fecha_elaboacion;
    }

    public String getProceso_evalua() {
        return proceso_evalua;
    }

    public void setProceso_evalua(String proceso_evalua) {
        this.proceso_evalua = proceso_evalua;
    }

    public String getAutonomia_econo() {
        return autonomia_econo;
    }

    public void setAutonomia_econo(String autonomia_econo) {
        this.autonomia_econo = autonomia_econo;
    }

    public String getEstabilidad_salud() {
        return estabilidad_salud;
    }

    public void setEstabilidad_salud(String estabilidad_salud) {
        this.estabilidad_salud = estabilidad_salud;
    }

    public String getProcesos_educativos() {
        return procesos_educativos;
    }

    public void setProcesos_educativos(String procesos_educativos) {
        this.procesos_educativos = procesos_educativos;
    }

    public String getFactor_riesgo() {
        return factor_riesgo;
    }

    public void setFactor_riesgo(String factor_riesgo) {
        this.factor_riesgo = factor_riesgo;
    }

    public String getFecha_egreso() {
        return fecha_egreso;
    }

    public void setFecha_egreso(String fecha_egreso) {
        this.fecha_egreso = fecha_egreso;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }
    
    
}
