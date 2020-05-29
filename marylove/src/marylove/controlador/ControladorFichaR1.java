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
import marylove.DBmodelo.victimaDB;
import marylove.DBmodelo.x_respuestasDB;

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

    private int suma = 0;

    public ControladorFichaR1(formularioR1 v, x_respuestas respuestas, FichaR1DB fRlDB) {
        this.v = v;
        this.respuestas = respuestas;
        this.fRlDB = fRlDB;
//        v.setVisible(true);
    }

    public void iniciarComponentes() {
        v.getBtnGuardar().addActionListener(this);
    }

    public boolean guardar_escala_prevencion_riesgos() throws SQLException {
        eprdb = new Escala_prevencion_riesgoDB(victimaDB.getCodigo_victima_static(), C_Login.personal_cod);
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
        if (v.getCbxPregunta1().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta1().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta1().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "1) Seleccione una respuesta...");
        }
        //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta2().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta2().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta2().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "2) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta3().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta3().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta3().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "3) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta4().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta4().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta4().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "4) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta5().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta5().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta5().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "5) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta6().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta6().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta6().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "6) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta7().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta7().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta7().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "7) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta8().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta8().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta8().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "8) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta9().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta9().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta9().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "9) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta10().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta10().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta10().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "10) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta11().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta11().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta11().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "11) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta12().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta12().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta12().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "12) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta13().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta13().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta13().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "13) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta14().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta14().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta14().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "14) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta15().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta15().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta15().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "15) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta16().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta16().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta16().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "16) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta17().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta17().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta17().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "17) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta18().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta18().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta18().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "18) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta19().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta19().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta19().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "19) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        if (v.getCbxPregunta20().getSelectedIndex() != 0) {
            int pregunta_codigo = pdb.obtener_id(v.getLblPregunta20().getText(), 1);
            xrdb = new x_respuestasDB(EncuestaDB.getEncuesta_codigo_static(), pregunta_codigo, v.getCbxPregunta20().getSelectedItem().toString());
            xrdb.insertar_x_respuesta();
        } else {
            JOptionPane.showMessageDialog(null, "20) Seleccione una respuesta...");
        }
         //------------------------------------------------------------------------------------------------------------------------------------------
        
    }
    public void guargar_total() throws SQLException {
        edb = new EncuestaDB(Integer.parseInt(v.getTxtRiesgototal().getText()));
        edb.update_total_encuesta(EncuestaDB.getEncuesta_codigo_static());
        
    }
    public boolean validaciones(){
        if (v.getCbxPregunta1().getSelectedIndex()==0 || v.getCbxPregunta2().getSelectedIndex()==0 ||
            v.getCbxPregunta3().getSelectedIndex()==0 || v.getCbxPregunta4().getSelectedIndex()==0 ||
            v.getCbxPregunta5().getSelectedIndex()==0 || v.getCbxPregunta6().getSelectedIndex()==0 ||
            v.getCbxPregunta7().getSelectedIndex()==0 || v.getCbxPregunta8().getSelectedIndex()==0 ||
            v.getCbxPregunta9().getSelectedIndex()==0 || v.getCbxPregunta10().getSelectedIndex()==0 ||
            v.getCbxPregunta11().getSelectedIndex()==0 || v.getCbxPregunta12().getSelectedIndex()==0 ||
            v.getCbxPregunta13().getSelectedIndex()==0 || v.getCbxPregunta14().getSelectedIndex()==0 ||
            v.getCbxPregunta15().getSelectedIndex()==0 || v.getCbxPregunta16().getSelectedIndex()==0 ||
            v.getCbxPregunta17().getSelectedIndex()==0 || v.getCbxPregunta18().getSelectedIndex()==0 ||
            v.getCbxPregunta19().getSelectedIndex()==0 || v.getCbxPregunta20().getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(null, "seleccione un valor");
            return false;
        }  else {
            return true;
        }
    
    }

    public void sumaRespuestas() {
        
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

        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource().equals(v.getBtnGuardar())) {
       
           if (validaciones()) {
               try {
                   guardar_escala_prevencion_riesgos();
                   guardar_encuesta();
                   sumaRespuestas();
                   guarda_respuestas();
                   guargar_total();
               } catch (SQLException ex) {
                   Logger.getLogger(ControladorFichaR1.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
       }
    }

}
