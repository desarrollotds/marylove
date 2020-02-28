/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.util.Date;
import marylove.models.PlanAtencionTerapeutica;

/**
 *
 * @author LENOVO
 */
public class PlanAtencionTerapeuticoDB extends PlanAtencionTerapeutica {

    public PlanAtencionTerapeuticoDB() {
    }

    public PlanAtencionTerapeuticoDB(String plan_at_codigo, Date plan_at_fecha, String plan_at_derechos_victima, String plan_at_estrategias_rep, String plan_at_compromisos_terep) {
        super(plan_at_codigo, plan_at_fecha, plan_at_derechos_victima, plan_at_estrategias_rep, plan_at_compromisos_terep);
    }

    public PlanAtencionTerapeuticoDB(String plan_at_codigo) {
        super(plan_at_codigo);
    }
    
    
//     public boolean insertarArtEntregados() {
//        String sql = "INSERT INTO ficha_plan_atencion_terapeuta"
//                + "(plan_at_codigo, hist_id,plan_at_fecha, plan_at_encuadre_terapeuta,plam_at_obj_atencion,plan_at_derechos_victima,plan_at_estrategias_rep,plan_at_compromisos_terap)";
//        sql += "VALUES";
//        sql += "(9,'"+ge + "','" + getArticulo_observaciones() + "'," + getArticulo_cantidad() + ")";
//        PreparedStatement ps = conectar.getPs(sql);
//        if (conectar.noQuery(sql) == null) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
