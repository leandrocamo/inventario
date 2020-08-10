package controller;

import vista.FrmInicioPrincipal;

public class InicioPrincipalController {

    private FrmInicioPrincipal vistaFIP;

    public InicioPrincipalController(FrmInicioPrincipal vistaFIP) {
        this.vistaFIP = vistaFIP;
    }

    public void iniciarFrmPrincipal() {
        vistaFIP.setVisible(true);
        vistaFIP.setExtendedState(6);
        vistaFIP.setTitle("SGI || Sistema de Gestión de Inventario");
    }
}
