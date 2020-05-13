
package marylove.controlador;

import marylove.vista.PanelProgreso;

/**
 *
 * @author vasquez
 */
public class controlAbrir {
    private PanelProgreso vista;
    
    int min;

    public controlAbrir() {
    }

    public controlAbrir(PanelProgreso vista) {
        this.vista = vista;
    }
    
    public void iniControl(){
        progreso();
    }
    
    public void progreso(){
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        min = 100;
        try{
            for (int i = 0; i < min; i++) {
                Thread.sleep(70);
                vista.getPgbingreso().setValue(i);
            }
            vista.setVisible(false);
        }catch(Exception e){
            System.out.println("error en el panel de progreso");
        }
    }
}
