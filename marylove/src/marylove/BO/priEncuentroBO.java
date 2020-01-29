/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//capa de negocio
package marylove.BO;

import java.sql.Connection;
import marylove.conexion.Conexion;
import marylove.dao.priEncuentroDao;
import marylove.models.Primer_encuentro;

/**
 *
 * @author LENOVO
 */
public class priEncuentroBO {
    private String mensaje="";
    private priEncuentroDao Dao= new priEncuentroDao();
    
    public String agregarDatos (Primer_encuentro pe){
        //Connection conn = Conexion.;
        try {
            
        } catch (Exception e) {
        mensaje=mensaje + " " +e.getMessage();
        }
        return mensaje;
    }
}
