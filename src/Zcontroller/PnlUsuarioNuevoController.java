package Zcontroller;

import Zclases.ClasesUtilizadas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Zmodelo.ConsultaPnlUsuarioNuevo;
import Zvista.PnlUsuarioNuevo;
import Zmodelo.PnlUsuarioNuevoModel;

public class PnlUsuarioNuevoController implements ActionListener {

    private PnlUsuarioNuevo punVista = null;
    private PnlUsuarioNuevoModel punModelo = new PnlUsuarioNuevoModel();
    private ConsultaPnlUsuarioNuevo cpunModelo = new ConsultaPnlUsuarioNuevo();
    private ClasesUtilizadas clasesUtilizadas = null;
//    pnlUsuarioDetalle pud = new pnlUsuarioDetalle();

    public PnlUsuarioNuevoController(PnlUsuarioNuevo punVista) {
        this.punVista = punVista;
        this.punVista.btnLimpiar.addActionListener(this);

    }

    public boolean ejecutarGuardar() {
        clasesUtilizadas = new ClasesUtilizadas();
        boolean marca = false;

        if (clasesUtilizadas.validarCombo(punVista.cbxAreaDependencia.getSelectedIndex(), "Área Dependencia")
                && clasesUtilizadas.validarCampoVacio(punVista.txtApellidosNombres.getText())
                && clasesUtilizadas.validarCampoVacio(punVista.txtCorreoElectronico.getText())
                && clasesUtilizadas.validarCampoVacio(punVista.txtContrasenia.getText())
                && clasesUtilizadas.validarCorreo(punVista.txtCorreoElectronico.getText())) {
            punModelo.setAdId(Integer.parseInt("" + punVista.cbxAreaDependenciaId.getSelectedItem()));
            punModelo.setUsuUsuario(punVista.txtApellidosNombres.getText());
            punModelo.setUsuEmail(punVista.txtCorreoElectronico.getText());
            punModelo.setUsuContrasenia(punVista.txtContrasenia.getText());

            if (cpunModelo.guardarUsuario(punModelo, true)) {

                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Registro guardado. Deseas guardar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION)) {
                    LimpiarPantalla();
                    marca = false;
                } else {
                    marca = true;
                }
            }

        }
        return marca;
    }

    public void LimpiarPantalla() {
        punVista.cbxAreaDependencia.setSelectedIndex(0);
        punVista.cbxAreaDependenciaId.setSelectedIndex(0);
        punVista.txtApellidosNombres.setText("");
        punVista.txtCorreoElectronico.setText("");
    }

    public void buscarUsuario(String usuId) {
        punModelo.setUsuId(Integer.parseInt(usuId));
        cpunModelo.buscarUsuario(punModelo);
        punVista.txtUsuId.setText("" + punModelo.getUsuId());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == punVista.btnLimpiar) {
            LimpiarPantalla();
        }

    }
}
