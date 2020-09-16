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
import marylove.models.Embarazo_complicaciones_json;
import marylove.models.Json_object_consulta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    private static String descripcion_static;

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
//        ps = conectar.getConnection().prepareStatement(sql);
//        ps.execute();
        if(conectar.noQuery(sql)){
            System.out.println("Insertado");
        }else{
            System.out.println("Error");
        }
    }

    public ArrayList<Embarazo_complicaciones> obtener_objeto() throws SQLException {
        
        sql = "SELECT emb_comp_id, emb_comp_descripcion, emb_comp_tipo "
                + " FROM public.embarazo_complicaciones;";
        re = conectar.query(sql);
//        ps = conectar.getConnection().prepareStatement(sql);
//        re = ps.executeQuery();
//        conectar.cerrarConexion();
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

    public void punto1Anamnesis(Embarazo_complicaciones Ec, String json) throws ParseException {
        Embarazo_complicaciones_json ecj;
        ArrayList<Embarazo_complicaciones_json> aecj = new ArrayList<>();
        Object o = null;

        o= new JSONParser().parse(json);
         JSONArray complicaciones = (JSONArray) o;
            for (int i = 0; i < complicaciones.size(); i++) {
                JSONObject etc = (JSONObject) complicaciones.get(i);
                long emb_comp_id = (long) etc.get("emb_comp_id");
                int id_id = (int) emb_comp_id;
                String descripcion = (String) etc.get("descripcion");
                if (!descripcion.equals("")) {
                    descripcion_static=descripcion;
                }
                boolean estado = (boolean) etc.get("estado");
                ecj = new Embarazo_complicaciones_json(id_id,descripcion,estado);
                aecj.add(ecj);

            }
        for (Embarazo_complicaciones_json a: aecj) {
            int emb_comp_id = a.getEmb_comp_id();
            boolean estado = a.isEstado();
            for (Embarazo_complicaciones e: aec) {
                if (emb_comp_id==e.getEmb_comp_id() && estado == true) {
                    Ec = new Embarazo_complicaciones();
                    Ec.setEmb_comp_id(e.getEmb_comp_id());
                    Ec.setEmb_comp_descripcion(e.getEmb_comp_descripcion());
                    Ec.setEmb_comp_tipo(e.getEmb_comp_tipo());
                    ListaEC.add(Ec);
                }
            }
        
        }
    }

    public static String getDescripcion_static() {
        return descripcion_static;
    }

    public static void setDescripcion_static(String descripcion_static) {
        Embarazo_complicacionesDB.descripcion_static = descripcion_static;
    }


    public ArrayList<Embarazo_complicaciones> getAec() {
        return aec;
    }

    public void setAec(ArrayList<Embarazo_complicaciones> aec) {
        this.aec = aec;
    }
    
}
