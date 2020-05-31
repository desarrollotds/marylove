package marylove.controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.EgresoDB;
import marylove.DBmodelo.jsonDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.Direccion;
import marylove.models.Egreso;
import marylove.models.Json_object_consulta;
import marylove.vista.FichaEgreso;

public class ControladorFichaEgreso extends Validaciones {

    private final Direccion dir;
    private final Egreso egresoModel;
    private final FichaEgreso vistaEgres;
    private final EgresoDB egresoModelDb;
    private final DireccionDB dirDB;
    DefaultComboBoxModel modelComb;
    ArrayList<Json_object_consulta> jocarray;
    Calendar cal = new GregorianCalendar();
    String idp = null;
    DefaultTableModel modeloTabDlReg;

    JFileChooser archivo = new JFileChooser();
    private FileInputStream foto = null;
    private int longByte = 0;
//
//    File archivo;
//    private byte[] imagen;
//    private int lbtimg;
//    public FileInputStream entrada;
//    FileNameExtensionFilter filimg = new FileNameExtensionFilter("Formato de archivo JPEG(*.JPG;*PNG*) ", "jpg", "png", "jpeg");
////    JFileChooser imagenSelec = new JFileChooser();

    jsonDB jo = new jsonDB();

    public ControladorFichaEgreso(Direccion dir, Egreso egresoModel, FichaEgreso vistaEgres, EgresoDB egresoModelDb, DireccionDB dirDB) throws Exception {
        this.dir = dir;
        this.egresoModel = egresoModel;
        this.vistaEgres = vistaEgres;
        this.egresoModelDb = egresoModelDb;
        this.dirDB = dirDB;
    }

    public void iniciCtrlEgreso() throws ParseException, org.json.simple.parser.ParseException {
        //AbrirVentEgreso();
        inicioRapidoVentan();
        llenarcomboParentesco();
        cargarActulizar();
        popTable();
        validaciones();

        vistaEgres.getBtnBuscar().addActionListener(e -> eventoBuscarEgreso());
        vistaEgres.getDtcFechEgreso().setCalendar(cal);

        vistaEgres.getTxtCedula().addKeyListener(enter1(vistaEgres.getTxtCedula(), vistaEgres.getTxtNombresApellidos(), vistaEgres.getTxtCodigo()));

        vistaEgres.getJdBtnCancelar().addActionListener(e -> botonCancelarJDg(vistaEgres.getjDialogIngDirecc()));

        vistaEgres.getBtnGuardar().addActionListener(e -> {
            try {
                egresoDatos();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFichaEgreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//        vistaEgres.getBtnIngreImg().addActionListener(e -> ingresarIm(vistaEgres.getLblImgApliada(), vistaEgres.getLblImg()));
        vistaEgres.getBtnIngreImg().addActionListener(e -> insertarImg());
        vistaEgres.getBtnCancelar().addActionListener(e -> LimpiarCancelar());

        vistaEgres.getLblImg().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                vistaEgres.getDlgAmpliarImg().setSize(1200, 700);
                vistaEgres.getDlgAmpliarImg().setLocationRelativeTo(null);
                vistaEgres.getDlgAmpliarImg().setVisible(true);
            }
        }
        );

        vistaEgres.getBtnVerReg().addActionListener(e -> abrirDlgRegstrados());
        vistaEgres.getBtnDlgCancelar().addActionListener(e -> botonCancelarJDg(vistaEgres.getDlgRegistros()));
        vistaEgres.getBtnActualizar().addActionListener(e -> cargarActulizar());
        vistaEgres.getBtnEditarEgreso().addActionListener(e -> EditarBtn());
    }

