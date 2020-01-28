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
public class Articulos_entregados {
    private int articulo_id ;
    private int ingreso_id ;
    private String articulo_descripcion ;
    private String articulo_observaciones ;

    public Articulos_entregados() {
    }

    public Articulos_entregados(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones) {
        this.articulo_id = articulo_id;
        this.ingreso_id = ingreso_id;
        this.articulo_descripcion = articulo_descripcion;
        this.articulo_observaciones = articulo_observaciones;
    }

    public int getArticulo_id() {
        return articulo_id;
    }

    public void setArticulo_id(int articulo_id) {
        this.articulo_id = articulo_id;
    }

    public int getIngreso_id() {
        return ingreso_id;
    }

    public void setIngreso_id(int ingreso_id) {
        this.ingreso_id = ingreso_id;
    }

    public String getArticulo_descripcion() {
        return articulo_descripcion;
    }

    public void setArticulo_descripcion(String articulo_descripcion) {
        this.articulo_descripcion = articulo_descripcion;
    }

    public String getArticulo_observaciones() {
        return articulo_observaciones;
    }

    public void setArticulo_observaciones(String articulo_observaciones) {
        this.articulo_observaciones = articulo_observaciones;
    }
    
    
}
