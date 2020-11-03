package Inicio;

import Modelo.InicioSesionModel;
import Modelo.InicioSesionQuery;
import Vista.InicioSesionView;
import Controller.InicioSesionController;

public class inventario {

    public static void main(String[] args) {
        InicioSesionModel model = new InicioSesionModel();
        InicioSesionQuery query = new InicioSesionQuery();
        InicioSesionView view = new InicioSesionView();

        InicioSesionController controller = new InicioSesionController(model, query, view);
        controller.iniciarVista();
        view.setVisible(true);
    }

}
