package marylove.controlador;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import marylove.DBmodelo.primer_EncuentroDB;
import marylove.DBmodelo.psicologoDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.vista.FichaPrimerEncuentro;

/**
 *
 * @author Usuario
 */
public class ControladorPrimerEncuentro extends Validaciones {

    private final FichaPrimerEncuentro vista_1encuentro;
    private final primer_EncuentroDB modelo_1encuentro;
    psicologoDB pDB = new psicologoDB();

    public ControladorPrimerEncuentro(FichaPrimerEncuentro vista_1encuentro, primer_EncuentroDB modelo_1encuentro) throws Exception {
        this.vista_1encuentro = vista_1encuentro;
        this.modelo_1encuentro = modelo_1encuentro;
    }

    public void iniciarControl() {
        vista_1encuentro.getTxtNombre().addKeyListener(validarLetras(vista_1encuentro.getTxtNombre()));
        vista_1encuentro.getTxtCodigo().addKeyListener(validarNumeros(vista_1encuentro.getTxtCodigo()));
        vista_1encuentro.getTxtCedula().addKeyListener(validarCedula(vista_1encuentro.getTxtCedula()));
        vista_1encuentro.getBtnGuardar().addActionListener(e -> insertaDatos());
        vista_1encuentro.getBtnCancelar().addActionListener(e -> borrarDatos());
        vista_1encuentro.getTxtCedula().addKeyListener(enter1(vista_1encuentro.getTxtCedula(), vista_1encuentro.getTxtNombre(), vista_1encuentro.getTxtCodigo()));

        Calendar c2 = new GregorianCalendar();
        vista_1encuentro.getDatFechaPrimerEncuentro().setCalendar(c2);
    }

    public void insertaDatos() {
        if (vista_1encuentro.getTxaEstadoEmocional().getText().equals("")
                || vista_1encuentro.getTxaNivelRiesgo().getText().equals("")
                || vista_1encuentro.getTxaValoracionDaño().getText().equals("")
                || vista_1encuentro.getTxaInquietudes().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            modelo_1encuentro.setVictima_codigo(Integer.parseInt(vista_1encuentro.getTxtCodigo().getText()));
            modelo_1encuentro.setPstIntCrisis_fecha(obtenerFecha(vista_1encuentro.getDatFechaPrimerEncuentro()));
            controlArea(vista_1encuentro.getTxaEstadoEmocional());
            modelo_1encuentro.setPstIntCrisis_estado_emocional(vista_1encuentro.getTxaEstadoEmocional().getText());
            controlArea(vista_1encuentro.getTxaNivelRiesgo());
            modelo_1encuentro.setPstIntCrisis_nivel_riesgo(vista_1encuentro.getTxaNivelRiesgo().getText());
            controlArea(vista_1encuentro.getTxaValoracionDaño());
            modelo_1encuentro.setPstIntCrisis_valoracionpreliminar(vista_1encuentro.getTxaValoracionDaño().getText());
            String opc = (String)vista_1encuentro.getCmbRiesgo().getSelectedItem();
            if (opc.equals("Si")) {
                modelo_1encuentro.setPstIntCrisis_riesgo_suicida(true);
            }
            if (opc.equals("No")) {
                modelo_1encuentro.setPstIntCrisis_riesgo_suicida(false);
            }
            modelo_1encuentro.setPstIntCrisis_puntosReelevantes(vista_1encuentro.getTxaInquietudes().getText());
            if (vista_1encuentro.getJrbSi().isSelected()) {
                modelo_1encuentro.setPstIntCrisis_proceso_psicoterapeutico(true);
            } else if (vista_1encuentro.getJrbNo().isSelected()) {
                modelo_1encuentro.setPstIntCrisis_proceso_psicoterapeutico(false);
            }
            
            if (vista_1encuentro.getJrbProceso().isSelected()) {
                modelo_1encuentro.setPstIntCrisis_asesoria(true);
            } else if (vista_1encuentro.getJrbAsesoria().isSelected()) {
                modelo_1encuentro.setPstIntCrisis_asesoria(false);
            }
            
            modelo_1encuentro.setPsicologo_codigo(pDB.verifiUserP(personal_cod));
            try {
                if (modelo_1encuentro.Ingresar_PrimerEncuentro() ) {
                    JOptionPane.showMessageDialog(null, "Datos Insertado Correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null,"ERROOOOOR no se puede ingresar los datos debido a que no es Psicologo> " + e);
            }
                
            
        }
    }

    public void borrarDatos() {
        vista_1encuentro.getTxtNombre().setText("");
        vista_1encuentro.getTxtCodigo().setText("");
        vista_1encuentro.getTxtCedula().setText("");
        vista_1encuentro.getTxaEstadoEmocional().setText("");
        vista_1encuentro.getTxaInquietudes().setText("");
        vista_1encuentro.getTxaNivelRiesgo().setText("");
        vista_1encuentro.getTxaValoracionDaño().setText("");
        //vista_1encuentro.getTxtPsicologa().setText("");
        vista_1encuentro.getTxaNivelRiesgo().setText("");
        vista_1encuentro.getBtngp1().clearSelection();
        vista_1encuentro.getBtngp2().clearSelection();

    }
}
