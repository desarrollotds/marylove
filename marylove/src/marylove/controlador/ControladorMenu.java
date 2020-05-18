package marylove.controlador;
//modificacion Test

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import marylove.vista.FichaPrimerEncuentro;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.V_Menu;
import marylove.vista.VistaCita;
import marylove.vista.VistaRegistroLlamada;
import marylove.vista.formularioR1;

public class ControladorMenu implements ActionListener {
    ControladorFichaIngreso ctrlFichIng;
    V_Menu vistaPrincipal;
    Ficharegistroyreferencia vistaRegisRef;
    VistaRegistroLlamada vrLL;
    VistaCita vCitas;
    formularioR1 Vfr1;
    FichaPrimerEncuentro vfichPriEncuent;
    Controlador_registro_llamadas ctrlLlamadas;

    public ControladorMenu(ControladorFichaIngreso ctrlFichIng, V_Menu vistaPrincipal, Ficharegistroyreferencia vistaRegisRef, VistaRegistroLlamada vrLL, VistaCita vCitas, formularioR1 Vfr1, FichaPrimerEncuentro vfichPriEncuent, Controlador_registro_llamadas ctrlLlamadas) {
        this.ctrlFichIng = ctrlFichIng;
        this.vistaPrincipal = vistaPrincipal;
        this.vistaRegisRef = vistaRegisRef;
        this.vrLL = vrLL;
        this.vCitas = vCitas;
        this.Vfr1 = Vfr1;
        this.vfichPriEncuent = vfichPriEncuent;
        this.ctrlLlamadas = ctrlLlamadas;
    }

    public void iniciarContrl() {
//        ctrlRegRef.IniciaCtrlRegistroReferencia();
//        ctrlLlamadas.iniciarControlRLL();
        ctrlFichIng.inciarCtrlFichIngreso();
        vistaPrincipal.getBtnpsico().addActionListener(e-> ctrlFichIng.AbrirVentanFichIng());
        vistaPrincipal.getBtnllamada().addActionListener(e -> abriPanelVistas(vrLL.getPnlLlamadas()));
        vistaPrincipal.getBtnCita().addActionListener(e -> abriPanelVistas(vCitas.getPanelCitas()));
        vistaPrincipal.getBtnRegistro().addActionListener(e -> abriPanelVistas(vfichPriEncuent.getPnlPrimerEncuentro()));
    }

    private void abrirVistaMenu() {
        vistaPrincipal.setSize(900, 700);
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setLocationRelativeTo(null);
    }
    
    public void abrirVistaRegistroRefernce() {
        vistaRegisRef.setVisible(true);
        vistaRegisRef.setLocationRelativeTo(null);
    }

    private void abriPanelVistas(JPanel panel) {
        panel.setSize(1500, 870);
        panel.setLocation(2, 2);
        JScrollPane scrollpane;
        scrollpane = new JScrollPane();
        scrollpane.setBounds(0, 0, 1050, 700);
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

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == this.vistaPrincipal.getBtnCita()) {
//             try {
//                 VistaCita vCitas = new VistaCita();
//            VistaCita vCitas = new VistaCita();
//             try {
//                 ControladorCitas CTRL = new ControladorCitas(vCitas);
//             } catch (Exception ex) {
//                 Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
//             }

        }
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
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
}
