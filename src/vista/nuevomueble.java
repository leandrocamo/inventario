/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Conexion;
import clases.TextPrompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

public class nuevomueble extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    private boolean marcaGuardar = true;
    private String idMueble = "";
    private int contadorColor = 0;
    private int contadorMarca = 0;
    private int contadorTipoMueble = 0;
    private int contadorEstado = 0;
    private int contadorCuentaContable = 0;
    private int contadorUbicacion = 0;
    private Principal p = new Principal();
    

    public nuevomueble(String idMueble) throws ParseException {
        initComponents();
        this.setLocationRelativeTo(null);//centrar el app en la pantalla
        this.setResizable(false);//bloquea cambiar el tamaño de la pantalla
//        //Envía PlaceHorlder
        TextPrompt prueba1 = new TextPrompt("Código Etiqueta", txtCodigoEtiqueta);
        TextPrompt prueba2 = new TextPrompt("Descripción del equipo o mueble", txtDescripcion);
        TextPrompt prueba3 = new TextPrompt("Serie o códgo único del equipo o mueble", txtSerie);

//        cbxIdColor.setVisible(false);
//        cbxIdMarca.setVisible(false);
//        cbxIdTipoMueble.setVisible(false);
//        cbxIdEstado.setVisible(false);
//        cbxIdCuentaContable.setVisible(false);
//        cbxIdUbicacion.setVisible(false);
//        
        if (idMueble == null) {
            color();
            marca();
            tipoMueble();
            estado();
            cuentacontable();
            ubicacion();
            marcaGuardar = true;
        } else {
            color();
            marca();
            tipoMueble();
            estado();
            cuentacontable();
            ubicacion();
            enviarDatosConsulta(idMueble);
            marcaGuardar = false;
            this.idMueble = idMueble;
        }
    }

    public void color() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM color WHERE COLESTADO = 1 ORDER BY COLNOMBRE ASC";
        try {
            cbxColor.addItem("Seleccione una opción...");
            cbxIdColor.addItem("0");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxColor.addItem("" + rs.getObject("COLNOMBRE"));
                cbxIdColor.addItem("" + rs.getObject("COLID"));
            }
            this.contadorColor++;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros de Color.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void marca() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM marca WHERE MARESTADO = 1 ORDER BY MARNOMBRE";
        try {
            cbxMarca.addItem("Seleccione una opción...");
            cbxIdMarca.addItem("0");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxMarca.addItem("" + rs.getObject("MARNOMBRE"));
                cbxIdMarca.addItem("" + rs.getObject("MARID"));
            }
            this.contadorMarca++;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros de Marca.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void tipoMueble() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM tipomueble WHERE TMESTADO = 1 ORDER BY TMNOMBRE ASC";
        try {
            cbxTipoMueble.addItem("Seleccione una opción...");
            cbxIdTipoMueble.addItem("0");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxTipoMueble.addItem("" + rs.getObject("TMNOMBRE"));
                cbxIdTipoMueble.addItem("" + rs.getObject("TMID"));
            }
            this.contadorTipoMueble++;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros de Tipo Mueble.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void estado() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM estado WHERE ESTESTADO = 1 ORDER BY ESTNOMBRE ASC";

        try {
            cbxEstado.addItem("Seleccione una opción...");
            cbxIdEstado.addItem("0");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxEstado.addItem("" + rs.getObject("ESTNOMBRE"));
                cbxIdEstado.addItem("" + rs.getObject("ESTID"));
            }
            this.contadorEstado++;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros del Estado del Mueble.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void cuentacontable() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM cuentacontable WHERE CCESTADO = 1 ORDER BY CCNOMBRE ASC";
        try {
            cbxCuentaContable.addItem("Seleccione una opción...");
            cbxIdCuentaContable.addItem("0");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxCuentaContable.addItem("" + rs.getObject("CCNOMBRE"));
                cbxIdCuentaContable.addItem("" + rs.getObject("CCID"));
            }
            this.contadorCuentaContable++;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros de la cuenta contable.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void ubicacion() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM ubicacion WHERE UBIESTADO = 1 ORDER BY UBINOMBRE ASC";

        try {
            cbxUbicacion.addItem("Seleccione una opción...");
            cbxIdUbicacion.addItem("0");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxUbicacion.addItem("" + rs.getObject("UBINOMBRE"));
                cbxIdUbicacion.addItem("" + rs.getObject("UBIID"));
            }
            this.contadorUbicacion++;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros del ubicación del Mueble.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int opcionCombo(int opcion, String nombre, int valor) {
        if (opcion == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion de " + nombre + ".", "Error", JOptionPane.WARNING_MESSAGE);
            return valor;
        } else {
            return valor;
        }
    }

    public void enviarDatosConsulta(String idMueble) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "SELECT * "
                + "FROM mueble as MUE "
                + "INNER JOIN color as COL ON COL.COLID = MUE.COLID "
                + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID "
                + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID "
                + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID "
                + "INNER JOIN ubicacion as UBI ON UBI.UBIID = MUE.UBIID "
                + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID "
                + "WHERE MUE.MUEESTADO = 1 "
                + "AND MUE.MUEID = '" + idMueble + "' ";
