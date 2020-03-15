/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import marylove.controlador.ControladorAgregarHijos;
import marylove.vista.FormaAgregarHijos;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Alumno
 */
public class test_x_text {
    public static void main(String[] args) throws ParseException, SQLException {
//        Ficharegistroyreferencia f= new Ficharegistroyreferencia();
//        ControladorRegistroReferencia ff=new ControladorRegistroReferencia(f);
//       f.setVisible(true);
//       f.setLocationRelativeTo(null);
        FormaAgregarHijos faa=new FormaAgregarHijos();
        ControladorAgregarHijos cah= new ControladorAgregarHijos(faa);
        faa.setVisible(true);
        faa.setLocationRelativeTo(null);
        faa.setResizable(false);
    }
}
