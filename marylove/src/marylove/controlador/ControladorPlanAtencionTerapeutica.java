/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//falta completar el controlador
package marylove.controlador;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.DBmodelo.PlanAtencionTerapeuticoDB;
import marylove.models.PlanAtencionTerapeutica;
import marylove.vista.FichaPlanAtencionTerapeutica;

/**
 *
 * @author LENOVO
 */
public class ControladorPlanAtencionTerapeutica extends Validaciones {
    private final FichaPlanAtencionTerapeutica vista;
    private final PlanAtencionTerapeuticoDB modelo;

    public ControladorPlanAtencionTerapeutica(FichaPlanAtencionTerapeutica vista, PlanAtencionTerapeuticoDB modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    
    public void iniciarControlador(){
        abrirVentana();
        obtenerFechaSistema();
        vista.getBtnGuardar().addActionListener(e->agregarFicha());
        
    }

    //agregar la fecha
    public void agregarFicha(){
        modelo.setPlan_at_fecha(obtenerFecha(vista.getDcFecha()));
        modelo.setPlan_at_codigo(vista.getTxtCodigo().getText());
        modelo.setHist_id(1);
        modelo.setPlan_at_encuadre_terapeuta(vista.getTxaEncuadre().getText());
        modelo.setPlan_at_obj_atencion(vista.getTxaObjetivos().getText());
        modelo.setPlan_at_derechos_victima(vista.getTxaDerechosConcuicados().getText());
        modelo.setPlan_at_estrategias_rep(vista.getTxaEstrategias().getText());
        modelo.setPlan_at_compromisos_terep(vista.getTxaCompromisos().getText());
        
        if (vista.getBtnGuardar().getText().contentEquals("Guardar")) {
            if (modelo.insertarArtEntregados()) {
                JOptionPane.showMessageDialog(null, "datosguardados");
        
            }else{
                JOptionPane.showMessageDialog(null, "error");
            }
            
        }
        
        
    }
    
    public void abrirVentana(){
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    public void obtenerFechaSistema(){
        Calendar c2 = new GregorianCalendar();
        vista.getDcFecha().setCalendar(c2);
    }
    
}
    
    
