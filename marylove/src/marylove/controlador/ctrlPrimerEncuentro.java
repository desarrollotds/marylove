package marylove.controlador;

import marylove.vista.FichaPrimerEncuentro;

/**
 *
 * @author LENOVO
 */
public class ctrlPrimerEncuentro {
    private final marylove.vista.FichaPrimerEncuentro primerEncuentro;

    public ctrlPrimerEncuentro(FichaPrimerEncuentro primerEncuentro) {
        this.primerEncuentro = primerEncuentro;
    }
    
    public void iniciarControl(){
        abrirVentana();
    }
    
    public void abrirVentana(){
        primerEncuentro.setVisible(true);
        primerEncuentro.setLocationRelativeTo(null);
    }
   
}

