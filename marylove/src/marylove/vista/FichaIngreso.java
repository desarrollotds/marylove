
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ficha de Ingreso");

        jLabel2.setText("Nombres y Apellidos: ");

        jLabel3.setText("Fecha de Ingreso:");

        jLabel4.setText("Código:");

        jLabel9.setText("Cedula: ");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNombresApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(2, 2, 2)
                                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombresApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDormitorioLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDormitorioLayout.createSequentialGroup()
                        .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDormitorioLayout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDormitorioLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDormitorio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(382, 382, 382))
                            .addGroup(pnlDormitorioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblCodigoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))))
        );
        pnlDormitorioLayout.setVerticalGroup(
            pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDormitorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigoIngreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDormitorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDormitorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
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

        jLabel7.setText("Hijos/ Hijas o Personas con las que ingresa");

        btnIngresarHij.setText("Ingresar ");

        lblCodHijoa.setText("Codigo: ");

        javax.swing.GroupLayout pnlHijosLayout = new javax.swing.GroupLayout(pnlHijos);
        pnlHijos.setLayout(pnlHijosLayout);
        pnlHijosLayout.setHorizontalGroup(
            pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHijosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlHijosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(284, 284, 284)
                        .addComponent(lblCodHijoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnIngresarHij, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        pnlHijosLayout.setVerticalGroup(
            pnlHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHijosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodHijoa)
                .addGap(2, 2, 2)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngresarHij)
                .addContainerGap(7, Short.MAX_VALUE))
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
                .addGroup(pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(pnlArticulosBeneficiariaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarArticulosVictima)
                        .addGap(143, 143, 143)
                        .addComponent(lblCodigoEntBenef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblCant, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        pnlArticulosBeneficiariaLayout.setVerticalGroup(
            pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosBeneficiariaLayout.createSequentialGroup()
                .addComponent(lblCodigoEntBenef)
                .addGap(1, 1, 1)
                .addGroup(pnlArticulosBeneficiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnAgregarArticulosVictima))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
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
                .addGroup(pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                        .addComponent(lblCant1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarArticulosFundacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCodigoArtEntFund, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        pnlArticulosFundacionLayout.setVerticalGroup(
            pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                .addGroup(pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pnlArticulosFundacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(btnAgregarArticulosFundacion)))
                    .addGroup(pnlArticulosFundacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCodigoArtEntFund)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCant1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("(3) Artículos que entrega la fundación ", pnlArticulosFundacion);

        btnActualizar.setText("Actulizar");

        javax.swing.GroupLayout pnlFichaIngreLayout = new javax.swing.GroupLayout(pnlFichaIngre);
        pnlFichaIngre.setLayout(pnlFichaIngreLayout);
        pnlFichaIngreLayout.setHorizontalGroup(
            pnlFichaIngreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaIngreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFichaIngreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFichaIngreLayout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addComponent(pnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFichaIngreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlFichaIngreLayout.setVerticalGroup(
            pnlFichaIngreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaIngreLayout.createSequentialGroup()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFichaIngre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFichaIngre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIngresarHij;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel lblCant;
    private javax.swing.JLabel lblCant1;
    private javax.swing.JLabel lblCodHijoa;
    private javax.swing.JLabel lblCodigoArtEntFund;
    private javax.swing.JLabel lblCodigoEntBenef;
    private javax.swing.JLabel lblCodigoIngreso;
    private javax.swing.JPanel pnlArticulosBeneficiaria;
    private javax.swing.JPanel pnlArticulosFundacion;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlDormitorio;
    private javax.swing.JPanel pnlFichaIngre;
    private javax.swing.JPanel pnlHijos;
    private javax.swing.JTable tblArticulosBeneficiaria;
    private javax.swing.JTable tblArticulosFundacion;
    private javax.swing.JTable tblHijos;
    private javax.swing.JTextArea txaReferida;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDormitorio;
    private javax.swing.JTextField txtNombresApellidos;
    // End of variables declaration//GEN-END:variables
}
