/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.conexion;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author PEDRO
 */
public class Conexion {

    private static HikariConfig config;
    private static HikariDataSource ds;

    private PreparedStatement stmt;
    private ResultSet rs;

    private Statement Consultar = null;
    private ResultSet Resultados = null;
    private String Error;

    public void Conexion_() {
        Properties configuracion = new Properties();
        InputStream configInput = null;
        try {
           // configInput = new FileInputStream("Informacion.properties");
            //configuracion.load(configInput);
            config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql:35.193.22.29:5432/marylove");
//            config.setJdbcUrl("jdbc:postgresql://" + configuracion.getProperty("host_ip_name") + "/" + configuracion.getProperty("db_name"));
            config.setUsername("postgres");
            config.setPassword("1234");
            config.setMaximumPoolSize(10);
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            ds = new HikariDataSource(config);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Connection getConnection() throws SQLException {
        Conexion_();
        if (ds != null) {
            System.out.println("Con-Abierta");
        }else{
            System.out.println("Conexion erronea");
        }
        return ds.getConnection();
    }

    public void CerrarConexion() {
        //posible error no va el try catch
        
        //ds.close();
        //System.out.println("Con-Cerrada");
        try {
            ds.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar"+ e.getMessage());
        }
    }
    
    

}
