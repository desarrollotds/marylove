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
import marylove.models.ContactoEmergencia;

/**
 *
 * @author Alumno
 */
public class ContactoEmergenciaDB extends ContactoEmergencia {

    public static int conctacto_emergencia_static;

    //variable de la clase DB
    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re;
    boolean ingreso = true;
    String sql = "";
    //variables glovales
    int codigo = 0;

    public ContactoEmergenciaDB() {
    }

    public ContactoEmergenciaDB(String cont_parentesco, int per_codigo, int per_rela_codigo, String cont_domicilio) {
        super(cont_parentesco, per_codigo, per_rela_codigo, cont_domicilio);
    }

    public int insertarContactEmerg() throws SQLException {
        codigo = 0;
        //conn = new ConexionHi();
        sql = "INSERT INTO public.contacto_emergencia (cont_parentesco,"
                + "per_codigo,per_rela_codigo,cont_domicilio)VALUES("
                + "'"+getCont_parentesco()+"',"+getPer_codigo()+","
                +getPer_rela_codigo()+",'"+getCont_domicilio()+"');";
        ps=conectar.getConnection().prepareStatement(sql);
        ps.execute();
        conectar.cerrarConexion();
        return codigo;
    }

}
