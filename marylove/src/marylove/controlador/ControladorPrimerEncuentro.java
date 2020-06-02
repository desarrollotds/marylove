package marylove.controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.primer_EncuentroDB;
import marylove.DBmodelo.psicologoDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.Plan_de_Vida;
import marylove.models.Primer_encuentro;
import marylove.vista.FichaPrimerEncuentro;

/**
 *
 * @author Usuario
 */
public class ControladorPrimerEncuentro extends Validaciones {

    DefaultTableModel modeloTabEdit;
    private final FichaPrimerEncuentro vista_1encuentro;
    private final primer_EncuentroDB modelo_1encuentro;
    psicologoDB pDB = new psicologoDB();

    public ControladorPrimerEncuentro(FichaPrimerEncuentro vista_1encuentro, primer_EncuentroDB modelo_1encuentro) throws Exception {
        this.vista_1encuentro = vista_1encuentro;
        this.modelo_1encuentro = modelo_1encuentro;
    }

    public void iniciarControl() {

        popTable();
        vista_1encuentro.getTxtNombre().addKeyListener(validarLetras(vista_1encuentro.getTxtNombre()));
        vista_1encuentro.getTxtCodigo().addKeyListener(validarNumeros(vista_1encuentro.getTxtCodigo()));
        vista_1encuentro.getTxtCedula().addKeyListener(validarCedula(vista_1encuentro.getTxtCedula()));
        vista_1encuentro.getBtnGuardar().addActionListener(e -> insertaDatos());
        vista_1encuentro.getBtnCancelar().addActionListener(e -> borrarDatos());
        vista_1encuentro.getTxtCedula().addKeyListener(enter1(vista_1encuentro.getTxtCedula(), vista_1encuentro.getTxtNombre(), vista_1encuentro.getTxtCodigo()));

        Calendar c2 = new GregorianCalendar();
        vista_1encuentro.getDatFechaPrimerEncuentro().setCalendar(c2);

        vista_1encuentro.getBtnRegist1Encuent().addActionListener(e -> AbrirEditarIngresarPrimerEn());
        vista_1encuentro.getBtnActulizartbl().addActionListener(e -> cargarListaEditIngPrimerEncu());
        vista_1encuentro.getBtnOk().addActionListener(e -> EditarBtn());
        vista_1encuentro.getBtnCancelarEdit().addActionListener(e -> botonCancelarJDg(vista_1encuentro.getjDlgEdit()));
        vista_1encuentro.getBtnCanelarRegl().addActionListener(e -> botonCancelarJDg(vista_1encuentro.getjDlgEditTbl()));
        vista_1encuentro.getBtnBuscar1().addActionListener(e -> eventobuscarTexto());
    }

