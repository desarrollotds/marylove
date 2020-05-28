package marylove.models;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.vista.VistaReportes;

/**
 * @author Angel Lucero
 */
public class ReporteTrabajoSocial {

    private Document doc;
    private final String fundation = "Fundación María Amor";
    private final String title = "Reporte de Trabajo Social";
    private final String[] headerTable = {"Número", "Compañera", "Datos Iniciales", "Ficha Social"};
    private final float[] rows = {2f, 2f, 2f, 2f};
    private PdfPTable table;
    private Date myDate;
    private final VistaReportes vreportes;
    private final ConexionHi conn;
    
    private int contPersonas = 0;
    private int contDatosIniciales = 0;
    private int contFichaSocial = 0;
    private String datosIniciales = "";
    private String fichaSocial = "";

    public ReporteTrabajoSocial(VistaReportes vreportes, ConexionHi conn) {
        this.vreportes = vreportes;
        this.conn = conn;
    }

    public boolean generateReport(String año) {
        table = createTable(headerTable, 4);
        try {
            table.setWidths(rows);
        } catch (DocumentException e) {
            return false;
        }
        
        try {
            doc = createDocument();
            doc.add(createImage());
            doc.add(createTittle(fundation));
            doc.add(new Phrase(Chunk.NEWLINE));
            
            doc.add(createTittle(title));
            doc.add(new Phrase(Chunk.NEWLINE));

            Paragraph fecha = new Paragraph(getDate());
            fecha.setAlignment(Element.ALIGN_RIGHT);
            doc.add(fecha);
            doc.add(new Phrase(Chunk.NEWLINE));
            
            doc.add(new Phrase(Chunk.NEWLINE));
            
            Paragraph header = new Paragraph(createHeader(año));
            doc.add(header);
            doc.add(new Phrase(Chunk.NEWLINE));

            try {
                ResultSet res = conn.query(getSentence(año));
                while (res.next()) {
                    contPersonas++;
                    if (res.getString(2).equals("0")) {
                        datosIniciales = "No";
                    }
                    else {
                        datosIniciales = "Si";
                        contDatosIniciales++;
                    }
                    if (res.getString(3).equals("0")) {
                        fichaSocial = "No";
                    } else {
                        fichaSocial = "Si";
                        contFichaSocial++;
                    }
                    
                    table.addCell(new PdfPCell(new Paragraph(String.valueOf(contPersonas), FontFactory.getFont("Arial", 10))));
                    table.addCell(new PdfPCell(new Paragraph(res.getString(1).toUpperCase(), FontFactory.getFont("Arial", 10))));
                    table.addCell(new PdfPCell(new Paragraph(datosIniciales, FontFactory.getFont("Arial", 10))));
                    table.addCell(new PdfPCell(new Paragraph(fichaSocial, FontFactory.getFont("Arial", 10))));
                }
                doc.add(table);

                doc.add(new Phrase(Chunk.NEWLINE));
                
                Paragraph summary = new Paragraph(createSummary(año));
                doc.add(summary);
                doc.add(new Phrase(Chunk.NEWLINE));

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
    
    private Image createImage(){
        Image imagen = null;
        try {
            imagen = Image.getInstance("");
        } catch (BadElementException ex) {
            Logger.getLogger(ReporteTrabajoSocial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReporteTrabajoSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagen;
    }

    private PdfPTable createTable(String[] header, int filas) {
        PdfPTable auxTable = new PdfPTable(filas);
        auxTable.setWidthPercentage(90);
        for (String header1 : header) {
            auxTable.addCell(new PdfPCell(new Paragraph(header1, FontFactory.getFont("Arial", 10, Font.PLAIN))));
        }
        return auxTable;
    }

    private String getDate() {
        myDate = new Date();
        String fecha = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy, HH:mm").format(myDate);
        return fecha;
    }

    private String getSentence(String año) {
        String SQL_SELECT = "SELECT persona_nombre AS \"Nombre\", \n"
                + "(SELECT COUNT(primer_codigo) FROM victima JOIN primer_encuentro USING (victima_codigo)) AS \"Datos Iniciales\",\n"
                + "(SELECT COUNT(legal_id) FROM victima JOIN ficha_legal USING (victima_codigo)) AS \"Ficha Social\"\n"
                + "FROM victima JOIN persona USING (persona_codigo) JOIN ingreso USING (victima_codigo)\n"
                + "WHERE EXTRACT (YEAR FROM ingreso_fecha) = " + año + " \n"
                + "ORDER BY \n"
                + "ingreso_fecha";
        return SQL_SELECT;
    }

    private Paragraph createHeader(String año){
        String headerString = "Este reporte presenta a las compañeras que han llenado la "
                + "Ficha de Datos Iniciales y Ficha Social durante el año " + año + ".";
        Paragraph headerParagraph = new Paragraph(headerString, FontFactory.getFont("Arial", 12, Font.PLAIN));
        headerParagraph.setAlignment(Element.ALIGN_JUSTIFIED);
        return headerParagraph;
    }
    
    private Paragraph createSummary(String año) {
        String stringSummary = "Resumen: Se han encontrado " + contPersonas + " registro(s) durante el " + año + 
                ", en donde: " + contDatosIniciales + " persona(s) realizaron la Ficha de Datos Iniciales y " + 
                contFichaSocial + " persona(s) realizaron la Ficha Social.";
        Paragraph summary = new Paragraph(stringSummary, FontFactory.getFont("Arial", 10, Font.ITALIC));
        summary.setAlignment(Element.ALIGN_JUSTIFIED);
        return summary;
    }
}
