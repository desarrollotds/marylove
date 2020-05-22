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
public class x_embarazo_comp {

    private int x_emb_comp_id;
    private int embarazo_id;
    private int emp_comp_id;
    private String mater_otro_descrip;
    private boolean estado;

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

    public int getEmp_comp_id() {
        return emp_comp_id;
    }

    public void setEmp_comp_id(int emp_comp_id) {
        this.emp_comp_id = emp_comp_id;
    }

    public String getMater_otro_descrip() {
        return mater_otro_descrip;
    }

    public void setMater_otro_descrip(String mater_otro_descrip) {
        this.mater_otro_descrip = mater_otro_descrip;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public x_embarazo_comp() {
    }

    public x_embarazo_comp(int embarazo_id, int emp_comp_id, boolean estado) {
        this.embarazo_id = embarazo_id;
        this.emp_comp_id = emp_comp_id;
        this.estado = estado;
    }

    public x_embarazo_comp(int embarazo_id, int emp_comp_id, String mater_otro_descrip) {
        this.embarazo_id = embarazo_id;
        this.emp_comp_id = emp_comp_id;
        this.mater_otro_descrip = mater_otro_descrip;
    }

    public x_embarazo_comp(int x_emb_comp_id, int embarazo_id, int emp_comp_id, String mater_otro_descrip) {
        this.x_emb_comp_id = x_emb_comp_id;
        this.embarazo_id = embarazo_id;
        this.emp_comp_id = emp_comp_id;
        this.mater_otro_descrip = mater_otro_descrip;
    }

    public x_embarazo_comp(int embarazo_id, int emp_comp_id, String mater_otro_descrip, boolean estado) {
        this.embarazo_id = embarazo_id;
        this.emp_comp_id = emp_comp_id;
        this.mater_otro_descrip = mater_otro_descrip;
        this.estado = estado;
    }

}
