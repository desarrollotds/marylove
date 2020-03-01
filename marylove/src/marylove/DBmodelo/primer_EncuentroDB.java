package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Primer_encuentro;

/**
 *
 * @author USUARIO
 */
public class primer_EncuentroDB extends Primer_encuentro {

    PreparedStatement ps;
    ResultSet re = null;
    boolean entra = true;
    public boolean Ingresar_PrimerEncuentro(Conexion con, Primer_encuentro pE) {
        System.out.println("entra = true");
        
        try {
            String sql = "INSERT INTO public.primer_encuentro"
                + "(primer_codigo, victima_codigo, pstintcrisis_fecha, pstintcrisis_estado_emocional, "
                + "pstintcrisis_nivel_riesgo, pstintcrisis_valoracionpreliminar, pstintcrisis_riesgo_suicida,"
                + "pstintcrisis_puntosreelevantes, pstintcrisis_proceso_psicoterapeutico, pstintcrisis_asesoria, psicologo_codigo"
                + "VALUES (" + pE.getPrimer_codigo() + "'," + pE.getVictima_codigo() + "'," + pE.getPstIntCrisis_fecha() + "',"
                + pE.getPstIntCrisis_estado_emocional() + "'," + pE.getPstIntCrisis_nivel_riesgo() + "'," + pE.getPstIntCrisis_valoracionpreliminar() + "',"
                + pE.isPstIntCrisis_riesgo_suicida() + "'," + pE.getPstIntCrisis_puntosReelevantes() + "'," + pE.isPstIntCrisis_proceso_psicoterapeutico() + "',"
                + pE.isPstIntCrisis_asesoria() + "'," + pE.getPsicologo_codigo() + "';";
//            ps = conn.getConection().prepareStatement(sql);
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            System.out.println("Ingresados datos Correctos");

        } catch (SQLException ex) {
            Logger.getLogger(primer_EncuentroDB.class.getName()).log(Level.SEVERE, null, ex);
            entra = false;
        }
        con.cerrarConexion();
        return entra;
    }
    
}
