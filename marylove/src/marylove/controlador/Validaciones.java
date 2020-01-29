package marylove.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public abstract class Validaciones {

     public KeyListener validarLetras(JTextField letras) { // metodo para validar el ingreso de letras 
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char val = e.getKeyChar();
                if ((val < 'a' || val > 'z') && (val < 'A' || val > 'Z') && (val != KeyEvent.VK_SPACE)) {
                    e.consume();
                }
                int cont = 50;
                if (letras.getText().length() >= cont) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Demaciados caracteres (49)", "Verificacion", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        return ke;
    }
     
     public KeyListener validarNumeros(JTextField numero){ // metodo para validar el ingreso de numeros 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char val = e.getKeyChar();
                if (val < '0' || val > '9') {
                    e.consume();
                }
                int cont = 12;
                if (numero.getText().length() >= cont) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Numero de celular no válido", "Verificación", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        };
        return kn;
    }
}
