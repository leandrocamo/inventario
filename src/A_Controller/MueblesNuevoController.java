package A_Controller;

import A_ClasesUtilizadas.ClasesUtilizadas;

import A_Modelo.MueblesNuevoModel;
import A_Modelo.MueblesNuevoQuery;
import A_Vista.MueblesNuevoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MueblesNuevoController implements ActionListener {//], ItemListener {

    private MueblesNuevoView view;
    private MueblesNuevoModel model;
    private MueblesNuevoQuery query;
//    private UsuarioModel modelUsuario = new UsuarioModel();
    private ClasesUtilizadas clases = new ClasesUtilizadas();

    private ArrayList<String> lista = new ArrayList<>();
//    private String seleccion = "Seleccione una opción...";

    public MueblesNuevoController(MueblesNuevoView view, MueblesNuevoModel model, MueblesNuevoQuery query) {
        this.view = view;
        this.model = model;
        this.query = query;

        cargarCombos();
        this.view.cbxColor.addActionListener(this);
        this.view.cbxColorID.addActionListener(this);
        this.view.cbxCuentaContable.addActionListener(this);
        this.view.cbxCuentaContableID.addActionListener(this);
        this.view.cbxEstado.addActionListener(this);
        this.view.cbxEstadoID.addActionListener(this);
        this.view.cbxMarca.addActionListener(this);
        this.view.cbxMarcaID.addActionListener(this);
        this.view.cbxTipoMueble.addActionListener(this);
        this.view.cbxTipoMuebleID.addActionListener(this);

//        this.view.cbxAreaDependencia.addActionListener(this);
//        this.view.cbxAreaDependenciaID.addActionListener(this);
//        this.view.cbxUbicacion.addActionListener(this);
//        this.view.cbxUsuario.addActionListener(this);
//        this.view.cbxAreaDependencia.addItemListener(this);
//        this.view.cbxUbicacion.addItemListener(this);
//        this.view.cbxUsuario.addItemListener(this);
        this.view.btnGuardar.addActionListener(this);
    }

    public void cargarDatosMueble() {
        view.txtMueID.setText("" + model.getMUEID());
        view.txtCantidad.setText("" + model.getMUECANTIDAD());
        view.txtCodigoEtiqueta.setText("" + model.getMUECODIGOETIQUETA());
        view.txtDescripcion.setText("" + model.getMUEDESCRIPCION());
        view.txtFD.setText("" + model.getMUEFD());
        view.txtFO.setText("" + model.getMUEFO());
        view.txtSerie.setText("" + model.getMUESERIE());
        view.txtValorComercial.setText("" + model.getMUEVALORCOMERCIAL());
        view.txtValorNuevo.setText("" + model.getMUEVALORNUEVO());
        view.txtValorRemanente.setText("" + model.getMUEVALORREMANENTE());
        view.txtValorTotal.setText("" + model.getMUEVALORTOTAL());
        view.txtValorUnitario.setText("" + model.getMUEVALORUNITARIO());

        view.txtFechaCompra.setDate(model.getMUEFECHACOMPRA());
        view.txtFechaExpiracion.setDate(model.getMUEFECHAEXPIRACION());
        view.txtFechaFabricacion.setDate(model.getMUEFECHAFABRICACION());

        view.cbxColorID.setSelectedItem("" + model.getCOLID());
        view.cbxCuentaContableID.setSelectedItem("" + model.getCCID());
        view.cbxEstadoID.setSelectedItem("" + model.getESTID());
        view.cbxMarcaID.setSelectedItem("" + model.getMARID());
        view.cbxTipoMuebleID.setSelectedItem("" + model.getTMID());

        view.cargarComboAreadependenciaUbicacionCustodio("" + model.getUSUXUBIID(), "" + model.getUBIID(), "" + model.getADID());
        view.cbxAreaDependenciaID.setSelectedItem("" + model.getADID());
        view.cbxUbicacionID.setSelectedItem("" + model.getUBIID());
        view.cbxUsuarioID.setSelectedItem("" + model.getUSUXUBIID());

    }

    public void cargarCombos() {

        cargarComboColor();
        cargarComboCuentaContable();
        cargarComboEstado();
        cargarComboMarca();
        cargarComboTipoMueble();
//        cargarComboAreaDependenciaConModel();
//        cargarComboAreaDependencia();
    }

    public void cargarComboColor() {
        String sql = "SELECT * FROM color WHERE COLESTADO = 1 ORDER BY COLNOMBRE ASC";
        String columna1 = "COLNOMBRE";
        String columna2 = "COLID";
        String combo = "cbxColor";
        lista = query.buscarRegistrosCombos(sql, columna1, columna2, combo);

        for (int i = 0; i < lista.size(); i++) {
            view.cbxColor.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();

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

        for (int i = 0; i < lista.size(); i++) {
            view.cbxMarca.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();

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

        for (int i = 0; i < lista.size(); i++) {
            view.cbxTipoMueble.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();

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

        for (int i = 0; i < lista.size(); i++) {
            view.cbxEstado.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();

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

        for (int i = 0; i < lista.size(); i++) {
            view.cbxCuentaContable.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();

        for (int i = 0; i < lista.size(); i++) {
            view.cbxCuentaContableID.addItem(lista.get(i));
        }
    }

    public void cargarComboUbicacion(String ADID) {
        String sql = "SELECT * FROM ubicacion WHERE UBIESTADO = 1 AND ADID = " + ADID + " ORDER BY UBINOMBRE ASC";
        String columna1 = "UBINOMBRE";
        String columna2 = "UBIID";
        String combo = "cbxUbicacion";
        lista = query.buscarRegistrosCombos(sql, columna1, columna2, combo);

        view.cbxUbicacion.removeAllItems();
        view.cbxUbicacionID.removeAllItems();

        for (int i = 0; i < lista.size(); i++) {
            view.cbxUbicacion.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();

        for (int i = 0; i < lista.size(); i++) {
            view.cbxUbicacionID.addItem(lista.get(i));
        }
    }

    public void cargarComboUsuario(String UBIID) {
        String sql = "SELECT * FROM usuxubi UXU \n"
                + "INNER JOIN usuario USU ON USU.USUID=UXU.USUID \n"
                + "WHERE UXU.UBIID = " + UBIID + " AND UXU.USUXUBIESTADO=1 \n"
                + "ORDER BY USU.USUAPELLIDOS ASC";
        String columna1 = "USU.USUAPELLIDOS";
        String columna2 = "UXU.USUXUBIID";
        String combo = "cbxUbicacion";
        lista = query.buscarRegistrosCombos(sql, columna1, columna2, combo);

        view.cbxUbicacion.removeAllItems();
        view.cbxUbicacionID.removeAllItems();

        for (int i = 0; i < lista.size(); i++) {
            view.cbxUbicacion.addItem(lista.get(i));
        }

        lista = query.buscarRegistrosCombosID();

        for (int i = 0; i < lista.size(); i++) {
            view.cbxUbicacionID.addItem(lista.get(i));
        }
    }

    public void limpiarPantallaMueble() {
        view.cbxColor.setSelectedIndex(0);
        view.cbxCuentaContable.setSelectedIndex(0);
        view.cbxEstado.setSelectedIndex(0);
        view.cbxMarca.setSelectedIndex(0);
        view.cbxTipoMueble.setSelectedIndex(0);

        view.txtMueID.setText("");
        view.txtDescripcion.setText("");
        view.txtSerie.setText("");
        view.txtFD.setText("");
        view.txtFO.setText("");
        view.txtCodigoEtiqueta.setText(query.generarCodigoEtiqueta());
        view.txtValorNuevo.setText("");
        view.txtValorComercial.setText("");
        view.txtValorRemanente.setText("");
        view.txtValorUnitario.setText("");
        view.txtValorTotal.setText("");
        view.txtCantidad.setText("");

        view.txtFechaCompra.setDate(null);
        view.txtFechaFabricacion.setDate(null);
        view.txtFechaExpiracion.setDate(null);
    }

    public boolean guardarMueble() {
        boolean marcaGlobal = false;
        boolean codigoEtiqueta = false;
        boolean descripcion = false;
        boolean serie = false;
        boolean color = false;
        boolean marca = false;
        boolean tipomueble = false;
        boolean fechacompra = false;
        boolean fechafabricacion = false;
        boolean fechaexpiracion = false;
        boolean estado = false;
        boolean cuentacontable = false;
        boolean areadependencia = false;
        boolean fd = false;
        boolean fo = false;
        boolean valornuevo = false;
        boolean valorcomercial = false;
        boolean valorremanente = false;
        boolean valorunitario = false;
        boolean valortotal = false;
        boolean cantidad = false;

        //SE VALIDA SI LOS CAMPOS SI ESTAN VACIOS
        if (clases.validarCombo(view.cbxCuentaContable.getSelectedIndex(), "Cuenta Contable")) {
            model.setCCID(Integer.parseInt("" + view.cbxCuentaContableID.getSelectedItem()));
            cuentacontable = true;
        }

        if (clases.validarCombo(view.cbxTipoMueble.getSelectedIndex(), "Tipo Mueble")) {
            model.setTMID(Integer.parseInt("" + view.cbxTipoMuebleID.getSelectedItem()));
            tipomueble = true;
        }
        if (clases.validarCombo(view.cbxEstado.getSelectedIndex(), "Estado")) {
            model.setESTID(Integer.parseInt("" + view.cbxEstadoID.getSelectedItem()));
            estado = true;
        }

        if (clases.validarCombo(view.cbxAreaDependencia.getSelectedIndex(), "Área Dependencia")
                && clases.validarCombo(view.cbxUbicacion.getSelectedIndex(), "Ubicación")
                && clases.validarCombo(view.cbxUsuario.getSelectedIndex(), "Custodio")) {
//            AreaDependenciaModel modelAreaDependencia = (AreaDependenciaModel) view.cbxAreaDependencia.getSelectedItem();
//            UbicacionModel modelUbicacion = (UbicacionModel) view.cbxUbicacion.getSelectedItem();
//            UsuarioModel modelUsuario = (UsuarioModel) view.cbxUsuario.getSelectedItem();
//            model.setUSUXUBIID(modelUsuario.getUSUID());
            model.setUSUXUBIID(Integer.parseInt("" + view.cbxUsuarioID.getSelectedItem()));
            areadependencia = true;
        }
        if (clases.validarCombo(view.cbxMarca.getSelectedIndex(), "Marca")) {
            model.setMARID(Integer.parseInt("" + view.cbxMarcaID.getSelectedItem()));
            marca = true;
        }
        if (clases.validarCombo(view.cbxColor.getSelectedIndex(), "Color")) {
            model.setCOLID(Integer.parseInt("" + view.cbxColorID.getSelectedItem()));
            color = true;
        }
        if (clases.validarCampoVacio(view.txtDescripcion.getText(), "Descripción")) {
            model.setMUEDESCRIPCION(view.txtDescripcion.getText());
            descripcion = true;
        }
        if (clases.validarCampoVacio(view.txtSerie.getText(), "Serie")) {
            model.setMUESERIE(view.txtSerie.getText());
            serie = true;
        }
        if (clases.validarFechaVacia(view.txtFechaCompra.getDate(), "Fecha Compra")) {
            model.setMUEFECHACOMPRA(clases.convertirFecha(view.txtFechaCompra.getDate()));
            fechacompra = true;
        }
        if (clases.validarFechaVacia(view.txtFechaFabricacion.getDate(), "Fecha Fabricación")) {
            model.setMUEFECHAFABRICACION(clases.convertirFecha(view.txtFechaFabricacion.getDate()));
            fechafabricacion = true;
        }
        if (clases.validarFechaVacia(view.txtFechaExpiracion.getDate(), "Fecha Expiración")) {
            model.setMUEFECHAEXPIRACION(clases.convertirFecha(view.txtFechaExpiracion.getDate()));
            fechaexpiracion = true;
        }
        if (clases.validarCampoVacio(view.txtFD.getText(), "FD")) {
            model.setMUEFD(view.txtFD.getText());
            fd = true;
        }
        if (clases.validarCampoVacio(view.txtFO.getText(), "FO")) {
            model.setMUEFO(view.txtFO.getText());
            fo = true;
        }
        if (clases.validarCampoVacio(view.txtValorNuevo.getText(), "Valor Nuevo")) {
            model.setMUEVALORNUEVO(Double.parseDouble("" + view.txtValorNuevo.getText()));
            valornuevo = true;
        }
        if (clases.validarCampoVacio(view.txtValorComercial.getText(), "Valor Comercial")) {
            model.setMUEVALORCOMERCIAL(Double.parseDouble("" + view.txtValorComercial.getText()));
            valorcomercial = true;
        }
        if (clases.validarCampoVacio(view.txtValorRemanente.getText(), "Valor Remanente")) {
            model.setMUEVALORREMANENTE(Double.parseDouble("" + view.txtValorRemanente.getText()));
            valorremanente = true;
        }
        if (clases.validarCampoVacio(view.txtValorTotal.getText(), "Valor Total")) {
            model.setMUEVALORTOTAL(Double.parseDouble("" + view.txtValorTotal.getText()));
            valortotal = true;
        }
        if (clases.validarCampoVacio(view.txtCantidad.getText(), "Cantidad")) {
            model.setMUECANTIDAD(Integer.parseInt("" + view.txtCantidad.getText()));
            cantidad = true;
        }
        if (clases.validarCampoVacio(view.txtValorUnitario.getText(), "Valor Unitario")) {
            model.setMUEVALORUNITARIO(Double.parseDouble("" + view.txtValorUnitario.getText()));
            valorunitario = true;
        }
        if (clases.validarCampoVacio(view.txtCodigoEtiqueta.getText(), "Código Etiqueta")) {
            model.setMUECODIGOETIQUETA(view.txtCodigoEtiqueta.getText());
            codigoEtiqueta = true;
        }

        if (codigoEtiqueta
                && descripcion
                && serie
                && color
                && marca
                && tipomueble
                && fechacompra
                && fechafabricacion
                && fechaexpiracion
                && estado
                && cuentacontable
                && areadependencia
                && fd
                && fo
                && valornuevo
                && valorcomercial
                && valorremanente
                && valorunitario
                && valortotal
                && cantidad) {
            if (model.getMUEID() == 0) {
                if (query.guardarMueble(model)) {
                    if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Desea guardar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                        limpiarPantallaMueble();
                        marcaGlobal = false;
                    } else {
                        marcaGlobal = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un problema al guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                //ACTUALIZAR
                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                    if (query.actualizarMueble(model)) {
                        marcaGlobal = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        return marcaGlobal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.cbxColor) {
            view.cbxColorID.setSelectedIndex(view.cbxColor.getSelectedIndex());
        }
        if (e.getSource() == view.cbxColorID) {
            view.cbxColor.setSelectedIndex(view.cbxColorID.getSelectedIndex());
        }
        if (e.getSource() == view.cbxCuentaContable) {
            view.cbxCuentaContableID.setSelectedIndex(view.cbxCuentaContable.getSelectedIndex());
        }
        if (e.getSource() == view.cbxCuentaContableID) {
            view.cbxCuentaContable.setSelectedIndex(view.cbxCuentaContableID.getSelectedIndex());
        }
        if (e.getSource() == view.cbxEstado) {
            view.cbxEstadoID.setSelectedIndex(view.cbxEstado.getSelectedIndex());
        }
        if (e.getSource() == view.cbxEstadoID) {
            view.cbxEstado.setSelectedIndex(view.cbxEstadoID.getSelectedIndex());
        }
        if (e.getSource() == view.cbxMarca) {
            view.cbxMarcaID.setSelectedIndex(view.cbxMarca.getSelectedIndex());
        }
        if (e.getSource() == view.cbxMarcaID) {
            view.cbxMarca.setSelectedIndex(view.cbxMarcaID.getSelectedIndex());
        }
        if (e.getSource() == view.cbxTipoMueble) {
            view.cbxTipoMuebleID.setSelectedIndex(view.cbxTipoMueble.getSelectedIndex());
        }
        if (e.getSource() == view.cbxTipoMuebleID) {
            view.cbxTipoMueble.setSelectedIndex(view.cbxTipoMuebleID.getSelectedIndex());
        }
        if (e.getSource() == view.btnGuardar) {
            if (guardarMueble()) {
                view.btnCancelar.doClick();
            }

        }
    }
//
//    @Override
//    public void itemStateChanged(ItemEvent e) {
//        if (e.getSource() == view.cbxCuentaContable) {
//            view.cbxCuentaContableID.setSelectedIndex(view.cbxCuentaContable.getSelectedIndex());
//        }
//        if (e.getSource() == view.cbxCuentaContableID) {
//            view.cbxCuentaContable.setSelectedIndex(view.cbxCuentaContableID.getSelectedIndex());
//        }
//    }
}
