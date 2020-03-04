/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.sql.Time;



/**
 *
 * @author icrv9
 */
public class Cita{
    
    //ATRIBUTOS DE LA CLASE
private int cita_id;
private java.sql.Date	cita_fecha;
private Time 	cita_hora;
private int llamada_codigo;
private int psicologo_codigo;
private int victima_codigo;

    //VARIABLES DE CONEXIÓN
    

    public Cita() {
    }

    public Cita(int cita_id, java.sql.Date cita_fecha, Time cita_hora, int llamada_codigo, int psicologo_codigo, int victima_codigo) {
        this.cita_id = cita_id;
        this.cita_fecha = cita_fecha;
        this.cita_hora = cita_hora;
        this.llamada_codigo = llamada_codigo;
        this.psicologo_codigo = psicologo_codigo;
        this.victima_codigo = victima_codigo;
    }
    
    public int getCita_id() {
        return cita_id;
    }

    public void setCita_id(int cita_id) {
        this.cita_id = cita_id;
    }

    public java.sql.Date getCita_fecha() {
        return cita_fecha;
    }

    public void setCita_fecha(java.sql.Date cita_fecha) {
        this.cita_fecha = cita_fecha;
    }

    public Time getCita_hora() {
        return cita_hora;
    }

    public void setCita_hora(Time cita_hora) {
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

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }
    
}
