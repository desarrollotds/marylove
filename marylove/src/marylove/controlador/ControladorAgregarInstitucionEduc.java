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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.InstitucionEducativaDB;
import marylove.DBmodelo.jsonDB;
import marylove.models.Json_object_consulta;
import marylove.vista.FormaAgregarInstitucionEduc;
import org.json.simple.parser.ParseException;

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
    DefaultComboBoxModel modelo;
    ArrayList<Json_object_consulta> jocarray;
    jsonDB jo = new jsonDB();
    public ControladorAgregarInstitucionEduc(FormaAgregarInstitucionEduc vista) throws ParseException {
    this.vista=vista;
    this.vista.getBtnGuardar().addActionListener(this);
    this.vista.getBtnCancelar().addActionListener(this);

    llenarComboPais();
    llenarComboTipo();
    }
    public void ingresarInti() throws SQLException{
     it=new InstitucionEducativaDB(vista.getTxtNombre().getText(), vista.getTxtTelefono().getText(),
     obtenerIdLastDirec(),vista.getCbxTipo().getSelectedIndex()+1);
     it.insetarInstEduc();
    
    }
    public void finals(){
    JOptionPane.showMessageDialog(vista, "Institucion Agregada");
    vista.dispose();
    }
    public void ingresarDireccion(){
    op=new DireccionDB(vista.getTxtCalle().getText(), vista.getTxtInterseccion().getText(), 
    vista.getTxtNCasa().getText(),vista.getTxtBarrio().getText() ,vista.getTxtParroquia().getText() ,
    vista.getTxtCiudad().getText(),vista.getTxtReferencia().getText(), vista.getTxtProvincia().getText(),
    vista.getCbxPais().getSelectedItem().toString(),true);
    op.insertaDireccion();
    }
    public int obtenerIdLastDirec() throws SQLException{
        op=new DireccionDB();
        direccionId=op.obtenerIdDireccion();
        return direccionId;
    }
    public void llenarComboPais() throws ParseException{
     modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerNacionalidades();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxPais().setModel(modelo);
    
    }
     public void llenarComboTipo() throws ParseException{
     modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerTipo_Insti();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxTipo().setModel(modelo);
    
    }
     public boolean validaciones(){
         if(!vista.getTxtNombre().getText().matches("[0-9]*")){
            if(vista.getTxtTelefono().getText().matches("[0-9]*")){
                return true;
              }else{
         JOptionPane.showMessageDialog(vista,"Ingreso: Solo números...");
         vista.getTxtNombre().setText("");
         return false;
         }
         }else{
         JOptionPane.showMessageDialog(vista,"Ingreso: Solo letras...");
         vista.getTxtNombre().setText("");
         return false;
         }
//     
     
     
     }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.getBtnGuardar())){
            if(validaciones()){
                try {
                    ingresarDireccion();
                    ingresarInti();
                    finals();
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
