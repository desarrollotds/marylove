/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import marylove.controlador.Controlador_registro_llamadas;
import marylove.vista.VistaRegistroLlamada;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Asus
 */
public class NewClass {
    public static void main(String[] args) throws ParseException {
//        FichaAnamnesis f= new FichaAnamnesis();
//        ControladorFichaAnamnesisNew ff = new ControladorFichaAnamnesisNew(f);
//        
          VistaRegistroLlamada f = new VistaRegistroLlamada();
          Controlador_registro_llamadas ff = new Controlador_registro_llamadas(f);
          f.setVisible(true);
          f.setLocationRelativeTo(null);
    }
}
