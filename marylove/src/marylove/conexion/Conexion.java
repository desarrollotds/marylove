/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author icrv9
 */
public class Conexion {

    String urlDatabase = "jdbc:postgresql://35.193.22.29:5432/marylove";
    private static final String pgUsuario = "mina67";
    private static final String pgPass = "tiger";//CONTRASEÑA DE LA BASE DE DATOS

    private Connection con;//CONEXION
    private Statement st;//COMANDOS SQL
    private ResultSet rst;//RESULTADO DE LAS CONSULTAS

//    public Connection getConection() {
//        try {
//            Class.forName("org.postgresql.Driver");
//            conn = DriverManager.getConnection(urlDatabase, "yuu69", "tigernew");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
    
    public Connection conectarBD(){
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(urlDatabase, pgUsuario, pgPass);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void cerrarConexion() {

        //Cierra la conexion de la Base de Datos
        try {

            con.close();
            System.out.println("conexion cerrada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public ResultSet query(String sql) {//CONSULTAS 
        try {
            st = con.createStatement();
            rst = st.executeQuery(sql);
            return rst;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }//FIN DEL METODO RESULTSET DEL QUERY PARA CONSULTAS

    public SQLException noQuery(String sql){
        
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }//FIN DEL METODO RESULTSET DEL QUERY PARA CONSULTAS
}
