package Zcontroller;

import javax.swing.JOptionPane;
import Zvista.Borrar_pnlNuevoMueble;

public class Borrar_PnlNuevoMuebleController {

    public boolean guardarRegistro(Borrar_pnlNuevoMueble pnm) {

        if (pnm.guardarRegistro() && pnm.marcaGuardar) {
            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Deseas guardar otro registro?", "Confirmar", JOptionPane.YES_NO_OPTION)) {
                pnm.cbxColor.setSelectedIndex(0);
                pnm.cbxCuentaContable.setSelectedIndex(0);
                pnm.cbxEstado.setSelectedIndex(0);
                pnm.cbxMarca.setSelectedIndex(0);
                pnm.cbxTipoMueble.setSelectedIndex(0);
                pnm.cbxUbicacion.setSelectedIndex(0);
                pnm.txtCantidad.setText(null);
                pnm.txtCodigoEtiqueta.setText(null);
                pnm.txtDescripcion.setText(null);
                pnm.txtFD.setText(null);
                pnm.txtFO.setText(null);
                pnm.txtSerie.setText(null);
                pnm.txtValorComercial.setText(null);
                pnm.txtValorNuevo.setText(null);
                pnm.txtValorRemanente.setText(null);
                pnm.txtValorTotal.setText(null);
                pnm.txtValorUnitario.setText(null);

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
