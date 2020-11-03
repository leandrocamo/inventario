package Vista;

import ClasesUtilizadas.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author camo
 */
public class UsuarioUbicacionView extends javax.swing.JPanel {

    Conexion conexion = new Conexion();
    String inicioCombo = "Seleccione una opción...";

    public UsuarioUbicacionView() {
        initComponents();
        cbxUbicacionID.setVisible(false);
        btnActualizar.setVisible(false);

    }

    public void cargarCombo(String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();

//        sql = "SELECT * FROM areadependencia WHERE ADESTADO = 1 ORDER BY ADNOMBRE ASC";
        cbxUbicacion.removeAllItems();
        cbxUbicacionID.removeAllItems();
        cbxUbicacion.addItem("" + inicioCombo);
        cbxUbicacionID.addItem("" + inicioCombo);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxUbicacionID.addItem("" + rs.getObject(1));
                cbxUbicacion.addItem("" + rs.getObject(3));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros del Combo.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - combo().");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        cbxUbicacion = new javax.swing.JComboBox<>();
        cbxUbicacionID = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo.setText("Administración de XXXX");

        btnRegresar.setText("Regresar");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable);

        btnAgregar.setText("Agregar");

        cbxUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUbicacionActionPerformed(evt);
            }
        });

        cbxUbicacionID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxUbicacionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUbicacionIDActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbxUbicacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxUbicacionID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnAgregar)
                    .addComponent(cbxUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxUbicacionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUbicacionActionPerformed
        if (cbxUbicacion.getSelectedIndex() > 0) {
            cbxUbicacionID.setSelectedIndex(cbxUbicacion.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxUbicacionActionPerformed

    private void cbxUbicacionIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUbicacionIDActionPerformed
        if (cbxUbicacionID.getSelectedIndex() > 0) {
            cbxUbicacion.setSelectedIndex(cbxUbicacionID.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxUbicacionIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxUbicacion;
    public javax.swing.JComboBox<String> cbxUbicacionID;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable;
    public javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
