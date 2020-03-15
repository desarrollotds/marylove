/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Cita;
import marylove.models.Psicologo;

/**
 *
 * @author Usuario
 */
public class CitaDB extends Cita {

    ConexionHi conn;
    Conexion con;
    PreparedStatement ps;
    ResultSet rs = null;
//variable estatica
    private static int cita_codigo_insert;
    
    //VARIABLES DE CONEXIÓN
    private Conexion conecta = new Conexion();

    public CitaDB() {
    }

    public CitaDB(int cita_id, java.sql.Date cita_fecha, Time cita_hora, int llamada_codigo, int psicologo_codigo) {
        super(cita_id, cita_fecha, cita_hora, llamada_codigo, psicologo_codigo);
    }

    public boolean crearCita() throws SQLException {
        conn=new ConexionHi();
        String sql = "INSERT INTO cita ( cita_fecha, cita_hora, llamada_codigo, psicologo_codigo, cita_estado"
                + "VALUES ('"+getCita_fecha()+"','"+getCita_hora()+"'"
                + getLlamada_codigo()+","+getPsicologo_codigo()+",true)returning cita_id;";
        ps=conn.getConnection().prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
        cita_codigo_insert=rs.getInt(1);
        }
        if(cita_codigo_insert!=0){
        return true;
        }else{
        return false;
        }
    }

    //ELIMINAR UNA CITA EXISTENTE
    public boolean eliminarCita() {
        String sql = "UPDATE estado_cita = 'false' WHERE cita_id = " + getCita_id();
        System.out.println(sql);
        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    //EXTRAER LA LISTA DE LAS CITAS YA REGISTRADAS EN LA BD 
    public List<Cita> consultarListaCitas(java.sql.Date fecha) {
        String sql = "SELECT * FROM cita WHERE estado_cita = 'true' AND cita_fecha = " + fecha;

        try {
            List<Cita> listaCitas = new ArrayList<Cita>();//CREACIÓN DE LA LISTA
            ResultSet rs = conecta.query(sql);//

            while (rs.next()) {
                Cita obj = new Cita();
                obj.setCita_id(rs.getInt("cita_id"));
                obj.setCita_fecha(rs.getDate("cita_fecha"));
                obj.setCita_hora(rs.getTime("cita_hora"));
                obj.setLlamada_codigo(rs.getInt("llamada_codigo"));
                obj.setPsicologo_codigo(rs.getInt("psicologo_codigo"));
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

        String sql = "SELECT psi.psicologo_codigo, p.persona_nombre, p.persona_apellido "
                + "FROM psicologo psi "
                + "JOIN personal per ON per.personal_codigo = psi.personal_codigo "
                + "JOIN persona p ON per.persona_codigo = p.persona_codigo";

        try {
            List<Psicologo> listaPsicologos = new ArrayList<Psicologo>();
            rs = conecta.query(sql);
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

    public Object consultarCita(int cod_cita) {
        Cita obj = new Cita();
        String sql = "SELECT * FROM Cita WHERE cita_id = " + cod_cita;
        return null;
    }
}
