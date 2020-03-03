/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import marylove.DBmodelo.personaDB;
import marylove.DBmodelo.persona_llamadaDB;
import marylove.vista.Ficharegistroyreferencia;

/**
 *
 * @author Asus
 */
public class ControladorRegistroReferencia extends Validaciones implements ActionListener{
    Ficharegistroyreferencia vista;
    private static int ID_persona_llamada;
    persona_llamadaDB pldb;
   
    public ControladorRegistroReferencia(Ficharegistroyreferencia vista) {
        this.vista=vista;
        vista.getBtnAgregarAgresores().addActionListener(this);
        vista.getBtnAgregarHijos().addActionListener(this);
        vista.getBtnCancelar().addActionListener(this);
        vista.getBtnGuardar().addActionListener(this);
        
        
    }
    public void DatosPersonales(){
        personaDB personBD=new personaDB();
        
    }


    
    public void Iniciable(){
       vista.getTxtNombrePersona().addKeyListener(validarLetras(vista.getTxtNombrePersona()));
  
               
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(vista.getBtnGuardar())) {
            
        }if (ae.getSource().equals(vista.getBtnCancelar())) {
            
        }if (ae.getSource().equals(vista.getBtnAgregarAgresores())) {
            
        }if (ae.getSource().equals(vista.getBtnAgregarHijos())) {
            
        }
    }
    
}
