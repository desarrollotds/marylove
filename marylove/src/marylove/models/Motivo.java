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
public class Motivo {

    private int motivo_id;
    private String motivo_descripcion;

    public Motivo() {
    }

    public Motivo(int motivo_id, String motivo_descripcion) {
        this.motivo_id = motivo_id;
        this.motivo_descripcion = motivo_descripcion;
    }

    public int getMotivo_id() {
        return motivo_id;
    }

    public void setMotivo_id(int motivo_id) {
        this.motivo_id = motivo_id;
    }

    public String getMotivo_descripcion() {
        return motivo_descripcion;
    }

    public void setMotivo_descripcion(String motivo_descripcion) {
        this.motivo_descripcion = motivo_descripcion;
    }

}

