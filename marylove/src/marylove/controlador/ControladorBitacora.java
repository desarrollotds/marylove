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
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.BitacoraDB;
import marylove.DBmodelo.ResultadosDB;
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
    C_Login login;
    public DefaultTableModel modelotabla;
    private ConexionHi conectar = new ConexionHi();
    ResultadosDB resul = new ResultadosDB();

    public ControladorBitacora(VistaBitacora vbitacora) throws ParseException {

        this.vbitacora = vbitacora;
        this.vbitacora.getBtnBuscar().addActionListener(this);
        this.vbitacora.getBtnCancelar().addActionListener(this);
        this.vbitacora.getBtnGuardar().addActionListener(this);
        this.vbitacora.getBtnactualizar().addActionListener(this);
        this.vbitacora.getTbDatos().setVisible(false);
        obtenerPersonal();
        model.ObtenerPersonal(vbitacora);
        this.vbitacora.getTxtFecha().setText(Fecha());
        inicializador();

    }

    public void inicializador() {

        modelotabla = new DefaultTableModel();
        modelotabla.addColumn("Personal");
        modelotabla.addColumn("Fecha");
        modelotabla.addColumn("Descripcion");
        this.vbitacora.getTbDatos().setModel(modelotabla);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vbitacora.getBtnBuscar())) {

            model.BuscarVictima(this.vbitacora.getTxtBuscarCedula().getText().toString(), vbitacora);
            if (model.isValidacion()) {
                ObtenerRegistros();
                this.vbitacora.getTbDatos().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(vbitacora, "No se han encontrado datos", "Problema", JOptionPane.WARNING_MESSAGE);
            }

        }
        if (e.getSource().equals(this.vbitacora.getBtnCancelar())) {
            Limpiar();

        }
        if (e.getSource().equals(this.vbitacora.getBtnGuardar())) {
            String descripcion = this.vbitacora.getTxaDescripcion().getText();
            if (descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(vbitacora, "Agregue una descripción de la Actividad", "Problema", JOptionPane.WARNING_MESSAGE);
            } else {
                model.setBitacora_desc(this.vbitacora.getTxaDescripcion().getText());
                cambiarfecha();
                createBitacora();
                vbitacora.getBtnactualizar().setEnabled(true);

            }
        }
        if(e.getSource().equals(this.vbitacora.getBtnactualizar())){
            ObtenerRegistros();
        }
       
    }

    // TRANSFORMA LA FECHA EN UN FORMATO 
    public String Fecha() throws ParseException {
        String fecha;
        String pattern = "dd-MM-YYYY ";
        SimpleDateFormat formato = new SimpleDateFormat(pattern);
        //Nuevas soluciones a la fecha

        fecha = formato.format(new Date());

        return fecha;
    }

    public void cambiarfecha() {
        try {
            String fecha = vbitacora.getTxtFecha().getText();
            String pattern = "dd-MM-YYYY ";
            SimpleDateFormat formatodb = new SimpleDateFormat(pattern);
            Date d = new Date();
            Long fechadb = d.getTime();
            java.sql.Date fechaBDpg = new java.sql.Date(fechadb);
            model.setBitacora_date(fechaBDpg);
        } catch (Exception e) {
        }

    }

    public void ObtenerRegistros() {
        modelotabla = model.ObtenerRegistros(vbitacora.getTxtBuscarCedula().getText(), vbitacora);
        vbitacora.getTbDatos().setModel(modelotabla);
        int[] anchos = {70, 10, 600};
        for (int i = 0; i < vbitacora.getTbDatos().getColumnCount(); i++) {
            vbitacora.getTbDatos().getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        System.out.println(modelotabla.getRowCount());

    }

    //OBTIENE LA FECHA ACTUAL Y SETEA AL OBJETO
    public Date date() {
        Date date = new Date();
        model.setBitacora_date(date);
        return date;

    }

    //METODO PARA CREAR UNA BITACORA
    public void createBitacora() {
        try {
            if (model.crearBitacora()) {
                JOptionPane.showMessageDialog(vbitacora, "Datos Ingresados Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.vbitacora.getTxaDescripcion().setText("");

            } else {
                JOptionPane.showMessageDialog(vbitacora, "Hubo un error al ingresar la información", "Problema", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e) {
            System.out.println("ERROOOOOR> " + e);
            JOptionPane.showMessageDialog(vbitacora, "Hubo un error al ingresar la información", "Problema", JOptionPane.ERROR_MESSAGE);
        }
    }

    //METODO PARA OBTENER EL ID DEL PERSONAL
    public void obtenerPersonal() {
        try {
            login = new C_Login();
            model.setPersonal_codigo(login.personal_cod);
            System.out.println(model.getPersonal_codigo());
        } catch (Exception e) {
        }
    }

    // METODO PARA LIMPIAR LA VENTANA
    public void Limpiar() {
        this.vbitacora.getTxtBuscarCedula().setText("");
        this.vbitacora.getTxtVictima().setText("");
        this.vbitacora.getTxtCedula().setText("");
        this.vbitacora.getTbDatos().setVisible(false);
        vbitacora.getBtnactualizar().setEnabled(false);
    }

}
