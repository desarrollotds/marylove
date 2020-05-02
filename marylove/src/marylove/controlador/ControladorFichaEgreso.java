package marylove.controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import marylove.DBmodelo.DefinicionObjetivosEspecificosDB;
import marylove.DBmodelo.DefinicionObjetivosGeneralDB;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.EgresoDB;
import marylove.DBmodelo.jsonDB;
import marylove.conexion.Conexion;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.DefinicionObjetivosEspecifico;
import marylove.models.DefinicionObjetivosGeneral;
import marylove.models.Direccion;
import marylove.models.Egreso;
import marylove.models.Json_object_consulta;
import marylove.vista.FichaEgreso;

public class ControladorFichaEgreso extends Validaciones {

    private Direccion dir;
    private Egreso egresoModel;
    private FichaEgreso vistaEgres;
    private EgresoDB egresoModelDb;
    private DireccionDB dirDB;
    DefaultComboBoxModel modelComb;
    ArrayList<Json_object_consulta> jocarray;
    JFileChooser archivo = new JFileChooser();
    String idp = null;
    private FileInputStream foto = null;
    private int longByte = 0;

    jsonDB jo = new jsonDB();

    Conexion conex = new Conexion();

    public ControladorFichaEgreso(Direccion dir, Egreso egresoModel, FichaEgreso vistaEgres, EgresoDB egresoModelDb, DireccionDB dirDB) {
        this.dir = dir;
        this.egresoModel = egresoModel;
        this.vistaEgres = vistaEgres;
        this.egresoModelDb = egresoModelDb;
        this.dirDB = dirDB;
    }

