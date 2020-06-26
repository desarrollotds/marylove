/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.conexion.ConexionHi;
import marylove.models.Cita;
import marylove.models.Persona_llamada;
import marylove.models.Psicologo;
import marylove.models.Victima;

/**
 *
 * @author Usuario
 */
public class CitaDB extends Cita {

    PreparedStatement ps;
    ResultSet rs = null;
//variable estatica
    private static int cita_codigo_insert;

    //VARIABLES DE CONEXIÓN
    private ConexionHi conectar = new ConexionHi();

    public CitaDB() {

    }

    public CitaDB(int cita_id, java.sql.Date cita_fecha, String cita_hora, int llamada_codigo, int psicologo_codigo, int victima_codigo) {
        super(cita_id, cita_fecha, cita_hora, llamada_codigo, psicologo_codigo, victima_codigo);

    }

    public static int getCita_codigo_insert() {
        return cita_codigo_insert;
    }

    public static void setCita_codigo_insert(int cita_codigo_insert) {
        CitaDB.cita_codigo_insert = cita_codigo_insert;
    }

    public boolean crearCita() {

//        String sql = "INSERT INTO cita (cita_fecha, cita_hora, llamada_codigo, psicologo_codigo, cita_estado) "
//                + "VALUES ('" + getCita_fecha() + "', '" + getCita_hora() + "', " + getLlamada_codigo() + ", "
//                + getPsicologo_codigo() + ", 'true') returning cita_id;";
        String sql = "INSERT INTO cita (cita_fecha, llamada_codigo, psicologo_codigo, cita_estado, cita_hora) "
                + "VALUES ('" + getCita_fecha() + "', " + getLlamada_codigo() + ", "
                + getPsicologo_codigo() + ", 'true','" + getCita_hora() + "') returning cita_id;";
        try {
            rs = conectar.query(sql);
            if (rs != null) {
                while (rs.next()) {
                    cita_codigo_insert = rs.getInt(1);
                }
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    //ELIMINAR UNA CITA EXISTENTE
    public boolean eliminarCita() {
        String sql = "UPDATE cita SET cita_estado = 'false' WHERE cita_id = " + getCita_id();
        System.out.println(sql);
        try {
            boolean resultado = conectar.noQuery(sql);
            return resultado;
        } catch (Exception e) {
            return false;
        }
    }

    //EXTRAER LA LISTA DE LAS CITAS YA REGISTRADAS EN LA BD 
    public List[] consultarListaCitas(java.sql.Date fecha) {
        String sql = "SELECT cit.cita_hora, cit.cita_id, perll.per_nombre, perll.per_apellido "
                + "FROM cita cit "
                + "JOIN llamada lla ON cit.llamada_codigo = lla.llamada_codigo "
                + "JOIN persona_llamada perll ON lla.per_codigo = perll.per_codigo "
                + "WHERE cita_estado = 'true' "
                + "AND cita_fecha = '" + fecha + "' ;";

        try {
            //CREAMOS LAS LISTAS QUE CONTENDRAN LOS OBJETOS CON LOS DATOS
            List<Persona_llamada> listaPersonasLlamada = new ArrayList<Persona_llamada>();
            List<Cita> listaCitas = new ArrayList<Cita>();//CREACIÓN DE LA LISTA
            List lstDatosCitas[] = new List[10];//CREACIÓN DEL ARRAY DE LISTAS EL CUAL VA A SER RETORNADO

            //REALIZAMOS LA CONSULTA
            rs = conectar.query(sql);

            while (rs.next()) {
                Cita obj = new Cita();
                obj.setCita_hora(rs.getString(1));
                obj.setCita_id(rs.getInt(2));
                listaCitas.add(obj);//AGREGAMOS EL OBJETO A LA LISTA DE CITAS
                Persona_llamada objPersonaLlam = new Persona_llamada();// CREAMOS UN OBJETO PARA LA PERSONA LLAMADA
                objPersonaLlam.setPer_nombre(rs.getString(3));
                objPersonaLlam.setPer_apellido(rs.getString(4));
                listaPersonasLlamada.add(objPersonaLlam);//AÑADIMOS EL OBJETO A SU RESPECTIVA LISTA
            }

            //AÑADIMOS LAS LISTAS QUE CONTIENEN LOS DATOS DE LA CONSULTA AL ARRAY QUE VA A SER RETORNADO
            lstDatosCitas[0] = listaCitas;//AGREGAMOS LA LISTA DE CITAS AL ARRAY
            lstDatosCitas[1] = listaPersonasLlamada;//AGREGAMOS LA LISTA DE PERSONAS LLAMADA AL ARRAY
            return lstDatosCitas;
        } catch (SQLException ex) {
            Logger.getLogger(CitaDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //LISTAR A LOS PSICOLOGOS AL SERVICIO DE LA FUNDACIÓN
    public List<Psicologo> consultarPsicologos() {

        String sql = "SELECT psi.psicologo_codigo, p.persona_nombre, p.persona_apellido "
                + "FROM psicologo psi "
                + "JOIN personal per ON per.personal_codigo = psi.personal_codigo "
                + "JOIN persona p ON per.persona_codigo = p.persona_codigo";

        try {
            List<Psicologo> listaPsicologos = new ArrayList<Psicologo>();
            rs = conectar.query(sql);
            while (rs.next()) {
                Psicologo obj = new Psicologo();
                obj.setCodigo_psic(rs.getInt(1));
                obj.setPersona_nombre(rs.getString(2));
                obj.setPersona_apellido(rs.getString(3));
                System.out.println(obj.getCodigo_psic() + " " + obj.getPersona_nombre() + " " + obj.getPersona_apellido());

                listaPsicologos.add(obj);//AGREGAMOS
            }
            return listaPsicologos;
        } catch (SQLException ex) {
            Logger.getLogger(CitaDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //CONSULTAMOS LA LISTA DE VICTIMAS PARA IDENTIFICARLOS EN LA TABLA DE LA LISTA DE BENEFICIARIAS EN LA VENTANA DE AGENDAMIENTO DE CITAS
    public List<Persona_llamada> consultarBeneficiarias() {
        String sql = "SELECT per_codigo, per_cedu_cod, per_nombre, per_apellido FROM persona_llamada ";
        try {
            List<Persona_llamada> listaBeneficiarias = new ArrayList<Persona_llamada>();
            rs = conectar.query(sql);

            while (rs.next()) {
                Persona_llamada objPersonaLlamada = new Persona_llamada();
                objPersonaLlamada.setPer_codigo(rs.getInt(1));
                objPersonaLlamada.setPer_cedu_cod(rs.getString(2));
                objPersonaLlamada.setPer_nombre(rs.getString(3));
                objPersonaLlamada.setPer_apellido(rs.getString(4));

                listaBeneficiarias.add(objPersonaLlamada);
            }
            return listaBeneficiarias;
        } catch (SQLException ex) {
            Logger.getLogger(CierreDB.class.getName()).log(Level.SEVERE, sql, ex);
            return null;
        }
    }

    public List<Persona_llamada> buscarBeneficiarias(String nombre_o_apellido) {

        String sql = "SELECT per_codigo, per_nombre, per_apellido FROM persona_llamada WHERE per_nombre LIKE '%" + nombre_o_apellido + "%' OR per_apellido LIKE '%" + nombre_o_apellido + "%' ";
        try {
            List<Persona_llamada> listaBeneficiarias = new ArrayList<Persona_llamada>();
            rs = conectar.query(sql);

            while (rs.next()) {
                Persona_llamada objPersonaLlamada = new Persona_llamada();
                objPersonaLlamada.setPer_codigo(rs.getInt(1));
                objPersonaLlamada.setPer_nombre(rs.getString(2));
                objPersonaLlamada.setPer_apellido(rs.getString(3));

                listaBeneficiarias.add(objPersonaLlamada);
            }
            return listaBeneficiarias;
        } catch (SQLException ex) {
            Logger.getLogger(CierreDB.class.getName()).log(Level.SEVERE, sql, ex);
            return null;
        }
    }
}
