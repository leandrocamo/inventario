package A_Vista;

import A_ClasesUtilizadas.TextPrompt;

public class MueblesView extends javax.swing.JPanel {

    public MueblesView() {
        initComponents();
//        TextPrompt p1 = new TextPrompt("Ingrese un texto a buscar.", txtBuscar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenuSuperior = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnOpcionBuscar = new javax.swing.JToggleButton();
        PnlContenedor = new javax.swing.JPanel();

        btnNuevo.setText("Nuevo");

        btnRegresar.setText("Regresar");

        btnOpcionBuscar.setText("Buscar por parámetros");

        javax.swing.GroupLayout pnlMenuSuperiorLayout = new javax.swing.GroupLayout(pnlMenuSuperior);
        pnlMenuSuperior.setLayout(pnlMenuSuperiorLayout);
        pnlMenuSuperiorLayout.setHorizontalGroup(
            pnlMenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOpcionBuscar)
                .addContainerGap(366, Short.MAX_VALUE))
        );
        pnlMenuSuperiorLayout.setVerticalGroup(
            pnlMenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnRegresar)
                    .addComponent(btnOpcionBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PnlContenedor.setBackground(new java.awt.Color(153, 153, 255));
        PnlContenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PnlContenedor;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JToggleButton btnOpcionBuscar;
    public javax.swing.JButton btnRegresar;
    public javax.swing.JPanel pnlMenuSuperior;
    // End of variables declaration//GEN-END:variables
}