    public void iniciCtrlEgreso() throws ParseException, org.json.simple.parser.ParseException {
        AbrirVentEgreso();
        fechaSistemaIni();
        llenarComboCantones();
        llenarcomboParentesco();
        vistaEgres.getBtnDireccion().setEnabled(false);
        vistaEgres.getTxtCedula().addKeyListener(enter1(vistaEgres.getTxtCedula(), vistaEgres.getTxtNombresApellidos(), vistaEgres.getTxtCodigo()));

        vistaEgres.getBtnDireccion().addActionListener(e -> MustraVentana());
        vistaEgres.getJdBtnGuardar().addActionListener(e -> datosDirecc());
        vistaEgres.getBtnGuardar().addActionListener(e -> egresoDatos());
        vistaEgres.getBtnGuardar().addActionListener(e -> guardarDatosEgreso());
        vistaEgres.getBtnIngreImg().addActionListener(e -> insertarImg());
        vistaEgres.getBtnCancelar().addActionListener(e-> botonCancelar());
        
        vistaEgres.getLblImg().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                vistaEgres.getDlgAmpliarImg().setSize(1200, 700);
                vistaEgres.getDlgAmpliarImg().setLocationRelativeTo(null);
                vistaEgres.getDlgAmpliarImg().setVisible(true);
            }
        }
        );

    }

    public void botonCancelar() {
        vistaEgres.setVisible(true);
    }

    public void MustraVentana() {
        vistaEgres.getjDialogIngDirecc().setVisible(true);
        vistaEgres.getjDialogIngDirecc().setLocationRelativeTo(null);
        vistaEgres.getjDialogIngDirecc().setSize(400, 700);
        vistaEgres.getjDialogIngDirecc().setResizable(false);
    }

    public void AbrirVentEgreso() {
        vistaEgres.setVisible(true);
        vistaEgres.setLocationRelativeTo(null);
    }

    public void validaciones() {

    }

    public void fechaSistemaIni() {
        Calendar c = new GregorianCalendar();
        vistaEgres.getDtcFechEgreso().setCalendar(c);
    }

    public void datosDirecc() {
        if (vistaEgres.getJdxtCalle().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaEgres.getJdtxtInterseccion().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaEgres.getJdtxtNumCasa().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaEgres.getJdtxtBarrio().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (vistaEgres.getJdtxtParroquia().getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                        } else {
                            if (vistaEgres.getJdtxtCiudad().getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                            } else {
                                if (vistaEgres.getJdtxtReferencia().getText().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    if (vistaEgres.getJdtxtProvincia().getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        if (vistaEgres.getJdtxtPais().getText().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                                        } else {
                                            dirDB.setCalle_dir(vistaEgres.getJdxtCalle().getText());
                                            dirDB.setDir_interseccion(vistaEgres.getJdtxtInterseccion().getText());
                                            dirDB.setDir_num_casa(vistaEgres.getJdtxtNumCasa().getText());
                                            dirDB.setDir_barrio(vistaEgres.getJdtxtBarrio().getText());
                                            dirDB.setDir_parroquia(vistaEgres.getJdtxtParroquia().getText());
                                            dirDB.setDir_ciudad(vistaEgres.getJdtxtCiudad().getText());
                                            dirDB.setDir_referencias(vistaEgres.getJdtxtReferencia().getText());
                                            dirDB.setProvincia(vistaEgres.getJdtxtProvincia().getText());
                                            dirDB.setPais(vistaEgres.getJdtxtPais().getText());
                                            if (dirDB.insertaDireccion()) {
                                                vistaEgres.getJdLblCodigo().setText(Integer.toString(dirDB.verifiDirecc(conex)));
                                                JOptionPane.showMessageDialog(null, "Direccion ingresada correctamente");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Error al Ingresar Dirección");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void egresoDatos() {
        if (vistaEgres.getDtcFechEgreso().getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaEgres.getTxaSituacion().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaEgres.getTxtTelefonoBeneficiaria().getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaEgres.getTxtCelular().getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {
                        egresoModelDb.setVictima_codigo(Integer.parseInt(vistaEgres.getTxtCodigo().getText()));
                        egresoModelDb.setPersonal_codigo(egresoModelDb.verifiUserP(personal_cod));
                        egresoModelDb.setEgreso_fecha(obtenerFecha(vistaEgres.getDtcFechEgreso()));
                        egresoModelDb.setEgreso_situacion(vistaEgres.getTxaSituacion().getText());
                        egresoModelDb.setTelefono(Integer.parseInt(vistaEgres.getTxtTelefonoBeneficiaria().getText()));
                        egresoModelDb.setCelular(Integer.parseInt(vistaEgres.getTxtCelular().getText()));
                        egresoModelDb.setDir_codigo(Integer.parseInt(vistaEgres.getJdLblCodigo().getText()));
                        System.out.println("coidog lbl: " + Integer.parseInt(vistaEgres.getJdLblCodigo().getText()));
                        if (egresoModelDb.IngresarEgreso()) {
                            JOptionPane.showMessageDialog(null, "Datos Agregados correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                        }

                    }
                }
            }
        }
    }

    public Date obtenerFecha3(JDateChooser fech) {
        SimpleDateFormat NFormt = new SimpleDateFormat("yyyy/MM/dd");

        String fechaJ = NFormt.format(fech.getDate());
        System.out.println("fechJ: " + fechaJ);
        Date fecha = null;
        try {
            fecha = NFormt.parse(fechaJ);
            vistaEgres.getDtcFechEgreso().setDate(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.out.println("Fecha mio: " + fecha);
        return fecha;
    }

    public void guardarDatosEgreso() {

    }

    public void llenarComboCantones() throws ParseException, org.json.simple.parser.ParseException {
        modelComb = new DefaultComboBoxModel();
        jocarray = jo.obtenerCanton();
        for (Json_object_consulta o : jocarray) {
            modelComb.addElement(o.getValor());
        }
        vistaEgres.getCbxCanton().setModel(modelComb);
    }

    public void llenarcomboParentesco() throws org.json.simple.parser.ParseException {
        modelComb = new DefaultComboBoxModel();
        jocarray = jo.obtenerParntesco();
        for (Json_object_consulta o : jocarray) {
            modelComb.addElement(o.getValor());
        }
        vistaEgres.getCbxParentesco().setModel(modelComb);
    }

    public void insertarImg() {
        vistaEgres.getLblImg().setIcon(null);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG;*.PNG)", "jpg", "jpeg", "png");//filtro de selecion de archivos

        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Seleccionar Foto");

        archivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int est = archivo.showOpenDialog(null);
        if (est == JFileChooser.APPROVE_OPTION) {
            try {
                egresoModelDb.setFis(new FileInputStream(archivo.getSelectedFile()));
                egresoModelDb.setLongBytes((int) archivo.getSelectedFile().length());
//                fis = new FileInputStream(archivo.getSelectedFile());
//                longBytes = (int) archivo.getSelectedFile().length();

                try {
                    Image icono = ImageIO.read(archivo.getSelectedFile()).getScaledInstance(vistaEgres.getLblImgApliada().getWidth(), vistaEgres.getLblImgApliada().getHeight(), Image.SCALE_DEFAULT);
                    vistaEgres.getLblImgApliada().setIcon(new ImageIcon(icono));
                    ImageIcon icon = new ImageIcon(icono);
//                    Image icono2 = ImageIO.read(archivo.getSelectedFile()).getScaledInstance(vistaEgres.getLblImgApliada().getWidth(), vistaEgres.getLblImgApliada().getHeight(), Image.SCALE_DEFAULT);                   
                    vistaEgres.getLblImg().setIcon(new ImageIcon(icon.getImage().getScaledInstance(vistaEgres.getLblImg().getHeight(), vistaEgres.getLblImg().getHeight(), Image.SCALE_SMOOTH)));//ajusta la imagen al tamaño de el label
                    vistaEgres.getLblImgApliada().updateUI();
                    vistaEgres.getLblImg().updateUI();
                    vistaEgres.getLblImg().setHorizontalAlignment(JLabel.CENTER);//centra la imgaen en el label
                    vistaEgres.getLblImg().setVerticalAlignment(JLabel.CENTER);//centra la imgaen en el label
                    foto = egresoModelDb.getFis();
                    longByte = egresoModelDb.getLongBytes();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al Cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al Cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

}
