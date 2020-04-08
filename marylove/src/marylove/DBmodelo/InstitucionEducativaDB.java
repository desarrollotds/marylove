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
import static marylove.DBmodelo.HijosDB.codigopersona;
import marylove.conexion.ConexionHi;
import marylove.models.InstitucionEducativa;

/**
 *
 * @author Alumno
 */
public class InstitucionEducativaDB extends InstitucionEducativa {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re;
    boolean ingreso = true;
    String sql = "";
    //variables globales
    ArrayList<InstitucionEducativa> listaInstituciones;
    InstitucionEducativa ie;
    public InstitucionEducativaDB() {
    }

    public InstitucionEducativaDB(String inst_nombre, String inst_telefono, int dir_codigo, int inst_tipo) {
        super(inst_nombre, inst_telefono, dir_codigo, inst_tipo);
    }
    
    public void insetarInstEduc() throws SQLException{
    conn= new ConexionHi();
    sql="INSERT INTO public.institucion_educativa(inst_nombre,inst_telefono,"
            + "dir_codigo,inst_tipo)VALUES ('"+getInst_nombre()+"','"+getInst_telefono()+"',"
            +getDir_codigo()+","+getInst_tipo()+")";
    ps=conn.getConnection().prepareStatement(sql);
    ps.execute();
    conn.CerrarConexion();
        
    }
     public ArrayList instituciones() throws SQLException {
         listaInstituciones = new ArrayList<>();
         conn= new ConexionHi();
         
        sql = "SELECT * FROM public.institucion_educativa";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        conn.CerrarConexion();
        while (re.next()){
        ie= new InstitucionEducativa(re.getInt(1), re.getString(2),re.getString(3),re.getInt(4),re.getInt(5));
        listaInstituciones.add(ie);
        
        }
            return listaInstituciones;
    }

}
