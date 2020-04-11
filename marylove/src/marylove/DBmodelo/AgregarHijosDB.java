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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Hijos;

/**
 *
 * @author AlexanderGuzman
 */
public class AgregarHijosDB extends Hijos{
    Conexion conectar = new Conexion();
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
    
        
    public List<Hijos> listarHij(int cod) throws SQLException {
        List<Hijos> listarHij = new ArrayList<Hijos>();
        String sql = "select per.persona_codigo,per.persona_nombre, per.persona_apellido, per.persona_fecha_nac\n" +
                     "from persona per inner join hijos h\n" +
                     "on per.persona_codigo = h.persona_codigo\n" +
                     "where per.persona_codigo = '"+ cod+"';";
//        sql += "order by 1";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Hijos p = new Hijos();
//                p.setArticulo_descripcion(rs.getInt("ruc"));
                p.setHijo_codigo(rs.getInt("definicion_id"));
                //evaluacion_id
                p.setPersona_nombre(rs.getString("objetivosespecificos"));
                p.setPersona_apellido(rs.getString("actividad"));
                p.setPersona_fecha_nac(rs.getDate("tiempo"));
                //Falta edad no hay atributo
                //Falta parentesco no hay atributo
                listarHij.add(p);
            }
            rs.close();
            return listarHij;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
