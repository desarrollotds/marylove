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
    private DefaultTableModel modelotabla = new DefaultTableModel();
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
                modelotabla = sentencias.ReporteGeneral();
                excel.Impresion(vreportes, modelotabla);
            }
            if (bandera == 2) {
                modelotabla = sentencias.ReporteBitacora();
                excel.Impresion(vreportes, modelotabla);
            }
        }

        ///////////////////////
        if (e.getSource().equals(vreportes.getBtnGenerar())) {
            String parametroAño = vreportes.getjComboBoxAnios().getSelectedItem().toString();
            if (bandera == 1) {
                reporteAnio();
            }
            if (bandera == 2) {
                if (vreportes.getCbxTipoGeneral().getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(vreportes, "Seleccione el tipo de reporte", "Mensaje de Información", JOptionPane.WARNING_MESSAGE);
                }
                if (vreportes.getCbxTipoGeneral().getSelectedIndex() == 1) {
//                    createGeneralReport();
                }
                if (vreportes.getCbxTipoGeneral().getSelectedIndex() == 2) {
                    createVictimaReport();
                }
                if (vreportes.getCbxTipoGeneral().getSelectedIndex() == 3) {
                    createNNAReport();
                }
            }
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

    public void reporteAnio() {
        String titulo = "Reporte Anual";
        String[] cabecera = {"N", "Nombre", "F.Ingreso", "F.Egreso", "NNA", "Embarazo", "Llamada linea apoyo", "Bienvenida", "Plan Emergente",
            "Plan de vida", "Evaluacion plan vida", "Plan de autonimia"};
        PdfPTable tabla = createTable(cabecera, 12);
        float[] medidaCeldas = {1f, 4f, 2f, 2f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f};
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

            String SQL_SELECT = "SELECT v.victima_codigo as \"N\",\n"
                    + "p.persona_nombre ||'  '||p.persona_apellido as \"Nombre\",\n"
                    + "i.ingreso_fecha as \"Fecha de ingreso\",\n"
                    + "e.egreso_fecha as \"Fecha de egreso\",\n"
                    + "(select count(*) from hijos h where h.victima_codigo =v.victima_codigo  )as NNA ,\n"
                    + "(SELECT CASE WHEN (select v1.victima_embarazo from victima v1  where v.victima_codigo=  v1.victima_codigo and  v1.victima_embarazo = true) IS NOT\n"
                    + "NULL THEN  '1'   ELSE  '' END) as \"Embarazo\",\n"
                    + "(SELECT CASE WHEN (select rf.llamada_lineaapoyo from registro_referencia rf where  v.victima_codigo = rf.victima_codigo  and rf.llamada_lineaapoyo = true) IS NOT\n"
                    + "NULL THEN  '1'   ELSE  '' END) as \"llamanda a la linea\",\n"
                    + "(select count(*)from registro_referencia rf where  v.victima_codigo = rf.victima_codigo ) as \"Binvenida\",\n"
                    + "\n"
                    + "(select count(*) from plan_emergente pe where v.victima_codigo = pe.victima_codigo)as \"plan emergente\",\n"
                    + "(select count(*) from plan_vida pv where v.victima_codigo = pv.victima_codigo)as \"plan de vida\",\n"
                    + "(select count(*) from evaluacion_plan_vida epv  where v.victima_codigo = epv.victima_codigo)as \"Evaluacion plan de vida\",\n"
                    + "(select count(*) from plan_autonomia pa where v.victima_codigo = pa.victima_codigo)as \"plan de autonimia\"\n"
                    + "from persona p\n"
                    + "join victima v\n"
                    + "on v.persona_codigo = p.persona_codigo\n"
                    + "join ingreso i\n"
                    + "on i.victima_codigo = v.victima_codigo\n"
                    + "left join egreso e\n"
                    + "on e.victima_codigo = v.victima_codigo\n"
                    + " WHERE extract (year from i.ingreso_fecha) ="
                    + vreportes.getjComboBoxAnios().getSelectedItem() + ";";

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
                }

                doc.add(tabla);
                doc.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(vreportes, "Se ha producido un error generar el reporte",
                        "MENSAJE DE INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "Reporte guardado");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(vreportes, "Se ha producido un error generar el reporte",
                    "MENSAJE DE INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
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
//    public void createGeneralReport() {
//        String titulo = "Reporte General de las compañeras acogidas";
//        String[] cabecera = {"Nombre", "F.Ingreso", "F.Egreso", "Agresor", "Nacionalidad", "Provincia", "Ciudad", "Parroquia", "Años", "Instruccion",
//            "Ocupación", "Estado Civil ", "#NNA", "NNA", "Sexo", "F.Nacimiento", "Años", "Año Escolar", "Institución Educativa"};
//        PdfPTable tabla = createTable(cabecera, 19);
//        float[] medidaCeldas = {2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 1f, 2f, 2f, 2f, 1f, 2f, 1f, 2f, 1f, 2f, 2f};
//        try {
//            tabla.setWidths(medidaCeldas);
//        } catch (Exception e) {
//        }
//        try {
////            Document doc = createDocument();
////            doc.add(createTittle(titulo));
////            doc.add(new Phrase(Chunk.NEWLINE));
////            Paragraph fecha = new Paragraph(Fecha());
////            fecha.setAlignment(Element.ALIGN_RIGHT);
////            doc.add(fecha);
////            doc.add(new Phrase(Chunk.NEWLINE));
//            String SQL_SELECT = "SELECT\n"
//                    + " p.persona_nombre||' '|| p.persona_apellido AS \"Compañera\",\n"
//                    + " (CASE\n"
//                    + " WHEN  i.ingreso_fecha  IS NULL THEN ''\n"
//                    + " ELSE i.ingreso_fecha||''\n"
//                    + " END) AS \"Fecha Ingreso\" ,\n"
//                    + " (CASE\n"
//                    + " WHEN  e.egreso_fecha  IS NULL THEN ''\n"
//                    + " ELSE e.egreso_fecha||''\n"
//                    + " END) AS \"Fecha Egreso\" ,\n"
//                    + " (select par_valores->xra.parentesco->>'valor' from parametros where par_id = 9) AS \"Agresor\",\n"
//                    + " (select par_valores->p.persona_nacionalidad->>'valor' from parametros where par_id = 3) AS \"Nacionalidad\",\n"
//                    + " (CASE\n"
//                    + " WHEN d.dir_provincia  IS NULL THEN ''\n"
//                    + " ELSE d.dir_provincia||''\n"
//                    + " END) AS \"Provincia\" ,\n"
//                    + " (CASE\n"
//                    + " WHEN d.dir_ciudad  IS NULL THEN ''\n"
//                    + " ELSE d.dir_ciudad||''\n"
//                    + " END) AS \"Ciudad\" ,\n"
//                    + " (CASE\n"
//                    + " WHEN d.dir_parroquia  IS NULL THEN ''\n"
//                    + " ELSE d.dir_parroquia||''\n"
//                    + " END) AS \"Parroquia\" ,\n"
//                    + " (CASE\n"
//                    + " WHEN  ((current_date-p.persona_fecha_nac)/365)  IS NULL THEN ''\n"
//                    + " ELSE ((current_date-p.persona_fecha_nac)/365)||''\n"
//                    + " END) AS \"Años\" ,\n"
//                    + " (select par_valores->p.persona_nivel_acad->>'valor' from parametros where par_id = 5) AS \"Instruccion\",\n"
//                    + " (select par_valores->p.persona_ocupacion->>'valor' from parametros where par_id = 7) AS \"Ocupacion\",\n"
//                    + " (select par_valores->p.persona_estadocivil->>'valor' from parametros where par_id = 4) AS \"Estado Civil\",\n"
//                    + " (SELECT\n"
//                    + " COUNT(*)\n"
//                    + " FROM\n"
//                    + " hijos h \n"
//                    + " WHERE\n"
//                    + " h.victima_codigo =v.victima_codigo) AS \"NNA Responsables\",\n"
//                    + " (CASE\n"
//                    + " WHEN  p1.persona_nombre || ' '||p1.persona_apellido  IS NULL THEN ''\n"
//                    + " ELSE p1.persona_nombre || ' '||p1.persona_apellido\n"
//                    + " END)\n"
//                    + " AS \" NNA\",\n"
//                    + " (CASE\n"
//                    + " WHEN p1.persona_sexo IS NULL THEN ''\n"
//                    + " ELSE p1.persona_sexo||''\n"
//                    + " END) AS \"Sexo\" ,\n"
//                    + " (CASE\n"
//                    + " WHEN p1.persona_fecha_nac  IS NULL THEN ''\n"
//                    + " ELSE p1.persona_fecha_nac||''\n"
//                    + " END) AS \"Fecha de Nacimiento\" ,\n"
//                    + " (CASE\n"
//                    + " WHEN  ((current_date-p1.persona_fecha_nac)/365)  IS NULL THEN ''\n"
//                    + " ELSE ((current_date-p1.persona_fecha_nac)/365)||''\n"
//                    + " END) AS \"Años NNA \" ,\n"
//                    + " (CASE\n"
//                    + " WHEN  h.hijo_anioescolar IS NULL THEN ''\n"
//                    + " ELSE  h.hijo_anioescolar||''\n"
//                    + " END) AS \"Año Escolar\" ,\n"
//                    + " (CASE\n"
//                    + " WHEN ie.inst_nombre IS NULL THEN ''\n"
//                    + " ELSE ie.inst_nombre||''\n"
//                    + " END) AS \"Institucion Educativa\" \n"
//                    + "\n"
//                    + " FROM\n"
//                    + " persona p\n"
//                    + " JOIN \n"
//                    + " victima v\n"
//                    + " ON \n"
//                    + " v.persona_codigo = p.persona_codigo\n"
//                    + " JOIN\n"
//                    + " ingreso i\n"
//                    + " ON \n"
//                    + " i.victima_codigo = v.victima_codigo\n"
//                    + " LEFT JOIN\n"
//                    + " egreso e\n"
//                    + " ON\n"
//                    + " e.victima_codigo = v.victima_codigo\n"
//                    + " LEFT JOIN\n"
//                    + " direccion_persona dp\n"
//                    + " ON\n"
//                    + " p.persona_codigo = dp.persona_codigo\n"
//                    + " LEFT JOIN \n"
//                    + " direccion d\n"
//                    + " ON \n"
//                    + " d.dir_codigo = dp.dir_domicilio\n"
//                    + " LEFT JOIN  hijos h\n"
//                    + " ON h.victima_codigo = v.victima_codigo\n"
//                    + " LEFT JOIN persona p1\n"
//                    + " ON p1.persona_codigo = h.persona_codigo\n"
//                    + " LEFT JOIN \n"
//                    + " institucion_educativa ie\n"
//                    + " ON ie.inst_codigo = h.institucion_codigo\n"
//                    + " LEFT JOIN registro_referencia rr\n"
//                    + " ON\n"
//                    + " v.victima_codigo = rr.victima_codigo\n"
//                    + " LEFT  JOIN x_registro_agresor xra\n"
//                    + " ON\n"
//                    + " xra.registroreferencia_codigo =rr.registroreferencia_codigo \n"
//                    + "LEFT JOIN \n"
//                    + " agresor a\n"
//                    + " ON a.agresor_codigo = xra.agresor_codigo\n"
//                    + "WHERE extract (year from i.ingreso_fecha) = " + vreportes.getjComboBoxAnios().getSelectedItem() + "\n"
//                    + " ORDER BY \n"
//                    + " v.victima_codigo, i.ingreso_fecha\n";
//
//            try {
//                ResultSet res = conn.query(SQL_SELECT);
//                modelogeneral.setColumnIdentifiers(new Object[]{"Personal", "Fecha", "Descripción"});
//                while (res.next()) {
//                    modelogeneral.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
//                        res.getString(4), res.getString(5), res.getString(6),
//                        res.getString(7), res.getString(8), res.getString(9),
//                        res.getString(10), res.getString(11), res.getString(12),
//                        res.getString(13), res.getString(14), res.getString(15),
//                        res.getString(16), res.getString(17), res.getString(18), res.getString(19)});
//
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(1), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(2), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(3), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(4), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(5), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(6), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(7), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(8), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(9), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(10), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(11), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(12), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(13), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(14), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(15), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(16), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(17), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(18), FontFactory.getFont("Arial", 9))));
////                    tabla.addCell(new PdfPCell(new Paragraph(res.getString(19), FontFactory.getFont("Arial", 9))));
//                }
////                doc.add(tabla);
////                doc.close();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(vreportes, "Se ha producido un error generar el reporte",
//                        "MENSAJE DE INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
//            }
//            JOptionPane.showMessageDialog(vreportes, "Documento Generado",
//                    "MENSAJE DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(vreportes, "Se ha producido un error generar el reporte",
//                    "MENSAJE DE INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
//        }
//    }
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

            String SQL_SELECT = " SELECT DISTINCT \n"
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
                    + " JOIN\n"
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
                    + " WHERE extract (year from i.ingreso_fecha) = " + vreportes.getjComboBoxAnios().getSelectedItem() + "\n";

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
                JOptionPane.showMessageDialog(vreportes, "Se ha producido un error generar el reporte",
                        "MENSAJE DE INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(vreportes, "Documento generado",
                    "MENSAJE DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vreportes, "Se ha producido un error generar el reporte",
                    "MENSAJE DE INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
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
                    + " JOIN\n"
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
                    + "WHERE extract (year from i.ingreso_fecha) = " + vreportes.getjComboBoxAnios().getSelectedItem() + "\n"
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
                JOptionPane.showMessageDialog(vreportes, "Se ha producido un error generar el reporte",
                        "MENSAJE DE INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            }
            doc.add(tabla);
            doc.close();
            JOptionPane.showMessageDialog(vreportes, "Documento Generado",
                    "MENSAJE DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException ex) {
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
        String[] items = {"Selccione el tipo de reporte...", "Reporte General", "Reporte de Bitacora", "Reporte de Formularios", "F.Nacimiento", "Años ", "Año Escolar", "Institución Educativa"};
        for (int i = 0; i < items.length; i++) {
            vreportes.getCbxTipoReporte().addItem(items[i]);
        }

    }

}
