/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import marylove.DBmodelo.FichaAnamnesisBD;
import marylove.vista.FichaAnamnesis;

/**
 *
 * @author Usuario
 */
public class ControladorFichaAnamnesisLenin extends Validaciones implements ActionListener{
    
    private FichaAnamnesis vistaAnamnesis;
    private FichaAnamnesisBD modeloAnamnesisBD;

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ControladorFichaAnamnesisLenin() throws Exception{
    }

    public ControladorFichaAnamnesisLenin(FichaAnamnesis vistaAnamnesis, FichaAnamnesisBD modeloAnamnesisBD) throws Exception{
        this.vistaAnamnesis = vistaAnamnesis;
        this.modeloAnamnesisBD = modeloAnamnesisBD;
    }

    public void iniciarControl(){
        
    }
        //rerererererererererererere
    //ESTA ES UNA PRUEBA
    int i = 0;
    String v = "ESTA ES UNA PRUEBA DE PUSH";
}
