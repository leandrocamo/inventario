package A_Controller;

import A_ClasesUtilizadas.ClasesUtilizadas;
import A_Modelo.MarcaModel;
import A_Modelo.MarcaQuery;
import A_Tabla.TablaMarca;
import A_Vista.MarcaEdicionView;
import A_Vista.MarcaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public final class MarcaController implements ActionListener {

    private final MarcaView view;
    private final MarcaModel model;
    private final MarcaQuery query;
    private final MarcaEdicionView viewMarcaEdicion;
    private final TablaMarca tabla = new TablaMarca();
    private final ClasesUtilizadas clases = new ClasesUtilizadas();
    private int clic_tabla = 0;

    public MarcaController(MarcaView view, MarcaModel model, MarcaQuery query, MarcaEdicionView viewMarcaEdicion) {
        this.view = view;
        this.model = model;
        this.query = query;
        this.viewMarcaEdicion = viewMarcaEdicion;
        renderizarTabla();
        this.viewMarcaEdicion.btnNoAplica.addActionListener(this);
        this.viewMarcaEdicion.btnGuardarRegistro.addActionListener(this);
        clicJTableMarca();
    }

    public void renderizarTabla() {
        tabla.cargandoRegistrosMarca(this.view.jTableMarca);
        view.lblTotalRegistros.setText("Se encontraron " + this.model.getNroRegistros() + " de " + model.getTotalRegistros() + " registros.");
    }

    public boolean guardarMarca() {
//        model.setMARID(Integer.parseInt(viewMarcaEdicion.txtCodigo.getText()));
        boolean MARNOMBRE = false, MARDESCRIPCION = false;
        if (clases.validarCampoVacio(viewMarcaEdicion.txtNombre.getText(), "Nombre")) {
            model.setMARNOMBRE(viewMarcaEdicion.txtNombre.getText());
            MARNOMBRE = true;
        }
        if (clases.validarCampoVacio(viewMarcaEdicion.txtDescripcion.getText(), "Descripción")) {
            model.setMARDESCRIPCION(viewMarcaEdicion.txtDescripcion.getText());
            MARDESCRIPCION = true;
        }
        if (MARNOMBRE && MARDESCRIPCION) {
            if (model.getMARID() == 0) {
                if (query.guardarRegistro(model)) {
                    if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Desea guardar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                        limpiarParametrosMarca();
                        return false;
                    } else {
                        renderizarTabla();
                        return true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un problema al guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                //ACTUALIZAR
                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                    if (query.actualizarRegistro(model)) {
                        renderizarTabla();
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    public void limpiarParametrosMarca() {
        viewMarcaEdicion.txtDescripcion.setText("");
        viewMarcaEdicion.txtNombre.setText("");
    }

    public void clicJTableMarca() {
        view.jTableMarca.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                clic_tabla = view.jTableMarca.rowAtPoint(evt.getPoint());

                int id = Integer.parseInt("" + view.jTableMarca.getValueAt(clic_tabla, 1));
                int column = view.jTableMarca.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / view.jTableMarca.getRowHeight();

                if (row < view.jTableMarca.getRowCount() && row >= 0
                        && column < view.jTableMarca.getColumnCount() && column >= 0) {
                    Object value = view.jTableMarca.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
//                            System.out.println("presionó editar");
                            viewMarcaEdicion.lblTitulo.setText("Actualización de Marca");
                            model.setMARID(id);

                            query.buscarRegistroID(model);
                            viewMarcaEdicion.txtCodigo.setText("" + model.getMARID());
                            viewMarcaEdicion.txtNombre.setText("" + model.getMARNOMBRE());
                            viewMarcaEdicion.txtDescripcion.setText("" + model.getMARDESCRIPCION());

                            view.btnNuevoMarca.doClick();
                        }
                        if (boton.getName().equals("e")) {
                            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.YES_NO_OPTION)) {
                                model.setMARID(id);
                                query.eliminarRegistro(model);
                                renderizarTabla();

                            }
                        }
                    }
                }
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewMarcaEdicion.btnGuardarRegistro) {
            if (guardarMarca()) {
                viewMarcaEdicion.btnCancelar.doClick();
            }
        }
    }

}
