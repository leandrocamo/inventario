package Controller;

import ClasesUtilizadas.ClasesUtilizadas;
import Modelo.UbicacionModel;
import Modelo.UbicacionQuery;
import Tabla.TablaUbicacion;
import Vista.UbicacionEdicionView;
import Vista.UbicacionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public final class UbicacionController implements ActionListener {

    private final UbicacionView view;
    private final UbicacionModel model;
    private final UbicacionQuery query;
    private final UbicacionEdicionView viewUbicacionEdicion;
    private final TablaUbicacion tabla = new TablaUbicacion();
    private final ClasesUtilizadas clases = new ClasesUtilizadas();
    private String selectAllUbicacion = "SELECT UBI.UBIID, AD.ADNOMBRE, UBI.UBINOMBRE FROM ubicacion UBI "
            + "INNER JOIN areadependencia AD ON UBI.ADID = AD.ADID "
            + "WHERE UBI.UBIESTADO = 1 AND AD.ADESTADO = 1 "
            + "ORDER BY AD.ADNOMBRE, UBI.UBINOMBRE ASC";
    private int clic_tabla = 0;

    public UbicacionController(UbicacionView view, UbicacionModel model, UbicacionQuery query, UbicacionEdicionView viewUbicacionEdicion) {
        this.view = view;
        this.model = model;
        this.query = query;
        this.viewUbicacionEdicion = viewUbicacionEdicion;

        renderizarTabla(selectAllUbicacion);
        clicJTable();

        this.view.btnBuscar.addActionListener(this);
        this.viewUbicacionEdicion.btnGuardarRegistro.addActionListener(this);
        this.viewUbicacionEdicion.btnNoAplica.addActionListener(this);
    }

    public void renderizarTabla(String sql) {
        tabla.cargandoRegistros(this.view.jTable, sql);
        view.lblTotalRegistros.setText("Se encontraron " + tabla.getTotalRegistros() + " de " + query.totalRegistros(selectAllUbicacion));
    }

    public boolean insertarRegistro(String sql) {
        boolean ubicacion = false, areadependencia = false;
        if (clases.validarCampoVacio(viewUbicacionEdicion.txtUbicacion.getText(), "Ubicación")) {
            model.setUbicacion(viewUbicacionEdicion.txtUbicacion.getText());
            ubicacion = true;
        }
        if (clases.validarCombo(viewUbicacionEdicion.cbxAreaDependencia.getSelectedIndex(), "Área Dependencia")) {
            model.setAreadependenciaID(Integer.parseInt("" + viewUbicacionEdicion.cbxAreaDependenciaID.getSelectedItem()));
            areadependencia = true;
        }
        if (ubicacion && areadependencia) {
            if (query.guardarRegistro(model, sql)) {
                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Desea guardar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                    limpiarParametrosUbicacion();
                    return false;
                } else {
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema al guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean guardarRegistro(String sql) {
        boolean ubicacion = false, areadependencia = false;
        if (clases.validarCampoVacio(viewUbicacionEdicion.txtUbicacion.getText(), "Nombre")) {
            model.setUbicacion(viewUbicacionEdicion.txtUbicacion.getText());
            ubicacion = true;
        }
        if (clases.validarCombo(viewUbicacionEdicion.cbxAreaDependencia.getSelectedIndex(), "Área Dependencia")) {
            model.setAreadependenciaID(Integer.parseInt("" + viewUbicacionEdicion.cbxAreaDependenciaID.getSelectedItem()));
            areadependencia = true;
        }
        if (ubicacion && areadependencia) {
//            ACTUALIZAR
            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                if (query.actualizarRegistro(model, sql)) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un problema al guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void limpiarParametrosUbicacion() {
        viewUbicacionEdicion.cbxAreaDependencia.setSelectedIndex(0);
        viewUbicacionEdicion.txtUbicacion.setText("");
    }

    public void clicJTable() {
        view.jTable.addMouseListener(new MouseAdapter() {

            @Override
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

                        String opcion = "Ubicación";

                        if (boton.getName().equals("m")) {
//                            JOptionPane.showMessageDialog(null, "PRESIONÓ EDITAR","Advertencia", JOptionPane.INFORMATION_MESSAGE);
                            String editar = "SELECT UBI.UBIID, AD.ADID, UBI.UBINOMBRE FROM ubicacion UBI\n"
                                    + "INNER JOIN areadependencia AD ON UBI.ADID = AD.ADID \n"
                                    + "WHERE UBI.UBIESTADO = 1 AND AD.ADESTADO = 1 \n"
                                    + "AND UBI.UBIID=";

                            viewUbicacionEdicion.lblTitulo.setText("Actualización de " + opcion);
                            model.setId(id);
                            view.btnNuevo.doClick();
                            query.buscarRegistroID(model, editar + model.getId());
                            viewUbicacionEdicion.txtCodigo.setText("" + model.getId());
                            viewUbicacionEdicion.txtUbicacion.setText("" + model.getUbicacion());
                            viewUbicacionEdicion.cbxAreaDependenciaID.setSelectedItem("" + model.getAreadependenciaID());
                        }
                        String eliminar = "DELETE FROM ubicacion WHERE UBIID = ?";
                        if (boton.getName().equals("e")) {
//                            JOptionPane.showMessageDialog(null, "PRESIONÓ ELIMINAR "+modelGeneral.getId(), "Advertencia", JOptionPane.ERROR_MESSAGE);
                            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro?", "Confirmar", JOptionPane.YES_NO_OPTION)) {
                                model.setId(id);
                                query.eliminarRegistro(model, eliminar);
                                renderizarTabla(selectAllUbicacion);
                            }
                        }
                    }
                }
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.btnBuscar) {
            String sql = "SELECT UBI.UBIID, AD.ADNOMBRE, UBI.UBINOMBRE FROM ubicacion UBI "
                    + "INNER JOIN areadependencia AD ON UBI.ADID = AD.ADID "
                    + "WHERE UBI.UBIESTADO = 1 AND AD.ADESTADO = 1 "
                    + "AND (AD.ADNOMBRE LIKE '%" + view.txtBuscar.getText() + "%' "
                    + "OR UBI.UBINOMBRE LIKE '%" + view.txtBuscar.getText() + "%') "
                    + "ORDER BY AD.ADNOMBRE, UBI.UBINOMBRE ASC";
            renderizarTabla(sql);

        }

        if (e.getSource() == viewUbicacionEdicion.btnNoAplica) {
            viewUbicacionEdicion.cbxAreaDependencia.setSelectedItem("No aplica");
            viewUbicacionEdicion.txtUbicacion.setText("No aplica");
        }
        if (e.getSource() == viewUbicacionEdicion.btnGuardarRegistro) {
            if (model.getId() == 0) {
                String sql = "INSERT INTO ubicacion(UBINOMBRE, ADID, UBIESTADO) VALUES (?, ?, ?)";
                if (insertarRegistro(sql)) {
                    view.txtBuscar.setText("");
                    view.btnBuscar.doClick();
                    viewUbicacionEdicion.btnCancelar.doClick();
                }
            } else {
                String sql = "UPDATE ubicacion SET UBINOMBRE=?, ADID=? WHERE UBIID=?";
                if (guardarRegistro(sql)) {
                    model.setId(0);
                    view.txtBuscar.setText("");
                    view.btnBuscar.doClick();
                    viewUbicacionEdicion.btnCancelar.doClick();

                }
            }
        }

    }

}
