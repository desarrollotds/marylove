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
public class x_respuestas extends Preguntas{
   
    private int resp_id ;
    private int enc_codigo;
    private int pregunta_codigo;
    private String resp_descripcion;

    public x_respuestas() {
    }

    public x_respuestas(int resp_id, int enc_codigo, int pregunta_codigo, String resp_descripcion) {
        this.resp_id = resp_id;
        this.enc_codigo = enc_codigo;
        this.pregunta_codigo = pregunta_codigo;
        this.resp_descripcion = resp_descripcion;
    }

    public int getResp_id() {
        return resp_id;
    }

    public void setResp_id(int resp_id) {
        this.resp_id = resp_id;
    }

    public int getEnc_codigo() {
        return enc_codigo;
    }

    public void setEnc_codigo(int enc_codigo) {
        this.enc_codigo = enc_codigo;
    }

    public int getPregunta_codigo() {
        return pregunta_codigo;
    }

    public void setPregunta_codigo(int pregunta_codigo) {
        this.pregunta_codigo = pregunta_codigo;
    }

    public String getResp_descripcion() {
        return resp_descripcion;
    }

    public void setResp_descripcion(String resp_descripcion) {
        this.resp_descripcion = resp_descripcion;
    }
   
    
}
