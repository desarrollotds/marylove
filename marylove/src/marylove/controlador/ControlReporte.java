package marylove.controlador;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.IngresoDB;
import marylove.conexion.ConexionHi;
import marylove.models.ReporteTrabajoSocial;
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
        this.vreportes.getBtnBuscar().addActionListener(this);
        this.vreportes.getBtnReport().addActionListener(this);

        this.vreportes.getCbxTipoReporte().addActionListener(this);
        this.vreportes.getBtnGenerar().addActionListener(this);
        this.vreportes.getPnlEspecificacion().setVisible(false);
        this.vreportes.getLblTipoReporte().setText(this.vreportes.getCbxTipoReporte().getSelectedItem().toString());
        this.vreportes.getCbxTipoGeneral().addActionListener(this);
        this.vreportes.getCbxTipoGeneral().setVisible(false);
        this.vreportes.getLbtipo().setVisible(false);

        this.vreportes.getTxtRuta().setEnabled(false);
        this.vreportes.getBtnGenerar().setVisible(false);
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
                    this.vreportes.getCbxTipoGeneral().setVisible(false);
                    this.vreportes.getLbtipo().setVisible(false);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(vreportes, "Se ha producido un error inesperado con la base de datos",
                            "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 1) {
                    bandera = 1;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 2) {
                    this.vreportes.getLbtipo().setVisible(true);
                    this.vreportes.getCbxTipoGeneral().setVisible(true);
                    bandera = 2;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 3) {
                    bandera = 3;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 4) {
                    bandera = 4;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 5) {
                    bandera = 5;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 6) {
                    bandera = 6;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 7) {
                    bandera = 7;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 8) {
                    bandera = 8;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 9) {
                    bandera = 9;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 10) {
                    bandera = 10;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 11) {
                    bandera = 11;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 12) {
                    bandera = 12;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 13) {
                    bandera = 13;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 14) {
                    bandera = 14;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 15) {
                    bandera = 15;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 16) {
                    bandera = 16;
                }
                 if (vreportes.getCbxTipoReporte().getSelectedIndex() == 17) {
                    bandera = 17;
                }
            }
        }

        if (e.getSource().equals(vreportes.getBtnBuscar())) {
            Ruta();
            if (this.vreportes.getTxtRuta().getText().toString().equals("")) {
                JOptionPane.showMessageDialog(vreportes, "Ingrese una ruta para guardar el documento", "Mensaje de Información", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vreportes.getBtnGenerar().setVisible(true);
            }
        }

        //SELECCIONA LOS TIPOS DE REPORTES... IF VALIDO
        if (e.getSource().equals(vreportes.getBtnReport())) {

            if (bandera == 1) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteGeneral();
                excel.Impresion(vreportes, modelotabla);
            }
            if (bandera == 2) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteBitacora();
                excel.Impresion(vreportes, modelotabla);
            }
            if (bandera == 3) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteFormularios();
                excel.Impresion(vreportes, modelotabla);
            }
            if (bandera == 4) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteAnio();
                excel.Impresion(vreportes, modelotabla);
            }
            if (bandera == 5) {
                modelotabla = new DefaultTableModel();
                modelotabla=sentencias.ReporteAnamnesisDP();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 6) {
                modelotabla = new DefaultTableModel();
                modelotabla= sentencias.AnamnesisDPM();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 7) {
                modelotabla = new DefaultTableModel();
                modelotabla= sentencias.AnamnesisCF();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 8) {
                modelotabla = new DefaultTableModel();
                modelotabla= sentencias.AnamnesisPE();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 9) {
                modelotabla = new DefaultTableModel();
                modelotabla= sentencias.AnamnesisCN();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 10) {
                modelotabla = new DefaultTableModel();
                modelotabla=sentencias.AnamnesisPDV();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 11) {
                modelotabla = new DefaultTableModel();
                modelotabla=sentencias.AnamnesisAA();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 12) {
                modelotabla = new DefaultTableModel();
                modelotabla=sentencias.AnamnesisDM();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 13) {
                modelotabla = new DefaultTableModel();
                modelotabla=sentencias.AnamnesisSCE();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 14) {
                modelotabla = new DefaultTableModel();
                 modelotabla=sentencias.AnamnesisENNA();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 15) {
                modelotabla = new DefaultTableModel();
                modelotabla=sentencias.AnamnesisSNNA();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 16) {
                modelotabla = new DefaultTableModel();
                modelotabla=sentencias.AnamnesisRF();
                excel.Impresion(vreportes, modelotabla);

            }
            if (bandera == 17) {
                modelotabla = new DefaultTableModel();
                modelotabla=sentencias.AnamnesisO();
                excel.Impresion(vreportes, modelotabla);

            }
        }

        ///////////////////////
        if (e.getSource().equals(vreportes.getBtnGenerar())) {
            String parametroAño = vreportes.getjComboBoxAnios().getSelectedItem().toString();

            if (bandera == 3) {
                if (comprobarConexion()) {
                    socialReport(parametroAño);
                }
            }
        }
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
    private void socialReport(String parametroAño) {
        ReporteTrabajoSocial reporte = new ReporteTrabajoSocial(vreportes, conn);
        if (reporte.generateReport(parametroAño)) {
            int resp = JOptionPane.showConfirmDialog(vreportes, "Se ha generado el reporte en la ruta: \n"
                    + vreportes.getTxtRuta().getText() + ".pdf\n"
                    + "¿Desea abrir el archivo ahora?", "MENSAJE DE INFORMACIÓN",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (resp == 0) {
                reporte.openFile();
            }
        } else {
            JOptionPane.showMessageDialog(vreportes, "Se ha producido un error generar el reporte",
                    "MENSAJE DE INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
        }
    }

    // METODO PARA CREAR EL DOCUMENTO PDF
    public Document createDocument() {
        String ruta = vreportes.getTxtRuta().getText();
        Document doc = new Document();
        try {
            FileOutputStream file = new FileOutputStream(ruta + ".pdf");
            PdfWriter.getInstance(doc, file);
            doc.setPageSize(PageSize.A4.rotate());
            doc.open();
            System.out.println(ruta);

        } catch (DocumentException e) {
            JOptionPane.showMessageDialog(vreportes, "Se generó un error al crear el documento", "Información", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(vreportes, "No se a especificado una ruta de almacenamiento", "Información", JOptionPane.WARNING_MESSAGE);

        }
        return doc;
    }

    // METODO PARA OBTENER LA RUTA
    private void Ruta() {
        JFileChooser ruta = new JFileChooser();
        int opcion = ruta.showSaveDialog(vreportes);
        vreportes.getTxtRuta().setText("");
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File file = ruta.getSelectedFile();
            vreportes.getTxtRuta().setText(file.toString());
        }
    }

    // METODO PARA CREAR EL TITULO
    public Paragraph createTittle(String titulo) {
        Paragraph title = new Paragraph(titulo, FontFactory.getFont("Arial", 30, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        return title;
    }
    // METODO PARA CREAR UN PDFPTABLE

    public PdfPTable createTable(String[] cabecera, int filas) {
        PdfPTable tabla = new PdfPTable(filas);
        tabla.setWidthPercentage(105);
        for (int i = 0; i < cabecera.length; i++) {
            tabla.addCell(new PdfPCell(new Paragraph(cabecera[i], FontFactory.getFont("Arial", 10, Font.BOLD))));
        }
        return tabla;
    }

    // METODO PARA OBTENER FECHA, HORA Y DIA ACTUAL
    public String Fecha() {
        String fecha;
        String pattern = " EEEE dd-MM-YYYY kk:mm:ss ";
        SimpleDateFormat formato = new SimpleDateFormat(pattern);
        fecha = formato.format(new Date());
        return fecha;
    }

    public void CargarCombo() {
        String[] items = {"Selccione el tipo de reporte...", "Reporte General", "Reporte de Bitacora", "Reporte de Formularios",
            "Reporte por Año", "Anamnesis - Datos de Identificación ", "Anamnesis-Datos de Padre y Madre", "Anamnesis- Composición Familiar",
            " Anamnesis- Periodo de Embarazo", "Anamnesis -Condiciones de Nacimiento", "Anamnesis- Primeros dias de vida",
            "Anamnesis-Alimentación Actual", "Anamnesis- Desarrollo Motor", "Anamnesis- Sueño y control de esfinteres", "Anamnesis-Escolarización NNA",
            "Anamnesis-Salud NNA", "Anamnesis-Relación Familiar", "Anamnesis-Observaciones"};
        for (int i = 0; i < items.length; i++) {
            vreportes.getCbxTipoReporte().addItem(items[i]);
        }

    }

}
