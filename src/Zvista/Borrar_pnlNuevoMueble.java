package Zvista;

import Zclases.TextPrompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Zmodelo.Conexion;

public class Borrar_pnlNuevoMueble extends javax.swing.JPanel {

    Conexion conexion = new Conexion();
    public boolean marcaGuardar = true;
    private String idMueble = "";
    private int contadorColor = 0;
    private int contadorMarca = 0;
    private int contadorTipoMueble = 0;
    private int contadorEstado = 0;
    private int contadorCuentaContable = 0;
    private int contadorUbicacion = 0;
//    private Principal p = new Principal();

    public Borrar_pnlNuevoMueble(String idMueble) throws ParseException {

        initComponents();
////        //Envía PlaceHorlder
        TextPrompt prueba1 = new TextPrompt("Código Etiqueta", txtCodigoEtiqueta);
        TextPrompt prueba2 = new TextPrompt("Descripción del equipo o mueble", txtDescripcion);
        TextPrompt prueba3 = new TextPrompt("Serie o códgo único del equipo o mueble", txtSerie);
        TextPrompt prueba4 = new TextPrompt("Serie o códgo único del equipo o mueble", txtSerie);

        cbxIdColor.setVisible(false);
        cbxIdMarca.setVisible(false);
        cbxIdTipoMueble.setVisible(false);
        cbxIdEstado.setVisible(false);
        cbxIdCuentaContable.setVisible(false);
        cbxIdUbicacion.setVisible(false);

//        idMueble = null;
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
                System.out.println("Conexión cerrada - color().");
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
                System.out.println("Conexión cerrada - marca().");
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
                System.out.println("Conexión cerrada - tipoMueble().");
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
                System.out.println("Conexión cerrada - estado().");
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
                System.out.println("Conexión cerrada - cuentacontable().");
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
                System.out.println("Conexión cerrada - ubicacion().");
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

    public void enviarDatosConsulta(String idMueble) throws ParseException {
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
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtCodigoEtiqueta.setText(rs.getString("MUE.MUECODIGOETIQUETA"));
                txtDescripcion.setText(rs.getString("MUE.MUEDESCRIPCION"));
                txtSerie.setText(rs.getString("MUE.MUESERIE"));

                //Para que funcione este código se agregó throws ParseException en el inicio de la clase enviarDatosConsulta()
                txtFechaCompra.setDate(formatoFecha.parse(rs.getString("MUE.MUEFECHACOMPRA")));
                txtFechaFabricacion.setDate(formatoFecha.parse(rs.getString("MUE.MUEFECHAFABRICACION")));
                txtFechaExpiracion.setDate(formatoFecha.parse(rs.getString("MUE.MUEFECHAEXPIRACION")));

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
                System.out.println("Conexión cerrada - enviarDatosConsulta().");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public Date convertirFecha(Date fechaEnviada) {
        long d = fechaEnviada.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        return fecha;
    }

    public boolean guardarRegistro() {
        int color = opcionCombo(cbxColor.getSelectedIndex(), "color", Integer.parseInt("" + cbxIdColor.getSelectedItem()));
        int marca = opcionCombo(cbxMarca.getSelectedIndex(), "marca", Integer.parseInt("" + cbxIdMarca.getSelectedItem()));
        int tipoMueble = opcionCombo(cbxTipoMueble.getSelectedIndex(), "tipo de mueble", Integer.parseInt("" + cbxIdTipoMueble.getSelectedItem()));
        int estado = opcionCombo(cbxEstado.getSelectedIndex(), "estado del mueble", Integer.parseInt("" + cbxIdEstado.getSelectedItem()));
        int cuentaContable = opcionCombo(cbxCuentaContable.getSelectedIndex(), "Cuenta Contable", Integer.parseInt("" + cbxIdCuentaContable.getSelectedItem()));
        int ubicacion = opcionCombo(cbxUbicacion.getSelectedIndex(), "ubicación", Integer.parseInt("" + cbxIdUbicacion.getSelectedItem()));

        String codigoetiqueta = txtCodigoEtiqueta.getText();
        String descripcion = txtDescripcion.getText();
        String serie = txtSerie.getText();

        Date fechaCompra = convertirFecha(txtFechaCompra.getDate());
        Date fechaFabricacion = convertirFecha(txtFechaFabricacion.getDate());
        Date fechaExpiracion = convertirFecha(txtFechaExpiracion.getDate());

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
                        + "'" + fechaCompra + "', "
                        + "'" + fechaFabricacion + "', "
                        + "'" + fechaExpiracion + "', "
                        + "'" + FD + "', "
                        + "'" + FO + "', "
                        + "'" + valornuevo + "', "
                        + "'" + valorcomercial + "', "
                        + "'" + valorremanente + "', "
                        + "'" + cantidad + "', "
                        + "'" + valorunitario + "', "
                        + "'" + valortotal + "', "
                        + "'1') ";
//                System.out.println(sql);
                try {
                    ps = con.prepareStatement(sql);
                    ps.execute();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo ingresar el mueble\n" + ex, "Error (U244)", JOptionPane.WARNING_MESSAGE);
                } finally {
                    try {
                        con.close();
                        System.out.println("Conexión cerrada - guardarRegistro() - Nuevo.");
                    } catch (SQLException e) {
                        System.err.println(e);
                    }
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
                        + "MUEFECHACOMPRA = '" + fechaCompra + "', "
                        + "MUEFECHAFABRICACION = '" + fechaFabricacion + "', "
                        + "MUEFECHAEXPIRACION = '" + fechaExpiracion + "', "
                        + "MUEFD = '" + FD + "', "
                        + "MUEFO = '" + FO + "', "
                        + "MUEVALORNUEVO = '" + valornuevo + "', "
                        + "MUEVALORCOMERCIAL = '" + valorcomercial + "', "
                        + "MUEVALORREMANENTE = '" + valorremanente + "', "
                        + "MUECANTIDAD = '" + cantidad + "', "
                        + "MUEVALORUNITARIO = '" + valorunitario + "', "
                        + "MUEVALORTOTAL = '" + valortotal + "' "
                        + "WHERE MUE.MUEID = " + this.idMueble;
//                System.out.println(sql);
                try {
                    ps = con.prepareStatement(sql);
                    ps.execute();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el mueble.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
                } finally {
                    try {
                        con.close();
                        System.out.println("Conexión cerrada - guardarRegistro() - Editar.");
                    } catch (SQLException e) {
                        System.err.println(e);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitulo = new javax.swing.JLabel();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox();
        cbxIdColor = new javax.swing.JComboBox<>();
        cbxIdMarca = new javax.swing.JComboBox<>();
        cbxIdTipoMueble = new javax.swing.JComboBox<>();
        cbxIdCuentaContable = new javax.swing.JComboBox<>();
        cbxIdUbicacion = new javax.swing.JComboBox<>();
        cbxIdEstado = new javax.swing.JComboBox<>();
        txtFechaCompra = new com.toedter.calendar.JDateChooser();
        txtFechaFabricacion = new com.toedter.calendar.JDateChooser();
        txtFechaExpiracion = new com.toedter.calendar.JDateChooser();
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
        txtValorNuevo = new javax.swing.JFormattedTextField();

        txtTitulo.setBackground(new java.awt.Color(102, 153, 255));
        txtTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("MUEBLE");

        jLabel2.setText("Código etiqueta:");

        txtCodigoEtiqueta.setText("300833B2DDD9014000000103");

        jLabel3.setText("Descripción:");

        txtDescripcion.setColumns(1);
        txtDescripcion.setRows(1);
        txtDescripcion.setText("TELEVISIÓN PARA EL LABORATORIO DE ELECTRÓNICA");
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel4.setText("Serie");

        txtSerie.setText("POR DEFINIR");
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

        jLabel8.setText("Fecha compra: ");

        jLabel9.setText("Fecha fabricación:");

        jLabel10.setText("Fecha expiración:");

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
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoEtiqueta, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(txtSerie)
                            .addComponent(cbxColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTipoMueble, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechaFabricacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechaExpiracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxIdColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxIdTipoMueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxIdCuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxIdUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtFechaFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtFechaExpiracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxIdColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdTipoMueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdCuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        txtFD.setText("FD");
        txtFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFDActionPerformed(evt);
            }
        });

        jLabel15.setText("FO:");

        txtFO.setText("FO");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad)
                            .addComponent(txtValorTotal)
                            .addComponent(txtValorUnitario)))
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
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFO, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxUbicacion, javax.swing.GroupLayout.Alignment.LEADING, 0, 282, Short.MAX_VALUE)
                            .addComponent(txtValorNuevo)
                            .addComponent(cbxCuentaContable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieActionPerformed

    private void cbxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxColorActionPerformed
        if (this.contadorColor > 0) {
            cbxIdColor.setSelectedIndex(cbxColor.getSelectedIndex());
        }
    }//GEN-LAST:event_cbxColorActionPerformed

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

