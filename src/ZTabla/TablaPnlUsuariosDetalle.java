package ZTabla;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Zmodelo.ConsultaPnlUsuariosDetalle;
import Zmodelo.PnlUsuariosDetalle;

public class TablaPnlUsuariosDetalle {

    ConsultaPnlUsuariosDetalle cpud = null;

    public void cargandoRegistrosUsuario(JTable jTable, String textoBuscar) {

        jTable.setDefaultRenderer(Object.class, new ZTabla.Render());
        DefaultTableModel dt = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Nro.");
        dt.addColumn("CÓDIGO");
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

        cpud = new ConsultaPnlUsuariosDetalle();
        PnlUsuariosDetalle pud = new PnlUsuariosDetalle();
        ArrayList<PnlUsuariosDetalle> list = null;

        if (textoBuscar == null) {
            list = cpud.ListarBuscarUsuario(null);
        } else {
            list = cpud.ListarBuscarUsuario(textoBuscar);
        }

        if (list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {

                Object fila[] = new Object[8];
                pud = list.get(i);
                fila[0] = pud.getNro();
                fila[1] = pud.getUsuId();
                fila[2] = pud.getUsuUsuario();
                fila[3] = pud.getUsuCorreoElectronico();
                fila[4] = pud.getRole();
                fila[5] = pud.getAdNombre();
                fila[6] = btn_modificar;
                fila[7] = btn_eliminar;
                dt.addRow(fila);
            }
            jTable.setModel(dt);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(dt);
            jTable.setRowSorter(ordenar);
            TableColumnModel columnModel = jTable.getColumnModel();
            columnModel.getColumn(3).setPreferredWidth(300);
//            columnModel.getColumn(3).setPreferredWidth(300);

        }
    }

}
