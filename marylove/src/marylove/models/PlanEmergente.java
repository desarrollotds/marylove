/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.util.Date;

/**
 *
 * @author Alumno
 */
public class PlanEmergente {
    private int emergente_id;
    private int victima_codigo;
    private String emergente_fecha;
    private int personal_codigo;

    public PlanEmergente() {
    }
//holiii

    public PlanEmergente(int emergente_id, int victima_codigo, String emergente_fecha, int personal_codigo) {
        this.emergente_id = emergente_id;
        this.victima_codigo = victima_codigo;
        this.emergente_fecha = emergente_fecha;
        this.personal_codigo = personal_codigo;
    }

    public PlanEmergente(int victima_codigo, String emergente_fecha, int personal_codigo) {
        this.victima_codigo = victima_codigo;
        this.emergente_fecha = emergente_fecha;
        this.personal_codigo = personal_codigo;
    }

    public int getEmergente_id() {
        return emergente_id;
    }

    public void setEmergente_id(int emergente_id) {
        this.emergente_id = emergente_id;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public String getEmergente_fecha() {
        return emergente_fecha;
    }

    public void setEmergente_fecha(String emergente_fecha) {
        this.emergente_fecha = emergente_fecha;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }

}
