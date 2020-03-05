package marylove.controlador;

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
import marylove.conexion.Conexion;
import marylove.models.HistorialClinico;
import marylove.vista.FichaHistoriaClinica;
import static marylove.controlador.C_Login.personal_cod;

/**
 *
 * @author vasquez
 */
public class ControlHistorialClinico extends Validaciones {

    private FichaHistoriaClinica vistaHC;
    private HistorialClinico modeloHC;
    private HistorialClinicoDB hcDB;
    private Conexion conex;
    
    File archivo;
    private byte[] imagen;
    private int lbtimg;
    public FileInputStream entrada;
    FileNameExtensionFilter filimg = new FileNameExtensionFilter("Formato de archivo JPEG(*.JPG;*PNG*) ", "jpg", "png", "jpeg");
    JFileChooser imagenSelec = new JFileChooser();
    
    psicologoDB pDB = new psicologoDB();

    public ControlHistorialClinico(FichaHistoriaClinica vistaHC, HistorialClinico modeloHC, HistorialClinicoDB hcDB, Conexion conex) {
        this.vistaHC = vistaHC;
        this.modeloHC = modeloHC;
        this.hcDB = hcDB;
        this.conex = conex;
        vistaHC.setVisible(true);
    }

    

    public void inicialCHistClini() {
        //validaciones
        vistaHC.getTxtNombre().addKeyListener(validarCedula(vistaHC.getTxtNombre()));
        vistaHC.getTxtCodigo().addKeyListener(validarNumeros(vistaHC.getTxtCodigo()));
        // eventos de botones
        vistaHC.getBtnAgregar1().addActionListener(e -> ingresarIm(vistaHC.getLabGenFam()));
        vistaHC.getBtnGuardar().addActionListener(e -> ingresarHC());
        
        // obtener el codigo
        vistaHC.getTxtNombre().addKeyListener(enter2(conex, vistaHC.getTxtNombre(), vistaHC.getTxtCodigo()));

    }
    
    public void ingresarHC(){
        if (hcDB.ingresarHistClinico(conex, datos()) && !vistaHC.getTxtCodigo().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Datos ingresar Correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Datos no ingresar");
        }
    }

    public HistorialClinico datos() {
        String tipdeman="";
        if (vistaHC.getChxTVExplicita().isSelected()) {
            tipdeman = tipdeman+vistaHC.getChxTVExplicita().getText();
        }
        if (vistaHC.getChxTVImplicita().isSelected()) {
            if (tipdeman.equals("")) {
                tipdeman = tipdeman+vistaHC.getChxTVImplicita().getText();
            }else{
                tipdeman = tipdeman+" y "+vistaHC.getChxTVImplicita().getText();
            }
        }
        modeloHC.setVictima_codigo(Integer.parseInt(vistaHC.getTxtCodigo().getText()));
        modeloHC.setPsicologo_codigo(pDB.verifiUserP(conex, personal_cod));
        modeloHC.setMotivo_consulta(vistaHC.getTxaFormulacion().getText());
        modeloHC.setDemanda(vistaHC.getTxtDemanda().getText());
        modeloHC.setDemanda_implicita(tipdeman);
        modeloHC.setHistorial_violencia(vistaHC.getTxtHistoriaViolencia().getText());
        modeloHC.setBiog_psico_perso(vistaHC.getTxaBiografiaPsicologica1().getText());
        modeloHC.setGenograma_famili(imagen);
        modeloHC.setGfLong(lbtimg);
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
        modeloHC.setDiagnos_diferencial(vistaHC.getTxaDiagnosticoDiferencial().getText());
        modeloHC.setMemoria(vistaHC.getTxtMemoria().getText());
        modeloHC.setPersonality_descrip(vistaHC.getTxaDescripcion().getText());
        modeloHC.setSenala_tecnicas(vistaHC.getTxaTecnicas().getText());
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

    private void ingresarIm(JLabel  label) { // metodo para ingresar la imagen en formato jpeg,png,etc
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
}
