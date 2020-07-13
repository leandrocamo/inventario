/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import vista.nuevomueble;

/**
 *
 * @author camo
 */
public class NuevoMueble extends Conexion {
    private nuevomueble vistaNuevoMueble;

    public void color() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * \n"
                + "FROM color \n"
                + "WHERE COLESTADO = 1 \n"
                + "ORDER BY COLNOMBRE ASC";
//        System.out.println("->" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
//                Guardar registros en el comboBox
                vistaNuevoMueble.cbxColor.addItem("" + rs.getObject("COLNOMBRE"));
                vistaNuevoMueble.cbxIdColor.addItem("" + rs.getObject("COLID"));

//                vistaNuevoMueble.cbxColor.addItem(
//                        new color(Integer.parseInt("" + rs.getObject("COLID")),
//                                "" + rs.getObject("COLNOMBRE")
//                        )
//                );
            }
//            this.contadorColor++;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
//        try {
//            Statement stm;
//            stm = (Statement) conexion.conn.createStatement();
//            ResultSet rs = stm.executeQuery(sql);
//            while (rs.next()) {
//                Guardar registros en el comboBox
//                cbxColor.addItem("" + rs.getObject("COLNOMBRE"));
//                cbxIdColor.addItem("" + rs.getObject("COLID"));
//
//                cbxColor.addItem(
//                        new color(Integer.parseInt("" + rs.getObject("COLID")),
//                                "" + rs.getObject("COLNOMBRE")
//                        )
//                );
//            }
//            this.contadorColor++;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "No se obtuvo los registros de color.\n" + ex, "Error", JOptionPane.WARNING_MESSAGE);
//        }
//    }

}
