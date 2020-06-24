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
import marylove.models.Anamnesis;
import marylove.vista.FichaAnamnesis;

/**
 *
 * @author Usuario
 */
public class AnamnesisDB extends Anamnesis {

    //variables conexion
    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;

    static int nacimiento_codigo, deta_codigo , sucoes_id , post_parto_id , salud_nna_id , desarrollo_id , rela_famili_nna_id , embarazo_id , escolaridad_id , anamnesis_id ;
    //Registrar un padre vacio a la tabla 
    static int codigoPadre ;
    //VARIABLES TEMPORALES FALTANTES
    int hijoCodigo, personal_codigo ,
            personaCodigoHijo ,
            persona_codigoPadre ;

    public static boolean existenciafichaAnam;
    //an.edad_madre, an.nacionalidad_madre, an.apellido_madre,an.nombre_madre,an.edad_madre, an.anamnesis_estado,

    //variables locales
    public AnamnesisDB() {
    }

    public AnamnesisDB(int anamnesis_id, String observaciones_generales) {
        super(anamnesis_id, observaciones_generales);
    }

    public AnamnesisDB(int hijo_codigo, int embarazo_id, int nacimiento_codigo,
            int post_parto_id, int desarrollo_id, int escoralidad_id, int salud_nna_id,
            int relación_familiar_nna_id, int sucoes_id, String observaciones_generales,
            int personal_codigo) {

        super(hijo_codigo, embarazo_id, nacimiento_codigo, post_parto_id, desarrollo_id, escoralidad_id, salud_nna_id, relación_familiar_nna_id, sucoes_id, observaciones_generales, personal_codigo);
    }

    public boolean llenarAnamnesis() throws SQLException {
        String sql = "INSERT INTO public.anamnesis("
                + " hijo_codigo, embarazo_id, nacimiento_codigo,"
                + " post_parto_id, desarrollo_id, escolaridad_id, salud_nna_id, "
                + "rela_famili_nna_id, observaciones_generales, personal_codigo, sucoes_id)"
                + " VALUES (" + getHijo_codigo() + ", " + getEmbarazo_id() + ", " + getNacimiento_codigo() + ", "
                + " " + getPost_parto_id() + ", " + getDesarrollo_id() + ", " + getEscoralidad_id() + ","
                + " " + getSalud_nna_id() + ", " + getRelación_familiar_nna_id() + ","
                + " " + getSucoes_id() + ", '" + getObservaciones_generales() + "'," + getPersonal_codigo() + ");";

        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }

    public int codigoPadre() throws SQLException {

        String sql = "Select MAX(persona_codigo)+1 from persona";
        System.out.println(sql);
        rs = conectar.query(sql);
        int nuevocodigopersona = 0;
        while (rs.next()) {
            nuevocodigopersona = rs.getInt(1);
        }
        System.out.println(nuevocodigopersona + "hola");
        String sql2 = "INSERT INTO public.persona(persona_codigo) VALUES (" + nuevocodigopersona + ") ";
        boolean resultado = conectar.noQuery(sql2);
        System.out.println(sql2);
        String sql3 = "INSERT INTO public.padre(persona_codigo)VALUES(" + nuevocodigopersona + ") RETURNING padre_id, persona_codigo ";
        rs = conectar.query(sql3);
        System.out.println(sql3);

        while (rs.next()) {
            codigoPadre = rs.getInt(1);
            persona_codigoPadre = rs.getInt(2);
        }
        return codigoPadre;
    }

    //modifica e inserta el codigo del padre en la tabla hijos
    public boolean updateHijoCodigoP(int codigohijo) {
        String sql = "UPDATE public.hijos SET padre_id=" + codigoPadre + " WHERE hijo_codigo=" + codigohijo;
        boolean result = conectar.noQuery(sql);
        System.out.println(sql);
        return result;
    }

