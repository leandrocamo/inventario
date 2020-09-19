package A_Controller;

import A_Modelo.MarcaModel;
import A_Modelo.MarcaQuery;
import A_Modelo.MueblesModel;
import A_Modelo.MueblesQuery;
import A_Vista.InventarioView;
import A_Vista.MarcaEdicionView;
import A_Vista.MarcaView;
import A_Vista.MenuView;
import A_Vista.MueblesView;
import A_Vista.PrincipalView;
import A_Vista.Reportes;
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

    private Reportes viewReportes = new Reportes();

    private MarcaView viewMarca = new MarcaView();
    private MarcaQuery queryMarca = new MarcaQuery();
    private MarcaModel modelMarca = new MarcaModel();
    private MarcaEdicionView viewMarcaEdicion = new MarcaEdicionView();
    private MarcaController controllerMarca = new MarcaController(viewMarca, modelMarca, queryMarca, viewMarcaEdicion);

    public PrincipalController(PrincipalView view) {
        this.view = view;
        this.viewMenu.btnBienes.addActionListener(this);
        this.viewMueble.btnRegresar.addActionListener(this);
        this.viewMenu.btnInventario.addActionListener(this);
        this.viewInventario.btnRegresarInventario.addActionListener(this);

        this.viewMenu.btnReportes.addActionListener(this);
        this.viewReportes.btnRegresar.addActionListener(this);

        this.viewMenu.btnMarca.addActionListener(this);
        this.viewMarca.btnRegresarMarca.addActionListener(this);
        
        this.viewMarca.btnNuevoMarca.addActionListener(this);
        this.viewMarcaEdicion.btnCancelar.addActionListener(this);

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
        viewReportes.setVisible(false);
        viewMarca.setVisible(false);
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
            viewReportes.setVisible(false);
            viewMarca.setVisible(false);
            viewMarcaEdicion.setVisible(false);

            view.PnlContenedor.add(viewMueble);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMenu.btnInventario) {
            viewMenu.setVisible(false);
            viewMueble.setVisible(false);
            viewInventario.setVisible(true);
            viewReportes.setVisible(false);
            viewMarca.setVisible(false);
            viewMarcaEdicion.setVisible(false);

            view.PnlContenedor.add(viewInventario);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMenu.btnReportes) {
            viewMenu.setVisible(false);
            viewMueble.setVisible(false);
            viewInventario.setVisible(false);
            viewReportes.setVisible(true);
            viewMarca.setVisible(false);
            viewMarcaEdicion.setVisible(false);

            view.PnlContenedor.add(viewReportes);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMenu.btnMarca) {
            viewMenu.setVisible(false);
            viewMueble.setVisible(false);
            viewInventario.setVisible(false);
            viewReportes.setVisible(false);
            viewMarca.setVisible(true);
            viewMarcaEdicion.setVisible(false);

            view.PnlContenedor.add(viewMarca);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMarca.btnNuevoMarca) {
            viewMenu.setVisible(false);
            viewMueble.setVisible(false);
            viewInventario.setVisible(false);
            viewReportes.setVisible(false);
            viewMarca.setVisible(false);
            viewMarcaEdicion.setVisible(true);

            view.PnlContenedor.add(viewMarcaEdicion);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMarcaEdicion.btnCancelar) {
            viewMenu.btnMarca.doClick();
        }
        if (e.getSource() == viewMueble.btnRegresar || e.getSource() == viewInventario.btnRegresarInventario
                || e.getSource() == viewReportes.btnRegresar || e.getSource() == viewMarca.btnRegresarMarca) {
            //Botón regresar a Inicio de la Vista Muebles
            panelInicio();
        }
    }

}