    private void txtFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFDActionPerformed

    private void txtValorComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorComercialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorComercialActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox cbxColor;
    public javax.swing.JComboBox cbxCuentaContable;
    public javax.swing.JComboBox cbxEstado;
    public javax.swing.JComboBox<String> cbxIdColor;
    public javax.swing.JComboBox<String> cbxIdCuentaContable;
    public javax.swing.JComboBox<String> cbxIdEstado;
    public javax.swing.JComboBox<String> cbxIdMarca;
    public javax.swing.JComboBox<String> cbxIdTipoMueble;
    public javax.swing.JComboBox<String> cbxIdUbicacion;
    public javax.swing.JComboBox cbxMarca;
    public javax.swing.JComboBox cbxTipoMueble;
    public javax.swing.JComboBox cbxUbicacion;
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
    public javax.swing.JFormattedTextField txtCantidad;
    public javax.swing.JTextField txtCodigoEtiqueta;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextField txtFD;
    public javax.swing.JTextField txtFO;
    public com.toedter.calendar.JDateChooser txtFechaCompra;
    public com.toedter.calendar.JDateChooser txtFechaExpiracion;
    public com.toedter.calendar.JDateChooser txtFechaFabricacion;
    public javax.swing.JTextField txtSerie;
    public javax.swing.JLabel txtTitulo;
    public javax.swing.JFormattedTextField txtValorComercial;
    public javax.swing.JFormattedTextField txtValorNuevo;
    public javax.swing.JFormattedTextField txtValorRemanente;
    public javax.swing.JFormattedTextField txtValorTotal;
    public javax.swing.JFormattedTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
