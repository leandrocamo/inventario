/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_Vista;

import A_ClasesUtilizadas.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InicioSesionView extends javax.swing.JFrame {

    Conexion conexion = new Conexion();

    public InicioSesionView() {
        initComponents();
//        presentarId();
    }

    public void presentarId() {
        PreparedStatement ps = null;
//        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "";

//        sql = "INSERT INTO color (COLNOMBRE, COLDESCRIPCION, COLESTADO) VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, JOptionPane.showInputDialog("Nombre color:"));
            ps.setString(2, JOptionPane.showInputDialog("Nombre descripción:"));
            ps.setBoolean(3, false);
            ps.executeUpdate();
            

            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                int claveGenerada = rs.getInt(1);
                JOptionPane.showMessageDialog(null, "Clave generada = " + claveGenerada);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - presentarId().");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConfigurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Inicio de sesión");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(3, 3));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Usuario:");
        jPanel2.add(jLabel2);

        txtUsuario.setText("jm@gmail.com");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        jPanel2.add(txtUsuario);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Contraseña:");
        jPanel2.add(jLabel3);

        txtContrasenia.setText("jm@gmail.com");
        txtContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyPressed(evt);
            }
        });
        jPanel2.add(txtContrasenia);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);

        btnIngresar.setText("Ingresar");
        jPanel2.add(btnIngresar);

        btnCancelar.setText("Cancelar");
        jPanel2.add(btnCancelar);

        btnConfigurar.setText("Configurar");
        jPanel2.add(btnConfigurar);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtContrasenia.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtContraseniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnIngresar.doClick();
        }
    }//GEN-LAST:event_txtContraseniaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesionView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnConfigurar;
    public javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JPasswordField txtContrasenia;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
