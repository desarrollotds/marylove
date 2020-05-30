
package marylove.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FichaEgreso extends javax.swing.JFrame {

    public FichaEgreso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogIngDirecc = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        Calle = new javax.swing.JLabel();
        jdxtCalle = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jdtxtInterseccion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jdtxtNumCasa = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jdtxtBarrio = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jdtxtParroquia = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jdtxtCiudad = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jdtxtReferencia = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jdtxtEstado = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jdtxtProvincia = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jdtxtPais = new javax.swing.JTextField();
        jdLblCodigo = new javax.swing.JLabel();
        jdBtnCancelar = new javax.swing.JButton();
        jdBtnEditar = new javax.swing.JButton();
        jdBtnGuardar = new javax.swing.JButton();
        dlgAmpliarImg = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        lblImgApliada = new javax.swing.JLabel();
        dlgRegistros = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDlgRegistros = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnDlgCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        dlgEditar = new javax.swing.JDialog();
        panelEgreso1 = new javax.swing.JPanel();
        pnlCabecera1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtNombresApellidos1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        txtCedula1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        dtcFechEgreso1 = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaSituacion1 = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtTelefonoBeneficiaria1 = new javax.swing.JTextField();
        txtCelular1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtTelefonoReferencia1 = new javax.swing.JTextField();
        btnEditarEgreso = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        lblCodigo1 = new javax.swing.JLabel();
        cbxParentesco1 = new javax.swing.JComboBox<>();
        lblImg1 = new javax.swing.JLabel();
        btnIngreImg1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        txtProvincia1 = new javax.swing.JTextField();
        txtCanton1 = new javax.swing.JTextField();
        txtDireccion1 = new javax.swing.JTextField();
        panelEgreso = new javax.swing.JPanel();
        pnlCabecera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombresApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        dtcFechEgreso = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaSituacion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefonoBeneficiaria = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTelefonoReferencia = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        cbxParentesco = new javax.swing.JComboBox<>();
        lblImg = new javax.swing.JLabel();
        btnIngreImg = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtProvincia = new javax.swing.JTextField();
        txtCanton = new javax.swing.JTextField();
        btnVerReg = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();

        jDialogIngDirecc.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("Ingresar Direccion");

        Calle.setText("Calle");

        jLabel18.setText("Intersección");

        jLabel19.setText("Número de casa");

        jLabel20.setText("Barrio");

        jLabel21.setText("Parroquia");

        jLabel22.setText("Ciudad");

        jLabel23.setText("Referencia");

        jLabel24.setText("Estado");

        jLabel25.setText("Provincia: ");

        jLabel26.setText("País");

        jdtxtPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdtxtPaisActionPerformed(evt);
            }
        });

        jdLblCodigo.setText("Codigo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jdLblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Calle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdxtCalle)
                            .addComponent(jdtxtInterseccion)
                            .addComponent(jdtxtNumCasa)
                            .addComponent(jdtxtBarrio)
                            .addComponent(jdtxtParroquia)
                            .addComponent(jdtxtCiudad)
                            .addComponent(jdtxtReferencia)
                            .addComponent(jdtxtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jdtxtProvincia)
                            .addComponent(jdtxtPais))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jdLblCodigo)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Calle)
                    .addComponent(jdxtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jdtxtInterseccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jdtxtNumCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jdtxtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jdtxtParroquia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jdtxtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jdtxtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jdtxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jdtxtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jdtxtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jDialogIngDirecc.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jdBtnCancelar.setText("Cancelar");
        jDialogIngDirecc.getContentPane().add(jdBtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        jdBtnEditar.setText("Editar");
        jDialogIngDirecc.getContentPane().add(jdBtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, -1, -1));

        jdBtnGuardar.setText("Guardar");
        jdBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdBtnGuardarActionPerformed(evt);
            }
        });
        jDialogIngDirecc.getContentPane().add(jdBtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImgApliada, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImgApliada, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dlgAmpliarImgLayout = new javax.swing.GroupLayout(dlgAmpliarImg.getContentPane());
        dlgAmpliarImg.getContentPane().setLayout(dlgAmpliarImgLayout);
        dlgAmpliarImgLayout.setHorizontalGroup(
            dlgAmpliarImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgAmpliarImgLayout.setVerticalGroup(
            dlgAmpliarImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblDlgRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Nombre Apellido", "Situacion en la que Ingresa", "Teléfono", "Celular", "Provincia", "Cantón", "Persona referencia", "Teléfono referencia", "Direccion", "Fecha egreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDlgRegistros);

        jLabel27.setText("Buscar: ");

        jLabel28.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnActualizar.setText("Actualizar");

        btnDlgCancelar.setText("Cancelar");

        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDlgCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnDlgCancelar)
                        .addContainerGap())
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout dlgRegistrosLayout = new javax.swing.GroupLayout(dlgRegistros.getContentPane());
        dlgRegistros.getContentPane().setLayout(dlgRegistrosLayout);
        dlgRegistrosLayout.setHorizontalGroup(
            dlgRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgRegistrosLayout.setVerticalGroup(
            dlgRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel13.setText("Editar Ficha de Egreso");

        jLabel29.setText("Nombres y Apellidos: ");

        jLabel30.setText("Fecha de Egreso:");

        txtNombresApellidos1.setEditable(false);

        jLabel31.setText("Código:");

        txtCodigo1.setEditable(false);

        txtCedula1.setEditable(false);

        jLabel32.setText("Cédula: ");

        javax.swing.GroupLayout pnlCabecera1Layout = new javax.swing.GroupLayout(pnlCabecera1);
        pnlCabecera1.setLayout(pnlCabecera1Layout);
        pnlCabecera1Layout.setHorizontalGroup(
            pnlCabecera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabecera1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCabecera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlCabecera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedula1)
                    .addComponent(txtNombresApellidos1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addGap(97, 97, 97)
                .addGroup(pnlCabecera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(pnlCabecera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtcFechEgreso1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txtCodigo1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabecera1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(270, 270, 270))
        );
        pnlCabecera1Layout.setVerticalGroup(
            pnlCabecera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabecera1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCabecera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(pnlCabecera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabecera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jLabel29)
                        .addComponent(txtNombresApellidos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dtcFechEgreso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel33.setText("Situación en la que egresa:");

        txaSituacion1.setColumns(20);
        txaSituacion1.setRows(5);
        jScrollPane3.setViewportView(txaSituacion1);

        jLabel34.setText("Datos generales para localizar al grupo familiar que egresa");

        jLabel35.setText("Teléfono:");

        jLabel36.setText("Celular:");

        jLabel37.setText("Dirección del nuevo Domicilio:");

        jLabel38.setText("Cantón:");

        jLabel39.setText("Provincia:");

        jLabel40.setText("Dirección:");

        jLabel41.setText("Parentesco:");

        jLabel42.setText("Teléfono:");

        btnEditarEgreso.setText("Editar");

        btnCancelar1.setText("Cancelar");

        lblCodigo1.setText("Codigo: ");

        cbxParentesco1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblImg1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagen", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnIngreImg1.setText("+");

        txtDireccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccion1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                        .addComponent(txtTelefonoBeneficiaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel39)
                                            .addComponent(jLabel40))
                                        .addGap(77, 77, 77)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtProvincia1)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(btnIngreImg1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtDireccion1))))
                                .addGap(151, 151, 151)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel41)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbxParentesco1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCanton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 295, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(376, 499, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel42)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTelefonoReferencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addGap(119, 119, 119)
                                        .addComponent(lblImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar1)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarEgreso)))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(lblCodigo1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(txtTelefonoBeneficiaria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38)
                    .addComponent(txtProvincia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCanton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 29, Short.MAX_VALUE)
                        .addComponent(btnIngreImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(cbxParentesco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtTelefonoReferencia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarEgreso)
                    .addComponent(btnCancelar1))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout panelEgreso1Layout = new javax.swing.GroupLayout(panelEgreso1);
        panelEgreso1.setLayout(panelEgreso1Layout);
        panelEgreso1Layout.setHorizontalGroup(
            panelEgreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEgreso1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEgreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEgreso1Layout.setVerticalGroup(
            panelEgreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEgreso1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgEditarLayout = new javax.swing.GroupLayout(dlgEditar.getContentPane());
        dlgEditar.getContentPane().setLayout(dlgEditarLayout);
        dlgEditarLayout.setHorizontalGroup(
            dlgEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEgreso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgEditarLayout.setVerticalGroup(
            dlgEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgEditarLayout.createSequentialGroup()
                .addComponent(panelEgreso1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ficha de Egreso");

        jLabel2.setText("Nombres y Apellidos: ");

        jLabel3.setText("Fecha de Egreso:");

        txtNombresApellidos.setEditable(false);

        jLabel4.setText("Código:");

        txtCodigo.setEditable(false);

        jLabel17.setText("Cédula: ");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txtNombresApellidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo)
                    .addComponent(dtcFechEgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNombresApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(dtcFechEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Situación en la que egresa:");

        txaSituacion.setColumns(20);
        txaSituacion.setRows(5);
        jScrollPane1.setViewportView(txaSituacion);

        jLabel6.setText("Datos generales para localizar al grupo familiar que egresa");

        jLabel7.setText("Teléfono:");

        jLabel8.setText("Celular:");

        jLabel9.setText("Dirección del nuevo Domicilio:");

        jLabel10.setText("Cantón:");

        jLabel11.setText("Provincia:");

        jLabel12.setText("Dirección:");

        jLabel14.setText("Parentesco:");

        jLabel15.setText("Teléfono referencia:");

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Limpiar/Cancelar");

        lblCodigo.setText("Codigo: ");

        cbxParentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblImg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagen", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnIngreImg.setText("+");

        btnVerReg.setText("Ver registros");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIngreImg)
                                    .addComponent(txtTelefonoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxParentesco, 0, 250, Short.MAX_VALUE)
                            .addComponent(txtCanton)
                            .addComponent(txtTelefonoBeneficiaria, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVerReg)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblCodigo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefonoBeneficiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(txtCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIngreImg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTelefonoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnVerReg))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout panelEgresoLayout = new javax.swing.GroupLayout(panelEgreso);
        panelEgreso.setLayout(panelEgresoLayout);
        panelEgresoLayout.setHorizontalGroup(
            panelEgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCabecera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelEgresoLayout.setVerticalGroup(
            panelEgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEgresoLayout.createSequentialGroup()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jdBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdBtnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdBtnGuardarActionPerformed

    private void jdtxtPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdtxtPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdtxtPaisActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDireccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccion1ActionPerformed

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnEditarEgreso() {
        return btnEditarEgreso;
    }

    public void setBtnEditarEgreso(JButton btnEditarEgreso) {
        this.btnEditarEgreso = btnEditarEgreso;
    }

    public JButton getBtnCancelar1() {
        return btnCancelar1;
    }

    public void setBtnCancelar1(JButton btnCancelar1) {
        this.btnCancelar1 = btnCancelar1;
    }

    public JButton getBtnIngreImg1() {
        return btnIngreImg1;
    }

    public void setBtnIngreImg1(JButton btnIngreImg1) {
        this.btnIngreImg1 = btnIngreImg1;
    }

    public JComboBox<String> getCbxParentesco1() {
        return cbxParentesco1;
    }

    public void setCbxParentesco1(JComboBox<String> cbxParentesco1) {
        this.cbxParentesco1 = cbxParentesco1;
    }

    public JDialog getDlgEditar() {
        return dlgEditar;
    }

    public void setDlgEditar(JDialog dlgEditar) {
        this.dlgEditar = dlgEditar;
    }

    public JDateChooser getDtcFechEgreso1() {
        return dtcFechEgreso1;
    }

    public void setDtcFechEgreso1(JDateChooser dtcFechEgreso1) {
        this.dtcFechEgreso1 = dtcFechEgreso1;
    }

    public JLabel getLblImg1() {
        return lblImg1;
    }

    public void setLblImg1(JLabel lblImg1) {
        this.lblImg1 = lblImg1;
    }

    public JTextArea getTxaSituacion1() {
        return txaSituacion1;
    }

    public void setTxaSituacion1(JTextArea txaSituacion1) {
        this.txaSituacion1 = txaSituacion1;
    }

    public JTextField getTxtCanton1() {
        return txtCanton1;
    }

    public void setTxtCanton1(JTextField txtCanton1) {
        this.txtCanton1 = txtCanton1;
    }

    public JTextField getTxtCedula1() {
        return txtCedula1;
    }

    public void setTxtCedula1(JTextField txtCedula1) {
        this.txtCedula1 = txtCedula1;
    }

    public JTextField getTxtCelular1() {
        return txtCelular1;
    }

    public void setTxtCelular1(JTextField txtCelular1) {
        this.txtCelular1 = txtCelular1;
    }

    public JTextField getTxtCodigo1() {
        return txtCodigo1;
    }

    public void setTxtCodigo1(JTextField txtCodigo1) {
        this.txtCodigo1 = txtCodigo1;
    }

    public JTextField getTxtDireccion1() {
        return txtDireccion1;
    }

    public void setTxtDireccion1(JTextField txtDireccion1) {
        this.txtDireccion1 = txtDireccion1;
    }

    public JTextField getTxtNombresApellidos1() {
        return txtNombresApellidos1;
    }

    public void setTxtNombresApellidos1(JTextField txtNombresApellidos1) {
        this.txtNombresApellidos1 = txtNombresApellidos1;
    }

    public JTextField getTxtProvincia1() {
        return txtProvincia1;
    }

    public void setTxtProvincia1(JTextField txtProvincia1) {
        this.txtProvincia1 = txtProvincia1;
    }

    public JTextField getTxtTelefonoBeneficiaria1() {
        return txtTelefonoBeneficiaria1;
    }

    public void setTxtTelefonoBeneficiaria1(JTextField txtTelefonoBeneficiaria1) {
        this.txtTelefonoBeneficiaria1 = txtTelefonoBeneficiaria1;
    }

    public JTextField getTxtTelefonoReferencia1() {
        return txtTelefonoReferencia1;
    }

    public void setTxtTelefonoReferencia1(JTextField txtTelefonoReferencia1) {
        this.txtTelefonoReferencia1 = txtTelefonoReferencia1;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTable getTblDlgRegistros() {
        return tblDlgRegistros;
    }

    public void setTblDlgRegistros(JTable tblDlgRegistros) {
        this.tblDlgRegistros = tblDlgRegistros;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnDlgCancelar() {
        return btnDlgCancelar;
    }

    public void setBtnDlgCancelar(JButton btnDlgCancelar) {
        this.btnDlgCancelar = btnDlgCancelar;
    }

    public JButton getBtnVerReg() {
        return btnVerReg;
    }

    public void setBtnVerReg(JButton btnVerReg) {
        this.btnVerReg = btnVerReg;
    }

    public JDialog getDlgRegistros() {
        return dlgRegistros;
    }

    public void setDlgRegistros(JDialog dlgRegistros) {
        this.dlgRegistros = dlgRegistros;
    }

    public JTextField getTxtCanton() {
        return txtCanton;
    }

    public void setTxtCanton(JTextField txtCanton) {
        this.txtCanton = txtCanton;
    }

    public JTextField getTxtProvincia() {
        return txtProvincia;
    }

    public void setTxtProvincia(JTextField txtProvincia) {
        this.txtProvincia = txtProvincia;
    }

    public JPanel getPanelEgreso() {
        return panelEgreso;
    }

    public void setPanelEgreso(JPanel panelEgreso) {
        this.panelEgreso = panelEgreso;
    }

    public JLabel getLblImgApliada() {
        return lblImgApliada;
    }

    public void setLblImgApliada(JLabel lblImgApliada) {
        this.lblImgApliada = lblImgApliada;
    }

    public JButton getBtnIngreImg() {
        return btnIngreImg;
    }

    public void setBtnIngreImg(JButton btnIngreImg) {
        this.btnIngreImg = btnIngreImg;
    }

    public JDialog getDlgAmpliarImg() {
        return dlgAmpliarImg;
    }

    public void setDlgAmpliarImg(JDialog dlgAmpliarImg) {
        this.dlgAmpliarImg = dlgAmpliarImg;
    }

    public JLabel getLblImg() {
        return lblImg;
    }

    public void setLblImg(JLabel lblImg) {
        this.lblImg = lblImg;
    }

    public JComboBox<String> getCbxParentesco() {
        return cbxParentesco;
    }

    public void setCbxParentesco(JComboBox<String> cbxParentesco) {
        this.cbxParentesco = cbxParentesco;
    }

    public JLabel getJdLblCodigo() {
        return jdLblCodigo;
    }

    public void setJdLblCodigo(JLabel jdLblCodigo) {
        this.jdLblCodigo = jdLblCodigo;
    }

    public JTextField getJdtxtPais() {
        return jdtxtPais;
    }

    public void setJdtxtPais(JTextField jdtxtPais) {
        this.jdtxtPais = jdtxtPais;
    }

    public JTextField getJdtxtProvincia() {
        return jdtxtProvincia;
    }

    public void setJdtxtProvincia(JTextField jdtxtProvincia) {
        this.jdtxtProvincia = jdtxtProvincia;
    }

    public JLabel getLblCodigo() {
        return lblCodigo;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        this.lblCodigo = lblCodigo;
    }

    

    public JDateChooser getDtcFechEgreso() {
        return dtcFechEgreso;
    }

    public void setDtcFechEgreso(JDateChooser dtcFechEgreso) {
        this.dtcFechEgreso = dtcFechEgreso;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JDialog getjDialogIngDirecc() {
        return jDialogIngDirecc;
    }

    public void setjDialogIngDirecc(JDialog jDialogIngDirecc) {
        this.jDialogIngDirecc = jDialogIngDirecc;
    }

    public JButton getJdBtnCancelar() {
        return jdBtnCancelar;
    }

    public void setJdBtnCancelar(JButton jdBtnCancelar) {
        this.jdBtnCancelar = jdBtnCancelar;
    }

    public JButton getJdBtnEditar() {
        return jdBtnEditar;
    }

    public void setJdBtnEditar(JButton jdBtnEditar) {
        this.jdBtnEditar = jdBtnEditar;
    }

    public JButton getJdBtnGuardar() {
        return jdBtnGuardar;
    }

    public void setJdBtnGuardar(JButton jdBtnGuardar) {
        this.jdBtnGuardar = jdBtnGuardar;
    }

    public JTextField getJdtxtBarrio() {
        return jdtxtBarrio;
    }

    public void setJdtxtBarrio(JTextField jdtxtBarrio) {
        this.jdtxtBarrio = jdtxtBarrio;
    }

    public JTextField getJdtxtCiudad() {
        return jdtxtCiudad;
    }

    public void setJdtxtCiudad(JTextField jdtxtCiudad) {
        this.jdtxtCiudad = jdtxtCiudad;
    }

    public JTextField getJdtxtEstado() {
        return jdtxtEstado;
    }

    public void setJdtxtEstado(JTextField jdtxtEstado) {
        this.jdtxtEstado = jdtxtEstado;
    }

    public JTextField getJdtxtInterseccion() {
        return jdtxtInterseccion;
    }

    public void setJdtxtInterseccion(JTextField jdtxtInterseccion) {
        this.jdtxtInterseccion = jdtxtInterseccion;
    }

    public JTextField getJdtxtNumCasa() {
        return jdtxtNumCasa;
    }

    public void setJdtxtNumCasa(JTextField jdtxtNumCasa) {
        this.jdtxtNumCasa = jdtxtNumCasa;
    }

    public JTextField getJdtxtParroquia() {
        return jdtxtParroquia;
    }

    public void setJdtxtParroquia(JTextField jdtxtParroquia) {
        this.jdtxtParroquia = jdtxtParroquia;
    }

    public JTextField getJdtxtReferencia() {
        return jdtxtReferencia;
    }

    public void setJdtxtReferencia(JTextField jdtxtReferencia) {
        this.jdtxtReferencia = jdtxtReferencia;
    }

    public JPanel getPnlCabecera() {
        return pnlCabecera;
    }

    public void setPnlCabecera(JPanel pnlCabecera) {
        this.pnlCabecera = pnlCabecera;
    }

    public JTextField getTjdxtCalle() {
        return jdxtCalle;
    }

    public void setTjdxtCalle(JTextField tjdxtCalle) {
        this.jdxtCalle = tjdxtCalle;
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
    
    public JTextArea getTxaSituacion() {
        return txaSituacion;
    }

    public void setTxaSituacion(JTextArea txaSituacion) {
        this.txaSituacion = txaSituacion;
    }

    public JTextField getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(JTextField txtCelular) {
        this.txtCelular = txtCelular;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JTextField getTxtNombresApellidos() {
        return txtNombresApellidos;
    }

    public void setTxtNombresApellidos(JTextField txtNombresApellidos) {
        this.txtNombresApellidos = txtNombresApellidos;
    }

    public JTextField getTxtTelefonoBeneficiaria() {
        return txtTelefonoBeneficiaria;
    }

    public void setTxtTelefonoBeneficiaria(JTextField txtTelefonoBeneficiaria) {
        this.txtTelefonoBeneficiaria = txtTelefonoBeneficiaria;
    }

    public JTextField getTxtTelefonoReferencia() {
        return txtTelefonoReferencia;
    }

    public void setTxtTelefonoReferencia(JTextField txtTelefonoReferencia) {
        this.txtTelefonoReferencia = txtTelefonoReferencia;
    }

    public JTextField getJdxtCalle() {
        return jdxtCalle;
    }

    public void setJdxtCalle(JTextField jdxtCalle) {
        this.jdxtCalle = jdxtCalle;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Calle;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnDlgCancelar;
    private javax.swing.JButton btnEditarEgreso;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIngreImg;
    private javax.swing.JButton btnIngreImg1;
    private javax.swing.JButton btnVerReg;
    private javax.swing.JComboBox<String> cbxParentesco;
    private javax.swing.JComboBox<String> cbxParentesco1;
    private javax.swing.JDialog dlgAmpliarImg;
    private javax.swing.JDialog dlgEditar;
    private javax.swing.JDialog dlgRegistros;
    private com.toedter.calendar.JDateChooser dtcFechEgreso;
    private com.toedter.calendar.JDateChooser dtcFechEgreso1;
    private javax.swing.JDialog jDialogIngDirecc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jdBtnCancelar;
    private javax.swing.JButton jdBtnEditar;
    private javax.swing.JButton jdBtnGuardar;
    private javax.swing.JLabel jdLblCodigo;
    private javax.swing.JTextField jdtxtBarrio;
    private javax.swing.JTextField jdtxtCiudad;
    private javax.swing.JTextField jdtxtEstado;
    private javax.swing.JTextField jdtxtInterseccion;
    private javax.swing.JTextField jdtxtNumCasa;
    private javax.swing.JTextField jdtxtPais;
    private javax.swing.JTextField jdtxtParroquia;
    private javax.swing.JTextField jdtxtProvincia;
    private javax.swing.JTextField jdtxtReferencia;
    private javax.swing.JTextField jdxtCalle;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblImg1;
    private javax.swing.JLabel lblImgApliada;
    private javax.swing.JPanel panelEgreso;
    private javax.swing.JPanel panelEgreso1;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlCabecera1;
    private javax.swing.JTable tblDlgRegistros;
    private javax.swing.JTextArea txaSituacion;
    private javax.swing.JTextArea txaSituacion1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCanton;
    private javax.swing.JTextField txtCanton1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedula1;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCelular1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtNombresApellidos;
    private javax.swing.JTextField txtNombresApellidos1;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JTextField txtProvincia1;
    private javax.swing.JTextField txtTelefonoBeneficiaria;
    private javax.swing.JTextField txtTelefonoBeneficiaria1;
    private javax.swing.JTextField txtTelefonoReferencia;
    private javax.swing.JTextField txtTelefonoReferencia1;
    // End of variables declaration//GEN-END:variables
}
