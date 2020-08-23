/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import marylove.controlador.ControladorRegistroReferencia;
import marylove.vista.Ficharegistroyreferencia;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Asus
 */
public class hyu_greit {

    public static void main(String[] args) throws ParseException, SQLException, Exception {
//        FichaAnamnesis f= new FichaAnamnesis();
//        ControladorFichaAnamnesisNew ff = new ControladorFichaAnamnesisNew(f);
//        
//          VistaRegistroLlamada f = new VistaRegistroLlamada();
//          Controlador_registro_llamadas ff = new Controlador_registro_llamadas(f);
//    FichaFormularioR3 f = new FichaFormularioR3();
//        controlFormularioR3 ff = new controlFormularioR3(f);
//          FormaAgregarAgresores f = new FormaAgregarAgresores();
//          ControladorAgregarAgresores ff = new ControladorAgregarAgresores(f);
        Ficharegistroyreferencia f= new Ficharegistroyreferencia();
        ControladorRegistroReferencia ff = new ControladorRegistroReferencia(f);
//          formularioR1 f=new formularioR1();
//          ControladorFichaR1 ff = new ControladorFichaR1(f);
//        FormaAgregarInstitucionEduc f = new FormaAgregarInstitucionEduc();
//        ControladorAgregarInstitucionEduc ff = new ControladorAgregarInstitucionEduc(f);
          f.setVisible(true);
          f.setLocationRelativeTo(null);
          f.setResizable(false);
          
//        PreguntasDB p = new PreguntasDB();
//        ArrayList<Preguntas> pp = p.obtener_preguntas();
//        for (Preguntas o : pp) {
//            switch (o.getPregunta_descripcion()){
//            
//                    case "1. Frecuencia de las agresiones en el cierre de los círculos de violencia":
//                        System.out.println("1");
//                    break;
//                    case "2 Violencia emocional, física, sexual, económica, o combinada como los tipos más  habituales, utilizando o no objetos para someterla":
//                        System.out.println("2");
//                    break;
//                    case "3. Intensidad de las agresiones en el cierre de los círculos de violencia. ":
//                        System.out.println("3");
//                    break;
//                    case "4. Nivel de afección según la cantidad de episodios violentos experimentados. ":
//                        System.out.println("4");
//                    break;
//                    case "5. Presencia de armas letales que son usadas por el agresor":
//                        System.out.println("5");
//                    break;
//                    case "6. Amenazas de muerte de parte del agresor hacia ella o terceros":
//                        System.out.println("6");
//                    break;
//                    case "7. Intentos de ahorcamiento y/o asesinato por parte del agresor hacia ella o terceros":
//                        System.out.println("7");
//                    break;
//                    case " 8. Intentos de suicidio provocados por el temor a enfrentar el episodio violento y/o ideación suicida":
//                        System.out.println("8");
//                    break;
//                    case "9. Ingesta de alcohol, drogas o estimulantes por parte del agresor":
//                        System.out.println("9");
//                    break;
//                    case "10. Embarazo (la violencia es mayor cuando en esta etapa, le golpeo en el vientre)":
//                        System.out.println("10");
//                    break;
//                    case "11. Los celos son motivos de agresión cada vez más fuerte":
//                        System.out.println("11");
//                    break;
//                    case "12. Mantiene control sobre sus actividades cotidianas, familiares laborales y económicas.":
//                        System.out.println("12");
//                    break;
//                    case "13. La agrede en ambientes públicos e incluso agrede a otras personas":
//                        System.out.println("13");
//                    break;
//                    case "14. Cuando se torna violento lo hace también con los NNA":
//                        System.out.println("14");
//                    break;
//                    case "15. Cuando ha denunciado a su pareja las reacciones de él han ejercido tanta presión sobre ella que ha decidido abandonar los procesos por temor":
//                        System.out.println("15");
//                    break;
//                    case "16. Ha recibido agresiones que requieran de asistencia medica":
//                        System.out.println("16");
//                    break;
//                    case "17. Cuenta con personas que le apoyan para que salga del ambiente violento":
//                        System.out.println("17");
//                    break;
//                    case "18. Presenta antecedentes de violencia en su familia de origen":
//                        System.out.println("18");
//                    break;
//                    case "19. Durante las separaciones cual fue/ es el nivel de consecuencias":
//                        System.out.println("19");
//                    break;
//                    case "20. Su salud se ha visto deteriorada desde que empezó los episodios violentos":
//                        System.out.println("20");
//                    break;
//                    case "21. Ha descuidado su apariencia personal incluso iniciando con la ingesta de alcohol o drogas":
//                        System.out.println("21");
//                    break;
//                    case "22. Ha tenido pensamientos reiterados de hacer justicia por su propia mano":
//                        System.out.println("22");
//                    break;
//                    case "23. Grado de aceptación de la situación según sus creencias y valores.":
//                        System.out.println("23");
//                    break;
//            }
//        }
    }

    public hyu_greit() {
    }
}
