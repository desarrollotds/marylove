package marylove.controlador;

import marylove.vista.vistaCarga;

/**
 *
 * @author vasquez
 */
public class controlAbrir {

    public controlAbrir() {
    }

    public void iniControl() {
        new Thread(new cargar()).start();
    }
}

class cargar implements Runnable {

    vistaCarga vista = new vistaCarga();
    int min;

    @Override
    public void run() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        min = 50;
        try {
            for (int i = 0; i < min; i++) {
                Thread.sleep(70);
                vista.getPgbingreso().setValue(i);
            }
            vista.setVisible(false);
        } catch (Exception e) {
            System.out.println("error en el panel de progreso "+e.getMessage());
        }
    }

}
