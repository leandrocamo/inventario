package A_Controller;

import A_Modelo.MueblesNuevoModel;
import A_Modelo.MueblesNuevoQuery;
import A_Vista.MueblesNuevoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MueblesNuevoController implements ActionListener {

    private MueblesNuevoView view;
    private MueblesNuevoModel model;
    private MueblesNuevoQuery query;

    private ArrayList<String> lista = new ArrayList<>();
    private String seleccion = "Seleccione una opción...";

    public MueblesNuevoController(MueblesNuevoView view, MueblesNuevoModel model, MueblesNuevoQuery query) {
        this.view = view;
        this.model = model;
        this.query = query;

        cargarCombos();
        this.view.cbxColor.addActionListener(this);
        this.view.cbxCuentaContable.addActionListener(this);
        this.view.cbxEstado.addActionListener(this);
        this.view.cbxMarca.addActionListener(this);
        this.view.cbxTipoMueble.addActionListener(this);
        this.view.cbxUbicacion.addActionListener(this);
        
    }

    public void cargarCombos() {
        cargarComboColor();
        cargarComboCuentaContable();
        cargarComboEstado();
        cargarComboMarca();
        cargarComboTipoMueble();
        cargarComboUbicacion();
    }

    public void cargarComboColor() {
        String sql = "SELECT * FROM color WHERE COLESTADO = 1 ORDER BY COLNOMBRE ASC";
        String columna1 = "COLNOMBRE";
        String columna2 = "COLID";
        String combo = "cbxColor";
        lista = query.buscarRegistrosCombos(sql, columna1, columna2, combo);
        view.cbxColor.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxColor.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();
        view.cbxColorID.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxColorID.addItem(lista.get(i));
        }

    }

    public void cargarComboMarca() {
        String sql = "SELECT * FROM marca WHERE MARESTADO = 1 ORDER BY MARNOMBRE";
        String columna1 = "MARNOMBRE";
        String columna2 = "MARID";
        String combo = "cbxMarca";
        lista = query.buscarRegistrosCombos(sql, columna1, columna2, combo);
        view.cbxMarca.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxMarca.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();
        view.cbxMarcaID.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxMarcaID.addItem(lista.get(i));
        }

    }

    public void cargarComboTipoMueble() {
        String sql = "SELECT * FROM tipomueble WHERE TMESTADO = 1 ORDER BY TMNOMBRE ASC";
        String columna1 = "TMNOMBRE";
        String columna2 = "TMID";
        String combo = "cbxTipoMueble";
        lista = query.buscarRegistrosCombos(sql, columna1, columna2, combo);
        view.cbxTipoMueble.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxTipoMueble.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();
        view.cbxTipoMuebleID.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxTipoMuebleID.addItem(lista.get(i));
        }
    }

    public void cargarComboEstado() {
        String sql = "SELECT * FROM estado WHERE ESTESTADO = 1 ORDER BY ESTNOMBRE ASC";
        String columna1 = "ESTNOMBRE";
        String columna2 = "ESTID";
        String combo = "cbxEstado";
        lista = query.buscarRegistrosCombos(sql, columna1, columna2, combo);
        view.cbxEstado.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxEstado.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();
        view.cbxEstadoID.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxEstadoID.addItem(lista.get(i));
        }
    }

    public void cargarComboCuentaContable() {
        String sql = "SELECT * FROM cuentacontable WHERE CCESTADO = 1 ORDER BY CCNOMBRE ASC";
        String columna1 = "CCNOMBRE";
        String columna2 = "CCID";
        String combo = "cbxCuentaContable";
        lista = query.buscarRegistrosCombos(sql, columna1, columna2, combo);
        view.cbxCuentaContable.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxCuentaContable.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();
        view.cbxCuentaContableID.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxCuentaContableID.addItem(lista.get(i));
        }
    }

    public void cargarComboUbicacion() {
        String sql = "SELECT * FROM ubicacion WHERE UBIESTADO = 1 ORDER BY UBINOMBRE ASC";
        String columna1 = "UBINOMBRE";
        String columna2 = "UBIID";
        String combo = "cbxUbicacion";
        lista = query.buscarRegistrosCombos(sql, columna1, columna2, combo);
        view.cbxUbicacion.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxUbicacion.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();
        view.cbxUbicacionID.addItem(seleccion);
        for (int i = 0; i < lista.size(); i++) {
            view.cbxUbicacionID.addItem(lista.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.cbxColor) {
            view.cbxColorID.setSelectedIndex(view.cbxColor.getSelectedIndex());
        }
        if (e.getSource() == view.cbxCuentaContable) {
            view.cbxCuentaContableID.setSelectedIndex(view.cbxCuentaContable.getSelectedIndex());
        }
        if (e.getSource() == view.cbxEstado) {
            view.cbxEstadoID.setSelectedIndex(view.cbxEstado.getSelectedIndex());
        }
        if (e.getSource() == view.cbxMarca) {
            view.cbxMarcaID.setSelectedIndex(view.cbxMarca.getSelectedIndex());
        }
        if (e.getSource() == view.cbxTipoMueble) {
            view.cbxTipoMuebleID.setSelectedIndex(view.cbxTipoMueble.getSelectedIndex());
        }
        if (e.getSource() == view.cbxUbicacion) {
            view.cbxUbicacionID.setSelectedIndex(view.cbxUbicacion.getSelectedIndex());
        }
    }

}
