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
public class Registro_diario {

    private int regisdi_id ;
    private Date regisdi_date ;
    private String regisdi_modalidad ;
    private String regisdi_desc ;
   private int  victima_codigo ;

    public Registro_diario() {
    }

    public Registro_diario(int regisdi_id, Date regisdi_date, String regisdi_modalidad, String regisdi_desc, int victima_codigo) {
        this.regisdi_id = regisdi_id;
        this.regisdi_date = regisdi_date;
        this.regisdi_modalidad = regisdi_modalidad;
        this.regisdi_desc = regisdi_desc;
        this.victima_codigo = victima_codigo;
    }

    public int getRegisdi_id() {
        return regisdi_id;
    }

    public void setRegisdi_id(int regisdi_id) {
        this.regisdi_id = regisdi_id;
    }

    public Date getRegisdi_date() {
        return regisdi_date;
    }

    public void setRegisdi_date(Date regisdi_date) {
        this.regisdi_date = regisdi_date;
    }

    public String getRegisdi_modalidad() {
        return regisdi_modalidad;
    }

    public void setRegisdi_modalidad(String regisdi_modalidad) {
        this.regisdi_modalidad = regisdi_modalidad;
    }

    public String getRegisdi_desc() {
        return regisdi_desc;
    }

    public void setRegisdi_desc(String regisdi_desc) {
        this.regisdi_desc = regisdi_desc;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }
   
}

