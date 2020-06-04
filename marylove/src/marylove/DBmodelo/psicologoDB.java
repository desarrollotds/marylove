package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import marylove.conexion.ConexionHi;
import marylove.models.Psicologo;

/**
 *
 * @author Alumno
 */
public class psicologoDB extends Psicologo {

    PreparedStatement ps;
    ResultSet re = null;

    ConexionHi conectar = new ConexionHi();
    ArrayList<String> psico;
    String sql = "";
    private static int psicologo_codigo_static;
    // conexion prueba

    public static int getPsicologo_codigo_static() {
        return psicologo_codigo_static;
    }

    public static void setPsicologo_codigo_static(int psicologo_codigo_static) {
        psicologoDB.psicologo_codigo_static = psicologo_codigo_static;
    }

    public psicologoDB() {
    }

    public psicologoDB(int codigo_psic, int personal_cod) {
        super(codigo_psic, personal_cod);
    }
    
    public boolean obtener_id(int id) throws SQLException{
        sql = "select psicologo_codigo from psicologo where personal_codigo = "+id+";";
        re=conectar.query(sql);
        if (re!=null) {
            while (re.next()) {
                psicologo_codigo_static=re.getInt(1);
            }
            return true;
        }
        return false;
    }

    public boolean ingrePsicologo(Psicologo psc) {
        boolean ingreso = true;
        try {
            sql = "INSERT INTO public.psicologo(personal_codigo)"
                    + "VALUES (" + psc.getPersonal_cod() + ");";
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar psicilogo " + ex.getMessage());
            ingreso = false;
        }
        return ingreso;
    }

    public int verifiUserP(int c_per) { // verifica que perfil es el usuario
        int user = 0;
        try {
            sql = "select psicologo_codigo from psicologo where personal_codigo = " + c_per + ";";

            re = conectar.query(sql);
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar psicilogo " + ex.getMessage());
            conectar.cerrarConexion();
            user = 0;
        }
        return user;
    }

    public ArrayList obtenerPsicologicos() {
        psico = new ArrayList<>();
        try {
            sql = "select p.persona_nombre ||' '|| p.persona_apellido from persona p,"
                    + " psicologo ps, personal pe where p.persona_codigo=pe.persona_codigo "
                    + "and pe.personal_codigo=ps.personal_codigo;";
            re = conectar.query(sql);
            while (re.next()) {
                psico.add(re.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener nombre de psicilogo " + ex.getMessage());
            conectar.cerrarConexion();
            psico = null;
        }
        return psico;

    }
}
