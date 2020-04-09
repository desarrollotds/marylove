package marylove.controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.DBmodelo.DefinicionObjetivosEspecificosDB;
import marylove.DBmodelo.DefinicionObjetivosGeneralDB;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.EgresoDB;
import marylove.conexion.Conexion;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.DefinicionObjetivosEspecifico;
import marylove.models.DefinicionObjetivosGeneral;
import marylove.models.Direccion;
import marylove.models.Egreso;
import marylove.vista.FichaEgreso;

public class ControladorFichaEgreso extends Validaciones {

    private Direccion dir;
    private Egreso egresoModel;
    private FichaEgreso vistaEgres;
    private EgresoDB egresoModelDb;
    private DireccionDB dirDB;

    Conexion conex = new Conexion();

    public ControladorFichaEgreso(Direccion dir, Egreso egresoModel, FichaEgreso vistaEgres, EgresoDB egresoModelDb, DireccionDB dirDB) {
        this.dir = dir;
        this.egresoModel = egresoModel;
        this.vistaEgres = vistaEgres;
        this.egresoModelDb = egresoModelDb;
        this.dirDB = dirDB;
    }

    public void iniciCtrlEgreso() {
        AbrirVentEgreso();
        fechaSistemaIni();
        vistaEgres.getTxtCedula().addKeyListener(enter1(vistaEgres.getTxtCedula(), vistaEgres.getTxtNombresApellidos(), vistaEgres.getTxtCodigo()));

        vistaEgres.getBtnDireccion().addActionListener(e -> MustraVentana());
        vistaEgres.getJdBtnGuardar().addActionListener(e -> datosDirecc());
        vistaEgres.getBtnGuardar().addActionListener(e -> egresoDatos());
        vistaEgres.getBtnGuardar().addActionListener(e -> guardarDatosEgreso());
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
}
