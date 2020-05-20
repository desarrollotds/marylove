
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Direccion_persona;

public class DireccionPersonaDB extends Direccion_persona{
    PreparedStatement ps;
    ResultSet re = null;
    String sql;
    ConexionHi conectar;// = new ConexionHi();

    public DireccionPersonaDB(int persona_codigo, int dir_domicilio) {
        super(persona_codigo, dir_domicilio);
    }

    public DireccionPersonaDB() {
    }
    
    public boolean insertarDireccionD(){
        boolean ing= true;
       // conectar= new ConexionHi();
        try {
            sql = "INSERT INTO public.direccion_persona(persona_codigo,dir_domicilio)"
                    + " VALUES("+getPersona_codigo()+","+getDir_domicilio()+");";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.execute();
            ing = true;
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar ficha Dirección: "+ex.getMessage());
            ing = false;
        }
        conectar.cerrarConexion();
         return ing;
    
    }
    
    public int verifiUser(int cod_per) { // verifica que perfil es el usuario
        int dirCod = 0;
        try {
             sql = "select dirp_id from direccion_persona where persona_codigo = '" + cod_per + "';";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                dirCod = re.getInt(1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            dirCod = 0;
            System.out.println("erorr al obtener direccion persona"+ex.getMessage());
        }
        conectar.cerrarConexion();
        return dirCod;
    }
}
