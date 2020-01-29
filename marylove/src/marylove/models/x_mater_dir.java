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
public class x_mater_dir {
private int mater_dir_id;
private int embarazo_id;
private int dir_codigo;
private int control_frecuencia;

    public int getMater_dir_id() {
        return mater_dir_id;
    }

    public void setMater_dir_id(int mater_dir_id) {
        this.mater_dir_id = mater_dir_id;
    }

    public int getEmbarazo_id() {
        return embarazo_id;
    }

    public void setEmbarazo_id(int embarazo_id) {
        this.embarazo_id = embarazo_id;
    }

    public int getDir_codigo() {
        return dir_codigo;
    }

    public void setDir_codigo(int dir_codigo) {
        this.dir_codigo = dir_codigo;
    }

    public int getControl_frecuencia() {
        return control_frecuencia;
    }

    public void setControl_frecuencia(int control_frecuencia) {
        this.control_frecuencia = control_frecuencia;
    }

    public x_mater_dir(int embarazo_id, int dir_codigo, int control_frecuencia) {
        this.embarazo_id = embarazo_id;
        this.dir_codigo = dir_codigo;
        this.control_frecuencia = control_frecuencia;
    }

    public x_mater_dir() {
    }

    public x_mater_dir(int mater_dir_id, int embarazo_id, int dir_codigo, int control_frecuencia) {
        this.mater_dir_id = mater_dir_id;
        this.embarazo_id = embarazo_id;
        this.dir_codigo = dir_codigo;
        this.control_frecuencia = control_frecuencia;
    }



}
