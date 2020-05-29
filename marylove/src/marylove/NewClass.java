/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import marylove.controlador.ControladorFichaR1;
import marylove.vista.formularioR1;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Asus
 */
public class NewClass {

    public static void main(String[] args) throws ParseException, SQLException {
//        FichaAnamnesis f= new FichaAnamnesis();
//        ControladorFichaAnamnesisNew ff = new ControladorFichaAnamnesisNew(f);
//        
//          VistaRegistroLlamada f = new VistaRegistroLlamada();
//          Controlador_registro_llamadas ff = new Controlador_registro_llamadas(f);
    formularioR1 f = new formularioR1();
        ControladorFichaR1 ff = new ControladorFichaR1(f);
          f.setVisible(true);
          f.setLocationRelativeTo(null);
          f.setResizable(false);
//        PreguntasDB p = new PreguntasDB();
//        ArrayList<Preguntas> pp = p.obtener_preguntas();
//        for (Preguntas o : pp) {
//            switch (o.getPregunta_descripcion()){
//            
//                    case "1) Procedencia extranjera del agresor o de la victima":
//                        System.out.println("1");
//                    break;
//                    case "2) Separacion reciente o en tramites de separacion":
//                        System.out.println("2");
//                    break;
//                    case "3) Acoso reciente a la victima o quebrantamiento de la orden de alejamiento":
//                        System.out.println("3");
//                    break;
//                    case "4) Existencia de violencia fisica susceptible de causar lesiones":
//                        System.out.println("4");
//                    break;
//                    case "5) Violencia fisica en presencia de los hijos u otros familiares":
//                        System.out.println("5");
//                    break;
//                    case "6) Aumento de la frecuencia y de la gravedad de los incidentes violentos en el ultimo mes":
//                        System.out.println("6");
//                    break;
//                    case "7) Amenazas graves o de muerte en el ultimo mes":
//                        System.out.println("7");
//                    break;
//                    case "8) Amenazas con objetos peligrosos o con armas de cualquier tipo":
//                        System.out.println("8");
//                    break;
//                    case "9) Intencion clara de causar lesiones graves o muy graves":
//                        System.out.println("9");
//                    break;
//                    case "10) Agresiones sexuales en la relacion de pareja":
//                        System.out.println("10");
//                    break;
//                    case "11) Celos muy intensos o conductas controladoras sobre la pareja":
//                        System.out.println("11");
//                    break;
//                    case "12) Historial de conductas violentas con una pareja anterior":
//                        System.out.println("12");
//                    break;
//                    case "13) Historial de conductas violentas con otras personas (amigos, compañeros, trabajos, etc)":
//                        System.out.println("13");
//                    break;
//                    case "14) Consumo abusivo de alcohol y/o drogas":
//                        System.out.println("14");
//                    break;
//                    case "15) Antecedentes de enfermedad mental con abandono de tratamientos psiquiatricos o psicologicos":
//                        System.out.println("15");
//                    break;
//                    case "16) Conductas de crueldad, de desprecio a la victima y de falta de arrepentimiento":
//                        System.out.println("16");
//                    break;
//                    case "17) Justificacion de las conductas violentas por su propio estado (alcohol, drogas, estres) o por la provocacion de la victima":
//                        System.out.println("17");
//                    break;
//                    case "18) Percepcion de la victima de peligro de muerte en el ultimo mes":
//                        System.out.println("18");
//                    break;
//                    case "19) Intentos de retirar denuncias previas o de echarse atras en la decision de abandonar o denunciar al agresor":
//                        System.out.println("19");
//                    break;
//                    case "20) Vulnerabilidad de la victima por razon de enfermedad, soledad o dependencia":
//                        System.out.println("20");
//                    break;
//            
//            }
//        }
    }
}
