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
public class Caracteristicas_violencia {
    
private int carasteristica_id;
private String	caracteristicas_nombre;
private int carasteristicas_tipo;  

    public Caracteristicas_violencia() {
    }

    public Caracteristicas_violencia(String caracteristicas_nombre, int carasteristicas_tipo) {
        this.caracteristicas_nombre = caracteristicas_nombre;
        this.carasteristicas_tipo = carasteristicas_tipo;
    }

    public Caracteristicas_violencia(int carasteristica_id, String caracteristicas_nombre, int carasteristicas_tipo) {
        this.carasteristica_id = carasteristica_id;
        this.caracteristicas_nombre = caracteristicas_nombre;
        this.carasteristicas_tipo = carasteristicas_tipo;
    }



    public int getCarasteristica_id() {
        return carasteristica_id;
    }

    public void setCarasteristica_id(int carasteristica_id) {
        this.carasteristica_id = carasteristica_id;
    }

    public String getCaracteristicas_nombre() {
        return caracteristicas_nombre;
    }

    public void setCaracteristicas_nombre(String caracteristicas_nombre) {
        this.caracteristicas_nombre = caracteristicas_nombre;
    }

    public int getCarasteristicas_tipo() {
        return carasteristicas_tipo;
    }

    public void setCarasteristicas_tipo(int carasteristicas_tipo) {
        this.carasteristicas_tipo = carasteristicas_tipo;
    }


}

