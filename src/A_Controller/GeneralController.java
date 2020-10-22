package A_Controller;

import A_ClasesUtilizadas.ClasesUtilizadas;
import A_Modelo.GeneralModel;
import A_Modelo.GeneralQuery;
import A_Tabla.TablaGeneral;
import A_Vista.GeneralEdicionView;
import A_Vista.GeneralView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public final class GeneralController implements ActionListener {

    private final GeneralView view;
    private final GeneralModel model;
    private final GeneralQuery query;
    private final GeneralEdicionView viewGeneralEdicion;
    public final TablaGeneral tabla = new TablaGeneral();
    private final ClasesUtilizadas clases = new ClasesUtilizadas();
//    private String sql = "";

    public GeneralController(GeneralView view, GeneralModel model, GeneralQuery query, GeneralEdicionView viewGeneralEdicion, String sql) {
        this.view = view;
        this.model = model;
        this.query = query;
        this.viewGeneralEdicion = viewGeneralEdicion;
//        this.sql = sql;
        renderizarTabla(sql);
    }

    public void renderizarTabla(String sql) {
        tabla.cargandoRegistros(this.view.jTable, sql);
    }

    public boolean insertarRegistro(String sql) {
        boolean nombre = false, descripcion = false;
        if (clases.validarCampoVacio(viewGeneralEdicion.txtNombre.getText(), "Nombre")) {
            model.setNombre(viewGeneralEdicion.txtNombre.getText());
            nombre = true;
        }
        if (clases.validarCampoVacio(viewGeneralEdicion.txtDescripcion.getText(), "Descripción")) {
            model.setDescripcion(viewGeneralEdicion.txtDescripcion.getText());
            descripcion = true;
        }
        if (nombre && descripcion) {
            if (query.guardarRegistro(model, sql)) {
                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Desea guardar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                    limpiarParametrosGeneral();
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
        boolean nombre = false, descripcion = false;
        if (clases.validarCampoVacio(viewGeneralEdicion.txtNombre.getText(), "Nombre")) {
            model.setNombre(viewGeneralEdicion.txtNombre.getText());
            nombre = true;
        }
        if (clases.validarCampoVacio(viewGeneralEdicion.txtDescripcion.getText(), "Descripción")) {
            model.setDescripcion(viewGeneralEdicion.txtDescripcion.getText());
            descripcion = true;
        }
        if (nombre && descripcion) {
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

    public void limpiarParametrosGeneral() {
        viewGeneralEdicion.txtDescripcion.setText("");
        viewGeneralEdicion.txtNombre.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == viewGeneralEdicion.btnGuardarRegistro) {
//            if (guardarRegistro()) {
//                view.txtBuscar.setText("");
//                view.btnBuscar.doClick();
//                viewGeneralEdicion.btnCancelar.doClick();
//
//            }
//        }
//        if (e.getSource() == view.btnBuscar) {
//            String textoBuscar = view.txtBuscar.getText();
//            tabla.cargandoRegistros(this.view.jTable, sentenciaSelectAll);
//            this.view.lblTotalRegistros.setText("Se encontraron " + tabla.getTotalRegistros() + " de " + query.totalRegistros() + " registros.");
//        }
//        if (e.getSource() == view.btnBuscarPorTexto) {
//            String textoBuscar = view.txtBuscar.getText();
//            tabla.cargandoRegistrosMuebles(this.view.jTableMuebles, textoBuscar, "NoAplica", "NoAplica");
//            this.view.txtTotalRegistros.setText("Se encontraron " + tabla.getTotalRegistros() + " de " + query.totalRegistros() + " registros.");
//        }
    }

}
