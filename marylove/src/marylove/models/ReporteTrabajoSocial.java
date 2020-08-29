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
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import marylove.conexion.ConexionHi;
import marylove.vista.VistaReportes;

/**
 * @author Angel Lucero
 */
public class ReporteTrabajoSocial {

    private Document doc;
    private final String fundation = "Fundación María Amor";
    private final String title = "Reporte del Área de Trabajo Social\nde la Fundación María Amor";
    private final String[] headerTable = {"Nro", "Compañera", "Sexo", "Fecha de Ingreso", "Ficha Primer Encuentro", "Fecha de Desarrollo", "Ficha Legal", "Fecha de Desarrollo"};
    private final float[] rows = {1f, 2f, 1f, 2f, 2f, 2f, 2f, 2f};
    private PdfPTable table;
    private Date myDate;
    private final VistaReportes vreportes;
    private final ConexionHi conn;

    private int contPersonas = 0;
    private int contDatosIniciales = 0;
    private int contFichaSocial = 0;
    private String fechaIngreso = "";
    private String datosIniciales = "";
    private String fichaSocial = "";
    
    private String nombreCompleto = "";
    private String txtPrimer = "";
    private String txtLegal = "";

    public ReporteTrabajoSocial(VistaReportes vreportes, ConexionHi conn) {
        this.vreportes = vreportes;
        this.conn = conn;
    }

