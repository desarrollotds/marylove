package marylove.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.CierreDB;
import marylove.DBmodelo.RegisActuacionesDB;
import marylove.DBmodelo.fichaLegalDB;
import marylove.DBmodelo.victimaDB;
import marylove.models.Cierre;
import marylove.models.Register_Actuaciones;
import marylove.vista.FichaRegistroActuaciones;

/**
 *
 * @author vasquez
 */
public class ControlFichaRegisActu extends Validaciones {

    private FichaRegistroActuaciones vFRA;
    private Cierre mC;
    private CierreDB cDB;
    private Register_Actuaciones mRA;
    private RegisActuacionesDB raDB;

    DefaultTableModel modeloTab;
    DefaultTableModel modeloTab2;
    fichaLegalDB fDB = new fichaLegalDB();
    Calendar cal = new GregorianCalendar();

    public ControlFichaRegisActu() throws Exception {
    }

    public ControlFichaRegisActu(FichaRegistroActuaciones vFRA, Cierre mC, CierreDB cDB, Register_Actuaciones mRA, RegisActuacionesDB raDB) throws Exception {
        this.vFRA = vFRA;
        this.mC = mC;
        this.cDB = cDB;
        this.mRA = mRA;
        this.raDB = raDB;
    }

    public void iniciarCFichaRegusActu() {
        // mostrar la fecha actual en el a JDateChooser
        vFRA.getFechaRegistroActuaciones().setCalendar(cal);
        vFRA.getJdcRAFechLimite().setCalendar(cal);
        vFRA.getJdcCFechLimite().setCalendar(cal);
        vFRA.getJdcCFechCier().setCalendar(cal);
        // validaciones
        vFRA.getTxtCedula().addKeyListener(validarCedula(vFRA.getTxtCedula()));
        vFRA.getTxtNombre().addKeyListener(validarLetras(vFRA.getTxtNombre()));
        vFRA.getTxtCodigo().addKeyListener(validarNumeros(vFRA.getTxtCodigo()));

        vFRA.getTxtCedula().addKeyListener(enter1(vFRA.getTxtCedula(), vFRA.getTxtNombre(), vFRA.getTxtCodigo()));
        vFRA.getTxtCedula().addKeyListener(enterTabla());
        //control de botones
        vFRA.getBtnAñadirActuacion().addActionListener(e -> anadirRA());
        vFRA.getBtnEditarActuacion().addActionListener(e -> editar(1));
        vFRA.getBtnAñadirCierre().addActionListener(e -> anadirC());
        vFRA.getBtnEditarCierre().addActionListener(e -> editar(2));
        vFRA.getBtnEliminarActuacion().addActionListener(e -> eliminarDatos(1));
        vFRA.getBtnEliminarCierre().addActionListener(e -> eliminarDatos(2));

        vFRA.getBtnGuarRA().addActionListener(e -> ingreRegisAct());
        vFRA.getBtnRACanc().addActionListener(e -> borrarDatos(1));
        vFRA.getBtnCGuar().addActionListener(e -> ingreCierre());
        vFRA.getBtnCCanc().addActionListener(e -> borrarDatos(2));

        vFRA.getBtnLimp().addActionListener(e -> borrarT());

    }

    public Register_Actuaciones datosRA() {
        mRA.setReg_id(Integer.parseInt(vFRA.getLabRAId().getText()));
        mRA.setLegal_id(fDB.obtenerLegal_Id(Integer.parseInt(vFRA.getTxtCodigo().getText())));
        mRA.setNotf_dilig(vFRA.getTxtRANotDil().getText());
        mRA.setFecha_limite(obtenerFecha(vFRA.getJdcRAFechLimite()));
        mRA.setObserv(vFRA.getTxtRAObs().getText());
        return mRA;
    }

    public Cierre datosCierre() {
        mC.setCierre_id(Integer.parseInt(vFRA.getLabCId().getText()));
        mC.setLegal_id(fDB.obtenerLegal_Id(Integer.parseInt(vFRA.getTxtCodigo().getText())));
        mC.setNotifi_dilig(vFRA.getTxtCNotDil().getText());
        mC.setFecha_limite(obtenerFecha(vFRA.getJdcCFechLimite()));
        mC.setObservacion(vFRA.getTxtCObs().getText());
        mC.setFecha_cierre(obtenerFecha(vFRA.getJdcCFechCier()));
        return mC;
    }

    public void ingreRegisAct() {
        if (vFRA.getBtnGuarRA().getText().equals("Editar")) {
            if (raDB.actualizar(datosRA())) {
                vFRA.getJdiRegActu().setVisible(false);
                mostrarTabla(1);
                borrarDatos(1);
                vFRA.getBtnGuarRA().setText("Guardar");
            } else {
                JOptionPane.showMessageDialog(null, "Datos no actualizados");
            }
        } else {
            if (raDB.ingreRegis_Actu(datosRA())) {
                vFRA.getJdiRegActu().setVisible(false);
                borrarDatos(1);
                mostrarTabla(1);
            } else {
                JOptionPane.showMessageDialog(null, "Datos no ingresar");
            }
        }

    }

