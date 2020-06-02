package marylove.controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Cursor;
import static java.awt.Frame.*;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.victimaDB;
import marylove.models.Json_object_consulta;
import marylove.models.Victima;

public abstract class Validaciones {

    private jsonDB claseJsonDB = new jsonDB();//DECLARARAMOS LA VARIABLE DE LA CLASE JSON

    //DECLARAMOS LAS LISTAS QUE CONTIENEN LOS VALORES DE LOS DISTINTOS JSONS QUE USARÁ LA FICHA
//    public ArrayList<Json_object_consulta> listaNacionalidades = claseJsonDB.obtenerNacionalidades();
//    public ArrayList<Json_object_consulta> listaEstadoCivil = claseJsonDB.obtenerEstadoCivil();
//    public ArrayList<Json_object_consulta> listaInstruccionAcademica = claseJsonDB.obtenerInstruccines();
//    public ArrayList<Json_object_consulta> listaOcupaciones = claseJsonDB.obtenerOcupaciones();
    static ArrayList<Json_object_consulta> listaNacionalidades = new ArrayList<>();
    static ArrayList<Json_object_consulta> listaEstadoCivil = new ArrayList<>();
    static ArrayList<Json_object_consulta> listaInstruccionAcademica = new ArrayList<>();
    static ArrayList<Json_object_consulta> listaOcupaciones = new ArrayList<>();
    static ArrayList<Json_object_consulta> listaParentesco = new ArrayList<>();

    public Validaciones() throws org.json.simple.parser.ParseException {
        //validarJsons();
    }

    public void validarJsons() throws org.json.simple.parser.ParseException {

        if (listaNacionalidades.isEmpty()) {
            listaNacionalidades = claseJsonDB.obtenerNacionalidades();
        }
        if (listaEstadoCivil.isEmpty()) {
            listaEstadoCivil = claseJsonDB.obtenerEstadoCivil();
        }
        if (listaInstruccionAcademica.isEmpty()) {
            listaInstruccionAcademica = claseJsonDB.obtenerInstruccines();
        }
        if (listaOcupaciones.isEmpty()) {
            listaOcupaciones = claseJsonDB.obtenerOcupaciones();
        }
        if (listaParentesco.isEmpty()) {
            listaParentesco = claseJsonDB.obtenerParntescoEspecifico();
        }
    }

    //METODO PARA CONSULTAR EL ID DE UNA NACIONALIDAD SELECCIONADA
    public String consultarIdNacionalidad(String nacionalidad) {
        for (int i = 0; i < listaNacionalidades.size(); i++) {
            Json_object_consulta obj = listaNacionalidades.get(i);

            //System.out.println("VALOR: " + obj.getValor());
            if (obj.getValor().equalsIgnoreCase(nacionalidad)) {
                //System.out.println("ID DE NACIONALIDAD:" + obj.getId());
                return obj.getId() + "";
            }
        }
        return null;
    }

    //METODO PARA CONSULTAR EL ID DE UN ESTADO CIVIL SELECCIONADO
    public String consultarIdEstadoCivil(String estadocivil) {
        for (int i = 0; i < listaEstadoCivil.size(); i++) {
            Json_object_consulta obj = listaEstadoCivil.get(i);

            //System.out.println("VALOR: " + obj.getValor());
            if (obj.getValor().equalsIgnoreCase(estadocivil)) {
                //System.out.println("ID DE ESTADO CIVIL:" + obj.getId());
                return obj.getId() + "";
            }
        }
        return null;
    }

    //METODO PARA CONSULTAR EL ID DE UNA INSTRUCCION ACADEMICA SELECCIONADA
    public String consultarIdInstruccionAcademica(String instruccionA) {
        for (int i = 0; i < listaInstruccionAcademica.size(); i++) {
            Json_object_consulta obj = listaInstruccionAcademica.get(i);

            //System.out.println("VALOR: " + obj.getValor());
            if (obj.getValor().equalsIgnoreCase(instruccionA)) {
                //System.out.println("ID DE LA INSTRUCCION ACADEMICA ES:" + obj.getId());
                return obj.getId() + "";
            }
        }
        return null;
    }

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

