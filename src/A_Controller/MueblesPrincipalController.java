package A_Controller;

import A_Modelo.MueblesPrincipalModel;
import A_Modelo.MueblesPrincipalQuery;
import A_Vista.MueblesPrincipalView;
import A_Tabla.TablaMuebles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MueblesPrincipalController implements ActionListener {

    private MueblesPrincipalView view;
    private MueblesPrincipalModel model;
    private MueblesPrincipalQuery query;
    private ArrayList<String> lista = new ArrayList<>();
    private TablaMuebles tabla = new TablaMuebles();
    private String usuID = "Todos";
    private String ccID = "Todos";
//    private int clic_tabla = 0;

    public MueblesPrincipalController(MueblesPrincipalView view, MueblesPrincipalModel model, MueblesPrincipalQuery query) {
        this.view = view;
        this.model = model;
        this.query = query;

        cargarCustodios();
        cargarCuentaContable();
        tabla.cargandoRegistrosMuebles(this.view.jTableMuebles, "", ccID, usuID);
        view.pnlBuscarTexto.setVisible(true);
        view.pnlBuscarCombo.setVisible(false);
        view.pnlCodigos.setVisible(false);
        this.view.cbxCuentaContable.addActionListener(this);
        this.view.cbxCustodio.addActionListener(this);
        this.view.btnBuscarPorTexto.addActionListener(this);
        this.view.btnBuscarPorParametro.addActionListener(this);
        this.view.txtTotalRegistros.setText("Se encontraron " + query.totalRegistros() + " de " + query.totalRegistros() + " registros.");
//        clicJTableMuebles();
    }

    public void iniciarVista() {
    }

    public void renderizarTabla() {
        tabla.cargandoRegistrosMuebles(this.view.jTableMuebles, "", ccID, usuID);
    }

    public void cargarCustodios() {
        lista = query.buscarCustodios();
        view.cbxCustodio.addItem("Todos");
        for (int i = 0; i < lista.size(); i++) {
            view.cbxCustodio.addItem(lista.get(i));
        }

        lista = query.buscarCustodiosID();
        view.cbxCustodioID.addItem("Todos");
        for (int i = 0; i < lista.size(); i++) {
            view.cbxCustodioID.addItem(lista.get(i));
        }

    }

    public void cargarCuentaContable() {
        lista = query.buscarCuentasContables();
        view.cbxCuentaContable.addItem("Todos");
        for (int i = 0; i < lista.size(); i++) {
            view.cbxCuentaContable.addItem(lista.get(i));
        }

        lista = query.buscarCuentasContablesID();
        view.cbxCuentaContableID.addItem("Todos");
        for (int i = 0; i < lista.size(); i++) {
            view.cbxCuentaContableID.addItem(lista.get(i));
        }

    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.cbxCuentaContable) {
            view.cbxCuentaContableID.setSelectedIndex(view.cbxCuentaContable.getSelectedIndex());
        }
        if (e.getSource() == view.cbxCustodio) {
            view.cbxCustodioID.setSelectedIndex(view.cbxCustodio.getSelectedIndex());
        }
        if (e.getSource() == view.btnBuscarPorTexto) {
            String textoBuscar = view.txtBuscar.getText();
            tabla.cargandoRegistrosMuebles(this.view.jTableMuebles, textoBuscar, "NoAplica", "NoAplica");
            this.view.txtTotalRegistros.setText("Se encontraron " + tabla.getTotalRegistros() + " de " + query.totalRegistros() + " registros.");
        }
        if (e.getSource() == view.btnBuscarPorParametro) {
            usuID = "" + view.cbxCustodioID.getSelectedItem();
            ccID = "" + view.cbxCuentaContableID.getSelectedItem();
            tabla.cargandoRegistrosMuebles(this.view.jTableMuebles, null, ccID, usuID);
            this.view.txtTotalRegistros.setText("Se encontraron " + tabla.getTotalRegistros() + " de " + query.totalRegistros() + " registros.");
        }

    }
}
