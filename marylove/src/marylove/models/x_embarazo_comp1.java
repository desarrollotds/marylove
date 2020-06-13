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
public class x_embarazo_comp1 {
    private int x_emb_comp_id;
    private int embarazo_id;
    private boolean estado;
    private String json_complicaciones;

    public x_embarazo_comp1() {
    }

    public x_embarazo_comp1(boolean estado, String json_complicaciones) {
        this.estado = estado;
        this.json_complicaciones = json_complicaciones;
    }

    public x_embarazo_comp1(int embarazo_id, boolean estado, String json_complicaciones) {
        this.embarazo_id = embarazo_id;
        this.estado = estado;
        this.json_complicaciones = json_complicaciones;
    }

    public x_embarazo_comp1(int x_emb_comp_id, int embarazo_id, boolean estado, String json_complicaciones) {
        this.x_emb_comp_id = x_emb_comp_id;
        this.embarazo_id = embarazo_id;
        this.estado = estado;
        this.json_complicaciones = json_complicaciones;
    }

    public int getX_emb_comp_id() {
        return x_emb_comp_id;
    }

    public void setX_emb_comp_id(int x_emb_comp_id) {
        this.x_emb_comp_id = x_emb_comp_id;
    }

    public int getEmbarazo_id() {
        return embarazo_id;
    }

    public void setEmbarazo_id(int embarazo_id) {
        this.embarazo_id = embarazo_id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getJson_complicaciones() {
        return json_complicaciones;
    }

    public void setJson_complicaciones(String json_complicaciones) {
        this.json_complicaciones = json_complicaciones;
    }
    
}
