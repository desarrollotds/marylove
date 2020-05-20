/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import marylove.vista.VistaRuta;

/**
 *
 * @author usuario
 */
public class ControladorRuta implements ActionListener {

    private VistaRuta vr;

    public ControladorRuta(VistaRuta vr) {
        this.vr = vr;
        this.vr.setVisible(true);
        this.vr.setLocationRelativeTo(null);
        this.vr.setResizable(true);
        this.vr.getBtnGenerar().addActionListener(this);
        this.vr.getBtnBuscar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vr.getBtnGenerar())) {

        }
        if (e.getSource().equals(this.vr.getBtnBuscar())) {
            
        }
    }
    
    public void obtenerRuta(){
        JFileChooser ruta = new JFileChooser();
        int opcion = ruta.showSaveDialog(this.vr);
         if (opcion == JFileChooser.APPROVE_OPTION) {
            File file = ruta.getSelectedFile();
            this.vr.getTxtRuta().setText(file.toString());
        }
           
    }

}
