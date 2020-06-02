package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Familiars;
import marylove.models.x_hijos_familiares;

public class FamiliarsDB extends x_hijos_familiares  {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    int id = 0;

    public FamiliarsDB(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam) {
        super(XhijosFamili_id, XfamiliaresId, XhijoCodig, familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam);
    }

    public FamiliarsDB(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_estadocivil, char persona_sexo) {
        super(XhijosFamili_id, XfamiliaresId, XhijoCodig, familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_sexo);
    }

    public FamiliarsDB(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(XhijosFamili_id, XfamiliaresId, XhijoCodig, familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
    }

    public FamiliarsDB(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(XhijosFamili_id, XfamiliaresId, XhijoCodig, familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
    }

    public FamiliarsDB(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(XhijosFamili_id, XfamiliaresId, XhijoCodig, familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }

    public FamiliarsDB(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(XhijosFamili_id, XfamiliaresId, XhijoCodig, familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public FamiliarsDB(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(XhijosFamili_id, XfamiliaresId, XhijoCodig, familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public FamiliarsDB(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(XhijosFamili_id, XfamiliaresId, XhijoCodig, familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public FamiliarsDB(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig) {
        super(XhijosFamili_id, XfamiliaresId, XhijoCodig);
    }

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
                + getPersona_fecha_nac() + "')returning persona_codigo;";
        System.out.println(sql);

        re = conectar.query(sql);

        while (re.next()) {
            id = re.getInt(1);
        }
        return true;
    }

    public boolean IngresarFamily2() throws SQLException {
        sql = "insert into familiares(persona_codigo,parentesco,estado)\n"
                + "VALUES (" + id + ",'" + getParentescoFam() + "',true)";
        System.out.println("sql2: " + sql);
        ps = conectar.getConnection().prepareStatement(sql);
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
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
        sql = "SELECT fm.familiares_id, pr.persona_nombre||' '||pr.persona_apellido, pr.persona_fecha_nac, fm.parentesco  from persona pr "
                + "JOIN victima vc ON vc.persona_codigo = pr.persona_codigo JOIN victima_familiares vf "
                + "ON vf.victima_codigo = vc.victima_codigo JOIN familiares fm ON fm.familiares_id = vf.familiares_id "
                + "where vf.victima_codigo = " + codV + ";";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Familiars fm = new Familiars();
                fm.setFamiliares_id(rs.getInt(1));
                fm.setPersona_nombre(rs.getString(2));
                fm.setPersona_fecha_nac(rs.getDate(3));
                fm.setParentescoFam(rs.getString(4));
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
}
