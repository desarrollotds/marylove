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
public class Bitacora_procesos_terapeutas {
 private int bitProTer_codigo;
 private int hist_id;
 private Date bitProTer_fecha;
 private String bitProTer_situacion;
 private int  bitProTer_apreciacio_pers;

    public Bitacora_procesos_terapeutas() {
    }

    public Bitacora_procesos_terapeutas(int bitProTer_codigo, int hist_id, Date bitProTer_fecha, String bitProTer_situacion, int bitProTer_apreciacio_pers) {
        this.bitProTer_codigo = bitProTer_codigo;
        this.hist_id = hist_id;
        this.bitProTer_fecha = bitProTer_fecha;
        this.bitProTer_situacion = bitProTer_situacion;
        this.bitProTer_apreciacio_pers = bitProTer_apreciacio_pers;
    }

    public int getBitProTer_codigo() {
        return bitProTer_codigo;
    }

    public void setBitProTer_codigo(int bitProTer_codigo) {
        this.bitProTer_codigo = bitProTer_codigo;
    }

    public int getHist_id() {
        return hist_id;
    }

    public void setHist_id(int hist_id) {
        this.hist_id = hist_id;
    }

    public Date getBitProTer_fecha() {
        return bitProTer_fecha;
    }

    public void setBitProTer_fecha(Date bitProTer_fecha) {
        this.bitProTer_fecha = bitProTer_fecha;
    }

    public String getBitProTer_situacion() {
        return bitProTer_situacion;
    }

    public void setBitProTer_situacion(String bitProTer_situacion) {
        this.bitProTer_situacion = bitProTer_situacion;
    }

    public int getBitProTer_apreciacio_pers() {
        return bitProTer_apreciacio_pers;
    }

    public void setBitProTer_apreciacio_pers(int bitProTer_apreciacio_pers) {
        this.bitProTer_apreciacio_pers = bitProTer_apreciacio_pers;
    }
 
 
}
