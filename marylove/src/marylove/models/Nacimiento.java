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
public class Nacimiento {
private int nacimiento_codigo;
private int mes_alumbramiento;
private int dir_id;
private int parto_tipo;
private String observaciozes_parto;
private boolean anestesia;

    public Nacimiento() {
    }

    public Nacimiento(int nacimiento_codigo, int mes_alumbramiento, int dir_id, int parto_tipo, String observaciozes_parto, boolean anestesia) {
        this.nacimiento_codigo = nacimiento_codigo;
        this.mes_alumbramiento = mes_alumbramiento;
        this.dir_id = dir_id;
        this.parto_tipo = parto_tipo;
        this.observaciozes_parto = observaciozes_parto;
        this.anestesia = anestesia;
    }

    public int getNacimiento_codigo() {
        return nacimiento_codigo;
    }

    public void setNacimiento_codigo(int nacimiento_codigo) {
        this.nacimiento_codigo = nacimiento_codigo;
    }

    public int getMes_alumbramiento() {
        return mes_alumbramiento;
    }

    public void setMes_alumbramiento(int mes_alumbramiento) {
        this.mes_alumbramiento = mes_alumbramiento;
    }

    public int getDir_id() {
        return dir_id;
    }

    public void setDir_id(int dir_id) {
        this.dir_id = dir_id;
    }

    public int getParto_tipo() {
        return parto_tipo;
    }

    public void setParto_tipo(int parto_tipo) {
        this.parto_tipo = parto_tipo;
    }

    public String getObservaciozes_parto() {
        return observaciozes_parto;
    }

    public void setObservaciozes_parto(String observaciozes_parto) {
        this.observaciozes_parto = observaciozes_parto;
    }

    public boolean isAnestesia() {
        return anestesia;
    }

    public void setAnestesia(boolean anestesia) {
        this.anestesia = anestesia;
    }

}

