
package marylove.controlador;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.DefinicionObjetivosEspecificosDB;
import marylove.DBmodelo.DefinicionObjetivosGeneralDB;
import marylove.conexion.Conexion;
import marylove.models.DefinicionObjetivosEspecifico;
import marylove.models.DefinicionObjetivosGeneral;
import marylove.vista.FichaEvaluacionPlandeVida;
import marylove.vista.VistaDefinicionObjetivosEspecifico;
import marylove.vista.vistaAgregarObjetivoGenera;

public class ControlEvaluacionPlanVida {
     private Conexion conex;
    DefaultTableModel modeloTabOE;
    DefaultTableModel modeloTabOG;
    private FichaEvaluacionPlandeVida vistaEvaPlanVid;
    private DefinicionObjetivosGeneralDB objGenModelDB;
    private DefinicionObjetivosEspecificosDB objEspecModelDB;
    private DefinicionObjetivosGeneral objGenMOdel;
    private DefinicionObjetivosEspecifico objEspecMdel;
    private VistaDefinicionObjetivosEspecifico vistaObjEsp;
    private vistaAgregarObjetivoGenera vistaObjGene;

    public ControlEvaluacionPlanVida(FichaEvaluacionPlandeVida vistaEvaPlanVid, DefinicionObjetivosGeneralDB objGenModelDB, DefinicionObjetivosEspecificosDB objEspecModelDB, DefinicionObjetivosGeneral objGenMOdel, DefinicionObjetivosEspecifico objEspecMdel, VistaDefinicionObjetivosEspecifico vistaObjEsp, vistaAgregarObjetivoGenera vistaObjGene) {
  
        this.vistaEvaPlanVid = vistaEvaPlanVid;
        this.objGenModelDB = objGenModelDB;
        this.objEspecModelDB = objEspecModelDB;
        this.objGenMOdel = objGenMOdel;
        this.objEspecMdel = objEspecMdel;
        this.vistaObjEsp = vistaObjEsp;
        this.vistaObjGene = vistaObjGene;
    }
    
     
    
    public void iniciCtrlEvaluacionPlanVida(){
        cargaListaObjEspe();
        vistaEvaPlanVid.getBtnObjetivosEspecificos().addActionListener(e->abrirVentObjEspecificos());
        vistaEvaPlanVid.getBtnObjetivoGeneral().addActionListener(e->abrirVentObjeGenerales());
        vistaObjEsp.getBtnGuardar().addActionListener(e-> datosObjEsp());
        
        cargaListaObjGen();
        vistaObjGene.getBtnGuardar().addActionListener(e->datosObjGen());
    }
    
   public void abrirEvaPlaVida(){
       vistaEvaPlanVid.setVisible(true);
       vistaEvaPlanVid.setLocationRelativeTo(null);
   }
   
   public void abrirVentObjEspecificos(){
       vistaObjEsp.setVisible(true);
       vistaObjEsp.setLocationRelativeTo(null);
   }
   
   public void abrirVentObjeGenerales(){
       vistaObjGene.setVisible(true);
       vistaObjGene.setLocationRelativeTo(null);
   }
   
   public void datosObjEsp(){
       
       objEspecModelDB.setObjetivosEspecificos(vistaObjEsp.getTxtObjEspecifico().getText());
       objEspecModelDB.setActividad(vistaObjEsp.getTxtActividad().getText());
       objEspecModelDB.setTiempo(vistaObjEsp.getTxtTiempo().getText());
       objEspecModelDB.setApoyode(vistaObjEsp.getTxtApoyoDe().getText());
       objEspecModelDB.setSupuestosAmenazas(vistaObjEsp.getTxtSupuestoAmenaza().getText());  
     
       if (objEspecModelDB.insertarObjectivEspecif()) {
            JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
            cargaListaObjEspe();
            vistaObjEsp.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
        }
   }
   
   public void cargaListaObjEspe(){
        int canFilas = vistaEvaPlanVid.getTabObjetivosEspecificos().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabOE.removeRow(i);
        }

        modeloTabOE = (DefaultTableModel) vistaEvaPlanVid.getTabObjetivosEspecificos().getModel();
        List<DefinicionObjetivosEspecifico> lista;

        try {
            lista = objEspecModelDB.listartObjetiv();
            int columnas = modeloTabOE.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOE.addRow(new Object[columnas]);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getDefinicion_id(),i,0);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getObjetivosEspecificos(), i, 1);
                //fila del codigo responsable 
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getActividad(), i, 3);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getTiempo(), i,4);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getApoyode(), i, 5);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getSupuestosAmenazas(), i, 6);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   ////////////////////////////////////////////////77
   
   public void datosObjGen(){
       objGenModelDB.setObjetivo_general(vistaObjGene.getTxtObjGeneral().getText());
       objGenModelDB.setTiempo(vistaObjGene.getTxtObjGeneral().getText());
       objGenModelDB.setObservaciones(vistaObjGene.getTxtTiempo().getText());  
     
       if (objGenModelDB.insertarObjeGen()) {
            JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
            cargaListaObjGen();
            vistaObjGene.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
        }
   }
   
   public void cargaListaObjGen(){
        int canFilas = vistaEvaPlanVid.getTabObjetivoGeneral().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabOG.removeRow(i);
        }

        modeloTabOG = (DefaultTableModel) vistaEvaPlanVid.getTabObjetivoGeneral().getModel();
        List<DefinicionObjetivosGeneral> lista;

        try {
            lista = objGenModelDB.listartObjeGen();
            int columnas = modeloTabOG.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOG.addRow(new Object[columnas]);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getDefiniciong_id(), i, 0);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getObjetivo_general(), i, 1);
                //fila del codigo responsable 
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getTiempo(), i, 3);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getObservaciones(), i,4);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

}
