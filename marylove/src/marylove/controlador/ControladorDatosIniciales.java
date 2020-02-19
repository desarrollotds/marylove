package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import marylove.vista.VistaAgregarFamiliar;
import marylove.vista.VistaDatosIniciales;

/** @author Angel Lucero */
public class ControladorDatosIniciales implements ActionListener{
    private VistaDatosIniciales vistaDatosIniciales = new VistaDatosIniciales();
    
    private final VistaAgregarFamiliar agregarFamiliar = new VistaAgregarFamiliar(vistaDatosIniciales);
    private final ControladorAgregarFamiliar addRelative = new ControladorAgregarFamiliar(agregarFamiliar, vistaDatosIniciales.getTabEstructuraFamiliar());

    public ControladorDatosIniciales() {
        addListener();
        setDate();
    }
    
    private void addListener(){
        //Boton Guardar
        vistaDatosIniciales.getBtnGuardar().addActionListener(this);
        //1 Datos iniciales
        vistaDatosIniciales.getRadSituacionMovilidadVictimaSi().addActionListener(this);
        vistaDatosIniciales.getRadSituacionMovilidadVictimaNo().addActionListener(this);
        vistaDatosIniciales.getRadEmbarazadaVictimaSi().addActionListener(this);
        vistaDatosIniciales.getRadEmbarazadaVictimaNo().addActionListener(this);
        vistaDatosIniciales.getRadDiscapacidadVictimaSi().addActionListener(this);
        vistaDatosIniciales.getRadDiscapacidadVictimaNo().addActionListener(this);
        //4 Ficha Socioeconimica
        vistaDatosIniciales.getBtnAgregarFamiliar().addActionListener(this);
    }
    
    private void setDate(){
        vistaDatosIniciales.getDatFechaIngreso().setDate(getDate());
    }
  
    private Date getDate(){
        Date fecha = new Date();
        return fecha;
    }
    
    public static void main(String args[]) {
        new ControladorDatosIniciales();
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        if(arg.getSource().equals(vistaDatosIniciales.getBtnGuardar())){
            JOptionPane.showMessageDialog(vistaDatosIniciales, "Se supone que guardará la información");
        }
        
        //1 Datos de Identificacion
        if(arg.getSource().equals(vistaDatosIniciales.getRadSituacionMovilidadVictimaSi())){
            vistaDatosIniciales.getCbxSituacionMovilidadVictima().setEnabled(true);
        }
        if(arg.getSource().equals(vistaDatosIniciales.getRadSituacionMovilidadVictimaNo())){
            vistaDatosIniciales.getCbxSituacionMovilidadVictima().setSelectedIndex(0);
            vistaDatosIniciales.getCbxSituacionMovilidadVictima().setEnabled(false);
        }
        
        if(arg.getSource().equals(vistaDatosIniciales.getRadEmbarazadaVictimaSi())){
            vistaDatosIniciales.getSpnMesesEmbarazoVictima().setEnabled(true);
        }
        if(arg.getSource().equals(vistaDatosIniciales.getRadEmbarazadaVictimaNo())){
            vistaDatosIniciales.getSpnMesesEmbarazoVictima().setValue(0);
            vistaDatosIniciales.getSpnMesesEmbarazoVictima().setEnabled(false);
        }
        
        if(arg.getSource().equals(vistaDatosIniciales.getRadDiscapacidadVictimaSi())){
            vistaDatosIniciales.getSpnPorcentajeDiscapacidadVictima().setEnabled(true);
        }
        if(arg.getSource().equals(vistaDatosIniciales.getRadDiscapacidadVictimaNo())){
            vistaDatosIniciales.getSpnPorcentajeDiscapacidadVictima().setValue(0);
            vistaDatosIniciales.getSpnPorcentajeDiscapacidadVictima().setEnabled(false);
        }
        
        //4 Ficha Socioeconomica
        if(arg.getSource().equals(vistaDatosIniciales.getBtnAgregarFamiliar())){
            agregarFamiliar.show();
        }
    }
}
