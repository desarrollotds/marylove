/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;
import marylove.conexion.ConexionHi;

/**
 *
 * @author LENOVO
 */
public class FichaR2DB extends x_respuestasDB{
    
    ConexionHi conecta = new ConexionHi();
    
    public void Consulta (){
        String sql = "select (persona_nombre||''||persona_apellido) as Nombre from persona where persona_cedula = '0106909526';";
        conecta.noQuery(sql);
    }

    public FichaR2DB() throws Exception{
    }

    public FichaR2DB(int enc_codigo, int pregunta_codigo, String resp_descripcion) {
        super(enc_codigo, pregunta_codigo, resp_descripcion);
    }

    public FichaR2DB(int resp_id, int enc_codigo, int pregunta_codigo, String resp_descripcion) {
        super(resp_id, enc_codigo, pregunta_codigo, resp_descripcion);
    }
    
}
