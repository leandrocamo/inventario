package controller;

import clases.ClasesUtilizadas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class InicioSesionController implements ActionListener {

    private InicioSesion modeloIS;
    private ConsultaInicioSesion modeloCIS;
    private FrmInicioSesion vistaFIS;
    private ClasesUtilizadas cu = new ClasesUtilizadas();

    public InicioSesionController(InicioSesion modeloIS, ConsultaInicioSesion modeloCIS, FrmInicioSesion vistaFIS) {
        this.modeloIS = modeloIS;
        this.modeloCIS = modeloCIS;
        this.vistaFIS = vistaFIS;
        //Asignacmos el ActionListener a los 3 botones de la vista
        this.vistaFIS.btnIngresar.addActionListener(this);
        this.vistaFIS.btnCancelar.addActionListener(this);
        this.vistaFIS.btnConfigurar.addActionListener(this);

    }

    public void iniciarVista() {
        vistaFIS.setTitle("Inicio");
        vistaFIS.setLocationRelativeTo(null);
        vistaFIS.setResizable(false);//bloquea cambiar el tamaño de la pantalla
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTON INGRESAR
        if (e.getSource() == vistaFIS.btnIngresar) {

            if (cu.validarCampoVacio(vistaFIS.txtusuario.getText()) && cu.validarCampoVacio(vistaFIS.txtcontrasenia.getText())) {
                modeloIS.setUsuario(vistaFIS.txtusuario.getText());
                modeloIS.setContrasenia(vistaFIS.txtcontrasenia.getText());
                if (modeloCIS.buscarUsuario(modeloIS)) {
                    vistaFIS.setVisible(false);
                    FrmInicioPrincipal vistaFP = new FrmInicioPrincipal();
                    InicioPrincipalController controllerIPC = new InicioPrincipalController(vistaFP);
                    controllerIPC.iniciarFrmPrincipal();
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        //BOTON CANCELAR
        if (e.getSource() == vistaFIS.btnCancelar) {
            System.exit(0);
        }
        //BOTON CONFIGURACIÓN
        if (e.getSource() == vistaFIS.btnConfigurar) {
            JOptionPane.showMessageDialog(null, "Programar Configurar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
