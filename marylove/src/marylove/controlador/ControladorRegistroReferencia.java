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
        vista.getTxtinstruccionOtros().setVisible(false);
//        if(vista.getCbxInstruccion().getSelectedItem().equals("Otra")){
//           vista.getTxtinstruccionOtros().setVisible(true);
//        }else{
//        vista.getTxtinstruccionOtros().setVisible(false);
//        vista.getTxtinstruccionOtros().setText("");
//        }

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
        String intrucOtros="";
        
        
        long fecha_nacimiento=vista.getDcFechaNacimiento().getDate().getTime();
        Date fecha=fechaBD(fecha_nacimiento);
        int estadocivil =vista.getCbxEstadoCivill().getSelectedIndex()+1;

        char sexo=vista.getCbSexo().getSelectedItem().toString().charAt(0);
        int ocupacion=vista.getCbxOcupacion().getSelectedIndex()+1;
        int nacionalidad=vista.getCbxNacionalidad().getSelectedIndex()+1;
        int nivelacademico=vista.getCbxInstruccion().getSelectedIndex()+1;
        int estamigratorio=vista.getCbxEstadoMigratrorio().getSelectedIndex()+1;
        
        personaDB pdb = new personaDB(vista.getTxtCedula().getText(),
        vista.getTxtNombrePersona().getText(), vista.getTxtApellidoPersona().getText(),
        fecha,estadocivil,nacionalidad,ocupacion,nivelacademico,
        vista.getTxtinstruccionOtros().getText(),estamigratorio,
        vista.getTxtTelefonoPersona().getText(),vista.getTxtCelular().getText(),
        true,sexo,vista.getTxtLugarTrabajo().getText(),vista.getTxtReferencia().getText());
        pdb.ingresarPersona();

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