    public void nacimiento() throws SQLException {
        String sql = " INSERT INTO public.nacimiento(nacimiento_estado) VALUES (true) RETURNING nacimiento_codigo";
        System.out.println(sql);
        rs = conectar.query(sql);
        while (rs.next()) {
            nacimiento_codigo = rs.getInt(1);
        }
    }

    public void detallenacimiento() throws SQLException {
        String sql = " INSERT INTO public.detalle_nacimiento( nacimiento_codigo, detalle_nac_estado)VALUES (" + nacimiento_codigo + ", false) RETURNING deta_codigo;";
        System.out.println(sql);
        rs = conectar.query(sql);
        while (rs.next()) {
            deta_codigo = rs.getInt(1);
        }
    }

    public void suenocontro() throws SQLException {
        String sql = " INSERT INTO public.sueno_control_esfin(sueno_cont_estado) VALUES (false) RETURNING sucoes_id;";
        System.out.println(sql);
        rs = conectar.query(sql);
        while (rs.next()) {
            sucoes_id = rs.getInt(1);
        }
    }

    public void saludnna() throws SQLException {
        String sql = "INSERT INTO public.salud_nna(salud_nna_estado) VALUES (false) RETURNING salud_nna_id ";
        System.out.println(sql);
        rs = conectar.query(sql);
        while (rs.next()) {
            salud_nna_id = rs.getInt(1);
        }
    }

    public void postParto() throws SQLException {
        String sql = "INSERT INTO public.post_parto(post_parto_estado) VALUES(false) RETURNING post_parto_id";
        System.out.println(sql);
        rs = conectar.query(sql);
        while (rs.next()) {
            post_parto_id = rs.getInt(1);
        }
    }

    public void desarrollo() throws SQLException {
        String sql = "INSERT INTO public.desarrollo(desarrollo_estado) VALUES (false) RETURNING desarrollo_id";
        System.out.println(sql);
        rs = conectar.query(sql);
        while (rs.next()) {
            desarrollo_id = rs.getInt(1);
        }
    }

    public void relacionFamiliar() throws SQLException {
        String sql = "INSERT INTO public.relacion_familiar_nna(rela_famili_estado) VALUES(false) RETURNING rela_famili_nna_id";
        System.out.println(sql);
        rs = conectar.query(sql);
        while (rs.next()) {
            rela_famili_nna_id = rs.getInt(1);
        }
    }

    public void embarazoEstado() throws SQLException {
        String sql = "INSERT INTO public.embarazo_estado(embarazo_estado) VALUES(false) RETURNING embarazo_id";
        System.out.println(sql);
        rs = conectar.query(sql);
        while (rs.next()) {
            embarazo_id = rs.getInt(1);
        }
    }

    public void escolaridad() throws SQLException {
        String sql = " INSERT INTO public.escolaridad(esc_estado) VALUES (false) RETURNING escolaridad_id";
        System.out.println(sql);
        rs = conectar.query(sql);
        while (rs.next()) {
            escolaridad_id = rs.getInt(1);
        }
    }

    public boolean anamnesis() throws SQLException {
        String sql = " INSERT INTO public.anamnesis(anamnesis_estado,hijo_codigo,embarazo_id, nacimiento_codigo, post_parto_id, desarrollo_id, escolaridad_id, salud_nna_id, rela_famili_nna_id, personal_codigo, sucoes_id) VALUES "
                + "(false "
                + ", " + FiltroHijosVictima.getCodigo()
                + ", " + embarazo_id
                + ", " + nacimiento_codigo
                + ", " + post_parto_id
                + ", " + desarrollo_id
                + ", " + escolaridad_id
                + ", " + salud_nna_id
                + ", " + rela_famili_nna_id
                //    + ", "+C_Login.personal_cod
                + ", 1"
                + ", " + sucoes_id
                + ") RETURNING anamnesis_id";
        rs = conectar.query(sql);
        System.out.println(sql);
        while (rs.next()) {
            anamnesis_id = rs.getInt(1);
        }
        System.out.println("jjjjj   " + anamnesis_id);
        return true;

    }

