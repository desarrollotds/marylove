package marylove.controlador;

import marylove.vista.FichaPrimerEncuentro;

/**
 *
 * @author LENOVO
 */
public class ctrlPrimerEncuentro {
    private final marylove.vista.FichaPrimerEncuentro VistaPrimerEncuentro;

    public ctrlPrimerEncuentro(FichaPrimerEncuentro primerEncuentro) {
        this.VistaPrimerEncuentro = primerEncuentro;
    }
    
    public void iniciarControl(){
        abrirVentana();
    }
    
    public void abrirVentana(){
        VistaPrimerEncuentro.setVisible(true);
        VistaPrimerEncuentro.setLocationRelativeTo(null);
    }
    
    public void agregarDatos (int b){
        VistaPrimerEncuentro.getTxtCodigo().setText("");
        VistaPrimerEncuentro.getTxtNombre().setText("");
        VistaPrimerEncuentro.getTxtPsicologa().setText("");
        VistaPrimerEncuentro.getTxtCodigo().setText("");
                
                
                         
    }
   
}

