package A_Vista;

import A_ClasesUtilizadas.Conexion;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;

public class MueblesPrincipalView extends javax.swing.JPanel {

    Conexion conexion = new Conexion();

    public MueblesPrincipalView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBuscarTexto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscarPorTexto = new javax.swing.JButton();
        pnlBuscarCombo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxCuentaContable = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxCustodio = new javax.swing.JComboBox<>();
        btnBuscarPorParametro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMuebles = new javax.swing.JTable();
        pnlCodigos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbxCuentaContableID = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxCustodioID = new javax.swing.JComboBox<>();
        txtTotalRegistros = new javax.swing.JLabel();
        btnExportarCSV = new javax.swing.JButton();

        jLabel1.setText("Buscar:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        btnBuscarPorTexto.setText("Buscar");
        btnBuscarPorTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorTextoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscarTextoLayout = new javax.swing.GroupLayout(pnlBuscarTexto);
        pnlBuscarTexto.setLayout(pnlBuscarTextoLayout);
        pnlBuscarTextoLayout.setHorizontalGroup(
            pnlBuscarTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarPorTexto)
                .addContainerGap())
        );
        pnlBuscarTextoLayout.setVerticalGroup(
            pnlBuscarTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarTextoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBuscarTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscarTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarPorTexto)))
        );

        jLabel2.setText("Cuenta Contable:");

        jLabel3.setText("Custodio:");

        btnBuscarPorParametro.setText("Buscar");

        javax.swing.GroupLayout pnlBuscarComboLayout = new javax.swing.GroupLayout(pnlBuscarCombo);
        pnlBuscarCombo.setLayout(pnlBuscarComboLayout);
        pnlBuscarComboLayout.setHorizontalGroup(
            pnlBuscarComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarComboLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cbxCuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cbxCustodio, 0, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarPorParametro)
                .addContainerGap())
        );
        pnlBuscarComboLayout.setVerticalGroup(
            pnlBuscarComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarComboLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscarComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxCuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxCustodio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPorParametro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableMuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableMuebles);

        jLabel4.setText("Id Cuenta Contrable:");
        pnlCodigos.add(jLabel4);

        pnlCodigos.add(cbxCuentaContableID);

        jLabel5.setText("Id Custodio:");
        pnlCodigos.add(jLabel5);

        pnlCodigos.add(cbxCustodioID);

        txtTotalRegistros.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtTotalRegistros.setText("jLabel6");

        btnExportarCSV.setText("Exportar CSV");
        btnExportarCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBuscarTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBuscarCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addComponent(pnlCodigos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTotalRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExportarCSV)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBuscarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBuscarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalRegistros)
                    .addComponent(btnExportarCSV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCodigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarPorTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarPorTextoActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscarPorTexto.doClick();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnExportarCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarCSVActionPerformed
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM mueble";
        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros del documentoinventario.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - btnExportarCSVAction().");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        /*JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = fileChooser.showSaveDialog(this);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File archivoCSV = fileChooser.getSelectedFile();
        try {
            //File archivo = new File("datos.xls");
            TableModel modelo = jTableMuebles.getModel();
            FileWriter excel = new FileWriter(archivoCSV + ".xls");
            for (int i = 0; i < modelo.getColumnCount()-2; i++) {
                excel.write(modelo.getColumnName(i) + ";");
            }
            excel.write("\n");
            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount()-2; j++) {
                    String data = "" + modelo.getValueAt(i, j);
                    if (data == "null") {
                        data = "";
                    }
                    excel.write(data + ";");
                }
                excel.write("\n");
            }

            excel.close();
            JOptionPane.showMessageDialog(null, "Archivo Creado");

        } catch (IOException ex) {
            System.err.println(ex);
        }*/

    }//GEN-LAST:event_btnExportarCSVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarPorParametro;
    public javax.swing.JButton btnBuscarPorTexto;
    private javax.swing.JButton btnExportarCSV;
    public javax.swing.JComboBox<String> cbxCuentaContable;
    public javax.swing.JComboBox<String> cbxCuentaContableID;
    public javax.swing.JComboBox<String> cbxCustodio;
    public javax.swing.JComboBox<String> cbxCustodioID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableMuebles;
    public javax.swing.JPanel pnlBuscarCombo;
    public javax.swing.JPanel pnlBuscarTexto;
    public javax.swing.JPanel pnlCodigos;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JLabel txtTotalRegistros;
    // End of variables declaration//GEN-END:variables
}
