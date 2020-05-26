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
import marylove.models.Detalle_nacimiento;

/**
 *
 * @author Asus
 */
public class Detalle_nacimientoDB extends Detalle_nacimiento {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;

    public Detalle_nacimientoDB() {
    }

    public Detalle_nacimientoDB(String complicaciones_parto, String peso, String talla, boolean lloro_nac, boolean necesito_oxigeno, String sintomas_after_part, int nacimiento_codigo) {
        super(complicaciones_parto, peso, talla, lloro_nac, necesito_oxigeno, sintomas_after_part, nacimiento_codigo);
    }

    public boolean llenarDetalleNacimiento() throws SQLException {
        String sql = "INSERT INTO detalle_nacimiento(complicaciones_parto, peso, talla, lloro_nac, necesito_oxigeno, sintomas_after_part, nacimiento_codigo)\n"
                + "	VALUES ('" + getComplicaciones_parto() + "',"
                + " '" + getPeso() + "', '" + getTalla() + "', '" + isLloro_nac() + "',"
                + " '" + isNecesito_oxigeno() + "', '" + getSintomas_after_part() + "', "
                + " " + getNacimiento_codigo() + ");";

        ps = conectar.getConnection().prepareStatement(sql);
        if (ps.execute()) {
            conectar.cerrarConexion();
            return true;
        } else {
            conectar.cerrarConexion();
            return false;
        }
    }

    //METODOS DE LA FICHA ANAMNESIS--------------------------------------------------------------------------------------------------
    //1.5 ACTUALIZACIÓN DE CONDICIONES DE NACIMIENTO
    public boolean actualizacionCondicionesNacimiento(int deta_codigo, int nacimiento_codigo) {

        String sql = "UPDATE detalle_nacimiento SET"
                + "peso = '" + getPeso() + "'"
                + ", talla = '" + getTalla() + "'"
                + ", lloro_nac = '" + isLloro_nac() + "'"
                + ", necesito_oxigeno = '" + isNecesito_oxigeno() + "'"
                + ", sintomas_after_part = '" + getSintomas_after_part() + "'"
                + " WHERE deta_codigo = " + deta_codigo + ""
                + " AND nacimiento_codigo = " + nacimiento_codigo;

        if (conectar.noQuery(sql)) {
            System.out.println("1.5 Se actualizó las condiciones de nacimiento (Ubicación del método: NacimientoDB)");
            return true;
        } else {
            System.out.println("Error 1.5 No se pudo actualizar las condiciones de nacimiento (Ubicación del método: NacimientoDB)");
            return false;
        }
    }
}
