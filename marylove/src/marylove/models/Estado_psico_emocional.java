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
public class Estado_psico_emocional {

    private int estado_id;
    private String estado_nombre;
    private int estado_tipo;

    public Estado_psico_emocional() {
    }

    public Estado_psico_emocional(String estado_nombre, int estado_tipo) {
        this.estado_nombre = estado_nombre;
        this.estado_tipo = estado_tipo;
    }

    public Estado_psico_emocional(int estado_id, String estado_nombre, int estado_tipo) {
        this.estado_id = estado_id;
        this.estado_nombre = estado_nombre;
        this.estado_tipo = estado_tipo;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public String getEstado_nombre() {
        return estado_nombre;
    }

    public void setEstado_nombre(String estado_nombre) {
        this.estado_nombre = estado_nombre;
    }

    public int getEstado_tipo() {
        return estado_tipo;
    }

    public void setEstado_tipo(int estado_tipo) {
        this.estado_tipo = estado_tipo;
    }

}

