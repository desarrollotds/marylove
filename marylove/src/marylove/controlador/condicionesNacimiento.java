/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import marylove.vista.FichaAnamnesis;

/**
 *
 * @author LENOVO
 */
public class condicionesNacimiento {

    FichaAnamnesis vistaAnamnesis;

    public void accionesChecks() {
        //pestana 4
        vistaAnamnesis.getJcxNoViolencia().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxNoControles().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxNoComplicaciones().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxNoConsume().addActionListener(e -> valCheck());
        
        vistaAnamnesis.getJcxSiViolencia().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxSiControles().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxSiComplicaciones().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxSiConsume().addActionListener(e -> valCheck());
        
        vistaAnamnesis.getJcxSiEstudia().addActionListener(e->valEscolNino());
        vistaAnamnesis.getJcxSiAprendizaje().addActionListener(e->valEscolNino());
        vistaAnamnesis.getJcxSiNivelacion().addActionListener(e->valEscolNino());
        
        vistaAnamnesis.getJcxNoEstudia().addActionListener(e->valEscolNino());
        vistaAnamnesis.getJcxNoAprendizaje().addActionListener(e->valEscolNino());
        vistaAnamnesis.getJcxNoNivelacion().addActionListener(e->valEscolNino());
        //pestania 5
        vistaAnamnesis.getJcxNormal().addActionListener(e -> condiconesNacimiento());
        vistaAnamnesis.getJcxCesarea().addActionListener(e -> condiconesNacimiento());
        // pestana 6 
        vistaAnamnesis.getJcxSiLeche().addActionListener(e->controlPestaña6());
        vistaAnamnesis.getJcxNoLeche().addActionListener(e->controlPestaña6());
        // pestania 11 
        vistaAnamnesis.getJcxSiProblemasRespiratorios().addActionListener(e-> checkSalud());
        vistaAnamnesis.getJcxNoProblemasRespiratorios().addActionListener(e-> checkSalud());
        
        vistaAnamnesis.getJcxSiAlergias().addActionListener(e-> checkSalud());
        vistaAnamnesis.getJcxNoAlergias().addActionListener(e-> checkSalud());
        
        vistaAnamnesis.getJcxSiNeurologicos().addActionListener(e-> checkSalud());
        vistaAnamnesis.getJcxNoNeurologicos().addActionListener(e-> checkSalud());
        
         vistaAnamnesis.getJcxSiNerviosos().addActionListener(e-> checkSalud());
        vistaAnamnesis.getJcxNoNerviosos().addActionListener(e-> checkSalud());
    }
    //pestania 11
    
