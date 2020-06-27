/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.DBmodelo.EncuestaDB;
import marylove.DBmodelo.Escala_prevencion_riesgoDB;
import marylove.DBmodelo.PreguntasDB;
import marylove.DBmodelo.psicologoDB;
import marylove.DBmodelo.victimaDB;
import marylove.DBmodelo.x_respuestasDB;
import marylove.models.Victima;
import marylove.vista.FichaFormularioR3;

/**
 *
 * @author vasquez
 */
public class controlFormularioR3 implements ActionListener {

    x_respuestasDB xrdb;
    EncuestaDB edb;
    Escala_prevencion_riesgoDB eprdb;
    PreguntasDB pdb;
    private FichaFormularioR3 v;
    private int total = 0;
    victimaDB vdb;

    Victima vic = new Victima();

    //incio de guardado--------------------------------------------------------------------------------------------------------------------------------
    //metodo de guaradado en la primera tabla
    public boolean guardar_escala_prevencion_riesgos() throws SQLException {
        boolean real = false;
        psicologoDB psdb = new psicologoDB();
        int pID = psdb.obtener_id(C_Login.personal_cod);
        if (pID != 0 && vic.getVictima_codigo() != 0) {
            eprdb = new Escala_prevencion_riesgoDB(vic.getVictima_codigo(), pID);
            if (eprdb.insertar_escala_prevencion_riesgo()) {
                real = true;
            }
        }
        return real;

    }

    //metodo de guardado en la segunda tabla
    public void guardar_encuesta() throws SQLException {
        edb = new EncuestaDB(Escala_prevencion_riesgoDB.getEsca_preve_ries_static(), 3);
        edb.insertar_encuesta();
    }

