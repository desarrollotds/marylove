package marylove.controlador;

import marylove.vista.VistaMenuPrincipal;

/**
 *
 * @author Patricio
 */
public class ControladorMenu {
    VistaMenuPrincipal vistaPrincipal;
    

    public ControladorMenu(VistaMenuPrincipal vistaPrincipal) {
        
        
    }
    
    public void iniciarContrl(){
        abrirVistaMenu();
    }
    
    private void abrirVistaMenu(){
    vistaPrincipal.setVisible(true);
    vistaPrincipal.setLocationRelativeTo(null);
        
    }
}