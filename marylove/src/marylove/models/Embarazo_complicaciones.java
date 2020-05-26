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
public class Embarazo_complicaciones extends x_embarazo_comp {
    private int emb_comp_id;
    private String emb_comp_descripcion;
    private int emb_comp_tipo;
 public Embarazo_complicaciones(int emb_comp_id, String emb_comp_descripcion, int emb_comp_tipo, int embarazo_id, int emp_comp_id, String mater_otro_descrip) {
        super(embarazo_id, emp_comp_id, mater_otro_descrip);
        this.emb_comp_id = emb_comp_id;
        this.emb_comp_descripcion = emb_comp_descripcion;
        this.emb_comp_tipo = emb_comp_tipo;
    }
    public Embarazo_complicaciones() {
    }

    public Embarazo_complicaciones(String emb_comp_descripcion, int emb_comp_tipo) {
        this.emb_comp_descripcion = emb_comp_descripcion;
        this.emb_comp_tipo = emb_comp_tipo;
    }

    public Embarazo_complicaciones(int emb_comp_id, String emb_comp_descripcion, int emb_comp_tipo) {
        this.emb_comp_id = emb_comp_id;
        this.emb_comp_descripcion = emb_comp_descripcion;
        this.emb_comp_tipo = emb_comp_tipo;
    }

    public int getEmb_comp_id() {
        return emb_comp_id;
    }

    public void setEmb_comp_id(int emb_comp_id) {
        this.emb_comp_id = emb_comp_id;
    }

    public String getEmb_comp_descripcion() {
        return emb_comp_descripcion;
    }

    public void setEmb_comp_descripcion(String emb_comp_descripcion) {
        this.emb_comp_descripcion = emb_comp_descripcion;
    }

    public int getEmb_comp_tipo() {
        return emb_comp_tipo;
    }

    public void setEmb_comp_tipo(int emb_comp_tipo) {
        this.emb_comp_tipo = emb_comp_tipo;
    }
    
}
