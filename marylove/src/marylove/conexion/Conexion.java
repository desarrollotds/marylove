/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.logging.Logger;

/**
 *
 * @author icrv9
 */
public class Conexion {

    String urlDatabase = "jdbc:postgresql://35.193.22.29:5432/marylove";
    Connection conn;

    public Connection getConection() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(urlDatabase, "yuu69", "tigernew");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void cerrarConexion() {

        //Cierra la conexion de la Base de Datos
        try {

            conn.close();
            System.out.println("conexion cerrada");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

