
package marylove.DBmodelo;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Egreso;
import marylove.models.Ingreso;

public class EgresoDB extends Egreso {

    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    //variables globales
    String sql="";
    List<Egreso> listaEgresos ;

    public EgresoDB(int victima_codigo, Date egreso_fecha, String egreso_situacion, byte croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo) {
        super(victima_codigo, egreso_fecha, egreso_situacion, croquis, canton, provincia, per_refe_parentesco, telefono, personal_codigo);
    }

    public EgresoDB() {

    }

    public boolean IngresarEgreso() {
         sql = "INSERT INTO public.egreso( victima_codigo, egreso_fecha, "
                 + "egreso_situacion, croquis, canton, provincia, "
                 + "per_refe_parentesco, telefono, personal_codigo)" +
                 " VALUES ("+getVictima_codigo()+", '"+getEgreso_fecha()+"', "
                 + "'"+getEgreso_situacion()+"', '"+getCroquis()+"','"+getCanton()+"',"
                 + "'"+getProvincia()+"', '"+getPer_refe_parentesco()+"', "
                 + "'"+getTelefono()+"',"+getPersonal_codigo()+");";
            ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Egreso> listaEgresos() {
        listaEgresos = new ArrayList<Egreso>();
         sql = "select* from egreso";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Egreso e = new Egreso();
               //llenar 
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

    public boolean actualizar(int id) {
         sql ="UPDATE public.egreso" +
                 "	SET victima_codigo="+getVictima_codigo()+","
                 + " egreso_fecha='"+getEgreso_fecha()+"', "
                 + " egreso_situacion='"+getEgreso_situacion()+"',"
                 + " croquis='"+getCroquis()+"',"
                 + " canton='"+getCanton()+"',"
                 + " provincia='"+getProvincia()+"',"
                 + " per_refe_parentesco='"+getPer_refe_parentesco()+"',"
                 + " telefono='"+getTelefono()+"',"
                 + " personal_codigo="+getPersonal_codigo()+" "
                 + "WHERE egreso_codigo="+id+";" ;

        if (conectar.noQuery(sql) == null) {
            conectar.cerrarConexion();
            return true;
        } else {
            conectar.cerrarConexion();
            return false;
        }
    }
    
    public int maxId(){
        int id=0;
         try {
            String sql = "select max(ingreso_id) from egreso ;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                id = (re.getInt(1)
                        );
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
//        conectar.cerrarConexion();
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
            System.out.println("Error personal "+ex.getMessage());
            user = 0;
        }
//        conectar.cerrarConexion();
        return user;
    }

}
