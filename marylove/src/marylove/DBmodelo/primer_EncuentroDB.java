package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.conexion.ConexionHi;
import marylove.models.Primer_encuentro;

/**
 *
 * @author USUARIO
 */
public class primer_EncuentroDB extends Primer_encuentro {

    ConexionHi conn;
    PreparedStatement ps;
    ResultSet re = null;
    Conexion conectar = new Conexion();

    public primer_EncuentroDB() {
    }

    public primer_EncuentroDB(int primer_codigo, int victima_codigo, Date pstIntCrisis_fecha, String pstIntCrisis_estado_emocional, String pstIntCrisis_nivel_riesgo, String pstIntCrisis_valoracionpreliminar, String pstIntCrisis_riesgo_suicida, String pstIntCrisis_puntosReelevantes, boolean pstIntCrisis_proceso_psicoterapeutico, boolean pstIntCrisis_asesoria, int psicologo_codigo) {
        super(primer_codigo, victima_codigo, pstIntCrisis_fecha, pstIntCrisis_estado_emocional, pstIntCrisis_nivel_riesgo, pstIntCrisis_valoracionpreliminar, pstIntCrisis_riesgo_suicida, pstIntCrisis_puntosReelevantes, pstIntCrisis_proceso_psicoterapeutico, pstIntCrisis_asesoria, psicologo_codigo);
    }

    public boolean Ingresar_PrimerEncuentro(Conexion con, Primer_encuentro pE) {
        boolean entra = true;
        try {
            String sql = "INSERT INTO public.primer_encuentro"
                + "(primer_codigo, victima_codigo, pstintcrisis_fecha, pstintcrisis_estado_emocional, "
                + "pstintcrisis_nivel_riesgo, pstintcrisis_valoracionpreliminar, pstintcrisis_riesgo_suicida,"
                + "pstintcrisis_puntosreelevantes, pstintcrisis_proceso_psicoterapeutico, pstintcrisis_asesoria, psicologo_codigo)"
                + "VALUES (" + getPrimer_codigo() + "'," + getVictima_codigo() + "'," + getPstIntCrisis_fecha() + "',"
                + getPstIntCrisis_estado_emocional() + "'," + getPstIntCrisis_nivel_riesgo() + "'," + getPstIntCrisis_valoracionpreliminar() + "',"
                + getPstIntCrisis_riesgo_suicida() + "'," + getPstIntCrisis_puntosReelevantes() + "'," + isPstIntCrisis_proceso_psicoterapeutico() + "',"
                + isPstIntCrisis_asesoria() + "'," + getPsicologo_codigo() + ")";
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