    public boolean generateReport(String año) {
        table = createTable(headerTable, 8);
        try {
            table.setWidths(rows);
        } catch (DocumentException e) {
            return false;
        }

        try {
//            doc = createDocument();
            doc.add(createImage());
            //doc.add(createTittle(fundation));
            //doc.add(new Phrase(Chunk.NEWLINE));

            doc.add(createTittle(title));
            doc.add(new Phrase(Chunk.NEWLINE));

            Paragraph fecha = new Paragraph("Fecha: " + getDate() + "\nHora: " + getTime());
            fecha.setAlignment(Element.ALIGN_LEFT);
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
                    
                    nombreCompleto = verifyName(res.getString(1)) + " " + verifyName(res.getString(2));
                    
                    if (res.getString(5) == null) {
                        datosIniciales = "No";
                    } else {
                        datosIniciales = "Si";
                        contDatosIniciales++;
                    }
                    
                    txtPrimer = verifyDate(res.getString(6));
                    txtLegal = verifyDate(res.getString(8));
                    fechaIngreso = verifyDate(res.getString(4));
                    
                    if (res.getString(7) == null) {
                        fichaSocial = "No";
                    } else {
                        fichaSocial = "Si";
                        contFichaSocial++;
                    }

                    table.addCell(new PdfPCell(new Paragraph(String.valueOf(contPersonas), FontFactory.getFont("Arial", 10))));
                    table.addCell(new PdfPCell(new Paragraph(nombreCompleto, FontFactory.getFont("Arial", 10))));
                    table.addCell(new PdfPCell(new Paragraph(res.getString(3), FontFactory.getFont("Arial", 10))));
                    table.addCell(new PdfPCell(new Paragraph(fechaIngreso, FontFactory.getFont("Arial", 10))));
                    table.addCell(new PdfPCell(new Paragraph(datosIniciales, FontFactory.getFont("Arial", 10))));
                    table.addCell(new PdfPCell(new Paragraph(txtPrimer, FontFactory.getFont("Arial", 10))));
                    table.addCell(new PdfPCell(new Paragraph(fichaSocial, FontFactory.getFont("Arial", 10))));
                    table.addCell(new PdfPCell(new Paragraph(txtLegal, FontFactory.getFont("Arial", 10))));
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

//    private Document createDocument() {
//        //String ruta = vreportes.getTxtRuta().getText();
//        Document ducument = new Document();
//        try {
//            FileOutputStream file = new FileOutputStream(ruta + ".pdf");
//            PdfWriter.getInstance(ducument, file);
//            ducument.open();
//        } catch (DocumentException | FileNotFoundException e) {
//        }
//        return ducument;
//    }

    private Paragraph createTittle(String titulo) {
        Paragraph titleX = new Paragraph(titulo, FontFactory.getFont("Arial", 12, Font.BOLD));
        titleX.setAlignment(Element.ALIGN_CENTER);
        return titleX;
    }

    private Image createImage() {
        Image imagen = null;
        try {
            imagen = Image.getInstance("src/iconos/logoml.png");
        } catch (BadElementException | IOException ex) {
            System.out.println(ex);
        }
        return imagen;
    }

    private PdfPTable createTable(String[] header, int filas) {
        PdfPTable auxTable = new PdfPTable(filas);
        auxTable.setWidthPercentage(95);
        for (String header1 : header) {
            auxTable.addCell(new PdfPCell(new Paragraph(header1, FontFactory.getFont("Arial", 10, Font.BOLD))));
        }
        return auxTable;
    }

    private String getDate() {
        myDate = new Date();
        String fecha = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy").format(myDate);
        return fecha;
    }

    private String getTime() {
        myDate = new Date();
        String fecha = new SimpleDateFormat("HH:mm").format(myDate);
        return fecha;
    }
    
    private String verifyName(String nombre) {
        System.out.println(nombre);
        if (nombre == null) {
            System.out.println("vacio");
            return " ";
        } else {
            return nombre.toUpperCase();
        } 
    }
    
    private String verifyDate(String fecha) {
        if (fecha == null) {
            return "No disponible";
        } else {
            return fecha;
        } 
    }

    private String getSentence(String año) {
        /*String SQL_SELECT = "SELECT persona_nombre AS \"Nombre\", \n"
                + "(SELECT COUNT(primer_codigo) FROM victima JOIN primer_encuentro USING (victima_codigo)) AS \"Datos Iniciales\",\n"
                + "(SELECT COUNT(legal_id) FROM victima JOIN ficha_legal USING (victima_codigo)) AS \"Ficha Social\"\n"
                + "FROM victima JOIN persona USING (persona_codigo) JOIN ingreso USING (victima_codigo)\n"
                + "WHERE EXTRACT (YEAR FROM ingreso_fecha) = " + año + " \n"
                + "ORDER BY \n"
                + "ingreso_fecha";
*/
        String SQL_SELECT = "SELECT per.persona_nombre, per.persona_apellido, \n"
                + "per.persona_sexo, vvh.ingreso_fecha, \n"
                + "pri.primer_codigo, pri.pstintcrisis_fecha, \n"
                + "leg.legal_id, leg.fecha_elaboracion\n"
                + "FROM vista_victimas_hijos vvh LEFT JOIN persona per USING(persona_codigo) \n"
                + "LEFT JOIN primer_encuentro pri USING (victima_codigo) \n"
                + "LEFT JOIN ficha_legal leg USING (victima_codigo) \n"
                //+ "WHERE EXTRACT (YEAR FROM vvh.ingreso_fecha) = " + año + " \n"
                + "ORDER BY vvh.ingreso_fecha";

        return SQL_SELECT;
    }

    private Paragraph createHeader(String año) {
        String headerString = "La Fundación María Amor mediante este documento presenta evidencias del cumplimiento "
                + "de las actividades realizadas para el Área de Trabajo Social por parte de su personal de trabajo "
                + "con el fin de solicitar información faltante en el caso de que se requiera.\n"
                + "En la siguiente tabla se presentan a las compañeras que han cumplido con el ingreso de datos de la "
                + "Ficha Primer Encuentro y la Ficha Legal durante el año " + año + ".";
        Paragraph headerParagraph = new Paragraph(headerString, FontFactory.getFont("Arial", 12, Font.PLAIN));
        headerParagraph.setAlignment(Element.ALIGN_JUSTIFIED);
        return headerParagraph;
    }

    private Paragraph createSummary(String año) {
        String stringSummary = "En resumen: Se han encontrado " + contPersonas + " registros durante el año " + año
                + ", en donde: " + contDatosIniciales + " persona(s) realizaron la Ficha de Datos Iniciales y "
                + contFichaSocial + " persona(s) realizaron la Ficha Social.";
        Paragraph summary = new Paragraph(stringSummary, FontFactory.getFont("Arial", 12, Font.ITALIC));
        summary.setAlignment(Element.ALIGN_JUSTIFIED);
        return summary;
    }

//    public void openFile() {
//        try {
//            File path = new File(vreportes.getTxtRuta().getText() + ".pdf");
//            Desktop.getDesktop().open(path);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
}
