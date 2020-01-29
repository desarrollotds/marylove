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
public class x_motivo_llamada {
private int motivo_llamada_id;
private int llamada_codigo;
private int motivo_id;
private String motivollamada_descripcion;  

    public int getMotivo_llamada_id() {
        return motivo_llamada_id;
    }

    public void setMotivo_llamada_id(int motivo_llamada_id) {
        this.motivo_llamada_id = motivo_llamada_id;
    }

    public int getLlamada_codigo() {
        return llamada_codigo;
    }

    public void setLlamada_codigo(int llamada_codigo) {
        this.llamada_codigo = llamada_codigo;
    }

    public int getMotivo_id() {
        return motivo_id;
    }

    public void setMotivo_id(int motivo_id) {
        this.motivo_id = motivo_id;
    }

    public String getMotivollamada_descripcion() {
        return motivollamada_descripcion;
    }

    public void setMotivollamada_descripcion(String motivollamada_descripcion) {
        this.motivollamada_descripcion = motivollamada_descripcion;
    }

    public x_motivo_llamada(int motivo_llamada_id, int llamada_codigo, int motivo_id, String motivollamada_descripcion) {
        this.motivo_llamada_id = motivo_llamada_id;
        this.llamada_codigo = llamada_codigo;
        this.motivo_id = motivo_id;
        this.motivollamada_descripcion = motivollamada_descripcion;
    }

    public x_motivo_llamada(int llamada_codigo, int motivo_id, String motivollamada_descripcion) {
        this.llamada_codigo = llamada_codigo;
        this.motivo_id = motivo_id;
        this.motivollamada_descripcion = motivollamada_descripcion;
    }

    public x_motivo_llamada() {
    }


}
