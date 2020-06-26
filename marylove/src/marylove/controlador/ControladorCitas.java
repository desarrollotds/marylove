/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.CitaDB;
import marylove.DBmodelo.LlamadaDB;
import marylove.DBmodelo.psicologoDB;

import marylove.models.Cita;
import marylove.models.Persona_llamada;
import marylove.models.Psicologo;
import marylove.vista.VistaCita;

/**
 *
 * @author Usuario
 */
public class ControladorCitas extends Validaciones implements ActionListener, PropertyChangeListener {

    private VistaCita vistaCita;
    private CitaDB modeloCita;
    private psicologoDB modeloPsicologo;
    private int codigo_llamada;
    private int codigo_empleado;
    private List<Psicologo> listaPsicologos;

    public int getCodigo_llamada() {
        return codigo_llamada;
    }

    public void setCodigo_llamada(int codigo_llamada) {
        this.codigo_llamada = codigo_llamada;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public ControladorCitas(VistaCita vistaCita) throws Exception {
        this.vistaCita = vistaCita;
        this.vistaCita.getLbl_codigoempleado().setText(codigo_empleado + "");
//        this.vistaCita.setVisible(true);
//        this.vistaCita.setResizable(false);
//        this.vistaCita.setLocationRelativeTo(null);

        //DAMOS FORMATO A LA TABLA QUE CONTENDRA A LAS BENEFICIARIAS
        DefaultTableModel modeloTablaBeneficiarias;
        modeloTablaBeneficiarias = (DefaultTableModel) vistaCita.getTbl_lstBeneficiarias().getModel();
        modeloTablaBeneficiarias.addColumn("Código");
        modeloTablaBeneficiarias.addColumn("Cédula");
        modeloTablaBeneficiarias.addColumn("Nombres");
        modeloTablaBeneficiarias.addColumn("Apellidos");
        vistaCita.getTbl_lstBeneficiarias().setModel(modeloTablaBeneficiarias);

        // cargarPsicologos();
    }

    public void iniciarControl() {
//        vistaCita.setVisible(true);
        cargarPsicologos();
        cargarListaBeneficiarias(null);
        Calendar fecha = new GregorianCalendar();

        vistaCita.getLblFechaActual().setText(fechaBD(fecha.getTime().getTime()).toString());
        vistaCita.getBtnCancelar().addActionListener(e -> vistaCita.dispose());
        vistaCita.getBtnSalir().addActionListener(e -> System.exit(0));
        vistaCita.getBtnCrearCita().addActionListener(e -> crearCita());
        vistaCita.getBtnEliminar().addActionListener(e -> eliminarCita());
        vistaCita.getDtc_FechaCita().addPropertyChangeListener((PropertyChangeEvent evt) -> this.propertyChange(evt));
        vistaCita.getBtnBuscar().addActionListener(e -> cargarListaBeneficiarias(vistaCita.getTxt_NombreVictima().getText()));
        vistaCita.getTbl_lstBeneficiarias().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarPersonaBeneficiaria();
            }
        });

    }

    public void crearCita() {
        if ((vistaCita.getTxt_codigoVictima().getText() == null)
                || (vistaCita.getTxt_NombreVictima().getText() == null)
                || (vistaCita.getCbxPsicologos().getSelectedIndex() == 0)
                || (vistaCita.getDtc_FechaCita().getDate().getTime() == 0)) {
            JOptionPane.showMessageDialog(null, "No se pudo crear la cita, revise que los datos esten ingresados correctamente y vuelva a intentarlo");

        } else {
            modeloCita = new CitaDB();
            modeloCita.setCita_fecha(fechaBD(vistaCita.getDtc_FechaCita().getDate().getTime()));
            modeloCita.setLlamada_codigo(LlamadaDB.getLlamada_static());
            modeloCita.setPsicologo_codigo(listaPsicologos.get(vistaCita.getCbxPsicologos().getSelectedIndex() - 1).getCodigo_psic());
            modeloCita.setVictima_codigo(Integer.parseInt(vistaCita.getTxt_codigoVictima().getText()));
            //Guardamos la hora
            Date hora = (Date) vistaCita.getSprHoraCita().getValue();
            modeloCita.setCita_hora(new java.sql.Time(hora.getTime()) + "");//Seteamos la hora extrayendo el time de la variable de tipo date que creamos anteriormente
            System.out.println("HORA GUARDADA: " + modeloCita.getCita_hora());

            try {
                if (modeloCita.crearCita()) {
                    JOptionPane.showMessageDialog(null, "La cita fue creada exitosamente");
                    cargaListaCitas(fechaBD(vistaCita.getDtc_FechaCita().getDate().getTime()));
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo crear la cita, revise que los datos esten ingresados correctamente y vuelva a intentarlo");
                }
            } catch (HeadlessException e) {
                System.out.println("ERROOOOOR> " + e);
            }
        }
    }

    public void eliminarCita() {
        modeloCita = new CitaDB();
        int row = vistaCita.getTbl_lstCitas().getSelectedRow();
        if (row >= 0) {
            if (JOptionPane.showConfirmDialog(null,
                    "Esta seguro que desea eliminar esta cita con el codigo " + vistaCita.getTbl_lstCitas().getValueAt(row, 1).toString(),
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                modeloCita.setCita_id(Integer.parseInt(vistaCita.getTbl_lstCitas().getValueAt(row, 1).toString()));
                try {
                    if (modeloCita.eliminarCita() == true) {
                        JOptionPane.showMessageDialog(null, "La cita fue eliminada exitosamente");
                        cargaListaCitas(fechaBD(vistaCita.getDtc_FechaCita().getDate().getTime()));
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar la cita seleccionada");
                    }
                } catch (Exception e) {
                    System.out.println("No se pudo eliminar la cita porque ocurrio el error: " + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se a seleccionado ninguna cita");
        }
    }

    private void cargaListaCitas(java.sql.Date fecha) {

        if (fecha != null) {
            DefaultTableModel modeloTablaCitas = new DefaultTableModel();
            //modeloTablaCitas = (DefaultTableModel) vistaCita.getTbl_lstCitas().getModel();

            modeloTablaCitas.addColumn(obtenerDiaSemana() + " " + vistaCita.getDtc_FechaCita().getCalendar().get(Calendar.DATE) + " de " + obtenerMesAnio() + " del " + vistaCita.getDtc_FechaCita().getCalendar().get(Calendar.YEAR));
            modeloTablaCitas.addColumn("Código de Cita");
            modeloTablaCitas.addColumn("Befeniciaria");

            try {
                List ArrayDatosCitas[] = modeloCita.consultarListaCitas(fechaBD(vistaCita.getDtc_FechaCita().getDate().getTime()));
                List<Cita> listaCitas = ArrayDatosCitas[0];
                List<Persona_llamada> listaPersonasLlamada = ArrayDatosCitas[1];
                int columnas = modeloTablaCitas.getColumnCount();

                for (int i = 0; i < listaCitas.size(); i++) {
                    modeloTablaCitas.addRow(new Object[columnas]);
                    modeloTablaCitas.setValueAt(listaCitas.get(i).getCita_hora(), i, 0);
                    modeloTablaCitas.setValueAt(listaCitas.get(i).getCita_id(), i, 1);
                    modeloTablaCitas.setValueAt(listaPersonasLlamada.get(i).getPer_apellido() + " " + listaPersonasLlamada.get(i).getPer_nombre(), i, 2);

                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e);
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

    private String obtenerMesAnio() {
        Calendar now = vistaCita.getDtc_FechaCita().getCalendar();
        String[] arrayMeses = new String[]{
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
        };
        System.out.println("EL MES ES: " + arrayMeses[now.get(Calendar.MONTH)]);
        String mes = arrayMeses[now.get(Calendar.MONTH)];
        return mes;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        try {
            cargaListaCitas(fechaBD(vistaCita.getDtc_FechaCita().getDate().getTime()));
            System.out.println("ACTUALIZANDOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        } catch (Exception e) {
            System.out.println("error en propertyChange " + e.getMessage());
        }
    }

    public void cargarPsicologos() {
        //DefaultComboBoxModel comboPsicologos = new DefaultComboBoxModel();
        modeloCita = new CitaDB();

        try {
            listaPsicologos = modeloCita.consultarPsicologos();
            if (listaPsicologos.size() >= 0) {
                try {
                    for (int i = 0; i < listaPsicologos.size(); i++) {
                        vistaCita.getCbxPsicologos().addItem(listaPsicologos.get(i).getPersona_nombre() + " " + listaPsicologos.get(i).getPersona_apellido());
                        System.out.println("Se cargo el psicologo: " + listaPsicologos.get(i).getPersona_nombre() + " " + listaPsicologos.get(i).getPersona_apellido());
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
            System.out.println("ERROR AL SACAR LA LISTA DE PSICOLOGOS DE LA BD " + e);
        }
    }

    public void cargarListaBeneficiarias(String buscar) {

        DefaultTableModel modeloTablaBeneficiarias;
        modeloTablaBeneficiarias = (DefaultTableModel) vistaCita.getTbl_lstBeneficiarias().getModel();
        List<Persona_llamada> listaBeneficiarias;
        try {

            if (buscar == null) {
                listaBeneficiarias = modeloCita.consultarBeneficiarias();
                modeloTablaBeneficiarias.setRowCount(0);
            } else {
                listaBeneficiarias = modeloCita.buscarBeneficiarias(buscar);
                modeloTablaBeneficiarias.setRowCount(0);
                vistaCita.getTxt_NombreVictima().requestFocus();
            }

            int columnas = modeloTablaBeneficiarias.getColumnCount();

            if (listaBeneficiarias.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No existen beneficiarias actualmente");
            } else {
                for (int i = 0; i < listaBeneficiarias.size(); i++) {
                    modeloTablaBeneficiarias.addRow(new Object[columnas]);
                    modeloTablaBeneficiarias.setValueAt(listaBeneficiarias.get(i).getPer_codigo(), i, 0);
                    modeloTablaBeneficiarias.setValueAt(listaBeneficiarias.get(i).getPer_cedu_cod(), i, 1);
                    modeloTablaBeneficiarias.setValueAt(listaBeneficiarias.get(i).getPer_nombre(), i, 2);
                    modeloTablaBeneficiarias.setValueAt(listaBeneficiarias.get(i).getPer_apellido(), i, 3);
                }
                vistaCita.getTbl_lstBeneficiarias().setModel(modeloTablaBeneficiarias);
            }

        } catch (Exception e) {
            System.out.println("ERROR al cargar la lista de beneficiarios en la clase ControladorCitas: " + e);
        }
    }

    public void cargarPersonaBeneficiaria() {
        int row = vistaCita.getTbl_lstBeneficiarias().getSelectedRow();
        if (row >= 0) {
            vistaCita.getTxt_codigoVictima().setText(vistaCita.getTbl_lstBeneficiarias().getValueAt(row, 0).toString());
            vistaCita.getTxt_NombreVictima().setText(vistaCita.getTbl_lstBeneficiarias().getValueAt(row, 2).toString() + " " + vistaCita.getTbl_lstBeneficiarias().getValueAt(row, 3).toString());
            
        } else {
            System.out.println("No se selecciono nada: "+row);
        }

    }

}
