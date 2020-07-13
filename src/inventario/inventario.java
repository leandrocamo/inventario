
package inventario;

import modelo.InicioModel;
import modelo.InicioConsultaModel;
import vista.Inicio;
import controller.InicioController;


public class inventario {


    public static void main(String[] args) {
        InicioModel imodelo = new InicioModel();
        InicioConsultaModel icmodelo = new InicioConsultaModel();
        Inicio ivista = new Inicio();
        InicioController controller = new InicioController(imodelo, icmodelo, ivista);
        controller.iniciar();
        ivista.setVisible(true);
    }
    
}
