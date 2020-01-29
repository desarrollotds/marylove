/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 *
 * @author icrv9
 */
public class Conexion {
    public Connection conn;
public Connection getConnection() throws Exception {
    String urlDatabase =  "jdbc:postgresql://35.193.22.29:5432/marylove";
     
    return DriverManager.getConnection(urlDatabase,"yuu69","tigernew");
}
public void cerrarConexion()
    {
        try
        {
            //Cierra la conexion de la Base de Datos
            conn.close();
            System.out.println("Cerrada la conexion con la Base de Datos");
        }
        catch(SQLException e)
        {
            System.out.println("Error al cerrar la conexion con la Base de datos. \n"+e);
        }
    }
}






