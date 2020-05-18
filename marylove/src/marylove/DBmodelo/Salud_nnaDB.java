/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Salud_nna;

/**
 *
 * @author Asus
 */
public class Salud_nnaDB extends Salud_nna{
    Conexion con;
    ConexionHi conn;
    PreparedStatement ps;
    ResultSet rs = null;
    private static int salud_nna_id_static;
    
    public Salud_nnaDB(String problem_familiare, 
            String problem_familiar_descrip, 
            boolean problem_respiratorio, 
            String problem_resp_descrip, 
            boolean problem_alergias, 
            String problem_aler_descrip, 
            boolean problem_neurologico, 
            String problem_neuro_descrip, 
            boolean problem_nerviosos, 
            String problem_nervi_descrip) {
        super(problem_familiare, problem_familiar_descrip, problem_respiratorio, problem_resp_descrip, problem_alergias, problem_aler_descrip, problem_neurologico, problem_neuro_descrip, problem_nerviosos, problem_nervi_descrip);
    }

    public Salud_nnaDB() {
    }

    public static int getSalud_nna_id_static() {
        return salud_nna_id_static;
    }

    public static void setSalud_nna_id_static(int salud_nna_id_static) {
        Salud_nnaDB.salud_nna_id_static = salud_nna_id_static;
    }
     public boolean llenarSaludNNA() throws SQLException {
        String sql = "INSERT INTO salud_nna(problem_familiar, problem_familiar_descrip, "
                + "problem_respiratorio, problem_resp_descrip, problem_alergias, "
                + "problem_aler_descrip, problem_neurologico, problem_neuro_descrip, "
                + "problem_nerviosos, problem_nervi_descrip)"
                + " VALUES ('"+getProblem_familiare()+"', '"+getProblem_familiar_descrip()+"', "
                + " '"+isProblem_respiratorio()+"', '"+getProblem_resp_descrip()+"',"
                + " '"+isProblem_alergias()+"', '"+getProblem_aler_descrip()+"', "
                + " '"+isProblem_neurologico()+"', '"+getProblem_neuro_descrip()+"', "
                + " '"+isProblem_nerviosos()+"', '"+getProblem_neuro_descrip()+"')returning salud_nna_id;";

        ps=conn.getConnection().prepareStatement(sql);
        rs=ps.executeQuery();
        conn.CerrarConexion();
        if(rs!=null){
         while(rs.next()){
        salud_nna_id_static=rs.getInt(1);
        }
         return true;
        }else{
        return false;
        }
    }
}