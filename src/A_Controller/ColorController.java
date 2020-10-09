package A_Controller;

import A_ClasesUtilizadas.ClasesUtilizadas;
import A_Modelo.MarcaModel;
import A_Modelo.ColorQuery;
import A_Tabla.TablaColor;
import A_Vista.ColorEdicionView;
import A_Vista.ColorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public final class ColorController implements ActionListener {

    private final ColorView view;
    private final MarcaModel model;
    private final ColorQuery query;
    private final ColorEdicionView viewColorEdicion;
    private final TablaColor tabla = new TablaColor();
    private final ClasesUtilizadas clases = new ClasesUtilizadas();
    private int clic_tabla = 0;

    public ColorController(ColorView view, MarcaModel model, ColorQuery query, ColorEdicionView viewColorEdicion) {
        this.view = view;
        this.model = model;
        this.query = query;
        this.viewColorEdicion = viewColorEdicion;
        renderizarTabla();
        this.viewColorEdicion.btnNoAplica.addActionListener(this);
        this.viewColorEdicion.btnGuardarRegistro.addActionListener(this);
        clicJTableColor();
    }

    public void renderizarTabla() {
        tabla.cargandoRegistrosColor(this.view.jTableColor);
        view.lblTotalRegistros.setText("Se encontraron " + this.model.getNroRegistros() + " de " + model.getTotalRegistros() + " registros.");
    }

    public boolean guardarColor() {
        boolean MARNOMBRE = false, MARDESCRIPCION = false;
        if (clases.validarCampoVacio(viewColorEdicion.txtNombre.getText(), "Nombre")) {
            model.setMARNOMBRE(viewColorEdicion.txtNombre.getText());
            MARNOMBRE = true;
        }
        if (clases.validarCampoVacio(viewColorEdicion.txtDescripcion.getText(), "Descripción")) {
            model.setMARDESCRIPCION(viewColorEdicion.txtDescripcion.getText());
            MARDESCRIPCION = true;
        }
        if (MARNOMBRE && MARDESCRIPCION) {
            if (model.getMARID() == 0) {
                if (query.guardarRegistro(model)) {
                    if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Desea guardar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                        limpiarParametrosColor();
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

    public void limpiarParametrosColor() {
        viewColorEdicion.txtDescripcion.setText("");
        viewColorEdicion.txtNombre.setText("");
    }

    public void clicJTableColor() {
        view.jTableColor.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                clic_tabla = view.jTableColor.rowAtPoint(evt.getPoint());

                int id = Integer.parseInt("" + view.jTableColor.getValueAt(clic_tabla, 1));
                int column = view.jTableColor.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / view.jTableColor.getRowHeight();

                if (row < view.jTableColor.getRowCount() && row >= 0
                        && column < view.jTableColor.getColumnCount() && column >= 0) {
                    Object value = view.jTableColor.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
//                            System.out.println("presionó editar");
                            viewColorEdicion.lblTitulo.setText("Actualización de Color");
                            model.setMARID(id);

                            query.buscarRegistroID(model);
                            viewColorEdicion.txtCodigo.setText("" + model.getMARID());
                            viewColorEdicion.txtNombre.setText("" + model.getMARNOMBRE());
                            viewColorEdicion.txtDescripcion.setText("" + model.getMARDESCRIPCION());

                            view.btnNuevoColor.doClick();
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
        if (e.getSource() == viewColorEdicion.btnGuardarRegistro) {
            if (guardarColor()) {
                viewColorEdicion.btnCancelar.doClick();
            }
        }
    }

}
