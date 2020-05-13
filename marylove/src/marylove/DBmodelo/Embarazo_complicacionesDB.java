/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Embarazo_complicaciones;

/**
 *
 * @author Asus
 */
public class Embarazo_complicacionesDB extends Embarazo_complicaciones {

    PreparedStatement ps;
    ResultSet re;
    victimaDB vdb;
    private ConexionHi conn;
    private String sql = "";

    public Embarazo_complicacionesDB() {
    }

    public Embarazo_complicacionesDB(String emb_comp_descripcion, int emb_comp_tipo) {
        super(emb_comp_descripcion, emb_comp_tipo);
    }

    public void insertar_embarazo_complicaciones() throws SQLException {
        String sql = "INSERT INTO public.embarazo_complicaciones("
                + "	emb_comp_descripcion, emb_comp_tipo)"
                + "	VALUES ( '" + getEmb_comp_descripcion() + "', " + getEmb_comp_tipo() + ");";
        ps = conn.getConnection().prepareStatement(sql);
        ps.execute();
    }

    public int obtener_id(String text,int id) throws SQLException {
        int res = 0;
        sql = "Select emb_comp_id from embarazo_complicaciones where emb_comp_descripcion='"+text+"' and emb_comp_tipo="+id+";";
        ps=conn.getConnection().prepareStatement(sql);
        re=ps.executeQuery();
        conn.CerrarConexion();
        while(re.next()){
            res=re.getInt(1);
        }
        return res;
    }
}
