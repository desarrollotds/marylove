/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import marylove.vista.FichaEgreso;

/**
 *
 * @author usuario
 */
public class ControladorFichaEgreso extends Validaciones implements ActionListener {

    private FichaEgreso fichaegreso;
    private Validaciones validaciones;

    public ControladorFichaEgreso(FichaEgreso fichaegreso) {
        this.fichaegreso = fichaegreso;
        this.fichaegreso.setVisible(true);
        this.fichaegreso.setResizable(false);
        this.fichaegreso.setLocationRelativeTo(null);
        this.fichaegreso.getBtnGuardar().addActionListener(this);
        this.fichaegreso.getBtnCancelar().addActionListener(this);
        ObtenerFecha();
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fichaegreso.getBtnGuardar()) {
            JOptionPane.showMessageDialog(fichaegreso, "Accion agregada");

        }
        if (e.getSource() == this.fichaegreso.getBtnCancelar()) {
            this.fichaegreso.dispose();
        }
    }

    public void ObtenerFecha() {
        try {   
            this.fichaegreso.getTxtFecha().setText(Fecha());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fichaegreso, e);
        }

    }

   

}
