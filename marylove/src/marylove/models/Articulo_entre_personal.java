/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author Usuario
 */
public class Articulo_entre_personal {
    private int artentper_id ;
    private int ingreso_id ;
    private String artentper_nombre ;
    private String artentper_estado ;

    public Articulo_entre_personal() {
    }

    public Articulo_entre_personal(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_estado) {
        this.artentper_id = artentper_id;
        this.ingreso_id = ingreso_id;
        this.artentper_nombre = artentper_nombre;
        this.artentper_estado = artentper_estado;
    }

    public int getArtentper_id() {
        return artentper_id;
    }

    public void setArtentper_id(int artentper_id) {
        this.artentper_id = artentper_id;
    }

    public int getIngreso_id() {
        return ingreso_id;
    }

    public void setIngreso_id(int ingreso_id) {
        this.ingreso_id = ingreso_id;
    }

    public String getArtentper_nombre() {
        return artentper_nombre;
    }

    public void setArtentper_nombre(String artentper_nombre) {
        this.artentper_nombre = artentper_nombre;
    }

    public String getArtentper_estado() {
        return artentper_estado;
    }

    public void setArtentper_estado(String artentper_estado) {
        this.artentper_estado = artentper_estado;
    }
    
    
}
