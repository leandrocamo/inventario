package Tabla;

import Modelo.CuentaContableModel;
import Modelo.CuentaContableQuery;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TablaCuentaContable {
    private int totalRegistros;

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }


    public void cargandoRegistros(JTable jTable) {

        jTable.setDefaultRenderer(Object.class, new Tabla.Render());
        DefaultTableModel dt = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Nro.");
        dt.addColumn("CÓDIGO");
        dt.addColumn("NOMBRE");
        dt.addColumn("DESCRIPCIÓN");
        dt.addColumn("CUENTA CONTABLE");
        dt.addColumn("EDICIÓN");
        dt.addColumn("ELIMINACIÓN");

        JButton btn_modificar = new JButton("Editar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");

        CuentaContableQuery query = new CuentaContableQuery();
        CuentaContableModel model = new CuentaContableModel();
        ArrayList<CuentaContableModel> list = null;
        list = query.listarRegistros();

        if (list.size() == 0) {
            setTotalRegistros(0);
            JOptionPane.showMessageDialog(null, "No se encontró registros.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        if (list.size() >= 0) {

            for (int i = 0; i < list.size(); i++) {

                Object fila[] = new Object[7];
                model = list.get(i);
                fila[0] = model.getNroRegistros();
                fila[1] = model.getId();
                fila[2] = model.getNombre();
                fila[3] = model.getDescripcion();
                fila[4] = model.getIdcuentacontable();
                fila[5] = btn_modificar;
                fila[6] = btn_eliminar;
                setTotalRegistros(model.getNroRegistros());
                dt.addRow(fila);
            }
            jTable.setModel(dt);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(dt);
            jTable.setRowSorter(ordenar);
//            TableColumnModel columnModel = jTable.getColumnModel();
        }
    }

}
