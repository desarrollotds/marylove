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
                + "	VALUES ('"+getComplicaciones_parto()+"',"
                + " '"+getPeso()+"', '"+getTalla()+"', '"+isLloro_nac()+"',"
                + " '"+isNecesito_oxigeno()+"', '"+getSintomas_after_part()+"', "
                + " "+getNacimiento_codigo()+");";

        ps=conectar.getConnection().prepareStatement(sql);
        if(ps.execute()){
         conectar.cerrarConexion();
         return true;        
        }else{
         conectar.cerrarConexion();
        return false;
        }
        
    }
}
