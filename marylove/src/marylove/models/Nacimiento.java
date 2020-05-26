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
public class Nacimiento extends Detalle_nacimiento{
private int nacimiento_codigo;
private int mes_alumbramiento;
private String lugar_nacimiento;
private String parto_tipo;
private String observaciozes_parto;
private boolean anestesia;
private boolean nacimiento_estado;

    public Nacimiento()  {
    }

    public Nacimiento( int mes_alumbramiento, String lugar_nacimiento, String parto_tipo, String observaciozes_parto, boolean anestesia, boolean nacimiento_estado, int deta_codigo, String complicaciones_parto, String peso, String talla, boolean lloro_nac, boolean necesito_oxigeno, String sintomas_after_part, int nacimiento_codigo, boolean detalle_nac_estado) {
        super(deta_codigo, complicaciones_parto, peso, talla, lloro_nac, necesito_oxigeno, sintomas_after_part, nacimiento_codigo, detalle_nac_estado);
    
        this.mes_alumbramiento = mes_alumbramiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.parto_tipo = parto_tipo;
        this.observaciozes_parto = observaciozes_parto;
        this.anestesia = anestesia;
        this.nacimiento_estado = nacimiento_estado;
    }


    public Nacimiento(int mes_alumbramiento, String lugar_nacimiento, String parto_tipo, String observaciozes_parto, boolean anestesia, boolean nacimiento_estado) {
        this.mes_alumbramiento = mes_alumbramiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.parto_tipo = parto_tipo;
        this.observaciozes_parto = observaciozes_parto;
        this.anestesia = anestesia;
        this.nacimiento_estado = nacimiento_estado;
    }

    public Nacimiento(int mes_alumbramiento, String lugar_nacimiento, String parto_tipo, String observaciozes_parto, boolean anestesia) {
        this.mes_alumbramiento = mes_alumbramiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.parto_tipo = parto_tipo;
        this.observaciozes_parto = observaciozes_parto;
        this.anestesia = anestesia;
    }

    public Nacimiento(int nacimiento_codigo, int mes_alumbramiento, String lugar_nacimiento, String parto_tipo, String observaciozes_parto, boolean anestesia) {
        this.nacimiento_codigo = nacimiento_codigo;
        this.mes_alumbramiento = mes_alumbramiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.parto_tipo = parto_tipo;
        this.observaciozes_parto = observaciozes_parto;
        this.anestesia = anestesia;
    }

    public int getNacimiento_codigo() {
        return nacimiento_codigo;
    }

    public void setNacimiento_codigo(int nacimiento_codigo) {
        this.nacimiento_codigo = nacimiento_codigo;
    }

    public int getMes_alumbramiento() {
        return mes_alumbramiento;
    }

    public void setMes_alumbramiento(int mes_alumbramiento) {
        this.mes_alumbramiento = mes_alumbramiento;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getParto_tipo() {
        return parto_tipo;
    }

    public void setParto_tipo(String parto_tipo) {
        this.parto_tipo = parto_tipo;
    }

   

    public String getObservaciozes_parto() {
        return observaciozes_parto;
    }

    public void setObservaciozes_parto(String observaciozes_parto) {
        this.observaciozes_parto = observaciozes_parto;
    }

    public boolean isAnestesia() {
        return anestesia;
    }

    public void setAnestesia(boolean anestesia) {
        this.anestesia = anestesia;
    }

    public boolean isNacimiento_estado() {
        return nacimiento_estado;
    }

    public void setNacimiento_estado(boolean nacimiento_estado) {
        this.nacimiento_estado = nacimiento_estado;
    }

}

