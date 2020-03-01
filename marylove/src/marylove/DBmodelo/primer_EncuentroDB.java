package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Primer_encuentro;

/**
 *
 * @author USUARIO
 */
public class primer_EncuentroDB extends Primer_encuentro {

    Conexion conectar = new Conexion();

    public primer_EncuentroDB() {
    }

    public primer_EncuentroDB(int primer_codigo, int victima_codigo, Date pstIntCrisis_fecha, String pstIntCrisis_estado_emocional, String pstIntCrisis_nivel_riesgo, String pstIntCrisis_valoracionpreliminar, boolean pstIntCrisis_riesgo_suicida, String pstIntCrisis_puntosReelevantes, boolean pstIntCrisis_proceso_psicoterapeutico, boolean pstIntCrisis_asesoria, int psicologo_codigo) {
        super(primer_codigo, victima_codigo, pstIntCrisis_fecha, pstIntCrisis_estado_emocional, pstIntCrisis_nivel_riesgo, pstIntCrisis_valoracionpreliminar, pstIntCrisis_riesgo_suicida, pstIntCrisis_puntosReelevantes, pstIntCrisis_proceso_psicoterapeutico, pstIntCrisis_asesoria, psicologo_codigo);
    }

    public boolean Ingresar_PrimerEncuentro() {
        System.out.println("entra = true");
        String sql = "INSERT INTO public.primer_encuentro"
                + "(primer_codigo, victima_codigo, pstintcrisis_fecha, pstintcrisis_estado_emocional, pstintcrisis_nivel_riesgo, pstintcrisis_valoracionpreliminar, pstintcrisis_riesgo_suicida,pstintcrisis_puntosreelevantes, pstintcrisis_proceso_psicoterapeutico, pstintcrisis_asesoria,psicologo_codigo)";
            sql += "VALUES ";
            sql += "("+getPrimer_codigo() + "'," + getVictima_codigo() + "'," + getPstIntCrisis_fecha() + "',"+getPstIntCrisis_estado_emocional() + "'," + getPstIntCrisis_nivel_riesgo() + "'," + getPstIntCrisis_valoracionpreliminar() + "',"+ isPstIntCrisis_riesgo_suicida() + "'," + getPstIntCrisis_puntosReelevantes() + "'," + isPstIntCrisis_proceso_psicoterapeutico() + "',"+ isPstIntCrisis_asesoria() + "'," + getPsicologo_codigo() + ")";
        PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            //conectar.cerrarConexion();
            return true;
        } else {
            conectar.cerrarConexion();
            return false;
        }
    }

}
