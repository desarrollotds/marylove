package marylove.controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.models.Registro_referencia;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.FormaAgregarHijos;

public class CtrlRegistroReferencia extends Validaciones{

    private final Ficharegistroyreferencia vistRegisRef;
    private final Registro_referencia modelRegisRef;
    private final FormaAgregarHijos vistaAgreHijos;

   
   
    public CtrlRegistroReferencia(Ficharegistroyreferencia vistRegisRef, Registro_referencia modelRegisRef, FormaAgregarHijos vistaAgreHijos) {
        this.vistRegisRef = vistRegisRef;
        this.modelRegisRef = modelRegisRef;
        this.vistaAgreHijos = vistaAgreHijos;
    }

    public void IniciaCtrlRegistroReferencia() {
        iniciaFechas();
        vistRegisRef.getBtnAgregarHijos().addActionListener(e -> agregarHijos(1));
        vistRegisRef.getBtnAgregarHijos().addActionListener(e -> abrirVistaRegHijos());
        

    }
    
    public void iniciaFechas() {
        Calendar fechSys = new GregorianCalendar();
        vistRegisRef.getJdcFecha().setCalendar(fechSys);
        vistRegisRef.getDcFechaNacimiento().setCalendar(fechSys);
    }

    private void abrirVistaRegHijos() {
        vistaAgreHijos.setVisible(true);
        vistaAgreHijos.setLocationRelativeTo(null);

    }
    
     public void IniciarValidaciones() {
        vistRegisRef.getTxtNombres().addKeyListener(validarLetras(vistRegisRef.getTxtNombres()));
        vistRegisRef.getTxtApellidos().addKeyListener(validarLetras(vistRegisRef.getTxtApellidos()));
        
        vistRegisRef.getTxtCelular().addKeyListener(validarNumeros(vistRegisRef.getTxtCelular()));
        vistRegisRef.getTxtFijo().addKeyListener(validarNumeros( vistRegisRef.getTxtFijo()));
        
    }

    public void agregarHijos(int a) {
        if (a == 1) {// crear

            vistRegisRef.getTxtCodigo().setText("");
            vistRegisRef.getTxtNombres().setText("");
            vistRegisRef.getTxtApellidos().setText("");

            vistRegisRef.getCbSexo().setSelectedItem(0);
            vistRegisRef.getCbxEstadoCivill().setSelectedItem(0);
            vistRegisRef.getCbxInstruccion().setSelectedItem(0);
            vistRegisRef.getTxtOcupacion().setText("");
            vistRegisRef.getTxtLugarTrabajo().setText("");
            vistRegisRef.getTxtReferencia().setText("");
            vistRegisRef.getTxtTelefono().setText("");
            vistRegisRef.getTxtNumeroHijos().setText("");
            vistRegisRef.getTxtVarones().setText("");
            vistRegisRef.getTxtMujeres().setText("");

        } else {//editar
            DefaultTableModel modeloTabla = (DefaultTableModel) vistRegisRef.getTblHijos().getModel();
            int fsel = vistRegisRef.getTblHijos().getSelectedRow();
            if (fsel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
            } else {

            }
        }
    }
   

}
