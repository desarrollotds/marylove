package marylove.models;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import marylove.conexion.ConexionHi;
import marylove.vista.VistaReportes;
/**@author Angel Lucero */

public class ReporteTrabajoSocial {
    private Document doc;
    private final String fundation = "Fundación María Amor";
    private final String title = "Reporte de Trabajo Social";
    private final String[] header = {"Compañera", "Datos Iniciales", "Ficha Social"};
    private final float[] rows = {2f, 2f, 2f};
    private PdfPTable table;
    private Paragraph titleReport;
    private Date myDate;
    private final VistaReportes vreportes;
    private final ConexionHi conn;

    public ReporteTrabajoSocial(VistaReportes vreportes, ConexionHi conn) {
        this.vreportes = vreportes;
        this.conn = conn;
    }

    public boolean generateReport(int año) {
        table = createTable(header, 3);
        try {
            table.setWidths(rows);
        } catch (DocumentException e) {
            return false;
        }
        try {
            doc = createDocument();
            doc.add(createTittle(fundation));
            doc.add(new Phrase(Chunk.NEWLINE));
            doc.add(createTittle(title));
            doc.add(new Phrase(Chunk.NEWLINE));

            Paragraph fecha = new Paragraph(getDate());
            fecha.setAlignment(Element.ALIGN_RIGHT);
            doc.add(fecha);
            doc.add(new Phrase(Chunk.NEWLINE));

            try {
                ResultSet res = conn.query(getSentence(año));
                while (res.next()) {
                    table.addCell(new PdfPCell(new Paragraph(res.getString(1), FontFactory.getFont("Arial", 9))));
                    table.addCell(new PdfPCell(new Paragraph(res.getString(2), FontFactory.getFont("Arial", 9))));
                    table.addCell(new PdfPCell(new Paragraph(res.getString(3), FontFactory.getFont("Arial", 9))));
                    System.out.println(res.getString(2));
                }
                doc.add(table);
                doc.close();
                return true;
            } catch (DocumentException | SQLException e) {
                return false;
            }

        } catch (DocumentException e) {
            return false;
        }
    }

    private Document createDocument() {
        String ruta = vreportes.getTxtRuta().getText();
        Document ducument = new Document();
        try {
            FileOutputStream file = new FileOutputStream(ruta + ".pdf");
            PdfWriter.getInstance(ducument, file);
            //ducument.setPageSize(PageSize.A4.rotate());
            ducument.open();
        } catch (DocumentException | FileNotFoundException e) {
        }
        return ducument;
    }

    private Paragraph createTittle(String titulo) {
        Paragraph titleX = new Paragraph(titulo, FontFactory.getFont("Arial", 12, Font.BOLD));
        titleX.setAlignment(Element.ALIGN_CENTER);
        return titleX;
    }
    
    private Paragraph createSummary(){
        Paragraph summary = new Paragraph("", FontFactory.getFont("Arial", 12, Font.BOLD));
        summary.setAlignment(Element.ALIGN_LEFT);
        return summary;
    }

    private PdfPTable createTable(String[] header, int filas) {
        PdfPTable auxTable = new PdfPTable(filas);
        auxTable.setWidthPercentage(110);
        for (String header1 : header) {
            auxTable.addCell(new PdfPCell(new Paragraph(header1, FontFactory.getFont("Arial", 10, Font.BOLD))));
        }
        return auxTable;
    }

    private String getDate() {
        myDate = new Date();
        String fecha = new SimpleDateFormat("EEEE dd/MMM/yyyy kk:mm").format(myDate);
        return fecha;
    }
    
    private String getSentence(int año){
        String SQL_SELECT = "SELECT persona_nombre AS \"Nombre\", \n"
            + "(SELECT COUNT(primer_codigo) FROM victima JOIN primer_encuentro USING (victima_codigo)) AS \"Datos Iniciales\",\n"
            + "(SELECT COUNT(legal_id) FROM victima JOIN ficha_legal USING (victima_codigo)) AS \"Ficha Social\"\n"
            + "FROM victima JOIN persona USING (persona_codigo) JOIN ingreso USING (victima_codigo)\n"
            + "WHERE EXTRACT (YEAR FROM ingreso_fecha) = " + año + " \n"
            + "ORDER BY \n"
            + "ingreso_fecha";
        return SQL_SELECT;
    }

}
