
package marylove.controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import marylove.DBmodelo.IngresoDB;
import marylove.DBmodelo.psicologoDB;
import marylove.vista.VistaReportes;

public class ControlReporte implements ActionListener {

    private VistaReportes vreportes;
    private ArrayList<String> anios;
    private DefaultComboBoxModel modelo;
    private IngresoDB i;

    public ControlReporte(VistaReportes vreportes) {
        this.vreportes = vreportes;
        this.vreportes.setVisible(true);
        this.vreportes.getjBn_Anual().addActionListener(this);
        this.vreportes.getPnlEspecificacion().setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vreportes.getjBn_Anual())) {
            this.vreportes.getPnlEspecificacion().setVisible(true);

        }
    }

    public void llenarComboAnio() throws SQLException {
        i = new IngresoDB();
        anios = i.obtenerAnio();
        modelo = new DefaultComboBoxModel();
        for (String o : anios) {
            modelo.addElement(o);
        }
        vreportes.getjComboBoxAnios().setModel(modelo);
    }
}

