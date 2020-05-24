package marylove.controlador;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.IngresoDB;
import marylove.conexion.ConexionHi;
import marylove.conexion.ConexionHi;
import marylove.vista.VistaReportes;
import marylove.vista.VistaRuta;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ControlReporte implements ActionListener {

    private VistaReportes vreportes;
    private ArrayList<String> anios;
    private DefaultComboBoxModel modelo;
    private IngresoDB i;
    private int bandera;

    private ConexionHi conn;

    public ControlReporte(VistaReportes vreportes) {
        this.vreportes = vreportes;
        this.vreportes.setVisible(true);
        this.vreportes.getBtnCompaniera().addActionListener(this);
        this.vreportes.getBtnHijos().addActionListener(this);
        this.vreportes.getPnlEspecificacion().setVisible(false);
        this.vreportes.getBtnBuscar().addActionListener(this);

        this.vreportes.getCbxTipoReporte().addActionListener(this);
        this.vreportes.getBtnGenerar().addActionListener(this);
        this.vreportes.getPnlEspecificacion().setVisible(false);
        this.vreportes.getBtnHijos().setVisible(false);
        this.vreportes.getBtnCompaniera().setVisible(false);
        this.vreportes.getLblTipoReporte().setText(this.vreportes.getCbxTipoReporte().getSelectedItem().toString());
    }

    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource().equals(this.vreportes.getjBn_Anual())) {
            this.vreportes.getPnlEspecificacion().setVisible(true);
            this.vreportes.getjButtonRAnual().setVisible(true);
            try {
                llenarComboAnio();
            } catch (SQLException ex) {
                Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
 /*if (e.getSource().equals(this.vreportes.getBtn_General())) {
            this.vreportes.getPnlEspecificacion().setVisible(true);
            this.vreportes.getBtnHijos().setEnabled(true);
            this.vreportes.getBtnCompaniera().setEnabled(true);

            this.vreportes.getjButtonRGenaral().setVisible(true);
            try {
                llenarComboAnio();
            } catch (SQLException ex) {
                Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/

        if (e.getSource().equals(this.vreportes.getBtnHijos())) {

        }
        if (e.getSource().equals(this.vreportes.getBtnCompaniera())) {

        }
        /* if (e.getSource().equals(this.vreportes.getBtnSocial())) {
            this.vreportes.getjButtonRSocial().setVisible(true);
            socialReport();
        }*/

        if (e.getSource().equals(this.vreportes.getCbxTipoReporte())) {
            this.vreportes.getLblTipoReporte().setText(this.vreportes.getCbxTipoReporte().getSelectedItem().toString());
            this.vreportes.getPnlEspecificacion().setVisible(true);
            this.vreportes.getBtnHijos().setVisible(false);
            this.vreportes.getBtnCompaniera().setVisible(false);
            try {
                llenarComboAnio();
            } catch (SQLException ex) {
                Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

            if (vreportes.getCbxTipoReporte().getSelectedIndex() == 1) {
                bandera = 1;
            }
            if (vreportes.getCbxTipoReporte().getSelectedIndex() == 2) {
                this.vreportes.getBtnHijos().setVisible(true);
                this.vreportes.getBtnCompaniera().setVisible(true);
                bandera = 2;
            }
            if (vreportes.getCbxTipoReporte().getSelectedIndex() == 3) {
                bandera = 3;
            }
        }
        if (e.getSource().equals(vreportes.getBtnGenerar())) {
            if (bandera == 1) {
                JOptionPane.showMessageDialog(vreportes, "Se llama al método del reporte Anual");

            }
            if (bandera == 2) {
                JOptionPane.showMessageDialog(vreportes, "Se llama al método del reporte General");
            }
            if (bandera == 3) {
                socialReport();
            }
        }
        if (e.getSource().equals(vreportes.getBtnBuscar())) {
            Ruta();
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

    private void socialReport() {
        try {
            Date myDate = new Date();
            String fecha = new SimpleDateFormat("dd-MM-yyyy").format(myDate);
            FileOutputStream file = new FileOutputStream("Reporte Trabajo Social " + fecha + ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, file);
            doc.open();
            Paragraph title = new Paragraph("Reporte de Trabajo Social", FontFactory.getFont("Arial", 12, Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);
            title.add(new Phrase(Chunk.NEWLINE));
            doc.add(title);
            doc.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        /*
        try {
            ConexionHi conHi = new ConexionHi();
            Connection conn = conHi.getConnection();
            JasperReport report = null;
            String path = "src//marylove/reports/ReporteSocial.jasper";
            Map parametro = new HashMap();
            parametro.put("anio", vreportes.getjComboBoxAnios().getSelectedIndex());

            report = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException | SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        JOptionPane.showMessageDialog(vreportes, "Se ha generado el reporte",
                "MENSAJE DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }

    public void reporteAnio() {
        try {
            ConexionHi con = new ConexionHi();
            Connection conn = con.getConnection();
            JasperReport reporte = null;
            String path = "src//marylove/reports/report_anio.jasper";
            Map parametro = new HashMap();
            parametro.put("anio", vreportes.getjComboBoxAnios().getSelectedIndex());

            reporte = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {

        }

    }

    public void Listar() {

        try {
            ConexionHi conexion = new ConexionHi();
            Statement comando = conexion.getConnection().createStatement();
            ResultSet res = comando.executeQuery("select persona_nombre from persona");

            while (res.next()) {
                JOptionPane.showMessageDialog(null, res.getString("persona_nombre"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public Document createDocument() {
        String ruta = vreportes.getTxtRuta().getText();
        Document doc = new Document();
        try {
            FileOutputStream file = new FileOutputStream(ruta + ".pdf");
            PdfWriter.getInstance(doc, file);
            doc.setPageSize(PageSize.A4.rotate());
            doc.open();
            System.out.println(ruta);

        } catch (Exception e) {
        }
        return doc;
    }

    private void Ruta() {
        JFileChooser ruta = new JFileChooser();
        int opcion = ruta.showSaveDialog(vreportes);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File file = ruta.getSelectedFile();
            vreportes.getTxtRuta().setText(file.toString());
        }
    }

    public Paragraph Ptittle(String titulo) {
        Paragraph title = new Paragraph(titulo, FontFactory.getFont("Arial", 30, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        return title;
    }
    
     public PdfPTable createTable(String[] cabecera, int filas) {
        PdfPTable tabla = new PdfPTable(filas);
        tabla.setWidthPercentage(100);
        for (int i = 0; i < cabecera.length; i++) {
            tabla.addCell(new PdfPCell(new Paragraph(cabecera[i], FontFactory.getFont("Arial", 10, Font.BOLD))));
        }
        return tabla;

    }

    //Para pruebas
    public static void main(String[] args) {
        new ControlReporte(new VistaReportes());
    }
}
