package marylove.controlador;

import java.awt.Cursor;
import static java.awt.Cursor.*;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import marylove.DBmodelo.HistorialClinicoDB;
import marylove.DBmodelo.psicologoDB;
import marylove.models.HistorialClinico;
import marylove.vista.FichaHistoriaClinica;
import static marylove.controlador.C_Login.personal_cod;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author vasquez
 */
public class ControlHistorialClinico extends Validaciones {

    private FichaHistoriaClinica vistaHC;
    private HistorialClinico modeloHC;
    private HistorialClinicoDB hcDB;

    File archivo;
    private byte[] imagen;
    private int lbtimg;
    public FileInputStream entrada;
    FileNameExtensionFilter filimg = new FileNameExtensionFilter("Formato de archivo JPEG(*.JPG;*PNG*) ", "jpg", "png", "jpeg");
    JFileChooser imagenSelec = new JFileChooser();

    psicologoDB pDB = new psicologoDB();

    public ControlHistorialClinico(FichaHistoriaClinica vistaHC, HistorialClinico modeloHC, HistorialClinicoDB hcDB) throws Exception {
        this.vistaHC = vistaHC;
        this.modeloHC = modeloHC;
        this.hcDB = hcDB;
    }

    public void inicialCHistClini() {
        // .setCursor(new Cursor(WAIT_CURSOR));
        // .setCursor(new Cursor(DEFAULT_CURSOR));
        fechaSistemaIni();
        //validaciones
        vistaHC.getTxtNombre().addKeyListener(validarCedula(vistaHC.getTxtNombre()));//mostrarDatos()
        vistaHC.getTxtCodigo().addKeyListener(validarNumeros(vistaHC.getTxtCodigo()));
        // eventos de botones
        vistaHC.getBtnAgregar1().addActionListener(e -> ingresarIm(vistaHC.getLabGenFam()));
        vistaHC.getBtnGuardar().addActionListener(e -> {vistaHC.getBtnGuardar().setCursor(new Cursor(WAIT_CURSOR));ingresarHC(); vistaHC.getBtnGuardar().setCursor(new Cursor(DEFAULT_CURSOR));});
        vistaHC.getBtnCancelar().addActionListener(e -> limpiar());

        // obtener el codigo
        vistaHC.getTxtNombre().addKeyListener(enter2(vistaHC.getTxtNombre(), vistaHC.getTxtCodigo()));
        vistaHC.getTxtNombre().addKeyListener(mostrarDatos());

    }

    public void ingresarHC() {
        if (vistaHC.getBtnGuardar().getText().equals("Editar")) {
            if (hcDB.actualizar(datos())) {
                JOptionPane.showMessageDialog(null, "Datos Editador");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Editador");
            }
        } else if (vistaHC.getBtnGuardar().getText().equals("Guardar")) {
            if (hcDB.ingresarHistClinico(datos()) && !vistaHC.getTxtCodigo().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Datos ingresar Correctamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Datos no ingresar");
            }
        }

    }

    public void fechaSistemaIni() {
        Calendar c = new GregorianCalendar();
        vistaHC.getJdcFechHC().setCalendar(c);
    }

