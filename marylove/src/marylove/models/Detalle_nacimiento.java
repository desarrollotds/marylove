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
public class Detalle_nacimiento {

    private int deta_codigo;
    private String complicaciones_parto;
    private String peso;
    private String talla;
    private boolean lloro_nac;
    private boolean necesito_oxigeno;
    private String síntomas_after_part;
    private int nacimiento_codigo;

    public Detalle_nacimiento() {
    }

    public Detalle_nacimiento(int deta_codigo, String complicaciones_parto, String peso, String talla, boolean lloro_nac, boolean necesito_oxigeno, String síntomas_after_part, int nacimiento_codigo) {
        this.deta_codigo = deta_codigo;
        this.complicaciones_parto = complicaciones_parto;
        this.peso = peso;
        this.talla = talla;
        this.lloro_nac = lloro_nac;
        this.necesito_oxigeno = necesito_oxigeno;
        this.síntomas_after_part = síntomas_after_part;
        this.nacimiento_codigo = nacimiento_codigo;
    }

    public int getDeta_codigo() {
        return deta_codigo;
    }

    public void setDeta_codigo(int deta_codigo) {
        this.deta_codigo = deta_codigo;
    }

    public String getComplicaciones_parto() {
        return complicaciones_parto;
    }

    public void setComplicaciones_parto(String complicaciones_parto) {
        this.complicaciones_parto = complicaciones_parto;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public boolean isLloro_nac() {
        return lloro_nac;
    }

    public void setLloro_nac(boolean lloro_nac) {
        this.lloro_nac = lloro_nac;
    }

    public boolean isNecesito_oxigeno() {
        return necesito_oxigeno;
    }

    public void setNecesito_oxigeno(boolean necesito_oxigeno) {
        this.necesito_oxigeno = necesito_oxigeno;
    }

    public String getSíntomas_after_part() {
        return síntomas_after_part;
    }

    public void setSíntomas_after_part(String síntomas_after_part) {
        this.síntomas_after_part = síntomas_after_part;
    }

    public int getNacimiento_codigo() {
        return nacimiento_codigo;
    }

    public void setNacimiento_codigo(int nacimiento_codigo) {
        this.nacimiento_codigo = nacimiento_codigo;
    }

}

