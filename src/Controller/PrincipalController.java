package Controller;

import ClasesUtilizadas.ClasesUtilizadas;
import Modelo.CuentaContableModel;
import Modelo.CuentaContableQuery;
import Modelo.GeneralModel;
import Modelo.GeneralQuery;
import Modelo.MarcaModel;
import Modelo.MarcaQuery;
import Modelo.MueblesModel;
import Modelo.MueblesQuery;
import Modelo.UbicacionModel;
import Modelo.UbicacionQuery;
import Modelo.UsuarioModel;
import Modelo.UsuarioQuery;
import Modelo.UsuarioUbicacionModel;
import Modelo.UsuarioUbicacionQuery;

import Vista.GeneralEdicionView;
import Vista.GeneralView;
import Vista.CuentaContableEdicionView;
import Vista.CuentaContableView;
import Vista.InventarioView;
import Vista.MarcaEdicionView;
import Vista.MarcaView;
import Vista.MenuView;
import Vista.MueblesView;
import Vista.PrincipalView;
import Vista.Reportes;
import Vista.UbicacionEdicionView;
import Vista.UbicacionView;
import Vista.UsuarioEdicionView;
import Vista.UsuarioUbicacionView;
import Vista.UsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PrincipalController implements ActionListener {

    private final PrincipalView view;
    private final MenuView viewMenu = new MenuView();
    private final InventarioView viewInventario = new InventarioView();

    private final ClasesUtilizadas clases = new ClasesUtilizadas();
    //Mueble
    private final MueblesView viewMueble = new MueblesView();
    private final MueblesQuery queryMueble = new MueblesQuery();
    private final MueblesModel modelMueble = new MueblesModel();
    private final MueblesController controllerMueble = new MueblesController(viewMueble, modelMueble, queryMueble);

    private final Reportes viewReportes = new Reportes();

    private final MarcaView viewMarca = new MarcaView();
    private final MarcaQuery queryMarca = new MarcaQuery();
    private final MarcaModel modelMarca = new MarcaModel();
    private final MarcaEdicionView viewMarcaEdicion = new MarcaEdicionView();
    private final MarcaController controllerMarca = new MarcaController(viewMarca, modelMarca, queryMarca, viewMarcaEdicion);

    private final GeneralView viewGeneral = new GeneralView();
    private final GeneralEdicionView viewGeneralEdicion = new GeneralEdicionView();
    private final GeneralQuery queryGeneral = new GeneralQuery();
    private final GeneralModel modelGeneral = new GeneralModel();
    private GeneralController controllerGeneral;

    private final CuentaContableView viewCC = new CuentaContableView();
    private final CuentaContableEdicionView viewCCEdicion = new CuentaContableEdicionView();
    private final CuentaContableModel modelCC = new CuentaContableModel();
    private final CuentaContableQuery queryCC = new CuentaContableQuery();
    private final CuentaContableController controllerCC = new CuentaContableController(viewCC, modelCC, queryCC, viewCCEdicion);

    private final UbicacionView viewUbicacion = new UbicacionView();
    private final UbicacionEdicionView viewUbicacionEdicion = new UbicacionEdicionView();
    private final UbicacionModel modelUbicacion = new UbicacionModel();
    private final UbicacionQuery queryUbicacion = new UbicacionQuery();
    private final UbicacionController controllerUbicacion = new UbicacionController(viewUbicacion, modelUbicacion, queryUbicacion, viewUbicacionEdicion);

    private final UsuarioView viewUsuario = new UsuarioView();
    private final UsuarioEdicionView viewUsuarioEdicion = new UsuarioEdicionView();
    private final UsuarioModel modelUsuario = new UsuarioModel();
    private final UsuarioQuery queryUsuario = new UsuarioQuery();

    private final UsuarioUbicacionView viewUsuarioUbicacion = new UsuarioUbicacionView();
    private final UsuarioUbicacionModel modelUsuarioUbicacion = new UsuarioUbicacionModel();
    private final UsuarioUbicacionQuery queryUsuarioUbicacion = new UsuarioUbicacionQuery();

    private final UsuarioController controllerUsuario = new UsuarioController(viewUsuario, modelUsuario, queryUsuario, viewUsuarioEdicion, viewUsuarioUbicacion, modelUsuarioUbicacion, queryUsuarioUbicacion);

    public String sentenciaSelectAll = "";
    public String opcion = "";

    public PrincipalController(PrincipalView view) {
        this.view = view;
        this.viewMenu.btnBienes.addActionListener(this);
        this.viewMueble.btnRegresar.addActionListener(this);
        this.viewMenu.btnInventario.addActionListener(this);
        this.viewInventario.btnRegresarInventario.addActionListener(this);

        this.viewMenu.btnReportes.addActionListener(this);
        this.viewReportes.btnRegresar.addActionListener(this);

        this.viewMenu.btnMarca.addActionListener(this);
        this.viewMarca.btnRegresarMarca.addActionListener(this);
        this.viewMarca.btnNuevoMarca.addActionListener(this);
        this.viewMarcaEdicion.btnCancelar.addActionListener(this);

        this.viewMenu.btnColor.addActionListener(this);

        this.viewMenu.btnCuentaContable.addActionListener(this);
        this.viewCC.btnRegresar.addActionListener(this);
        this.viewCC.btnNuevo.addActionListener(this);
        this.viewCCEdicion.btnCancelar.addActionListener(this);

        // GENERAL
        this.viewGeneral.btnBuscar.addActionListener(this);
        this.viewGeneral.btnNuevo.addActionListener(this);
        this.viewGeneral.btnRegresar.addActionListener(this);
        this.viewGeneralEdicion.btnCancelar.addActionListener(this);
        this.viewGeneralEdicion.btnGuardarRegistro.addActionListener(this);

        this.viewMenu.btnTipoMueble.addActionListener(this);
        this.viewMenu.btnAreaDependencia.addActionListener(this);
        this.viewMenu.btnEstado.addActionListener(this);

        this.viewMenu.btnUbicacion.addActionListener(this);
        this.viewUbicacion.btnRegresar.addActionListener(this);
        this.viewUbicacion.btnNuevo.addActionListener(this);
        this.viewUbicacionEdicion.btnCancelar.addActionListener(this);

        this.viewMenu.btnUsuario.addActionListener(this);
        this.viewUsuario.btnRegresar.addActionListener(this);
        this.viewUsuario.btnNuevo.addActionListener(this);
        this.viewUsuarioEdicion.btnCancelar.addActionListener(this);
        this.viewUsuario.btnUsuarioUbicacion.addActionListener(this);

        clicJTableGeneral();

    }

    public void iniciarVista() {
        view.setVisible(true);
        view.setExtendedState(6);
        view.setTitle("SGI || Sistema de Gestión de Inventario");
        panelInicioMenu();
    }

    public void panelInicioMenu() {
        viewMenu.setVisible(true);
        view.PnlContenedor.add(viewMenu);
        view.PnlContenedor.validate();
    }

    public void panelMenu() {
        viewMenu.setVisible(false);
        viewMueble.setVisible(false);
        viewInventario.setVisible(false);
        viewReportes.setVisible(false);
        viewMarca.setVisible(false);
        viewMarcaEdicion.setVisible(false);
        viewCC.setVisible(false);
        viewCCEdicion.setVisible(false);

        viewGeneral.setVisible(false);
        viewGeneralEdicion.setVisible(false);

        viewUbicacion.setVisible(false);
        viewUbicacionEdicion.setVisible(false);
        viewUsuario.setVisible(false);
        viewUsuarioEdicion.setVisible(false);
        viewUsuarioUbicacion.setVisible(false);

    }

    public String sentenciasSQL(String opcion, String accion) {
        System.out.println("MENSAJE: " + "opcion: " + opcion + " acción: " + accion);
        String sql = "";

        switch (accion) {
            case "Buscar":
                switch (opcion) {
                    case "Color":
                        sql = "SELECT *FROM COLOR WHERE COLESTADO=1 "
                                + "AND (COLNOMBRE LIKE '%" + viewGeneral.txtBuscar.getText() + "%' "
                                + "OR COLDESCRIPCION LIKE '%" + viewGeneral.txtBuscar.getText() + "%') ORDER BY COLNOMBRE";
                        break;
                    case "Tipo de Mueble":
                        sql = "SELECT *FROM TIPOMUEBLE WHERE TMESTADO=1 "
                                + "AND (TMNOMBRE LIKE '%" + viewGeneral.txtBuscar.getText() + "%' "
                                + "OR TMDESCRIPCION LIKE '%" + viewGeneral.txtBuscar.getText() + "%') ORDER BY TMNOMBRE";
                        break;
                    case "Área de Dependencia":
                        sql = "SELECT *FROM areadependencia WHERE ADESTADO=1 "
                                + "AND (ADNOMBRE LIKE '%" + viewGeneral.txtBuscar.getText() + "%' "
                                + "OR ADDESCRIPCION LIKE '%" + viewGeneral.txtBuscar.getText() + "%') ORDER BY ADNOMBRE";
                        break;
                    case "Estado":
                        sql = "SELECT *FROM estado WHERE ESTESTADO=1 "
                                + "AND (ESTNOMBRE LIKE '%" + viewGeneral.txtBuscar.getText() + "%' "
                                + "OR ESTDESCRIPCION LIKE '%" + viewGeneral.txtBuscar.getText() + "%') ORDER BY ESTNOMBRE";
                        break;
                }
                break;
            case "Editar":
                switch (opcion) {
                    case "Color":

                        sql = "SELECT *FROM COLOR WHERE COLESTADO=1 AND COLID=";
                        break;
                    case "Tipo de Mueble":

                        sql = "SELECT *FROM TIPOMUEBLE WHERE TMESTADO=1 AND TMID =";
                        break;
                    case "Área de Dependencia":

                        sql = "SELECT *FROM areadependencia WHERE ADESTADO=1 AND ADID =";
                        break;
                    case "Estado":

                        sql = "SELECT *FROM estado WHERE ESTESTADO=1 AND ESTID =";
                        break;
                }
                break;
            case "Eliminar":
                switch (opcion) {
                    case "Color":
                        sql = "DELETE FROM COLOR WHERE COLID = ?";
                        break;
                    case "Tipo de Mueble":
                        sql = "DELETE FROM TIPOMUEBLE WHERE TMID = ?";
                        break;
                    case "Área de Dependencia":
                        sql = "DELETE FROM areadependencia WHERE ADID = ?";
                        break;
                    case "Estado":
                        sql = "DELETE FROM estado WHERE ESTID = ?";
                        break;

                }
                break;
            case "Insertar":
                switch (opcion) {
                    case "Color":
                        sql = "INSERT INTO COLOR (COLNOMBRE, COLDESCRIPCION, COLESTADO) VALUES (?, ?, ?);";
                        break;
                    case "Tipo de Mueble":
                        sql = "INSERT INTO TIPOMUEBLE (TMNOMBRE, TMDESCRIPCION, TMESTADO) VALUES (?, ?, ?);";
                        break;
                    case "Área de Dependencia":
                        sql = "INSERT INTO areadependencia (ADNOMBRE, ADDESCRIPCION, ADESTADO) VALUES (?, ?, ?);";
                        break;
                    case "Estado":
                        sql = "INSERT INTO estado (ESTNOMBRE, ESTDESCRIPCION, ESTESTADO) VALUES (?, ?, ?);";
                        break;

                }
                break;
            case "Actualizar":
                switch (opcion) {
                    case "Color":
                        sql = "UPDATE COLOR SET COLNOMBRE=?, COLDESCRIPCION=? WHERE COLID=?";
                        break;
                    case "Tipo de Mueble":
                        sql = "UPDATE TIPOMUEBLE SET TMNOMBRE=?, TMDESCRIPCION=? WHERE TMID=?";
                        break;
                    case "Área de Dependencia":
                        sql = "UPDATE areadependencia SET ADNOMBRE=?, ADDESCRIPCION=? WHERE ADID=?";
                        break;
                    case "Estado":
                        sql = "UPDATE estado SET ESTNOMBRE=?, ESTDESCRIPCION=? WHERE ESTID=?";
                        break;

                }
                break;
        }
        return sql;
    }
    private int clic_tabla = 0;
    private String accion = "";

    public void renderizarTotalRegistros() {
        viewGeneral.lblTotalRegistros.setText("Se encontraron " + controllerGeneral.tabla.getTotalRegistros() + " de " + queryGeneral.totalRegistros(sentenciaSelectAll));
    }

    public void clicJTableGeneral() {
        viewGeneral.jTable.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                clic_tabla = viewGeneral.jTable.rowAtPoint(evt.getPoint());

                int id = Integer.parseInt("" + viewGeneral.jTable.getValueAt(clic_tabla, 1));
                int column = viewGeneral.jTable.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / viewGeneral.jTable.getRowHeight();

                if (row < viewGeneral.jTable.getRowCount() && row >= 0
                        && column < viewGeneral.jTable.getColumnCount() && column >= 0) {
                    Object value = viewGeneral.jTable.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        String editar = sentenciasSQL(opcion, "Editar");

                        if (boton.getName().equals("m")) {
//                            JOptionPane.showMessageDialog(null, "PRESIONÓ EDITAR","Advertencia", JOptionPane.INFORMATION_MESSAGE);
                            viewGeneralEdicion.lblTitulo.setText("Actualización de " + opcion);
                            modelGeneral.setId(id);
                            viewGeneral.btnNuevo.doClick();
                            queryGeneral.buscarRegistroID(modelGeneral, editar + modelGeneral.getId());
                            viewGeneralEdicion.txtCodigo.setText("" + modelGeneral.getId());
                            viewGeneralEdicion.txtNombre.setText("" + modelGeneral.getNombre());
                            viewGeneralEdicion.txtDescripcion.setText("" + modelGeneral.getDescripcion());

                        }
                        String eliminar = sentenciasSQL(opcion, "Eliminar");
                        if (boton.getName().equals("e")) {
//                            JOptionPane.showMessageDialog(null, "PRESIONÓ ELIMINAR "+modelGeneral.getId(), "Advertencia", JOptionPane.ERROR_MESSAGE);
                            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Desea eliminar este registro?", "Confirmar", JOptionPane.YES_NO_OPTION)) {
                                modelGeneral.setId(id);
                                queryGeneral.eliminarRegistro(modelGeneral, eliminar);
                                controllerGeneral.renderizarTabla(sentenciaSelectAll);
                                renderizarTotalRegistros();
//                                JOptionPane.showMessageDialog(null, "PRESIONÓ ELIMINAR " + modelGeneral.getId(), "Advertencia", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewMenu.btnBienes) {
            panelMenu();
            viewMueble.setVisible(true);

            view.PnlContenedor.add(viewMueble);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewMenu.btnInventario) {
            panelMenu();
            viewInventario.setVisible(true);

            view.PnlContenedor.add(viewInventario);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMenu.btnReportes) {
            panelMenu();
            viewReportes.setVisible(true);

            view.PnlContenedor.add(viewReportes);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMenu.btnMarca) {
            panelMenu();
            viewMarca.setVisible(true);

            view.PnlContenedor.add(viewMarca);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewMarca.btnNuevoMarca) {
            panelMenu();
            viewMarcaEdicion.setVisible(true);
            view.PnlContenedor.add(viewMarcaEdicion);
            view.PnlContenedor.validate();

        }
        if (e.getSource() == viewMarcaEdicion.btnCancelar) {
            viewMenu.btnMarca.doClick();
        }

        //CUENTA CONTABLE =============================================
        if (e.getSource() == viewMenu.btnCuentaContable) {
            panelMenu();
            viewCC.setVisible(true);
            view.PnlContenedor.add(viewCC);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewCC.btnNuevo) {
            panelMenu();
            viewCCEdicion.setVisible(true);
            view.PnlContenedor.add(viewCCEdicion);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewCCEdicion.btnCancelar) {
            viewMenu.btnCuentaContable.doClick();
        }
        // C O L O R =====================================================
        //Cuando el usuario presiona Color en el Menú, muestra la administración de color
        if (e.getSource() == viewMenu.btnColor) {
            opcion = "Color";
            panelMenu();
            viewGeneral.setVisible(true);
            viewGeneral.lblTitulo.setText("Administración de " + opcion);
            view.PnlContenedor.add(viewGeneral);
            view.PnlContenedor.validate();

            sentenciaSelectAll = "SELECT *FROM COLOR WHERE COLESTADO=1 ORDER BY COLNOMBRE";
            controllerGeneral = new GeneralController(viewGeneral, modelGeneral, queryGeneral, viewGeneralEdicion, sentenciaSelectAll);
            renderizarTotalRegistros();
//            clicJTable();

        }
        // T I P O  D E  M U E B L E ===========================================
        //Cuando el usuario presiona Color en el Menú, muestra la administración de color
        if (e.getSource() == viewMenu.btnTipoMueble) {
            opcion = "Tipo de Mueble";
            panelMenu();
            viewGeneral.setVisible(true);
            viewGeneral.lblTitulo.setText("Administración de " + opcion);
            view.PnlContenedor.add(viewGeneral);
            view.PnlContenedor.validate();

            sentenciaSelectAll = "SELECT *FROM TIPOMUEBLE WHERE TMESTADO=1 ORDER BY TMNOMBRE";
            controllerGeneral = new GeneralController(viewGeneral, modelGeneral, queryGeneral, viewGeneralEdicion, sentenciaSelectAll);
//            clicJTable();
            renderizarTotalRegistros();
        }
        // A R E A   D E   D E P E N D E N C I A ================================
        //Cuando el usuario presiona Color en el Menú, muestra la administración de color
        if (e.getSource() == viewMenu.btnAreaDependencia) {
            opcion = "Área de Dependencia";
            panelMenu();
            viewGeneral.setVisible(true);
            viewGeneral.lblTitulo.setText("Administración de " + opcion);
            view.PnlContenedor.add(viewGeneral);
            view.PnlContenedor.validate();

            sentenciaSelectAll = "SELECT *FROM areadependencia WHERE ADESTADO=1 ORDER BY ADNOMBRE";
            controllerGeneral = new GeneralController(viewGeneral, modelGeneral, queryGeneral, viewGeneralEdicion, sentenciaSelectAll);
            renderizarTotalRegistros();
        }
        // E S T A D O   D E L   M U E B L E ================================
        //Cuando el usuario presiona Color en el Menú, muestra la administración de color
        if (e.getSource() == viewMenu.btnEstado) {
            opcion = "Estado";
            panelMenu();
            viewGeneral.setVisible(true);
            viewGeneral.lblTitulo.setText("Administración de " + opcion);
            view.PnlContenedor.add(viewGeneral);
            view.PnlContenedor.validate();

            sentenciaSelectAll = "SELECT *FROM estado WHERE ESTESTADO=1 ORDER BY ESTNOMBRE";
            controllerGeneral = new GeneralController(viewGeneral, modelGeneral, queryGeneral, viewGeneralEdicion, sentenciaSelectAll);
            renderizarTotalRegistros();
        }
        // U B I C A C I Ó N ============================================
        if (e.getSource() == viewMenu.btnUbicacion) {
            opcion = "Ubicación";
            panelMenu();
            viewUbicacion.setVisible(true);
            viewUbicacion.lblTitulo.setText("Administración de " + opcion);
            view.PnlContenedor.add(viewUbicacion);
            view.PnlContenedor.validate();
            System.out.println("U B I C A C I Ó N");
        }
        if (e.getSource() == viewUbicacion.btnNuevo) {
            panelMenu();
            viewUbicacionEdicion.setVisible(true);
            viewUbicacionEdicion.lblTitulo.setText("Registro de " + opcion);
            viewUbicacionEdicion.txtCodigo.setText("");
            viewUbicacionEdicion.txtUbicacion.setText("");
            viewUbicacionEdicion.cbxAreaDependencia.setSelectedIndex(0);

            view.PnlContenedor.add(viewUbicacionEdicion);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewUbicacionEdicion.btnCancelar) {
            viewMenu.btnUbicacion.doClick();
        }
        // U S U A R I O S ===================================

        if (e.getSource() == viewMenu.btnUsuario) {
            opcion = "Usuarios";
            panelMenu();
            viewUsuario.setVisible(true);
            viewUsuario.lblTitulo.setText("Administración de " + opcion);
            view.PnlContenedor.add(viewUsuario);
            view.PnlContenedor.validate();
            System.out.println("U S U A R I O S");

        }
        if (e.getSource() == viewUsuario.btnNuevo) {
            panelMenu();
            viewUsuarioEdicion.setVisible(true);
            viewUsuarioEdicion.lblTitulo.setText("Registro de " + opcion);
            viewUsuarioEdicion.txtCodigo.setText("");
            viewUsuarioEdicion.txtNombres.setText("");
            viewUsuarioEdicion.txtApellidos.setText("");
            viewUsuarioEdicion.txtCorreoElectronico.setText("");

            view.PnlContenedor.add(viewUsuarioEdicion);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewUsuarioEdicion.btnCancelar) {
            viewMenu.btnUsuario.doClick();
        }
        // U S U A R I O - U B I C A C I Ó N =======================================
        if (e.getSource() == viewUsuario.btnUsuarioUbicacion) {
            panelMenu();
            viewUsuarioUbicacion.setVisible(true);

            view.PnlContenedor.add(viewUsuarioUbicacion);
            view.PnlContenedor.validate();
        }

        // F I N =============================================
        if (e.getSource() == viewGeneralEdicion.btnCancelar) {
            switch (opcion) {
                case "Color":
                    viewMenu.btnColor.doClick();
                    break;
                case "Tipo de Mueble":
                    viewMenu.btnTipoMueble.doClick();
                    break;
                case "Área de Dependencia":
                    viewMenu.btnAreaDependencia.doClick();
                    break;
                case "Estado":
                    viewMenu.btnEstado.doClick();
                    break;
            }
        }

        if (e.getSource() == viewGeneral.btnBuscar) {
            controllerGeneral.tabla.cargandoRegistros(viewGeneral.jTable, sentenciasSQL(opcion, "Buscar"));
            renderizarTotalRegistros();

        }
        //Cuando el usuario presiona Color Nuevo, muestra la ventana para ingresar color.
        if (e.getSource() == viewGeneral.btnNuevo) {
            panelMenu();
            viewGeneralEdicion.setVisible(true);
            viewGeneralEdicion.lblTitulo.setText("Registo de " + opcion);
            viewGeneralEdicion.txtCodigo.setText("");
            viewGeneralEdicion.txtNombre.setText("");
            viewGeneralEdicion.txtDescripcion.setText("");

            view.PnlContenedor.add(viewGeneralEdicion);
            view.PnlContenedor.validate();
        }
        if (e.getSource() == viewGeneralEdicion.btnGuardarRegistro) {
//            JOptionPane.showMessageDialog(null, "id: " + modelGeneral.getId());
            if (modelGeneral.getId() == 0) {
                if (controllerGeneral.insertarRegistro(sentenciasSQL(opcion, "Insertar"))) {
                    viewGeneral.txtBuscar.setText("");
                    viewGeneral.btnBuscar.doClick();
                    renderizarTotalRegistros();
                    viewGeneralEdicion.btnCancelar.doClick();

                }
            } else {
                if (controllerGeneral.guardarRegistro(sentenciasSQL(opcion, "Actualizar"))) {
                    modelGeneral.setId(0);
                    viewGeneral.txtBuscar.setText("");
                    viewGeneral.btnBuscar.doClick();
                    renderizarTotalRegistros();
                    viewGeneralEdicion.btnCancelar.doClick();

                }
            }
        }

        if (e.getSource() == viewMueble.btnRegresar
                || e.getSource() == viewInventario.btnRegresarInventario
                || e.getSource() == viewReportes.btnRegresar
                || e.getSource() == viewMarca.btnRegresarMarca
                || e.getSource() == viewGeneral.btnRegresar
                || e.getSource() == viewCC.btnRegresar
                || e.getSource() == viewUbicacion.btnRegresar
                || e.getSource() == viewUsuario.btnRegresar) {

            panelMenu();
            panelInicioMenu();
        }

    }

}
