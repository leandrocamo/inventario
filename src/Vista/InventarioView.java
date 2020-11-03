/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ClasesUtilizadas.Conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author camo
 */
public class InventarioView extends javax.swing.JPanel {

    Conexion conexion = new Conexion();

    public InventarioView() {
        initComponents();
        btnGuardarCSV.setVisible(true);
        cargarDocumentoInventariado();
        lstDocumentoInventarioID.setVisible(false);
        cargarInventariado(null);
    }

    

    public void cargarDocumentoInventariado() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM documentoinventario WHERE DITESTADO = 1 ORDER BY DIFECHA DESC";
        lstDocumentoInventario.removeAll();
        lstDocumentoInventarioID.removeAllItems();
        ArrayList array = new ArrayList();
        DefaultListModel modelo = new DefaultListModel();
//        ArrayList arrayID = new ArrayList();
//        DefaultListModel modeloID = new DefaultListModel();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                array.add(rs.getObject("DIFECHA") + " - " + rs.getObject("DIARCHIVOIMPORTADO"));
                modelo.addElement(array);
                lstDocumentoInventarioID.addItem("" + rs.getObject("DIID"));
//                arrayID.add(rs.getObject("DIID"));
//                modeloID.addElement(arrayID);
            }
            modelo.removeAllElements();
