package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import marylove.DBmodelo.primer_EncuentroDB;
import marylove.conexion.Conexion;
import marylove.models.Primer_encuentro;
import marylove.vista.FichaPrimerEncuentro;

/**
 *
 * @author Usuario
 */
public class ControladorPrimerEncuentro extends Validaciones {

    private final FichaPrimerEncuentro Vista_1_Encuentro;
    private final Primer_encuentro Modelo_1_Encuentro;
    private final Conexion conex;
    private primer_EncuentroDB pri_enDB;

    public ControladorPrimerEncuentro(FichaPrimerEncuentro Vista_1_Encuentro, Primer_encuentro Modelo_1_Encuentro, Conexion conex) {
        this.Vista_1_Encuentro = Vista_1_Encuentro;
        this.Modelo_1_Encuentro = Modelo_1_Encuentro;
        this.conex = conex;
        Vista_1_Encuentro.setVisible(true);
    }

    public void iniciarControl() {
        Vista_1_Encuentro.getTxtNombre().addKeyListener(validarLetras(Vista_1_Encuentro.getTxtNombre()));
        Vista_1_Encuentro.getTxtCodigo().addKeyListener(validarNumeros(Vista_1_Encuentro.getTxtCodigo()));
        Vista_1_Encuentro.getBtnGuardar().addActionListener(e -> pri_enDB.Ingresar_PrimerEncuentro(conex, insertaDatos()));
        Vista_1_Encuentro.getBtnCancelar().addActionListener(e -> borrarDatos());
    }

    public Primer_encuentro insertaDatos() {
        Date fech=Vista_1_Encuentro.getDatFechaPrimerEncuentro().getDate();
        Modelo_1_Encuentro.setPrimer_codigo(1);
        Modelo_1_Encuentro.setVictima_codigo(2);
        Modelo_1_Encuentro.setPstIntCrisis_fecha(fech);
        Modelo_1_Encuentro.setPstIntCrisis_estado_emocional(Vista_1_Encuentro.getTxaEstadoEmocional().getText());
        Modelo_1_Encuentro.setPstIntCrisis_nivel_riesgo(Vista_1_Encuentro.getTxaNivelRiesgo().getText());
        Modelo_1_Encuentro.setPstIntCrisis_valoracionpreliminar(Vista_1_Encuentro.getTxaValoracionDaño().getText());
        Modelo_1_Encuentro.setPstIntCrisis_riesgo_suicida(Vista_1_Encuentro.getCmbRiesgo().getSelectedItem().toString());
        Modelo_1_Encuentro.setPstIntCrisis_puntosReelevantes(Vista_1_Encuentro.getTxaInquietudes().getText());
        if (Vista_1_Encuentro.getJrbSi().isSelected()) {
            Modelo_1_Encuentro.setPstIntCrisis_proceso_psicoterapeutico(true);
            
        } else if(Vista_1_Encuentro.getJrbNo().isSelected()){
            Modelo_1_Encuentro.setPstIntCrisis_proceso_psicoterapeutico(false);
        }
        if (Vista_1_Encuentro.getJrbProceso().isSelected()) {
            Modelo_1_Encuentro.setPstIntCrisis_asesoria(true);
            
        } else if(Vista_1_Encuentro.getJrbAsesoria().isSelected()){
            Modelo_1_Encuentro.setPstIntCrisis_asesoria(false);
        }
        Modelo_1_Encuentro.setPstIntCrisis_asesoria(true);
        Modelo_1_Encuentro.setPsicologo_codigo(1);
        return Modelo_1_Encuentro;
    }

    public void borrarDatos() {
        Vista_1_Encuentro.getTxtNombre().setText("");
        Vista_1_Encuentro.getTxtCodigo().setText("");
        Vista_1_Encuentro.getTxaEstadoEmocional().setText("");
        Vista_1_Encuentro.getTxaInquietudes().setText("");
        Vista_1_Encuentro.getTxaNivelRiesgo().setText("");
        Vista_1_Encuentro.getTxaValoracionDaño().setText("");
        Vista_1_Encuentro.getTxtPsicologa().setText("");
        Vista_1_Encuentro.getTxaNivelRiesgo().setText("");

    }
}
