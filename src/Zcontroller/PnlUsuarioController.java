package Zcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Zvista.PnlUsuario;
import Zvista.PnlUsuariosDetalle;
import Zvista.PnlUsuarioNuevo;

public class PnlUsuarioController implements ActionListener {

    private PnlUsuario pnlUsuario;
    private PnlUsuariosDetalle pnlUsuariosDeta = new PnlUsuariosDetalle();
    private PnlUsuarioNuevo pnlUsuarioNue = new PnlUsuarioNuevo();
    private PnlUsuarioNuevoController controller = new PnlUsuarioNuevoController(pnlUsuarioNue);
    int clic_tabla = 0;

    public PnlUsuarioController(PnlUsuario pnlUsuario) {
        this.pnlUsuario = pnlUsuario;
        this.pnlUsuario.btnNuevo.addActionListener(this);

        this.pnlUsuarioNue.btnCancelar.addActionListener(this);
        this.pnlUsuarioNue.btnGuardar.addActionListener(this);
    }

    public void iniciarPanelUsuario() {
        pnlUsuario.btnNuevo.setVisible(true);
        pnlUsuario.btnInicio.setVisible(true);
        pnlUsuariosDeta.setVisible(true);
        pnlUsuarioNue.setVisible(false);
        clicJTableUsuarios();
        pnlUsuario.pnlContenedorUsuario.add(pnlUsuariosDeta);
        pnlUsuario.pnlContenedorUsuario.validate();

    }

    public void ingresarUsuario() {
        pnlUsuario.btnNuevo.setVisible(false);
        pnlUsuario.btnInicio.setVisible(false);
        pnlUsuariosDeta.setVisible(false);
        pnlUsuarioNue.setVisible(true);

        pnlUsuario.pnlContenedorUsuario.add(pnlUsuarioNue);
        pnlUsuario.pnlContenedorUsuario.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //CARGA EL PANEL DE USUARIO NUEVO
        if (e.getSource() == pnlUsuario.btnNuevo) {
            ingresarUsuario();
        }
        //CANCELAR, regresa al formulario Usuario Inicio
        if (e.getSource() == pnlUsuarioNue.btnCancelar) {
            iniciarPanelUsuario();
        }
//        //GUARDAR, guarda el usuario.
        if (e.getSource() == pnlUsuarioNue.btnGuardar) {
            controller = new PnlUsuarioNuevoController(pnlUsuarioNue);
            if (controller.ejecutarGuardar()) {
                iniciarPanelUsuario();
                pnlUsuariosDeta.renderizarTablaUsuario();
            }
        }
    }

    public void clicJTableUsuarios() {
        pnlUsuariosDeta.jTableUsuarios.addMouseListener(new MouseAdapter() {

//            @Override
            public void mouseClicked(MouseEvent evt) {
                clic_tabla = pnlUsuariosDeta.jTableUsuarios.rowAtPoint(evt.getPoint());

//                int usuID = Integer.parseInt("" + pnlUsuariosDeta.jTableUsuarios.getValueAt(clic_tabla, 1));
                String usuID = "" + pnlUsuariosDeta.jTableUsuarios.getValueAt(clic_tabla, 1);

                int column = pnlUsuariosDeta.jTableUsuarios.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / pnlUsuariosDeta.jTableUsuarios.getRowHeight();
                if (row < pnlUsuariosDeta.jTableUsuarios.getRowCount() && row >= 0
                        && column < pnlUsuariosDeta.jTableUsuarios.getColumnCount() && column >= 0) {
                    Object value = pnlUsuariosDeta.jTableUsuarios.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
                            System.out.println("Presionó editar con id " + usuID);
                            ingresarUsuario();

                            controller.buscarUsuario(usuID);

//                            ingresarUsuario(usuID);
////                                panelNuevoMueble = new Borrar_pnlNuevoMueble("" + mueID);
////                                panelPrincipal.setVisible(false);
////                                vPrincipal.pnlNavegacionSuperior.setVisible(false);
////                                vPrincipal.pnlNavegacionInferior.setVisible(true);
////                                panelNuevoMueble.setVisible(true);
////                                panelNuevoMueble.txtTitulo.setText("Actualización de Mueble");
////                                vPrincipal.pnlContenedor.add(panelNuevoMueble);
////                                vPrincipal.pnlContenedor.validate();
                        }
                        if (boton.getName().equals("e")) {
                            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.YES_NO_OPTION)) {
//                                Borrar_ConsultaPnlPrincipalMuebles cpm = new Borrar_ConsultaPnlPrincipalMuebles();
//                                Borrar_PnlPrincipal pp = new Borrar_PnlPrincipal();
//                                pp.setMueId("" + mueID);
//                                cpm.eliminarMueble(pp);
//                                panelPrincipal.renderizarTablas();
                            }
                        }
                    }
                }
            }

        });
    }

}