    public void validaciones() {
        vistaEgres.getTxtTelefonoBeneficiaria().addKeyListener(validarNumeros(vistaEgres.getTxtTelefonoBeneficiaria()));
        vistaEgres.getTxtTelefonoBeneficiaria1().addKeyListener(validarNumeros(vistaEgres.getTxtTelefonoBeneficiaria1()));
        vistaEgres.getTxtCelular().addKeyListener(validarNumeros(vistaEgres.getTxtCelular()));
        vistaEgres.getTxtCelular1().addKeyListener(validarNumeros(vistaEgres.getTxtCelular1()));
        vistaEgres.getTxtTelefonoReferencia().addKeyListener(validarNumeros(vistaEgres.getTxtTelefonoReferencia()));
        vistaEgres.getTxtTelefonoReferencia1().addKeyListener(validarNumeros(vistaEgres.getTxtTelefonoReferencia1()));

    }

    public void inicioRapidoVentan() {
        vistaEgres.getDlgAmpliarImg().setSize(1200, 700);
        vistaEgres.getDlgAmpliarImg().setVisible(true);
        vistaEgres.getDlgAmpliarImg().setVisible(false);
    }

    public void LimpiarCancelar() {
        vistaEgres.getBtnGuardar().setEnabled(true);
        vistaEgres.getTxtCedula().setText("");
        vistaEgres.getTxtNombresApellidos().setText("");
        vistaEgres.getTxtCodigo().setText("");
        vistaEgres.getDtcFechEgreso().setCalendar(cal);
        vistaEgres.getTxaSituacion().setText("");
        vistaEgres.getTxtTelefonoBeneficiaria().setText("");
        vistaEgres.getTxtCelular().setText("");
        vistaEgres.getTxtTelefonoReferencia().setText("");
        vistaEgres.getTxtDireccion().setText("");
        vistaEgres.getTxtProvincia().setText("");
        vistaEgres.getTxtCanton().setText("");
    }

    public void botonCancelarJDg(JDialog canVista) {
        canVista.setVisible(false);
    }

    public void abrirDlgRegstrados() {
        vistaEgres.getDlgRegistros().setVisible(true);
        vistaEgres.getDlgRegistros().setSize(1200, 700);
    }

    public void MustraVentana() {
        vistaEgres.getjDialogIngDirecc().setVisible(true);
        vistaEgres.getjDialogIngDirecc().setSize(400, 600);
        vistaEgres.getjDialogIngDirecc().setResizable(false);
        vistaEgres.getjDialogIngDirecc().setLocationRelativeTo(null);
    }

    public void AbrirVentEgreso() {
        vistaEgres.setVisible(true);
//        vistaEgres.getBtnGuardar().setEnabled(false);
        vistaEgres.setLocationRelativeTo(null);
    }

