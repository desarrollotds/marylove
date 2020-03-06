
package marylove.controlador;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import marylove.DBmodelo.CierreDB;
import marylove.DBmodelo.RegisActuacionesDB;
import marylove.DBmodelo.fichaLegalDB;
import marylove.conexion.Conexion;
import marylove.models.Cierre;
import marylove.models.Register_Actuaciones;
import marylove.vista.FichaRegistroActuaciones;

/**
 *
 * @author vasquez
 */
public class ControlFichaRegisActu extends Validaciones{
    private FichaRegistroActuaciones vFRA; 
    private Cierre mC;
    private CierreDB cDB;
    private Register_Actuaciones mRA;
    private RegisActuacionesDB raDB;
    
    Conexion cx = new Conexion();
    fichaLegalDB fDB = new fichaLegalDB();

    public ControlFichaRegisActu() {
    }

    public ControlFichaRegisActu(FichaRegistroActuaciones vFRA, Cierre mC, CierreDB cDB, Register_Actuaciones mRA, RegisActuacionesDB raDB) {
        this.vFRA = vFRA;
        this.mC = mC;
        this.cDB = cDB;
        this.mRA = mRA;
        this.raDB = raDB;
        vFRA.setVisible(true);
    }
    
    public void iniciarCFichaRegusActu(){
        // validaciones
        vFRA.getTxtCedula().addKeyListener(validarCedula(vFRA.getTxtCedula()));
        vFRA.getTxtNombre().addKeyListener(validarLetras(vFRA.getTxtNombre()));
        vFRA.getTxtCodigo().addKeyListener(validarNumeros(vFRA.getTxtCodigo()));
        
        vFRA.getTxtCedula().addKeyListener(enter1(cx, vFRA.getTxtCedula(),vFRA.getTxtNombre(),vFRA.getTxtCodigo()));
        
        //control de botones
        vFRA.getBtnAñadirActuacion().addActionListener(e-> visualizarDialog(vFRA.getJdiRegActu()));
        vFRA.getBtnAñadirCierre().addActionListener(e-> visualizarDialog(vFRA.getJdiCierre()));
        vFRA.getBtnGuarRA().addActionListener(e-> ingreRegisAct());
        vFRA.getBtnCGuar().addActionListener(e-> ingreCierre());
    }
    
    public Register_Actuaciones datosRA(){
        
        mRA.setLegal_id(fDB.obtenerLegal_Id(Integer.parseInt(vFRA.getTxtCodigo().getText())));
        mRA.setNotf_dilig(vFRA.getTxtRANotDil().getText());
        mRA.setFecha_limite(obtenerFecha(vFRA.getJdcRAFechLimite()));
        mRA.setObserv(vFRA.getTxtRAObs().getText());
        return mRA;   
    }
    
    public Cierre datosCierre(){
        mC.setLegal_id(fDB.obtenerLegal_Id(Integer.parseInt(vFRA.getTxtCodigo().getText())));
        mC.setNotifi_dilig(vFRA.getTxtCNotDil().getText());
        mC.setFecha_limite(obtenerFecha(vFRA.getJdcCFechLimite()));
        mC.setObservacion(vFRA.getTxtCObs().getText());
        mC.setFecha_cierre(obtenerFecha(vFRA.getJdcCFechCier()));
        return mC;
    }
    
    public void ingreRegisAct(){
        if (raDB.ingreRegis_Actu(datosRA())) {
            JOptionPane.showMessageDialog(null, "Datos ingresar Correctamente");
            vFRA.getJdiRegActu().setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Datos no ingresar");
        }
    }
    
    public void ingreCierre(){
        if (cDB.ingreCierre(datosCierre())) {
            JOptionPane.showMessageDialog(null, "Datos ingresar Correctamente");
            vFRA.getJdiCierre().setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Datos no ingresar");
        }
    }
    
    public void visualizarDialog(JDialog dialog ){
        dialog.setVisible(true);
        dialog.setSize(429,295);
        dialog.setLocationRelativeTo(null);
    }
    
}
