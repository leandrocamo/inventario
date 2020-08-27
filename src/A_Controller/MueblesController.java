package A_Controller;

import A_Modelo.MueblesModel;
import A_Modelo.MueblesNuevoModel;
import A_Modelo.MueblesNuevoQuery;
import A_Modelo.MueblesPrincipalModel;
import A_Modelo.MueblesPrincipalQuery;
import A_Modelo.MueblesQuery;
import A_Tabla.TablaMuebles;
import A_Vista.MueblesNuevoView;
import A_Vista.MueblesPrincipalView;
import A_Vista.MueblesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MueblesController implements ActionListener {

    private MueblesView view;
    private MueblesModel model;
    private MueblesQuery query;

    private MueblesPrincipalView viewMueblesPrincipal = new MueblesPrincipalView();
    private MueblesPrincipalModel modelMueblesPrincipal = new MueblesPrincipalModel();
    private MueblesPrincipalQuery queryMueblesPrincipal = new MueblesPrincipalQuery();
    private MueblesPrincipalController controllerMueblesPrincipal = new MueblesPrincipalController(viewMueblesPrincipal, modelMueblesPrincipal, queryMueblesPrincipal);

    private MueblesNuevoView viewMueblesNuevo = new MueblesNuevoView();
    private MueblesNuevoModel modelMueblesNuevo = new MueblesNuevoModel();
    private MueblesNuevoQuery queryMueblesNuevo = new MueblesNuevoQuery();
    private MueblesNuevoController controllerMueblesNuevo = new MueblesNuevoController(viewMueblesNuevo, modelMueblesNuevo, queryMueblesNuevo);

//    
    public MueblesController(MueblesView view, MueblesModel model, MueblesQuery query) {
        this.view = view;
        this.model = model;
        this.query = query;
        iniciarVista();

        this.view.btnNuevo.addActionListener(this);
        this.viewMueblesNuevo.btnCancelar.addActionListener(this);
        this.view.btnOpcionBuscar.addActionListener(this);

    }

    public void iniciarVista() {
        view.pnlMenuSuperior.setVisible(true);
        viewMueblesPrincipal.setVisible(true);
        viewMueblesNuevo.setVisible(false);
//        view.setVisible(false);
//        p2.setVisible(false);
//        controllerMueblesPrincipal.iniciarVista();
        view.PnlContenedor.add(viewMueblesPrincipal);
        view.PnlContenedor.validate();
    }

//   
    @Override
    public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Not-isSelected.", "Información", JOptionPane.INFORMATION_MESSAGE);
        if (e.getSource() == view.btnNuevo) {
            view.pnlMenuSuperior.setVisible(false);
            viewMueblesPrincipal.setVisible(false);
            viewMueblesNuevo.setVisible(true);
            viewMueblesNuevo.lblTitulo.setText("Registro de nuevo mueble");

            view.PnlContenedor.add(viewMueblesNuevo);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewMueblesNuevo.btnCancelar) {
            view.pnlMenuSuperior.setVisible(true);
            viewMueblesPrincipal.setVisible(true);
            viewMueblesNuevo.setVisible(false);

            view.PnlContenedor.add(viewMueblesPrincipal);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == view.btnOpcionBuscar) {
            if (view.btnOpcionBuscar.isSelected()) {
                viewMueblesPrincipal.pnlBuscarTexto.setVisible(false);
                viewMueblesPrincipal.pnlBuscarCombo.setVisible(true);
            } else {
//
                viewMueblesPrincipal.pnlBuscarTexto.setVisible(true);
                viewMueblesPrincipal.pnlBuscarCombo.setVisible(false);
            }
        }

//        
    }

}
