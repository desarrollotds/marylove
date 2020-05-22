/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Post_parto;

/**
 *
 * @author Asus
 */
public class Post_partoDB extends Post_parto {

    ConexionHi conectar; //= new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;
    private static int post_parto_id_static;

    public static int getPost_parto_id_static() {
        return post_parto_id_static;
    }

    public static void setPost_parto_id_static(int post_parto_id_static) {
        Post_partoDB.post_parto_id_static = post_parto_id_static;
    }

    public Post_partoDB() {
    }

    public Post_partoDB(int Post_parto_id, String Sensacion_post_parto, boolean Sexo_esperado, String reaccion_padre, String reaccion_madre, boolean alim_leche_mater, String alim_leche_master_descrip, boolean problemas_succion, String destete_descripcion, int edad_sentar, int edad_caminar, int edad_primeras_palabras, int edad_aliment_solido, String dificultades_alimentacion, int veces_como_diario, String actitud_madre_no_come, String comer_solo_acompanado, boolean post_parto_estado, String edad_fin_leche_mater, boolean biberon, String biberon_edad_ini, String biberon_edad_fin) {
        super(Post_parto_id, Sensacion_post_parto, Sexo_esperado, reaccion_padre, reaccion_madre, alim_leche_mater, alim_leche_master_descrip, problemas_succion, destete_descripcion, edad_sentar, edad_caminar, edad_primeras_palabras, edad_aliment_solido, dificultades_alimentacion, veces_como_diario, actitud_madre_no_come, comer_solo_acompanado, post_parto_estado, edad_fin_leche_mater, biberon, biberon_edad_ini, biberon_edad_fin);
    }

    public Post_partoDB(int Post_parto_id, String Sensacion_post_parto, boolean Sexo_esperado, String reaccion_padre, String reaccion_madre, boolean alim_leche_mater, String alim_leche_master_descrip, boolean problemas_succion, String destete_descripcion, int edad_sentar, int edad_caminar, int edad_primeras_palabras, int edad_aliment_solido, String dificultades_alimentacion, int veces_como_diario, String actitud_madre_no_come, String comer_solo_acompanado, String edad_fin_leche_mater, boolean biberon, String biberon_edad_ini, String biberon_edad_fin) {
        super(Post_parto_id, Sensacion_post_parto, Sexo_esperado, reaccion_padre, reaccion_madre, alim_leche_mater, alim_leche_master_descrip, problemas_succion, destete_descripcion, edad_sentar, edad_caminar, edad_primeras_palabras, edad_aliment_solido, dificultades_alimentacion, veces_como_diario, actitud_madre_no_come, comer_solo_acompanado, edad_fin_leche_mater, biberon, biberon_edad_ini, biberon_edad_fin);
    }

    public Post_partoDB(String Sensacion_post_parto, boolean Sexo_esperado, String reaccion_padre, String reaccion_madre, boolean alim_leche_mater, String alim_leche_master_descrip, boolean problemas_succion, String destete_descripcion, int edad_sentar, int edad_caminar, int edad_primeras_palabras, int edad_aliment_solido, String dificultades_alimentacion, int veces_como_diario, String actitud_madre_no_come, String comer_solo_acompanado, String edad_fin_leche_mater, boolean biberon, String biberon_edad_ini, String biberon_edad_fin) {
        super(Sensacion_post_parto, Sexo_esperado, reaccion_padre, reaccion_madre, alim_leche_mater, alim_leche_master_descrip, problemas_succion, destete_descripcion, edad_sentar, edad_caminar, edad_primeras_palabras, edad_aliment_solido, dificultades_alimentacion, veces_como_diario, actitud_madre_no_come, comer_solo_acompanado, edad_fin_leche_mater, biberon, biberon_edad_ini, biberon_edad_fin);
    }

    public void llenarPostParto() {

//        String sql = "INSERT INTO post_parto(sensacion_post_parto, sexo_esperado, reaccion_padre, reaccion_madre, "
//                + "alim_leche_master, alim_leche_master_descrip, alim_leche_master_edad_ini, alim_leche_master_fin, "
//                + "problemas_succion, destete_descripcion, edad_sentar, edad_caminar, edad_primeras_palabras, "
//                + "edad_aliment_solido, dificultades_alimentacion, veces_como_diario, actitud_madre_no_come, comer_solo_acompanado) "
//                + "	VALUES ('"+getSensacion_post_parto()+"', '"+isSexo_esperado()+"',"
//                + " '"+getReaccion_padre()+"', '"+getReaccion_madre()+"', "
//                + " '"+getAlim_leche_master()+"', '"+getAlim_leche_master_descrip()+"',"
//                + " "+getAlim_leche_master_edad_ini()+", "+getAlim_leche_master_fin()+","
//                + " '"+getProblemas_succion()+"', '"+getDestete_descripcion()+"',"
//                + " "+getEdad_sentar()+", "+getEdad_caminar()+", "+getEdad_primeras_palabras()+", "
//                + " "+getEdad_aliment_solido()+", '"+getDificultades_alimentacion()+"',"
//                + " "+getVeces_como_diario()+", '"+getActitud_madre_no_come()+"',"
//                + " '"+getComer_solo_acompanado()+"')returning post_parto_id;";
//
//        ps=conectar.getConnection().prepareStatement(sql);
//        rs=ps.executeQuery();
//        conectar.cerrarConexion();
//        if(rs!=null){
//         while(rs.next()){
//        post_parto_id_static=rs.getInt(1);
//        }
//         return true;
//        }else{
//        return false;
//        }
    }

    //METODOS FICHA ANAMNESIS----------------------------------------------------------------------------------------------------------------------
    //1.6 ACTUALIZAR DATOS DE LOS PRIMEROS DÍAS VIDA
    public boolean actualizarDatosPrimerosDiasVida(int cod_PostParto) {
        String sql = "Select actualizarDatosPrimerosDiasVida(" + ""
                + cod_PostParto + ", "
                + "'" + isAlim_leche_mater() + "', "
                + "'" + getAlim_leche_master_descrip() + "', "
                + "'" + getEdad_fin_leche_mater() + "', "
                + "'" + isBiberon() + "', "
                + "'"+getBiberon_edad_ini() + "', "
                + "'" + getBiberon_edad_fin()+ "', "
                + "'" + isProblemas_succion() + "', "
                + "'" + getDestete_descripcion() + "', "
                + getEdad_sentar() + ", "
                + getEdad_caminar() + ", "
                + getEdad_primeras_palabras() + ")";

        boolean result = conectar.noQuery(sql);
        return result;
    }
    
     //1.7 ACTUALIZAR DATOS DE LOS PRIMEROS DÍAS VIDA
    public boolean actualizarDatosAlimentacionActual(int cod_PostParto) {
        String sql = "Select actualizarDatosAlimentacionActual(" + ""
                + cod_PostParto + ", "
                + getEdad_aliment_solido() + ", "
                + "'" + getDificultades_alimentacion() + "', "
                + getVeces_como_diario()+ ", "
                + "'"+getComer_solo_acompanado()+ "', "
                + "'"+getActitud_madre_no_come() + "')";

        boolean result = conectar.noQuery(sql);
        return result;
    }
}
