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
import marylove.conexion.Conexion;
import marylove.models.Motivo;

/**
 *
 * @author Asus
 */
public class MotivoDB extends Motivo {

    Conexion conectar = new Conexion();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    //variables locales para el metodo obteMotivId(String nombre)
    
    Motivo m;
    private ArrayList<Motivo> am= new ArrayList<>();

    public MotivoDB() throws SQLException {
        am=obtener_objeto();
    }

    public MotivoDB(String motivo_descripcion) {
        super(motivo_descripcion);
    }

    public MotivoDB(int motivo_id, String motivo_descripcion) {
        super(motivo_id, motivo_descripcion);
    }
    public ArrayList<Motivo> obtener_objeto() throws SQLException{
    
        sql="SELECT motivo_id, motivo_descripcion" +
       " FROM public.motivo;";
        ps=conectar.conectarBD().prepareStatement(sql);
        re=ps.executeQuery();
        conectar.cerrarConexion();
        while (re.next()) {
            
            int id =re.getInt(1);
            String des= re.getString(2);
            m=new Motivo(id, des);
            am.add(m);
        
        }
        return am;
    
    }
    public int obteMotivId(String nombre) throws SQLException {
       int res = 0;
       
       for (Motivo o: am ) {
           if (o.getMotivo_descripcion().equals(nombre)) {
               res=o.getMotivo_id();
           }
       }

        return res;
    }


}
