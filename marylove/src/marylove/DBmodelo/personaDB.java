package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.conexion.ConexionHi;
import marylove.models.Persona;

/**
 *
 * @author vasquez
 */
public class personaDB extends Persona {

    private static List<Persona> listaPersona = new ArrayList<>();
    private static int persona_codigo_static;
    private static int persona_agresor_static;
    private static int persona_cont_emerg_static;
    PreparedStatement ps;
    ResultSet re;
    boolean ingreso = true;
    String sql = "";
    //variables globales para los metodos
    int codigo_per = 0;
    ArrayList<Persona> personaescogida;
    Persona p;
    int id;

    ConexionHi conectar = new ConexionHi();

    public personaDB() {
    }

    public personaDB(String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }//constructor para insertar el contacto de emergencia

    public personaDB(int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public personaDB(String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public static List<Persona> getListaPersona() {
        return listaPersona;
    }

    public static void setListaPersona(List<Persona> listaPersona) {
        personaDB.listaPersona = listaPersona;
    }

    public static int getPersona_codigo_static() {
        return persona_codigo_static;
    }

    public static void setPersona_codigo_static(int persona_codigo_static) {
        personaDB.persona_codigo_static = persona_codigo_static;
    }

    public static int getPersona_agresor_static() {
        return persona_agresor_static;
    }

    public static void setPersona_agresor_static(int persona_agresor_static) {
        personaDB.persona_agresor_static = persona_agresor_static;
    }

    public static int getPersona_cont_emerg_static() {
        return persona_cont_emerg_static;
    }

    public static void setPersona_cont_emerg_static(int persona_cont_emerg_static) {
        personaDB.persona_cont_emerg_static = persona_cont_emerg_static;
    }

    public int ingresarPersonaContacEmerg() throws SQLException {
        codigo_per = 0;
        String cedula = "CE-C" + obtenerIdPersona() + 2 + "";
        sql = "INSERT INTO public.persona(persona_cedula,persona_nombre,"
                + "persona_telefono,persona_celular)"
                + "VALUES('" + cedula + "','" + getPersona_nombre()
                + "','" + getPersona_telefono() + "','')returning persona_codigo;";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        conectar.cerrarConexion();
        while (re.next()) {
            persona_cont_emerg_static = re.getInt(1);
            codigo_per = re.getInt(1);
        }
        return codigo_per;
    }

    public int ingresarPersona() {
        codigo_per = 0;
        try {

            sql = "INSERT INTO persona( persona_cedula, persona_nombre, persona_apellido,"
                    + " persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, "
                    + "persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, "
                    + "persona_nivel_acad_otros, persona_lugar_trabajo,persona_referencia)	VALUES ( '" + getPersona_cedula() + "', "
                    + "'" + getPersona_nombre() + "', '" + getPersona_apellido() + "', '" + getPersona_fecha_nac() + "', "
                    + getPersona_ocupacion() + ", " + getPersona_nivel_acad() + ", " + getPersona_est_migr() + ", '"
                    + getPersona_telefono() + "', '" + getPersona_celular() + "'," + getPersona_estadocivil() + ", "
                    + getPersona_nacionalidad() + ",true, '" + getPersona_sexo() + "','"
                    + getPersona_nivel_acad_otros() + "','" + getPersona_lugar_trabajo() + "','" + getPersona_referencia()
                    + "')returning persona_codigo;";
            System.out.println(sql);
            
            re = conectar.query(sql);
            while (re.next()) {

                persona_codigo_static = re.getInt(1);
                codigo_per = re.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(personaDB.class.getName()).log(Level.SEVERE, null, ex);
        }


        return codigo_per;
    }

    public int ingresarPersonaAgresor() {

        codigo_per = 0;
        try {

            sql = "INSERT INTO public.persona( persona_cedula, persona_nombre, persona_apellido,"
                    + " persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, "
                    + "persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, "
                    + "persona_nivel_acad_otros, persona_lugar_trabajo,persona_referencia)	VALUES ( '" + getPersona_cedula() + "', "
                    + "'" + getPersona_nombre() + "', '" + getPersona_apellido() + "', '" + getPersona_fecha_nac() + "', "
                    + getPersona_ocupacion() + ", " + getPersona_nivel_acad() + ", " + getPersona_est_migr() + ", '"
                    + getPersona_telefono() + "', '" + getPersona_celular() + "'," + getPersona_estadocivil() + ", "
                    + getPersona_nacionalidad() + ",true, '" + getPersona_sexo() + "','"
                    + getPersona_nivel_acad_otros() + "','" + getPersona_lugar_trabajo() + "','" + getPersona_referencia()
                    + "')returning persona_codigo;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {

                persona_agresor_static = re.getInt(1);
                codigo_per = re.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(personaDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        conectar.cerrarConexion();

        return codigo_per;
    }

    public int verifiCed(ConexionHi con, String ced) { // determinar si la cedula ingresada ya tiene datos 

        int cod_per = 0;
        try {
            sql = "select persona_codigo from Persona where persona_cedula = '" + ced + "';";
            ps = con.getConnection().prepareStatement(sql);
            re = ps.executeQuery();

            while (re.next()) {
                cod_per = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("No existe usuario");
            cod_per = 0;
        }
        con.cerrarConexion();
        return cod_per;
    }

    public int obtenerCod(String ced) {

        int cod = 0;
        try {
            sql = "select persona_codigo from Persona where persona_cedula = '" + ced + "';";
//            ps = conectar.getConnection().prepareStatement(sql);
//            ps = conectar.getConnection().prepareStatement(sql);
//            re = ps.executeQuery();
            re = conectar.query(sql);
            while (re.next()) {
                cod = re.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("No existe usuario");
            cod = 0;
        }
//        conectar.CerrarConexion();
        conectar.cerrarConexion();
        return cod;
    }

    public boolean eliminarPersonaCodigo() {

        try {
            sql = "UPDATE public.persona"
                    + "	SET  persona_estado_actual=false"
                    + "	WHERE persona_codigo=" + persona_codigo_static;
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            conectar.cerrarConexion();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(personaDB.class.getName()).log(Level.SEVERE, null, ex);
            conectar.cerrarConexion();
            return false;
        }
    }

    public boolean verificarExistencia(int cod, String ced) throws SQLException {
        sql = "select * from persona where persona_codigo=" + cod + " and persona_cedula='" + ced + "';";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        conectar.cerrarConexion();
        if (re != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarPersona(int id) {

        try {
            sql = "UPDATE public.persona SET persona_nombre='" + getPersona_nombre() + "', "
                    + "persona_apellido='" + getPersona_apellido() + "', "
                    + "persona_fecha_nac='" + getPersona_fecha_nac() + "', "
                    + "persona_ocupacion=" + getPersona_ocupacion() + ", "
                    + "persona_nivel_acad=" + getPersona_nivel_acad() + ", "
                    + "persona_telefono='" + getPersona_telefono() + "', "
                    + "persona_celular='" + getPersona_cedula() + "', "
                    + "persona_estadocivil=" + getPersona_estadocivil() + ", "
                    + "persona_nacionalidad=" + getPersona_nacionalidad() + ", "
                    + "persona_estado_actual='true', "
                    + "persona_sexo='" + getPersona_sexo() + "', "
                    + "persona_nivel_acad_otros='" + getPersona_nivel_acad_otros() + "', "
                    + "persona_lugar_trabajo='" + getPersona_lugar_trabajo() + "', "
                    + "persona_referencia='" + getPersona_referencia() + "', "
                    + "persona_est_migr=" + getPersona_est_migr() + " "
                    + "WHERE persona_codigo=" + id + ";";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            conectar.cerrarConexion();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(personaDB.class.getName()).log(Level.SEVERE, null, ex);
            conectar.cerrarConexion();
            return false;
        }
    }

    public ArrayList<Persona> obtenerPersonaCodigo(String codigopersona) throws SQLException {

        personaescogida = new ArrayList<>();
        sql = "SELECT * FROM persona where persona_codigo = " + codigopersona + ";";
        re = conectar.query(sql);
        while (re.next()) {
            p = new Persona(re.getInt("persona_codigo"), re.getString("persona_cedula"),
                    re.getString("persona_nombre"), re.getString("persona_apellido"),
                    re.getDate("persona_fecha_nac"), re.getInt("persona_ocupacion"),
                    re.getInt("persona_nivel_acad"), re.getInt("persona_est_migr"),
                    re.getString("persona_telefono"), re.getString("persona_celular"),
                    re.getInt("persona_estadocivil"), re.getInt("persona_nacionalidad"),
                    re.getBoolean("persona_estado_actual"), re.getString("persona_sexo").charAt(0),
                    re.getString("persona_nivel_acad_otros"), re.getString("persona_lugar_trabajo"),
                    re.getString("persona_referencia")
            );
            personaescogida.add(p);
        }
        return personaescogida;

    }

    public ArrayList<Persona> obtenerPersonaCedula(String cedula) throws SQLException {

        personaescogida = new ArrayList<>();
        sql = "SELECT * FROM persona where persona_cedula = " + cedula + ";";
        re = conectar.query(sql);

        while (re.next()) {
            p = new Persona(re.getInt("persona_codigo"), re.getString("persona_cedula"),
                    re.getString("persona_nombre"), re.getString("persona_apellido"),
                    re.getDate("persona_fecha_nac"), re.getInt("persona_ocupacion"),
                    re.getInt("persona_nivel_acad"), re.getInt("persona_est_migr"),
                    re.getString("persona_telefono"), re.getString("persona_celular"),
                    re.getInt("persona_estadocivil"), re.getInt("persona_nacionalidad"),
                    re.getBoolean("persona_estado_actual"), re.getString("persona_sexo").charAt(0),
                    re.getString("persona_nivel_acad_otros"), re.getString("persona_lugar_trabajo"),
                    re.getString("persona_referencia")
            );
            personaescogida.add(p);
        }
        conectar.cerrarConexion();
        return personaescogida;

    }

    public boolean buscarPersonaTotal() throws SQLException {
        String sql = "Select persona_codigo, persona_cedula, persona_nombre,persona_apellido from persona where persona_estado_actual = true";
        re = conectar.query(sql);
        Persona per;
        while (re.next()) {
            per = new Persona();
            per.setPersona_codigo(re.getInt("persona_codigo"));
            per.setPersona_cedula(re.getString("persona_cedula"));
            per.setPersona_nombre(re.getString("persona_nombre"));
            per.setPersona_apellido(re.getString("persona_apellido"));
            listaPersona.add(per);
        }
        return true;
    }

    public boolean buscarPorParametroPersona(String nombre, String apellido) throws SQLException {

        String sql = "";
        if (!apellido.trim().equals("")) {
            sql = "Select persona_codigo, persona_cedula, persona_nombre,persona_apellido from persona where  persona_apellido LIKE '%" + apellido + "%' and  persona_estado_actual=true";
        }
        if (!nombre.trim().equals("")) {
            sql = "Select persona_codigo, persona_cedula, persona_nombre,persona_apellido from persona where persona_nombre LIKE '%" + nombre + "%'  and  persona_estado_actual = true";

        }
        if (nombre.trim().equals("") && apellido.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese Datos de Busqueda");
        }
        if (!nombre.trim().equals("") && !apellido.trim().equals("")) {

            sql = "Select persona_codigo, persona_cedula, persona_nombre,persona_apellido from persona where persona_nombre LIKE '%" + nombre + "%' and persona_apellido LIKE '%" + apellido + "%' and  persona_estado_actual = true";
        }

        System.out.println(sql);
        try {
            re = conectar.query(sql);
            Persona per;
            while (re.next()) {
                per = new Persona();
                per.setPersona_codigo(re.getInt("persona_codigo"));
                per.setPersona_cedula(re.getString("persona_cedula"));
                per.setPersona_nombre(re.getString("persona_nombre"));
                per.setPersona_apellido(re.getString("persona_apellido"));
                listaPersona.add(per);
            }
        } catch (SQLException e) {
            System.out.println("Sin datos de retorno");
        }
        return true;

    }

    public int obtenerIdPersona() {

        try {

            sql = "select persona_codigo from persona order by persona_codigo desc limit 1;";
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

    public boolean ingrePersona2(Persona pe) {
        boolean ingreso = false;
        try {

            String sql = "INSERT INTO public.persona( persona_cedula, "
                    + "persona_nombre,persona_apellido, persona_fecha_nac, persona_ocupacion ,persona_nivel_acad ,"
                    + " persona_est_migr, persona_telefono,persona_celular, "
                    + "persona_estadocivil, persona_nacionalidad,persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_estado_actual) "
                    + "VALUES ('" + pe.getPersona_cedula() + "','" + pe.getPersona_nombre()
                    + "','" + pe.getPersona_apellido() + "','" + pe.getPersona_fecha_nac() + "',"
                    + pe.getPersona_ocupacion() + "," + pe.getPersona_nivel_acad()
                    + "," + pe.getPersona_est_migr() + ",'" + pe.getPersona_telefono() + "','"
                    + pe.getPersona_celular() + "'," + pe.getPersona_estadocivil() + ","
                    + pe.getPersona_nacionalidad() + ",'" + pe.getPersona_sexo() + "','" + pe.getPersona_nivel_acad_otros() + "','"
                    + pe.getPersona_lugar_trabajo() + "',true);";
            //            ps = conectar.getConection().prepareStatement(sql);
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            conectar.cerrarConexion();
            ingreso = true;
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar Persona " + ex.getMessage());
            ingreso = false;
        }
        return ingreso;
    }
}
