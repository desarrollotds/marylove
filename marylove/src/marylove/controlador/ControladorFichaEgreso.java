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

    jsonDB jo = new jsonDB();

    public ControladorFichaEgreso(Direccion dir, Egreso egresoModel, FichaEgreso vistaEgres, EgresoDB egresoModelDb, DireccionDB dirDB) throws Exception {
        this.dir = dir;
        this.egresoModel = egresoModel;
        this.vistaEgres = vistaEgres;
        this.egresoModelDb = egresoModelDb;
        this.dirDB = dirDB;
    }

    public void iniciCtrlEgreso() throws ParseException, org.json.simple.parser.ParseException {
        inicioRapidoVentan();
        llenarcomboParentesco();
        cargarActulizar();
        popTable();
        validaciones();
        inicIcon();
        cargarImagenApliada();
        // Validar componentes
        vistaEgres.getTxtNombresApellidos().addKeyListener(validarLetras(vistaEgres.getTxtNombresApellidos()));
        vistaEgres.getTxtCedula().addKeyListener(validarTodo(vistaEgres.getTxtCedula()));
        vistaEgres.getTxtCedula1().addKeyListener(validarTodo(vistaEgres.getTxtCedula1()));
        vistaEgres.getTxtCodigo().addKeyListener(validarNumeros(vistaEgres.getTxtCodigo()));
        vistaEgres.getTxtCodigo1().addKeyListener(validarNumeros(vistaEgres.getTxtCodigo1()));
        vistaEgres.getTxtCelular().addKeyListener(validarCelular(vistaEgres.getTxtCelular()));
        vistaEgres.getTxtCelular1().addKeyListener(validarCelular(vistaEgres.getTxtCelular1()));
        
        vistaEgres.getBtnBuscar().addActionListener(e -> eventoBuscarEgreso());
        vistaEgres.getDtcFechEgreso().setCalendar(cal);
        vistaEgres.getTxtCedula().addKeyListener(enter1(vistaEgres.getTxtCedula(), vistaEgres.getTxtNombresApellidos(), vistaEgres.getTxtCodigo()));
        vistaEgres.getBtnIngreImg().addActionListener(e -> insertarImg());
        vistaEgres.getBtnIngreImg1().addActionListener(e -> insertarImgDlg());
        vistaEgres.getBtnCancelar().addActionListener(e -> LimpiarCancelar());
        vistaEgres.getBtnVerReg().addActionListener(e -> abrirDlgRegstrados());
        vistaEgres.getBtnDlgCancelar().addActionListener(e -> botonCancelarJDg(vistaEgres.getDlgRegistros()));
        vistaEgres.getBtnActualizar().addActionListener(e -> cargarActulizar());
        vistaEgres.getBtnEditarEgreso().addActionListener(e -> EditarBtn());
        vistaEgres.getBtnGuardar().addActionListener(e -> {
            try {
                egresoDatos();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFichaEgreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void inicIcon() {
        vistaEgres.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistaEgres.getDlgAmpliarImg().setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistaEgres.getDlgEditar().setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistaEgres.getDlgRegistros().setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());

    }

    public void cargarImagenApliada() {
        vistaEgres.getLblImg().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                AbrImgAmpi();
            }
        }
        );
    }

    public void AbrImgAmpi() {
        vistaEgres.getDlgAmpliarImg().setSize(1200, 700);
        vistaEgres.getDlgAmpliarImg().setLocationRelativeTo(null);
        vistaEgres.getDlgAmpliarImg().setVisible(true);
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
        vistaEgres.getLblImg().setIcon(null);
        vistaEgres.getLblImg1().setIcon(null);
        vistaEgres.getLblImgApliada().setIcon(null);
    }

    public void botonCancelarJDg(JDialog canVista) {
        canVista.setVisible(false);
    }

    public void abrirDlgRegstrados() {
        vistaEgres.getDlgRegistros().setVisible(true);
        vistaEgres.getDlgRegistros().setSize(1200, 700);
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
                                                egresoModelDb.setEgreso_fecha(Fecha4(vistaEgres.getDtcFechEgreso()));
                                                egresoModelDb.setEgreso_situacion(vistaEgres.getTxaSituacion().getText());
                                                egresoModelDb.setCanton(vistaEgres.getTxtCanton().getText());
                                                egresoModelDb.setProvincia(vistaEgres.getTxtProvincia().getText());
                                                egresoModelDb.setPer_refe_parentesco(vistaEgres.getCbxParentesco().getSelectedItem().toString());
                                                egresoModelDb.setTelefono(vistaEgres.getTxtTelefonoReferencia().getText());
                                                egresoModelDb.setDireccion(vistaEgres.getTxtDireccion().getText());
                                                egresoModelDb.setCelarEgreso(vistaEgres.getTxtCelular().getText());
                                                egresoModelDb.setTelefonoEgreso(vistaEgres.getTxtTelefonoBeneficiaria().getText());
                                                try {
                                                    if (egresoModelDb.IngresarEgreso()) {
                                                        foto = null;
                                                        longByte = 0;
                                                        JOptionPane.showMessageDialog(null, "Datos Egreso, agregados correctamente");
                                                        cargarActulizar();
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                                                    }
                                                } catch (Exception ex) {
                                                    JOptionPane.showMessageDialog(null, "No hay imagen ");
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

    public Date Fecha4(JDateChooser fech) {
        Date dat = fech.getDate();
        long d = dat.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        return fecha;

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

    private byte[] convertByte(int myImg) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(myImg).array();
    }

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
        vistaEgres.getDlgEditar().setSize(750, 700);
        vistaEgres.getDlgEditar().setLocationRelativeTo(null);
    }

    public void popTable() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemImg = new JMenuItem("VER CROQUIS");
        JMenuItem itemBorrar = new JMenuItem("BORRAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            try {
                EditarEgreso();
            } catch (ParseException ex) {
                Logger.getLogger(ControladorFichaEgreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        itemImg.addActionListener((ActionEvent e) -> {
            verImgSelec();
        });
        itemBorrar.addActionListener((ActionEvent e) -> {
            DefaultTableModel modeloTbl = null;
            eliminar(modeloTbl, vistaEgres.getTblDlgRegistros());
        });
        pM.add(itemEdit);
        pM.add(itemBorrar);
        pM.add(itemImg);
        vistaEgres.getTblDlgRegistros().setComponentPopupMenu(pM);
    }

    public void EditarEgreso() throws ParseException {
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
            String fec = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 11).toString();

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
            vistaEgres.getDtcFechEgresoEdit().setCalendar(putFechJDchos(fec));
            vistaEgres.getLblImg1().setIcon(egresoModelDb.agregaImagen(cod));

            vistaEgres.getDlgRegistros().setTitle("Editar Egreso");
            AbrirEditarEgreso();
        }
    }

    public Calendar putFechJDchos(String fech) throws java.text.ParseException {
        Calendar calen = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        calen.setTime(sdf.parse(fech));
        return calen;
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
        egresoModelDb.setEgreso_fecha(Fecha4(vistaEgres.getDtcFechEgresoEdit()));

        if (foto == null) {
            if (egresoModelDb.actualizarEgreso()) {
                JOptionPane.showMessageDialog(null, "Datos Egreso editados correctamente");
                vistaEgres.getDlgEditar().setVisible(false);
                cargarActulizar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Editar Datos.");
            }
        } else {
            if (egresoModelDb.actualizarEgresoCroq()) {
                JOptionPane.showMessageDialog(null, "Datos Editados correctamente");
                foto = null;
                vistaEgres.getDlgEditar().setVisible(false);
                cargarActulizar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Editar Datos.");
            }
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
                    JOptionPane.showMessageDialog(null, "Error al Cargar la imagen \n Verifique la imagen", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al Cargar la imagen \n Verifique la imagen", "Error", JOptionPane.ERROR_MESSAGE);

            } catch (NullPointerException exc) {
                JOptionPane.showMessageDialog(null, "Error al Cargar la imagen \n Verifique la imagen", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception exce) {
                JOptionPane.showMessageDialog(null, "Error al Cargar la imagen \n Verifique la imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void insertarImgDlg() {
        vistaEgres.getLblImg1().setIcon(null);
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
                    Image icono = ImageIO.read(archivo.getSelectedFile()).getScaledInstance(vistaEgres.getLblImg1().getWidth(), vistaEgres.getLblImg1().getHeight(), Image.SCALE_DEFAULT);
                    vistaEgres.getLblImg1().setIcon(new ImageIcon(icono));
                    vistaEgres.getLblImg1().updateUI();
                    vistaEgres.getLblImg1().setHorizontalAlignment(JLabel.CENTER);//centra la imgaen en el label
                    vistaEgres.getLblImg1().setVerticalAlignment(JLabel.CENTER);//centra la imgaen en el label
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

//    public void MostrarImgSelec() {
//        vistaEgres.getTblDlgRegistros().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                if (vistaEgres.getTblDlgRegistros().getSelectedRow() > -1) {
//                    DefaultTableModel modeloTabla = (DefaultTableModel) vistaEgres.getTblDlgRegistros().getModel();
//                    String cod = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 0).toString();
//                    vistaEgres.getLbCargaRapImg().setIcon(egresoModelDb.agregaImagen(cod));
//                    vistaEgres.getLblImgApliada().setIcon(egresoModelDb.agregaImagen(cod));
//                    vistaEgres.getLblImgApliada().updateUI();
//                    vistaEgres.getLblImgApliada().setHorizontalAlignment(JLabel.CENTER);//centra la imgaen en el label
//                    vistaEgres.getLblImgApliada().setVerticalAlignment(JLabel.CENTER);
//                }
//            }
//        });
//    }
    public void verImgSelec() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaEgres.getTblDlgRegistros().getModel();
        int fsel = vistaEgres.getTblDlgRegistros().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaEgres.getTblDlgRegistros().getSelectedRow(), 0).toString();
            vistaEgres.getLblImgApliada().setIcon(egresoModelDb.AmpliarImagen(cod));
            vistaEgres.getLblImgApliada().updateUI();
            vistaEgres.getLblImgApliada().setHorizontalAlignment(JLabel.CENTER);//centra la imgaen en el label
            vistaEgres.getLblImgApliada().setVerticalAlignment(JLabel.CENTER);
            AbrImgAmpi();
        }
    }
}
