package marylove.controlador;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.VistaMenuPrincipal;
import marylove.vista.VistaRegistroLlamadas;

public class ControladorMenu {

    VistaMenuPrincipal vistaPrincipal;
    Ficharegistroyreferencia vistaRegisRef;
    CtrlRegistroReferencia ctrlRegRef;
    VistaRegistroLlamadas vrLL;

    public ControladorMenu() {
    }

    public ControladorMenu(VistaMenuPrincipal vistaPrincipal, Ficharegistroyreferencia vistaRegisRef, CtrlRegistroReferencia ctrlRegRef, VistaRegistroLlamadas vrLL) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaRegisRef = vistaRegisRef;
        this.ctrlRegRef = ctrlRegRef;
        this.vrLL = vrLL;
    }

    

    public void iniciarContrl() {
        abrirVistaMenu();
        salir();
        ctrlRegRef.IniciaCtrlRegistroReferencia();
        ctrlRegRef.IniciarValidaciones();
        vistaPrincipal.getItmRegisRefer().addActionListener(e -> abriPanel2(vistaRegisRef.getPnlFRegistroReferencia()));
        vistaPrincipal.getItmLlamada().addActionListener(e -> abriPanel2(vrLL.getPnlLlamadas()));
        

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

    public void salir() {
        System.out.println("dispouse");
        vistaRegisRef.dispose();
    }
    
    private void abriPanel2(JPanel panel){
        panel.setSize(850, 400);
        panel.setLocation(2, 2);
        JScrollPane scrollpane;
        scrollpane = new JScrollPane();
        scrollpane.setBounds(0,0,870, 670);
        scrollpane.setViewportView(panel);
        vistaPrincipal.getPnlPrincipal().removeAll();
        vistaPrincipal.getPnlPrincipal().add(scrollpane);
        vistaPrincipal.getPnlPrincipal().revalidate();
        vistaPrincipal.getPnlPrincipal().repaint();
    }
}
