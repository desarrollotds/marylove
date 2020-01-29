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
public class Cita{
    
private int cita_id;
private String	cita_fecha;
private String 	cita_hora;
private int llamada_codigo;
private int psicologo_codigo;

    public Cita() {
    }

    public Cita(int cita_id, String cita_fecha, String cita_hora, int llamada_codigo, int psicologo_codigo) {
        this.cita_id = cita_id;
        this.cita_fecha = cita_fecha;
        this.cita_hora = cita_hora;
        this.llamada_codigo = llamada_codigo;
        this.psicologo_codigo = psicologo_codigo;
    }

    public int getCita_id() {
        return cita_id;
    }

    public void setCita_id(int cita_id) {
        this.cita_id = cita_id;
    }

    public String getCita_fecha() {
        return cita_fecha;
    }

    public void setCita_fecha(String cita_fecha) {
        this.cita_fecha = cita_fecha;
    }

    public String getCita_hora() {
        return cita_hora;
    }

    public void setCita_hora(String cita_hora) {
        this.cita_hora = cita_hora;
    }

    public int getLlamada_codigo() {
        return llamada_codigo;
    }

    public void setLlamada_codigo(int llamada_codigo) {
        this.llamada_codigo = llamada_codigo;
    }

    public int getPsicologo_codigo() {
        return psicologo_codigo;
    }

    public void setPsicologo_codigo(int psicologo_codigo) {
        this.psicologo_codigo = psicologo_codigo;
    }



}
