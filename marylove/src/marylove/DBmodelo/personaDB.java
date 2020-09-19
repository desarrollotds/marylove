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
import marylove.models.Anamnesis;
import marylove.models.Nacimiento;
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
    private static String persona_codigo_existencia_static;
    private static Persona persona_agresor_encontrada_static;//resultado del metodo buscar en en agregar agresores
    private static int persona_metodo_modificar_static;
    PreparedStatement ps;
    ResultSet re = null;
    boolean ingreso = true;
    String sql = "";
    boolean f = true;
    //variables globales para los metodos
    int codigo_per = 0;
    ArrayList<Persona> personaescogida=new ArrayList<>();
    private static ArrayList<Persona> lista_personas_inicial=new ArrayList<>();
    Persona p = new Persona();
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

    public static int getPersona_metodo_modificar_static() {
        return persona_metodo_modificar_static;
    }

    public static void setPersona_metodo_modificar_static(int persona_metodo_modificar_static) {
        personaDB.persona_metodo_modificar_static = persona_metodo_modificar_static;
    }

    public static Persona getPersona_agresor_encontrada_static() {
        return persona_agresor_encontrada_static;
    }

    public static void setPersona_agresor_encontrada_static(Persona persona_agresor_encontrada_static) {
        personaDB.persona_agresor_encontrada_static = persona_agresor_encontrada_static;
    }

    public static ArrayList<Persona> getLista_personas_inicial() {
        return lista_personas_inicial;
    }

    public static void setLista_personas_inicial(ArrayList<Persona> lista_personas_inicial) {
        personaDB.lista_personas_inicial = lista_personas_inicial;
    }

    public static String getPersona_codigo_existencia_static() {
        return persona_codigo_existencia_static;
    }

    public static void setPersona_codigo_existencia_static(String persona_codigo_existencia_static) {
        personaDB.persona_codigo_existencia_static = persona_codigo_existencia_static;
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

    public void listapersonas() throws SQLException {
        lista_personas_inicial = new ArrayList<>();
        sql = "select * from persona";
        re = conectar.query(sql);
        while (re.next()) {

            char sexochar;
            if (re.getString("persona_sexo") != null) {
                sexochar = re.getString("persona_sexo").charAt(0);
            } else {
                sexochar = ' ';
            }

            p = new Persona(re.getInt("persona_codigo"),
                    re.getString("persona_cedula"),
                    re.getString("persona_nombre"),
                    re.getString("persona_apellido"),
                    re.getDate("persona_fecha_nac"),
                    re.getInt("persona_ocupacion"),
                    re.getInt("persona_nivel_acad"),
                    re.getInt("persona_est_migr"),
                    re.getString("persona_telefono"),
                    re.getString("persona_celular"),
                    re.getInt("persona_estadocivil"),
                    re.getInt("persona_nacionalidad"),
                    re.getBoolean("persona_estado_actual"),
                    sexochar,
                    re.getString("persona_nivel_acad_otros"),
                    re.getString("persona_lugar_trabajo"),
                    re.getString("persona_referencia"));

            lista_personas_inicial.add(p);

        }

    }

    public void prueba_recorrer() {
        for (Persona o : lista_personas_inicial) {
            System.out.println(o.toString());
        }

    }

    public Persona obtener_persona_especifica(String c) {
        System.out.println("cedula enviada " + c);
        Persona persona = new Persona();
        for (Persona o : lista_personas_inicial) {
           // System.out.println(o + " persona");
            if (c.equals(o.getPersona_cedula())) {
                persona = new Persona(
                        o.getPersona_codigo(),
                        o.getPersona_cedula(),
                        o.getPersona_nombre(),
                        o.getPersona_apellido(),
                        o.getPersona_fecha_nac(),
                        o.getPersona_ocupacion(),
                        o.getPersona_nivel_acad(),
                        o.getPersona_est_migr(),
                        o.getPersona_telefono(),
                        o.getPersona_celular(),
                        o.getPersona_estadocivil(),
                        o.getPersona_nacionalidad(),
                        o.isPersona_estado_actual(),
                        o.getPersona_sexo(),
                        o.getPersona_nivel_acad_otros(),
                        o.getPersona_lugar_trabajo(),
                        o.getPersona_referencia()
                );
            }
        }
        System.out.println(persona.toString() + " esto es la persana buscada");
        return persona;
    }

    public void verificar_existencia(String c) {
       
        //System.out.println("VERIFICAR EXISTENCIA R_R | cedula enviada " + c);

        for (Persona u: lista_personas_inicial) {
            //System.out.println("VERIFICAR EXISTENCIA R_R ENTRA AL FOR");
            if (c.equals(u.getPersona_cedula())) {
               // System.out.println("VERIFICAR EXISTENCIA R_R ENTRA AL IF");
                persona_codigo_existencia_static = u.getPersona_cedula();
                persona_codigo_static = u.getPersona_codigo();
                
                //System.out.println("VERIFICAR EXISTENCIA R_R personaDB cedula : : : : : " + persona_codigo_existencia_static + " no esta nula");
               
            } else {
            persona_codigo_existencia_static= "no_one_p";
            }
        }
        

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

        } catch (Exception ex) {
                System.out.println("error al ingresar datos de persona:"+ex.getMessage());
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

    public boolean askIdBase( String ced) throws SQLException {
        boolean f=false;
        sql = "select * from persona where persona_cedula='" + ced + "';";
        re = conectar.query(sql);
        while (re.next()) {
        if (ced.equals(re.getString(2))) {
            Persona p = new Persona();
            p.setPersona_codigo(re.getInt(1));
            p.setPersona_cedula(re.getString(2));
            p.setPersona_nombre(re.getString(3));
            p.setPersona_apellido(re.getString(4));
            p.setPersona_fecha_nac(re.getDate(5));
            p.setPersona_ocupacion(re.getInt(6));
            p.setPersona_nivel_acad(re.getInt(7));
            p.setPersona_est_migr(re.getInt(17));
            p.setPersona_telefono(re.getString(8));
            p.setPersona_celular(re.getString(9));
            p.setPersona_estadocivil(re.getInt(10));
            p.setPersona_nacionalidad(re.getInt(11));
            p.setPersona_estado_actual(re.getBoolean(12));
            char sexochar;
            if (re.getString(13) != null) {
                sexochar = re.getString("persona_sexo").charAt(0);
            } else {
                sexochar = ' ';
            }
            p.setPersona_sexo(sexochar);
            p.setPersona_nivel_acad_otros(re.getString(14));
            p.setPersona_lugar_trabajo(re.getString(15));
            p.setPersona_referencia(re.getString(16));
            p.setEdad(re.getInt(18));
            persona_agresor_encontrada_static = p;
            f = true;
        } else {
            Persona p = new Persona();
            p.setPersona_cedula("no_one");
            persona_agresor_encontrada_static = p;
            f = false;
        }
        }
        return f;
    }

    public boolean modificarPersona(int id) {

        try {
            sql = "UPDATE public.persona SET persona_nombre='" + getPersona_nombre() + "', "
                    + "persona_apellido='" + getPersona_apellido() + "', "
                    + "persona_fecha_nac='" + getPersona_fecha_nac() + "', "
                    + "persona_ocupacion=" + getPersona_ocupacion() + ", "
                    + "persona_nivel_acad=" + getPersona_nivel_acad() + ", "
                    + "persona_telefono='" + getPersona_telefono() + "', "
                    + "persona_celular='" + getPersona_celular() + "', "
                    + "persona_estadocivil=" + getPersona_estadocivil() + ", "
                    + "persona_nacionalidad=" + getPersona_nacionalidad() + ", "
                    + "persona_estado_actual='true', "
                    + "persona_sexo='" + getPersona_sexo() + "', "
                    + "persona_nivel_acad_otros='" + getPersona_nivel_acad_otros() + "', "
                    + "persona_lugar_trabajo='" + getPersona_lugar_trabajo() + "', "
                    + "persona_referencia='" + getPersona_referencia() + "', "
                    + "persona_est_migr=" + getPersona_est_migr() + " "
                    + "WHERE persona_codigo=" + id + " returning persona_codigo;";
            re=conectar.query(sql);
            if (re!=null){
                while(re.next()){
                    persona_metodo_modificar_static=re.getInt(1);
                    
                }
            }
            System.out.println(persona_metodo_modificar_static+" persona_metodo_modificar_static");
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
    
    public boolean personaBYCedula(String ced){
        boolean verf = true;
        try {

            sql = "select persona_codigo from persona where persona_cedula = '"+ced+"'";
            re = conectar.query(sql);

            while (re.next()) {
                id = re.getInt(1);
                verf = false;
            }
        } catch (SQLException ex) {
            System.out.println("error al obtener persona por la cedula");
            conectar.cerrarConexion();
        }
        return verf;
    }
}
