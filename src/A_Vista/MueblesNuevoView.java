package A_Vista;

import A_Modelo.AreaDependenciaModel;
import A_Modelo.MueblesNuevoModel;
import A_Modelo.MueblesNuevoQuery;
import A_Modelo.UbicacionModel;
import A_Modelo.UsuarioModel;
import java.awt.event.ItemEvent;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class MueblesNuevoView extends javax.swing.JPanel {
    
    public MueblesNuevoView() {
        initComponents();
//        AreaDependenciaModel modelArea = new AreaDependenciaModel();
        cbxUbicacion.setVisible(false);
        lblUbicacion.setVisible(false);
        pnlUbicacion.setVisible(false);
        cbxUsuario.setVisible(false);
        lblCustodio.setVisible(false);
        pnlCustodio.setVisible(false);
        pnlCombosIDs.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoEtiqueta = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbxColor = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbxMarca = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbxTipoMueble = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtFechaCompra = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFechaFabricacion = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtFechaExpiracion = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cbxCuentaContable = new javax.swing.JComboBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        cbxAreaDependencia = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        lblUbicacion = new javax.swing.JLabel();
        cbxUbicacion = new javax.swing.JComboBox();
        pnlUbicacion = new javax.swing.JPanel();
        lblCustodio = new javax.swing.JLabel();
        cbxUsuario = new javax.swing.JComboBox<>();
        pnlCustodio = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtFD = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtFO = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtValorNuevo = new javax.swing.JFormattedTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtValorComercial = new javax.swing.JFormattedTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtValorRemanente = new javax.swing.JFormattedTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JFormattedTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JFormattedTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        jPanel23 = new javax.swing.JPanel();
        pnlCombosIDs = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxColorID = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cbxMarcaID = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cbxTipoMuebleID = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        cbxCuentaContableID = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        cbxAreaDependenciaID = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cbxEstadoID = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 709));
        jPanel1.setLayout(new java.awt.GridLayout(25, 3));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código etiqueta:");
        jPanel1.add(jLabel2);

        txtCodigoEtiqueta.setText("300833B2DDD9014000000103");
        jPanel1.add(txtCodigoEtiqueta);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descripción:");
        jPanel1.add(jLabel3);

        txtDescripcion.setColumns(1);
        txtDescripcion.setRows(1);
        txtDescripcion.setText("TELEVISIÓN PARA EL LABORATORIO DE ELECTRÓNICA");
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Serie:");
        jPanel1.add(jLabel4);

        txtSerie.setText("POR DEFINIR");
        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });
        jPanel1.add(txtSerie);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Color:");
        jPanel1.add(jLabel5);

        cbxColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxColorActionPerformed(evt);
            }
        });
        jPanel1.add(cbxColor);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Marca:");
        jPanel1.add(jLabel6);

        cbxMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMarcaItemStateChanged(evt);
            }
        });
        cbxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(cbxMarca);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tipo de mueble:");
        jPanel1.add(jLabel7);

        cbxTipoMueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoMuebleActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipoMueble);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Fecha compra: ");
        jPanel1.add(jLabel8);
        jPanel1.add(txtFechaCompra);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel10);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Fecha fabricación:");
        jPanel1.add(jLabel9);
        jPanel1.add(txtFechaFabricacion);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel11);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Fecha expiración:");
        jPanel1.add(jLabel10);
        jPanel1.add(txtFechaExpiracion);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel12);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Estado:");
        jPanel1.add(jLabel11);

        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxEstado);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Cuenta contable:");
        jPanel1.add(jLabel12);

        cbxCuentaContable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCuentaContableActionPerformed(evt);
            }
        });
        jPanel1.add(cbxCuentaContable);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Área de Dependencia:");
        jPanel1.add(jLabel27);

        cbxAreaDependencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAreaDependenciaItemStateChanged(evt);
            }
        });
        jPanel1.add(cbxAreaDependencia);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel24);

        lblUbicacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUbicacion.setText("Ubicación:");
        jPanel1.add(lblUbicacion);

        cbxUbicacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxUbicacionItemStateChanged(evt);
            }
        });
        cbxUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUbicacionActionPerformed(evt);
            }
        });
        jPanel1.add(cbxUbicacion);

        javax.swing.GroupLayout pnlUbicacionLayout = new javax.swing.GroupLayout(pnlUbicacion);
        pnlUbicacion.setLayout(pnlUbicacionLayout);
        pnlUbicacionLayout.setHorizontalGroup(
            pnlUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        pnlUbicacionLayout.setVerticalGroup(
            pnlUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(pnlUbicacion);

        lblCustodio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCustodio.setText("Custodio:");
        jPanel1.add(lblCustodio);

        cbxUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxUsuarioItemStateChanged(evt);
            }
        });
        jPanel1.add(cbxUsuario);

        javax.swing.GroupLayout pnlCustodioLayout = new javax.swing.GroupLayout(pnlCustodio);
        pnlCustodio.setLayout(pnlCustodioLayout);
        pnlCustodioLayout.setHorizontalGroup(
            pnlCustodioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        pnlCustodioLayout.setVerticalGroup(
            pnlCustodioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(pnlCustodio);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("FD:");
        jPanel1.add(jLabel14);

        txtFD.setText("FD");
        txtFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFDActionPerformed(evt);
            }
        });
        jPanel1.add(txtFD);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel16);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("FO:");
        jPanel1.add(jLabel15);

        txtFO.setText("FO");
        jPanel1.add(txtFO);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel17);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Valor nuevo:");
        jPanel1.add(jLabel16);

        txtValorNuevo.setText("1.55");
        jPanel1.add(txtValorNuevo);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel20);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Valor comercial:");
        jPanel1.add(jLabel17);

        txtValorComercial.setText("12.05");
        txtValorComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorComercialActionPerformed(evt);
            }
        });
        jPanel1.add(txtValorComercial);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel21);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Valor remanente:");
        jPanel1.add(jLabel18);

        txtValorRemanente.setText("12.05");
        jPanel1.add(txtValorRemanente);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel18);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Valor unitario:");
        jPanel1.add(jLabel19);

        txtValorUnitario.setText("12.05");
        txtValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorUnitarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtValorUnitario);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel19);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Valor total:");
        jPanel1.add(jLabel20);

        txtValorTotal.setText("12.05");
        jPanel1.add(txtValorTotal);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel22);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Cantidad:");
        jPanel1.add(jLabel21);

        txtCantidad.setText("2");
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantidad);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel23);

        jScrollPane1.setViewportView(jPanel1);

        jLabel1.setText("COLID:");
        pnlCombosIDs.add(jLabel1);

        pnlCombosIDs.add(cbxColorID);

        jLabel22.setText("MARID:");
        pnlCombosIDs.add(jLabel22);

        pnlCombosIDs.add(cbxMarcaID);

        jLabel23.setText("TMID");
        pnlCombosIDs.add(jLabel23);

        pnlCombosIDs.add(cbxTipoMuebleID);

        jLabel24.setText("CCID");
        pnlCombosIDs.add(jLabel24);

        pnlCombosIDs.add(cbxCuentaContableID);

        jLabel25.setText("ADID:");
        pnlCombosIDs.add(jLabel25);

        pnlCombosIDs.add(cbxAreaDependenciaID);

        jLabel26.setText("ESTID:");
        pnlCombosIDs.add(jLabel26);

        pnlCombosIDs.add(cbxEstadoID);

        btnGuardar.setText("Guardar");
        jPanel3.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        jPanel3.add(btnCancelar);

        jButton1.setText("Ingresar No Aplica");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCombosIDs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCombosIDs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed

    }//GEN-LAST:event_txtSerieActionPerformed

    private void cbxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxColorActionPerformed

    }//GEN-LAST:event_cbxColorActionPerformed

    private void cbxMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMarcaItemStateChanged

    }//GEN-LAST:event_cbxMarcaItemStateChanged

    private void cbxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarcaActionPerformed

    }//GEN-LAST:event_cbxMarcaActionPerformed

    private void cbxTipoMuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoMuebleActionPerformed

    }//GEN-LAST:event_cbxTipoMuebleActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed

    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void cbxCuentaContableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCuentaContableActionPerformed

    }//GEN-LAST:event_cbxCuentaContableActionPerformed

    private void cbxUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUbicacionActionPerformed

    }//GEN-LAST:event_cbxUbicacionActionPerformed

    private void txtFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFDActionPerformed

    }//GEN-LAST:event_txtFDActionPerformed

    private void txtValorComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorComercialActionPerformed

    }//GEN-LAST:event_txtValorComercialActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed

    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorUnitarioActionPerformed

    private void cbxAreaDependenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAreaDependenciaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            AreaDependenciaModel model = (AreaDependenciaModel) cbxAreaDependencia.getSelectedItem();
            UbicacionModel modelUbicacion = new UbicacionModel();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(modelUbicacion.cargarUbicacion(model.getADID()));
            cbxUbicacion.setModel(modeloCombo);
            cbxUbicacion.setVisible(true);
            lblUbicacion.setVisible(true);
            pnlUbicacion.setVisible(true);
            
            cbxUsuario.removeAllItems();
            cbxUsuario.setVisible(false);
            lblCustodio.setVisible(false);
            pnlCustodio.setVisible(false);
            
        }
    }//GEN-LAST:event_cbxAreaDependenciaItemStateChanged

    private void cbxUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxUsuarioItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            AreaDependenciaModel modelAreaDependencia = (AreaDependenciaModel) cbxAreaDependencia.getSelectedItem();
            UbicacionModel modelUbicacion = (UbicacionModel) cbxUbicacion.getSelectedItem();
            UsuarioModel modelUsuario = (UsuarioModel) cbxUsuario.getSelectedItem();
            
