
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
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Egreso;
import marylove.models.Ingreso;

public class EgresoDB extends Egreso {

    Conexion conectar = new Conexion();
    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conn;
    //variables globales
    String sql="";
    List<Egreso> listaEgresos ;

    public EgresoDB(int egreso_codigo, int victima_codigo, String egreso_fecha, String egreso_situacion, int dir_codigo, int telefono, int celular, int personal_codigo, FileInputStream fis, int longBytes, byte croquis) {
        super(egreso_codigo, victima_codigo, egreso_fecha, egreso_situacion, dir_codigo, telefono, celular, personal_codigo, fis, longBytes, croquis);
    }
    
    public EgresoDB() {

    }

    public boolean IngresarEgreso() {
         sql = "INSERT INTO public.egreso"
                + "(victima_codigo,dir_codigo, personal_codigo, egreso_fecha,egreso_situacion, telefono, celular, croquis)"
                + "VALUES ("+getVictima_codigo()+","+getDir_codigo()+","+getPersonal_codigo()+",'"+getEgreso_fecha()+"','"+getEgreso_situacion()+"','"+getTelefono()+"','"+getCelular()+"',?)";
            PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Egreso> listaEgresos() {
        conectar = new Conexion();
        listaEgresos = new ArrayList<Egreso>();
         sql = "select* from egreso";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                Egreso e = new Egreso();
               e.setVictima_codigo(rs.getInt("victima_codigo"));
               e.setEgreso_fecha(rs.getString("egreso_fecha"));
               e.setEgreso_situacion(rs.getString("egreso_situacion"));
               e.setDir_codigo(rs.getInt("dir_codigo"));
               e.setTelefono(rs.getInt("telefono"));
               e.setCelular(rs.getInt("celular"));
               e.setPersonal_codigo(rs.getInt("personal_codigo"));
                listaEgresos.add(e);
            }
            rs.close();
            conectar.cerrarConexion();
            return listaEgresos;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean actualizar() {
        conectar = new Conexion();
         sql = "UPDATE public.egreso SET"
                + " victima_codigo="+getVictima_codigo()+","
                + "egreso_fecha="+getEgreso_fecha()+","
                + "egreso_situacion='"+getEgreso_situacion()+"',"
                + "croquis=?, "
                + "dir_codigo="+getDir_codigo()+","
                + "telefono="+getTelefono()+","
                + "celular="+getCelular()+","
                + "personal_codigo="+getPersonal_codigo()+" "
                + " WHERE <condition>;";

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
            ps = conectar.conectarBD().prepareStatement(sql);
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
            ps = conectar.conectarBD().prepareStatement(sql);
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
