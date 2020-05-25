/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.conexion.ConexionHi;
import marylove.vista.VistaBitacora;

/**
 *
 * @author usuario
 */
public class ControladorBitacora implements ActionListener {

    VistaBitacora vbitacora;
    ConexionHi con = new ConexionHi();

    public ControladorBitacora(VistaBitacora vbitacora) {
        this.vbitacora = vbitacora;
        this.vbitacora.setVisible(true);
        this.vbitacora.setResizable(false);
        this.vbitacora.setLocationRelativeTo(null);
        this.vbitacora.getPnlVictima().setVisible(false);
        this.vbitacora.getPnlDescripcion().setVisible(false);
        this.vbitacora.getPnlBotones().setVisible(false);
        this.vbitacora.getBtnBuscar().addActionListener(this);
        this.vbitacora.getBtnCancelar().addActionListener(this);
        this.vbitacora.getBtnGuardar().addActionListener(this);
        this.vbitacora.getTxtFecha().setText(Fecha());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vbitacora.getBtnBuscar())) {
            this.vbitacora.getPnlVictima().setVisible(true);
            this.vbitacora.getPnlDescripcion().setVisible(true);
            this.vbitacora.getPnlBotones().setVisible(true);
            BuscarVictima();

        }
        if (e.getSource().equals(this.vbitacora.getBtnCancelar())) {
            this.vbitacora.dispose();
        }
    }

    public String Fecha() {
        String fecha;
        String pattern = "dd-MM-YYYY ";
        SimpleDateFormat formato = new SimpleDateFormat(pattern);
        fecha = formato.format(new Date());
        return fecha;
    }

    public void BuscarVictima() {
        try {
            String cedula = this.vbitacora.getTxtBuscarCedula().getText();
            String SQL_SELECT = "SELECT\n"
                    + "p.persona_cedula,\n"
                    + "p.persona_nombre ||' '||p.persona_apellido FROM persona p\n"
                    + "JOIN victima v\n"
                    + "ON v.persona_codigo=p.persona_codigo\n"
                    + "WHERE p.persona_cedula = '"+cedula+"'";

            ResultSet rs = con.query(SQL_SELECT);
            while (rs.next()) {
                this.vbitacora.getTxtCedula().setText(rs.getString(1));
                this.vbitacora.getTxtVictima().setText(rs.getString(2));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vbitacora, ex);
        }

    }

   
}
