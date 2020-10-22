package A_Controller;

import A_ClasesUtilizadas.ClasesUtilizadas;
import A_Modelo.CuentaContableModel;
import A_Modelo.CuentaContableQuery;
import A_Tabla.TablaCuentaContable;
import A_Vista.CuentaContableEdicionView;
import A_Vista.CuentaContableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CuentaContableController implements ActionListener {

    private final CuentaContableView view;
    private final CuentaContableModel model;
    private final CuentaContableQuery query;
    private final CuentaContableEdicionView viewCCEdicion;
    private final TablaCuentaContable tabla = new TablaCuentaContable();
    private final ClasesUtilizadas clases = new ClasesUtilizadas();
    private int clic_tabla = 0;
    private String titulo = "Cuenta Contable";

    public CuentaContableController(CuentaContableView view, CuentaContableModel model, CuentaContableQuery query, CuentaContableEdicionView viewCCEdicion) {
        this.view = view;
        this.model = model;
        this.query = query;
        this.viewCCEdicion = viewCCEdicion;
        
        renderizarTabla();
        this.viewCCEdicion.btnNoAplica.addActionListener(this);
        this.viewCCEdicion.btnGuardarRegistro.addActionListener(this);
        clicJTableColor();
    }

  

    public void renderizarTabla() {
        tabla.cargandoRegistros(this.view.jTable);
        view.lblTotalRegistros.setText("Se encontraron " + this.model.getNroRegistros() + " de " + model.getTotalRegistros() + " registros.");
    }

    public boolean guardarRegistro() {
        boolean nombre = false, descripcion = false, idcuentacontable = false;
        if (clases.validarCampoVacio(viewCCEdicion.txtNombre.getText(), "Nombre")) {
            model.setNombre(viewCCEdicion.txtNombre.getText());
            nombre = true;
        }
        if (clases.validarCampoVacio(viewCCEdicion.txtDescripcion.getText(), "Descripción")) {
            model.setDescripcion(viewCCEdicion.txtDescripcion.getText());
            descripcion = true;
        }
        if (clases.validarCampoVacio(viewCCEdicion.txtCuentaContable.getText(), "Cuenta Contable")) {
            model.setIdcuentacontable(viewCCEdicion.txtCuentaContable.getText());
            idcuentacontable = true;
        }
        if (nombre && descripcion && idcuentacontable) {
            if (model.getId() == 0) {
                if (query.guardarRegistro(model)) {
                    if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Desea guardar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                        limpiarParametros();
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

    public void limpiarParametros() {
        viewCCEdicion.txtDescripcion.setText("");
        viewCCEdicion.txtNombre.setText("");
    }

    public void clicJTableColor() {
        view.jTable.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                clic_tabla = view.jTable.rowAtPoint(evt.getPoint());

                int id = Integer.parseInt("" + view.jTable.getValueAt(clic_tabla, 1));
                int column = view.jTable.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / view.jTable.getRowHeight();

                if (row < view.jTable.getRowCount() && row >= 0
                        && column < view.jTable.getColumnCount() && column >= 0) {
                    Object value = view.jTable.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
//                            System.out.println("presionó editar");
                            viewCCEdicion.lblTitulo.setText("Actualización de "+titulo);
                            model.setId(id);

                            query.buscarRegistroID(model);
                            viewCCEdicion.txtCodigo.setText("" + model.getId());
                            viewCCEdicion.txtNombre.setText("" + model.getNombre());
                            viewCCEdicion.txtDescripcion.setText("" + model.getDescripcion());
                            viewCCEdicion.txtCuentaContable.setText("" + model.getIdcuentacontable());

                            view.btnNuevo.doClick();
                        }
                        if (boton.getName().equals("e")) {
                            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.YES_NO_OPTION)) {
                                model.setId(id);
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
        if (e.getSource() == viewCCEdicion.btnGuardarRegistro) {
            if (guardarRegistro()) {
                viewCCEdicion.btnCancelar.doClick();
            }
        }
    }

}
