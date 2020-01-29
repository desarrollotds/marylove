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
public class Preguntas {
private int pregunta_codigo;
private String pregunta_descripcion;
private int pregunta_tipo_id; 

    public Preguntas() {
    }

    public Preguntas(int pregunta_codigo, String pregunta_descripcion, int pregunta_tipo_id) {
        this.pregunta_codigo = pregunta_codigo;
        this.pregunta_descripcion = pregunta_descripcion;
        this.pregunta_tipo_id = pregunta_tipo_id;
    }

    public int getPregunta_codigo() {
        return pregunta_codigo;
    }

    public void setPregunta_codigo(int pregunta_codigo) {
        this.pregunta_codigo = pregunta_codigo;
    }

    public String getPregunta_descripcion() {
        return pregunta_descripcion;
    }

    public void setPregunta_descripcion(String pregunta_descripcion) {
        this.pregunta_descripcion = pregunta_descripcion;
    }

    public int getPregunta_tipo_id() {
        return pregunta_tipo_id;
    }

    public void setPregunta_tipo_id(int pregunta_tipo_id) {
        this.pregunta_tipo_id = pregunta_tipo_id;
    }

}

