package marylove.controlador;

import java.awt.Cursor;
import static java.awt.Cursor.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import marylove.DBmodelo.PlanAutonomiaDB;
import marylove.DBmodelo.victimaDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.Plan_Autonomia;
import marylove.vista.VistaPlanAutonomía;

public class controlPlanAutonomia extends Validaciones {

    private VistaPlanAutonomía vista;
    private Plan_Autonomia modelo;
    private PlanAutonomiaDB planADB;

    public controlPlanAutonomia(VistaPlanAutonomía vista, Plan_Autonomia modelo, PlanAutonomiaDB planADB) throws Exception{
        this.vista = vista;
        this.modelo = modelo;
        this.planADB = planADB;
    }
    public void iniciarCAutonomia() {
        vista.getTxtPAcodVic().addKeyListener(validarNumeros(vista.getTxtPAcodVic()));
        vista.getTxtPAced().addKeyListener(validarCedula(vista.getTxtPAced()));
        vista.getTxtPAced().addKeyListener(enter2(vista.getTxtPAced(), vista.getTxtPAcodVic()));
        vista.getTxtPAced().addKeyListener(enterllenar());
//        vista.getTxtPAfacries().addKeyListener(validarLetras2(vista.getTxtPAfacries()));
//        vista.getTxtPAproeduc().addKeyListener(validarLetras2(vista.getTxtPAproeduc()));
//        vista.getTxtPArecseg().addKeyListener(validarLetras2(vista.getTxtPArecseg()));
//        vista.getTxtPAsalud().addKeyListener(validarLetras2(vista.getTxtPAsalud()));
//        vista.getTxtautecon().addKeyListener(validarLetras2(vista.getTxtautecon()));
//        vista.getTxtevalproc().addKeyListener(validarLetras2(vista.getTxtevalproc()));

        vista.getBtnPAguard().addActionListener(e -> {vista.getBtnPAguard().setCursor(new Cursor(WAIT_CURSOR)); guardarDatos(); vista.getBtnPAguard().setCursor(new Cursor(DEFAULT_CURSOR));});
        vista.getBtnPAcanc().addActionListener(e -> borrarDatos());
    }

    public void guardarDatos() {
        if (vista.getTxtPAced().getText().equals("")|| vista.getTxtPAcodVic().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "llenar los datos necesarios");
        }else{
            if (vista.getBtnPAguard().getText().equals("Editar")) {
                if (planADB.actualizar(datos())) {
                    vista.getBtnPAguard().setText("Guardar");
                    borrarDatos();
                    JOptionPane.showMessageDialog(null, "Datos editados Correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se han editados los datos");
                }
            } else {
                if (planADB.ingresarPAutonomia(datos())) {
                    borrarDatos();
                JOptionPane.showMessageDialog(null, "Datos ingresar Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se han ingresar los datos");
            }
            }
            
        }

    }public Plan_Autonomia datos() {
        modelo.setCodigo_victima(Integer.parseInt(vista.getTxtPAcodVic().getText()));
        modelo.setPersona_codigo(personal_cod);
        modelo.setAutonomia_econo(vista.getTxtautecon().getText());
        modelo.setEstabilidad_salud(vista.getTxtPAsalud().getText());
        modelo.setFactor_riesgo(vista.getTxtPAfacries().getText());
        modelo.setProceso_evalua(vista.getTxtevalproc().getText());
        modelo.setProcesos_educativos(vista.getTxtPAproeduc().getText());
        modelo.setRedes_seguras(vista.getTxtPArecseg().getText());
        try {
            modelo.setFecha_elaboacion(obtenerFecha(vista.getDtcfechElab()));
            modelo.setFecha_egreso(obtenerFecha(vista.getDtcPAfechegre()));
        } catch (Exception e) {
            System.out.println("ERROR ingreso FECHA " + e.getMessage());
        }
        return modelo;
    }
    
    
    
    public void borrarDatos() {
        vista.getTxtPAced().setText("");
        vista.getTxtPAcodVic().setText("");
        vista.getTxtPAfacries().setText("");
        vista.getTxtPAproeduc().setText("");
        vista.getTxtPArecseg().setText("");
        vista.getTxtPAsalud().setText("");
        vista.getTxtautecon().setText("");
        vista.getTxtevalproc().setText("");
    }

    public void obtenerPlan() {
        if (planADB.obtenetDatos(Integer.parseInt(vista.getTxtPAcodVic().getText())).getAutonomia_codigo() != 0) {
            modelo = planADB.obtenetDatos(Integer.parseInt(vista.getTxtPAcodVic().getText()));
            ingreDATE(vista.getDtcfechElab(), modelo.getFecha_elaboacion());
            ingreDATE(vista.getDtcPAfechegre(), modelo.getFecha_egreso());
            vista.getTxtPAfacries().setText(modelo.getFactor_riesgo());
            vista.getTxtPAproeduc().setText(modelo.getProcesos_educativos());
            vista.getTxtautecon().setText(modelo.getAutonomia_econo());
            vista.getTxtPAsalud().setText(modelo.getEstabilidad_salud());
            vista.getTxtPArecseg().setText(modelo.getRedes_seguras());
            vista.getTxtevalproc().setText(modelo.getProceso_evalua());
            vista.getBtnPAguard().setText("Editar");
        }
    }

    public KeyListener enterllenar() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                victimaDB vDB = new victimaDB();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                vista.getTxtPAced().setCursor(new Cursor(WAIT_CURSOR));
                    if (!vista.getTxtPAcodVic().getText().equals("")) {
                        obtenerPlan();
                    }
                }
                vista.getTxtPAced().setCursor(new Cursor(DEFAULT_CURSOR));
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        return kn;
    }
}