    public void checkSalud(){
        if (vistaAnamnesis.getJcxSiProblemasRespiratorios().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueProblemasRespiratorios().setEnabled(true);
        }
        if (vistaAnamnesis.getJcxNoProblemasRespiratorios().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueProblemasRespiratorios().setEnabled(false);
        }
        if (vistaAnamnesis.getJcxSiAlergias().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueAlergias().setEnabled(true);
            
        }
        if (vistaAnamnesis.getJcxNoAlergias().isSelected()) {
             vistaAnamnesis.getTxtEspecifiqueAlergias().setEnabled(false);
        }
        
        if (vistaAnamnesis.getJcxSiNeurologicos().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNeurologicos().setEnabled(true);
        }
        if (vistaAnamnesis.getJcxNoNeurologicos().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNeurologicos().setEnabled(false);
        }
        
         if (vistaAnamnesis.getJcxSiNerviosos().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNerviosos().setEnabled(true);
        }
        if (vistaAnamnesis.getJcxNoNerviosos().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNerviosos().setEnabled(false);
        }
        
    }
    //pestania 5
    public void condiconesNacimiento() {
        if (vistaAnamnesis.getJcxNormal().isSelected()) {
            vistaAnamnesis.getTxtMotivoCesarea().setEnabled(false);
        }
        if (vistaAnamnesis.getJcxCesarea().isSelected()) {
            vistaAnamnesis.getTxtMotivoCesarea().setEnabled(true);
        }

    }
    public void valCheck() {
        System.out.println("llega al validar check");
        if (vistaAnamnesis.getJcxSiViolencia().isSelected()) {
            System.out.println("caso si");
            vistaAnamnesis.getJcxGolpes().setEnabled(true);
            vistaAnamnesis.getJcxInsultos().setEnabled(true);
            vistaAnamnesis.getJcxAbusoSexual().setEnabled(true);
            vistaAnamnesis.getJcxNegligencia().setEnabled(true);
            vistaAnamnesis.getJcxAmbitoLaboral().setEnabled(true);
        } else {

            if (vistaAnamnesis.getJcxNoViolencia().isSelected()) {
                System.out.println("caso no check");
                vistaAnamnesis.getJcxGolpes().setEnabled(false);
                vistaAnamnesis.getJcxInsultos().setEnabled(false);
                vistaAnamnesis.getJcxAbusoSexual().setEnabled(false);
                vistaAnamnesis.getJcxNegligencia().setEnabled(false);
                vistaAnamnesis.getJcxAmbitoLaboral().setEnabled(false);
            }
        }

        if (vistaAnamnesis.getJcxSiControles().isSelected()) {
            vistaAnamnesis.getJcxUnaVez().setEnabled(true);
            vistaAnamnesis.getJcxMensual().setEnabled(true);
            vistaAnamnesis.getJcxTrimestral().setEnabled(true);
            vistaAnamnesis.getJcxNinguna().setEnabled(true);
        } else {
            if (vistaAnamnesis.getJcxNoControles().isSelected()) {
                vistaAnamnesis.getJcxUnaVez().setEnabled(false);
                vistaAnamnesis.getJcxMensual().setEnabled(false);
                vistaAnamnesis.getJcxTrimestral().setEnabled(false);
                vistaAnamnesis.getJcxNinguna().setEnabled(false);
            }
        }

        if (vistaAnamnesis.getJcxSiComplicaciones().isSelected()) {
            vistaAnamnesis.getJcxBajoPeso().setEnabled(true);
            vistaAnamnesis.getJcxHemorragias().setEnabled(true);
            vistaAnamnesis.getJcxInfecciones().setEnabled(true);
            vistaAnamnesis.getJcxPreclansia().setEnabled(true);
        } else {

            if (vistaAnamnesis.getJcxNoComplicaciones().isSelected()) {
                vistaAnamnesis.getJcxBajoPeso().setEnabled(false);
                vistaAnamnesis.getJcxHemorragias().setEnabled(false);
                vistaAnamnesis.getJcxInfecciones().setEnabled(false);
                vistaAnamnesis.getJcxPreclansia().setEnabled(false);
            }
        }

        if (vistaAnamnesis.getJcxSiConsume().isSelected()) {
            vistaAnamnesis.getJcxAlcohol().setEnabled(true);
            vistaAnamnesis.getJcxTabaco().setEnabled(true);
            vistaAnamnesis.getJcxDroga().setEnabled(true);
        } else {
            if (vistaAnamnesis.getJcxNoConsume().isSelected()) {
                vistaAnamnesis.getJcxAlcohol().setEnabled(false);
                vistaAnamnesis.getJcxTabaco().setEnabled(false);
                vistaAnamnesis.getJcxDroga().setEnabled(false);
            }
        }

    }

    public void valEscolNino() {
        if (vistaAnamnesis.getJcxSiEstudia().isSelected()) {
            vistaAnamnesis.getTxtExpliqueEstudia().setEnabled(true);
        } else {
            if (vistaAnamnesis.getJcxNoEstudia().isSelected()) {
                vistaAnamnesis.getTxtExpliqueEstudia().setEnabled(false);
            }
        }

        if (vistaAnamnesis.getJcxSiAprendizaje().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueAprendizaje().setEnabled(true);
        } else {
            if (vistaAnamnesis.getJcxNoAprendizaje().isSelected()) {
                vistaAnamnesis.getTxtEspecifiqueAprendizaje().setEnabled(false);
            }
        }
        if (vistaAnamnesis.getJcxSiNivelacion().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNivelacion().setEnabled(true);
        }else{
            if (vistaAnamnesis.getJcxSiNivelacion().isSelected()) {
                vistaAnamnesis.getTxtEspecifiqueNivelacion().setEnabled(false);
            }
        }
    }
    
    public void controlPestaña6(){
        if(vistaAnamnesis.getJcxSiLeche().isSelected()){
            vistaAnamnesis.getJcxNoLeche().setEnabled(false);
            vistaAnamnesis.getTxtPorqueLeche().setEnabled(false);
        }
        if(vistaAnamnesis.getJcxNoLeche().isSelected()){
            vistaAnamnesis.getJcxSiLeche().setEnabled(false);
            vistaAnamnesis.getTxtPorqueLeche().setEnabled(true);
         
        }
    }
}
