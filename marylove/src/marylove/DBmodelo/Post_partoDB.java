/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.controlador.FiltroHijosVictima;
import marylove.models.Post_parto;

/**
 *
 * @author Asus
 */
public class Post_partoDB extends Post_parto {

    ConexionHi conectar = new ConexionHi(); //= new ConexionHi();
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

    public Post_partoDB(int Post_parto_id, String Sensacion_post_parto, boolean Sexo_esperado, String reaccion_padre, String reaccion_madre, boolean alim_leche_mater, String alim_leche_master_descrip, boolean problemas_succion, String destete_descripcion, String edad_sentar, String edad_caminar, String edad_primeras_palabras, String edad_aliment_solido, String dificultades_alimentacion, int veces_como_diario, String actitud_madre_no_come, String comer_solo_acompanado, boolean post_parto_estado, String edad_fin_leche_mater, boolean biberon, String biberon_edad_ini, String biberon_edad_fin) {
        super(Post_parto_id, Sensacion_post_parto, Sexo_esperado, reaccion_padre, reaccion_madre, alim_leche_mater, alim_leche_master_descrip, problemas_succion, destete_descripcion, edad_sentar, edad_caminar, edad_primeras_palabras, edad_aliment_solido, dificultades_alimentacion, veces_como_diario, actitud_madre_no_come, comer_solo_acompanado, post_parto_estado, edad_fin_leche_mater, biberon, biberon_edad_ini, biberon_edad_fin);
    }

    public Post_partoDB(int Post_parto_id, String Sensacion_post_parto, boolean Sexo_esperado, String reaccion_padre, String reaccion_madre, boolean alim_leche_mater, String alim_leche_master_descrip, boolean problemas_succion, String destete_descripcion, String edad_sentar, String edad_caminar, String edad_primeras_palabras, String edad_aliment_solido, String dificultades_alimentacion, int veces_como_diario, String actitud_madre_no_come, String comer_solo_acompanado, String edad_fin_leche_mater, boolean biberon, String biberon_edad_ini, String biberon_edad_fin) {
        super(Post_parto_id, Sensacion_post_parto, Sexo_esperado, reaccion_padre, reaccion_madre, alim_leche_mater, alim_leche_master_descrip, problemas_succion, destete_descripcion, edad_sentar, edad_caminar, edad_primeras_palabras, edad_aliment_solido, dificultades_alimentacion, veces_como_diario, actitud_madre_no_come, comer_solo_acompanado, edad_fin_leche_mater, biberon, biberon_edad_ini, biberon_edad_fin);
    }

