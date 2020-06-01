package marylove.DBmodelo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import marylove.conexion.ConexionHi;
import marylove.models.Familiars;
import marylove.models.Ingreso;

public class IngresoDB extends Ingreso {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    ArrayList<String> anio;
    String sql = "";

    public IngresoDB(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha);
    }

    public IngresoDB(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
    }

    public IngresoDB(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }

    public IngresoDB(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public IngresoDB(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public IngresoDB(int ingreso_id, int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(ingreso_id, victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public IngresoDB() {
    }

    public boolean IngresarDormitorioReferido() throws SQLException {
        sql = "INSERT INTO ingreso"
                + "(victima_codigo,personal_codigo,asignacion_dormitorio, referidapor,ingreso_fecha,ingreso_estado)"
                + "VALUES (" + getVictima_codigo() + "," + getPersonal_codigo() + ",'" + getAsignacion_dormitorio() + "','" + getReferidapor() + "','" + getIngreso_fecha() + "','a')";
        ps = conectar.getConnection().prepareStatement(sql);
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizar() {
        sql = "update ingreso set asignacion_dormitorio ='" + getAsignacion_dormitorio() +"', "
                + "referidapor ='"+ getReferidapor()+ "' "
                + "where ingreso_id ="+getIngreso_id()+"";

        if (conectar.noQuery(sql) == true) {
            conectar.cerrarConexion();
            return true;

        } else {
            conectar.cerrarConexion();
            return false;
        }
    }

    public ArrayList obtenerAnio() throws SQLException {
        anio = new ArrayList<>();
        sql = "select distinct extract(year from ingreso_fecha) from ingreso order by  extract(year from ingreso_fecha);";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            anio.add(re.getString(1));
        }
        conectar.cerrarConexion();
        return anio;

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
        conectar.cerrarConexion();
        return user;
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

    ////////////
    public List<Ingreso> listarDormRefEdit() {
        List<Ingreso> listarDormRefEdit = new ArrayList<>();
        sql = "select i.ingreso_id,pe.persona_cedula,pe.persona_nombre,pe.persona_apellido, i.asignacion_dormitorio, i.referidapor, i.ingreso_fecha\n"
                + "from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo inner join ingreso i\n"
                + "on i.victima_codigo = vc.victima_codigo"
                + " where ingreso_estado = 'a';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Ingreso i = new Ingreso();
                i.setIngreso_id(rs.getInt("ingreso_id"));
                i.setPersona_cedula(rs.getString("persona_cedula"));
                i.setPersona_nombre(rs.getString("persona_nombre"));
                i.setPersona_apellido(rs.getString("persona_apellido"));
                i.setAsignacion_dormitorio(rs.getString("asignacion_dormitorio"));
                i.setReferidapor(rs.getString("referidapor"));
                i.setIngreso_fecha(rs.getDate("ingreso_fecha"));
                listarDormRefEdit.add(i);
            }
            rs.close();
            conectar.cerrarConexion();
            return listarDormRefEdit;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Ingreso> BuscarDormRefEdit(String texto) {
        List<Ingreso> listarDormRefEdit = new ArrayList<>();
        sql = "select i.ingreso_id,pe.persona_cedula,pe.persona_nombre,pe.persona_apellido, i.asignacion_dormitorio, i.referidapor, i.ingreso_fecha\n"
                + "from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo inner join ingreso i\n"
                + "on i.victima_codigo = vc.victima_codigo\n"
                + "where ingreso_estado = 'a' and pe.persona_cedula like '" + texto + "%'\n"
                + " or pe.persona_nombre like '" + texto + "%'\n"
                + " or pe.persona_apellido like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Ingreso i = new Ingreso();
                i.setIngreso_id(rs.getInt("ingreso_id"));
                i.setPersona_cedula(rs.getString("persona_cedula"));
                i.setPersona_nombre(rs.getString("persona_nombre"));
                i.setPersona_apellido(rs.getString("persona_apellido"));
                i.setAsignacion_dormitorio(rs.getString("asignacion_dormitorio"));
                i.setReferidapor(rs.getString("referidapor"));
                i.setIngreso_fecha(rs.getDate("ingreso_fecha"));
                listarDormRefEdit.add(i);
            }
            rs.close();
            return listarDormRefEdit;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            conectar.cerrarConexion();
            return null;
        }
    }
    
    public boolean eliminarIngreso() {
        sql = "UPDATE ingreso SET ingreso_estado = 'd' WHERE ingreso_id='" + getIngreso_id() + "'";
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }
}
