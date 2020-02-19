package marylove.controlador;
//modificacion Test

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import marylove.vista.FichaCitas;
import marylove.vista.FichaEgreso;
import marylove.vista.FichaIngreso;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.V_Menu;
import marylove.vista.VistaMenuPrincipal;
import marylove.vista.VistaRegistroLlamada;
import marylove.vista.formularioR1;

public class ControladorMenu implements ActionListener {

    V_Menu vistaPrincipal;
    Ficharegistroyreferencia vistaRegisRef;
    CtrlRegistroReferencia ctrlRegRef;
    VistaRegistroLlamada vrLL;
    FichaCitas vistaFichCitas;
    formularioR1 Vfr1;
//    Controlador_registro_llamadas ctrlLlamadas;

    public ControladorMenu(V_Menu vistaPrincipal, Ficharegistroyreferencia vistaRegisRef, CtrlRegistroReferencia ctrlRegRef, VistaRegistroLlamada vrLL, formularioR1 Vfr1, Controlador_registro_llamadas ctrlLlamadas, FichaCitas vistaFichCitas) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaRegisRef = vistaRegisRef;
//        this.ctrlRegRef = ctrlRegRef;
        this.vrLL = vrLL;
        this.Vfr1 = Vfr1;
//        this.ctrlLlamadas = ctrlLlamadas;
        this.vistaFichCitas = vistaFichCitas;
    }

    public ControladorMenu(V_Menu vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.setLocationRelativeTo(null);
//        this.vistaPrincipal.getBtnCita().addActionListener(this);

    }

    public void iniciarContrl() {
//        ctrlRegRef.IniciaCtrlRegistroReferencia();
//        ctrlLlamadas.iniciarControlRLL();
        //vistaPrincipal.getItmRegisRefer().addActionListener(e -> abriPanel2(vistaRegisRef.getPnlFRegistroReferencia()));
        vistaPrincipal.getBtnCita().addActionListener(e -> abriPanelVistas(vistaFichCitas.getPanelAgendCitas()));
//        vistaPrincipal.getItmFR1().addActionListener(e -> abriPanel2(Vfr1.getPnlfr1()));

    }

    private void abrirVistaMenu() {
        vistaPrincipal.setSize(900, 700);
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setLocationRelativeTo(null);

    }
    
    private void abrirFichaCitas(){
        vistaFichCitas.setSize(900, 700);
        vistaFichCitas.setVisible(true);
        vistaFichCitas.setLocationRelativeTo(null);
    }
    
    public void abrirVistaRegistroRefernce() {
        vistaRegisRef.setVisible(true);
        vistaRegisRef.setLocationRelativeTo(null);
    }

    private void abriPanelVistas(JPanel panel) {
        panel.setSize(850, 400);
        panel.setLocation(2, 2);
        JScrollPane scrollpane;
        scrollpane = new JScrollPane();
        scrollpane.setBounds(0, 0, 870, 670);
        scrollpane.setViewportView(panel);
        vistaPrincipal.getPanelVistas().removeAll();
        vistaPrincipal.getPanelVistas().add(scrollpane);
        vistaPrincipal.getPanelVistas().revalidate();
        vistaPrincipal.getPanelVistas().repaint();
    }

//    private void abriPanel2(JPanel panel) {
//        panel.setSize(850, 400);
//        panel.setLocation(2, 2);
//        JScrollPane scrollpane;
//        scrollpane = new JScrollPane();
//        scrollpane.setBounds(0, 0, 870, 670);
//        scrollpane.setViewportView(panel);
//        vistaPrincipal.getPnlPrincipal().removeAll();
//        vistaPrincipal.getPnlPrincipal().add(scrollpane);
//        vistaPrincipal.getPnlPrincipal().revalidate();
//        vistaPrincipal.getPnlPrincipal().repaint();
//    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == this.vistaPrincipal.getItmIngreso()) {
//            FichaIngreso fichaingreso = new FichaIngreso();
//            ControladorFichaIngreso CTRL = new ControladorFichaIngreso(fichaingreso);
//
//        }
//        if (e.getSource() == this.vistaPrincipal.getItmEgreso()) {
//            FichaEgreso fichaegreso = new FichaEgreso();
//ControladorFichaEgreso CTRL1 = new ControladorFichaEgreso(fichaegreso);
//
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
