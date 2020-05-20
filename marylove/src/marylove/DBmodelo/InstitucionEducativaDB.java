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
import marylove.models.InstitucionEducativa;

/**
 *
 * @author Alumno
 */
public class InstitucionEducativaDB extends InstitucionEducativa {

    ConexionHi conectar;// = new ConexionHi();
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
    sql="INSERT INTO public.institucion_educativa(inst_nombre,inst_telefono,"
            + "dir_codigo,inst_tipo)VALUES ('"+getInst_nombre()+"','"+getInst_telefono()+"',"
            +getDir_codigo()+","+getInst_tipo()+")";
    ps=conectar.getConnection().prepareStatement(sql);
    ps.execute();
    conectar.cerrarConexion();
        
    }
     public ArrayList instituciones() throws SQLException {
         listaInstituciones = new ArrayList<>();
         conectar= new ConexionHi();
         
        sql = "SELECT * FROM public.institucion_educativa";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        conectar.cerrarConexion();
        while (re.next()){
        ie= new InstitucionEducativa(re.getInt(1), re.getString(2),re.getString(3),re.getInt(4),re.getInt(5));
        listaInstituciones.add(ie);
        
        }
            return listaInstituciones;
    }

}
