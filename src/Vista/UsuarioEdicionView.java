package Vista;

import ClasesUtilizadas.Conexion;
import java.awt.event.KeyEvent;

public class UsuarioEdicionView extends javax.swing.JPanel {

    Conexion conexion = new Conexion();
    String inicioCombo = "Seleccione una opción...";

    public UsuarioEdicionView() {
        initComponents();
        txtNombres.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        pnlAreaDependencia = new javax.swing.JPanel();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        pnlDescripcion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardarRegistro = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

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

        lblNombres.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombres.setText("Nombres:");
        jPanel1.add(lblNombres);

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresKeyPressed(evt);
            }
        });
        jPanel1.add(txtNombres);

        javax.swing.GroupLayout pnlAreaDependenciaLayout = new javax.swing.GroupLayout(pnlAreaDependencia);
        pnlAreaDependencia.setLayout(pnlAreaDependenciaLayout);
        pnlAreaDependenciaLayout.setHorizontalGroup(
            pnlAreaDependenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        pnlAreaDependenciaLayout.setVerticalGroup(
            pnlAreaDependenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        jPanel1.add(pnlAreaDependencia);

        lblApellidos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblApellidos.setText("Apellidos:");
        jPanel1.add(lblApellidos);

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosKeyPressed(evt);
            }
        });
        jPanel1.add(txtApellidos);

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Correo Electrónico:");
        jPanel1.add(jLabel1);

        txtCorreoElectronico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoElectronicoKeyPressed(evt);
            }
        });
        jPanel1.add(txtCorreoElectronico);

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

        btnGuardarRegistro.setText("Guardar");
        jPanel2.add(btnGuardarRegistro);

        btnCancelar.setText("Cancelar");
        jPanel2.add(btnCancelar);

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

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed

    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCorreoElectronico.requestFocus();
        }
    }//GEN-LAST:event_txtApellidosKeyPressed

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtApellidos.requestFocus();
        }
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtCorreoElectronicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnGuardarRegistro.doClick();
        }
    }//GEN-LAST:event_txtCorreoElectronicoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardarRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JLabel lblApellidos;
    public javax.swing.JLabel lblNombres;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JPanel pnlAreaDependencia;
    public javax.swing.JPanel pnlDescripcion;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtCorreoElectronico;
    public javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
