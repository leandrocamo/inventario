package Tabla;

import Modelo.UsuarioModel;
import Modelo.UsuarioQuery;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TablaUsuario {

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
        dt.addColumn("NOMBRES");
        dt.addColumn("APELLIDOS");
        dt.addColumn("CORREO ELECTRÓNICO");
        dt.addColumn("ROLL");
        dt.addColumn("EDITAR");
        dt.addColumn("ELIMINAR");
        dt.addColumn("UBICAR");
        dt.addColumn("RESETEAR");
        
        

        JButton btn_modificar = new JButton("Editar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");
        
        JButton btn_ubicar = new JButton("Ubicación");
        btn_ubicar.setName("u");
        
        JButton btn_resetear = new JButton("Resetear");
        btn_resetear.setName("r");

        UsuarioQuery query = new UsuarioQuery();
        UsuarioModel model = new UsuarioModel();
        ArrayList<UsuarioModel> list = null;

//        if (SentenciaSQL == null) {
//            list = query.listarMarcas(null);
//        } else {
        list = query.listarUsuario(sql);
//        }

        if (list.size() == 0) {
            setTotalRegistros(0);
            JOptionPane.showMessageDialog(null, "No se encontró registros.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        if (list.size() >= 0) {

            for (int i = 0; i < list.size(); i++) {

                Object fila[] = new Object[10];
                model = list.get(i);
                fila[0] = model.getNroRegistros();
                fila[1] = model.getId();
                fila[2] = model.getNombres();
                fila[3] = model.getApellidos();
                fila[4] = model.getCorreoElectronico();
                fila[5] = model.getRol();
                fila[6] = btn_modificar;
                fila[7] = btn_eliminar;
                fila[8] = btn_ubicar;
                fila[9] = btn_resetear;
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
