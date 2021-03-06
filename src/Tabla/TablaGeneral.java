package Tabla;

import Modelo.GeneralModel;
import Modelo.GeneralQuery;
import Modelo.MarcaModel;
import Modelo.MarcaQuery;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TablaGeneral {

    private int totalRegistros;

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public void cargandoRegistros(JTable jTable, String sql) {

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
        dt.addColumn("ACCIÓN");
        dt.addColumn("ACCIÓN");

        JButton btn_modificar = new JButton("Editar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");

        GeneralQuery query = new GeneralQuery();
        GeneralModel model = new GeneralModel();
        ArrayList<GeneralModel> list = null;

//        if (SentenciaSQL == null) {
//            list = query.listarMarcas(null);
//        } else {
        list = query.listarGeneral(sql);
//        }

        if (list.size() == 0) {
            setTotalRegistros(0);
            JOptionPane.showMessageDialog(null, "No se encontró registros.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        if (list.size() >= 0) {

            for (int i = 0; i < list.size(); i++) {

                Object fila[] = new Object[6];
                model = list.get(i);
                fila[0] = model.getNroRegistros();
                fila[1] = model.getId();
                fila[2] = model.getNombre();
                fila[3] = model.getDescripcion();
                fila[4] = btn_modificar;
                fila[5] = btn_eliminar;
                setTotalRegistros(model.getNroRegistros());
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
