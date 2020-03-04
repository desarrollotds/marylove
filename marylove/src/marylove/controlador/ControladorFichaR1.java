
package marylove.controlador;

import java.awt.Color;
import javax.swing.JOptionPane;
import marylove.DBmodelo.FichaR1DB;
import marylove.conexion.Conexion;
import marylove.models.x_respuestas;
import marylove.vista.formularioR1;

/**
 *
 * @author USER
 */
public class ControladorFichaR1 {
    private formularioR1 vistaR1;
    private x_respuestas  respuestas;
    private Conexion conex;
    private FichaR1DB fRlDB;
    private int suma=0;

    public ControladorFichaR1(formularioR1 vistaR1, FichaR1DB fR1DB, Conexion conex) {
        this.vistaR1 = vistaR1;
        this.respuestas = respuestas;
        this.conex = conex;
        vistaR1.setVisible(true);
    }

    
    
    //
    public void iniciarComponentes(){
        vistaR1.getBtnGuardar().addActionListener(e -> GuardaRespuestas());
    }
    
    public void GuardaRespuestas(){//metodo para guardar los datos de la ficha
        
        fRlDB=new FichaR1DB();
        if (vistaR1.getLblPregunta1().equals("1) Procedencia extranjera del agresor o de la victima")) {
            fRlDB.setEnc_codigo(1);
            fRlDB.setPregunta_codigo(1);
            fRlDB.setResp_id(1);
            fRlDB.setResp_descripcion(vistaR1.getCbxPregunta1().getSelectedItem().toString());
        }
        if (vistaR1.getLblPregunta2().equals("2) Procedencia extranjera del agresor o de la victima")) {
            fRlDB.setEnc_codigo(2);
            fRlDB.setPregunta_codigo(2);
            fRlDB.setResp_id(2);
            fRlDB.setResp_descripcion(vistaR1.getCbxPregunta2().getSelectedItem().toString());
        }
         
    }
    
    public void sumaRespuestas(){
        if (vistaR1.getLblPregunta1().getText().toString().equals("Seleccione")|| vistaR1.getLblPregunta2().getText().toString().equals("Seleccione")
            || vistaR1.getLblPregunta3().getText().toString().equals("Seleccione")|| vistaR1.getLblPregunta4().getText().toString().equals("Seleccione")
            || vistaR1.getLblPregunta5().getText().toString().equals("Seleccione")|| vistaR1.getLblPregunta6().getText().toString().equals("Seleccione")    
            || vistaR1.getLblPregunta7().getText().toString().equals("Seleccione")|| vistaR1.getLblPregunta8().getText().toString().equals("Seleccione")    
            || vistaR1.getLblPregunta9().getText().toString().equals("Seleccione")|| vistaR1.getLblPregunta10().getText().toString().equals("Seleccione")    
            || vistaR1.getLblPregunta11().getText().toString().equals("Seleccione")|| vistaR1.getLblPregunta12().getText().toString().equals("Seleccione")    
            || vistaR1.getLblPregunta13().getText().toString().equals("Seleccione")|| vistaR1.getLblPregunta14().getText().toString().equals("Seleccione")    
            || vistaR1.getLblPregunta15().getText().toString().equals("Seleccione")|| vistaR1.getLblPregunta16().getText().toString().equals("Seleccione")    
            || vistaR1.getLblPregunta17().getText().toString().equals("Seleccione")|| vistaR1.getLblPregunta18().getText().toString().equals("Seleccione")
            || vistaR1.getLblPregunta19().getText().toString().equals("Seleccione")|| vistaR1.getLblPregunta20().getText().toString().equals("Seleccione") 
            ) {
            JOptionPane.showMessageDialog(null, "seleccione un valor");
        } else {
            suma=suma+Integer.parseInt(vistaR1.getCbxPregunta1().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta2().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta3().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta4().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta5().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta6().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta7().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta8().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta9().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta10().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta11().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta12().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta13().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta14().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta15().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta16().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta17().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta18().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta19().getSelectedItem().toString());
        suma=suma+Integer.parseInt(vistaR1.getCbxPregunta20().getSelectedItem().toString());
        
        vistaR1.getTxtRiesgototal().setText(Integer.toString(suma));
        if(suma>=24&&suma<=48){
            vistaR1.getLblAlto().setBackground(Color.red);
        }else if(suma>=10&&suma<24){
            vistaR1.getLblModerado().setBackground(Color.YELLOW);
        }else{
            vistaR1.getLblBajo().setBackground(Color.GREEN);
        }
        
        }
        
        
    }
  
    
}
