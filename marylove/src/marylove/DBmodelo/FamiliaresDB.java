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
import marylove.conexion.ConexionHi;
import marylove.controlador.FiltroHijosVictima;
import marylove.models.Familiares;

/**
 *
 * @author Usuario
 */
public class FamiliaresDB extends Familiares {
    private static ArrayList<Familiares> af;
    Familiares f;

    public static ArrayList<Familiares> getAf() {
        return af;
    }

    public static void setAf(ArrayList<Familiares> af) {
        FamiliaresDB.af = af;
    }
    
    public FamiliaresDB() throws SQLException {
        
    }

    public FamiliaresDB(int familiares_id, String persona_nombre, String persona_apellido, char persona_sexo, Date persona_fecha_nac, int persona_estadocivil, String parentesco, int persona_nivel_acad, int persona_ocupacion) {
        super(familiares_id, persona_nombre, persona_apellido, persona_sexo, persona_fecha_nac, persona_estadocivil, parentesco, persona_nivel_acad, persona_ocupacion);
    }

    ConexionHi conectar = new ConexionHi();// = new ConexionHi();
    PreparedStatement ps;
    ResultSet re = null;

    public ArrayList<Familiares> lista(int id) throws SQLException {
        af= new ArrayList<>();
        
        String sql = "select f.familiares_id,p.persona_nombre, p.persona_apellido,"
                + "p.persona_sexo,p.persona_fecha_nac, p.persona_estadocivil, "
                + "f.parentesco,p.persona_ocupacion from familiares f join persona "
                + " p using(persona_codigo) where f.hijo_codigo=" + id + ";";
        re = conectar.query(sql);
        while (re.next()) {
            String sex=re.getString(4);
            char sexo= sex.charAt(0);
            f=new Familiares(re.getInt(1),re.getString(2),re.getString(3),// id nombre apellido
            sexo,re.getDate(5),re.getInt(6),re.getString(7),//char fecha_nac estado_civil parentesco
            re.getInt(8),re.getInt(9));
            af.add(f);
        }
        return af;
    }

}
