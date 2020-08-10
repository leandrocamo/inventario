package controller;

import clases.ClasesUtilizadas;
import javax.swing.JOptionPane;
import modelo.ConsultaPnlUsuarioNuevo;
import modelo.PnlUsuarioNuevo;
import vista.pnlUsuarioDetalle;
import vista.pnlUsuarioNuevo;

public class PnlUsuarioNuevoController {

    pnlUsuarioNuevo punVista = null;
    PnlUsuarioNuevo punModelo = null;
    ConsultaPnlUsuarioNuevo cpunModelo = null;
    ClasesUtilizadas clasesAuxiliares = null;
//    pnlUsuarioDetalle pud = new pnlUsuarioDetalle();

    public PnlUsuarioNuevoController(pnlUsuarioNuevo punVista) {
        this.punVista = punVista;
    }

    public boolean ejecutarGuardar() {
        punModelo = new PnlUsuarioNuevo();
        cpunModelo = new ConsultaPnlUsuarioNuevo();
        clasesAuxiliares = new ClasesUtilizadas();

        if (clasesAuxiliares.validarCombo(punVista.cbxAreaDependencia.getSelectedIndex(), "Área Dependencia")
                && clasesAuxiliares.validarCorreo(punVista.txtCorreoElectronico.getText())) {
            punModelo.setAdId(Integer.parseInt("" + punVista.cbxAreaDependenciaId.getSelectedItem()));
            punModelo.setUsuUsuario(punVista.txtApellidosNombres.getText());
            punModelo.setUsuEmail(punVista.txtCorreoElectronico.getText());
            punModelo.setUsuContrasenia(punVista.txtContrasenia.getText());

            if (cpunModelo.guardarUsuario(punModelo, true)) {
//                pud.renderizarTablaUsuario();
                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Deseas guardar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                    punVista.cbxAreaDependencia.setSelectedIndex(0);
                    punVista.cbxAreaDependenciaId.setSelectedIndex(0);
                    punVista.txtApellidosNombres.setText("");
                    punVista.txtCorreoElectronico.setText("");
//                    pud.btnBuscarUsuario.doClick();
                    return true;
                } else {
//                    pud.btnBuscarUsuario.doClick();
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
        
        
    }
}