    public void insertaDatos() {
        int cod = vista_1encuentro.getCmbRiesgo().getSelectedIndex();
        if (vista_1encuentro.getTxaEstadoEmocional().getText().equals("")
                || vista_1encuentro.getTxaNivelRiesgo().getText().equals("")
                || vista_1encuentro.getTxaValoracionDaño().getText().equals("")
                || vista_1encuentro.getTxaInquietudes().getText().equals("")
                || cod == 0
                || vista_1encuentro.getJrbProceso().isSelected() == false && vista_1encuentro.getJrbAsesoria().isSelected() == false
                || vista_1encuentro.getJrbSi().isSelected() == false && vista_1encuentro.getJrbNo().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            modelo_1encuentro.setVictima_codigo(Integer.parseInt(vista_1encuentro.getTxtCodigo().getText()));
            modelo_1encuentro.setPstIntCrisis_fecha(obtenerFecha(vista_1encuentro.getDatFechaPrimerEncuentro()));
            controlArea(vista_1encuentro.getTxaEstadoEmocional());
            modelo_1encuentro.setPstIntCrisis_estado_emocional(vista_1encuentro.getTxaEstadoEmocional().getText());
            controlArea(vista_1encuentro.getTxaNivelRiesgo());
            modelo_1encuentro.setPstIntCrisis_nivel_riesgo(vista_1encuentro.getTxaNivelRiesgo().getText());
            controlArea(vista_1encuentro.getTxaValoracionDaño());
            modelo_1encuentro.setPstIntCrisis_valoracionpreliminar(vista_1encuentro.getTxaValoracionDaño().getText());
            String opc = (String) vista_1encuentro.getCmbRiesgo().getSelectedItem();
            if (opc.equals("Si")) {
                modelo_1encuentro.setPstIntCrisis_riesgo_suicida(true);
            }
            if (opc.equals("No")) {
                modelo_1encuentro.setPstIntCrisis_riesgo_suicida(false);
            }
            controlArea(vista_1encuentro.getTxaInquietudes());
            modelo_1encuentro.setPstIntCrisis_puntosReelevantes(vista_1encuentro.getTxaInquietudes().getText());
            if (vista_1encuentro.getJrbSi().isSelected()) {
                modelo_1encuentro.setPstIntCrisis_proceso_psicoterapeutico(true);
            } else if (vista_1encuentro.getJrbNo().isSelected()) {
                modelo_1encuentro.setPstIntCrisis_proceso_psicoterapeutico(false);
            }

            if (vista_1encuentro.getJrbProceso().isSelected()) {
                modelo_1encuentro.setPstIntCrisis_asesoria(true);
            } else if (vista_1encuentro.getJrbAsesoria().isSelected()) {
                modelo_1encuentro.setPstIntCrisis_asesoria(false);
            }

            modelo_1encuentro.setPsicologo_codigo(pDB.verifiUserP(personal_cod));
            try {
                if (modelo_1encuentro.Ingresar_PrimerEncuentro()) {
                    JOptionPane.showMessageDialog(null, "Datos Insertado Correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos\n"
                            + "ERROOOOOR no se puede ingresar los datos debido a que no es Psicologo>");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROOOOOR no se puede ingresar los datos debido a que no es Psicologo> " + e);
            }

        }
    }

    public void borrarDatos() {
        vista_1encuentro.getTxtNombre().setText("");
        vista_1encuentro.getTxtCodigo().setText("");
        vista_1encuentro.getTxtCedula().setText("");
        vista_1encuentro.getTxaEstadoEmocional().setText("");
        vista_1encuentro.getTxaInquietudes().setText("");
        vista_1encuentro.getTxaNivelRiesgo().setText("");
        vista_1encuentro.getTxaValoracionDaño().setText("");
        vista_1encuentro.getTxaNivelRiesgo().setText("");
        vista_1encuentro.getBtngp1().clearSelection();
        vista_1encuentro.getBtngp2().clearSelection();

    }

    public void cancelar(JFrame vista) {
        vista.setVisible(false);
    }

    public void botonCancelarJDg(JDialog canVista) {
        canVista.setVisible(false);
    }

    public void abrirDlgVistas(JDialog dlgVist) {
        dlgVist.setVisible(true);
        dlgVist.setSize(1200, 700);
        dlgVist.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
    }

    public void AbrirEditarIngresarPrimerEn() {
        vista_1encuentro.getjDlgEditTbl().setVisible(true);
        vista_1encuentro.getjDlgEditTbl().setSize(1200, 700);
        vista_1encuentro.getjDlgEditTbl().setLocationRelativeTo(null);
        vista_1encuentro.getjDlgEditTbl().setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        cargarListaEditIngPrimerEncu();
    }

    private void cargarListaEditIngPrimerEncu() {
        int canFilas = vista_1encuentro.getTblEditar().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i > 0) {
                modeloTabEdit.removeRow(i);
            }
        }
        modeloTabEdit = (DefaultTableModel) vista_1encuentro.getTblEditar().getModel();
        List<Primer_encuentro> lista;
        try {
            lista = modelo_1encuentro.listarPrimerEn();
            int columnas = modeloTabEdit.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabEdit.addRow(new Object[columnas]);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPrimer_codigo(), i, 0);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPstIntCrisis_estado_emocional(), i, 3);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPstIntCrisis_nivel_riesgo(), i, 4);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPstIntCrisis_valoracionpreliminar(), i, 5);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).isPstIntCrisis_riesgo_suicida(), i, 6);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPstIntCrisis_puntosReelevantes(), i, 7);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).isPstIntCrisis_proceso_psicoterapeutico(), i, 8);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).isPstIntCrisis_asesoria(), i, 9);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPstIntCrisis_fecha(), i, 10);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPrimerEncuentro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AbrirEditarPlanVid() {
        vista_1encuentro.getjDlgEdit().setVisible(true);
        //820, 532
        vista_1encuentro.getjDlgEdit().setSize(880,540);
        vista_1encuentro.getjDlgEdit().setLocationRelativeTo(null);
        vista_1encuentro.getjDlgEdit().setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());

    }

    public void popTable() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemEliminar = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            Editar();
        });
        itemEliminar.addActionListener((ActionEvent e) -> {
            eliminarPrimerEncu();
        });
        pM.add(itemEdit);
        pM.add(itemEliminar);
        vista_1encuentro.getTblEditar().setComponentPopupMenu(pM);
    }

    public void Editar() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista_1encuentro.getTblEditar().getModel();
        int fsel = vista_1encuentro.getTblEditar().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            //label
            String cod = modeloTabla.getValueAt(vista_1encuentro.getTblEditar().getSelectedRow(), 0).toString();
            //textarea
            String estado_emocional = modeloTabla.getValueAt(vista_1encuentro.getTblEditar().getSelectedRow(), 3).toString();
            String nivel_riesgo = modeloTabla.getValueAt(vista_1encuentro.getTblEditar().getSelectedRow(), 4).toString();
            String valoracionpreliminar = modeloTabla.getValueAt(vista_1encuentro.getTblEditar().getSelectedRow(), 5).toString();
            //combobox
            String riesgo_suicida = modeloTabla.getValueAt(vista_1encuentro.getTblEditar().getSelectedRow(), 6).toString();
            //textarea
            String puntosreelevantes = modeloTabla.getValueAt(vista_1encuentro.getTblEditar().getSelectedRow(), 7).toString();
            //radiobuttons
            String proceso_psicoterapeutico = modeloTabla.getValueAt(vista_1encuentro.getTblEditar().getSelectedRow(), 8).toString();
            String asesoria = modeloTabla.getValueAt(vista_1encuentro.getTblEditar().getSelectedRow(), 9).toString();
            
            vista_1encuentro.getLblCodEdit().setText(cod);
            vista_1encuentro.getTxaEstadoEmocionalEdit().setText(estado_emocional);
            vista_1encuentro.getTxaNivelRiesgoEdit().setText(nivel_riesgo);
            vista_1encuentro.getTxaValoracionDañoEdit().setText(valoracionpreliminar);
            if (riesgo_suicida.equals("true")) {
                vista_1encuentro.getCmbRiesgoEdit().setSelectedIndex(1);
            } else {
                if (riesgo_suicida.equals("false")) {
                    vista_1encuentro.getCmbRiesgoEdit().setSelectedIndex(2);
                }
            }
            vista_1encuentro.getTxaInquietudesEdit().setText(puntosreelevantes);
            //valor traido de la base a la ventana para la editaci
            if (proceso_psicoterapeutico.equals("true")) {
                vista_1encuentro.getJrbSiEdit().setSelected(true);               
            }else {
                if (proceso_psicoterapeutico.equals("false")) {
                    vista_1encuentro.getJrbNoEdit().setSelected(true);
                }
            }
            if (asesoria.equals("true")) {
                vista_1encuentro.getJrbProcesoEdit().setSelected(true);               
            }else {
                if (asesoria.equals("false")) {
                    vista_1encuentro.getJrbAsesoriaEdit().setSelected(true);
                }
            }

            vista_1encuentro.getjDlgEdit().setTitle("Editar Primer Encuentro");
            AbrirEditarPlanVid();
        }
    }

    public void EditarBtn() {
        modelo_1encuentro.setPrimer_codigo(Integer.parseInt(vista_1encuentro.getLblCodEdit().getText()));
        modelo_1encuentro.setPstIntCrisis_estado_emocional(vista_1encuentro.getTxaEstadoEmocionalEdit().getText());
        modelo_1encuentro.setPstIntCrisis_nivel_riesgo(vista_1encuentro.getTxaNivelRiesgoEdit().getText());
        modelo_1encuentro.setPstIntCrisis_valoracionpreliminar(vista_1encuentro.getTxaValoracionDañoEdit().getText());
        String op = (String) vista_1encuentro.getCmbRiesgoEdit().getSelectedItem();
        if (op.equals("Si")) {
            modelo_1encuentro.setPstIntCrisis_riesgo_suicida(true);
        }
        if (op.equals("No")) {
            modelo_1encuentro.setPstIntCrisis_riesgo_suicida(false);
        }
        modelo_1encuentro.setPstIntCrisis_puntosReelevantes(vista_1encuentro.getTxaInquietudesEdit().getText());
        if (vista_1encuentro.getJrbSiEdit().isSelected()) {
            modelo_1encuentro.setPstIntCrisis_proceso_psicoterapeutico(true);
        } else if (vista_1encuentro.getJrbNoEdit().isSelected()) {
            modelo_1encuentro.setPstIntCrisis_proceso_psicoterapeutico(false);
        }

        if (vista_1encuentro.getJrbProcesoEdit().isSelected()) {
            modelo_1encuentro.setPstIntCrisis_asesoria(true);
        } else if (vista_1encuentro.getJrbAsesoriaEdit().isSelected()) {
            modelo_1encuentro.setPstIntCrisis_asesoria(false);
        }

        if (modelo_1encuentro.actualizar1Encuent()) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            vista_1encuentro.getjDlgEdit().setVisible(false);
            cargarListaEditIngPrimerEncu();

            vista_1encuentro.getTxaEstadoEmocionalEdit().setText("");
            vista_1encuentro.getTxaInquietudesEdit().setText("");
            vista_1encuentro.getTxaNivelRiesgoEdit().setText("");
            vista_1encuentro.getTxaValoracionDañoEdit().setText("");
            vista_1encuentro.getTxaNivelRiesgoEdit().setText("");
            vista_1encuentro.getBtngp1EditProcesoyAcesoria().clearSelection();
            vista_1encuentro.getBtngp2EditAcogida().clearSelection();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");
        }
    }

    public void eventobuscarTexto() {
        System.out.println("buscando");
        int canFilas = vista_1encuentro.getTblEditar().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabEdit.removeRow(i);
        }

        modeloTabEdit = (DefaultTableModel) vista_1encuentro.getTblEditar().getModel();
        List<Primer_encuentro> lista;
        try {
            lista = modelo_1encuentro.buscarTexto1Encuent(vista_1encuentro.getTxtBuscar().getText().toUpperCase());
            System.out.println("letra: " + vista_1encuentro.getTxtBuscar().getText().toUpperCase());
            int columnas = modeloTabEdit.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabEdit.addRow(new Object[columnas]);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPrimer_codigo(), i, 0);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPstIntCrisis_estado_emocional(), i, 3);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPstIntCrisis_nivel_riesgo(), i, 4);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPstIntCrisis_valoracionpreliminar(), i, 5);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).isPstIntCrisis_riesgo_suicida(), i, 6);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPstIntCrisis_puntosReelevantes(), i, 7);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).isPstIntCrisis_proceso_psicoterapeutico(), i, 8);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).isPstIntCrisis_asesoria(), i, 9);
                vista_1encuentro.getTblEditar().setValueAt(lista.get(i).getPstIntCrisis_fecha(), i, 10);
            }
            if (vista_1encuentro.getTxtBuscar().getText().length() == 0) {
                cargarListaEditIngPrimerEncu();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorPlandeVida.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    //!!!!!!!!!!!!!--Eliminar Primer Encuentro dando un estado 'd'--!!!!!!!!!!!!!!!!!
    //borrado logico
    private void eliminarPrimerEncu() {
        int fsel = vista_1encuentro.getTblEditar().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vista_1encuentro.getTblEditar().getModel();
                String cod = modeloTabla.getValueAt(vista_1encuentro.getTblEditar().getSelectedRow(), 0).toString();
                modelo_1encuentro.setPrimer_codigo(Integer.parseInt(cod));
                System.out.println(cod);
                if (modelo_1encuentro.eliminar1Enc()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    cargarListaEditIngPrimerEncu();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }
    }

}
