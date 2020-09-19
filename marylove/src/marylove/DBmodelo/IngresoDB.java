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
import marylove.models.Dormitorios;

public class IngresoDB extends Dormitorios {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    ArrayList<String> anio;
    String sql = "";

    public IngresoDB(int dormitorio_id, int victima_codigoDormit, String dormitorio_nombre, Date dormitorio_ingreso, Date dormitorio_salida) {
        super(dormitorio_id, victima_codigoDormit, dormitorio_nombre, dormitorio_ingreso, dormitorio_salida);
    }

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
                + "(victima_codigo,personal_codigo, referidapor,ingreso_fecha,ingreso_estado)"
                + "VALUES (" + getVictima_codigo() + "," + getPersonal_codigo() + ",'" + getReferidapor() + "','" + getIngreso_fecha() + "','a')";
        ps = conectar.getConnection().prepareStatement(sql);
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarDormitorio() throws SQLException {
        sql = "INSERT INTO dormitorios"
                + "(victima_codigo,dormitorio_nombre, dormitorio_ingreso)"
                + "VALUES (" + getVictima_codigo() + ",'" + getDormitorio_nombre() + "','" + getDormitorio_ingreso() + "')";
        ps = conectar.getConnection().prepareStatement(sql);
        System.out.println("sql: agregar Dormitorio: " + sql);
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean dormitorioSalida(int cv, Date fechS, int id) {
        sql = "update dormitorios set dormitorio_salida='" + fechS + "' "
                + "where victima_codigo =" + cv+ "AND dormitorio_id = " + id;

        if (conectar.noQuery(sql) == true) {
            conectar.cerrarConexion();
            return true;

        } else {
            conectar.cerrarConexion();
            return false;
        }
    }

    public Dormitorios mostrarDormitorio(int codVict) {
        Dormitorios user = new Dormitorios();
        try {
            sql = "SELECT d.dormitorio_id, d.dormitorio_nombre, i.referidapor  FROM ingreso i "
                    + "JOIN dormitorios d ON d.victima_codigo = i.victima_codigo "
                    + "WHERE i.ingreso_id = " + codVict;
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user.setDormitorio_id(re.getInt(1));
                user.setDormitorio_nombre(re.getString(2));
                user.setReferidapor(re.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Dormitorio " + ex.getMessage());
            user = null;
        }
        conectar.cerrarConexion();
        return user;
    }

    public boolean actualizar() {//Arreglar 
        sql = "update ingreso set referidapor='" + getReferidapor() + "' "
                + "where ingreso_id = " + getIngreso_id();

        if (conectar.noQuery(sql) == true) {
            conectar.cerrarConexion();
            return true;

        } else {
            conectar.cerrarConexion();
            return false;
        }
    }
    public boolean actualizar(int iID) {//Arreglar 
        sql = "update ingreso set referidapor='" + getReferidapor() + "' "
                + "where ingreso_id = " + iID;

        if (conectar.noQuery(sql) == true) {
            conectar.cerrarConexion();
            return true;

        } else {
            conectar.cerrarConexion();
            return false;
        }
    }

    public boolean actualizarDormitorio() {
        sql = "update dormitorios set dormitorio_nombre ='" + getDormitorio_nombre() + "', "
                + "dormitorio_ingreso='" + getDormitorio_ingreso() + "', "
                + "dormitorio_salida='" + getDormitorio_salida() + "' "
                + "where dormitorio_id =" + getDormitorio_id() + "";

        if (conectar.noQuery(sql) == true) {
            conectar.cerrarConexion();
            return true;

        } else {
            conectar.cerrarConexion();
            return false;
        }
    }
    
     public boolean actualizarDormitorio(int dID, String dNomb) {
        sql = "update dormitorios set dormitorio_nombre ='" + dNomb + "' "
                + "where dormitorio_id =" + dID + "";

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
        re = conectar.query(sql);
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

    public int ingreId(int codV) {
        int id = 0;
        try {
            sql = "select ingreso_id from ingreso WHERE ingreso_estado = 'a' AND victima_codigo = " + codV + ";";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                id = (re.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
        conectar.cerrarConexion();
        return id;
    }

    ////////////
    public List<Dormitorios> listarDormRefEdit() {
        List<Dormitorios> listarDormRefEdit = new ArrayList<>();
        sql = "SELECT i.ingreso_id, i.referidapor, i.ingreso_fecha,  p.persona_cedula, p.persona_nombre, p.persona_apellido, d.dormitorio_nombre,d.dormitorio_ingreso,d.dormitorio_salida,d.dormitorio_id\n"
                + "FROM ingreso i\n"
                + "JOIN victima v ON v.victima_codigo = i.victima_codigo\n"
                + "JOIN persona p ON p.persona_codigo = v.persona_codigo\n"
                + "JOIN dormitorios d ON d.victima_codigo = v.victima_codigo"
                + " where ingreso_estado = 'a';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Dormitorios i = new Dormitorios();
                i.setIngreso_id(rs.getInt("ingreso_id"));
                i.setPersona_cedula(rs.getString("persona_cedula"));
                i.setPersona_nombre(rs.getString("persona_nombre"));
                i.setPersona_apellido(rs.getString("persona_apellido"));
                i.setDormitorio_nombre(rs.getString("dormitorio_nombre"));
                i.setDormitorio_ingreso(rs.getDate("dormitorio_ingreso"));
                i.setDormitorio_salida(rs.getDate("dormitorio_salida"));
                i.setReferidapor(rs.getString("referidapor"));
                i.setIngreso_fecha(rs.getDate("ingreso_fecha"));
                i.setDormitorio_id(rs.getInt("dormitorio_id"));
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

    public List<Dormitorios> BuscarDormRefEdit(String texto) {
        List<Dormitorios> listarDormRefEdit = new ArrayList<>();
        sql = "SELECT i.ingreso_id, i.referidapor, i.ingreso_fecha,  p.persona_cedula, p.persona_nombre, p.persona_apellido, d.dormitorio_nombre,d.dormitorio_ingreso,d.dormitorio_salida,d.dormitorio_id\n"
                + "FROM ingreso i\n"
                + "JOIN victima v ON v.victima_codigo = i.victima_codigo\n"
                + "JOIN persona p ON p.persona_codigo = v.persona_codigo\n"
                + "JOIN dormitorios d ON d.victima_codigo = v.victima_codigo "
                + "where ingreso_estado = 'a' and p.persona_cedula like '" + texto + "%'\n"
                + " or p.persona_nombre like '" + texto + "%'\n"
                + " or p.persona_apellido like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Dormitorios i = new Dormitorios();
                i.setIngreso_id(rs.getInt("ingreso_id"));
                i.setPersona_cedula(rs.getString("persona_cedula"));
                i.setPersona_nombre(rs.getString("persona_nombre"));
                i.setPersona_apellido(rs.getString("persona_apellido"));
                i.setDormitorio_nombre(rs.getString("dormitorio_nombre"));
                i.setDormitorio_ingreso(rs.getDate("dormitorio_ingreso"));
                i.setDormitorio_salida(rs.getDate("dormitorio_salida"));
                i.setReferidapor(rs.getString("referidapor"));
                i.setIngreso_fecha(rs.getDate("ingreso_fecha"));
                i.setDormitorio_id(rs.getInt("dormitorio_id"));
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
        sql = "UPDATE ingreso SET ingreso_estado = 'd' WHERE ingreso_id = " + getIngreso_id();
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarIngreso2(int id) {
        sql = "DELETE ingreso  WHERE ingreso_id= " + id + "";
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public int dorID(int vID) {
        int id = 0;
        try {
            sql = "SELECT dormitorio_id FROM dormitorios where victima_codigo = " + vID;
            re = conectar.query(sql);
            while (re.next()) {
                id = (re.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println("no se pudo obtener el dormitorio id");
        }
        return id;
    }
}
