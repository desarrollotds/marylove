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
import marylove.DBmodelo.FichaR1DB;
import marylove.DBmodelo.PreguntasDB;
import marylove.DBmodelo.psicologoDB;
import marylove.DBmodelo.victimaDB;
import marylove.DBmodelo.x_respuestasDB;
import marylove.models.Victima;

import marylove.models.x_respuestas;
import marylove.vista.formularioR1;

/**
 *
 * @author USER
 */
public class ControladorFichaR1 implements ActionListener {

    private formularioR1 v;
    private x_respuestas respuestas;
    private FichaR1DB fRlDB;
    // variables globales
    x_respuestasDB xrdb;
    EncuestaDB edb;
    Escala_prevencion_riesgoDB eprdb;
    PreguntasDB pdb;
    psicologoDB psdb;
    private int suma = 0;
    victimaDB vdb;
    Victima vic = new Victima();

    public ControladorFichaR1(formularioR1 v, x_respuestas respuestas, FichaR1DB fRlDB) {
        this.v = v;
        this.respuestas = respuestas;
        this.fRlDB = fRlDB;
//        v.setVisible(true);
    }

    public ControladorFichaR1(formularioR1 v) {
        this.v = v;
        iniciarComponentes();
        victimaDB.setCodigo_victima_static(1);
        psicologoDB.setPsicologo_codigo_static(1);

    }

    public void iniciarComponentes() {
        v.getBtnGuardar().addActionListener(this);
        v.getBtn_limpiar().addActionListener(this);
        v.getBtnCancelar().addActionListener(this);
        v.getBtnGenerar().addActionListener(this);
        v.getBtnBuscar().addActionListener(this);
        v.getBtnGuardar().setEnabled(false);
        v.getBtn_limpiar().setEnabled(false);
        v.getBtn_siguiente().setVisible(false);
    }

    public boolean guardar_escala_prevencion_riesgos() throws SQLException {
        psdb = new psicologoDB();
        int pID = psdb.obtener_id(C_Login.personal_cod);
        if (pID != 0) {
            if (vic.getVictima_codigo() != 0) {
                eprdb = new Escala_prevencion_riesgoDB(vic.getVictima_codigo(), pID);
            }
        }
        if (eprdb.insertar_escala_prevencion_riesgo()) {
            return true;
        } else {
            return false;
        }
    }

    public void guardar_encuesta() throws SQLException {
        edb = new EncuestaDB(Escala_prevencion_riesgoDB.getEsca_preve_ries_static(), 1);
        edb.insertar_encuesta();
    }

