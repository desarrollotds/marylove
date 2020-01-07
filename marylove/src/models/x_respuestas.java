/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author icrv9
 */
public class x_respuestas extends  Preguntas{
   
    private int resp_id ;
    private int enc_codigo;
    private int pregunta_codigo;
    private String resp_descripcion;
	constraint fk_enc_xresp foreign key enc_codigo references encuesta (enc_codigo)
);


}
