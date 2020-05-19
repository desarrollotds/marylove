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
public class Desarrollo {

    private int desarrollo_id;
    private String des_motor_grueso;
    private String des_motor_fino;
    private String movimientos;
    private String des_psico_social;
    private String des_cognitivo;
    private String des_fisico;
    private String caridad_lenguajes;
    private String claridad_lenguajes_descrip;
    private boolean desarrollo_estado;
    
    public Desarrollo() {
    }

    public Desarrollo(String des_motor_grueso, String des_motor_fino, String movimientos, String des_psico_social, String des_cognitivo, String des_fisico, String caridad_lenguajes, String claridad_lenguajes_descrip) {
        this.des_motor_grueso = des_motor_grueso;
        this.des_motor_fino = des_motor_fino;
        this.movimientos = movimientos;
        this.des_psico_social = des_psico_social;
        this.des_cognitivo = des_cognitivo;
        this.des_fisico = des_fisico;
        this.caridad_lenguajes = caridad_lenguajes;
        this.claridad_lenguajes_descrip = claridad_lenguajes_descrip;
    }

    public Desarrollo(int desarrollo_id, String des_motor_grueso, String des_motor_fino, String movimientos, String des_psico_social, String des_cognitivo, String des_fisico, String caridad_lenguajes, String claridad_lenguajes_descrip) {
        this.desarrollo_id = desarrollo_id;
        this.des_motor_grueso = des_motor_grueso;
        this.des_motor_fino = des_motor_fino;
        this.movimientos = movimientos;
        this.des_psico_social = des_psico_social;
        this.des_cognitivo = des_cognitivo;
        this.des_fisico = des_fisico;
        this.caridad_lenguajes = caridad_lenguajes;
        this.claridad_lenguajes_descrip = claridad_lenguajes_descrip;
    }

    public Desarrollo(String des_motor_grueso, String des_motor_fino, String movimientos, String des_psico_social, String des_cognitivo, String des_fisico, String caridad_lenguajes, String claridad_lenguajes_descrip, boolean desarrollo_estado) {
        this.des_motor_grueso = des_motor_grueso;
        this.des_motor_fino = des_motor_fino;
        this.movimientos = movimientos;
        this.des_psico_social = des_psico_social;
        this.des_cognitivo = des_cognitivo;
        this.des_fisico = des_fisico;
        this.caridad_lenguajes = caridad_lenguajes;
        this.claridad_lenguajes_descrip = claridad_lenguajes_descrip;
        this.desarrollo_estado = desarrollo_estado;
    }
    

    public int getDesarrollo_id() {
        return desarrollo_id;
    }

    public void setDesarrollo_id(int desarrollo_id) {
        this.desarrollo_id = desarrollo_id;
    }

    public String getDes_motor_grueso() {
        return des_motor_grueso;
    }

    public void setDes_motor_grueso(String des_motor_grueso) {
        this.des_motor_grueso = des_motor_grueso;
    }

    public String getDes_motor_fino() {
        return des_motor_fino;
    }

    public void setDes_motor_fino(String des_motor_fino) {
        this.des_motor_fino = des_motor_fino;
    }

    public String getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(String movimientos) {
        this.movimientos = movimientos;
    }

    public String getDes_psico_social() {
        return des_psico_social;
    }

    public void setDes_psico_social(String des_psico_social) {
        this.des_psico_social = des_psico_social;
    }

    public String getDes_cognitivo() {
        return des_cognitivo;
    }

    public void setDes_cognitivo(String des_cognitivo) {
        this.des_cognitivo = des_cognitivo;
    }

    public String getDes_fisico() {
        return des_fisico;
    }

    public void setDes_fisico(String des_fisico) {
        this.des_fisico = des_fisico;
    }

    public String getCaridad_lenguajes() {
        return caridad_lenguajes;
    }

    public void setCaridad_lenguajes(String caridad_lenguajes) {
        this.caridad_lenguajes = caridad_lenguajes;
    }

    public String getClaridad_lenguajes_descrip() {
        return claridad_lenguajes_descrip;
    }

    public void setClaridad_lenguajes_descrip(String claridad_lenguajes_descrip) {
        this.claridad_lenguajes_descrip = claridad_lenguajes_descrip;
    }

    public boolean isDesarrollo_estado() {
        return desarrollo_estado;
    }

    public void setDesarrollo_estado(boolean desarrollo_estado) {
        this.desarrollo_estado = desarrollo_estado;
    }

}

