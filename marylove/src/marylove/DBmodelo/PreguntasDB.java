/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import marylove.conexion.ConexionHi;
import marylove.models.Preguntas;

/**
 *
 * @author Asus
 */

public class PreguntasDB extends Preguntas {
    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    int res=0;
    //variables gobales y estaticas
    private static ArrayList<Preguntas>preguntas=new ArrayList<>();
    Preguntas p;
    
    public ArrayList<Preguntas> obtener_preguntas() throws SQLException{
        
        sql="select * from preguntas;";
        re=conectar.query(sql);
        while (re.next()) {
            p=new Preguntas(re.getInt(1), re.getString(2), re.getInt(3));
            preguntas.add(p);
        }
        return preguntas;
    }
    public int obtener_id(String text, int tipo) {
        
        for (Preguntas o: preguntas) {
        
            if (text.equals(o.getPregunta_descripcion())) {
                if (tipo==o.getPregunta_tipo_id()) {
                    res= o.getPregunta_codigo();
                }
               
            } 
        }
        return res;
       
    }
    

    public PreguntasDB() throws SQLException {
        preguntas=obtener_preguntas();
    }
    
}
