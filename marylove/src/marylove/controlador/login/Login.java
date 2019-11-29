package marylove.controlador.login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import marylove.controlador.ControladorMenu;
import marylove.vista.VistaMenuPrincipal;
import marylove.vista.login.FrmLogin;
/**
 *
 * @author Patricio
 */
public class Login  implements ActionListener{
    // <editor-fold defaultstate="collapsed" desc="VISTA"> //</editor-fold> PARA DOCUMENTAR
    private FrmLogin vista;
    //aqui modelo;

    public Login(FrmLogin vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setTitle("LOGIN");
        añadirEscuchas();
    }
    
    private void añadirEscuchas(){
        vista.getBtnAceptar().addActionListener(this);
        vista.getBtnSalir().addActionListener(this);
    }
    
    private void abrirMenu(){
        vista.dispose();
        new ControladorMenu(new VistaMenuPrincipal());
    }
    
    private void salir(){
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.getBtnAceptar())){
            abrirMenu();
        }
        if(e.getSource().equals(vista.getBtnSalir())){
            salir();
        }
    }
}