    public void conectarTodo(int codigohijo) {

        try {
            codigoPadre();
            updateHijoCodigoP(codigohijo);
            nacimiento();
            detallenacimiento();
            suenocontro();
            saludnna();
            postParto();
            desarrollo();
            relacionFamiliar();
            embarazoEstado();
            escolaridad();
            anamnesis();
        } catch (SQLException ex) {
            Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //.8 .9 .10 

    public void llenarcamposAnamnesis(Anamnesis an) {
        String sql = "SELECT d.desarrollo_id, d.des_motor_grueso, d.des_motor_fino,d.caridad_lenguajes, d.claridad_lenguajes_descrip, d.movimientos, d.des_psico_social, d.des_cognitivo, d.des_fisico,s.duerme_toda_noche,s.miedo_dormir_solo,s.pesadillas,\n"
                + "s.ayuda_bano,s.moja_cama, s.periodo_ecopresis, s.como_es_sueno, s.despertar_descripcion, s.acompanamiento_dormir,s.edad_control_esfinter, s.periodo_ecopresis_descrip \"causa\",  es.esc_estudia,es.esc_explicacion, es.esc_asis_prog_apoyo, es.esc_repeticion_anio_causas,es.esc_nna_problem_aprend, es.esc_nna_observaciones, es.esc_asis_prog_apoyo_obser, an.observaciones_generales, es.esc_ultimo_anio_cursado\n"
                + "	FROM anamnesis an join desarrollo d  using(desarrollo_id) join  escolaridad es  using(escolaridad_id) join  sueno_control_esfin s using(sucoes_id) where an.hijo_codigo=" + FichaAnamnesis.txtCodigo.getText() + "; ";
        System.out.println(sql);
        try {
            rs = conectar.query(sql);

            while (rs.next()) {
                an.setDes_motor_grueso(rs.getString(2));
                an.setDes_motor_fino(rs.getString(3));
                an.setCaridad_lenguajes(rs.getString(4));
                an.setClaridad_lenguajes_descrip(rs.getString(5));
                an.setMovimientos(rs.getString(6));
                an.setDes_psico_social(rs.getString(7));
                an.setDes_cognitivo(rs.getString(8));
                an.setDes_fisico(rs.getString(9));
                an.setDuerme_toda_noche(rs.getBoolean(10));
                an.setMiedo_dormir_solo(rs.getBoolean(11));
                an.setPesadillas(rs.getBoolean(12));
                an.setAyuda_baño(rs.getBoolean(13));
                an.setMoja_cama(rs.getBoolean(14));
                an.setPeriodo_ecopresis(rs.getBoolean(15));
                an.setComo_es_sueno(rs.getString(16));
                an.setDespertar_descripcion(rs.getString(17));
                an.setAcompanamiento_dormir(rs.getString(18));
                an.setEdad_control_esfinter(rs.getInt(19));
                an.setPeriodo_ecopresis_descrip(rs.getString(20));
                an.setEsc_estudia(rs.getBoolean(21));
                an.setEsc_explicacion(rs.getString(22));
                an.setEsc_asis_prog_apoyo(rs.getBoolean(23));
                an.setEsc_repeticion_anio_causas(rs.getString(24));
                an.setEsc_nna_problem_aprend(rs.getBoolean(25));
                an.setEsc_nna_observaciones(rs.getString(26));
                an.setEsc_asis_prog_apoyo_obser(rs.getString(27));
                an.setObservaciones_generales(rs.getString(28));
                an.setEsc_ultimo_anio_cursado(rs.getString(29));
            }
            System.out.println(an.getEsc_nna_observaciones());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    //METODOS DE ACTUALIZACIÓN POR PESTAÑAS--------------------------------------------------------------------------------------------------------------------
    //1.1 ACTUALIZAR DATOS DE IDENTIFICACIÓN
    public boolean actualizarDatosIdentificacion(NacimientoDB objNac, HijosDB objHijo) {
        String sql;
        
        if (objHijo.getPersona_fecha_nac() == null) {
            sql = "Select actualizarDatosIdentificacion(" + ""
                    + "null, "
                    + objHijo.getPersona_nacionalidad() + ", "
                    + personaCodigoHijo + ", "
                    + "'" + objNac.getLugar_nacimiento() + "',"
                    + nacimiento_codigo + ")";
        } else {
            sql = "Select actualizarDatosIdentificacion(" + ""
                    + "'" + objHijo.getPersona_fecha_nac() + "', "
                    + objHijo.getPersona_nacionalidad() + ", "
                    + personaCodigoHijo + ", "
                    + "'" + objNac.getLugar_nacimiento() + "',"
                    + nacimiento_codigo + ")";
        }
        
        System.out.println(sql);
        boolean result = false;
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                result = rs.getBoolean(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //1.2 ACTUALIZAR DATOS DEL PADRE Y LA MADRE
    public boolean actualizarDatosPadre(PadreDB objPadre, HijosDB objHijo) {

        String sql = "Select actualizarDatosPadre(" + ""
                + "'" + objPadre.getPersona_nombre() + "', "
                + "'" + objPadre.getPersona_apellido() + "', "
                + objPadre.getPersona_nacionalidad() + ", "
                + codigoPadre + ", "
                + "'" + objHijo.isPadre_agresor() + "',"
                + "'" + objHijo.getHijo_estado_ingreso() + "', "
                + FiltroHijosVictima.getCodigo() + ", "
                + objPadre.getEdad() + ", "
                + persona_codigoPadre + ")";
        System.out.println(sql);
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

    public boolean actualizarDatosPadreMadre(PadreDB objPadre, HijosDB objHijo) {
        String sql = "Select actualizarDatosPadreMadre(" + ""
                + "'" + objPadre.getPersona_nombre() + "', "
                + "'" + objPadre.getPersona_apellido() + "', "
                + objPadre.getPersona_nacionalidad() + ", "
                + codigoPadre + ", "
                + "'" + objHijo.isPadre_agresor() + "',"
                + "'" + objHijo.getHijo_estado_ingreso() + "', "
                + FiltroHijosVictima.getCodigo() + ", "
                + objPadre.getEdad() + ", "
                + persona_codigoPadre + ","
                + "'" + getNombre_madre() + "', "
                + "'" + getApellido_madre() + "', "
                + getEdad_madre() + ", "
                + getNacionalidad_madre() + ", "
                + anamnesis_id + ")";
        System.out.println(sql);
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

    //1.3 NO ES NECESARIO
    //1.4 LO HACE DANNY
    //1.5 ACTUALIZAR DATOS DE LAS CONDICIONES DE NACIMIENTO
    public boolean actualizarDatosCondicionesNacimiento(NacimientoDB objNac, Detalle_nacimientoDB objDetalleNac, Post_partoDB objPostParto) {

        String sql = "Select actualizarDatosCondicionesNacimiento(" + ""
                + objNac.getMes_alumbramiento() + ", "
                + "'" + objNac.getObservaciozes_parto() + "', "
                + "'" + objNac.isAnestesia() + "', "
                + "'" + objNac.getLugar_nacimiento() + "', "
                + "'" + objNac.getParto_tipo() + "', "
                + nacimiento_codigo + ", "
                + "'" + objDetalleNac.getPeso() + "', "
                + "'" + objDetalleNac.getTalla() + "', "
                + "'" + objDetalleNac.isLloro_nac() + "', "
                + "'" + objDetalleNac.isNecesito_oxigeno() + "', "
                + "'" + objDetalleNac.getSintomas_after_part() + "', "
                + deta_codigo + ", "
                + post_parto_id + ", "
                + "'" + objPostParto.isSexo_esperado() + "', "
                + "'" + objPostParto.getReaccion_madre() + "', "
                + "'" + objPostParto.getReaccion_padre() + "')";
        boolean result = false;
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                result = rs.getBoolean(1);
                System.out.println(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //1.6 ESTA EN LA CLASE POSTPARTODBB
    //1.7 ESTA EN LA CLASE POSTPARTODB
    //1.14 ACTUALIZAR OBSERVACIONES GENERALES
    public boolean update_observaciones_generales() {
        boolean res = false;
        String sql = "select anamnesis_obser_gener_updatea("
                + anamnesis_id + ", "
                + "'" + getObservaciones_generales() + "')";
        boolean result = false;
        rs = conectar.query(sql);
        try {
            while (rs.next()) {
                result = rs.getBoolean(1);
                System.out.println(result);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL EJECUTAR");
            Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void consultaAnamnesisExist(Anamnesis anam) {
        FichaAnamnesis d = new FichaAnamnesis() ;
        String sql = "SELECT an.anamnesis_id, an.hijo_codigo,h.persona_codigo,h.padre_id, an.embarazo_id, an.nacimiento_codigo, an.post_parto_id, an.desarrollo_id, an.escolaridad_id, an.salud_nna_id, an.rela_famili_nna_id, an.personal_codigo, an.sucoes_id,  padr.persona_codigo  \n"
                + "             	FROM anamnesis an join hijos h using (hijo_codigo) join padre padr   using(padre_id)  where  an.hijo_codigo=" + d.getTxtCodigo().getText() + "; ";

        System.out.println(sql);
//nacimiento_codigo = 6, deta_codigo = 5, sucoes_id = 7, post_parto_id = 5, salud_nna_id = 5, desarrollo_id = 6, rela_famili_nna_id = 5, embarazo_id = 5, escolaridad_id = 2, anamnesis_id = 
        try {
            rs = conectar.query(sql);
            System.out.println(rs.getRow());
            if (rs.next()) {
                anamnesis_id = (rs.getInt(1));
                hijoCodigo = (rs.getInt(2));
                personaCodigoHijo = (rs.getInt(3));
                codigoPadre = (rs.getInt(4));
                embarazo_id = (rs.getInt(5));
                nacimiento_codigo = (rs.getInt(6));
                post_parto_id = (rs.getInt(7));
                desarrollo_id = (rs.getInt(8));
                escolaridad_id = (rs.getInt(9));
                salud_nna_id = (rs.getInt(10));
                rela_famili_nna_id = (rs.getInt(11));
                personal_codigo = (rs.getInt(12));
                sucoes_id = (rs.getInt(13));
                persona_codigoPadre = (rs.getInt(14));
                System.out.println("si");
                existenciafichaAnam = true;
            } else {
                existenciafichaAnam = false;
                System.out.println("no");
                conectarTodo(Integer.parseInt(FichaAnamnesis.txtCodigo.getText()));
            }
            System.out.println(anamnesis_id);
            System.out.println(hijoCodigo);

            System.out.println(codigoPadre);
            System.out.println(embarazo_id);
            System.out.println(nacimiento_codigo);
            System.out.println(post_parto_id);
            System.out.println("siiii :) ");

        } catch (SQLException ex) {
            Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //METODO QUE EJECUTA LA FUNCIÓN FINAL DE ACTUALIZACIÓN DE LA FICHA ANAMNESIS, LA CUAL ACTUALIZA TODOS LOS ESTADOS DE LAS TABLAS LLENADAS EN LA FICHA 
    public boolean actualizacionFichaAnamnesis(){
        boolean result = false;
        //LLAMAMOS A LA FUNCIÓN
        String sql = "SELECT actualizarTablas_FichaAnamnesis( "
                + anamnesis_id+", "
                + post_parto_id+", "
                + salud_nna_id+", "
                + rela_famili_nna_id+", "
                + sucoes_id+", "
                + desarrollo_id+", "
                + escolaridad_id+", "
                + nacimiento_codigo+", "
                + deta_codigo+", "
                + FiltroHijosVictima.getCodigo()+", "
                + embarazo_id+") ;";
        rs = conectar.query(sql);
         try {
            while (rs.next()) {
                result = rs.getBoolean(1);
                System.out.println(result);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL EJECUTAR");
            Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         return result;
    }
}
