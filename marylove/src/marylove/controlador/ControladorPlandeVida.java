package marylove.controlador;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.DefinicionObjetivosEspecificosDB;
import marylove.DBmodelo.DefinicionObjetivosGeneralDB;
import marylove.DBmodelo.Plan_devidaDB;
import marylove.conexion.Conexion;
import marylove.models.DefinicionObjetivosEspecifico;
import marylove.models.DefinicionObjetivosGeneral;
import marylove.vista.FichaPlandeVida;
import marylove.vista.VistaDefinicionObjetivosEspecifico;
import marylove.vista.vistaAgregarObjetivoGenera;

/**
 *
 * @author USUARIO
 */
public class ControladorPlandeVida extends Validaciones{

    private final FichaPlandeVida vista;
    private final Plan_devidaDB modelo;
    private Conexion conex;
    DefaultTableModel modeloTabOE;
    DefaultTableModel modeloTabOG;
    private DefinicionObjetivosGeneralDB objGeModelDB;
    private DefinicionObjetivosEspecificosDB objEspeModelDB;
    private DefinicionObjetivosGeneral objGeMOdel;
    private DefinicionObjetivosEspecifico objEspeMdel;
    private VistaDefinicionObjetivosEspecifico vistObjEsp;
    private vistaAgregarObjetivoGenera vistObjGene;

    public ControladorPlandeVida(FichaPlandeVida vista, Plan_devidaDB modelo, DefinicionObjetivosGeneralDB objGeModelDB, DefinicionObjetivosEspecificosDB objEspeModelDB, DefinicionObjetivosGeneral objGeMOdel, DefinicionObjetivosEspecifico objEspeMdel, VistaDefinicionObjetivosEspecifico vistObjEsp, vistaAgregarObjetivoGenera vistObjGene) {
        this.vista = vista;
        this.modelo = modelo;
        this.objGeModelDB = objGeModelDB;
        this.objEspeModelDB = objEspeModelDB;
        this.objGeMOdel = objGeMOdel;
        this.objEspeMdel = objEspeMdel;
        this.vistObjEsp = vistObjEsp;
        this.vistObjGene = vistObjGene;
    }

    

    public void iniciarControl() {
        cargaListaObjEspe();
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));
        vista.getTxtCodigo().addKeyListener(validarNumeros(vista.getTxtCodigo()));
        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombre(), vista.getTxtCodigo()));
        Calendar c2 = new GregorianCalendar();
        vista.getDtcFecha().setCalendar(c2);
        vista.getBtnObjetivosEspecificos().addActionListener(e->abrirVentObjEspecificos());
        vista.getBtnObjetivoGeneral().addActionListener(e->abrirVentObjeGenerales());
        vistObjEsp.getBtnGuardar().addActionListener(e-> datosObjEsp());
        
        cargaListaObjGen();
        vistObjGene.getBtnGuardar().addActionListener(e->datosObjGen());
    }
    public void insertaDatos() {
        
        
    }
    public void abrirEvaPlaVida(){
       vista.setVisible(true);
       vista.setLocationRelativeTo(null);
   }
   
   public void abrirVentObjEspecificos(){
       vistObjEsp.setVisible(true);
       vistObjEsp.setLocationRelativeTo(null);
   }
   
   public void abrirVentObjeGenerales(){
       vistObjGene.setVisible(true);
       vistObjGene.setLocationRelativeTo(null);
   }
   
   public void datosObjEsp(){
       
       objEspeModelDB.setObjetivosEspecificos(vistObjEsp.getTxtObjEspecifico().getText());
       objEspeModelDB.setActividad(vistObjEsp.getTxtActividad().getText());
       objEspeModelDB.setTiempo(vistObjEsp.getTxtTiempo().getText());
       objEspeModelDB.setApoyode(vistObjEsp.getTxtApoyoDe().getText());
       objEspeModelDB.setSupuestosAmenazas(vistObjEsp.getTxtSupuestoAmenaza().getText());  
     
       if (objEspeModelDB.insertarObjectivEspecif()) {
            JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
            cargaListaObjEspe();
            vistObjEsp.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
        }
   }
   
   public void cargaListaObjEspe(){
        int canFilas = vista.getTabObjetivosEspecificos().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i!=0) {
                modeloTabOE.removeRow(i);
            }
            
        }

        modeloTabOE = (DefaultTableModel) vista.getTabObjetivosEspecificos().getModel();
        List<DefinicionObjetivosEspecifico> lista;

        try {
            lista = objEspeModelDB.listartObjetiv();
            int columnas = modeloTabOE.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOE.addRow(new Object[columnas]);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getDefinicion_id(),i,0);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getObjetivosEspecificos(), i, 1);
                //fila del codigo responsable 
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getActividad(), i, 3);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getTiempo(), i,4);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getApoyode(), i, 5);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getSupuestosAmenazas(), i, 6);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void datosObjGen(){
       objGeModelDB.setObjetivo_general(vistObjGene.getTxtObjGeneral().getText());
       objGeModelDB.setTiempo(vistObjGene.getTxtObjGeneral().getText());
       objGeModelDB.setObservaciones(vistObjGene.getTxtTiempo().getText());  
     
       if (objGeModelDB.insertarObjeGen()) {
            JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
            cargaListaObjGen();
            vistObjGene.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
        }
   }
   
   public void cargaListaObjGen(){
        int canFilas = vista.getTabObjetivoGeneral().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabOG.removeRow(i);
        }

        modeloTabOG = (DefaultTableModel) vista.getTabObjetivoGeneral().getModel();
        List<DefinicionObjetivosGeneral> lista;

        try {
            lista = objGeModelDB.listartObjeGen();
            int columnas = modeloTabOG.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOG.addRow(new Object[columnas]);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getDefiniciong_id(), i, 0);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getObjetivo_general(), i, 1);
                //fila del codigo responsable 
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getTiempo(), i, 3);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getObservaciones(), i,4);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    public void borrarDatos() {
        
    }
}
