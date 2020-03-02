
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.HistorialClinico;

/**
 *
 * @author vasquez
 */
public class HistorialClinicoDB extends HistorialClinico{
    PreparedStatement ps;
    ResultSet re = null;

    public HistorialClinicoDB() {
    }
    
    public boolean ingresarHistClinico(Conexion con, HistorialClinico hc){
        boolean ingre=true;
        try {
            String sql = "INSERT INTO public.historial_clinico (victima_codigo, "
                    + "psicologo_codigo, motivo_consulta, demanda, demanda_implicita, historial_violencia, biog_psico_perso,"
                    +" prub_descrip, apart_gene_conduct, conducta, func_cogni_sensorio, estado_consciencia,"
                    +" orientacion, memoria, atencion_concentracion, afectividad, funciones_ment_superior, diagnos_infor,"
                    +" diagnos_diferencial, personality_descrip, senala_tecnicas, recomendaciones, genograma_famili)"
                    + " VALUES (" + hc.getVictima_codigo() + "," + hc.getPsicologo_codigo()+ ",'"+hc.getMotivo_consulta()
                    + "','" + hc.getDemanda() + "','" + hc.getDemanda_implicita() + "','"+hc.getHistorial_violencia()
                    + "','"+ hc.getBiog_psico_perso() +"','"+hc.getPrub_descripcion()
                    +"','"+hc.getApart_gene_conduct()+"','"+hc.getConducta()+"','"+hc.getFunc_cogni_sensorio()
                    +"','"+hc.getEstado_consiencia()+"','"+hc.getOrientacion()+"','"+hc.getMemoria()+"','"+hc.getAtencion_concentracion()
                    +"','"+hc.getAfectividad()+"','"+hc.getFunciones_ment_superior()+"','"+hc.getDiagnos_infor()
                    +"','"+hc.getDiagnos_diferencial()+"','"+hc.getPersonality_descrip()+"','"+hc.getSenala_tecnicas()
                    +"','"+hc.getRecomendaciones()+"',?);";
            ps = con.conectarBD().prepareStatement(sql);
            ps.setBytes(1, hc.getGenograma_famili());
            ps.execute();
            ingre = true;

        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar ficha Historial Clinico: "+ex.getMessage());
            ingre = false;
        }
        con.cerrarConexion();
        return ingre; 
    }
    
    public HistorialClinico obtenetCV(Conexion con, String ced){
        HistorialClinico hisCli = new HistorialClinico();
        try {
            String sql = "select * from historial_clinico as hc"
                    +" join victima as vc on hc.victima_codigo = vc.victima_codigo"
                    +" join persona as pe on vc.persona_codigo = pe.persona_codigo"
                    +" where pe.persona_cedula = '"+ced+"';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                hisCli.setHist_id(re.getInt(1));
                hisCli.setVictima_codigo(re.getInt(2));
                hisCli.setMotivo_consulta(re.getString(3));
                hisCli.setPsicologo_codigo(re.getInt(24));
            }
        } catch (SQLException ex) {
            System.out.println("error al obtener datos de victima "+ex.getMessage());
        }
        con.cerrarConexion();
        return hisCli;
    }
    
}
