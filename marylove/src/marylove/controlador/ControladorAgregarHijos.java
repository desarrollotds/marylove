/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import marylove.vista.FormaAgregarHijos;

/**
 *
 * @author Asus
 */
public class ControladorAgregarHijos implements ActionListener {
    FormaAgregarHijos v;
    public ControladorAgregarHijos(FormaAgregarHijos v) {
        this.v=v;
        this.v.getBtnGuardar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    
}
