package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Plan_de_Vida;
import marylove.models.Primer_encuentro;

/**
 *
 * @author USUARIO
 */
public class primer_EncuentroDB extends Primer_encuentro {
     PreparedStatement ps;
    ResultSet re = null;
    String sql="";
    ConexionHi conectar = new ConexionHi();
    boolean ingreso = true;
    
    public primer_EncuentroDB() {
    }

    public primer_EncuentroDB(int primer_codigo, int victima_codigo, String pstIntCrisis_fecha, String pstIntCrisis_estado_emocional, String pstIntCrisis_nivel_riesgo, String pstIntCrisis_valoracionpreliminar, boolean pstIntCrisis_riesgo_suicida, String pstIntCrisis_puntosReelevantes, boolean pstIntCrisis_proceso_psicoterapeutico, boolean pstIntCrisis_asesoria, int psicologo_codigo) {
        super(primer_codigo, victima_codigo, pstIntCrisis_fecha, pstIntCrisis_estado_emocional, pstIntCrisis_nivel_riesgo, pstIntCrisis_valoracionpreliminar, pstIntCrisis_riesgo_suicida, pstIntCrisis_puntosReelevantes, pstIntCrisis_proceso_psicoterapeutico, pstIntCrisis_asesoria, psicologo_codigo);
    }
    

