package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Direccion;

public class DireccionDB extends Direccion {

    //variables static
    private static int direccion_codigo_static;

    //variables DB
    PreparedStatement ps;
    ResultSet re = null;
    String sql;
    ConexionHi conectar = new ConexionHi();
    //variables globales
    int direccionId;
    private static Direccion direccion_econtrada_estatic;

    public DireccionDB() {
    }

    public DireccionDB(String calle_dir, String dir_interseccion,
            String dir_num_casa, String dir_barrio, String dir_parroquia,
            String dir_ciudad, String dir_referencias,
            String provincia, String pais, boolean dir_estado) {
        super(calle_dir, dir_interseccion, dir_num_casa, dir_barrio,
                dir_parroquia, dir_ciudad, dir_referencias, provincia, pais, dir_estado);
    }

    public static Direccion getDireccion_econtrada_estatic() {
        return direccion_econtrada_estatic;
    }

    public static void setDireccion_econtrada_estatic(Direccion direccion_econtrada_estatic) {
        DireccionDB.direccion_econtrada_estatic = direccion_econtrada_estatic;
    }

    public static int getDireccion_codigo_static() {
        return direccion_codigo_static;
    }

    public static void setDireccion_codigo_static(int direccion_codigo_static) {
        DireccionDB.direccion_codigo_static = direccion_codigo_static;
    }
    
    public boolean getDirectionBase(int cod)throws SQLException {
        sql = "select * from direccion d, direccion_persona dp where dp.dir_domicilio = d.dir_codigo and dp.persona_codigo = "+cod+"";
        re = conectar.query(sql);
        if (re!=null) {
          Direccion d = new Direccion();
          d.setDir_codigo(re.getInt(1));
          d.setCalle_dir(re.getString(2));
          d.setDir_interseccion(re.getString(3));
          d.setDir_num_casa(re.getString(4));
          d.setDir_barrio(re.getString(5));
          d.setDir_parroquia(re.getString(6));
          d.setDir_ciudad(re.getString(7));
          d.setDir_referencias(re.getString(8));
          d.setProvincia(re.getString(9));
          d.setPais(re.getString(10));
          d.setDir_estado(re.getBoolean(11));
          direccion_econtrada_estatic = d;
        return true;
        } else {
        return false;
        }
        
        
    }
    public int obtenerIdDireccion() throws SQLException {
        direccionId = 0;
        sql = "select dir_codigo from direccion order by dir_codigo desc limit 1;";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        while (re.next()) {
            direccionId = re.getInt(1);
        }
        conectar.cerrarConexion();
        return direccionId;
    }

    public boolean insertaDireccion() throws SQLException {
        System.out.println("llega al direccion");
        boolean ing = true;

        
            sql = "INSERT INTO public.direccion(dir_calle,dir_interseccion,dir_num_casa,dir_barrio,dir_parroquia,"
                    + "dir_ciudad,dir_referencias,dir_provincia,dir_pais,dir_estado)VALUES('" + getCalle_dir() + "','"
                    + getDir_interseccion() + "','" + getDir_num_casa() + "','" + getDir_barrio() + "','"
                    + getDir_parroquia() + "','" + getDir_ciudad() + "','" + getDir_referencias() + "','"
                    + getProvincia() + "','" + getPais() + "','" + getDir_estado() + "')returning dir_codigo;";
            re = conectar.query(sql);
            if (re != null) {
                while (re.next()) {
                    direccion_codigo_static = re.getInt(1);
                }
                return true;
            } else {

                return false;
            }
        
    }

    public boolean IngresarDirec() {
        System.out.println("llega a IngresarDirec");
        sql = "INSERT INTO public.direccion(dir_calle,dir_interseccion,dir_num_casa,dir_barrio,dir_parroquia,"
                + "dir_ciudad,dir_referencias,dir_provincia,dir_pais,dir_estado)VALUES('" + getCalle_dir() + "','"
                + getDir_interseccion() + "','" + getDir_num_casa() + "','" + getDir_barrio() + "','"
                + getDir_parroquia() + "','" + getDir_ciudad() + "','" + getDir_referencias() + "','"
                + getProvincia() + "','" + getPais() + "','" + getDir_estado() + "');";
        return conectar.noQuery(sql);
    }

    public int verifiDirecc() { // verifica que perfil es el usuario
        int dirCod = 0;
        try {
            sql = "select max(dir_codigo) from direccion;";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                dirCod = re.getInt(1);
            }

        } catch (SQLException ex) {
            dirCod = 0;
            System.out.println("erorr al obtener direccion persona" + ex.getMessage());
        }
        conectar.cerrarConexion();
        return dirCod;
    }

}
