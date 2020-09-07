package A_Controller;

import A_Modelo.MueblesModel;
import A_Modelo.MueblesNuevoModel;
import A_Modelo.MueblesNuevoQuery;
import A_Modelo.MueblesPrincipalModel;
import A_Modelo.MueblesPrincipalQuery;
import A_Modelo.MueblesQuery;
import A_Tabla.TablaMuebles;
import A_Vista.MueblesNuevoView;
import A_Vista.MueblesPrincipalView;
import A_Vista.MueblesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MueblesController implements ActionListener {

    private MueblesView view;
    private MueblesModel model;
    private MueblesQuery query;

    private MueblesPrincipalView viewMueblesPrincipal = new MueblesPrincipalView();
    private MueblesPrincipalModel modelMueblesPrincipal = new MueblesPrincipalModel();
    private MueblesPrincipalQuery queryMueblesPrincipal = new MueblesPrincipalQuery();
    private MueblesPrincipalController controllerMueblesPrincipal = new MueblesPrincipalController(viewMueblesPrincipal, modelMueblesPrincipal, queryMueblesPrincipal);

    private MueblesNuevoView viewMueblesNuevo = new MueblesNuevoView();
    private MueblesNuevoModel modelMueblesNuevo = new MueblesNuevoModel();
    private MueblesNuevoQuery queryMueblesNuevo = new MueblesNuevoQuery();
    private MueblesNuevoController controllerMueblesNuevo = new MueblesNuevoController(viewMueblesNuevo, modelMueblesNuevo, queryMueblesNuevo);
    
    private int clic_tabla = 0;

//    
    public MueblesController(MueblesView view, MueblesModel model, MueblesQuery query) {
        this.view = view;
        this.model = model;
        this.query = query;
        iniciarVista();

        this.view.btnNuevo.addActionListener(this);
        this.viewMueblesNuevo.btnCancelar.addActionListener(this);
        this.view.btnOpcionBuscar.addActionListener(this);

    }

    public void iniciarVista() {
        view.pnlMenuSuperior.setVisible(true);
        viewMueblesPrincipal.setVisible(true);
        viewMueblesNuevo.setVisible(false);
//        view.setVisible(false);
//        p2.setVisible(false);
//        controllerMueblesPrincipal.iniciarVista();
        view.PnlContenedor.add(viewMueblesPrincipal);
        view.PnlContenedor.validate();
        clicJTableMuebles();
    }

    public void clicJTableMuebles() {
        viewMueblesPrincipal.jTableMuebles.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                clic_tabla = viewMueblesPrincipal.jTableMuebles.rowAtPoint(evt.getPoint());

                int mueID = Integer.parseInt("" + viewMueblesPrincipal.jTableMuebles.getValueAt(clic_tabla, 1));
                int column = viewMueblesPrincipal.jTableMuebles.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / viewMueblesPrincipal.jTableMuebles.getRowHeight();

                if (row < viewMueblesPrincipal.jTableMuebles.getRowCount() && row >= 0
                        && column < viewMueblesPrincipal.jTableMuebles.getColumnCount() && column >= 0) {
                    Object value = viewMueblesPrincipal.jTableMuebles.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
//                            System.out.println("presionó editar");
//                            JOptionPane.showMessageDialog(null, "Presionó editar con ID " + mueID);
                            view.pnlMenuSuperior.setVisible(false);
                            viewMueblesPrincipal.setVisible(false);
                            viewMueblesNuevo.setVisible(true);
                            viewMueblesNuevo.lblTitulo.setText("Actualización del mueble");
                            modelMueblesNuevo.setMUEID(mueID);
                            try {
                                queryMueblesNuevo.listarMuebleID(modelMueblesNuevo);
                                controllerMueblesNuevo.cargarDatosMueble();
                            } catch (ParseException ex) {
                                Logger.getLogger(MueblesController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            view.PnlContenedor.add(viewMueblesNuevo);
                            view.PnlContenedor.validate();
                        }
                        if (boton.getName().equals("e")) {
                            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.YES_NO_OPTION)) {
                                modelMueblesNuevo.setMUEID(mueID);
                                queryMueblesNuevo.eliminarMueble(modelMueblesNuevo);
                                controllerMueblesPrincipal.renderizarTabla();
                            }
                        }
                    }
                }
            }

        });
    }

//   
    @Override
    public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Not-isSelected.", "Información", JOptionPane.INFORMATION_MESSAGE);
        if (e.getSource() == view.btnNuevo) {
            view.pnlMenuSuperior.setVisible(false);
            viewMueblesPrincipal.setVisible(false);
            viewMueblesNuevo.setVisible(true);
            viewMueblesNuevo.lblTitulo.setText("Registro de nuevo mueble");
            controllerMueblesNuevo.limpiarPantallaMueble();
            view.PnlContenedor.add(viewMueblesNuevo);
            view.PnlContenedor.validate();

            //MANDO CERO(0) para validar que el nuevo registro, si mando código es porque es para editar
            modelMueblesNuevo.setMUEID(0);
        }
        if (e.getSource() == viewMueblesNuevo.btnCancelar) {
            controllerMueblesPrincipal.renderizarTabla();
            view.pnlMenuSuperior.setVisible(true);
            viewMueblesPrincipal.setVisible(true);
            viewMueblesNuevo.setVisible(false);

            view.PnlContenedor.add(viewMueblesPrincipal);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == view.btnOpcionBuscar) {
            if (view.btnOpcionBuscar.isSelected()) {
                viewMueblesPrincipal.pnlBuscarTexto.setVisible(false);
                viewMueblesPrincipal.pnlBuscarCombo.setVisible(true);
            } else {
                viewMueblesPrincipal.pnlBuscarTexto.setVisible(true);
                viewMueblesPrincipal.pnlBuscarCombo.setVisible(false);
            }
        }

//        
    }

}
