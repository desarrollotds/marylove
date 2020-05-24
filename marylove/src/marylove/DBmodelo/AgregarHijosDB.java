/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import marylove.conexion.ConexionHi;
import marylove.models.Hijos;

/**
 *
 * @author AlexanderGuzman
 */
public class AgregarHijosDB extends Hijos{
    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    boolean ingreso = true;

    boolean verif = true;
    String sql = "";
    public AgregarHijosDB() {
    }
    
    public boolean agregarHijo(){
      sql="INSERT INTO public.persona( persona_cedula, persona_nombre, persona_apellido,"
                    + " persona_fecha_nac  "
                    
                    + ")	VALUES ( '" ;  
      sql="Insert victima_codigo,institucion_codigo"
              + ",hijo_anioescolar, hijo_estado_ingreso,"
              + "";
        return true;
    };

}
