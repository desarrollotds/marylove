package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Timer;
import marylove.models.Llamada;
import marylove.models.Persona_llamada;
import marylove.models.x_resultado_llamada;
import marylove.vista.VistaRegistroLlamada;
import marylove.DBmodelo.Persona_llamadaDB;
import marylove.models.Resultado;

/**
 *
 * @author USUARIO
 */
public class Controlador_registro_llamadas implements ActionListener {

    VistaRegistroLlamada vistaRegis_Llamadas;
    DefaultComboBoxModel modelo;// modelo para setear datos en los combos
    ArrayList<Resultado> res;//lista de resultados

    public Controlador_registro_llamadas(VistaRegistroLlamada vistaRegis_Llamadas) {
        this.vistaRegis_Llamadas = vistaRegis_Llamadas;
        this.vistaRegis_Llamadas.getBtnGuardar().addActionListener(this);
        llenarComboResultados();
//        this.vistaRegis_Llamadas.setVisible(true);
//        this.vistaRegis_Llamadas.setResizable(false);
//        this.vistaRegis_Llamadas.setLocationRelativeTo(null);
    }

    public void iniciarControlRLL() {
        Timer tiempo = new Timer(100, new horas());
        tiempo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(vistaRegis_Llamadas.getBtnGuardar())) {

        }

    }
public void caracteristicasViolencia(){

    if (vistaRegis_Llamadas.getCbFisica().isSelected()) {
        
    }
}
    public void llenarComboResultados() {//llenado del combo resultados
        modelo = new DefaultComboBoxModel();
        Persona_llamadaDB p=new Persona_llamadaDB();
        //res=p.listaResultados();
        for (Resultado o: res) {
            modelo.addElement(o.getResultado_nombre());
        }
        vistaRegis_Llamadas.getCbReultados().setModel(modelo);
    }

    public void resultados() {
        Llamada llama = new Llamada();
        int llamadacodigoId = llama.obtenerId();
        int resultado = 0;
        String descripcion = "";
        resultado = vistaRegis_Llamadas.getCbReultados().getSelectedIndex();
        descripcion = vistaRegis_Llamadas.getTxtOtrosResultado().getText();
        x_resultado_llamada xrl = new x_resultado_llamada(llamadacodigoId, resultado, descripcion);
        xrl.ingresarResultados(xrl);
    }

    public void datosDeInformcion() {

        String nombre = "", apellido = "", edad, direccion, estado_civil, nacionalidad, comosupollamada;
        int numerohijos = 0;
        boolean trabaja = true;
        try {
            if (vistaRegis_Llamadas.getTxtNombreVictima().getText().matches("[A-Z a-z]*")) {
                nombre = vistaRegis_Llamadas.getTxtNombreVictima().getText().toUpperCase();
            } else {

            }
            if (vistaRegis_Llamadas.getTxtApellidoVictima().getText().matches("[A-Z a-z]*")) {
                apellido = vistaRegis_Llamadas.getTxtApellidoVictima().getText().toUpperCase();
            } else {

            }
            edad = vistaRegis_Llamadas.getSpnEdadVictima().getValue().toString();
            System.out.println(edad);
            direccion = vistaRegis_Llamadas.getTxtDireccionVictima().getText();
            nacionalidad = vistaRegis_Llamadas.getCbnacionalidadVictima().getSelectedItem().toString();
            estado_civil = vistaRegis_Llamadas.getCbxEstadoCivilVictima().getSelectedItem().toString();
            numerohijos = Integer.parseInt(vistaRegis_Llamadas.getSpnNumeroHijos().getValue().toString());
            comosupollamada = vistaRegis_Llamadas.getTxtComoSupoLineaTelfonica().getText();
            if (vistaRegis_Llamadas.getRbTrabajaSi().isSelected()) {
                trabaja = true;
            }
            if (vistaRegis_Llamadas.getRbTrabajaNoReporta().isSelected()) {
                trabaja = false;
            }
            if (vistaRegis_Llamadas.getRbTrabajoNo().isSelected()) {
                trabaja = false;
            }
            Persona_llamada pl = new Persona_llamada(nombre, apellido, direccion, nacionalidad, edad, estado_civil, numerohijos, comosupollamada, trabaja);
            Persona_llamadaDB pldb = new Persona_llamadaDB();
            pldb.ingresarPersona_llamada(pl);
        } catch (Exception e) {
        }

    }

    class horas implements ActionListener { // metodo para tomar la hora actual y mostrar

        @Override
        public void actionPerformed(ActionEvent e) {
            Date hora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat forHora = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            // vistaRegis_Llamadas.getJlbHoraActu().setText(String.format(forHora.format(hora), hoy));
        }
    }
}
