/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.controlador.FiltroHijosVictima;
import marylove.models.x_hijos_familiares;

/**
 *
 * @author Usuario
 */
public class x_hijos_familiaresDB extends x_hijos_familiares {

    ResultSet rs = null;
    private ConexionHi conectar = new ConexionHi();

    public boolean ingresar_Familiar_x_Hijo() {
        int persona_codigo = 0;
        int familiares_id = 0;
        String sql = "INSERT INTO persona(persona_nombre, persona_apellido, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo) "
                + "VALUES ("
                + "'" + getPersona_nombre() + "', "
                + "'" + getPersona_apellido() + "', "
                + getPersona_ocupacion() + ", "
                + getPersona_nivel_acad() + ", "
                + getPersona_estadocivil() + ", "
                + getPersona_nacionalidad() + ", "
                + "'true', "
                + "'" + getPersona_sexo() + "')returning persona_codigo";

        System.out.println(sql);
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    persona_codigo = rs.getInt(1);
                    System.out.println("Se ingresó la persona");
                }

                sql = "INSERT INTO familiares(persona_codigo, parentesco, estado, edad)"
                        + "VALUES ("
                        + persona_codigo + ", "
                        + "'" + getParentescoFam() + "', "
                        + "'true', "
                        + getEdadFam() + ")returning familiares_id";
                System.out.println(sql);
                rs = conectar.query(sql);
                if (rs != null) {
                    while (rs.next()) {
                        familiares_id = rs.getInt(1);
                        System.out.println("Se ingresó el familiar");
                    }
                    sql = "INSERT INTO x_hijo_familiares(familiares_codigo, hijo_codigo)"
                            + "VALUES ("
                            + familiares_id + ", "
                            + AnamnesisDB.hijoCodigo + ")";
                    System.out.println(sql);

                    if (conectar.noQuery(sql)) {
                        System.out.println("Se ingresó la relación");
                        return true;
                    }
                } else {
                    System.out.println("ERROR AL INGRESAR LA TUPLA FAMILIARES");
                }
            } catch (SQLException ex) {
                Logger.getLogger(x_hijos_familiaresDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("ERROR AL INGRESAR LA PERSONA FAMILIAR");
        }
        return false;
    }

    public boolean actualizar_Familiar_x_Hijo() {
        boolean result = false;
        String sql = "SELECT actualizarDatosFamiliarNNA("
                + getPersona_codigo() + ", "
                + "'" + getPersona_nombre() + "', "
                + "'" + getPersona_apellido() + "', "
                + "'" + getPersona_sexo() + "', "
                + getPersona_estadocivil() + ", "
                + getPersona_ocupacion() + ", "
                + "'" + getParentescoFam() + "', "
                + getEdadFam() + ", "
                + getPersona_nivel_acad() + ")";

        System.out.println(sql);
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    result = rs.getBoolean(1);
                    System.out.println("Se actualizó al familiar correctamente");
                    System.out.println(result);
                    return result;
                }
            } catch (SQLException ex) {
                Logger.getLogger(x_hijos_familiaresDB.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERROR AL ACTUALIZAR AL FAMILIAR");
            }
        } else {
            System.out.println("ERROR AL INGRESAR LA PERSONA FAMILIAR");
        }
        return result;
    }

    public boolean eliminar_Familiar_x_Hijo() {
        boolean result = false;
        String sql = "SELECT eliminarDatosFamiliarNNA(" + getPersona_codigo() + ")";
        System.out.println(sql);
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                result = rs.getBoolean(1);
                System.out.println("Se eliminó al familiar correctamente");
                System.out.println(result);
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(x_hijos_familiaresDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR AL ELIMINAR AL FAMILIAR");
        }

        return result;
    }

    public ArrayList<x_hijos_familiares> listar_Familiares_x_Hijo() {
        String sql = "SELECT p.persona_codigo, p.persona_nombre, p.persona_apellido, p.persona_sexo, p.persona_estadocivil, "
                + "f.parentesco, p.persona_ocupacion, f.edad, p.persona_nivel_acad "
                + "FROM persona p "
                + "JOIN familiares f ON f.persona_codigo = p.persona_codigo "
                + "JOIN x_hijo_familiares xhf ON f.familiares_id = xhf.familiares_codigo "
                + "WHERE xhf.hijo_codigo = " + AnamnesisDB.hijoCodigo
                + " AND p.persona_estado_actual = 'true'"
                + " AND f.estado = 'true'";
        System.out.println(sql);
        rs = conectar.query(sql);
        ArrayList<x_hijos_familiares> listaFamiliares = new ArrayList<>();
        try {
            if (rs != null) {
                while (rs.next()) {
                    x_hijos_familiares obj = new x_hijos_familiares();
                    obj.setPersona_codigo(rs.getInt(1));
                    obj.setPersona_nombre(rs.getString(2));
                    obj.setPersona_apellido(rs.getString(3));
                    obj.setPersona_sexo(rs.getString(4).charAt(0));
                    obj.setPersona_estadocivil(rs.getInt(5));
                    obj.setParentescoFam(rs.getString(6));
                    obj.setPersona_ocupacion(rs.getInt(7));
                    obj.setEdadFam(rs.getInt(8));
                    obj.setPersona_nivel_acad(rs.getInt(9));
                    listaFamiliares.add(obj);
                }
                return listaFamiliares;
            }
        } catch (Exception ex) {
            Logger.getLogger(x_hijos_familiaresDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
}
