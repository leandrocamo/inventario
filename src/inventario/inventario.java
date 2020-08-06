
package inventario;

import modelo.Inicio;
import modelo.ConsultaInicio;
import vista.frmInicio;
import controller.InicioController;


public class inventario {


    public static void main(String[] args) {
        Inicio imodelo = new Inicio();
        ConsultaInicio icmodelo = new ConsultaInicio();
        frmInicio ivista = new frmInicio();
        InicioController controller = new InicioController(imodelo, icmodelo, ivista);
        controller.iniciar();
        ivista.setVisible(true);
    }
    
}
