/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    Embarazo_complicaciones ec;
    private ArrayList<Embarazo_complicaciones> aec= new ArrayList<>();

    public Embarazo_complicacionesDB() throws SQLException {
        this.aec=obtener_objeto();
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

    public ArrayList<Embarazo_complicaciones> obtener_objeto() throws SQLException {
        
        sql = "SELECT emb_comp_id, emb_comp_descripcion, emb_comp_tipo "
                + " FROM public.embarazo_complicaciones;";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        conn.CerrarConexion();
        while (re.next()) {
            int id = re.getInt(1);
            String des = re.getString(2);
            int tipo = re.getInt(1);
            ec = new Embarazo_complicaciones(id, des, tipo);
            aec.add(ec);
        }
        return aec;
    }

    public int obtener_id(String text, int id) throws SQLException {
        
        int res = 0;
        for (Embarazo_complicaciones o : aec) {
            if (o.getEmb_comp_descripcion().equals(text)) {
                if (o.getEmb_comp_tipo()==id) {
                    res=o.getEmb_comp_id();
                }
            }
        }
        return res;
    }

    public ArrayList<Embarazo_complicaciones> getAec() {
        return aec;
    }

    public void setAec(ArrayList<Embarazo_complicaciones> aec) {
        this.aec = aec;
    }
    
}
