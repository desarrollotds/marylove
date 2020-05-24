/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.controlador.ControladorCitas;
import marylove.controlador.ControladorFichaAnamnesis;
import marylove.controlador.ControladorRegistroReferencia;
import marylove.controlador.FiltroHijosVictima;
import marylove.vista.FichaAnamnesis;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.VistaCita;
import marylove.vista.VistaFiltroVistaVictima;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Alumno
 */
public class test_x_text {

    public static void main(String[] args) throws ParseException, SQLException {
        try {
            //        Ficharegistroyreferencia f= new Ficharegistroyreferencia();
//        ControladorRegistroReferencia ff=new ControladorRegistroReferencia(f);
//       f.setVisible(true);
//       f.setLocationRelativeTo(null);
//        FormaAgregarHijos faa=new FormaAgregarHijos();
//        ControladorAgregarHijos cah= new ControladorAgregarHijos(faa);
//        faa.setVisible(true);
//        faa.setLocationRelativeTo(null);
//        faa.setResizable(false);

            VistaCita vistaCita = new VistaCita();
            ControladorCitas controladorCitas = new ControladorCitas(vistaCita);
            controladorCitas.iniciarControl();

//            FichaAnamnesis vistaAnamnesis = new FichaAnamnesis();
//            ControladorFichaAnamnesis controladorFichaAnamnesis = new ControladorFichaAnamnesis(vistaAnamnesis);
//            controladorFichaAnamnesis.inciarControl();

            VistaFiltroVistaVictima vista = new VistaFiltroVistaVictima();
            FiltroHijosVictima filtro = new FiltroHijosVictima(vista);
            vista.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(test_x_text.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
