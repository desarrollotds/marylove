package marylove.DBmodelo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
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
import marylove.models.Egreso;

public class EgresoDB extends Egreso {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    //variables globales
    String sql = "";
    List<Egreso> listaEgresos;

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, byte croquiz, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String celarEgreso, String telefonoEgreso, String egresoEstaso) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, croquiz, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, celarEgreso, telefonoEgreso, egresoEstaso);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, byte croquiz, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String celarEgreso, String telefonoEgreso, String egresoEstaso, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_estadocivil, char persona_sexo) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, croquiz, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, celarEgreso, telefonoEgreso, egresoEstaso, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_sexo);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, byte croquiz, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String celarEgreso, String telefonoEgreso, String egresoEstaso, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, croquiz, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, celarEgreso, telefonoEgreso, egresoEstaso, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, byte croquiz, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String celarEgreso, String telefonoEgreso, String egresoEstaso, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, croquiz, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, celarEgreso, telefonoEgreso, egresoEstaso, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, byte croquiz, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String celarEgreso, String telefonoEgreso, String egresoEstaso, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, croquiz, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, celarEgreso, telefonoEgreso, egresoEstaso, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, byte croquiz, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String celarEgreso, String telefonoEgreso, String egresoEstaso, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, croquiz, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, celarEgreso, telefonoEgreso, egresoEstaso, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, byte croquiz, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String celarEgreso, String telefonoEgreso, String egresoEstaso, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, croquiz, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, celarEgreso, telefonoEgreso, egresoEstaso, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public EgresoDB(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, byte croquiz, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String celarEgreso, String telefonoEgreso, String egresoEstaso, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, fis, longBytes, croquis, croquiz, canton, provincia, per_refe_parentesco, telefono, personal_codigo, direccion, celarEgreso, telefonoEgreso, egresoEstaso, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public EgresoDB() {
    }

    public boolean IngresarEgreso() throws SQLException {
        boolean ingre = true;
        try {
            sql = "INSERT INTO public.egreso"
                    + "(victima_codigo,personal_codigo, egreso_fecha,egreso_situacion,canton,provincia,per_refe_parentesco, "
                    + "telefono,direccion,telefono_egreso, celular_egreso,egreso_estado, croquis)"
                    + "VALUES (" + getVictima_codigo() + "," + getPersonal_codigo() + ",'" + getEgreso_fecha() + "','"
                    + getEgreso_situacion() + "','" + getCanton() + "','" + getProvincia() + "','" + getPer_refe_parentesco()
                    + "','" + getTelefono() + "','" + getDireccion() + "','" + getTelefonoEgreso() + "','" + getCelarEgreso() + "','a',?)";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.setBinaryStream(1, getFis(), getLongBytes());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar Egreso: " + ex.getMessage());
            ingre = false;
        }
        conectar.cerrarConexion();
        return ingre;
    }

    public List<Egreso> listaEgresos() {
        listaEgresos = new ArrayList<>();
        sql = "select e.egreso_codigo,pe.persona_cedula,pe.persona_nombre,pe.persona_apellido, e.egreso_situacion, \n"
                + "e.canton, e.provincia, e.per_refe_parentesco, e.telefono,e.direccion,e.egreso_fecha,telefono_egreso, \n"
                + " celular_egreso\n"
                + "from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo inner join egreso e\n"
                + "on e.victima_codigo = vc.victima_codigo\n"
                + "where e.egreso_estado = 'a';";
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
                e.setEgreso_fecha(rs.getDate("egreso_fecha"));
                e.setTelefonoEgreso(rs.getString("telefono_egreso"));
                e.setCelarEgreso(rs.getString("celular_egreso"));
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
            sql = "select max(ingreso_id) from egreso ;";
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

    public boolean actualizarEgresoCroq() {
        boolean ingre = false;
        try {
            sql = "UPDATE egreso SET ";
            sql += "egreso_situacion='" + getEgreso_situacion() + "', ";
            sql += "canton='" + getCanton() + "', ";
            sql += "provincia='" + getProvincia() + "', ";
            sql += "per_refe_parentesco='" + getPer_refe_parentesco() + "', ";
            sql += "telefono='" + getTelefono() + "', ";
            sql += "direccion='" + getDireccion() + "', ";
            //sql += "egreso_fecha='" + getEgreso_fecha() + "', ";
            sql += "telefono_egreso='" + getTelefonoEgreso() + "', ";
            sql += "celular_egreso='" + getCelarEgreso() + "', ";
            sql += "croquis = ?";
            sql += " WHERE egreso_codigo='" + getEgreso_codigo() + "'";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.setBinaryStream(1, getFis(), getLongBytes());
            ps.execute();
            ingre = true;
        } catch (Exception ex) {
            System.out.println("Error al editar Egreso " + ex.getMessage());
            ingre = false;
        }
        conectar.cerrarConexion();
        return ingre;
    }
    public boolean actualizarEgreso() {
        boolean ingre = false;
        try {
            sql = "UPDATE egreso SET ";
            sql += "egreso_situacion='" + getEgreso_situacion() + "', ";
            sql += "canton='" + getCanton() + "', ";
            sql += "provincia='" + getProvincia() + "', ";
            sql += "per_refe_parentesco='" + getPer_refe_parentesco() + "', ";
            sql += "telefono='" + getTelefono() + "', ";
            sql += "direccion='" + getDireccion() + "', ";
            //sql += "egreso_fecha='" + getEgreso_fecha() + "', ";
            sql += "telefono_egreso='" + getTelefonoEgreso() + "', ";
            sql += "celular_egreso='" + getCelarEgreso() + "'; ";
            sql += " WHERE egreso_codigo='" + getEgreso_codigo() + "'";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            ingre = true;
        } catch (Exception ex) {
            System.out.println("Error al editar Egreso " + ex.getMessage());
            ingre = false;
        }
        conectar.cerrarConexion();
        return ingre;
    }

    public List<Egreso> buscarEgreso(String texto) throws SQLException {
        List<Egreso> buscarEgreso = new ArrayList();
        System.out.println("testoDB: " + texto);
        sql = "select e.egreso_codigo,pe.persona_cedula,pe.persona_nombre,pe.persona_apellido, e.egreso_situacion, "
                + "e.canton, e.provincia, e.per_refe_parentesco, e.telefono,e.direccion,e.egreso_fecha,e.telefono_egreso,"
                + "e.celular_egreso \n"
                + "from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo inner join egreso e\n"
                + "on e.victima_codigo = vc.victima_codigo\n"
                + "where egreso_estado = 'a' and persona_cedula like '" + texto + "%'\n"
                + " or persona_nombre like '" + texto + "%'\n"
                + " or persona_apellido like '" + texto + "%'\n"
                + " or canton like '" + texto + "%'\n"
                + " or provincia like '" + texto + "%';";
        System.out.println("persona like '" + texto + "%");
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
                e.setEgreso_fecha(rs.getDate("egreso_fecha"));
                e.setTelefonoEgreso(rs.getString("telefono_egreso"));
                e.setCelarEgreso(rs.getString("celular_egreso"));
                buscarEgreso.add(e);
            }
            rs.close();
            return buscarEgreso;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean EliminarEgreso() {
        sql = "UPDATE egreso SET egreso_estado = 'd' WHERE egreso_codigo='" + getEgreso_codigo() + "'";
        System.out.println(getEgreso_codigo());
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }
    
      public ImageIcon agregaImagen(String idp) {
        sql = "select croquis from egreso WHERE egreso_estado = 'a' and egreso_codigo='" + idp + "'";
        InputStream is;
        ImageIcon foto;
        ImageIcon newicon = null;
        try {
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                is = rs.getBinaryStream(1);
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newImg = img.getScaledInstance(140, 150, java.awt.Image.SCALE_SMOOTH);
                newicon = new ImageIcon(newImg);
            }
            rs.close();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay imagen a mostrar");
        }
         if (conectar.noQuery(sql) == true) {
            return newicon;
        } else {
            return newicon;
        }
    }
      public ImageIcon AmpliarImagen(String idp) {
        sql = "select croquis from egreso WHERE egreso_estado = 'a' and egreso_codigo='" + idp + "'";
        InputStream is;
        ImageIcon foto;
        ImageIcon newicon = null;
        try {
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                is = rs.getBinaryStream(1);
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newImg = img.getScaledInstance(1200, 700, java.awt.Image.SCALE_SMOOTH);
                newicon = new ImageIcon(newImg);
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay imagen a mostrar");
        }
         if (conectar.noQuery(sql) == true) {
            return newicon;
        } else {
            return newicon;
        }
    }
}
