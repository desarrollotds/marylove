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
import marylove.DBmodelo.victimaDB;
import marylove.DBmodelo.x_respuestasDB;
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
    //incio de guardado--------------------------------------------------------------------------------------------------------------------------------
    //metodo de guaradado en la primera tabla
    public boolean guardar_escala_prevencion_riesgos() throws SQLException {
        eprdb = new Escala_prevencion_riesgoDB(victimaDB.getCodigo_victima_static(), C_Login.personal_cod);
        if (eprdb.insertar_escala_prevencion_riesgo()) {
            return true;
        } else {
            return false;
        }

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
        System.out.println(p1);
        r1 = v.getCbxResp1().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p2 = pdb.obtener_id(v.getLblPregunta2().getText(), 3);
        System.out.println(p2);
        r2 = v.getCbxResp2().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p3 = pdb.obtener_id(v.getLblPregunta3().getText(), 3);
        System.out.println(p3);
        r3 = v.getCbxResp3().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p4 = pdb.obtener_id(v.getLblPregunta4().getText(), 3);
        System.out.println(p4);
        r4 = v.getCbxResp4().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p5 = pdb.obtener_id(v.getLblPregunta5().getText(), 3);
        System.out.println(p5);
        r5 = v.getCbxResp5().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p6 = pdb.obtener_id(v.getLblPregunta6().getText(), 3);
        System.out.println(p6);
        r6 = v.getCbxResp6().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p7 = pdb.obtener_id(v.getLblPregunta7().getText(), 3);
        System.out.println(p7);
        r7 = v.getCbxResp7().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p8 = pdb.obtener_id(v.getLblPregunta8().getText(), 3);
        System.out.println(p8);
        r8 = v.getCbxResp8().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p9 = pdb.obtener_id(v.getLblPregunta9().getText(), 3);
        System.out.println(p9);
        r9 = v.getCbxResp9().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p10 = pdb.obtener_id(v.getLblPregunta10().getText(), 3);
        System.out.println(p10);
        r10 = v.getCbxResp10().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p11 = pdb.obtener_id(v.getLblPregunta11().getText(), 3);
        System.out.println(p11);
        r11 = v.getCbxResp11().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p12 = pdb.obtener_id(v.getLblPregunta12().getText(), 3);
        System.out.println(p12);
        r12 = v.getCbxResp12().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p13 = pdb.obtener_id(v.getLblPregunta13().getText(), 3);
        System.out.println(p13);
        r13 = v.getCbxResp13().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p14 = pdb.obtener_id(v.getLblPregunta14().getText(), 3);
        System.out.println(p14);
        r14 = v.getCbxResp14().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p15 = pdb.obtener_id(v.getLblPregunta15().getText(), 3);
        System.out.println(p15);
        r15 = v.getCbxResp15().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p16 = pdb.obtener_id(v.getLblPregunta16().getText(), 3);
        System.out.println(p16);
        r16 = v.getCbxResp16().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p17 = pdb.obtener_id(v.getLblPregunta17().getText(), 3);
        System.out.println(p17);
        r17 = v.getCbxResp17().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p18 = pdb.obtener_id(v.getLblPregunta18().getText(), 3);
        System.out.println(p18);
        r18 = v.getCbxResp18().getSelectedItem().toString();

        //----------------------------------------------------------------------
        p19 = pdb.obtener_id(v.getLblPregunta19().getText(), 3);
        System.out.println(p19);
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
        iniciarCtr();
    }

    public void iniciarCtr() {
        v.getBtnFR3calcular().addActionListener(this);
        v.getBtnCancelar().addActionListener(this);
        v.getBtnGuardar().addActionListener(this);
        v.getBtn_limpieza().addActionListener(this);
        v.getLabFR3refe().setText("--------");
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
        } else if (rep <= 38) {
            v.getLabFR3refe().setText("MEDIO");
        } else {
            v.getLabFR3refe().setText("GRAVE");
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
    }

    public void buscar_x_cedula() throws SQLException {
        String ced = v.getTxtCedula().getText();
        vdb = new victimaDB();
        boolean re = vdb.obtener_id_formulario(ced);
        System.out.println(re);
        if (re) {
            v.getTxtFR3nombre().setText(victimaDB.getVictima_nom_formulario());
            v.getBtnCancelar().setEnabled(true);
            v.getBtnGuardar().setEnabled(true);
            v.getBtn_limpieza().setEnabled(true);
            
        }
        if (re == false) {
            v.getBtnCancelar().setEnabled(false);
            v.getBtnGuardar().setEnabled(false);
            v.getBtn_limpieza().setEnabled(false);
            
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(v.getBtn_limpieza())) {
            limpiar();
        }
        if (e.getSource().equals(v.getBtn_buscar())) {
            try {
                buscar_x_cedula();
            } catch (SQLException ex) {
                Logger.getLogger(controlFormularioR3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(v.getBtnFR3calcular())) {
            obtenerTotal();
            mostrar();
        }
        if (e.getSource().equals(v.getBtnCancelar())) {

        }
        if (e.getSource().equals(v.getBtnGuardar())) {

            int seleccion = JOptionPane.showOptionDialog(null, "Seguro que desea guardar los datos?...",
                    "Alerta!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Guardar", "Cancelar"}, "Guardar") + 1;
            if (seleccion == 1) {
                try {
                    v.getBtnGuardar().setEnabled(false);
                    v.getBtnFR3calcular().setEnabled(false);
                    v.getBtn_limpieza().setEnabled(false);
                    guardar_escala_prevencion_riesgos();
                    guardar_encuesta();
                    obtenerTotal();
                    mostrar();
                    guardar_preguntas();
                    guargar_total();
                } catch (SQLException ex) {
                    Logger.getLogger(controlFormularioR3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
