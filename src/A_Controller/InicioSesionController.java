package A_Controller;

import A_Modelo.InicioSesionModel;
import A_Modelo.InicioSesionQuery;
import A_Vista.InicioSesionView;
import A_ClasesUtilizadas.ClasesUtilizadas;
import A_Vista.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class InicioSesionController implements ActionListener {

    private InicioSesionModel model;
    private InicioSesionQuery query;
    private InicioSesionView view;
    private ClasesUtilizadas claseAux = new ClasesUtilizadas();

    public InicioSesionController(InicioSesionModel model, InicioSesionQuery query, InicioSesionView view) {
        this.model = model;
        this.query = query;
        this.view = view;

        this.view.btnIngresar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
        this.view.btnConfigurar.addActionListener(this);
    }

    public void iniciarVista() {
        view.setTitle("Inicio");
        view.setLocationRelativeTo(null);
        view.setResizable(false);//bloquea cambiar el tamaño de la pantalla
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTON INGRESAR
        if (e.getSource() == view.btnIngresar) {

            if (claseAux.validarCampoVacio(view.txtUsuario.getText())
                    && claseAux.validarCampoVacio(view.txtContrasenia.getText())) {
                model.setUsuEmail(view.txtUsuario.getText());
                model.setUsuContrsasenia(view.txtContrasenia.getText());
                if (query.validasUsuario(model)) {
                    view.setVisible(false);

                    PrincipalView viewPrincipal = new PrincipalView();
                    PrincipalController controllerPrincipal = new PrincipalController(viewPrincipal);
                    controllerPrincipal.iniciarVista();
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        //BOTON CANCELAR
        if (e.getSource() == view.btnCancelar) {
            System.exit(0);
        }
        //BOTON CONFIGURACIÓN
        if (e.getSource() == view.btnConfigurar) {
            JOptionPane.showMessageDialog(null, "Programar Configurar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
