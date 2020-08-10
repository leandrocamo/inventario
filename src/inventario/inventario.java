package inventario;

import controller.InicioSesionController;
import modelo.ConsultaInicioSesion;
import modelo.InicioSesion;
import vista.FrmInicioSesion;

public class inventario {

    public static void main(String[] args) {
        InicioSesion modeloIS = new InicioSesion();
        ConsultaInicioSesion modeloCIS = new ConsultaInicioSesion();
        FrmInicioSesion vistaFIS = new FrmInicioSesion();
        InicioSesionController controllerISC = new InicioSesionController(modeloIS, modeloCIS, vistaFIS);
        controllerISC.iniciarVista();
        vistaFIS.setVisible(true);
    }

}
