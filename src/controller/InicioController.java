package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class InicioController implements ActionListener {

    private Inicio iniciom;
    private ConsultaInicio inicioconsultam;
    private frmInicio frmInicio;

    public InicioController(Inicio modelo, ConsultaInicio modt, frmInicio frm) {
        this.iniciom = modelo;
        this.inicioconsultam = modt;
        this.frmInicio = frm;
        
        this.frmInicio.btningresar.addActionListener(this);
        this.frmInicio.btncancelar.addActionListener(this);
    }

    public void iniciar() {
        frmInicio.setTitle("Inicio");
        frmInicio.setLocationRelativeTo(null);
        frmInicio.setResizable(false);//bloquea cambiar el tamaño de la pantalla
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmInicio.btningresar) {
            iniciom.setUsuario(frmInicio.txtusuario.getText());
            iniciom.setContrasenia(frmInicio.txtcontrasenia.getText());

            if (inicioconsultam.buscarUsuario(iniciom)) {
                frmInicio.setVisible(false);
                try {
                    pnlPrincipal panelPrincipal = new pnlPrincipal();
                    pnlNuevoMueble panelNuevoM = new pnlNuevoMueble(null);
                    frmPrincipal vPrincipal = new frmPrincipal();
                    frmPrincipalController ctrlPrincipal = new frmPrincipalController(panelPrincipal, panelNuevoM, vPrincipal);
                    ctrlPrincipal.iniciar();
                } catch (ParseException ex) {
                    Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
            }
        }
        if (e.getSource() == frmInicio.btncancelar) {
            System.exit(0);
        }
    }

}
