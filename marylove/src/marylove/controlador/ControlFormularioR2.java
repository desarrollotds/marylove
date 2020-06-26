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
import marylove.DBmodelo.EncuestaDB;
import marylove.DBmodelo.Escala_prevencion_riesgoDB;
import marylove.DBmodelo.PreguntasDB;
import marylove.DBmodelo.psicologoDB;
import marylove.DBmodelo.victimaDB;
import marylove.DBmodelo.x_respuestasDB;
import marylove.models.Victima;
import marylove.vista.formuR2;

/**
 *
 * @author LENOVO
 */
public class ControlFormularioR2 implements ActionListener {
    // variables globales

    x_respuestasDB xrdb;
    EncuestaDB edb;
    Escala_prevencion_riesgoDB eprdb;
    PreguntasDB pdb;
    victimaDB vdb;
    private formuR2 v;

    private int suma = 0;

    Victima vic = new Victima();

    public ControlFormularioR2(formuR2 vista) {
        this.v = vista;
    }

    public void iniciarControl() {
        v.getBtnSumar().addActionListener(this);
        v.getBtn_cancelar().addActionListener(this);
        v.getBtn_guardar().addActionListener(this);
        v.getBtn_siguiente().addActionListener(this);
        v.getBtn_limpiar().addActionListener(this);
        v.getBtn_buscar().addActionListener(this);
        v.getBtn_guardar().setEnabled(false);
        v.getBtn_limpiar().setEnabled(false);
        v.getJscpDescripcion().setVisible(false);
        v.getPnlResultados().setVisible(false);
        //this.vista.setVisible(true);
        //this.v.setLocationRelativeTo(null);
//         victimaDB.setCodigo_victima_static(1);
//        C_Login.personal_cod=1;
    }

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
        edb = new EncuestaDB(Escala_prevencion_riesgoDB.getEsca_preve_ries_static(), 2);
        edb.insertar_encuesta();
    }

    //metodo de guaradado en la tercera tabla (tabla terciaria)
    public void guardar_preguntas() throws SQLException {
        pdb = new PreguntasDB();
        xrdb = new x_respuestasDB();
        int p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0, p7 = 0, p8 = 0, p9 = 0, p10 = 0;
        int p11 = 0, p12 = 0, p13 = 0, p14 = 0, p15 = 0, p16 = 0, p17 = 0, p18 = 0, p19 = 0, p20 = 0, p21 = 0, p22 = 0, p23 = 0;
        String r1 = "", r2 = "", r3 = "", r4 = "", r5 = "", r6 = "", r7 = "", r8 = "", r9 = "", r10 = "",
                r11 = "", r12 = "", r13 = "", r14 = "", r15 = "", r16 = "", r17 = "", r18 = "", r19 = "", r20 = "", r21 = "", r22 = "", r23 = "";

        p1 = pdb.obtener_id(v.getJ_pregunta1().getText(), 2);
        System.out.println(p1);
        r1 = v.getJcb1().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p2 = pdb.obtener_id(v.getJ_pregunta2().getText(), 2);
        System.out.println(p2);
        r2 = v.getJcb2().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p3 = pdb.obtener_id(v.getJ_pregunta3().getText(), 2);
        System.out.println(p3);
        r3 = v.getJcb3().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p4 = pdb.obtener_id(v.getJ_pregunta4().getText(), 2);
        System.out.println(p4);
        r4 = v.getJcb4().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p5 = pdb.obtener_id(v.getJ_pregunta5().getText(), 2);
        System.out.println(p5);
        r5 = v.getJcb5().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p6 = pdb.obtener_id(v.getJ_pregunta6().getText(), 2);
        System.out.println(p6);
        r6 = v.getJcb6().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p7 = pdb.obtener_id(v.getJ_pregunta7().getText(), 2);
        System.out.println(p7);
        r7 = v.getJcb7().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p8 = pdb.obtener_id(v.getJ_pregunta8().getText(), 2);
        System.out.println(p8);
        r8 = v.getJcb8().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p9 = pdb.obtener_id(v.getJ_pregunta9().getText(), 2);
        System.out.println(p9);
        r9 = v.getJcb9().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p10 = pdb.obtener_id(v.getJ_pregunta10().getText(), 2);
        System.out.println(p10);
        r10 = v.getJcb10().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p11 = pdb.obtener_id(v.getJ_pregunta11().getText(), 2);
        System.out.println(p11);
        r11 = v.getJcb11().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p12 = pdb.obtener_id(v.getJ_pregunta12().getText(), 2);
        System.out.println(p12);
        r12 = v.getJcb12().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p13 = pdb.obtener_id(v.getJ_pregunta13().getText(), 2);
        System.out.println(p13);
        r13 = v.getJcb13().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p14 = pdb.obtener_id(v.getJ_pregunta14().getText(), 2);
        System.out.println(p14);
        r14 = v.getJcb14().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p15 = pdb.obtener_id(v.getJ_pregunta15().getText(), 2);
        System.out.println(p15);
        r15 = v.getJcb15().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p16 = pdb.obtener_id(v.getJ_pregunta16().getText(), 2);
        System.out.println(p16);
        r16 = v.getJcb16().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p17 = pdb.obtener_id(v.getJ_pregunta17().getText(), 2);
        System.out.println(p17);
        r17 = v.getJcb17().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p18 = pdb.obtener_id(v.getJ_pregunta18().getText(), 2);
        System.out.println(p18);
        r18 = v.getJcb18().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p19 = pdb.obtener_id(v.getJ_pregunta19().getText(), 2);
        System.out.println(p19);
        r19 = v.getJcb19().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p20 = pdb.obtener_id(v.getJ_pregunta20().getText(), 2);
        System.out.println(p20);
        r20 = v.getJcb20().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p21 = pdb.obtener_id(v.getJ_pregunta21().getText(), 2);
        System.out.println(p21);
        r21 = v.getJcb21().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p22 = pdb.obtener_id(v.getJ_pregunta22().getText(), 2);
        System.out.println(p22);
        r22 = v.getJcb22().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p23 = pdb.obtener_id(v.getJ_pregunta23().getText(), 2);
        System.out.println(p23);
        r23 = v.getJcb23().getSelectedItem().toString();

        //----------------------------------------------------------------------
        xrdb.insert_x_respuesta_r2(EncuestaDB.getEncuesta_codigo_static(), p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
                p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10,
                r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    }

    private void sumar() {
        suma = suma + Integer.parseInt(v.getJcb1().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb2().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb3().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb4().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb5().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb6().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb7().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb8().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb9().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb10().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb11().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb12().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb13().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb14().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb15().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb16().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb17().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb18().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb19().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb20().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb21().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb22().getSelectedItem().toString());
        suma = suma + Integer.parseInt(v.getJcb23().getSelectedItem().toString());
        System.out.println(suma);
//        if (suma >= 0 && suma <= 23) {
//            System.out.println(suma);
//            v.getLbValor1().setText("" + suma);
//           
//            v.getLbResul1().setVisible(true);
//        } else if (suma >= 24 && suma <= 46) {
//            System.out.println(suma);
//            v.getLbValor2().setText("" + suma);
//            v.getLbValor1().setText("");
//            v.getLbResul2().setVisible(true);
//        } else if (suma >= 47 && suma <= 69) {
//            System.out.println(suma);
//            v.getLbValor3().setText("" + suma);
//
//            v.getLbValor2().setText("");
//
//            v.getLbResul3().setVisible(true);
//        }

    }

    public boolean validaciones() {
        if (v.getJcb1().getSelectedIndex() == 0 || v.getJcb2().getSelectedIndex() == 0
                || v.getJcb3().getSelectedIndex() == 0 || v.getJcb4().getSelectedIndex() == 0
                || v.getJcb5().getSelectedIndex() == 0 || v.getJcb6().getSelectedIndex() == 0
                || v.getJcb7().getSelectedIndex() == 0 || v.getJcb8().getSelectedIndex() == 0
                || v.getJcb9().getSelectedIndex() == 0 || v.getJcb10().getSelectedIndex() == 0
                || v.getJcb11().getSelectedIndex() == 0 || v.getJcb12().getSelectedIndex() == 0
                || v.getJcb13().getSelectedIndex() == 0 || v.getJcb14().getSelectedIndex() == 0
                || v.getJcb15().getSelectedIndex() == 0 || v.getJcb16().getSelectedIndex() == 0
                || v.getJcb17().getSelectedIndex() == 0 || v.getJcb18().getSelectedIndex() == 0
                || v.getJcb19().getSelectedIndex() == 0 || v.getJcb20().getSelectedIndex() == 0
                || v.getJcb21().getSelectedIndex() == 0 || v.getJcb22().getSelectedIndex() == 0
                || v.getJcb23().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Existen campos sin seleccionar", "Información", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {

            return true;
        }

    }

    public void limpieza() {

        v.getJcb1().setSelectedIndex(0);
        v.getJcb2().setSelectedIndex(0);
        v.getJcb3().setSelectedIndex(0);
        v.getJcb4().setSelectedIndex(0);
        v.getJcb5().setSelectedIndex(0);
        v.getJcb6().setSelectedIndex(0);
        v.getJcb7().setSelectedIndex(0);
        v.getJcb8().setSelectedIndex(0);
        v.getJcb9().setSelectedIndex(0);
        v.getJcb10().setSelectedIndex(0);
        v.getJcb11().setSelectedIndex(0);
        v.getJcb12().setSelectedIndex(0);
        v.getJcb13().setSelectedIndex(0);
        v.getJcb14().setSelectedIndex(0);
        v.getJcb15().setSelectedIndex(0);
        v.getJcb16().setSelectedIndex(0);
        v.getJcb17().setSelectedIndex(0);
        v.getJcb18().setSelectedIndex(0);
        v.getJcb19().setSelectedIndex(0);
        v.getJcb20().setSelectedIndex(0);
        v.getJcb21().setSelectedIndex(0);
        v.getJcb22().setSelectedIndex(0);
        v.getJcb23().setSelectedIndex(0);

    }

    public void cancelar() {
        edb = new EncuestaDB();
        edb.update_estado(false, EncuestaDB.getEncuesta_codigo_static());
        v.dispose();

    }

    public void guargar_total() throws SQLException {
        edb = new EncuestaDB(suma);
        edb.update_total_encuesta(EncuestaDB.getEncuesta_codigo_static());
        JOptionPane.showMessageDialog(null, "Datos Guardados");
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
            v.getTxtCompanera().setText(vic.getPersona_nombre());
            v.getJscpDescripcion().setVisible(true);
            v.getPnlResultados().setVisible(true);
            v.getBtn_cancelar().setEnabled(true);
            v.getBtn_guardar().setEnabled(true);
            v.getBtn_limpiar().setEnabled(true);
            v.getBtn_siguiente().setEnabled(true);

        }
        if (re == false) {
            v.getBtn_cancelar().setEnabled(false);
            v.getBtn_guardar().setEnabled(false);
            v.getBtn_limpiar().setEnabled(false);
            v.getBtn_siguiente().setEnabled(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(v.getBtnSumar())) {
            if (validaciones()) {
                sumar();
                v.getTxtValor().setText(Integer.toString(suma));
            }

        }
        if (e.getSource().equals(v.getBtn_cancelar())) {

        }
        if (e.getSource().equals(v.getBtn_buscar())) {
            try {
                buscar_x_cedula();
            } catch (SQLException ex) {
                Logger.getLogger(ControlFormularioR2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(v.getBtn_limpiar())) {
            limpieza();
        }
        if (e.getSource().equals(v.getBtn_guardar())) {
            if (validaciones()) {
                try {
                    if (guardar_escala_prevencion_riesgos()) {
                        JOptionPane.showMessageDialog(null, "Guardando Datos...");
                        v.getBtnSumar().setEnabled(false);
                        v.getBtn_guardar().setEnabled(false);
                        v.getBtn_siguiente().setEnabled(false);
                        v.getBtn_limpiar().setEnabled(false);
                        guardar_encuesta();
                        guardar_preguntas();
                        sumar();
                        guargar_total();
                        v.getBtn_siguiente().setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido Guardar");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ControlFormularioR2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
