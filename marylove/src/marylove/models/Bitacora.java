/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.util.Date;

/**
 *
 * @author icrv9
 */
public class Bitacora {
private int bitacora_id;
private int personal_codigo;
private int victima_codigo;
private Date bitacora_date;
private String bitacora_situacion; 
private String bitacora_accion_realizada;
private String bitacora_resultado;

    public Bitacora() {
    }

    public Bitacora(int bitacora_id, int personal_codigo, int victima_codigo, Date bitacora_date, String bitacora_situacion, String bitacora_accion_realizada, String bitacora_resultado) {
        this.bitacora_id = bitacora_id;
        this.personal_codigo = personal_codigo;
        this.victima_codigo = victima_codigo;
        this.bitacora_date = bitacora_date;
        this.bitacora_situacion = bitacora_situacion;
        this.bitacora_accion_realizada = bitacora_accion_realizada;
        this.bitacora_resultado = bitacora_resultado;
    }


    public String getBitacora_situacion() {
        return bitacora_situacion;
    }

    public void setBitacora_situacion(String bitacora_situacion) {
        this.bitacora_situacion = bitacora_situacion;
    }

    public String getBitacora_accion_realizada() {
        return bitacora_accion_realizada;
    }

    public void setBitacora_accion_realizada(String bitacora_accion_realizada) {
        this.bitacora_accion_realizada = bitacora_accion_realizada;
    }

    public String getBitacora_resultado() {
        return bitacora_resultado;
    }

    public void setBitacora_resultado(String bitacora_resultado) {
        this.bitacora_resultado = bitacora_resultado;
    }

    
//test
    public int getBitacora_id() {
        return bitacora_id;
    }

    public void setBitacora_id(int bitacora_id) {
        this.bitacora_id = bitacora_id;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }

    public Date getBitacora_date() {
        return bitacora_date;
    }

    public void setBitacora_date(Date bitacora_date) {
        this.bitacora_date = bitacora_date;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }
  
}



