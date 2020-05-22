/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.x_embarazo_comp;

/**
 *
 * @author Asus
 */
public class x_embarazo_compDB extends x_embarazo_comp {

    PreparedStatement ps;
    ResultSet re;
    victimaDB vdb;
    private Conexion conectar; //=new ConexionHi();
    private String sql = "";

    public x_embarazo_compDB() {
    }

    public x_embarazo_compDB(int embarazo_id, int emp_comp_id, boolean estado) {
        super(embarazo_id, emp_comp_id, estado);
    }

    public x_embarazo_compDB(int embarazo_id, int emp_comp_id, String mater_otro_descrip, boolean estado) {
        super(embarazo_id, emp_comp_id, mater_otro_descrip, estado);
    }

    public x_embarazo_compDB(int embarazo_id, int emp_comp_id, String mater_otro_descrip) {
        super(embarazo_id, emp_comp_id, mater_otro_descrip);
    }

    public boolean primer_insert() throws SQLException {
        sql = "INSERT INTO public.x_embarazo_comp("
                + "	 embarazo_id, emb_comp_id,estado)"
                + "	VALUES (" + getEmbarazo_id() + ", " + getEmp_comp_id() + ",'false');";
        ps = conectar.conectarBD().prepareStatement(sql);
        if (ps.execute()) {
            conectar.cerrarConexion();
            return true;
        } else {
            conectar.cerrarConexion();
            return false;
        }

    }

    public boolean update_x_embarazo_comp(int embarazo_id, int emb_comp_id) throws SQLException {
        boolean res = false;
        sql = "UPDATE public.x_embarazo_comp SET mater_otro_descrip='" + getMater_otro_descrip() + "', estado=true "
                + "WHERE embarazo_id=" + embarazo_id + " and emb_comp_id=" + emb_comp_id + ";";
        ps = conectar.conectarBD().prepareStatement(sql);
        re = ps.executeQuery();
        conectar.cerrarConexion();
        while (re.next()) {
            res=re.getBoolean(1);
        }
        return res;
    }

    public void llenar_x_embarazo_comp() throws SQLException {
        sql = "INSERT INTO public.x_embarazo_comp("
                + "	 embarazo_id, emb_comp_id, mater_otro_descrip)"
                + "	VALUES (" + getEmbarazo_id() + ", " + getEmp_comp_id() + ", " + getMater_otro_descrip() + ");";
        ps = conectar.conectarBD().prepareStatement(sql);
        ps.execute();
        conectar.cerrarConexion();
    }

}
