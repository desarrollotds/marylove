package marylove.controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
import marylove.models.Persona_llamada;
import marylove.vista.VistaRegistroLlamadas;
/**
 *
 * @author USUARIO
 */
public class Controlador_registro_llamadas extends Validaciones {

    VistaRegistroLlamadas vistaRegis_Llamadas;

    public Controlador_registro_llamadas(VistaRegistroLlamadas vistaRegis_Llamadas) {
        this.vistaRegis_Llamadas = vistaRegis_Llamadas;
    }

    public void iniciarControlRLL() {
        Timer tiempo = new Timer(100, new horas());
        tiempo.start();
    }

    class horas implements ActionListener { // metodo para tomar la hora actual y mostrar

        @Override
        public void actionPerformed(ActionEvent e) {
            Date hora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat forHora = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            vistaRegis_Llamadas.getJlbHoraActu().setText(String.format(forHora.format(hora), hoy));
        }
    }

    private Persona_llamada datosPersona() {
        Persona_llamada perLlam = new Persona_llamada();
        perLlam.setPer_nombre(vistaRegis_Llamadas.getTxtNombreBeneficiaria().getText());
        perLlam.setPer_apellido(vistaRegis_Llamadas.getTxtApellidoBeneficiaria().getText());
        perLlam.setPer_estado_civil(vistaRegis_Llamadas.getCbxEstadoCivilBeneficiaria().getSelectedItem().toString());
        perLlam.setPer_rango_edad(vistaRegis_Llamadas.getSpnEdadBeneficiaria().getValue().toString());
        if (vistaRegis_Llamadas.getJrbHijSi().isSelected()) {
            perLlam.setPer_numerohijos((int)vistaRegis_Llamadas.getJspNHijos().getValue());
        } else {
            if (vistaRegis_Llamadas.getJrbHijNo().isSelected()) {
                perLlam.setPer_numerohijos(0);
            } else {
                if (vistaRegis_Llamadas.getJrbNoRep().isSelected()) {
                    perLlam.setPer_numerohijos(0);
                }
            }
        }
//        if(vistaRegis_Llamadas.getJrbTrabSi().isSelected()){
//        perLlam.setPer_cargo(per_cargo);
        return null;

    }
}
