package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Psicologo;

/**
 *
 * @author Alumno
 */
public class psicologoDB extends Psicologo {

    PreparedStatement ps;
    ResultSet re = null;

    Conexion conectar;
    ArrayList<String> psico;
    String sql="";
    // conexion prueba
 
    
    public psicologoDB() {
    }

    public psicologoDB(int codigo_psic, int personal_cod) {
        super(codigo_psic, personal_cod);
    }

    public boolean ingrePsicologo(Psicologo psc) {
        conectar = new Conexion();
        boolean ingreso = true;
        try {
             sql = "INSERT INTO public.psicologo(personal_codigo)"
                    + "VALUES (" + psc.getPersonal_cod() + ");";
            if (conectar.noQuery(sql) == null) {
                ingreso = true;
            }else{
                ingreso = false;
            }
        } catch (Exception ex) {
            System.out.println("Error al ingresar psicilogo "+ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }

    
    public int verifiUserP(int c_per) { // verifica que perfil es el usuario
        conectar = new Conexion();
        int user = 0;
        try {
            sql = "select psicologo_codigo from psicologo where personal_codigo = " + c_per + ";";
            
            re = conectar.query(sql);
            while (re.next()) {
                user = re.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("Error al verificar psicilogo "+ex.getMessage());
            user = 0;
        }
        conectar.cerrarConexion();
        return user;
    }
    
    public ArrayList obtenerPsicologicos(){
        conectar = new Conexion();
        psico= new ArrayList<>();
        try{
            sql="select p.persona_nombre ||' '|| p.persona_apellido from persona p,"
        + " psicologo ps, personal pe where p.persona_codigo=pe.persona_codigo "
        + "and pe.personal_codigo=ps.personal_codigo;";
            re = conectar.query(sql);
            while (re.next()) {
                psico.add(re.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener nombre de psicilogo "+ex.getMessage());
            psico = null;
        }
        
        conectar.cerrarConexion();
        return psico;
    
    }
}
