
package marylove.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import marylove.conexion.Conexion;
import marylove.models.Primer_encuentro;

/**
 *
 * @author LENOVO
 */
public class priEncuentroDao {
   private String mensaje="";
                              //conexion      //objeto
    public String agregarDatos (Connection con, Primer_encuentro pe){
        PreparedStatement pst = null;
        String sql= "insert into primer_encuentro (primer_codigo, victima_codigo,pstintcrisis_fecha,pstintcrisis_estado_emocional,pstintcrisis_nivel_riesgo,pstintcrisis_valoracionpreliminar,pstintcrisis_riesgo_suicida,pstintcrisis_puntosreelevantes,pstintcrisis_proceso_psicoterapeutico,pstintcrisis_asesoria,psicologo_codigo) \n" +
                "values (?,?,?,?,?,?,?,?,?,?,?)"; //continuar desde aqui 
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pe.getPrimer_codigo());
//            pst.setInt(2, pe.getVictima_codigo());
//            //pst.setDate(3, pe.getPstIntCrisis_fecha());
//            //pst.setBoolean(4, pe.getPstIntCrisis_estado_emocional());
//            pst.setString(5, pe.getPstIntCrisis_nivel_riesgo());
//            pst.setString(6, pe.getPstIntCrisis_valoracionpreliminar());
//            pst.setString(7, pe.getPstIntCrisis_riesgo_suicida());
//            pst.setString(8, pe.getPstIntCrisis_puntosReelevantes());
//           // pst.setInt(9, pe.getPsicologo_psicoterapesutico());
//            pst.setInt(10, pe.get());
//            pst.setInt(11, pe.getPrimer_codigo());
            
        } catch (Exception e) {
        }
        return mensaje;
    }
}
