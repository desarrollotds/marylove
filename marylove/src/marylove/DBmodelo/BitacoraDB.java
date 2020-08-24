/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.conexion.ConexionHi;
import marylove.models.Bitacora;
import marylove.vista.VistaBitacora;

/**
 *
 * @author usuario
 */
public class BitacoraDB extends Bitacora {

    private ConexionHi conectar = new ConexionHi();
    private boolean validacion;

    public BitacoraDB() {

    }

    public BitacoraDB(int bitacora_id, int personal_codigo, Date bitacora_date, String bitacora_desc) {
        super(bitacora_id, personal_codigo, bitacora_date, bitacora_desc);

    }

    public void BuscarVictima(String cedula, VistaBitacora vbitacora) {
        try {
            String SQL_SELECT = "SELECT\n"
                    + "p.persona_cedula,\n"
                    + "p.persona_nombre ||' '||p.persona_apellido,\n"
                    + "v.victima_codigo\n "
                    + "FROM persona p\n"
                    + "JOIN victima v\n"
                    + "ON v.persona_codigo=p.persona_codigo\n"
                    + "WHERE p.persona_cedula = '" + cedula + "'";
            validacion = false;
            ResultSet rs = conectar.query(SQL_SELECT);
            while (rs.next()) {
                vbitacora.getTxtCedula().setText(rs.getString(1));
                vbitacora.getTxtVictima().setText(rs.getString(2));
                setVictima_codigo(rs.getInt(3));
                validacion = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public boolean crearBitacora() throws SQLException {
        String sql = "INSERT INTO bitacora (personal_codigo,bitacora_date,bitacora_desc,victima_codigo)\n"
                + "VALUES(" + getPersonal_codigo() + ",'" + getBitacora_date() + "','" + getBitacora_desc() + "'," + getVictima_codigo() + ")";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }

    public void ObtenerPersonal(VistaBitacora vbitacora) {
        try {
            String SQL_SELECT = "SELECT p.persona_nombre||' '||p.persona_apellido\n"
                    + "FROM persona p\n"
                    + "JOIN personal pr\n"
                    + "ON pr.persona_codigo = p.persona_codigo\n"
                    + "WHERE pr.personal_codigo =" + getPersonal_codigo();
            ResultSet rs = conectar.query(SQL_SELECT);
            while (rs.next()) {
                vbitacora.getTxtPersonal().setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Surgió un error" + ex);
        }
    }

    public DefaultTableModel ObtenerRegistros(String cedula, VistaBitacora vista) {
        DefaultTableModel model = new DefaultTableModel();
        try {
            String SQL_SELECT = "SELECT  p.persona_nombre ||' '||p.persona_apellido AS \"Personal\"\n" +
"   ,b.bitacora_date AS \"Fecha \", b.bitacora_desc AS \"Descripcion\"\n" +
"    FROM public.bitacora b\n" +
"	JOIN personal per\n" +
"	ON per.personal_codigo = b.personal_codigo\n" +
"	JOIN persona p\n" +
"	ON p.persona_codigo = per.persona_codigo\n" +
"	JOIN victima v \n" +
"	ON v.victima_codigo = b.victima_codigo\n" +
"	JOIN persona p1\n" +
"	ON p1.persona_codigo = v.persona_codigo\n" +
"	WHERE p1.persona_cedula = '"+cedula+"';";
            ResultSet rs = conectar.query(SQL_SELECT);
            model.setColumnIdentifiers(new Object[]{"Personal","Fecha","Descripción"});
           
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});  
            }   

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Surgió un error" + ex);
        }
        
         return model;
    }

    public boolean isValidacion() {
        return validacion;
    }

    public void setValidacion(boolean validacion) {
        this.validacion = validacion;
    }

}
