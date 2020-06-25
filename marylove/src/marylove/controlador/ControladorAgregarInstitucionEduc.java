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
    
    private FormaAgregarInstitucionEduc v;
    //variables globales para los metodos
    DireccionDB op;
    InstitucionEducativaDB it;
    int direccionId;
    DefaultComboBoxModel modelo;
    ArrayList<Json_object_consulta> jocarray;
    jsonDB jo = new jsonDB();
    public ControladorAgregarInstitucionEduc(FormaAgregarInstitucionEduc vista) throws ParseException {
    this.v=vista;
    this.v.getBtnGuardar().addActionListener(this);
    this.v.getBtnCancelar().addActionListener(this);

    llenarComboPais();
    llenarComboTipo();
    }
    public void ingresarInti(){
        try {
            it=new InstitucionEducativaDB(v.getTxtNombre().getText(), v.getTxtTelefono().getText(),
            obtenerIdLastDirec(),v.getCbxTipo().getSelectedIndex()+1);
            it.insetarInstEduc();
        } catch (SQLException ex) {
            System.out.println("No se ingreso la institucion "+ex.getMessage());;
        }
    
    }
    public void finals(){
    JOptionPane.showMessageDialog(v, "Institucion Agregada");
    }
    public void ingresarDireccion() throws SQLException{
    op=new DireccionDB(v.getTxtCalle().getText(), v.getTxtInterseccion().getText(), 
    v.getTxtNCasa().getText(),v.getTxtBarrio().getText() ,v.getTxtParroquia().getText() ,
    v.getTxtCiudad().getText(),v.getTxtReferencia().getText(), v.getTxtProvincia().getText(),
    v.getCbxPais().getSelectedItem().toString(),true);
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
        v.getCbxPais().setModel(modelo);
    
    }
     public void llenarComboTipo() throws ParseException{
     modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerTipo_Insti();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxTipo().setModel(modelo);
    
    }
     public boolean validaciones(){
         if(!v.getTxtNombre().getText().matches("[0-9]*")){
            if(v.getTxtTelefono().getText().matches("[0-9]*")){
                return true;
              }else{
         JOptionPane.showMessageDialog(v,"Ingreso: Solo números...");
         v.getTxtNombre().setText("");
         return false;
         }
         }else{
         JOptionPane.showMessageDialog(v,"Ingreso: Solo letras...");
         v.getTxtNombre().setText("");
         return false;
         }
//     
     
     
     }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(v.getBtnGuardar())){
            if(validaciones()){
                try {
                    ingresarDireccion();
                    ingresarInti();
                    finals();
                    limpiar();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAgregarInstitucionEduc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(e.getSource().equals(v.getBtnCancelar())){
        v.dispose();
        }
    }
    public void limpiar() {
        v.getTxtNombre().setText("");
        v.getTxtTelefono().setText("");
        v.getCbxTipo().setSelectedIndex(0);
        v.getTxtCalle().setText("");
        v.getTxtNCasa().setText("");
        v.getTxtParroquia().setText("");
        v.getTxtReferencia().setText("");
        v.getTxtInterseccion().setText("");
        v.getTxtBarrio().setText("");
        v.getTxtCiudad().setText("");
        v.getTxtProvincia().setText("");
        v.getCbxPais().setSelectedIndex(0);
    }
    
}
