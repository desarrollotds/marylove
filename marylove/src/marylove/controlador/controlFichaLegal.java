package marylove.controlador;

import java.awt.Cursor;
import static java.awt.Cursor.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import marylove.DBmodelo.abogadaDB;
import marylove.DBmodelo.fichaLegalDB;
import marylove.DBmodelo.victimaDB;
import marylove.models.Ficha_Legal;
import static marylove.controlador.C_Login.personal_cod;
import marylove.vista.FichaLegal;

/**
 *
 * @author vasquez
 */
public class controlFichaLegal extends Validaciones {

    private FichaLegal vistaLegal;
    private Ficha_Legal modeloLegal;
    private fichaLegalDB flDB;

    abogadaDB aDB = new abogadaDB();

    public controlFichaLegal(FichaLegal vistaLegal, Ficha_Legal modeloLegal, fichaLegalDB flDB) throws Exception {
        this.vistaLegal = vistaLegal;
        this.modeloLegal = modeloLegal;
        this.flDB = flDB;
    }

    public void iniCFLegal() {
        vistaLegal.getTxtNombre().addKeyListener(validarLetras(vistaLegal.getTxtNombre()));
        vistaLegal.getTxtCodigo().addKeyListener(validarNumeros(vistaLegal.getTxtCodigo()));
        vistaLegal.getTxtCedula().addKeyListener(validarCedula(vistaLegal.getTxtCedula()));
        vistaLegal.getTxtCedula().addKeyListener(enter1(vistaLegal.getTxtCedula(), vistaLegal.getTxtNombre(), vistaLegal.getTxtCodigo()));
        vistaLegal.getTxtNombre().addKeyListener(enter1(vistaLegal.getTxtCedula(), vistaLegal.getTxtNombre(), vistaLegal.getTxtCodigo()));
        vistaLegal.getTxtCedula().addKeyListener(enterllenar());
        vistaLegal.getTxtNombre().addKeyListener(enterllenar());
//        vistaLegal.getTxtANivelderiesgo().addKeyListener(validarArea(vistaLegal.getTxtANivelderiesgo()));
//        vistaLegal.getTxtArelaciondehechos().addKeyListener(validarArea(vistaLegal.getTxtArelaciondehechos()));
//        vistaLegal.getTxtAaspectosrelevantes().addKeyListener(validarArea(vistaLegal.getTxtAaspectosrelevantes()));
//        vistaLegal.getTxtAmotivoconsulta().addKeyListener(validarArea(vistaLegal.getTxtAmotivoconsulta()));

        vistaLegal.getBtnGuardar().addActionListener(e -> {
            vistaLegal.getBtnGuardar().setCursor(new Cursor(WAIT_CURSOR));
            guardarDatos();
            vistaLegal.getBtnGuardar().setCursor(new Cursor(DEFAULT_CURSOR));
        });
        vistaLegal.getBtnCancelar().addActionListener(e -> borrarDatos());
    }

    public void guardarDatos() {
        if (vistaLegal.getTxtCodigo().getText().equals("") || vistaLegal.getTxtCedula().getText().equals("") || vistaLegal.getTxtNombre().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Datos necesarios no ingresados");
        } else {
            if (aDB.verifiUserA(personal_cod) != 0) {
                if (vistaLegal.getBtnGuardar().getText().equals("Editar")) {
                    if (flDB.editFLegal(datos())) {
                        vistaLegal.getBtnGuardar().setText("Guardar");
                        borrarDatos();
                        JOptionPane.showMessageDialog(null, "Datos editados Correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se han editados los datos");
                    }
                } else {
                    if (flDB.ingreFLegal(datos())) {
                        borrarDatos();
                        JOptionPane.showMessageDialog(null, "Datos ingresar Correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se han ingresar los datos");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Su perfil no tiene permisos de Guardar ni Editar");
            }
        }

    }

    public Ficha_Legal datos() {
        modeloLegal.setVictima_codigo(Integer.parseInt(vistaLegal.getTxtCodigo().getText()));
        modeloLegal.setAbogada_codigo(aDB.verifiUserA(personal_cod));
        modeloLegal.setMotivo_consulta(vistaLegal.getTxtAmotivoconsulta().getText());
        modeloLegal.setRelacion_hechos(vistaLegal.getTxtArelaciondehechos().getText());
        modeloLegal.setAspectos_reelevantes(vistaLegal.getTxtAaspectosrelevantes().getText());
        try {
            modeloLegal.setFecha(obtenerFecha(vistaLegal.getJdcFecha()));
        } catch (Exception e) {
            System.out.println("ERROR ingreso FECHA " + e.getMessage());
        }
        return modeloLegal;
    }

    public void borrarDatos() {
        vistaLegal.getTxtNombre().setText("");
        vistaLegal.getTxtCedula().setText("");
        vistaLegal.getTxtCodigo().setText("");
        vistaLegal.getTxtANivelderiesgo().setText("");
        vistaLegal.getTxtArelaciondehechos().setText("");
        vistaLegal.getTxtAaspectosrelevantes().setText("");
        vistaLegal.getTxtAmotivoconsulta().setText("");

    }

    public void obtenerFicha() {
        if (flDB.obtenerFichaLegal(Integer.parseInt(vistaLegal.getTxtCodigo().getText())).getLegal_id() != 0) {
            modeloLegal = flDB.obtenerFichaLegal(Integer.parseInt(vistaLegal.getTxtCodigo().getText()));
            vistaLegal.getLabLeg_id().setText("" + modeloLegal.getLegal_id());
            vistaLegal.getTxtArelaciondehechos().setText(modeloLegal.getRelacion_hechos());
            vistaLegal.getTxtAaspectosrelevantes().setText(modeloLegal.getAspectos_reelevantes());
            vistaLegal.getTxtAmotivoconsulta().setText(modeloLegal.getMotivo_consulta());
            ingreDATE(vistaLegal.getJdcFecha(), modeloLegal.getFecha());
            vistaLegal.getBtnGuardar().setText("Editar");
        }
    }

    public KeyListener enterllenar() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                victimaDB vDB = new victimaDB();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    vistaLegal.getTxtCedula().setCursor(new Cursor(WAIT_CURSOR));
                    vistaLegal.getTxtNombre().setCursor(new Cursor(WAIT_CURSOR));
                    if (!vistaLegal.getTxtCodigo().getText().equals("")) {
                        obtenerFicha();
                    }
                    vistaLegal.getTxtNombre().setCursor(new Cursor(DEFAULT_CURSOR));
                    vistaLegal.getTxtCedula().setCursor(new Cursor(DEFAULT_CURSOR));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        return kn;
    }
// en la clase ficha_legal ingresar la columna de fecha
// cambiar de codigo de psicologa a codigo de abogada
}
