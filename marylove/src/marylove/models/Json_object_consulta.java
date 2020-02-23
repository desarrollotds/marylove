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
public class Json_object_consulta {
    private int id;
    private String valor;

    public Json_object_consulta(int id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public Json_object_consulta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
