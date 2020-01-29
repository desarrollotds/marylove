package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
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

    public void iniciarControlRLL(){
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
}
