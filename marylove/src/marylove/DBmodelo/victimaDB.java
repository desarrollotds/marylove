package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.controlador.FiltroHijosVictima;
import marylove.models.Persona;
import marylove.models.Victima;

/**
 *
 * @author vasquez
 */
public class victimaDB extends Victima {

    PreparedStatement ps;
    ResultSet re ;
    int cod = 0;

    ConexionHi conectar = new ConexionHi();
    String sql = "";
    //variables globqales
    int id = 0;
    Victima v;
    //vatriables staticas
    private static int codigo_victima_static;
    private static List<Victima> arrayvictima = new ArrayList<>();

    public victimaDB() {
    }

    public victimaDB(int persona_codigo, boolean victima_estado) {
        super(persona_codigo, victima_estado);
    }

    //-----------------------------------------------------------------------------------------------------
    public void datosVictima(String nombre, String cedula) {

        v = new Victima();
        String sql2 = "";
        try {
            if (nombre.equals("") && !cedula.equals("")) {
                sql2 = "select vc.victima_codigo,pe.persona_cedula, pe.persona_nombre, pe.persona_apellido from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo where pe.persona_cedula Like '%" + cedula + "%'";
                System.out.println(sql2);
            } else if (!nombre.equals("") && cedula.equals("")) {
                sql2 = "select vc.victima_codigo,pe.persona_cedula, pe.persona_nombre, pe.persona_apellido from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo where pe.persona_nombre Like '%" + nombre + "%'";
                System.out.println("2");
            } else if (nombre.equals("") && cedula.equals("")) {
                sql2 = "select vc.victima_codigo, pe.persona_cedula,pe.persona_nombre, pe.persona_apellido from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo ";
                // System.out.println(" holaaaaaaaaaaaaaaa");
            } else {
                System.out.println("vacio");
                sql2 = "select vc.victima_codigo, pe.persona_cedula,pe.persona_nombre, pe.persona_apellido from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo ";
            }

            //  sql = " select hj.hijo_codigo , pe.persona_nombre||' '||pe.persona_apellido from hijos hj join persona pe USING (persona_codigo) where   hj.victima_codigo="+codigo_victima
            ps = conectar.getConnection().prepareStatement(sql2);
            re = ps.executeQuery();
            while (re.next()) {
                Victima vc = new Victima();
                vc.setVictima_codigo(re.getInt(1));
                vc.setPersona_cedula(re.getString(2));
                vc.setPersona_nombre(re.getString(3));
                vc.setPersona_apellido(re.getString(4));
                arrayvictima.add(vc);
            }

        } catch (Exception e) {
        }
        conectar.cerrarConexion();
    }

    //-----------------------------------------------------------------------------------------------------
    public static List<Victima> getArrayvictima() {
        return arrayvictima;
    }

    public static void setArrayvictima(List<Victima> arrayvictima) {
        victimaDB.arrayvictima = arrayvictima;
    }

    public static int getCodigo_victima_static() {
        return codigo_victima_static;
    }

    public static void setCodigo_victima_static(int codigo_victima_static) {
        victimaDB.codigo_victima_static = codigo_victima_static;
    }

    public boolean insertarVictima() {
        try {
            sql = "INSERT into public.victima ( persona_codigo, victima_embarazo"
                    + ")	VALUES (" + personaDB.getPersona_codigo_static() + ", '" + isVictima_estado() + "' )  RETURNING victima_codigo;";
            System.out.println(sql);
            re=conectar.query(sql);

            while (re.next()) {
                codigo_victima_static = re.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return true;
    }

    public Victima obtenetCV(String ced, String nom , String app) {
        Victima v = new Victima();
        //select vc.victima_codigo, pe.persona_nombre||' '||pe.persona_apellido, pe.persona_cedula from victima vc
        //join persona pe on vc.persona_codigo = pe.persona_codigo
        //where pe.persona_cedula = '0101111111'  || (pe.persona_nombre LIKE '%Manuela Fajardo%' 
        //&& pe.persona_apellido LIKE '%Manuela Fajardo%')
        try {
            sql = "select vc.victima_codigo, pe.persona_nombre||' '||pe.persona_apellido, pe.persona_cedula from victima vc "
                    + " join persona pe on vc.persona_codigo = pe.persona_codigo "
                    + " where pe.persona_cedula = '" + ced + "' OR (pe.persona_nombre LIKE '%" + nom + "%' "
                    + " AND pe.persona_apellido LIKE '%"+ app +"%');";
            re = conectar.query(sql);
            while (re.next()) {
                v.setVictima_codigo(re.getInt(1));
                v.setPersona_nombre(re.getString(2));
                v.setPersona_cedula(re.getString(3));
            }
        } catch (Exception ex) {
            System.out.println("error al obtener datos de victima " + ex.getMessage());
            conectar.cerrarConexion();
        }
        return v;
    }

    public int obtenerIdVictima() {

        try {

            sql = "select victima_codigo from victima where persona_codigo='" + getPersona_codigo() + "'";
            System.out.println(sql + "----------------");
            re = conectar.query(sql);
            while (re.next()) {
                id = re.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            conectar.cerrarConexion();
        }
        return id;
    }
    public void MadreVictimaAnamnesis( Victima v) {
        sql = "select  p.persona_nombre, p.persona_apellido,p.persona_nacionalidad, Extract(year from age( current_date , p.persona_fecha_nac)) from victima v join persona p using (persona_codigo) join hijos h using (victima_codigo) where h.hijo_codigo=" + FiltroHijosVictima.getCodigo() + ";";
        System.out.println(sql);
        re=conectar.query(sql);
        try {
            while (re.next()) {
                v.setPersona_nombre(re.getString(1));
                v.setPersona_apellido(re.getString(2));
                v.setPersona_nacionalidad(re.getInt(3));
                v.setEdad(Integer.parseInt(String.valueOf(re.getString(4))));
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(victimaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
