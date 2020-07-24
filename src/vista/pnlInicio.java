/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.KeyEvent;
import modelo.Conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class pnlInicio extends javax.swing.JPanel {

    Conexion conexion = new Conexion();

    public pnlInicio() {
        initComponents();
        initComponents();
        cargarDatos();
//        this.setExtendedState(6);
        btnGuardar.setVisible(false);
        cargarDatosBatch();
    }

    public void cargarDatos() {
        DefaultTableModel m;
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();

        PreparedStatement ps = null;
        ResultSet rs;

        String sql = "SELECT * FROM mueble MUE \n"
                + "INNER JOIN ubicacion UBI ON UBI.UBIID=MUE.UBIID \n"
                + "INNER JOIN areadependencia AXD ON AXD.ADID=UBI.ADID \n"
                + "INNER JOIN usuario USU ON USU.ADID=AXD.ADID\n"
                + "INNER JOIN color as COL ON COL.COLID = MUE.COLID \n"
                + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID \n"
                + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID \n"
                + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID \n"
                + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID \n"
                + "WHERE MUE.MUEESTADO = 1 ORDER BY MUE.MUEDESCRIPCION ASC";
//       System.out.println("all|| " + sql);
        try {
            String titulo[] = {"Nro.", "CÓDIGO", "DESCRIPCIÓN", "CÓDIGO ETIQUETA", "SERIE", "MARCA"};
            m = new DefaultTableModel(null, titulo);
            JTable p = new JTable(m);
            String fila[] = new String[6];

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int index = 1;
            while (rs.next()) {
                fila[0] = String.valueOf(index);
                fila[1] = rs.getString("MUE.MUEID");
                fila[2] = rs.getString("MUE.MUEDESCRIPCION");
                fila[3] = rs.getString("MUE.MUECODIGOETIQUETA");
                fila[4] = rs.getString("MAR.MARNOMBRE");
                fila[5] = rs.getString("MUE.MUESERIE");
                m.addRow(fila);
                index++;
            }
            jtDatos.setModel(m);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(m);
            jtDatos.setRowSorter(ordenar);
            this.jtDatos.setModel(m);

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public void cargarDatosBatch() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM batch WHERE BATESTADO = 1 ORDER BY BATFECHA ASC";
        try {
            cbxArchivo.addItem("Seleccione una opción...");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxArchivo.addItem("" + rs.getObject("BATARCHIVOIMPORTADO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros del Batch.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void eliminarDatosImportar() {
        DefaultTableModel tb = (DefaultTableModel) jtableCSV.getModel();
        int a = jtableCSV.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void eliminarDatos() {
        DefaultTableModel tb = (DefaultTableModel) jtDatos.getModel();
        int a = jtDatos.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public File obtenerArchivo() {
        String fileName;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Excel .csv", "csv");
        fileChooser.setFileFilter(filtro);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.CANCEL_OPTION) {
            return null;
        } else {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            fileName = archivoSeleccionado.getAbsolutePath();
            txtPath.setText(archivoSeleccionado.getName());
            System.out.println("Archivo: " + fileName);
            return archivoSeleccionado;
        }
    }

    public String quitarComillas(String cadena) {
        String resultadoCadena = "";
        int tamanio = cadena.length();
        char arregloCadena[] = new char[tamanio];
        arregloCadena = cadena.toCharArray();
        for (int i = 0; i < tamanio; i++) {
            if (arregloCadena[i] != '"') {
                resultadoCadena = resultadoCadena + arregloCadena[i];

            }
        }
        return resultadoCadena;
    }

    public void guardarCVSaBDD() {
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        String path = txtPath.getText();
        String idBatch = null;

        String sql = "INSERT INTO batch (BATID, BATFECHA, BATARCHIVOIMPORTADO, BATESTADO) "
                + "VALUES (NULL, '" + capturarfechayhora() + "', '" + path + "', '1')";
        try {
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }

        ResultSet rs = null;
        sql = "SELECT * FROM batch WHERE BATARCHIVOIMPORTADO='" + path + "'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idBatch = "" + rs.getObject("BATID");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo el ID del Batch.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        }

        for (int i = 0; i < jtableCSV.getRowCount(); i++) {
            sql = "INSERT INTO device (DEVID, BATID, DEVTYPE, DEVIDENTIFIER, DEVSIGNAL, DEVSEENCOUNT, DEVFIRSTSEEN, DEVLASTSEEN, DEVASCII, DEVESTADO) "
                    + "VALUES (NULL, '" + idBatch + "', '" + jtableCSV.getValueAt(i, 0) + "', "
                    + "'" + jtableCSV.getValueAt(i, 1) + "', '" + jtableCSV.getValueAt(i, 2) + "', "
                    + "'" + jtableCSV.getValueAt(i, 3) + "', '" + jtableCSV.getValueAt(i, 4) + "', "
                    + "'" + jtableCSV.getValueAt(i, 5) + "', '" + jtableCSV.getValueAt(i, 6) + "', '1');";
            try {
                ps = con.prepareStatement(sql);
                ps.execute();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        eliminarDatosImportar();

        try {
            con.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private void procesarCsv(File archivoSeleccionado) throws IOException {
//        eliminarDatosImportar();
        boolean bandera = true;
        DefaultTableModel modeloTabla = new DefaultTableModel();
        BufferedReader input = new BufferedReader(new FileReader(archivoSeleccionado));
        String linea;
        String campo;
        ArrayList<String> columnas = new ArrayList<String>();
        int veces = 0;

        while ((linea = input.readLine()) != null) {
            ArrayList<String> contenidoFila = new ArrayList<String>();
            int tamanio = linea.length();
            int intAux = 0;
            char arregloCadena[] = new char[tamanio];
            arregloCadena = linea.toCharArray();
            for (int i = 0; i < tamanio; i++) {
                if (arregloCadena[i] == ',') {
                    campo = linea.substring(intAux, i);
                    campo = quitarComillas(campo);
                    intAux = i + 1;
                    if (bandera) {
                        columnas.add(campo);
                    } else {
                        contenidoFila.add(campo);
                    }
                } else if (i == tamanio - 1) {
                    campo = linea.substring(intAux, i + 1);
                    campo = quitarComillas(campo);
                    //System.out.print(">" + campo+" - ");
                    if (bandera) {
                        columnas.add(campo);
                        for (int x = 0; x < columnas.size(); x++) {
                            modeloTabla.addColumn(columnas.get(x));
                        }
                    } else {
                        contenidoFila.add(campo);
                        modeloTabla.addRow(contenidoFila.toArray());
                    }
                    bandera = false;
                }
//                }

            }
        }
        jtableCSV.setModel(modeloTabla);
        input.close();
    }

    public String capturarfechayhora() {
        String fechahora = null;
        Date fechaActual = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        fechahora = formatofecha.format(fechaActual);
        return fechahora;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnActualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        pnlImportar = new javax.swing.JPanel();
        btnExaminar = new javax.swing.JButton();
        txtPath = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtableCSV = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbxArchivo = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableInventariado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnInventariar = new javax.swing.JButton();

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        txtBuscar.setText("PROYECTOR");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtDatos);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar)
                        .addGap(10, 10, 10)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Principal", pnlPrincipal);

        btnExaminar.setText("Examinar");
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });

        txtPath.setEnabled(false);

        jtableCSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtableCSV);

        btnGuardar.setText("Guardar BDD");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlImportarLayout = new javax.swing.GroupLayout(pnlImportar);
        pnlImportar.setLayout(pnlImportarLayout);
        pnlImportarLayout.setHorizontalGroup(
            pnlImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImportarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addGroup(pnlImportarLayout.createSequentialGroup()
                        .addComponent(btnExaminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPath)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );
        pnlImportarLayout.setVerticalGroup(
            pnlImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImportarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExaminar)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Importar", pnlImportar);

        cbxArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxArchivoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxArchivoMousePressed(evt);
            }
        });
        cbxArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxArchivoActionPerformed(evt);
            }
        });

        jTableInventariado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTableInventariado);

        jLabel3.setText("Escojar el inventario:");

        btnInventariar.setText("Inventariar");
        btnInventariar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventariarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbxArchivo, 0, 419, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInventariar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnInventariar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventario", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        eliminarDatosImportar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jtDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDatosMouseClicked

    }//GEN-LAST:event_jtDatosMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String textoBuscar = txtBuscar.getText();
        eliminarDatos();

        DefaultTableModel m;
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();

        PreparedStatement ps = null;
        ResultSet rs;

        String sql = "SELECT * "
                + "FROM mueble as MUE "
                + "INNER JOIN ubicacion UBI ON UBI.UBIID=MUE.UBIID \n"
                + "INNER JOIN areadependencia AXD ON AXD.ADID=UBI.ADID \n"
                + "INNER JOIN usuario USU ON USU.ADID=AXD.ADID\n"
                + "INNER JOIN color as COL ON COL.COLID = MUE.COLID \n"
                + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID \n"
                + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID \n"
                + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID \n"
                + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID \n"
                + "WHERE MUE.MUEESTADO = 1 "
                + "AND MUE.MUEDESCRIPCION LIKE '%" + textoBuscar + "%' "
                + "OR MUE.MUECODIGOETIQUETA LIKE '%" + textoBuscar + "%' "
                + "OR MUE.MUESERIE = '%" + textoBuscar + "%' "
                + "OR MAR.MARNOMBRE LIKE '%" + textoBuscar + "%'  "
                + "ORDER BY MUE.MUEDESCRIPCION ASC";
        try {
            String titulo[] = {"Nro.", "CÓDIGO", "DESCRIPCIÓN", "CÓDIGO ETIQUETA", "SERIE", "MARCA"};
            m = new DefaultTableModel(null, titulo);
            JTable p = new JTable(m);
            String fila[] = new String[6];

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int index = 1;
            while (rs.next()) {
                fila[0] = String.valueOf(index);
                fila[1] = rs.getString("MUE.MUEID");
                fila[2] = rs.getString("MUE.MUEDESCRIPCION");
                fila[3] = rs.getString("MUE.MUECODIGOETIQUETA");
                fila[4] = rs.getString("MAR.MARNOMBRE");
                fila[5] = rs.getString("MUE.MUESERIE");
                m.addRow(fila);
                index++;
            }
            jtDatos.setModel(m);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(m);
            jtDatos.setRowSorter(ordenar);
            this.jtDatos.setModel(m);

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - cargarDatos()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        File archivoSeleccionado = obtenerArchivo();
        if (archivoSeleccionado != null) {
            try {
                procesarCsv(archivoSeleccionado);
                btnGuardar.setVisible(true);
            } catch (IOException io) {
                System.out.println(io);
            }
        }

    }//GEN-LAST:event_btnExaminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (jtableCSV.getRowCount() > 0) {
            guardarCVSaBDD();
            cargarDatosBatch();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor cargue valores para guardar en la Base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbxArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxArchivoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxArchivoMouseClicked

    private void cbxArchivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxArchivoMousePressed

    }//GEN-LAST:event_cbxArchivoMousePressed

    private void cbxArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxArchivoActionPerformed

    }//GEN-LAST:event_cbxArchivoActionPerformed

    private void btnInventariarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventariarActionPerformed
        String nombreCSV = "" + cbxArchivo.getSelectedItem();

        DefaultTableModel m;
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();

        PreparedStatement ps = null;
        ResultSet rs;

        String sql = "SELECT * FROM mueble AS MUE "
                + "INNER JOIN ubicacion UBI ON UBI.UBIID=MUE.UBIID \n"
                + "INNER JOIN areadependencia AXD ON AXD.ADID=UBI.ADID \n"
                + "INNER JOIN usuario USU ON USU.ADID=AXD.ADID\n"
                + "INNER JOIN color as COL ON COL.COLID = MUE.COLID \n"
                + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID \n"
                + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID \n"
                + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID \n"
                + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID, \n"
                + "batch b INNER JOIN device as D ON b.BATID=D.BATID "
                + "WHERE MUE.MUEESTADO = 1 "
                + "AND B.BATARCHIVOIMPORTADO = '" + nombreCSV + "' "
                + "AND MUE.MUECODIGOETIQUETA = D.DEVIDENTIFIER";
        //        System.out.println("Prueba: " + sql);
        String titulo[] = {"Nro.", "CÓDIGO", "DESCRIPCIÓN", "CÓDIGO ETIQUETA", "OBSERVACIÓN", "SERIE", "MARCA", "UBICACION", "AREA DEPENDENCIA", "USUARIO"};
        m = new DefaultTableModel(null, titulo);
        JTable p = new JTable(m);
        String fila[] = new String[10];
        int index = 1;
        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                //INCLUIR LAS COLUMNAS QUE DESEEN TAMBIEN SE DEBE INCLUIR
                //MAS ABAJO
                fila[0] = String.valueOf(index);
                fila[1] = rs.getString("MUE.MUEID");
                fila[2] = rs.getString("MUE.MUEDESCRIPCION");
                fila[3] = rs.getString("MUE.MUECODIGOETIQUETA");
                fila[4] = "Inventariado...";
                fila[5] = rs.getString("MUE.MUESERIE");
                fila[6] = rs.getString("MAR.MARNOMBRE");
                fila[7] = rs.getString("UBI.UBINOMBRE");
                fila[8] = rs.getString("AXD.ADNOMBRE");
                fila[9] = rs.getString("USU.USUUSUARIO");

                m.addRow(fila);
                index++;
            }
            jTableInventariado.setModel(m);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(m);
            jTableInventariado.setRowSorter(ordenar);
            this.jTableInventariado.setModel(m);

        } catch (SQLException e) {
            System.err.println(e);
        }
        try {

            sql = "SELECT * FROM mueble as MUE "
                    + "INNER JOIN ubicacion UBI ON UBI.UBIID=MUE.UBIID \n"
                    + "INNER JOIN areadependencia AXD ON AXD.ADID=UBI.ADID \n"
                    + "INNER JOIN usuario USU ON USU.ADID=AXD.ADID\n"
                    + "INNER JOIN color as COL ON COL.COLID = MUE.COLID \n"
                    + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID \n"
                    + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID \n"
                    + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID \n"
                    + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID \n"
                    + "WHERE MUE.MUEESTADO = 1 "
                    + "AND MUE.MUECODIGOETIQUETA NOT IN (SELECT D.DEVIDENTIFIER FROM batch as B "
                    + "INNER JOIN device as D ON b.BATID=D.BATID "
                    + "WHERE B.BATARCHIVOIMPORTADO = '" + nombreCSV + "') "
                    + "ORDER BY MUE.MUEDESCRIPCION ASC";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            //            int index = 1;
            while (rs.next()) {
                fila[0] = String.valueOf(index);
                fila[1] = rs.getString("MUE.MUEID");
                fila[2] = rs.getString("MUE.MUEDESCRIPCION");
                fila[3] = rs.getString("MUE.MUECODIGOETIQUETA");
                fila[4] = "No existe fisicamente.";
                m.addRow(fila);
                index++;
            }
            jTableInventariado.setModel(m);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(m);
            jTableInventariado.setRowSorter(ordenar);
            this.jTableInventariado.setModel(m);

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }//GEN-LAST:event_btnInventariarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInventariar;
    private javax.swing.JComboBox<String> cbxArchivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableInventariado;
    public javax.swing.JTable jtDatos;
    private javax.swing.JTable jtableCSV;
    private javax.swing.JPanel pnlImportar;
    private javax.swing.JPanel pnlPrincipal;
    public javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
