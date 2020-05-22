/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import marylove.conexion.ConexionHi;
import marylove.vista.VistaReportes;
import marylove.vista.VistaRuta;

/**
 *
 * @author usuario
 */
public class ControladorRuta implements ActionListener {

    private VistaRuta vr;
    private String path;

    public ControladorRuta(VistaRuta vr) {
        this.vr = vr;
        this.vr.setVisible(true);
        this.vr.setLocationRelativeTo(null);
        this.vr.setResizable(true);
        this.vr.getBtnGenerar().addActionListener(this);
        this.vr.getBtnBuscar().addActionListener(this);
    }

    public ControladorRuta() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public VistaRuta getVr() {
        return vr;
    }

    public void setVr(VistaRuta vr) {
        this.vr = vr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vr.getBtnGenerar())) {
            ReporteGeneralNNA();

        }
        if (e.getSource().equals(this.vr.getBtnBuscar())) {
            obtenerRuta();

        }
    }

    public void obtenerRuta() {
        // Se obtiene una ruta para guardar el documento
        JFileChooser ruta = new JFileChooser();
        int opcion = ruta.showSaveDialog(this.vr);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File file = ruta.getSelectedFile();
            this.vr.getTxtRuta().setText(file.toString());

        }

    }

    public void ReporteGeneral() throws DocumentException {
        ControladorRuta cr = new ControladorRuta();
        String ruta = this.vr.getTxtRuta().getText();
        JOptionPane.showMessageDialog(null, ruta);
        Paragraph title = new Paragraph("Reporte General de las compañeras acogidas", FontFactory.getFont("Arial", 30, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        title.add(new Phrase(Chunk.NEWLINE));
        title.add(new Phrase(Chunk.NEWLINE));

        String[] cabecera = {"Nombre", "F.Ingreso", "F.Egreso", "Agresor", "Nacionalidad", "Provincia ", "Ciudad", "Parroquia",
            "Años", "Instruccion", "Ocupación", "Esado Civil", "#NNA", "NNA", "Sexo", "F.Nacimiento", "Años", "Año Escolar", "Institución Educativa"};
        PdfPTable tabla = new PdfPTable(19);
        tabla.setWidthPercentage(105);
        float[] medidaCeldas = {2f, 2f, 2f,2f, 1f, 2f, 2f, 2f, 2f, 1f, 2f, 2f, 2f, 2f, 1f, 2f, 1f, 2f, 2f};
        tabla.setWidths(medidaCeldas);

        for (int i = 0; i < cabecera.length; i++) {

            tabla.addCell(new PdfPCell(new Paragraph(cabecera[i], FontFactory.getFont("Arial", 10, Font.BOLD))));
        }

        try {
            // Se crea el documento en la ruta proporcionada
            FileOutputStream file = new FileOutputStream(ruta + ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, file);
            doc.setPageSize(PageSize.A4.rotate());
            doc.open();

            doc.add(title);

            //DB
            //Conexion a la base de datos y se ejecuta el código sql para obtener la información general
            ConexionHi conexion = new ConexionHi();
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
                    //                    + "/*WHERE extract (year from i.ingreso_fecha) = 2017*/\n"
                    + " ORDER BY \n"
                    + " v.victima_codigo, i.ingreso_fecha";

            try {
                Statement comando = conexion.getConnection().createStatement();
                ResultSet res = comando.executeQuery(SQL_SELECT);

                while (res.next()) {
                    //Se añaden los datos obtenidos de la base de datos a la tabla
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
                //Se añade la tabla al documento
                doc.add(tabla);
                // Se cierra el documento
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

    //Metodo para obtener el reporte de las victimas
    public void ReporteGeneralVictima() {
        ControladorRuta cr = new ControladorRuta();
        //Se obttiene la ruta
        String ruta = this.vr.getTxtRuta().getText();
        // Se crea el titulo y se da el formato
        Paragraph title = new Paragraph("Reporte General de las compañeras acogidas", FontFactory.getFont("Arial", 30, Font.BOLD));
        //Diseño
        title.setAlignment(Element.ALIGN_CENTER);
        title.add(new Phrase(Chunk.NEWLINE));
        title.add(new Phrase(Chunk.NEWLINE));

        //Cabecera de la tabla
        String[] cabecera = {"Nombre", "F.Ingreso", "F.Egreso", "Agresor", "Nacionalidad", "Provincia ", "Ciudad", "Parroquia",
            "Años", "Instruccion", "Ocupación", "Esado Civil", "#NNA"};
        PdfPTable tabla = new PdfPTable(13);
          tabla.setWidthPercentage(105);
        for (int i = 0; i < cabecera.length; i++) {

            //Se añaden los datos de la cabecera
            tabla.addCell(new PdfPCell(new Paragraph(cabecera[i], FontFactory.getFont("Arial", 10, Font.BOLD))));
        }

        try {
            //Se crea el documento en la ruta proporcionada
            FileOutputStream file = new FileOutputStream(ruta + ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, file);
            //Forma horizontal
            doc.setPageSize(PageSize.A4.rotate());
            //Se abre el documento
            doc.open();

            //Se agrega el titulo
            doc.add(title);

            //S ecrea la conexion a la base de datos y se ejecuta el codigo sql para obtener la información de la victima
            ConexionHi conexion = new ConexionHi();
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
                    //                    + " WHERE extract (year from i.ingreso_fecha) = 2017\n"
                    + " ORDER BY \n"
                    + " v.victima_codigo, i.ingreso_fecha";

            try {
                Statement comando = conexion.getConnection().createStatement();
                ResultSet res = comando.executeQuery(SQL_SELECT);

                while (res.next()) {
                    //Se añaden los datos obtenidos de la base de datos a la tabla
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

                tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
                //Se añade la tabla
                doc.add(tabla);
                // Se cierra el documento
                doc.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            JOptionPane.showMessageDialog(null, "Documento guardado en:" + ruta);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    //Metodo para obtener el reporte general de los NNA  de las victimas

    public void ReporteGeneralNNA() {
        ControladorRuta cr = new ControladorRuta();
        String ruta = this.vr.getTxtRuta().getText();
        // Se crea el titulo y el formato
        Paragraph title = new Paragraph("Reporte General de los NNA de las compañeras acogidas", FontFactory.getFont("Arial", 30, Font.BOLD));
        //Diseños
        title.setAlignment(Element.ALIGN_CENTER);
        title.add(new Phrase(Chunk.NEWLINE));
        title.add(new Phrase(Chunk.NEWLINE));

        //Cabecera de la tablas
        String[] cabecera = {"Compañera", "#NNA", "NNA", "Sexo", "F.Nacimiento", "Años ", "Año Escolar", "Institución Educativa"};
        PdfPTable tabla = new PdfPTable(8);
        tabla.setWidthPercentage(100);
        for (int i = 0; i < cabecera.length; i++) {

            tabla.addCell(new PdfPCell(new Paragraph(cabecera[i], FontFactory.getFont("Arial", 10, Font.BOLD))));
        }

        // Se crea el documento en la ubicación obtenida
        try {
            FileOutputStream file = new FileOutputStream(ruta + ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, file);
            // Forma Horizontal
            doc.setPageSize(PageSize.A4.rotate());
            //Se abre el documento
            doc.open();

            // Se agrega el titulo
            doc.add(title);

            //Se conecta a la DB y sentencia sql para obtener los datos de los NNA
            ConexionHi conexion = new ConexionHi();
            String SQL_SELECT = "SELECT\n"
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
                    + "WHERE extract (year from i.ingreso_fecha) = 2017\n"
                    + " ORDER BY \n"
                    + " v.victima_codigo, i.ingreso_fecha";

            try {
                Statement comando = conexion.getConnection().createStatement();
                ResultSet res = comando.executeQuery(SQL_SELECT);

                // Se asignan los valores de la DB
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

                // Alineación del documento
                tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
                //Se añade la tabla
                doc.add(tabla);
                //Se cierra el documento
                doc.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            JOptionPane.showMessageDialog(null, "Documento guardado en:" + ruta);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
        }
    }

}
