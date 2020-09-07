package A_Tabla;

import A_Modelo.MueblesModel;
import A_Modelo.MueblesPrincipalModel;
import A_Modelo.MueblesPrincipalQuery;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TablaMuebles {

    private int totalRegistros;
    
    public int getTotalRegistros() {
        return totalRegistros;
    }
    
    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
    
    public void cargandoRegistrosMuebles(JTable jTable, String textoBuscar, String ccID, String usuID) {
        
        jTable.setDefaultRenderer(Object.class, new A_Tabla.Render());
        DefaultTableModel dt = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Nro.");
        dt.addColumn("CÓDIGO");
        dt.addColumn("CÓDIGO ETIQUETA");
        dt.addColumn("DESCRIPCIÓN");
        dt.addColumn("SERIE");
        dt.addColumn("CUENTA CONTABLE");
        dt.addColumn("CUSTODIO");
        dt.addColumn("ACCIÓN");
        dt.addColumn("ACCIÓN");
        
        JButton btn_modificar = new JButton("Editar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");

//        cpud = new ConsultaPnlUsuariosDetalle();
//        PnlUsuariosDetalle pud = new PnlUsuariosDetalle();
        MueblesPrincipalQuery query = new MueblesPrincipalQuery();
        MueblesPrincipalModel model = new MueblesPrincipalModel();
        ArrayList<MueblesPrincipalModel> list = null;
        
        if (textoBuscar == null) {
            list = query.listarBuscarMueble(null, ccID, usuID);
        } else {
            list = query.listarBuscarMueble(textoBuscar, ccID, usuID);
        }
        if (list.size() == 0) {
            setTotalRegistros(0);
            JOptionPane.showMessageDialog(null, "No se encontró registros.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        if (list.size() >= 0) {
            
            for (int i = 0; i < list.size(); i++) {
                
                Object fila[] = new Object[9];
                model = list.get(i);
                fila[0] = model.getNro();
                fila[1] = model.getMueID();
                fila[2] = model.getMueCodigoEtiqueta();
                fila[3] = model.getMueDescripcion();
                fila[4] = model.getMueSerie();
                fila[5] = model.getCcNombre();
                fila[6] = model.getUsuApellido() + " " + model.getUsuNombre();
                fila[7] = btn_modificar;
                fila[8] = btn_eliminar;
                setTotalRegistros(model.getNro());
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
