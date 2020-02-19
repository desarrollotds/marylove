package marylove.controlador;
import marylove.models.Primer_encuentro;
import marylove.vista.FichaPrimerEncuentro;

/**
 *
 * @author Usuario
 */
public class ControladorPrimerEncuentro extends Validaciones {

    private final FichaPrimerEncuentro VistaPrimerEncuentro;
    private final Primer_encuentro ModeloPrimerEncuentro;

    public ControladorPrimerEncuentro(FichaPrimerEncuentro VistaPrimerEncuentro, Primer_encuentro ModeloPrimerEncuentro) {
        this.VistaPrimerEncuentro = VistaPrimerEncuentro;
        this.ModeloPrimerEncuentro = ModeloPrimerEncuentro;
    }

    public void iniciarControl() {
        abrirVentana();
    }

    public void abrirVentana() {
        VistaPrimerEncuentro.setVisible(true);
        VistaPrimerEncuentro.setLocationRelativeTo(null);
    }

    public void agregarDatos(int b) {
        VistaPrimerEncuentro.getTxtCodigo().setText("");
        VistaPrimerEncuentro.getTxtNombre().setText("");
        VistaPrimerEncuentro.getTxtPsicologa().setText("");
        VistaPrimerEncuentro.getTxtCodigo().setText("");

    }

}
