/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author Asus
 */
public class Embarazo_complicaciones_json {
    private int emb_comp_id;
    private String descripcion;
    private boolean estado;

    public Embarazo_complicaciones_json() {
    }

    public Embarazo_complicaciones_json(String descripcion, boolean estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Embarazo_complicaciones_json(int emb_comp_id, String descripcion, boolean estado) {
        this.emb_comp_id = emb_comp_id;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getEmb_comp_id() {
        return emb_comp_id;
    }

    public void setEmb_comp_id(int emb_comp_id) {
        this.emb_comp_id = emb_comp_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