    public void ingreCierre() {
        if (vFRA.getBtnCGuar().getText().equals("Editar")) {
            if (cDB.actualizar(datosCierre())) {
                vFRA.getJdiCierre().setVisible(false);
                mostrarTabla(2);
                vFRA.getBtnCGuar().setText("Guardar");
                borrarDatos(2);
            } else {
                JOptionPane.showMessageDialog(null, "Datos no ingresar");
            }
        } else {
            if (cDB.ingreCierre(datosCierre())) {
                vFRA.getJdiCierre().setVisible(false);
                mostrarTabla(2);
                borrarDatos(2);
            } else {
                JOptionPane.showMessageDialog(null, "Datos no ingresar");
            }
        }

    }

    public void visualizarDialog(JDialog dialog) {
        dialog.setVisible(true);
        dialog.setSize(429, 295);
        dialog.setLocationRelativeTo(null);
    }

    public void mostrarTabla(int fun) {
        List<Register_Actuaciones> listAR;
        List<Cierre> listC;
        try {
            if (fun == 1) {
                int canFilas = vFRA.getJtTablaActuaciones().getRowCount();
                for (int a = canFilas - 1; a >= 0; a--) {
                    modeloTab.removeRow(a);
                }
                modeloTab = (DefaultTableModel) vFRA.getJtTablaActuaciones().getModel();
                listAR = raDB.obtenerRegisAct(Integer.parseInt(vFRA.getTxtCodigo().getText()));
                int columnas = modeloTab.getColumnCount();
                for (int i = 0; i < listAR.size(); i++) {
                    modeloTab.addRow(new Object[columnas]);
                    vFRA.getJtTablaActuaciones().setValueAt(listAR.get(i).getReg_id(), i, 0);
                    vFRA.getJtTablaActuaciones().setValueAt(listAR.get(i).getNotf_dilig(), i, 1);
                    vFRA.getJtTablaActuaciones().setValueAt(listAR.get(i).getFecha_limite(), i, 2);
                    vFRA.getJtTablaActuaciones().setValueAt(listAR.get(i).getObserv(), i, 3);
                }
            } else if (fun == 2) {
                int canFilas2 = vFRA.getJtTablaCierre().getRowCount();
                for (int a = canFilas2 - 1; a >= 0; a--) {
                    modeloTab2.removeRow(a);
                }
                modeloTab2 = (DefaultTableModel) vFRA.getJtTablaCierre().getModel();
                listC = cDB.obtenerCierre(Integer.parseInt(vFRA.getTxtCodigo().getText()));

                int columnas2 = modeloTab2.getColumnCount();
                for (int j = 0; j < listC.size(); j++) {
                    modeloTab2.addRow(new Object[columnas2]);
                    vFRA.getJtTablaCierre().setValueAt(listC.get(j).getCierre_id(), j, 0);
                    vFRA.getJtTablaCierre().setValueAt(listC.get(j).getNotifi_dilig(), j, 1);
                    vFRA.getJtTablaCierre().setValueAt(listC.get(j).getFecha_limite(), j, 2);
                    vFRA.getJtTablaCierre().setValueAt(listC.get(j).getObservacion(), j, 3);
                    vFRA.getJtTablaCierre().setValueAt(listC.get(j).getFecha_cierre(), j, 4);
                }
            }

        } catch (Exception e) {
            System.out.println("error al cargar tablas " + e.getMessage());
        }

    }

    public void editar(int edit) {
        if (edit == 1) {
            DefaultTableModel moTablaRA = (DefaultTableModel) vFRA.getJtTablaActuaciones().getModel();
            int fsel = vFRA.getJtTablaActuaciones().getSelectedRow();
            if (fsel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila lista", "Verificación", JOptionPane.WARNING_MESSAGE);
            } else {
                vFRA.getLabRAId().setText(moTablaRA.getValueAt(vFRA.getJtTablaActuaciones().getSelectedRow(), 0).toString());
                vFRA.getTxtRANotDil().setText(moTablaRA.getValueAt(vFRA.getJtTablaActuaciones().getSelectedRow(), 1).toString());
                ingreDATE(vFRA.getJdcRAFechLimite(), moTablaRA.getValueAt(vFRA.getJtTablaActuaciones().getSelectedRow(), 2).toString());
                vFRA.getTxtRAObs().setText(moTablaRA.getValueAt(vFRA.getJtTablaActuaciones().getSelectedRow(), 3).toString());
                vFRA.getBtnGuarRA().setText("Editar");
                visualizarDialog(vFRA.getJdiRegActu());
            }
        } else if (edit == 2) {
            DefaultTableModel moTablaC = (DefaultTableModel) vFRA.getJtTablaCierre().getModel();
            int fsel = vFRA.getJtTablaCierre().getSelectedRow();
            if (fsel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila lista", "Verificación", JOptionPane.WARNING_MESSAGE);
            } else {
                vFRA.getLabCId().setText(moTablaC.getValueAt(vFRA.getJtTablaCierre().getSelectedRow(), 0).toString());
                vFRA.getTxtCNotDil().setText(moTablaC.getValueAt(vFRA.getJtTablaCierre().getSelectedRow(), 1).toString());
                ingreDATE(vFRA.getJdcCFechLimite(), moTablaC.getValueAt(vFRA.getJtTablaCierre().getSelectedRow(), 2).toString());
                vFRA.getTxtCObs().setText(moTablaC.getValueAt(vFRA.getJtTablaCierre().getSelectedRow(), 3).toString());
                ingreDATE(vFRA.getJdcCFechCier(), moTablaC.getValueAt(vFRA.getJtTablaCierre().getSelectedRow(), 4).toString());
                vFRA.getBtnCGuar().setText("Editar");
                visualizarDialog(vFRA.getJdiCierre());
            }
        }

    }

