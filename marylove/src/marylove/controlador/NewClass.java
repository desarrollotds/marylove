/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import marylove.DBmodelo.jsonDB;
import static marylove.controlador.Validaciones.valida;
import marylove.models.Json_object_consulta;

/**
 *
 * @author Asus
 */
public abstract class NewClass {

    public NewClass() throws org.json.simple.parser.ParseException{
    }
        
    //DECLARAMOS LAS LISTAS QUE CONTIENEN LOS VALORES DE LOS DISTINTOS JSONS QUE USARÁ LA FICHA
    private jsonDB claseJsonDB = new jsonDB();
    protected ArrayList<Json_object_consulta> listaNacionalidades = claseJsonDB.obtenerNacionalidades();;
    protected ArrayList<Json_object_consulta> listaEstadoCivil = claseJsonDB.obtenerEstadoCivil();
    protected ArrayList<Json_object_consulta> listaInstruccionAcademica = claseJsonDB.obtenerInstruccines();
    protected ArrayList<Json_object_consulta> listaOcupaciones = claseJsonDB.obtenerOcupaciones();
    

public KeyListener validarCedula(JTextField ced) { // metodo para validar el ingreso de numeros 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char val = e.getKeyChar();
                if (val < '0' || val > '9') {
                    e.consume();
                }
                if (ced.getText().length() == 10) {
                    System.out.println(ced.getText().length());
                    if (valida(ced.getText())) {
                        System.out.println("cedula correcta");
                    } else {
                        JOptionPane.showMessageDialog(null, "Numero de cedular no válido", "Verificación", JOptionPane.WARNING_MESSAGE);
                    }
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        return kn;
    }

//VALIDACIÓN DE FECHA PARA SETEO A LA BASE DE DATOS
    public java.sql.Date fechaBD(Long fecha) {
        //Validamos que el parámetro recibido no este vacio
        if (fecha != 0) {
            try {
                //El tipo de dato "java.sql.Date" es el tipo de dato "Date" de la Base de Datos por esta razón no existe problema para setearle a la base puesto que lo transforma al formato necesario
                java.sql.Date fechaBD = new java.sql.Date(fecha);
                return fechaBD;//retornamos la fecha lista para ser seteada a la base de datos

            } catch (Exception e) {
                System.out.println("ERROR AL VALIDAR FECHA: " + fecha + " /n EXCEPCIÓN ERROR:" + e);
                return null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo validar la fecha correctamente");
            return null;
        }
    }
     
     //METODO PARA CONSULTAR EL ID DE UNA NACIONALIDAD SELECCIONADA
    public String consultarIdNacionalidad(String nacionalidad) {
        for (int i = 0; i < listaNacionalidades.size(); i++) {
            Json_object_consulta obj = listaNacionalidades.get(i);

            System.out.println("VALOR: " + obj.getValor());

            if (obj.getValor().equalsIgnoreCase(nacionalidad)) {
                System.out.println("ID DE NACIONALIDAD:" + obj.getId());
                return obj.getId() + "";
            }
        }
        return null;
    }

    //METODO PARA CONSULTAR EL ID DE UN ESTADO CIVIL SELECCIONADO
    public String consultarIdEstadoCivil(String estadocivil) {
        for (int i = 0; i < listaEstadoCivil.size(); i++) {
            Json_object_consulta obj = listaEstadoCivil.get(i);

            System.out.println("VALOR: " + obj.getValor());

            if (obj.getValor().equalsIgnoreCase(estadocivil)) {
                System.out.println("ID DE ESTADO CIVIL:" + obj.getId());
                return obj.getId() + "";
            }
        }
        return null;
    }

    //METODO PARA CONSULTAR EL ID DE UNA INSTRUCCION ACADEMICA SELECCIONADA
    public String consultarIdInstruccionAcademica(String instruccionA) {
        for (int i = 0; i < listaInstruccionAcademica.size(); i++) {
            Json_object_consulta obj = listaInstruccionAcademica.get(i);

            System.out.println("VALOR: " + obj.getValor());

            if (obj.getValor().equalsIgnoreCase(instruccionA)) {
                System.out.println("ID DE LA INSTRUCCION ACADEMICA ES:" + obj.getId());
                return obj.getId() + "";
            }
        }
        return null;
    }
    
}
