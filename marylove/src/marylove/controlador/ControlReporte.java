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
    private Validaciones validaciones;
    private ConexionHi conn = new ConexionHi();

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
                createVictimaReport();
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
            String sql = "select persona_nombre from persona";
            ResultSet res = conexion.query(sql);
            while (res.next()) {
                JOptionPane.showMessageDialog(null, res.getString("persona_nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //METODO PARA CREAR EL REPORTE GENERAL
    public void createGeneralReport() {
        String titulo = "Reporte General de las compañeras acogidas";
        String[] cabecera = {"Nombre", "F.Ingreso", "F.Egreso", "Agresor", "Nacionalidad", "Provincia", "Ciudad", "Parroquia", "Años", "Instruccion",
            "Ocupación", "Estado Civil ", "#NNA", "NNA", "Sexo", "F.Nacimiento", "Años", "Año Escolar", "Institución Educativa"};
        PdfPTable tabla = createTable(cabecera, 19);
        float[] medidaCeldas = {2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 1f, 2f, 2f, 2f, 1f, 2f, 1f, 2f, 1f, 2f, 2f};
        try {
            tabla.setWidths(medidaCeldas);
        } catch (Exception e) {
        }
        try {
            Document doc = createDocument();
            doc.add(createTittle(titulo));
            doc.add(new Phrase(Chunk.NEWLINE));
            Paragraph fecha = new Paragraph(Fecha());
            fecha.setAlignment(Element.ALIGN_RIGHT);
            doc.add(fecha);
            doc.add(new Phrase(Chunk.NEWLINE));
            String SQL_SELECT = "SELECT\n"
                    + " p.persona_nombre||' '|| p.persona_apellido AS \"Compañera\",\n"
                    + " (CASE\n"
                    + " WHEN  i.ingreso_fecha  IS NULL THEN ''\n"
                    + " ELSE i.ingreso_fecha||''\n"
                    + " END) AS \"Fecha Ingreso\" ,\n"
                    + " (CASE\n"
                    + " WHEN  e.egreso_fecha  IS NULL THEN ''\n"
                    + " ELSE e.egreso_fecha||''\n"
                    + " END) AS \"Fecha Egreso\" ,\n"
                    + " (select par_valores->xra.parentesco->>'valor' from parametros where par_id = 9) AS \"Agresor\",\n"
                    + " (select par_valores->p.persona_nacionalidad->>'valor' from parametros where par_id = 3) AS \"Nacionalidad\",\n"
                    + " (CASE\n"
                    + " WHEN d.dir_provincia  IS NULL THEN ''\n"
                    + " ELSE d.dir_provincia||''\n"
                    + " END) AS \"Provincia\" ,\n"
                    + " (CASE\n"
                    + " WHEN d.dir_ciudad  IS NULL THEN ''\n"
                    + " ELSE d.dir_ciudad||''\n"
                    + " END) AS \"Ciudad\" ,\n"
                    + " (CASE\n"
                    + " WHEN d.dir_parroquia  IS NULL THEN ''\n"
                    + " ELSE d.dir_parroquia||''\n"
                    + " END) AS \"Parroquia\" ,\n"
                    + " (CASE\n"
                    + " WHEN  ((current_date-p.persona_fecha_nac)/365)  IS NULL THEN ''\n"
                    + " ELSE ((current_date-p.persona_fecha_nac)/365)||''\n"
                    + " END) AS \"Años\" ,\n"
                    + " (select par_valores->p.persona_nivel_acad->>'valor' from parametros where par_id = 5) AS \"Instruccion\",\n"
                    + " (select par_valores->p.persona_ocupacion->>'valor' from parametros where par_id = 7) AS \"Ocupacion\",\n"
                    + " (select par_valores->p.persona_estadocivil->>'valor' from parametros where par_id = 4) AS \"Estado Civil\",\n"
                    + " (SELECT\n"
                    + " COUNT(*)\n"
                    + " FROM\n"
                    + " hijos h \n"
                    + " WHERE\n"
                    + " h.victima_codigo =v.victima_codigo) AS \"NNA Responsables\",\n"
                    + " (CASE\n"
                    + " WHEN  p1.persona_nombre || ' '||p1.persona_apellido  IS NULL THEN ''\n"
                    + " ELSE p1.persona_nombre || ' '||p1.persona_apellido\n"
                    + " END)\n"
                    + " AS \" NNA\",\n"
                    + " (CASE\n"
                    + " WHEN p1.persona_sexo IS NULL THEN ''\n"
                    + " ELSE p1.persona_sexo||''\n"
                    + " END) AS \"Sexo\" ,\n"
                    + " (CASE\n"
                    + " WHEN p1.persona_fecha_nac  IS NULL THEN ''\n"
                    + " ELSE p1.persona_fecha_nac||''\n"
                    + " END) AS \"Fecha de Nacimiento\" ,\n"
                    + " (CASE\n"
                    + " WHEN  ((current_date-p1.persona_fecha_nac)/365)  IS NULL THEN ''\n"
                    + " ELSE ((current_date-p1.persona_fecha_nac)/365)||''\n"
                    + " END) AS \"Años NNA \" ,\n"
                    + " (CASE\n"
                    + " WHEN  h.hijo_anioescolar IS NULL THEN ''\n"
                    + " ELSE  h.hijo_anioescolar||''\n"
                    + " END) AS \"Año Escolar\" ,\n"
                    + " (CASE\n"
                    + " WHEN ie.inst_nombre IS NULL THEN ''\n"
                    + " ELSE ie.inst_nombre||''\n"
                    + " END) AS \"Institucion Educativa\" \n"
                    + "\n"
                    + " FROM\n"
                    + " persona p\n"
                    + " JOIN \n"
                    + " victima v\n"
                    + " ON \n"
                    + " v.persona_codigo = p.persona_codigo\n"
                    + " LEFT JOIN\n"
                    + " ingreso i\n"
                    + " ON \n"
                    + " i.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN\n"
                    + " egreso e\n"
                    + " ON\n"
                    + " e.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN\n"
                    + " direccion_persona dp\n"
                    + " ON\n"
                    + " p.persona_codigo = dp.persona_codigo\n"
                    + " LEFT JOIN \n"
                    + " direccion d\n"
                    + " ON \n"
                    + " d.dir_codigo = dp.dir_domicilio\n"
                    + " LEFT JOIN  hijos h\n"
                    + " ON h.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN persona p1\n"
                    + " ON p1.persona_codigo = h.persona_codigo\n"
                    + " LEFT JOIN \n"
                    + " institucion_educativa ie\n"
                    + " ON ie.inst_codigo = h.institucion_codigo\n"
                    + " LEFT JOIN registro_referencia rr\n"
                    + " ON\n"
                    + " v.victima_codigo = rr.victima_codigo\n"
                    + " LEFT  JOIN x_registro_agresor xra\n"
                    + " ON\n"
                    + " xra.registroreferencia_codigo =rr.registroreferencia_codigo \n"
                    + "LEFT JOIN \n"
                    + " agresor a\n"
                    + " ON a.agresor_codigo = xra.agresor_codigo\n"
                    + "/*WHERE extract (year from i.ingreso_fecha) = 2017*/\n"
                    + " ORDER BY \n"
                    + " v.victima_codigo, i.ingreso_fecha\n";

            try {
                ResultSet res = conn.query(SQL_SELECT);
                while (res.next()) {
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(1), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(2), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(3), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(4), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(5), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(6), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(7), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(8), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(9), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(10), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(11), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(12), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(13), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(14), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(15), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(16), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(17), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(18), FontFactory.getFont("Arial", 9))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(19), FontFactory.getFont("Arial", 9))));
                }
                doc.add(tabla);
                doc.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            JOptionPane.showMessageDialog(null, "Documento Generado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //METODO PARA CREAR EL REPORTE GENERAL DE LA VICTIMA
    public void createVictimaReport() {
        String titulo = "Reporte General de las compañeras acogidas";
        String[] cabecera = {"Nombre", "F.Ingreso", "F.Egreso", "Agresor", "Nacionalidad", "Provincia ", "Ciudad", "Parroquia",
            "Años", "Instruccion", "Ocupación", "Esado Civil", "#NNA"};
        PdfPTable tabla = createTable(cabecera, 13);

        try {
            Document doc = createDocument();
            doc.add(createTittle(titulo));
            doc.add(new Phrase(Chunk.NEWLINE));
            Paragraph fecha = new Paragraph(Fecha());
            fecha.setAlignment(Element.ALIGN_RIGHT);
            doc.add(fecha);
            doc.add(new Phrase(Chunk.NEWLINE));

            String SQL_SELECT = " SELECT\n"
                    + " p.persona_nombre||' '|| p.persona_apellido AS \"Compañera\",\n"
                    + " (CASE\n"
                    + " WHEN  i.ingreso_fecha  IS NULL THEN ''\n"
                    + " ELSE i.ingreso_fecha||''\n"
                    + " END) AS \"Fecha Ingreso\" ,\n"
                    + " (CASE\n"
                    + " WHEN  e.egreso_fecha  IS NULL THEN ''\n"
                    + " ELSE e.egreso_fecha||''\n"
                    + " END) AS \"Fecha Egreso\" ,\n"
                    + " (select par_valores->xra.parentesco->>'valor' from parametros where par_id = 9) AS \"Agresor\",\n"
                    + " (select par_valores->p.persona_nacionalidad->>'valor' from parametros where par_id = 3) AS \"Nacionalidad\",\n"
                    + " (CASE\n"
                    + " WHEN d.dir_provincia  IS NULL THEN ''\n"
                    + " ELSE d.dir_provincia||''\n"
                    + " END) AS \"Provincia\" ,\n"
                    + " (CASE\n"
                    + " WHEN d.dir_ciudad  IS NULL THEN ''\n"
                    + " ELSE d.dir_ciudad||''\n"
                    + " END) AS \"Ciudad\" ,\n"
                    + " (CASE\n"
                    + " WHEN d.dir_parroquia  IS NULL THEN ''\n"
                    + " ELSE d.dir_parroquia||''\n"
                    + " END) AS \"Parroquia\" ,\n"
                    + " (CASE\n"
                    + " WHEN  ((current_date-p.persona_fecha_nac)/365)  IS NULL THEN ''\n"
                    + " ELSE ((current_date-p.persona_fecha_nac)/365)||''\n"
                    + " END) AS \"Años\" ,\n"
                    + " (select par_valores->p.persona_nivel_acad->>'valor' from parametros where par_id = 5) AS \"Instruccion\",\n"
                    + " (select par_valores->p.persona_ocupacion->>'valor' from parametros where par_id = 7) AS \"Ocupacion\",\n"
                    + " (select par_valores->p.persona_estadocivil->>'valor' from parametros where par_id = 4) AS \"Estado Civil\",\n"
                    + " (SELECT\n"
                    + " COUNT(*)\n"
                    + " FROM\n"
                    + " hijos h \n"
                    + " WHERE\n"
                    + " h.victima_codigo =v.victima_codigo) AS \"NNA Responsables\"\n"
                    + " FROM\n"
                    + " persona p\n"
                    + " JOIN \n"
                    + " victima v\n"
                    + " ON \n"
                    + " v.persona_codigo = p.persona_codigo\n"
                    + " LEFT JOIN\n"
                    + " ingreso i\n"
                    + " ON \n"
                    + " i.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN\n"
                    + " egreso e\n"
                    + " ON\n"
                    + " e.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN\n"
                    + " direccion_persona dp\n"
                    + " ON\n"
                    + " p.persona_codigo = dp.persona_codigo\n"
                    + " LEFT JOIN \n"
                    + " direccion d\n"
                    + " ON \n"
                    + " d.dir_codigo = dp.dir_domicilio\n"
                    + " LEFT JOIN  hijos h\n"
                    + " ON h.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN persona p1\n"
                    + " ON p1.persona_codigo = h.persona_codigo\n"
                    + " LEFT JOIN \n"
                    + " institucion_educativa ie\n"
                    + " ON ie.inst_codigo = h.institucion_codigo\n"
                    + " LEFT JOIN registro_referencia rr\n"
                    + " ON\n"
                    + " v.victima_codigo = rr.victima_codigo\n"
                    + " LEFT  JOIN x_registro_agresor xra\n"
                    + " ON\n"
                    + " xra.registroreferencia_codigo =rr.registroreferencia_codigo \n"
                    + "LEFT JOIN \n"
                    + " agresor a\n"
                    + " ON a.agresor_codigo = xra.agresor_codigo\n"
                    + " /*WHERE extract (year from i.ingreso_fecha) = 2017*/\n"
                    + " ORDER BY \n"
                    + " v.victima_codigo, i.ingreso_fecha";

            try {
                ResultSet res = conn.query(SQL_SELECT);

                while (res.next()) {
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(1), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(2), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(3), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(4), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(5), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(6), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(7), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(8), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(9), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(10), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(11), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(12), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(13), FontFactory.getFont("Arial", 10))));
                }
                doc.add(tabla);
                doc.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            JOptionPane.showMessageDialog(null, "Documento Generado");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    // METODO PARA CREAR EL REPORTE GENERAL DE NNA
    public void createNNAReport() {
        try {
            Document doc = createDocument();
            String titulo = "Reporte de NNA Acogidos";
            String[] cabecera = {"Compañera", "#NNA", "NNA", "Sexo", "F.Nacimiento", "Años ", "Año Escolar", "Institución Educativa"};
            PdfPTable tabla = createTable(cabecera, 8);
            doc.add(new Phrase(Chunk.NEWLINE));
            doc.add(createTittle(titulo));
            Paragraph fecha = new Paragraph(Fecha());
            fecha.setAlignment(Element.ALIGN_RIGHT);
            doc.add(fecha);
            doc.add(new Phrase(Chunk.NEWLINE));
            String sql = " SELECT\n"
                    + " p.persona_nombre||' '|| p.persona_apellido AS \"Compañera\",\n"
                    + " \n"
                    + " (SELECT\n"
                    + " COUNT(*)\n"
                    + " FROM\n"
                    + " hijos h \n"
                    + " WHERE\n"
                    + " h.victima_codigo =v.victima_codigo) AS \"NNA Responsables\",\n"
                    + " (CASE\n"
                    + " WHEN  p1.persona_nombre || ' '||p1.persona_apellido  IS NULL THEN ''\n"
                    + " ELSE p1.persona_nombre || ' '||p1.persona_apellido\n"
                    + " END)\n"
                    + " AS \" NNA\",\n"
                    + " (CASE\n"
                    + " WHEN p1.persona_sexo IS NULL THEN ''\n"
                    + " ELSE p1.persona_sexo||''\n"
                    + " END) AS \"Sexo\" ,\n"
                    + " (CASE\n"
                    + " WHEN p1.persona_fecha_nac  IS NULL THEN ''\n"
                    + " ELSE p1.persona_fecha_nac||''\n"
                    + " END) AS \"Fecha de Nacimiento\" ,\n"
                    + " (CASE\n"
                    + " WHEN  ((current_date-p1.persona_fecha_nac)/365)  IS NULL THEN ''\n"
                    + " ELSE ((current_date-p1.persona_fecha_nac)/365)||''\n"
                    + " END) AS \"Años\" ,\n"
                    + " (CASE\n"
                    + " WHEN  h.hijo_anioescolar IS NULL THEN ''\n"
                    + " ELSE  h.hijo_anioescolar||''\n"
                    + " END) AS \"Año Escolar\" ,\n"
                    + " (CASE\n"
                    + " WHEN ie.inst_nombre IS NULL THEN ''\n"
                    + " ELSE ie.inst_nombre||''\n"
                    + " END) AS \"Institucion Educativa\" \n"
                    + "\n"
                    + " FROM\n"
                    + " persona p\n"
                    + " JOIN \n"
                    + " victima v\n"
                    + " ON \n"
                    + " v.persona_codigo = p.persona_codigo\n"
                    + " LEFT JOIN\n"
                    + " ingreso i\n"
                    + " ON \n"
                    + " i.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN\n"
                    + " egreso e\n"
                    + " ON\n"
                    + " e.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN\n"
                    + " direccion_persona dp\n"
                    + " ON\n"
                    + " p.persona_codigo = dp.persona_codigo\n"
                    + " LEFT JOIN \n"
                    + " direccion d\n"
                    + " ON \n"
                    + " d.dir_codigo = dp.dir_domicilio\n"
                    + " LEFT JOIN  hijos h\n"
                    + " ON h.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN persona p1\n"
                    + " ON p1.persona_codigo = h.persona_codigo\n"
                    + " LEFT JOIN \n"
                    + " institucion_educativa ie\n"
                    + " ON ie.inst_codigo = h.institucion_codigo\n"
                    + " LEFT JOIN registro_referencia rr\n"
                    + " ON\n"
                    + " v.victima_codigo = rr.victima_codigo\n"
                    + " LEFT  JOIN x_registro_agresor xra\n"
                    + " ON\n"
                    + " xra.registroreferencia_codigo =rr.registroreferencia_codigo \n"
                    + "LEFT JOIN \n"
                    + " agresor a\n"
                    + " ON a.agresor_codigo = xra.agresor_codigo\n"
                    + "/*WHERE extract (year from i.ingreso_fecha) = 2017*/\n"
                    + " ORDER BY \n"
                    + " v.victima_codigo, i.ingreso_fecha";

            try {
                ResultSet res = conn.query(sql);
                while (res.next()) {
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(1), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(2), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(3), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(4), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(5), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(6), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(7), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(8), FontFactory.getFont("Arial", 10))));

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(vreportes, ex);
            }
            doc.add(tabla);
            doc.close();
            JOptionPane.showMessageDialog(null, "Documento Generado");
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(vreportes, ex);
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

        } catch (Exception e) {
        }
        return doc;
    }
    // METODO PARA OBTENER LA RUTA
    private void Ruta() {
        JFileChooser ruta = new JFileChooser();
        int opcion = ruta.showSaveDialog(vreportes);
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

    //Para pruebas
    public static void main(String[] args) {
        new ControlReporte(new VistaReportes());
    }
}
