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
import marylove.models.Hijos;
import marylove.vista.FichaAnamnesis;

public class HijosDB extends Hijos {

    //VARIABLES STATIC
    private static List<HijosDB> arrayHijos = new ArrayList<>();
    private static List<Hijos> buscaHijos = new ArrayList<>();
    //variabñes DB
    public static int codigopersona = 0;
    public static int codigo_hijo_static;
    ConexionHi conectar = new ConexionHi();// = new ConexionHi();
    private String sql = "";
    PreparedStatement ps;
    ResultSet re = null;
    victimaDB vdb;
    //varibles globales

    public HijosDB(int persona_codigo, int victima_codigo, String hijo_anioescolar, int institucion_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_codigo, victima_codigo, hijo_anioescolar, institucion_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public HijosDB(String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public HijosDB() {
    }

    //-----------------------------------------------------------------------------------------------------------
    public void BusquedaHijos(int codigovictima) {
        sql = "select hj.hijo_codigo, pe.persona_cedula , pe.persona_nombre, pe.persona_apellido from hijos hj join persona pe USING (persona_codigo) where   hj.victima_codigo=" + codigovictima;
        System.out.println(sql);
        try {
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                Hijos hijo = new Hijos();

                hijo.setHijo_codigo(re.getInt(1));
                hijo.setPersona_cedula(re.getString(2));
                hijo.setPersona_nombre(re.getString(3));
                hijo.setPersona_apellido(re.getString(4));
                buscaHijos.add(hijo);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        conectar.cerrarConexion();
    }

    public void HijosAnamnesis(Hijos h) {
        sql = "SELECT  h.persona_codigo, h.victima_codigo, h.hijo_anioescolar, h.hijo_estado, h.padre_id, h.padre_agresor, h.hijo_estado_ingreso, h.institucion_codigo, p.persona_cedula, p.persona_nombre, p.persona_apellido,Extract(year from age( current_date , p.persona_fecha_nac)), p.persona_nacionalidad, p.persona_fecha_nac,h.padre_agresor FROM hijos h join persona p using(persona_codigo) where hijo_codigo=" + FichaAnamnesis.txtCodigo.getText() + "; ";
        System.out.println(sql);
        try {
            re = conectar.query(sql);

            while (re.next()) {
                h.setPersona_codigo(re.getInt(1));
                h.setVictima_codigo(re.getInt(2));
                h.setHijo_anioescolar(re.getString(3));
                h.setHijo_estado(re.getString(4));
                h.setPadre_id(re.getInt(5));
                h.setPadre_agresor(re.getBoolean(6));
                h.setHijo_estado_ingreso(re.getString(7));
                h.setInstitucion(re.getInt(8));
                h.setPersona_cedula(re.getString(9));
                h.setPersona_nombre(re.getString(10));
                h.setPersona_apellido(re.getString(11));
                h.setEdad(Integer.parseInt(String.valueOf(re.getString(12))));
                h.setPersona_nacionalidad(re.getInt(13));
                h.setPersona_fecha_nac(re.getDate(14));
                h.setPadreAgresor(re.getBoolean(15));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        conectar.cerrarConexion();
    }

    public static List<Hijos> getBuscaHijos() {
        return buscaHijos;
    }

    public static void setBuscaHijos(List<Hijos> buscaHijos) {
        HijosDB.buscaHijos = buscaHijos;
    }

    //------------------------------------------------------------------------------------------------------------
    public static List<HijosDB> getArrayHijos() {
        return arrayHijos;
    }

    public static void setArrayHijos(List<HijosDB> arrayHijos) {
        HijosDB.arrayHijos = arrayHijos;
    }

    public String obtener_anioescolar(int id) {
        String res = "";
        sql = "Select hijo_anioescolar from hijos where hijo_codigo=" + 1 + ";";
        try {
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conectar.cerrarConexion();
            while (re.next()) {
                res = re.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HijosDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public boolean agregarPrsonaHijo() throws SQLException {
        sql = "INSERT INTO persona( persona_cedula, persona_nombre, persona_apellido,"
                + " persona_fecha_nac, persona_nivel_acad, persona_estado_actual, persona_sexo"
                + " )VALUES ( '" + getPersona_cedula() + "', "
                + "'" + getPersona_nombre() + "', '" + getPersona_apellido() + "', '" + getPersona_fecha_nac() + "' "
                + ", " + getPersona_nivel_acad() + ", 'true','" + getPersona_sexo() + "') returning persona_codigo;";
        System.out.println(sql);

        re = conectar.query(sql);

        while (re.next()) {
            codigopersona = re.getInt(1);
        }
        return true;

    }

    public boolean insetarHijo() throws SQLException {

        sql = "INSERT INTO hijos( persona_codigo, victima_codigo, hijo_anioescolar, institucion_codigo"
                // + " )VALUES (" + codigopersona + ", " + vdb.getCodigo_victima_static() + ",'" + getHijo_anioescolar() + "'," + getInstitucion_codigo() + ") returning hijo_codigo;";
                + " )VALUES (" + codigopersona + ", " + getVictima_codigo() + ",'" + getHijo_anioescolar() + "'," + getInstitucion_codigo() + ") returning hijo_codigo;";

        System.out.println(sql);
        re = conectar.query(sql);

        while (re.next()) {
            codigo_hijo_static = re.getInt(1);
        }
        return true;
    }

    public boolean consultaHijosVictimas() {
        try {
            sql = "select p.persona_cedula, p.persona_nombre, p.persona_apellido, p.persona_sexo, p.persona_fecha_nac from persona p,  hijos h where h.victima_codigo=" + vdb.getCodigo_victima_static() + " and h.persona_codigo=p.persona_codigo ";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conectar.cerrarConexion();
            HijosDB hijos;
            while (re.next()) {
                hijos = new HijosDB();
                hijos.setPersona_cedula(re.getString(1));
                hijos.setPersona_nombre(re.getString(2));
                hijos.setPersona_apellido(re.getString(3));
                hijos.setPersona_sexo(re.getString(4).charAt(0));
                hijos.setPersona_fecha_nac(re.getDate(5));
                arrayHijos.add(hijos);

            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return true;
    }

    //METODOS DE LA FICHA ANAMNESIS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //1.1 DATOS DE IDENTIFICACIÓN
    public boolean actualizacionDatosIdenificacion(int persona_codigo) {
        sql = new String();
        sql = "UPDATE persona SET"
                + " persona_fecha_nac = '" + getPersona_fecha_nac() + "'"
                + ", persona_nacionalidad = " + getPersona_nacionalidad() + ""
                + " WHERE persona_codigo = " + persona_codigo;

        if (conectar.noQuery(sql) == true) {
            System.out.println("1.1 Se actualizó la fecha de nacimiento y la nacionalidad (Ubicación del método: HijosDB)");
            return true;
        } else {
            System.out.println("Error 1.1 No se pudo actualizar los datos personales de Nacimiento (Ubicación del método: HijosDB)");
            return false;
        }
    }

    //1.2 DATOS DE LA MADRE Y PADRE Y 1.3 SITUACIÓN EN LA QUE INGRESA EL NNA
    public boolean actualizarDatosPadreMadre(int hijo_codigo) {
        sql = "UPDATE hijos SET"
                + " padre_agresor = '" + isPadre_agresor() + "'"
                + ", hijo_estado_ingreso = '" + getHijo_estado_ingreso() + "'"
                + " WHERE hijo_codigo = " + hijo_codigo;

        if (conectar.noQuery(sql) == true) {
            System.out.println("1.2 y 1.3 Se actualizaron los datos de hijos, campos padre_agresor, estado_ingresoNNA (Ubicación del método: HijosDB)");
            return true;
        } else {
            System.out.println("Error 1.2 y 1.3 No se pudo actualizar los datos de hijos (Ubicación del método: HijosDB)");
            return false;
        }
    }

    public List<Hijos> listarHijosCod(String ced) throws SQLException {
        List<Hijos> listarHijosCod = new ArrayList<>();
        sql = "select h.hijo_codigo, per.persona_nombre, per.persona_apellido, per.persona_fecha_nac, Extract(year from age(current_date,per.persona_fecha_nac ))as edad from persona per\n"
                + "inner join hijos h\n"
                + "on per.persona_codigo = h.persona_codigo\n"
                + "where hijos_estado = true";
        ResultSet rs = conectar.query(sql);
        try {

            while (rs.next()) {
                System.out.println("rs.next");
                Hijos h = new Hijos();
                h.setHijo_codigo(rs.getInt("hijo_codigo"));
                h.setPersona_nombre(rs.getString("persona_nombre"));
                h.setPersona_apellido(rs.getString("persona_apellido"));
                h.setPersona_fecha_nac(rs.getDate("persona_fecha_nac"));
                h.setEdad((Integer.parseInt(String.valueOf(rs.getString("edad")))));
                listarHijosCod.add(h);
            }
            rs.close();
            conectar.cerrarConexion();
            return listarHijosCod;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean eliminarHijos() {
        sql = "UPDATE hijos SET hijos_estado = 'false' WHERE hijo_codigo='" + getHijo_codigo() + "'";
        return conectar.noQuery(sql) == true;
    }

    public List<Hijos> obtenListHijos(int codigovictima) {
        List<Hijos> listHijos = new ArrayList();
        sql = "select hj.hijo_codigo, pe.persona_nombre,pe.persona_apellido, "
                + "pe.persona_fecha_nac, date_part('year',age(pe.persona_fecha_nac))as edad from hijos hj join persona pe "
                + "ON pe.persona_codigo = hj.persona_codigo where persona_estado_actual= true and  hj.victima_codigo =" + codigovictima;
        System.out.println("listar hijos: " + sql);
        try {
            re = conectar.query(sql);
            while (re.next()) {
                Hijos hijo = new Hijos();
                hijo.setHijo_codigo(re.getInt(1));
                hijo.setPersona_nombre(re.getString(2));
                hijo.setPersona_apellido(re.getString(3));
                hijo.setPersona_fecha_nac(re.getDate(4));
                hijo.setEdad((Integer.parseInt(String.valueOf(re.getString("edad")))));
                listHijos.add(hijo);
            }
            return listHijos;
        } catch (Exception e) {
            System.out.println("error al obtener lista de hijos " + e.getMessage());
            conectar.cerrarConexion();
            return null;
        }
    }

    public List<Hijos> obtenListHijosAll() {
        List<Hijos> listHijos = new ArrayList();
        sql = "select hj.hijo_codigo,pe.persona_cedula, pe.persona_nombre,pe.persona_apellido, "
                + "pe.persona_fecha_nac, date_part('year',age(pe.persona_fecha_nac)) as edad from hijos hj join persona pe "
                + "ON pe.persona_codigo = hj.persona_codigo where persona_estado_actual= true;";
        System.out.println("listar hijos: " + sql);
        try {
            re = conectar.query(sql);
            while (re.next()) {
                Hijos hijo = new Hijos();
                hijo.setHijo_codigo(re.getInt(1));
                hijo.setPersona_cedula(re.getString(2));
                hijo.setPersona_nombre(re.getString(3));
                hijo.setPersona_apellido(re.getString(4));
                hijo.setPersona_fecha_nac(re.getDate(5));
                hijo.setEdad((Integer.parseInt(String.valueOf(re.getString("edad")))));
                listHijos.add(hijo);
            }
            return listHijos;
        } catch (Exception e) {
            System.out.println("error al obtener lista de hijos " + e.getMessage());
            conectar.cerrarConexion();
            return null;
        }
    }

    public List<Hijos> BuscarListHijosAll(String texto) {
        List<Hijos> listHijos = new ArrayList();
        sql = "select hj.hijo_codigo,pe.persona_cedula, pe.persona_nombre,pe.persona_apellido, "
                + "pe.persona_fecha_nac, date_part('year',age(pe.persona_fecha_nac)) as edad from hijos hj join persona pe "
                + "ON pe.persona_codigo = hj.persona_codigo "
                + "where persona_estado_actual= true and pe.persona_cedula like '" + texto + "%'\n"
                + " or pe.persona_nombre like '" + texto + "%'\n"
                + " or pe.persona_apellido like '" + texto + "%';";
        System.out.println("listar hijos: " + sql);
        try {
            re = conectar.query(sql);
            while (re.next()) {
                Hijos hijo = new Hijos();
                hijo.setHijo_codigo(re.getInt(1));
                hijo.setPersona_cedula(re.getString(2));
                hijo.setPersona_nombre(re.getString(3));
                hijo.setPersona_apellido(re.getString(4));
                hijo.setPersona_fecha_nac(re.getDate(5));
                hijo.setEdad((Integer.parseInt(String.valueOf(re.getString("edad")))));
                listHijos.add(hijo);
            }
            return listHijos;
        } catch (Exception e) {
            System.out.println("error al obtener lista de hijos " + e.getMessage());
            conectar.cerrarConexion();
            return null;
        }
    }
}
