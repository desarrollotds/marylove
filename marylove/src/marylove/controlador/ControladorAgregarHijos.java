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
import marylove.DBmodelo.HijosDB;
import marylove.vista.FormaAgregarHijos;
import marylove.controlador.ControladorRegistroReferencia;

/**
 *
 * @author Asus
 */
public class ControladorAgregarHijos extends Validaciones implements ActionListener {
    FormaAgregarHijos v;
    HijosDB hdb;
    public static int victimacodigo;
    public ControladorAgregarHijos(FormaAgregarHijos v) {
        this.v=v;
        this.v.getBtnGuardar().addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(v.getBtnGuardar())) {
            long fecha=v.getDcFechaNacimiento().getDate().getTime();
//            hdb =new HijosDB(v.getCbxNivelAcademico().getSelectedIndex() + 1,v.getCbxIntiEducativa().getSelectedIndex() + 1,  v.getTxtCedula().getText(), v.getTxtNombres().getText(), 
//                    v.getTxtApellidos().getText(),fechaBD(fecha).getDate(), v.getCbxSexo().getSelectedItem().toString().charAt(1)); 
            hdb= new HijosDB(marylove.DBmodelo.HijosDB.codigopersona, marylove.DBmodelo.victimaDB.codigo_victima, v.getCbxAnioEscolar().getSelectedItem().toString(), v.getCbxIntiEducativa().getSelectedIndex() + 1 , v.getTxtCedula().toString(), v.getTxtNombres().toString(), v.getTxtApellidos().toString(), fechaBD(fecha), v.getCbxSexo().getSelectedItem().toString().charAt(1));
            try {
                System.out.println(marylove.DBmodelo.HijosDB.codigopersona); 
                hdb.agregarPrsonaHijo();
                hdb.insetarHijo();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAgregarHijos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
