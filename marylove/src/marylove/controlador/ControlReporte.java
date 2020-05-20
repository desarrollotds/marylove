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
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
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

    private ConexionHi conn;

    public ControlReporte(VistaReportes vreportes) {
        this.vreportes = vreportes;
        this.vreportes.setVisible(true);
        this.vreportes.getjBn_Anual().addActionListener(this);
        this.vreportes.getBtn_General().addActionListener(this);
        this.vreportes.getBtnCompaniera().addActionListener(this);
        this.vreportes.getBtnHijos().addActionListener(this);
        this.vreportes.getPnlEspecificacion().setVisible(false);
        this.vreportes.getBtnSocial().addActionListener(this);
        this.vreportes.getjButtReportAnio().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vreportes.getjBn_Anual())) {
            this.vreportes.getPnlEspecificacion().setVisible(true);
            this.vreportes.getBtnHijos().setEnabled(false);
            this.vreportes.getBtnCompaniera().setEnabled(false);
            try {
                llenarComboAnio();
            } catch (SQLException ex) {
                Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(this.vreportes.getBtn_General())) {
            this.vreportes.getPnlEspecificacion().setVisible(true);
            this.vreportes.getBtnHijos().setEnabled(true);
            this.vreportes.getBtnCompaniera().setEnabled(true);
            try {
                llenarComboAnio();
            } catch (SQLException ex) {
                Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(vreportes.getjButtReportAnio())) {
            reporteAnio();
        }
        if (e.getSource().equals(this.vreportes.getBtnHijos())) {

        }
        if (e.getSource().equals(this.vreportes.getBtnCompaniera())) {

        }
        if (e.getSource().equals(this.vreportes.getBtnSocial())) {
            socialReport();
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
        }
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

    public void victimaReport() throws SQLException {
        try {
            //conn= new ConexionHi();
            //Connection con = conn.getConnection();
            ConexionHi conexion = new ConexionHi();
            Connection con = null;
            con = conexion.getConnection();
            String ruta = "src\\marylove\\reports\\victimaReport.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(ruta);
            Map parametro = new HashMap();
            parametro.put("idusuario", 2017);

            JasperPrint j = JasperFillManager.fillReport(reporte, null, con);
            JasperViewer jv = new JasperViewer(j, false);
            jv.setVisible(true);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void ReporteGeneral() {
       ControladorRuta cr = new ControladorRuta();
        String ruta = cr.path;
        JOptionPane.showMessageDialog(null, ruta);
        Paragraph title = new Paragraph("Reporte General de las compañeras acogidas", FontFactory.getFont("Arial", 30, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        title.add(new Phrase(Chunk.NEWLINE));
        title.add(new Phrase(Chunk.NEWLINE));

        String[] cabecera = {"Nombre", "F.Ingreso", "F.Egreso", "Agresor", "Años", "Estado Civil ", "Nacionalidad", "Instruccion",
            "Ocupación", "# NNA", "Provincia", "Ciudad", "Parroquia", "NNA", "Sexo", "F.Nacimiento", "Años", "Año Escolar", "Institución Educativa"};
        PdfPTable tabla = new PdfPTable(19);
        for (int i = 0; i < cabecera.length; i++) {

            tabla.addCell(new PdfPCell(new Paragraph(cabecera[i], FontFactory.getFont("Arial", 10, Font.BOLD))));
        }

        try {
            FileOutputStream file = new FileOutputStream(ruta + ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, file);
            doc.setPageSize(PageSize.A4.rotate());
            doc.open();

            doc.add(title);

            //DB
            ConexionHi conexion = new ConexionHi();
            String usuario = "postgres";
            String password = "desarrollo";
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
                    + " v.victima_codigo, i.ingreso_fecha";

            try {
                Statement comando = conexion.getConnection().createStatement();
                ResultSet res = comando.executeQuery(SQL_SELECT);

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
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(14), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(15), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(16), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(17), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(18), FontFactory.getFont("Arial", 10))));
                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(19), FontFactory.getFont("Arial", 10))));

                }

                tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
                doc.add(tabla);
                doc.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            JOptionPane.showMessageDialog(null, "Documento guardado en:" + ruta);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
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

    //Para pruebas
    public static void main(String[] args) {
        new ControlReporte(new VistaReportes());
    }
}
