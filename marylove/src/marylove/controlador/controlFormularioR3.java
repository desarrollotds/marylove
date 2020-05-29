/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import marylove.vista.FichaFormularioR3;

/**
 *
 * @author vasquez
 */
public class controlFormularioR3 {

    private FichaFormularioR3 vista;

    public controlFormularioR3(FichaFormularioR3 vista) {
        this.vista = vista;
        vista.getTxtFR3total().setEnabled(false);
    }

    public void iniciarCtr() {
        vista.getBtnFR3calcular().addActionListener(l -> mostrar());
        vista.getBtnCancelar().addActionListener(l -> limpiar());
    }

    public int obtenerTotal() {
        int total = 0;
        total = total + vista.getCbxResp1().getSelectedIndex();
        total = total + vista.getCbxResp2().getSelectedIndex();
        total = total + vista.getCbxResp3().getSelectedIndex();
        total = total + vista.getCbxResp4().getSelectedIndex();
        total = total + vista.getCbxResp5().getSelectedIndex();
        total = total + vista.getCbxResp6().getSelectedIndex();
        total = total + vista.getCbxResp7().getSelectedIndex();
        total = total + vista.getCbxResp8().getSelectedIndex();
        total = total + vista.getCbxResp9().getSelectedIndex();
        total = total + vista.getCbxResp10().getSelectedIndex();
        total = total + vista.getCbxResp11().getSelectedIndex();
        total = total + vista.getCbxResp12().getSelectedIndex();
        total = total + vista.getCbxResp13().getSelectedIndex();
        total = total + vista.getCbxResp14().getSelectedIndex();
        total = total + vista.getCbxResp15().getSelectedIndex();
        total = total + vista.getCbxResp16().getSelectedIndex();
        total = total + vista.getCbxResp17().getSelectedIndex();
        total = total + vista.getCbxResp18().getSelectedIndex();
        total = total + vista.getCbxResp19().getSelectedIndex();
        return total;
    }

    private void mostrar() {
        int rep = obtenerTotal();
        vista.getTxtFR3total().setText(rep + "");
        if (rep <= 19) {
            vista.getLabFR3refe().setText("LEVE");
        } else if (rep <= 38) {
            vista.getLabFR3refe().setText("MEDIO");
        } else {
            vista.getLabFR3refe().setText("GRAVE");
        }
    }
    
    private void limpiar(){
        vista.getTxtFR3nombre().setText("");
        vista.getTxtFR3motivo().setText("");
        vista.getTxtFR3total().setText("");
        vista.getLabFR3refe().setText("Leve");
        vista.getCbxResp1().setSelectedIndex(0);
        vista.getCbxResp2().setSelectedIndex(0);
        vista.getCbxResp3().setSelectedIndex(0);
        vista.getCbxResp4().setSelectedIndex(0);
        vista.getCbxResp5().setSelectedIndex(0);
        vista.getCbxResp6().setSelectedIndex(0);
        vista.getCbxResp7().setSelectedIndex(0);
        vista.getCbxResp8().setSelectedIndex(0);
        vista.getCbxResp9().setSelectedIndex(0);
        vista.getCbxResp10().setSelectedIndex(0);
        vista.getCbxResp11().setSelectedIndex(0);
        vista.getCbxResp12().setSelectedIndex(0);
        vista.getCbxResp13().setSelectedIndex(0);
        vista.getCbxResp14().setSelectedIndex(0);
        vista.getCbxResp15().setSelectedIndex(0);
        vista.getCbxResp16().setSelectedIndex(0);
        vista.getCbxResp17().setSelectedIndex(0);
        vista.getCbxResp18().setSelectedIndex(0);
        vista.getCbxResp19().setSelectedIndex(0);
    }
}
