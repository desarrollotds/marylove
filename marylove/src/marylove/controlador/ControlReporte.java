package marylove.controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.IngresoDB;
import marylove.conexion.ConexionHi;
import marylove.vista.VistaReportes;
import org.json.simple.parser.ParseException;

public class ControlReporte extends Validaciones implements ActionListener {

    private VistaReportes vreportes;
    private ArrayList<String> anios;
    private DefaultComboBoxModel modelo;
    private IngresoDB i;
    private int bandera;
    private Validaciones validaciones;
    private ConexionHi conn = new ConexionHi();
    private DefaultTableModel modelotabla;
    private SentenciasSelect sentencias = new SentenciasSelect();
    private ExportarExcel excel = new ExportarExcel();

    public ControlReporte(VistaReportes vreportes) throws ParseException {
        this.vreportes = vreportes;
        this.vreportes.setVisible(true);

        this.vreportes.setIconImage(new ImageIcon(getClass().getResource("/iconos/logoml.png")).getImage());
        CargarCombo();

        this.vreportes.getPnlEspecificacion().setVisible(false);
        this.vreportes.getBtnReport().addActionListener(this);
        this.vreportes.getCbxTipoReporte().addActionListener(this);
        this.vreportes.getPnlEspecificacion().setVisible(false);
        this.vreportes.getTxtID().setVisible(false);
        this.vreportes.getLbid().setVisible(false);
        this.vreportes.getTxtCedula().setVisible(false);
        this.vreportes.getLbcedula().setVisible(false);
        this.vreportes.getjComboBoxAnios().setVisible(false);
        this.vreportes.getLbanio().setVisible(false);
        this.vreportes.getLbFecha().setVisible(false);
        this.vreportes.getDate().setVisible(false);
        this.vreportes.getLblTipoReporte().setText(this.vreportes.getCbxTipoReporte().getSelectedItem().toString());
        comprobarConexion();
    }

    //Método para la verificación de que exista una conexión a Internet
    private boolean showMessage() {
        try {
            Socket s = new Socket("www.google.com", 80);
            if (s.isConnected()) {
                /*JOptionPane.showMessageDialog(vreportes, "Bienvenido",
                        "MENSAJE DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);*/
            }
            return true;
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(vreportes, "Necesita una conexión a Internet",
                    "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vreportes.getCbxTipoReporte())) {
            if (vreportes.getCbxTipoReporte().getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(vreportes, "Seleccione un area de reporte", "Mensaje de Información", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    llenarComboAnio();
                    this.vreportes.getLblTipoReporte().setText(this.vreportes.getCbxTipoReporte().getSelectedItem().toString());
                    this.vreportes.getPnlEspecificacion().setVisible(true);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(vreportes, "Se ha producido un error inesperado con la base de datos",
                            "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 1) {
                    HabilitarAnio();
                    bandera = 1;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 2) {
                    HabilitarCedula();
                    HabilitarFecha();
                    bandera = 2;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 3) {
                    HabilitarCedula();
                    bandera = 3;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 4) {
                    HabilitarAnio();
                    bandera = 4;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 5) {
                    Habilitar();
                    bandera = 5;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 6) {
                    Habilitar();
                    bandera = 6;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 7) {
                    Habilitar();
                    bandera = 7;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 8) {
                    Habilitar();
                    bandera = 8;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 9) {
                    Habilitar();
                    bandera = 9;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 10) {
                    Habilitar();
                    bandera = 10;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 11) {
                    Habilitar();
                    bandera = 11;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 12) {
                    Habilitar();
                    bandera = 12;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 13) {
                    Habilitar();
                    bandera = 13;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 14) {
                    Habilitar();
                    bandera = 14;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 15) {
                    Habilitar();
                    bandera = 15;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 16) {
                    Habilitar();
                    bandera = 16;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 17) {
                    Habilitar();
                    bandera = 17;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 18) {
                    HabilitarCedula();
                    bandera = 18;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 19) {
                    HabilitarCedula();
                    HabilitarFecha();
                    bandera = 19;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 20) {
                    HabilitarCedula();
                    bandera = 20;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 21) {
                    HabilitarCedula();
                    HabilitarFecha();
                    bandera = 21;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 22) {
                    HabilitarCedula();
                    bandera = 22;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 23) {
                    HabilitarCedula();
                    bandera = 23;
                }
            }
        }

        //SELECCIONA LOS TIPOS DE REPORTES... IF VALIDO
        if (e.getSource().equals(vreportes.getBtnReport())) {

            if (bandera == 1) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteGeneral(vreportes.getjComboBoxAnios().getSelectedItem().toString());
                excel.Impresion(vreportes, modelotabla);
            }
            if (bandera == 2) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.ReporteBitacora(vreportes.getTxtCedula().getText(),obtenerFecha(vreportes.getDate()));
                    excel.Impresion(vreportes, modelotabla);
                }
            }
            if (bandera == 3) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.ReporteFormularios(vreportes.getTxtCedula().getText());
                    excel.Impresion(vreportes, modelotabla);
                }
            }
            if (bandera == 4) {
                if (vreportes.getjComboBoxAnios().getSelectedItem().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {

                }
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteAnio(vreportes.getjComboBoxAnios().getSelectedItem().toString());
                excel.Impresion(vreportes, modelotabla);
            }
            if (bandera == 5) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.ReporteAnamnesisDP(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 6) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisDPM(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 7) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
//                    modelotabla = sentencias.AnamnesisCF();
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 8) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisPE(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 9) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisCN(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 10) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisPDV(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 11) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisAA(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 12) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisDM(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 13) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisSCE(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 14) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisENNA(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 15) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisSNNA(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 16) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisRF(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 17) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.AnamnesisO(vreportes.getTxtID().getText());
                    excel.Impresion(vreportes, modelotabla);
                }

            }
            if (bandera == 18) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.PrimerEncuentro(vreportes.getTxtCedula().getText());
                    excel.Impresion(vreportes, modelotabla);
                }
            }
            if (bandera == 19) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.Avances_Terapeuticos(vreportes.getTxtCedula().getText(),obtenerFecha(vreportes.getDate()));
                    excel.Impresion(vreportes, modelotabla);
                }
            }
            if (bandera == 20) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.PlanAtencion(vreportes.getTxtCedula().getText());
                    excel.Impresion(vreportes, modelotabla);
                }
            }
             if (bandera == 21) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.PlanEmergente(vreportes.getTxtCedula().getText(),obtenerFecha(vreportes.getDate()));
                    excel.Impresion(vreportes, modelotabla);
                }
            }
             if (bandera == 22) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.HistorialClinico(vreportes.getTxtCedula().getText());
                    excel.Impresion(vreportes, modelotabla);
                }
            }
             if (bandera == 23) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.FichaLegal(vreportes.getTxtCedula().getText());
                    excel.Impresion(vreportes, modelotabla);
                }
            }

        }

        ///////////////////////
