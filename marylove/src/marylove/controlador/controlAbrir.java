package marylove.controlador;

import java.awt.Color;
import javax.swing.ImageIcon;
import marylove.vista.vistaCarga;

/**
 *
 * @author vasquez
 */
public class controlAbrir extends Thread {

    private int auxiliar = 0;
    private vistaCarga vista;
    boolean realizado = false;

    public controlAbrir(vistaCarga vista) {
        this.vista = vista;
    }

    public void iniciarControl() {
        abrirVentana();
        formWindowActivated();
    }

    private void abrirVentana() {
        try {
            //String directorio = System.getProperty("lenovo.dir"); //eso le da el directorio del proyecto
            //si las imágenes están dentro de una carpeta, por ejemplo imgs

            //String directorioImagenes = directorio + File.separator + "iconos" +File.separator + "cargaFunda1.png";
            //BufferedImage img = ImageIcon(new File(directorioImagenes));
            //vista.getFondo().setIcon((Icon) img);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
            //no se vea
            vista.getRootPane().setOpaque(false);
            //se pone transparente
            vista.getContentPane().setBackground(new Color(0, 0, 0, 0));
            vista.setBackground(new Color(0, 0, 0, 0));
            vista.setResizable(false);

            //icono
            vista.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());

        } catch (Exception e) {
            System.out.println("error en la ventana de carga" + e.getMessage());
        }

    }

    private void formWindowActivated() {

        if (realizado == false) {
            realizado = true;
            vista.getBarra().setMaximum(49);
            vista.getBarra().setMinimum(0);
            vista.getBarra().setStringPainted(true);
            start();

        }
    }

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
                    case 10:
                        vista.getTexto().setText("cargando usuario....");
                        break;
                    case 20:
                        vista.getTexto().setText("cargando perfiles....");
                        break;
                    case 30:
                        vista.getTexto().setText("cargando iconos....");
                        break;
                    case 40:
                        vista.getTexto().setText("cargando datos....");
                        break;
                    case 45:
                        vista.getTexto().setText("cargando ventana....");
                        break;
                    case 50:
                        vista.getTexto().setText("cargando  finalizada");
                        vista.dispose();
                        stop();
                        break;
                }
                Thread.sleep(450);
            }
        } catch (Exception e) {
            System.out.println("Error en el carga:" + e);
        }

    }
}
