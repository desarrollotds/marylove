/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.dao;

import java.sql.PreparedStatement;
import marylove.conexion.Conexion;
import marylove.models.primer_encuentro;

/**
 *
 * @author LENOVO
 */
public class priEncuentroDao {
   private String mensaje="";
                              //conexion      //objeto
    public String agregarDatos (Conexion con, primer_encuentro pe){
        PreparedStatement pst = null;
        String sql= "insert into primer_encuentro (primer_codigo, victima_codigo, pstintcrisis_fecha,pstintcrisis_estado_emocional,pstintcrisis_nivel_riesgo,pstintcrisis_valoracionpreliminar,pstintcrisis_riesgo_suicida,pstintcrisis_puntosreelevantes,pstintcrisis_proceso_psicoterapeutico,pstintcrisis_asesoria,psicologo_codigo) \n" +
                "values (?,?,?,?,?,?,?,?,?,?,?)"; //continuar desde aqui 
        
        return mensaje;
    }
}