//            modeloID.removeAllElements();
            for (int i = 0; i < array.size(); i++) {
                modelo.addElement(array.get(i));
//                modeloID.addElement(arrayID.get(i));
            }
            lstDocumentoInventario.setModel(modelo);
            //lstDocumentoInventarioID.setModel(modeloID);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo los registros del documentoinventario.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - cargarDocumentoInventariado().");
            } catch (SQLException e) {
                System.err.println(e);
            }
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
            //System.out.println("Archivo: " + fileName);
            return archivoSeleccionado;
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
        jTableCSV.setModel(modeloTabla);
        input.close();
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
        //Inicializamos las variables Statement
        PreparedStatement ps = null;
        //Abrimos la conexion a la BDD
        Connection con = conexion.getConexion();
        //Guardamos en una varibale la ubicación del arhivo CSV
        String path = txtPath.getText();
        //Guardamos en un string el id null del documento inventariado.
        String idDi = null;
        //Guardamos en una variable la fecha y hora actual
        String fecha = capturarfechayhora();
        //Guardamos en una variable la sentencia SQL para insertar en la tabla documentoindentario
        String sql = "INSERT INTO documentoinventario (DIID, DIFECHA, DIARCHIVOIMPORTADO, DITESTADO) "
                + "VALUES (NULL, '" + fecha + "', '" + path + "', '1')";
        try {
            //Ejecutamos el Statement con la SQL
            ps = con.prepareStatement(sql);
            //Ejecutamos el SQL
            ps.execute();
        } catch (SQLException e) {
            //Si hay un error en el try, presenta el error
            System.err.println(e);
        }
        //Inicializamos las variables ResultSet para consultar el id del documentoinventariado
        ResultSet rs = null;
        //Guardamos en una variable la sentencia SQL para consulta el ID del documentoindentario guardado
        sql = "SELECT * FROM documentoinventario WHERE DIARCHIVOIMPORTADO='" + path + "' AND DIFECHA = '" + fecha + "' ";
        try {
            //Ejecutamos el Statement con la SQL
            ps = con.prepareStatement(sql);
            //Ejecutamos el SQL
            rs = ps.executeQuery();
            //Si existe un id guardar en idDi, gracias al rs
            while (rs.next()) {
                idDi = "" + rs.getObject("DIID");
            }
        } catch (SQLException ex) {
            //Si hay un error en el try, presenta el error
            JOptionPane.showMessageDialog(null, "No se obtuvo el ID del documentoinventario.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
        }
//Con este for recorremos en el Jtable, los registros cargados.
        for (int i = 0; i < jTableCSV.getRowCount(); i++) {
            //Por cada fila del JTable empezamos a ingresar el mueble capturado con la máquina de etiquetas.
            sql = "INSERT INTO equipoinventariado (EIID, DIID, EITYPE, EIEVIDENTIFIER, EISIGNAL, EISEENCOUNT, EIFIRSTSEEN, EILASTSEEN, EIASCII, EIESTADO) "
                    + "VALUES (NULL, '" + idDi + "', '" + jTableCSV.getValueAt(i, 0) + "', "
                    + "'" + jTableCSV.getValueAt(i, 1) + "', '" + jTableCSV.getValueAt(i, 2) + "', "
                    + "'" + jTableCSV.getValueAt(i, 3) + "', '" + jTableCSV.getValueAt(i, 4) + "', "
                    + "'" + jTableCSV.getValueAt(i, 5) + "', '" + jTableCSV.getValueAt(i, 6) + "', '1');";
            try {
                //Ejecutamos el Statement con la SQL
                ps = con.prepareStatement(sql);
                //Ejecutamos el SQL
                ps.execute();
            } catch (SQLException e) {
                //Si hay un error en el try, presenta el error
                System.err.println(e);
            }
        }
        //Si todo sale bien aparece un mensaje de OK
        JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        //Eleiminar los datos que contiene el JTable
        eliminarDatosImportar();

        try {
            //Cerramos la conexión de la base de datos
            con.close();
            //Imprimimos por consola que se cerró la conexxión
            System.out.println("Conexión cerrada - guardarCVSaBDD().");
        } catch (SQLException e) {
            //Si hay un error en el try, presenta el error
            System.err.println(e);
        }
    }

    public String capturarfechayhora() {
        String fechahora = null;
        Date fechaActual = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        fechahora = formatofecha.format(fechaActual);
        return fechahora;
    }

    public void eliminarDatosImportar() {
        DefaultTableModel tb = (DefaultTableModel) jTableCSV.getModel();
        int a = jTableCSV.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void cargarInventariado(String id) {
//        String nombreCSV = "" + cbxArchivo.getSelectedItem();

        DefaultTableModel m;
        Connection con = conexion.getConexion();

        PreparedStatement ps = null;
        ResultSet rs;

        String sql = "SELECT * FROM mueble MUE "
                + "INNER JOIN usuxubi UXU ON UXU.USUXUBIID=MUE.USUXUBIID \n"
                + "INNER JOIN usuario USU ON UXU.USUID=USU.USUID \n"
                + "INNER JOIN ubicacion UBI ON UXU.UBIID=UBI.UBIID \n"
                + "INNER JOIN areadependencia AXD ON AXD.ADID=UBI.ADID \n"
                + "INNER JOIN color as COL ON COL.COLID = MUE.COLID \n"
                + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID \n"
                + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID \n"
                + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID \n"
                + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID, \n"
                + "documentoinventario DI INNER JOIN equipoinventariado AS EI ON DI.DIID = EI.DIID\n"
                + "WHERE MUE.MUEESTADO = 1 AND DI.DITESTADO = 1 AND DI.DIID = " + id + " "
                + "AND MUE.MUECODIGOETIQUETA = EI.EIEVIDENTIFIER";
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
                fila[9] = rs.getString("USU.USUAPELLIDOS") + " " + rs.getString("USU.USUNOMBRES");

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
            if (id != null) {
                sql = "SELECT * FROM mueble MUE "
                        + "INNER JOIN usuxubi UXU ON UXU.USUXUBIID=MUE.USUXUBIID \n"
                        + "INNER JOIN usuario USU ON UXU.USUID=USU.USUID \n"
                        + "INNER JOIN ubicacion UBI ON UXU.UBIID=UBI.UBIID \n"
                        + "INNER JOIN areadependencia AXD ON AXD.ADID=UBI.ADID \n"
                        + "INNER JOIN color as COL ON COL.COLID = MUE.COLID \n"
                        + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID \n"
                        + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID \n"
                        + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID \n"
                        + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID \n"
                        + "WHERE MUE.MUEESTADO = 1 "
                        + "AND MUE.MUECODIGOETIQUETA NOT IN (SELECT D.EIEVIDENTIFIER FROM documentoinventario as B "
                        + "INNER JOIN equipoinventariado as D ON B.DIID=D.DIID "
                        + "WHERE B.DIID = " + id + ") "
                        + "ORDER BY MUE.MUEDESCRIPCION ASC";
            }
//            System.out.println("" + sql);

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
                System.out.println("Conexión cerrada - cargarInventariado()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    /*
    
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlCargarCSV = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCSV = new javax.swing.JTable();
        btnExaminar = new javax.swing.JButton();
        txtPath = new javax.swing.JTextField();
        btnGuardarCSV = new javax.swing.JButton();
        pnlInventariar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInventariado = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstDocumentoInventario = new javax.swing.JList<>();
        lstDocumentoInventarioID = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnEliminarCSVCargado = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnExportarCSV = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnRegresarInventario = new javax.swing.JButton();

        jTableCSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableCSV.setEnabled(false);
        jScrollPane2.setViewportView(jTableCSV);

        btnExaminar.setText("Examinar");
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });

        txtPath.setEnabled(false);

        btnGuardarCSV.setText("Guardar en BDD");
        btnGuardarCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCargarCSVLayout = new javax.swing.GroupLayout(pnlCargarCSV);
        pnlCargarCSV.setLayout(pnlCargarCSVLayout);
        pnlCargarCSVLayout.setHorizontalGroup(
            pnlCargarCSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCargarCSVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCargarCSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addGroup(pnlCargarCSVLayout.createSequentialGroup()
                        .addComponent(btnExaminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarCSV)))
                .addContainerGap())
        );
        pnlCargarCSVLayout.setVerticalGroup(
            pnlCargarCSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCargarCSVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCargarCSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExaminar)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCSV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Importar", pnlCargarCSV);

        jTableInventariado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableInventariado);

        lstDocumentoInventario.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstDocumentoInventario.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDocumentoInventarioValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstDocumentoInventario);

        lstDocumentoInventarioID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Archivo CSV cargado:");

        btnEliminarCSVCargado.setText("Eliminar");
        btnEliminarCSVCargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCSVCargadoActionPerformed(evt);
            }
        });

        btnExportarCSV.setText("Exportar CSV");
        btnExportarCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarCSVActionPerformed(evt);
            }
        });
        jPanel1.add(btnExportarCSV);

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        javax.swing.GroupLayout pnlInventariarLayout = new javax.swing.GroupLayout(pnlInventariar);
        pnlInventariar.setLayout(pnlInventariarLayout);
        pnlInventariarLayout.setHorizontalGroup(
            pnlInventariarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventariarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInventariarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInventariarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarCSVCargado))
                    .addComponent(lstDocumentoInventarioID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInventariarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInventariarLayout.setVerticalGroup(
            pnlInventariarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventariarLayout.createSequentialGroup()
                .addGroup(pnlInventariarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInventariarLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lstDocumentoInventarioID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlInventariarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnEliminarCSVCargado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                    .addGroup(pnlInventariarLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventariar", pnlInventariar);

        btnRegresarInventario.setText("Regresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresarInventario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresarInventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        File archivoSeleccionado = obtenerArchivo();
        if (archivoSeleccionado != null) {
            try {
                procesarCsv(archivoSeleccionado);
                btnGuardarCSV.setVisible(true);
            } catch (IOException io) {
                System.out.println(io);
            }
        }
    }//GEN-LAST:event_btnExaminarActionPerformed

    private void btnGuardarCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCSVActionPerformed
        if (jTableCSV.getRowCount() > 0) {
            guardarCVSaBDD();
            cargarDocumentoInventariado();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor cargue valores para guardar en la Base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarCSVActionPerformed

    private void lstDocumentoInventarioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDocumentoInventarioValueChanged
        lstDocumentoInventarioID.setSelectedIndex(lstDocumentoInventario.getSelectedIndex());
//        JOptionPane.showMessageDialog(null, lstDocumentoInventario.getSelectedIndex());
        if (lstDocumentoInventario.getSelectedIndex() == -1) {
            cargarInventariado(null);       
        } else {
            cargarInventariado("" + lstDocumentoInventarioID.getSelectedItem());
        }
    }//GEN-LAST:event_lstDocumentoInventarioValueChanged

    private void btnExportarCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarCSVActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = fileChooser.showSaveDialog(this);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File archivoCSV = fileChooser.getSelectedFile();
        try {
            //File archivo = new File("datos.xls");
            TableModel modelo = jTableInventariado.getModel();
            FileWriter excel = new FileWriter(archivoCSV + ".xls");
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                excel.write(modelo.getColumnName(i) + ";");
            }
            excel.write("\n");
            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    String data = (String) modelo.getValueAt(i, j);
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
        }

    }//GEN-LAST:event_btnExportarCSVActionPerformed

    private void btnEliminarCSVCargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCSVCargadoActionPerformed
        /*if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.YES_NO_OPTION)) {
                                modelMueblesNuevo.setMUEID(mueID);
                                queryMueblesNuevo.eliminarMueble(modelMueblesNuevo);
                                controllerMueblesPrincipal.renderizarTabla();
                            }*/
        if (lstDocumentoInventarioID.getSelectedIndex() > -1 && JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.YES_NO_OPTION)) {
            PreparedStatement ps = null;
            PreparedStatement ps2 = null;
            Connection con = conexion.getConexion();
            String sql = "DELETE FROM equipoinventariado WHERE DIID=" + lstDocumentoInventarioID.getSelectedItem();
            String sql2 = "DELETE FROM documentoinventario WHERE DIID=" + lstDocumentoInventarioID.getSelectedItem();

            try {
                ps = con.prepareStatement(sql);
                ps.execute();
                ps2 = con.prepareStatement(sql2);
                ps2.execute();
                cargarInventariado(null);
                cargarDocumentoInventariado();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                try {
                    con.close();
                    System.out.println("Conexión cerrada - btnEliminarCSVCargado");
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }else
            JOptionPane.showMessageDialog(null, "No hay registros a eliminar","Error",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnEliminarCSVCargadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargarInventariado(null);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarCSVCargado;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnExportarCSV;
    private javax.swing.JButton btnGuardarCSV;
    public javax.swing.JButton btnRegresarInventario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCSV;
    private javax.swing.JTable jTableInventariado;
    private javax.swing.JList<String> lstDocumentoInventario;
    private javax.swing.JComboBox<String> lstDocumentoInventarioID;
    private javax.swing.JPanel pnlCargarCSV;
    private javax.swing.JPanel pnlInventariar;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
