/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import marylove.vista.FormaAgregarInstitucionEduc;

/**
 *
 * @author Unos conejos muy sospechosos
 */
public class ControladorAgregarInstitucionEduc implements ActionListener{
    
    FormaAgregarInstitucionEduc vista;
    
    public ControladorAgregarInstitucionEduc(FormaAgregarInstitucionEduc vista) {
    this.vista=vista;
    this.vista.getBtnGuardar().addActionListener(this);
    this.vista.getBtnCancelar().addActionListener(this);
    }
    
    public void ingresarDireccion(){
    
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.getBtnGuardar())){
        if(vista.getTxtTelefono().getText().matches("[0-9]*")){
        
        }
        }
    }
   
    
}
