/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import marylove.DBmodelo.IngresoAvanceProceTerapeuticoDB;
import marylove.controlador.ControlFormularioR2;
import marylove.controlador.CtrlFichaEvaluacionProcesoTerapeutico;
import marylove.controlador.controlAbrir;
import marylove.models.IngresoAvanceProceTeraputico;
import marylove.vista.FichaAnamnesis;
import marylove.vista.FichaEvolucionProcesoTerapeutico;
import marylove.vista.IngresoAvancesProcesoTerapeutico;
import marylove.vista.vistaCarga;

//problema
/**
 *
 * @author LENOVO
 */
public class testDaniel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
         FichaAnamnesis f= new FichaAnamnesis();
        //ControladorFichaAnamnesisNew ff = new ControladorFichaAnamnesisNew(f);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
     }
    
}