    public boolean Ingresar_PrimerEncuentro() {       
        try {
             sql = "INSERT INTO public.primer_encuentro"
                    + "(victima_codigo, pstintcrisis_fecha, pstintcrisis_estado_emocional, pstintcrisis_nivel_riesgo, pstintcrisis_valoracionpreliminar, pstintcrisis_riesgo_suicida,pstintcrisis_puntosreelevantes, pstintcrisis_proceso_psicoterapeutico, pstintcrisis_asesoria,psicologo_codigo,primer_encuentro_estado)";
            sql += "VALUES ";
            sql += "("+ getVictima_codigo() + ",'" + getPstIntCrisis_fecha()
                    + "','" + getPstIntCrisis_estado_emocional() + "','" + getPstIntCrisis_nivel_riesgo()
                    + "','" + getPstIntCrisis_valoracionpreliminar() + "'," + isPstIntCrisis_riesgo_suicida()
                    + ",'" + getPstIntCrisis_puntosReelevantes() + "'," + isPstIntCrisis_proceso_psicoterapeutico()
                    + "," + isPstIntCrisis_asesoria() + "," + getPsicologo_codigo() + ",'a')";
//            ps = conectar.getConnection().prepareStatement(sql);
//            ps.execute();
            ingreso = conectar.noQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al ingresar Primer Encuentro: " + ex.getMessage());
            ingreso = false;
        }
        conectar.cerrarConexion();
        return ingreso;
    }
     public boolean actualizar1Encuent() {
        sql = "UPDATE public.primer_encuentro SET ";
        sql += "pstintcrisis_estado_emocional='" + getPstIntCrisis_estado_emocional()+ "', ";
        sql += "pstintcrisis_nivel_riesgo='" + getPstIntCrisis_nivel_riesgo()+ "', ";
        sql += "pstintcrisis_valoracionpreliminar='" + getPstIntCrisis_valoracionpreliminar()+ "', ";
        sql += "pstintcrisis_riesgo_suicida='" + isPstIntCrisis_riesgo_suicida()+ "', ";
        sql += "pstintcrisis_puntosreelevantes='" + getPstIntCrisis_puntosReelevantes()+ "', ";
        sql += "pstintcrisis_proceso_psicoterapeutico='" + isPstIntCrisis_proceso_psicoterapeutico() + "', ";
        sql += "pstintcrisis_asesoria='" + isPstIntCrisis_asesoria()+ "' ";
        sql += " WHERE primer_codigo='" + getPrimer_codigo()+ "';";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }
      public boolean eliminar1Enc() {
        sql = "UPDATE primer_encuentro SET primer_encuentro_estado = 'd' WHERE primer_codigo='" + getPrimer_codigo()+ "'";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }
       public List<Primer_encuentro> listarPrimerEn() throws SQLException {
        List<Primer_encuentro> listarPrimerEn = new ArrayList<>();
        sql = "select epv.primer_codigo,per.persona_cedula,per.persona_nombre, per.persona_apellido, epv.pstintcrisis_estado_emocional,epv.pstintcrisis_nivel_riesgo,epv.pstintcrisis_valoracionpreliminar,epv.pstintcrisis_riesgo_suicida,epv.pstintcrisis_puntosreelevantes, epv.pstintcrisis_proceso_psicoterapeutico, epv.pstintcrisis_asesoria, epv.pstintcrisis_fecha \n"
                + "from primer_encuentro epv\n"
                + "join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona per\n"
                + "on vc.persona_codigo = per.persona_codigo\n"
                + "where primer_encuentro_estado = 'a';";
        re = conectar.query(sql);
        try {
            while (re.next()) {
                Primer_encuentro p = new Primer_encuentro();
                p.setPrimer_codigo(re.getInt("primer_codigo"));
                p.setPersona_cedula(re.getString("persona_cedula"));
                p.setPersona_nombre(re.getString("persona_nombre"));
                p.setPersona_apellido(re.getString("persona_apellido"));
                p.setPstIntCrisis_estado_emocional(re.getString("pstintcrisis_estado_emocional"));
                p.setPstIntCrisis_nivel_riesgo(re.getString("pstintcrisis_nivel_riesgo"));
                p.setPstIntCrisis_valoracionpreliminar(re.getString("pstintcrisis_valoracionpreliminar"));
                p.setPstIntCrisis_riesgo_suicida(re.getBoolean("pstintcrisis_riesgo_suicida"));
                p.setPstIntCrisis_puntosReelevantes(re.getString("pstintcrisis_puntosreelevantes"));
                p.setPstIntCrisis_proceso_psicoterapeutico(re.getBoolean("pstintcrisis_proceso_psicoterapeutico"));
                p.setPstIntCrisis_asesoria(re.getBoolean("pstintcrisis_asesoria"));
                p.setPstIntCrisis_fecha(re.getString("pstintcrisis_fecha"));
                listarPrimerEn.add(p);
            }
            re.close();
            return listarPrimerEn;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
       public List<Primer_encuentro> buscarTexto1Encuent(String texto) throws SQLException {
        List<Primer_encuentro> buscarTexto = new ArrayList();
        System.out.println("testoDB: " + texto);
        sql = "select epv.primer_codigo,per.persona_cedula,per.persona_nombre, per.persona_apellido, epv.pstintcrisis_estado_emocional,epv.pstintcrisis_nivel_riesgo,epv.pstintcrisis_valoracionpreliminar,epv.pstintcrisis_riesgo_suicida,epv.pstintcrisis_puntosreelevantes, epv.pstintcrisis_proceso_psicoterapeutico, epv.pstintcrisis_asesoria, epv.pstintcrisis_fecha \n"
                + "from primer_encuentro epv\n"
                + "join victima vc\n"
                + "on epv.victima_codigo = vc.victima_codigo inner join persona per\n"
                + "on vc.persona_codigo = per.persona_codigo "
                + "where primer_encuentro_estado = 'a' and persona_cedula like '" + texto + "%'\n"
                + "OR persona_nombre LIKE '" + texto + "%'\n"
                + "OR persona_apellido like '" + texto + "%';";
        re = conectar.query(sql);
        try {
            while (re.next()) {
                Primer_encuentro p = new Primer_encuentro();
                p.setPrimer_codigo(re.getInt("primer_codigo"));
                p.setPersona_cedula(re.getString("persona_cedula"));
                p.setPersona_nombre(re.getString("persona_nombre"));
                p.setPersona_apellido(re.getString("persona_apellido"));
                p.setPstIntCrisis_estado_emocional(re.getString("pstintcrisis_estado_emocional"));
                p.setPstIntCrisis_nivel_riesgo(re.getString("pstintcrisis_nivel_riesgo"));
                p.setPstIntCrisis_valoracionpreliminar(re.getString("pstintcrisis_valoracionpreliminar"));
                p.setPstIntCrisis_riesgo_suicida(re.getBoolean("pstintcrisis_riesgo_suicida"));
                p.setPstIntCrisis_puntosReelevantes(re.getString("pstintcrisis_puntosreelevantes"));
                p.setPstIntCrisis_proceso_psicoterapeutico(re.getBoolean("pstintcrisis_proceso_psicoterapeutico"));
                p.setPstIntCrisis_asesoria(re.getBoolean("pstintcrisis_asesoria"));
                p.setPstIntCrisis_fecha(re.getString("pstintcrisis_fecha"));
                buscarTexto.add(p);

            }
            re.close();
            return buscarTexto;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}