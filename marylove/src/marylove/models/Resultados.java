/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author usuario
 */
public class Resultados {
    
    private String nombre;
    private String tipo;
    private String total;

    public Resultados(String nombre, String tipo, String total) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.total = total;
    }

    public Resultados() {
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

   
    
    
    
}
