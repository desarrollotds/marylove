package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import marylove.vista.FormaAgregarArticulosVictima;

public class ControladorAgregarArticulosVictima extends Validaciones implements ActionListener{
    
    private FormaAgregarArticulosVictima agregararticulos;

    public ControladorAgregarArticulosVictima(FormaAgregarArticulosVictima agregararticulos) {
        this.agregararticulos = agregararticulos;
        this.agregararticulos.setVisible(true);
        this.agregararticulos.setResizable(false);
        this.agregararticulos.setLocationRelativeTo(null);
        this.agregararticulos.getBtnCancelar().addActionListener(this);
        this.agregararticulos.getBtnGuardar().addActionListener(this);
        ValoresSpinner(this.agregararticulos.getSpnCantidad(),10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.agregararticulos.getBtnCancelar()) {
            this.agregararticulos.dispose();
        }
        if (e.getSource() == this.agregararticulos.getBtnGuardar()) {
            JOptionPane.showMessageDialog(agregararticulos, "Accion agregada");

        }
       }
    
    
    
}
