package marylove.controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.models.Direccion;
import marylove.models.Hijos;
import marylove.models.InstitucionEducativa;
import marylove.models.RegistroReferenciaDb;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.FormaAgregarHijos;

public class CtrlRegistroReferencia extends Validaciones{

    private final Ficharegistroyreferencia vistRegisRef;
    private final RegistroReferenciaDb modelRegisRef;
    private final FormaAgregarHijos vistaAgreHijos;
    private final InstitucionEducativa modelInstEducativa;
    private final Hijos modelhijos;
    private final Direccion modelDirecc;
   
   //subir
    
    public CtrlRegistroReferencia(Ficharegistroyreferencia vistRegisRef, RegistroReferenciaDb modelRegisRef, FormaAgregarHijos vistaAgreHijos, InstitucionEducativa modelInstEducativa, Hijos modelhijos, Direccion modelDirecc) {
        this.vistRegisRef = vistRegisRef;
        this.modelRegisRef = modelRegisRef;
        this.vistaAgreHijos = vistaAgreHijos;
        this.modelInstEducativa = modelInstEducativa;
        this.modelhijos = modelhijos;
        this.modelDirecc = modelDirecc;
        

    }
    
    
    public void IniciaCtrlRegistroReferencia() {
        iniciaFechas();
        vistRegisRef.getBtnAgregarHijos().addActionListener(e -> agregarNewHijos(1));
        vistRegisRef.getBtnAgregarHijos().addActionListener(e -> abrirVistaRegHijos());
    }
    
    public void iniciaFechas() {
        Calendar fechSys = new GregorianCalendar();
              // vistRegisRef.getJdcFecha().setCalendar(fechSys);
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
     
    public void insertarBeneficiario(){
        modelRegisRef.setPersona_codigo(Integer.parseInt(vistRegisRef.getTxtCodigo().getText()));
        modelRegisRef.setPersona_cedula(vistRegisRef.getTxtCedula().getText());
        modelRegisRef.setPersona_nombre(vistRegisRef.getTxtNombres().getText());
        modelRegisRef.setPersona_apellido(vistRegisRef.getTxtApellidos().getText());
        modelRegisRef.setPersona_fecha_nac(vistRegisRef.getDcFechaNacimiento().getDateFormatString());
        //Aqui capo sexo
        modelRegisRef.setPersona_estadocivil(vistRegisRef.getCbxEstadoCivill().getItemCount());
        modelRegisRef.setPersona_estado_actual((boolean) vistRegisRef.getCbxConvivia().getSelectedItem());
        //Aqui instrucciones falta atributo
        modelRegisRef.setPersona_ocupacion(Integer.parseInt(vistRegisRef.getTxtOcupacion().getText()));
        // Falta Instruccion
        // lugar de trabajo
        //falta referencia
        modelRegisRef.setPersona_telefono(vistRegisRef.getTxtOcupacion().getText());  
    }
    
    public void agregarHijos(){
        modelRegisRef.setPersona_nombre(vistaAgreHijos.getTxtNombres().getText());
        modelRegisRef.setPersona_apellido(vistaAgreHijos.getTxtApellidos().getText());
        modelRegisRef.setPersona_fecha_nac(vistaAgreHijos.getDcFechaNacimiento().getDateFormatString());
        modelInstEducativa.setInst_nombre(vistaAgreHijos.getTxtInstitucionEducativa().getText());
        modelhijos.setHijo_anioescolar(vistaAgreHijos.getCbxAnioEscolar().getSelectedItem().toString());
        
    }
    
    public void agregarDomicilio(){
        //Falata pais y lugar de referencia
        modelRegisRef.setPersona_est_migr(Integer.parseInt(vistRegisRef.getTxtEstadoMigratorio().getText()));
        
    }
    
    public void agregarNewHijos(int a) {
        if (a == 1) {// crear

            vistRegisRef.getTxtCodigo().setText("");
            vistRegisRef.getTxtNombres().setText("");
            vistRegisRef.getTxtApellidos().setText("");

            vistRegisRef.getCbSexo().setSelectedItem(0);
            vistRegisRef.getCbxEstadoCivill().setSelectedItem(0);
            //vistRegisRef.getCbxInstruccion().setSelectedItem(0);
            vistRegisRef.getTxtOcupacion().setText("");
            vistRegisRef.getTxtLugarTrabajo().setText("");
            vistRegisRef.getTxtReferencia().setText("");
            vistRegisRef.getTxtTelefono().setText("");
           // vistRegisRef.getTxtNumeroHijos().setText("");
            //vistRegisRef.getTxtVarones().setText("");
            //vistRegisRef.getTxtMujeres().setText("");

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

