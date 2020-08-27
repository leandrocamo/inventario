package ZTabla;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Zmodelo.Borrar_ConsultaPnlPrincipalMuebles;
import Zmodelo.Borrar_PnlPrincipal;

public class TablaPnlPrincipal {

    Borrar_ConsultaPnlPrincipalMuebles cpp = null;

    public void visualizarMuebles(JTable jtableMuebles) {

        jtableMuebles.setDefaultRenderer(Object.class, new ZTabla.Render());
        DefaultTableModel dt = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Nro.");
        dt.addColumn("CÓDIGO");
        dt.addColumn("DESCRIPCIÓN");
        dt.addColumn("CÓDIGO ETIQUETA");
        dt.addColumn("SERIE");
        dt.addColumn("MARCA");
        dt.addColumn("ACCIÓN");
        dt.addColumn("Eliminar");

        JButton btn_modificar = new JButton("Editar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");

        cpp = new Borrar_ConsultaPnlPrincipalMuebles();
        Borrar_PnlPrincipal vo = new Borrar_PnlPrincipal();
        ArrayList<Borrar_PnlPrincipal> list = cpp.ListarMuebles();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[8];
                vo = list.get(i);
                fila[0] = vo.getNro();
                fila[1] = vo.getMueId();
                fila[2] = vo.getMueDescripcion();
                fila[3] = vo.getMueCodigoEtiqueta();
                fila[4] = vo.getMueSerie();
                fila[5] = vo.getMarNombre();
                fila[6] = btn_modificar;
                fila[7] = btn_eliminar;
                dt.addRow(fila);
            }
            jtableMuebles.setModel(dt);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(dt);
            jtableMuebles.setRowSorter(ordenar);
            TableColumnModel columnModel = jtableMuebles.getColumnModel();
            columnModel.getColumn(2).setPreferredWidth(300);
            columnModel.getColumn(3).setPreferredWidth(300);
        }
    }

    public void visualizarMueblesBuscar(JTable jtableMuebles, String textoBuscar) {

        jtableMuebles.setDefaultRenderer(Object.class, new ZTabla.Render());
        DefaultTableModel dt = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Nro.");
        dt.addColumn("CÓDIGO");
        dt.addColumn("DESCRIPCIÓN");
        dt.addColumn("CÓDIGO ETIQUETA");
        dt.addColumn("SERIE");
        dt.addColumn("MARCA");
        dt.addColumn("ACCIÓN");
        dt.addColumn("Eliminar");

        JButton btn_modificar = new JButton("Editar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");

        cpp = new Borrar_ConsultaPnlPrincipalMuebles();
        Borrar_PnlPrincipal vo = new Borrar_PnlPrincipal();
        ArrayList<Borrar_PnlPrincipal> list = cpp.BuscarMueble(textoBuscar);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[8];
                vo = list.get(i);
                fila[0] = vo.getNro();
                fila[1] = vo.getMueId();
                fila[2] = vo.getMueDescripcion();
                fila[3] = vo.getMueCodigoEtiqueta();
                fila[4] = vo.getMueSerie();
                fila[5] = vo.getMarNombre();
                fila[6] = btn_modificar;
                fila[7] = btn_eliminar;
                dt.addRow(fila);
            }
            jtableMuebles.setModel(dt);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(dt);
            jtableMuebles.setRowSorter(ordenar);
            TableColumnModel columnModel = jtableMuebles.getColumnModel();
            columnModel.getColumn(2).setPreferredWidth(300);
            columnModel.getColumn(3).setPreferredWidth(300);
        }
    }
}
