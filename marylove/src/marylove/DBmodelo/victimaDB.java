package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Persona;
import marylove.models.Victima;

/**
 *
 * @author vasquez
 */
public class victimaDB extends Victima {

    PreparedStatement ps;
    ResultSet re = null;
    int cod = 0;
    ConexionHi conn;
    Conexion cx = new Conexion();
    String sql = "";
    //variables globqales
    int id = 0;
   //vatriables staticas
     private static int codigo_victima_static;

    public victimaDB()  {
    }

    public victimaDB(int persona_codigo, boolean victima_estado) {
        super(persona_codigo, victima_estado);
    }

    public static int getCodigo_victima_static() {
        return codigo_victima_static;
    }

    public static void setCodigo_victima_static(int codigo_victima_static) {
        victimaDB.codigo_victima_static = codigo_victima_static;
    }
    
    public boolean insertarVictima() {
        try {
            conn = new ConexionHi();
            sql = "INSERT into public.victima ( persona_codigo, victima_embarazo"
                    + ")	VALUES ("+getPersona_codigo()+", '"+isVictima_estado()+"' )  RETURNING victima_codigo;";
            System.out.println(sql);
            ps = conn.getConnection().prepareStatement(sql);
          re=  ps.executeQuery();

            while (re.next()) {
                codigo_victima_static = re.getInt(1);
            }
            conn.CerrarConexion();
        } catch ( SQLException ex) {
        Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public Victima obtenetCV(String ced) {
        Victima v = new Victima();
        try {
            sql = "select vc.victima_codigo, pe.persona_nombre||' '||pe.persona_apellido from victima vc"
                    + " join persona as pe on vc.persona_codigo = pe.persona_codigo"
                    + " where pe.persona_cedula = '" + ced + "';";
            ps = cx.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                v.setVictima_codigo(re.getInt(1));
                v.setPersona_nombre(re.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("error al obtener datos de victima " + ex.getMessage());
        }
        cx.cerrarConexion();
        return v;
    }

    public int obtenerIdVictima() {
        conn = new ConexionHi();

        try {

            sql = "select victima_codigo from victima where persona_codigo='" + getPersona_codigo() + "'";
            System.out.println(sql + "----------------");
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            conn.CerrarConexion();
//            PreparedStatement ps = conn.getConection().prepareStatement(sql);

            while (re.next()) {
                id = re.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
