package Tabla;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.ConsultaPnlUsuarioDetalle;
import modelo.PnlUsuarioDetalle;

public class TablaPnlUsuarioDetalle {

    ConsultaPnlUsuarioDetalle cpud = null;

    public void cargandoRegistrosUsuario(JTable jTable, String textoBuscar) {

        jTable.setDefaultRenderer(Object.class, new Tabla.Render());
        DefaultTableModel dt = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Nro.");
        dt.addColumn("USUARIO");
        dt.addColumn("CORREO ELECTRÓNICO");
        dt.addColumn("ROLE");
        dt.addColumn("ÁREA DEPENCIA");
        dt.addColumn("ACCIÓN");
        dt.addColumn("ACCIÓN");

        JButton btn_modificar = new JButton("Editar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");

        cpud = new ConsultaPnlUsuarioDetalle();
        PnlUsuarioDetalle pud = new PnlUsuarioDetalle();
        ArrayList<PnlUsuarioDetalle> list = null;

        if (textoBuscar == null) {
            list = cpud.ListarBuscarUsuario(null);
        } else {
            list = cpud.ListarBuscarUsuario(textoBuscar);
        }

        if (list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {

                Object fila[] = new Object[7];
                pud = list.get(i);
                fila[0] = pud.getNro();
                fila[1] = pud.getUsuUsuario();
                fila[2] = pud.getUsuCorreoElectronico();
                fila[3] = pud.getRole();
                fila[4] = pud.getAdNombre();
                fila[5] = btn_modificar;
                fila[6] = btn_eliminar;
//                System.out.println("RENDERIZAR TABLA "+pud.getNro()+".- " + pud.getUsuUsuario());
                dt.addRow(fila);
                System.out.print("Modelo: >" + dt.getValueAt(i, 0));
                System.out.println(" - " + dt.getValueAt(i, 1));
            }
            jTable.setModel(dt);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(dt);
            jTable.setRowSorter(ordenar);
            TableColumnModel columnModel = jTable.getColumnModel();
            columnModel.getColumn(2).setPreferredWidth(300);
//            columnModel.getColumn(3).setPreferredWidth(300);
//            System.out.print("Tabla: >" + jTable.getValueAt(3, 0));
            for (int i = 0; i < jTable.getRowCount(); i++) {
                System.out.print("Tabla: >" + jTable.getValueAt(i, 0));
                System.out.println(" - " + jTable.getValueAt(i, 1));
            }

        }
    }

}