    public void guarda_respuestas() throws SQLException {//metodo para guardar los datos de la ficha
        pdb = new PreguntasDB();
        xrdb = new x_respuestasDB();
        int p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0, p7 = 0, p8 = 0, p9 = 0, p10 = 0;
        int p11 = 0, p12 = 0, p13 = 0, p14 = 0, p15 = 0, p16 = 0, p17 = 0, p18 = 0, p19 = 0, p20 = 0;
        String r1 = "", r2 = "", r3 = "", r4 = "", r5 = "", r6 = "", r7 = "", r8 = "", r9 = "", r10 = "",
                r11 = "", r12 = "", r13 = "", r14 = "", r15 = "", r16 = "", r17 = "", r18 = "", r19 = "", r20 = "";
        p1 = pdb.obtener_id(v.getLblPregunta1().getText(), 1);
        System.out.println(p1);
        r1 = v.getCbxPregunta1().getSelectedItem().toString();
        System.out.println("-------" + r1);
        //----------------------------------------------------------------------
        p2 = pdb.obtener_id(v.getLblPregunta2().getText(), 1);
        System.out.println(p2);
        r2 = v.getCbxPregunta2().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p3 = pdb.obtener_id(v.getLblPregunta3().getText(), 1);
        System.out.println(p3);
        r3 = v.getCbxPregunta3().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p4 = pdb.obtener_id(v.getLblPregunta4().getText(), 1);
        System.out.println(p4);
        r4 = v.getCbxPregunta4().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p5 = pdb.obtener_id(v.getLblPregunta5().getText(), 1);
        System.out.println(p5);
        r5 = v.getCbxPregunta5().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p6 = pdb.obtener_id(v.getLblPregunta6().getText(), 1);
        System.out.println(p6);
        r6 = v.getCbxPregunta6().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p7 = pdb.obtener_id(v.getLblPregunta7().getText(), 1);
        System.out.println(p7);
        r7 = v.getCbxPregunta7().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p8 = pdb.obtener_id(v.getLblPregunta8().getText(), 1);
        System.out.println(p8);
        r8 = v.getCbxPregunta8().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p9 = pdb.obtener_id(v.getLblPregunta9().getText(), 1);
        System.out.println(p9);
        r9 = v.getCbxPregunta9().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p10 = pdb.obtener_id(v.getLblPregunta10().getText(), 1);
        System.out.println(p10);
        r10 = v.getCbxPregunta10().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p11 = pdb.obtener_id(v.getLblPregunta11().getText(), 1);
        System.out.println(p11);
        r11 = v.getCbxPregunta11().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p12 = pdb.obtener_id(v.getLblPregunta12().getText(), 1);
        System.out.println(p12);
        r12 = v.getCbxPregunta12().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p13 = pdb.obtener_id(v.getLblPregunta13().getText(), 1);
        System.out.println(p13);
        r13 = v.getCbxPregunta13().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p14 = pdb.obtener_id(v.getLblPregunta14().getText(), 1);
        System.out.println(p14);
        r14 = v.getCbxPregunta14().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p15 = pdb.obtener_id(v.getLblPregunta15().getText(), 1);
        System.out.println(p15);
        r15 = v.getCbxPregunta15().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p16 = pdb.obtener_id(v.getLblPregunta16().getText(), 1);
        System.out.println(p16);
        r16 = v.getCbxPregunta16().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p17 = pdb.obtener_id(v.getLblPregunta17().getText(), 1);
        System.out.println(p17);
        r17 = v.getCbxPregunta17().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p18 = pdb.obtener_id(v.getLblPregunta18().getText(), 1);
        System.out.println(p18);
        r18 = v.getCbxPregunta18().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p19 = pdb.obtener_id(v.getLblPregunta19().getText(), 1);
        System.out.println(p19);
        r19 = v.getCbxPregunta19().getSelectedItem().toString();
        //---------------------------------------------------------------------
        p20 = pdb.obtener_id(v.getLblPregunta20().getText(), 1);
        System.out.println(p20);
        r20 = v.getCbxPregunta20().getSelectedItem().toString();
        //------------------------------------------------------------------------------------------------------------------------------------------
        xrdb.insert_x_respuesta_r1(EncuestaDB.getEncuesta_codigo_static(), p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
                r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);

    }

    public void guargar_total() throws SQLException {
        edb = new EncuestaDB(Integer.parseInt(v.getTxtRiesgototal().getText()));
        if (edb.update_total_encuesta(EncuestaDB.getEncuesta_codigo_static())) {
            JOptionPane.showMessageDialog(null, "Datos Guardados");
            validarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Datos no Guardados");
        }

    }

    public boolean validaciones() {
        if (v.getCbxPregunta1().getSelectedIndex() == 0 || v.getCbxPregunta2().getSelectedIndex() == 0
                || v.getCbxPregunta3().getSelectedIndex() == 0 || v.getCbxPregunta4().getSelectedIndex() == 0
                || v.getCbxPregunta5().getSelectedIndex() == 0 || v.getCbxPregunta6().getSelectedIndex() == 0
                || v.getCbxPregunta7().getSelectedIndex() == 0 || v.getCbxPregunta8().getSelectedIndex() == 0
                || v.getCbxPregunta9().getSelectedIndex() == 0 || v.getCbxPregunta10().getSelectedIndex() == 0
                || v.getCbxPregunta11().getSelectedIndex() == 0 || v.getCbxPregunta12().getSelectedIndex() == 0
                || v.getCbxPregunta13().getSelectedIndex() == 0 || v.getCbxPregunta14().getSelectedIndex() == 0
                || v.getCbxPregunta15().getSelectedIndex() == 0 || v.getCbxPregunta16().getSelectedIndex() == 0
                || v.getCbxPregunta17().getSelectedIndex() == 0 || v.getCbxPregunta18().getSelectedIndex() == 0
                || v.getCbxPregunta19().getSelectedIndex() == 0 || v.getCbxPregunta20().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos...");
            return false;
        } else {
            return true;
        }

    }

