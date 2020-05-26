/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
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
                + "VALUES(1,'05-25-2020','" + getBitacora_desc() + "'," + getVictima_codigo() + ")";
        boolean resultado = conectar.noQuery(sql);
        return resultado;
    }

    public boolean isValidacion() {
        return validacion;
    }

    public void setValidacion(boolean validacion) {
        this.validacion = validacion;
    }

}