    public HistorialClinico datos() {
        String tipdeman = "";
        if (vistaHC.getChxTVExplicita().isSelected()) {
            tipdeman = tipdeman + vistaHC.getChxTVExplicita().getText();
        }
        if (vistaHC.getChxTVImplicita().isSelected()) {
            if (tipdeman.equals("")) {
                tipdeman = tipdeman + vistaHC.getChxTVImplicita().getText();
            } else {
                tipdeman = tipdeman + " y " + vistaHC.getChxTVImplicita().getText();
            }
        }
        modeloHC.setVictima_codigo(Integer.parseInt(vistaHC.getTxtCodigo().getText()));
        modeloHC.setPsicologo_codigo(pDB.verifiUserP(personal_cod));
        modeloHC.setMotivo_consulta(vistaHC.getTxaFormulacion().getText());
        modeloHC.setDemanda(vistaHC.getTxtDemanda().getText());
        modeloHC.setDemanda_implicita(tipdeman);
        modeloHC.setHistorial_violencia(vistaHC.getTxtHistoriaViolencia().getText());
        controlArea(vistaHC.getTxaBiografiaPsicologica1());
        modeloHC.setBiog_psico_perso(vistaHC.getTxaBiografiaPsicologica1().getText());
        modeloHC.setGenograma_famili(imagen);
        modeloHC.setGfLong(lbtimg);
        controlArea(vistaHC.getTxaAplicacionPruebas());
        modeloHC.setPrub_descripcion(vistaHC.getTxaAplicacionPruebas().getText());
        modeloHC.setApart_gene_conduct(vistaHC.getTxtSensoperecepcion().getText());
        modeloHC.setConducta(vistaHC.getTxtConducta().getText());
        modeloHC.setFunc_cogni_sensorio(vistaHC.getTxtFuncionesCognitivas().getText());
        modeloHC.setEstado_consiencia(vistaHC.getTxtEstadoConciencia().getText());
        modeloHC.setOrientacion(vistaHC.getTxtOrientacion().getText());
        modeloHC.setMemoria(vistaHC.getTxtMemoria().getText());
        modeloHC.setAtencion_concentracion(vistaHC.getTxtAtencion().getText());
        modeloHC.setAfectividad(vistaHC.getTxtAfectividad().getText());
        modeloHC.setFunciones_ment_superior(vistaHC.getTxtFuncionesMentales().getText());
        modeloHC.setDiagnos_infor(vistaHC.getTxaDiagnosticoInformal().getText());
        controlArea(vistaHC.getTxaDiagnosticoDiferencial());
        modeloHC.setDiagnos_diferencial(vistaHC.getTxaDiagnosticoDiferencial().getText());
        controlArea(vistaHC.getTxaDescripcion());
        modeloHC.setPersonality_descrip(vistaHC.getTxaDescripcion().getText());
        controlArea(vistaHC.getTxaTecnicas());
        modeloHC.setSenala_tecnicas(vistaHC.getTxaTecnicas().getText());
        controlArea(vistaHC.getTxaRecomendaciones());
        modeloHC.setRecomendaciones(vistaHC.getTxaRecomendaciones().getText());
        try {
            modeloHC.setFechaHC(obtenerFecha(vistaHC.getJdcFechHC()));
        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER LA  FECHA " + e.getMessage());
        }
//        vistaHC.getTxaCriterios();
        return modeloHC;

    }

