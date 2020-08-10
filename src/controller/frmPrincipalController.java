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
import modelo.ConsultaPnlPrincipalMuebles;
import modelo.PnlPrincipal;
import vista.frmPrincipal;
import vista.pnlNuevoMueble;
import vista.pnlPrincipal;
import vista.pnlUsuarioDetalle;
import vista.pnlUsuarioNuevo;

public class frmPrincipalController implements ActionListener {

    pnlPrincipal panelPrincipal;
    pnlNuevoMueble panelNuevoMueble;
    frmPrincipal vPrincipal;
    int clic_tabla = 0;
    
    pnlUsuarioDetalle pud = new pnlUsuarioDetalle();
    pnlUsuarioNuevo punVista  = new pnlUsuarioNuevo();
    PnlUsuarioNuevoController punc = null;

    public frmPrincipalController(pnlPrincipal panelPrincipal, pnlNuevoMueble panelNuevoMueble, frmPrincipal vPrincipal) {
        this.panelPrincipal = panelPrincipal;
        this.panelNuevoMueble = panelNuevoMueble;
        this.vPrincipal = vPrincipal;

        this.vPrincipal.btnNuevoMueble.addActionListener(this);
        this.vPrincipal.btnGuardarNuevoMueble.addActionListener(this);
        this.vPrincipal.btnCancelar.addActionListener(this);
        this.panelPrincipal.btnBuscar.addActionListener(this);

        this.vPrincipal.btnInicio.addActionListener(this);

        this.vPrincipal.btnUsuario.addActionListener(this);
        this.vPrincipal.btnGuardarUsuario.addActionListener(this);
        this.vPrincipal.btnNuevoUsuario.addActionListener(this);

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
        vPrincipal.btnNuevoMueble.setVisible(true);
        vPrincipal.btnNuevoUsuario.setVisible(false);
    }

    public void regresarPantallas() {

        //BOTONES A MOSTAR U OCULTAR
        vPrincipal.pnlNavegacionSuperior.setVisible(true);
        vPrincipal.pnlNavegacionInferior.setVisible(false);
        vPrincipal.btnNuevoMueble.setVisible(true);
        vPrincipal.btnNuevoUsuario.setVisible(false);

        //PANELES A MOSTRA U OCULTAR
        panelPrincipal.setVisible(true);
        panelNuevoMueble.setVisible(false);
        punVista.setVisible(false);
        pud.setVisible(false);
//        pun.setVisible(false);

        //OPCION A MOSTRAR
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
                            try {
                                panelNuevoMueble = new pnlNuevoMueble("" + mueID);
                                panelPrincipal.setVisible(false);
                                vPrincipal.pnlNavegacionSuperior.setVisible(false);
                                vPrincipal.pnlNavegacionInferior.setVisible(true);
                                panelNuevoMueble.setVisible(true);
                                panelNuevoMueble.txtTitulo.setText("Actualización de Mueble");
                                vPrincipal.pnlContenedor.add(panelNuevoMueble);
                                vPrincipal.pnlContenedor.validate();
                            } catch (ParseException ex) {
                                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if (boton.getName().equals("e")) {
                            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.YES_NO_OPTION)) {
                                ConsultaPnlPrincipalMuebles cpm = new ConsultaPnlPrincipalMuebles();
                                PnlPrincipal pp = new PnlPrincipal();
                                pp.setMueId("" + mueID);
                                cpm.eliminarMueble(pp);
                                panelPrincipal.renderizarTablas();
                            }
                        }
                    }
                }
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vPrincipal.btnInicio) {
            regresarPantallas();
        } else if (e.getSource() == vPrincipal.btnNuevoMueble) {
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
                if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(null, "Registro guardado. Deseas guardar otra actividad?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION)) {
                    regresarPantallas();
                } else {
                    //REGRESAR AL PNLNUEVOMUEBLE Y LIMPIRAR LOS TEXT FIELDS
                    //Limpiar los txt y los comboBox para que el usuario ingrese un nuevo registro.
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los registros se actualizaron con éxito.");
                regresarPantallas();
            }
            panelPrincipal.renderizarTablas();
        } else if (e.getSource() == panelPrincipal.btnBuscar) {
            panelPrincipal.cargarRegistrosBuscar(panelPrincipal.txtBuscar.getText());
//            panelPrincipal.rederizarTablas();
        } else if (e.getSource() == vPrincipal.btnUsuario) {
            
            panelPrincipal.setVisible(false);
            panelNuevoMueble.setVisible(false);


            pud.setVisible(true);
            vPrincipal.pnlContenedor.add(pud);

            vPrincipal.pnlNavegacionInferior.setVisible(false);
            vPrincipal.btnNuevoMueble.setVisible(false);
            vPrincipal.btnNuevoUsuario.setVisible(true);

        } else if (e.getSource() == vPrincipal.btnNuevoUsuario) {
            
            panelPrincipal.setVisible(false);
            panelNuevoMueble.setVisible(false);
            pud.setVisible(false);

            punVista.setVisible(true);
            vPrincipal.pnlContenedor.add(punVista);

            vPrincipal.pnlNavegacionSuperior.setVisible(false);
            vPrincipal.pnlNavegacionInferior.setVisible(true);
            vPrincipal.btnNuevoMueble.setVisible(false);
            vPrincipal.btnNuevoUsuario.setVisible(true);
            vPrincipal.btnGuardarNuevoMueble.setVisible(false);
            vPrincipal.btnGuardarUsuario.setVisible(true);

        } else if (e.getSource() == vPrincipal.btnGuardarUsuario) {
//            punVista = new pnlUsuarioNuevo();
            punc = new PnlUsuarioNuevoController(punVista);
            if (!punc.ejecutarGuardar()) {

                panelPrincipal.setVisible(false);
                panelNuevoMueble.setVisible(false);
                punVista.setVisible(false);

                vPrincipal.pnlNavegacionSuperior.setVisible(true);
                vPrincipal.pnlNavegacionInferior.setVisible(false);
                vPrincipal.btnNuevoMueble.setVisible(false);
                vPrincipal.btnNuevoUsuario.setVisible(true);
                pud.setVisible(true);
                pud.renderizarTablaUsuario();
                vPrincipal.pnlContenedor.add(pud);
            }

        }
    }
}
