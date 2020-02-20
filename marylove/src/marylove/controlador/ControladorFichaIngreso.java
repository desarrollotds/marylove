/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import marylove.models.Ingreso;
import marylove.vista.FichaIngreso;
import marylove.vista.FormaAgregarArticulosPersonal;
import marylove.vista.FormaAgregarArticulosVictima;

/**
 *
 * @author usuario
 */
public class ControladorFichaIngreso implements ActionListener {
    private FichaIngreso fichaingreso;
    private Ingreso ficha_ingreso_model;

    public ControladorFichaIngreso() {
    }

    public ControladorFichaIngreso(FichaIngreso fichaingreso) {
        this.fichaingreso = fichaingreso;
        this.fichaingreso.setVisible(true);
        this.fichaingreso.setResizable(false);
        this.fichaingreso.setLocationRelativeTo(null);
        this.fichaingreso.getBtnAgregarArticulosVictima().addActionListener(this);
        this.fichaingreso.getBtnAgregarArticulosFundacion().addActionListener(this);
        this.fichaingreso.getBtnGuardar().addActionListener(this);
        this.fichaingreso.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Se llama a la forma para agregar articulos
        if(e.getSource()==this.fichaingreso.getBtnAgregarArticulosVictima()){
          LammarFormaArticulosVictima();
        }
        if(e.getSource()==this.fichaingreso.getBtnAgregarArticulosFundacion()){
            LLamarFormaArticulosPersonal();
        }
        //Se validan acciones para botones guardar y cancelar
        if(e.getSource()==this.fichaingreso.getBtnGuardar()){
             JOptionPane.showMessageDialog(fichaingreso, "Accion agregada");
            
        }
        if(e.getSource()==this.fichaingreso.getBtnCancelar()){
            this.fichaingreso.dispose();
            
        }
    }
    
    public void LLamarFormaArticulosPersonal(){
         FormaAgregarArticulosPersonal agregararticulos = new FormaAgregarArticulosPersonal();
         ControladorAgregarArticulosPersonal controladoragregararticulos = new ControladorAgregarArticulosPersonal(agregararticulos);
    }
    
    public void LammarFormaArticulosVictima(){
        FormaAgregarArticulosVictima agregararticulos = new FormaAgregarArticulosVictima();
        ControladorAgregarArticulosVictima controladoragregararticulos = new ControladorAgregarArticulosVictima(agregararticulos);
        
    }
    public void GuardarDatos(){ 
        ficha_ingreso_model = new Ingreso();
        ficha_ingreso_model.setPersonal_codigo(1);
        ficha_ingreso_model.setVictima_codigo(1);
        ficha_ingreso_model.setAsignacion_dormitorio(this.fichaingreso.getTxtDormitorio().getText().toString());
        ficha_ingreso_model.setReferidapor(this.fichaingreso.getTxaReferida().getText().toString());
    }
    
    
   
    
    
}
