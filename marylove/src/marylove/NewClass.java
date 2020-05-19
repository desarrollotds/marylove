/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import marylove.controlador.ControladorFichaAnamnesisNew;
import marylove.vista.FichaAnamnesis;

/**
 *
 * @author Asus
 */
public class NewClass {
    public static void main(String[] args) {
        FichaAnamnesis f= new FichaAnamnesis();
        ControladorFichaAnamnesisNew ff = new ControladorFichaAnamnesisNew(f);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
