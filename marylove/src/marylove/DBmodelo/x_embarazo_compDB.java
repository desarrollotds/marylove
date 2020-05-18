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
    private ConexionHi conectar=new ConexionHi();
    private String sql = "";

    public x_embarazo_compDB() {
    }

    public x_embarazo_compDB(int embarazo_id, int emp_comp_id, String mater_otro_descrip) {
        super(embarazo_id, emp_comp_id, mater_otro_descrip);
    }
    
    public void llenar_x_embarazo_comp() throws SQLException{
        sql = "INSERT INTO public.x_embarazo_comp(" +
"	 embarazo_id, emb_comp_id, mater_otro_descrip)" +
"	VALUES ("+getEmbarazo_id()+", "+getEmp_comp_id()+", "+getMater_otro_descrip()+");";
        ps=conectar.getConnection().prepareStatement(sql);
        ps.execute();
    }

}
