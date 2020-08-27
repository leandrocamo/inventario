package Zcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Zvista.FrmInicioPrincipal;
import Zvista.PnlUsuario;
import Zvista.pnl02;
import Zvista.pnlMenu;

public class InicioPrincipalController implements ActionListener {

    private FrmInicioPrincipal vistaFIP;
    private pnlMenu menu = new pnlMenu();

    private PnlUsuario p1 = new PnlUsuario();
    private PnlUsuarioController usuarioController = new PnlUsuarioController(p1);

    private pnl02 p2 = new pnl02();

    public InicioPrincipalController(FrmInicioPrincipal vistaFIP) {
        this.vistaFIP = vistaFIP;

        this.menu.btnUsuario.addActionListener(this);
        this.menu.jButton9.addActionListener(this);
        this.menu.jButton10.addActionListener(this);
        this.p1.btnInicio.addActionListener(this);
        this.p2.jButton1.addActionListener(this);
    }

    public void iniciarFrmPrincipal() {
        vistaFIP.setVisible(true);
        vistaFIP.setExtendedState(6);
        vistaFIP.setTitle("SGI || Sistema de Gestión de Inventario");
        cargarPanelInicial();
    }

    public void cargarPanelInicial() {
        menu.setVisible(true);
        p1.setVisible(false);
        p2.setVisible(false);
        vistaFIP.pnlContenedor.add(menu);
        vistaFIP.pnlContenedor.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //OPCION USUARIOS
        if (e.getSource() == menu.btnUsuario) {
            menu.setVisible(false);
            p1.setVisible(true);
            p2.setVisible(false);

            vistaFIP.pnlContenedor.add(p1);
            vistaFIP.pnlContenedor.validate();

            usuarioController.iniciarPanelUsuario();
        }
        //OPCION 2 DEL MENÚ
        if (e.getSource() == menu.jButton9) {
            menu.setVisible(false);
            p1.setVisible(false);
            p2.setVisible(true);

            vistaFIP.pnlContenedor.add(p2);
            vistaFIP.pnlContenedor.validate();
        }
        //OPCION INICIO
        if (e.getSource() == p1.btnInicio || e.getSource() == p2.jButton1) {
            cargarPanelInicial();
        }

    }
}
