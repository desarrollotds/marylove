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

/**
 *
 * @author Usuario
 */
public class AnamnesisDB extends Anamnesis {

    //variables conexion
    ConexionHi conectar = new ConexionHi();
    PreparedStatement ps;
    ResultSet rs = null;
    static int nacimiento_codigo, deta_codigo, sucoes_id, post_parto_id, salud_nna_id, desarrollo_id, rela_famili_nna_id, embarazo_id, escolaridad_id, anamnesis_id;

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

    public boolean update_observaciones_generales() {
        boolean res = false;
        String sql = "select anamnesis_obser_gener_updateA ()";

        return res;
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

    //Registrar un padre vacio a la tabla 
    static int codigoPadre;

    public int codigoPadre() throws SQLException {

        String sql = "Select MAX(persona_codigo)+1 from persona";
        rs = conectar.query(sql);
        int nuevocodigopersona = 0;
        while (rs.next()) {
            nuevocodigopersona = rs.getInt(1);
        }
        System.out.println(nuevocodigopersona + "hola");
        String sql2 = "INSERT INTO public.persona(persona_codigo) VALUES (" + nuevocodigopersona + ") ";
        boolean resultado = conectar.noQuery(sql2);

        String sql3 = "INSERT INTO public.padre(persona_codigo)VALUES(" + nuevocodigopersona + ") RETURNING padre_id";
        rs = conectar.query(sql);

        while (rs.next()) {
            codigoPadre = rs.getInt(1);
        }
        return codigoPadre;
    }

    //modifica e inserta el codigo del padre en la tabla hijos
    public boolean updateHijoCodigoP(int codigohijo) {
        String sql = "UPDATE public.hijos SET padre_id=" + codigoPadre + " WHERE hijo_codigo=" + codigohijo;
        boolean result = conectar.noQuery(sql);
       return result;
    }

    public void nacimiento() throws SQLException {
        String sql = " INSERT INTO public.nacimiento(nacimiento_estado) VALUES (true) RETURNING nacimiento_codigo";
        rs = conectar.query(sql);
        while (rs.next()) {
            nacimiento_codigo = rs.getInt(1);
        }
        conectar.cerrarConexion();

    }

    public void detallenacimiento() throws SQLException {
        String sql = " INSERT INTO public.detalle_nacimiento( nacimiento_codigo, detalle_nac_estado)VALUES (" + nacimiento_codigo + ", false) RETURNING deta_codigo;";
        rs = conectar.query(sql);
        while (rs.next()) {
            deta_codigo = rs.getInt(1);
        }
        conectar.cerrarConexion();

    }

    public void suenocontro() throws SQLException {
        String sql = " INSERT INTO public.sueno_control_esfin(sueno_cont_estado) VALUES (false) RETURNING sucoes_id;";
        rs = conectar.query(sql);
        while (rs.next()) {
            sucoes_id = rs.getInt(1);
        }
        conectar.cerrarConexion();
    }

    public void saludnna() throws SQLException {
        String sql = "INSERT INTO public.salud_nna(salud_nna_estado) VALUES (false) RETURNING salud_nna_id ";
        rs = conectar.query(sql);
        while (rs.next()) {
            salud_nna_id = rs.getInt(1);
        }
        conectar.cerrarConexion();

    }

    public void postParto() throws SQLException {
        String sql = "INSERT INTO public.post_parto(post_parto_estado) VALUES(false) RETURNING post_parto_id";
        rs = conectar.query(sql);
        while (rs.next()) {
            post_parto_id = rs.getInt(1);
        }
        conectar.cerrarConexion();
    }

    public void desarrollo() throws SQLException {
        String sql = "INSERT INTO public.desarrollo(desarrollo_estado) VALUES (false) RETURNING desarrollo_id";
        rs = conectar.query(sql);
        while (rs.next()) {
            desarrollo_id = rs.getInt(1);
        }
        conectar.cerrarConexion();
    }

    public void relacionFamiliar() throws SQLException {
        String sql = "INSERT INTO public.relacion_familiar_nna(rela_famili_estado) VALUES(false) RETURNING rela_famili_nna_id";
        rs = conectar.query(sql);
        while (rs.next()) {
            rela_famili_nna_id = rs.getInt(1);
        }
        conectar.cerrarConexion();
    }

    public void embarazoEstado() throws SQLException {
        String sql = "INSERT INTO public.embarazo_estado(embarazo_estado) VALUES(false) RETURNING embarazo_id";

        rs = conectar.query(sql);
        while (rs.next()) {
            embarazo_id = rs.getInt(1);
        }
        conectar.cerrarConexion();
    }

    public void escolaridad() throws SQLException {
        String sql = " INSERT INTO public.escolaridad(esc_estado) VALUES (false) RETURNING escolaridad_id";
        rs = conectar.query(sql);
        while (rs.next()) {
            escolaridad_id = rs.getInt(1);
        }
        conectar.cerrarConexion();
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

        while (rs.next()) {
            anamnesis_id = rs.getInt(1);
        }
        System.out.println("jjjjj   " + anamnesis_id);
        conectar.cerrarConexion();
        return true;

    }

    public void conectarTodo(int codigohijo) {
        String sql = "select hijo_codigo from anamnesis where hijo_codigo=" + codigohijo;
        rs = conectar.query(sql);

        try {
            if (rs.next()) {
                conectar.cerrarConexion();
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

            } else {
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnamnesisDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //METODOS DE ACTUALIZACIÓN POR PESTAÑAS--------------------------------------------------------------------------------------------------------------------
    //1.1 ACTUALIZAR DATOS DE IDENTIFICACIÓN
    public boolean actualizarDatosIdentificacion(NacimientoDB objNac, HijosDB objHijo, int cod_nacimiento, int cod_hijo) {

        String sql = "Select actualizarDatosIdentificacion(" + ""
                + "'" + objHijo.getPersona_fecha_nac() + "', "
                + objHijo.getPersona_nacionalidad() + ", "
                + cod_hijo + ", "
                + "'" + objNac.getLugar_nacimiento() + "')";
        boolean result = conectar.noQuery(sql);
        return result;
        
    }

    //1.2 ACTUALIZAR DATOS DEL PADRE Y LA MADRE
    public boolean actualizarDatosPadreMadre(PadreDB objPadre, HijosDB objHijo, int cod_padre, int cod_hijo) {

        String sql = "Select actualizarDatosPadreMadre(" + ""
                + "'" + objPadre.getPersona_nombre() + "', "
                + "'" + objPadre.getPersona_apellido() + "', "
                + objPadre.getPersona_nacionalidad() + ", "
                + cod_padre + ", "
                + "'" + objHijo.isPadre_agresor() + "',"
                + "'" + objHijo.getHijo_estado_ingreso() + "', "
                + cod_hijo + ")";
         boolean result = conectar.noQuery(sql);
        return result;
    }

    //1.3 NO ES NECESARIO
    //1.4 LO HACE DANNY
    //1.5 ACTUALIZAR DATOS DE LAS CONDICIONES DE NACIMIENTO
    public boolean actualizarDatosCondicionesNacimiento(NacimientoDB objNac, Detalle_nacimientoDB objDetalleNac, int cod_Nac, int cod_DetalleNac) {

        String sql = "Select actualizarDatosCondicionesNacimiento(" + ""
                + objNac.getMes_alumbramiento()+ ", "
                + "'" + objNac.getObservaciozes_parto()+ "', "
                + "'"+objNac.isAnestesia() + "', "
                + "'"+objNac.getLugar_nacimiento()+"', "
                + "'" + objNac.getParto_tipo()+ "', "
                + cod_Nac+", "
                + "'"+objDetalleNac.getPeso()+"', "
                + "'"+objDetalleNac.getTalla()+"', "
                + "'"+objDetalleNac.isLloro_nac()+"', "
                + "'"+ objDetalleNac.isNecesito_oxigeno()+"', "
                + "'"+objDetalleNac.getSintomas_after_part()+"', "
                + cod_DetalleNac+")";

        boolean result = conectar.noQuery(sql);
        return result;
    }
    //1.6 ESTA EN LA CLASE POSTPARTODBB
    //1.7 ESTA EN LA CLASE POSTPARTODB

}
