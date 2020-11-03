package Tabla;

import Modelo.UsuarioUbicacionModel;
import Modelo.UsuarioUbicacionQuery;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TablaUsuarioUbicacion {

    public void cargandoRegistros(JTable jTable, String sql) {

        jTable.setDefaultRenderer(Object.class, new Tabla.Render());
        DefaultTableModel dt = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Nro.");
        dt.addColumn("CÓDIGO");
        dt.addColumn("UBICACIÓN");
        dt.addColumn("ELIMINAR");

        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");

        UsuarioUbicacionQuery query = new UsuarioUbicacionQuery();
        UsuarioUbicacionModel model = new UsuarioUbicacionModel();
        ArrayList<UsuarioUbicacionModel> list = null;

        list = query.listarRegistros(sql);

        if (list.size() >= 0) {

            for (int i = 0; i < list.size(); i++) {

                Object fila[] = new Object[4];
                model = list.get(i);
                fila[0] = model.getNroRegistros();
                fila[1] = model.getId();
                fila[2] = model.getUbicacion();
                fila[3] = btn_eliminar;
                dt.addRow(fila);
            }
            jTable.setModel(dt);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(dt);
            jTable.setRowSorter(ordenar);
            TableColumnModel columnModel = jTable.getColumnModel();
//            columnModel.getColumn(3).setPreferredWidth(300);
//            columnModel.getColumn(3).setPreferredWidth(300);

        }
    }

}
