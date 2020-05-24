package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import marylove.conexion.ConexionHi;
import marylove.models.Estado_psico_emocional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexanderGuzman
 */
public class EstadoPsicoEmoDB extends Estado_psico_emocional {
    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;
    String sql = "";
    //variables gloables
    int par_id = 0;
    Estado_psico_emocional epe;
    public ArrayList<Estado_psico_emocional>aepe=new ArrayList<>();

    public EstadoPsicoEmoDB() throws SQLException {
        aepe=obtener_objeto();
    }

    public EstadoPsicoEmoDB(String estado_nombre, int estado_tipo) {
        super(estado_nombre, estado_tipo);
    }
    
    public ArrayList<Estado_psico_emocional> obtener_objeto() throws SQLException{
        int res=0;
        sql="SELECT estado_id, estado_nombre, estado_tipo" +
       " FROM public.estado_psico_emocional;";
        ps=conectar.getConnection().prepareStatement(sql);
        re=ps.executeQuery();
        conectar.cerrarConexion();
        while (re.next()) {
            int id=re.getInt(1);
            String des=re.getString(2);
            int tipo=re.getInt(3);
            epe=new Estado_psico_emocional(id, des, tipo);
            aepe.add(epe);
        
        }
        return aepe;
    }
    public int obtenerIdEstado(String nombre,int id) throws SQLException{
        int res=0;
       for (Estado_psico_emocional o: aepe) {
           if (o.getEstado_nombre().equals(nombre) ) {
               if (o.getEstado_tipo()==id) {
                   res=o.getEstado_id();
               }
           }
       }
        return res;
    }
}
