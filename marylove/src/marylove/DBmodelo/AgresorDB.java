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
import java.util.Date;
import java.util.List;
import marylove.conexion.ConexionHi;
import marylove.models.Agresor;

/**
 *
 * @author Unos conejos muy sospechosos
 */
public class AgresorDB extends Agresor {
    //Varibales static
    private static int agresor_codigo_static;
    private static List<AgresorDB> agresores= new ArrayList<>(); 
    //variablesDB
    ConexionHi conectar=new ConexionHi(); // = new ConexionHi();
    PreparedStatement ps;
    ResultSet re;
    String sql = "";
    //variables globales
    victimaDB vdb;
    int co_re=0;
    
    public AgresorDB() {
    }

    public AgresorDB(int persona_codigo) {
        super(persona_codigo);
    }

    public AgresorDB(String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo, String parentesco) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo, parentesco);
    }
    
    
    public boolean consultaAgresorVictimas() {
        try {
            sql="select p.persona_cedula, p.persona_nombre, p.persona_apellido, p.persona_fecha_nac, p.persona_telefono, p.persona_celular, "
                    + "p.persona_sexo, xra.parentesco "
                    + "from registro_referencia rr, x_registro_agresor xra, agresor a, persona p "
                    + "where rr.registroreferencia_codigo=xra.registroreferencia_codigo and "
                    + "xra.agresor_codigo=a.agresor_codigo and a.persona_codigo=p.persona_codigo "
                    + "and rr.victima_codigo="+vdb.getCodigo_victima_static()+";";
            ps = conectar.getConnection().prepareStatement(sql);
            re = ps.executeQuery();

            conectar.cerrarConexion();

            AgresorDB a;
            while (re.next()) {
                a = new AgresorDB();
                a.setPersona_cedula(re.getString(1));
                a.setPersona_nombre(re.getString(2));
                a.setPersona_apellido(re.getString(3));
                a.setPersona_fecha_nac(re.getDate(4));
                a.setPersona_telefono(re.getString(5));
                a.setPersona_celular(re.getString(6));
                a.setPersona_sexo(re.getString(7).charAt(0));
                a.setParentesco(re.getString(8));
                agresores.add(a);

            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return true;
    }
    public int insertarAgresor(int id) throws SQLException {
        
        co_re=0;
        sql = "INSERT INTO public.agresor( persona_codigo)VALUES "
                + "(" + id + ")returning agresor_codigo;";
        ps=conectar.getConnection().prepareStatement(sql);
        re=ps.executeQuery();

        conectar.cerrarConexion();

        while(re.next()){
            co_re=re.getInt(1);
            agresor_codigo_static=re.getInt(1);
        
        }
        return co_re;
    }

    public static int getAgresor_codigo_static() {
        return agresor_codigo_static;
    }

    public static void setAgresor_codigo_static(int agresor_codigo_static) {
        AgresorDB.agresor_codigo_static = agresor_codigo_static;
    }

    public static List<AgresorDB> getAgresores() {
        return agresores;
    }

    public static void setAgresores(List<AgresorDB> agresores) {
        AgresorDB.agresores = agresores;
    }

    
    

}