    public KeyListener validarArea(JTextArea letras) { // metodo para validar el ingreso de letras 
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char val = e.getKeyChar();
                if ((val < 'a' || val > 'z') && (val < 'A' || val > 'Z') && (val != KeyEvent.VK_SPACE)) {
                    e.consume();
                }
                int cont = 300;
                if (letras.getText().length() >= cont) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Demaciados caracteres (300)", "Verificacion", JOptionPane.WARNING_MESSAGE);
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

    public KeyListener validarLetras2(JTextField letras) { // metodo para validar el ingreso de letras 
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char val = e.getKeyChar();
                if ((val < 'a' || val > 'z') && (val < 'A' || val > 'Z') && (val != KeyEvent.VK_SPACE)) {
                    e.consume();
                }
                int cont = 300;
                if (letras.getText().length() >= cont) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Demaciados caracteres (300)", "Verificacion", JOptionPane.WARNING_MESSAGE);
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
        return fecha2;
    }

    public String obtenerFecha2(Date fech) {
        String fecha2 = "";
        SimpleDateFormat NFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha2 = NFormat.format(fech);
        return fecha2;
    }

    public KeyListener enter1(JTextField cd, JTextField nombre, JTextField codigo) { // al hacer un enter buscar el codigo y nombre de la vistima por la cedula

        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                victimaDB vDB = new victimaDB();
                Victima vD = new Victima();
                String nomb = "";
                String apellido = "";
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    cd.setCursor(new Cursor(WAIT_CURSOR));
                    nombre.setCursor(new Cursor(WAIT_CURSOR));
                    if (!nombre.getText().equals("")) {
                        nomb = seprarN(nombre.getText(), 2);
                        apellido = seprarN(nombre.getText(), 1);
                    }
                    vD = vDB.obtenetCV(cd.getText(), nomb, apellido);
                    if (vD.getVictima_codigo() != 0) {
                        codigo.setText("" + vD.getVictima_codigo());
                        nombre.setText(vD.getPersona_nombre());
                        cd.setText(vD.getPersona_cedula());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se entraron datos");
                    }
                    nombre.setCursor(new Cursor(DEFAULT_CURSOR));
                    cd.setCursor(new Cursor(DEFAULT_CURSOR));
                }
            }

            @Override

            public void keyReleased(KeyEvent e) {

            }
        };
        return kn;
    }

    public KeyListener enter2(JTextField cd, JTextField codigo) { // al hacer un enter busca el codigo de la vistima con la cedula 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                victimaDB vDB = new victimaDB();
                Victima vD = new Victima();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    cd.setCursor(new Cursor(WAIT_CURSOR));
                    vD = vDB.obtenetCV(cd.getText(), "", "");
                    if (vD.getVictima_codigo() != 0) {
                        codigo.setText("" + vD.getVictima_codigo());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se entraron datos");
                    }
                    cd.setCursor(new Cursor(DEFAULT_CURSOR));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        return kn;
    }

    public ImageIcon cargarIMG(byte[] imag, int h, int l) { // ingreso de imagenes desde la base de datos
        Image imgi;
        ImageIcon icono;
        imgi = new ImageIcon(imag).getImage();
        icono = new ImageIcon(imgi.getScaledInstance(h, l, Image.SCALE_SMOOTH));
        return icono;
    }

    //VALIDACIÓN DE FECHA PARA SETEO A LA BASE DE DATOS
    public java.sql.Date fechaBD(Long fecha) {
        //Validamos que el parámetro recibido no este vacio
        if (fecha != 0) {
            try {
                //El tipo de dato "java.sql.Date" es el tipo de dato "Date" de la Base de Datos por esta razón no existe problema para setearle a la base puesto que lo transforma al formato necesario
                java.sql.Date fechaBD = new java.sql.Date(fecha);
                return fechaBD;//retornamos la fecha lista para ser seteada a la base de datos

            } catch (Exception e) {
                System.out.println("ERROR AL VALIDAR FECHA: " + fecha + " /n EXCEPCIÓN ERROR:" + e);
                return null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo validar la fecha correctamente");
            return null;
        }
    }

    public void ingreDATE(JDateChooser fecha, String tuFecha) {
        try {
            Date fechaParseada = new SimpleDateFormat("yyyy/MM/dd").parse(tuFecha);
            fecha.setDate(fechaParseada);
        } catch (ParseException ex) {
            System.out.println("Error al ingresar Fecha al Calendario " + ex.getMessage());
        }
    }

    public void controlArea(JTextArea area) {
        //Metodo para que tomar el saltos de linea y lo guarden en la base de datos..
        String texto = area.getText();
        texto = texto.trim();
        String[] areglo = texto.split("\n");

    }

    public boolean consulta(String pet, String tipo, String acc) {// panel de codulta para realizar una accion de si o no
        String botones[] = {"Si", "No"};
        boolean resp = false;
        int seleccion = JOptionPane.showOptionDialog(null, pet + " " + tipo, acc, 0, 0, null, botones, null);
        if (seleccion == JOptionPane.YES_OPTION) {
            resp = true;
        } else if (seleccion == JOptionPane.NO_OPTION) {
            resp = false;
        }
        return resp;
    }

    public String seprarN(String nom, int opc) {
        String sep = "";
        String[] sepr = nom.split(" ");
        if (sepr.length != 0) {
            if (opc == 1) {
                if (sepr.length > 2) {
                    sep = sepr[2];
                } else if (sepr.length > 1){
                    sep = sepr[1];
                }
            } else {
                sep = sepr[0];
            }
        }
        return sep;
    }
    
    //Método para la verificación de que exista una conexión a Internet
    public boolean comprobarConexion() {
        try {
            Socket s = new Socket("www.google.com", 80);
            if (s.isConnected()) {
                /*
                JOptionPane.showMessageDialog(vreportes, "Bienvenido",
                        "MENSAJE DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                */
            }
            return true;
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Necesita una conexión a Internet",
                    "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public KeyListener validarMontos(JTextField num) { // metodo para numeros con , o .
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char val = e.getKeyChar();
                if ((val < '0' || val > '9') &&(val != '.') &&(val != ',') )  {
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
}
