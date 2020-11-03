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
import Tabla.TablaUsuarioUbicacion;
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

public final class UsuarioUbicacionController implements ActionListener {

    private final UsuarioUbicacionView view;
    private final UsuarioUbicacionModel model;
    private final UsuarioUbicacionQuery query;
    private final TablaUsuarioUbicacion tabla = new TablaUsuarioUbicacion();
    private final ClasesUtilizadas clases = new ClasesUtilizadas();
    private int fila_tabla = 0;

    public UsuarioUbicacionController(UsuarioUbicacionView view, UsuarioUbicacionModel model, UsuarioUbicacionQuery query) {
        this.view = view;
        this.model = model;
        this.query = query;

        clicJTable();

//        this.view.btnBuscar.addActionListener(this);
//        this.viewUsuarioEdicion.btnGuardarRegistro.addActionListener(this);
    }

//    }
    public void renderizarTabla(String sql) {
        tabla.cargandoRegistros(this.view.jTable, sql);
    }

    public boolean validacionControles() {
//        boolean nombres = false, apellidos = false, correo = false;
//        if (clases.validarCampoVacio(viewUsuarioEdicion.txtNombres.getText(), "Nombres")) {
//            model.setNombres(viewUsuarioEdicion.txtNombres.getText());
//            nombres = true;
//        }
//        if (clases.validarCampoVacio(viewUsuarioEdicion.txtApellidos.getText(), "Apellidos")) {
//            model.setApellidos(viewUsuarioEdicion.txtApellidos.getText());
//            apellidos = true;
//        }
//        if (clases.validarCampoVacio(viewUsuarioEdicion.txtCorreoElectronico.getText(), "Correo Electrónico")
//                && clases.validarCorreo(viewUsuarioEdicion.txtCorreoElectronico.getText())) {
////            if (clases.validarCorreo(viewUsuarioEdicion.txtCorreoElectronico.getText())) {
//            model.setCorreoElectronico(viewUsuarioEdicion.txtCorreoElectronico.getText());
//            correo = true;
////            }
//        }
//        if (nombres && apellidos && correo) {
//            return true;
//        } else {
        return false;
//        }
//
    }

//    public boolean insertarRegistro(String sql) {
//        if (validacionControles()) {
//            if (query.guardarRegistro(model, sql)) {
//                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Desea guardar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
//                    limpiarParametros();
//                    return false;
//                } else {
//                    return true;
//                }
//            } else {
////                JOptionPane.showMessageDialog(null, "Hubo un problema al guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }
//    public boolean guardarRegistro(String sql) {
//        if (validacionControles()) {
//            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
//                if (query.actualizarRegistro(model, sql)) {
//                    return true;
//                } else {
//                    JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        } else {
////            JOptionPane.showMessageDialog(null, "Hubo un problema al guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//    }
//    public void limpiarParametros() {
////        viewUsuarioEdicion.txtNombres.setText("");
////        viewUsuarioEdicion.txtApellidos.setText("");
////        viewUsuarioEdicion.txtCorreoElectronico.setText("");
//    }
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

                        if (boton.getName().equals("e")) {
//                            JOptionPane.showMessageDialog(null, "PRESIONÓ ELIMINAR " + model.getId(), "Advertencia", JOptionPane.ERROR_MESSAGE);
                            String eliminar = "DELETE FROM USUXUBI WHERE USUXUBIID = " + id;
                            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro?", "Confirmar", JOptionPane.YES_NO_OPTION)) {
                                query.eliminarRegistro(eliminar);
                                view.btnActualizar.doClick();
//                                renderizarTabla(eliminar);
                            }
                        }
                    }
                }
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//            if (model.getId() == 0) {
//                String sql = "INSERT INTO USUARIO(USUNOMBRES, USUAPELLIDOS, USUEMAIL, USUCONTRASENIA, ROLE, USUESTADO) VALUES (?, ?, ?, ?, ?, ?)";
//                if (insertarRegistro(sql)) {
//                    viewUsuarioEdicion.btnCancelar.doClick();
//                    renderizarTabla(selectAllUsuario);
//                }
//            } else {
//                String sql = "UPDATE USUARIO SET USUNOMBRES=?, USUAPELLIDOS=?, USUEMAIL=? WHERE USUID=?";
//                if (guardarRegistro(sql)) {
//                    model.setId(0);
//                    viewUsuarioEdicion.btnCancelar.doClick();
//                    renderizarTabla(selectAllUsuario);
//
//                }
//            }
//        }
    }

}
