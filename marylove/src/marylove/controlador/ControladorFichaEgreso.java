/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import marylove.vista.FichaEgreso;

/**
 *
 * @author usuario
 */
public class ControladorFichaEgreso implements ActionListener {
    private FichaEgreso fichaegreso;

    public ControladorFichaEgreso(FichaEgreso fichaegreso) {
        this.fichaegreso = fichaegreso;
        this.fichaegreso.setVisible(true);
        this.fichaegreso.setResizable(false);
        this.fichaegreso.setLocationRelativeTo(null);
        this.fichaegreso.getBtnGuardar().addActionListener(this);
        this.fichaegreso.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.fichaegreso.getBtnGuardar()){
            JOptionPane.showMessageDialog(fichaegreso, "Accion agregada");
            
        }
        if(e.getSource()==this.fichaegreso.getBtnCancelar()){
            this.fichaegreso.dispose();
        }
    }
    
    
    
}
