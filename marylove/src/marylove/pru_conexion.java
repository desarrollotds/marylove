/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import marylove.conexion.ConexionHi;

/**
 *
 * @author Asus
 */
public class pru_conexion {
    public static void main(String[] args) {
        ConexionHi c = new ConexionHi();
        String u = "select * from persona";
        
        ResultSet e = c.query(u);
        
        if (e==null) {
            JOptionPane.showMessageDialog(null, "no hay datos");
        } else {
            JOptionPane.showMessageDialog(null, "hay datos");
        }
    }
    
}
