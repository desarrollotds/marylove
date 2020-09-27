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
import marylove.models.x_embarazo_comp1;

/**
 *
 * @author Asus
 */
public class x_embarazo_comp1DB extends x_embarazo_comp1{
    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar = new ConexionHi();
    private static int x_emb_comp_id_static;

    public static int getX_emb_comp_id_static() {
        return x_emb_comp_id_static;
    }

    public static void setX_emb_comp_id_static(int x_emb_comp_id_static) {
        x_embarazo_comp1DB.x_emb_comp_id_static = x_emb_comp_id_static;
    }
    
    public x_embarazo_comp1DB() {
    }

    public x_embarazo_comp1DB(boolean estado, String json_complicaciones) {
        super(estado, json_complicaciones);
    }

    public x_embarazo_comp1DB(int embarazo_id, boolean estado, String json_complicaciones) {
        super(embarazo_id, estado, json_complicaciones);
    }

    public x_embarazo_comp1DB(int x_emb_comp_id, int embarazo_id, boolean estado, String json_complicaciones) {
        super(x_emb_comp_id, embarazo_id, estado, json_complicaciones);
    }
    public boolean primer_insert () throws SQLException {
        String sql = "INSERT INTO public.x_embarazo_comp( embarazo_id, estado)"
                + "VALUES ("+AnamnesisDB.embarazo_id+", '"+isEstado()+"')returning x_emb_comp_id;";
        re=conectar.query(sql);
        if (re!=null) {
            while (re.next()) {
                x_emb_comp_id_static=re.getInt(1);
            }
            return true;
        } else {
            return false;
        }
    
    }
    public boolean update_x_embarazo_comp () {
    
        String sql = "UPDATE public.x_embarazo_comp SET "
                + "estado='"+isEstado()+"', json_complicaciones='"+getJson_complicaciones()+"' "
                + "WHERE x_emb_comp_id="+x_embarazo_comp1DB.x_emb_comp_id_static+";";
        return conectar.noQuery(sql);
        
    }
}