    public Post_partoDB(String Sensacion_post_parto, boolean Sexo_esperado, String reaccion_padre, String reaccion_madre, boolean alim_leche_mater, String alim_leche_master_descrip, boolean problemas_succion, String destete_descripcion, String edad_sentar, String edad_caminar, String edad_primeras_palabras, String edad_aliment_solido, String dificultades_alimentacion, int veces_como_diario, String actitud_madre_no_come, String comer_solo_acompanado, String edad_fin_leche_mater, boolean biberon, String biberon_edad_ini, String biberon_edad_fin) {
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
    public boolean actualizarDatosPrimerosDiasVida(String lecheMaterna, String usoBiberon, String dificultadSuccion) throws SQLException {
        boolean result = false;
        String sql = "Select actualizarDatosPrimerosDiasVida(" + ""
                + AnamnesisDB.post_parto_id + ", "
                + "" + lecheMaterna + ", "
                + "'" + getAlim_leche_master_descrip() + "', "
                + "'" + getEdad_fin_leche_mater() + "', "
                + "" + usoBiberon + ", "
                + "'" + getBiberon_edad_ini() + "', "
                + "'" + getBiberon_edad_fin() + "', "
                + "" + dificultadSuccion + ", "
                + "'" + getDestete_descripcion() + "', "
                + "'" + getEdad_sentar() + "', "
                + "'" + getEdad_caminar() + "', "
                + "'" + getEdad_primeras_palabras() + "')";
        System.out.println(sql);
        
        rs = conectar.query(sql);
        if (rs != null) {
            while (rs.next()) {
                result = rs.getBoolean(1);
                System.out.println(result);
            }

        }else {
            result = false;
        }

        return result;
    }

    //1.7 ACTUALIZAR DATOS DE LOS PRIMEROS DÍAS VIDA
    public boolean actualizarDatosAlimentacionActual(int cod_PostParto) {
        String sql = "Select actualizarDatosAlimentacionActual(" + ""
                + cod_PostParto + ", "
                + "'" + getEdad_aliment_solido() + "', "
                + "'" + getDificultades_alimentacion() + "', "
                + getVeces_como_diario() + ", "
                + "'" + getComer_solo_acompanado() + "', "
                + "'" + getActitud_madre_no_come() + "')";

        boolean result = false;
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                System.out.println(rs.getBoolean(1));
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void FichaAnamnesisLlenadoCampos(Post_parto postp) {
        String sql = "SELECT n.mes_alumbramiento, n.lugar_nacimiento, n.parto_tipo, n.motivo_cesarea,  n.anestesia,  n.observaciones_parto, n.nacimiento_estado, dn.complicaciones_parto, dn.lloro_nac, dn.necesito_oxigeno, dn.peso, dn.talla,dn.sintomas_after_part,  pp.sexo_esperado,  pp.reaccion_padre, pp.reaccion_madre, pp.alim_leche_mater,pp.alim_leche_mater_descrip, \n"
                + "	pp.edad_fin_leche_mater, pp.biberon,   pp.biberon_edad_ini,pp.biberon_edad_fin,pp.problemas_succion, pp.destete_descripcion, pp.edad_sentar,pp.edad_caminar, pp.edad_primeras_palabras, pp.edad_aliment_solido,pp.dificultades_alimentacion,pp.veces_como_diario,pp.comer_solo_acompanado,  pp.actitud_madre_no_come\n"
                + "	FROM anamnesis an join post_parto pp using(post_parto_id) join nacimiento n    using (nacimiento_codigo) join detalle_nacimiento dn using (nacimiento_codigo) where an.hijo_codigo=" + AnamnesisDB.hijoCodigo + ";";
        System.out.println(sql);
        try {
            rs = conectar.query(sql);
            while (rs.next()) {
                System.out.println("hollllll");
                postp.setMes_alumbramiento(rs.getInt(1));
                postp.setLugar_nacimiento(rs.getString(2));
                postp.setParto_tipo(rs.getString(3));
                postp.setMotivo_cesarea(rs.getString(4));
                postp.setAnestesia(rs.getBoolean(5));
                postp.setObservaciozes_parto(rs.getString(6));
                postp.setNacimiento_estado(rs.getBoolean(7));
                postp.setComplicaciones_parto(rs.getString(8));
                postp.setLloro_nac(rs.getBoolean(9));
                postp.setNecesito_oxigeno(rs.getBoolean(10));
                postp.setPeso(rs.getString(11));
                postp.setTalla(rs.getString(12));
                postp.setSintomas_after_part(rs.getString(13));
                postp.setSexo_esperado(rs.getBoolean(14));
                postp.setReaccion_padre(rs.getString(15));
                postp.setReaccion_madre(rs.getString(16));
                postp.setAlim_leche_mater(rs.getBoolean(17));
                postp.setAlim_leche_master_descrip(rs.getString(18));
                postp.setEdad_fin_leche_mater(rs.getString(19));
                postp.setBiberon(rs.getBoolean(20));
                postp.setBiberon_edad_ini(rs.getString(21));
                postp.setBiberon_edad_fin(rs.getString(22));
                postp.setProblemas_succion(rs.getBoolean(23));
                postp.setDestete_descripcion(rs.getString(24));
                postp.setEdad_sentar(rs.getString(25));
                postp.setEdad_caminar(rs.getString(26));
                postp.setEdad_primeras_palabras(rs.getString(27));
                postp.setEdad_aliment_solido(rs.getString(28));
                postp.setDificultades_alimentacion(rs.getString(29));
                postp.setVeces_como_diario(rs.getInt(30));
                postp.setComer_solo_acompanado(rs.getString(31));
                postp.setActitud_madre_no_come(rs.getString(32));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Post_partoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
