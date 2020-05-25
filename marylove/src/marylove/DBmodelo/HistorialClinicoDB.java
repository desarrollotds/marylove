package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.HistorialClinico;

/**
 *
 * @author vasquez
 */
public class HistorialClinicoDB extends HistorialClinico {

    PreparedStatement ps;
    ResultSet re = null;

    ConexionHi conectar = new ConexionHi();

    public HistorialClinicoDB() {
    }

    public boolean ingresarHistClinico(HistorialClinico hc) {
        boolean ingre = true;
        try {
            String sql = "INSERT INTO public.historial_clinico (victima_codigo, "
                    + "psicologo_codigo, motivo_consulta, demanda, demanda_implicita, historial_violencia, biog_psico_perso,"
                    + " prub_descrip, apart_gene_conduct, conducta, func_cogni_sensorio, estado_consciencia,"
                    + " orientacion, memoria, atencion_concentracion, afectividad, funciones_ment_superior, diagnos_infor,"
                    + " diagnos_diferencial, personality_descrip, senala_tecnicas, recomendaciones, genograma_famili)"
                    + " VALUES (" + hc.getVictima_codigo() + "," + hc.getPsicologo_codigo() + ",'" + hc.getMotivo_consulta()
                    + "','" + hc.getDemanda() + "','" + hc.getDemanda_implicita() + "','" + hc.getHistorial_violencia()
                    + "','" + hc.getBiog_psico_perso() + "','" + hc.getPrub_descripcion()
                    + "','" + hc.getApart_gene_conduct() + "','" + hc.getConducta() + "','" + hc.getFunc_cogni_sensorio()
                    + "','" + hc.getEstado_consiencia() + "','" + hc.getOrientacion() + "','" + hc.getMemoria() + "','" + hc.getAtencion_concentracion()
                    + "','" + hc.getAfectividad() + "','" + hc.getFunciones_ment_superior() + "','" + hc.getDiagnos_infor()
                    + "','" + hc.getDiagnos_diferencial() + "','" + hc.getPersonality_descrip() + "','" + hc.getSenala_tecnicas()
                    + "','" + hc.getRecomendaciones() + "',? );";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.setBytes(1, hc.getGenograma_famili());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar ficha Historial Clinico: " + ex.getMessage());
            ingre = false;
        }
        conectar.cerrarConexion();
        return ingre;
    }

    public HistorialClinico obtenetCV(int ced) {
        HistorialClinico hisCli = new HistorialClinico();
        try {
            String sql = "select * from historial_clinico where victima_codigo = " + ced + " ;";
            re = conectar.query(sql);
            while (re.next()) {
                hisCli.setHist_id(re.getInt(1));
                hisCli.setVictima_codigo(re.getInt(2));
                hisCli.setMotivo_consulta(re.getString(3));
                hisCli.setDemanda(re.getString(4));
                hisCli.setDemanda_implicita(re.getString(5));
                hisCli.setHistorial_violencia(re.getString(6));
                hisCli.setBiog_psico_perso(re.getString(7));
                hisCli.setGenograma_famili(re.getBytes(8));
                hisCli.setPrub_descripcion(re.getString(9));
                hisCli.setApart_gene_conduct(re.getString(10));
                hisCli.setConducta(re.getString(11));
                hisCli.setFunc_cogni_sensorio(re.getString(12));
                hisCli.setEstado_consiencia(re.getString(13));
                hisCli.setOrientacion(re.getString(14));
                hisCli.setMemoria(re.getString(15));
                hisCli.setAtencion_concentracion(re.getString(16));
                hisCli.setAfectividad(re.getString(17));
                hisCli.setFunciones_ment_superior(re.getString(18));
                hisCli.setDiagnos_infor(re.getString(19));
                hisCli.setDiagnos_diferencial(re.getString(20));
                hisCli.setPersonality_descrip(re.getString(21));
                hisCli.setSenala_tecnicas(re.getString(22));
                hisCli.setRecomendaciones(re.getString(23));
                hisCli.setPsicologo_codigo(re.getInt(24));
            }
        } catch (SQLException ex) {
            hisCli = null;
            System.out.println("error al obtener datos de victima " + ex.getMessage());
        }
        return hisCli;
    }

    public boolean actualizar(HistorialClinico hc) {
        boolean ingre = false;
        try {
            String sql = "UPDATE historial_clinico SET ";
            sql += "motivo_consulta ='" + hc.getMotivo_consulta() + "', ";
            sql += "demanda ='" + hc.getDemanda() + "', ";
            sql += "demanda_implicita ='" + hc.getDemanda_implicita() + "', ";
            sql += "historial_violencia ='" + hc.getHistorial_violencia() + "', ";
            sql += "biog_psico_perso ='" + hc.getBiog_psico_perso() + "', ";
            sql += "prub_descrip ='" + hc.getPrub_descripcion() + "', ";
            sql += "apart_gene_conduct ='" + hc.getApart_gene_conduct() + "', ";
            sql += "conducta ='" + hc.getConducta() + "', ";
            sql += "func_cogni_sensorio ='" + hc.getFunc_cogni_sensorio() + "', ";
            sql += "estado_consciencia ='" + hc.getEstado_consiencia() + "', ";
            sql += "orientacion ='" + hc.getOrientacion() + "', ";
            sql += "memoria ='" + hc.getMemoria() + "', ";
            sql += "atencion_concentracion ='" + hc.getAtencion_concentracion() + "', ";
            sql += "afectividad ='" + hc.getAfectividad() + "', ";
            sql += "funciones_ment_superior ='" + hc.getFunciones_ment_superior() + "', ";
            sql += "diagnos_infor ='" + hc.getDiagnos_infor() + "', ";
            sql += "diagnos_diferencial ='" + hc.getDiagnos_diferencial() + "', ";
            sql += "personality_descrip ='" + hc.getPersonality_descrip() + "', ";
            sql += "senala_tecnicas ='" + hc.getSenala_tecnicas() + "', ";
            sql += "recomendaciones ='" + hc.getRecomendaciones() + "', ";
            sql += "genograma_famili = ? ";
            sql += "WHERE victima_codigo = " + hc.getVictima_codigo() + ";";
            ps = conectar.getConnection().prepareStatement(sql);
            ps.setBytes(1, hc.getGenograma_famili());
            ps.execute();
            ingre = true;
        } catch (Exception ex) {
            System.out.println("Error al editar Historia clinico " + ex.getMessage());
            ingre = false;
        }
        conectar.cerrarConexion();
        return  ingre;
    }
    
    public int HistId(int cod){
        int id = 0;
        try {
            String sql = "select hist_id from historial_clinico where victima_codigo= " + cod + " ;";
            re = conectar.query(sql);
            while (re.next()) {
                id = re.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("error al obtener datos de victima " + ex.getMessage());
        }
        return id;
    }
}
