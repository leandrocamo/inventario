
package Vista;

import ClasesUtilizadas.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UbicacionEdicionView extends javax.swing.JPanel {
    Conexion conexion = new Conexion();
    String inicioCombo = "Seleccione una opción...";


    public UbicacionEdicionView() {
        initComponents();
        txtUbicacion.requestFocus();
        cargarComboAreadependencia();
        cbxAreaDependenciaID.setVisible(false);
    }
    public void cargarComboAreadependencia() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "";

        sql = "SELECT * FROM areadependencia WHERE ADESTADO = 1 ORDER BY ADNOMBRE ASC";

        cbxAreaDependencia.removeAllItems();
        cbxAreaDependenciaID.removeAllItems();

        cbxAreaDependencia.addItem("" + inicioCombo);
        cbxAreaDependenciaID.addItem("" + inicioCombo);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxAreaDependencia.addItem("" + rs.getObject("ADNOMBRE"));
                cbxAreaDependenciaID.addItem("" + rs.getObject("ADID"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros del Área Dependencia.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - cargarComboAreadependencia().");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblAreaDependencia = new javax.swing.JLabel();
        cbxAreaDependencia = new javax.swing.JComboBox<>();
        pnlAreaDependencia = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        pnlDescripcion = new javax.swing.JPanel();
        cbxAreaDependenciaID = new javax.swing.JComboBox<>();
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

        lblAreaDependencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAreaDependencia.setText("Área Dependencia:");
        jPanel1.add(lblAreaDependencia);

        cbxAreaDependencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAreaDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAreaDependenciaActionPerformed(evt);
            }
        });
        jPanel1.add(cbxAreaDependencia);

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

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Ubicación");
        jPanel1.add(lblNombre);

        txtUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUbicacionActionPerformed(evt);
            }
        });
        txtUbicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUbicacionKeyPressed(evt);
            }
        });
        jPanel1.add(txtUbicacion);

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

        cbxAreaDependenciaID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAreaDependenciaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAreaDependenciaIDActionPerformed(evt);
            }
        });
        jPanel1.add(cbxAreaDependenciaID);

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

    private void txtUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUbicacionActionPerformed
       
    }//GEN-LAST:event_txtUbicacionActionPerformed

    private void btnNoAplicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoAplicaActionPerformed
//        txtDescripcion.setText("No Aplica");
//        txtNombre.setText("No Aplica");
    }//GEN-LAST:event_btnNoAplicaActionPerformed

    private void txtUbicacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUbicacionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            txtDescripcion.requestFocus();
        }
    }//GEN-LAST:event_txtUbicacionKeyPressed

    private void cbxAreaDependenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAreaDependenciaActionPerformed
        if (cbxAreaDependencia.getSelectedIndex() > 0) {
            cbxAreaDependenciaID.setSelectedIndex(cbxAreaDependencia.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxAreaDependenciaActionPerformed

    private void cbxAreaDependenciaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAreaDependenciaIDActionPerformed
        if (cbxAreaDependenciaID.getSelectedIndex() > 0) {
            cbxAreaDependencia.setSelectedIndex(cbxAreaDependenciaID.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxAreaDependenciaIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardarRegistro;
    public javax.swing.JButton btnNoAplica;
    public javax.swing.JComboBox<String> cbxAreaDependencia;
    public javax.swing.JComboBox<String> cbxAreaDependenciaID;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblAreaDependencia;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JPanel pnlAreaDependencia;
    public javax.swing.JPanel pnlDescripcion;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
