package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import vista.frmPrincipal;
import vista.pnlNuevoMueble;
import vista.pnlPrincipal;

public class frmPrincipalController implements ActionListener {

    pnlPrincipal panelPrincipal;
    pnlNuevoMueble panelNuevoMueble;
    frmPrincipal vPrincipal;
    int clic_tabla = 0;

    public frmPrincipalController(pnlPrincipal panelPrincipal, pnlNuevoMueble panelNuevoMueble, frmPrincipal vPrincipal) {
        this.panelPrincipal = panelPrincipal;
        this.panelNuevoMueble = panelNuevoMueble;
        this.vPrincipal = vPrincipal;

        this.vPrincipal.btnNuevoMueble.addActionListener(this);
        this.vPrincipal.btnGuardarNuevoMueble.addActionListener(this);
        this.vPrincipal.btnCancelar.addActionListener(this);
        this.panelPrincipal.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        vPrincipal.setVisible(true);
        vPrincipal.setExtendedState(6);
        vPrincipal.setTitle("SGI || Sistema de Gestión de Inventario");
        panelPrincipal.setVisible(true);
        panelNuevoMueble.setVisible(false);
        vPrincipal.pnlContenedor.add(panelPrincipal);
        vPrincipal.pnlNavegacionInferior.setVisible(false);
        clicJTableMuebles();
    }

    public void regresarPantallas() {
        panelPrincipal.setVisible(true);
        vPrincipal.pnlNavegacionSuperior.setVisible(true);
        vPrincipal.pnlNavegacionInferior.setVisible(false);
        panelNuevoMueble.setVisible(false);
        vPrincipal.pnlContenedor.add(panelPrincipal);
        vPrincipal.pnlContenedor.validate();
    }

    public void clicJTableMuebles() {
        panelPrincipal.jTableMuebles.addMouseListener(new MouseAdapter() {

//            @Override
            public void mouseClicked(MouseEvent evt) {
                clic_tabla = panelPrincipal.jTableMuebles.rowAtPoint(evt.getPoint());

                int mueID = Integer.parseInt("" + panelPrincipal.jTableMuebles.getValueAt(clic_tabla, 1));

                int column = panelPrincipal.jTableMuebles.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / panelPrincipal.jTableMuebles.getRowHeight();
                if (row < panelPrincipal.jTableMuebles.getRowCount() && row >= 0
                        && column < panelPrincipal.jTableMuebles.getColumnCount() && column >= 0) {
                    Object value = panelPrincipal.jTableMuebles.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
//                            System.out.println("Click en el boton modificar > " + mueID);                           
                            try {
                                panelNuevoMueble = new pnlNuevoMueble("" + mueID);
                            } catch (ParseException ex) {
                                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            panelPrincipal.setVisible(false);
                            vPrincipal.pnlNavegacionSuperior.setVisible(false);
                            vPrincipal.pnlNavegacionInferior.setVisible(true);
                            panelNuevoMueble.setVisible(true);
                            panelNuevoMueble.txtTitulo.setText("Actualización de Mueble");
                            vPrincipal.pnlContenedor.add(panelNuevoMueble);
                            vPrincipal.pnlContenedor.validate();
                        }
                        if (boton.getName().equals("e")) {
                            //JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            System.out.println("Click en el boton eliminar > " + mueID);
                        }
                    }
                }
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vPrincipal.btnNuevoMueble) {
            try {
                panelNuevoMueble = new pnlNuevoMueble(null);
            } catch (ParseException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            panelPrincipal.setVisible(false);
            vPrincipal.pnlNavegacionSuperior.setVisible(false);
            vPrincipal.pnlNavegacionInferior.setVisible(true);
            panelNuevoMueble.setVisible(true);
            panelNuevoMueble.txtTitulo.setText("Creación de nuevo mueble");
            vPrincipal.pnlContenedor.add(panelNuevoMueble);
            vPrincipal.pnlContenedor.validate();
        } else if (e.getSource() == vPrincipal.btnCancelar) {
            regresarPantallas();
        } else if (e.getSource() == vPrincipal.btnGuardarNuevoMueble) {
            if (panelNuevoMueble.guardarRegistro() && panelNuevoMueble.marcaGuardar) {
                if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(null, "Registro guardado. Deseas guardar otra actividad?")) {
                    regresarPantallas();
                } else {
                    //REGRESAR AL PNLNUEVOMUEBLE Y LIMPIRAR LOS TEXT FIELDS
                    //Limpiar los txt y los comboBox para que el usuario ingrese un nuevo registro.
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los registros se actualizaron con éxito.");
                regresarPantallas();
            }
            panelPrincipal.rederizarTablas();
        } else if (e.getSource() == panelPrincipal.btnBuscar) {
            panelPrincipal.cargarRegistrosBuscar(panelPrincipal.txtBuscar.getText());
//            panelPrincipal.rederizarTablas();
        }
    }
}
