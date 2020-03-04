/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Cita;
import marylove.models.Psicologo;

/**
 *
 * @author Usuario
 */
public class CitaDB extends Cita {

    //VARIABLES DE CONEXIÓN
    private Conexion conecta = new Conexion();

    public CitaDB() {
    }

    public CitaDB(int cita_id, java.sql.Date cita_fecha, Time cita_hora, int llamada_codigo, int psicologo_codigo, int victima_codigo) {
        super(cita_id, cita_fecha, cita_hora, llamada_codigo, psicologo_codigo, victima_codigo);
    }

    public boolean crearCita() {
        String sql = "INSERT INTO cita (cita_id, cita_fecha, cita_hora, llamada_codigo, psicologo_codigo, victima_codigo, cita_estado";
        sql += "VALUES ('" + getCita_fecha() + "'"
                + ", '" + getCita_hora() + "'"
                + ", " + getLlamada_codigo() + ""
                + ", " + getPsicologo_codigo() + " "
                + ", " + getVictima_codigo() + " "
                + ", 'A'";
        System.out.println(sql);
        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    //ELIMINAR UNA CITA EXISTENTE
    public boolean eliminarCita() {
        String sql = "UPDATE estado_cita = 'I' WHERE cita_id = " + getCita_id();
        System.out.println(sql);
        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    //EXTRAER LA LISTA DE LAS CITAS YA REGISTRADAS EN LA BD 
    public List<Cita> consultarListaCitas() {
        String sql = "SELECT * FROM cita WHERE estado_cita = 'A'";

        try {
            List<Cita> listaCitas = new ArrayList<Cita>();
            ResultSet rs = conecta.query(sql);

            while (rs.next()) {
                Cita obj = new Cita();
                obj.setCita_id(rs.getInt("cita_id"));
                obj.setCita_fecha(rs.getDate("cita_fecha"));
                obj.setCita_hora(rs.getTime("cita_hora"));
                obj.setLlamada_codigo(rs.getInt("llamada_codigo"));
                obj.setPsicologo_codigo(rs.getInt("psicologo_codigo"));
                obj.setVictima_codigo(rs.getInt("victima_codigo"));
                listaCitas.add(obj);//AGREGAMOS
            }
            return listaCitas;
        } catch (SQLException ex) {
            Logger.getLogger(CitaDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //LISTAR A LOS PSICOLOGOS AL SERVICIO DE LA FUNDACIÓN
    public List<Psicologo> consultarPsicologos() {

        String sql = "SELECT psi.psicologo_codigo, p.persona_nombre, p.persona_aoellido "
                + "FROM psicologo psi "
                + "JOIN personal per ON per.personal_codigo = psi.personal_codigo "
                + "JOIN persona p ON per.persona_codigo = p.persona_codigo";

        try {
            List<Psicologo> listaPsicologos = new ArrayList<Psicologo>();
            ResultSet rs = conecta.query(sql);

            while (rs.next()) {
                Psicologo obj = new Psicologo();
                obj.setCodigo_psic(rs.getInt("psicologo_codigo"));
                obj.setPersona_nombre(rs.getString("persona_nombre"));
                obj.setPersona_apellido(rs.getString("persona_apellido"));
                listaPsicologos.add(obj);//AGREGAMOS
            }
            return listaPsicologos;
        } catch (SQLException ex) {
            Logger.getLogger(CitaDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Object consultarCita (){
        return null;
        
    }
}
