/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.controlador.FiltroHijosVictima;
import marylove.models.Anamnesis;
import marylove.models.Desarrollo;
import marylove.models.Detalle_nacimiento;
import marylove.models.Embarazo_estado;
import marylove.models.Escolaridad;
import marylove.models.Hijos;
import marylove.models.Nacimiento;
import marylove.models.Padre;
import marylove.models.Persona;
import marylove.models.Post_parto;
import marylove.models.Relacion_familiar_nna;
import marylove.models.Salud_nna;
import marylove.models.Sueno_control_esfin;
import marylove.models.x_embarazo_comp1;
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

    //CODIGO ESTATICOS PARA CONTROL ANAMNESIS
    static int hijoCodigo, anamnesis_id;
    static int nacimiento_codigo, detaNac_codigo, sucoes_id, post_parto_id, salud_nna_id, desarrollo_id, rela_famili_nna_id, embarazo_id, escolaridad_id;
    //Registrar un padre vacio a la tabla 
    static int codigoPadre;
    //VARIABLES TEMPORALES FALTANTES
    private static int personal_codigo, personaCodigoHijo,
            persona_codigoPadre;

    public static boolean existenciafichaAnam;

    //an.edad_madre, an.nacionalidad_madre, an.apellido_madre,an.nombre_madre,an.edad_madre, an.anamnesis_estado,
    //metodos get y set
    //----------------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------
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
            detaNac_codigo = rs.getInt(1);
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
    public boolean actualizarDatosPadre(PadreDB objPadre, HijosDB objHijo, String padreAgresor) {

        String sql = "Select actualizarDatosPadre(" + ""
                + "'" + objPadre.getPersona_nombre() + "', "
                + "'" + objPadre.getPersona_apellido() + "', "
                + objPadre.getPersona_nacionalidad() + ", "
                + codigoPadre + ", "
                + "" + padreAgresor + ","
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

    public boolean actualizarDatosPadreMadre(PadreDB objPadre, HijosDB objHijo, String padreAgresor) {
        String sql = "Select actualizarDatosPadreMadre(" + ""
                + "'" + objPadre.getPersona_nombre() + "', "
                + "'" + objPadre.getPersona_apellido() + "', "
                + objPadre.getPersona_nacionalidad() + ", "
                + codigoPadre + ", "
                + "" + padreAgresor + ","
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
    public boolean actualizarDatosCondicionesNacimiento(NacimientoDB objNac, Detalle_nacimientoDB objDetalleNac, Post_partoDB objPostParto, String anestesia, String lloroNac, String necesito_O, String sexoEsperado) {
        System.out.println("codigo" + detaNac_codigo);
        String sql = "Select actualizarDatosCondicionesNacimiento(" + ""
                + objNac.getMes_alumbramiento() + ", "
                + "" + anestesia + ", "
                + "'" + objNac.getLugar_nacimiento() + "', "
                + "'" + objNac.getParto_tipo() + "', "
                + nacimiento_codigo + ", "
                + "'" + objDetalleNac.getPeso() + "', "
                + "'" + objDetalleNac.getTalla() + "', "
                + "" + lloroNac + ", "
                + "" + necesito_O + ", "
                + "'" + objDetalleNac.getSintomas_after_part() + "', "
                + detaNac_codigo + ", "
                + post_parto_id + ", "
                + "" + sexoEsperado + ", "
                + "'" + objPostParto.getReaccion_madre() + "', "
                + "'" + objPostParto.getReaccion_padre() + "',"
                + "'" + objDetalleNac.getComplicaciones_parto() + "',"
                + "'" + objNac.getMotivo_cesarea() + "')";
        boolean result = false;
        System.out.println(sql);
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

    public boolean consultaAnamnesisExist(int hijCod) {

        String sql = "SELECT an.anamnesis_id, an.hijo_codigo,h.persona_codigo,h.padre_id, an.embarazo_id, an.nacimiento_codigo, an.post_parto_id, an.desarrollo_id, an.escolaridad_id, an.salud_nna_id, an.rela_famili_nna_id, an.personal_codigo, an.sucoes_id,  padr.persona_codigo, detNac.deta_codigo"
                + " FROM anamnesis an "
                + " join hijos h using (hijo_codigo)"
                + " join padre padr   using(padre_id)"
                + " join detalle_nacimiento detNac using (nacimiento_codigo)"
                + " where  an.hijo_codigo=" + hijCod + "; ";

        System.out.println(sql);
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
                detaNac_codigo = (rs.getInt(15));
                System.out.println("si");
                existenciafichaAnam = true;
                return true;
            } else {
                existenciafichaAnam = false;
                System.out.println("no");
                conectarTodo(hijCod);
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //METODO QUE EJECUTA LA FUNCIÓN FINAL DE ACTUALIZACIÓN DE LA FICHA ANAMNESIS, LA CUAL ACTUALIZA TODOS LOS ESTADOS DE LAS TABLAS LLENADAS EN LA FICHA 
    public boolean actualizacionFichaAnamnesis() {
        boolean result = false;
        //LLAMAMOS A LA FUNCIÓN
        String sql = "SELECT actualizarTablas_FichaAnamnesis( "
                + anamnesis_id + ", "
                + post_parto_id + ", "
                + salud_nna_id + ", "
                + rela_famili_nna_id + ", "
                + sucoes_id + ", "
                + desarrollo_id + ", "
                + escolaridad_id + ", "
                + nacimiento_codigo + ", "
                + detaNac_codigo + ", "
                + FiltroHijosVictima.getCodigo() + ", "
                + embarazo_id + ") ;";
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

    public boolean actualizarFechaMod() {
        String sql = " UPDATE anamnesis "
                + "SET fecha_modificacion = current_timestamp WHERE anamnesis_id=" + anamnesis_id;
        System.out.println(sql);
        if (conectar.noQuery(sql)) {
            return true;
        } else {
            return false;
        }
    }

    public String consultarUltimaFechaMod() {
        String sql = "Select fecha_modificacion from anamnesis where anamnesis_id = " + anamnesis_id;

        rs = conectar.query(sql);
        System.out.println(sql);
        String fecha = null;
        try {
            while (rs.next()) {
                fecha = rs.getTimestamp(1) + "";
                System.out.println(fecha);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL EJECUTAR");
            Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha;
    }

    public boolean actualizarEncabezado() {
        boolean result;
        String sql = "Update anamnesis set fecha_creacion = '" + getFechaElaboracion() + "' where anamnesis_id = " + anamnesis_id;
        result = conectar.noQuery(sql);
        System.out.println(result);
        return result;
    }

    //---------------------------------------------------------ANAMNESIS  METODOS PARA CARGAR LOS DATOS----------------------------------------------------------------
    //------------------------------------------------------------------------------ eyelash 1
    public ArrayList<Object> getInfoDataFromAnamnesisBase() {
        ArrayList<Object> datos = new ArrayList<>();
        Persona p = new Persona();
        Anamnesis a = new Anamnesis();
        Nacimiento n = new Nacimiento();
        String sql = "SELECT "
                + "per.persona_cedula, "
                + "per.persona_nombre, "
                + "per.persona_apellido, "
                + "per.persona_fecha_nac, "
                + "per.persona_nacionalidad, "
                + "anam.fecha_creacion, "
                + "nac.lugar_nacimiento "
                + "FROM anamnesis anam "
                + "JOIN hijos hij ON hij.hijo_codigo = anam.hijo_codigo "
                + "JOIN persona per ON hij.persona_codigo = per.persona_codigo "
                + "JOIN nacimiento nac ON nac.nacimiento_codigo = anam.nacimiento_codigo "
                + "WHERE anam.anamnesis_id = " + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    p.setPersona_cedula(rs.getString(1));
                    p.setPersona_nombre(rs.getString(2));
                    p.setPersona_apellido(rs.getString(3));
                    p.setPersona_fecha_nac(rs.getDate(4));
                    p.setPersona_nacionalidad(rs.getInt(5));
                    a.setFechaElaboracion(rs.getDate(6));
                    n.setLugar_nacimiento(rs.getString(7));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            datos.add(p);
            datos.add(a);
            datos.add(n);
        } else {
            System.out.println("metodo: getPersonFromAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return datos;
    }
//------------------------------------------------------------------------------ eyelash 2

    public ArrayList<Object> getInfoDataFatherMotherFromAnamnesisBase() {
        ArrayList<Object> datos = new ArrayList<>();

        Anamnesis a = new Anamnesis();
        Persona p = new Persona();
        Padre pa = new Padre();
        Hijos h = new Hijos();

        String sql = "SELECT "
                + "anam.nombre_madre, "
                + "anam.apellido_madre, "
                + "anam.edad_madre, "
                + "anam.nacionalidad_madre, "
                + "per.persona_nombre, "
                + "per.persona_apellido, "
                + "per.persona_nacionalidad, "
                + "pa.edad, "
                + "hij.padre_agresor, "
                + "hij.hijo_estado_ingreso "
                + "FROM anamnesis anam "
                + "JOIN hijos hij ON hij.hijo_codigo = anam.hijo_codigo "
                + "JOIN padre pa ON pa.padre_id = hij.padre_id "
                + "JOIN persona per ON per.persona_codigo = pa.persona_codigo "
                + "WHERE anam.anamnesis_id = " + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    a.setNombre_madre(rs.getString(1));
                    a.setApellido_madre(rs.getString(2));
                    a.setEdad_madre(rs.getInt(3));
                    a.setNacionalidad_madre(rs.getInt(4));
                    p.setPersona_nombre(rs.getString(5));
                    p.setPersona_apellido(rs.getString(6));
                    p.setPersona_nacionalidad(rs.getInt(7));
                    pa.setEdad(rs.getInt(8));
                    h.setPadre_agresor(rs.getBoolean(9));
                    h.setHijo_estado_ingreso(rs.getString(10));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            datos.add(a);
            datos.add(p);
            datos.add(pa);
            datos.add(h);
        } else {
            System.out.println("metodo: getInfoDataFatherMotherFromAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return datos;
    }

    //-------------------------------------------------------------------------- eyelash 4
    public ArrayList<Object> getInfoDataPregnancyPeriodFromAnamnesisBase() {
        ArrayList<Object> datos = new ArrayList<>();
        Embarazo_estado ee = new Embarazo_estado();
        x_embarazo_comp1 xec1 = new x_embarazo_comp1();

        String sql = "SELECT "
                + "ee.embarazo_id, "
                + "ee.victima_codigo, "
                + "ee.embarazo_planificado, "
                + "ee.embarazo_reaccion_padre, "
                + "ee.embarazo_reaccion_madre, "
                + "ee.donde_realizo_controles, "
                + "ee.consumo_causas, "
                + "ee.aborto_causas, "
                + "ee.embarazo_estado, "
                + "xec.x_emb_comp_id, "
                + "xec.embarazo_id, "
                + "xec.estado, "
                + "xec.json_complicaciones"
                + "FROM public.embarazo_estado ee "
                + "JOIN public.x_embarazo_comp xec ON ee.embarazo_id=xec.embarazo_id"
                + "JOIN public.anamnesis ana ON ana.embarazo_id=ee.embarazo_id "
                + "WHERE ana.anamnesis_id =" + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    ee.setEmbarazo_id(rs.getInt(1));
                    ee.setVictima_codigo(rs.getInt(2));
                    ee.setEmbarazo_planificado(rs.getBoolean(3));
                    ee.setEmbarazo_reaccion_padre(rs.getString(4));
                    ee.setEmbarazo_reaccion_madre(rs.getString(5));
                    ee.setDonde_realizo_controles(rs.getString(6));
                    ee.setConsumo_causas(rs.getString(7));
                    ee.setAborto_causas(rs.getString(8));
                    ee.setEmbarazo_estado(rs.getBoolean(9));
                    xec1.setX_emb_comp_id(rs.getInt(10));
                    xec1.setEmbarazo_id(rs.getInt(11));
                    xec1.setEstado(rs.getBoolean(12));
                    xec1.setJson_complicaciones(rs.getString(13));

                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            datos.add(ee);
            datos.add(xec1);
        } else {
            System.out.println("metodo: getInfoDataPregnancyPeriodFromAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return datos;
    }

    //--------------------------------------------------------------------------
    //-------------------------------------------------------------------------- eyelash 5
    public ArrayList<Object> getInfoDataConditionsOfBirthFomAnamnesisBase() {
        ArrayList<Object> datos = new ArrayList<>();
        Nacimiento n = new Nacimiento();
        Detalle_nacimiento dn = new Detalle_nacimiento();
        Post_parto pp = new Post_parto();

        String sql = "SELECT "
                + "nac.mes_alumbramiento, "
                + "nac.anestesia, "
                + "nac.lugar_nacimiento, "
                + "nac.parto_tipo, "
                + "nac.motivo_cesarea, "
                + "detNac.complicaciones_parto, "
                + "detNac.peso, "
                + "detNac.talla, "
                + "detNac.lloro_nac, "
                + "detNac.necesito_oxigeno, "
                + "detNac.sintomas_after_part, "
                + "pp.sexo_esperado, "
                + "pp.reaccion_padre, "
                + "pp.reaccion_madre "
                + "FROM anamnesis anam "
                + "JOIN nacimiento nac ON nac.nacimiento_codigo = anam.nacimiento_codigo "
                + "JOIN detalle_nacimiento detNac ON detNac.nacimiento_codigo = nac.nacimiento_codigo "
                + "JOIN post_parto pp ON pp.post_parto_id = anam.post_parto_idWHERE anam.anamnesis_id = " + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    n.setMes_alumbramiento(rs.getInt(1));
                    n.setAnestesia(rs.getBoolean(2));
                    n.setLugar_nacimiento(rs.getString(3));
                    n.setParto_tipo(rs.getString(4));
                    n.setMotivo_cesarea(rs.getString(5));
                    dn.setComplicaciones_parto(rs.getString(6));
                    dn.setPeso(rs.getString(7));
                    dn.setTalla(rs.getString(8));
                    dn.setLloro_nac(rs.getBoolean(9));
                    dn.setNecesito_oxigeno(rs.getBoolean(10));
                    dn.setSintomas_after_part(rs.getString(11));
                    pp.setSexo_esperado(rs.getBoolean(12));
                    pp.setReaccion_padre(rs.getString(13));
                    pp.setReaccion_madre(rs.getString(14));

                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            datos.add(n);
            datos.add(dn);
            datos.add(pp);
        } else {
            System.out.println("metodo: getInfoDataConditionsOfBirthFomAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return datos;
    }

    //-------------------------------------------------------------------------- eyelash 6
    public Post_parto getInfoDataFirstDayOfLifeFomAnamnesisBase() {
        Post_parto pp = new Post_parto();

        String sql = "SELECT "
                + "pp.alim_leche_mater_descrip, "
                + "pp.destete_descripcion, "
                + "pp.edad_sentar, "
                + "pp.edad_caminar, "
                + "pp.edad_primeras_palabras, "
                + "pp.edad_fin_leche_mater, "
                + "pp.biberon, "
                + "pp.biberon_edad_ini, "
                + "pp.biberon_edad_fin, "
                + "pp.alim_leche_mater, "
                + "pp.problemas_succion "
                + "FROM anamnesis anam "
                + "JOIN post_parto pp ON pp.post_parto_id = anam.post_parto_id "
                + "WHERE anam.anamnesis_id = " + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    pp.setAlim_leche_master_descrip(rs.getString(1));
                    pp.setDestete_descripcion(rs.getString(2));
                    pp.setEdad_sentar(rs.getString(3));
                    pp.setEdad_caminar(rs.getString(4));
                    pp.setEdad_primeras_palabras(rs.getString(5));
                    pp.setEdad_fin_leche_mater(rs.getString(6));
                    pp.setBiberon(rs.getBoolean(7));
                    pp.setBiberon_edad_ini(rs.getString(8));
                    pp.setBiberon_edad_fin(rs.getString(9));
                    pp.setAlim_leche_mater(rs.getBoolean(10));
                    pp.setProblemas_succion(rs.getBoolean(11));

                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            System.out.println("metodo: getInfoDataFirstDayOfLifeFomAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return pp;
    }

    //-------------------------------------------------------------------------- eyelash 7
    public Post_parto getInfoDataCurrentFeedFromAnamnesisBase() {
        Post_parto pp = new Post_parto();
        String sql = "SELECT "
                + "pp.edad_aliment_solido, "
                + "pp.dificultades_alimentacion, "
                + "pp.veces_como_diario, "
                + "pp.comer_solo_acompanado, "
                + "pp.actitud_madre_no_come "
                + "FROM anamnesis anam "
                + "JOIN post_parto pp ON pp.post_parto_id = anam.post_parto_id "
                + "WHERE anam.anamnesis_id = " + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    pp.setEdad_aliment_solido(rs.getString(1));
                    pp.setDificultades_alimentacion(rs.getString(2));
                    pp.setVeces_como_diario(rs.getInt(3));
                    pp.setComer_solo_acompanado(rs.getString(4));
                    pp.setActitud_madre_no_come(rs.getString(5));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("metodo: getInfoDataCurrentFeedFromAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return pp;
    }
    //---------------------------------------------------------------------------- eyelash 8

    public Desarrollo getInfoDataMotorDevelopmentFromAnamnesisBase() {
        Desarrollo d = new Desarrollo();
        String sql = "SELECT "
                + "d.des_motor_grueso, "
                + "d.des_motor_fino, "
                + "d.movimientos, "
                + "d.des_psico_social, "
                + "d.des_cognitivo, "
                + "d.des_fisico, "
                + "d.caridad_lenguajes, "
                + "d.claridad_lenguajes_descrip "
                + "FROM anamnesis anam "
                + "JOIN desarrollo d ON d.desarrollo_id = anam.desarrollo_id "
                + "WHERE anam.anamnesis_id = " + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    d.setDes_motor_grueso(rs.getString(1));
                    d.setDes_motor_fino(rs.getString(2));
                    d.setMovimientos(rs.getString(3));
                    d.setDes_psico_social(rs.getString(4));
                    d.setDes_cognitivo(rs.getString(5));
                    d.setDes_fisico(rs.getString(6));
                    d.setCaridad_lenguajes(rs.getString(7));
                    d.setClaridad_lenguajes_descrip(rs.getString(8));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("metodo: getInfoDataMotorDevelopmentFromAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return d;
    }

    //---------------------------------------------------------------------------- eyelash 9 
    public Sueno_control_esfin getInfoDataSleepControlSphincterFromAnamnesisBase() {
        Sueno_control_esfin sce = new Sueno_control_esfin();

        String sql = "SELECT "
                + "sce.duerme_toda_noche, "
                + "sce.miedo_dormir_solo, "
                + "sce.despertar_descripcion, "
                + "sce.pesadillas, "
                + "sce.edad_control_esfinter, "
                + "sce.ayuda_bano, "
                + "sce.moja_cama, "
                + "sce.periodo_ecopresis_descrip, "
                + "sce.periodo_ecopresis, "
                + "sce.como_es_sueno, "
                + "sce.acompanamiento_dormir "
                + "FROM anamnesis anam "
                + "JOIN sueno_control_esfin sce ON sce.sucoes_id = anam.sucoes_id "
                + "WHERE anam.anamnesis_id = " + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    sce.setDuerme_toda_noche(rs.getBoolean(1));
                    sce.setMiedo_dormir_solo(rs.getBoolean(2));
                    sce.setDespertar_descripcion(rs.getString(3));
                    sce.setPesadillas(rs.getBoolean(4));
                    sce.setEdad_control_esfinter(rs.getInt(5));
                    sce.setAyuda_baño(rs.getBoolean(6));
                    sce.setMoja_cama(rs.getBoolean(7));
                    sce.setPeriodo_ecopresis_descrip(rs.getString(8));
                    sce.setPeriodo_ecopresis(rs.getBoolean(9));
                    sce.setComo_es_sueno(rs.getString(10));
                    sce.setAcompanamiento_dormir(rs.getString(11));

                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("metodo: getInfoDataSleepControlSphincterFromAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return sce;
    }

    //---------------------------------------------------------------------------- eyelash 10 
    public Escolaridad getInfoDataScholarshipFromAnamnesisBase() {
        Escolaridad es = new Escolaridad();
        String sql = "SELECT  "
                + "es.escolaridad_id, "
                + "es.esc_estudia, "
                + "es.esc_explicacion, "
                + "es.esc_repeticion_anio_causas, "
                + "es.esc_nna_problem_aprend, "
                + "es.esc_nna_observaciones, "
                + "es.esc_asis_prog_apoyo,  "
                + "es.esc_asis_prog_apoyo_obser, "
                + "es.esc_estado, es.esc_ultimo_anio_cursado "
                + "FROM public.escolaridad es  "
                + "JOIN public.anamnesis ana ON es.escolaridad_id=ana.escolaridad_id "
                + "WHERE anamnesis_id = " + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    es.setEscolaridad_id(rs.getInt(1));
                    es.setEsc_estudia(rs.getBoolean(2));
                    es.setEsc_explicacion(rs.getString(3));
                    es.setEsc_repeticion_anio_causas(rs.getString(4));
                    es.setEsc_nna_observaciones(rs.getString(5));
                    es.setEsc_asis_prog_apoyo(rs.getBoolean(6));
                    es.setEsc_asis_prog_apoyo_obser(rs.getString(7));
                    es.setEsc_estado(rs.getBoolean(8));
                    es.setEsc_ultimo_anio_cursado(rs.getString(9));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("metodo: getInfoDataFromEscolaridad (sin datos) array objetos 'datos'se envia nulo ");
        }
        return es;
    }

    //---------------------------------------------------------------------------- eyelash 11
    public Salud_nna getInfoDataSHealthNNAFromAnamnesisBase() {
        Salud_nna s = new Salud_nna();

        String sql = "SELECT  "
                + "s.problem_familiar, "
                + "s.problem_familiar_descrip, "
                + "s.problem_respiratorio, "
                + "s.problem_resp_descrip, "
                + "s.problem_alergias, "
                + "s.problem_aler_descrip, "
                + "s.problem_neurologico, "
                + "s.problem_neuro_descrip, "
                + "s.problem_nerviosos, "
                + "s.problem_nervi_descrip "
                + "FROM anamnesis anam "
                + "JOIN salud_nna s ON s.salud_nna_id = anam.salud_nna_id "
                + "WHERE anam.anamnesis_id = " + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    s.setProblem_familiare(rs.getString(1));
                    s.setProblem_familiar_descrip(rs.getString(2));
                    s.setProblem_respiratorio(rs.getBoolean(3));
                    s.setProblem_resp_descrip(rs.getString(4));
                    s.setProblem_alergias(rs.getBoolean(5));
                    s.setProblem_aler_descrip(rs.getString(6));
                    s.setProblem_neurologico(rs.getBoolean(7));
                    s.setProblem_neuro_descrip(rs.getString(8));
                    s.setProblem_nerviosos(rs.getBoolean(9));
                    s.setProblem_nervi_descrip(rs.getString(10));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("metodo: getInfoDataSleepControlSphincterFromAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return s;
    }

    //--------------------------------------------------------------------------- eyelash 12
    public Relacion_familiar_nna getInfoDataFamilyRelationFromAnamnesisBase() {
        Relacion_familiar_nna rf = new Relacion_familiar_nna();
        String sql = "SELECT "
                + "rf.clima_familiar, "
                + "rf.relacion_padre, "
                + "rf.relacion_madre, "
                + "rf.relacion_hermanos, "
                + "rf.trabajo, "
                + "rf.trabajo_decrip, "
                + "rf.agresion_agresor, "
                + "rf.objeto_utilizado, "
                + "rf.obligacion_familiar, "
                + "rf.proyeccion_madre, "
                + "rf.necesidad_inmediata, "
                + "rf.agresion_frecuencia "
                + "FROM anamnesis anam "
                + "JOIN relacion_familiar_nna rf ON rf.rela_famili_nna_id = anam.rela_famili_nna_id "
                + "WHERE anam.anamnesis_id = " + anamnesis_id + "; ";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    rf.setClima_familiar(rs.getString(1));
                    rf.setRelacion_padre(rs.getString(2));
                    rf.setRelacion_madre(rs.getString(3));
                    rf.setRelacion_hermanos(rs.getString(4));
                    rf.setTrabajo(rs.getBoolean(5));
                    rf.setTrabajo_decrip(rs.getString(6));
                    rf.setAgresion_agresor(rs.getBoolean(7));
                    rf.setObjeto_utilizado(rs.getString(8));
                    rf.setObligacion_familiar(rs.getString(9));
                    rf.setProyeccion_madre(rs.getString(10));
                    rf.setNecesidad_inmediata(rs.getString(11));
                    rf.setAgresion_frecuencia(rs.getString(12));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("metodo: getInfoDataFamilyRelationFromAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return rf;
    }

    //--------------------------------------------------------------------------- eyelash 13
    public Anamnesis getInfoDataObservationsFromAnamnesisBase() {
        Anamnesis objA = new Anamnesis();
        String sql = "SELECT "
                + "observaciones_generales "
                + "FROM anamnesis "
                + "WHERE anamnesis_id = " + anamnesis_id + ";";
        rs = conectar.query(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    objA.setObservaciones_generales(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("metodo: getInfoDataObservationsFromAnamnesisBase (sin datos) array objetos 'datos'se envia nulo ");
        }
        return objA;
    }
}
