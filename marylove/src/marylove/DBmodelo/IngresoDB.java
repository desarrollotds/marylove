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
import marylove.models.Ingreso;

/**
 *
 * @author usuario
 */
public class IngresoDB extends Ingreso {

    private Conexion conectar = new Conexion();

    public IngresoDB(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor);
    }

    public IngresoDB() {
    }

    public boolean IngresarIngreso() {
        String sql = "INSERT INTO public.ingreso"
                + "(victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor)"
                + "VALUES ("+getVictima_codigo()+","+getPersonal_codigo()+",'"+getAsignacion_dormitorio()+"','"+getReferidapor()+"')";
        //PreparedStatement ps= conectar.noQuery(sql);
        conectar.query(sql);
        return true;
    }
    public List<Ingreso> listaIngresos(){
         List<Ingreso> listaIngresos = new ArrayList<Ingreso>();
        String sql = "select* from ingreso";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Ingreso i = new Ingreso();
                i.setAsignacion_dormitorio(rs.getString("ingreso_id"));
                i.setVictima_codigo(rs.getInt("victima_codigo"));
                i.setPersonal_codigo(rs.getInt("persnal_codigo"));
                i.setAsignacion_dormitorio(rs.getString("asignacion_dormitorio"));
                i.setReferidapor(rs.getString("Referidapor"));
                listaIngresos.add(i);
            }
            rs.close();
            return listaIngresos;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public boolean actualizar() {
        String sql = "UPDATE public.ingreso SET "
                + "victima_codigo="+getVictima_codigo()+","
                + " personal_codigo="+getPersonal_codigo()+","
                + "asignacion_dormitorio='"+getAsignacion_dormitorio()+"',"
                + " Referidapor= '"+getReferidapor()+" "
                + " WHERE ingreso_id ="+getIngreso_id();
        
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

}
