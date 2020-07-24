package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
//import sun.swing.table.DefaultTableCellHeaderRenderer;
import vista.Principal;

public class PrincipalController implements ActionListener {

    private PrincipalModel modeloP = new PrincipalModel();
    private PrincipalConsultaModel modeloPC = new PrincipalConsultaModel();//modeloCRUD
    private Principal vistaPrincipal;

    public PrincipalController(Principal frmInicio) {
        this.vistaPrincipal = frmInicio;
//        this.vistaPrincipal.btnBuscar.addActionListener(this);
    }

  

    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == vistaPrincipal.btnBuscar) {
//            
//        }
    }

}
