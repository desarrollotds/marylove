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

    public BitacoraDB(int bitacora_id, int personal_codigo, int victima_codigo, Date bitacora_date, String bitacora_situacion, String bitacora_accion_realizada, String bitacora_resultado) {
        super(bitacora_id, personal_codigo, victima_codigo, bitacora_date, bitacora_situacion, bitacora_accion_realizada, bitacora_resultado);
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
        String sql = "INSERT INTO public.bitacora(\n"
                + "     personal_codigo, bitacora_date, victima_codigo, bitacora_situacion, bitacora_accion_realizada, bitacora_resultado)\n"
                + "	VALUES (" + getPersonal_codigo() + ",'" + getBitacora_date() + "'," + getVictima_codigo()
                + "     , '" + getBitacora_situacion() + "', '" + getBitacora_accion_realizada() + "', '" + getBitacora_resultado() + "');";
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

    public DefaultTableModel ObtenerRegistros(String cedula) {

        DefaultTableModel model = new DefaultTableModel();
        try {
            String SQL_SELECT = "SELECT \n"
                    + "b.bitacora_date ,b.bitacora_situacion,\n"
                    + "b.bitacora_accion_realizada, b.bitacora_resultado,\n"
                    + "p.persona_nombre ||' '||p.persona_apellido\n"
                    + "/*p1.persona_nombre ||'  '|| p1.persona_apellido*/\n"
                    + "FROM public.bitacora b\n"
                    + "JOIN personal per\n"
                    + "USING (personal_codigo)\n"
                    + "JOIN persona p\n"
                    + "ON p.persona_codigo = per.persona_codigo\n"
                    + "JOIN victima v \n"
                    + "USING (victima_codigo)\n"
                    + "JOIN persona p1\n"
                    + "ON p1.persona_codigo = v.persona_codigo\n"
                    + "WHERE p1.persona_cedula = '"+cedula+"'";
            ResultSet rs = conectar.query(SQL_SELECT);
            model.setColumnIdentifiers(new Object[]{"Fecha", "Situación", "Acción Realizada","Resultado","Personal"});

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)});
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
