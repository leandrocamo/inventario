package Vista;

import ClasesUtilizadas.ClasesUtilizadas;
import ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reportes extends javax.swing.JPanel {

    Conexion conexion = new Conexion();
    String inicioCombo = "Seleccione una opción...";
    private final ClasesUtilizadas classUtilizada = new ClasesUtilizadas();

    public Reportes() {
        initComponents();
        cbxUsuarioID.setVisible(false);
        cargarCombo();
    }

    public void cargarCombo() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();

        String sql = "SELECT * FROM usuario WHERE USUESTADO = 1 ORDER BY USUAPELLIDOS, USUNOMBRES ASC";

        cbxUsuario.removeAllItems();
        cbxUsuarioID.removeAllItems();

        cbxUsuario.addItem("" + inicioCombo);
        cbxUsuarioID.addItem("" + inicioCombo);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxUsuario.addItem(rs.getObject(3) + " " + rs.getObject(2));
                cbxUsuarioID.addItem("" + rs.getObject(1));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros del Área Dependencia.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - cargarCombo.");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnReporte1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbxUsuario = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnReporte2 = new javax.swing.JButton();
        cbxUsuarioID = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generador de Reportes");

        jPanel1.setLayout(new java.awt.GridLayout(4, 4));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Mostrar muebles completos");
        jPanel1.add(jLabel2);

        btnReporte1.setText("Reporte 1");
        btnReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel10);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel11);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Usuario:");
        jPanel1.add(jLabel4);

        cbxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(cbxUsuario);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Equipos asignados");
        jPanel1.add(jLabel3);

        btnReporte2.setText("Reporte 2");
        btnReporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte2);

        cbxUsuarioID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxUsuarioID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUsuarioIDActionPerformed(evt);
            }
        });
        jPanel1.add(cbxUsuarioID);

        btnRegresar.setText("Regresar");
        jPanel6.add(btnRegresar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte1ActionPerformed
        Connection con = conexion.getConexion();
        try {
            JasperReport reporte = null;
            String path = "src\\Reportes\\inventario.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, con);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - REPORTE1.");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }//GEN-LAST:event_btnReporte1ActionPerformed

    private void btnReporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte2ActionPerformed
        Connection con = conexion.getConexion();
        if (classUtilizada.validarCombo(cbxUsuario.getSelectedIndex(), "Usuario")) {
            try {
                JasperReport reporte = null;
                String path = "src\\Reportes\\mueblesasignados.jasper";

                Map parametro = new HashMap();
                parametro.put("idUsuario", cbxUsuarioID.getSelectedItem());

                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, con);

                JasperViewer view = new JasperViewer(jprint, false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    con.close();
                    System.out.println("Conexión cerrada - REPORTE 2.");
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }//GEN-LAST:event_btnReporte2ActionPerformed

    private void cbxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUsuarioActionPerformed
        if (cbxUsuario.getSelectedIndex() > 0) {
            cbxUsuarioID.setSelectedIndex(cbxUsuario.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxUsuarioActionPerformed

    private void cbxUsuarioIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUsuarioIDActionPerformed
        if (cbxUsuarioID.getSelectedIndex() > 0) {
            cbxUsuario.setSelectedIndex(cbxUsuarioID.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxUsuarioIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReporte1;
    private javax.swing.JButton btnReporte2;
    private javax.swing.JComboBox<String> cbxUsuario;
    private javax.swing.JComboBox<String> cbxUsuarioID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
