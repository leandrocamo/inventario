package A_Controller;

import A_Modelo.ColorQuery;
import A_Modelo.MarcaModel;
import A_Modelo.MarcaQuery;
import A_Modelo.MueblesModel;
import A_Modelo.MueblesQuery;
import A_Vista.ColorEdicionView;
import A_Vista.ColorView;
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

    private ColorView viewColor = new ColorView();
    private ColorEdicionView viewColorEdicion = new ColorEdicionView();
    private ColorQuery queryColor = new ColorQuery();
    private ColorController controllerColor = new ColorController(viewColor, modelMarca, queryColor, viewColorEdicion);

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

        this.viewMenu.btnColor.addActionListener(this);
        this.viewColor.btnRegresarColor.addActionListener(this);
        this.viewColor.btnNuevoColor.addActionListener(this);
        this.viewColorEdicion.btnCancelar.addActionListener(this);

    }

    public void iniciarVista() {
        view.setVisible(true);
        view.setExtendedState(6);
        view.setTitle("SGI || Sistema de Gestión de Inventario");
        panelInicioMenu();
    }

    public void panelInicioMenu() {
        viewMenu.setVisible(true);
        view.PnlContenedor.add(viewMenu);
        view.PnlContenedor.validate();
    }

    public void panelMenu() {
        viewMenu.setVisible(false);
        viewMueble.setVisible(false);
        viewInventario.setVisible(false);
        viewReportes.setVisible(false);
        viewMarca.setVisible(false);
        viewMarcaEdicion.setVisible(false);
        viewColor.setVisible(false);
        viewColorEdicion.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewMenu.btnBienes) {
            panelMenu();
            viewMueble.setVisible(true);

            view.PnlContenedor.add(viewMueble);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewMenu.btnInventario) {
            panelMenu();
            viewInventario.setVisible(true);

            view.PnlContenedor.add(viewInventario);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMenu.btnReportes) {
            panelMenu();
            viewReportes.setVisible(true);

            view.PnlContenedor.add(viewReportes);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMenu.btnMarca) {
            panelMenu();
            viewMarca.setVisible(true);

            view.PnlContenedor.add(viewMarca);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewMarca.btnNuevoMarca) {
            panelMenu();
            viewMarcaEdicion.setVisible(true);
            view.PnlContenedor.add(viewMarcaEdicion);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMarcaEdicion.btnCancelar) {
            viewMenu.btnMarca.doClick();
        }

        //========== COLOR
        //Cuando el usuario presiona Color en el Menú, muestra la administración de color
        if (e.getSource() == viewMenu.btnColor) {
            panelMenu();
            viewColor.setVisible(true);
            view.PnlContenedor.add(viewColor);
            view.PnlContenedor.validate();
        }
        //Cuando el usuario presiona Color Nuevo, muestra la ventana para ingresar color.
        if (e.getSource() == viewColor.btnNuevoColor) {
            panelMenu();
            viewColorEdicion.setVisible(true);
            view.PnlContenedor.add(viewColorEdicion);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewColorEdicion.btnCancelar) {
            viewMenu.btnColor.doClick();
        }

        if (e.getSource() == viewMueble.btnRegresar
                || e.getSource() == viewInventario.btnRegresarInventario
                || e.getSource() == viewReportes.btnRegresar
                || e.getSource() == viewMarca.btnRegresarMarca
                || e.getSource() == viewColor.btnRegresarColor) {

            panelMenu();
            panelInicioMenu();
        }

    }

}
