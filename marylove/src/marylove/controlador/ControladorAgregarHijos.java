/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import marylove.DBmodelo.ArticulosEntregadosDB;
import marylove.DBmodelo.ArticulosEntregadosPersonalDB;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.IngresoDB;
import marylove.DBmodelo.InstitucionEducativaDB;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.personaDB;
import marylove.DBmodelo.victimaDB;
import marylove.models.ArticulosEntregados;
import marylove.models.ArticulosEntregadosPersonal;
import marylove.models.InstitucionEducativa;
import marylove.models.Json_object_consulta;
import marylove.vista.FichaIngreso;
import marylove.vista.FormaAgregarArticulosPersonal;
import marylove.vista.FormaAgregarArticulosVictima;
import marylove.vista.FormaAgregarHijos;
import marylove.vista.FormaAgregarInstitucionEduc;
import marylove.vista.VistaFamiliares;
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
    InstitucionEducativaDB iedb = new InstitucionEducativaDB();
    ArrayList<InstitucionEducativa> arrayInstiEduc;
    DefaultComboBoxModel modelo;
    jsonDB jo = new jsonDB();
    ArrayList<Json_object_consulta> jocarray;
    
    FormaAgregarArticulosVictima f = new FormaAgregarArticulosVictima();
    ArticulosEntregados ae = new ArticulosEntregados();
    ArticulosEntregadosDB aed = new ArticulosEntregadosDB();
    ArticulosEntregadosPersonal aep = new ArticulosEntregadosPersonal();
    ArticulosEntregadosPersonalDB aepb = new ArticulosEntregadosPersonalDB();
    FichaIngreso fi = new FichaIngreso();
    FormaAgregarArticulosPersonal faap = new FormaAgregarArticulosPersonal();
    IngresoDB idb = new IngresoDB();
    FormaAgregarHijos fah = new FormaAgregarHijos();
    VistaFamiliares vf = new VistaFamiliares();
//    ControladorFichaIngreso cotIng = new ControladorFichaIngreso(f, ae, aed, aep, aepb, fi, faap, idb, fah, vf);
    int control = 0;
    FormaAgregarInstitucionEduc faie = new FormaAgregarInstitucionEduc();

    public ControladorAgregarHijos(FormaAgregarHijos v) throws ParseException, SQLException {
        this.v = v;
        this.v.getBtnGuardar().addActionListener(this);
        this.v.getBtnAgregarIntiEdu().addActionListener(this);
        this.v.getBtnCancelar().addActionListener(this);
        faie.getBtnGuardar().addActionListener(e -> {
            try {
                llenarComboInstiEduc();
            } catch (SQLException ex) {
                System.out.println("error al llenar instituciones " + ex.getMessage());;
            }
        });
        comboAnioEscolar();
        comboNivelAcademico();
        llenarComboInstiEduc();
    }
    
    public void llenarComboInstiEduc() throws SQLException {
        modelo = new DefaultComboBoxModel();

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
                if (control == 0) {
                    ControladorAgregarInstitucionEduc caie = new ControladorAgregarInstitucionEduc(faie);
                    control++;
                }
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
            ControladorFichaIngreso.ban=0;
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
                                try {
                                    if (ControladorFichaIngreso.ban == 1) {
                                        long fecha = v.getDcFechaNacimiento().getDate().getTime();

                                        iedb = new InstitucionEducativaDB();
                                        hdb = new HijosDB(pdb.getPersona_codigo_static(),
                                                ControladorFichaIngreso.codVic,
                                                v.getCbxAnioEscolar().getSelectedItem().toString(),
                                                iedb.insti_id(v.getCbxIntiEducativa().getSelectedItem().toString()),
                                                v.getTxtCedula().getText().toString(), v.getTxtNombres().getText().toString(),
                                                v.getTxtApellidos().getText().toString(),
                                                fechaBD(fecha),
                                                v.getCbxSexo().getSelectedItem().toString().charAt(0));
                                        
                                    } else {
                                        long fecha = v.getDcFechaNacimiento().getDate().getTime();

                                        iedb = new InstitucionEducativaDB();
                                        hdb = new HijosDB(pdb.getPersona_codigo_static(),
                                                vdb.getCodigo_victima_static(),
                                                v.getCbxAnioEscolar().getSelectedItem().toString(),
                                                iedb.insti_id(v.getCbxIntiEducativa().getSelectedItem().toString()),
                                                v.getTxtCedula().getText().toString(), v.getTxtNombres().getText().toString(),
                                                v.getTxtApellidos().getText().toString(),
                                                fechaBD(fecha),
                                                v.getCbxSexo().getSelectedItem().toString().charAt(0));
                                    }
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
                                } catch (SQLException ex) {
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
