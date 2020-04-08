/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import marylove.DBmodelo.AgresorDB;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.DireccionPersonaDB;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.personaDB;
import marylove.models.Json_object_consulta;
import marylove.vista.FormaAgregarAgresores;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Unos conejos muy sospechosos
 *
 */
public class ControladorAgregarAgresores extends Validaciones implements ActionListener, ItemListener {

    private FormaAgregarAgresores vista;
    //variables globales para los metodos

    //variables static
    private static int parentesco_static;
    
    //variables globales
    DireccionDB op;
    int direccionId;
    personaDB pdb;
    DireccionPersonaDB dpdb;
    DefaultComboBoxModel modelo;
    AgresorDB adb;
    ArrayList<Json_object_consulta> jocarray;
    jsonDB jo = new jsonDB();

    public ControladorAgregarAgresores() {
    }
    
    public ControladorAgregarAgresores(FormaAgregarAgresores vista) throws ParseException {
        this.vista = vista;
//        this.vista.setVisible(true);
//        this.vista.setLocationRelativeTo(null);
        this.vista.setResizable(false);
        this.vista.getBtnCancelar().addActionListener(this);
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getCbxNivelacad().addItemListener(this);
        vista.getTxtinstruccionOtros().setEnabled(false);
        comboNivelAcad();
        comboNacionalidad();
        comboOcupa();
        comboParentesco();
    }

    public void comboNacionalidad() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerNacionalidades();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxPais().setModel(modelo);
        vista.getCbxNacionalidad().setModel(modelo);

    }

    public void comboParentesco() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerParntesco();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxParentesco().setModel(modelo);

    }

    public void comboNivelAcad() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerInstruccines();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxNivelacad().setModel(modelo);

    }

    public void comboOcupa() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerOcupaciones();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxOcupacion().setModel(modelo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getBtnGuardar())) {
            try {
                if (validaciones()) {

                    DatosPersonales();
                    ingresarDireccion();
                    insetarDireccionPersona();

                }

            } catch (SQLException ex) {
                Logger.getLogger(ControladorAgregarAgresores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(vista.getBtnCancelar())) {

            vista.dispose();

        }
    }

    public boolean validaciones() {
        if (vista.getTxtCedula().getText() != null) {
            if (vista.getTxtCedula().getText().length() >= 10
                    && vista.getTxtCedula().getText().length() <= 13
                    && vista.getTxtCedula().getText().matches("[0-9]*")) {
                if (vista.getTxtNombre().getText() != null && !vista.getTxtNombre().getText().matches("[0-9]*")) {
                    if (vista.getTxtApellido().getText() != null && !vista.getTxtApellido().getText().matches("[0-9]*")) {
                        int ao = vista.getDcFechanacimiento().getDate().getYear();
                        Date h = new Date();
                        int suma = h.getYear() - ao;
                        if (vista.getDcFechanacimiento().getDate() != null && suma > 5) {
                            if (vista.getTxtTelefono().getText().matches("[0-9]*") && vista.getTxtTelefono().getText().length() <= 10) {
                                if (vista.getTxtCelular().getText().matches("[0-9]*") && vista.getTxtCelular().getText().length() == 10) {
                                    return true;
                                } else {
                                    JOptionPane.showMessageDialog(vista, "Ingrese una número válido");
                                    vista.getTxtCelular().setText("");
                                    return false;

                                }
                            } else {
                                JOptionPane.showMessageDialog(vista, "Ingrese una número válido");
                                vista.getTxtTelefono().setText("");
                                return false;

                            }
                        } else {
                            JOptionPane.showMessageDialog(vista, "Ingrese una fecha válida");
                            return false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(vista, "Ingrese un apellido válido");
                        vista.getTxtApellido().setText("");
                        return false;
                    }

                } else {
                    JOptionPane.showMessageDialog(vista, "Ingrese un nombre válido");
                    vista.getTxtNombre().setText("");
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(vista, "Ingrese una Cédula válida");
                vista.getTxtCedula().setText("");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Ingrese una Cédula...");
            vista.getTxtCedula().setText("");
            return false;
        }

    }

    public void DatosPersonales() throws SQLException {
        String intrucOtros = "";

        long fecha_nacimiento = vista.getDcFechanacimiento().getDate().getTime();
        Date fecha = fechaBD(fecha_nacimiento);

        int ocupacion = vista.getCbxOcupacion().getSelectedIndex() + 1;
        int nacionalidad = vista.getCbxNacionalidad().getSelectedIndex() + 1;
        int nivelacademico = vista.getCbxNivelacad().getSelectedIndex() + 1;
        int estamigratorio = vista.getCbxEstadomigra().getSelectedIndex() + 1;
        int estadocivil = 0;
        char sex = vista.getCbxSexo().getSelectedItem().toString().charAt(0);
        pdb = new personaDB(vista.getTxtCedula().getText(),
                vista.getTxtNombre().getText(), vista.getTxtApellido().getText(),
                fecha, ocupacion, nivelacademico, estamigratorio,
                vista.getTxtTelefono().getText(), vista.getTxtCelular().getText(),
                estadocivil, nacionalidad, true, sex, vista.getTxtinstruccionOtros().getText(),
                vista.getTxtDireccionTrabajo().getText(), vista.getTxtReferencia().getText());
        pdb.ingresarPersonaAgresor();
        adb = new AgresorDB(pdb.getPersona_agresor_static());
        adb.insertarAgresor();
        parentesco_static=vista.getCbxParentesco().getSelectedIndex()+1;
    }

    public void insetarDireccionPersona() throws SQLException {
        pdb = new personaDB();
        op = new DireccionDB();
        int dir = op.obtenerIdDireccion();
        int per = pdb.obtenerIdPersona();
        dpdb = new DireccionPersonaDB(per, dir);
        dpdb.insertarDireccionD();
    }

    public void ingresarDireccion() {
        op = new DireccionDB(vista.getTxtCalle().getText(), vista.getTxtInterseccion().getText(),
                vista.getTxtNCasa().getText(), vista.getTxtBarrio().getText(), vista.getTxtParroquia().getText(),
                vista.getTxtCiudad().getText(), vista.getTxtReferencia().getText(), vista.getTxtProvincia().getText(),
                vista.getCbxPais().getSelectedItem().toString(), true);
        op.insertaDireccion();

    }

    public void finals() {
        JOptionPane.showMessageDialog(vista, "Agresor Agregado");
        vista.dispose();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem().equals("Otra")) {

            vista.getTxtinstruccionOtros().setEnabled(true);
        } else {
            vista.getTxtinstruccionOtros().setEnabled(false);
            vista.getTxtinstruccionOtros().setText("");
        }

    }

    public static int getParentesco_static() {
        return parentesco_static;
    }

    public static void setParentesco_static(int parentesco_static) {
        ControladorAgregarAgresores.parentesco_static = parentesco_static;
    }
    

}
