package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;


public class InicioController implements ActionListener {

    private InicioModel iniciom;
    private InicioConsultaModel inicioconsultam;
    private Inicio frmInicio;

    public InicioController(InicioModel modelo, InicioConsultaModel modt, Inicio frm) {
        this.iniciom = modelo;
        this.inicioconsultam = modt;
        this.frmInicio = frm;
        this.frmInicio.btningresar.addActionListener(this);
        this.frmInicio.btncancelar.addActionListener(this);
    }

    public void iniciar() {
        frmInicio.setTitle("Inicio");
        frmInicio.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmInicio.btningresar) {
            iniciom.setUsuario(frmInicio.txtusuario.getText());
            iniciom.setContrasenia(frmInicio.txtcontrasenia.getText());
            if (inicioconsultam.buscarUsuario(iniciom)) {
//                JOptionPane.showMessageDialog(null, "Ingreso");
                Principal frmPrincipal = new Principal();
                frmInicio.setVisible(false);
                frmPrincipal.setVisible(true);
                Principal vistaPrincipal = new Principal();
                PrincipalConsultaModel modeloPrincipalConsulta = new PrincipalConsultaModel();
                PrincipalController controladorPrincipal = new PrincipalController(frmPrincipal);
                
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
            }
        }
        if (e.getSource() == frmInicio.btncancelar) {
            System.exit(0);
        }
    }

}