    public void egresoDatos() throws SQLException {
        if (vistaEgres.getTxtCedula().getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese cédula", "Campos vacío", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaEgres.getDtcFechEgreso().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Fecha Egreso vacío", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaEgres.getTxtCodigo().getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "No existe Codigo interno, vuelva a intentarlo", "Error interno", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaEgres.getTxaSituacion().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingrese una situacion", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (vistaEgres.getTxtCelular().getText().length() == 0) {
                            JOptionPane.showMessageDialog(null, "Ingrese celular del Beneficiario", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                        } else {
                            if (vistaEgres.getTxtTelefonoBeneficiaria().getText().length() == 0) {
                                JOptionPane.showMessageDialog(null, "Ingrese teléfono del Beneficiario", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                            } else {
                                if (vistaEgres.getTxtProvincia().getText().length() == 0) {
                                    JOptionPane.showMessageDialog(null, "Ingrese Provincia", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    if (vistaEgres.getTxtCanton().getText().length() == 0) {
                                        JOptionPane.showMessageDialog(null, "Ingrese Cantón", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        if (vistaEgres.getTxtDireccion().getText().length() == 0) {
                                            JOptionPane.showMessageDialog(null, "Ingrese Dirección", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                                        } else {
                                            if (vistaEgres.getTxtTelefonoReferencia().getText().length() == 0) {
                                                JOptionPane.showMessageDialog(null, "Ingrese Teléfono referencia", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                                            } else {
                                                egresoModelDb.setVictima_codigo(Integer.parseInt(vistaEgres.getTxtCodigo().getText()));
                                                egresoModelDb.setPersonal_codigo(egresoModelDb.verifiUserP(personal_cod));
//                                                
                                                egresoModelDb.setEgreso_fecha(obtenerFecha3(vistaEgres.getDtcFechEgreso()));
                                                egresoModelDb.setEgreso_situacion(vistaEgres.getTxaSituacion().getText());
                                                egresoModelDb.setCanton(vistaEgres.getTxtCanton().getText());
                                                egresoModelDb.setProvincia(vistaEgres.getTxtProvincia().getText());
                                                egresoModelDb.setPer_refe_parentesco(vistaEgres.getCbxParentesco().getSelectedItem().toString());
                                                egresoModelDb.setTelefono(vistaEgres.getTxtTelefonoReferencia().getText());
                                                egresoModelDb.setDireccion(vistaEgres.getTxtDireccion().getText());
                                                egresoModelDb.setCelarEgreso(vistaEgres.getTxtCelular().getText());
                                                egresoModelDb.setTelefonoEgreso(vistaEgres.getTxtTelefonoBeneficiaria().getText());
                                                if (egresoModelDb.IngresarEgreso()) {
                                                    JOptionPane.showMessageDialog(null, "Datos Egreso, agregados correctamente");
                                                    cargarActulizar();
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
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
    }

    public Date obtenerFecha3(JDateChooser fech) {
        SimpleDateFormat NFormt = new SimpleDateFormat("yyyy/MM/dd");
        String fechaJ = NFormt.format(fech.getDate());
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

    public void llenarcomboParentesco() throws org.json.simple.parser.ParseException {
        modelComb = new DefaultComboBoxModel();
        jocarray = jo.obtenerParntesco();
        for (Json_object_consulta o : jocarray) {
            modelComb.addElement(o.getValor());
        }
        vistaEgres.getCbxParentesco().setModel(modelComb);
        vistaEgres.getCbxParentesco1().setModel(modelComb);
    }

    // metodos de ingreso de imagenes
//    public byte[] imgcargar(File archivo, int logbyte) {//trasformar imagen ingresada en byte
//        byte[] img = new byte[logbyte];
//        try {
//            entrada = new FileInputStream(archivo);
//            entrada.read(img);
//
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "imagen: " + ex);
//            img = null;
//        }
//        System.out.println("trandorma img: " + img);
//        return img;
//    }
    private byte[] convertByte(int myImg) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(myImg).array();
    }

//    private void ingresarIm(JLabel label, JLabel label2) { // metodo para ingresar la imagen en formato jpeg,png,etc
//        Image imgijl;
//        ImageIcon imgEscalada;
//        ImageIcon imgEscalada2;
//        imagenSelec.setDialogTitle("Buscar imagen");
//        imagenSelec.setFileFilter(filimg);
//        imagenSelec.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        int estado = imagenSelec.showOpenDialog(null);
//        if (estado == JFileChooser.APPROVE_OPTION) {
//            archivo = imagenSelec.getSelectedFile();
//            //necesitamos saber la cantidad de bytes
//            lbtimg = ((int) imagenSelec.getSelectedFile().length());
//            System.out.print("imagen.ength: " + lbtimg);
//            imagen = imgcargar(archivo, lbtimg);
////            imagen = convertByte(lbtimg);
////            egresoModelDb.setCroquis(imagen);
//            imgijl = new ImageIcon(imgcargar(archivo, lbtimg)).getImage();
//            imgEscalada = new ImageIcon(imgijl.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
//            imgEscalada2 = new ImageIcon(imgijl.getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_DEFAULT));
//            label.setIcon(imgEscalada);
//            label2.setIcon(imgEscalada2);
//            label.updateUI();
//            label2.updateUI();
//        }
//    }
    public void cargarActulizar() {
        int canFilas = vistaEgres.getTblDlgRegistros().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabDlReg.removeRow(i);
        }

        modeloTabDlReg = (DefaultTableModel) vistaEgres.getTblDlgRegistros().getModel();
        List<Egreso> lista;
        try {
            lista = egresoModelDb.listaEgresos();
            int columnas = modeloTabDlReg.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabDlReg.addRow(new Object[columnas]);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getEgreso_codigo(), i, 0);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getPersona_nombre() + lista.get(i).getPersona_apellido(), i, 2);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getEgreso_situacion(), i, 3);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getTelefonoEgreso(), i, 4);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getCelarEgreso(), i, 5);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getProvincia(), i, 6);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getCanton(), i, 7);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getPer_refe_parentesco(), i, 8);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getTelefono(), i, 9);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getDireccion(), i, 10);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getEgreso_fecha(), i, 11);
            }

        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaEgreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AbrirEditarEgreso() {
        vistaEgres.getDlgEditar().setVisible(true);
        vistaEgres.getDlgEditar().setSize(720, 700);
        vistaEgres.getDlgEditar().setLocationRelativeTo(null);
    }

    public void popTable() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemBorrar = new JMenuItem("BORRAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarEgreso();
        });
        itemBorrar.addActionListener((ActionEvent e) -> {
            DefaultTableModel modeloTbl = null;
            eliminar(modeloTbl, vistaEgres.getTblDlgRegistros());
        });
        pM.add(itemEdit);
        pM.add(itemBorrar);
        vistaEgres.getTblDlgRegistros().setComponentPopupMenu(pM);
    }

    public void EditarEgreso() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaEgres.getTblDlgRegistros().getModel();
        int fsel = vistaEgres.getTblDlgRegistros().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 0).toString();
            String ced = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 1).toString();
            String nomApe = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 2).toString();
            String situacion = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 3).toString();
            String tel = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 4).toString();
            String cel = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 5).toString();
            String prov = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 6).toString();
            String canton = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 7).toString();
            String perRef = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 8).toString();
            String telRef = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 9).toString();
            String dir = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 10).toString();
            //String fec = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 11).toString();

            vistaEgres.getTxtCodigo1().setText(cod);
            vistaEgres.getTxtCedula1().setText(ced);
            vistaEgres.getTxtNombresApellidos1().setText(nomApe);
            vistaEgres.getTxaSituacion1().setText(situacion);
            vistaEgres.getTxtTelefonoBeneficiaria1().setText(tel);
            vistaEgres.getTxtCelular1().setText(cel);
            vistaEgres.getTxtProvincia1().setText(prov);
            vistaEgres.getTxtCanton1().setText(canton);
            vistaEgres.getCbxParentesco1().setSelectedItem(perRef);
            vistaEgres.getTxtTelefonoReferencia1().setText(telRef);
            vistaEgres.getTxtDireccion1().setText(dir);
            //vistaEgres.getDtcFechEgreso1().setDate(ParseFecha(fec));

            vistaEgres.getDlgRegistros().setTitle("Editar Egreso");
            AbrirEditarEgreso();
        }
    }

    public static Date ParseFecha(String fecha)//De String a Date la Fecha
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public void EditarBtn() {
        egresoModelDb.setEgreso_codigo(Integer.parseInt(vistaEgres.getTxtCodigo1().getText()));
        egresoModelDb.setPersona_cedula(vistaEgres.getTxtCedula1().getText());
        egresoModelDb.setPersona_nombre(vistaEgres.getTxtNombresApellidos1().getText());
        egresoModelDb.setEgreso_situacion(vistaEgres.getTxaSituacion1().getText());
        egresoModelDb.setTelefonoEgreso(vistaEgres.getTxtTelefonoBeneficiaria1().getText());
        egresoModelDb.setCelarEgreso(vistaEgres.getTxtCelular1().getText());
        egresoModelDb.setProvincia(vistaEgres.getTxtProvincia1().getText());
        egresoModelDb.setCanton(vistaEgres.getTxtCanton1().getText());
        egresoModelDb.setPer_refe_parentesco(vistaEgres.getCbxParentesco1().getSelectedItem().toString());
        egresoModelDb.setTelefono(vistaEgres.getTxtTelefonoReferencia1().getText());
        egresoModelDb.setDireccion(vistaEgres.getTxtDireccion1().getText());
        //egresoModelDb.setEgreso_fecha(vistaEgres.getDtcFechEgreso1().getDate());

        if (egresoModelDb.actualizarEgreso()) {
            JOptionPane.showMessageDialog(null, "Datos Egreso editados correctamente");
            vistaEgres.getDlgEditar().setVisible(false);
            cargarActulizar();

            vistaEgres.getTxtCodigo1().setText("");
            vistaEgres.getTxtCedula1().setText("");
            vistaEgres.getTxtNombresApellidos1().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Error al editar Datos.");

        }
    }

    public void eventoBuscarEgreso() {
        DefaultTableModel tb = (DefaultTableModel) vistaEgres.getTblDlgRegistros().getModel();
        int a = vistaEgres.getTblDlgRegistros().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        DefaultTableModel modeloTabDlRegt = (DefaultTableModel) vistaEgres.getTblDlgRegistros().getModel();
        List<Egreso> lista;
        try {
            lista = egresoModelDb.buscarEgreso(vistaEgres.getTxtBuscar().getText());
            int columnas = modeloTabDlRegt.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabDlRegt.addRow(new Object[columnas]);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getEgreso_codigo(), i, 0);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getPersona_nombre() + lista.get(i).getPersona_apellido(), i, 2);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getEgreso_situacion(), i, 3);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getTelefonoEgreso(), i, 4);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getCelarEgreso(), i, 5);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getProvincia(), i, 6);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getCanton(), i, 7);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getPer_refe_parentesco(), i, 8);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getTelefono(), i, 9);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getDireccion(), i, 10);
                vistaEgres.getTblDlgRegistros().setValueAt(lista.get(i).getEgreso_fecha(), i, 11);
            }
            if (vistaEgres.getTxtBuscar().getText().length() == 0) {
                cargarActulizar();
            }
        } catch (Exception ex) {
            Logger.getLogger(ControlEvaluacionPlanVida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //////////////////Eliminar 
    private void eliminar(DefaultTableModel modeloTabla, JTable tabla) {

        int fsel = tabla.getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                modeloTabla = (DefaultTableModel) tabla.getModel();
                String cod = modeloTabla.getValueAt(tabla.getSelectedRow(), 0).toString();
                egresoModelDb.setEgreso_codigo(Integer.parseInt(cod));
                System.out.println(cod);
                if (egresoModelDb.EliminarEgreso()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    cargarActulizar();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }
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

                try {

                    Image icono = ImageIO.read(archivo.getSelectedFile()).getScaledInstance(vistaEgres.getLblImgApliada().getWidth(), vistaEgres.getLblImgApliada().getHeight(), Image.SCALE_DEFAULT);
                    vistaEgres.getLblImgApliada().setIcon(new ImageIcon(icono));
                    ImageIcon icon = new ImageIcon(icono);
//                    Image icono2 = ImageIO.read(archivo.getSelectedFile()).getScaledInstance(vistaEgres.getLblImgApliada().getWidth(), vistaEgres.getLblImgApliada().getHeight(), Image.SCALE_DEFAULT);                   
                    vistaEgres.getLblImg().setIcon(new ImageIcon(icon.getImage().getScaledInstance(vistaEgres.getLblImg().getWidth(), vistaEgres.getLblImg().getHeight(), Image.SCALE_SMOOTH)));//ajusta la imagen al tamaño de el label
                    vistaEgres.getLblImgApliada().updateUI();
                    vistaEgres.getLblImg().updateUI();
                    vistaEgres.getLblImg().setHorizontalAlignment(JLabel.CENTER);//centra la imgaen en el label
                    vistaEgres.getLblImg().setVerticalAlignment(JLabel.CENTER);//centra la imgaen en el label
                    System.out.println("getFis: " + egresoModelDb.getFis());
                    System.out.println("getLongByte: " + egresoModelDb.getLongBytes());
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
