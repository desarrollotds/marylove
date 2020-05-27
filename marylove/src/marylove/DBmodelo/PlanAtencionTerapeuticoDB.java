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
import marylove.models.PlanAtencionTerapeutica;

/**
 *
 * @author LENOVO
 */
public class PlanAtencionTerapeuticoDB extends PlanAtencionTerapeutica {

    PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar = new ConexionHi();
    String sql = "";

    public PlanAtencionTerapeuticoDB() {
    }

    public PlanAtencionTerapeuticoDB(String plan_at_codigo, String plan_at_fecha, String plan_at_encuadre_terapeuta, String plan_at_obj_atencion, String plan_at_derechos_victima, String plan_at_estrategias_rep, String plan_at_compromisos_terep, int hist_id, int victima_codigo, int psicologo_codigo, String motivo_consulta, String demanda, String demanda_implicita, String historial_violencia, String biog_psico_perso, byte[] genograma_famili, int gfLong, String prub_descripcion, String apart_gene_conduct, String conducta, String func_cogni_sensorio, String estado_consiencia, String orientacion, String memoria, String atencion_concentracion, String afectividad, String funciones_ment_superior, String diagnos_infor, String diagnos_diferencial, String personality_descrip, String senala_tecnicas, String recomendaciones) {
        super(plan_at_codigo, plan_at_fecha, plan_at_encuadre_terapeuta, plan_at_obj_atencion, plan_at_derechos_victima, plan_at_estrategias_rep, plan_at_compromisos_terep, hist_id, victima_codigo, psicologo_codigo, motivo_consulta, demanda, demanda_implicita, historial_violencia, biog_psico_perso, genograma_famili, gfLong, prub_descripcion, apart_gene_conduct, conducta, func_cogni_sensorio, estado_consiencia, orientacion, memoria, atencion_concentracion, afectividad, funciones_ment_superior, diagnos_infor, diagnos_diferencial, personality_descrip, senala_tecnicas, recomendaciones);
    }

    public PlanAtencionTerapeuticoDB(String plan_at_codigo) {
        super(plan_at_codigo);
    }

    public boolean insertarArtEntregados(){

        sql = "INSERT INTO ficha_plan_atencion_terapeuta"
                + "( plan_at_fecha, plan_at_encuadre_terapeuta, plan_at_obj_atencion, plan_at_derechos_victima, plan_at_estrategias_rep,plan_at_compromisos_terap, hist_id)";
        sql += "VALUES";
        sql += "('" + getPlan_at_fecha() + "','" + getPlan_at_encuadre_terapeuta() + "','" + getPlan_at_obj_atencion() + "','" + getPlan_at_derechos_victima() + "','" + getPlan_at_estrategias_rep() + "','" + getPlan_at_compromisos_terep() + "', " + getHist_id() + ")";

        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }

    public int planATID(int cod) {
        int id = 0;
        try {
            String sql = "select plan_at_codigo from ficha_plan_atencion_terapeuta where hist_id = " + cod + " ;";
            re = conectar.query(sql);
            while (re.next()) {
                id = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("error al obtener id del plan de atencion " + ex.getMessage());
        }
        return id;
    }
    
    public PlanAtencionTerapeutica planATDatos(int cod) {
        PlanAtencionTerapeutica pAT= new PlanAtencionTerapeutica();
        try {
            String sql = "select * from ficha_plan_atencion_terapeuta where hist_id = " + cod + " ;";
            re = conectar.query(sql);
            while (re.next()) {
                pAT.setPlan_at_codigo(re.getInt(1)+"");
                pAT.setHist_id(re.getInt(2));
                pAT.setPlan_at_fecha(re.getString(3));
                pAT.setPlan_at_encuadre_terapeuta(re.getString(4));
                pAT.setPlan_at_obj_atencion(re.getString(5));
                pAT.setPlan_at_derechos_victima(re.getString(6));
                pAT.setPlan_at_estrategias_rep(re.getString(7));
                pAT.setPlan_at_compromisos_terep(re.getString(8));
            }
        } catch (SQLException ex) {
            System.out.println("error al obtener datos del plan de atencion " + ex.getMessage());
        }
        return pAT;
    }
    
    public boolean actualizar(PlanAtencionTerapeutica pat) {
        boolean ingre = false;
        try {
            String sql = "UPDATE ficha_plan_atencion_terapeuta SET ";
            sql += "plan_at_fecha = '" + pat.getPlan_at_fecha() + "', ";
            sql += "plan_at_encuadre_terapeuta = '" + pat.getPlan_at_encuadre_terapeuta()+ "', ";
            sql += "plan_at_obj_atencion = '" + pat.getPlan_at_obj_atencion() + "', ";
            sql += "plan_at_derechos_victima = '" + pat.getPlan_at_derechos_victima() + "', ";
            sql += "plan_at_estrategias_rep = '" + pat.getPlan_at_estrategias_rep() + "', ";
            sql += "plan_at_compromisos_terap = '" + pat.getPlan_at_compromisos_terep() + "' ";
            sql += "WHERE hist_id = " + pat.getHist_id() + " ;";
            ingre = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al editar Historia clinico " + ex.getMessage());
            ingre = false;
        }
        return  ingre;
    }
}
