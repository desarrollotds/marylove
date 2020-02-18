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
import javax.swing.SpinnerNumberModel;
import marylove.vista.FormaAgregarArticulos;

/**
 *
 * @author usuario
 */
public class ControladorAgregarArticulos extends Validaciones implements ActionListener{
    private FormaAgregarArticulos formaagregaraticulos;

    public ControladorAgregarArticulos(FormaAgregarArticulos formaagregaraticulos) {
        this.formaagregaraticulos = formaagregaraticulos;
        this.formaagregaraticulos.setVisible(true);
        this.formaagregaraticulos.setResizable(false);
        this.formaagregaraticulos.setLocationRelativeTo(null);
        this.formaagregaraticulos.getBtnCancelar().addActionListener(this);
        this.formaagregaraticulos.getBtnGuardar().addActionListener(this);
        Valores();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.formaagregaraticulos.getBtnCancelar()){
            this.formaagregaraticulos.dispose();
        }
        if(e.getSource()==this.formaagregaraticulos.getBtnGuardar()){
            JOptionPane.showMessageDialog(formaagregaraticulos, "Accion agregada");
        }
    }
    
    public void Valores(){
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMaximum(10);
        nm.setMinimum(0);
        this.formaagregaraticulos.getSpnCantidad().setModel(nm);
    }
   
    
    
   
    
}