//        System.out.println(">" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                txtCodigoEtiqueta.setText(rs.getString("MUE.MUECODIGOETIQUETA"));
                txtDescripcion.setText(rs.getString("MUE.MUEDESCRIPCION"));
                txtSerie.setText(rs.getString("MUE.MUESERIE"));
                txtFechaCompra.setText(rs.getString("MUE.MUEFECHACOMPRA"));
                txtFechaFabricacion.setText(rs.getString("MUE.MUEFECHAFABRICACION"));
                txtFechaExpiracion.setText(rs.getString("MUE.MUEFECHAEXPIRACION"));
                txtFD.setText(rs.getString("MUE.MUEFD"));
                txtFO.setText(rs.getString("MUE.MUEFO"));
                txtValorNuevo.setText(rs.getString("MUE.MUEVALORNUEVO"));
                txtValorComercial.setText(rs.getString("MUE.MUEVALORCOMERCIAL"));
                txtValorRemanente.setText(rs.getString("MUE.MUEVALORREMANENTE"));
                txtValorUnitario.setText(rs.getString("MUE.MUEVALORUNITARIO"));
                txtValorTotal.setText(rs.getString("MUE.MUEVALORTOTAL"));
                txtCantidad.setText(rs.getString("MUE.MUECANTIDAD"));

                cbxMarca.setSelectedItem(rs.getString("MAR.MARNOMBRE"));
                cbxIdMarca.setSelectedItem(rs.getString("MAR.MARID"));
                cbxColor.setSelectedItem(rs.getString("COL.COLNOMBRE"));
                cbxIdColor.setSelectedItem(rs.getString("COL.COLID"));
                cbxTipoMueble.setSelectedItem("" + rs.getString("TM.TMNOMBRE"));
                cbxIdTipoMueble.setSelectedItem("" + rs.getString("TM.TMID"));
                cbxEstado.setSelectedItem("" + rs.getString("EST.ESTNOMBRE"));
                cbxIdEstado.setSelectedItem("" + rs.getString("EST.ESTID"));
                cbxCuentaContable.setSelectedItem("" + rs.getString("CC.CCNOMBRE"));
                cbxIdCuentaContable.setSelectedItem("" + rs.getString("CC.CCID"));
                cbxUbicacion.setSelectedItem("" + rs.getString("UBI.UBINOMBRE"));
                cbxIdUbicacion.setSelectedItem("" + rs.getString("UBI.UBIID"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los registro de mueble: " + idMueble + ".\n" + ex);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada.");
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
        jLabel2 = new javax.swing.JLabel();
        txtCodigoEtiqueta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxColor = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbxMarca = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbxTipoMueble = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtFechaCompra = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFechaFabricacion = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFechaExpiracion = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox();
        cbxIdColor = new javax.swing.JComboBox<>();
        cbxIdMarca = new javax.swing.JComboBox<>();
        cbxIdTipoMueble = new javax.swing.JComboBox<>();
        cbxIdCuentaContable = new javax.swing.JComboBox<>();
        cbxIdUbicacion = new javax.swing.JComboBox<>();
        cbxIdEstado = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbxCuentaContable = new javax.swing.JComboBox();
        cbxUbicacion = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        txtFD = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtFO = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtValorNuevo = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        txtValorComercial = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        txtValorRemanente = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(102, 153, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear mueble");

        jLabel2.setText("Código etiqueta:");

        jLabel3.setText("Descripción:");

        txtDescripcion.setColumns(1);
        txtDescripcion.setRows(1);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel4.setText("Serie");

        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });

        jLabel5.setText("Color:");

        cbxColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxColorActionPerformed(evt);
            }
        });

        jLabel6.setText("Marca");

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

        jLabel7.setText("Tipo de mueble:");

        cbxTipoMueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoMuebleActionPerformed(evt);
            }
        });

        jLabel8.setText("Fecha compra:");

        try {
            txtFechaCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Fecha fabricación:");

        try {
            txtFechaFabricacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaFabricacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFabricacionActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha expiración:");

        try {
            txtFechaExpiracion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaExpiracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaExpiracionActionPerformed(evt);
            }
        });

        jLabel11.setText("Estado:");

        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoEtiqueta)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(txtSerie)
                            .addComponent(cbxColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTipoMueble, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechaCompra)
                            .addComponent(txtFechaFabricacion)
                            .addComponent(txtFechaExpiracion)
                            .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxIdColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxIdTipoMueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxIdCuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxIdUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cbxTipoMueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtFechaFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtFechaExpiracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxIdColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdTipoMueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdCuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Cuenta contable:");

        jLabel13.setText("Ubicación:");

        cbxCuentaContable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCuentaContableActionPerformed(evt);
            }
        });

        cbxUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUbicacionActionPerformed(evt);
            }
        });

        jLabel14.setText("FD:");

        txtFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFDActionPerformed(evt);
            }
        });

        jLabel15.setText("FO:");

        jLabel16.setText("Valor nuevo:");

        jLabel17.setText("Valor comercial:");

        txtValorComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorComercialActionPerformed(evt);
            }
        });

        jLabel18.setText("Valor remanente:");

        jLabel19.setText("Valor unitario:");

        jLabel20.setText("Valor total:");

        jLabel21.setText("Cantidad:");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValorRemanente))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtValorComercial))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxCuentaContable, 0, 227, Short.MAX_VALUE)
                            .addComponent(cbxUbicacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFD)
                            .addComponent(txtFO)
                            .addComponent(txtValorNuevo)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad)
                            .addComponent(txtValorUnitario)
                            .addComponent(txtValorTotal))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbxCuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbxUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtFO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtValorNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtValorComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtValorRemanente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Evaluamos si escogio una opcion en los comboBox
