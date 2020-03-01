/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PEDRO
 */
public class ConexionHi {

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
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/mary");
//            config.setJdbcUrl("jdbc:postgresql://" + configuracion.getProperty("host_ip_name") + "/" + configuracion.getProperty("db_name"));
            config.setUsername("postgres");
            config.setPassword("xxxxx");
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
        }
        return ds.getConnection();
    }

    public void CerrarConexion() {
        ds.close();
        System.out.println("Con-Cerrada");
    }

public void probarConexion(){

        try {
            List<String> listaUsuarios = new ArrayList<String>();
            Connection conexion=this.getConnection();
            ResultSet r =conexion.createStatement().executeQuery("");
            while(r.next()){
            listaUsuarios.add(r.getString(1));
            }
            
            this.CerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
        }
}


    
    public static void main (String [] args){
        ConexionHi c = new ConexionHi();
        c.Conexion_();
             
    }
    
    

}
