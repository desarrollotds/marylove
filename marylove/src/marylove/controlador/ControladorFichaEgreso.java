package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import marylove.DBmodelo.DefinicionObjetivosEspecificosDB;
import marylove.DBmodelo.DefinicionObjetivosGeneralDB;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.EgresoDB;
import marylove.conexion.Conexion;
import marylove.models.DefinicionObjetivosEspecifico;
import marylove.models.DefinicionObjetivosGeneral;
import marylove.models.Direccion;
import marylove.models.Egreso;
import marylove.vista.FichaEgreso;

public class ControladorFichaEgreso {

    private Direccion dir;
    private Egreso egresoModel;
    private FichaEgreso vistaEgres;
    private EgresoDB egresoModelDb;
    private DireccionDB dirDB;
    
     Conexion conex = new Conexion();

    public ControladorFichaEgreso(Direccion dir, Egreso egresoModel, FichaEgreso vistaEgres, EgresoDB egresoModelDb, DireccionDB dirDB) {
        this.dir = dir;
        this.egresoModel = egresoModel;
        this.vistaEgres = vistaEgres;
        this.egresoModelDb = egresoModelDb;
        this.dirDB = dirDB;
    }
    
    public void iniciCtrlEgreso() {
//        AbrirVentEgreso();
        vistaEgres.getBtnDireccion().addActionListener(e -> MustraVentana());
        vistaEgres.getJdBtnGuardar().addActionListener(e->datosDirecc() );
    }

    public void MustraVentana() {
        vistaEgres.getjDialogIngDirecc().setVisible(true);
        vistaEgres.getjDialogIngDirecc().setLocationRelativeTo(null);
        vistaEgres.getjDialogIngDirecc().setSize(400, 450);
        vistaEgres.getjDialogIngDirecc().setResizable(false);
    }

    public void AbrirVentEgreso() {
        vistaEgres.setVisible(true);
        vistaEgres.setLocationRelativeTo(null);
    }
    
    public Direccion datosDirecc(){
       Direccion dir = new Direccion();
       
      
       dir.setCalle_dir(vistaEgres.getJdxtCalle().getText());
       dir.setDir_interseccion(vistaEgres.getJdtxtInterseccion().getText());
       dir.setDir_num_casa(vistaEgres.getJdtxtNumCasa().getText());
       dir.setDir_barrio(vistaEgres.getJdtxtBarrio().getText());
       dir.setDir_parroquia(vistaEgres.getJdtxtParroquia().getText());
       dir.setDir_ciudad(vistaEgres.getJdtxtCiudad().getText());
       dir.setDir_referencias(vistaEgres.getJdtxtReferencia().getText());
//       dir.setDir_estado(vistaEgres.getJdtxtEstado().getText());
       
       if (dirDB.verifiDirecc(conex)!=0) {
            JOptionPane.showMessageDialog(null, "Ids Insertados correctamente"); 
        }else {
            JOptionPane.showMessageDialog(null, "Error al Ingresar Ids");
        }
        return dir;
        
    }
    
    public void guardarDatos(){
//        if (dirDB.insertaDireccion(conex, datosDirecc())) {
//            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente"); 
//        }else {
//            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
//        }
    }
    
    public Egreso egresoDatos(){
        Egreso egres= new Egreso();
        egres.setEgreso_situacion(vistaEgres.getTxaSituacion().getText());
        egres.setTelefono(Integer.parseInt(vistaEgres.getTxtTelefonoBeneficiaria().getText()));
        egres.setCelular(Integer.parseInt(vistaEgres.getTxtCelular().getText()));
        return null;
        
    }
    
    
}
