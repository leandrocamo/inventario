package Controller;

import ClasesUtilizadas.ClasesUtilizadas;
import Modelo.UsuarioModel;
import Modelo.UsuarioQuery;
import Modelo.UsuarioModel;
import Modelo.UsuarioQuery;
import Modelo.UsuarioUbicacionModel;
import Modelo.UsuarioUbicacionQuery;
import Tabla.TablaUsuario;
import Tabla.TablaUsuario;
import Vista.UsuarioEdicionView;
import Vista.UsuarioView;
import Vista.UsuarioEdicionView;
import Vista.UsuarioUbicacionView;
import Vista.UsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public final class UsuarioController implements ActionListener {

    private final UsuarioView view;
    private final UsuarioModel model;
    private final UsuarioQuery query;
    private final UsuarioEdicionView viewUsuarioEdicion;
    private final UsuarioUbicacionView viewUsuarioUbicacion;
    private final UsuarioUbicacionModel modelUsuarioUbicacion;
    private final UsuarioUbicacionQuery queryUsuarioUbicacion;
    private final UsuarioUbicacionController controllerUsuarioUbicacion;

    private final TablaUsuario tabla = new TablaUsuario();
    private final ClasesUtilizadas clases = new ClasesUtilizadas();

    private String selectAllUsuario = "SELECT USU.USUID, USU.USUNOMBRES, USU.USUAPELLIDOS, USU.USUEMAIL, USU.ROLE FROM USUARIO USU "
            + "WHERE USU.USUESTADO = 1 "
            + "ORDER BY USU.USUAPELLIDOS, USU.USUNOMBRES ASC";
    private int fila_tabla = 0;

    public UsuarioController(UsuarioView view, UsuarioModel model, UsuarioQuery query, UsuarioEdicionView viewUsuarioEdicion, UsuarioUbicacionView viewUsuarioUbicacion, UsuarioUbicacionModel modelUsuarioUbicacion, UsuarioUbicacionQuery queryUsuarioUbicacion) {

        this.view = view;
        this.model = model;
        this.query = query;
        this.viewUsuarioEdicion = viewUsuarioEdicion;
        this.viewUsuarioUbicacion = viewUsuarioUbicacion;
        this.modelUsuarioUbicacion = modelUsuarioUbicacion;
        this.queryUsuarioUbicacion = queryUsuarioUbicacion;
        controllerUsuarioUbicacion = new UsuarioUbicacionController(this.viewUsuarioUbicacion, this.modelUsuarioUbicacion, this.queryUsuarioUbicacion);
        renderizarTabla(selectAllUsuario);

        clicJTable();
        this.view.btnBuscar.addActionListener(this);
        this.viewUsuarioEdicion.btnGuardarRegistro.addActionListener(this);
        this.viewUsuarioUbicacion.btnRegresar.addActionListener(this);
        this.viewUsuarioUbicacion.btnAgregar.addActionListener(this);
        this.viewUsuarioUbicacion.btnActualizar.addActionListener(this);
    }

    public void renderizarTabla(String sql) {
        tabla.cargandoRegistros(this.view.jTable, sql);
        view.lblTotalRegistros.setText("Se encontraron " + tabla.getTotalRegistros() + " de " + query.totalRegistros(selectAllUsuario));
    }

    public boolean validacionControles() {
        boolean nombres = false, apellidos = false, correo = false;
        if (clases.validarCampoVacio(viewUsuarioEdicion.txtNombres.getText(), "Nombres")) {
            model.setNombres(viewUsuarioEdicion.txtNombres.getText());
            nombres = true;
        }
        if (clases.validarCampoVacio(viewUsuarioEdicion.txtApellidos.getText(), "Apellidos")) {
            model.setApellidos(viewUsuarioEdicion.txtApellidos.getText());
            apellidos = true;
        }
        if (clases.validarCampoVacio(viewUsuarioEdicion.txtCorreoElectronico.getText(), "Correo Electrónico")
                && clases.validarCorreo(viewUsuarioEdicion.txtCorreoElectronico.getText())) {
//            if (clases.validarCorreo(viewUsuarioEdicion.txtCorreoElectronico.getText())) {
            model.setCorreoElectronico(viewUsuarioEdicion.txtCorreoElectronico.getText());
            correo = true;
//            }
        }
        if (nombres && apellidos && correo) {
            return true;
        } else {
            return false;
        }

    }

    public boolean insertarRegistro(String sql) {
        if (validacionControles()) {
            if (query.guardarRegistro(model, sql)) {
                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Desea guardar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                    limpiarParametrosUsuario();
                    return false;
                } else {
                    return true;
                }
            } else {
//                JOptionPane.showMessageDialog(null, "Hubo un problema al guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean guardarRegistro(String sql) {
        if (validacionControles()) {
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
//            JOptionPane.showMessageDialog(null, "Hubo un problema al guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void limpiarParametrosUsuario() {
        viewUsuarioEdicion.txtNombres.setText("");
        viewUsuarioEdicion.txtApellidos.setText("");
        viewUsuarioEdicion.txtCorreoElectronico.setText("");
    }

    public void cargarUbicacion() {
        String sql = "SELECT UXU.USUXUBIID, UBI.UBINOMBRE FROM USUXUBI UXU "
                + "INNER JOIN USUARIO USU ON USU.USUID=UXU.USUID "
                + "INNER JOIN UBICACION UBI ON UBI.UBIID=UXU.UBIID "
                + "WHERE USU.USUID =" + model.getId();
        controllerUsuarioUbicacion.renderizarTabla(sql);
        sql = "SELECT * FROM UBICACION UBI WHERE UBI.UBIID NOT IN (SELECT UXU.UBIID FROM USUXUBI UXU WHERE UXU.USUID = " + model.getId() + ") ORDER BY UBI.UBINOMBRE ASC";
        viewUsuarioUbicacion.cargarCombo(sql);
    }

    public void clicJTable() {

        view.jTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
                fila_tabla = view.jTable.rowAtPoint(evt.getPoint());

                int id = Integer.parseInt("" + view.jTable.getValueAt(fila_tabla, 1));
                int column = view.jTable.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / view.jTable.getRowHeight();

                if (row < view.jTable.getRowCount() && row >= 0 && column < view.jTable.getColumnCount() && column >= 0) {
                    Object value = view.jTable.getValueAt(row, column);

                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        String opcion = "Usuario";

                        if (boton.getName().equals("m")) {
//                            JOptionPane.showMessageDialog(null, "PRESIONÓ EDITAR", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                            String editar = "SELECT USUNOMBRES, USUAPELLIDOS, USUEMAIL FROM USUARIO \n"
                                    + "WHERE USUESTADO = 1 \n"
                                    + "AND USUID=";

                            viewUsuarioEdicion.lblTitulo.setText("Actualización de " + opcion);
                            model.setId(id);
                            view.btnNuevo.doClick();
                            query.buscarRegistroID(model, editar + model.getId());
                            viewUsuarioEdicion.txtCodigo.setText("" + model.getId());
                            viewUsuarioEdicion.txtNombres.setText("" + model.getNombres());
                            viewUsuarioEdicion.txtApellidos.setText("" + model.getApellidos());
                            viewUsuarioEdicion.txtCorreoElectronico.setText("" + model.getCorreoElectronico());
                        }

                        if (boton.getName().equals("e")) {
//                            JOptionPane.showMessageDialog(null, "PRESIONÓ ELIMINAR " + model.getId(), "Advertencia", JOptionPane.ERROR_MESSAGE);
                            String eliminar = "DELETE FROM USUARIO WHERE USUID = ?";
                            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro?", "Confirmar", JOptionPane.YES_NO_OPTION)) {
                                model.setId(id);
                                query.eliminarRegistro(model, eliminar);
                                renderizarTabla(selectAllUsuario);
                            }
                        }
                        if (boton.getName().equals("u")) {
//                            JOptionPane.showMessageDialog(null, "PRESIONÓ UBICAR", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                            String editar = "SELECT USUNOMBRES, USUAPELLIDOS, USUEMAIL FROM USUARIO \n"
                                    + "WHERE USUESTADO = 1 \n"
                                    + "AND USUID=";
                            model.setId(id);
                            view.btnUsuarioUbicacion.doClick();
                            query.buscarRegistroID(model, editar + model.getId());
                            viewUsuarioUbicacion.lblTitulo.setText("Asignar ubicación: " + model.getNombres() + " " + model.getApellidos());
                            cargarUbicacion();
                        }
                        if (boton.getName().equals("r")) {
                            JOptionPane.showMessageDialog(null, "PRESIONÓ resetear", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.btnBuscar) {
            String sql = "SELECT USU.USUID, USU.USUNOMBRES, USU.USUAPELLIDOS, USU.USUEMAIL, USU.ROLE FROM USUARIO USU "
                    + "WHERE USU.USUESTADO = 1 "
                    + "AND (USU.USUNOMBRES LIKE '%" + view.txtBuscar.getText() + "%' "
                    + "OR USU.USUAPELLIDOS LIKE '%" + view.txtBuscar.getText() + "%' "
                    + "OR USU.USUEMAIL LIKE '%" + view.txtBuscar.getText() + "%') "
                    + "ORDER BY USU.USUAPELLIDOS, USU.USUNOMBRES ASC";
            renderizarTabla(sql);

        }

        if (e.getSource() == viewUsuarioEdicion.btnGuardarRegistro) {
//            JOptionPane.showMessageDialog(null, "Valor: " + model.getId());
            if (model.getId() == 0) {
                String sql = "INSERT INTO USUARIO(USUNOMBRES, USUAPELLIDOS, USUEMAIL, USUCONTRASENIA, ROLE, USUESTADO) VALUES (?, ?, ?, ?, ?, ?)";
                if (insertarRegistro(sql)) {
                    viewUsuarioEdicion.btnCancelar.doClick();
                    renderizarTabla(selectAllUsuario);
                }
            } else {
                String sql = "UPDATE USUARIO SET USUNOMBRES=?, USUAPELLIDOS=?, USUEMAIL=? WHERE USUID=?";
                if (guardarRegistro(sql)) {
                    model.setId(0);
                    viewUsuarioEdicion.btnCancelar.doClick();
                    renderizarTabla(selectAllUsuario);

                }
            }
        }
        if (e.getSource() == viewUsuarioUbicacion.btnRegresar) {
            viewUsuarioEdicion.btnCancelar.doClick();
        }

        if (e.getSource() == viewUsuarioUbicacion.btnAgregar) {
//            JOptionPane.showMessageDialog(null, "Valor: " + model.getId());
            String sql = "INSERT INTO USUXUBI(UBIID, USUID, USUXUBIESTADO) VALUES (" + viewUsuarioUbicacion.cbxUbicacionID.getSelectedItem() + "," + model.getId() + ",1)";
            System.out.println(sql);
            queryUsuarioUbicacion.insertarRegistro(sql);
            cargarUbicacion();
        }
        if (e.getSource() == viewUsuarioUbicacion.btnActualizar) {
            cargarUbicacion();
        }

    }

}
