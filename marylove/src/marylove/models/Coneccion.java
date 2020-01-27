/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author icrv9
 */
public class Coneccion {
static final String URL = "jdbc:postgresql://35.193.22.29:5432/marylove";
static final String USER = "mina67";
static final String PASS = "tiger";
 
public Connection crearConexion() throws SQLException{
    try {
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(URL, USER, PASS);
        if (conexion != null){
            System.out.print("Conexion establecida...");
            return conexion;
        }
        return null;
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
}




