
package marylove.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class V_Menu extends javax.swing.JFrame {

    public V_Menu() {
        initComponents();
    }

    public JButton getBtnMenu() {
        return btnMenu;
    }

    public void setBtnMenu(JButton btnMenu) {
        this.btnMenu = btnMenu;
    }

    public JButton getBtninf() {
        return btninf;
    }

    public void setBtninf(JButton btninf) {
        this.btninf = btninf;
    }

    public JButton getBtnleg() {
        return btnleg;
    }

    public void setBtnleg(JButton btnleg) {
        this.btnleg = btnleg;
    }

    public JButton getBtnpsico() {
        return btnpsico;
    }

    public void setBtnpsico(JButton btnpsico) {
        this.btnpsico = btnpsico;
    }

    public JButton getBtnsoc() {
        return btnsoc;
    }

    public void setBtnsoc(JButton btnsoc) {
        this.btnsoc = btnsoc;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnCita() {
        return btnCita;
    }

    public void setBtnCita(JButton btnCita) {
        this.btnCita = btnCita;
    }

    public JButton getBtnRegistro() {
        return btnRegistro;
    }

    public void setBtnRegistro(JButton btnRegistro) {
        this.btnRegistro = btnRegistro;
    }

    public JButton getBtnllamada() {
        return btnllamada;
    }

    public void setBtnllamada(JButton btnllamada) {
        this.btnllamada = btnllamada;
    }

    public JLabel getLblinf() {
        return lblinf;
    }

    public void setLblinf(JLabel lblinf) {
        this.lblinf = lblinf;
    }

    public JLabel getLblleg() {
        return lblleg;
    }

    public void setLblleg(JLabel lblleg) {
        this.lblleg = lblleg;
    }

    public JLabel getLblpsico() {
        return lblpsico;
    }

    public void setLblpsico(JLabel lblpsico) {
        this.lblpsico = lblpsico;
    }

    public JLabel getLblsoc() {
        return lblsoc;
    }

    public void setLblsoc(JLabel lblsoc) {
        this.lblsoc = lblsoc;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnllamada = new javax.swing.JButton();
        btnCita = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnpsico = new javax.swing.JButton();
        btnsoc = new javax.swing.JButton();
        btnleg = new javax.swing.JButton();
        btninf = new javax.swing.JButton();
        lblsoc = new javax.swing.JLabel();
        lblleg = new javax.swing.JLabel();
        lblinf = new javax.swing.JLabel();
        lblpsico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnllamada.setBackground(new java.awt.Color(255, 255, 255));
        btnllamada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/llamada.png"))); // NOI18N
        btnllamada.setToolTipText("<html>\n<head>\n<style>\n#contenido{\nbackground: white;\ncolor: black;\n}\n</style>\n</head>\n<body  >\n<div id='contenido'>\n<FONT size=5>\n<font FACE=\"times new roman\">LLAMADA</FONT>\n</div>\n</body>\n</html>");
        btnllamada.setBorder(null);
        btnllamada.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/llamada2.png"))); // NOI18N
        btnllamada.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/llamada2.png"))); // NOI18N
        btnllamada.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/llamada2.png"))); // NOI18N
        btnllamada.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnCita.setBackground(new java.awt.Color(255, 255, 255));
        btnCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calendario3.png"))); // NOI18N
        btnCita.setToolTipText("<html>\n<head>\n<style>\n#contenido{\nbackground: white;\ncolor: black;\n}\n</style>\n</head>\n<body  >\n<div id='contenido'>\n<FONT size=5>\n<font FACE=\"times new roman\">CITA</FONT>\n</div>\n</body>\n</html>");
        btnCita.setAutoscrolls(true);
        btnCita.setBorder(null);
        btnCita.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCita.setMaximumSize(new java.awt.Dimension(80, 41));
        btnCita.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calnedario2.png"))); // NOI18N
        btnCita.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calnedario2.png"))); // NOI18N
        btnCita.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calnedario2.png"))); // NOI18N
        btnCita.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitaActionPerformed(evt);
            }
        });

        btnMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/menu1.png"))); // NOI18N
        btnMenu.setText("MENU");
        btnMenu.setBorder(null);
        btnMenu.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconoMenu.png"))); // NOI18N
        btnMenu.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconoMenu.png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar2.png"))); // NOI18N
        btnBuscar.setToolTipText("<html>\n<head>\n<style>\n#contenido{\nbackground: white;\ncolor: black;\n}\n</style>\n</head>\n<body  >\n<div id='contenido'>\n<FONT size=5>\n<font FACE=\"times new roman\">BUSCAR</FONT>\n</div>\n</body>\n</html>");
        btnBuscar.setBorder(null);
        btnBuscar.setMargin(new java.awt.Insets(2, 0, 2, 25));
        btnBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar1.png"))); // NOI18N
        btnBuscar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar1.png"))); // NOI18N
        btnBuscar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar1.png"))); // NOI18N
        btnBuscar.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnRegistro.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/registro2.png"))); // NOI18N
        btnRegistro.setToolTipText("<html>\n<head>\n<style>\n#contenido{\nbackground: white;\ncolor: black;\n}\n</style>\n</head>\n<body  >\n<div id='contenido'>\n<FONT size=5>\n<font FACE=\"times new roman\">REGISTRO</FONT>\n</div>\n</body>\n</html>");
        btnRegistro.setBorder(null);
        btnRegistro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/registro.png"))); // NOI18N
        btnRegistro.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/registro.png"))); // NOI18N
        btnRegistro.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/registro.png"))); // NOI18N
        btnRegistro.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        txtBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 2, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCita, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnllamada, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btnllamada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegistro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(182, 2297));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(180, 2297));

        btnpsico.setBackground(new java.awt.Color(255, 255, 255));
        btnpsico.setText("PSICOLOGIA");
        btnpsico.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 2, true));

        btnsoc.setBackground(new java.awt.Color(255, 255, 255));
        btnsoc.setText("TRABAJO SOCIAL");
        btnsoc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 2, true));

        btnleg.setBackground(new java.awt.Color(255, 255, 255));
        btnleg.setText("LEGAL");
        btnleg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 2, true));

        btninf.setBackground(new java.awt.Color(255, 255, 255));
        btninf.setText("INFANTO JUVENIL");
        btninf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 2, true));

        lblsoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/trabajo social(3).png"))); // NOI18N

        lblleg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/legal(2).png"))); // NOI18N

        lblinf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/infanto(1).png"))); // NOI18N

        lblpsico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/psicologia(5).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblpsico, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnpsico, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblsoc)
            .addComponent(btnsoc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblleg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnleg, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblinf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btninf, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblpsico, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnpsico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblsoc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnsoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblleg, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnleg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblinf, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btninf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCitaActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistroActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCita;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btninf;
    private javax.swing.JButton btnleg;
    private javax.swing.JButton btnllamada;
    private javax.swing.JButton btnpsico;
    private javax.swing.JButton btnsoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblinf;
    private javax.swing.JLabel lblleg;
    private javax.swing.JLabel lblpsico;
    private javax.swing.JLabel lblsoc;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
