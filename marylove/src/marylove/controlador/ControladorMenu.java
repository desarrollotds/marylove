package marylove.controlador;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.VistaMenuPrincipal;
import marylove.vista.VistaRegistroLlamadas;
import marylove.vista.formularioR1;

public class ControladorMenu {

    VistaMenuPrincipal vistaPrincipal;
    Ficharegistroyreferencia vistaRegisRef;
    CtrlRegistroReferencia ctrlRegRef;
    VistaRegistroLlamadas vrLL;
    formularioR1 Vfr1;
    Controlador_registro_llamadas ctrlLlamadas;
    

    public ControladorMenu(VistaMenuPrincipal vistaPrincipal, Ficharegistroyreferencia vistaRegisRef, CtrlRegistroReferencia ctrlRegRef, VistaRegistroLlamadas vrLL, formularioR1 Vfr1, Controlador_registro_llamadas ctrlLlamadas) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaRegisRef = vistaRegisRef;
        this.ctrlRegRef = ctrlRegRef;
        this.vrLL = vrLL;
        this.Vfr1 = Vfr1;
        this.ctrlLlamadas = ctrlLlamadas;
    }

   

    public void iniciarContrl() {
        abrirVistaMenu();
        salir();
        ctrlRegRef.IniciaCtrlRegistroReferencia();
        ctrlLlamadas.iniciarControlRLL();
        ctrlRegRef.IniciarValidaciones();
        //vistaPrincipal.getItmRegisRefer().addActionListener(e -> abriPanel2(vistaRegisRef.getPnlFRegistroReferencia()));
        vistaPrincipal.getItmLlamada().addActionListener(e -> abriPanel2(vrLL.getPnlLlamadas()));
        vistaPrincipal.getItmFR1().addActionListener(e -> abriPanel2(Vfr1.getPnlfr1()));
        

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
