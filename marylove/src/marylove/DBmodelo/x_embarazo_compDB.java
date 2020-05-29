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
import marylove.models.x_embarazo_comp;

/**
 *
 * @author Asus
 */
public class x_embarazo_compDB extends x_embarazo_comp {

    PreparedStatement ps;
    ResultSet re;
    victimaDB vdb;
    ConexionHi conectar = new ConexionHi();
    private String sql = "";

    public x_embarazo_compDB() {
    }

    public x_embarazo_compDB(int emp_comp_id, boolean estado) {
        super(emp_comp_id, estado);
    }

    public x_embarazo_compDB(int emp_comp_id, String mater_otro_descrip, boolean estado) {
        super(emp_comp_id, mater_otro_descrip, estado);
    }

    public x_embarazo_compDB(int embarazo_id, int emp_comp_id, String mater_otro_descrip) {
        super(embarazo_id, emp_comp_id, mater_otro_descrip);
    }

    public boolean primer_insert() throws SQLException {
        sql = "INSERT INTO public.x_embarazo_comp("
                + "	 embarazo_id, emb_comp_id,estado)"
                + "	VALUES (" + AnamnesisDB.embarazo_id + ", " + getEmp_comp_id() + ",'false');";
        boolean result = conectar.noQuery(sql);
        return result;
    }

    public boolean update_x_embarazo_comp(int emb_comp_id) throws SQLException {
        boolean res = false;
        sql = "select x_embarazo_comp_updateA (" + AnamnesisDB.embarazo_id + "," + emb_comp_id + ",'" + getMater_otro_descrip() + "')";
        boolean result = false;
        ResultSet rs = conectar.query(sql);
        while (rs.next()) {
            result = rs.getBoolean(1);
            System.out.println(result);
        }
        return result;
    }

    public void llenar_x_embarazo_comp() throws SQLException {
        sql = "INSERT INTO public.x_embarazo_comp("
                + "	 embarazo_id, emb_comp_id, mater_otro_descrip)"
                + "	VALUES (" + getEmbarazo_id() + ", " + getEmp_comp_id() + ", " + getMater_otro_descrip() + ");";
        boolean result = conectar.noQuery(sql);
    }

}
