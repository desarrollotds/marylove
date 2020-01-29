package marylove.vista;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

/** @author Angel Lucero */
public class VistaMenuPrincipal extends javax.swing.JFrame {
    public VistaMenuPrincipal() {
        initComponents();
    }

    public JMenuItem getItmRegisRefer() {
        return itmRegisRefer;
    }

    public void setItmRegisRefer(JMenuItem itmRegisRefer) {
        this.itmRegisRefer = itmRegisRefer;
    }

    public JPanel getPnlPrincipal() {
        return pnlPrincipal;
    }

    public void setPnlPrincipal(JPanel pnlPrincipal) {
        this.pnlPrincipal = pnlPrincipal;
    }

    public JMenuItem getItmLlamada() {
        return itmLlamada;
    }

    public void setItmLlamada(JMenuItem itmLlamada) {
        this.itmLlamada = itmLlamada;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itmRegisRefer = new javax.swing.JMenuItem();
        itmLlamada = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        itmRegisRefer.setText("Registro Referencia");
        itmRegisRefer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegisReferActionPerformed(evt);
            }
        });
        jMenu1.add(itmRegisRefer);

        itmLlamada.setText("Registro Llamada");
        itmLlamada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmLlamadaActionPerformed(evt);
            }
        });
        jMenu1.add(itmLlamada);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmRegisReferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegisReferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itmRegisReferActionPerformed

    private void itmLlamadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmLlamadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itmLlamadaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmLlamada;
    private javax.swing.JMenuItem itmRegisRefer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}