//            JOptionPane.showMessageDialog(null,modelUsuario.getUSUID());
        }
    }//GEN-LAST:event_cbxUsuarioItemStateChanged

    private void cbxUbicacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxUbicacionItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            UbicacionModel model = (UbicacionModel) cbxUbicacion.getSelectedItem();
            UsuarioModel modelUsuario = new UsuarioModel();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(modelUsuario.cargarUsuario(model.getUBIID()));
            cbxUsuario.setModel(modeloCombo);
            cbxUsuario.setVisible(true);
            lblCustodio.setVisible(true);
            pnlCustodio.setVisible(true);
            
        }
    }//GEN-LAST:event_cbxUbicacionItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        cbxColor.setSelectedItem("No aplica");
        cbxCuentaContable.setSelectedItem("No aplica");
        cbxEstado.setSelectedItem("No aplica");
        cbxMarca.setSelectedItem("No aplica");
        cbxTipoMueble.setSelectedItem("No aplica");
        Date fecha = new Date();
        txtFechaCompra.setDate(fecha);
        txtFechaExpiracion.setDate(fecha);
        txtFechaFabricacion.setDate(fecha);
        
        txtCodigoEtiqueta.setText("No aplica");
        txtDescripcion.setText("No aplica");
        txtSerie.setText("No aplica");
        txtFD.setText("No aplica");
        txtFO.setText("No aplica");
        txtValorComercial.setText("0.00");
        txtValorNuevo.setText("0.00");
        txtValorRemanente.setText("0.00");
        txtValorTotal.setText("0.00");
        txtValorUnitario.setText("0.00");
        txtCantidad.setText("0");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JComboBox<String> cbxAreaDependencia;
    public javax.swing.JComboBox<String> cbxAreaDependenciaID;
    public javax.swing.JComboBox cbxColor;
    public javax.swing.JComboBox<String> cbxColorID;
    public javax.swing.JComboBox cbxCuentaContable;
    public javax.swing.JComboBox<String> cbxCuentaContableID;
    public javax.swing.JComboBox cbxEstado;
    public javax.swing.JComboBox<String> cbxEstadoID;
    public javax.swing.JComboBox cbxMarca;
    public javax.swing.JComboBox<String> cbxMarcaID;
    public javax.swing.JComboBox cbxTipoMueble;
    public javax.swing.JComboBox<String> cbxTipoMuebleID;
    public javax.swing.JComboBox cbxUbicacion;
    public javax.swing.JComboBox<String> cbxUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCustodio;
    public javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JPanel pnlCombosIDs;
    private javax.swing.JPanel pnlCustodio;
    private javax.swing.JPanel pnlUbicacion;
    public javax.swing.JFormattedTextField txtCantidad;
    public javax.swing.JTextField txtCodigoEtiqueta;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextField txtFD;
    public javax.swing.JTextField txtFO;
    public com.toedter.calendar.JDateChooser txtFechaCompra;
    public com.toedter.calendar.JDateChooser txtFechaExpiracion;
    public com.toedter.calendar.JDateChooser txtFechaFabricacion;
    public javax.swing.JTextField txtSerie;
    public javax.swing.JFormattedTextField txtValorComercial;
    public javax.swing.JFormattedTextField txtValorNuevo;
    public javax.swing.JFormattedTextField txtValorRemanente;
    public javax.swing.JFormattedTextField txtValorTotal;
    public javax.swing.JFormattedTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
