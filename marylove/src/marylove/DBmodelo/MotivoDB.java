/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;

/**
 *
 * @author Asus
 */
public class MotivoDB {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    //variables locales para el metodo obteMotivId(String nombre)
    int mId;

    public int obteMotivId(String nombre) throws SQLException {
       mId=0;
        conn = new ConexionHi();
        sql = "select motivo_id from motivo where motivo_descripcion='" + nombre + "';";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        conn.CerrarConexion();
        while (re.next()) {
            mId = re.getInt(1);
        }

        return mId;
    }


}
