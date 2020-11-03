
package Vista;

import ClasesUtilizadas.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GeneralEdicionView extends javax.swing.JPanel {
    Conexion conexion = new Conexion();
    String inicioCombo = "Seleccione una opción...";


    public GeneralEdicionView() {
        initComponents();
        txtNombre.requestFocus();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        pnlDescripcion = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardarRegistro = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNoAplica = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registro de XXXX");

        jPanel1.setLayout(new java.awt.GridLayout(4, 3, 3, 3));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");
        jPanel1.add(jLabel2);

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        jPanel1.add(txtNombre);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);

        lblDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDescripcion.setText("Descripción:");
        jPanel1.add(lblDescripcion);

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
        });
        jPanel1.add(txtDescripcion);

        javax.swing.GroupLayout pnlDescripcionLayout = new javax.swing.GroupLayout(pnlDescripcion);
        pnlDescripcion.setLayout(pnlDescripcionLayout);
        pnlDescripcionLayout.setHorizontalGroup(
            pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        pnlDescripcionLayout.setVerticalGroup(
            pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        jPanel1.add(pnlDescripcion);

        btnGuardarRegistro.setText("Guardar");
        jPanel2.add(btnGuardarRegistro);

        btnCancelar.setText("Cancelar");
        jPanel2.add(btnCancelar);

        btnNoAplica.setText("No aplica");
        btnNoAplica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoAplicaActionPerformed(evt);
            }
        });
        jPanel2.add(btnNoAplica);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
       
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
       
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnNoAplicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoAplicaActionPerformed
        txtDescripcion.setText("No Aplica");
        txtNombre.setText("No Aplica");
    }//GEN-LAST:event_btnNoAplicaActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDescripcion.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnGuardarRegistro.doClick();
        }
    }//GEN-LAST:event_txtDescripcionKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardarRegistro;
    public javax.swing.JButton btnNoAplica;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JLabel lblDescripcion;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JPanel pnlDescripcion;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
