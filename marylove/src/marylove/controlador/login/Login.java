package marylove.controlador.login;
import marylove.vista.FrmLogin;
/**
 *
 * @author Patricio
 */
public class Login{
  
    private final marylove.vista.FrmLogin login;

    public Login(FrmLogin marylove) {
        this.login = marylove;
    }

    public Login() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public void iniciarControl (){
        abrirVentana();
       
    }
    
    public void abrirVentana(){
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
    
}