//        if (e.getSource().equals(vreportes.getBtnGenerar())) {
//            String parametroAño = vreportes.getjComboBoxAnios().getSelectedItem().toString();
//
//            if (bandera == 3) {
//                if (comprobarConexion()) {
//                    socialReport(parametroAño);
//                }
//            }
//        }
    }

    public void llenarComboAnio() throws SQLException {
        i = new IngresoDB();
        anios = i.obtenerAnio();
        modelo = new DefaultComboBoxModel();
        for (String o : anios) {
            modelo.addElement(o);
        }
        vreportes.getjComboBoxAnios().setModel(modelo);
    }

    //Reprote de Trabajo Social
//    private void socialReport(String parametroAño) {
//        ReporteTrabajoSocial reporte = new ReporteTrabajoSocial(vreportes, conn);
//        if (reporte.generateReport(parametroAño)) {
//            int resp = JOptionPane.showConfirmDialog(vreportes, "Se ha generado el reporte en la ruta: \n"
//                    + vreportes.getTxtRuta().getText() + ".pdf\n"
//                    + "¿Desea abrir el archivo ahora?", "MENSAJE DE INFORMACIÓN",
//                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
//            if (resp == 0) {
//                reporte.openFile();
//            }
//        } else {
//            JOptionPane.showMessageDialog(vreportes, "Se ha producido un error generar el reporte",
//                    "MENSAJE DE INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    public void CargarCombo() {
        String[] items = {"Selccione el tipo de reporte...", "Reporte General", "Reporte de Bitacora", "Reporte de Formularios",
            "Reporte por Año", "Anamnesis - Datos de Identificación ", "Anamnesis-Datos de Padre y Madre", "Anamnesis- Composición Familiar",
            " Anamnesis- Periodo de Embarazo", "Anamnesis -Condiciones de Nacimiento", "Anamnesis- Primeros dias de vida",
            "Anamnesis-Alimentación Actual", "Anamnesis- Desarrollo Motor", "Anamnesis- Sueño y control de esfinteres", "Anamnesis-Escolarización NNA",
            "Anamnesis-Salud NNA", "Anamnesis-Relación Familiar", "Anamnesis-Observaciones", "Primer Encuentro", "Avances Terapeuticos",
            "Plan Terapeutico","Plan Emergente","Historial Clinico","Ficha Legal"};
        for (int i = 0; i < items.length; i++) {
            vreportes.getCbxTipoReporte().addItem(items[i]);
        }

    }

    public void Habilitar() {
        this.vreportes.getTxtID().setVisible(true);
        this.vreportes.getLbid().setVisible(true);
        this.vreportes.getTxtCedula().setVisible(false);
        this.vreportes.getLbcedula().setVisible(false);
        this.vreportes.getjComboBoxAnios().setVisible(false);
        this.vreportes.getLbanio().setVisible(false);
    }

    public void HabilitarAnio() {
        this.vreportes.getTxtID().setVisible(false);
        this.vreportes.getLbid().setVisible(false);
        this.vreportes.getTxtCedula().setVisible(false);
        this.vreportes.getLbcedula().setVisible(false);
        this.vreportes.getjComboBoxAnios().setVisible(true);
        this.vreportes.getLbanio().setVisible(true);
        this.vreportes.getLbFecha().setVisible(false);
        this.vreportes.getDate().setVisible(false);
    }

    public void HabilitarCedula() {
        this.vreportes.getTxtID().setVisible(false);
        this.vreportes.getLbid().setVisible(false);
        this.vreportes.getTxtCedula().setVisible(true);
        this.vreportes.getLbcedula().setVisible(true);
        this.vreportes.getjComboBoxAnios().setVisible(false);
        this.vreportes.getLbanio().setVisible(false);
        this.vreportes.getLbFecha().setVisible(false);
        this.vreportes.getDate().setVisible(false);
    }
    
    public void HabilitarFecha(){
        this.vreportes.getLbFecha().setVisible(true);
        this.vreportes.getDate().setVisible(true);
    }
    
 
}
