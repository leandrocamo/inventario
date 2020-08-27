package Inicio;

import A_Modelo.InicioSesionModel;
import A_Modelo.InicioSesionQuery;
import A_Vista.InicioSesionView;
import A_Controller.InicioSesionController;

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
