
package marylove.controlador;

import javax.swing.JOptionPane;
import marylove.DBmodelo.fichaLegalDB;
import marylove.DBmodelo.victimaDB;
import marylove.conexion.Conexion;
import marylove.models.Ficha_Legal;
import marylove.vista.FichaLegal;

/**
 *
 * @author vasquez
 */
public class controlFichaLegal extends Validaciones{
    private FichaLegal vistaLegal;
    private Ficha_Legal modeloLegal;
    private fichaLegalDB flDB;
    private Conexion conex;
    

    public controlFichaLegal(FichaLegal vistaLegal, Ficha_Legal modeloLegal, Conexion conex, fichaLegalDB flDB) {
        this.vistaLegal = vistaLegal;
        this.modeloLegal = modeloLegal;
        this.conex = conex;
        this.flDB = flDB;
    }

    public void iniCFLegal() {
        vistaLegal.getTxtNombre().addKeyListener(validarLetras(vistaLegal.getTxtNombre()));
        vistaLegal.getTxtCodigo().addKeyListener(validarNumeros(vistaLegal.getTxtCodigo()));
        vistaLegal.getTxtCedula().addKeyListener(validarNumeros(vistaLegal.getTxtCedula()));
        vistaLegal.getBtnGuardar().addActionListener(e -> guardarDatos());
        vistaLegal.getBtnCancelar().addActionListener(e -> borrarDatos());
        vistaLegal.getTxtCedula().addKeyListener(enter1(conex,vistaLegal.getTxtCedula(),vistaLegal.getTxtNombre(),vistaLegal.getTxtCodigo()));

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
        modeloLegal.setAbogada_codigo(15);
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
// en la clase ficha_legal ingresar la columna de fecha
// cambiar de codigo de psicologa a codigo de abogada
}
