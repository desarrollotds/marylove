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
import marylove.models.HistorialClinico;
import marylove.models.PlanEmergente;
import marylove.models.PlanEmergenteItem;

/**
 *
 * @author LENqweqweqOVO
 */
public class PlanEmergente2DB extends PlanEmergente {

    ConexionHi conex = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;

    public PlanEmergente2DB() {
    }

    public PlanEmergente2DB(int victima_codigo, String emergente_fecha, int personal_codigo) {
        super(victima_codigo, emergente_fecha, personal_codigo);
    }

    public boolean ingresarPlan2() {
        boolean ingre = true;
        try {

            String sql = "INSERT INTO public.plan_emergente(victima_codigo, emergente_fecha, personal_codigo)";
            sql += "VALUES";
            sql += " ('" + getVictima_codigo() + "','" + getEmergente_fecha() + "','" + getPersonal_codigo() + "')";
            ps = conex.getConnection().prepareStatement(sql);
            ps.execute();

            if (conex.noQuery(sql) == null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        }
        conex.cerrarConexion();
        return ingre;
    }

    public void obtenetSelect(int ced) {
     
        try {
            String sql = "SELECT "
                    + "a.item_id,"
                    + "a.emergente_id,"
                    + "p.emergente_id, "
                    + "a.apreciacioninicial, "
                    + "a.accionesinmediatas, "
                    + "a.item_fecha, "
                    + "a.modalidad_nombre,"
                    + "p.emergente_fecha,"
                    + "p.victima_codigo"
                    + " FROM plan_emerg_item a"
                    + " JOIN plan_emergente p on p.emergente_id =a.emergente_id"
                    + " JOIN victima v ON v.victima_codigo = p.victima_codigo"
                    + " JOIN persona per ON per.persona_codigo = v.persona_codigo"             
                    + " WHERE per.persona_cedula = '"+ced+"';";
            ps = conex.getConnection().prepareStatement(sql);
            re = ps.executeQuery();

        } catch (SQLException ex) {
            System.out.println("error al obtener datos de victima mijin  " + ex.getMessage());
        }
        conex.cerrarConexion();
       
    }
    public int obtenerCodigo(int cod) {
        int id = 0;
        try {
            String sql = "select plan_emergente from victima_codigo where =" + cod + ";";
            ps = conex.getConnection().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                id = (re.getInt(1) + 1);
            }
            re = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener id " + ex.getMessage());
        }
        conex.cerrarConexion();
        return id;
    }

}//sdfsdfsdf
