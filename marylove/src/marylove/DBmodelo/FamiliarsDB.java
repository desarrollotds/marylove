package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Familiars;
import marylove.models.x_hijos_familiares;

public class FamiliarsDB extends x_hijos_familiares {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    int id = 0;


    public FamiliarsDB() {
    }

    public int maxId() {
        int id = 0;
        try {
            sql = "select max(ingreso_id) from ingreso ;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                id = (re.getInt(1));
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
        conectar.cerrarConexion();
        return id;
    }

    public boolean IngresarFamily() throws SQLException {
        sql = "insert into persona(persona_cedula,persona_nombre,persona_apellido,persona_fecha_nac)\n"
                + "values ('" + getPersona_cedula() + "','" + getPersona_nombre() + "','" + getPersona_apellido() + "','"
                + getPersona_fecha_nac() + "') returning persona_codigo ;";
        re = conectar.query(sql);
        while (re.next()) {
            id = re.getInt(1);
        }
        if (id > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int IngresarFamily2() throws SQLException {
        int id2 = 0;
        sql = "insert into familiares(persona_codigo, parentesco,estado) "
                + "VALUES (" + id + ", '" + getParentescoFam() + "' ,true) returning familiares_id";
        System.out.println("sql2: " + sql);
        re = conectar.query(sql);
        while (re.next()) {
            id2 = re.getInt(1);
        }
        return id2;
    }

    public boolean inserVICFAM(int famcod, int vicod) {
        sql = "insert into x_victima_familiares(familiares_id, victima_codigo) "
                + "values (" + famcod + ", " + vicod + ") ;";
        return conectar.noQuery(sql);
    }

    public boolean EdadIngresarFamily3() throws SQLException {
        sql = "update familiares set edad =\n"
                + "(Extract(year from age(current_date,per.persona_fecha_nac )))\n"
                + "from persona per inner join familiares fm \n"
                + "on  per.persona_codigo = fm.persona_codigo";
        ps = conectar.getConnection().prepareStatement(sql);
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public List<x_hijos_familiares> listFamilyAcomp() {
        List<x_hijos_familiares> listFamilyAcomp = new ArrayList<>();
        sql = "select hf.hijosfamili_id, pe.persona_cedula, pe.persona_nombre,pe.persona_apellido, pe.persona_fecha_nac,fm.parentesco,fm.edad\n"
                + "from x_hijos_familares hf join familiares fm\n"
                + "on fm.familiares_id = hf.familiares_id join persona pe\n"
                + "on pe.persona_codigo = fm.persona_codigo \n"
                + "where fm.estado = true;";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                x_hijos_familiares i = new x_hijos_familiares();
                i.setXhijosFamili_id(rs.getInt("hijosfamili_id"));
                i.setPersona_cedula(rs.getString("persona_cedula"));
                i.setPersona_nombre(rs.getString("persona_nombre"));
                i.setPersona_apellido(rs.getString("persona_apellido"));
                i.setPersona_fecha_nac(rs.getDate("persona_fecha_nac"));
                i.setEdadFam(rs.getInt("edad"));
                i.setParentescoFam(rs.getString("parentesco"));
                listFamilyAcomp.add(i);
            }
            rs.close();
            conectar.cerrarConexion();
            return listFamilyAcomp;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean actuFamlyAcomp() throws SQLException {
        sql = "UPDATE familiares SET \n"
                + "parentesco=' " + getParentescoFam() + "'\n"
                + "WHERE familiares_id='" + getFamiliares_id() + "';";
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarPerAcomp() {
        sql = "UPDATE persona SET ";
        sql += "persona_nombre='" + getPersona_nombre() + "', ";
        sql += "persona_apellido='" + getPersona_apellido() + "'";
        sql += "persona_apellido='" + getPersona_apellido() + "'";
        sql += "persona_apellido='" + getPersona_apellido() + "'";
        sql += " WHERE persona_cedula='" + getPersona_cedula() + "'";

        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public List<x_hijos_familiares> listFamilyAcompBusc(String texto) {
        List<x_hijos_familiares> listFamilyAcompBusc = new ArrayList<>();
        sql = "select hf.hijosfamili_id, pe.persona_cedula, pe.persona_nombre,pe.persona_apellido, pe.persona_fecha_nac,fm.parentesco,fm.edad\n"
                + "from x_hijos_familares hf join familiares fm\n"
                + "on fm.familiares_id = hf.familiares_id join persona pe\n"
                + "on pe.persona_codigo = fm.persona_codigo \n"
                + "where fm.estado = true "
                + "where fm.estado = true and pe.persona_cedula like '" + texto + "%'\n"
                + " or pe.persona_nombre like '" + texto + "%'\n"
                + " or pe.persona_apellido like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                x_hijos_familiares i = new x_hijos_familiares();
                i.setXhijosFamili_id(rs.getInt("hijosfamili_id"));
                i.setPersona_cedula(rs.getString("persona_cedula"));
                i.setPersona_nombre(rs.getString("persona_nombre"));
                i.setPersona_apellido(rs.getString("persona_apellido"));
                i.setPersona_fecha_nac(rs.getDate("persona_fecha_nac"));
                i.setEdadFam(rs.getInt("edad"));
                i.setParentescoFam(rs.getString("parentesco"));
                listFamilyAcompBusc.add(i);
            }
            rs.close();
            conectar.cerrarConexion();
            return listFamilyAcompBusc;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

      public List<Familiars> obtenerFamil(int codV) { // obtener los datos para datos de familia en ingreso
//        SELECT pr.persona_nombre||' '||pr.persona_apellido, pr.persona_fecha_nac, fm.parentesco  from persona pr 
//          JOIN victima vc ON vc.persona_codigo = pr.persona_codigo JOIN victima_familiares vf 
//          ON vf.victima_codigo = vc.victima_codigo JOIN familiares fm ON fm.familiares_id = vf.familiares_id
//          where vf.victima_codigo = 1; 
        List<Familiars> datos = new ArrayList();
//        sql = "SELECT pr.persona_codigo, pr.persona_nombre||' '||pr.persona_apellido, pr.persona_fecha_nac, fm.parentesco, fm.edad  from persona pr "
//                + "JOIN victima vc ON vc.persona_codigo = pr.persona_codigo JOIN x_victima_familiares vf "
//                + "ON vf.victima_codigo = vc.victima_codigo JOIN familiares fm ON fm.familiares_id = vf.familiares_id "
//                + "where vf.victima_codigo = " + codV + ";";
        sql = " SELECT vf.victifamili_id,pr.persona_cedula, pr.persona_nombre||' '||pr.persona_apellido, pr.persona_fecha_nac, fm.parentesco, date_part('year',age(pr.persona_fecha_nac)) as edad  \n"
                + "from x_victima_familiares vf join familiares fm\n"
                + "on vf.familiares_id = fm.familiares_id join persona pr\n"
                + "on pr.persona_codigo = fm.persona_codigo "
                + "where vf.victima_codigo = " + codV + " and fm.estado = true;";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Familiars fm = new Familiars();
                fm.setFamiliares_id(rs.getInt(1));
                fm.setPersona_cedula(rs.getString(2));
                fm.setPersona_nombre(rs.getString(3));
                fm.setPersona_fecha_nac(rs.getDate(4));
                fm.setParentescoFam(rs.getString(5));
                fm.setEdad((Integer.parseInt(String.valueOf(rs.getString("edad")))));
                datos.add(fm);
            }
            rs.close();
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            conectar.cerrarConexion();
            return null;
        }
    }
    
     public List<Familiars> obtenerFamilAll() { 
        List<Familiars> datos = new ArrayList();
        sql = " SELECT vf.victifamili_id,pr.persona_cedula, pr.persona_nombre,pr.persona_apellido, pr.persona_fecha_nac, fm.parentesco, Extract(year from age(current_date,pr.persona_fecha_nac ))as edad\n"
                + "from x_victima_familiares vf join familiares fm\n"
                + "on vf.familiares_id = fm.familiares_id join persona pr\n"
                + "on pr.persona_codigo = fm.persona_codigo "
                + "where fm.estado = true;";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Familiars fm = new Familiars();
                fm.setFamiliares_id(rs.getInt(1));
                fm.setPersona_cedula(rs.getString(2));
                fm.setPersona_nombre(rs.getString(3));
                fm.setPersona_apellido(rs.getString(4));
                fm.setPersona_fecha_nac(rs.getDate(5));
                fm.setParentescoFam(rs.getString(6));
                fm.setEdad((Integer.parseInt(String.valueOf(rs.getString("edad")))));
                datos.add(fm);
            }
            rs.close();
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            conectar.cerrarConexion();
            return null;
        }
    }
     
     public List<Familiars> AcompFamilBuscar(String texto) { 
        List<Familiars> datos = new ArrayList();
        sql = " SELECT vf.victifamili_id,pr.persona_cedula, pr.persona_nombre,pr.persona_apellido, pr.persona_fecha_nac, fm.parentesco, date_part('year',age(pr.persona_fecha_nac)) as edad \n"
                + "from x_victima_familiares vf join familiares fm\n"
                + "on vf.familiares_id = fm.familiares_id join persona pr\n"
                + "on pr.persona_codigo = fm.persona_codigo "
                + "where fm.estado = true and pr.persona_cedula like '" + texto + "%'\n"
                + " or pr.persona_nombre like '" + texto + "%'\n"
                + " or pr.persona_apellido like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Familiars fm = new Familiars();
                fm.setFamiliares_id(rs.getInt(1));
                fm.setPersona_cedula(rs.getString(2));
                fm.setPersona_nombre(rs.getString(3));
                fm.setPersona_apellido(rs.getString(4));
                fm.setPersona_fecha_nac(rs.getDate(5));
                fm.setParentescoFam(rs.getString(6));
                fm.setEdad((Integer.parseInt(String.valueOf(rs.getString("edad")))));
                datos.add(fm);
            }
            rs.close();
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            conectar.cerrarConexion();
            return null;
        }
    }

     public boolean eliminarFamAcom() {
        sql = "UPDATE familiares SET estado = 'false' WHERE familiares_id='" + getFamiliares_id()+ "'";
        return conectar.noQuery(sql) == true;
    } 
     
    public int maxIdVF() {
        int id = 0;
        try {
            sql = "select max(victifamili_id) from x_victima_familiares ;";
            re = conectar.query(sql);
            while (re.next()) {
                id = (re.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
            conectar.cerrarConexion();
        }
        id = id + 1;
        return id;
    }
}
