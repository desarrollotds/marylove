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

    public DireccionDB() {
    }

    public DireccionDB(String calle_dir, String dir_interseccion,
            String dir_num_casa, String dir_barrio, String dir_parroquia,
            String dir_ciudad, String dir_referencias,
            String provincia, String pais, boolean dir_estado) {
        super(calle_dir, dir_interseccion, dir_num_casa, dir_barrio,
                dir_parroquia, dir_ciudad, dir_referencias, provincia, pais, dir_estado);
    }

    public static int getDireccion_codigo_static() {
        return direccion_codigo_static;
    }

    public static void setDireccion_codigo_static(int direccion_codigo_static) {
        DireccionDB.direccion_codigo_static = direccion_codigo_static;
    }

    //hola
    public int obtenerIdDireccion() throws SQLException {
        direccionId = 0;
        sql = "select dir_codigo from direccion order by dir_codigo desc limit 1;";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();

        while (re.next()) {

            direccionId = re.getInt(1);
        }

        return direccionId;
    }

    public boolean insertaDireccion() {
        System.out.println("llega al direccion");
        boolean ing = true;

        try {
            sql = "INSERT INTO public.direccion(dir_calle,dir_interseccion,dir_num_casa,dir_barrio,dir_parroquia,"
                    + "dir_ciudad,dir_referencias,dir_provincia,dir_pais,dir_estado)VALUES('" + getCalle_dir() + "','"
                    + getDir_interseccion() + "','" + getDir_num_casa() + "','" + getDir_barrio() + "','"
                    + getDir_parroquia() + "','" + getDir_ciudad() + "','" + getDir_referencias() + "','"
                    + getProvincia() + "','" + getPais() + "','" + getDir_estado() + "');";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            System.out.println("direccion: " + getDir_num_casa() + ":" + getDir_barrio() + "','"
                    + getDir_parroquia() + "','" + getDir_ciudad() + "','" + getDir_referencias() + "','"
                    + getProvincia() + "','" + getPais() + "','" + getDir_estado());
            ing = true;
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar ficha Dirección: " + ex.getMessage());
            ing = false;
        }
        conectar.cerrarConexion();
        return ing;
    }
    public boolean IngresarDirec() {
        System.out.println("llega a IngresarDirec");
        sql = "INSERT INTO public.direccion(dir_calle,dir_interseccion,dir_num_casa,dir_barrio,dir_parroquia,"
                    + "dir_ciudad,dir_referencias,dir_provincia,dir_pais,dir_estado)VALUES('" + getCalle_dir() + "','"
                    + getDir_interseccion() + "','" + getDir_num_casa() + "','" + getDir_barrio() + "','"
                    + getDir_parroquia() + "','" + getDir_ciudad() + "','" + getDir_referencias() + "','"
                    + getProvincia() + "','" + getPais() + "','" + getDir_estado() + "');";
            PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public int verifiDirecc(ConexionHi con) { // verifica que perfil es el usuario

        int dirCod = 0;
        try {
            sql = "select max(dir_codigo) from direccion;";
            ps = con.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                dirCod = re.getInt(1);
            }

        } catch (SQLException ex) {
            dirCod = 0;
            System.out.println("erorr al obtener direccion persona" + ex.getMessage());
        }
        con.cerrarConexion();
        return dirCod;
    }

}
