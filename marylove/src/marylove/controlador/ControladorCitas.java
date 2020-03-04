/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.CitaDB;

import marylove.models.Cita;
import marylove.vista.FichaAgendamientoCitas;
import marylove.vista.VistaCita;

/**
 *
 * @author Usuario
 */
public class ControladorCitas extends Validaciones implements ActionListener{
    
     private VistaCita vistaCita;
    private CitaDB modeloCita;

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public ControladorCitas(VistaCita vistaCita) {
        this.vistaCita = vistaCita;
        this.vistaCita.setVisible(true);
//        this.vistaCita.setResizable(false);
        this.vistaCita.setLocationRelativeTo(null);
    }

    public void iniciarControl() {
        vistaCita.getBtnCrearCita().addActionListener(e -> crearCita());
        vistaCita.getTbl_lstCitas().setCellSelectionEnabled(true);
        vistaCita.getBtnCancelar().addActionListener(e -> vistaCita.dispose());
        vistaCita.getBtnSalir().addActionListener(e -> System.exit(0));
        vistaCita.getBtnEliminar().addActionListener(e -> eliminarCita());
    }

    public void crearCita() {
        String nombreVictima= vistaCita.getTxt_NombreVictima().getText().toString();
        modeloCita.setVictima_codigo(Integer.parseInt(vistaCita.getTxt_codigoVictima().getText()));
        modeloCita.setCita_fecha(fechaBD(vistaCita.getDtc_FechaCita().getDate().getTime()));
        //modeloCita.setLlamada_codigo();
        String nom_psicologo = vistaCita.getCbxPsicologos().getSelectedItem().toString();
        if (modeloCita.crearCita()) {
            JOptionPane.showMessageDialog(null, "La cita fue creada exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo crear la cita, revise que los datos esten ingresados correctamente y vuelva a intentarlo");
        }

    }

    public void eliminarCita() {
        xxxxxx();

        int column = vistaCita.getTbl_lstCitas().getSelectedColumn();
        int row = vistaCita.getTbl_lstCitas().getSelectedRow();
        if (column >= 0 && row >= 0) {
            String valores = vistaCita.getTbl_lstCitas().getValueAt(row, column).toString();
            System.out.println(valores);
            if (JOptionPane.showConfirmDialog(null,
                    "Esta seguro que desea eliminar esta cita con el codigo " + valores,
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                modeloCita.setCita_id(Integer.parseInt(valores));
                if (modeloCita.eliminarCita()) {
                    JOptionPane.showMessageDialog(null, "La cita fue eliminada exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar la cita seleccionada");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se a seleccionado ninguna cita");
        }
    }

    public void mostrarDetallesCita() {

    }

    private void cargaLista(int valor, String condicion) {
        DefaultTableModel modeloTabla;
        modeloTabla = (DefaultTableModel) vistaCita.getTbl_lstCitas().getModel();

        for (int j = vistaCita.getTbl_lstCitas().getRowCount() - 1; j >= 0; j--) {
            modeloTabla.removeRow(j);
        }

        List<Cita> lista = modeloCita.consultarListaCitas();
        int columnas = modeloTabla.getColumnCount();

        for (int i = 0; i < lista.size(); i++) {
            modeloTabla.addRow(new Object[columnas]);
            vistaCita.getTbl_lstCitas().setValueAt(lista.get(i), i, 0);
        }
    }

    private void xxxxxx() {
        Calendar now = vistaCita.getDtc_FechaCita().getCalendar();
        String[] arrayDias = new String[]{
            "Domingo",
            "Lunes",
            "Martes",
            "Miercoles",
            "Jueves",
            "Viernes",
            "Sábado"};
        System.out.println("HOY ES: "+arrayDias[now.get(Calendar.DAY_OF_WEEK)-1]);
    }
    
}
