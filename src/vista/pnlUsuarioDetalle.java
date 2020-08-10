package vista;

import Tabla.TablaPnlUsuarioDetalle;
import clases.TextPrompt;
import java.awt.event.KeyEvent;
import modelo.Conexion;

public class pnlUsuarioDetalle extends javax.swing.JPanel {

    Conexion conexion = new Conexion();
    TablaPnlUsuarioDetalle tabla = new TablaPnlUsuarioDetalle();

    public pnlUsuarioDetalle() {
        initComponents();
        tabla.cargandoRegistrosUsuario(jTableUsuarios, null);
        TextPrompt p1 = new TextPrompt("Ingrese un texto para buscar.", txtBuscarUsuario);
    }

    public void renderizarTablaUsuario() {
        tabla.cargandoRegistrosUsuario(jTableUsuarios, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarUsuario = new javax.swing.JButton();
        txtBuscarUsuario = new javax.swing.JTextField();

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableUsuarios);

        jLabel1.setText("Buscar:");

        btnBuscarUsuario.setText("Buscar");
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        txtBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarUsuarioKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarUsuario)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscarUsuario)
                    .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        tabla.cargandoRegistrosUsuario(jTableUsuarios, txtBuscarUsuario.getText());
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void txtBuscarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscarUsuario.doClick();
        }
    }//GEN-LAST:event_txtBuscarUsuarioKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField txtBuscarUsuario;
    // End of variables declaration//GEN-END:variables
}
