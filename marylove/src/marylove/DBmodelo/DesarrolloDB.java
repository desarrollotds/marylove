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
import marylove.models.Desarrollo;

/**
 *
 * @author Asus
 */
public class DesarrolloDB extends Desarrollo {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;
    private static int desarrollo_id_static;

    public DesarrolloDB() {
    }

    public DesarrolloDB(String des_motor_grueso, String des_motor_fino, String movimientos, String des_psico_social, String des_cognitivo, String des_fisico, String caridad_lenguajes, String claridad_lenguajes_descrip) {
        super(des_motor_grueso, des_motor_fino, movimientos, des_psico_social, des_cognitivo, des_fisico, caridad_lenguajes, claridad_lenguajes_descrip);
    }

    public DesarrolloDB(int desarrollo_id, String des_motor_grueso, String des_motor_fino, String movimientos, String des_psico_social, String des_cognitivo, String des_fisico, String caridad_lenguajes, String claridad_lenguajes_descrip) {
        super(desarrollo_id, des_motor_grueso, des_motor_fino, movimientos, des_psico_social, des_cognitivo, des_fisico, caridad_lenguajes, claridad_lenguajes_descrip);
    }

    public boolean llenarDesarrollo() throws SQLException {
        String sql = "INSERT INTO desarrollo(des_motor_grueso, des_motor_fino, "
                + "movimientos, des_psico_social, des_cognitivo, des_fisico, "
                + "caridad_lenguajes, claridad_lenguajes_descrip)"
                + " VALUES ('" + getDes_motor_grueso() + "', '" + getDes_motor_fino() + "', "
                + "'" + getMovimientos() + "', '" + getDes_psico_social() + "', '" + getDes_cognitivo() + "', "
                + "'" + getDes_fisico() + "', '" + getCaridad_lenguajes() + "',"
                + " '" + getClaridad_lenguajes_descrip() + "')returning desarrollo_id;";
        ps = conectar.getConnection().prepareStatement(sql);
        rs = ps.executeQuery();
        conectar.cerrarConexion();
        if (rs != null) {
            while (rs.next()) {
                desarrollo_id_static = rs.getInt(1);
            }
            return true;
        } else {
            return false;
        }
    }

    public static int getDesarrollo_id_static() {
        return desarrollo_id_static;
    }

    public static void setDesarrollo_id_static(int desarrollo_id_static) {
        DesarrolloDB.desarrollo_id_static = desarrollo_id_static;
    }

}
