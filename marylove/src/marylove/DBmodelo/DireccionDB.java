
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.Direccion;

public class DireccionDB extends Direccion{
     PreparedStatement ps;
    ResultSet re = null;

    public DireccionDB() {
    }
    //hola
    public boolean insertaDireccion(Conexion con, Direccion dir){
        boolean ing= true;
        
        try {
            String sql = "INSERT INTO public.direccion(dir_calle,dir_interseccion,dir_num_casa,dir_barrio,dir_parroquia,"
                    + "dir_ciudad,dir_referencias,dir_estado)"
                    + " VALUES(?,?,?,?,?,?,?,?);";
            System.out.println("dir: "+ dir.getCalle_dir());
            ps = con.conectarBD().prepareStatement(sql);
            ps.setString(1, dir.getCalle_dir());
            ps.setString(2, dir.getDir_interseccion());
            ps.setString(3, dir.getDir_num_casa());
            ps.setString(4, dir.getDir_barrio());
            ps.setString(5, dir.getDir_parroquia());
            ps.setString(6, dir.getDir_ciudad());
            ps.setString(7, dir.getDir_referencias());
            ps.setString(8, dir.getDir_estado());
            ps.execute();
            ing = true;
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar ficha Dirección: "+ex.getMessage());
            ing = false;
        }
        con.cerrarConexion();
         return ing;
    }
    
    public int verifiDirecc(Conexion con) { // verifica que perfil es el usuario
        int dirCod = 0;
        try {
            String sql = "select max(dir_codigo) from direccion;";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                dirCod = re.getInt(1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            dirCod = 0;
            System.out.println("erorr al obtener direccion persona"+ex.getMessage());
        }
        con.cerrarConexion();
        return dirCod;
    }
}