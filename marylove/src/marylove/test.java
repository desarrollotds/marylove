/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import marylove.DBmodelo.PlanAtencionTerapeuticoDB;
import marylove.controlador.ControladorPlanAtencionTerapeutica;
import marylove.vista.FichaPlanAtencionTerapeutica;

/**
 *
 * @author LENOVO
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FichaPlanAtencionTerapeutica vista = new FichaPlanAtencionTerapeutica();
        PlanAtencionTerapeuticoDB modelo = new PlanAtencionTerapeuticoDB ();
        ControladorPlanAtencionTerapeutica ctrl = new ControladorPlanAtencionTerapeutica(vista, modelo);
        ctrl.iniciarControlador();
    }
    
}
