package vista;

public class frmPrincipal extends javax.swing.JFrame  {

//    pnlPrincipal panelInicio = new pnlPrincipal();
//    pnlNuevoMueble panelNuevoMueble;

    public frmPrincipal() {
        initComponents();
//        pnlContenedor.add(panelInicio);
//        this.setExtendedState(6);
//        btnNuevoMueble.addActionListener(this);
//        btnCancelar.addActionListener(this);
//        btnGuardarNuevoMueble.addActionListener(this);
//        btnEditarMueble.addActionListener(this);
////
//        btnCancelar.setVisible(false);
//        btnGuardarNuevoMueble.setVisible(false);
    }

//    public void regresarInicio() {
        //PANELES
//        panelInicio.setVisible(true);
//        panelNuevoMueble.setVisible(false);
//        pnlContenedor.add(panelInicio);
//        pnlContenedor.validate();
        //BOTONES
//        btnNuevoMueble.setVisible(true);
//        btnGuardarNuevoMueble.setVisible(false);
//        btnEditarMueble.setVisible(true);
//        btnCancelar.setVisible(false);

//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlContenedor = new javax.swing.JPanel();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlNavegacionSuperior = new javax.swing.JPanel();
        btnNuevoMueble = new javax.swing.JButton();
        pnlNavegacionInferior = new javax.swing.JPanel();
        btnGuardarNuevoMueble = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlContenedor.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("Sistema de Gestión de Inventario");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblTitulo))
        );

        btnNuevoMueble.setText("Nuevo mueble");
        btnNuevoMueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMuebleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNavegacionSuperiorLayout = new javax.swing.GroupLayout(pnlNavegacionSuperior);
        pnlNavegacionSuperior.setLayout(pnlNavegacionSuperiorLayout);
        pnlNavegacionSuperiorLayout.setHorizontalGroup(
            pnlNavegacionSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavegacionSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoMueble)
                .addGap(717, 717, 717))
        );
        pnlNavegacionSuperiorLayout.setVerticalGroup(
            pnlNavegacionSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavegacionSuperiorLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnNuevoMueble)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardarNuevoMueble.setText("Guardar");
        btnGuardarNuevoMueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarNuevoMuebleActionPerformed(evt);
            }
        });
        pnlNavegacionInferior.add(btnGuardarNuevoMueble);

        btnCancelar.setText("Cancelar");
        pnlNavegacionInferior.add(btnCancelar);

        jMenu1.setText("Opciones");

        jMenuItem2.setText("Inicio");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNavegacionSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pnlNavegacionInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNavegacionSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNavegacionInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        pnlUsuario objp = new pnlUsuario();
        //objp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnNuevoMuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMuebleActionPerformed

    }//GEN-LAST:event_btnNuevoMuebleActionPerformed

    private void btnGuardarNuevoMuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarNuevoMuebleActionPerformed

    }//GEN-LAST:event_btnGuardarNuevoMuebleActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardarNuevoMueble;
    public javax.swing.JButton btnNuevoMueble;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JPanel pnlContenedor;
    public javax.swing.JPanel pnlNavegacionInferior;
    public javax.swing.JPanel pnlNavegacionSuperior;
    private javax.swing.JPanel pnlTitulo;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object evt = e.getSource();
//        if (evt.equals(btnNuevoMueble)) {
//
//            try {
//                panelNuevoMueble = new pnlNuevoMueble(null);
//            } catch (ParseException ex) {
//                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            panelInicio.setVisible(false);
//            btnNuevoMueble.setVisible(false);
//            panelNuevoMueble.setVisible(true);
//            btnGuardarNuevoMueble.setVisible(true);
//            btnEditarMueble.setVisible(false);
//            btnCancelar.setVisible(true);
//
//            panelNuevoMueble.txtTitulo.setText("Creación de nuevo mueble");
//
//            pnlContenedor.add(panelNuevoMueble);
//            pnlContenedor.validate();
//
//        } else 
//            if (evt.equals(btnCancelar)) {
//            panelInicio.setVisible(true);
//            btnNuevoMueble.setVisible(true);
//            panelNuevoMueble.setVisible(false);
//            btnGuardarNuevoMueble.setVisible(false);
//            btnEditarMueble.setVisible(true);
//            btnCancelar.setVisible(false);
//
//            pnlContenedor.add(panelInicio);
//            pnlContenedor.validate();
//        } else if (evt.equals(btnGuardarNuevoMueble)) {
//            if (panelNuevoMueble.guardarRegistro() && panelNuevoMueble.marcaGuardar) {
//                if (JOptionPane.showConfirmDialog(this, "El mueble fue registrado.\n¿Desea ingresar otro mueble?", "Confirmación", JOptionPane.YES_NO_OPTION) == 0) {
//                    //Limpiar los txt y los comboBox para que el usuario ingrese un nuevo registro.
//                    //corregir
//                } else {
//                    regresarInicio();
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Los registros se actualizaron con éxito.");
//                regresarInicio();
//            }
//        } else if (evt.equals(btnEditarMueble)) {
//            int seleccion = panelInicio.jTableMuebles.getSelectedRow();
//            if (seleccion > -1) {
//                String idMueble = (String) panelInicio.jTableMuebles.getValueAt(seleccion, 1);
//                try {
//                    panelNuevoMueble = new pnlNuevoMueble(idMueble);
//                } catch (ParseException ex) {
//                    Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                panelInicio.setVisible(false);
//                btnNuevoMueble.setVisible(false);
//                panelNuevoMueble.setVisible(true);
//                btnGuardarNuevoMueble.setVisible(true);
//                btnEditarMueble.setVisible(false);
//                btnCancelar.setVisible(true);
//
//                panelNuevoMueble.txtTitulo.setText("Edición de mueble");
//
//                pnlContenedor.add(panelNuevoMueble);
//                pnlContenedor.validate();
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Por favor escoja un mueble de la tabla inferior.", "Error", JOptionPane.WARNING_MESSAGE);
//            }
//        }
//    }
}
