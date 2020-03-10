package marylove.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import marylove.DBmodelo.abogadaDB;
import marylove.DBmodelo.fichaLegalDB;
import marylove.DBmodelo.victimaDB;
import marylove.conexion.Conexion;
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
    Conexion conex = new Conexion();

    abogadaDB aDB = new abogadaDB();

    public controlFichaLegal(FichaLegal vistaLegal, Ficha_Legal modeloLegal, fichaLegalDB flDB) {
        this.vistaLegal = vistaLegal;
        this.modeloLegal = modeloLegal;
        this.flDB = flDB;
    }

    public void iniCFLegal() {
        vistaLegal.getTxtNombre().addKeyListener(validarLetras(vistaLegal.getTxtNombre()));
        vistaLegal.getTxtCodigo().addKeyListener(validarNumeros(vistaLegal.getTxtCodigo()));
        vistaLegal.getTxtCedula().addKeyListener(validarCedula(vistaLegal.getTxtCedula()));
        vistaLegal.getTxtCedula().addKeyListener(enter1(vistaLegal.getTxtCedula(), vistaLegal.getTxtNombre(), vistaLegal.getTxtCodigo()));
        vistaLegal.getTxtCedula().addKeyListener(enterllenar());
        
        vistaLegal.getBtnGuardar().addActionListener(e -> guardarDatos());
        vistaLegal.getBtnCancelar().addActionListener(e -> borrarDatos());
    }

    public void guardarDatos() {
        if (flDB.ingreFLegal(conex, datos())) {
            JOptionPane.showMessageDialog(null, "Datos ingresar Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se han ingresar los datos");
        }
    }

    public Ficha_Legal datos() {
        modeloLegal.setVictima_codigo(Integer.parseInt(vistaLegal.getTxtCodigo().getText()));
        modeloLegal.setAbogada_codigo(aDB.verifiUserA(conex, personal_cod));
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
           vistaLegal.getLabLeg_id().setText(""+modeloLegal.getLegal_id());
            vistaLegal.getTxtArelaciondehechos().setText(modeloLegal.getRelacion_hechos());
            vistaLegal.getTxtAaspectosrelevantes().setText(modeloLegal.getAspectos_reelevantes());
            vistaLegal.getTxtAmotivoconsulta().setText(modeloLegal.getMotivo_consulta());
            ingreDATE(vistaLegal.getJdcFecha(), modeloLegal.getFecha());
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
                    if (!vistaLegal.getTxtCodigo().getText().equals("")) {
                        obtenerFicha();
                    }
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