    // metodos de ingreso de imagenes
    public byte[] imgcargar(File archivo, int logbyte) {//trasformar imagen ingresada en byte
        byte[] imagen = new byte[logbyte];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(imagen);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "imagen: " + ex);
            imagen = null;
        }
        return imagen;
    }

    private void ingresarIm(JLabel label) { // metodo para ingresar la imagen en formato jpeg,png,etc
        Image imgijl;
        ImageIcon imgEscalada;
        imagenSelec.setDialogTitle("Buscar imagen");
        imagenSelec.setFileFilter(filimg);
        imagenSelec.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = imagenSelec.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            archivo = imagenSelec.getSelectedFile();
            //necesitamos saber la cantidad de bytes
            lbtimg = ((int) imagenSelec.getSelectedFile().length());
            imagen = imgcargar(archivo, lbtimg);
            imgijl = new ImageIcon(imgcargar(archivo, lbtimg)).getImage();
            imgEscalada = new ImageIcon(imgijl.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
            label.setIcon(imgEscalada);
            label.updateUI();
        }
    }

    public void cargar() {
        modeloHC = hcDB.obtenetCV(Integer.parseInt(vistaHC.getTxtCodigo().getText()));
        vistaHC.getTxaFormulacion().setText(modeloHC.getMotivo_consulta());
        vistaHC.getTxtDemanda().setText(modeloHC.getDemanda());
        vistaHC.getTxtHistoriaViolencia().setText(modeloHC.getHistorial_violencia());
        vistaHC.getTxaBiografiaPsicologica1().setText(modeloHC.getBiog_psico_perso());
        vistaHC.getTxaAplicacionPruebas().setText(modeloHC.getPrub_descripcion());
        vistaHC.getTxtSensoperecepcion().setText(modeloHC.getApart_gene_conduct());
        vistaHC.getTxtConducta().setText(modeloHC.getConducta());
        vistaHC.getTxtFuncionesCognitivas().setText(modeloHC.getFunc_cogni_sensorio());
        vistaHC.getTxtEstadoConciencia().setText(modeloHC.getEstado_consiencia());
        vistaHC.getTxtOrientacion().setText(modeloHC.getOrientacion());
        vistaHC.getTxtMemoria().setText(modeloHC.getMemoria());
        vistaHC.getTxtAtencion().setText(modeloHC.getAtencion_concentracion());
        vistaHC.getTxtAfectividad().setText(modeloHC.getAfectividad());
        vistaHC.getTxtFuncionesMentales().setText(modeloHC.getFunciones_ment_superior());
        vistaHC.getTxaDiagnosticoInformal().setText(modeloHC.getDiagnos_infor());
        vistaHC.getTxaDiagnosticoDiferencial().setText(modeloHC.getDiagnos_diferencial());
        vistaHC.getTxaDescripcion().setText(modeloHC.getPersonality_descrip());
        vistaHC.getTxaTecnicas().setText(modeloHC.getSenala_tecnicas());
        vistaHC.getTxaRecomendaciones().setText(modeloHC.getRecomendaciones());
        vistaHC.getLabGenFam().setIcon(cargarIMG(modeloHC.getGenograma_famili(), vistaHC.getLabGenFam().getWidth(), vistaHC.getLabGenFam().getHeight()));
        imagen = modeloHC.getGenograma_famili();
    }

    public void limpiar() {
        vistaHC.getTxtNombre().setText("");
        vistaHC.getTxtCodigo().setText("");
        vistaHC.getTxaFormulacion().setText("");
        vistaHC.getTxtDemanda().setText("");
        vistaHC.getTxtHistoriaViolencia().setText("");
        vistaHC.getTxaBiografiaPsicologica1().setText("");
        vistaHC.getTxaAplicacionPruebas().setText("");
        vistaHC.getTxtSensoperecepcion().setText("");
        vistaHC.getTxtConducta().setText("");
        vistaHC.getTxtFuncionesCognitivas().setText("");
        vistaHC.getTxtEstadoConciencia().setText("");
        vistaHC.getTxtOrientacion().setText("");
        vistaHC.getTxtMemoria().setText("");
        vistaHC.getTxtAtencion().setText("");
        vistaHC.getTxtAfectividad().setText("");
        vistaHC.getTxtFuncionesMentales().setText("");
        vistaHC.getTxaDiagnosticoInformal().setText("");
        vistaHC.getTxaDiagnosticoDiferencial().setText("");
        vistaHC.getTxaDescripcion().setText("");
        vistaHC.getTxaTecnicas().setText("");
        vistaHC.getTxaRecomendaciones().setText("");
        vistaHC.getLabGenFam().setIcon(null);
        vistaHC.getBtnGuardar().setText("Guardar");
    }

    public KeyListener mostrarDatos() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!vistaHC.getTxtCodigo().getText().equals("")) {
                        if (hcDB.obtenetCV(Integer.parseInt(vistaHC.getTxtCodigo().getText())).getHist_id() != 0) {
                            cargar();
                            vistaHC.getBtnGuardar().setText("Editar");
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        return kn;
    }
}
