
package marylove.controlador;

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
    private Conexion conex;
    private fichaLegalDB flDB;

    public controlFichaLegal() {
        
    }

    public controlFichaLegal(FichaLegal vistaLegal, Ficha_Legal modeloLegal, Conexion conex) {
        this.vistaLegal = vistaLegal;
        this.modeloLegal = modeloLegal;
        this.conex = conex;
        vistaLegal.setVisible(true);
        
    }
    
    
    public void iniCFLegal(){
       vistaLegal.getTxtNombre().addKeyListener(validarLetras(vistaLegal.getTxtNombre()));
       vistaLegal.getTxtCodigo().addKeyListener(validarNumeros(vistaLegal.getTxtCodigo()));
       vistaLegal.getTxtCedula().addKeyListener(validarNumeros(vistaLegal.getTxtCedula()));
       vistaLegal.getBtnGuardar().addActionListener(e -> flDB.ingreFLegal(conex, datos()));
       vistaLegal.getBtnCancelar().addActionListener(e -> borrarDatos());
    }
    
    public Ficha_Legal datos(){
        victimaDB  vdb = new victimaDB();
        modeloLegal.setVictima_codigo(vdb.obtenetCV(conex, vistaLegal.getTxtCedula().getText()));
        modeloLegal.setAbogada_codigo(15);
        modeloLegal.setMotivo_consulta(vistaLegal.getTxtAmotivoconsulta().getText());
        modeloLegal.setRelacion_hechos(vistaLegal.getTxtArelaciondehechos().getText());
        modeloLegal.setAspectos_reelevantes(vistaLegal.getTxtAaspectosrelevantes().getText());
        return modeloLegal;
    }
    
    public void borrarDatos(){
        vistaLegal.getTxtNombre().setText("");
        vistaLegal.getTxtCedula().setText("");
        vistaLegal.getTxtCodigo().setText("");
        vistaLegal.getTxtANivelderiesgo().setText("");
        vistaLegal.getTxtAaspectosrelevantes().setText("");
        vistaLegal.getTxtAmotivoconsulta().setText("");
        
    }
// en la clase ficha_legal ingresar la columna de fecha
// cambiar de codigo de psicologa a codigo de abogada
}
