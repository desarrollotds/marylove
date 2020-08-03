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
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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

//    private PreparedStatement stmt;
//    private ResultSet rs;
//    private Statement Consultar = null;//CONSULTAS SQL
//    private ResultSet Resultados = null;//RESULTADOS DE LAS CONSULTAS SQL
//    private String Error;
    private Connection con;//CONEXION
    private Statement st;//COMANDOS SQL
    private ResultSet rst;//RESULTADO DE LAS CONSULTAS

    public void Conexion() {
        Properties configuracion = new Properties();
        InputStream configInput = null;
        try {
//             configInput = new FileInputStream("Informacion.properties");
//            configuracion.load(configInput);
            config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://35.206.88.13:5432/marylove");
//            config.setJdbcUrl("jdbc:postgresql://localhost:5432/marylove");
//            config.setJdbcUrl("jdbc:postgresql://" + configuracion.getProperty("host_ip_name") + "/" + configuracion.getProperty("db_name"));
            config.setUsername("postgres");
            config.setPassword("fma*2020*");
            config.setMaximumPoolSize(30);
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            ds = new HikariDataSource(config);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error causa: "+e.getCause());
            System.out.println("Error class: "+e.getClass());
            System.out.println("Supre error : "+e.getSuppressed());
        }
    }

    public Connection getConnection() throws SQLException {
        Conexion();
        if (ds != null) {
            System.out.println("Con-Abierta");
        }
        return ds.getConnection();
    }

    public void cerrarConexion() {
        ds.close();
        System.out.println("Con-Cerrada");
    }

    public void probarConexion() {

        try {
            List<String> listaUsuarios = new ArrayList<String>();
            con = this.getConnection();
            ResultSet r = con.createStatement().executeQuery("");
            while (r.next()) {
                listaUsuarios.add(r.getString(1));
            }

            this.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet query(String sql) {//CONSULTAS 
        try {
            st = getConnection().createStatement();
            rst = st.executeQuery(sql);
            cerrarConexion();
            return rst;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }//FIN DEL METODO RESULTSET DEL QUERY PARA CONSULTAS

    public boolean noQuery(String sql) {
        try {
            st = getConnection().createStatement();
            st.execute(sql);
            st.close();
            cerrarConexion();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al ingresar:" + ex.getMessage());
            return false;
        }
    }//FIN DEL METODO RESULTSET DEL QUERY PARA CONSULTAS

    public PreparedStatement getPs(String sql) {
        try {
            return con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//    private final static String cadenaConexion = "jdbc:postgresql://34.95.193.17:5432/marylove";
//    private final static String pgUsuario = "postgres";
//    private final static String pgPass = "tds-one2020";
//
//    public ConexionHi() {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            con = DriverManager.getConnection(cadenaConexion, pgUsuario, pgPass);
//        } catch (SQLException ex) {
//            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