    public void sumaRespuestas() {
        suma = 0;
        try {
            suma = suma + Integer.parseInt(v.getCbxPregunta1().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta2().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta3().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta4().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta5().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta6().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta7().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta8().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta9().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta10().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta11().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta12().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta13().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta14().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta15().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta16().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta17().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta18().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta19().getSelectedItem().toString());
            suma = suma + Integer.parseInt(v.getCbxPregunta20().getSelectedItem().toString());

            v.getTxtRiesgototal().setText(Integer.toString(suma));
            if (suma >= 24 && suma <= 48) {
                v.getLblAlto().setBackground(Color.red);
            } else if (suma >= 10 && suma < 24) {
                v.getLblModerado().setBackground(Color.YELLOW);
            } else {
                v.getLblBajo().setBackground(Color.GREEN);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(v, "Existen valores sin seleccionar", "Mensaje de Información", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(v, "Surgió un error", "Mensaje de Información", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void cancelar() {
        edb = new EncuestaDB();
        edb.update_estado(false, EncuestaDB.getEncuesta_codigo_static());
        v.dispose();
    }

    public void limpieza() {
        v.getCbxPregunta1().setSelectedIndex(0);
        v.getCbxPregunta2().setSelectedIndex(0);
        v.getCbxPregunta3().setSelectedIndex(0);
        v.getCbxPregunta4().setSelectedIndex(0);
        v.getCbxPregunta5().setSelectedIndex(0);
        v.getCbxPregunta6().setSelectedIndex(0);
        v.getCbxPregunta7().setSelectedIndex(0);
        v.getCbxPregunta8().setSelectedIndex(0);
        v.getCbxPregunta9().setSelectedIndex(0);
        v.getCbxPregunta10().setSelectedIndex(0);
        v.getCbxPregunta11().setSelectedIndex(0);
        v.getCbxPregunta12().setSelectedIndex(0);
        v.getCbxPregunta13().setSelectedIndex(0);
        v.getCbxPregunta14().setSelectedIndex(0);
        v.getCbxPregunta15().setSelectedIndex(0);
        v.getCbxPregunta16().setSelectedIndex(0);
        v.getCbxPregunta17().setSelectedIndex(0);
        v.getCbxPregunta18().setSelectedIndex(0);
        v.getCbxPregunta19().setSelectedIndex(0);
        v.getCbxPregunta20().setSelectedIndex(0);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(v.getBtnGuardar())) {

            if (validaciones()) {
                try {
                    JOptionPane.showMessageDialog(null, "Guardando Datos...");
                    guardar_escala_prevencion_riesgos();
                    guardar_encuesta();
                    sumaRespuestas();
                    guarda_respuestas();
                    guargar_total();
                    v.getBtnGuardar().setEnabled(false);
                    v.getBtn_limpiar().setEnabled(false);
                    v.getBtn_siguiente().setEnabled(true);

                } catch (SQLException ex) {
                    Logger.getLogger(ControladorFichaR1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        if (e.getSource().equals(v.getBtn_limpiar())) {
            limpieza();

        }
        if (e.getSource().equals(v.getBtn_siguiente())) {

        }
        if (e.getSource().equals(v.getBtnCancelar())) {

        }
        if (e.getSource().equals(v.getBtnGenerar())) {
            sumaRespuestas();
        }
        if (e.getSource().equals(v.getBtnBuscar())) {
            try {
                buscar_x_cedula();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFichaR1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void validarCampos() {
        if (v.getTxtCedula().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un cedula");
        }
    }

    public void buscar_x_cedula() throws SQLException {
        String ced = v.getTxtCedula().getText();
        vdb = new victimaDB();
        vic = vdb.obtener_id_formulario(ced);
        if (vic.getVictima_codigo() != 0) {
            v.getTxtVictima().setText(vic.getPersona_nombre());
            v.getBtnCancelar().setEnabled(true);
            v.getBtnGuardar().setEnabled(true);
            v.getBtn_limpiar().setEnabled(true);
            v.getBtn_siguiente().setEnabled(true);
        }else{
            v.getBtnCancelar().setEnabled(false);
            v.getBtnGuardar().setEnabled(false);
            v.getBtn_limpiar().setEnabled(false);
            v.getBtn_siguiente().setEnabled(false);
        }

    }

}
