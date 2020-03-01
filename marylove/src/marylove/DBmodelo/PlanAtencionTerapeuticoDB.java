/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.util.Date;
import marylove.conexion.Conexion;
import marylove.models.PlanAtencionTerapeutica;

/**
 *
 * @author LENOVO
 */
public class PlanAtencionTerapeuticoDB extends PlanAtencionTerapeutica {
    
    Conexion conectar = new Conexion();
    String sql="";
    public PlanAtencionTerapeuticoDB() {
    }

    public PlanAtencionTerapeuticoDB(String plan_at_codigo, Date plan_at_fecha, String plan_at_encuadre_terapeuta, String plan_at_obj_atencion, String plan_at_derechos_victima, String plan_at_estrategias_rep, String plan_at_compromisos_terep, int hist_id, int victima_codigo, String motivo_consulta, String demanda, String demanda_implicita, String historial_violencia, String biog_psico_perso, String genograma_famili, String prub_descripcion, String apart_gene_conduct, String conducta, String func_cogni_sensorio, String estado_consiencia, String orientacion, String memoria, String atencion_concentracion, String afectividad, String funciones_ment_superior, String diagnos_infor, String diagnos_diferencial, String personality_descrip, String senala_tecnicas, String recomendaciones) {
        super(plan_at_codigo, plan_at_fecha, plan_at_encuadre_terapeuta, plan_at_obj_atencion, plan_at_derechos_victima, plan_at_estrategias_rep, plan_at_compromisos_terep, hist_id, victima_codigo, motivo_consulta, demanda, demanda_implicita, historial_violencia, biog_psico_perso, genograma_famili, prub_descripcion, apart_gene_conduct, conducta, func_cogni_sensorio, estado_consiencia, orientacion, memoria, atencion_concentracion, afectividad, funciones_ment_superior, diagnos_infor, diagnos_diferencial, personality_descrip, senala_tecnicas, recomendaciones);
    }

    

    public PlanAtencionTerapeuticoDB(String plan_at_codigo) {
        super(plan_at_codigo);
    }
    
    
     public boolean insertarArtEntregados() {
       sql = "INSERT INTO ficha_plan_atencion_terapeuta"
                + "(plan_at_codigo, hist_id, plan_at_fecha, plan_at_encuadre_terapeuta, plan_at_obj_atencion, plan_at_derechos_victima, plan_at_estrategias_rep,plan_at_compromisos_terap)";
        sql += "VALUES";
        sql += "(9,"+getHist_id()+ ",'" + getPlan_at_fecha() + "','" + getPlan_at_encuadre_terapeuta() + "','" +getPlan_at_obj_atencion()+"','"+getPlan_at_derechos_victima()+ "','" +getPlan_at_estrategias_rep()+"','"+getPlan_at_compromisos_terep()+")";
        PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
}
