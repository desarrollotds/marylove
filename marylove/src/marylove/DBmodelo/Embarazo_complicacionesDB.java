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
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.controlador.FiltroHijosVictima;
import marylove.models.Embarazo_complicaciones;

/**
 *
 * @author Asus
 */
public class Embarazo_complicacionesDB extends Embarazo_complicaciones {

    PreparedStatement ps;
    ResultSet re;
    victimaDB vdb;
     ConexionHi conectar =new ConexionHi();
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
        ps = conectar.getConnection().prepareStatement(sql);
        ps.execute();
    }

    public ArrayList<Embarazo_complicaciones> obtener_objeto() throws SQLException {
        
        sql = "SELECT emb_comp_id, emb_comp_descripcion, emb_comp_tipo "
                + " FROM public.embarazo_complicaciones;";
        ps = conectar.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        conectar.cerrarConexion();
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
     public static ArrayList<Embarazo_complicaciones> ListaEC = new ArrayList<>();

    public void punto1Anamnesis(Embarazo_complicaciones Ec) {
        sql = "select e.emb_comp_descripcion, e.emb_comp_tipo, x.mater_otro_descrip FROM x_embarazo_comp x, embarazo_complicaciones e, embarazo_estado ee,  anamnesis an where    x.emb_comp_id=e.emb_comp_id and ee.embarazo_id=x.embarazo_id and an.embarazo_id=ee.embarazo_id and an.hijo_codigo=" + FiltroHijosVictima.getCodigo() + ";";
        System.out.println(sql);
        try {
            re = conectar.query(sql);
            while (re.next()) {
                Ec=new Embarazo_complicaciones();
                Ec.setEmb_comp_descripcion(re.getString(1));
                Ec.setEmb_comp_tipo(re.getInt(2));
                Ec.setMater_otro_descrip(re.getString(3));
                ListaEC.add(Ec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Embarazo_complicacionesDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public ArrayList<Embarazo_complicaciones> getAec() {
        return aec;
    }

    public void setAec(ArrayList<Embarazo_complicaciones> aec) {
        this.aec = aec;
    }
    
}
