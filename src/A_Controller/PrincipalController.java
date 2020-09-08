package A_Controller;

import A_Modelo.MueblesModel;
import A_Modelo.MueblesQuery;
import A_Vista.InventarioView;
import A_Vista.MenuView;
import A_Vista.MueblesView;
import A_Vista.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PrincipalController implements ActionListener {

    private PrincipalView view;
    private MenuView viewMenu = new MenuView();
    private InventarioView viewInventario = new InventarioView();
    //Mueble
    private MueblesView viewMueble = new MueblesView();
    private MueblesQuery queryMueble = new MueblesQuery();
    private MueblesModel modelMueble = new MueblesModel();
    private MueblesController controllerMueble = new MueblesController(viewMueble, modelMueble, queryMueble);

    public PrincipalController(PrincipalView view) {
        this.view = view;
        this.viewMenu.btnBienes.addActionListener(this);
        this.viewMueble.btnRegresar.addActionListener(this);
        this.viewMenu.btnInventario.addActionListener(this);
        this.viewInventario.btnRegresarInventario.addActionListener(this);
    }

    public void iniciarVista() {
        view.setVisible(true);
        view.setExtendedState(6);
        view.setTitle("SGI || Sistema de Gestión de Inventario");
        panelInicio();
    }

    public void panelInicio() {
        viewMenu.setVisible(true);
        viewMueble.setVisible(false);
        viewInventario.setVisible(false);
//        p2.setVisible(false);
        view.PnlContenedor.add(viewMenu);
        view.PnlContenedor.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //OPCION USUARIOS
//        if (e.getSource() == viewMenu.btnUsuario) {
//            //viewMenu.setVisible(false);
//            JOptionPane.showMessageDialog(null, "Programar Pnl Usuario", "Información", JOptionPane.INFORMATION_MESSAGE);
//        }
        if (e.getSource() == viewMenu.btnBienes) {
            viewMenu.setVisible(false);
            viewMueble.setVisible(true);
            viewInventario.setVisible(false);
//            controllerMueble.iniciarVista();
            view.PnlContenedor.add(viewMueble);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMenu.btnInventario) {
            viewMenu.setVisible(false);
            viewMueble.setVisible(false);
            viewInventario.setVisible(true);
//            controllerMueble.iniciarVista();
            view.PnlContenedor.add(viewInventario);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMueble.btnRegresar || e.getSource() == viewInventario.btnRegresarInventario) {
            //Botón regresar a Inicio de la Vista Muebles
            panelInicio();
        }
    }

}
