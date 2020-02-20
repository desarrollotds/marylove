/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.util.Date;

/**
 *
 * @author usuario
 */
public class Egreso {
  private int egreso_codigo;
  private int victima_codigo;
  private Date egreso_fecha;
  private String egreso_situacion;
  //croquis bytea,
  private int dir_codigo;
  private int telefono;
  private int celular;
  private int personal_codigo;

    public Egreso(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, int dir_codigo, int telefono, int celular, int personal_codigo) {
        this.egreso_codigo = egreso_codigo;
        this.victima_codigo = victima_codigo;
        this.egreso_fecha = egreso_fecha;
        this.egreso_situacion = egreso_situacion;
        this.dir_codigo = dir_codigo;
        this.telefono = telefono;
        this.celular = celular;
        this.personal_codigo = personal_codigo;
    }

    public Egreso() {
    }
    

    public int getEgreso_codigo() {
        return egreso_codigo;
    }

    public void setEgreso_codigo(int egreso_codigo) {
        this.egreso_codigo = egreso_codigo;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public Date getEgreso_fecha() {
        return egreso_fecha;
    }

    public void setEgreso_fecha(Date egreso_fecha) {
        this.egreso_fecha = egreso_fecha;
    }

    public String getEgreso_situacion() {
        return egreso_situacion;
    }

    public void setEgreso_situacion(String egreso_situacion) {
        this.egreso_situacion = egreso_situacion;
    }

    public int getDir_codigo() {
        return dir_codigo;
    }

    public void setDir_codigo(int dir_codigo) {
        this.dir_codigo = dir_codigo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }
  
  
  
    
}