    //metodo de guardado en la tercera tabla
    public void guardar_preguntas() throws SQLException {
        pdb = new PreguntasDB();
        xrdb = new x_respuestasDB();
        int p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0, p7 = 0, p8 = 0, p9 = 0, p10 = 0;
        int p11 = 0, p12 = 0, p13 = 0, p14 = 0, p15 = 0, p16 = 0, p17 = 0, p18 = 0, p19 = 0;
        String r1 = "", r2 = "", r3 = "", r4 = "", r5 = "", r6 = "", r7 = "", r8 = "", r9 = "", r10 = "",
                r11 = "", r12 = "", r13 = "", r14 = "", r15 = "", r16 = "", r17 = "", r18 = "", r19 = "";

        p1 = pdb.obtener_id(v.getLblPregunta1().getText(), 3);
        r1 = v.getCbxResp1().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p2 = pdb.obtener_id(v.getLblPregunta2().getText(), 3);
        r2 = v.getCbxResp2().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p3 = pdb.obtener_id(v.getLblPregunta3().getText(), 3);
        r3 = v.getCbxResp3().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p4 = pdb.obtener_id(v.getLblPregunta4().getText(), 3);
        r4 = v.getCbxResp4().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p5 = pdb.obtener_id(v.getLblPregunta5().getText(), 3);
        r5 = v.getCbxResp5().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p6 = pdb.obtener_id(v.getLblPregunta6().getText(), 3);
        r6 = v.getCbxResp6().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p7 = pdb.obtener_id(v.getLblPregunta7().getText(), 3);
        r7 = v.getCbxResp7().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p8 = pdb.obtener_id(v.getLblPregunta8().getText(), 3);
        r8 = v.getCbxResp8().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p9 = pdb.obtener_id(v.getLblPregunta9().getText(), 3);
        r9 = v.getCbxResp9().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p10 = pdb.obtener_id(v.getLblPregunta10().getText(), 3);
        r10 = v.getCbxResp10().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p11 = pdb.obtener_id(v.getLblPregunta11().getText(), 3);
        r11 = v.getCbxResp11().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p12 = pdb.obtener_id(v.getLblPregunta12().getText(), 3);
        r12 = v.getCbxResp12().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p13 = pdb.obtener_id(v.getLblPregunta13().getText(), 3);
        r13 = v.getCbxResp13().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p14 = pdb.obtener_id(v.getLblPregunta14().getText(), 3);
        r14 = v.getCbxResp14().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p15 = pdb.obtener_id(v.getLblPregunta15().getText(), 3);
        r15 = v.getCbxResp15().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p16 = pdb.obtener_id(v.getLblPregunta16().getText(), 3);
        r16 = v.getCbxResp16().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p17 = pdb.obtener_id(v.getLblPregunta17().getText(), 3);
        r17 = v.getCbxResp17().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p18 = pdb.obtener_id(v.getLblPregunta18().getText(), 3);
        r18 = v.getCbxResp18().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p19 = pdb.obtener_id(v.getLblPregunta19().getText(), 3);
        r19 = v.getCbxResp19().getSelectedItem().toString();

        //----------------------------------------------------------------------
        xrdb.insert_x_respuesta_r3(EncuestaDB.getEncuesta_codigo_static(), p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19,
                r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public void cancelar() {
        edb = new EncuestaDB();
        edb.update_estado(false, EncuestaDB.getEncuesta_codigo_static());
        v.dispose();

    }

    public void guargar_total() throws SQLException {
        edb = new EncuestaDB(total);
        edb.update_total_encuesta(EncuestaDB.getEncuesta_codigo_static());
        JOptionPane.showMessageDialog(null, "Datos Guardados");
    }

    public controlFormularioR3(FichaFormularioR3 vista) {
        this.v = vista;
        vista.getTxtFR3total().setEnabled(false);
    }

    public void iniciarCtr() {
        v.getBtn_buscar().addActionListener(e -> buscar2());
        v.getBtnFR3calcular().addActionListener(this);
        v.getBtnCancelar().addActionListener(this);
        v.getBtnGuardar().addActionListener(e -> guardar());
        v.getBtn_limpieza().addActionListener(this);
        v.getLabFR3refe().setText("--------");
        v.getPnlDescripcion().setVisible(false);
        v.getPnlResultados().setVisible(false);
        v.getTxtcolor().setVisible(false);
//         victimaDB.setCodigo_victima_static(1);
//        C_Login.personal_cod=1;
    }

    public int obtenerTotal() {
        total = 0;
        total = total + v.getCbxResp1().getSelectedIndex();
        total = total + v.getCbxResp2().getSelectedIndex();
        total = total + v.getCbxResp3().getSelectedIndex();
        total = total + v.getCbxResp4().getSelectedIndex();
        total = total + v.getCbxResp5().getSelectedIndex();
        total = total + v.getCbxResp6().getSelectedIndex();
        total = total + v.getCbxResp7().getSelectedIndex();
        total = total + v.getCbxResp8().getSelectedIndex();
        total = total + v.getCbxResp9().getSelectedIndex();
        total = total + v.getCbxResp10().getSelectedIndex();
        total = total + v.getCbxResp11().getSelectedIndex();
        total = total + v.getCbxResp12().getSelectedIndex();
        total = total + v.getCbxResp13().getSelectedIndex();
        total = total + v.getCbxResp14().getSelectedIndex();
        total = total + v.getCbxResp15().getSelectedIndex();
        total = total + v.getCbxResp16().getSelectedIndex();
        total = total + v.getCbxResp17().getSelectedIndex();
        total = total + v.getCbxResp18().getSelectedIndex();
        total = total + v.getCbxResp19().getSelectedIndex();

        return total;
    }

    private void mostrar() {
        int rep = obtenerTotal();
        v.getTxtFR3total().setText(rep + "");
        if (rep <= 19) {
            v.getLabFR3refe().setText("LEVE");
            v.getTxtcolor().setBackground(Color.green);
        } else if (rep <= 38) {
            v.getLabFR3refe().setText("MEDIO");
            v.getTxtcolor().setBackground(Color.yellow);
        } else {
            v.getLabFR3refe().setText("GRAVE");
            v.getTxtcolor().setBackground(Color.green);
        }
    }

    private void limpiar() {
        v.getTxtFR3nombre().setText("");
        v.getTxtFR3motivo().setText("");
        v.getTxtFR3total().setText("");
        v.getLabFR3refe().setText("--------");
        v.getCbxResp1().setSelectedIndex(0);
        v.getCbxResp2().setSelectedIndex(0);
        v.getCbxResp3().setSelectedIndex(0);
        v.getCbxResp4().setSelectedIndex(0);
        v.getCbxResp5().setSelectedIndex(0);
        v.getCbxResp6().setSelectedIndex(0);
        v.getCbxResp7().setSelectedIndex(0);
        v.getCbxResp8().setSelectedIndex(0);
        v.getCbxResp9().setSelectedIndex(0);
        v.getCbxResp10().setSelectedIndex(0);
        v.getCbxResp11().setSelectedIndex(0);
        v.getCbxResp12().setSelectedIndex(0);
        v.getCbxResp13().setSelectedIndex(0);
        v.getCbxResp14().setSelectedIndex(0);
        v.getCbxResp15().setSelectedIndex(0);
        v.getCbxResp16().setSelectedIndex(0);
        v.getCbxResp17().setSelectedIndex(0);
        v.getCbxResp18().setSelectedIndex(0);
        v.getCbxResp19().setSelectedIndex(0);
        total = 0;
    }

    public void buscar_x_cedula() throws SQLException {
        String ced = v.getTxtCedula().getText();
        boolean re = false;
        vdb = new victimaDB();
        vic = vdb.obtener_id_formulario(ced);
        if (vic.getVictima_codigo() != 0) {
            re = true;
        }
        if (re) {
            v.getTxtFR3nombre().setText(vic.getPersona_nombre());
            v.getPnlDescripcion().setVisible(true);
            v.getPnlResultados().setVisible(true);
            v.getBtnGuardar().setEnabled(false);

        }
        if (re == false) {
            JOptionPane.showMessageDialog(v, "No existe persona ingresada con esa cédula", "Información", JOptionPane.WARNING_MESSAGE);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(v.getBtn_limpieza())) {
            limpiar();
            v.getTxtcolor().setVisible(false);
            v.getBtnGuardar().setEnabled(false);
        }
        if (e.getSource().equals(v.getBtn_buscar())) {
//            try {
//                buscar_x_cedula();
//                System.out.println("Entra al buscar");
//            } catch (SQLException ex) {
//                Logger.getLogger(controlFormularioR3.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        if (e.getSource().equals(v.getBtnFR3calcular())) {
            obtenerTotal();
            mostrar();
            v.getBtnGuardar().setEnabled(true);
            v.getTxtcolor().setVisible(true);
        }
        if (e.getSource().equals(v.getBtnCancelar())) {
            limpiar();
            v.getPnlDescripcion().setVisible(false);
            v.getPnlResultados().setVisible(false);

        }
        if (e.getSource().equals(v.getBtnGuardar())) {
//            System.out.println("Entra al guardar");
////            int seleccion = JOptionPane.showOptionDialog(null, "Seguro que desea guardar los datos?...",
////                    "Alerta!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
////                    null, new Object[]{"Guardar", "Cancelar"}, "Guardar") + 1;
////            if (seleccion == 0) {
//                try {
//                    if (guardar_escala_prevencion_riesgos()) {
//                        v.getBtnGuardar().setEnabled(false);
//                        v.getBtnFR3calcular().setEnabled(false);
//                        v.getBtn_limpieza().setEnabled(false);
//                        guardar_encuesta();
//                        obtenerTotal();
//                        mostrar();
//                        guardar_preguntas();
//                        guargar_total();
//                    }else{
//                        JOptionPane.showMessageDialog(null, "Datos no guardados");
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(controlFormularioR3.class.getName()).log(Level.SEVERE, null, ex);
//                }
////            }
        }
    }

    private void guardar() {
        System.out.println("Entra al guardar");
//            int seleccion = JOptionPane.showOptionDialog(null, "Seguro que desea guardar los datos?...",
//                    "Alerta!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
//                    null, new Object[]{"Guardar", "Cancelar"}, "Guardar") + 1;
//            if (seleccion == 0) {
        try {
            if (guardar_escala_prevencion_riesgos()) {
//                v.getBtnGuardar().setEnabled(false);
//                v.getBtnFR3calcular().setEnabled(false);
//                v.getBtn_limpieza().setEnabled(false);
                guardar_encuesta();
//                obtenerTotal();
                mostrar();
                guardar_preguntas();
                guargar_total();
                limpiar();
                v.getPnlDescripcion().setVisible(false);
                v.getPnlResultados().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Datos no guardados");
            }
        } catch (SQLException ex) {
            Logger.getLogger(controlFormularioR3.class.getName()).log(Level.SEVERE, null, ex);
        }
//            }
    }

    private void buscar2() {
        try {
            buscar_x_cedula();
            System.out.println("Entra al buscar");
        } catch (SQLException ex) {
            Logger.getLogger(controlFormularioR3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
