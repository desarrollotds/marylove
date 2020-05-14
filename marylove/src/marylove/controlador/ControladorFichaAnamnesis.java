/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import com.mxrck.autocompleter.AutoCompleter;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.DBmodelo.FichaAnamnesisBD;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.NacimientoDB;
import marylove.DBmodelo.jsonDB;
import marylove.conexion.Conexion;
import marylove.models.Json_object_consulta;
import marylove.vista.FichaAnamnesis;
import org.json.simple.parser.ParseException;
import sun.awt.image.VSyncedBSManager;

/**
 *
 * @author Usuario
 */
public class ControladorFichaAnamnesis extends Validaciones {

    private Conexion con = new Conexion();
    private FichaAnamnesisBD modeloFichaAnamnesisBD;
    private FichaAnamnesis vistaAnamnesis;
    private HijosDB modeloHijosDB;
    private jsonDB claseJsonDB;
    private final ArrayList <Json_object_consulta> listaNacionalidades  = claseJsonDB.obtenerNacionalidades();

    public ControladorFichaAnamnesis(FichaAnamnesis vistaAnamnesis) throws ParseException {
        this.vistaAnamnesis = vistaAnamnesis;
        this.vistaAnamnesis.setVisible(true);
    }

    public void inciarControl() {
        //CONTROL DE BOTONES
        vistaAnamnesis.getBtnGuardar().addActionListener(e -> guardarDatos());

        //CONTROLADORES DE FECHAS
        vistaAnamnesis.getJdcFechaElaboracion().setCalendar(Calendar.getInstance());

        //CONTROLES DE TEXTOS
        vistaAnamnesis.getTxtCedula().addKeyListener(validarCedula(vistaAnamnesis.getTxtCedula()));

        //METODOS PARA TEXTOS
        autocompletarListaNacionalidades();
    }

    public void guardarDatos() {
    }

    public void encabezadoFichaAnamnesis() {
        if (vistaAnamnesis.getTxtNombreApellido().getText() == "") {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del niño, niña o adolescente al cuál se esta realizando la encuesta");
        } else {
            modeloHijosDB.setPersona_nombre(vistaAnamnesis.getTxtNombreApellido().getText());//Seteamos el nombre
            modeloHijosDB.setPersona_apellido(vistaAnamnesis.getTxtNombreApellido().getText());//Seteamos el apellido
            modeloHijosDB.setPersona_cedula(vistaAnamnesis.getTxtCedula().getText());

        }
    }

    public void datosIdentificacion() {

        //Como anteriormente creamos un objeto modelo de la clase HijosDB y estamos guardando datos del mismo nna entoncces procedemos a usarle mismo objeto
        modeloHijosDB.setPersona_fecha_nac(fechaBD(vistaAnamnesis.getJdcFechaNacimientoNNA().getDate().getTime()));
        modeloHijosDB.setPersona_nacionalidad(0);//INGRESAREMOS EL ID DE LA NACIONALIDAD QUE EXISTE EN EL JSON DE NACIONALIDADES

        NacimientoDB modeloNacimientoDB = new NacimientoDB();
        modeloNacimientoDB.setLugar_nacimiento(vistaAnamnesis.getTxtLugarNacNNA1().getText());
    }

    public int consultarNacionalidad() {
        return 0;
    }

    public void autocompletarListaNacionalidades() {
        TextAutoCompleter completarNacionalidad = new TextAutoCompleter(vistaAnamnesis.getTxtNacionalidadNNA());
        completarNacionalidad.addItem("Hola");
        completarNacionalidad.addItem("Hugo");

        for (int i = 0; i < listaNacionalidades.size(); i++) {
            Json_object_consulta obj = listaNacionalidades.get(i);
            completarNacionalidad.addItem(obj.getValor());
        }
    }

}
