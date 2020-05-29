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
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.InstitucionEducativaDB;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.personaDB;
import marylove.DBmodelo.victimaDB;
import marylove.models.InstitucionEducativa;
import marylove.models.Json_object_consulta;
import marylove.vista.FormaAgregarHijos;
import marylove.vista.FormaAgregarInstitucionEduc;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Asus
 */
public class ControladorAgregarHijos extends Validaciones implements ActionListener {

    private FormaAgregarHijos v;
    HijosDB hdb;
    victimaDB vdb;
    personaDB pdb;
    InstitucionEducativaDB iedb;
    ArrayList<InstitucionEducativa> arrayInstiEduc;
    DefaultComboBoxModel modelo;
    jsonDB jo = new jsonDB();
    ArrayList<Json_object_consulta> jocarray;

    public ControladorAgregarHijos(FormaAgregarHijos v) throws ParseException, SQLException {
        this.v = v;
        this.v.getBtnGuardar().addActionListener(this);
        this.v.getBtnAgregarIntiEdu().addActionListener(this);
        this.v.getBtnCancelar().addActionListener(this);
        comboAnioEscolar();
        comboNivelAcademico();
        llenarComboInstiEduc();
    }

    public void llenarComboInstiEduc() throws SQLException {
        modelo = new DefaultComboBoxModel();
        iedb = new InstitucionEducativaDB();
        arrayInstiEduc = iedb.instituciones();
        for (InstitucionEducativa o : arrayInstiEduc) {
            modelo.addElement(o.getInst_nombre());

        }
        v.getCbxIntiEducativa().setModel(modelo);
    }

    public void comboAnioEscolar() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerAnioEscolar();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxAnioEscolar().setModel(modelo);

    }

    public void comboNivelAcademico() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerNivel_academico();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxNivelAcademico().setModel(modelo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        vdb = new victimaDB();
        pdb = new personaDB();
        if (e.getSource().equals(v.getBtnAgregarIntiEdu())) {
            try {
                System.out.println("entra");
                FormaAgregarInstitucionEduc faie = new FormaAgregarInstitucionEduc();
                ControladorAgregarInstitucionEduc caie = new ControladorAgregarInstitucionEduc(faie);
                faie.setVisible(true);
                faie.setLocationRelativeTo(null);
                faie.setResizable(true);
                llenarComboInstiEduc();

            } catch (ParseException ex) {
                Logger.getLogger(ControladorAgregarHijos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAgregarHijos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(v.getBtnCancelar())) {
            System.out.println("entra");
            v.dispose();
        }

        //
        if (e.getSource().equals(v.getBtnGuardar())) {
            if (v.getTxtCedula().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Cedula", JOptionPane.WARNING_MESSAGE);
            } else {
                if (v.getTxtNombres().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Nombre", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (v.getTxtApellidos().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Apellido", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (v.getDcFechaNacimiento().getDate() == null) {
                            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Fecha", JOptionPane.WARNING_MESSAGE);
                        } else {
                            if (v.getCbxSexo().getSelectedIndex() == 0) {
                                JOptionPane.showMessageDialog(null, "Campos Vacios", "Selecione sexo", JOptionPane.WARNING_MESSAGE);
                            } else {
//                                if (v.getCbxIntiEducativa().getSelectedIndex() == 0) {
//                                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Selecione Institucion Educativa", JOptionPane.WARNING_MESSAGE);
//                                } else {

                                long fecha = v.getDcFechaNacimiento().getDate().getTime();
//            hdb =new HijosDB(v.getCbxNivelAcademico().getSelectedIndex() + 1,v.getCbxIntiEducativa().getSelectedIndex() + 1,  v.getTxtCedula().getText(), v.getTxtNombres().getText(), 
//                    v.getTxtApellidos().getText(),fechaBD(fecha).getDate(), v.getCbxSexo().getSelectedItem().toString().charAt(1)); 
                                hdb = new HijosDB(pdb.getPersona_codigo_static(), vdb.getCodigo_victima_static(),
                                        v.getCbxAnioEscolar().getSelectedItem().toString(),
                                        v.getCbxIntiEducativa().getSelectedIndex() + 1,
                                        v.getTxtCedula().getText().toString(), v.getTxtNombres().getText().toString(),
                                        v.getTxtApellidos().getText().toString(),
                                        fechaBD(fecha),
                                        v.getCbxSexo().getSelectedItem().toString().charAt(0));
                                try {
                                    System.out.println(marylove.DBmodelo.HijosDB.codigopersona);
                                    hdb.agregarPrsonaHijo();
                                    hdb.insetarHijo();
                                    JOptionPane.showMessageDialog(this.v, "Hijo registrado correctamente");
                                    v.getCbxAnioEscolar().setSelectedIndex(0);
                                    v.getCbxIntiEducativa().setSelectedIndex(0);
                                    v.getTxtCedula().setText("");
                                    v.getTxtApellidos().setText("");
                                    v.getTxtNombres().setText("");
                                    v.getCbxSexo().setSelectedIndex(0);

                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(this.v, "Ocurrió un error al registrar el Hijo");
                                    Logger.getLogger(ControladorAgregarHijos.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
