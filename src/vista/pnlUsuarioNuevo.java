package vista;

import clases.TextPrompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Conexion;

public class pnlUsuarioNuevo extends javax.swing.JPanel {

    Conexion conexion = new Conexion();
    private int contadorAreaDependencia = 0;

    public pnlUsuarioNuevo() {
        initComponents();
        TextPrompt p1 = new TextPrompt("Ingrese apellidos y nombres en ese orden.", txtApellidosNombres);
        TextPrompt p2 = new TextPrompt("Ingrese un correo electrónico.", txtCorreoElectronico);
        cargarAreaDependencia();
        cbxAreaDependenciaId.setVisible(false);

    }

    public void cargarAreaDependencia() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM areadependencia WHERE ADESTADO = 1 ORDER BY ADNOMBRE ASC";
        try {
            cbxAreaDependencia.removeAllItems();
            cbxAreaDependenciaId.removeAllItems();
            cbxAreaDependencia.addItem("Seleccione una opción...");
            cbxAreaDependenciaId.addItem("0");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxAreaDependencia.addItem("" + rs.getObject("ADNOMBRE"));
                cbxAreaDependenciaId.addItem("" + rs.getObject("ADID"));
            }
            this.contadorAreaDependencia++;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros de Color.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - cargarAreaDependencia().");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxAreaDependencia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtApellidosNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        cbxAreaDependenciaId = new javax.swing.JComboBox<>();
        txtUsuId = new javax.swing.JLabel();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Área Dependencia: ");

        cbxAreaDependencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAreaDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAreaDependenciaActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Apellidos y Nombres:");

        txtApellidosNombres.setText("Moran Sanchez Maria José");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Correo Electrónico:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contraseña:");

        txtCorreoElectronico.setText("moran@mail.com");

        txtContrasenia.setText("Ecuador2020");

        cbxAreaDependenciaId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxAreaDependenciaId, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxAreaDependencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellidosNombres)
                            .addComponent(txtCorreoElectronico)
                            .addComponent(txtContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)))
                    .addComponent(txtUsuId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxAreaDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidosNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxAreaDependenciaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAreaDependenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAreaDependenciaActionPerformed
        if (this.contadorAreaDependencia > 0) {
            cbxAreaDependenciaId.setSelectedIndex(cbxAreaDependencia.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxAreaDependenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cbxAreaDependencia;
    public javax.swing.JComboBox<String> cbxAreaDependenciaId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JTextField txtApellidosNombres;
    public javax.swing.JTextField txtContrasenia;
    public javax.swing.JTextField txtCorreoElectronico;
    public javax.swing.JLabel txtUsuId;
    // End of variables declaration//GEN-END:variables
}
