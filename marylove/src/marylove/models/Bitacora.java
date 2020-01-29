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
private Date bitacora_date;
private String bitacora_desc; 

    public Bitacora() {
    }

    public Bitacora(int bitacora_id, int personal_codigo, Date bitacora_date, String bitacora_desc) {
        this.bitacora_id = bitacora_id;
        this.personal_codigo = personal_codigo;
        this.bitacora_date = bitacora_date;
        this.bitacora_desc = bitacora_desc;
    }

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

    public String getBitacora_desc() {
        return bitacora_desc;
    }

    public void setBitacora_desc(String bitacora_desc) {
        this.bitacora_desc = bitacora_desc;
    }
  
}



