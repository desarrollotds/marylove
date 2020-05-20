/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.PlanAtencionTerapeutica;

/**
 *
 * @author LENOVO
 */
public class PlanAtencionTerapeuticoDB extends PlanAtencionTerapeutica {
    
     PreparedStatement ps;
    ResultSet re = null;
    ConexionHi conectar ; //= new ConexionHi();
    String sql="";
    public PlanAtencionTerapeuticoDB() {
    }

    public PlanAtencionTerapeuticoDB(String plan_at_codigo, String plan_at_fecha, String plan_at_encuadre_terapeuta, String plan_at_obj_atencion, String plan_at_derechos_victima, String plan_at_estrategias_rep, String plan_at_compromisos_terep, int hist_id, int victima_codigo, int psicologo_codigo, String motivo_consulta, String demanda, String demanda_implicita, String historial_violencia, String biog_psico_perso, byte[] genograma_famili, int gfLong, String prub_descripcion, String apart_gene_conduct, String conducta, String func_cogni_sensorio, String estado_consiencia, String orientacion, String memoria, String atencion_concentracion, String afectividad, String funciones_ment_superior, String diagnos_infor, String diagnos_diferencial, String personality_descrip, String senala_tecnicas, String recomendaciones) {
        super(plan_at_codigo, plan_at_fecha, plan_at_encuadre_terapeuta, plan_at_obj_atencion, plan_at_derechos_victima, plan_at_estrategias_rep, plan_at_compromisos_terep, hist_id, victima_codigo, psicologo_codigo, motivo_consulta, demanda, demanda_implicita, historial_violencia, biog_psico_perso, genograma_famili, gfLong, prub_descripcion, apart_gene_conduct, conducta, func_cogni_sensorio, estado_consiencia, orientacion, memoria, atencion_concentracion, afectividad, funciones_ment_superior, diagnos_infor, diagnos_diferencial, personality_descrip, senala_tecnicas, recomendaciones);
    }
    

    public PlanAtencionTerapeuticoDB(String plan_at_codigo) {
        super(plan_at_codigo);
    }
    
    
     public boolean insertarArtEntregados() {
         boolean ingreso=true;
         try {
              sql = "INSERT INTO ficha_plan_atencion_terapeuta"
                     + "( plan_at_fecha, plan_at_encuadre_terapeuta, plan_at_obj_atencion, plan_at_derechos_victima, plan_at_estrategias_rep,plan_at_compromisos_terap)";
             sql += "VALUES";
             sql += "('" + getPlan_at_fecha() + "','" + getPlan_at_encuadre_terapeuta() + "','" +getPlan_at_obj_atencion()+"','"+getPlan_at_derechos_victima()+ "','" +getPlan_at_estrategias_rep()+"','"+getPlan_at_compromisos_terep()+"')";
             
             ps = conectar.getConnection().prepareStatement(sql);
             ps.execute();
             ingreso=true;
         } catch (SQLException ex) {
             System.out.println("error:" +ex.getMessage());
             ingreso=false;
         }
         conectar.cerrarConexion();
         return ingreso;
    }
}
