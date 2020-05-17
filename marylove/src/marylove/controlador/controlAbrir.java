package marylove.controlador;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import marylove.DBmodelo.fichaLegalDB;
import marylove.vista.FichaEgreso;
import marylove.vista.vistaCarga;

/**
 *
 * @author vasquez
 */
public class controlAbrir{

    private int auxiliar = 0;
    vistaCarga vista = new vistaCarga();
    FichaEgreso ficha = new FichaEgreso();
    hilo ejecutar = new hilo();
    boolean realizado = false;
    

    public void iniciarControl() {
        abrirVentana();
        formWindowActivated();
    }

    private void abrirVentana() {
        try {
              vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        //no se vea
        vista.getRootPane().setOpaque(false);
        //se pone transparente
        vista.getContentPane().setBackground(new Color(0, 0, 0, 0));
        vista.setBackground(new Color(0, 0, 0, 0));
        vista.setResizable(false);
        Image imagenInterna = new ImageIcon(getClass().getResource("\\iconos\\cargarFunda1.png")).getImage();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
        
    }

    private void formWindowActivated() {
        if (realizado==false) {
            realizado = true;
            vista.getBarra().setMaximum(49);
            vista.getBarra().setMinimum(0);
             vista.getBarra().setStringPainted(true);
            ejecutar.start();
                    
        }
    }

    private class hilo extends Thread {
        FichaEgreso ficha = new FichaEgreso();
        @Override
        public void run() {
            try {
                while (true) {
                    auxiliar++;
                    vista.getBarra().setValue(auxiliar);
                    switch (auxiliar) {
                        case 5:
                            vista.getTexto().setText("cargando sistema....");
                            break;
                        case 20:
                            vista.getTexto().setText("cargando iconos....");
                            break;
                        case 40:
                            vista.getTexto().setText("cargando cargando datos....");
                            break;
                        case 50:
                            vista.getTexto().setText("cargando  ventana....");
                             ficha.setVisible(true);
                             ficha.setLocationRelativeTo(null);
                             vista.dispose();
                            break;
                           
                    }
                    Thread.sleep(100);
                }
            } catch (Exception e) {
            }
        }
    }
}
