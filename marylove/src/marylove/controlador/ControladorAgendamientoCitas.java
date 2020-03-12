/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import marylove.DBmodelo.psicologoDB;
import marylove.vista.FichaAgendamientoCitas;

/**
 *
 * @author Unos conejos muy Sospechosos
 */
public class ControladorAgendamientoCitas implements ActionListener{
    ArrayList<String> psicologos;
    FichaAgendamientoCitas vista;
    DefaultComboBoxModel modelo;
    psicologoDB i;
    
    public ControladorAgendamientoCitas(FichaAgendamientoCitas vista ) throws SQLException {
    this.vista=vista;
//    llenarComboPsicologo();
    this.vista.getBtnGuardar().addActionListener(this);
    this.vista.getBtnCancelar().addActionListener(this);
    
    }
    public void llenarComboPsicologo() throws SQLException{
    i= new psicologoDB();
          psicologos=i.obtenerPsicologicos();
          modelo = new DefaultComboBoxModel();
          for(String o: psicologos){
              modelo.addElement(o);
          }
          vista.getCbxPsicologa().setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
    
}
