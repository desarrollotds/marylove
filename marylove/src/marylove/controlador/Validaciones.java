package marylove.controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public abstract class Validaciones {

    public KeyListener validarLetras(JTextField letras) { // metodo para validar el ingreso de letras 
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char val = e.getKeyChar();
                if ((val < 'a' || val > 'z') && (val < 'A' || val > 'Z') && (val != KeyEvent.VK_SPACE)) {
                    e.consume();
                }
                // codigo para pasar las letras a mayuscula
                if (Character.isLowerCase(val)) {
                    String cad = ("" + val).toUpperCase();
                    val = cad.charAt(0);
                    e.setKeyChar(val);
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

    public KeyListener validarCelular(JTextField numero) { // metodo para validar el ingreso de numeros de celular y telefono
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

    public KeyListener validarNumeros(JTextField numero) { // metodo para validar el ingreso de numeros 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char val = e.getKeyChar();
                if (val < '0' || val > '9') {
                    e.consume();
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

    public KeyListener validarCedula(JTextField ced) { // metodo para validar el ingreso de numeros 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char val = e.getKeyChar();
                if (val < '0' || val > '9') {
                    e.consume();
                }
                System.out.println("entra");
                if (ced.getText().length() == 10) {
                    System.out.println(ced.getText().length());
                    if (valida(ced.getText())) {
                        System.out.println("cedula correcta");
                    } else {
                        JOptionPane.showMessageDialog(null, "Numero de cedular no válido", "Verificación", JOptionPane.WARNING_MESSAGE);
                    }
                    e.consume();
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

    public static boolean valida(String x) {//validaciones de cedula
        int suma = 0;
        if (x.length() == 9) {
            System.out.println("Ingrese su cedula de 10 digitos");
            return false;
        } else {
            int a[] = new int[x.length() / 2];
            int b[] = new int[(x.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < x.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
                c = c + 2;
                if (i < (x.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1)))) {
                return true;
            } else if (suma % 10 == 0 && x.charAt(x.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }

        }
    }

    //Metodo para obtener fecha y hora actual
    public String Fecha() {
        String fecha;
        String pattern = "dd-MM-YYYY  hh:mm:ss";
        SimpleDateFormat formato = new SimpleDateFormat(pattern);
        fecha = formato.format(new Date());
        return fecha;
    }

    //Metodo para validar JSpinner con un valor máximo
    //Valor mínimo 0
    public JSpinner ValoresSpinner(JSpinner spinner, int maximo) {
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMaximum(maximo);
        nm.setMinimum(0);
        spinner.setModel(nm);
        return spinner;
    }

    public String obtenerFecha(JDateChooser fech) {
        Date fechaN = fech.getDate();
        String fecha2 = "";
            SimpleDateFormat NFormat = new SimpleDateFormat("yyyy/MM/dd");
            fecha2 = NFormat.format(fechaN);
        System.out.println(fecha2);
        return fecha2;
    }
}
