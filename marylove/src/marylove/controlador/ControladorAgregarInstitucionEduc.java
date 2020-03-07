/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.InstitucionEducativaDB;
import marylove.vista.FormaAgregarInstitucionEduc;

/**
 *
 * @author Unos conejos muy sospechosos
 */
public class ControladorAgregarInstitucionEduc implements ActionListener{
    
    FormaAgregarInstitucionEduc vista;
    //variables globales para los metodos
    DireccionDB op;
    InstitucionEducativaDB it;
    int direccionId;
    public ControladorAgregarInstitucionEduc(FormaAgregarInstitucionEduc vista) {
    this.vista=vista;
    this.vista.getBtnGuardar().addActionListener(this);
    this.vista.getBtnCancelar().addActionListener(this);
    }
    public void ingresarInti() throws SQLException{
     it=new InstitucionEducativaDB(vista.getTxtNombre().getText(), vista.getTxtTelefono().getText(),
     obtenerIdLastDirec(),vista.getCbxTipo().getSelectedIndex()+1);
     it.insetarInstEduc();
    
    }
    public void finals(){
    vista.getTxtBarrio().setText("");
    vista.getTxtCalle().setText("");
    vista.getTxtCiudad().setText("");
    vista.getTxtInterseccion().setText("");
    vista.getTxtNCasa().setText("");
    vista.getTxtNombre().setText("");
    vista.getTxtPais().setText("");
    vista.getTxtParroquia().setText("");
    vista.getTxtProvincia().setText("");
    vista.getTxtReferencia().setText("");
    vista.getTxtTelefono().setText("");
    JOptionPane.showMessageDialog(vista, "Institucion Agregada");
    
    }
    public void ingresarDireccion(){
    op=new DireccionDB(vista.getTxtCalle().getText(), vista.getTxtInterseccion().getText(), 
    vista.getTxtNCasa().getText(),vista.getTxtBarrio().getText() ,vista.getTxtParroquia().getText() ,
    vista.getTxtCiudad().getText(),vista.getTxtReferencia().getText(), vista.getTxtProvincia().getText(),
    vista.getTxtPais().getText(),true);
    op.insertaDireccion();
    }
    public int obtenerIdLastDirec() throws SQLException{
        op=new DireccionDB();
        direccionId=op.obtenerIdDireccion();
        return direccionId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.getBtnGuardar())){
        if(vista.getTxtTelefono().getText().matches("[0-9]*")){
            try {
                ingresarDireccion();
                ingresarInti();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAgregarInstitucionEduc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        if(e.getSource().equals(vista.getBtnCancelar())){
        vista.dispose();
        }
    }
   
    
}
