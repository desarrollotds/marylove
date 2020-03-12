/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.CitaDB;
import marylove.DBmodelo.psicologoDB;

import marylove.models.Cita;
import marylove.models.Psicologo;
import marylove.vista.FichaAgendamientoCitas;
import marylove.vista.VistaCita;

/**
 *
 * @author Usuario
 */
public class ControladorCitas extends Validaciones implements ActionListener, PropertyChangeListener{
    
     private VistaCita vistaCita;
    private CitaDB modeloCita;
    private psicologoDB modeloPsicologo;
    private int codigo_llamada; 

    public int getCodigo_llamada() {
        return codigo_llamada;
    }

    public void setCodigo_llamada(int codigo_llamada) {
        this.codigo_llamada = codigo_llamada;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public ControladorCitas(VistaCita vistaCita) {
        this.vistaCita = vistaCita;
        this.vistaCita.setVisible(true);
        this.vistaCita.setResizable(false);
        this.vistaCita.setLocationRelativeTo(null);
        // cargarPsicologos();

    }

    public void iniciarControl() {
        Calendar fecha = new GregorianCalendar();
        vistaCita.getLblFechaActual().setText(fechaBD(fecha.getTime().getTime()).toString());
        cargarPsicologos();
        vistaCita.getBtnCrearCita().addActionListener(e -> crearCita());
        vistaCita.getTbl_lstCitas().setCellSelectionEnabled(true);
        vistaCita.getBtnCancelar().addActionListener(e -> vistaCita.dispose());
        vistaCita.getBtnSalir().addActionListener(e -> System.exit(0));
        vistaCita.getBtnEliminar().addActionListener(e -> eliminarCita());
        vistaCita.getDtc_FechaCita().addPropertyChangeListener((PropertyChangeEvent evt) -> this.propertyChange(evt));
    }

    public void crearCita() {
        String nombreVictima = vistaCita.getTxt_NombreVictima().getText().toString();
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
        obtenerDiaSemana();

        int column = vistaCita.getTbl_lstCitas().getSelectedColumn();
        int row = vistaCita.getTbl_lstCitas().getSelectedRow();
        obtenerDiaSemana();
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

    private void cargaListaCitas(java.sql.Date fecha) {

        if (fecha != null) {
            DefaultTableModel modeloTablaCitas;
            modeloTablaCitas = (DefaultTableModel) vistaCita.getTbl_lstCitas().getModel();
            modeloTablaCitas.addColumn(obtenerDiaSemana() + " " + fecha.getDate() + " " + fechaBD(vistaCita.getDtc_FechaCita().getDate().getTime()).getYear());
            modeloTablaCitas.addColumn("Código de Cita");
            modeloTablaCitas.addColumn("Befeniciaria");

            System.out.println(fecha.getDate());
            for (int j = vistaCita.getTbl_lstCitas().getRowCount() - 1; j >= 0; j--) {
                modeloTablaCitas.removeRow(j);
            }

            List<Cita> lista = modeloCita.consultarListaCitas(fechaBD(vistaCita.getDtc_FechaCita().getDate().getTime()));

            int columnas = modeloTablaCitas.getColumnCount();

            for (int i = 0; i < lista.size(); i++) {
                modeloTablaCitas.addRow(new Object[columnas]);
                modeloTablaCitas.setValueAt(lista.get(i).getCita_hora(), i, 0);
                modeloTablaCitas.setValueAt(lista.get(i).getCita_id(), i, 1);
                modeloTablaCitas.setValueAt(lista.get(i).getVictima_codigo(), i, 0);
            }
            vistaCita.getTbl_lstCitas().setModel(modeloTablaCitas);
        } else {
            System.out.println("NO SE PUDO SACAR LA LISTA DE CITAS");
        }

    }

    private String obtenerDiaSemana() {
        Calendar now = vistaCita.getDtc_FechaCita().getCalendar();
        String[] arrayDias = new String[]{
            "Domingo",
            "Lunes",
            "Martes",
            "Miércoles",
            "Jueves",
            "Viernes",
            "Sábado"
        };
        System.out.println("HOY ES: " + arrayDias[now.get(Calendar.DAY_OF_WEEK) - 1]);
        String dia = arrayDias[now.get(Calendar.DAY_OF_WEEK) - 1];
        return dia;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        cargaListaCitas(fechaBD(vistaCita.getDtc_FechaCita().getDate().getTime()));
        System.out.println("ACTUALIZANDOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
    }

    public void cargarPsicologos() {
        //DefaultComboBoxModel comboPsicologos = new DefaultComboBoxModel();
        modeloCita = new CitaDB();

        try {
             //ArrayList lista = (ArrayList) modeloCita.obtenerPsicologicos();
            List<Psicologo> lista = modeloCita.consultarPsicologos();
            if (lista.size() >= 0) {
                try {
                    for (int i = 0; i < lista.size(); i++) {
                        vistaCita.getCbxPsicologos().addItem(lista.get(i).getPersona_nombre()+" "+lista.get(i).getPersona_apellido());
                        // comboPsicologos.addElement(lista.get(i).toString());
                        System.out.println("Se cargo el psicologo: " + lista.get(i).getPersona_nombre()+" "+lista.get(i).getPersona_apellido());
                    }
                   // vistaCita.getCbxPsicologos().setModel(comboPsicologos);
                } catch (Exception e) {
                    System.out.println("error al mostrar: " + e.getMessage());
                }
            } else {
                System.out.println("ERROR LISTA VACIA");
            }

            //        List<Psicologo> listaPsicologos = modeloCita.consultarPsicologos();
        } catch (Exception e) {
            System.out.println("ERROR AL SACAR LA LISTA DE LA BD " + e);
        }
    }    
}