    public void borrarDatos(int att) {
        if (att == 1) {
            vFRA.getTxtRANotDil().setText("");
            vFRA.getTxtRAObs().setText("");
            vFRA.getJdcRAFechLimite().setCalendar(cal);
        } else if (att == 2) {
            vFRA.getTxtCNotDil().setText("");
            vFRA.getTxtCObs().setText("");
            vFRA.getJdcCFechLimite().setCalendar(cal);
            vFRA.getJdcCFechCier().setCalendar(cal);
        }
    }

    public void anadirRA() {
        vFRA.getBtnGuarRA().setText("Guardar");
        borrarDatos(1);
        visualizarDialog(vFRA.getJdiRegActu());
        vFRA.getLabRAId().setText("" + raDB.maxID());
    }

    public void anadirC() {
        vFRA.getBtnCGuar().setText("Guardar");
        borrarDatos(2);
        visualizarDialog(vFRA.getJdiCierre());
        vFRA.getLabCId().setText("" + cDB.maxID());
    }

    public void borrarT() {
        vFRA.getTxtNombre().setText("");
        vFRA.getTxtCedula().setText("");
        vFRA.getTxtCodigo().setText("");
        int canFilas = vFRA.getJtTablaActuaciones().getRowCount();
        for (int a = canFilas - 1; a >= 0; a--) {
            modeloTab.removeRow(a);
        }
        int canFilas2 = vFRA.getJtTablaCierre().getRowCount();
        for (int a = canFilas2 - 1; a >= 0; a--) {
            modeloTab2.removeRow(a);
        }
    }

    public KeyListener enterTabla() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                victimaDB vDB = new victimaDB();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!vFRA.getTxtCodigo().getText().equals("")) {
                        mostrarTabla(1);
                        mostrarTabla(2);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        return kn;
    }
    
    public boolean consulta(String tipo){
        String botones[]= {"Si","No"};
        boolean resp = false;
        int seleccion = JOptionPane.showOptionDialog(vFRA, "Desea eliminar el dato de "+tipo, "Eliminado", 0, 0, null, botones, vFRA);
        if (seleccion == JOptionPane.YES_OPTION) {
            resp = true;
        }else if (seleccion == JOptionPane.NO_OPTION) {
            resp = false;
        }
        return resp;
    }
    
    public void eliminarDatos(int elim){
        int id = 0;
        if (elim == 1) {
            DefaultTableModel moTablaRA = (DefaultTableModel) vFRA.getJtTablaActuaciones().getModel();
            int fsel = vFRA.getJtTablaActuaciones().getSelectedRow();
            if (fsel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila de la lista", "Verificación", JOptionPane.WARNING_MESSAGE);
            } else {
                id = Integer.parseInt(moTablaRA.getValueAt(vFRA.getJtTablaActuaciones().getSelectedRow(), 0).toString());
                if (consulta("Actuaciones")) {
                    if (raDB.elimnarRA(id)) {
                        mostrarTabla(1);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al eliminar la Accion");
                    }
                }
                
            }
        } else if (elim == 2) {
            DefaultTableModel moTablaC = (DefaultTableModel) vFRA.getJtTablaCierre().getModel();
            int fsel = vFRA.getJtTablaCierre().getSelectedRow();
            if (fsel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila de la lista", "Verificación", JOptionPane.WARNING_MESSAGE);
            } else {
                id = Integer.parseInt(moTablaC.getValueAt(vFRA.getJtTablaCierre().getSelectedRow(), 0).toString());
                if (consulta("Cierre")) {
                    if (cDB.elimnarCierre(id)) {
                        mostrarTabla(2);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al eliminar el cierre");
                    }
                }
            }
        }
    }
}
