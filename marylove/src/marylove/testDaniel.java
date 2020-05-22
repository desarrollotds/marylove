/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import marylove.DBmodelo.IngresoAvanceProceTerapeuticoDB;
import marylove.controlador.CtrlFichaEvaluacionProcesoTerapeutico;
import marylove.controlador.controlAbrir;
import marylove.models.IngresoAvanceProceTeraputico;
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
        // TODO code application logic here
        IngresoAvanceProceTerapeuticoDB modelo = new IngresoAvanceProceTerapeuticoDB();
        FichaEvolucionProcesoTerapeutico vista = new FichaEvolucionProcesoTerapeutico();
        CtrlFichaEvaluacionProcesoTerapeutico control = new CtrlFichaEvaluacionProcesoTerapeutico(modelo, vista);
        control.iniciarControlador();
     }
    
}
