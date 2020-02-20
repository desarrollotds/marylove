/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.vista.DBmodelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Egreso;
import marylove.models.Ingreso;

/**
 *
 * @author usuario
 */
public class EgresoDB extends Egreso {

    Conexion conectar = new Conexion();

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, int dir_codigo, int telefono, int celular, int personal_codigo) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, dir_codigo, telefono, celular, personal_codigo);
    }

    public EgresoDB() {

    }

    public boolean IngresarIngreso() {
        String sql = "INSERT INTO public.egreso"
                + "(victima_codigo, egreso_fecha, egreso_situacion,croquis, dir_codigo, telefono, celular, personal_codigo)"
                + "VALUES ("+getVictima_codigo()+","+getEgreso_fecha()+",'"+getEgreso_situacion()+"',"+getDir_codigo()+","
                + getTelefono()+","+getCelular()+","+getPersonal_codigo()+")";
        //PreparedStatement ps= conectar.noQuery(sql);
        try {
            conectar.query(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(IngresoDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Egreso> listaEgresos() {
        List<Egreso> listaEgresos = new ArrayList<Egreso>();
        String sql = "select* from egreso";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Egreso e = new Egreso();
               e.setVictima_codigo(rs.getInt("victima_codigo"));
               e.setEgreso_fecha(rs.getDate("egreso_fecha"));
               e.setEgreso_situacion(rs.getString("egreso_situacion"));
               e.setDir_codigo(rs.getInt("dir_codigo"));
               e.setTelefono(rs.getInt("telefono"));
               e.setCelular(rs.getInt("celular"));
               e.setPersonal_codigo(rs.getInt("personal_codigo"));
                listaEgresos.add(e);
            }
            rs.close();
            return listaEgresos;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean actualizar() {
        String sql = "UPDATE public.egreso SET"
                + " victima_codigo="+getVictima_codigo()+","
                + "egreso_fecha="+getEgreso_fecha()+","
                + "egreso_situacion='"+getEgreso_situacion()+"',"
                + "croquis=?, "
                + "dir_codigo="+getDir_codigo()+","
                + "telefono="+getTelefono()+","
                + "celular="+getCelular()+","
                + "personal_codigo="+getPersonal_codigo()+" "
                + " WHERE <condition>;";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

}
