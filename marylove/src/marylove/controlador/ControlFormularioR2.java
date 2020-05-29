/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import marylove.vista.formuR2;
import marylove.vista.formularioR2;

/**
 *
 * @author LENOVO
 */
public class ControlFormularioR2 {


    private formuR2 vista = new formuR2();

    private int suma = 0;

    public ControlFormularioR2() {
    }

  
    public void iniciarControl() {
        vista.getBtnSumar().addActionListener(e -> sumar());
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
    }

    private void sumar() {
        suma = suma + Integer.parseInt(vista.getJcb1().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb2().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb3().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb4().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb5().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb6().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb7().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb8().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb9().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb10().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb11().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb12().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb13().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb14().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb15().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb16().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb17().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb18().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb19().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb20().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb21().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb22().getSelectedItem().toString());
        suma = suma + Integer.parseInt(vista.getJcb23().getSelectedItem().toString());

        if (suma >= 0 && suma <= 23) {
            System.out.println(suma);
            vista.getLbValor1().setText("" + suma);
            vista.getLbResul1().setVisible(true);
        } else if (suma >= 24 && suma <= 46) {
            System.out.println(suma);
            vista.getLbValor2().setText("" + suma);
            vista.getLbValor1().setText("");
            vista.getLbResul2().setVisible(true);
        } else if (suma >= 47 && suma <= 69) {
            System.out.println(suma);
            vista.getLbValor3().setText("" + suma);

            vista.getLbValor2().setText("");

            vista.getLbResul3().setVisible(true);
        }

    }
}
