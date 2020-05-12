/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import javax.swing.JOptionPane;
import marylove.vista.formularioR1;

/**
 *
 * @author LENOVO
 */
public class CtrlFormularioR1 {


    private formularioR1 vista;
   int resultado ;
    public void iniciarFormulario() {
        formularioR1 formu = new formularioR1();
        formu.setVisible(true);
        formu.setLocationRelativeTo(null);
        vista.getBtnGuardar().addActionListener(e->ObtenerResultado());
        
    }

    public void ObtenerResultado() {
        try {
               resultado=Integer.parseInt(vista.getCbxPregunta1().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta2().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta3().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta4().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta5().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta6().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta7().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta8().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta9().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta10().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta11().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta12().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta13().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta14().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta15().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta16().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta17().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta18().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta19().getSelectedItem().toString())+
                Integer.parseInt(vista.getCbxPregunta20().getSelectedItem().toString());
        } catch (NumberFormatException e) {
            System.out.println("Error: "+e);
        }
    }
}
