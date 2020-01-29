/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author Danny
 */
public class x_llamada_estado_psico {
    
    private int llamadaestado_id;
    private int llamada_codigo;
    private int estado_id;
    private int llamadaestado_descrip;

    public x_llamada_estado_psico(int llamadaestado_id, int llamada_codigo, int estado_id, int llamadaestado_descrip) {
        this.llamadaestado_id = llamadaestado_id;
        this.llamada_codigo = llamada_codigo;
        this.estado_id = estado_id;
        this.llamadaestado_descrip = llamadaestado_descrip;
    }

    public x_llamada_estado_psico(int llamada_codigo, int estado_id, int llamadaestado_descrip) {
        this.llamada_codigo = llamada_codigo;
        this.estado_id = estado_id;
        this.llamadaestado_descrip = llamadaestado_descrip;
    }

    public int getLlamadaestado_id() {
        return llamadaestado_id;
    }

    public void setLlamadaestado_id(int llamadaestado_id) {
        this.llamadaestado_id = llamadaestado_id;
    }

    public int getLlamada_codigo() {
        return llamada_codigo;
    }

    public void setLlamada_codigo(int llamada_codigo) {
        this.llamada_codigo = llamada_codigo;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public int getLlamadaestado_descrip() {
        return llamadaestado_descrip;
    }

    public void setLlamadaestado_descrip(int llamadaestado_descrip) {
        this.llamadaestado_descrip = llamadaestado_descrip;
    }

    public x_llamada_estado_psico() {
    }
    
}
