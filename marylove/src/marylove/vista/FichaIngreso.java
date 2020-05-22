
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FichaIngreso extends javax.swing.JFrame {

    public FichaIngreso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dlgRegistro = new javax.swing.JDialog();
        pnlFichaIngre1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnlDormitorio1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDorRef = new javax.swing.JTable();
        pnlArticulosBeneficiaria1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblArticulosBeneficiaria1 = new javax.swing.JTable();
        pnlArticulosFundacion1 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblArticulosFundacion1 = new javax.swing.JTable();
        pnlHijos1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblHijos1 = new javax.swing.JTable();
        btnDlgActualizar = new javax.swing.JButton();
        txtDlgBusar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        pnlFichaIngre = new javax.swing.JPanel();
        pnlCabecera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombresApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlDormitorio = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDormitorio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaReferida = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCodigoIngreso = new javax.swing.JLabel();
        pnlHijos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHijos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnIngresarHij = new javax.swing.JButton();
        lblCodHijoa = new javax.swing.JLabel();
        pnlArticulosBeneficiaria = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnAgregarArticulosVictima = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblArticulosBeneficiaria = new javax.swing.JTable();
        lblCant = new javax.swing.JLabel();
        lblCodigoEntBenef = new javax.swing.JLabel();
        pnlArticulosFundacion = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblArticulosFundacion = new javax.swing.JTable();
        btnAgregarArticulosFundacion = new javax.swing.JButton();
        lblCant1 = new javax.swing.JLabel();
        lblCodigoArtEntFund = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnVerRegistros = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        tblDorRef.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cédula", "Nombre Apellido", "Dormitorio", "Referido por: ", "Fecha Ingreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblDorRef);

        javax.swing.GroupLayout pnlDormitorio1Layout = new javax.swing.GroupLayout(pnlDormitorio1);
        pnlDormitorio1.setLayout(pnlDormitorio1Layout);
        pnlDormitorio1Layout.setHorizontalGroup(
            pnlDormitorio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        pnlDormitorio1Layout.setVerticalGroup(
            pnlDormitorio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab(" (1) Dormitorio /Referida", pnlDormitorio1);

        tblArticulosBeneficiaria1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Nombre Apellido", "Articulo", "Cantidad", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblArticulosBeneficiaria1);

        javax.swing.GroupLayout pnlArticulosBeneficiaria1Layout = new javax.swing.GroupLayout(pnlArticulosBeneficiaria1);
        pnlArticulosBeneficiaria1.setLayout(pnlArticulosBeneficiaria1Layout);
        pnlArticulosBeneficiaria1Layout.setHorizontalGroup(
            pnlArticulosBeneficiaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        pnlArticulosBeneficiaria1Layout.setVerticalGroup(
            pnlArticulosBeneficiaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosBeneficiaria1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("(2) Artículos que entrega la beneficiaria ", pnlArticulosBeneficiaria1);

        tblArticulosFundacion1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Nombre Apellido", "Articulo", "Cantidad", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblArticulosFundacion1);
        if (tblArticulosFundacion1.getColumnModel().getColumnCount() > 0) {
            tblArticulosFundacion1.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout pnlArticulosFundacion1Layout = new javax.swing.GroupLayout(pnlArticulosFundacion1);
        pnlArticulosFundacion1.setLayout(pnlArticulosFundacion1Layout);
        pnlArticulosFundacion1Layout.setHorizontalGroup(
            pnlArticulosFundacion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        pnlArticulosFundacion1Layout.setVerticalGroup(
            pnlArticulosFundacion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("(3) Artículos que entrega la fundación ", pnlArticulosFundacion1);

        tblHijos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombres Apellidos", "Fecha nacimiento", "Edad", "Parentesco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblHijos1);

        javax.swing.GroupLayout pnlHijos1Layout = new javax.swing.GroupLayout(pnlHijos1);
        pnlHijos1.setLayout(pnlHijos1Layout);
        pnlHijos1Layout.setHorizontalGroup(
            pnlHijos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        pnlHijos1Layout.setVerticalGroup(
            pnlHijos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab(" (4) Hijos /Hijas o personas con las que Ingresa", pnlHijos1);

        btnDlgActualizar.setText("Actulizar");

        jLabel11.setText("Buscar: ");

        javax.swing.GroupLayout pnlFichaIngre1Layout = new javax.swing.GroupLayout(pnlFichaIngre1);
        pnlFichaIngre1.setLayout(pnlFichaIngre1Layout);
        pnlFichaIngre1Layout.setHorizontalGroup(
            pnlFichaIngre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFichaIngre1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDlgBusar, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDlgActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane2)
        );
        pnlFichaIngre1Layout.setVerticalGroup(
            pnlFichaIngre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaIngre1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFichaIngre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDlgActualizar)
                    .addComponent(txtDlgBusar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2))
        );

        javax.swing.GroupLayout dlgRegistroLayout = new javax.swing.GroupLayout(dlgRegistro.getContentPane());
        dlgRegistro.getContentPane().setLayout(dlgRegistroLayout);
        dlgRegistroLayout.setHorizontalGroup(
            dlgRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFichaIngre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgRegistroLayout.setVerticalGroup(
            dlgRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFichaIngre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ficha de Ingreso");

        jLabel2.setText("Nombres y Apellidos: ");

        jLabel3.setText("Fecha de Ingreso:");

        txtNombresApellidos.setEditable(false);

        jLabel4.setText("Código:");

        txtCodigo.setEditable(false);

        jLabel9.setText("Cedula: ");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(48, 48, 48)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombresApellidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombresApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel5.setText("Dormitorio:");

        jLabel6.setText("Referida por:(Institución, persona acompañante, contactos)");

        txaReferida.setColumns(20);
        txaReferida.setLineWrap(true);
        txaReferida.setRows(5);
        txaReferida.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txaReferida);

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        lblCodigoIngreso.setText("Codigo: ");

        javax.swing.GroupLayout pnlDormitorioLayout = new javax.swing.GroupLayout(pnlDormitorio);
        pnlDormitorio.setLayout(pnlDormitorioLayout);
        pnlDormitorioLayout.setHorizontalGroup(
            pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDormitorioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDormitorioLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(271, 271, 271))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDormitorioLayout.createSequentialGroup()
                        .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDormitorioLayout.createSequentialGroup()
                                .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDormitorioLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDormitorio, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDormitorioLayout.createSequentialGroup()
                                        .addComponent(btnCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGuardar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCodigoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        pnlDormitorioLayout.setVerticalGroup(
            pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDormitorioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDormitorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoIngreso))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab(" (1) Dormitorio /Referida", pnlDormitorio);

        tblHijos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombres", "Apellidos", "Fecha nacimiento", "Edad", "Parentesco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblHijos);
        if (tblHijos.getColumnModel().getColumnCount() > 0) {
            tblHijos.getColumnModel().getColumn(2).setHeaderValue("Apellidos");
        }

        jLabel7.setText("Hijos/ Hijas o Personas con las que ingresa");

        btnIngresarHij.setText("Ingresar ");

        lblCodHijoa.setText("Codigo: ");

        javax.swing.GroupLayout pnlHijosLayout = new javax.swing.GroupLayout(pnlHijos);
        pnlHijos.setLayout(pnlHijosLayout);
        pnlHijosLayout.setHorizontalGroup(
            pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHijosLayout.createSequentialGroup()
                .addGroup(pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHijosLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel7)
                        .addGap(48, 48, 48)
                        .addComponent(lblCodHijoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlHijosLayout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addGroup(pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIngresarHij)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        pnlHijosLayout.setVerticalGroup(
            pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHijosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblCodHijoa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngresarHij)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" (4) Hijos /Hijas o personas con las que Ingresa", pnlHijos);

        jLabel8.setText("Artículos que entrega la beneficiaria");

        btnAgregarArticulosVictima.setText("Agregar Artículos");

        tblArticulosBeneficiaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Articulo", "Cantidad", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblArticulosBeneficiaria);

        lblCant.setText(" Cantidad");

        lblCodigoEntBenef.setText("Codigo: ");

        javax.swing.GroupLayout pnlArticulosBeneficiariaLayout = new javax.swing.GroupLayout(pnlArticulosBeneficiaria);
        pnlArticulosBeneficiaria.setLayout(pnlArticulosBeneficiariaLayout);
        pnlArticulosBeneficiariaLayout.setHorizontalGroup(
            pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosBeneficiariaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlArticulosBeneficiariaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(32, 32, 32)
                        .addComponent(btnAgregarArticulosVictima)
                        .addGap(129, 129, 129)
                        .addComponent(lblCodigoEntBenef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblCant, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnlArticulosBeneficiariaLayout.setVerticalGroup(
            pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosBeneficiariaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnAgregarArticulosVictima)
                    .addComponent(lblCodigoEntBenef))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(lblCant))
        );

        jTabbedPane1.addTab("(2) Artículos que entrega la beneficiaria ", pnlArticulosBeneficiaria);

        jLabel10.setText("Artículos que entrega la beneficiaria");

        tblArticulosFundacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Articulo", "Cantidad", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblArticulosFundacion);

        btnAgregarArticulosFundacion.setText("Agregar Artículos");

        lblCant1.setText("Total: ");

        lblCodigoArtEntFund.setText("Codigo: ");

        javax.swing.GroupLayout pnlArticulosFundacionLayout = new javax.swing.GroupLayout(pnlArticulosFundacion);
        pnlArticulosFundacion.setLayout(pnlArticulosFundacionLayout);
        pnlArticulosFundacionLayout.setHorizontalGroup(
            pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(32, 32, 32)
                        .addComponent(btnAgregarArticulosFundacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCodigoArtEntFund, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCant1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnlArticulosFundacionLayout.setVerticalGroup(
            pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btnAgregarArticulosFundacion)
                    .addComponent(lblCodigoArtEntFund))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCant1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("(3) Artículos que entrega la fundación ", pnlArticulosFundacion);

        btnActualizar.setText("Actulizar");

        btnVerRegistros.setText("Ver Registros");

        javax.swing.GroupLayout pnlFichaIngreLayout = new javax.swing.GroupLayout(pnlFichaIngre);
        pnlFichaIngre.setLayout(pnlFichaIngreLayout);
        pnlFichaIngreLayout.setHorizontalGroup(
            pnlFichaIngreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaIngreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFichaIngreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFichaIngreLayout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFichaIngreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerRegistros)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlFichaIngreLayout.setVerticalGroup(
            pnlFichaIngreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaIngreLayout.createSequentialGroup()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(pnlFichaIngreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnVerRegistros))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFichaIngre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFichaIngre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JDialog getDlgRegistro() {
        return dlgRegistro;
    }

    public void setDlgRegistro(JDialog dlgRegistro) {
        this.dlgRegistro = dlgRegistro;
    }

    public JTable getTblArticulosFundacion1() {
        return tblArticulosFundacion1;
    }

    public void setTblArticulosFundacion1(JTable tblArticulosFundacion1) {
        this.tblArticulosFundacion1 = tblArticulosFundacion1;
    }

    public JButton getBtnDlgActualizar() {
        return btnDlgActualizar;
    }

    public void setBtnDlgActualizar(JButton btnDlgActualizar) {
        this.btnDlgActualizar = btnDlgActualizar;
    }

    public JButton getBtnVerRegistros() {
        return btnVerRegistros;
    }

    public void setBtnVerRegistros(JButton btnVerRegistros) {
        this.btnVerRegistros = btnVerRegistros;
    }

    public JTable getTblArticulosBeneficiaria1() {
        return tblArticulosBeneficiaria1;
    }

    public void setTblArticulosBeneficiaria1(JTable tblArticulosBeneficiaria1) {
        this.tblArticulosBeneficiaria1 = tblArticulosBeneficiaria1;
    }

    public JTable getTblDorRef() {
        return tblDorRef;
    }

    public void setTblDorRef(JTable tblDorRef) {
        this.tblDorRef = tblDorRef;
    }

    public JTable getTblHijos1() {
        return tblHijos1;
    }

    public void setTblHijos1(JTable tblHijos1) {
        this.tblHijos1 = tblHijos1;
    }

    public JTextField getTxtDlgBusar() {
        return txtDlgBusar;
    }

    public void setTxtDlgBusar(JTextField txtDlgBusar) {
        this.txtDlgBusar = txtDlgBusar;
    }

    public JPanel getPnlFichaIngre() {
        return pnlFichaIngre;
    }

    public void setPnlFichaIngre(JPanel pnlFichaIngre) {
        this.pnlFichaIngre = pnlFichaIngre;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JLabel getLblCodHijoa() {
        return lblCodHijoa;
    }

    public void setLblCodHijoa(JLabel lblCodHijoa) {
        this.lblCodHijoa = lblCodHijoa;
    }

    public JLabel getLblCodigoArtEntFund() {
        return lblCodigoArtEntFund;
    }

    public void setLblCodigoArtEntFund(JLabel lblCodigoArtEntFund) {
        this.lblCodigoArtEntFund = lblCodigoArtEntFund;
    }

    public JLabel getLblCodigoEntBenef() {
        return lblCodigoEntBenef;
    }

    public void setLblCodigoEntBenef(JLabel lblCodigoEntBenef) {
        this.lblCodigoEntBenef = lblCodigoEntBenef;
    }

    public JLabel getLblCodigoIngreso() {
        return lblCodigoIngreso;
    }

    public void setLblCodigoIngreso(JLabel lblCodigoIngreso) {
        this.lblCodigoIngreso = lblCodigoIngreso;
    }

    public JDateChooser getJdcFecha() {
        return jdcFecha;
    }

    public void setJdcFecha(JDateChooser jdcFecha) {
        this.jdcFecha = jdcFecha;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JButton getBtnIngresarHij() {
        return btnIngresarHij;
    }

    public void setBtnIngresarHij(JButton btnIngresarHij) {
        this.btnIngresarHij = btnIngresarHij;
    }

    public JLabel getLblCant1() {
        return lblCant1;
    }

    public void setLblCant1(JLabel lblCant1) {
        this.lblCant1 = lblCant1;
    }

    public JLabel getLblCant() {
        return lblCant;
    }

    public void setLblCant(JLabel lblCant) {
        this.lblCant = lblCant;
    }

    public JButton getBtnAgregarArticulosVictima() {
        return btnAgregarArticulosVictima;
    }

    public void setBtnAgregarArticulosVictima(JButton btnAgregarArticulosVictima) {
        this.btnAgregarArticulosVictima = btnAgregarArticulosVictima;
    }


    public JButton getBtnAgregarArticulosFundacion() {
        return btnAgregarArticulosFundacion;
    }

    public void setBtnAgregarArticulosFundacion(JButton btnAgregarArticulosFundacion) {
        this.btnAgregarArticulosFundacion = btnAgregarArticulosFundacion;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JTable getTblArticulosBeneficiaria() {
        return tblArticulosBeneficiaria;
    }

    public void setTblArticulosBeneficiaria(JTable tblArticulosBeneficiaria) {
        this.tblArticulosBeneficiaria = tblArticulosBeneficiaria;
    }

    public JTable getTblArticulosFundacion() {
        return tblArticulosFundacion;
    }

    public void setTblArticulosFundacion(JTable tblArticulosFundacion) {
        this.tblArticulosFundacion = tblArticulosFundacion;
    }

    public JTable getTblHijos() {
        return tblHijos;
    }

    public void setTblHijos(JTable tblHijos) {
        this.tblHijos = tblHijos;
    }

    public JTextArea getTxaReferida() {
        return txaReferida;
    }

    public void setTxaReferida(JTextArea txaReferida) {
        this.txaReferida = txaReferida;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JTextField getTxtDormitorio() {
        return txtDormitorio;
    }

    public void setTxtDormitorio(JTextField txtDormitorio) {
        this.txtDormitorio = txtDormitorio;
    }

    public JTextField getTxtNombresApellidos() {
        return txtNombresApellidos;
    }

    public void setTxtNombresApellidos(JTextField txtNombresApellidos) {
        this.txtNombresApellidos = txtNombresApellidos;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaIngreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarArticulosFundacion;
    private javax.swing.JButton btnAgregarArticulosVictima;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDlgActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIngresarHij;
    private javax.swing.JButton btnVerRegistros;
    private javax.swing.JDialog dlgRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel lblCant;
    private javax.swing.JLabel lblCant1;
    private javax.swing.JLabel lblCodHijoa;
    private javax.swing.JLabel lblCodigoArtEntFund;
    private javax.swing.JLabel lblCodigoEntBenef;
    private javax.swing.JLabel lblCodigoIngreso;
    private javax.swing.JPanel pnlArticulosBeneficiaria;
    private javax.swing.JPanel pnlArticulosBeneficiaria1;
    private javax.swing.JPanel pnlArticulosFundacion;
    private javax.swing.JPanel pnlArticulosFundacion1;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlDormitorio;
    private javax.swing.JPanel pnlDormitorio1;
    private javax.swing.JPanel pnlFichaIngre;
    private javax.swing.JPanel pnlFichaIngre1;
    private javax.swing.JPanel pnlHijos;
    private javax.swing.JPanel pnlHijos1;
    private javax.swing.JTable tblArticulosBeneficiaria;
    private javax.swing.JTable tblArticulosBeneficiaria1;
    private javax.swing.JTable tblArticulosFundacion;
    private javax.swing.JTable tblArticulosFundacion1;
    private javax.swing.JTable tblDorRef;
    private javax.swing.JTable tblHijos;
    private javax.swing.JTable tblHijos1;
    private javax.swing.JTextArea txaReferida;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDlgBusar;
    private javax.swing.JTextField txtDormitorio;
    private javax.swing.JTextField txtNombresApellidos;
    // End of variables declaration//GEN-END:variables
}
