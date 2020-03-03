/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

import marylove.models.Cita;
import marylove.vista.FichaAgendamientoCitas;
import marylove.vista.VistaCita;

/**
 *
 * @author Usuario
 */
public class ControladorCitas extends Validaciones implements ActionListener{
    
    private VistaCita vistaCita;
    private Cita modeloCita;

    @Override
    public void actionPerformed(ActionEvent e) {
    }
     
    public ControladorCitas(VistaCita vistaCita) {
        this.vistaCita = vistaCita;
//        this.vistaCita.setVisible(true);
//        this.vistaCita.setResizable(false);
//        this.vistaCita.setLocationRelativeTo(null);
    }
    
    public void iniciarComponentes(){
        vistaCita.getBtnCrearCita().addActionListener(e -> crearCita());
    }

    public void crearCita(){
       //String nombreVictima= vistaCita.getTxt_NombreVictima().getText().toString();
       String codVictima = vistaCita.getTxt_codigoVictima().getText().toString();
       modeloCita.setCita_fecha(vistaCita.getDtc_FechaCita().toString());
    //   String hora = vistaCita.getSprHoras().toString()+":"+vistaCita.getSprMinutos().toString();
     //  modeloCita.setCita_hora(hora);
       //modeloCita.setLlamada_codigo();
       String nom_psicologo = vistaCita.getCbxPsicologos().getSelectedItem().toString();
       
    }
    
}
