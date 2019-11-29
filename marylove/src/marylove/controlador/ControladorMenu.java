package marylove.controlador;

import marylove.vista.VistaMenuPrincipal;

/**
 *
 * @author Patricio
 */
public class ControladorMenu {
    VistaMenuPrincipal vistaPrincipal;

    public ControladorMenu(VistaMenuPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.setVisible(true);
        this.vistaPrincipal.setExtendedState(6);
        añadirEscuchas();
    }
    
    private void añadirEscuchas(){
        
    }
}