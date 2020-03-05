/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.personaDB;
import marylove.DBmodelo.persona_llamadaDB;
import marylove.models.Json_object_consulta;
import marylove.vista.Ficharegistroyreferencia;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Asus
 */
public class ControladorRegistroReferencia extends Validaciones implements ActionListener {

    Ficharegistroyreferencia vista;
    private static int ID_persona_llamada;
    persona_llamadaDB pldb;
    DefaultComboBoxModel modelo;
    ArrayList<Json_object_consulta> jocarray;
    jsonDB jo = new jsonDB();

    public ControladorRegistroReferencia(Ficharegistroyreferencia vista) throws ParseException {
        this.vista = vista;
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.setResizable(false);
        vista.getBtnAgregarAgresores().addActionListener(this);
        vista.getBtnAgregarHijos().addActionListener(this);
        vista.getBtnCancelar().addActionListener(this);
        vista.getBtnGuardar().addActionListener(this);
        comboEstadoCivil();
        comboInstruccion();

    }

    public void comboInstruccion() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerInstruccines();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxInstruccion().setModel(modelo);

    }

    public void DatosPersonales() {
        String cedula="";
        String nombre="";
        String apellido="";
        Date fecha_nacimiento=vista.getDcFechaNacimiento().getDate();
        DateFormat f=new SimpleDateFormat("dd-MM-yyyy");
        String fecha2=f.format(fecha_nacimiento);
        System.out.println(fecha_nacimiento);
        if (vista.getTxtNombrePersona().getText().matches("[A-Z a-z]*")) {
                nombre = vista.getTxtNombrePersona().getText().toUpperCase();
            } else {

            }
        personaDB personBD = new personaDB();

    }

    public void comboEstadoCivil() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerEstadoCivil();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxEstadoCivill().setModel(modelo);

    }

    public void Iniciable() {
        vista.getTxtNombrePersona().addKeyListener(validarLetras(vista.getTxtNombrePersona()));

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(vista.getBtnGuardar())) {
            DatosPersonales();
        }
        if (ae.getSource().equals(vista.getBtnCancelar())) {

        }
        if (ae.getSource().equals(vista.getBtnAgregarAgresores())) {

        }
        if (ae.getSource().equals(vista.getBtnAgregarHijos())) {

        }
    }

}
