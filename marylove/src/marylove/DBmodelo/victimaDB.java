
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
public class victimaDB extends Victima{
    PreparedStatement ps;
    ResultSet re = null;
    int cod=0;
    ConexionHi conn;
    String sql="";
    //variables globqales
    int id=0;
    public victimaDB() {
    }


    public boolean insertarVictima(){
            
        sql="INSERT into public.victima ()";
        return true;
    }
    public Victima obtenetCV( String ced){
        Victima v = new Victima();
        try {
             sql = "select vc.victima_codigo, pe.persona_nombre||' '||pe.persona_apellido from victima vc"
                    +" join persona as pe on vc.persona_codigo = pe.persona_codigo"
                    +" where pe.persona_cedula = '"+ced+"';";
            ps = conn.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                v.setVictima_codigo(re.getInt(1));
                v.setPersona_nombre(re.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("error al obtener datos de victima "+ex.getMessage());
        }
        conn.CerrarConexion();
        return v;
    }
    public int obtenerIdVictima() {
        conn= new ConexionHi();

        try {
           
            sql = "select victima_codigo from victima order by victima_codigo desc limit 1;";
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
