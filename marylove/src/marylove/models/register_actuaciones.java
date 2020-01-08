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
public class register_actuaciones {

    private int reg_id;
    private int legal_id;
    private String notificaciones_diligencias;
    private Date fecha_limite;
    private String observaciones;

    public register_actuaciones() {
    }

    public register_actuaciones(int reg_id, int legal_id, String notificaciones_diligencias, Date fecha_limite, String observaciones) {
        this.reg_id = reg_id;
        this.legal_id = legal_id;
        this.notificaciones_diligencias = notificaciones_diligencias;
        this.fecha_limite = fecha_limite;
        this.observaciones = observaciones;
    }

    public int getReg_id() {
        return reg_id;
    }

    public void setReg_id(int reg_id) {
        this.reg_id = reg_id;
    }

    public int getLegal_id() {
        return legal_id;
    }

    public void setLegal_id(int legal_id) {
        this.legal_id = legal_id;
    }

    public String getNotificaciones_diligencias() {
        return notificaciones_diligencias;
    }

    public void setNotificaciones_diligencias(String notificaciones_diligencias) {
        this.notificaciones_diligencias = notificaciones_diligencias;
    }

    public Date getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
