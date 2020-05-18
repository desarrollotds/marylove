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
    ConexionHi conectar= new ConexionHi();
    ArrayList<String> psico;
    String sql="";
    // conexion prueba
 
    
    public psicologoDB() {
    }

    public psicologoDB(int codigo_psic, int personal_cod) {
        super(codigo_psic, personal_cod);
    }

    public boolean ingrePsicologo(Psicologo psc) {
        boolean ingreso = true;
        try {
             sql = "INSERT INTO public.psicologo(personal_codigo)"
                    + "VALUES (" + psc.getPersonal_cod() + ");";
            ps= conectar.getConnection().prepareStatement(sql);
            ps.execute();

        } catch (SQLException ex) {
            System.out.println("Error al ingresar psicilogo "+ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }

    
    public int verifiUserP(int c_per) { // verifica que perfil es el usuario
        int user = 0;
        try {
            sql = "select psicologo_codigo from psicologo where personal_codigo = " + c_per + ";";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar psicilogo "+ex.getMessage());
            user = 0;
        }
        conectar.cerrarConexion();
        return user;
    }
    
    public ArrayList obtenerPsicologicos() throws SQLException{
        psico= new ArrayList<>();
        conectar=new ConexionHi();
        sql="select p.persona_nombre ||' '|| p.persona_apellido from persona p,"
        + " psicologo ps, personal pe where p.persona_codigo=pe.persona_codigo "
        + "and pe.personal_codigo=ps.personal_codigo;";
         ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                psico.add(re.getString(1));
            }
            conectar.cerrarConexion();
        return psico;
    
    }
}
