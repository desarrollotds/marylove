package marylove.DBmodelo;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Egreso;
import marylove.models.Persona;

public class EgresoDB extends Egreso {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    //variables globales
    String sql = "";
    List<Egreso> listaEgresos;

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public EgresoDB() {
    }

    public boolean IngresarEgreso() throws SQLException {
        sql = "INSERT INTO public.egreso"
                + "(victima_codigo,personal_codigo, egreso_fecha,egreso_situacion,canton,provincia,per_refe_parentesco, telefono,direccion, croquis)"
                //                + "VALUES ("+getVictima_codigo()+","+getPersonal_codigo()+",'"+getEgreso_fecha()+"','"+getEgreso_situacion()+"','"+getCanton()+"','"+getProvincia()+"','"+getPer_refe_parentesco()+"','"+getTelefono()+"','?')";
                + "VALUES (" + getVictima_codigo() + "," + 1 + ",'" + getEgreso_fecha() + "','" + getEgreso_situacion() + "','" + getCanton() + "','" + getProvincia() + "','" + getPer_refe_parentesco() + "','" + getTelefono() + "','" + getDireccion() + "','?')";

        System.out.println("vict: " + getVictima_codigo());
        System.out.println("Fech: " + getEgreso_fecha());
        System.out.println("situacion: " + getEgreso_situacion());
        System.out.println("canton: " + getCanton());
        System.out.println("provincia: " + getProvincia());
        System.out.println("parentesco: " + getPer_refe_parentesco());
        System.out.println("telef: " + getTelefono());
        System.out.println("croqu: " + getCroquis());
        ps = conectar.getPs(sql);
        ps.setBytes(9, getCroquis());
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Egreso> listaEgresos() {
        listaEgresos = new ArrayList<>();
        sql = "select e.egreso_codigo,pe.persona_cedula,pe.persona_nombre,pe.persona_apellido, e.egreso_situacion, e.canton, e.provincia, e.per_refe_parentesco, e.telefono,e.direccion \n"
                + "from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo inner join egreso e\n"
                + "on e.victima_codigo = vc.victima_codigo;";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Egreso e = new Egreso();
                e.setEgreso_codigo(rs.getInt("egreso_codigo"));
                e.setPersona_cedula(rs.getString("persona_cedula"));
                e.setPersona_nombre(rs.getString("persona_nombre"));
                e.setPersona_apellido(rs.getString("persona_apellido"));
                e.setEgreso_situacion(rs.getString("egreso_situacion"));
                e.setCanton(rs.getString("canton"));
                e.setProvincia(rs.getString("provincia"));
                e.setPer_refe_parentesco(rs.getString("per_refe_parentesco"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                listaEgresos.add(e);
            }
            rs.close();
            conectar.cerrarConexion();
            return listaEgresos;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public int maxId() {
        int id = 0;
        try {
            String sql = "select max(ingreso_id) from egreso ;";
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

    public int verifiUserP(int c_per) { // verifica que perfil es el usuario
        int user = 0;
        try {
            sql = "select * from personal where personal_codigo = " + c_per + ";";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error personal " + ex.getMessage());
            user = 0;
        }
//        conectar.cerrarConexion();
        return user;
    }

    public boolean actualizarEgreso() {
        String sql = "UPDATE egreso SET ";
        sql += "egreso_situacion='" + getEgreso_situacion() + "', ";
        sql += "canton='" + getCanton() + "', ";
        sql += "provincia='" + getProvincia() + "', ";
        sql += "per_refe_parentesco='" + getPer_refe_parentesco() + "',";
        sql += "telefono='" + getTelefono() + "',";
        sql += "direccion='" + getDireccion() + "'";
        sql += " WHERE egreso_codigo='" + getEgreso_codigo() + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Egreso> buscarEgreso(String texto) throws SQLException {
        List<Egreso> buscarEgreso = new ArrayList();
        System.out.println("testoDB: " + texto);
        sql = "select e.egreso_codigo,pe.persona_cedula,pe.persona_nombre,pe.persona_apellido, e.egreso_situacion, e.canton, e.provincia, e.per_refe_parentesco, e.telefono,e.direccion \n"
                + "from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo inner join egreso e\n"
                + "on e.victima_codigo = vc.victima_codigo\n"
                + "where persona_cedula like '" + texto + "%'\n"
                + " or persona_nombre like '" + texto + "%'\n"
                + " or persona_apellido like '" + texto + "%'\n"
                + " or canton like '" + texto + "%'\n"
                + " or provincia like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Egreso e = new Egreso();
                e.setEgreso_codigo(rs.getInt("egreso_codigo"));
                e.setPersona_cedula(rs.getString("persona_cedula"));
                e.setPersona_nombre(rs.getString("persona_nombre"));
                e.setPersona_apellido(rs.getString("persona_apellido"));
                e.setEgreso_situacion(rs.getString("egreso_situacion"));
                e.setCanton(rs.getString("canton"));
                e.setProvincia(rs.getString("provincia"));
                e.setPer_refe_parentesco(rs.getString("per_refe_parentesco"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                listaEgresos.add(e);
            }
            rs.close();
            return buscarEgreso;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    select e.egreso_codigo, pe.persona_nombre||' '||pe.persona_apellido, e.egreso_situacion, e.canton, e.provincia, e.per_refe_parentesco, e.telefono, e.personal_codigo 
//from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo inner join egreso e
//on e.victima_codigo = vc.victima_codigo;
}
