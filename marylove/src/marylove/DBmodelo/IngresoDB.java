
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import marylove.conexion.ConexionHi;
import marylove.models.Ingreso;

public class IngresoDB extends Ingreso {

    ConexionHi conectar;// = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    ArrayList<String> anio;
    String sql = "";

    public IngresoDB(int victima_codigo, int personal_codigo, String asignacion_dormitorio, String Referidapor, Date ingreso_fecha) {
        super(victima_codigo, personal_codigo, asignacion_dormitorio, Referidapor, ingreso_fecha);
    }

    public IngresoDB() {
    }

    public boolean IngresarDormitorioReferido() {
        String sql = "INSERT INTO ingreso"
                + "(victima_codigo,personal_codigo,asignacion_dormitorio, referidapor,ingreso_fecha)"
                + "VALUES (" +getVictima_codigo()+ "," +getPersonal_codigo()+ ",'" +getAsignacion_dormitorio() + "','" + getReferidapor() + "','" +getIngreso_fecha()+ "')";
        PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizar() {
        String sql = "UPDATE public.ingreso SET "
                + "victima_codigo=" + getVictima_codigo() + ","
                + " personal_codigo=" + getPersonal_codigo() + ","
                + "asignacion_dormitorio='" + getAsignacion_dormitorio() + "',"
                + " Referidapor= '" + getReferidapor() + " "
                + " WHERE ingreso_id =" + getIngreso_id();

        if (conectar.noQuery(sql) == null) {
            conectar.cerrarConexion();
            return true;

        } else {
            conectar.cerrarConexion();
            return false;
        }
    }

   
 public ArrayList obtenerAnio() throws SQLException {
        anio = new ArrayList<>();
        sql = "select distinct extract(year from ingreso_fecha) from ingreso order by  extract(year from ingreso_fecha);";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            anio.add(re.getString(1));
        }
        conectar.cerrarConexion();
        return anio;

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
        conectar.cerrarConexion();
        return user;
    }
     
    public int maxId(){
        int id=0;
         try {
            String sql = "select max(ingreso_id) from ingreso ;";
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
        conectar.cerrarConexion();
        return id;
    }
}

