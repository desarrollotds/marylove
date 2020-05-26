/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.DBmodelo.BitacoraDB;
import marylove.conexion.ConexionHi;
import marylove.models.Bitacora;
import marylove.vista.VistaBitacora;

/**
 *
 * @author usuario
 */
public class ControladorBitacora implements ActionListener {

    VistaBitacora vbitacora;
    BitacoraDB model = new BitacoraDB();

    public ControladorBitacora(VistaBitacora vbitacora) {
//        this.vbitacora = vbitacora;
//        this.vbitacora.setVisible(true);
//        this.vbitacora.setResizable(false);
        this.vbitacora.setLocationRelativeTo(null);
        this.vbitacora.getPnlVictima().setVisible(false);
        this.vbitacora.getPnlDescripcion().setVisible(false);
        this.vbitacora.getPnlBotones().setVisible(false);
        this.vbitacora.getBtnBuscar().addActionListener(this);
        this.vbitacora.getBtnCancelar().addActionListener(this);
        this.vbitacora.getBtnGuardar().addActionListener(this);
        date();
        this.vbitacora.getTxtFecha().setText(Fecha());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vbitacora.getBtnBuscar())) {

            model.BuscarVictima(this.vbitacora.getTxtBuscarCedula().getText().toString(), vbitacora);
            if (model.isValidacion()) {
                this.vbitacora.getPnlVictima().setVisible(true);
                this.vbitacora.getPnlDescripcion().setVisible(true);
                this.vbitacora.getPnlBotones().setVisible(true);
            } else {
                this.vbitacora.getPnlVictima().setVisible(false);
                this.vbitacora.getPnlDescripcion().setVisible(false);
                this.vbitacora.getPnlBotones().setVisible(false);
                JOptionPane.showMessageDialog(vbitacora, "No existe una persona ingresada con esa cédula", "Problema", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource().equals(this.vbitacora.getBtnCancelar())) {
            this.vbitacora.dispose();
        }
        if (e.getSource().equals(this.vbitacora.getBtnGuardar())) {
            if (this.vbitacora.getTxaDescripcion().getText().equals("")) {
                JOptionPane.showMessageDialog(vbitacora, "Agregue una descripción de la Actividad", "Problema", JOptionPane.ERROR_MESSAGE);
            } else {
                model.setBitacora_desc(this.vbitacora.getTxaDescripcion().getText());
                createBitacora();
            }
        }
    }

    public String Fecha() {
        String fecha;
        String pattern = "MM-dd-YYYY ";
        SimpleDateFormat formato = new SimpleDateFormat(pattern);
        fecha = formato.format(date());
        return fecha;
    }

    public Date date() {
        Date date = new Date();
        model.setBitacora_date(date);
        return date;

    }

//    public void BuscarVictima(String cedula) {
//        try {
//            String SQL_SELECT = "SELECT\n"
//                    + "p.persona_cedula,\n"
//                    + "p.persona_nombre ||' '||p.persona_apellido,\n"
//                    + "v.victima_codigo\n "
//                    + "FROM persona p\n"
//                    + "JOIN victima v\n"
//                    + "ON v.persona_codigo=p.persona_codigo\n"
//                    + "WHERE p.persona_cedula = '" + cedula + "'";
//            validacion = false;
//            ResultSet rs = con.query(SQL_SELECT);
//
//            while (rs.next()) {
//                vbitacora.getTxtCedula().setText(rs.getString(1));
//                vbitacora.getTxtVictima().setText(rs.getString(2));
//                bitacora.setVictima_codigo(rs.getInt(3));
//                System.out.println(bitacora.getVictima_codigo());
//                validacion = true;
//            }
//            System.out.println(rs);
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//
//    }
    public void createBitacora() {
//        String SQL_INSERT = "INSERT INTO bitacora (personal_codigo,bitacora_date,bitacora_desc,victima_codigo)\n"
//                + "VALUES(1,'05-25-2020','" + bitacora.getBitacora_desc() + "'," + bitacora.getVictima_codigo() + ")";
        try {
//            con.noQuery(SQL_INSERT);
            if (model.crearBitacora()) {
                JOptionPane.showMessageDialog(vbitacora, "Datos Ingresados Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.vbitacora.getTxtBuscarCedula().setText("");
                this.vbitacora.getPnlVictima().setVisible(false);
                this.vbitacora.getPnlDescripcion().setVisible(false);
                this.vbitacora.getPnlBotones().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(vbitacora, "Agregue una descripción de la Actividad", "Problema", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e) {
            System.out.println("ERROOOOOR> " + e);
        }
    }

}