//        boolean error = false;
        int color = opcionCombo(cbxColor.getSelectedIndex(), "color", Integer.parseInt("" + cbxIdColor.getSelectedItem()));
        int marca = opcionCombo(cbxMarca.getSelectedIndex(), "marca", Integer.parseInt("" + cbxIdMarca.getSelectedItem()));
        int tipoMueble = opcionCombo(cbxTipoMueble.getSelectedIndex(), "tipo de mueble", Integer.parseInt("" + cbxIdTipoMueble.getSelectedItem()));
        int estado = opcionCombo(cbxEstado.getSelectedIndex(), "estado del mueble", Integer.parseInt("" + cbxIdEstado.getSelectedItem()));
        int cuentaContable = opcionCombo(cbxCuentaContable.getSelectedIndex(), "Cuenta Contable", Integer.parseInt("" + cbxIdCuentaContable.getSelectedItem()));
        int ubicacion = opcionCombo(cbxUbicacion.getSelectedIndex(), "ubicación", Integer.parseInt("" + cbxIdUbicacion.getSelectedItem()));

        String codigoetiqueta = txtCodigoEtiqueta.getText();
        String descripcion = txtDescripcion.getText();
        String serie = txtSerie.getText();
        String fechacompra = txtFechaCompra.getText();
        String fechafabricacion = txtFechaFabricacion.getText();
        String fechaexpiracion = txtFechaExpiracion.getText();
        String FD = txtFD.getText();
        String FO = txtFO.getText();
        String valornuevo = txtValorNuevo.getText();
        String valorcomercial = txtValorComercial.getText();
        String valorremanente = txtValorRemanente.getText();
        String cantidad = txtCantidad.getText();
        String valorunitario = txtValorUnitario.getText();
        String valortotal = txtValorTotal.getText();

        PreparedStatement ps = null;
        Connection con = conexion.getConexion();

        if (cbxColor.getSelectedIndex() != 0
                && cbxMarca.getSelectedIndex() != 0
                && cbxTipoMueble.getSelectedIndex() != 0
                && cbxEstado.getSelectedIndex() != 0
                && cbxCuentaContable.getSelectedIndex() != 0
                && cbxEstado.getSelectedIndex() != 0) {

            if (this.marcaGuardar) {
                String sql = "INSERT INTO mueble VALUES (NULL, "
                        + "'" + cuentaContable + "', "
                        + "'" + tipoMueble + "', "
                        + "'" + estado + "', "
                        + "'" + ubicacion + "', "
                        + "'" + marca + "', "
                        + "'" + color + "', "
                        + "'" + codigoetiqueta + "', "
                        + "'" + descripcion + "', "
                        + "'" + serie + "', "
                        + "'" + fechacompra + "', "
                        + "'" + fechafabricacion + "', "
                        + "'" + fechaexpiracion + "', "
                        + "'" + FD + "', "
                        + "'" + FO + "', "
                        + "'" + valornuevo + "', "
                        + "'" + valorcomercial + "', "
                        + "'" + valorremanente + "', "
                        + "'" + cantidad + "', "
                        + "'" + valorunitario + "', "
                        + "'" + valortotal + "', "
                        + "'1') ";
                try {
                    ps = con.prepareStatement(sql);
                    ps.execute();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo ingresar el mueble\n" + ex, "Error (U244)", JOptionPane.WARNING_MESSAGE);
                } finally {
                    try {
                        con.close();
                        System.out.println("Conexión cerrada.");
                    } catch (SQLException e) {
                        System.err.println(e);
                    }
                }
                if (JOptionPane.showConfirmDialog(this, "El mueble fue registrado.\n¿Desea ingresar otro mueble?", "Confirmación", JOptionPane.YES_NO_OPTION) == 0) {
                    //Limpiar los txt y los comboBox para que el usuario ingrese un nuevo registro.
                    //corregir

                } else {
                    dispose();
                }
            } else {
                String sql = "UPDATE mueble MUE "
                        + "SET CCID = '" + cuentaContable + "', "
                        + "TMID = '" + tipoMueble + "', "
                        + "ESTID = '" + estado + "', "
                        + "UBIID = '" + ubicacion + "', "
                        + "MARID = '" + marca + "', "
                        + "COLID = '" + color + "', "
                        + "MUECODIGOETIQUETA = '" + codigoetiqueta + "', "
                        + "MUEDESCRIPCION = '" + descripcion + "', "
                        + "MUESERIE = '" + serie + "', "
                        + "MUEFECHACOMPRA = '" + fechacompra + "', "
                        + "MUEFECHAFABRICACION = '" + fechafabricacion + "', "
                        + "MUEFECHAEXPIRACION = '" + fechaexpiracion + "', "
                        + "MUEFD = '" + FD + "', "
                        + "MUEFO = '" + FO + "', "
                        + "MUEVALORNUEVO = '" + valornuevo + "', "
                        + "MUEVALORCOMERCIAL = '" + valorcomercial + "', "
                        + "MUEVALORREMANENTE = '" + valorremanente + "', "
                        + "MUECANTIDAD = '" + cantidad + "', "
                        + "MUEVALORUNITARIO = '" + valorunitario + "', "
                        + "MUEVALORTOTAL = '" + valortotal + "' "
                        + "WHERE MUE.MUEID = " + this.idMueble;
                try {
                    ps = con.prepareStatement(sql);
                    ps.execute();
                    //corregir
                    //A pesar que el código parece que está bien, no funciona
                    p.btnActualizar.doClick();
                    dispose();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el mueble.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
                } finally {
                    try {
                        con.close();
                        System.out.println("Conexión cerrada.");
                    } catch (SQLException e) {
                        System.err.println(e);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieActionPerformed

    private void cbxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxColorActionPerformed
        if (this.contadorColor > 0) {
            cbxIdColor.setSelectedIndex(cbxColor.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxColorActionPerformed

    private void txtFechaFabricacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFabricacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFabricacionActionPerformed

    private void txtFechaExpiracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaExpiracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaExpiracionActionPerformed

    private void txtFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFDActionPerformed

    private void txtValorComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorComercialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorComercialActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cbxMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMarcaItemStateChanged
    }//GEN-LAST:event_cbxMarcaItemStateChanged

    private void cbxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarcaActionPerformed
        if (this.contadorMarca > 0) {
            cbxIdMarca.setSelectedIndex(cbxMarca.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxMarcaActionPerformed

    private void cbxTipoMuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoMuebleActionPerformed
        if (this.contadorTipoMueble > 0) {
            cbxIdTipoMueble.setSelectedIndex(cbxTipoMueble.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxTipoMuebleActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        if (this.contadorEstado > 0) {
            cbxIdEstado.setSelectedIndex(cbxEstado.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void cbxCuentaContableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCuentaContableActionPerformed
        if (this.contadorCuentaContable > 0) {
            cbxIdCuentaContable.setSelectedIndex(cbxCuentaContable.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxCuentaContableActionPerformed

    private void cbxUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUbicacionActionPerformed
        if (this.contadorUbicacion > 0) {
            cbxIdUbicacion.setSelectedIndex(cbxUbicacion.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxUbicacionActionPerformed

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
            java.util.logging.Logger.getLogger(nuevomueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevomueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevomueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevomueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new nuevomueble().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    public javax.swing.JComboBox cbxColor;
    private javax.swing.JComboBox cbxCuentaContable;
    private javax.swing.JComboBox cbxEstado;
    public javax.swing.JComboBox<String> cbxIdColor;
    private javax.swing.JComboBox<String> cbxIdCuentaContable;
    private javax.swing.JComboBox<String> cbxIdEstado;
    private javax.swing.JComboBox<String> cbxIdMarca;
    private javax.swing.JComboBox<String> cbxIdTipoMueble;
    private javax.swing.JComboBox<String> cbxIdUbicacion;
    private javax.swing.JComboBox cbxMarca;
    private javax.swing.JComboBox cbxTipoMueble;
    private javax.swing.JComboBox cbxUbicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JTextField txtCodigoEtiqueta;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFD;
    private javax.swing.JTextField txtFO;
    private javax.swing.JFormattedTextField txtFechaCompra;
    private javax.swing.JFormattedTextField txtFechaExpiracion;
    private javax.swing.JFormattedTextField txtFechaFabricacion;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JFormattedTextField txtValorComercial;
    private javax.swing.JFormattedTextField txtValorNuevo;
    private javax.swing.JFormattedTextField txtValorRemanente;
    private javax.swing.JFormattedTextField txtValorTotal;
    private javax.swing.JFormattedTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
